package jetbrains.mps.build.packaging.mps.generator.template.main;

/*Generated by MPS */

import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.generator.template.CreateRootRuleContext;
import jetbrains.mps.build.packaging.mps.generator.template.util.CheckUtil;
import jetbrains.mps.generator.template.PropertyMacroContext;
import jetbrains.mps.build.packaging.behavior.Path_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.generator.template.IfMacroContext;
import jetbrains.mps.baseLanguage.tuples.runtime.Tuples;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.baseLanguage.tuples.runtime.MultiTuple;
import java.util.Set;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import java.util.HashSet;
import jetbrains.mps.generator.template.SourceSubstituteMacroNodesContext;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.internal.collections.runtime.ITranslator2;
import jetbrains.mps.build.packaging.behavior.Module_Behavior;
import jetbrains.mps.generator.template.MappingScriptContext;

public class QueriesGenerated {
  public static boolean createRootRule_Condition_3583849467507868254(final IOperationContext operationContext, final CreateRootRuleContext _context) {
    return CheckUtil.isInMpsAutobuild(_context.getOriginalInputModel());
  }

  public static Object propertyMacro_GetPropertyValue_8037435193861318521(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return Path_Behavior.call_getFullPathWithoutMacro_1226511495568(SLinkOperations.getTarget(SNodeOperations.as(_context.getNode(), "jetbrains.mps.build.packaging.structure.Copy"), "sourcePath", true));
  }

  public static Object propertyMacro_GetPropertyValue_8037435193861318577(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "fullPath");
  }

  public static boolean ifMacro_Condition_1479728067424414700(final IOperationContext operationContext, final IfMacroContext _context) {
    Tuples._2<SModel, String> key = MultiTuple.<SModel,String>from(_context.getInputModel(), "idea.additional.classpath");
    Set<String> processedPaths = (Set<String>) _context.getTransientObject(key);
    if (processedPaths == null) {
      processedPaths = SetSequence.fromSet(new HashSet<String>());
      _context.putTransientObject(key, processedPaths);
    }
    boolean wasNotProcesses = !(SetSequence.fromSet(processedPaths).contains(SPropertyOperations.getString(_context.getNode(), "fullPath")));
    if (wasNotProcesses) {
      SetSequence.fromSet(processedPaths).addElement(SPropertyOperations.getString(_context.getNode(), "fullPath"));
    }
    return wasNotProcesses;
  }

  public static Iterable sourceNodesQuery_8037435193861318531(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return ListSequence.fromList(SModelOperations.getRoots(_context.getInputModel(), "jetbrains.mps.build.packaging.structure.Block")).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode blk) {
        return "idea-patch.jar".equals(SPropertyOperations.getString(blk, "name")) || "mps.jar".equals(SPropertyOperations.getString(blk, "name"));
      }
    }).<SNode>translate(new ITranslator2<SNode, SNode>() {
      public Iterable<SNode> translate(SNode blk) {
        return SLinkOperations.getTargets(SNodeOperations.as(ListSequence.fromList(SLinkOperations.getTargets(blk, "entry", true)).first(), "jetbrains.mps.build.packaging.structure.ICompositeComponent"), "entry", true);
      }
    }).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return SNodeOperations.isInstanceOf(it, "jetbrains.mps.build.packaging.structure.Copy");
      }
    });
  }

  public static Iterable sourceNodesQuery_8037435193861318584(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return ListSequence.fromList(SModelOperations.getRoots(_context.getInputModel(), "jetbrains.mps.build.packaging.structure.Block")).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode blk) {
        return "core.baseLanguage".equals(SPropertyOperations.getString(blk, "name")) || "core.languageDesign".equals(SPropertyOperations.getString(blk, "name"));
      }
    }).<SNode>translate(new ITranslator2<SNode, SNode>() {
      public Iterable<SNode> translate(SNode blk) {
        return SLinkOperations.getTargets(SNodeOperations.as(ListSequence.fromList(SLinkOperations.getTargets(blk, "entry", true)).first(), "jetbrains.mps.build.packaging.structure.ICompositeComponent"), "entry", true);
      }
    });
  }

  public static Iterable sourceNodesQuery_8037435193861318628(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return ListSequence.fromList(Module_Behavior.call_getClassPath_1213877515083(SNodeOperations.as(_context.getNode(), "jetbrains.mps.build.packaging.structure.Module"))).concat(ListSequence.fromList(Module_Behavior.call_getRuntimeClassPath_1213877515098(SNodeOperations.as(_context.getNode(), "jetbrains.mps.build.packaging.structure.Module"))));
  }

  public static void mappingScript_CodeBlock_3583849467508042413(final IOperationContext operationContext, final MappingScriptContext _context) {
    if (!(CheckUtil.isInMpsAutobuild(_context.getOriginalInputModel()))) {
      return;
    }
    CheckUtil.checkCoreRuntimeDeps();
    // do not check included langs: it gives us a list of test languages, which should not be included in build 
    // <node> 
    CheckUtil.checkSamples();
  }
}
