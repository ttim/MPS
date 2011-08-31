package jetbrains.mps.ide.modelchecker.actions;

/*Generated by MPS */

import java.util.List;
import jetbrains.mps.ide.findusages.model.SearchResult;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.IVisitor;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.internal.collections.runtime.Sequence;

@Deprecated
public class ConstraintsChecker extends SpecificChecker {
  @Deprecated
  public ConstraintsChecker() {
  }

  public List<SearchResult<ModelCheckerIssue>> checkModel(SModel model, ProgressContext progressContext, IOperationContext operationContext) {
    List<SearchResult<ModelCheckerIssue>> results = ListSequence.<SearchResult<ModelCheckerIssue>>fromList(new ArrayList<SearchResult<ModelCheckerIssue>>());

    for (final SNode node : ListSequence.<SNode>fromList(SModelOperations.getNodes(model, null))) {
      if (!(progressContext.checkAndUpdateIndicator("Checking " + SModelOperations.getModelName(model) + " for cardinalities and properties constraints..."))) {
        break;
      }
      SNode concept = SNodeOperations.getConceptDeclaration(node);

      // Check links 
      for (final SNode link : ListSequence.<SNode>fromList(((List<SNode>) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(concept, "jetbrains.mps.lang.structure.structure.AbstractConceptDeclaration"), "call_getLinkDeclarations_1213877394480", new Class[]{SNode.class})))) {
        if (((Boolean) BehaviorManager.getInstance().invoke(Boolean.class, SNodeOperations.cast(link, "jetbrains.mps.lang.structure.structure.LinkDeclaration"), "call_isAtLeastOneCardinality_3386205146660812199", new Class[]{SNode.class}))) {
          if (SPropertyOperations.hasValue(link, "metaClass", "aggregation", "reference")) {
            if (ListSequence.<SNode>fromList(SNodeOperations.getChildren(node, link)).isEmpty()) {
              addIssue(results, node, "No children in role \"" + SPropertyOperations.getString(link, "role") + "\" (declared cardinality is " + SPropertyOperations.getString_def(link, "sourceCardinality", "0..1") + ")", ModelChecker.SEVERITY_ERROR, "cardinality", null);
            }
          } else {
            if ((SLinkOperations.getTargetNode(SNodeOperations.getReference(node, link)) == null)) {
              addIssue(results, node, "No reference in role \"" + SPropertyOperations.getString(link, "role") + "\" (declared cardinality is 1)", ModelChecker.SEVERITY_ERROR, "cardinality", null);
            }
          }
        } else if (((Boolean) BehaviorManager.getInstance().invoke(Boolean.class, SNodeOperations.cast(link, "jetbrains.mps.lang.structure.structure.LinkDeclaration"), "call_isSingular_1213877254557", new Class[]{SNode.class}))) {
          if (ListSequence.<SNode>fromList(SNodeOperations.getChildren(node, link)).count() > 1) {
            addIssue(results, node, ListSequence.<SNode>fromList(SNodeOperations.getChildren(node, link)).count() + " children in role \"" + SPropertyOperations.getString(link, "role") + "\" (declared cardinality is " + SPropertyOperations.getString_def(link, "sourceCardinality", "0..1") + ")", ModelChecker.SEVERITY_ERROR, "cardinality", new IModelCheckerFix() {
              public boolean doFix() {
                ListSequence.<SNode>fromList(SNodeOperations.getChildren(node, link)).skip(1).toListSequence().visitAll(new IVisitor<SNode>() {
                  public void visit(SNode child) {
                    SNodeOperations.deleteNode(child);
                  }
                });
                return true;
              }
            });
          }
        }
      }

      for (final SNode child : ListSequence.<SNode>fromList(SNodeOperations.getChildren(node)).where(new IWhereFilter<SNode>() {
        public boolean accept(SNode it) {
          return !(SNodeOperations.isAttribute(it));
        }
      })) {
        if (!(ModelCheckerUtils.isDeclaredLink(SNodeOperations.getContainingLinkDeclaration(child), true))) {
          addIssue(results, node, "Usage of undeclared child role \"" + SNodeOperations.getContainingLinkRole(child) + "\"", ModelChecker.SEVERITY_WARNING, "undeclared child", new IModelCheckerFix() {
            public boolean doFix() {
              ListSequence.<SNode>fromList(SNodeOperations.getChildren(node, SNodeOperations.getContainingLinkDeclaration(child))).visitAll(new IVisitor<SNode>() {
                public void visit(SNode child) {
                  SNodeOperations.deleteNode(child);
                }
              });
              return true;
            }
          });
        }
      }

      for (final SReference reference : Sequence.<SReference>fromIterable(SNodeOperations.getReferences(node))) {
        if (!(ModelCheckerUtils.isDeclaredLink(SLinkOperations.findLinkDeclaration(reference), false))) {
          addIssue(results, node, "Usage of undeclared reference role \"" + reference + "\"", ModelChecker.SEVERITY_WARNING, "undeclared reference", new IModelCheckerFix() {
            public boolean doFix() {
              node.removeReferent(SLinkOperations.getRole(reference));
              return true;
            }
          });
        }
      }
    }

    return results;
  }
}
