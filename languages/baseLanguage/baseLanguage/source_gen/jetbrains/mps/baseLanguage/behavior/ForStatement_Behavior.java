package jetbrains.mps.baseLanguage.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.scope.Scope;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.lang.scopes.runtime.ScopeUtils;
import jetbrains.mps.baseLanguage.scopes.Scopes;
import jetbrains.mps.lang.core.behavior.ScopeProvider_Behavior;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class ForStatement_Behavior {
  private static Class[] PARAMETERS_2496361171403550965 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static List<SNode> virtual_getScopeVariables_5067982036267369894(SNode thisNode) {
    return ListSequence.fromListAndArray(new ArrayList<SNode>(), SLinkOperations.getTarget(thisNode, "variable", true));
  }

  public static Scope virtual_getScope_3734116213129936182(SNode thisNode, SNode kind, SNode child) {
    if (SConceptOperations.isSubConceptOf(kind, "jetbrains.mps.baseLanguage.structure.IVariableDeclaration")) {
      // todo: change logic =( 
      List<SNode> variables = new ArrayList<SNode>();
      if (!(ScopeUtils.comeFrom("variable", thisNode, child))) {
        ListSequence.fromList(variables).addElement(SLinkOperations.getTarget(thisNode, "variable", true));
      }
      if (ScopeUtils.comeFrom("body", thisNode, child)) {
        ListSequence.fromList(variables).addSequence(ListSequence.fromList(SLinkOperations.getTargets(thisNode, "additionalVar", true)));
      }
      return Scopes.forVariables(kind, variables, ScopeUtils.lazyParentScope(thisNode, kind));
    }
    return ScopeProvider_Behavior.callSuper_getScope_3734116213129936182(thisNode, "jetbrains.mps.baseLanguage.structure.ForStatement", kind, child);
  }

  public static List<SNode> call_getScopeVariables_2496361171403550965(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (List<SNode>) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.ForStatement"), "virtual_getScopeVariables_5067982036267369894", PARAMETERS_2496361171403550965, new Object[]{});
  }

  public static List<SNode> callSuper_getScopeVariables_2496361171403550965(SNode thisNode, String callerConceptFqName) {
    return (List<SNode>) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.ForStatement"), callerConceptFqName, "virtual_getScopeVariables_5067982036267369894", PARAMETERS_2496361171403550965, new Object[]{});
  }
}
