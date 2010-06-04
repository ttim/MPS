package jetbrains.mps.lang.behavior.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.BaseNodeReferenceSearchScopeProvider;
import jetbrains.mps.smodel.constraints.IModelConstraints;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.constraints.ReferentConstraintContext;
import java.util.List;
import jetbrains.mps.smodel.SNode;
import java.util.ArrayList;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.smodel.search.ISearchScope;
import jetbrains.mps.smodel.search.AbstractSearchScope;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.util.Condition;
import jetbrains.mps.smodel.SNodePointer;

public class SuperNodeExpression_superConcept_ReferentConstraint extends BaseNodeReferenceSearchScopeProvider implements IModelConstraints {
  public SuperNodeExpression_superConcept_ReferentConstraint() {
  }

  public void registerSelf(ModelConstraintsManager manager) {
    manager.registerNodeReferentSearchScopeProvider("jetbrains.mps.lang.behavior.structure.SuperNodeExpression", "superConcept", this);
  }

  public void unRegisterSelf(ModelConstraintsManager manager) {
    manager.unRegisterNodeReferentSearchScopeProvider("jetbrains.mps.lang.behavior.structure.SuperNodeExpression", "superConcept");
  }

  public Object createSearchScopeOrListOfNodes(final IOperationContext operationContext, final ReferentConstraintContext _context) {
    List<SNode> result = new ArrayList<SNode>();
    SNode abstractConceptDeclaration = SLinkOperations.getTarget(SNodeOperations.getAncestor(_context.getReferenceNode(), "jetbrains.mps.lang.behavior.structure.ConceptBehavior", false, false), "concept", false);
    if (SNodeOperations.isInstanceOf(abstractConceptDeclaration, "jetbrains.mps.lang.structure.structure.ConceptDeclaration")) {
      SNode cd = (SNode) abstractConceptDeclaration;
      SNode extendsNode = SLinkOperations.getTarget(cd, "extends", false);
      if (extendsNode != null) {
        ListSequence.fromList(result).addElement(extendsNode);
      }
      for (SNode itfcRef : SLinkOperations.getTargets(cd, "implements", true)) {
        ListSequence.fromList(result).addElement(SLinkOperations.getTarget(itfcRef, "intfc", false));
      }
    }
    if (SNodeOperations.isInstanceOf(abstractConceptDeclaration, "jetbrains.mps.lang.structure.structure.InterfaceConceptDeclaration")) {
      SNode itfc = (SNode) abstractConceptDeclaration;
      for (SNode itfcRef : SLinkOperations.getTargets(itfc, "extends", true)) {
        ListSequence.fromList(result).addElement(SLinkOperations.getTarget(itfcRef, "intfc", false));
      }
    }
    return result;
  }

  public ISearchScope createNodeReferentSearchScope(final IOperationContext operationContext, final ReferentConstraintContext _context) {
    return new AbstractSearchScope() {
      @NotNull
      public List<SNode> getNodes(Condition<SNode> condition) {
        Iterable<SNode> seq = (Iterable<SNode>) createSearchScopeOrListOfNodes(operationContext, _context);
        List<SNode> result = new ArrayList<SNode>();
        if (seq != null) {
          for (SNode node : seq) {
            if (condition.met(node)) {
              result.add(node);
            }
          }
        }
        return result;
      }
    };
  }

  public SNodePointer getSearchScopeValidatorNodePointer() {
    return new SNodePointer("r:6786d6ee-e5cc-4a77-9efd-65a8dca8b187(jetbrains.mps.lang.behavior.constraints)", "5299096511375909194");
  }
}
