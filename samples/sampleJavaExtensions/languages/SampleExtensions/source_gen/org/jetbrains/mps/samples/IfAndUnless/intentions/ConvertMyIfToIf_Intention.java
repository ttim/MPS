package org.jetbrains.mps.samples.IfAndUnless.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.BaseIntention;
import jetbrains.mps.intentions.Intention;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;

public class ConvertMyIfToIf_Intention extends BaseIntention implements Intention {
  public ConvertMyIfToIf_Intention() {
  }

  public String getConcept() {
    return "org.jetbrains.mps.samples.IfAndUnless.structure.MyIfStatement";
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
    return "Convert to If";
  }

  public void execute(final SNode node, final EditorContext editorContext) {
    SNode statement = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.IfStatement", null);
    SLinkOperations.setTarget(statement, "condition", SLinkOperations.getTarget(node, "condition", true), true);
    SNode ifBody = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.StatementList", null);
    ListSequence.fromList(SLinkOperations.getTargets(ifBody, "statement", true)).addSequence(ListSequence.fromList(SLinkOperations.getTargets(SLinkOperations.getTarget(node, "body", true), "statement", true)));
    SLinkOperations.setTarget(statement, "ifTrue", ifBody, true);

    SNode ifFalseBody = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.StatementList", null);
    ListSequence.fromList(SLinkOperations.getTargets(ifFalseBody, "statement", true)).addSequence(ListSequence.fromList(SLinkOperations.getTargets(SLinkOperations.getTarget(node, "alternative", true), "statement", true)));
    SLinkOperations.setTarget(statement, "ifFalseStatement", SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.BlockStatement", null), true);
    SLinkOperations.setTarget(SNodeOperations.cast(SLinkOperations.getTarget(statement, "ifFalseStatement", true), "jetbrains.mps.baseLanguage.structure.BlockStatement"), "statements", ifFalseBody, true);
    SNodeOperations.replaceWithAnother(node, statement);
    editorContext.select(SLinkOperations.getTarget(statement, "condition", true));
  }

  public String getLocationString() {
    return "org.jetbrains.mps.samples.IfAndUnless.intentions";
  }
}
