package jetbrains.mps.lang.plugin.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.ConceptFunction;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class EnumerateChildrenFunction extends ConceptFunction {
  public static final String concept = "jetbrains.mps.lang.plugin.structure.EnumerateChildrenFunction";

  public EnumerateChildrenFunction(SNode node) {
    super(node);
  }

  public static EnumerateChildrenFunction newInstance(SModel sm, boolean init) {
    return (EnumerateChildrenFunction)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.plugin.structure.EnumerateChildrenFunction", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static EnumerateChildrenFunction newInstance(SModel sm) {
    return EnumerateChildrenFunction.newInstance(sm, false);
  }
}
