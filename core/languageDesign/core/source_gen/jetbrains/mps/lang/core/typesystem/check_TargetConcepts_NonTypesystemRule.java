package jetbrains.mps.lang.core.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractNonTypesystemRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.NonTypesystemRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.typesystem.runtime.IsApplicableStatus;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.errors.BaseQuickFixProvider;
import jetbrains.mps.errors.messageTargets.MessageTarget;
import jetbrains.mps.errors.messageTargets.NodeMessageTarget;
import jetbrains.mps.errors.IErrorReporter;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.smodel.SModelUtil_new;

public class check_TargetConcepts_NonTypesystemRule extends AbstractNonTypesystemRule_Runtime implements NonTypesystemRule_Runtime {
  public check_TargetConcepts_NonTypesystemRule() {
  }

  public void applyRule(final SNode node, final TypeCheckingContext typeCheckingContext, IsApplicableStatus status) {
    /*
      for (SNode child : ListSequence.fromList(SNodeOperations.getChildren(node)).where(new IWhereFilter<SNode>() {
        public boolean accept(SNode it) {
          return !(SNodeOperations.isAttribute(it));
        }
      })) {
        SNode link = SNodeOperations.getContainingLinkDeclaration(child);
        if (link != null && SPropertyOperations.hasValue(link, "metaClass", "aggregation", "reference")) {
          if (!(SConceptOperations.isSuperConceptOf(SLinkOperations.getTarget(link, "target", false), NameUtil.nodeFQName(SNodeOperations.getConceptDeclaration(child))))) {
            {
              BaseQuickFixProvider intentionProvider = null;
              MessageTarget errorTarget = new NodeMessageTarget();
              IErrorReporter _reporter_2309309498 = typeCheckingContext.reportTypeError(node, "incompatible target concept in role \"" + SNodeOperations.getContainingLinkRole(child) + "\"", "r:cec599e3-51d2-48a7-af31-989e3cbd593c(jetbrains.mps.lang.core.typesystem)", "8536912951295757850", intentionProvider, errorTarget);
            }
          }
        }
      }

      for (SReference reference : Sequence.fromIterable(SNodeOperations.getReferences(node))) {
        SNode link = SLinkOperations.findLinkDeclaration(reference);
        if (link != null && SPropertyOperations.hasValue(link, "metaClass", "reference", "reference")) {
          SNode target = SLinkOperations.getTargetNode(reference);
          if (!(SConceptOperations.isSuperConceptOf(SLinkOperations.getTarget(link, "target", false), NameUtil.nodeFQName(SNodeOperations.getConceptDeclaration(target))))) {
            {
              BaseQuickFixProvider intentionProvider = null;
              MessageTarget errorTarget = new NodeMessageTarget();
              IErrorReporter _reporter_2309309498 = typeCheckingContext.reportTypeError(node, "incompatible target concept in role \"" + SLinkOperations.getRole(reference) + "\"", "r:cec599e3-51d2-48a7-af31-989e3cbd593c(jetbrains.mps.lang.core.typesystem)", "8536912951295757902", intentionProvider, errorTarget);
            }
          }
        }
      }
    */
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.lang.core.structure.BaseConcept";
  }

  public IsApplicableStatus isApplicableAndPattern(SNode argument) {
    {
      boolean b = SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
      return new IsApplicableStatus(b, null);
    }
  }

  public boolean overrides() {
    return false;
  }
}
