package jetbrains.mps.baseLanguage.math.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInequationReplacementRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.EquationInfo;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.typesystem.inference.IErrorTarget;
import jetbrains.mps.typesystem.inference.NodeErrorTarget;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.smodel.SModelUtil_new;

public class matrix_replacement_rule_InequationReplacementRule extends AbstractInequationReplacementRule_Runtime {
  public matrix_replacement_rule_InequationReplacementRule() {
  }

  public void processInequation(final SNode subtype, final SNode supertype, final EquationInfo equationInfo, final TypeCheckingContext typeCheckingContext) {
    {
      SNode _nodeToCheck_1029348928467 = equationInfo.getNodeWithError();
      BaseIntentionProvider intentionProvider = null;
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:47d0f24b-df34-4ea0-aa7e-7c2eb0f88f31(jetbrains.mps.baseLanguage.math.typesystem)", "3498370411873359101", 0, intentionProvider);
      _info_12389875345.pushOuterRuleId((equationInfo).getRuleModel(), (equationInfo).getRuleId());
      _info_12389875345.setInequationGroup("default");
      typeCheckingContext.createLessThanInequation((SNode)SLinkOperations.getTarget(subtype, "elementType", true), (SNode)SLinkOperations.getTarget(supertype, "elementType", true), false, _info_12389875345);
    }
    if (SPropertyOperations.getInteger(subtype, "columns") != 0 && SPropertyOperations.getInteger(supertype, "columns") != 0) {
      if (!(SPropertyOperations.getInteger(subtype, "columns") == SPropertyOperations.getInteger(supertype, "columns"))) {
        {
          BaseIntentionProvider intentionProvider = null;
          IErrorTarget errorTarget = new NodeErrorTarget();
          typeCheckingContext.reportTypeError(equationInfo.getNodeWithError(), " invalid matrix dimensions", "r:47d0f24b-df34-4ea0-aa7e-7c2eb0f88f31(jetbrains.mps.baseLanguage.math.typesystem)", "7676695779583848932", intentionProvider, errorTarget);
        }
      }
    }
    if (SPropertyOperations.getInteger(subtype, "rows") != 0 && SPropertyOperations.getInteger(supertype, "rows") != 0) {
      if (!(SPropertyOperations.getInteger(subtype, "rows") == SPropertyOperations.getInteger(supertype, "rows"))) {
        {
          BaseIntentionProvider intentionProvider = null;
          IErrorTarget errorTarget = new NodeErrorTarget();
          typeCheckingContext.reportTypeError(equationInfo.getNodeWithError(), " invalid matrix dimensions", "r:47d0f24b-df34-4ea0-aa7e-7c2eb0f88f31(jetbrains.mps.baseLanguage.math.typesystem)", "7676695779583848960", intentionProvider, errorTarget);
        }
      }
    }
  }

  public boolean checkInequation(final SNode subtype, final SNode supertype, final EquationInfo equationInfo) {
    boolean result_14532009 = true;
    result_14532009 = result_14532009 && TypeChecker.getInstance().getSubtypingManager().isSubtype((SNode)SLinkOperations.getTarget(subtype, "elementType", true), (SNode)SLinkOperations.getTarget(supertype, "elementType", true), true);
    if (SPropertyOperations.getInteger(subtype, "columns") != 0 && SPropertyOperations.getInteger(supertype, "columns") != 0) {
      if (!(SPropertyOperations.getInteger(subtype, "columns") == SPropertyOperations.getInteger(supertype, "columns"))) {
        result_14532009 = false;
      }
    }
    if (SPropertyOperations.getInteger(subtype, "rows") != 0 && SPropertyOperations.getInteger(supertype, "rows") != 0) {
      if (!(SPropertyOperations.getInteger(subtype, "rows") == SPropertyOperations.getInteger(supertype, "rows"))) {
        result_14532009 = false;
      }
    }
    return result_14532009;
  }

  public boolean isWeak() {
    return true;
  }

  public boolean isApplicableSubtype(SNode node) {
    return SModelUtil_new.isAssignableConcept(node.getConceptFqName(), this.getApplicableSubtypeConceptFQName());
  }

  public boolean isApplicableSupertype(SNode node) {
    return SModelUtil_new.isAssignableConcept(node.getConceptFqName(), this.getApplicableSupertypeConceptFQName());
  }

  public String getApplicableSubtypeConceptFQName() {
    return "jetbrains.mps.baseLanguage.math.structure.MatrixType";
  }

  public String getApplicableSupertypeConceptFQName() {
    return "jetbrains.mps.baseLanguage.math.structure.MatrixType";
  }
}
