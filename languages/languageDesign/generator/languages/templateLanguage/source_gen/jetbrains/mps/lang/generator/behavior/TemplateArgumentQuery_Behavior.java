package jetbrains.mps.lang.generator.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.smodel.behaviour.BehaviorManager;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class TemplateArgumentQuery_Behavior {
  private static Class[] PARAMETERS_4035562641222622443 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static SNode virtual_getExpectedReturnType_1213877374441(SNode thisNode) {
    SNode expr = SNodeOperations.getAncestor(thisNode, "jetbrains.mps.lang.generator.structure.TemplateArgumentQueryExpression", false, false);
    SNode call = SNodeOperations.cast(SNodeOperations.getParent(expr), "jetbrains.mps.lang.generator.structure.ITemplateCall");
    int index = SNodeOperations.getIndexInParent(expr);
    if ((call != null) && (SLinkOperations.getTarget(call, "template", false) != null) && ListSequence.fromList(SLinkOperations.getTargets(SLinkOperations.getTarget(call, "template", false), "parameter", true)).isNotEmpty() && index >= 0 && index < ListSequence.fromList(SLinkOperations.getTargets(SLinkOperations.getTarget(call, "template", false), "parameter", true)).count()) {
      SNode templateParameter = ListSequence.fromList(SLinkOperations.getTargets(SLinkOperations.getTarget(call, "template", false), "parameter", true)).getElement(index);
      return SNodeOperations.copyNode(SLinkOperations.getTarget(templateParameter, "type", true));
    }
    return new TemplateArgumentQuery_Behavior.QuotationClass_8mmc34_a0e0b().createNode();
  }

  public static SNode call_getExpectedReturnType_4035562641222622443(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (SNode) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.generator.structure.TemplateArgumentQuery"), "virtual_getExpectedReturnType_1213877374441", PARAMETERS_4035562641222622443);
  }

  public static SNode callSuper_getExpectedReturnType_4035562641222622443(SNode thisNode, String callerConceptFqName) {
    return (SNode) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.generator.structure.TemplateArgumentQuery"), callerConceptFqName, "virtual_getExpectedReturnType_1213877374441", PARAMETERS_4035562641222622443);
  }

  public static class QuotationClass_8mmc34_a0e0b {
    public QuotationClass_8mmc34_a0e0b() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SNodeType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        result = quotedNode1_2;
      }
      return result;
    }
  }
}
