package jetbrains.mps.closures.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.InequationReplacementRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.helgins.inference.EquationInfo;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.helgins.inference.TypeChecker;
import java.util.Iterator;
import jetbrains.mps.smodel.SModelUtil_new;

public class FunctionType_subtypeOf_FunctionType_InequationReplacementRule extends InequationReplacementRule_Runtime {

  public FunctionType_subtypeOf_FunctionType_InequationReplacementRule() {
  }

  public void processInequation(SNode subtype, SNode supertype, EquationInfo equationInfo) {
    if (SLinkOperations.getCount(subtype, "parameterType") != SLinkOperations.getCount(supertype, "parameterType")) {
      TypeChecker.getInstance().reportTypeError(equationInfo.getNodeWithError(), "different parameter numbers", "jetbrains.mps.closures.helgins", "1201618945543");
      return;
    }
    TypeChecker.getInstance().getRuntimeSupport().createLessThanInequation(SLinkOperations.getTarget(subtype, "resultType", true), SLinkOperations.getTarget(supertype, "resultType", true), equationInfo.getNodeWithError(), null, "jetbrains.mps.closures.helgins", "1201614892741", false);
    {
      SNode paramType1;
      SNode paramType2;
      Iterator<SNode> paramType1_iterator = SLinkOperations.getTargets(subtype, "parameterType", true).iterator();
      Iterator<SNode> paramType2_iterator = SLinkOperations.getTargets(supertype, "parameterType", true).iterator();
      while(true) {
        if (!(paramType1_iterator.hasNext())) {
          break;
        }
        if (!(paramType2_iterator.hasNext())) {
          break;
        }
        paramType1 = paramType1_iterator.next();
        paramType2 = paramType2_iterator.next();
        TypeChecker.getInstance().getRuntimeSupport().createLessThanInequation(paramType2, paramType1, equationInfo.getNodeWithError(), null, "jetbrains.mps.closures.helgins", "1201614990748", false);
      }
    }
  }

  public boolean isWeak() {
    return true;
  }

  public boolean isApplicableSubtype(SNode node) {
    return SModelUtil_new.isAssignableConcept(node.getConceptFqName(), this.getApplicableSubtypeConceptFQName());
  }

  public boolean isApplicableSupertype(SNode node) {
    return SModelUtil_new.isAssignableConcept(node.getConceptFqName(), this.getApplicableSupertypeConceptFQName());
  }

  public String getApplicableSubtypeConceptFQName() {
    return "jetbrains.mps.closures.structure.FunctionType";
  }

  public String getApplicableSupertypeConceptFQName() {
    return "jetbrains.mps.closures.structure.FunctionType";
  }

}
