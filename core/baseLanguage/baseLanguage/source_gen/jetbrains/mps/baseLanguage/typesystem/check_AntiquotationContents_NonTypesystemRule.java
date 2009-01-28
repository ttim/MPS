package jetbrains.mps.baseLanguage.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractNonTypesystemRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.NonTypesystemRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.typesystem.inference.IErrorTarget;
import jetbrains.mps.typesystem.inference.NodeErrorTarget;
import jetbrains.mps.smodel.SModelUtil_new;

public class check_AntiquotationContents_NonTypesystemRule extends AbstractNonTypesystemRule_Runtime implements NonTypesystemRule_Runtime {

  public check_AntiquotationContents_NonTypesystemRule() {
  }

  public void applyRule(final SNode antiquotation, final TypeCheckingContext typeCheckingContext) {
    SNode contentsType = TypeChecker.getInstance().getTypeOf(SLinkOperations.getTarget(antiquotation, "expression", true));
    if (SNodeOperations.isInstanceOf(contentsType, "jetbrains.mps.lang.smodel.structure.SNodeType")) {
      if (SConceptOperations.isSubConceptOf(SLinkOperations.getTarget(contentsType, "concept", false), "jetbrains.mps.baseLanguage.structure.Classifier")) {
        {
          BaseIntentionProvider intentionProvider = null;
          intentionProvider = new BaseIntentionProvider("r:498ae934-e55c-4ef4-8232-fd0d8e936cf8(jetbrains.mps.baseLanguage.typesystem@17_0).ReplaceClassAntiquotationWithClassifierType_QuickFix");
          intentionProvider.putArgument("antiquotation", antiquotation);
          IErrorTarget errorTarget = new NodeErrorTarget();
          typeCheckingContext.reportWarning(SLinkOperations.getTarget(antiquotation, "expression", true), "Substitution of a classifier here is probably an error", "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.typesystem)", "1228301999219", intentionProvider, errorTarget);
        }
      }
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.lang.quotation.structure.Antiquotation";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

}
