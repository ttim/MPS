package jetbrains.mps.vcs.changesmanager.tree.features;

/*Generated by MPS */

import org.jetbrains.annotations.NotNull;
import jetbrains.mps.smodel.SModelReference;
import org.jetbrains.annotations.Nullable;

public class VirtualPackageFeature extends Feature {
  private String myVirtualPackage;

  public VirtualPackageFeature(@NotNull SModelReference modelReference, @NotNull String virtualPackage) {
    super(modelReference);
    myVirtualPackage = virtualPackage;
  }

  @NotNull
  public String toString() {
    return "Virtual Package {" + getModelReference().toString() + "|" + myVirtualPackage + "}";
  }

  @Nullable
  public Feature getParent() {
    int lastIndexOf = myVirtualPackage.lastIndexOf('.');
    if (lastIndexOf == -1) {
      return null;
    } else {
      String parentPackage = myVirtualPackage.substring(0, lastIndexOf);
      return new VirtualPackageFeature(getModelReference(), parentPackage);
    }
  }
}
