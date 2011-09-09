package jetbrains.mps.build.ant.generation.workers;

/*Generated by MPS */

import jetbrains.mps.build.ant.MpsWorker;
import jetbrains.mps.build.ant.IBuildServerMessageFormat;
import java.util.Map;
import jetbrains.mps.smodel.SModelDescriptor;
import java.util.HashMap;
import jetbrains.mps.generator.generationTypes.DiffGenerationHandler;
import jetbrains.mps.compiler.JavaCompiler;
import jetbrains.mps.ide.progress.ITaskProgressHelper;
import jetbrains.mps.build.ant.WhatToDo;
import org.apache.tools.ant.ProjectComponent;
import jetbrains.mps.project.MPSProject;
import jetbrains.mps.build.ant.generation.GenerateTask;
import jetbrains.mps.ide.generator.GenerationSettings;
import jetbrains.mps.project.IModule;
import jetbrains.mps.generator.GeneratorManager;
import jetbrains.mps.generator.GenerationListener;
import java.util.List;
import java.io.File;
import jetbrains.mps.project.MPSExtentions;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.io.StringWriter;
import java.util.Formatter;
import java.util.ArrayList;
import java.util.Comparator;
import jetbrains.mps.build.ant.generation.PerfomanceReport;
import jetbrains.mps.util.FileUtil;
import java.util.Set;
import jetbrains.mps.library.Library;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.make.MPSCompilationResult;
import jetbrains.mps.build.ant.TeamCityMessageFormat;
import jetbrains.mps.build.ant.generation.ConsoleMessageFormat;
import jetbrains.mps.generator.GenerationAdapter;
import jetbrains.mps.generator.GenerationOptions;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.build.ant.generation.TestGenerationOnTeamcity;
import jetbrains.mps.smodel.ModelAccess;
import com.intellij.openapi.util.Computable;
import jetbrains.mps.smodel.SModel;
import org.eclipse.jdt.internal.compiler.CompilationResult;
import jetbrains.mps.compiler.CompilationResultAdapter;
import org.apache.tools.ant.util.JavaEnvUtils;
import com.intellij.openapi.application.PathManager;
import jetbrains.mps.build.ant.generation.unittest.UnitTestRunner;
import jetbrains.mps.build.ant.generation.unittest.UnitTestOutputReader;
import java.io.IOException;
import java.net.URL;
import java.net.MalformedURLException;
import java.net.URLClassLoader;
import jetbrains.mps.util.Condition;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.util.ConditionalIterable;
import java.lang.reflect.Modifier;
import junit.framework.TestCase;
import java.util.LinkedHashMap;
import jetbrains.mps.project.structure.project.testconfigurations.BaseTestConfiguration;
import jetbrains.mps.generator.GenParameters;
import jetbrains.mps.project.structure.project.testconfigurations.IllegalGeneratorConfigurationException;
import org.eclipse.jdt.core.compiler.CategorizedProblem;
import org.apache.tools.ant.BuildException;
import jetbrains.mps.generator.generationTypes.IGenerationHandler;
import jetbrains.mps.messages.IMessageHandler;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.messages.IMessage;
import jetbrains.mps.project.ProjectOperationContext;
import com.intellij.openapi.progress.EmptyProgressIndicator;
import jetbrains.mps.generator.IncrementalGenerationStrategy;
import jetbrains.mps.generator.GenerationCacheContainer;
import jetbrains.mps.generator.impl.dependencies.GenerationDependencies;
import jetbrains.mps.reloading.IClassPathItem;
import jetbrains.mps.reloading.EachClassPathItemVisitor;
import jetbrains.mps.reloading.FileClassPathItem;
import jetbrains.mps.reloading.JarFileClassPathItem;
import jetbrains.mps.project.AbstractModule;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.smodel.LanguageAspect;
import jetbrains.mps.smodel.Generator;
import jetbrains.mps.project.DevKit;
import jetbrains.mps.util.AbstractClassLoader;
import jetbrains.mps.build.ant.generation.unittest.UnitTestAdapter;

