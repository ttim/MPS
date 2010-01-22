package jetbrains.mps.samples.complex.typesystem;

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
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.smodel.SNodeId;

public class Complex_is_Numeric_SubtypingRule extends SubtypingRule_Runtime implements ISubtypingRule_Runtime {
  public Complex_is_Numeric_SubtypingRule() {
  }

  public SNode getSubOrSuperType(SNode complexType, TypeCheckingContext typeCheckingContext) {
    return SLinkOperations.getTarget(new Complex_is_Numeric_SubtypingRule.QuotationClass_8731_0().createNode(typeCheckingContext), "descriptor", false);
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.samples.complex.structure.ComplexType";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean isWeak() {
    return false;
  }

  public static class QuotationClass_8731_0 {
    public QuotationClass_8731_0() {
    }

    public SNode createNode(final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_8731_0 = null;
      {
        quotedNode_8731_0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.blTypes.structure.PrimitiveTypeRef", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_8731_0 = quotedNode_8731_0;
        quotedNode1_8731_0.addReference(SReference.create("descriptor", quotedNode1_8731_0, SModelReference.fromString("r:00000000-0000-4000-0000-011c895902de(jetbrains.mps.baseLanguage.blTypes.primitiveDescriptors)"), SNodeId.fromString("1196683729865")));
        result = quotedNode1_8731_0;
      }
      return result;
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_8731_0 = null;
      {
        quotedNode_8731_0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.blTypes.structure.PrimitiveTypeRef", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_8731_0 = quotedNode_8731_0;
        quotedNode1_8731_0.addReference(SReference.create("descriptor", quotedNode1_8731_0, SModelReference.fromString("r:00000000-0000-4000-0000-011c895902de(jetbrains.mps.baseLanguage.blTypes.primitiveDescriptors)"), SNodeId.fromString("1196683729865")));
        result = quotedNode1_8731_0;
      }
      return result;
    }
  }
}
