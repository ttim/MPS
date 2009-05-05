package jetbrains.mps.lang.typesystem.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.BaseIntention;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import java.util.List;
import jetbrains.mps.intentions.Intention;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;

public class ConvertGivetypeToTypeOfIntention_Intention extends BaseIntention {

  public ConvertGivetypeToTypeOfIntention_Intention() {
  }

  public String getConcept() {
    return "jetbrains.mps.lang.typesystem.structure.GivetypeStatement";
  }

  public boolean isParameterized() {
    return false;
  }

  public boolean isErrorIntention() {
    return false;
  }

  public boolean isAvailableInChildNodes() {
    return false;
  }

  public String getDescription(final SNode node, final EditorContext editorContext) {
    return "Convert to typeof";
  }

  public boolean isApplicable(final SNode node, final EditorContext editorContext) {
    return true;
  }

  public void execute(final SNode node, final EditorContext editorContext) {
    SNode equationStatement = SModelOperations.createNewNode(SNodeOperations.getModel(node), "jetbrains.mps.lang.typesystem.structure.CreateEquationStatement", null);
    SNode typeOfExpression = SModelOperations.createNewNode(SNodeOperations.getModel(node), "jetbrains.mps.lang.typesystem.structure.TypeOfExpression", null);
    SNode leftTypeClause = SModelOperations.createNewNode(SNodeOperations.getModel(node), "jetbrains.mps.lang.typesystem.structure.NormalTypeClause", null);
    SNode rightTypeClause = SModelOperations.createNewNode(SNodeOperations.getModel(node), "jetbrains.mps.lang.typesystem.structure.NormalTypeClause", null);
    SLinkOperations.setTarget(equationStatement, "leftExpression", leftTypeClause, true);
    SLinkOperations.setTarget(equationStatement, "rightExpression", rightTypeClause, true);
    SLinkOperations.setTarget(leftTypeClause, "normalType", typeOfExpression, true);
    SNode typeExpression = SLinkOperations.getTarget(node, "typeExpression", true);
    SLinkOperations.setTarget(rightTypeClause, "normalType", typeExpression, true);
    SNode termExpression = SLinkOperations.getTarget(node, "termExpression", true);
    SLinkOperations.setTarget(typeOfExpression, "term", termExpression, true);
    SNodeOperations.replaceWithAnother(node, equationStatement);
  }

  public String getLocationString() {
    return "jetbrains.mps.lang.typesystem.intentions";
  }

  public List<Intention> getInstances(final SNode node, final EditorContext editorContext) {
    List<Intention> list = ListSequence.fromList(new ArrayList<Intention>());
    ListSequence.fromList(list).addElement(this);
    return list;
  }

}
