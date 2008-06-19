package jetbrains.mps.baseLanguage.classifiers.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import java.util.Iterator;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeof_DefaultMethodCallOperation_InferenceRule implements InferenceRule_Runtime {

  public typeof_DefaultMethodCallOperation_InferenceRule() {
  }

  public void applyRule(final SNode nodeToCheck) {
    TypeChecker.getInstance().getRuntimeSupport().createEquation(TypeChecker.getInstance().getRuntimeSupport().typeOf(nodeToCheck, "jetbrains.mps.baseLanguage.classifiers.helgins", "1205769685435", true), SLinkOperations.getTarget(SLinkOperations.getTarget(nodeToCheck, "member", false), "returnType", true), nodeToCheck, null, "jetbrains.mps.baseLanguage.classifiers.helgins", "1205769679712");
    {
      SNode parameter;
      SNode argument;
      Iterator<SNode> parameter_iterator = SLinkOperations.getTargets(SLinkOperations.getTarget(nodeToCheck, "member", false), "parameter", true).iterator();
      Iterator<SNode> argument_iterator = SLinkOperations.getTargets(nodeToCheck, "actualArgument", true).iterator();
      while(true) {
        if (!(parameter_iterator.hasNext())) {
          break;
        }
        if (!(argument_iterator.hasNext())) {
          break;
        }
        parameter = parameter_iterator.next();
        argument = argument_iterator.next();
        TypeChecker.getInstance().getRuntimeSupport().createLessThanInequation(TypeChecker.getInstance().getRuntimeSupport().typeOf(argument, "jetbrains.mps.baseLanguage.classifiers.helgins", "1205854575356", true), SLinkOperations.getTarget(parameter, "type", true), argument, null, "jetbrains.mps.baseLanguage.classifiers.helgins", "1205854571586", false, 0);
      }
    }
    if (ListSequence.fromList(SLinkOperations.getTargets(SLinkOperations.getTarget(nodeToCheck, "member", false), "parameter", true)).count() != SLinkOperations.getCount(nodeToCheck, "actualArgument")) {
      {
        BaseIntentionProvider intentionProvider = null;
        TypeChecker.getInstance().reportTypeError(nodeToCheck, "Number of parameters doesn't match", "jetbrains.mps.baseLanguage.classifiers.helgins", "1205854659855", intentionProvider);
      }
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.classifiers.structure.DefaultClassifierMethodCallOperation";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

}
