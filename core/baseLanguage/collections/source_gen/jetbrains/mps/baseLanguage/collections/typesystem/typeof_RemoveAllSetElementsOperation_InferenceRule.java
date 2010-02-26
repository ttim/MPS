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

public class typeof_RemoveAllSetElementsOperation_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {
  public typeof_RemoveAllSetElementsOperation_InferenceRule() {
  }

  public void applyRule(final SNode operation, final TypeCheckingContext typeCheckingContext) {
    final SNode elementType_typevar_1226594108923 = typeCheckingContext.createNewRuntimeTypesVariable();
    {
      SNode _nodeToCheck_1029348928467 = IOperation_Behavior.call_getOperand_1213877410070(operation);
      BaseIntentionProvider intentionProvider = null;
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "1226594108924", 0, intentionProvider);
      _info_12389875345.setInequationGroup("default");
      typeCheckingContext.createLessThanInequationStrong((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "1226594108932", true), (SNode) new typeof_RemoveAllSetElementsOperation_InferenceRule.QuotationClass_t2vuix_a0a1a0().createNode(typeCheckingContext.getEquationManager().getRepresentator(elementType_typevar_1226594108923), typeCheckingContext), false, _info_12389875345);
    }
    {
      SNode _nodeToCheck_1029348928467 = SLinkOperations.getTarget(operation, "argument", true);
      BaseIntentionProvider intentionProvider = null;
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "1226594108936", 0, intentionProvider);
      _info_12389875345.setInequationGroup("default");
      typeCheckingContext.createLessThanInequation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "1226594108944", true), (SNode) new typeof_RemoveAllSetElementsOperation_InferenceRule.QuotationClass_t2vuix_a0a2a0().createNode(typeCheckingContext.getEquationManager().getRepresentator(elementType_typevar_1226594108923), typeCheckingContext), false, _info_12389875345);
    }
    {
      SNode _nodeToCheck_1029348928467 = operation;
      BaseIntentionProvider intentionProvider = null;
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "1226594108949", 0, intentionProvider);
      typeCheckingContext.createEquation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "1226594108954", true), (SNode) new typeof_RemoveAllSetElementsOperation_InferenceRule.QuotationClass_t2vuix_a0a3a0().createNode(typeCheckingContext), _info_12389875345);
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.collections.structure.RemoveAllSetElementsOperation";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

  public static class QuotationClass_t2vuix_a0a1a0 {
    public QuotationClass_t2vuix_a0a1a0() {
    }

    public SNode createNode(Object parameter_t2vuix_a0a0a0b0a, final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_t2vuix_a0a1a0 = null;
      SNode quotedNode_t2vuix_a0a0b0a = null;
      {
        quotedNode_t2vuix_a0a1a0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.SetType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_t2vuix_a0a1a0 = quotedNode_t2vuix_a0a1a0;
        {
          quotedNode_t2vuix_a0a0b0a = (SNode) parameter_t2vuix_a0a0a0b0a;
          SNode quotedNode1_t2vuix_a0a0b0a;
          if (_parameterValues_129834374.contains(quotedNode_t2vuix_a0a0b0a)) {
            quotedNode1_t2vuix_a0a0b0a = CopyUtil.copy(quotedNode_t2vuix_a0a0b0a);
          } else {
            _parameterValues_129834374.add(quotedNode_t2vuix_a0a0b0a);
            quotedNode1_t2vuix_a0a0b0a = quotedNode_t2vuix_a0a0b0a;
          }
          if (quotedNode1_t2vuix_a0a0b0a != null) {
            quotedNode_t2vuix_a0a1a0.addChild("elementType", HUtil.copyIfNecessary(quotedNode1_t2vuix_a0a0b0a, typeCheckingContext));
          }
        }
        result = quotedNode1_t2vuix_a0a1a0;
      }
      return result;
    }

    public SNode createNode(Object parameter_t2vuix_a0a0a0b0a) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_t2vuix_a0a1a0 = null;
      SNode quotedNode_t2vuix_a0a0b0a = null;
      {
        quotedNode_t2vuix_a0a1a0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.SetType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_t2vuix_a0a1a0 = quotedNode_t2vuix_a0a1a0;
        {
          quotedNode_t2vuix_a0a0b0a = (SNode) parameter_t2vuix_a0a0a0b0a;
          SNode quotedNode1_t2vuix_a0a0b0a;
          if (_parameterValues_129834374.contains(quotedNode_t2vuix_a0a0b0a)) {
            quotedNode1_t2vuix_a0a0b0a = CopyUtil.copy(quotedNode_t2vuix_a0a0b0a);
          } else {
            _parameterValues_129834374.add(quotedNode_t2vuix_a0a0b0a);
            quotedNode1_t2vuix_a0a0b0a = quotedNode_t2vuix_a0a0b0a;
          }
          if (quotedNode1_t2vuix_a0a0b0a != null) {
            quotedNode_t2vuix_a0a1a0.addChild("elementType", HUtil.copyIfNecessary(quotedNode1_t2vuix_a0a0b0a));
          }
        }
        result = quotedNode1_t2vuix_a0a1a0;
      }
      return result;
    }
  }

  public static class QuotationClass_t2vuix_a0a2a0 {
    public QuotationClass_t2vuix_a0a2a0() {
    }

    public SNode createNode(Object parameter_t2vuix_a0a0a0c0a, final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_t2vuix_a0a2a0 = null;
      SNode quotedNode_t2vuix_a0a0c0a = null;
      {
        quotedNode_t2vuix_a0a2a0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.SequenceType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_t2vuix_a0a2a0 = quotedNode_t2vuix_a0a2a0;
        {
          quotedNode_t2vuix_a0a0c0a = (SNode) parameter_t2vuix_a0a0a0c0a;
          SNode quotedNode1_t2vuix_a0a0c0a;
          if (_parameterValues_129834374.contains(quotedNode_t2vuix_a0a0c0a)) {
            quotedNode1_t2vuix_a0a0c0a = CopyUtil.copy(quotedNode_t2vuix_a0a0c0a);
          } else {
            _parameterValues_129834374.add(quotedNode_t2vuix_a0a0c0a);
            quotedNode1_t2vuix_a0a0c0a = quotedNode_t2vuix_a0a0c0a;
          }
          if (quotedNode1_t2vuix_a0a0c0a != null) {
            quotedNode_t2vuix_a0a2a0.addChild("elementType", HUtil.copyIfNecessary(quotedNode1_t2vuix_a0a0c0a, typeCheckingContext));
          }
        }
        result = quotedNode1_t2vuix_a0a2a0;
      }
      return result;
    }

    public SNode createNode(Object parameter_t2vuix_a0a0a0c0a) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_t2vuix_a0a2a0 = null;
      SNode quotedNode_t2vuix_a0a0c0a = null;
      {
        quotedNode_t2vuix_a0a2a0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.SequenceType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_t2vuix_a0a2a0 = quotedNode_t2vuix_a0a2a0;
        {
          quotedNode_t2vuix_a0a0c0a = (SNode) parameter_t2vuix_a0a0a0c0a;
          SNode quotedNode1_t2vuix_a0a0c0a;
          if (_parameterValues_129834374.contains(quotedNode_t2vuix_a0a0c0a)) {
            quotedNode1_t2vuix_a0a0c0a = CopyUtil.copy(quotedNode_t2vuix_a0a0c0a);
          } else {
            _parameterValues_129834374.add(quotedNode_t2vuix_a0a0c0a);
            quotedNode1_t2vuix_a0a0c0a = quotedNode_t2vuix_a0a0c0a;
          }
          if (quotedNode1_t2vuix_a0a0c0a != null) {
            quotedNode_t2vuix_a0a2a0.addChild("elementType", HUtil.copyIfNecessary(quotedNode1_t2vuix_a0a0c0a));
          }
        }
        result = quotedNode1_t2vuix_a0a2a0;
      }
      return result;
    }
  }

  public static class QuotationClass_t2vuix_a0a3a0 {
    public QuotationClass_t2vuix_a0a3a0() {
    }

    public SNode createNode(final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_t2vuix_a0a3a0 = null;
      {
        quotedNode_t2vuix_a0a3a0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.VoidType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_t2vuix_a0a3a0 = quotedNode_t2vuix_a0a3a0;
        result = quotedNode1_t2vuix_a0a3a0;
      }
      return result;
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_t2vuix_a0a3a0 = null;
      {
        quotedNode_t2vuix_a0a3a0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.VoidType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_t2vuix_a0a3a0 = quotedNode_t2vuix_a0a3a0;
        result = quotedNode1_t2vuix_a0a3a0;
      }
      return result;
    }
  }
}