public class TestGenerationWorker extends MpsWorker {
  private final TestGenerationWorker.MyMessageHandler myMessageHandler = new TestGenerationWorker.MyMessageHandler();
  private boolean myTestFailed = false;
  private IBuildServerMessageFormat myBuildServerMessageFormat;
  private final Map<SModelDescriptor, Long> myPerfomanceMap = new HashMap<SModelDescriptor, Long>();
  private final DiffGenerationHandler myGenerationHandler = new DiffGenerationHandler(false, true) {
    protected JavaCompiler createJavaCompiler() {
      return new JavaCompiler() {
        public ClassLoader getClassLoader(ClassLoader parent) {
          return new TestGenerationWorker.MyClassLoader(parent);
        }
      };
    }

    public void finishGeneration(ITaskProgressHelper progressHelper) {
    }
  };

  public TestGenerationWorker(WhatToDo whatToDo, ProjectComponent component) {
    super(whatToDo, component);
  }

  public TestGenerationWorker(WhatToDo whatToDo, MpsWorker.AntLogger logger) {
    super(whatToDo, logger);
    myBuildServerMessageFormat = getBuildServerMessageFormat();
  }

  protected void executeTask(final MPSProject project, MpsWorker.ObjectsToProcess go) {
    setGenerationProperties();
    if (go.hasAnythingToGenerate()) {
      generate(project, go);
    }
  }

  private void setGenerationProperties() {
    if (myWhatToDo.getProperty(GenerateTask.PER_ROOT_GENERATION) != null) {
      boolean perRootGeneration = Boolean.parseBoolean(myWhatToDo.getProperty(GenerateTask.PER_ROOT_GENERATION));
      GenerationSettings.getInstance().setParallelGenerator(perRootGeneration);
      GenerationSettings.getInstance().setStrictMode(perRootGeneration);
      info("Per-root generation set to " + perRootGeneration);
    }
  }

  private void generate(MPSProject project, MpsWorker.ObjectsToProcess go) {
    StringBuffer s = new StringBuffer("Generating:");
    for (MPSProject p : go.getProjects()) {
      s.append("\n    ");
      s.append(p);
    }
    for (IModule m : go.getModules()) {
      s.append("\n    ");
      s.append(m);
    }
    for (SModelDescriptor m : go.getModels()) {
      s.append("\n    ");
      s.append(m);
    }
    info(s.toString());
    final GeneratorManager gm = project.getProject().getComponent(GeneratorManager.class);
    final GenerationListener generationListener = getGenerationListener();
    gm.addGenerationListener(generationListener);
    List<TestGenerationWorker.Cycle> order = computeGenerationOrder(project, go);
    for (final TestGenerationWorker.Cycle cycle : order) {
      generateModulesCycle(gm, cycle);
    }
    gm.removeGenerationListener(generationListener);
  }

  public void work() {
    setupEnvironment();
    Map<File, List<String>> mpsProjects = myWhatToDo.getMPSProjectFiles();
    for (File file : mpsProjects.keySet()) {
      if (!(file.getName().endsWith(MPSExtentions.DOT_MPS_PROJECT))) {
        continue;
      }
      MPSProject p;
      try {
        Class<?> cls = Class.forName("jetbrains.mps.TestMain");
        Method meth = cls.getMethod("loadProject", File.class);
        p = (MPSProject) meth.invoke(null, file);
      } catch (Exception ex) {
        throw new RuntimeException(ex);
      }
      info("Loaded project " + p);
      executeTask(p, new MpsWorker.ObjectsToProcess(Collections.singleton(p), new HashSet<IModule>(), new HashSet<SModelDescriptor>()));
      disposeProject(p);
      dispose();
    }
    LinkedHashSet<IModule> modules = new LinkedHashSet<IModule>();
    LinkedHashSet<SModelDescriptor> models = new LinkedHashSet<SModelDescriptor>();
    collectFromModuleFiles(modules);
    collectFromModelFiles(models);
    MpsWorker.ObjectsToProcess go = new MpsWorker.ObjectsToProcess(Collections.EMPTY_SET, modules, models);
    if (go.hasAnythingToGenerate()) {
      MPSProject project = createDummyProject();
      executeTask(project, go);
    } else {
      // <node> 
      // <node> 
    }
    generatePerformanceReport();
    dispose();
    showStatistic();
  }

