package jetbrains.mps.ui.generator.template.variants;

/*Generated by MPS */

import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.generator.template.DropRootRuleContext;
import jetbrains.mps.ui.multiplexing.VariantsUtil;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.generator.template.BaseMappingRuleContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.generator.template.PropertyMacroContext;
import jetbrains.mps.lang.core.behavior.INamedConcept_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.generator.template.ReferenceMacroContext;
import jetbrains.mps.generator.template.IfMacroContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.generator.template.SourceSubstituteMacroNodeContext;
import jetbrains.mps.generator.template.SourceSubstituteMacroNodesContext;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.generator.template.MapSrcMacroContext;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.smodel.SNodeId;
import jetbrains.mps.lang.typesystem.runtime.HUtil;

public class QueriesGenerated {
  public static boolean dropRootRule_Condition_8590671622325733980(final IOperationContext operationContext, final DropRootRuleContext _context) {
    return VariantsUtil.hasGenerateVariants(SNodeOperations.as(_context.getNode(), "jetbrains.mps.baseLanguage.structure.HasAnnotation")) && VariantsUtil.withinVariant(_context.getNode()) == null;
  }

  public static boolean baseMappingRule_Condition_3210848622155026174(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return SNodeOperations.getModel(_context.getNode()) == SNodeOperations.getModel(SLinkOperations.getTarget(_context.getNode(), "classifier", false));
  }

  public static boolean baseMappingRule_Condition_3210848622155026230(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    String wv = VariantsUtil.withinVariant(_context.getNode());
    return wv != null && VariantsUtil.hasGenerateVariant(SLinkOperations.getTarget(_context.getNode(), "classifier", false), wv);
  }

  public static boolean baseMappingRule_Condition_7346866931625615673(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return SNodeOperations.getModel(_context.getNode()) == SNodeOperations.getModel(SLinkOperations.getTarget(_context.getNode(), "baseMethodDeclaration", false));
  }

  public static boolean baseMappingRule_Condition_7346866931625605029(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    String wv = VariantsUtil.withinVariant(_context.getNode());
    return wv != null && VariantsUtil.hasGenerateVariant(SNodeOperations.getAncestor(SLinkOperations.getTarget(_context.getNode(), "baseMethodDeclaration", false), "jetbrains.mps.baseLanguage.structure.ClassConcept", false, false), wv);
  }

  public static boolean baseMappingRule_Condition_3210848622155838489(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return VariantsUtil.isGenerateVariantsAnn(_context.getNode());
  }

  public static boolean baseMappingRule_Condition_3210848622155981053(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return VariantsUtil.hasGenerateVariants(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_3210848622155026211(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return INamedConcept_Behavior.call_getFqName_1213877404258(SLinkOperations.getTarget(_context.getNode(), "classifier", false)) + "_" + VariantsUtil.withinVariant(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_3210848622155981147(final IOperationContext operationContext, final PropertyMacroContext _context) {
    String sfx = "_" + VariantsUtil.withinVariant(_context.getNode());
    String res = SPropertyOperations.getString(_context.getNode(), "name");
    if (res.endsWith(sfx)) {
      res = res.substring(0, res.length() - sfx.length());
    }
    return res + "_" + Sequence.fromIterable(VariantsUtil.generateVariants(_context.getNode())).first();
  }

  public static Object propertyMacro_GetPropertyValue_3210848622155981205(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return Sequence.fromIterable(VariantsUtil.generateVariants(_context.getNode())).first();
  }

  public static Object referenceMacro_GetReferent_3210848622155026189(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return SPropertyOperations.getString(SLinkOperations.getTarget(_context.getNode(), "classifier", false), "name") + "_" + VariantsUtil.withinVariant(_context.getCopiedOutputNodeForInputNode(_context.getNode()));
  }

  public static Object referenceMacro_GetReferent_7346866931625615692(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return SPropertyOperations.getString(SNodeOperations.getAncestor(SLinkOperations.getTarget(_context.getNode(), "baseMethodDeclaration", false), "jetbrains.mps.baseLanguage.structure.ClassConcept", false, false), "name") + "_" + VariantsUtil.withinVariant(_context.getCopiedOutputNodeForInputNode(_context.getNode()));
  }

  public static boolean ifMacro_Condition_3210848622155981243(final IOperationContext operationContext, final IfMacroContext _context) {
    return Sequence.fromIterable(VariantsUtil.generateVariants(_context.getNode())).count() > 1;
  }

  public static SNode sourceNodeQuery_3210848622155981195(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "superclass", true);
  }

  public static SNode sourceNodeQuery_3210848622155981279(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "staticInitializer", true);
  }

  public static SNode sourceNodeQuery_3210848622155981288(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "instanceInitializer", true);
  }

  public static Iterable sourceNodesQuery_7346866931625615743(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "actualArgument", true);
  }

