package jetbrains.mps.baseLanguage.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.baseLanguage.behavior.IOperation_Behavior;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import jetbrains.mps.util.Pair;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeof_FieldReferenceOperation_InferenceRule implements InferenceRule_Runtime {

  public typeof_FieldReferenceOperation_InferenceRule() {
  }

  public void applyRule(final SNode fieldReference) {
    final SNode fieldDeclaration = SLinkOperations.getTarget(fieldReference, "fieldDeclaration", false);
    if ((fieldDeclaration == null)) {
      return;
    }
    final SNode InstanceType_typevar_1206554174334 = TypeChecker.getInstance().getRuntimeSupport().createNewRuntimeTypesVariable();
    {
      SNode _nodeToCheck_1029348928467 = fieldReference;
      BaseIntentionProvider intentionProvider = null;
      TypeChecker.getInstance().getRuntimeSupport().createEquation(TypeChecker.getInstance().getRuntimeSupport().typeOf(IOperation_Behavior.call_getOperand_1213877410070(fieldReference), "jetbrains.mps.baseLanguage.helgins", "1206554174339", true), TypeChecker.getInstance().getEquationManager().getRepresentator(InstanceType_typevar_1206554174334), _nodeToCheck_1029348928467, null, "jetbrains.mps.baseLanguage.helgins", "1206554174335", intentionProvider);
    }
    final SNode fieldClassifier = SNodeOperations.getAncestor(fieldDeclaration, "jetbrains.mps.baseLanguage.structure.Classifier", false, false);
    {
      SNode _nodeToCheck_1029348928467 = fieldReference;
      BaseIntentionProvider intentionProvider = null;
      TypeChecker.getInstance().getRuntimeSupport().createLessThanInequationStrong(TypeChecker.getInstance().getEquationManager().getRepresentator(InstanceType_typevar_1206554174334), new QuotationClass_73().createNode(fieldClassifier), _nodeToCheck_1029348928467, null, "jetbrains.mps.baseLanguage.helgins", "1206554174350", false, 0, intentionProvider);
    }
    {
      final SNode IT = TypeChecker.getInstance().getEquationManager().getRepresentator(InstanceType_typevar_1206554174334);
      TypeChecker.getInstance().getRuntimeSupport().whenConcrete(IT, new Runnable() {

        public void run() {
          Map<SNode, List<SNode>> mmap = new HashMap<SNode, List<SNode>>();
          Pair<SNode, Map<SNode, List<SNode>>> pair;
          SNode matchedType = RulesFunctions_BaseLanguage.inference_matchTypeWithTypeVariables(SLinkOperations.getTarget(fieldDeclaration, "type", true), mmap);
          {
            SNode _nodeToCheck_1029348928467 = fieldReference;
            BaseIntentionProvider intentionProvider = null;
            TypeChecker.getInstance().getRuntimeSupport().createEquation(TypeChecker.getInstance().getRuntimeSupport().typeOf(fieldReference, "jetbrains.mps.baseLanguage.helgins", "1206554174385", true), matchedType, _nodeToCheck_1029348928467, null, "jetbrains.mps.baseLanguage.helgins", "1206554174383", intentionProvider);
          }
          RulesFunctions_BaseLanguage.inference_matchConcreteTypesWithTypeVariables(fieldClassifier, TypeChecker.getInstance().getEquationManager().getRepresentator(InstanceType_typevar_1206554174334), mmap);
          RulesFunctions_BaseLanguage.inference_equateMatchingTypeVariables(mmap);
        }

      }, "jetbrains.mps.baseLanguage.helgins@3_0", "1221141294370");
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.structure.FieldReferenceOperation";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

}
