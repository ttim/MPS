package jetbrains.mps.bootstrap.constraintsLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.ConceptFunction;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ConceptConstructorDeclaration extends ConceptFunction {
  public static final String concept = "jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptConstructorDeclaration";

  public  ConceptConstructorDeclaration(SNode node) {
    super(node);
  }

  public static ConceptConstructorDeclaration newInstance(SModel sm, boolean init) {
    return (ConceptConstructorDeclaration)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptConstructorDeclaration", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ConceptConstructorDeclaration newInstance(SModel sm) {
    return ConceptConstructorDeclaration.newInstance(sm, false);
  }

}
