package jetbrains.mps.baseLanguage.collections.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.baseLanguage.behavior.IOperation_Behavior;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.typesystem.inference.EquationInfo;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.SModelUtil_new;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.smodel.CopyUtil;
import jetbrains.mps.lang.typesystem.runtime.HUtil;

public class typeof_SubMapOperation_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {
  public typeof_SubMapOperation_InferenceRule() {
  }

  public void applyRule(final SNode operation, final TypeCheckingContext typeCheckingContext) {
    final SNode KEY_TYPE_typevar_1240240358091 = typeCheckingContext.createNewRuntimeTypesVariable();
    final SNode VALUE_TYPE_typevar_1240240358092 = typeCheckingContext.createNewRuntimeTypesVariable();
    {
      SNode _nodeToCheck_1029348928467 = IOperation_Behavior.call_getOperand_1213877410070(operation);
      BaseIntentionProvider intentionProvider = null;
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "1240240358093", 0, intentionProvider);
      _info_12389875345.setInequationGroup("default");
      typeCheckingContext.createLessThanInequation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "1240240358104", true), (SNode) new typeof_SubMapOperation_InferenceRule.QuotationClass_85e8rt_a0a2a0().createNode(typeCheckingContext.getEquationManager().getRepresentator(KEY_TYPE_typevar_1240240358091), typeCheckingContext.getEquationManager().getRepresentator(VALUE_TYPE_typevar_1240240358092), typeCheckingContext), false, _info_12389875345);
    }
    {
      SNode _nodeToCheck_1029348928467 = SLinkOperations.getTarget(operation, "fromKey", true);
      BaseIntentionProvider intentionProvider = null;
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "1240240358108", 0, intentionProvider);
      _info_12389875345.setInequationGroup("default");
      typeCheckingContext.createLessThanInequation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "1240240358112", true), (SNode) typeCheckingContext.getEquationManager().getRepresentator(KEY_TYPE_typevar_1240240358091), false, _info_12389875345);
    }
    {
      SNode _nodeToCheck_1029348928467 = SLinkOperations.getTarget(operation, "toKey", true);
      BaseIntentionProvider intentionProvider = null;
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "1240240364211", 0, intentionProvider);
      _info_12389875345.setInequationGroup("default");
      typeCheckingContext.createLessThanInequation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "1240240364215", true), (SNode) typeCheckingContext.getEquationManager().getRepresentator(KEY_TYPE_typevar_1240240358091), false, _info_12389875345);
    }
    {
      SNode _nodeToCheck_1029348928467 = operation;
      BaseIntentionProvider intentionProvider = null;
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "1240240358116", 0, intentionProvider);
      typeCheckingContext.createEquation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "1240240358118", true), (SNode) new typeof_SubMapOperation_InferenceRule.QuotationClass_85e8rt_a0a5a0().createNode(typeCheckingContext.getEquationManager().getRepresentator(KEY_TYPE_typevar_1240240358091), typeCheckingContext.getEquationManager().getRepresentator(VALUE_TYPE_typevar_1240240358092), typeCheckingContext), _info_12389875345);
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.collections.structure.SubMapOperation";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

  public static class QuotationClass_85e8rt_a0a2a0 {
    public QuotationClass_85e8rt_a0a2a0() {
    }

    public SNode createNode(Object parameter_85e8rt_a0a0a0c0a, Object parameter_85e8rt_a0a0a0c0a_0, final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_85e8rt_a0a2a0 = null;
      SNode quotedNode_85e8rt_a0a0c0a = null;
      SNode quotedNode_85e8rt_a0a0c0a_0 = null;
      {
        quotedNode_85e8rt_a0a2a0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.SortedMapType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_85e8rt_a0a2a0 = quotedNode_85e8rt_a0a2a0;
        {
          quotedNode_85e8rt_a0a0c0a = (SNode) parameter_85e8rt_a0a0a0c0a;
          SNode quotedNode1_85e8rt_a0a0c0a;
          if (_parameterValues_129834374.contains(quotedNode_85e8rt_a0a0c0a)) {
            quotedNode1_85e8rt_a0a0c0a = CopyUtil.copy(quotedNode_85e8rt_a0a0c0a);
          } else {
            _parameterValues_129834374.add(quotedNode_85e8rt_a0a0c0a);
            quotedNode1_85e8rt_a0a0c0a = quotedNode_85e8rt_a0a0c0a;
          }
          if (quotedNode1_85e8rt_a0a0c0a != null) {
            quotedNode_85e8rt_a0a2a0.addChild("keyType", HUtil.copyIfNecessary(quotedNode1_85e8rt_a0a0c0a, typeCheckingContext));
          }
        }
        {
          quotedNode_85e8rt_a0a0c0a_0 = (SNode) parameter_85e8rt_a0a0a0c0a_0;
          SNode quotedNode1_85e8rt_a0a0c0a_0;
          if (_parameterValues_129834374.contains(quotedNode_85e8rt_a0a0c0a_0)) {
            quotedNode1_85e8rt_a0a0c0a_0 = CopyUtil.copy(quotedNode_85e8rt_a0a0c0a_0);
          } else {
            _parameterValues_129834374.add(quotedNode_85e8rt_a0a0c0a_0);
            quotedNode1_85e8rt_a0a0c0a_0 = quotedNode_85e8rt_a0a0c0a_0;
          }
          if (quotedNode1_85e8rt_a0a0c0a_0 != null) {
            quotedNode_85e8rt_a0a2a0.addChild("valueType", HUtil.copyIfNecessary(quotedNode1_85e8rt_a0a0c0a_0, typeCheckingContext));
          }
        }
        result = quotedNode1_85e8rt_a0a2a0;
      }
      return result;
    }

    public SNode createNode(Object parameter_85e8rt_a0a0a0c0a, Object parameter_85e8rt_a0a0a0c0a_0) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_85e8rt_a0a2a0 = null;
      SNode quotedNode_85e8rt_a0a0c0a = null;
      SNode quotedNode_85e8rt_a0a0c0a_0 = null;
      {
        quotedNode_85e8rt_a0a2a0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.SortedMapType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_85e8rt_a0a2a0 = quotedNode_85e8rt_a0a2a0;
        {
          quotedNode_85e8rt_a0a0c0a = (SNode) parameter_85e8rt_a0a0a0c0a;
          SNode quotedNode1_85e8rt_a0a0c0a;
          if (_parameterValues_129834374.contains(quotedNode_85e8rt_a0a0c0a)) {
            quotedNode1_85e8rt_a0a0c0a = CopyUtil.copy(quotedNode_85e8rt_a0a0c0a);
          } else {
            _parameterValues_129834374.add(quotedNode_85e8rt_a0a0c0a);
            quotedNode1_85e8rt_a0a0c0a = quotedNode_85e8rt_a0a0c0a;
          }
          if (quotedNode1_85e8rt_a0a0c0a != null) {
            quotedNode_85e8rt_a0a2a0.addChild("keyType", HUtil.copyIfNecessary(quotedNode1_85e8rt_a0a0c0a));
          }
        }
        {
          quotedNode_85e8rt_a0a0c0a_0 = (SNode) parameter_85e8rt_a0a0a0c0a_0;
          SNode quotedNode1_85e8rt_a0a0c0a_0;
          if (_parameterValues_129834374.contains(quotedNode_85e8rt_a0a0c0a_0)) {
            quotedNode1_85e8rt_a0a0c0a_0 = CopyUtil.copy(quotedNode_85e8rt_a0a0c0a_0);
          } else {
            _parameterValues_129834374.add(quotedNode_85e8rt_a0a0c0a_0);
            quotedNode1_85e8rt_a0a0c0a_0 = quotedNode_85e8rt_a0a0c0a_0;
          }
          if (quotedNode1_85e8rt_a0a0c0a_0 != null) {
            quotedNode_85e8rt_a0a2a0.addChild("valueType", HUtil.copyIfNecessary(quotedNode1_85e8rt_a0a0c0a_0));
          }
        }
        result = quotedNode1_85e8rt_a0a2a0;
      }
      return result;
    }
  }

  public static class QuotationClass_85e8rt_a0a5a0 {
    public QuotationClass_85e8rt_a0a5a0() {
    }

    public SNode createNode(Object parameter_85e8rt_a0a0a0f0a, Object parameter_85e8rt_a0a0a0f0a_0, final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_85e8rt_a0a5a0 = null;
      SNode quotedNode_85e8rt_a0a0f0a = null;
      SNode quotedNode_85e8rt_a0a0f0a_0 = null;
      {
        quotedNode_85e8rt_a0a5a0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.SortedMapType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_85e8rt_a0a5a0 = quotedNode_85e8rt_a0a5a0;
        {
          quotedNode_85e8rt_a0a0f0a = (SNode) parameter_85e8rt_a0a0a0f0a;
          SNode quotedNode1_85e8rt_a0a0f0a;
          if (_parameterValues_129834374.contains(quotedNode_85e8rt_a0a0f0a)) {
            quotedNode1_85e8rt_a0a0f0a = CopyUtil.copy(quotedNode_85e8rt_a0a0f0a);
          } else {
            _parameterValues_129834374.add(quotedNode_85e8rt_a0a0f0a);
            quotedNode1_85e8rt_a0a0f0a = quotedNode_85e8rt_a0a0f0a;
          }
          if (quotedNode1_85e8rt_a0a0f0a != null) {
            quotedNode_85e8rt_a0a5a0.addChild("keyType", HUtil.copyIfNecessary(quotedNode1_85e8rt_a0a0f0a, typeCheckingContext));
          }
        }
        {
          quotedNode_85e8rt_a0a0f0a_0 = (SNode) parameter_85e8rt_a0a0a0f0a_0;
          SNode quotedNode1_85e8rt_a0a0f0a_0;
          if (_parameterValues_129834374.contains(quotedNode_85e8rt_a0a0f0a_0)) {
            quotedNode1_85e8rt_a0a0f0a_0 = CopyUtil.copy(quotedNode_85e8rt_a0a0f0a_0);
          } else {
            _parameterValues_129834374.add(quotedNode_85e8rt_a0a0f0a_0);
            quotedNode1_85e8rt_a0a0f0a_0 = quotedNode_85e8rt_a0a0f0a_0;
          }
          if (quotedNode1_85e8rt_a0a0f0a_0 != null) {
            quotedNode_85e8rt_a0a5a0.addChild("valueType", HUtil.copyIfNecessary(quotedNode1_85e8rt_a0a0f0a_0, typeCheckingContext));
          }
        }
        result = quotedNode1_85e8rt_a0a5a0;
      }
      return result;
    }

    public SNode createNode(Object parameter_85e8rt_a0a0a0f0a, Object parameter_85e8rt_a0a0a0f0a_0) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_85e8rt_a0a5a0 = null;
      SNode quotedNode_85e8rt_a0a0f0a = null;
      SNode quotedNode_85e8rt_a0a0f0a_0 = null;
      {
        quotedNode_85e8rt_a0a5a0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.SortedMapType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_85e8rt_a0a5a0 = quotedNode_85e8rt_a0a5a0;
        {
          quotedNode_85e8rt_a0a0f0a = (SNode) parameter_85e8rt_a0a0a0f0a;
          SNode quotedNode1_85e8rt_a0a0f0a;
          if (_parameterValues_129834374.contains(quotedNode_85e8rt_a0a0f0a)) {
            quotedNode1_85e8rt_a0a0f0a = CopyUtil.copy(quotedNode_85e8rt_a0a0f0a);
          } else {
            _parameterValues_129834374.add(quotedNode_85e8rt_a0a0f0a);
            quotedNode1_85e8rt_a0a0f0a = quotedNode_85e8rt_a0a0f0a;
          }
          if (quotedNode1_85e8rt_a0a0f0a != null) {
            quotedNode_85e8rt_a0a5a0.addChild("keyType", HUtil.copyIfNecessary(quotedNode1_85e8rt_a0a0f0a));
          }
        }
        {
          quotedNode_85e8rt_a0a0f0a_0 = (SNode) parameter_85e8rt_a0a0a0f0a_0;
          SNode quotedNode1_85e8rt_a0a0f0a_0;
          if (_parameterValues_129834374.contains(quotedNode_85e8rt_a0a0f0a_0)) {
            quotedNode1_85e8rt_a0a0f0a_0 = CopyUtil.copy(quotedNode_85e8rt_a0a0f0a_0);
          } else {
            _parameterValues_129834374.add(quotedNode_85e8rt_a0a0f0a_0);
            quotedNode1_85e8rt_a0a0f0a_0 = quotedNode_85e8rt_a0a0f0a_0;
          }
          if (quotedNode1_85e8rt_a0a0f0a_0 != null) {
            quotedNode_85e8rt_a0a5a0.addChild("valueType", HUtil.copyIfNecessary(quotedNode1_85e8rt_a0a0f0a_0));
          }
        }
        result = quotedNode1_85e8rt_a0a5a0;
      }
      return result;
    }
  }
}
