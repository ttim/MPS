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

public class ConvertIfToMyIf_Intention extends BaseIntention implements Intention {
  public ConvertIfToMyIf_Intention() {
  }

  public String getConcept() {
    return "jetbrains.mps.baseLanguage.structure.IfStatement";
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
    return "Convert to MyIf";
  }

  public void execute(final SNode node, final EditorContext editorContext) {
    SNode statement = SConceptOperations.createNewNode("org.jetbrains.mps.samples.IfAndUnless.structure.MyIfStatement", null);
    SLinkOperations.setTarget(statement, "condition", SLinkOperations.getTarget(node, "condition", true), true);
    SNode ifBody = SConceptOperations.createNewNode("org.jetbrains.mps.samples.IfAndUnless.structure.TrueFlow", null);
    ListSequence.fromList(SLinkOperations.getTargets(ifBody, "statement", true)).addSequence(ListSequence.fromList(SLinkOperations.getTargets(SLinkOperations.getTarget(node, "ifTrue", true), "statement", true)));
    SLinkOperations.setTarget(statement, "body", ifBody, true);

    SLinkOperations.setTarget(statement, "alternative", SConceptOperations.createNewNode("org.jetbrains.mps.samples.IfAndUnless.structure.FalseFlow", null), true);
    if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(node, "ifFalseStatement", true), "jetbrains.mps.baseLanguage.structure.BlockStatement")) {
      ListSequence.fromList(SLinkOperations.getTargets(SLinkOperations.getTarget(statement, "alternative", true), "statement", true)).addSequence(ListSequence.fromList(SLinkOperations.getTargets(SLinkOperations.getTarget(SNodeOperations.cast(SLinkOperations.getTarget(node, "ifFalseStatement", true), "jetbrains.mps.baseLanguage.structure.BlockStatement"), "statements", true), "statement", true)));
    } else {
      ListSequence.fromList(SLinkOperations.getTargets(SLinkOperations.getTarget(statement, "alternative", true), "statement", true)).addElement(SLinkOperations.getTarget(node, "ifFalseStatement", true));
    }
    SNodeOperations.replaceWithAnother(node, statement);
    editorContext.select(SLinkOperations.getTarget(statement, "condition", true));
  }

  public String getLocationString() {
    return "org.jetbrains.mps.samples.IfAndUnless.intentions";
  }
}
