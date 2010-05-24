package jetbrains.mps.baseLanguage.regexp.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.BaseNodeReferenceSearchScopeProvider;
import jetbrains.mps.smodel.constraints.IModelConstraints;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.constraints.ReferentConstraintContext;
import java.util.List;
import jetbrains.mps.smodel.SNode;
import java.util.ArrayList;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.baseLanguage.regexp.behavior.Regexp_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.SNodePointer;
import jetbrains.mps.smodel.constraints.PresentationReferentConstraintContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;

public class MatchVariableReferenceReplacement_match_ReferentConstraint extends BaseNodeReferenceSearchScopeProvider implements IModelConstraints {
  public MatchVariableReferenceReplacement_match_ReferentConstraint() {
  }

  public void registerSelf(ModelConstraintsManager manager) {
    manager.registerNodeReferentSearchScopeProvider("jetbrains.mps.baseLanguage.regexp.structure.MatchVariableReferenceReplacement", "match", this);
  }

  public void unRegisterSelf(ModelConstraintsManager manager) {
    manager.unRegisterNodeReferentSearchScopeProvider("jetbrains.mps.baseLanguage.regexp.structure.MatchVariableReferenceReplacement", "match");
  }

  public Object createSearchScopeOrListOfNodes(final IOperationContext operationContext, final ReferentConstraintContext _context) {
    List<SNode> matches = new ArrayList<SNode>();
    SNode top = SNodeOperations.getAncestor(_context.getEnclosingNode(), "jetbrains.mps.baseLanguage.regexp.structure.ReplaceRegexpOperation", true, false);
    if ((top != null)) {
      Regexp_Behavior.call_getString_1222432436326(SLinkOperations.getTarget(top, "search", true), matches);
    }
    return matches;
  }

  public SNodePointer getSearchScopeFactoryNodePointer() {
    return new SNodePointer("r:00000000-0000-4000-0000-011c89590515(jetbrains.mps.baseLanguage.regexp.constraints)", "3796137614137558194");
  }

  public boolean hasPresentation() {
    return true;
  }

  public String getPresentation(final IOperationContext operationContext, final PresentationReferentConstraintContext _context) {
    return (_context.getSmartReference() ?
      "\\" + SPropertyOperations.getString(_context.getParameterNode(), "name") :
      SPropertyOperations.getString(_context.getParameterNode(), "name")
    );
  }
}
