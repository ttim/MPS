package jetbrains.mps.lang.typesystem.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.ConceptFunction;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class VariableConverterItem_ConvertBlock extends ConceptFunction {
  public static final String concept = "jetbrains.mps.lang.typesystem.structure.VariableConverterItem_ConvertBlock";

  public VariableConverterItem_ConvertBlock(SNode node) {
    super(node);
  }

  public static VariableConverterItem_ConvertBlock newInstance(SModel sm, boolean init) {
    return (VariableConverterItem_ConvertBlock)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.typesystem.structure.VariableConverterItem_ConvertBlock", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static VariableConverterItem_ConvertBlock newInstance(SModel sm) {
    return VariableConverterItem_ConvertBlock.newInstance(sm, false);
  }
}
