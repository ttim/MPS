package jetbrains.mps.nanoj.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.BaseNodeReferenceSearchScopeProvider;
import jetbrains.mps.smodel.constraints.IModelConstraints;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.constraints.ReferentConstraintContext;
import java.util.List;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.smodel.search.ISearchScope;
import jetbrains.mps.smodel.search.AbstractSearchScope;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.util.Condition;
import jetbrains.mps.smodel.SNodePointer;

public class VarDeclReference_declaration_ReferentConstraint extends BaseNodeReferenceSearchScopeProvider implements IModelConstraints {
  public VarDeclReference_declaration_ReferentConstraint() {
  }

  public void registerSelf(ModelConstraintsManager manager) {
    manager.registerNodeReferentSearchScopeProvider("jetbrains.mps.nanoj.structure.VarDeclReference", "declaration", this);
  }

  public void unRegisterSelf(ModelConstraintsManager manager) {
    manager.unRegisterNodeReferentSearchScopeProvider("jetbrains.mps.nanoj.structure.VarDeclReference", "declaration");
  }

  public Object createSearchScopeOrListOfNodes(final IOperationContext operationContext, final ReferentConstraintContext _context) {
    List<SNode> result = ListSequence.fromList(new ArrayList<SNode>());
    SNode currentStatement = SNodeOperations.getAncestor(_context.getEnclosingNode(), "jetbrains.mps.nanoj.structure.NanoStatement", true, false);
    while (currentStatement != null) {
      SNode currentBlock = SNodeOperations.getAncestorWhereConceptInList(currentStatement, new String[]{"jetbrains.mps.nanoj.structure.NanoStatementList"}, false, false);
      if ((currentBlock == null)) {
        break;
      }
      for (SNode statement : ListSequence.fromList(SNodeOperations.getChildren(currentBlock)).where(new IWhereFilter<SNode>() {
        public boolean accept(SNode it) {
          return SNodeOperations.isInstanceOf(it, "jetbrains.mps.nanoj.structure.NanoStatement");
        }
      })) {
        if (statement == currentStatement) {
          break;
        }
        ListSequence.fromList(result).addSequence(ListSequence.fromList(SNodeOperations.getDescendants(statement, null, false, new String[]{})));
      }
      currentStatement = SNodeOperations.getAncestor(currentBlock, "jetbrains.mps.nanoj.structure.NanoStatement", true, false);
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
    return new SNodePointer("r:00000000-0000-4000-0000-011c895905dc(jetbrains.mps.nanoj.constraints)", "689680155165915394");
  }
}
