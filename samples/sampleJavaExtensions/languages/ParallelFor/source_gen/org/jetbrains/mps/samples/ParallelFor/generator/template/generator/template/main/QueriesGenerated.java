package org.jetbrains.mps.samples.ParallelFor.generator.template.generator.template.main;

/*Generated by MPS */

import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.generator.template.BaseMappingRuleContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.baseLanguage.behavior.ContinueStatement_Behavior;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.lang.typesystem.runtime.HUtil;
import jetbrains.mps.generator.template.PropertyMacroContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.generator.template.ReferenceMacroContext;
import jetbrains.mps.generator.template.IfMacroContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.generator.template.SourceSubstituteMacroNodeContext;
import jetbrains.mps.generator.template.SourceSubstituteMacroNodesContext;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import jetbrains.mps.baseLanguage.behavior.StatementList_Behavior;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;

public class QueriesGenerated {
  public static boolean baseMappingRule_Condition_8923957828369629274(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return SNodeOperations.isInstanceOf(SLinkOperations.getTarget(_context.getNode(), "variableDeclaration", false), "org.jetbrains.mps.samples.ParallelFor.structure.ParallelLoopVariable");
  }

  public static boolean baseMappingRule_Condition_4697196167065973042(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return SNodeOperations.isInstanceOf(ContinueStatement_Behavior.call_getLoop_1213877346346(_context.getNode()), "org.jetbrains.mps.samples.ParallelFor.structure.ParallelFor");
  }

  public static boolean baseMappingRule_Condition_7865129668867016083(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return TypeChecker.getInstance().getRuntimeSupport().coerce_(TypeChecker.getInstance().getTypeOf(_context.getNode()), HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.baseLanguage.structure.ArrayType"), true) != null;
  }

  public static Object propertyMacro_GetPropertyValue_5337045848190803509(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return _context.createUniqueName("latch", null);
  }

  public static Object propertyMacro_GetPropertyValue_5337045848190803543(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return _context.createUniqueName("exceptions", null);
  }

  public static Object propertyMacro_GetPropertyValue_633195941006880942(final IOperationContext operationContext, final PropertyMacroContext _context) {
    if (!(SPropertyOperations.getBoolean(SLinkOperations.getTarget(_context.getNode(), "loopVariable", true), "isFinal"))) {
      _context.showErrorMessage(SLinkOperations.getTarget(_context.getNode(), "loopVariable", true), "The loop variable must be final");
    }

    return SPropertyOperations.getString(SLinkOperations.getTarget(_context.getNode(), "loopVariable", true), "name");
  }

  public static Object propertyMacro_GetPropertyValue_633195941006945119(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getInteger(_context.getNode(), "numberOfThreads");
  }

  public static Object referenceMacro_GetReferent_7865129668867189303(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return SNodeOperations.cast(_context.getNode().getReferent("exc"), "jetbrains.mps.baseLanguage.structure.Classifier");
  }

  public static Object referenceMacro_GetReferent_7793246093815939787(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return "localA";
  }

  public static boolean ifMacro_Condition_8374756414439004441(final IOperationContext operationContext, final IfMacroContext _context) {
    return !(SPropertyOperations.getBoolean(_context.getNode(), "nowait"));
  }

  public static boolean ifMacro_Condition_8374756414439004406(final IOperationContext operationContext, final IfMacroContext _context) {
    return !(SPropertyOperations.getBoolean(_context.getNode(), "nowait"));
  }

  public static boolean ifMacro_Condition_633195941006966360(final IOperationContext operationContext, final IfMacroContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "threadPool", true) == null;
  }

  public static boolean ifMacro_Condition_633195941006966388(final IOperationContext operationContext, final IfMacroContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "threadPool", true) != null;
  }

  public static boolean ifMacro_Condition_8374756414438972401(final IOperationContext operationContext, final IfMacroContext _context) {
    return !(SPropertyOperations.getBoolean(_context.getNode(), "nowait"));
  }

  public static SNode sourceNodeQuery_7865129668866947390(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SNodeOperations.copyNode(SLinkOperations.getTarget(_context.getNode(), "inputSequence", true));
  }

  public static SNode sourceNodeQuery_633195941006833439(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return TypeChecker.getInstance().getTypeOf(SLinkOperations.getTarget(_context.getNode(), "loopVariable", true));
  }

  public static SNode sourceNodeQuery_4659204813808539958(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "threadPool", true);
  }

  public static SNode sourceNodeQuery_633195941006880920(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return TypeChecker.getInstance().getTypeOf(SLinkOperations.getTarget(_context.getNode(), "loopVariable", true));
  }

  public static SNode sourceNodeQuery_7865129668866947450(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SNodeOperations.copyNode(SLinkOperations.getTarget(_context.getNode(), "inputSequence", true));
  }

  public static SNode sourceNodeQuery_7865129668867016139(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return _context.getNode();
  }

  public static SNode sourceNodeQuery_7865129668867016163(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return _context.getNode();
  }

  public static Iterable sourceNodesQuery_633195941006921760(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(SLinkOperations.getTarget(_context.getNode(), "body", true), "statement", true);
  }

  public static Iterable sourceNodesQuery_5337045848190669725(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SetSequence.fromSet(StatementList_Behavior.call_uncaughtThrowables_3331512479731115649(SLinkOperations.getTarget(_context.getNode(), "body", true), false)).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return it != SNodeOperations.getNode("f:java_stub#6354ebe7-c22a-4a0f-ac54-50b52ab9b065#java.lang(JDK/java.lang@java_stub)", "~RuntimeException");
      }
    }).select(new ISelector<SNode, SNode>() {
      public SNode select(SNode it) {
        SNode n = SModelOperations.createNewNode(_context.getOutputModel(), "jetbrains.mps.lang.core.structure.BaseConcept", null);
        n.setReferent("exc", it, false);
        return n;
      }
    }).toListSequence();
  }
}
