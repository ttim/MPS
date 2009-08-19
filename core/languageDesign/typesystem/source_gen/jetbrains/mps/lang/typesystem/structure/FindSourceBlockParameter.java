package jetbrains.mps.lang.typesystem.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.ConceptFunctionParameter;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class FindSourceBlockParameter extends ConceptFunctionParameter {
  public static final String concept = "jetbrains.mps.lang.typesystem.structure.FindSourceBlockParameter";

  public FindSourceBlockParameter(SNode node) {
    super(node);
  }

  public static FindSourceBlockParameter newInstance(SModel sm, boolean init) {
    return (FindSourceBlockParameter)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.typesystem.structure.FindSourceBlockParameter", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static FindSourceBlockParameter newInstance(SModel sm) {
    return FindSourceBlockParameter.newInstance(sm, false);
  }
}
