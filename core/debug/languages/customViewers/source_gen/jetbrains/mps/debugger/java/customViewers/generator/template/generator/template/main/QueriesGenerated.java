package jetbrains.mps.debugger.java.customViewers.generator.template.generator.template.main;

/*Generated by MPS */

import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.generator.template.CreateRootRuleContext;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.generator.template.PropertyMacroContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.debug.evaluation.transform.TransformatorBuilder;
import jetbrains.mps.debugger.java.customViewers.behavior.HighLevelCustomViewer_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.generator.template.ReferenceMacroContext;
import jetbrains.mps.generator.template.IfMacroContext;
import org.apache.commons.lang.StringUtils;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.generator.template.SourceSubstituteMacroNodeContext;
import jetbrains.mps.generator.template.SourceSubstituteMacroNodesContext;
import jetbrains.mps.generator.template.MapSrcMacroPostProcContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.AttributeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.IAttributeDescriptor;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.IVisitor;
import jetbrains.mps.generator.template.MappingScriptContext;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.smodel.SNodeId;

public class QueriesGenerated {
  public static boolean createRootRule_Condition_722903304966670752(final IOperationContext operationContext, final CreateRootRuleContext _context) {
    return ListSequence.fromList(SModelOperations.getRoots(_context.getInputModel(), "jetbrains.mps.debugger.java.customViewers.structure.CustomViewer")).isNotEmpty() || ListSequence.fromList(SModelOperations.getRoots(_context.getInputModel(), "jetbrains.mps.debugger.java.customViewers.structure.HighLevelCustomViewer")).isNotEmpty();
  }

  public static Object propertyMacro_GetPropertyValue_4089989733346843322(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name");
  }

  public static Object propertyMacro_GetPropertyValue_399126674726715728(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return "MyWatchable_" + SPropertyOperations.getString(_context.getNode(), "name");
  }

  public static Object propertyMacro_GetPropertyValue_4089989733346843071(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name");
  }

  public static Object propertyMacro_GetPropertyValue_264293128390879124(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name") + "Wrapper";
  }

  public static Object propertyMacro_GetPropertyValue_6446777246631435404(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return TransformatorBuilder.getInstance().getJniSignatureFromType(HighLevelCustomViewer_Behavior.call_getValueTypeCopy_43370322128260022(_context.getNode()));
  }

  public static Object propertyMacro_GetPropertyValue_264293128390879201(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return HighLevelCustomViewer_Behavior.call_getClassName_7570572250661284600(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_8275758777999533495(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(SLinkOperations.getTarget(_context.getNode(), "watchable", false), "name");
  }

  public static Object propertyMacro_GetPropertyValue_722903304966670688(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return HighLevelCustomViewer_Behavior.call_getClassFqName_7570572250661287362(_context.getNode());
  }

  public static Object referenceMacro_GetReferent_8275758777999533505(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return ListSequence.fromList(SLinkOperations.getTargets(_context.getOutputNodeByInputNodeAndMappingLabel(SLinkOperations.getTarget(_context.getNode(), "watchable", false), "watchable"), "constructor", true)).first();
  }

  public static boolean ifMacro_Condition_4089989733346843275(final IOperationContext operationContext, final IfMacroContext _context) {
    return StringUtils.isNotEmpty(SPropertyOperations.getString(_context.getNode(), "iconPath"));
  }

  public static boolean ifMacro_Condition_264293128390879160(final IOperationContext operationContext, final IfMacroContext _context) {
    return (SLinkOperations.getTarget(_context.getNode(), "getPresentation", true) != null);
  }

  public static boolean ifMacro_Condition_7785669630792594441(final IOperationContext operationContext, final IfMacroContext _context) {
    return (SLinkOperations.getTarget(_context.getNode(), "getPresentation", true) != null);
  }

  public static boolean ifMacro_Condition_5493844864801812989(final IOperationContext operationContext, final IfMacroContext _context) {
    return (SLinkOperations.getTarget(_context.getNode(), "canWrap", true) != null);
  }

  public static boolean ifMacro_Condition_2685024263846493110(final IOperationContext operationContext, final IfMacroContext _context) {
    return (SLinkOperations.getTarget(_context.getNode(), "canWrap", true) != null);
  }

  public static SNode sourceNodeQuery_3798344557789646276(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return TransformatorBuilder.getInstance().getProxyTypeFromType(HighLevelCustomViewer_Behavior.call_getValueTypeCopy_43370322128260022(_context.getNode()));
  }

  public static SNode sourceNodeQuery_6588495380858422615(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "getWatchables", true), "body", true);
  }

