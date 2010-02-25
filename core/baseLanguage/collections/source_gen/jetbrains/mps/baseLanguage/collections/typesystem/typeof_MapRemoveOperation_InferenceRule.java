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

public class typeof_MapRemoveOperation_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {
  public typeof_MapRemoveOperation_InferenceRule() {
  }

  public void applyRule(final SNode nodeToCheck, final TypeCheckingContext typeCheckingContext) {
    final SNode KEY_typevar_1207233776692 = typeCheckingContext.createNewRuntimeTypesVariable();
    final SNode VALUE_typevar_1207233776693 = typeCheckingContext.createNewRuntimeTypesVariable();
    {
      SNode _nodeToCheck_1029348928467 = IOperation_Behavior.call_getOperand_1213877410070(nodeToCheck);
      BaseIntentionProvider intentionProvider = null;
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "1207233776694", 0, intentionProvider);
      _info_12389875345.setInequationGroup("default");
      typeCheckingContext.createLessThanInequation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "1207233776696", true), (SNode) new typeof_MapRemoveOperation_InferenceRule.QuotationClass_1445_l523emneazk2().createNode(typeCheckingContext.getEquationManager().getRepresentator(VALUE_typevar_1207233776693), typeCheckingContext.getEquationManager().getRepresentator(KEY_typevar_1207233776692), typeCheckingContext), false, _info_12389875345);
    }
    {
      SNode _nodeToCheck_1029348928467 = SLinkOperations.getTarget(nodeToCheck, "key", true);
      BaseIntentionProvider intentionProvider = null;
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "1207233776711", 0, intentionProvider);
      _info_12389875345.setInequationGroup("default");
      typeCheckingContext.createLessThanInequation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "1207233776715", true), (SNode) typeCheckingContext.getEquationManager().getRepresentator(KEY_typevar_1207233776692), false, _info_12389875345);
    }
    {
      SNode _nodeToCheck_1029348928467 = nodeToCheck;
      BaseIntentionProvider intentionProvider = null;
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "1207233776685", 0, intentionProvider);
      typeCheckingContext.createEquation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "1207233776690", true), (SNode) typeCheckingContext.getEquationManager().getRepresentator(VALUE_typevar_1207233776693), _info_12389875345);
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.collections.structure.MapRemoveOperation";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

  public static class QuotationClass_1445_l523emneazk2 {
    public QuotationClass_1445_l523emneazk2() {
    }

    public SNode createNode(Object parameter_1445_l523emneali4, Object parameter_1445_l523emnealib, final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1445_l523emnealh5 = null;
      SNode quotedNode_1445_l523emnealh6 = null;
      SNode quotedNode_1445_l523emnealh8 = null;
      {
        quotedNode_1445_l523emnealh5 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.MapType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_1445_l523emnealh5 = quotedNode_1445_l523emnealh5;
        {
          quotedNode_1445_l523emnealh6 = (SNode) parameter_1445_l523emneali4;
          SNode quotedNode1_1445_l523emnealh6;
          if (_parameterValues_129834374.contains(quotedNode_1445_l523emnealh6)) {
            quotedNode1_1445_l523emnealh6 = CopyUtil.copy(quotedNode_1445_l523emnealh6);
          } else {
            _parameterValues_129834374.add(quotedNode_1445_l523emnealh6);
            quotedNode1_1445_l523emnealh6 = quotedNode_1445_l523emnealh6;
          }
          if (quotedNode1_1445_l523emnealh6 != null) {
            quotedNode_1445_l523emnealh5.addChild("valueType", HUtil.copyIfNecessary(quotedNode1_1445_l523emnealh6, typeCheckingContext));
          }
        }
        {
          quotedNode_1445_l523emnealh8 = (SNode) parameter_1445_l523emnealib;
          SNode quotedNode1_1445_l523emnealh8;
          if (_parameterValues_129834374.contains(quotedNode_1445_l523emnealh8)) {
            quotedNode1_1445_l523emnealh8 = CopyUtil.copy(quotedNode_1445_l523emnealh8);
          } else {
            _parameterValues_129834374.add(quotedNode_1445_l523emnealh8);
            quotedNode1_1445_l523emnealh8 = quotedNode_1445_l523emnealh8;
          }
          if (quotedNode1_1445_l523emnealh8 != null) {
            quotedNode_1445_l523emnealh5.addChild("keyType", HUtil.copyIfNecessary(quotedNode1_1445_l523emnealh8, typeCheckingContext));
          }
        }
        result = quotedNode1_1445_l523emnealh5;
      }
      return result;
    }

    public SNode createNode(Object parameter_1445_l523emneali4, Object parameter_1445_l523emnealib) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1445_l523emnealh5 = null;
      SNode quotedNode_1445_l523emnealh6 = null;
      SNode quotedNode_1445_l523emnealh8 = null;
      {
        quotedNode_1445_l523emnealh5 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.MapType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_1445_l523emnealh5 = quotedNode_1445_l523emnealh5;
        {
          quotedNode_1445_l523emnealh6 = (SNode) parameter_1445_l523emneali4;
          SNode quotedNode1_1445_l523emnealh6;
          if (_parameterValues_129834374.contains(quotedNode_1445_l523emnealh6)) {
            quotedNode1_1445_l523emnealh6 = CopyUtil.copy(quotedNode_1445_l523emnealh6);
          } else {
            _parameterValues_129834374.add(quotedNode_1445_l523emnealh6);
            quotedNode1_1445_l523emnealh6 = quotedNode_1445_l523emnealh6;
          }
          if (quotedNode1_1445_l523emnealh6 != null) {
            quotedNode_1445_l523emnealh5.addChild("valueType", HUtil.copyIfNecessary(quotedNode1_1445_l523emnealh6));
          }
        }
        {
          quotedNode_1445_l523emnealh8 = (SNode) parameter_1445_l523emnealib;
          SNode quotedNode1_1445_l523emnealh8;
          if (_parameterValues_129834374.contains(quotedNode_1445_l523emnealh8)) {
            quotedNode1_1445_l523emnealh8 = CopyUtil.copy(quotedNode_1445_l523emnealh8);
          } else {
            _parameterValues_129834374.add(quotedNode_1445_l523emnealh8);
            quotedNode1_1445_l523emnealh8 = quotedNode_1445_l523emnealh8;
          }
          if (quotedNode1_1445_l523emnealh8 != null) {
            quotedNode_1445_l523emnealh5.addChild("keyType", HUtil.copyIfNecessary(quotedNode1_1445_l523emnealh8));
          }
        }
        result = quotedNode1_1445_l523emnealh5;
      }
      return result;
    }
  }
}