  private void generatePerformanceReport() {
    String[] destinations = getPerfomanceReportDestinations();
    if (destinations.length > 0) {
      StringWriter w = new StringWriter();
      Formatter f = new Formatter(w);
      f.format("Generation Time Report:\n");
      ArrayList<SModelDescriptor> models = new ArrayList<SModelDescriptor>();
      models.addAll(myPerfomanceMap.keySet());
      Collections.sort(models, new Comparator<SModelDescriptor>() {
        @Override
        public int compare(SModelDescriptor o1, SModelDescriptor o2) {
          return -myPerfomanceMap.get(o1).compareTo(myPerfomanceMap.get(o2));
        }
      });
      for (SModelDescriptor modelDescriptor : models) {
        f.format("%s %dms\n", modelDescriptor.getLongName(), myPerfomanceMap.get(modelDescriptor));
      }
      String report = w.toString();
      for (String dest : destinations) {
        if (dest.equals(PerfomanceReport.STDOUT)) {
          info(myBuildServerMessageFormat.escapeBuildMessage(report));
        } else {
          FileUtil.write(new File(dest), report);
        }
      }
    }
  }

  @Override
  protected void startMake(Set<Library> compiledLibraries, Set<IModule> toCompile) {
    System.out.println(myBuildServerMessageFormat.formatTestStart(myBuildServerMessageFormat.escapeBuildMessage("make " + compiledLibraries)));
    super.startMake(compiledLibraries, toCompile);
  }

  @Override
  protected void finishMake(Set<Library> compiledLibraries, @NotNull MPSCompilationResult result) {
    String testName = myBuildServerMessageFormat.escapeBuildMessage("make " + compiledLibraries);
    if (!(result.isOk())) {
      System.out.println(myBuildServerMessageFormat.formatTestFailure(testName, "Compilation Errors", result.toString()));
    }
    System.out.println(myBuildServerMessageFormat.formatTestFinish(testName));
  }

  public IBuildServerMessageFormat getBuildServerMessageFormat() {
    if (isRunningOnTeamCity()) {
      return new TeamCityMessageFormat();
    } else {
      return new ConsoleMessageFormat();
    }
  }

  private boolean isRunningOnTeamCity() {
    return myWhatToDo.getProperty("teamcity.version") != null;
  }

  private GenerationListener getGenerationListener() {
    if (isGeneratePerfomanceReport()) {
      return new GenerationAdapter() {
        @Override
        public void beforeGeneration(List<SModelDescriptor> inputModels, GenerationOptions options, IOperationContext operationContext) {
          Long startTime = System.currentTimeMillis();
          for (SModelDescriptor model : inputModels) {
            myPerfomanceMap.put(model, startTime);
          }
        }

        @Override
        public void afterGeneration(List<SModelDescriptor> inputModels, GenerationOptions options, IOperationContext operationContext) {
          Long finishTime = System.currentTimeMillis();
          for (SModelDescriptor model : inputModels) {
            Long startTime = myPerfomanceMap.get(model);
            myPerfomanceMap.put(model, finishTime - startTime);
          }
        }
      };
    } else {
      return new GenerationAdapter();
    }
  }

  private String[] getPerfomanceReportDestinations() {
    String reportType = myWhatToDo.getProperty(TestGenerationOnTeamcity.GENERATE_PERFORMANCE_REPORT);
    if (reportType == null || reportType.isEmpty()) {
      return new String[]{};
    }
    String[] reports = reportType.split(",+");
    return reports;
  }

  private boolean isGeneratePerfomanceReport() {
    return getPerfomanceReportDestinations().length > 0;
  }

