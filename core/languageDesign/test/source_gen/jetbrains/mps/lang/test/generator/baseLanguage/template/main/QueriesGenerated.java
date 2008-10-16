package jetbrains.mps.lang.test.generator.baseLanguage.template.main;

/*Generated by MPS */

import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.generator.template.BaseMappingRuleContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.baseLanguage.classifiers.behavior.ThisClassifierExpresson_Behavior;
import jetbrains.mps.baseLanguage.classifiers.behavior.IMember_Behavior;
import jetbrains.mps.generator.template.PropertyMacroContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.baseLanguage.unitTest.behavior.ITestMethod_Behavior;
import jetbrains.mps.util.Macros;
import jetbrains.mps.vfs.IFile;
import jetbrains.mps.generator.template.ReferenceMacroContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.generator.template.SourceSubstituteMacroNodeContext;
import jetbrains.mps.generator.template.SourceSubstituteMacroNodesContext;
import java.util.List;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class QueriesGenerated {

  public static boolean baseMappingRule_Condition_1217247234512(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return SNodeOperations.isInstanceOf(ThisClassifierExpresson_Behavior.call_getClassifier_1213877512819(_context.getNode()), "jetbrains.mps.lang.test.structure.NodesTestCase");
  }

  public static boolean baseMappingRule_Condition_1217247775422(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return SNodeOperations.isInstanceOf(IMember_Behavior.call_getContainer_1213877353020(_context.getNode()), "jetbrains.mps.lang.test.structure.NodesTestCase");
  }

  public static Object propertyMacro_GetPropertyValue_1216995305411(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name") + "_Test";
  }

  public static Object propertyMacro_GetPropertyValue_1216996538619(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return ITestMethod_Behavior.call_getTestName_1216136419751(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_1217434974886(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return ITestMethod_Behavior.call_getTestName_1216136419751(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_1221567851385(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return _context.getNode().getId();
  }

  public static Object propertyMacro_GetPropertyValue_1221567851434(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return "var" + _context.getNode().getId();
  }

  public static Object propertyMacro_GetPropertyValue_1221567851447(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SNodeOperations.getParent(_context.getNode()).getId();
  }

  public static Object propertyMacro_GetPropertyValue_1221567884824(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return _context.getNode().getId();
  }

  public static Object propertyMacro_GetPropertyValue_1221567884857(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SNodeOperations.getParent(SNodeOperations.getParent(_context.getNode())).getId();
  }

  public static Object propertyMacro_GetPropertyValue_1221567884881(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return "body" + ITestMethod_Behavior.call_getTestName_1216136419751(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_1221567898665(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return "var" + _context.getNode().getId();
  }

  public static Object propertyMacro_GetPropertyValue_1221567898678(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SNodeOperations.getParent(_context.getNode()).getId();
  }

  public static Object propertyMacro_GetPropertyValue_1221567898739(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name");
  }

  public static Object propertyMacro_GetPropertyValue_1221570038142(final IOperationContext operationContext, final PropertyMacroContext _context) {
    IOperationContext invocationContext = _context.getGenerator().getGeneratorSessionContext().getInvocationContext();
    String url = invocationContext.getProject().getPresentableUrl();
    if (url != null) {
      String path = url.replaceAll("/", "\\\\");
      return Macros.mpsHomeMacros().shrinkPath(path, (IFile)null).replaceAll("\\\\", "/");
    }
    return "";
  }

  public static Object propertyMacro_GetPropertyValue_1221570038189(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return _context.getOriginalInputModel().getSModelReference().toString();
  }

  public static Object propertyMacro_GetPropertyValue_1221570039970(final IOperationContext operationContext, final PropertyMacroContext _context) {
    IOperationContext invocationContext = _context.getGenerator().getGeneratorSessionContext().getInvocationContext();
    String url = invocationContext.getProject().getPresentableUrl();
    if (url != null) {
      String path = url.replaceAll("/", "\\\\");
      return Macros.mpsHomeMacros().shrinkPath(path, (IFile)null).replaceAll("\\\\", "/");
    }
    return "";
  }

  public static Object propertyMacro_GetPropertyValue_1221570040017(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return _context.getOriginalInputModel().getSModelReference().toString();
  }

  public static Object propertyMacro_GetPropertyValue_1221570981212(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return "body" + ITestMethod_Behavior.call_getTestName_1216136419751(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_1221573038180(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return "body" + ITestMethod_Behavior.call_getTestName_1216136419751(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_1221573076739(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return "body" + ITestMethod_Behavior.call_getTestName_1216136419751(_context.getNode());
  }

  public static Object referenceMacro_GetReferent_1210689466825(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return "var" + SLinkOperations.getTarget(_context.getNode(), "declaration", false).getId();
  }

  public static Object referenceMacro_GetReferent_1217248433242(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return SPropertyOperations.getString(SLinkOperations.getTarget(_context.getNode(), "member", false), "name");
  }

  public static Object referenceMacro_GetReferent_1217418600305(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return "test";
  }

  public static Object referenceMacro_GetReferent_1221567851425(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return SNodeOperations.getConceptDeclaration(SNodeOperations.getParent(_context.getNode()));
  }

  public static Object referenceMacro_GetReferent_1221567898656(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return SNodeOperations.getConceptDeclaration(SNodeOperations.getParent(_context.getNode()));
  }

  public static SNode sourceNodeQuery_1215080487278(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "nodeToCheck", true);
  }

  public static SNode sourceNodeQuery_1217431328926(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "nodeToCheck", true);
  }

  public static SNode sourceNodeQuery_1217526593768(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "nodeToCheck", true);
  }

  public static SNode sourceNodeQuery_1217526624853(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "typeToCheck", true);
  }

  public static SNode sourceNodeQuery_1221567898644(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "returnType", true);
  }

  public static Iterable sourceNodesQuery_1215702462324(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "before", true);
  }

  public static Iterable sourceNodesQuery_1215702462336(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "after", true);
  }

  public static Iterable sourceNodesQuery_1216995908944(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    List<SNode> res = new ArrayList<SNode>();
    for(SNode method : SLinkOperations.getTargets(_context.getNode(), "testMethods", true)) {
      ListSequence.fromList(res).addElement(method);
    }
    return res;
  }

  public static Iterable sourceNodesQuery_1217248368856(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "actualArgument", true);
  }

  public static Iterable sourceNodesQuery_1217432232836(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SNodeOperations.getDescendants(_context.getNode(), "jetbrains.mps.lang.test.structure.NodeOperation", false);
  }

  public static Iterable sourceNodesQuery_1221567851293(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    List<SNode> res = new ArrayList<SNode>();
    for(SNode method : SLinkOperations.getTargets(_context.getNode(), "testMethods", true)) {
      ListSequence.fromList(res).addElement(method);
    }
    return res;
  }

  public static Iterable sourceNodesQuery_1221567851393(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    List<SNode> nodes = new ArrayList<SNode>();
    for(SNode nodeTocheck : SLinkOperations.getTargets(SNodeOperations.getAncestor(_context.getNode(), "jetbrains.mps.lang.test.structure.NodesTestCase", false, false), "nodesToCheck", true)) {
      ListSequence.fromList(nodes).addElement(((SNode)nodeTocheck));
    }
    return nodes;
  }

  public static Iterable sourceNodesQuery_1221567851458(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    HashSet<SNode> set = new LinkedHashSet<SNode>();
    for(SNode ref : SNodeOperations.getDescendants(SLinkOperations.getTarget(_context.getNode(), "body", true), "jetbrains.mps.lang.test.structure.TestNodeReference", false)) {
      set.add(SLinkOperations.getTarget(ref, "declaration", false));
    }
    return new ArrayList<SNode>(set);
  }

  public static Iterable sourceNodesQuery_1221567851508(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(SLinkOperations.getTarget(_context.getNode(), "body", true), "statement", true);
  }

  public static Iterable sourceNodesQuery_1221567884870(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SNodeOperations.getDescendants(_context.getNode(), "jetbrains.mps.lang.test.structure.NodeOperation", false);
  }

  public static Iterable sourceNodesQuery_1221567898689(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    HashSet<SNode> set = new LinkedHashSet<SNode>();
    for(SNode ref : SNodeOperations.getDescendants(SLinkOperations.getTarget(_context.getNode(), "body", true), "jetbrains.mps.lang.test.structure.TestNodeReference", false)) {
      set.add(SLinkOperations.getTarget(ref, "declaration", false));
    }
    return new ArrayList<SNode>(set);
  }

  public static Iterable sourceNodesQuery_1221567898723(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(SLinkOperations.getTarget(_context.getNode(), "body", true), "statement", true);
  }

  public static Iterable sourceNodesQuery_1221567898732(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "methods", true);
  }

  public static Iterable sourceNodesQuery_1221567898748(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "parameter", true);
  }

}
