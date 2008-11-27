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
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.smodel.search.SimpleSearchScope;

public class MatchVariableReference_match_ReferentConstraint extends BaseNodeReferenceSearchScopeProvider implements IModelConstraints {

  public MatchVariableReference_match_ReferentConstraint() {
  }

  public void registerSelf(ModelConstraintsManager manager) {
    manager.registerNodeReferentSearchScopeProvider("jetbrains.mps.baseLanguage.regexp.structure.MatchVariableReference", "match", this);
  }

  public void unRegisterSelf(ModelConstraintsManager manager) {
    manager.unRegisterNodeReferentSearchScopeProvider("jetbrains.mps.baseLanguage.regexp.structure.MatchVariableReference", "match");
  }

  public Object createSearchScopeOrListOfNodes(final IOperationContext operationContext, final ReferentConstraintContext _context) {
    List<SNode> matches = new ArrayList<SNode>();
    for(SNode ruc : SNodeOperations.getAncestors(_context.getEnclosingNode(), "jetbrains.mps.baseLanguage.regexp.structure.RegexpUsingConstruction", false)) {
      for(SNode ref : SNodeOperations.getDescendants(ruc, "jetbrains.mps.baseLanguage.regexp.structure.RegexpDeclarationReferenceRegexp", false)) {
        if (SLinkOperations.getTarget(ref, "regexp", false) != null) {
          for(SNode mpe : SNodeOperations.getDescendants(SLinkOperations.getTarget(ref, "regexp", false), "jetbrains.mps.baseLanguage.regexp.structure.MatchParensRegexp", false)) {
            ListSequence.fromList(matches).addElement(mpe);
          }
        }
      }
      for(SNode mpe : SNodeOperations.getDescendants(ruc, "jetbrains.mps.baseLanguage.regexp.structure.MatchParensRegexp", false)) {
        ListSequence.fromList(matches).addElement(mpe);
      }
    }
    return new SimpleSearchScope(matches);
  }

}
