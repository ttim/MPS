package org.jetbrains.mps.samples.ParallelFor.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.BaseIntention;
import jetbrains.mps.intentions.Intention;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.AttributeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.IAttributeDescriptor;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;

public class UnmarkLocalInstanceMethodCallAsThreadSafe_Intention extends BaseIntention implements Intention {
  public UnmarkLocalInstanceMethodCallAsThreadSafe_Intention() {
  }

  public String getConcept() {
    return "jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall";
  }

  public boolean isParameterized() {
    return false;
  }

  public boolean isErrorIntention() {
    return false;
  }

  public boolean isAvailableInChildNodes() {
    return true;
  }

  public String getDescription(final SNode node, final EditorContext editorContext) {
    return "Unmark as Thread Safe";
  }

  public boolean isApplicable(final SNode node, final EditorContext editorContext) {
    if (!(this.isApplicableToNode(node, editorContext))) {
      return false;
    }
    if (editorContext.getSelectedNode() != node && !(this.isVisibleInChild(node, editorContext.getSelectedNode(), editorContext))) {
      return false;
    }
    return true;
  }

  public boolean isApplicableToNode(final SNode node, final EditorContext editorContext) {
    return AttributeOperations.getAttribute(node, new IAttributeDescriptor.NodeAttribute(SConceptOperations.findConceptDeclaration("org.jetbrains.mps.samples.ParallelFor.structure.ThreadSafe"))) != null;
  }

  public boolean isVisibleInChild(final SNode node, final SNode childNode, final EditorContext editorContext) {
    return SNodeOperations.getParent(childNode) == node;
  }

  public void execute(final SNode node, final EditorContext editorContext) {
    AttributeOperations.setAttribute(node, new IAttributeDescriptor.NodeAttribute(SConceptOperations.findConceptDeclaration("org.jetbrains.mps.samples.ParallelFor.structure.ThreadSafe")), null);
  }

  public String getLocationString() {
    return "org.jetbrains.mps.samples.ParallelFor.intentions";
  }
}
