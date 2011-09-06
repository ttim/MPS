package jetbrains.mps.build.packaging.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.smodel.structure.BehaviorDescriptor;
import jetbrains.mps.smodel.structure.ConceptRegistry;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class IVariableHolder_Behavior {
  private static Class[] PARAMETERS_1234864693585 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static SNode call_findVariable_1234876428215(SNode thisNode, String name, String antName) {
    List<SNode> allVars = IVariableHolder_Behavior.call_getAllVariable_1234864693585(thisNode);
    for (SNode var : ListSequence.fromList(allVars)) {
      if (SPropertyOperations.getString(var, "name").equals(name) && SPropertyOperations.getString(var, "antName").equals(antName)) {
        return var;
      }
    }
    return null;
  }

  public static List<SNode> call_getAllVariable_1234864693585(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (List<SNode>) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.build.packaging.structure.IVariableHolder"), "virtual_getAllVariable_1234864693585", PARAMETERS_1234864693585);
  }

  public static List<SNode> callSuper_getAllVariable_1234864693585(SNode thisNode, String callerConceptFqName) {
    return (List<SNode>) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.build.packaging.structure.IVariableHolder"), callerConceptFqName, "virtual_getAllVariable_1234864693585", PARAMETERS_1234864693585);
  }
}
