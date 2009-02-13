package jetbrains.mps.build.distrib.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class MacOsFileAssociation extends FileAssociation {
  public static final String concept = "jetbrains.mps.build.distrib.structure.MacOsFileAssociation";
  public static final String ROLE = "role";

  public MacOsFileAssociation(SNode node) {
    super(node);
  }

  public Role getRole() {
    return (Role)this.getChild(Role.class, MacOsFileAssociation.ROLE);
  }

  public void setRole(Role node) {
    super.setChild(MacOsFileAssociation.ROLE, node);
  }


  public static MacOsFileAssociation newInstance(SModel sm, boolean init) {
    return (MacOsFileAssociation)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.build.distrib.structure.MacOsFileAssociation", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static MacOsFileAssociation newInstance(SModel sm) {
    return MacOsFileAssociation.newInstance(sm, false);
  }

}
