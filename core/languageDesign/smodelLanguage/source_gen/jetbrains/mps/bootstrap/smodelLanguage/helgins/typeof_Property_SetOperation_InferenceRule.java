package jetbrains.mps.bootstrap.smodelLanguage.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.bootstrap.smodelLanguage.behavior.SNodeOperation_Behavior;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.bootstrap.structureLanguage.behavior.DataTypeDeclaration_Behavior;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeof_Property_SetOperation_InferenceRule implements InferenceRule_Runtime {

  public typeof_Property_SetOperation_InferenceRule() {
  }

  public void applyRule(final SNode op) {
    RulesUtil.checkAppliedCorrectly_generic(op);
    SNode propertyAccessOp = SNodeOperation_Behavior.call_getLeftExpressionOperation_1213877508946(op);
    SNode dataType = SLinkOperations.getTarget(SLinkOperations.getTarget(propertyAccessOp, "property", false), "dataType", false);
    if (!((dataType != null))) {
      TypeChecker.getInstance().reportTypeError(op, "couldn't define accessed property datatype", "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1186059295963");
    }
    SNode value = SLinkOperations.getTarget(op, "value", true);
    if ((value != null)) {
      if (DataTypeDeclaration_Behavior.call_isSimpleString_1220268704138(dataType)) {
        {
          SNode _nodeToCheck_1029348928467 = op;
          BaseIntentionProvider intentionProvider = null;
          TypeChecker.getInstance().getRuntimeSupport().createLessThanInequation(TypeChecker.getInstance().getRuntimeSupport().typeOf(value, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1186059295984", true), new QuotationClass_3().createNode(), _nodeToCheck_1029348928467, null, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1186059295979", false, 0, intentionProvider);
        }
      } else
      if (DataTypeDeclaration_Behavior.call_isSimpleInteger_1220268868375(dataType)) {
        {
          SNode _nodeToCheck_1029348928467 = op;
          BaseIntentionProvider intentionProvider = null;
          TypeChecker.getInstance().getRuntimeSupport().createLessThanInequation(TypeChecker.getInstance().getRuntimeSupport().typeOf(value, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1186059295997", true), new QuotationClass_4().createNode(), _nodeToCheck_1029348928467, null, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1186059295992", false, 0, intentionProvider);
        }
      } else
      if (DataTypeDeclaration_Behavior.call_isSimpleBoolean_1220268891062(dataType)) {
        {
          SNode _nodeToCheck_1029348928467 = op;
          BaseIntentionProvider intentionProvider = null;
          TypeChecker.getInstance().getRuntimeSupport().createLessThanInequation(TypeChecker.getInstance().getRuntimeSupport().typeOf(value, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1186059296010", true), new QuotationClass_5().createNode(), _nodeToCheck_1029348928467, null, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1186059296005", false, 0, intentionProvider);
        }
      } else
      if (DataTypeDeclaration_Behavior.call_isEnum_1220268692373(dataType)) {
        if (!(SNodeOperations.isInstanceOf(value, "jetbrains.mps.bootstrap.smodelLanguage.structure.EnumMemberReference"))) {
          if (DataTypeDeclaration_Behavior.call_isEnumOfInteger_1220268950942(dataType)) {
            {
              SNode _nodeToCheck_1029348928467 = op;
              BaseIntentionProvider intentionProvider = null;
              TypeChecker.getInstance().getRuntimeSupport().createLessThanInequation(TypeChecker.getInstance().getRuntimeSupport().typeOf(value, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1214430014542", true), new QuotationClass_93().createNode(), _nodeToCheck_1029348928467, null, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1214430014537", false, 0, intentionProvider);
            }
          } else
          if (DataTypeDeclaration_Behavior.call_isEnumOfBoolean_1220268971570(dataType)) {
            {
              SNode _nodeToCheck_1029348928467 = op;
              BaseIntentionProvider intentionProvider = null;
              TypeChecker.getInstance().getRuntimeSupport().createLessThanInequation(TypeChecker.getInstance().getRuntimeSupport().typeOf(value, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1214430042918", true), new QuotationClass_94().createNode(), _nodeToCheck_1029348928467, null, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1214430042913", false, 0, intentionProvider);
            }
          } else
          {
            {
              SNode _nodeToCheck_1029348928467 = op;
              BaseIntentionProvider intentionProvider = null;
              TypeChecker.getInstance().getRuntimeSupport().createLessThanInequation(TypeChecker.getInstance().getRuntimeSupport().typeOf(value, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1186059478775", true), new QuotationClass_6().createNode(), _nodeToCheck_1029348928467, null, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1186059478770", false, 0, intentionProvider);
            }
          }
        }
      } else
      {
        {
          BaseIntentionProvider intentionProvider = null;
          TypeChecker.getInstance().reportTypeError(op, "unknown property datatype: " + dataType, "jetbrains.mps.bootstrap.smodelLanguage.helgins@3_0", "1220882335290", intentionProvider);
        }
      }
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.bootstrap.smodelLanguage.structure.Property_SetOperation";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return true;
  }

}
