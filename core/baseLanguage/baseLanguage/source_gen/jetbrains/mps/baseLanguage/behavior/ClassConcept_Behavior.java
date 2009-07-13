package jetbrains.mps.baseLanguage.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.util.EqualUtil;
import jetbrains.mps.lang.core.behavior.INamedConcept_Behavior;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import java.util.ArrayList;
import jetbrains.mps.baseLanguage.search.ClassifierAndSuperClassifiersScope;
import jetbrains.mps.baseLanguage.structure.ClassConcept;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.baseLanguage.search.IClassifiersSearchScope;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class ClassConcept_Behavior {
  private static Class[] PARAMETERS_1240936569950 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static List<SNode> virtual_getMembers_1213877531970(SNode thisNode) {
    List<SNode> members = IMemberContainer_Behavior.callSuper_getMembers_1213877531970(thisNode, "jetbrains.mps.baseLanguage.structure.ClassConcept");
    ListSequence.fromList(members).addSequence(ListSequence.fromList(SLinkOperations.getTargets(thisNode, "field", true)));
    ListSequence.fromList(members).addSequence(ListSequence.fromList(SLinkOperations.getTargets(thisNode, "staticMethod", true)));
    ListSequence.fromList(members).addSequence(ListSequence.fromList(SLinkOperations.getTargets(thisNode, "constructor", true)));
    ListSequence.fromList(members).addSequence(ListSequence.fromList(SLinkOperations.getTargets(thisNode, "staticInnerClassifiers", true)));
    return members;
  }

  public static boolean call_isDescendant_1213877355812(SNode thisNode, SNode classToCompare) {
    if (EqualUtil.equals(INamedConcept_Behavior.call_getFqName_1213877404258(thisNode), INamedConcept_Behavior.call_getFqName_1213877404258(classToCompare))) {
      return true;
    }
    if (SLinkOperations.getTarget(thisNode, "superclass", true) == null) {
      return false;
    }
    return ClassConcept_Behavior.call_isDescendant_1213877355812(SLinkOperations.getTarget(SLinkOperations.getTarget(thisNode, "superclass", true), "classifier", false), classToCompare);
  }

  public static SNode call_getMainMethod_1213877355884(SNode thisNode) {
    return ListSequence.fromList(SLinkOperations.getTargets(thisNode, "staticMethod", true)).where(new IWhereFilter <SNode>() {

      public boolean accept(SNode it) {
        return StaticMethodDeclaration_Behavior.call_isMainMethod_1213877536670(it);
      }
    }).first();
  }

  public static boolean virtual_hasStaticMemebers_1214840444586(SNode thisNode) {
    return Classifier_Behavior.callSuper_hasStaticMemebers_1214840444586(thisNode, "jetbrains.mps.baseLanguage.structure.ClassConcept") || SLinkOperations.getCount(thisNode, "staticMethod") > 0;
  }

  public static List<SNode> call_getMethodsToImplement_1221637841398(SNode thisNode) {
    List<SNode> methods = new ArrayList<SNode>();
    ClassifierAndSuperClassifiersScope scope = new ClassifierAndSuperClassifiersScope(((ClassConcept)SNodeOperations.getAdapter(thisNode)), IClassifiersSearchScope.INSTANCE_METHOD);
    for(SNode method : scope.getNodes()) {
      SNode container = SNodeOperations.getAncestor(method, "jetbrains.mps.baseLanguage.structure.Classifier", false, false);
      if (container == thisNode || container == null) {
        continue;
      }
      if (SNodeOperations.isInstanceOf(container, "jetbrains.mps.baseLanguage.structure.Interface") || SPropertyOperations.getBoolean(method, "isAbstract")) {
        ListSequence.fromList(methods).addElement(method);
      }
    }
    return methods;
  }

  public static SNode virtual_getSuperclass_1240936569950(SNode thisNode) {
    return SLinkOperations.getTarget(thisNode, "superclass", true);
  }

  public static SNode call_getSuperclass_1240936569950(SNode thisNode) {
    return (SNode)BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.ClassConcept"), "virtual_getSuperclass_1240936569950", PARAMETERS_1240936569950);
  }

  public static SNode callSuper_getSuperclass_1240936569950(SNode thisNode, String callerConceptFqName) {
    return (SNode)BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.ClassConcept"), callerConceptFqName, "virtual_getSuperclass_1240936569950", PARAMETERS_1240936569950);
  }

  public static SNode getContextClass_8008512149545173402(SNode expr) {
    SNode contextNode = expr;
    SNode parent = SNodeOperations.getParent(expr);
    if (SNodeOperations.isInstanceOf(parent, "jetbrains.mps.baseLanguage.structure.AnonymousClass")) {
      for(SNode param : SLinkOperations.getTargets(SNodeOperations.cast(parent, "jetbrains.mps.baseLanguage.structure.AnonymousClass"), "parameter", true)) {
        if (ListSequence.fromList(SNodeOperations.getDescendants(param, null, true, new String[]{})).contains(expr)) {
          contextNode = parent;
          break;
        }
      }
    }
    return SNodeOperations.getAncestor(contextNode, "jetbrains.mps.baseLanguage.structure.ClassConcept", false, false);
  }

}
