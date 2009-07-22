package jetbrains.mps.lang.smodel.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.BaseIntention;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;

public class ReplaceConceptIsWithConceptEquals_Intention extends BaseIntention {

  public ReplaceConceptIsWithConceptEquals_Intention() {
  }

  public String getConcept() {
    return "jetbrains.mps.lang.smodel.structure.OperationParm_Concept";
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
    return "Replace 'concept=' with Concept List";
  }

  public boolean isApplicable(final SNode node, final EditorContext editorContext) {
    if (!(this.isApplicableToNode(node, editorContext))) {
      return false;
    }
    return true;
  }

  public boolean isApplicableToNode(final SNode node, final EditorContext editorContext) {
    return SNodeOperations.isInstanceOf(SLinkOperations.getTarget(node, "conceptArgument", true), "jetbrains.mps.lang.smodel.structure.RefConcept_Reference");
  }

  public void execute(final SNode node, final EditorContext editorContext) {
    SNode conceptList = SConceptOperations.createNewNode("jetbrains.mps.lang.smodel.structure.OperationParm_ConceptList", null);
    SLinkOperations.setTarget(ListSequence.fromList(SLinkOperations.getTargets(conceptList, "concept", true)).first(), "concept", SLinkOperations.getTarget(SNodeOperations.cast(SLinkOperations.getTarget(node, "conceptArgument", true), "jetbrains.mps.lang.smodel.structure.RefConcept_Reference"), "conceptDeclaration", false), false);
    SNodeOperations.replaceWithAnother(node, conceptList);
  }

  public String getLocationString() {
    return "jetbrains.mps.lang.smodel.intentions";
  }

}
