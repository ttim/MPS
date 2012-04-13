package org.jetbrains.mps.samples.ParallelFor.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.BaseIntention;
import jetbrains.mps.intentions.Intention;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.AttributeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.IAttributeDescriptor;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.smodel.action.SNodeFactoryOperations;

public class MarkAsNonThreadSafe_Intention extends BaseIntention implements Intention {
  public MarkAsNonThreadSafe_Intention() {
  }

  public String getConcept() {
    return "jetbrains.mps.baseLanguage.structure.ClassConcept";
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
    return "Mark as Non Thread Safe";
  }

  public boolean isApplicable(final SNode node, final EditorContext editorContext) {
    if (!(this.isApplicableToNode(node, editorContext))) {
      return false;
    }
    return true;
  }

  public boolean isApplicableToNode(final SNode node, final EditorContext editorContext) {
    return AttributeOperations.getAttribute(node, new IAttributeDescriptor.NodeAttribute(SConceptOperations.findConceptDeclaration("org.jetbrains.mps.samples.ParallelFor.structure.NonThreadSafeClass"))) == null;
  }

  public void execute(final SNode node, final EditorContext editorContext) {
    AttributeOperations.setAttribute(node, new IAttributeDescriptor.NodeAttribute(SConceptOperations.findConceptDeclaration("org.jetbrains.mps.samples.ParallelFor.structure.NonThreadSafeClass")), SNodeFactoryOperations.createNewNode("org.jetbrains.mps.samples.ParallelFor.structure.NonThreadSafeClass", null));
    AttributeOperations.setAttribute(node, new IAttributeDescriptor.NodeAttribute(SConceptOperations.findConceptDeclaration("org.jetbrains.mps.samples.ParallelFor.structure.ThreadSafe")), null);
  }

  public String getLocationString() {
    return "org.jetbrains.mps.samples.ParallelFor.intentions";
  }
}
