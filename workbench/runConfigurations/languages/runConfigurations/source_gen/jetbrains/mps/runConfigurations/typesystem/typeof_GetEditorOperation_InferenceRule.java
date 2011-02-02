package jetbrains.mps.runConfigurations.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.typesystem.runtime.IsApplicableStatus;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.errors.BaseQuickFixProvider;
import jetbrains.mps.typesystem.inference.EquationInfo;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.lang.typesystem.runtime.HUtil;
import jetbrains.mps.smodel.SModelUtil_new;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.project.GlobalScope;

public class typeof_GetEditorOperation_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {
  public typeof_GetEditorOperation_InferenceRule() {
  }

  public void applyRule(final SNode getEditorOperation, final TypeCheckingContext typeCheckingContext, IsApplicableStatus status) {
    {
      SNode _nodeToCheck_1029348928467 = SLinkOperations.getTarget(SNodeOperations.cast(SNodeOperations.getParent(getEditorOperation), "jetbrains.mps.baseLanguage.structure.DotExpression"), "operand", true);
      BaseQuickFixProvider intentionProvider = null;
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:8b43a830-217d-43d8-a0f8-6460c443f22d(jetbrains.mps.runConfigurations.typesystem)", "7902226081039521647", 0, intentionProvider);
      _info_12389875345.setInequationGroup("default");
      typeCheckingContext.createLessThanInequationStrong((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:8b43a830-217d-43d8-a0f8-6460c443f22d(jetbrains.mps.runConfigurations.typesystem)", "7902226081039521649", true), (SNode) new typeof_GetEditorOperation_InferenceRule.QuotationClass_89tbzo_a0a0a0().createNode(typeCheckingContext), false, _info_12389875345);
    }
    final SNode operand = SLinkOperations.getTarget(SNodeOperations.cast(SNodeOperations.getParent(getEditorOperation), "jetbrains.mps.baseLanguage.structure.DotExpression"), "operand", true);
    SNode configurationType = TypeChecker.getInstance().getRuntimeSupport().coerce_(typeCheckingContext.typeOf(operand, "r:8b43a830-217d-43d8-a0f8-6460c443f22d(jetbrains.mps.runConfigurations.typesystem)", "8937610127654552078", true), HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.runConfigurations.structure.PersistentConfigurationType"), true, typeCheckingContext);
    {
      SNode _nodeToCheck_1029348928467 = getEditorOperation;
      BaseQuickFixProvider intentionProvider = null;
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:8b43a830-217d-43d8-a0f8-6460c443f22d(jetbrains.mps.runConfigurations.typesystem)", "4624732408193248516", 0, intentionProvider);
      typeCheckingContext.createEquation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:8b43a830-217d-43d8-a0f8-6460c443f22d(jetbrains.mps.runConfigurations.typesystem)", "4624732408193248525", true), (SNode) new typeof_GetEditorOperation_InferenceRule.QuotationClass_89tbzo_a0a3a0().createNode(check_89tbzo_a0a0a3a0(configurationType), typeCheckingContext), _info_12389875345);
    }

  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.runConfigurations.structure.GetEditorOperation";
  }

  public IsApplicableStatus isApplicableAndPattern(SNode argument) {
    {
      boolean b = SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
      return new IsApplicableStatus(b, null);
    }
  }

  public boolean overrides() {
    return false;
  }

  private static SNode check_89tbzo_a0a0a3a0(SNode checkedDotOperand) {
    if (null != checkedDotOperand) {
      return SLinkOperations.getTarget(checkedDotOperand, "persistentConfiguration", false);
    }
    return null;
  }

  public static class QuotationClass_89tbzo_a0a0a0 {
    public QuotationClass_89tbzo_a0a0a0() {
    }

    public SNode createNode(final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.runConfigurations.structure.PersistentConfigurationType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        result = quotedNode1_2;
      }
      return result;
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.runConfigurations.structure.PersistentConfigurationType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        result = quotedNode1_2;
      }
      return result;
    }
  }

  public static class QuotationClass_89tbzo_a0a3a0 {
    public QuotationClass_89tbzo_a0a3a0() {
    }

    public SNode createNode(Object parameter_3, final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.runConfigurations.structure.SettingsEditorType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.setReferent("configuration", (SNode) parameter_3);
        result = quotedNode1_2;
      }
      return result;
    }

    public SNode createNode(Object parameter_3) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.runConfigurations.structure.SettingsEditorType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.setReferent("configuration", (SNode) parameter_3);
        result = quotedNode1_2;
      }
      return result;
    }
  }
}
