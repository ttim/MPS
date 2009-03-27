package jetbrains.mps.baseLanguage.classifiers.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.BaseNodeReferenceSearchScopeProvider;
import jetbrains.mps.smodel.constraints.IModelConstraints;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.constraints.ReferentConstraintContext;
import java.util.List;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.baseLanguage.classifiers.behavior.IClassifier_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;

public class DefaultClassifierType_classifier_ReferentConstraint extends BaseNodeReferenceSearchScopeProvider implements IModelConstraints {

  public DefaultClassifierType_classifier_ReferentConstraint() {
  }

  public void registerSelf(ModelConstraintsManager manager) {
    manager.registerNodeReferentSearchScopeProvider("jetbrains.mps.baseLanguage.classifiers.structure.DefaultClassifierType", "classifier", this);
  }

  public void unRegisterSelf(ModelConstraintsManager manager) {
    manager.unRegisterNodeReferentSearchScopeProvider("jetbrains.mps.baseLanguage.classifiers.structure.DefaultClassifierType", "classifier");
  }

  public Object createSearchScopeOrListOfNodes(final IOperationContext operationContext, final ReferentConstraintContext _context) {
    List<SNode> classifiers = SModelOperations.getRootsIncludingImported(_context.getModel(), operationContext.getScope(), "jetbrains.mps.baseLanguage.classifiers.structure.IClassifier");
    classifiers = ListSequence.fromList(classifiers).where(new IWhereFilter <SNode>() {

      public boolean accept(SNode it) {
        return SNodeOperations.getConceptDeclaration(IClassifier_Behavior.call_createType_1213877527970(it)) == SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.classifiers.structure.DefaultClassifierType");
      }
    }).toListSequence();
    return classifiers;
  }

}
