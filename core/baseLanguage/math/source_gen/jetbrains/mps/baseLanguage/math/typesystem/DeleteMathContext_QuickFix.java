package jetbrains.mps.baseLanguage.math.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.quickfix.QuickFix_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.baseLanguage.math.behavior.MathUtil;

public class DeleteMathContext_QuickFix extends QuickFix_Runtime {
  public DeleteMathContext_QuickFix() {
  }

  public String getDescription() {
    return "Use default math context";
  }

  public void execute(SNode node) {
    SNodeOperations.replaceWithAnother(node, MathUtil.convert1(SNodeOperations.cast(node, "jetbrains.mps.baseLanguage.math.structure.DecimalBinaryOperation")));
  }
}
