package jetbrains.mps.ui.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.typesystem.runtime.IsApplicableStatus;
import jetbrains.mps.ui.behavior.IUIObjectContextProvider_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.typesystem.inference.EquationInfo;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.SModelUtil_new;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.project.GlobalScope;

public class typeof_IterateContentsVariable_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {
  public typeof_IterateContentsVariable_InferenceRule() {
  }

  public void applyRule(final SNode icvar, final TypeCheckingContext typeCheckingContext, IsApplicableStatus status) {
    SNode oexp = IUIObjectContextProvider_Behavior.call_getContextExpression_8923564134258345446(SNodeOperations.getAncestor(icvar, "jetbrains.mps.ui.structure.IUIObjectContextProvider", false, false));
    if ((oexp != null)) {
      final SNode UIOT_typevar_2459884175397753215 = typeCheckingContext.createNewRuntimeTypesVariable();
      {
        SNode _nodeToCheck_1029348928467 = oexp;
        BaseIntentionProvider intentionProvider = null;
        EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:f2d87002-eac7-4f98-addf-b2caa99c13a5(jetbrains.mps.ui.typesystem)", "2459884175397753205", 0, intentionProvider);
        _info_12389875345.setInequationGroup("default");
        typeCheckingContext.createLessThanInequation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:f2d87002-eac7-4f98-addf-b2caa99c13a5(jetbrains.mps.ui.typesystem)", "2459884175397753198", true), (SNode) new typeof_IterateContentsVariable_InferenceRule.QuotationClass_dmnw7g_a0a1a1a0().createNode(typeCheckingContext.getEquationManager().getRepresentator(UIOT_typevar_2459884175397753215), typeCheckingContext), false, _info_12389875345);
      }
      {
        SNode _nodeToCheck_1029348928467 = icvar;
        BaseIntentionProvider intentionProvider = null;
        EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:f2d87002-eac7-4f98-addf-b2caa99c13a5(jetbrains.mps.ui.typesystem)", "2459884175397753220", 0, intentionProvider);
        typeCheckingContext.createEquation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:f2d87002-eac7-4f98-addf-b2caa99c13a5(jetbrains.mps.ui.typesystem)", "2459884175397753227", true), (SNode) new typeof_IterateContentsVariable_InferenceRule.QuotationClass_dmnw7g_a0a2a1a0().createNode(typeCheckingContext.getEquationManager().getRepresentator(UIOT_typevar_2459884175397753215), typeCheckingContext), _info_12389875345);
      }
    } else {
      SNode uio = SLinkOperations.getTarget(IUIObjectContextProvider_Behavior.call_getContainer_8923564134258257521(SNodeOperations.getAncestor(icvar, "jetbrains.mps.ui.structure.IUIObjectContextProvider", false, false)), "allows", false);
      {
        SNode _nodeToCheck_1029348928467 = icvar;
        BaseIntentionProvider intentionProvider = null;
        EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:f2d87002-eac7-4f98-addf-b2caa99c13a5(jetbrains.mps.ui.typesystem)", "2459884175397578629", 0, intentionProvider);
        typeCheckingContext.createEquation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:f2d87002-eac7-4f98-addf-b2caa99c13a5(jetbrains.mps.ui.typesystem)", "2459884175397578626", true), (SNode) new typeof_IterateContentsVariable_InferenceRule.QuotationClass_dmnw7g_a0a1a0b0a().createNode(uio, typeCheckingContext), _info_12389875345);
      }
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.ui.structure.IterateContentsVariable";
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

  public static class QuotationClass_dmnw7g_a0a1a1a0 {
    public QuotationClass_dmnw7g_a0a1a1a0() {
    }

    public SNode createNode(Object parameter_3, final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.ui.structure.ContainerType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.setReferent("uiObject", (SNode) parameter_3);
        result = quotedNode1_2;
      }
      return result;
    }

    public SNode createNode(Object parameter_3) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.ui.structure.ContainerType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.setReferent("uiObject", (SNode) parameter_3);
        result = quotedNode1_2;
      }
      return result;
    }
  }

  public static class QuotationClass_dmnw7g_a0a2a1a0 {
    public QuotationClass_dmnw7g_a0a2a1a0() {
    }

    public SNode createNode(Object parameter_3, final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.ui.structure.UIObjectType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.setReferent("uiObject", (SNode) parameter_3);
        result = quotedNode1_2;
      }
      return result;
    }

    public SNode createNode(Object parameter_3) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.ui.structure.UIObjectType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.setReferent("uiObject", (SNode) parameter_3);
        result = quotedNode1_2;
      }
      return result;
    }
  }

  public static class QuotationClass_dmnw7g_a0a1a0b0a {
    public QuotationClass_dmnw7g_a0a1a0b0a() {
    }

    public SNode createNode(Object parameter_3, final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.ui.structure.UIObjectType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.setReferent("uiObject", (SNode) parameter_3);
        result = quotedNode1_2;
      }
      return result;
    }

    public SNode createNode(Object parameter_3) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.ui.structure.UIObjectType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.setReferent("uiObject", (SNode) parameter_3);
        result = quotedNode1_2;
      }
      return result;
    }
  }
}
