package jetbrains.mps.lang.editor.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class TransactionPropertyHandler_newValue extends jetbrains.mps.baseLanguage.structure.ConceptFunctionParameter {
  public static final String concept = "jetbrains.mps.lang.editor.structure.TransactionPropertyHandler_newValue";

  public TransactionPropertyHandler_newValue(SNode node) {
    super(node);
  }

  public static TransactionPropertyHandler_newValue newInstance(SModel sm, boolean init) {
    return (TransactionPropertyHandler_newValue)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.editor.structure.TransactionPropertyHandler_newValue", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static TransactionPropertyHandler_newValue newInstance(SModel sm) {
    return TransactionPropertyHandler_newValue.newInstance(sm, false);
  }

}
