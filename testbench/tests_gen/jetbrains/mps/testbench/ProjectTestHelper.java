package jetbrains.mps.testbench;

/*Generated by MPS */

import jetbrains.mps.project.MPSProject;
import java.util.List;
import com.intellij.util.PathUtil;
import java.io.File;
import com.intellij.openapi.application.PathMacros;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.Level;
import jetbrains.mps.ide.IdeMain;
import jetbrains.mps.TestMain;
import jetbrains.mps.ide.generator.GenerationSettings;
import jetbrains.mps.make.script.ScriptBuilder;
import jetbrains.mps.make.facet.IFacet;
import jetbrains.mps.make.facet.ITarget;
import jetbrains.mps.make.resources.IResource;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.project.IModule;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.smodel.resources.ModelsToResources;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.generator.GeneratorManager;
import java.util.Map;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.HashMap;
import java.io.IOException;
import jetbrains.mps.generator.GenerationOptions;
import jetbrains.mps.make.script.IScriptController;
import jetbrains.mps.make.script.IParametersPool;
import jetbrains.mps.baseLanguage.tuples.runtime.Tuples;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import jetbrains.mps.vfs.IFile;
import jetbrains.mps.make.script.IResult;
import jetbrains.mps.ide.ThreadUtils;
import jetbrains.mps.project.ProjectOperationContext;
import jetbrains.mps.make.script.IScript;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.IMapping;
import jetbrains.mps.vfs.FileSystem;
import jetbrains.mps.internal.collections.runtime.IVisitor;
import difflib.Patch;
import difflib.DiffUtils;
import difflib.Delta;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Queue;
import jetbrains.mps.internal.collections.runtime.QueueSequence;
import jetbrains.mps.internal.collections.runtime.backports.LinkedList;
import jetbrains.mps.messages.IMessageHandler;
import jetbrains.mps.messages.IMessage;
import java.io.StringWriter;
import java.io.PrintWriter;

public class ProjectTestHelper {
  public ProjectTestHelper() {
    init();
  }

  public ProjectTestHelper.Token getToken(MPSProject prj) {
    return new ProjectTestHelper.PrivToken(prj);
  }

  public boolean build(ProjectTestHelper.Token tok) {
    return ((ProjectTestHelper.PrivToken) tok).build();
  }

  public void cleanUp(ProjectTestHelper.Token tok) {
    ((ProjectTestHelper.PrivToken) tok).cleanUp();
  }

  public void test(ProjectTestHelper.Token tok) {
  }

  public List<String> buildErrors(ProjectTestHelper.Token tok) {
    return ((ProjectTestHelper.PrivToken) tok).buildErrors();
  }

  public List<String> buildWarns(ProjectTestHelper.Token tok) {
    return ((ProjectTestHelper.PrivToken) tok).buildWarns();
  }

  public List<String> getDiffReport(ProjectTestHelper.Token tok) {
    return ((ProjectTestHelper.PrivToken) tok).diff();
  }

  public void setMacro(String macroName, String path) {
    String canonicalPath = PathUtil.getCanonicalPath(path);
    File file = new File(canonicalPath);
    if (file.exists() && file.isDirectory()) {
      PathMacros.getInstance().setMacro(macroName, canonicalPath);
    }
  }

  private void init() {
    BasicConfigurator.configure();
    Logger.getRootLogger().setLevel(Level.INFO);
    Testbench.initLogging();
    IdeMain.setTestMode(IdeMain.TestMode.CORE_TEST);
    TestMain.configureMPS();
    Testbench.initLibs();
    Testbench.makeAll();
    Testbench.reloadAll();
    boolean isParallel = System.getProperty("parallel.generation") != null && Boolean.parseBoolean(System.getProperty("parallel.generation"));
    GenerationSettings.getInstance().setParallelGenerator(isParallel);
    GenerationSettings.getInstance().setStrictMode(isParallel);
    if (isParallel) {
      GenerationSettings.getInstance().setNumberOfParallelThreads(8);
    }
  }

  private ScriptBuilder defaultScriptBuilder() {
    return new ScriptBuilder().withFacets(new IFacet.Name("Binaries"), new IFacet.Name("Generate"), new IFacet.Name("TextGen"), new IFacet.Name("JavaCompile"), new IFacet.Name("Make")).withFinalTarget(new ITarget.Name("make"));
  }

