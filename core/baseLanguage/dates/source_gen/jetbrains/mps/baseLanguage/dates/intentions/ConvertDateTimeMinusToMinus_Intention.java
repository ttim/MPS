package jetbrains.mps.baseLanguage.dates.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.BaseIntention;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;

public class ConvertDateTimeMinusToMinus_Intention extends BaseIntention {

  public String getConcept() {
    return "jetbrains.mps.baseLanguage.dates.structure.DateTimeMinusPeriodOperation";
  }

  public boolean isErrorIntention() {
    return true;
  }

  public String getDescription(final SNode node, final EditorContext editorContext) {
    return "convert minus expression to datetime minus period expression";
  }

  public boolean isApplicable(final SNode node, final EditorContext editorContext) {
    return true;
  }

  public void execute(final SNode node, final EditorContext editorContext) {
    SNode plusPeriodOperation = SNodeOperations.replaceWithNewChild(node, "jetbrains.mps.baseLanguage.structure.MinusExpression");
    SLinkOperations.setTarget(plusPeriodOperation, "leftExpression", SLinkOperations.getTarget(node, "leftValue", true), true);
    SLinkOperations.setTarget(plusPeriodOperation, "rightExpression", SLinkOperations.getTarget(node, "rightValue", true), true);
  }

  public String getLocationString() {
    return "jetbrains.mps.baseLanguage.dates.intentions";
  }

}
