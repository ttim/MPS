package jetbrains.mps.baseLanguage.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.baseLanguage.constraints.IOperation_Behavior;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeof_InstanceMethodCallOperation_InferenceRule implements InferenceRule_Runtime {

  public  typeof_InstanceMethodCallOperation_InferenceRule() {
  }

  public void applyRule(final SNode imco) {
    if (SLinkOperations.getTarget(imco, "baseMethodDeclaration", false) == null) {
      return;
    }
    if (!(SLinkOperations.getCount(imco, "actualArgument") == SLinkOperations.getCount(SLinkOperations.getTarget(imco, "baseMethodDeclaration", false), "parameter"))) {
      TypeChecker.getInstance().reportTypeError(imco, "wrong number of parameters", "jetbrains.mps.baseLanguage.helgins", "1204064546506");
    }
    // ---
    final SNode methodClassifier = SNodeOperations.getAncestor(SLinkOperations.getTarget(imco, "baseMethodDeclaration", false), "jetbrains.mps.baseLanguage.structure.Classifier", false, false);
    final SNode instanceType_typevar_1204064731338 = TypeChecker.getInstance().getRuntimeSupport().createNewRuntimeTypesVariable(false);
    TypeChecker.getInstance().getRuntimeSupport().createEquation(TypeChecker.getInstance().getEquationManager().getRepresentator(instanceType_typevar_1204064731338), TypeChecker.getInstance().getRuntimeSupport().typeOf(IOperation_Behavior.call_getOperand_1197028596169(imco), "jetbrains.mps.baseLanguage.helgins", "1204064784351", false), IOperation_Behavior.call_getOperand_1197028596169(imco), null, "jetbrains.mps.baseLanguage.helgins", "1204064763142");
    TypeChecker.getInstance().getRuntimeSupport().createLessThanInequationStrong(TypeChecker.getInstance().getEquationManager().getRepresentator(instanceType_typevar_1204064731338), new QuotationClass_83().createNode(methodClassifier), imco, null, "jetbrains.mps.baseLanguage.helgins", "1204065906120", false);
    // --- following piece of cake is identical for any method call ---
    {
      final SNode _representatorVar4 = TypeChecker.getInstance().getEquationManager().getRepresentator(instanceType_typevar_1204064731338);
      TypeChecker.getInstance().getRuntimeSupport().whenConcrete(_representatorVar4, new Runnable() {

        public void run() {
          Map<SNode, List<SNode>> mmap = new HashMap<SNode, List<SNode>>();
          RulesFunctions_BaseLanguage.inference_equateParametersAndReturnType(imco, SLinkOperations.getTarget(SLinkOperations.getTarget(imco, "baseMethodDeclaration", false), "returnType", true), mmap);
          RulesFunctions_BaseLanguage.inference_matchConcreteTypesWithTypeVariables(methodClassifier, TypeChecker.getInstance().getEquationManager().getRepresentator(instanceType_typevar_1204064731338), mmap);
          RulesFunctions_BaseLanguage.inference_equateMatchingTypeVariables(mmap);
        }

      }, "jetbrains.mps.baseLanguage.helgins", "1204065986803");
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return true;
  }

}