  public static SNode sourceNodeQuery_6588495380858423210(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return TransformatorBuilder.getInstance().getProxyTypeFromType(HighLevelCustomViewer_Behavior.call_getValueTypeCopy_43370322128260022(_context.getNode()));
  }

  public static SNode sourceNodeQuery_7785669630792626876(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return TransformatorBuilder.getInstance().getProxyTypeFromType(HighLevelCustomViewer_Behavior.call_getValueTypeCopy_43370322128260022(_context.getNode()));
  }

  public static SNode sourceNodeQuery_7785669630792594432(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return TransformatorBuilder.getInstance().getProxyTypeFromType(HighLevelCustomViewer_Behavior.call_getValueTypeCopy_43370322128260022(_context.getNode()));
  }

  public static SNode sourceNodeQuery_7785669630792594457(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "getPresentation", true), "body", true);
  }

  public static SNode sourceNodeQuery_5493844864801812976(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return TransformatorBuilder.getInstance().getProxyTypeFromType(HighLevelCustomViewer_Behavior.call_getValueTypeCopy_43370322128260022(_context.getNode()));
  }

  public static SNode sourceNodeQuery_2685024263846491797(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return TransformatorBuilder.getInstance().getProxyTypeFromType(HighLevelCustomViewer_Behavior.call_getValueTypeCopy_43370322128260022(_context.getNode()));
  }

  public static SNode sourceNodeQuery_2685024263846491806(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "canWrap", true), "body", true);
  }

  public static SNode sourceNodeQuery_4599835250971300521(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "valueProxyType", true);
  }

  public static SNode sourceNodeQuery_4838833313499857351(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "value", true);
  }

  public static Iterable sourceNodesQuery_4089989733346843285(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "watchable", true);
  }

  public static Iterable sourceNodesQuery_5726067590290743628(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return ListSequence.fromList(SModelOperations.getRoots(_context.getInputModel(), "jetbrains.mps.debugger.java.customViewers.structure.HighLevelCustomViewer")).union(ListSequence.fromList(SModelOperations.getRoots(_context.getInputModel(), "jetbrains.mps.debugger.java.customViewers.structure.CustomViewer")));
  }

  public static void mapSrcMacro_post_mapper_721063219978405017(final IOperationContext operationContext, final MapSrcMacroPostProcContext _context) {
    AttributeOperations.createAndSetAttrbiute(_context.getOutputNode(), new IAttributeDescriptor.NodeAttribute(SConceptOperations.findConceptDeclaration("jetbrains.mps.debugger.java.customViewers.structure.ToProcessMethod")), "jetbrains.mps.debugger.java.customViewers.structure.ToProcessMethod");
  }

  public static void mapSrcMacro_post_mapper_721063219978405039(final IOperationContext operationContext, final MapSrcMacroPostProcContext _context) {
    AttributeOperations.createAndSetAttrbiute(_context.getOutputNode(), new IAttributeDescriptor.NodeAttribute(SConceptOperations.findConceptDeclaration("jetbrains.mps.debugger.java.customViewers.structure.ToProcessMethod")), "jetbrains.mps.debugger.java.customViewers.structure.ToProcessMethod");
  }

  public static void mapSrcMacro_post_mapper_721063219978402837(final IOperationContext operationContext, final MapSrcMacroPostProcContext _context) {
    AttributeOperations.createAndSetAttrbiute(_context.getOutputNode(), new IAttributeDescriptor.NodeAttribute(SConceptOperations.findConceptDeclaration("jetbrains.mps.debugger.java.customViewers.structure.ToProcessMethod")), "jetbrains.mps.debugger.java.customViewers.structure.ToProcessMethod");
  }

  public static void mapSrcMacro_post_mapper_1123500463147192694(final IOperationContext operationContext, final MapSrcMacroPostProcContext _context) {
    AttributeOperations.createAndSetAttrbiute(_context.getOutputNode(), new IAttributeDescriptor.NodeAttribute(SConceptOperations.findConceptDeclaration("jetbrains.mps.debugger.java.evaluation.structure.DoNotTransformAnnotation")), "jetbrains.mps.debugger.java.evaluation.structure.DoNotTransformAnnotation");
  }

  public static void mapSrcMacro_post_mapper_4838833313499857391(final IOperationContext operationContext, final MapSrcMacroPostProcContext _context) {
    AttributeOperations.createAndSetAttrbiute(_context.getOutputNode(), new IAttributeDescriptor.NodeAttribute(SConceptOperations.findConceptDeclaration("jetbrains.mps.debugger.java.evaluation.structure.DoNotTransformAnnotation")), "jetbrains.mps.debugger.java.evaluation.structure.DoNotTransformAnnotation");
  }

  public static void mapSrcMacro_post_mapper_4838833313499857358(final IOperationContext operationContext, final MapSrcMacroPostProcContext _context) {
    AttributeOperations.createAndSetAttrbiute(_context.getOutputNode(), new IAttributeDescriptor.NodeAttribute(SConceptOperations.findConceptDeclaration("jetbrains.mps.debugger.java.evaluation.structure.DoNotTransformAnnotation")), "jetbrains.mps.debugger.java.evaluation.structure.DoNotTransformAnnotation");
  }

  public static void mapSrcMacro_post_mapper_4838833313499857371(final IOperationContext operationContext, final MapSrcMacroPostProcContext _context) {
    AttributeOperations.createAndSetAttrbiute(_context.getOutputNode(), new IAttributeDescriptor.NodeAttribute(SConceptOperations.findConceptDeclaration("jetbrains.mps.debugger.java.evaluation.structure.DoNotTransformAnnotation")), "jetbrains.mps.debugger.java.evaluation.structure.DoNotTransformAnnotation");
  }

  public static void mapSrcMacro_post_mapper_4838833313499857381(final IOperationContext operationContext, final MapSrcMacroPostProcContext _context) {
    AttributeOperations.createAndSetAttrbiute(_context.getOutputNode(), new IAttributeDescriptor.NodeAttribute(SConceptOperations.findConceptDeclaration("jetbrains.mps.debugger.java.evaluation.structure.DoNotTransformAnnotation")), "jetbrains.mps.debugger.java.evaluation.structure.DoNotTransformAnnotation");
  }

  public static void mapSrcMacro_post_mapper_1464575230816145950(final IOperationContext operationContext, final MapSrcMacroPostProcContext _context) {
    AttributeOperations.createAndSetAttrbiute(_context.getOutputNode(), new IAttributeDescriptor.NodeAttribute(SConceptOperations.findConceptDeclaration("jetbrains.mps.debugger.java.evaluation.structure.DoNotTransformAnnotation")), "jetbrains.mps.debugger.java.evaluation.structure.DoNotTransformAnnotation");
  }

  public static void mapSrcMacro_post_mapper_8256349518541671180(final IOperationContext operationContext, final MapSrcMacroPostProcContext _context) {
    AttributeOperations.createAndSetAttrbiute(_context.getOutputNode(), new IAttributeDescriptor.NodeAttribute(SConceptOperations.findConceptDeclaration("jetbrains.mps.debugger.java.evaluation.structure.DoNotTransformAnnotation")), "jetbrains.mps.debugger.java.evaluation.structure.DoNotTransformAnnotation");
    ListSequence.fromList(SNodeOperations.getDescendants(_context.getOutputNode(), null, false, new String[]{})).visitAll(new IVisitor<SNode>() {
      public void visit(SNode it) {
        AttributeOperations.createAndSetAttrbiute(it, new IAttributeDescriptor.NodeAttribute(SConceptOperations.findConceptDeclaration("jetbrains.mps.debugger.java.evaluation.structure.DoNotTransformAnnotation")), "jetbrains.mps.debugger.java.evaluation.structure.DoNotTransformAnnotation");
      }
    });
  }

  public static void mapSrcMacro_post_mapper_1855642807426525752(final IOperationContext operationContext, final MapSrcMacroPostProcContext _context) {
    AttributeOperations.createAndSetAttrbiute(_context.getOutputNode(), new IAttributeDescriptor.NodeAttribute(SConceptOperations.findConceptDeclaration("jetbrains.mps.debugger.java.evaluation.structure.DoNotTransformAnnotation")), "jetbrains.mps.debugger.java.evaluation.structure.DoNotTransformAnnotation");
  }

  public static void mappingScript_CodeBlock_264293128390891135(final IOperationContext operationContext, final MappingScriptContext _context) {
    for (SNode classConcept : ListSequence.fromList(SModelOperations.getRoots(_context.getModel(), "jetbrains.mps.baseLanguage.structure.ClassConcept"))) {
      if (eq_x583g4_a0a0a0a93(SLinkOperations.getTarget(SLinkOperations.getTarget(classConcept, "superclass", true), "classifier", false), SLinkOperations.getTarget(new QueriesGenerated.QuotationClass_x583g4_a0a0a0a0a93().createNode(), "classifier", false)) && SPropertyOperations.getString(classConcept, "name").endsWith("_WrapperFactory")) {
        for (SNode method : ListSequence.fromList(SNodeOperations.getDescendants(classConcept, "jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration", false, new String[]{})).where(new IWhereFilter<SNode>() {
          public boolean accept(SNode it) {
            return (AttributeOperations.getAttribute(it, new IAttributeDescriptor.NodeAttribute(SConceptOperations.findConceptDeclaration("jetbrains.mps.debugger.java.customViewers.structure.ToProcessMethod"))) != null);
          }
        })) {
          if ((method == null)) {
            continue;
          }
          TransformatorBuilder.getInstance().build(method, false).transform();
        }
      }
    }
  }

  public static void mappingScript_CodeBlock_4599835250971319477(final IOperationContext operationContext, final MappingScriptContext _context) {
    for (SNode viewer : ListSequence.fromList(SModelOperations.getRoots(_context.getModel(), "jetbrains.mps.debugger.java.customViewers.structure.HighLevelCustomViewer"))) {
      SNode valueProxyType = TransformatorBuilder.getInstance().getProxyTypeFromType(HighLevelCustomViewer_Behavior.call_getValueTypeCopy_43370322128260022(viewer));
      for (SNode valueParameter : ListSequence.fromList(SNodeOperations.getDescendants(viewer, "jetbrains.mps.debugger.java.customViewers.structure.HighLevelValue_ConceptFunctionParameter", false, new String[]{}))) {
        SLinkOperations.setTarget(valueParameter, "valueProxyType", SNodeOperations.copyNode(valueProxyType), true);
      }
    }
  }

  private static boolean eq_x583g4_a0a0a0a93(Object a, Object b) {
    return (a != null ?
      a.equals(b) :
      a == b
    );
  }

  public static class QuotationClass_x583g4_a0a0a0a0a93 {
    public QuotationClass_x583g4_a0a0a0a0a93() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.addReference(SReference.create("classifier", quotedNode1_2, SModelReference.fromString("f:java_stub#86441d7a-e194-42da-81a5-2161ec62a379#jetbrains.mps.debug.runtime.java.programState.proxies(MPS.Workbench/jetbrains.mps.debug.runtime.java.programState.proxies@java_stub)"), SNodeId.fromString("~ValueWrapperFactory")));
        result = quotedNode1_2;
      }
      return result;
    }
  }
}
