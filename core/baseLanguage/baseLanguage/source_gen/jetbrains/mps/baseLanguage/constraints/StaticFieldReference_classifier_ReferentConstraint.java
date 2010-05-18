package jetbrains.mps.baseLanguage.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.BaseNodeReferenceSearchScopeProvider;
import jetbrains.mps.smodel.constraints.IModelConstraints;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.constraints.ReferentConstraintContext;
import jetbrains.mps.baseLanguage.search.VisibleClassifiersScope;
import jetbrains.mps.baseLanguage.search.IClassifiersSearchScope;
import org.jetbrains.annotations.NotNull;
import java.util.List;
import jetbrains.mps.baseLanguage.structure.Classifier;
import java.util.Set;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import java.util.HashSet;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import java.util.ArrayList;
import jetbrains.mps.baseLanguage.structure.AnonymousClass;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;

public class StaticFieldReference_classifier_ReferentConstraint extends BaseNodeReferenceSearchScopeProvider implements IModelConstraints {
  public StaticFieldReference_classifier_ReferentConstraint() {
  }

  public void registerSelf(ModelConstraintsManager manager) {
    manager.registerNodeReferentSearchScopeProvider("jetbrains.mps.baseLanguage.structure.StaticFieldReference", "classifier", this);
  }

  public void unRegisterSelf(ModelConstraintsManager manager) {
    manager.unRegisterNodeReferentSearchScopeProvider("jetbrains.mps.baseLanguage.structure.StaticFieldReference", "classifier");
  }

  public Object createSearchScopeOrListOfNodes(final IOperationContext operationContext, final ReferentConstraintContext _context) {
    return new VisibleClassifiersScope(_context.getEnclosingNode(), IClassifiersSearchScope.CLASSIFFIER, operationContext.getScope()) {
      @NotNull
      @Override
      public List<Classifier> getClassifiers() {
        Set<SNode> enclosingClassifierAncestors = SetSequence.fromSet(new HashSet<SNode>());
        SetSequence.fromSet(enclosingClassifierAncestors).addSequence(ListSequence.fromList(SNodeOperations.getAncestors(_context.getEnclosingNode(), "jetbrains.mps.baseLanguage.structure.Classifier", false)));

        List<Classifier> result = new ArrayList();
        for (Classifier classifier : ListSequence.fromList(super.getClassifiers())) {
          if (classifier.getNonStatic()) {
            continue;
          }
          if (classifier instanceof AnonymousClass) {
            continue;
          }
          List<SNode> ancestors = classifier.getNode().getAncestors(true);
          // Filtering out Classifiers located in third-party containers (not Classifiers) 
          // and having no common Classifier container with enclosing node. 
          // Useful for Classifiers contained in EditorTestCases 
          // ("result" should not be able to access classifiers from "nodeToEdit")... 
          if (ListSequence.fromList(ancestors).where(new IWhereFilter<SNode>() {
            public boolean accept(SNode it) {
              return !(SNodeOperations.isInstanceOf(it, "jetbrains.mps.baseLanguage.structure.Classifier"));
            }
          }).isNotEmpty() && ListSequence.fromList(ancestors).intersect(SetSequence.fromSet(enclosingClassifierAncestors)).isEmpty()) {
            continue;
          }
          result.add(classifier);
        }
        return result;
      }
    };
  }
}
