package jetbrains.mps.lang.generator.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.typesystem.inference.IErrorTarget;
import jetbrains.mps.typesystem.inference.NodeErrorTarget;
import jetbrains.mps.typesystem.inference.EquationInfo;
import jetbrains.mps.lang.generator.behavior.BaseMappingRule_Behavior;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeof_BaseMappingRule_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {
  public typeof_BaseMappingRule_InferenceRule() {
  }

  public void applyRule(final SNode nodeToCheck, final TypeCheckingContext typeCheckingContext) {
    if (SLinkOperations.getTarget(SLinkOperations.getTarget(nodeToCheck, "labelDeclaration", false), "sourceConcept", false) != null) {
      if (!(SConceptOperations.isSuperConceptOf(SLinkOperations.getTarget(SLinkOperations.getTarget(nodeToCheck, "labelDeclaration", false), "sourceConcept", false), NameUtil.nodeFQName(SLinkOperations.getTarget(nodeToCheck, "applicableConcept", false))))) {
        {
          BaseIntentionProvider intentionProvider = null;
          IErrorTarget errorTarget = new NodeErrorTarget();
          typeCheckingContext.reportTypeError(nodeToCheck, "Label has incorrect type", "r:00000000-0000-4000-0000-011c895902e4(jetbrains.mps.lang.generator.typesystem)", "1203556587912", intentionProvider, errorTarget);
        }
      }
      {
        SNode _nodeToCheck_1029348928467 = nodeToCheck;
        BaseIntentionProvider intentionProvider = null;
        EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902e4(jetbrains.mps.lang.generator.typesystem)", "1200922039515", 0, intentionProvider);
        _info_12389875345.setInequationGroup("default");
        typeCheckingContext.createLessThanInequationStrong((SNode)new _Quotations.QuotationClass_2().createNode(BaseMappingRule_Behavior.call_getTemplateType_1213877498511(nodeToCheck), typeCheckingContext), (SNode)new _Quotations.QuotationClass_1().createNode(SLinkOperations.getTarget(SLinkOperations.getTarget(nodeToCheck, "labelDeclaration", false), "targetConcept", false), typeCheckingContext), false, _info_12389875345);
      }
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.lang.generator.structure.BaseMappingRule";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }
}
