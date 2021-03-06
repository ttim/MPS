package jetbrains.mps.build.gentest.plugin;

/*Generated by MPS */

import jetbrains.mps.make.facet.IFacet;
import java.util.List;
import jetbrains.mps.make.facet.ITarget;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.make.resources.IPropertiesPersistence;
import jetbrains.mps.make.facet.ITargetEx;
import jetbrains.mps.make.resources.IResource;
import jetbrains.mps.smodel.resources.ITResource;
import jetbrains.mps.make.script.IJob;
import jetbrains.mps.make.script.IResult;
import jetbrains.mps.make.script.IJobMonitor;
import jetbrains.mps.make.resources.IPropertiesAccessor;
import jetbrains.mps.smodel.resources.TResource;
import jetbrains.mps.internal.make.runtime.util.DeltaReconciler;
import java.util.Set;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import java.util.HashSet;
import jetbrains.mps.internal.make.runtime.util.FilesDelta;
import jetbrains.mps.vfs.IFile;
import jetbrains.mps.generator.fileGenerator.FileGenerationUtil;
import jetbrains.mps.vfs.FileSystem;
import jetbrains.mps.make.script.IFeedback;
import jetbrains.mps.make.script.IConfig;
import jetbrains.mps.baseLanguage.tuples.runtime.Tuples;
import jetbrains.mps.baseLanguage.tuples.runtime.MultiTuple;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import java.io.File;
import java.util.Map;
import jetbrains.mps.make.script.IPropertiesPool;
import jetbrains.mps.internal.collections.runtime.MapSequence;

public class Diff_Facet extends IFacet.Stub {
  private List<ITarget> targets = ListSequence.fromList(new ArrayList<ITarget>());
  private IFacet.Name name = new IFacet.Name("jetbrains.mps.build.gentest.Diff");

  public Diff_Facet() {
    ListSequence.fromList(targets).addElement(new Diff_Facet.Target_diff());
  }

  public Iterable<ITarget> targets() {
    return targets;
  }

  public Iterable<IFacet.Name> optional() {
    return null;
  }

  public Iterable<IFacet.Name> required() {
    return Sequence.fromArray(new IFacet.Name[]{new IFacet.Name("jetbrains.mps.lang.core.TextGen"), new IFacet.Name("jetbrains.mps.lang.core.Make")});
  }

  public Iterable<IFacet.Name> extended() {
    return null;
  }

  public IFacet.Name getName() {
    return this.name;
  }

  public IPropertiesPersistence propertiesPersistence() {
    return new Diff_Facet.TargetProperties();
  }

  public static class Target_diff implements ITargetEx {
    private static Class<? extends IResource>[] EXPECTED_INPUT = (Class<? extends IResource>[]) new Class[]{ITResource.class};
    private static Class<? extends IResource>[] EXPECTED_OUTPUT = (Class<? extends IResource>[]) new Class[]{};

    private ITarget.Name name = new ITarget.Name("jetbrains.mps.build.gentest.Diff.diff");

    public Target_diff() {
    }

    public IJob createJob() {
      return new IJob.Stub() {
        public IResult execute(final Iterable<IResource> input, final IJobMonitor monitor, final IPropertiesAccessor pa) {
          Iterable<IResource> _output_mtqq_a0a = null;
          switch (0) {
            case 0:
              if (pa.global().properties(Target_diff.this.getName(), Diff_Facet.Target_diff.Parameters.class).fileToPath() != null) {
                monitor.currentProgress().beginWork("Diffing", 100 * Sequence.fromIterable(input).count(), monitor.currentProgress().workLeft());
                for (IResource resource : input) {
                  final TResource tgres = ((TResource) resource);
                  String fqn = tgres.modelDescriptor().getSModelReference().getSModelFqName().getLongName();
                  monitor.currentProgress().advanceWork("Diffing", 1, fqn);
                  DeltaReconciler dr = new DeltaReconciler(tgres.delta());
                  final Set<String> retainedPaths = SetSequence.fromSet(new HashSet<String>());
                  dr.visitAll(new FilesDelta.Visitor() {
                    @Override
                    public boolean acceptKept(IFile file) {
                      SetSequence.fromSet(retainedPaths).addElement(pa.global().properties(Target_diff.this.getName(), Diff_Facet.Target_diff.Parameters.class).fileToPath().invoke(file));
                      return true;
                    }
                  });
                  final Differ differ = new Differ(retainedPaths, pa.global().properties(Target_diff.this.getName(), Diff_Facet.Target_diff.Parameters.class).excludedFiles());
                  final StringBuilder errors = new StringBuilder();
                  final String origOutRootPath = tgres.module().getOutputFor(tgres.modelDescriptor());
                  final String outDirPath = FileGenerationUtil.getDefaultOutputDir(tgres.modelDescriptor(), FileSystem.getInstance().getFileByPath(origOutRootPath)).getPath();

                  for (String diff : differ.diff(outDirPath, pa.global().properties(new ITarget.Name("jetbrains.mps.lang.core.Make.make"), jetbrains.mps.lang.core.plugin.Make_Facet.Target_make.Parameters.class).pathToFile().invoke(outDirPath).getPath())) {
                    errors.append("\n").append(diff);
                  }
                  if (errors.length() > 0) {
                    monitor.reportFeedback(new IFeedback.ERROR(String.valueOf("Differences\n" + errors.toString())));
                  }
                  monitor.currentProgress().advanceWork("Diffing", 99, fqn);
                }
                monitor.currentProgress().finishWork("Diffing");
              }
            default:
              return new IResult.SUCCESS(_output_mtqq_a0a);
          }
        }
      };
    }