  private void generateModulesCycle(GeneratorManager gm, TestGenerationWorker.Cycle cycle) {
    String currentTestName = myBuildServerMessageFormat.escapeBuildMessage(new StringBuffer(cycle.toString())).toString();
    System.out.println(myBuildServerMessageFormat.formatTestStart(currentTestName));
    cycle.generate(gm, myGenerationHandler, myMessageHandler);
    List<String> diffReports;
    boolean generationOk = myMessageHandler.getGenerationErrors().isEmpty();
    if (generationOk && Boolean.parseBoolean(myWhatToDo.getProperty(TestGenerationOnTeamcity.SHOW_DIFF))) {
      diffReports = ModelAccess.instance().runReadAction(new Computable<List<String>>() {
        public List<String> compute() {
          return myGenerationHandler.createDiffReports(myWhatToDo.getExcludedFromDiffFiles());
        }
      });
    } else {
      diffReports = new ArrayList<String>();
    }
    final List<SModel> outputModels = new ArrayList<SModel>();
    outputModels.addAll(myGenerationHandler.getOutputModels());
    final List<CompilationResult> compilationResult = new ArrayList<CompilationResult>();
    if (generationOk && isCompileSet()) {
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          CompilationResultAdapter listener = new CompilationResultAdapter() {
            public void onCompilationResult(CompilationResult r) {
              compilationResult.add(r);
            }
          };
          myGenerationHandler.compile(ITaskProgressHelper.EMPTY, listener);
        }
      });
    }
    boolean compilatonOk = true;
    for (CompilationResult r : compilationResult) {
      if (r.hasErrors()) {
        compilatonOk = false;
        break;
      }
    }
    StringBuffer sb = createDetailedReport(compilationResult, diffReports);
    myMessageHandler.clean();
    if (sb.length() > 0) {
      myTestFailed = true;
      System.out.append(myBuildServerMessageFormat.formatTestFailure(currentTestName, "Errors During Generation Testing", sb));
      System.out.println("");
    }
    System.out.println(myBuildServerMessageFormat.formatTestFinish(currentTestName));
    if (isSaveGeneratedFilesOnDisk() && generationOk && compilatonOk && !(diffReports.isEmpty())) {
      info("Saving files generated from " + cycle.toString() + " on disk.");
      myGenerationHandler.saveGeneratedFilesOnDisk();
    }
    if (isInvokeTestsSet() && ((TestGenerationWorker.ModelCycle) cycle).isUserModel()) {
      runTests(cycle.getClassPath(), myGenerationHandler, outputModels);
    }
    myGenerationHandler.clean();
  }

  private boolean isSaveGeneratedFilesOnDisk() {
    return Boolean.parseBoolean(myWhatToDo.getProperty(TestGenerationOnTeamcity.SAVE_ON_DISK));
  }

  private void runTests(List<File> moduleClassPath, DiffGenerationHandler handler, List<SModel> outputModels) {
    List<String> testClassesNames = getTestClassesNames(handler, outputModels, createClassLoader(moduleClassPath));
    if (testClassesNames.isEmpty()) {
      return;
    }
    List<String> commandLine = new ArrayList<String>();
    commandLine.add(JavaEnvUtils.getJreExecutable("java"));
    final List<File> classPaths = new ArrayList<File>(moduleClassPath);
    classPaths.add(new File(PathManager.getResourceRoot(getClass(), "/" + getClass().getName().replace('.', '/') + ".class")).getAbsoluteFile());
    classPaths.add(new File(jetbrains.mps.util.PathManager.getHomePath() + File.separator + "lib" + File.separator + "junit4" + File.separator + "junit-4.8.2.jar"));
    StringBuffer sb = new StringBuffer();
    String pathSeparator = System.getProperty("path.separator");
    for (File cp : classPaths) {
      sb.append(pathSeparator);
      sb.append(cp.getAbsolutePath());
    }
    commandLine.add("-classpath");
    commandLine.add(sb.toString());
    commandLine.add(UnitTestRunner.class.getCanonicalName());
    for (String testClassName : testClassesNames) {
      commandLine.add("-c");
      commandLine.add(testClassName);
    }
    ProcessBuilder builder = new ProcessBuilder(commandLine);
    try {
      Process process = builder.start();
      UnitTestOutputReader reader = new UnitTestOutputReader(process, new TestGenerationWorker.MyUnitTestAdapter());
      int result = reader.start();
      if (result != 0) {
        error("Process Exited With Code " + result);
      }
    } catch (IOException e) {
      log(e);
    }
  }

  private ClassLoader createClassLoader(List<File> files) {
    List<URL> classPath = new ArrayList<URL>();
    for (File f : files) {
      try {
        classPath.add(new URL("file:///" + f.getAbsolutePath() + ((f.isDirectory() ?
          "/" :
          ""
        ))));
      } catch (MalformedURLException e) {
        log(e);
      }
    }
    return new URLClassLoader(classPath.toArray(new URL[classPath.size()]));
  }

  private List<String> getTestClassesNames(DiffGenerationHandler generationHandler, List<SModel> outputModels, ClassLoader baseClassLoader) {
    List<String> testClasses = new ArrayList<String>();
    Condition<SNode> nodeCond = new Condition<SNode>() {
      public boolean met(final SNode node) {
        final Wrappers._boolean result = new Wrappers._boolean();
        ModelAccess.instance().runReadAction(new Runnable() {
          public void run() {
            result.value = SNodeOperations.isInstanceOf(node, "jetbrains.mps.baseLanguage.structure.ClassConcept");
          }
        });
        return result.value;
      }
    };
    for (final SModel model : outputModels) {
      Iterable<SNode> iterable = new ConditionalIterable<SNode>(model.roots(), nodeCond);
      for (final SNode outputRoot : iterable) {
        if (baseClassLoader == null) {
          model.getClass().getClassLoader();
        }
        ClassLoader classLoader = generationHandler.getCompiler().getClassLoader(baseClassLoader);
        try {
          String className = ModelAccess.instance().runReadAction(new Computable<String>() {
            public String compute() {
              return model.getLongName() + "." + outputRoot.getName();
            }
          });
          final Class testClass = Class.forName(className, true, classLoader);
          if (Modifier.isAbstract(testClass.getModifiers()) || Modifier.isInterface(testClass.getModifiers())) {
            continue;
          }
          if (Modifier.isPrivate(testClass.getModifiers())) {
            continue;
          }
          if (testClass.getAnnotation(classLoader.loadClass("jetbrains.mps.baseLanguage.util.plugin.run.MPSLaunch")) != null) {
            continue;
          }
          Class<TestCase> testCaseClass = (Class<TestCase>) classLoader.loadClass(TestCase.class.getName());
          if (testCaseClass.isAssignableFrom(testClass)) {
            boolean hasTestMethods = false;
            for (Method m : testClass.getDeclaredMethods()) {
              if (m.getName().startsWith("test") && Modifier.isPublic(m.getModifiers()) && (m.getParameterTypes().length == 0) && m.getReturnType().equals(void.class)) {
                hasTestMethods = true;
                break;
              }
            }
            if (hasTestMethods) {
              testClasses.add(className);
            }
          }
        } catch (ExceptionInInitializerError ignored) {
        } catch (Throwable throwable) {
          log(throwable);
        }
      }
    }
    return testClasses;
  }

  private boolean isInvokeTestsSet() {
    return Boolean.parseBoolean(myWhatToDo.getProperty(TestGenerationOnTeamcity.INVOKE_TESTS)) && isCompileSet();
  }

  private boolean isCompileSet() {
    return Boolean.parseBoolean(myWhatToDo.getProperty(GenerateTask.COMPILE));
  }

  private List<TestGenerationWorker.Cycle> computeGenerationOrder(MPSProject project, MpsWorker.ObjectsToProcess go) {
    List<TestGenerationWorker.Cycle> cycles = new ArrayList<TestGenerationWorker.Cycle>();
    Map<IModule, List<SModelDescriptor>> moduleToModels = new LinkedHashMap<IModule, List<SModelDescriptor>>();
    extractModels(go.getProjects(), go.getModules(), go.getModels(), moduleToModels);
    for (IModule module : moduleToModels.keySet()) {
      List<SModelDescriptor> modelsForModule = moduleToModels.get(module);
      for (SModelDescriptor smodel : modelsForModule) {
        cycles.add(new TestGenerationWorker.ModelCycle(smodel, module, project));
      }
    }
    return cycles;
  }

  private void extractModels(Set<MPSProject> projects, Set<IModule> modules, Set<SModelDescriptor> models, Map<IModule, List<SModelDescriptor>> moduleToModels) {
    for (MPSProject mpsProject : projects) {
      extractModels(models, mpsProject);
    }
    for (IModule m : modules) {
      List<SModelDescriptor> modelsList = new ArrayList<SModelDescriptor>();
      moduleToModels.put(m, modelsList);
      extractModels(modelsList, m);
    }
    for (final SModelDescriptor model : models) {
      assert model != null;
      IModule owningModule = ModelAccess.instance().runReadAction(new Computable<IModule>() {
        public IModule compute() {
          return model.getModule();
        }
      });
      if (owningModule == null) {
        warning("Model " + model.getLongName() + " won't be generated because module for it can not be found.");
      } else {
        List<SModelDescriptor> modelsList = moduleToModels.get(owningModule);
        if (modelsList == null) {
          modelsList = new ArrayList<SModelDescriptor>();
          moduleToModels.put(owningModule, modelsList);
        }
        modelsList.add(model);
      }
    }
  }

  @Override
  protected void extractModels(final Set<SModelDescriptor> modelDescriptors, final MPSProject project) {
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        List<BaseTestConfiguration> testConfigurationList = project.getProjectDescriptor().getTestConfigurations();
        if (testConfigurationList.isEmpty()) {
          List<String> properties = myWhatToDo.getMPSProjectFiles().get(project.getProjectFile());
          if (properties != null && properties.contains(TestGenerationOnTeamcity.WHOLE_PROJECT)) {
            superExtractModels(modelDescriptors, project);
          } else {
            warning("No test configurations for project " + project.getProjectDescriptor().getName());
          }
        } else {
          for (BaseTestConfiguration config : testConfigurationList) {
            try {
              GenParameters genParams = config.getGenParams(project.getProject(), true);
              modelDescriptors.addAll(genParams.getModelDescriptors());
            } catch (IllegalGeneratorConfigurationException e) {
              log("Error while reading configuration of project " + project.getProject().getName(), e);
            }
          }
        }
      }
    });
  }

  private void superExtractModels(final Set<SModelDescriptor> modelDescriptors, final MPSProject project) {
    super.extractModels(modelDescriptors, project);
  }

  private StringBuffer createDetailedReport(@NotNull List<CompilationResult> compilationResult, @NotNull List<String> diffReports) {
    StringBuffer sb = new StringBuffer();
    if (myMessageHandler.getGenerationErrors().size() > 0) {
      sb.append("Generation Errors:\n");
      for (String e : myMessageHandler.getGenerationErrors()) {
        sb.append("  ");
        sb.append(e);
        sb.append("\n");
      }
      sb.append("\n");
    }
    boolean headerPrinted = false;
    for (CompilationResult r : compilationResult) {
      if (r.getErrors() != null && r.getErrors().length > 0) {
        if (!(headerPrinted)) {
          sb.append("Compilation Problems:\n");
          headerPrinted = true;
        }
        for (CategorizedProblem p : r.getErrors()) {
          sb.append("  ");
          sb.append(new String(r.getCompilationUnit().getFileName()));
          sb.append(" (");
          sb.append(p.getSourceLineNumber());
          sb.append("): ");
          sb.append(p.getMessage());
          sb.append("\n");
        }
      }
    }
    if (headerPrinted) {
      sb.append("\n");
    }
    if (Boolean.parseBoolean(myWhatToDo.getProperty(TestGenerationOnTeamcity.SHOW_DIFF))) {
      if (diffReports.size() > 0) {
        sb.append("Difference:\n");
        for (String diffReport : diffReports) {
          sb.append("  ");
          sb.append(diffReport);
          sb.append("\n");
        }
        sb.append("\n");
      }
    }
    return myBuildServerMessageFormat.escapeBuildMessage(sb);
  }

  @Override
  protected void showStatistic() {
    if (myTestFailed && myWhatToDo.getFailOnError()) {
      throw new BuildException("Tests Failed");
    }
  }

  public static void main(String[] args) {
    TestGenerationWorker generator = new TestGenerationWorker(WhatToDo.fromDumpInFile(new File(args[0])), new MpsWorker.SystemOutLogger());
    generator.workFromMain();
  }

  protected static interface Cycle {
    public void generate(GeneratorManager gm, IGenerationHandler generationHandler, IMessageHandler messageHandler);
    public List<File> getClassPath();
  }

  /*package*/ class MyMessageHandler implements IMessageHandler {
    private final List<String> myGenerationErrors = ListSequence.fromList(new ArrayList<String>());
    private final List<String> myGenerationWarnings = ListSequence.fromList(new ArrayList<String>());

    /*package*/ MyMessageHandler() {
    }

    public void handle(IMessage msg) {
      switch (msg.getKind()) {
        case ERROR:
          TestGenerationWorker.this.error(msg.getText());
          if (msg.getException() != null) {
            myGenerationErrors.add(MpsWorker.extractStackTrace(msg.getException()).toString());
          } else {
            myGenerationErrors.add(msg.getText());
          }
          break;
        case WARNING:
          TestGenerationWorker.this.warning(msg.getText());
          myGenerationWarnings.add(msg.getText());
          break;
        case INFORMATION:
          TestGenerationWorker.this.verbose(msg.getText());
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

    public void clean() {
      myGenerationErrors.clear();
      myGenerationWarnings.clear();
    }

    public void clear() {
    }
  }

  private class ModelCycle implements TestGenerationWorker.Cycle {
    private final IModule myModule;
    private final MPSProject myProject;
    private final SModelDescriptor mySModel;

    public ModelCycle(SModelDescriptor sModel, IModule module, MPSProject project) {
      mySModel = sModel;
      myProject = project;
      myModule = module;
    }

    public void generate(GeneratorManager gm, IGenerationHandler generationHandler, IMessageHandler messageHandler) {
      gm.generateModels(Collections.<SModelDescriptor>singletonList(mySModel), ProjectOperationContext.get(myProject.getProject()), generationHandler, new EmptyProgressIndicator(), messageHandler, GenerationOptions.getDefaults().incremental(new IncrementalGenerationStrategy() {
        public Map<String, String> getModelHashes(SModelDescriptor descriptor, IOperationContext context) {
          return Collections.EMPTY_MAP;
        }

        public GenerationCacheContainer getContainer() {
          return null;
        }

        public GenerationDependencies getDependencies(SModelDescriptor p0) {
          return null;
        }

        public boolean isIncrementalEnabled() {
          return false;
        }
      }).saveTransientModels(isInvokeTestsSet()).rebuildAll(true).create());
    }

    private List<File> classPathItemToFiles(IClassPathItem cp) {
      final List<File> classPathFiles = new ArrayList<File>();
      cp.accept(new EachClassPathItemVisitor() {
        @Override
        public void visit(FileClassPathItem cpItem) {
          classPathFiles.add(new File(cpItem.getPath()));
        }

        @Override
        public void visit(JarFileClassPathItem cpItem) {
          classPathFiles.add(new File(cpItem.getFile().getAbsolutePath()));
        }
      });
      return classPathFiles;
    }

    @Override
    public List<File> getClassPath() {
      IClassPathItem cp = ModelAccess.instance().runReadAction(new Computable<IClassPathItem>() {
        @Override
        public IClassPathItem compute() {
          return AbstractModule.getDependenciesClasspath(Collections.singleton(myModule), true);
        }
      });
      return classPathItemToFiles(cp);
    }

    @Override
    public String toString() {
      return "generating " + mySModel.getLongName();
    }

    public SModelDescriptor getModel() {
      return mySModel;
    }

    public boolean isUserModel() {
      if (myModule instanceof Language) {
        for (LanguageAspect la : LanguageAspect.values()) {
          if (la.get((Language) myModule) == mySModel) {
            return false;
          }
        }
        return true;
      } else
      if (myModule instanceof Generator || myModule instanceof DevKit) {
        return false;
      }
      return true;
    }
  }

  private class MyClassLoader extends AbstractClassLoader {
    private MyClassLoader(ClassLoader parent) {
      super(parent);
    }

    protected byte[] findClassBytes(String name) {
      return myGenerationHandler.getCompiler().getClasses().get(name);
    }

    protected boolean isExcluded(String name) {
      return false;
    }

    @Override
    public URL getResource(String name) {
      final URL resource = super.getResource(name);
      final File outputDir = myGenerationHandler.getLastOutputDir();
      if (resource != null || outputDir == null) {
        return resource;
      }
      File resourceFile = new File(outputDir.getAbsolutePath() + File.separator + name);
      if (resourceFile.exists()) {
        try {
          return resourceFile.toURL();
        } catch (MalformedURLException e) {
        }
      }
      return null;
    }
  }

  private class MyUnitTestAdapter extends UnitTestAdapter {
    private MyUnitTestAdapter() {
    }

    @Override
    public void testStarted(String testName) {
      System.out.println(myBuildServerMessageFormat.formatTestStart(myBuildServerMessageFormat.escapeBuildMessage(testName)));
    }

    @Override
    public void testFailed(String test, String message, String details) {
      System.out.println(myBuildServerMessageFormat.formatTestFailure(myBuildServerMessageFormat.escapeBuildMessage(test), myBuildServerMessageFormat.escapeBuildMessage(message), myBuildServerMessageFormat.escapeBuildMessage(details)));
      myTestFailed = true;
    }

    @Override
    public void testFinished(String testName) {
      System.out.println(myBuildServerMessageFormat.formatTestFinish(myBuildServerMessageFormat.escapeBuildMessage(testName)));
    }

    @Override
    public void logMessage(String message) {
      if (message != null && !(message.isEmpty())) {
        info(message);
      }
    }

    @Override
    public void logError(String errorMessage) {
      if (errorMessage != null && !(errorMessage.isEmpty())) {
        error(errorMessage);
      }
    }
  }
}
