package jetbrains.mps.baseLanguage.math.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.BaseNodeReferenceSearchScopeProvider;
import jetbrains.mps.smodel.constraints.IModelConstraints;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.constraints.ReferentConstraintContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import java.util.List;
import jetbrains.mps.baseLanguage.math.behavior.MathSymbol_Behavior;
import jetbrains.mps.smodel.search.ISearchScope;
import jetbrains.mps.smodel.search.AbstractSearchScope;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.util.Condition;
import java.util.ArrayList;
import jetbrains.mps.smodel.SNodePointer;

public class MathSymbolIndexReference_indexRef_ReferentConstraint extends BaseNodeReferenceSearchScopeProvider implements IModelConstraints {
  public MathSymbolIndexReference_indexRef_ReferentConstraint() {
  }

  public void registerSelf(ModelConstraintsManager manager) {
    manager.registerNodeReferentSearchScopeProvider("jetbrains.mps.baseLanguage.math.structure.MathSymbolIndexReference", "indexRef", this);
  }

  public void unRegisterSelf(ModelConstraintsManager manager) {
    manager.unRegisterNodeReferentSearchScopeProvider("jetbrains.mps.baseLanguage.math.structure.MathSymbolIndexReference", "indexRef");
  }

  public Object createSearchScopeOrListOfNodes(final IOperationContext operationContext, final ReferentConstraintContext _context) {
    SNode ms = SNodeOperations.getAncestor(_context.getEnclosingNode(), "jetbrains.mps.baseLanguage.math.structure.MathSymbol", true, false);
    List<SNode> msi = MathSymbol_Behavior.call_getEmptyIndexList_1237828382992(ms);
    MathSymbol_Behavior.call_getVisibleIndices_1236440390782(ms, _context.getEnclosingNode(), msi);
    return msi;
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
    return new SNodePointer("r:d37b3f1e-89c7-4936-a6de-207bf5ae7643(jetbrains.mps.baseLanguage.math.constraints)", "1237825752099");
  }
}
