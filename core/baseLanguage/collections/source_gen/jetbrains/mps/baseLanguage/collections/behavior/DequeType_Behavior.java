package jetbrains.mps.baseLanguage.collections.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import java.util.List;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.smodel.behaviour.BehaviorManager;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.smodel.CopyUtil;
import jetbrains.mps.lang.typesystem.runtime.HUtil;

public class DequeType_Behavior {
  private static Class[] PARAMETERS_7602110602933345651 = {SNode.class ,SModel.class};

  public static void init(SNode thisNode) {
  }

  public static List<SNode> virtual_getAbstractCreators_7602110602933317830(SNode thisNode, SModel targetModel) {
    List<SNode> res = new ArrayList<SNode>();
    ListSequence.fromList(res).addElement(new DequeType_Behavior.QuotationClass_kzauu3_a0a0b0b().createNode(SLinkOperations.getTarget(thisNode, "elementType", true)));
    ListSequence.fromList(res).addSequence(Sequence.fromIterable(CustomContainersUtil.containerCreators(targetModel, thisNode)));
    return res;
  }

  public static List<SNode> call_getAbstractCreators_7602110602933345651(SNode thisNode, SModel targetModel) {
    return (List<SNode>) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.collections.structure.DequeType"), "virtual_getAbstractCreators_7602110602933317830", PARAMETERS_7602110602933345651, targetModel);
  }

  public static List<SNode> callSuper_getAbstractCreators_7602110602933345651(SNode thisNode, String callerConceptFqName, SModel targetModel) {
    return (List<SNode>) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.collections.structure.DequeType"), callerConceptFqName, "virtual_getAbstractCreators_7602110602933317830", PARAMETERS_7602110602933345651, targetModel);
  }

  public static class QuotationClass_kzauu3_a0a0b0b {
    public QuotationClass_kzauu3_a0a0b0b() {
    }

    public SNode createNode(Object parameter_kzauu3_a0a0a0a1a0) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_kzauu3_a0a0b0a = null;
      SNode quotedNode_kzauu3_a0a0a1a0 = null;
      {
        quotedNode_kzauu3_a0a0b0a = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.LinkedListCreator", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_kzauu3_a0a0b0a = quotedNode_kzauu3_a0a0b0a;
        {
          quotedNode_kzauu3_a0a0a1a0 = (SNode) parameter_kzauu3_a0a0a0a1a0;
          SNode quotedNode1_kzauu3_a0a0a1a0;
          if (_parameterValues_129834374.contains(quotedNode_kzauu3_a0a0a1a0)) {
            quotedNode1_kzauu3_a0a0a1a0 = CopyUtil.copy(quotedNode_kzauu3_a0a0a1a0);
          } else {
            _parameterValues_129834374.add(quotedNode_kzauu3_a0a0a1a0);
            quotedNode1_kzauu3_a0a0a1a0 = quotedNode_kzauu3_a0a0a1a0;
          }
          if (quotedNode1_kzauu3_a0a0a1a0 != null) {
            quotedNode_kzauu3_a0a0b0a.addChild("elementType", HUtil.copyIfNecessary(quotedNode1_kzauu3_a0a0a1a0));
          }
        }
        result = quotedNode1_kzauu3_a0a0b0a;
      }
      return result;
    }
  }
}
