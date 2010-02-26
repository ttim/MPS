package jetbrains.mps.baseLanguage.collections.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.SubtypingRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.ISubtypingRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.SModelUtil_new;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.smodel.CopyUtil;
import jetbrains.mps.lang.typesystem.runtime.HUtil;

public class supertypesOf_ListType_SequenceType_SubtypingRule extends SubtypingRule_Runtime implements ISubtypingRule_Runtime {
  public supertypesOf_ListType_SequenceType_SubtypingRule() {
  }

  public SNode getSubOrSuperType(SNode type, TypeCheckingContext typeCheckingContext) {
    return new supertypesOf_ListType_SequenceType_SubtypingRule.QuotationClass_qk8hie_a0a0a().createNode(SLinkOperations.getTarget(type, "elementType", true), typeCheckingContext);
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.collections.structure.ListType";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean isWeak() {
    return false;
  }

  public static class QuotationClass_qk8hie_a0a0a {
    public QuotationClass_qk8hie_a0a0a() {
    }

    public SNode createNode(Object parameter_qk8hie_a0a0a0a0, final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_qk8hie_a0a0a = null;
      SNode quotedNode_qk8hie_a0a0a0 = null;
      {
        quotedNode_qk8hie_a0a0a = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.SequenceType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_qk8hie_a0a0a = quotedNode_qk8hie_a0a0a;
        {
          quotedNode_qk8hie_a0a0a0 = (SNode) parameter_qk8hie_a0a0a0a0;
          SNode quotedNode1_qk8hie_a0a0a0;
          if (_parameterValues_129834374.contains(quotedNode_qk8hie_a0a0a0)) {
            quotedNode1_qk8hie_a0a0a0 = CopyUtil.copy(quotedNode_qk8hie_a0a0a0);
          } else {
            _parameterValues_129834374.add(quotedNode_qk8hie_a0a0a0);
            quotedNode1_qk8hie_a0a0a0 = quotedNode_qk8hie_a0a0a0;
          }
          if (quotedNode1_qk8hie_a0a0a0 != null) {
            quotedNode_qk8hie_a0a0a.addChild("elementType", HUtil.copyIfNecessary(quotedNode1_qk8hie_a0a0a0, typeCheckingContext));
          }
        }
        result = quotedNode1_qk8hie_a0a0a;
      }
      return result;
    }

    public SNode createNode(Object parameter_qk8hie_a0a0a0a0) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_qk8hie_a0a0a = null;
      SNode quotedNode_qk8hie_a0a0a0 = null;
      {
        quotedNode_qk8hie_a0a0a = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.SequenceType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_qk8hie_a0a0a = quotedNode_qk8hie_a0a0a;
        {
          quotedNode_qk8hie_a0a0a0 = (SNode) parameter_qk8hie_a0a0a0a0;
          SNode quotedNode1_qk8hie_a0a0a0;
          if (_parameterValues_129834374.contains(quotedNode_qk8hie_a0a0a0)) {
            quotedNode1_qk8hie_a0a0a0 = CopyUtil.copy(quotedNode_qk8hie_a0a0a0);
          } else {
            _parameterValues_129834374.add(quotedNode_qk8hie_a0a0a0);
            quotedNode1_qk8hie_a0a0a0 = quotedNode_qk8hie_a0a0a0;
          }
          if (quotedNode1_qk8hie_a0a0a0 != null) {
            quotedNode_qk8hie_a0a0a.addChild("elementType", HUtil.copyIfNecessary(quotedNode1_qk8hie_a0a0a0));
          }
        }
        result = quotedNode1_qk8hie_a0a0a;
      }
      return result;
    }
  }
}
