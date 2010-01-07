package jetbrains.mps.baseLanguage.typesystem;

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

public class typeof_ArrayLiteral_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {
  public typeof_ArrayLiteral_InferenceRule() {
  }

  public void applyRule(final SNode arrayLiteral, final TypeCheckingContext typeCheckingContext) {
    final SNode elementType_typevar_1188221443596 = typeCheckingContext.createNewRuntimeTypesVariable();
    for (SNode item : SLinkOperations.getTargets(arrayLiteral, "item", true)) {
      {
        SNode _nodeToCheck_1029348928467 = item;
        BaseIntentionProvider intentionProvider = null;
        EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.typesystem)", "1188221461712", 0, intentionProvider);
        _info_12389875345.setInequationGroup("default");
        typeCheckingContext.createGreaterThanInequation((SNode) typeCheckingContext.getEquationManager().getRepresentator(elementType_typevar_1188221443596), (SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.typesystem)", "1188221461717", true), false, _info_12389875345);
      }
    }
    {
      SNode _nodeToCheck_1029348928467 = arrayLiteral;
      BaseIntentionProvider intentionProvider = null;
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.typesystem)", "1188221467376", 0, intentionProvider);
      typeCheckingContext.createEquation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.typesystem)", "1188221454647", true), (SNode) new typeof_ArrayLiteral_InferenceRule.QuotationClass_4794_0().createNode(typeCheckingContext.getEquationManager().getRepresentator(elementType_typevar_1188221443596), typeCheckingContext), _info_12389875345);
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.structure.ArrayLiteral";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

  public static class QuotationClass_4794_0 {
    public QuotationClass_4794_0() {
    }

    public SNode createNode(Object parameter_4794_0, final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_81 = null;
      SNode quotedNode_82 = null;
      {
        quotedNode_81 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ArrayType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_80 = quotedNode_81;
        {
          quotedNode_82 = (SNode) parameter_4794_0;
          SNode quotedNode1_81;
          if (_parameterValues_129834374.contains(quotedNode_82)) {
            quotedNode1_81 = CopyUtil.copy(quotedNode_82);
          } else {
            _parameterValues_129834374.add(quotedNode_82);
            quotedNode1_81 = quotedNode_82;
          }
          if (quotedNode1_81 != null) {
            quotedNode_81.addChild("componentType", HUtil.copyIfNecessary(quotedNode1_81, typeCheckingContext));
          }
        }
        result = quotedNode1_80;
      }
      return result;
    }

    public SNode createNode(Object parameter_4794_0) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_81 = null;
      SNode quotedNode_82 = null;
      {
        quotedNode_81 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ArrayType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_80 = quotedNode_81;
        {
          quotedNode_82 = (SNode) parameter_4794_0;
          SNode quotedNode1_81;
          if (_parameterValues_129834374.contains(quotedNode_82)) {
            quotedNode1_81 = CopyUtil.copy(quotedNode_82);
          } else {
            _parameterValues_129834374.add(quotedNode_82);
            quotedNode1_81 = quotedNode_82;
          }
          if (quotedNode1_81 != null) {
            quotedNode_81.addChild("componentType", HUtil.copyIfNecessary(quotedNode1_81));
          }
        }
        result = quotedNode1_80;
      }
      return result;
    }
  }
}
