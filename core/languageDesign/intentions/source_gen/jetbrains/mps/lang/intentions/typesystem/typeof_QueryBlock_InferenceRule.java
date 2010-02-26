package jetbrains.mps.lang.intentions.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.SModelUtil_new;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.smodel.CopyUtil;
import jetbrains.mps.lang.typesystem.runtime.HUtil;

public class typeof_QueryBlock_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {
  public typeof_QueryBlock_InferenceRule() {
  }

  public void applyRule(final SNode block, final TypeCheckingContext typeCheckingContext) {
    ListSequence.fromList(SLinkOperations.getConceptLinkTargets(block, "conceptFunctionReturnType")).removeSequence(ListSequence.fromList(SLinkOperations.getConceptLinkTargets(block, "conceptFunctionReturnType")));
    ListSequence.fromList(SLinkOperations.getConceptLinkTargets(block, "conceptFunctionReturnType")).addElement(new typeof_QueryBlock_InferenceRule.QuotationClass_ay8ev8_a0a0b0a().createNode(SLinkOperations.getTarget(block, "paramType", true), typeCheckingContext));
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.lang.intentions.structure.QueryBlock";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

  public static class QuotationClass_ay8ev8_a0a0b0a {
    public QuotationClass_ay8ev8_a0a0b0a() {
    }

    public SNode createNode(Object parameter_ay8ev8_a0a0a0a1a0, final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_ay8ev8_a0a0b0a = null;
      SNode quotedNode_ay8ev8_a0a0a1a0 = null;
      {
        quotedNode_ay8ev8_a0a0b0a = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.ListType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_ay8ev8_a0a0b0a = quotedNode_ay8ev8_a0a0b0a;
        {
          quotedNode_ay8ev8_a0a0a1a0 = (SNode) parameter_ay8ev8_a0a0a0a1a0;
          SNode quotedNode1_ay8ev8_a0a0a1a0;
          if (_parameterValues_129834374.contains(quotedNode_ay8ev8_a0a0a1a0)) {
            quotedNode1_ay8ev8_a0a0a1a0 = CopyUtil.copy(quotedNode_ay8ev8_a0a0a1a0);
          } else {
            _parameterValues_129834374.add(quotedNode_ay8ev8_a0a0a1a0);
            quotedNode1_ay8ev8_a0a0a1a0 = quotedNode_ay8ev8_a0a0a1a0;
          }
          if (quotedNode1_ay8ev8_a0a0a1a0 != null) {
            quotedNode_ay8ev8_a0a0b0a.addChild("elementType", HUtil.copyIfNecessary(quotedNode1_ay8ev8_a0a0a1a0, typeCheckingContext));
          }
        }
        result = quotedNode1_ay8ev8_a0a0b0a;
      }
      return result;
    }

    public SNode createNode(Object parameter_ay8ev8_a0a0a0a1a0) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_ay8ev8_a0a0b0a = null;
      SNode quotedNode_ay8ev8_a0a0a1a0 = null;
      {
        quotedNode_ay8ev8_a0a0b0a = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.ListType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_ay8ev8_a0a0b0a = quotedNode_ay8ev8_a0a0b0a;
        {
          quotedNode_ay8ev8_a0a0a1a0 = (SNode) parameter_ay8ev8_a0a0a0a1a0;
          SNode quotedNode1_ay8ev8_a0a0a1a0;
          if (_parameterValues_129834374.contains(quotedNode_ay8ev8_a0a0a1a0)) {
            quotedNode1_ay8ev8_a0a0a1a0 = CopyUtil.copy(quotedNode_ay8ev8_a0a0a1a0);
          } else {
            _parameterValues_129834374.add(quotedNode_ay8ev8_a0a0a1a0);
            quotedNode1_ay8ev8_a0a0a1a0 = quotedNode_ay8ev8_a0a0a1a0;
          }
          if (quotedNode1_ay8ev8_a0a0a1a0 != null) {
            quotedNode_ay8ev8_a0a0b0a.addChild("elementType", HUtil.copyIfNecessary(quotedNode1_ay8ev8_a0a0a1a0));
          }
        }
        result = quotedNode1_ay8ev8_a0a0b0a;
      }
      return result;
    }
  }
}
