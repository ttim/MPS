package jetbrains.mps.baseLanguage.collections.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractNonTypesystemRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.NonTypesystemRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.pattern.IMatchingPattern;
import jetbrains.mps.lang.typesystem.runtime.HUtil;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.typesystem.inference.IErrorTarget;
import jetbrains.mps.typesystem.inference.NodeErrorTarget;
import jetbrains.mps.smodel.SModelUtil_new;

public class check_container_creator_not_primitive_array_NonTypesystemRule extends AbstractNonTypesystemRule_Runtime implements NonTypesystemRule_Runtime {
  public check_container_creator_not_primitive_array_NonTypesystemRule() {
  }

  public void applyRule(final SNode acc, final TypeCheckingContext typeCheckingContext) {
    {
      IMatchingPattern pattern_1 = HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.baseLanguage.structure.ArrayType");
      SNode coercedNode_1 = TypeChecker.getInstance().getRuntimeSupport().coerce_(TypeChecker.getInstance().getTypeOf(SLinkOperations.getTarget(acc, "copyFrom", true)), pattern_1, typeCheckingContext);
      if (coercedNode_1 != null) {
        if (!(!(SNodeOperations.isInstanceOf(SLinkOperations.getTarget(coercedNode_1, "componentType", true), "jetbrains.mps.baseLanguage.structure.PrimitiveType")))) {
          BaseIntentionProvider intentionProvider = null;
          IErrorTarget errorTarget = new NodeErrorTarget();
          typeCheckingContext.reportTypeError(SLinkOperations.getTarget(acc, "copyFrom", true), "Primitive arrays not supported", "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "1240320024069", intentionProvider, errorTarget);
        }
      } else {
      }
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.collections.structure.AbstractContainerCreator";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }
}
