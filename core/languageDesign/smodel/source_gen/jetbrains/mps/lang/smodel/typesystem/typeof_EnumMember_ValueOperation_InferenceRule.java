package jetbrains.mps.lang.smodel.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.typesystem.inference.EquationInfo;
import jetbrains.mps.typesystem.inference.ConceptWrapper;
import jetbrains.mps.lang.structure.behavior.DataTypeDeclaration_Behavior;
import jetbrains.mps.smodel.SModelUtil_new;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.project.GlobalScope;

public class typeof_EnumMember_ValueOperation_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {
  public typeof_EnumMember_ValueOperation_InferenceRule() {
  }

  public void applyRule(final SNode operation, final TypeCheckingContext typeCheckingContext) {
    final SNode Enum_typevar_1240331870095 = typeCheckingContext.createNewRuntimeTypesVariable();
    final SNode Member_typevar_1240331876974 = typeCheckingContext.createNewRuntimeTypesVariable();
    {
      SNode _nodeToCheck_1029348928467 = SLinkOperations.getTarget(SNodeOperations.cast(SNodeOperations.getParent(operation), "jetbrains.mps.baseLanguage.structure.DotExpression"), "operand", true);
      BaseIntentionProvider intentionProvider = null;
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "1240331899146", 0, intentionProvider);
      typeCheckingContext.createEquation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "1240331895732", true), (SNode) new typeof_EnumMember_ValueOperation_InferenceRule.QuotationClass_ecgaoh_a0a2a0().createNode(typeCheckingContext.getEquationManager().getRepresentator(Enum_typevar_1240331870095), typeCheckingContext), _info_12389875345);
    }
    {
      SNode _nodeToCheck_1029348928467 = operation;
      BaseIntentionProvider intentionProvider = null;
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "1240331973196", 0, intentionProvider);
      typeCheckingContext.createEquation((SNode) typeCheckingContext.getEquationManager().getRepresentator(Enum_typevar_1240331870095), new ConceptWrapper("jetbrains.mps.lang.structure.structure.EnumerationDataTypeDeclaration", new ConceptWrapper.LinkTargetInfo(true, "memberDataType", typeCheckingContext.getEquationManager().getRepresentator(Member_typevar_1240331876974), -1)), _info_12389875345);
    }
    {
      final SNode memberType = typeCheckingContext.getEquationManager().getRepresentator(Member_typevar_1240331876974);
      typeCheckingContext.whenConcrete(memberType, new Runnable() {
        public void run() {
          {
            SNode _nodeToCheck_1029348928467 = operation;
            BaseIntentionProvider intentionProvider = null;
            EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "1240577344535", 0, intentionProvider);
            typeCheckingContext.createEquation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "1240577344539", true), (SNode) DataTypeDeclaration_Behavior.call_toBaseLanguageType_1213877229718(SNodeOperations.cast(typeCheckingContext.getEquationManager().getRepresentator(memberType), "jetbrains.mps.lang.structure.structure.PrimitiveDataTypeDeclaration")), _info_12389875345);
          }
        }
      }, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "1240577305543", false, false);
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.lang.smodel.structure.EnumMember_ValueOperation";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

  public static class QuotationClass_ecgaoh_a0a2a0 {
    public QuotationClass_ecgaoh_a0a2a0() {
    }

    public SNode createNode(Object parameter_ecgaoh_a0a0a2a0, final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_ecgaoh_a0a2a0 = null;
      {
        quotedNode_ecgaoh_a0a2a0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SEnumMemberType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_ecgaoh_a0a2a0 = quotedNode_ecgaoh_a0a2a0;
        quotedNode1_ecgaoh_a0a2a0.setReferent("enum", (SNode) parameter_ecgaoh_a0a0a2a0);
        result = quotedNode1_ecgaoh_a0a2a0;
      }
      return result;
    }

    public SNode createNode(Object parameter_ecgaoh_a0a0a2a0) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_ecgaoh_a0a2a0 = null;
      {
        quotedNode_ecgaoh_a0a2a0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SEnumMemberType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_ecgaoh_a0a2a0 = quotedNode_ecgaoh_a0a2a0;
        quotedNode1_ecgaoh_a0a2a0.setReferent("enum", (SNode) parameter_ecgaoh_a0a0a2a0);
        result = quotedNode1_ecgaoh_a0a2a0;
      }
      return result;
    }
  }
}