  public static Iterable sourceNodesQuery_7346866931625615746(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "typeParameter", true);
  }

  public static Iterable sourceNodesQuery_3210848622155981065(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "staticMethod", true);
  }

  public static Iterable sourceNodesQuery_3210848622155981076(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "method", true);
  }

  public static Iterable sourceNodesQuery_3210848622155981090(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "property", true);
  }

  public static Iterable sourceNodesQuery_3210848622155981100(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "field", true);
  }

  public static Iterable sourceNodesQuery_3210848622155981109(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "staticInnerClassifiers", true);
  }

  public static Iterable sourceNodesQuery_3210848622155981119(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "staticField", true);
  }

  public static Iterable sourceNodesQuery_3210848622155981127(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "implementedInterface", true);
  }

  public static Iterable sourceNodesQuery_3210848622155981139(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "constructor", true);
  }

  public static Iterable sourceNodesQuery_3210848622155981218(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return Sequence.fromIterable(VariantsUtil.generateVariants(_context.getNode())).skip(1).select(new ISelector<String, SNode>() {
      public SNode select(String it) {
        return new QueriesGenerated.QuotationClass_x583g4_a0a0a0a0a62().createNode(it);
      }
    });
  }

  public static Iterable sourceNodesQuery_3210848622155981255(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return ListSequence.fromList(SLinkOperations.getTargets(_context.getNode(), "annotation", true)).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode ann) {
        return !(VariantsUtil.isGenerateVariantsAnn(ann) || VariantsUtil.isVariantAnn(ann));
      }
    });
  }

  public static Iterable sourceNodesQuery_3210848622155981296(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "typeVariableDeclaration", true);
  }

  public static SNode mapSrcMacro_mapper_3210848622155981238(final IOperationContext operationContext, final MapSrcMacroContext _context) {
    return _context.getNode();
  }

  public static SNode mapSrcMacro_mapper_8586335042091303254(final IOperationContext operationContext, final MapSrcMacroContext _context) {
    SNode copy = SNodeOperations.copyNode(_context.getNode());
    ListSequence.fromList(SLinkOperations.getTargets(copy, "annotation", true)).removeWhere(new IWhereFilter<SNode>() {
      public boolean accept(SNode ann) {
        return VariantsUtil.isGenerateVariantsAnn(ann) || VariantsUtil.isVariantAnn(ann);
      }
    });
    ListSequence.fromList(SLinkOperations.getTargets(copy, "annotation", true)).addElement(new QueriesGenerated.QuotationClass_x583g4_a0a0c0eb().createNode(Sequence.fromIterable(VariantsUtil.generateVariants(_context.getNode())).first()));
    if (Sequence.fromIterable(VariantsUtil.generateVariants(_context.getNode())).count() > 1) {
      List<SNode> vals = Sequence.fromIterable(VariantsUtil.generateVariants(_context.getNode())).skip(1).select(new ISelector<String, SNode>() {
        public SNode select(String it) {
          return new QueriesGenerated.QuotationClass_x583g4_a0a0a0a0a0a3a03().createNode(it);
        }
      }).toListSequence();
      ListSequence.fromList(SLinkOperations.getTargets(copy, "annotation", true)).addElement(new QueriesGenerated.QuotationClass_x583g4_a0a0b0d0eb().createNode(vals));
    }
    String sfx = "_" + VariantsUtil.withinVariant(_context.getNode());
    String name = SPropertyOperations.getString(_context.getNode(), "name");
    if (name.endsWith(sfx)) {
      name = name.substring(0, name.length() - sfx.length());
    }
    SPropertyOperations.set(copy, "name", name + "_" + Sequence.fromIterable(VariantsUtil.generateVariants(_context.getNode())).first());
    return copy;
  }

  public static class QuotationClass_x583g4_a0a0a0a0a62 {
    public QuotationClass_x583g4_a0a0a0a0a62() {
    }

    public SNode createNode(Object parameter_3) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.StringLiteral", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.setProperty("value", (String) parameter_3);
        result = quotedNode1_2;
      }
      return result;
    }
  }

  public static class QuotationClass_x583g4_a0a0c0eb {
    public QuotationClass_x583g4_a0a0c0eb() {
    }

    public SNode createNode(Object parameter_7) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      SNode quotedNode_2 = null;
      SNode quotedNode_3 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.AnnotationInstance", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_4 = quotedNode_1;
        quotedNode1_4.addReference(SReference.create("annotation", quotedNode1_4, SModelReference.fromString("r:36693452-2637-4608-8caa-ab32ee7c1be3(jetbrains.mps.ui.multiplexing)"), SNodeId.fromString("8590671622324574702")));
        {
          quotedNode_2 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.AnnotationInstanceValue", null, GlobalScope.getInstance(), false);
          SNode quotedNode1_5 = quotedNode_2;
          quotedNode1_5.addReference(SReference.create("key", quotedNode1_5, SModelReference.fromString("r:36693452-2637-4608-8caa-ab32ee7c1be3(jetbrains.mps.ui.multiplexing)"), SNodeId.fromString("8590671622324574704")));
          {
            quotedNode_3 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.StringLiteral", null, GlobalScope.getInstance(), false);
            SNode quotedNode1_6 = quotedNode_3;
            quotedNode1_6.setProperty("value", (String) parameter_7);
            quotedNode_2.addChild("value", quotedNode1_6);
          }
          quotedNode_1.addChild("value", quotedNode1_5);
        }
        result = quotedNode1_4;
      }
      return result;
    }
  }

  public static class QuotationClass_x583g4_a0a0a0a0a0a3a03 {
    public QuotationClass_x583g4_a0a0a0a0a0a3a03() {
    }

    public SNode createNode(Object parameter_3) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.StringLiteral", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.setProperty("value", (String) parameter_3);
        result = quotedNode1_2;
      }
      return result;
    }
  }

  public static class QuotationClass_x583g4_a0a0b0d0eb {
    public QuotationClass_x583g4_a0a0b0d0eb() {
    }

    public SNode createNode(Object parameter_8) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      SNode quotedNode_2 = null;
      SNode quotedNode_3 = null;
      SNode quotedNode_4 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.AnnotationInstance", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_5 = quotedNode_1;
        quotedNode1_5.addReference(SReference.create("annotation", quotedNode1_5, SModelReference.fromString("r:36693452-2637-4608-8caa-ab32ee7c1be3(jetbrains.mps.ui.multiplexing)"), SNodeId.fromString("8590671622324268192")));
        {
          quotedNode_2 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.AnnotationInstanceValue", null, GlobalScope.getInstance(), false);
          SNode quotedNode1_6 = quotedNode_2;
          quotedNode1_6.addReference(SReference.create("key", quotedNode1_6, SModelReference.fromString("r:36693452-2637-4608-8caa-ab32ee7c1be3(jetbrains.mps.ui.multiplexing)"), SNodeId.fromString("8590671622324287920")));
          {
            quotedNode_3 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ArrayLiteral", null, GlobalScope.getInstance(), false);
            SNode quotedNode1_7 = quotedNode_3;
            {
              List<SNode> nodes = (List<SNode>) parameter_8;
              for (SNode child : nodes) {
                quotedNode_3.addChild("item", HUtil.copyIfNecessary(child));
              }
            }
            quotedNode_2.addChild("value", quotedNode1_7);
          }
          quotedNode_1.addChild("value", quotedNode1_6);
        }
        result = quotedNode1_5;
      }
      return result;
    }
  }
}
