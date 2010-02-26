package jetbrains.mps.baseLanguage.collections.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.baseLanguage.behavior.IOperation_Behavior;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.typesystem.inference.EquationInfo;
import jetbrains.mps.smodel.SModelUtil_new;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.smodel.CopyUtil;
import jetbrains.mps.lang.typesystem.runtime.HUtil;

public class typeof_HasNextOperation_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {
  public typeof_HasNextOperation_InferenceRule() {
  }

  public void applyRule(final SNode hasNext, final TypeCheckingContext typeCheckingContext) {
    final SNode elementType_typevar_1237470988790 = typeCheckingContext.createNewRuntimeTypesVariable();
    {
      SNode _nodeToCheck_1029348928467 = IOperation_Behavior.call_getOperand_1213877410070(hasNext);
      BaseIntentionProvider intentionProvider = null;
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "1237470975923", 0, intentionProvider);
      _info_12389875345.setInequationGroup("default");
      typeCheckingContext.createLessThanInequationStrong((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "1237470932214", true), (SNode) new typeof_HasNextOperation_InferenceRule.QuotationClass_jfdsz3_a0a1a0().createNode(typeCheckingContext.getEquationManager().getRepresentator(elementType_typevar_1237470988790), typeCheckingContext), false, _info_12389875345);
    }
    {
      SNode _nodeToCheck_1029348928467 = hasNext;
      BaseIntentionProvider intentionProvider = null;
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "1237471013663", 0, intentionProvider);
      typeCheckingContext.createEquation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "1237471009307", true), (SNode) new typeof_HasNextOperation_InferenceRule.QuotationClass_jfdsz3_a0a2a0().createNode(typeCheckingContext), _info_12389875345);
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.collections.structure.HasNextOperation";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

  public static class QuotationClass_jfdsz3_a0a1a0 {
    public QuotationClass_jfdsz3_a0a1a0() {
    }

    public SNode createNode(Object parameter_jfdsz3_a0a0a0b0a, final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_jfdsz3_a0a1a0 = null;
      SNode quotedNode_jfdsz3_a0a0b0a = null;
      {
        quotedNode_jfdsz3_a0a1a0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.IteratorType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_jfdsz3_a0a1a0 = quotedNode_jfdsz3_a0a1a0;
        {
          quotedNode_jfdsz3_a0a0b0a = (SNode) parameter_jfdsz3_a0a0a0b0a;
          SNode quotedNode1_jfdsz3_a0a0b0a;
          if (_parameterValues_129834374.contains(quotedNode_jfdsz3_a0a0b0a)) {
            quotedNode1_jfdsz3_a0a0b0a = CopyUtil.copy(quotedNode_jfdsz3_a0a0b0a);
          } else {
            _parameterValues_129834374.add(quotedNode_jfdsz3_a0a0b0a);
            quotedNode1_jfdsz3_a0a0b0a = quotedNode_jfdsz3_a0a0b0a;
          }
          if (quotedNode1_jfdsz3_a0a0b0a != null) {
            quotedNode_jfdsz3_a0a1a0.addChild("elementType", HUtil.copyIfNecessary(quotedNode1_jfdsz3_a0a0b0a, typeCheckingContext));
          }
        }
        result = quotedNode1_jfdsz3_a0a1a0;
      }
      return result;
    }

    public SNode createNode(Object parameter_jfdsz3_a0a0a0b0a) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_jfdsz3_a0a1a0 = null;
      SNode quotedNode_jfdsz3_a0a0b0a = null;
      {
        quotedNode_jfdsz3_a0a1a0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.IteratorType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_jfdsz3_a0a1a0 = quotedNode_jfdsz3_a0a1a0;
        {
          quotedNode_jfdsz3_a0a0b0a = (SNode) parameter_jfdsz3_a0a0a0b0a;
          SNode quotedNode1_jfdsz3_a0a0b0a;
          if (_parameterValues_129834374.contains(quotedNode_jfdsz3_a0a0b0a)) {
            quotedNode1_jfdsz3_a0a0b0a = CopyUtil.copy(quotedNode_jfdsz3_a0a0b0a);
          } else {
            _parameterValues_129834374.add(quotedNode_jfdsz3_a0a0b0a);
            quotedNode1_jfdsz3_a0a0b0a = quotedNode_jfdsz3_a0a0b0a;
          }
          if (quotedNode1_jfdsz3_a0a0b0a != null) {
            quotedNode_jfdsz3_a0a1a0.addChild("elementType", HUtil.copyIfNecessary(quotedNode1_jfdsz3_a0a0b0a));
          }
        }
        result = quotedNode1_jfdsz3_a0a1a0;
      }
      return result;
    }
  }

  public static class QuotationClass_jfdsz3_a0a2a0 {
    public QuotationClass_jfdsz3_a0a2a0() {
    }

    public SNode createNode(final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_jfdsz3_a0a2a0 = null;
      {
        quotedNode_jfdsz3_a0a2a0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.BooleanType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_jfdsz3_a0a2a0 = quotedNode_jfdsz3_a0a2a0;
        result = quotedNode1_jfdsz3_a0a2a0;
      }
      return result;
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_jfdsz3_a0a2a0 = null;
      {
        quotedNode_jfdsz3_a0a2a0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.BooleanType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_jfdsz3_a0a2a0 = quotedNode_jfdsz3_a0a2a0;
        result = quotedNode1_jfdsz3_a0a2a0;
      }
      return result;
    }
  }
}