  private Iterable<IResource> collectResources(IOperationContext context, final MPSProject pro) {
    final Wrappers._T<Iterable<SModelDescriptor>> models = new Wrappers._T<Iterable<SModelDescriptor>>(null);
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        for (IModule mod : pro.getModules()) {
          models.value = Sequence.fromIterable(models.value).concat(ListSequence.fromList(mod.getEditableUserModels()));
        }
      }
    });
    return new ModelsToResources(context, Sequence.fromIterable(models.value).where(new IWhereFilter<SModelDescriptor>() {
      public boolean accept(SModelDescriptor smd) {
        return !(GeneratorManager.isDoNotGenerate(smd));
      }
    })).resources(false);
  }

  public static abstract class Token {
    public Token() {
    }
  }

  private class PrivToken extends ProjectTestHelper.Token {
    private final MPSProject project;
    private String tmpPath;
    private Map<String, String> path2tmp = MapSequence.fromMap(new HashMap<String, String>());
    private final ProjectTestHelper.MyMessageHandler myMessageHandler = new ProjectTestHelper.MyMessageHandler();

    public PrivToken(MPSProject project) {
      this.project = project;
      File tmpDir;
      try {
        tmpDir = File.createTempFile("projecttest", "tmp");
        tmpDir.delete();
        tmpDir.mkdir();
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
      this.tmpPath = tmpDir.getAbsolutePath();
    }

    public boolean build() {
      final GenerationOptions.OptionsBuilder optBuilder = GenerationOptions.fromSettings(GenerationSettings.getInstance());
      boolean isParallel = "true".equalsIgnoreCase(System.getProperty("parallel.generation"));
      if (isParallel) {
        optBuilder.strictMode(true).generateInParallel(isParallel, 8);
      }

      final IScriptController ctl = new IScriptController.Stub() {
        @Override
        public void setup(IParametersPool ppool) {
          Tuples._1<_FunctionTypes._return_P1_E0<? extends IFile, ? super String>> bparams = (Tuples._1<_FunctionTypes._return_P1_E0<? extends IFile, ? super String>>) ppool.parameters(new ITarget.Name("copyBinaries"), Object.class);
          bparams._0(new _FunctionTypes._return_P1_E0<IFile, String>() {
            public IFile invoke(String path) {
              return tmpFile(path);
            }
          });

          Tuples._1<_FunctionTypes._return_P1_E0<? extends IFile, ? super String>> tparams = (Tuples._1<_FunctionTypes._return_P1_E0<? extends IFile, ? super String>>) ppool.parameters(new ITarget.Name("textGen"), Object.class);
          tparams._0(new _FunctionTypes._return_P1_E0<IFile, String>() {
            public IFile invoke(String path) {
              return tmpFile(path);
            }
          });

          Tuples._2<Boolean, GenerationOptions.OptionsBuilder> params = (Tuples._2<Boolean, GenerationOptions.OptionsBuilder>) ppool.parameters(new ITarget.Name("configure"), Object.class);
          params._1(optBuilder);

          Tuples._1<Boolean> cparams = (Tuples._1<Boolean>) ppool.parameters(new ITarget.Name("auxCompile"), Object.class);
          cparams._0(true);
        }
      };


      final Wrappers._T<IResult> result = new Wrappers._T<IResult>();
      ModelAccess.instance().flushEventQueue();
      ThreadUtils.runInUIThreadAndWait(new Runnable() {
        public void run() {
          ProjectOperationContext context = ProjectOperationContext.get(project.getProject());
          IScript scr = defaultScriptBuilder().toScript();
          result.value = new TestMakeService(context, myMessageHandler).make(collectResources(context, project), scr, ctl);
        }
      });
      ModelAccess.instance().flushEventQueue();
      return result.value.isSucessful();
    }

    public List<String> buildErrors() {
      return myMessageHandler.getGenerationErrors();
    }

    public List<String> buildWarns() {
      return myMessageHandler.getGenerationWarnings();
    }

    public List<String> diff() {
      List<String> diffs = ListSequence.fromList(new ArrayList<String>());
      for (IMapping<String, String> p2t : MapSequence.fromMap(path2tmp).mappingsSet()) {
        File orig = new File(p2t.key());
        File revd = new File(p2t.value());
        if (orig.exists() && revd.exists() && orig.isDirectory() && revd.isDirectory()) {
          diffDirs(orig, revd, diffs);
        } else if (!(orig.exists()) && !(revd.exists())) {
          ListSequence.fromList(diffs).addElement("None exists: " + orig + " or " + revd);
        } else if (!(orig.exists())) {
          ListSequence.fromList(diffs).addElement("Created: " + revd);
        } else if (!(orig.exists())) {
          ListSequence.fromList(diffs).addElement("Removed: " + orig);
        } else {
          ListSequence.fromList(diffs).addElement("Something weird here: " + orig + " or here " + revd);
        }
      }
      return diffs;
    }

    private IFile tmpFile(String path) {
      if (MapSequence.fromMap(path2tmp).containsKey(path)) {
        return FileSystem.getInstance().getFileByPath(MapSequence.fromMap(path2tmp).get(path));
      }
      int idx = path.indexOf("/");
      String tmp = tmpPath + "/" + (idx < 0 ?
        path :
        path.substring(idx + 1)
      );
      MapSequence.fromMap(path2tmp).put(path, tmp);
      return FileSystem.getInstance().getFileByPath(tmp);
    }

    private void diffDirs(final File orig, File revd, final List<String> diffs) {
      Iterable<String> onames = Sequence.fromArray(orig.list());
      Iterable<String> rnames = Sequence.fromArray(revd.list());
      if (Sequence.fromIterable(onames).disjunction(Sequence.fromIterable(rnames)).isNotEmpty()) {
        Sequence.fromIterable(onames).subtract(Sequence.fromIterable(rnames)).visitAll(new IVisitor<String>() {
          public void visit(String it) {
            ListSequence.fromList(diffs).addElement("Removed: " + new File(orig, it));
          }
        });
        Sequence.fromIterable(rnames).subtract(Sequence.fromIterable(onames)).visitAll(new IVisitor<String>() {
          public void visit(String it) {
            ListSequence.fromList(diffs).addElement("Created: " + new File(orig, it));
          }
        });
      }
      for (String name : Sequence.fromIterable(onames).intersect(Sequence.fromIterable(rnames))) {
        if ("trace.info".equals(name)) {
          continue;
        }

        File onext = new File(orig, name);
        File rnext = new File(revd, name);
        if (onext.isDirectory() == rnext.isDirectory()) {
          if (!(onext.isDirectory())) {
            List<String> olines = fileToStrings(onext);
            Patch patch = DiffUtils.diff(olines, fileToStrings(rnext));
            for (Delta d : patch.getDeltas()) {
              ListSequence.fromList(diffs).addSequence(ListSequence.fromList(DiffUtils.generateUnifiedDiff(onext.getPath(), rnext.getPath(), olines, patch, 5)));
            }
          } else {
            diffDirs(onext, rnext, diffs);
          }
        } else {
          ListSequence.fromList(diffs).addElement("Something weird here: " + onext + " or here " + rnext);
        }
      }
    }

    private List<String> fileToStrings(File f) {
      List<String> result = ListSequence.fromList(new ArrayList<String>());
      BufferedReader in = null;
      try {
        in = new BufferedReader(new FileReader(f));
        String line;
        while ((line = in.readLine()) != null) {
          ListSequence.fromList(result).addElement(line);
        }
      } catch (IOException e) {
        e.printStackTrace();
      } finally {
        if (in != null) {
          try {
            in.close();
          } catch (IOException ignore) {
          }
        }
      }
      return result;
    }

    private void cleanUp() {
      for (Queue<File> dirs = QueueSequence.fromQueueAndArray(new LinkedList<File>(), new File(tmpPath)); QueueSequence.fromQueue(dirs).isNotEmpty();) {
        File dir = QueueSequence.fromQueue(dirs).removeFirstElement();
        dir.deleteOnExit();
        for (File f : dir.listFiles()) {
          if (f.isDirectory()) {
            QueueSequence.fromQueue(dirs).addLastElement(f);
          } else {
            f.deleteOnExit();
          }
        }
      }
      this.tmpPath = null;
      MapSequence.fromMap(path2tmp).clear();
      myMessageHandler.cleanUp();
    }
  }

  private static class MyMessageHandler implements IMessageHandler {
    private final List<String> myGenerationErrors = new ArrayList<String>();
    private final List<String> myGenerationWarnings = new ArrayList<String>();

    private MyMessageHandler() {
    }

    public void handle(IMessage msg) {
      switch (msg.getKind()) {
        case ERROR:
          if (msg.getException() != null) {
            StringWriter writer = new StringWriter();
            msg.getException().printStackTrace(new PrintWriter(writer));
            myGenerationErrors.add(writer.getBuffer().toString());
          } else {
            myGenerationErrors.add(msg.getText());
          }
          break;
        case WARNING:
          myGenerationWarnings.add(msg.getText());
          break;
        case INFORMATION:
          break;
        default:
      }
    }

    public List<String> getGenerationErrors() {
      return myGenerationErrors;
    }

    public List<String> getGenerationWarnings() {
      return myGenerationWarnings;
    }

    public void cleanUp() {
      myGenerationErrors.clear();
      myGenerationWarnings.clear();
    }

    public void clear() {
    }
  }
}
