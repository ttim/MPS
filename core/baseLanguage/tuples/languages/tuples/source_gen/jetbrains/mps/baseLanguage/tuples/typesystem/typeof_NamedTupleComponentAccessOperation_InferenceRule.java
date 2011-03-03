package jetbrains.mps.baseLanguage.tuples.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.typesystem.runtime.IsApplicableStatus;
import java.util.List;
import java.util.ArrayList;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.baseLanguage.behavior.IOperation_Behavior;
import jetbrains.mps.errors.BaseQuickFixProvider;
import jetbrains.mps.typesystem.inference.EquationInfo;
import jetbrains.mps.smodel.SModelUtil_new;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.lang.typesystem.runtime.HUtil;

public class typeof_NamedTupleComponentAccessOperation_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {
  public typeof_NamedTupleComponentAccessOperation_InferenceRule() {
  }

  public void applyRule(final SNode operation, final TypeCheckingContext typeCheckingContext, IsApplicableStatus status) {
    List<SNode> PTYPES = new ArrayList<SNode>();
    SNode tupleDecl = SNodeOperations.cast(SNodeOperations.getParent(SLinkOperations.getTarget(operation, "component", false)), "jetbrains.mps.baseLanguage.tuples.structure.NamedTupleDeclaration");
    for (SNode tvr : ListSequence.fromList(SLinkOperations.getTargets(tupleDecl, "typeVariableDeclaration", true))) {
      final SNode PTYPE_typevar_1239974367138 = typeCheckingContext.createNewRuntimeTypesVariable();
      ListSequence.fromList(PTYPES).addElement(typeCheckingContext.getRepresentative(PTYPE_typevar_1239974367138));
    }
    {
      SNode _nodeToCheck_1029348928467 = IOperation_Behavior.call_getOperand_1213877410070(operation);
      BaseQuickFixProvider intentionProvider = null;
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:e119dbbd-3529-4067-8bad-6b9edd79d0b6(jetbrains.mps.baseLanguage.tuples.typesystem)", "3862929002918414716", 0, intentionProvider);
      typeCheckingContext.createLessThanInequationStrong((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:e119dbbd-3529-4067-8bad-6b9edd79d0b6(jetbrains.mps.baseLanguage.tuples.typesystem)", "3862929002918414718", true), (SNode) new typeof_NamedTupleComponentAccessOperation_InferenceRule.QuotationClass_kga4po_a0a3a0().createNode(tupleDecl, PTYPES, typeCheckingContext), false, _info_12389875345);
    }
    SNode opType = SNodeOperations.copyNode(SLinkOperations.getTarget(SLinkOperations.getTarget(operation, "component", false), "type", true));
    if (SNodeOperations.isInstanceOf(opType, "jetbrains.mps.baseLanguage.structure.TypeVariableReference")) {
      int idx = SNodeOperations.getIndexInParent(SLinkOperations.getTarget(SNodeOperations.cast(opType, "jetbrains.mps.baseLanguage.structure.TypeVariableReference"), "typeVariableDeclaration", false));
      opType = ListSequence.fromList(PTYPES).getElement(idx);
    } else {
      List<SNode> variableReferences = SNodeOperations.getDescendants(opType, "jetbrains.mps.baseLanguage.structure.TypeVariableReference", false, new String[]{});
      List<SNode> tvrs = new ArrayList<SNode>();
      ListSequence.fromList(tvrs).addSequence(ListSequence.fromList(variableReferences));
      for (SNode tvr : tvrs) {
        int idx = SNodeOperations.getIndexInParent(SLinkOperations.getTarget(tvr, "typeVariableDeclaration", false));
        if (idx < ListSequence.fromList(PTYPES).count()) {
          SNodeOperations.replaceWithAnother(tvr, ListSequence.fromList(PTYPES).getElement(idx));
        }
      }
    }
    {
      SNode _nodeToCheck_1029348928467 = operation;
      BaseQuickFixProvider intentionProvider = null;
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:e119dbbd-3529-4067-8bad-6b9edd79d0b6(jetbrains.mps.baseLanguage.tuples.typesystem)", "1239579829277", 0, intentionProvider);
      typeCheckingContext.createEquation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:e119dbbd-3529-4067-8bad-6b9edd79d0b6(jetbrains.mps.baseLanguage.tuples.typesystem)", "1239579816726", true), (SNode) opType, _info_12389875345);
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.tuples.structure.NamedTupleComponentAccessOperation";
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

  public static class QuotationClass_kga4po_a0a3a0 {
    public QuotationClass_kga4po_a0a3a0() {
    }

    public SNode createNode(Object parameter_4, Object parameter_5, final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      SNode quotedNode_2 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.tuples.structure.NamedTupleType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_3 = quotedNode_1;
        quotedNode1_3.setReferent("classifier", (SNode) parameter_4);
        {
          List<SNode> nodes = (List<SNode>) parameter_5;
          for (SNode child : nodes) {
            quotedNode_1.addChild("parameter", HUtil.copyIfNecessary(child, typeCheckingContext));
          }
        }
        result = quotedNode1_3;
      }
      return result;
    }

    public SNode createNode(Object parameter_4, Object parameter_5) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      SNode quotedNode_2 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.tuples.structure.NamedTupleType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_3 = quotedNode_1;
        quotedNode1_3.setReferent("classifier", (SNode) parameter_4);
        {
          List<SNode> nodes = (List<SNode>) parameter_5;
          for (SNode child : nodes) {
            quotedNode_1.addChild("parameter", HUtil.copyIfNecessary(child));
          }
        }
        result = quotedNode1_3;
      }
      return result;
    }
  }
}
