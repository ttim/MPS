package jetbrains.mps.xmlQuery.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.xmlQuery.constraints.SchemaUtil;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.smodel.behaviour.BehaviorManager;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.smodel.SNodeId;
import jetbrains.mps.lang.typesystem.runtime.HUtil;

public class ElementBuilder_Behavior {
  private static Class[] PARAMETERS_1384720974900260447 = {SNode.class};
  private static Class[] PARAMETERS_1384720974900260456 = {SNode.class, SNode.class};
  private static Class[] PARAMETERS_1384720974900260473 = {SNode.class, SNode.class, SNode.class, SNode.class};

  public static void init(SNode thisNode) {
  }

  public static SNode virtual_getResultType_7057666463730718251(SNode thisNode) {
    return SchemaUtil.constructXMLElementTypeForElement(SLinkOperations.getTarget(thisNode, "elementDeclaration", false));
  }

  public static SNode virtual_getCreatorExpression_7057666463730727863(SNode thisNode, SNode parentRef) {
    return new ElementBuilder_Behavior.QuotationClass_w52xu1_a0a0c().createNode(SPropertyOperations.getString(SLinkOperations.getTarget(thisNode, "elementDeclaration", false), "elementName"));
  }

  public static SNode virtual_getAttachStatementChild_4797501453850305563(SNode thisNode, SNode parentBuilder, SNode parentRef, SNode childRef) {
    return new ElementBuilder_Behavior.QuotationClass_w52xu1_a0a0d().createNode(parentRef, childRef);
  }

