package jetbrains.mps.make.sandbox.sample;

/*Generated by MPS */

import jetbrains.mps.make.facet.IFacet;
import java.util.List;
import jetbrains.mps.make.facet.ITarget;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.make.script.IJob;
import jetbrains.mps.make.script.IResult;
import jetbrains.mps.make.resources.IResource;
import jetbrains.mps.make.script.IMonitor;
import jetbrains.mps.make.script.IVariablesPool;

public class Generate_Facet implements IFacet {
  private List<ITarget> targets = ListSequence.fromList(new ArrayList<ITarget>());
  private IFacet.Name name = new IFacet.Name("Generate");

  public Generate_Facet() {
    ListSequence.fromList(targets).addElement(new Generate_Facet.Target_fi61u2_a());
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

  public static class Target_fi61u2_a implements ITarget {
    private ITarget.Name name = new ITarget.Name("GenerateTarget");

    public Target_fi61u2_a() {
    }

    public IJob createJob() {
      return new IJob() {
        public IResult execute(Iterable<IResource> input, IMonitor monitor, IVariablesPool pool) {
          Iterable<IResource> _output_fi61u2_a0a = null;
          switch (0) {
            case 0:
            default:
              return new IResult.SUCCESS(_output_fi61u2_a0a);
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

    public <T> T createVariables(Class<T> cls) {
      return null;
    }
  }
}
