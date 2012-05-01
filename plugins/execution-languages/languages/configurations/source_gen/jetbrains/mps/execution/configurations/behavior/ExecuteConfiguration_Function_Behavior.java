package jetbrains.mps.execution.configurations.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import java.util.List;
import jetbrains.mps.baseLanguage.behavior.ILocalVariableElementList_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
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

public class ExecuteConfiguration_Function_Behavior {
  private static Class[] PARAMETERS_6538811202682334478 = {SNode.class};
  private static Class[] PARAMETERS_3091009652595815824 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static List<SNode> virtual_getLocalVariableElements_1238805763253(SNode thisNode) {
    return ILocalVariableElementList_Behavior.call_getLocalVariableElements_1238805763253(SLinkOperations.getTarget(thisNode, "body", true));
  }

  public static List<SNode> virtual_getParameters_1213877374450(SNode thisNode) {
    if (SNodeOperations.isInstanceOf(SNodeOperations.getContainingRoot(thisNode), "jetbrains.mps.execution.configurations.structure.RunConfigurationExecutor") && (SLinkOperations.getTarget(SNodeOperations.cast(SNodeOperations.getContainingRoot(thisNode), "jetbrains.mps.execution.configurations.structure.RunConfigurationExecutor"), "debuggerConfiguration", true) != null)) {
      return ListSequence.fromListAndArray(new ArrayList<SNode>(), SConceptOperations.findConceptDeclaration("jetbrains.mps.execution.configurations.structure.Project_Parameter"), SConceptOperations.findConceptDeclaration("jetbrains.mps.execution.configurations.structure.DebuggerSettings_Parameter"));
    }
    return ListSequence.fromListAndArray(new ArrayList<SNode>(), SConceptOperations.findConceptDeclaration("jetbrains.mps.execution.configurations.structure.Project_Parameter"));
  }

  public static SNode virtual_getExpectedReturnType_1213877374441(SNode thisNode) {
    return new ExecuteConfiguration_Function_Behavior.QuotationClass_cw5ucd_a0a0d().createNode();
  }

  public static List<SNode> call_getLocalVariableElements_6538811202682334478(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (List<SNode>) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.execution.configurations.structure.ExecuteConfiguration_Function"), "virtual_getLocalVariableElements_1238805763253", PARAMETERS_6538811202682334478);
  }

  public static List<SNode> call_getParameters_3091009652595815824(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (List<SNode>) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.execution.configurations.structure.ExecuteConfiguration_Function"), "virtual_getParameters_1213877374450", PARAMETERS_3091009652595815824);
  }

  public static List<SNode> callSuper_getLocalVariableElements_6538811202682334478(SNode thisNode, String callerConceptFqName) {
    return (List<SNode>) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.execution.configurations.structure.ExecuteConfiguration_Function"), callerConceptFqName, "virtual_getLocalVariableElements_1238805763253", PARAMETERS_6538811202682334478);
  }

  public static List<SNode> callSuper_getParameters_3091009652595815824(SNode thisNode, String callerConceptFqName) {
    return (List<SNode>) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.execution.configurations.structure.ExecuteConfiguration_Function"), callerConceptFqName, "virtual_getParameters_1213877374450", PARAMETERS_3091009652595815824);
  }

  public static class QuotationClass_cw5ucd_a0a0d {
    public QuotationClass_cw5ucd_a0a0d() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      SNode quotedNode_2 = null;
      SNode quotedNode_3 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.typesystem.structure.JoinType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_4 = quotedNode_1;
        {
          quotedNode_2 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.execution.commands.structure.ProcessType", null, GlobalScope.getInstance(), false);
          SNode quotedNode1_5 = quotedNode_2;
          quotedNode_1.addChild("argument", quotedNode1_5);
        }
        {
          quotedNode_3 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", null, GlobalScope.getInstance(), false);
          SNode quotedNode1_6 = quotedNode_3;
          quotedNode1_6.addReference(SReference.create("classifier", quotedNode1_6, SModelReference.fromString("f:java_stub#742f6602-5a2f-4313-aa6e-ae1cd4ffdc61#com.intellij.execution.process(MPS.Platform/com.intellij.execution.process@java_stub)"), SNodeId.fromString("~ProcessHandler")));
          quotedNode_1.addChild("argument", quotedNode1_6);
        }
        result = quotedNode1_4;
      }
      return result;
    }
  }
}
