package jetbrains.mps.build.plugin;

/*Generated by MPS */

import jetbrains.mps.smodel.structure.DescriptorProvider;
import jetbrains.mps.smodel.structure.FacetDescriptor;
import jetbrains.mps.make.facet.IFacetManifest;

public class FacetAspectDescriptor extends DescriptorProvider<FacetDescriptor> {
  private static FacetManifest MANIFEST;

  public FacetAspectDescriptor() {
    MANIFEST = new FacetManifest();
  }

  public FacetDescriptor getDescriptor(String conceptFqName) {
    return new FacetDescriptor() {
      public IFacetManifest getManifest() {
        return FacetAspectDescriptor.MANIFEST;
      }
    };
  }
}
