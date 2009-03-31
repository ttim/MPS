package jetbrains.mps.uiLanguage.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import java.util.List;
import jetbrains.mps.baseLanguage.collections.internal.query.ListOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.uiLanguage.behavior.IComponentInstance_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.baseLanguage.classifiers.behavior.IClassifier_Behavior;
import jetbrains.mps.baseLanguage.classifiers.behavior.IClassifierPart_Behavior;

public class ComponentDeclaration_Behavior {

  public static void init(SNode thisNode) {
  }

  public static SNode call_getAfterConstruction_1213877495346(SNode thisNode) {
    if (ComponentDeclaration_Behavior.call_getController_1213877495364(thisNode) == null) {
      return null;
    }
    return SLinkOperations.getTarget(ComponentDeclaration_Behavior.call_getController_1213877495364(thisNode), "afterConstruction", true);
  }

  public static SNode call_getBeforeConstruction_1216902155145(SNode thisNode) {
    if (ComponentDeclaration_Behavior.call_getController_1213877495364(thisNode) == null) {
      return null;
    }
    return SLinkOperations.getTarget(ComponentDeclaration_Behavior.call_getController_1213877495364(thisNode), "beforeConstruction", true);
  }

  public static SNode call_getController_1213877495364(SNode thisNode) {
    final SNode component = thisNode;
    return ListSequence.fromList(SModelOperations.getRoots(SNodeOperations.getModel(thisNode), "jetbrains.mps.uiLanguage.structure.ComponentController")).where(new IWhereFilter <SNode>() {

      public boolean accept(SNode it) {
        return SLinkOperations.getTarget(it, "component", false) == component;
      }
    }).first();
  }

  public static List<SNode> call_getDeclaredAttributes_1213877495390(SNode thisNode) {
    List<SNode> result = ListOperations.<SNode>createList();
    if (ComponentDeclaration_Behavior.call_getController_1213877495364(thisNode) != null) {
      ListSequence.fromList(result).addSequence(ListSequence.fromList(SLinkOperations.getTargets(ComponentDeclaration_Behavior.call_getController_1213877495364(thisNode), "attribute", true)));
    }
    return result;
  }

  public static List<SNode> call_getAttributes_1213877495417(SNode thisNode) {
    List<SNode> result = ListOperations.<SNode>createList();
    ListSequence.fromList(result).addSequence(ListSequence.fromList(ComponentDeclaration_Behavior.call_getDeclaredAttributes_1213877495390(thisNode)));
    if (ComponentDeclaration_Behavior.call_getExtendedComponent_1213877495528(thisNode) != null) {
      ListSequence.fromList(result).addSequence(ListSequence.fromList(ComponentDeclaration_Behavior.call_getAttributes_1213877495417(ComponentDeclaration_Behavior.call_getExtendedComponent_1213877495528(thisNode))));
    }
    return result;
  }

  public static List<SNode> call_getDeclaredMethods_1213877495451(SNode thisNode) {
    List<SNode> result = ListOperations.<SNode>createList();
    if (ComponentDeclaration_Behavior.call_getController_1213877495364(thisNode) != null) {
      ListSequence.fromList(result).addSequence(ListSequence.fromList(SLinkOperations.getTargets(ComponentDeclaration_Behavior.call_getController_1213877495364(thisNode), "componentMethod", true)));
    }
    return result;
  }

  public static List<SNode> call_getMethods_1213877495478(SNode thisNode) {
    List<SNode> result = ListOperations.<SNode>createList();
    ListSequence.fromList(result).addSequence(ListSequence.fromList(ComponentDeclaration_Behavior.call_getDeclaredMethods_1213877495451(thisNode)));
    if (ComponentDeclaration_Behavior.call_getExtendedComponent_1213877495528(thisNode) != null) {
      ListSequence.fromList(result).addSequence(ListSequence.fromList(ComponentDeclaration_Behavior.call_getMethods_1213877495478(ComponentDeclaration_Behavior.call_getExtendedComponent_1213877495528(thisNode))));
    }
    return result;
  }

  public static String call_getComponentClassName_1213877495512(SNode thisNode) {
    if (SPropertyOperations.getBoolean(thisNode, "stub")) {
      return NameUtil.nodeFQName(SLinkOperations.getTarget(thisNode, "mapTo", false));
    }
    return NameUtil.nodeFQName(thisNode);
  }

  public static SNode call_getExtendedComponent_1213877495528(SNode thisNode) {
    if (SPropertyOperations.getBoolean(thisNode, "stub")) {
      return SLinkOperations.getTarget(thisNode, "extendedComponent", false);
    }
    if (SLinkOperations.getTarget(thisNode, "root", true) != null) {
      return IComponentInstance_Behavior.call_getExtendedComponent_1213877498080(SLinkOperations.getTarget(thisNode, "root", true));
    }
    return null;
  }

  public static boolean call_isActionComponent_1213877495555(SNode thisNode) {
    return SPropertyOperations.getBoolean(thisNode, "actionComponent");
  }

  public static boolean call_hasCellRenderer_1213877495562(SNode thisNode) {
    return SLinkOperations.getTarget(thisNode, "rendererInfo", true) != null;
  }

  public static SNode virtual_createType_1213877527970(SNode thisNode) {
    SNode type = SConceptOperations.createNewNode("jetbrains.mps.uiLanguage.structure.ComponentType", null);
    SLinkOperations.setTarget(type, "component", thisNode, false);
    return type;
  }

  public static List<SNode> virtual_getMembers_1213877528124(SNode thisNode) {
    List<SNode> result = ListOperations.<SNode>createList();
    ListSequence.fromList(result).addSequence(ListSequence.fromList(IClassifier_Behavior.callSuper_getMembers_1213877528124(thisNode, "jetbrains.mps.uiLanguage.structure.ComponentDeclaration")));
    if (ComponentDeclaration_Behavior.call_getExtendedComponent_1213877495528(thisNode) != null) {
      ListSequence.fromList(result).addSequence(ListSequence.fromList(IClassifier_Behavior.call_getMembers_1213877528124(ComponentDeclaration_Behavior.call_getExtendedComponent_1213877495528(thisNode))));
    }
    SNode controller = ComponentDeclaration_Behavior.call_getController_1213877495364(thisNode);
    if (controller != null) {
      ListSequence.fromList(result).addSequence(ListSequence.fromList(IClassifierPart_Behavior.call_getMembers_1213877255431(controller)));
    }
    return result;
  }

}
