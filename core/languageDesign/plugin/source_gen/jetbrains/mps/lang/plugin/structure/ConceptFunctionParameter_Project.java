package jetbrains.mps.lang.plugin.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.ConceptFunctionParameter;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ConceptFunctionParameter_Project extends ConceptFunctionParameter {
  public static final String concept = "jetbrains.mps.lang.plugin.structure.ConceptFunctionParameter_Project";

  public ConceptFunctionParameter_Project(SNode node) {
    super(node);
  }

  public static ConceptFunctionParameter_Project newInstance(SModel sm, boolean init) {
    return (ConceptFunctionParameter_Project)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.plugin.structure.ConceptFunctionParameter_Project", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ConceptFunctionParameter_Project newInstance(SModel sm) {
    return ConceptFunctionParameter_Project.newInstance(sm, false);
  }
}
