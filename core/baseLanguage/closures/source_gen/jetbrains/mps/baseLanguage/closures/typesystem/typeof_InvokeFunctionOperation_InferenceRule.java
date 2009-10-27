package jetbrains.mps.baseLanguage.closures.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.typesystem.inference.EquationInfo;
import jetbrains.mps.baseLanguage.behavior.IOperation_Behavior;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeof_InvokeFunctionOperation_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {
  public typeof_InvokeFunctionOperation_InferenceRule() {
  }

  public void applyRule(final SNode invoke, final TypeCheckingContext typeCheckingContext) {
    List<SNode> ptypes1 = ListSequence.fromList(new ArrayList<SNode>());
    List<SNode> ptypes2 = ListSequence.fromList(new ArrayList<SNode>());
    for (SNode p : SLinkOperations.getTargets(invoke, "parameter", true)) {
      final SNode T_typevar_1240926882799 = typeCheckingContext.createNewRuntimeTypesVariable();
      ListSequence.fromList(ptypes1).addElement(typeCheckingContext.getEquationManager().getRepresentator(T_typevar_1240926882799));
      ListSequence.fromList(ptypes2).addElement(typeCheckingContext.getEquationManager().getRepresentator(T_typevar_1240926882799));
      {
        SNode _nodeToCheck_1029348928467 = p;
        BaseIntentionProvider intentionProvider = null;
        EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c89590337(jetbrains.mps.baseLanguage.closures.typesystem)", "1240926919975", 0, intentionProvider);
        _info_12389875345.setInequationGroup("default");
        typeCheckingContext.createLessThanInequation((SNode)typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c89590337(jetbrains.mps.baseLanguage.closures.typesystem)", "1240926911872", true), (SNode)typeCheckingContext.getEquationManager().getRepresentator(T_typevar_1240926882799), false, _info_12389875345);
      }
    }
    final SNode ret_typevar_1225797542595 = typeCheckingContext.createNewRuntimeTypesVariable();
    final SNode ret2_typevar_1230048995510 = typeCheckingContext.createNewRuntimeTypesVariable();
    {
      SNode _nodeToCheck_1029348928467 = invoke;
      BaseIntentionProvider intentionProvider = null;
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c89590337(jetbrains.mps.baseLanguage.closures.typesystem)", "1237374285371", 0, intentionProvider);
      typeCheckingContext.createEquation((SNode)typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c89590337(jetbrains.mps.baseLanguage.closures.typesystem)", "1237374276263", true), (SNode)typeCheckingContext.getEquationManager().getRepresentator(ret_typevar_1225797542595), _info_12389875345);
    }
    {
      SNode _nodeToCheck_1029348928467 = invoke;
      BaseIntentionProvider intentionProvider = null;
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, "either return type or parameter types don't match", "r:00000000-0000-4000-0000-011c89590337(jetbrains.mps.baseLanguage.closures.typesystem)", "1230048793938", 0, intentionProvider);
      _info_12389875345.setInequationGroup("default");
      typeCheckingContext.createLessThanInequationStrong((SNode)typeCheckingContext.typeOf(IOperation_Behavior.call_getOperand_1213877410070(invoke), "r:00000000-0000-4000-0000-011c89590337(jetbrains.mps.baseLanguage.closures.typesystem)", "1230048905737", true), (SNode)new _Quotations.QuotationClass_6().createNode(ptypes1, typeCheckingContext.getEquationManager().getRepresentator(ret_typevar_1225797542595), ptypes2, typeCheckingContext.getEquationManager().getRepresentator(ret_typevar_1225797542595), typeCheckingContext.getEquationManager().getRepresentator(ret2_typevar_1230048995510), typeCheckingContext), false, _info_12389875345);
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.closures.structure.InvokeFunctionOperation";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }
}
