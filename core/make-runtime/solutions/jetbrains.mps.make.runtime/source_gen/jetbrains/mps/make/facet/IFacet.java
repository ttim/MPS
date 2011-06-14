package jetbrains.mps.make.facet;

/*Generated by MPS */

import jetbrains.mps.internal.make.runtime.util.FqName;

public interface IFacet {
  public IFacet.Name getName();
  public Iterable<IFacet.Name> extended();
  public Iterable<IFacet.Name> required();
  public Iterable<IFacet.Name> optional();
  public Iterable<ITarget> targets();
  public static class Name extends FqName {
    public Name(String fqn) {
      super(fqn);
    }
  }

}
