package jetbrains.mps.bootstrap.smodelLanguage.helgins;

/*Generated by MPS  */

import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.bootstrap.helgins.structure.ApplicableNodeCondition;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelRepository;
import jetbrains.mps.smodel.SModelUID;
import jetbrains.mps.smodel.BaseAdapter;

public class typeof_SemanticDowncastExpression_InferenceRule implements InferenceRule_Runtime {

  public  typeof_SemanticDowncastExpression_InferenceRule() {
  }

  public void applyRule(SNode argument) {
    SNode leftExpr = SLinkOperations.getTarget(argument, "leftExpression", true);
    if(!(!((leftExpr == null)))) {
      TypeChecker.getInstance().reportTypeError(argument, "not expected here");
    }
    TypeChecker.getInstance().getRuntimeSupport().check(leftExpr);
    if(!(!((TypeChecker.getInstance().getRuntimeSupport().typeOf(leftExpr) == null)))) {
      TypeChecker.getInstance().reportTypeError(leftExpr, "no type");
    }
    do {
      SNode matchedNode_1178287491305 = TypeChecker.getInstance().getRuntimeSupport().typeOf(leftExpr);
      {
        boolean matches_1178287491308 = false;
        matches_1178287491308 = SModelUtil_new.isAssignableConcept(TypeChecker.getInstance().getRuntimeSupport().typeOf(leftExpr).getConceptFqName(), "jetbrains.mps.bootstrap.smodelLanguage.structure.SModelType");
        if(matches_1178287491308) {
          TypeChecker.getInstance().getRuntimeSupport().givetype(new QuotationClass_33().createNode(), argument);
          break;
        }
      }
      do {
        SNode matchedNode_1178287491317 = TypeChecker.getInstance().getRuntimeSupport().typeOf(leftExpr);
        {
          boolean matches_1178287491320 = false;
          matches_1178287491320 = SModelUtil_new.isAssignableConcept(TypeChecker.getInstance().getRuntimeSupport().typeOf(leftExpr).getConceptFqName(), "jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType");
          if(matches_1178287491320) {
            TypeChecker.getInstance().getRuntimeSupport().givetype(new QuotationClass_34().createNode(), argument);
            break;
          }
        }
      } while(false);
    } while(false);
  }
  public String getApplicableConceptFQName() {
    return "jetbrains.mps.bootstrap.smodelLanguage.structure.SemanticDowncastExpression";
  }
  public ApplicableNodeCondition getNodeCondition() {
    SModel model = SModelRepository.getInstance().getModelDescriptor(SModelUID.fromString("jetbrains.mps.bootstrap.smodelLanguage.helgins")).getSModel();
    return (ApplicableNodeCondition)BaseAdapter.fromNode(model.getNodeById("1178287490246"));
  }
  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }
  public boolean overrides() {
    return false;
  }
}
