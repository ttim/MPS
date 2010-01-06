package jetbrains.mps.baseLanguage.javadoc.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.BaseNodeReferenceSearchScopeProvider;
import jetbrains.mps.smodel.constraints.IModelConstraints;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.constraints.ReferentConstraintContext;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.project.GlobalScope;

public class MethodDocReference_methodDeclaration_ReferentConstraint extends BaseNodeReferenceSearchScopeProvider implements IModelConstraints {
  public MethodDocReference_methodDeclaration_ReferentConstraint() {
  }

  public void registerSelf(ModelConstraintsManager manager) {
    manager.registerNodeReferentSearchScopeProvider("jetbrains.mps.baseLanguage.javadoc.structure.MethodDocReference", "methodDeclaration", this);
  }

  public void unRegisterSelf(ModelConstraintsManager manager) {
    manager.unRegisterNodeReferentSearchScopeProvider("jetbrains.mps.baseLanguage.javadoc.structure.MethodDocReference", "methodDeclaration");
  }

  public Object createSearchScopeOrListOfNodes(final IOperationContext operationContext, final ReferentConstraintContext _context) {
    return ListSequence.fromList(SModelOperations.getNodesIncludingImported(_context.getModel(), operationContext.getScope(), "jetbrains.mps.baseLanguage.structure.BaseMethodDeclaration")).removeWhere(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return SNodeOperations.isInstanceOf(it, "jetbrains.mps.baseLanguage.structure.IVisible") && SLinkOperations.getTarget(SNodeOperations.cast(it, "jetbrains.mps.baseLanguage.structure.IVisible"), "visibility", true) == new MethodDocReference_methodDeclaration_ReferentConstraint.QuotationClass_1607_0().createNode();
      }
    });
  }

  public static class QuotationClass_1607_0 {
    public QuotationClass_1607_0() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_2 = null;
      {
        quotedNode_2 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.PrivateVisibility", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_2;
        result = quotedNode1_2;
      }
      return result;
    }
  }
}
