package jetbrains.mps.baseLanguage.tuples.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.BaseNodeReferenceSearchScopeProvider;
import jetbrains.mps.smodel.constraints.IModelConstraints;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.constraints.ReferentConstraintContext;
import jetbrains.mps.baseLanguage.search.VisibleClassifiersScope;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.baseLanguage.search.IClassifiersSearchScope;
import java.util.List;
import jetbrains.mps.smodel.INodeAdapter;
import jetbrains.mps.baseLanguage.structure.Classifier;
import jetbrains.mps.util.Condition;
import java.util.ArrayList;
import jetbrains.mps.baseLanguage.tuples.structure.NamedTupleDeclaration;
import jetbrains.mps.smodel.SNodePointer;

public class NamedTupleType_tupleDeclaration_ReferentConstraint extends BaseNodeReferenceSearchScopeProvider implements IModelConstraints {
  public NamedTupleType_tupleDeclaration_ReferentConstraint() {
  }

  public void registerSelf(ModelConstraintsManager manager) {
    manager.registerNodeReferentSearchScopeProvider("jetbrains.mps.baseLanguage.tuples.structure.NamedTupleType", "classifier", this);
  }

  public void unRegisterSelf(ModelConstraintsManager manager) {
    manager.unRegisterNodeReferentSearchScopeProvider("jetbrains.mps.baseLanguage.tuples.structure.NamedTupleType", "classifier");
  }

  public Object createSearchScopeOrListOfNodes(final IOperationContext operationContext, final ReferentConstraintContext _context) {
    return new VisibleClassifiersScope(SNodeOperations.getModel(_context.getEnclosingNode()), IClassifiersSearchScope.ANYTHING, operationContext.getScope()) {
      protected List<INodeAdapter> getNodesFormClassifiersList(List<Classifier> classifiers, int constraint, Condition<INodeAdapter> condition) {
        List<INodeAdapter> result = new ArrayList<INodeAdapter>();
        for (Classifier classifier : classifiers) {
          if (classifier instanceof NamedTupleDeclaration) {
            result.add(classifier);
          }
        }
        return result;
      }
    };
  }

  public SNodePointer getSearchScopeFactoryNodePointer() {
    return new SNodePointer("r:3d04bd03-b6d9-4be1-8a52-d7b756e1d85b(jetbrains.mps.baseLanguage.tuples.constraints)", "1652220223504359703");
  }
}
