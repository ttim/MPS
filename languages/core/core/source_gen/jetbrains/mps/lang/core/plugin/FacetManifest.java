package jetbrains.mps.lang.core.plugin;

/*Generated by MPS */

import jetbrains.mps.make.facet.IFacetManifest;
import java.util.List;
import jetbrains.mps.make.facet.IFacet;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.make.facet.FacetRegistry;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;

public class FacetManifest implements IFacetManifest {
  private List<IFacet> facets = ListSequence.fromList(new ArrayList<IFacet>());

  public FacetManifest() {
    ListSequence.fromList(facets).addElement(new Generate_Facet());
    ListSequence.fromList(facets).addElement(new TextGen_Facet());
  }

  public void registerFacets(FacetRegistry registry) {
    for (IFacet f : ListSequence.fromList(facets)) {
      registry.register(f);
    }
  }

  public void unRegisterFacets(FacetRegistry registry) {
    for (IFacet f : ListSequence.fromList(facets)) {
      registry.unregister(f);
    }
  }

  public Iterable<IFacet> facets() {
    return facets;
  }

  public IFacet lookup(final IFacet.Name fn) {
    return ListSequence.fromList(facets).findFirst(new IWhereFilter<IFacet>() {
      public boolean accept(IFacet f) {
        return f.getName().equals(fn);
      }
    });
  }
}
