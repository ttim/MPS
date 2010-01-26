package jetbrains.mps.baseLanguage.math.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.typesystem.inference.EquationInfo;
import jetbrains.mps.smodel.SModelUtil_new;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.smodel.CopyUtil;
import jetbrains.mps.lang.typesystem.runtime.HUtil;

public class typeof_IntervalLiteral_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {
  public typeof_IntervalLiteral_InferenceRule() {
  }

  public void applyRule(final SNode literal, final TypeCheckingContext typeCheckingContext) {
    final SNode elementType_typevar_1235747425275 = typeCheckingContext.createNewRuntimeTypesVariable();
    if ((SLinkOperations.getTarget(literal, "end", true) != null)) {
      {
        SNode _nodeToCheck_1029348928467 = SLinkOperations.getTarget(literal, "end", true);
        BaseIntentionProvider intentionProvider = null;
        EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:47d0f24b-df34-4ea0-aa7e-7c2eb0f88f31(jetbrains.mps.baseLanguage.math.typesystem)", "1236434335326", 0, intentionProvider);
        typeCheckingContext.createEquation((SNode) typeCheckingContext.getEquationManager().getRepresentator(elementType_typevar_1235747425275), (SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:47d0f24b-df34-4ea0-aa7e-7c2eb0f88f31(jetbrains.mps.baseLanguage.math.typesystem)", "1236434335330", true), _info_12389875345);
      }
    }
    if ((SLinkOperations.getTarget(literal, "start", true) != null)) {
      {
        SNode _nodeToCheck_1029348928467 = SLinkOperations.getTarget(literal, "start", true);
        BaseIntentionProvider intentionProvider = null;
        EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:47d0f24b-df34-4ea0-aa7e-7c2eb0f88f31(jetbrains.mps.baseLanguage.math.typesystem)", "1236434330693", 0, intentionProvider);
        typeCheckingContext.createEquation((SNode) typeCheckingContext.getEquationManager().getRepresentator(elementType_typevar_1235747425275), (SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:47d0f24b-df34-4ea0-aa7e-7c2eb0f88f31(jetbrains.mps.baseLanguage.math.typesystem)", "1236434330697", true), _info_12389875345);
      }
    }
    {
      SNode _nodeToCheck_1029348928467 = literal;
      BaseIntentionProvider intentionProvider = null;
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:47d0f24b-df34-4ea0-aa7e-7c2eb0f88f31(jetbrains.mps.baseLanguage.math.typesystem)", "1235747425306", 0, intentionProvider);
      typeCheckingContext.createEquation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:47d0f24b-df34-4ea0-aa7e-7c2eb0f88f31(jetbrains.mps.baseLanguage.math.typesystem)", "1235747425314", true), (SNode) new typeof_IntervalLiteral_InferenceRule.QuotationClass_7666_0().createNode(typeCheckingContext.getEquationManager().getRepresentator(elementType_typevar_1235747425275), typeCheckingContext), _info_12389875345);
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.math.structure.IntervalLiteral";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

  public static class QuotationClass_7666_0 {
    public QuotationClass_7666_0() {
    }

    public SNode createNode(Object parameter_7666_0, final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_7666_0 = null;
      SNode quotedNode_7666_1 = null;
      {
        quotedNode_7666_0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.math.structure.IntervalType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_7666_0 = quotedNode_7666_0;
        {
          quotedNode_7666_1 = (SNode) parameter_7666_0;
          SNode quotedNode1_7666_1;
          if (_parameterValues_129834374.contains(quotedNode_7666_1)) {
            quotedNode1_7666_1 = CopyUtil.copy(quotedNode_7666_1);
          } else {
            _parameterValues_129834374.add(quotedNode_7666_1);
            quotedNode1_7666_1 = quotedNode_7666_1;
          }
          if (quotedNode1_7666_1 != null) {
            quotedNode_7666_0.addChild("elementType", HUtil.copyIfNecessary(quotedNode1_7666_1, typeCheckingContext));
          }
        }
        result = quotedNode1_7666_0;
      }
      return result;
    }

    public SNode createNode(Object parameter_7666_0) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_7666_0 = null;
      SNode quotedNode_7666_1 = null;
      {
        quotedNode_7666_0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.math.structure.IntervalType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_7666_0 = quotedNode_7666_0;
        {
          quotedNode_7666_1 = (SNode) parameter_7666_0;
          SNode quotedNode1_7666_1;
          if (_parameterValues_129834374.contains(quotedNode_7666_1)) {
            quotedNode1_7666_1 = CopyUtil.copy(quotedNode_7666_1);
          } else {
            _parameterValues_129834374.add(quotedNode_7666_1);
            quotedNode1_7666_1 = quotedNode_7666_1;
          }
          if (quotedNode1_7666_1 != null) {
            quotedNode_7666_0.addChild("elementType", HUtil.copyIfNecessary(quotedNode1_7666_1));
          }
        }
        result = quotedNode1_7666_0;
      }
      return result;
    }
  }
}
