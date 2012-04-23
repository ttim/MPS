package jetbrains.mps.debugger.api.lang.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.BaseIntention;
import jetbrains.mps.intentions.Intention;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;

public class SwitchToComplexIsApplicable_Intention extends BaseIntention implements Intention {
  public SwitchToComplexIsApplicable_Intention() {
  }

  public String getConcept() {
    return "jetbrains.mps.debugger.api.lang.structure.BreakpointableNodeItem";
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
    if (SPropertyOperations.getBoolean(node, "isComplex")) {
      return "Use Concept List";
    }
    return "Use isApplicable Function";
  }

  public void execute(final SNode node, final EditorContext editorContext) {
    SPropertyOperations.set(node, "isComplex", "" + (!(SPropertyOperations.getBoolean(node, "isComplex"))));
    if (SPropertyOperations.getBoolean(node, "isComplex") && (SLinkOperations.getTarget(node, "isApplicable", true) == null)) {
      SLinkOperations.setNewChild(node, "isApplicable", "jetbrains.mps.debugger.api.lang.structure.ConceptFunction_IsApplicableToConcept");
      SLinkOperations.setNewChild(SLinkOperations.getTarget(node, "isApplicable", true), "body", "jetbrains.mps.baseLanguage.structure.StatementList");
    }
  }

  public String getLocationString() {
    return "jetbrains.mps.debugger.api.lang.intentions";
  }
}
