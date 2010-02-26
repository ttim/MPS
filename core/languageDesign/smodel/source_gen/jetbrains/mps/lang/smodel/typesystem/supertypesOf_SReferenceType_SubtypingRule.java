package jetbrains.mps.lang.smodel.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.SubtypingRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.ISubtypingRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.smodel.SModelUtil_new;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.smodel.SNodeId;

public class supertypesOf_SReferenceType_SubtypingRule extends SubtypingRule_Runtime implements ISubtypingRule_Runtime {
  public supertypesOf_SReferenceType_SubtypingRule() {
  }

  public SNode getSubOrSuperType(SNode referenceType, TypeCheckingContext typeCheckingContext) {
    return new supertypesOf_SReferenceType_SubtypingRule.QuotationClass_kps41k_a0a0a().createNode(typeCheckingContext);
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.lang.smodel.structure.SReferenceType";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean isWeak() {
    return false;
  }

  public static class QuotationClass_kps41k_a0a0a {
    public QuotationClass_kps41k_a0a0a() {
    }

    public SNode createNode(final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_kps41k_a0a0a = null;
      {
        quotedNode_kps41k_a0a0a = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_kps41k_a0a0a = quotedNode_kps41k_a0a0a;
        quotedNode1_kps41k_a0a0a.addReference(SReference.create("classifier", quotedNode1_kps41k_a0a0a, SModelReference.fromString("f:java_stub#jetbrains.mps.smodel(jetbrains.mps.smodel@java_stub)"), SNodeId.fromString("~SReference")));
        result = quotedNode1_kps41k_a0a0a;
      }
      return result;
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_kps41k_a0a0a = null;
      {
        quotedNode_kps41k_a0a0a = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_kps41k_a0a0a = quotedNode_kps41k_a0a0a;
        quotedNode1_kps41k_a0a0a.addReference(SReference.create("classifier", quotedNode1_kps41k_a0a0a, SModelReference.fromString("f:java_stub#jetbrains.mps.smodel(jetbrains.mps.smodel@java_stub)"), SNodeId.fromString("~SReference")));
        result = quotedNode1_kps41k_a0a0a;
      }
      return result;
    }
  }
}
