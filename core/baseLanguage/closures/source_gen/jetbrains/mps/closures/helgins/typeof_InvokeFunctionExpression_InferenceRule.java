package jetbrains.mps.closures.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import java.util.Iterator;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeof_InvokeFunctionExpression_InferenceRule implements InferenceRule_Runtime {

  public typeof_InvokeFunctionExpression_InferenceRule() {
  }

  public void applyRule(final SNode invoke) {
    {
      final SNode _representatorVar = TypeChecker.getInstance().getRuntimeSupport().typeOf(SLinkOperations.getTarget(invoke, "function", true), "jetbrains.mps.closures.helgins", "1199567116884", true);
      TypeChecker.getInstance().getRuntimeSupport().whenConcrete(_representatorVar, new Runnable() {

        public void run() {
          SNode ft = TypeChecker.getInstance().getRuntimeSupport().typeOf(SLinkOperations.getTarget(invoke, "function", true), "jetbrains.mps.closures.helgins", "1199567532549", true);
          TypeChecker.getInstance().getRuntimeSupport().createEquation(TypeChecker.getInstance().getRuntimeSupport().typeOf(invoke, "jetbrains.mps.closures.helgins", "1199711684834", true), SLinkOperations.getTarget(ft, "resultType", true), invoke, null, "jetbrains.mps.closures.helgins", "1199711681931");
          if (!(SLinkOperations.getCount(ft, "parameterType") == SLinkOperations.getCount(invoke, "parameter"))) {
            TypeChecker.getInstance().reportTypeError(invoke, "Wrong parameters number", "jetbrains.mps.closures.helgins", "1199568419784");
          }
          {
            SNode pt;
            SNode p;
            Iterator<SNode> pt_iterator = SLinkOperations.getTargets(ft, "parameterType", true).iterator();
            Iterator<SNode> p_iterator = SLinkOperations.getTargets(invoke, "parameter", true).iterator();
            while(true) {
              if (!(pt_iterator.hasNext())) {
                break;
              }
              if (!(p_iterator.hasNext())) {
                break;
              }
              pt = pt_iterator.next();
              p = p_iterator.next();
              TypeChecker.getInstance().getRuntimeSupport().createLessThanInequation(TypeChecker.getInstance().getRuntimeSupport().typeOf(p, "jetbrains.mps.closures.helgins", "1202920138888", true), pt, p, null, "jetbrains.mps.closures.helgins", "1202920135673", false, 0);
            }
          }
        }

      }, "jetbrains.mps.closures.helgins", "1199567113016");
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.closures.structure.InvokeFunctionExpression";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

}
