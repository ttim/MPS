package jetbrains.mps.make.sandbox.sample;

/*Generated by MPS */

import jetbrains.mps.make.facet.IFacet;
import java.util.List;
import jetbrains.mps.make.facet.ITarget;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.make.resources.IResource;
import jetbrains.mps.make.script.IJob;
import jetbrains.mps.make.script.IResult;
import jetbrains.mps.make.script.IJobMonitor;
import jetbrains.mps.make.script.IParametersPool;
import jetbrains.mps.make.script.IConfig;
import jetbrains.mps.make.script.IConfigMonitor;
import jetbrains.mps.baseLanguage.tuples.runtime.MultiTuple;
import jetbrains.mps.baseLanguage.tuples.runtime.Tuples;

public class GenerateSpecial_Facet implements IFacet {
  private List<ITarget> targets = ListSequence.fromList(new ArrayList<ITarget>());
  private IFacet.Name name = new IFacet.Name("GenerateSpecial");

  public GenerateSpecial_Facet() {
    ListSequence.fromList(targets).addElement(new GenerateSpecial_Facet.Target_GenerateSpecialTarget());
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
    return Sequence.fromArray(new IFacet.Name[]{new IFacet.Name("Generate")});
  }

  public IFacet.Name getName() {
    return this.name;
  }

  public static class Target_GenerateSpecialTarget implements ITarget {
    private static Class<? extends IResource>[] EXPECTED_INPUT = (Class<? extends IResource>[]) new Class[]{};
    private static Class<? extends IResource>[] EXPECTED_OUTPUT = (Class<? extends IResource>[]) new Class[]{};

    private ITarget.Name name = new ITarget.Name("GenerateSpecialTarget");

    public Target_GenerateSpecialTarget() {
    }

    public IJob createJob() {
      return new IJob() {
        public IResult execute(final Iterable<IResource> input, final IJobMonitor monitor, final IParametersPool pool) {
          Iterable<IResource> _output_i03q2a_a0a = null;
          switch (0) {
            case 0:
              pool.parameters(Target_GenerateSpecialTarget.this.getName(), GenerateSpecial_Facet.Target_GenerateSpecialTarget.Variables.class).foo("asdasdsd");
              return new IResult.SUCCESS(_output_i03q2a_a0a);
            default:
              return new IResult.SUCCESS(_output_i03q2a_a0a);
          }
        }
      };
    }

    public IConfig createConfig() {
      return new IConfig() {
        public boolean configure(final IConfigMonitor cmonitor, final IParametersPool pool) {
          switch (0) {
            case 0:
              switch (cmonitor.<what_Option>relayQuery(new DOH_Query())) {
                case ABORT_i03q2a_a0a0a:
                  pool.parameters(Target_GenerateSpecialTarget.this.getName(), GenerateSpecial_Facet.Target_GenerateSpecialTarget.Variables.class).baz(false);
                  break;
                case IGNORE_i03q2a_c0a0a:
                  pool.parameters(Target_GenerateSpecialTarget.this.getName(), GenerateSpecial_Facet.Target_GenerateSpecialTarget.Variables.class).baz(false);
                  break;
                case RETRY_i03q2a_b0a0a:
                  pool.parameters(Target_GenerateSpecialTarget.this.getName(), GenerateSpecial_Facet.Target_GenerateSpecialTarget.Variables.class).baz(true);
                  break;
                default:
              }
            default:
              return true;
          }
        }
      };
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
      return true;
    }

    public Iterable<Class<? extends IResource>> expectedInput() {
      return Sequence.fromArray(EXPECTED_INPUT);
    }

    public Iterable<Class<? extends IResource>> expectedOutput() {
      return null;
    }

    public <T> T createParameters(Class<T> cls) {
      return cls.cast(new Variables());
    }

    public <T> T createParameters(Class<T> cls, T copyFrom) {
      T t = createParameters(cls);
      if (t != null) {
        ((GenerateSpecial_Facet.Target_GenerateSpecialTarget.Variables) t).foo(((GenerateSpecial_Facet.Target_GenerateSpecialTarget.Variables) copyFrom).foo());
        ((GenerateSpecial_Facet.Target_GenerateSpecialTarget.Variables) t).bar((int) ((GenerateSpecial_Facet.Target_GenerateSpecialTarget.Variables) copyFrom).bar());
        ((GenerateSpecial_Facet.Target_GenerateSpecialTarget.Variables) t).baz((boolean) ((GenerateSpecial_Facet.Target_GenerateSpecialTarget.Variables) copyFrom).baz());
      }
      return t;
    }

    public static class Variables extends MultiTuple._3<String, Integer, Boolean> {
      public Variables() {
        super();
      }

      public Variables(String foo, Integer bar, Boolean baz) {
        super(foo, bar, baz);
      }

      public String foo(String value) {
        return super._0(value);
      }

      public Integer bar(Integer value) {
        return super._1(value);
      }

      public Boolean baz(Boolean value) {
        return super._2(value);
      }

      public String foo() {
        return super._0();
      }

      public Integer bar() {
        return super._1();
      }

      public Boolean baz() {
        return super._2();
      }

      @SuppressWarnings(value = "unchecked")
      public GenerateSpecial_Facet.Target_GenerateSpecialTarget.Variables assignFrom(Tuples._3<String, Integer, Boolean> from) {
        return (GenerateSpecial_Facet.Target_GenerateSpecialTarget.Variables) super.assign(from);
      }
    }
  }
}
