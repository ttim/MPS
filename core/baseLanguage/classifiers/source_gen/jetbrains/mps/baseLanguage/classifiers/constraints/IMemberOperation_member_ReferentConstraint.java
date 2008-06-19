package jetbrains.mps.baseLanguage.classifiers.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.IModelConstraints;
import jetbrains.mps.smodel.constraints.INodeReferentSearchScopeProvider;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.constraints.ReferentConstraintContext;
import jetbrains.mps.smodel.search.ISearchScope;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import java.util.List;
import java.util.ArrayList;
import jetbrains.mps.patterns.IMatchingPattern;
import jetbrains.mps.bootstrap.helgins.runtime.HUtil;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.baseLanguage.classifiers.behavior.BaseClassifierType_Behavior;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.smodel.search.SimpleSearchScope;

public class IMemberOperation_member_ReferentConstraint implements IModelConstraints, INodeReferentSearchScopeProvider {

  public IMemberOperation_member_ReferentConstraint() {
  }

  public void registerSelf(ModelConstraintsManager manager) {
    manager.registerNodeReferentSearchScopeProvider("jetbrains.mps.baseLanguage.classifiers.structure.IMemberOperation", "member", this);
  }

  public void unRegisterSelf(ModelConstraintsManager manager) {
    manager.unRegisterNodeReferentSearchScopeProvider("jetbrains.mps.baseLanguage.classifiers.structure.IMemberOperation", "member");
  }

  public boolean canCreateNodeReferentSearchScope(final IOperationContext operationContext, final ReferentConstraintContext _context) {
    return true;
  }

  public ISearchScope createNodeReferentSearchScope(final IOperationContext operationContext, final ReferentConstraintContext _context) {
    SNode operand = SLinkOperations.getTarget(_context.getEnclosingNode(), "operand", true);
    List<SNode> applicableMembers = new ArrayList<SNode>();
    {
      IMatchingPattern pattern_ = HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.baseLanguage.classifiers.structure.BaseClassifierType");
      SNode coercedNode_ = TypeChecker.getInstance().getRuntimeSupport().coerce(TypeChecker.getInstance().getTypeOf(operand), pattern_);
      if (coercedNode_ != null) {
        for(SNode member : BaseClassifierType_Behavior.call_getMembers_1213877402148(coercedNode_, _context.getEnclosingNode())) {
          if (SNodeOperations.isInstanceOf(member, NameUtil.nodeFQName(_context.getLinkTarget()))) {
            ListSequence.fromList(applicableMembers).addElement(member);
          }
        }
      }
    }
    return new SimpleSearchScope(applicableMembers);
  }

  public String getNodeReferentSearchScopeDescription() {
    return "<no description>";
  }

}
