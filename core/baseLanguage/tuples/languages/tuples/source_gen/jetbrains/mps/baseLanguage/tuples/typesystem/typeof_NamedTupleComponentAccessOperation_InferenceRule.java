package jetbrains.mps.baseLanguage.tuples.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import java.util.List;
import java.util.ArrayList;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.baseLanguage.behavior.IOperation_Behavior;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.typesystem.inference.EquationInfo;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeof_NamedTupleComponentAccessOperation_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {
  public typeof_NamedTupleComponentAccessOperation_InferenceRule() {
  }

  public void applyRule(final SNode operation, final TypeCheckingContext typeCheckingContext) {
    List<SNode> PTYPES = new ArrayList<SNode>();
    SNode tupleDecl = SNodeOperations.cast(SNodeOperations.getParent(SLinkOperations.getTarget(operation, "component", false)), "jetbrains.mps.baseLanguage.tuples.structure.NamedTupleDeclaration");
    for (SNode tvr : ListSequence.fromList(SLinkOperations.getTargets(tupleDecl, "typeVariableDeclaration", true))) {
      final SNode PTYPE_typevar_1239974367138 = typeCheckingContext.createNewRuntimeTypesVariable();
      ListSequence.fromList(PTYPES).addElement(typeCheckingContext.getEquationManager().getRepresentator(PTYPE_typevar_1239974367138));
    }
    {
      SNode _nodeToCheck_1029348928467 = IOperation_Behavior.call_getOperand_1213877410070(operation);
      BaseIntentionProvider intentionProvider = null;
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:e119dbbd-3529-4067-8bad-6b9edd79d0b6(jetbrains.mps.baseLanguage.tuples.typesystem)", "3862929002918414716", 0, intentionProvider);
      _info_12389875345.setInequationGroup("default");
      typeCheckingContext.createLessThanInequationStrong((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:e119dbbd-3529-4067-8bad-6b9edd79d0b6(jetbrains.mps.baseLanguage.tuples.typesystem)", "3862929002918414718", true), (SNode) new _Quotations.QuotationClass_6().createNode(tupleDecl, PTYPES, typeCheckingContext), false, _info_12389875345);
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
      BaseIntentionProvider intentionProvider = null;
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:e119dbbd-3529-4067-8bad-6b9edd79d0b6(jetbrains.mps.baseLanguage.tuples.typesystem)", "1239579829277", 0, intentionProvider);
      typeCheckingContext.createEquation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:e119dbbd-3529-4067-8bad-6b9edd79d0b6(jetbrains.mps.baseLanguage.tuples.typesystem)", "1239579816726", true), (SNode) opType, _info_12389875345);
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.tuples.structure.NamedTupleComponentAccessOperation";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }
}
