package jetbrains.mps.lang.smodel.typesystem;

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

public class supertypesOf_SNodeListType_ListType_SubtypingRule extends SubtypingRule_Runtime implements ISubtypingRule_Runtime {
  public supertypesOf_SNodeListType_ListType_SubtypingRule() {
  }

  public SNode getSubOrSuperType(SNode type, TypeCheckingContext typeCheckingContext) {
    SNode elementConcept = SLinkOperations.getTarget(type, "elementConcept", false);
    return new supertypesOf_SNodeListType_ListType_SubtypingRule.QuotationClass_r2ybw4_a0b0a().createNode(elementConcept, typeCheckingContext);
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.lang.smodel.structure.SNodeListType";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean isWeak() {
    return false;
  }

  public static class QuotationClass_r2ybw4_a0b0a {
    public QuotationClass_r2ybw4_a0b0a() {
    }

    public SNode createNode(Object parameter_r2ybw4_a0a0a1a0, final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_r2ybw4_a0b0a = null;
      SNode quotedNode_r2ybw4_a0a1a0 = null;
      {
        quotedNode_r2ybw4_a0b0a = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.ListType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_r2ybw4_a0b0a = quotedNode_r2ybw4_a0b0a;
        {
          quotedNode_r2ybw4_a0a1a0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SNodeType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
          SNode quotedNode1_r2ybw4_a0a1a0 = quotedNode_r2ybw4_a0a1a0;
          quotedNode1_r2ybw4_a0a1a0.setReferent("concept", (SNode) parameter_r2ybw4_a0a0a1a0);
          quotedNode_r2ybw4_a0b0a.addChild("elementType", quotedNode1_r2ybw4_a0a1a0);
        }
        result = quotedNode1_r2ybw4_a0b0a;
      }
      return result;
    }

    public SNode createNode(Object parameter_r2ybw4_a0a0a1a0) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_r2ybw4_a0b0a = null;
      SNode quotedNode_r2ybw4_a0a1a0 = null;
      {
        quotedNode_r2ybw4_a0b0a = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.ListType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_r2ybw4_a0b0a = quotedNode_r2ybw4_a0b0a;
        {
          quotedNode_r2ybw4_a0a1a0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SNodeType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
          SNode quotedNode1_r2ybw4_a0a1a0 = quotedNode_r2ybw4_a0a1a0;
          quotedNode1_r2ybw4_a0a1a0.setReferent("concept", (SNode) parameter_r2ybw4_a0a0a1a0);
          quotedNode_r2ybw4_a0b0a.addChild("elementType", quotedNode1_r2ybw4_a0a1a0);
        }
        result = quotedNode1_r2ybw4_a0b0a;
      }
      return result;
    }
  }
}