  public static SNode call_getComplexType_1384720974900281910(SNode thisNode) {
    if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(thisNode, "elementDeclaration", false), "jetbrains.mps.xmlSchema.structure.ElementWithType")) {
      return SLinkOperations.getTarget(SLinkOperations.getTarget(SNodeOperations.cast(SLinkOperations.getTarget(thisNode, "elementDeclaration", false), "jetbrains.mps.xmlSchema.structure.ElementWithType"), "complexTypeReference", true), "complexType", false);
    } else if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(thisNode, "elementDeclaration", false), "jetbrains.mps.xmlSchema.structure.ElementWithContent")) {
      return SLinkOperations.getTarget(SNodeOperations.cast(SLinkOperations.getTarget(thisNode, "elementDeclaration", false), "jetbrains.mps.xmlSchema.structure.ElementWithContent"), "complexType", true);
    } else {
      assert false;
      return null;
    }
  }

  public static SNode call_getResultType_1384720974900260447(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (SNode) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.xmlQuery.structure.ElementBuilder"), "virtual_getResultType_7057666463730718251", PARAMETERS_1384720974900260447, new Object[]{});
  }

  public static SNode call_getCreatorExpression_1384720974900260456(SNode thisNode, SNode parentRef) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (SNode) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.xmlQuery.structure.ElementBuilder"), "virtual_getCreatorExpression_7057666463730727863", PARAMETERS_1384720974900260456, new Object[]{parentRef});
  }

  public static SNode call_getAttachStatementChild_1384720974900260473(SNode thisNode, SNode parentBuilder, SNode parentRef, SNode childRef) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (SNode) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.xmlQuery.structure.ElementBuilder"), "virtual_getAttachStatementChild_4797501453850305563", PARAMETERS_1384720974900260473, new Object[]{parentBuilder, parentRef, childRef});
  }

  public static SNode callSuper_getResultType_1384720974900260447(SNode thisNode, String callerConceptFqName) {
    return (SNode) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.xmlQuery.structure.ElementBuilder"), callerConceptFqName, "virtual_getResultType_7057666463730718251", PARAMETERS_1384720974900260447, new Object[]{});
  }

  public static SNode callSuper_getCreatorExpression_1384720974900260456(SNode thisNode, String callerConceptFqName, SNode parentRef) {
    return (SNode) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.xmlQuery.structure.ElementBuilder"), callerConceptFqName, "virtual_getCreatorExpression_7057666463730727863", PARAMETERS_1384720974900260456, new Object[]{parentRef});
  }

  public static SNode callSuper_getAttachStatementChild_1384720974900260473(SNode thisNode, String callerConceptFqName, SNode parentBuilder, SNode parentRef, SNode childRef) {
    return (SNode) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.xmlQuery.structure.ElementBuilder"), callerConceptFqName, "virtual_getAttachStatementChild_4797501453850305563", PARAMETERS_1384720974900260473, new Object[]{parentBuilder, parentRef, childRef});
  }

  public static class QuotationClass_w52xu1_a0a0c {
    public QuotationClass_w52xu1_a0a0c() {
    }

    public SNode createNode(Object parameter_7) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      SNode quotedNode_2 = null;
      SNode quotedNode_3 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.GenericNewExpression", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_4 = quotedNode_1;
        {
          quotedNode_2 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassCreator", null, GlobalScope.getInstance(), false);
          SNode quotedNode1_5 = quotedNode_2;
          quotedNode1_5.addReference(SReference.create("baseMethodDeclaration", quotedNode1_5, SModelReference.fromString("f:java_stub#6ed54515-acc8-4d1e-a16c-9fd6cfe951ea#org.jdom(MPS.Core/org.jdom@java_stub)"), SNodeId.fromString("~Element.<init>(java.lang.String)")));
          {
            quotedNode_3 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.StringLiteral", null, GlobalScope.getInstance(), false);
            SNode quotedNode1_6 = quotedNode_3;
            quotedNode1_6.setProperty("value", (String) parameter_7);
            quotedNode_2.addChild("actualArgument", quotedNode1_6);
          }
          quotedNode_1.addChild("creator", quotedNode1_5);
        }
        result = quotedNode1_4;
      }
      return result;
    }
  }

  public static class QuotationClass_w52xu1_a0a0d {
    public QuotationClass_w52xu1_a0a0d() {
    }

    public SNode createNode(Object parameter_13, Object parameter_14) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      SNode quotedNode_2 = null;
      SNode quotedNode_3 = null;
      SNode quotedNode_4 = null;
      SNode quotedNode_5 = null;
      SNode quotedNode_6 = null;
      SNode quotedNode_7 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ExpressionStatement", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_8 = quotedNode_1;
        {
          quotedNode_2 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.DotExpression", null, GlobalScope.getInstance(), false);
          SNode quotedNode1_9 = quotedNode_2;
          {
            quotedNode_3 = (SNode) parameter_13;
            SNode quotedNode1_10;
            if (_parameterValues_129834374.contains(quotedNode_3)) {
              quotedNode1_10 = HUtil.copyIfNecessary(quotedNode_3);
            } else {
              _parameterValues_129834374.add(quotedNode_3);
              quotedNode1_10 = quotedNode_3;
            }
            if (quotedNode1_10 != null) {
              quotedNode_2.addChild("operand", HUtil.copyIfNecessary(quotedNode1_10));
            }
          }
          {
            quotedNode_4 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation", null, GlobalScope.getInstance(), false);
            SNode quotedNode1_11 = quotedNode_4;
            quotedNode1_11.addReference(SReference.create("baseMethodDeclaration", quotedNode1_11, SModelReference.fromString("f:java_stub#6ed54515-acc8-4d1e-a16c-9fd6cfe951ea#org.jdom(MPS.Core/org.jdom@java_stub)"), SNodeId.fromString("~Element.addContent(org.jdom.Element):org.jdom.Element")));
            {
              quotedNode_6 = (SNode) parameter_14;
              SNode quotedNode1_12;
              if (_parameterValues_129834374.contains(quotedNode_6)) {
                quotedNode1_12 = HUtil.copyIfNecessary(quotedNode_6);
              } else {
                _parameterValues_129834374.add(quotedNode_6);
                quotedNode1_12 = quotedNode_6;
              }
              if (quotedNode1_12 != null) {
                quotedNode_4.addChild("actualArgument", HUtil.copyIfNecessary(quotedNode1_12));
              }
            }
            quotedNode_2.addChild("operation", quotedNode1_11);
          }
          quotedNode_1.addChild("expression", quotedNode1_9);
        }
        result = quotedNode1_8;
      }
      return result;
    }
  }
}
