package jetbrains.mps.baseLanguage.collections.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
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

public class typeof_GetIndexOfOperation_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {
  public typeof_GetIndexOfOperation_InferenceRule() {
  }

  public void applyRule(final SNode op, final TypeCheckingContext typeCheckingContext) {
    SNode input = RulesFunctions_Collections.getInput(typeCheckingContext, op);
    final SNode elementType_typevar_1184856779488 = typeCheckingContext.createNewRuntimeTypesVariable();
    {
      SNode _nodeToCheck_1029348928467 = input;
      BaseIntentionProvider intentionProvider = null;
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "1184856768419", 0, intentionProvider);
      _info_12389875345.setInequationGroup("default");
      typeCheckingContext.createLessThanInequation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "1184856761975", true), (SNode) new typeof_GetIndexOfOperation_InferenceRule.QuotationClass_aycuzy_a0a2a0().createNode(typeCheckingContext.getEquationManager().getRepresentator(elementType_typevar_1184856779488), typeCheckingContext), false, _info_12389875345);
    }
    {
      SNode _nodeToCheck_1029348928467 = SLinkOperations.getTarget(op, "argument", true);
      BaseIntentionProvider intentionProvider = null;
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "1184856809408", 0, intentionProvider);
      _info_12389875345.setInequationGroup("default");
      typeCheckingContext.createLessThanInequation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "1184856800100", true), (SNode) typeCheckingContext.getEquationManager().getRepresentator(elementType_typevar_1184856779488), false, _info_12389875345);
    }
    {
      SNode _nodeToCheck_1029348928467 = op;
      BaseIntentionProvider intentionProvider = null;
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "1184856713865", 0, intentionProvider);
      typeCheckingContext.createEquation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "1184856710777", true), (SNode) new typeof_GetIndexOfOperation_InferenceRule.QuotationClass_aycuzy_a0a4a0().createNode(typeCheckingContext), _info_12389875345);
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.collections.structure.GetIndexOfOperation";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

  public static class QuotationClass_aycuzy_a0a2a0 {
    public QuotationClass_aycuzy_a0a2a0() {
    }

    public SNode createNode(Object parameter_aycuzy_a0a0a0c0a, final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_aycuzy_a0a2a0 = null;
      SNode quotedNode_aycuzy_a0a0c0a = null;
      {
        quotedNode_aycuzy_a0a2a0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.SequenceType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_aycuzy_a0a2a0 = quotedNode_aycuzy_a0a2a0;
        {
          quotedNode_aycuzy_a0a0c0a = (SNode) parameter_aycuzy_a0a0a0c0a;
          SNode quotedNode1_aycuzy_a0a0c0a;
          if (_parameterValues_129834374.contains(quotedNode_aycuzy_a0a0c0a)) {
            quotedNode1_aycuzy_a0a0c0a = CopyUtil.copy(quotedNode_aycuzy_a0a0c0a);
          } else {
            _parameterValues_129834374.add(quotedNode_aycuzy_a0a0c0a);
            quotedNode1_aycuzy_a0a0c0a = quotedNode_aycuzy_a0a0c0a;
          }
          if (quotedNode1_aycuzy_a0a0c0a != null) {
            quotedNode_aycuzy_a0a2a0.addChild("elementType", HUtil.copyIfNecessary(quotedNode1_aycuzy_a0a0c0a, typeCheckingContext));
          }
        }
        result = quotedNode1_aycuzy_a0a2a0;
      }
      return result;
    }

    public SNode createNode(Object parameter_aycuzy_a0a0a0c0a) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_aycuzy_a0a2a0 = null;
      SNode quotedNode_aycuzy_a0a0c0a = null;
      {
        quotedNode_aycuzy_a0a2a0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.SequenceType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_aycuzy_a0a2a0 = quotedNode_aycuzy_a0a2a0;
        {
          quotedNode_aycuzy_a0a0c0a = (SNode) parameter_aycuzy_a0a0a0c0a;
          SNode quotedNode1_aycuzy_a0a0c0a;
          if (_parameterValues_129834374.contains(quotedNode_aycuzy_a0a0c0a)) {
            quotedNode1_aycuzy_a0a0c0a = CopyUtil.copy(quotedNode_aycuzy_a0a0c0a);
          } else {
            _parameterValues_129834374.add(quotedNode_aycuzy_a0a0c0a);
            quotedNode1_aycuzy_a0a0c0a = quotedNode_aycuzy_a0a0c0a;
          }
          if (quotedNode1_aycuzy_a0a0c0a != null) {
            quotedNode_aycuzy_a0a2a0.addChild("elementType", HUtil.copyIfNecessary(quotedNode1_aycuzy_a0a0c0a));
          }
        }
        result = quotedNode1_aycuzy_a0a2a0;
      }
      return result;
    }
  }

  public static class QuotationClass_aycuzy_a0a4a0 {
    public QuotationClass_aycuzy_a0a4a0() {
    }

    public SNode createNode(final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_aycuzy_a0a4a0 = null;
      {
        quotedNode_aycuzy_a0a4a0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.IntegerType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_aycuzy_a0a4a0 = quotedNode_aycuzy_a0a4a0;
        result = quotedNode1_aycuzy_a0a4a0;
      }
      return result;
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_aycuzy_a0a4a0 = null;
      {
        quotedNode_aycuzy_a0a4a0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.IntegerType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_aycuzy_a0a4a0 = quotedNode_aycuzy_a0a4a0;
        result = quotedNode1_aycuzy_a0a4a0;
      }
      return result;
    }
  }
}
