package jetbrains.mps.baseLanguage.math.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.SubtypingRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.ISubtypingRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.typesystem.runtime.IsApplicableStatus;
import jetbrains.mps.smodel.SModelUtil_new;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.smodel.SNodeId;

public class bigcomplex_extends_BigComplex_SubtypingRule extends SubtypingRule_Runtime implements ISubtypingRule_Runtime {
  public bigcomplex_extends_BigComplex_SubtypingRule() {
  }

  public SNode getSubOrSuperType(SNode bigComplexType, TypeCheckingContext typeCheckingContext, IsApplicableStatus status) {
    return new bigcomplex_extends_BigComplex_SubtypingRule.QuotationClass_ertxks_a0a0a().createNode(typeCheckingContext);
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.math.structure.BigComplexType";
  }

  public IsApplicableStatus isApplicableAndPattern(SNode argument) {
    {
      boolean b = SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
      return new IsApplicableStatus(b, null);
    }
  }

  public boolean isWeak() {
    return false;
  }

  public static class QuotationClass_ertxks_a0a0a {
    public QuotationClass_ertxks_a0a0a() {
    }

    public SNode createNode(final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.addReference(SReference.create("classifier", quotedNode1_2, SModelReference.fromString("r:b79696e4-f917-4b28-af17-40e382bc7b82(jetbrains.mps.baseLanguage.math.runtime)"), SNodeId.fromString("877422884702771040")));
        result = quotedNode1_2;
      }
      return result;
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.addReference(SReference.create("classifier", quotedNode1_2, SModelReference.fromString("r:b79696e4-f917-4b28-af17-40e382bc7b82(jetbrains.mps.baseLanguage.math.runtime)"), SNodeId.fromString("877422884702771040")));
        result = quotedNode1_2;
      }
      return result;
    }
  }
}
