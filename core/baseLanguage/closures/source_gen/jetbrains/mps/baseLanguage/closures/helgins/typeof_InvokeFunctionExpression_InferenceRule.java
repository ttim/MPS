package jetbrains.mps.baseLanguage.closures.helgins;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.intentions.BaseIntentionProvider;
import java.util.Iterator;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeof_InvokeFunctionExpression_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {

  public typeof_InvokeFunctionExpression_InferenceRule() {
  }

  public void applyRule(final SNode invoke, final TypeCheckingContext typeCheckingContext) {
    {
      final SNode _representatorVar0 = typeCheckingContext.typeOf(SLinkOperations.getTarget(invoke, "function", true), "r:00000000-0000-4000-0000-011c89590337(jetbrains.mps.baseLanguage.closures.helgins)", "1199567116884", true);
      typeCheckingContext.whenConcrete(_representatorVar0, new Runnable() {

        public void run() {
          SNode ft = typeCheckingContext.typeOf(SLinkOperations.getTarget(invoke, "function", true), "r:00000000-0000-4000-0000-011c89590337(jetbrains.mps.baseLanguage.closures.helgins)", "1199567532549", true);
          {
            SNode _nodeToCheck_1029348928467 = invoke;
            BaseIntentionProvider intentionProvider = null;
            typeCheckingContext.createEquation(typeCheckingContext.typeOf(invoke, "r:00000000-0000-4000-0000-011c89590337(jetbrains.mps.baseLanguage.closures.helgins)", "1199711684834", true), SLinkOperations.getTarget(ft, "resultType", true), _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c89590337(jetbrains.mps.baseLanguage.closures.helgins)", "1199711681931", intentionProvider);
          }
          if (!(SLinkOperations.getCount(ft, "parameterType") == SLinkOperations.getCount(invoke, "parameter"))) {
            BaseIntentionProvider intentionProvider = null;
            typeCheckingContext.reportTypeError(invoke, "Wrong parameters number", "r:00000000-0000-4000-0000-011c89590337(jetbrains.mps.baseLanguage.closures.helgins)", "1199568419784", intentionProvider);
          }
          {
            SNode pt;
            SNode p;
            Iterator<SNode> pt_iterator = SLinkOperations.getTargets(ft, "parameterType", true).iterator();
            Iterator<SNode> p_iterator = SLinkOperations.getTargets(invoke, "parameter", true).iterator();
            while (true) {
              if (!(pt_iterator.hasNext())) {
                break;
              }
              if (!(p_iterator.hasNext())) {
                break;
              }
              pt = pt_iterator.next();
              p = p_iterator.next();
              {
                SNode _nodeToCheck_1029348928467 = invoke;
                BaseIntentionProvider intentionProvider = null;
                typeCheckingContext.createLessThanInequation(typeCheckingContext.typeOf(p, "r:00000000-0000-4000-0000-011c89590337(jetbrains.mps.baseLanguage.closures.helgins)", "1202920138888", true), pt, _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c89590337(jetbrains.mps.baseLanguage.closures.helgins)", "1202920135673", false, 0, intentionProvider);
              }
            }
          }
        }

      }, "r:00000000-0000-4000-0000-011c89590337(jetbrains.mps.baseLanguage.closures.helgins)", "1199567113016");
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.closures.structure.InvokeFunctionExpression";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

}
