package jetbrains.mps.bootstrap.structureLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ReferenceConceptLinkDeclaration extends ConceptLinkDeclaration {
  public static final String concept = "jetbrains.mps.bootstrap.structureLanguage.structure.ReferenceConceptLinkDeclaration";

  public  ReferenceConceptLinkDeclaration(SNode node) {
    super(node);
  }

  public static ReferenceConceptLinkDeclaration newInstance(SModel sm, boolean init) {
    return (ReferenceConceptLinkDeclaration)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.bootstrap.structureLanguage.structure.ReferenceConceptLinkDeclaration", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ReferenceConceptLinkDeclaration newInstance(SModel sm) {
    return ReferenceConceptLinkDeclaration.newInstance(sm, false);
  }

}
