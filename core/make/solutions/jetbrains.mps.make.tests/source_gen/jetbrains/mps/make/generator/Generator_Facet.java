package jetbrains.mps.make.generator;

/*Generated by MPS */

import jetbrains.mps.make.facet.IFacet;
import java.util.List;
import jetbrains.mps.make.facet.ITarget;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.make.script.IJob;
import jetbrains.mps.make.script.IResult;
import jetbrains.mps.make.resources.IResource;
import jetbrains.mps.make.script.IMonitor;
import jetbrains.mps.make.script.IVariablesPool;

public class Generator_Facet implements IFacet {
  private List<ITarget> targets = ListSequence.fromList(new ArrayList<ITarget>());
  private IFacet.Name name = new IFacet.Name("Generator");

  public Generator_Facet() {
    ListSequence.fromList(targets).addElement(new Generator_Facet.Target_ixz87t_a());
  }

  public Iterable<ITarget> targets() {
    return targets;
  }

  public Iterable<IFacet.Name> optional() {
    return null;
  }

  public Iterable<IFacet.Name> required() {
    return Sequence.fromArray(new IFacet.Name[]{new IFacet.Name("Maker")});
  }

  public Iterable<IFacet.Name> extended() {
    return null;
  }

  public IFacet.Name getName() {
    return this.name;
  }

  public static class Target_ixz87t_a implements ITarget {
    private ITarget.Name name = new ITarget.Name("Generate");

    public Target_ixz87t_a() {
    }

    public IJob createJob() {
      return new IJob() {
        public IResult execute(Iterable<IResource> input, IMonitor monitor, IVariablesPool pool) {
          Iterable<IResource> _output_ixz87t_a0a = null;
          switch (0) {
            case 0:
              for (IResource resource : input) {
                System.out.println("Input: " + resource);
                _output_ixz87t_a0a = Sequence.fromIterable(_output_ixz87t_a0a).concat(Sequence.fromIterable(Sequence.<IResource>singleton(resource)));
              }
              _output_ixz87t_a0a = Sequence.fromIterable(_output_ixz87t_a0a).concat(Sequence.fromIterable(input));
              return new IResult.SUCCESS(_output_ixz87t_a0a);
            default:
              return new IResult.SUCCESS(_output_ixz87t_a0a);
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
      return Sequence.fromArray(new ITarget.Name[]{new ITarget.Name("Make")});
    }

    public ITarget.Name getName() {
      return name;
    }

    public <T> T createVariables(Class<T> cls) {
      return null;
    }
  }
}
