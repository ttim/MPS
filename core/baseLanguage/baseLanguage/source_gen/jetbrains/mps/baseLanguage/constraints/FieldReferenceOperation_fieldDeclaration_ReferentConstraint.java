package jetbrains.mps.baseLanguage.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.BaseNodeReferenceSearchScopeProvider;
import jetbrains.mps.smodel.constraints.IModelConstraints;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.constraints.ReferentConstraintContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.lang.typesystem.runtime.HUtil;
import jetbrains.mps.baseLanguage.search.ClassifierVisibleMembersScope;
import jetbrains.mps.baseLanguage.structure.ClassifierType;
import jetbrains.mps.baseLanguage.search.IClassifiersSearchScope;

public class FieldReferenceOperation_fieldDeclaration_ReferentConstraint extends BaseNodeReferenceSearchScopeProvider implements IModelConstraints {

  public FieldReferenceOperation_fieldDeclaration_ReferentConstraint() {
  }

  public void registerSelf(ModelConstraintsManager manager) {
    manager.registerNodeReferentSearchScopeProvider("jetbrains.mps.baseLanguage.structure.FieldReferenceOperation", "fieldDeclaration", this);
  }

  public void unRegisterSelf(ModelConstraintsManager manager) {
    manager.unRegisterNodeReferentSearchScopeProvider("jetbrains.mps.baseLanguage.structure.FieldReferenceOperation", "fieldDeclaration");
  }

  public Object createSearchScopeOrListOfNodes(final IOperationContext operationContext, final ReferentConstraintContext _context) {
    //     fields declared in hierarhy of class specified by left expression. only applicable to expressions of classifier-type
    SNode instance = SLinkOperations.getTarget(SNodeOperations.cast(_context.getEnclosingNode(), "jetbrains.mps.baseLanguage.structure.DotExpression"), "operand", true);
    SNode classifierType = TypeChecker.getInstance().getRuntimeSupport().coerce_(TypeChecker.getInstance().getTypeOf(instance), HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.baseLanguage.structure.ClassifierType"), false);
    return new ClassifierVisibleMembersScope(((ClassifierType)SNodeOperations.getAdapter(classifierType)), _context.getEnclosingNode(), IClassifiersSearchScope.INSTANCE_FIELD);
  }

}
