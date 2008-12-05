package jetbrains.mps.lang.typesystem.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.ConceptFunctionParameter;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ConceptFunctionParameter_var extends ConceptFunctionParameter {
  public static final String concept = "jetbrains.mps.lang.typesystem.structure.ConceptFunctionParameter_var";

  public ConceptFunctionParameter_var(SNode node) {
    super(node);
  }

  public static ConceptFunctionParameter_var newInstance(SModel sm, boolean init) {
    return (ConceptFunctionParameter_var)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.typesystem.structure.ConceptFunctionParameter_var", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ConceptFunctionParameter_var newInstance(SModel sm) {
    return ConceptFunctionParameter_var.newInstance(sm, false);
  }

}
