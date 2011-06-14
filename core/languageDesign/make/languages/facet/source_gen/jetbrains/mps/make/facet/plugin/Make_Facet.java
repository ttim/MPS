package jetbrains.mps.make.facet.plugin;

/*Generated by MPS */

import jetbrains.mps.make.facet.IFacet;
import java.util.List;
import jetbrains.mps.make.facet.ITarget;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.make.resources.IResource;
import jetbrains.mps.smodel.resources.IDeltaResource;
import jetbrains.mps.make.script.IJob;
import jetbrains.mps.make.script.IResult;
import jetbrains.mps.make.script.IJobMonitor;
import jetbrains.mps.make.script.IParametersPool;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.internal.make.runtime.util.DeltaReconciler;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.make.delta.IDelta;
import jetbrains.mps.internal.collections.runtime.ITranslator2;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.make.delta.IInternalDelta;
import jetbrains.mps.make.script.IConfig;

public class Make_Facet implements IFacet {
  private List<ITarget> targets = ListSequence.fromList(new ArrayList<ITarget>());
  private IFacet.Name name = new IFacet.Name("jetbrains.mps.make.facet.Make");

  public Make_Facet() {
    ListSequence.fromList(targets).addElement(new Make_Facet.Target_pm9z_a());
    ListSequence.fromList(targets).addElement(new Make_Facet.Target_pm9z_b());
  }

  public Iterable<ITarget> targets() {
    return targets;
  }

  public Iterable<IFacet.Name> optional() {
    return null;
  }

  public Iterable<IFacet.Name> required() {
    return null;
  }

  public Iterable<IFacet.Name> extended() {
    return null;
  }

  public IFacet.Name getName() {
    return this.name;
  }

  public static class Target_pm9z_a implements ITarget {
    private static Class<? extends IResource>[] EXPECTED_INPUT = (Class<? extends IResource>[]) new Class[]{IDeltaResource.class};
    private static Class<? extends IResource>[] EXPECTED_OUTPUT = (Class<? extends IResource>[]) new Class[]{};

    private ITarget.Name name = new ITarget.Name("reconcile");

    public Target_pm9z_a() {
    }

    public IJob createJob() {
      return new IJob() {
        public IResult execute(final Iterable<IResource> input, final IJobMonitor monitor, final IParametersPool pool) {
          Iterable<IResource> _output_pm9z_a0a = null;
          switch (0) {
            case 0:
              ModelAccess.instance().runWriteInEDTAndWait(new Runnable() {
                public void run() {
                  new DeltaReconciler(Sequence.fromIterable(input).<IDelta>translate(new ITranslator2<IResource, IDelta>() {
                    public Iterable<IDelta> translate(IResource res) {
                      return ((IDeltaResource) res).delta();
                    }
                  }).where(new IWhereFilter<IDelta>() {
                    public boolean accept(IDelta d) {
                      return !(d instanceof IInternalDelta);
                    }
                  })).reconcileAll();
                  new DeltaReconciler(Sequence.fromIterable(input).<IDelta>translate(new ITranslator2<IResource, IDelta>() {
                    public Iterable<IDelta> translate(IResource res) {
                      return ((IDeltaResource) res).delta();
                    }
                  }).where(new IWhereFilter<IDelta>() {
                    public boolean accept(IDelta d) {
                      return d instanceof IInternalDelta;
                    }
                  })).reconcileAll();
                }
              });
              _output_pm9z_a0a = Sequence.fromIterable(_output_pm9z_a0a).concat(Sequence.fromIterable(input));
            default:
              return new IResult.SUCCESS(_output_pm9z_a0a);
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
      return null;
    }

    public Iterable<ITarget.Name> notBefore() {
      return null;
    }

    public Iterable<ITarget.Name> before() {
      return null;
    }

    public ITarget.Name getName() {
      return name;
    }

    public boolean requiresInput() {
      return true;
    }

    public boolean producesOutput() {
      return false;
    }

    public Iterable<Class<? extends IResource>> expectedInput() {
      return Sequence.fromArray(EXPECTED_INPUT);
    }

    public Iterable<Class<? extends IResource>> expectedOutput() {
      return null;
    }

    public <T> T createParameters(Class<T> cls) {
      return null;
    }

    public <T> T createParameters(Class<T> cls, T copyFrom) {
      T t = createParameters(cls);
      return t;
    }
  }

  public static class Target_pm9z_b implements ITarget {
    private static Class<? extends IResource>[] EXPECTED_INPUT = (Class<? extends IResource>[]) new Class[]{IResource.class};
    private static Class<? extends IResource>[] EXPECTED_OUTPUT = (Class<? extends IResource>[]) new Class[]{};

    private ITarget.Name name = new ITarget.Name("make");

    public Target_pm9z_b() {
    }

    public IJob createJob() {
      return new IJob() {
        public IResult execute(final Iterable<IResource> input, final IJobMonitor monitor, final IParametersPool pool) {
          Iterable<IResource> _output_pm9z_a0b = null;
          switch (0) {
            case 0:
            default:
              return new IResult.SUCCESS(_output_pm9z_a0b);
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
      return Sequence.fromArray(new ITarget.Name[]{new ITarget.Name("reconcile")});
    }

    public Iterable<ITarget.Name> notBefore() {
      return null;
    }

    public Iterable<ITarget.Name> before() {
      return null;
    }

    public ITarget.Name getName() {
      return name;
    }

    public boolean requiresInput() {
      return true;
    }

    public boolean producesOutput() {
      return false;
    }

    public Iterable<Class<? extends IResource>> expectedInput() {
      return Sequence.fromArray(EXPECTED_INPUT);
    }

    public Iterable<Class<? extends IResource>> expectedOutput() {
      return null;
    }

    public <T> T createParameters(Class<T> cls) {
      return null;
    }

    public <T> T createParameters(Class<T> cls, T copyFrom) {
      T t = createParameters(cls);
      return t;
    }
  }
}
