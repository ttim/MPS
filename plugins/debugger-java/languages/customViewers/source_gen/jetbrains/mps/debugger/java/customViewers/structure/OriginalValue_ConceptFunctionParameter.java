package jetbrains.mps.debugger.java.customViewers.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.ConceptFunctionParameter;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class OriginalValue_ConceptFunctionParameter extends ConceptFunctionParameter {
  public static final String concept = "jetbrains.mps.debugger.java.customViewers.structure.OriginalValue_ConceptFunctionParameter";

  public OriginalValue_ConceptFunctionParameter(SNode node) {
    super(node);
  }

  public static OriginalValue_ConceptFunctionParameter newInstance(SModel sm, boolean init) {
    return (OriginalValue_ConceptFunctionParameter) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.debugger.java.customViewers.structure.OriginalValue_ConceptFunctionParameter", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static OriginalValue_ConceptFunctionParameter newInstance(SModel sm) {
    return OriginalValue_ConceptFunctionParameter.newInstance(sm, false);
  }
}
