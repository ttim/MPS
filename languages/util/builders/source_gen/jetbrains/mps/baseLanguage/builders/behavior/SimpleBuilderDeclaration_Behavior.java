package jetbrains.mps.baseLanguage.builders.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.IScope;
import java.util.ArrayList;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;

public class SimpleBuilderDeclaration_Behavior {
  public static void init(SNode thisNode) {
  }

  public static boolean call_isRoot_8969040284892403078(SNode thisNode) {
    return SPropertyOperations.getBoolean(thisNode, "root") || (SLinkOperations.getTarget(thisNode, "extends", false) != null) && SimpleBuilderDeclaration_Behavior.call_isRoot_8969040284892403078(SLinkOperations.getTarget(thisNode, "extends", false));
  }

  public static boolean call_isDescendant_3816167865390595157(SNode thisNode, SNode b) {
    return thisNode == b || (SLinkOperations.getTarget(thisNode, "extends", false) != null) && SimpleBuilderDeclaration_Behavior.call_isDescendant_3816167865390595157(SLinkOperations.getTarget(thisNode, "extends", false), b);
  }

  public static List<SNode> call_getDescendants_3816167865390609214(SNode thisNode, SModel model, IScope scope) {
    List<SNode> result = new ArrayList<SNode>();
    SNode container = SNodeOperations.getAncestor(thisNode, "jetbrains.mps.baseLanguage.builders.structure.SimpleBuilders", false, false);
    for (SNode builder : SimpleBuilders_Behavior.call_getDescendands_5199967550912479741(container, model, scope)) {
      for (SNode dcl : SLinkOperations.getTargets(builder, "builder", true)) {
        if (SNodeOperations.isInstanceOf(dcl, "jetbrains.mps.baseLanguage.builders.structure.SimpleBuilderDeclaration") && SimpleBuilderDeclaration_Behavior.call_isDescendant_3816167865390595157(SNodeOperations.cast(dcl, "jetbrains.mps.baseLanguage.builders.structure.SimpleBuilderDeclaration"), thisNode)) {
          ListSequence.fromList(result).addElement(SNodeOperations.cast(dcl, "jetbrains.mps.baseLanguage.builders.structure.SimpleBuilderDeclaration"));
        }
      }
    }
    return result;
  }

  public static List<SNode> call_getAncestors_7782956297805865272(SNode thisNode) {
    List<SNode> result = new ArrayList<SNode>();
    SNode current = thisNode;
    while (current != null) {
      ListSequence.fromList(result).addElement(current);
      current = SLinkOperations.getTarget(current, "extends", false);
    }
    return result;
  }

  public static List<SNode> call_getExtensions_7782956297805903915(SNode thisNode, SModel model, IScope scope) {
    List<SNode> result = new ArrayList<SNode>();
    List<SNode> ancestors = SimpleBuilderDeclaration_Behavior.call_getAncestors_7782956297805865272(thisNode);
    SNode container = SNodeOperations.getAncestor(thisNode, "jetbrains.mps.baseLanguage.builders.structure.SimpleBuilders", true, false);
    for (SNode sb : SimpleBuilders_Behavior.call_getDescendands_5199967550912479741(container, model, scope)) {
      for (SNode dcl : SLinkOperations.getTargets(sb, "builder", true)) {
        if (SNodeOperations.isInstanceOf(dcl, "jetbrains.mps.baseLanguage.builders.structure.SimpleBuilderExtensionDeclaration") && ListSequence.fromList(ancestors).contains(SLinkOperations.getTarget(SNodeOperations.cast(dcl, "jetbrains.mps.baseLanguage.builders.structure.SimpleBuilderExtensionDeclaration"), "extended", false))) {
          ListSequence.fromList(result).addElement(SNodeOperations.cast(dcl, "jetbrains.mps.baseLanguage.builders.structure.SimpleBuilderExtensionDeclaration"));
        }
      }
    }
    return result;
  }

  public static List<SNode> call_getChildren_3816167865390856298(SNode thisNode, SModel model, IScope scope) {
    List<SNode> result = new ArrayList<SNode>();
    for (SNode a : SimpleBuilderDeclaration_Behavior.call_getAncestors_7782956297805865272(thisNode)) {
      ListSequence.fromList(result).addSequence(ListSequence.fromList(SLinkOperations.getTargets(a, "child", true)));
    }
    for (SNode ext : SimpleBuilderDeclaration_Behavior.call_getExtensions_7782956297805903915(thisNode, model, scope)) {
      ListSequence.fromList(result).addSequence(ListSequence.fromList(SLinkOperations.getTargets(ext, "child", true)));
    }
    return result;
  }

  public static List<SNode> call_getProperties_5389689214217081373(SNode thisNode, SModel model, IScope scope) {
    List<SNode> result = new ArrayList<SNode>();
    for (SNode a : SimpleBuilderDeclaration_Behavior.call_getAncestors_7782956297805865272(thisNode)) {
      ListSequence.fromList(result).addSequence(ListSequence.fromList(SLinkOperations.getTargets(a, "property", true)));
    }
    for (SNode ext : SimpleBuilderDeclaration_Behavior.call_getExtensions_7782956297805903915(thisNode, model, scope)) {
      ListSequence.fromList(result).addSequence(ListSequence.fromList(SLinkOperations.getTargets(ext, "property", true)));
    }
    return result;
  }

  public static SNode virtual_getContextDeclaration_6254726786820551255(SNode thisNode) {
    return thisNode;
  }
}
