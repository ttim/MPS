package jetbrains.mps.lang.smodel.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.quickfix.QuickFix_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;

public class ConvertCastToSModelCast_QuickFix extends QuickFix_Runtime {

  public ConvertCastToSModelCast_QuickFix() {
  }

  public String getDescription() {
    return "Convert to smodel cast";
  }

  public void execute(SNode node) {
    SNode snode = node;
    SNode blCast = snode;
    SNode expr = SLinkOperations.getTarget(blCast, "expression", true);
    SLinkOperations.removeChild(blCast, "expression");
    SNode cast = SConceptOperations.createNewNode("jetbrains.mps.lang.smodel.structure.SNodeTypeCastExpression", null);
    SLinkOperations.setTarget(cast, "concept", SLinkOperations.getTarget(SLinkOperations.getTarget(blCast, "type", true), "concept", false), false);
    SNodeOperations.replaceWithAnother(snode, cast);
    SLinkOperations.setTarget(cast, "leftExpression", expr, true);
  }

}
