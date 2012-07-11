package jetbrains.mps.lang.constraints.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import jetbrains.mps.lang.structure.behavior.AbstractConceptDeclaration_Behavior;
import jetbrains.mps.smodel.LanguageAspect;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ConceptConstraints_Behavior {
  private static Class[] PARAMETERS_8952337903384645670 = {SNode.class};
  private static Class[] PARAMETERS_6261424444345978682 = {SNode.class, SNode.class};

  public static void init(SNode thisNode) {
  }

  public static SNode virtual_getBaseConcept_2621449412040133768(SNode thisNode) {
    return SLinkOperations.getTarget(thisNode, "concept", false);
  }

  public static void virtual_setBaseConcept_6261424444345963020(SNode thisNode, SNode baseConcept) {
    SLinkOperations.setTarget(thisNode, "concept", baseConcept, false);
  }

  public static SNode call_getBaseConcept_8952337903384645670(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (SNode) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.constraints.structure.ConceptConstraints"), "virtual_getBaseConcept_2621449412040133768", PARAMETERS_8952337903384645670, new Object[]{});
  }

  public static void call_setBaseConcept_6261424444345978682(SNode thisNode, SNode baseConcept) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.constraints.structure.ConceptConstraints"), "virtual_setBaseConcept_6261424444345963020", PARAMETERS_6261424444345978682, new Object[]{baseConcept});
  }

  public static SNode callSuper_getBaseConcept_8952337903384645670(SNode thisNode, String callerConceptFqName) {
    return (SNode) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.constraints.structure.ConceptConstraints"), callerConceptFqName, "virtual_getBaseConcept_2621449412040133768", PARAMETERS_8952337903384645670, new Object[]{});
  }

  public static void callSuper_setBaseConcept_6261424444345978682(SNode thisNode, String callerConceptFqName, SNode baseConcept) {
    BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.constraints.structure.ConceptConstraints"), callerConceptFqName, "virtual_setBaseConcept_6261424444345963020", PARAMETERS_6261424444345978682, new Object[]{baseConcept});
  }

  public static SNode getConstraintFunctionBodyUsingInheritance_4960272075650318140(SNode concept, final _FunctionTypes._return_P1_E0<? extends SNode, ? super SNode> constraintFunctionSpecifier) {
    _FunctionTypes._return_P1_E0<? extends SNode, ? super SNode> computePredicate = new _FunctionTypes._return_P1_E0<SNode, SNode>() {
      public SNode invoke(SNode concept) {
        return constraintFunctionSpecifier.invoke(SNodeOperations.cast(AbstractConceptDeclaration_Behavior.call_findConceptAspect_8360039740498068384(concept, LanguageAspect.CONSTRAINTS), "jetbrains.mps.lang.constraints.structure.ConceptConstraints"));
      }
    };
    SNode method = SNodeOperations.cast(AbstractConceptDeclaration_Behavior.call_computeInHierarchy_4184580446578561998(concept, computePredicate), "jetbrains.mps.baseLanguage.structure.ConceptFunction");
    if (method == null) {
      return new ConceptConstraints_Behavior.QuotationClass_wrxfmp_a0a0c0h().createNode();
    } else {
      return SLinkOperations.getTarget(method, "body", true);
    }
  }

  public static class QuotationClass_wrxfmp_a0a0c0h {
    public QuotationClass_wrxfmp_a0a0c0h() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      SNode quotedNode_2 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ReturnStatement", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_3 = quotedNode_1;
        {
          quotedNode_2 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.BooleanConstant", null, GlobalScope.getInstance(), false);
          SNode quotedNode1_4 = quotedNode_2;
          quotedNode1_4.setProperty("value", "true");
          quotedNode_1.addChild("expression", quotedNode1_4);
        }
        result = quotedNode1_3;
      }
      return result;
    }
  }
}