    public IConfig createConfig() {
      return null;
    }

    public Iterable<ITarget.Name> notAfter() {
      return null;
    }

    public Iterable<ITarget.Name> after() {
      return Sequence.fromArray(new ITarget.Name[]{new ITarget.Name("jetbrains.mps.lang.core.Make.reconcile")});
    }

    public Iterable<ITarget.Name> notBefore() {
      return null;
    }

    public Iterable<ITarget.Name> before() {
      return Sequence.fromArray(new ITarget.Name[]{new ITarget.Name("jetbrains.mps.lang.core.Make.make")});
    }

    public ITarget.Name getName() {
      return name;
    }

    public boolean isOptional() {
      return false;
    }

    public boolean requiresInput() {
      return true;
    }

    public boolean producesOutput() {
      return true;
    }

    public Iterable<Class<? extends IResource>> expectedInput() {
      return Sequence.fromArray(EXPECTED_INPUT);
    }

    public Iterable<Class<? extends IResource>> expectedOutput() {
      return null;
    }

    public <T> T createParameters(Class<T> cls) {
      return cls.cast(new Parameters());
    }

    public <T> T createParameters(Class<T> cls, T copyFrom) {
      T t = createParameters(cls);
      if (t != null) {
        ((Tuples._2) t).assign((Tuples._2) copyFrom);
      }
      return t;
    }

    public static class Parameters extends MultiTuple._2<_FunctionTypes._return_P1_E0<? extends String, ? super IFile>, Set<File>> {
      public Parameters() {
        super();
      }

      public Parameters(_FunctionTypes._return_P1_E0<? extends String, ? super IFile> fileToPath, Set<File> excludedFiles) {
        super(fileToPath, excludedFiles);
      }

      public _FunctionTypes._return_P1_E0<? extends String, ? super IFile> fileToPath(_FunctionTypes._return_P1_E0<? extends String, ? super IFile> value) {
        return super._0(value);
      }

      public Set<File> excludedFiles(Set<File> value) {
        return super._1(value);
      }

      public _FunctionTypes._return_P1_E0<? extends String, ? super IFile> fileToPath() {
        return super._0();
      }

      public Set<File> excludedFiles() {
        return super._1();
      }

      @SuppressWarnings(value = "unchecked")
      public Diff_Facet.Target_diff.Parameters assignFrom(Tuples._2<_FunctionTypes._return_P1_E0<? extends String, ? super IFile>, Set<File>> from) {
        return (Diff_Facet.Target_diff.Parameters) super.assign(from);
      }
    }
  }

  public static class TargetProperties implements IPropertiesPersistence {
    public TargetProperties() {
    }

    public void storeValues(Map<String, String> store, IPropertiesPool properties) {
      {
        ITarget.Name name = new ITarget.Name("jetbrains.mps.build.gentest.Diff.diff");
        if (properties.hasProperties(name)) {
          Diff_Facet.Target_diff.Parameters props = properties.properties(name, Diff_Facet.Target_diff.Parameters.class);
          MapSequence.fromMap(store).put("jetbrains.mps.build.gentest.Diff.diff.fileToPath", null);
          MapSequence.fromMap(store).put("jetbrains.mps.build.gentest.Diff.diff.excludedFiles", null);
        }
      }
    }

    public void loadValues(Map<String, String> store, IPropertiesPool properties) {
      try {
        {
          ITarget.Name name = new ITarget.Name("jetbrains.mps.build.gentest.Diff.diff");
          Diff_Facet.Target_diff.Parameters props = properties.properties(name, Diff_Facet.Target_diff.Parameters.class);
          if (MapSequence.fromMap(store).containsKey("jetbrains.mps.build.gentest.Diff.diff.fileToPath")) {
            props.fileToPath(null);
          }
          if (MapSequence.fromMap(store).containsKey("jetbrains.mps.build.gentest.Diff.diff.excludedFiles")) {
            props.excludedFiles(null);
          }
        }
      } catch (RuntimeException re) {
      }
    }
  }
}
