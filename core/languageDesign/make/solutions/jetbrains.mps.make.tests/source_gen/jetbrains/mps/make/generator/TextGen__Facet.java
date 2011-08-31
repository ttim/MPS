package jetbrains.mps.make.generator;

/*Generated by MPS */

import jetbrains.mps.make.facet.IFacet;
import java.util.List;
import jetbrains.mps.make.facet.ITarget;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.make.resources.IPropertiesPersistence;
import jetbrains.mps.make.resources.IResource;
import jetbrains.mps.make.script.IJob;
import jetbrains.mps.make.script.IResult;
import jetbrains.mps.make.script.IJobMonitor;
import jetbrains.mps.make.resources.IPropertiesAccessor;
import jetbrains.mps.make.script.IConfig;
import jetbrains.mps.make.script.IConfigMonitor;
import java.util.Map;
import jetbrains.mps.make.script.IPropertiesPool;

public class TextGen__Facet extends IFacet.Stub {
  private List<ITarget> targets = ListSequence.<ITarget>fromList(new ArrayList<ITarget>());
  private IFacet.Name name = new IFacet.Name("TextGen_");

  public TextGen__Facet() {
    ListSequence.<ITarget>fromList(targets).addElement(new TextGen__Facet.Target_ConditionallyGenerate());
  }

  public Iterable<ITarget> targets() {
    return targets;
  }

  public Iterable<IFacet.Name> optional() {
    return null;
  }

  public Iterable<IFacet.Name> required() {
    return Sequence.fromArray(new IFacet.Name[]{new IFacet.Name("Maker_")});
  }

  public Iterable<IFacet.Name> extended() {
    return null;
  }

  public IFacet.Name getName() {
    return this.name;
  }

  public IPropertiesPersistence propertiesPersistence() {
    return new TextGen__Facet.TargetProperties();
  }

  public static class Target_ConditionallyGenerate implements ITarget {
    private static Class<? extends IResource>[] EXPECTED_INPUT = (Class<? extends IResource>[]) new Class[]{};
    private static Class<? extends IResource>[] EXPECTED_OUTPUT = (Class<? extends IResource>[]) new Class[]{};

    private ITarget.Name name = new ITarget.Name("TextGen_.ConditionallyGenerate");

    public Target_ConditionallyGenerate() {
    }

    public IJob createJob() {
      return new IJob.Stub() {
        public IResult execute(final Iterable<IResource> input, final IJobMonitor monitor, final IPropertiesAccessor pa) {
          Iterable<IResource> _output_rqwvem_a0a = null;
          switch (0) {
            case 0:
            default:
              return new IResult.SUCCESS(_output_rqwvem_a0a);
          }
        }
      };
    }

    public IConfig createConfig() {
      return new IConfig.Stub() {
        @Override
        public boolean configure(final IConfigMonitor cmonitor, final IPropertiesAccessor pa) {
          switch (0) {
            case 0:
              switch (cmonitor.<Bar_Option>relayQuery(new Askfoo_Query())) {
                case GOAHEAD_rqwvem_a0a0a:
                  return true;
                case NOWAY_rqwvem_b0a0a:
                  return false;
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
      return Sequence.fromArray(new ITarget.Name[]{new ITarget.Name("Maker_.Make")});
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
      return null;
    }

    public <T> T createParameters(Class<T> cls, T copyFrom) {
      T t = createParameters(cls);
      return t;
    }
  }

  public static class TargetProperties implements IPropertiesPersistence {
    public TargetProperties() {
    }

    public void storeValues(Map<String, String> store, IPropertiesPool properties) {
    }

    public void loadValues(Map<String, String> store, IPropertiesPool properties) {
      try {
      } catch (RuntimeException re) {
      }
    }
  }
}
