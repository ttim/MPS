package jetbrains.mps.lang.structure.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import java.util.List;
import java.util.ArrayList;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.Set;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import java.util.HashSet;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.LanguageAspect;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.internal.collections.runtime.ISelector;

public class InterfaceConceptDeclaration_Behavior {
  public static void init(SNode thisNode) {
  }

  public static List<SNode> virtual_getImmediateSuperconcepts_1222430305282(SNode thisNode) {
    List<SNode> result = new ArrayList<SNode>();
    for (SNode interfaceConceptReference : SLinkOperations.getTargets(thisNode, "extends", true)) {
      ListSequence.fromList(result).addElement(SLinkOperations.getTarget(interfaceConceptReference, "intfc", false));
    }
    return result;
  }

  public static List<SNode> call_getAllMethodsInPriorityOrder_9106339407519386413(SNode thisNode) {
    List<SNode> methods = ListSequence.fromList(new ArrayList<SNode>());
    Set<SNode> concepts = SetSequence.fromSet(new HashSet<SNode>());
    InterfaceConceptDeclaration_Behavior.call_collectAllMethodsInPriorityOrder_4038300048412704204(thisNode, methods, concepts);
    return methods;
  }

  public static void call_collectAllMethodsInPriorityOrder_4038300048412704204(SNode thisNode, List<SNode> methods, Set<SNode> concepts) {
    if (SetSequence.fromSet(concepts).contains(thisNode)) {
      return;
    }
    SetSequence.fromSet(concepts).addElement(thisNode);
    ListSequence.fromList(methods).addSequence(ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(AbstractConceptDeclaration_Behavior.call_findConceptAspect_8360039740498068384(thisNode, LanguageAspect.BEHAVIOR), "jetbrains.mps.lang.behavior.structure.ConceptBehavior"), "method", true)));
    for (SNode extendsInterface : ListSequence.fromList(SLinkOperations.getTargets(thisNode, "extends", true)).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return (SLinkOperations.getTarget(it, "intfc", false) != null);
      }
    }).select(new ISelector<SNode, SNode>() {
      public SNode select(SNode it) {
        return SLinkOperations.getTarget(it, "intfc", false);
      }
    })) {
      // todo: equal methods in different interfaces check! 
      InterfaceConceptDeclaration_Behavior.call_collectAllMethodsInPriorityOrder_4038300048412704204(extendsInterface, methods, concepts);
    }
  }
}
