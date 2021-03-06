package jetbrains.mps.baseLanguage.collections.trove.generator.template.main;

/*Generated by MPS */

import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.generator.template.PropertyMacroContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.baseLanguage.behavior.Type_Behavior;
import jetbrains.mps.lang.core.behavior.BaseConcept_Behavior;
import jetbrains.mps.generator.template.ReferenceMacroContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.generator.template.SourceSubstituteMacroNodeContext;
import jetbrains.mps.generator.template.SourceSubstituteMacroNodesContext;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class QueriesGenerated {
  public static Object propertyMacro_GetPropertyValue_5499565529811713156(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return "T" + SPropertyOperations.getString(SLinkOperations.getTarget(SNodeOperations.as(Type_Behavior.call_getUnboxedType_1213877337320(_context.getNode()), "jetbrains.mps.baseLanguage.structure.ClassifierType"), "classifier", false), "name") + "ListIterator";
  }

  public static Object propertyMacro_GetPropertyValue_5499565529811346601(final IOperationContext operationContext, final PropertyMacroContext _context) {
    String p = BaseConcept_Behavior.call_getPresentation_1213877396640(_context.getNode());
    return "T" + Character.toUpperCase(p.charAt(0)) + StringUtils.substring(p, 1) + "ArrayListDecorator";
  }

  public static Object referenceMacro_GetReferent_5499565529811371608(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    String p = BaseConcept_Behavior.call_getPresentation_1213877396640(_context.getNode());
    return "[gnu.trove]T" + Character.toUpperCase(p.charAt(0)) + StringUtils.substring(p, 1) + "ArrayList";
  }

  public static Object referenceMacro_GetReferent_5499565529811382100(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    String p = BaseConcept_Behavior.call_getPresentation_1213877396640(_context.getNode());
    return "[gnu.trove]T" + Character.toUpperCase(p.charAt(0)) + StringUtils.substring(p, 1) + "ArrayList";
  }

  public static Object referenceMacro_GetReferent_5499565529811760474(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    String p = BaseConcept_Behavior.call_getPresentation_1213877396640(_context.getNode());
    return "T" + Character.toUpperCase(p.charAt(0)) + StringUtils.substring(p, 1) + "ArrayListDecorator";
  }

  public static Object referenceMacro_GetReferent_5499565529811760433(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    String p = BaseConcept_Behavior.call_getPresentation_1213877396640(_context.getNode());
    return "T" + Character.toUpperCase(p.charAt(0)) + StringUtils.substring(p, 1) + "ArrayListDecorator";
  }

  public static Object referenceMacro_GetReferent_5499565529811346969(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return SNodeOperations.as(SLinkOperations.getTarget(SNodeOperations.cast(Type_Behavior.call_getUnboxedType_1213877337320(_context.getNode()), "jetbrains.mps.baseLanguage.structure.ClassifierType"), "classifier", false), "jetbrains.mps.baseLanguage.structure.ClassConcept");
  }

  public static Object referenceMacro_GetReferent_5499565529811382399(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return BaseConcept_Behavior.call_getPresentation_1213877396640(_context.getNode()) + "Value";
  }

  public static SNode sourceNodeQuery_5499565529811713176(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return Type_Behavior.call_getUnboxedType_1213877337320(_context.getNode());
  }

  public static SNode sourceNodeQuery_5499565529811713189(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return Type_Behavior.call_getUnboxedType_1213877337320(_context.getNode());
  }

  public static SNode sourceNodeQuery_5499565529811713202(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return Type_Behavior.call_getUnboxedType_1213877337320(_context.getNode());
  }

  public static SNode sourceNodeQuery_5499565529811713225(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return Type_Behavior.call_getUnboxedType_1213877337320(_context.getNode());
  }

  public static SNode sourceNodeQuery_5499565529811713240(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return Type_Behavior.call_getUnboxedType_1213877337320(_context.getNode());
  }

  public static SNode sourceNodeQuery_5499565529811356535(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return Type_Behavior.call_getUnboxedType_1213877337320(_context.getNode());
  }

  public static SNode sourceNodeQuery_5499565529811356518(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return Type_Behavior.call_getUnboxedType_1213877337320(_context.getNode());
  }

  public static SNode sourceNodeQuery_5499565529811356589(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return Type_Behavior.call_getUnboxedType_1213877337320(_context.getNode());
  }

  public static SNode sourceNodeQuery_5499565529811356603(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return Type_Behavior.call_getUnboxedType_1213877337320(_context.getNode());
  }

  public static SNode sourceNodeQuery_5499565529811356612(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return Type_Behavior.call_getUnboxedType_1213877337320(_context.getNode());
  }

  public static SNode sourceNodeQuery_5499565529811356623(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return Type_Behavior.call_getUnboxedType_1213877337320(_context.getNode());
  }

  public static SNode sourceNodeQuery_5499565529811356632(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return Type_Behavior.call_getUnboxedType_1213877337320(_context.getNode());
  }

  public static SNode sourceNodeQuery_5499565529811356641(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return Type_Behavior.call_getUnboxedType_1213877337320(_context.getNode());
  }

  public static SNode sourceNodeQuery_5499565529811356649(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return Type_Behavior.call_getUnboxedType_1213877337320(_context.getNode());
  }

  public static SNode sourceNodeQuery_5499565529811356665(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return Type_Behavior.call_getUnboxedType_1213877337320(_context.getNode());
  }

  public static SNode sourceNodeQuery_5499565529811356657(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return Type_Behavior.call_getUnboxedType_1213877337320(_context.getNode());
  }

  public static SNode sourceNodeQuery_5499565529811356673(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return Type_Behavior.call_getUnboxedType_1213877337320(_context.getNode());
  }

  public static SNode sourceNodeQuery_5499565529811356681(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return Type_Behavior.call_getUnboxedType_1213877337320(_context.getNode());
  }

  public static SNode sourceNodeQuery_5499565529811382416(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return Type_Behavior.call_getUnboxedType_1213877337320(_context.getNode());
  }

  public static SNode sourceNodeQuery_5499565529811382365(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return Type_Behavior.call_getUnboxedType_1213877337320(_context.getNode());
  }

  public static SNode sourceNodeQuery_5499565529811356693(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return Type_Behavior.call_getUnboxedType_1213877337320(_context.getNode());
  }

  public static SNode sourceNodeQuery_5499565529811382438(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return _context.getNode();
  }

  public static SNode sourceNodeQuery_5499565529811346924(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return _context.getNode();
  }

  public static SNode sourceNodeQuery_4737294400113015493(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return Type_Behavior.call_getUnboxedType_1213877337320(_context.getNode());
  }

  public static SNode sourceNodeQuery_5499565529811356499(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return _context.getNode();
  }

  public static SNode sourceNodeQuery_5499565529811382391(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return Type_Behavior.call_getUnboxedType_1213877337320(_context.getNode());
  }

  public static Iterable sourceNodesQuery_5499565529811382514(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return ListSequence.fromListAndArray(new ArrayList<SNode>(), new QueriesGenerated.QuotationClass_x583g4_a1a0a43().createNode(), new QueriesGenerated.QuotationClass_x583g4_a2a0a43().createNode(), new QueriesGenerated.QuotationClass_x583g4_a3a0a43().createNode(), new QueriesGenerated.QuotationClass_x583g4_a4a0a43().createNode(), new QueriesGenerated.QuotationClass_x583g4_a5a0a43().createNode(), new QueriesGenerated.QuotationClass_x583g4_a6a0a43().createNode());
  }

  public static class QuotationClass_x583g4_a1a0a43 {
    public QuotationClass_x583g4_a1a0a43() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ByteType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        result = quotedNode1_2;
      }
      return result;
    }
  }

  public static class QuotationClass_x583g4_a2a0a43 {
    public QuotationClass_x583g4_a2a0a43() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.DoubleType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        result = quotedNode1_2;
      }
      return result;
    }
  }

  public static class QuotationClass_x583g4_a3a0a43 {
    public QuotationClass_x583g4_a3a0a43() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.FloatType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        result = quotedNode1_2;
      }
      return result;
    }
  }

  public static class QuotationClass_x583g4_a4a0a43 {
    public QuotationClass_x583g4_a4a0a43() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.IntegerType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        result = quotedNode1_2;
      }
      return result;
    }
  }

  public static class QuotationClass_x583g4_a5a0a43 {
    public QuotationClass_x583g4_a5a0a43() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.LongType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        result = quotedNode1_2;
      }
      return result;
    }
  }

  public static class QuotationClass_x583g4_a6a0a43 {
    public QuotationClass_x583g4_a6a0a43() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ShortType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        result = quotedNode1_2;
      }
      return result;
    }
  }
}
