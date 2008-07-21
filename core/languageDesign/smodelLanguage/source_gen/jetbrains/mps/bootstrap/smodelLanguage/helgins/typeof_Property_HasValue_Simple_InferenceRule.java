package jetbrains.mps.bootstrap.smodelLanguage.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.bootstrap.smodelLanguage.behavior.SNodeOperation_Behavior;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.DataTypeUtil;
import jetbrains.mps.bootstrap.structureLanguage.structure.DataTypeDeclaration;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeof_Property_HasValue_Simple_InferenceRule implements InferenceRule_Runtime {

  public typeof_Property_HasValue_Simple_InferenceRule() {
  }

  public void applyRule(final SNode op) {
    RulesUtil.checkAppliedCorrectly_generic(op);
    {
      SNode _nodeToCheck_1029348928467 = op;
      BaseIntentionProvider intentionProvider = null;
      TypeChecker.getInstance().getRuntimeSupport().createEquation(TypeChecker.getInstance().getRuntimeSupport().typeOf(_nodeToCheck_1029348928467, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1203710488664", true), new QuotationClass_7().createNode(), _nodeToCheck_1029348928467, null, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1203710488662", intentionProvider);
    }
    SNode propertyAccessOp = SNodeOperation_Behavior.call_getLeftExpressionOperation_1213877508946(op);
    SNode dataType = SLinkOperations.getTarget(SLinkOperations.getTarget(propertyAccessOp, "property", false), "dataType", false);
    if (!((dataType != null))) {
      TypeChecker.getInstance().reportTypeError(op, "couldn't define accessed property datatype", "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1186059218089");
    }
    SNode value = SLinkOperations.getTarget(op, "value", true);
    if ((value != null)) {
      if (DataTypeUtil.isSimpleString(((DataTypeDeclaration)SNodeOperations.getAdapter(dataType)))) {
        {
          SNode _nodeToCheck_1029348928467 = value;
          BaseIntentionProvider intentionProvider = null;
          TypeChecker.getInstance().getRuntimeSupport().createLessThanInequation(TypeChecker.getInstance().getRuntimeSupport().typeOf(_nodeToCheck_1029348928467, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1186059218110", true), new QuotationClass_8().createNode(), _nodeToCheck_1029348928467, null, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1186059218105", false, 0, intentionProvider);
        }
      } else
      if (DataTypeUtil.isSimpleInteger(((DataTypeDeclaration)SNodeOperations.getAdapter(dataType)))) {
        {
          SNode _nodeToCheck_1029348928467 = value;
          BaseIntentionProvider intentionProvider = null;
          TypeChecker.getInstance().getRuntimeSupport().createLessThanInequation(TypeChecker.getInstance().getRuntimeSupport().typeOf(_nodeToCheck_1029348928467, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1186059218123", true), new QuotationClass_9().createNode(), _nodeToCheck_1029348928467, null, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1186059218118", false, 0, intentionProvider);
        }
      } else
      if (DataTypeUtil.isSimpleBoolean(((DataTypeDeclaration)SNodeOperations.getAdapter(dataType)))) {
        {
          SNode _nodeToCheck_1029348928467 = value;
          BaseIntentionProvider intentionProvider = null;
          TypeChecker.getInstance().getRuntimeSupport().createLessThanInequation(TypeChecker.getInstance().getRuntimeSupport().typeOf(_nodeToCheck_1029348928467, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1186059218136", true), new QuotationClass_10().createNode(), _nodeToCheck_1029348928467, null, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1186059218131", false, 0, intentionProvider);
        }
      } else
      {
        {
          BaseIntentionProvider intentionProvider = null;
          TypeChecker.getInstance().reportTypeError(op, "unknown property datatype: " + dataType, "jetbrains.mps.bootstrap.smodelLanguage.helgins@33_0", "1216638125797", intentionProvider);
        }
      }
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.bootstrap.smodelLanguage.structure.Property_HasValue_Simple";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return true;
  }

}
