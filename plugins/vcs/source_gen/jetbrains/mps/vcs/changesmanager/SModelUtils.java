package jetbrains.mps.vcs.changesmanager;

/*Generated by MPS */

import org.jetbrains.annotations.NotNull;
import java.util.List;
import jetbrains.mps.smodel.SNodeId;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.AttributesRolesUtil;
import jetbrains.mps.kernel.model.SModelUtil;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.event.SModelChildEvent;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;

public class SModelUtils {
  private SModelUtils() {
  }

  @NotNull
  public static List<SNodeId> getNodeIds(List<SNode> nodes) {
    return ListSequence.fromList(nodes).<SNodeId>select(new ISelector<SNode, SNodeId>() {
      public SNodeId select(SNode node) {
        return node.getSNodeId();
      }
    }).toListSequence();
  }

  public static boolean isChildInSingleRole(String childRole, SNode parent, SModelDescriptor modelDescriptor) {
    if (AttributesRolesUtil.isAttributeRole(childRole)) {
      SNode annotationLinkDeclaration = SModelUtil.findAnnotationLinkDeclaration(childRole, modelDescriptor.getModule().getScope());
      if ((annotationLinkDeclaration != null)) {
        return SPropertyOperations.hasValue(annotationLinkDeclaration, "sourceCardinality", "0..1", "0..1");
      }
    } else {
      SNode linkDeclaration = ((SNode) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(SNodeOperations.getConceptDeclaration(parent), "jetbrains.mps.lang.structure.structure.AbstractConceptDeclaration"), "call_findLinkDeclaration_1213877394467", new Class[]{SNode.class, String.class}, childRole));
      if ((linkDeclaration != null)) {
        return ((Boolean) BehaviorManager.getInstance().invoke(Boolean.class, SNodeOperations.cast(linkDeclaration, "jetbrains.mps.lang.structure.structure.LinkDeclaration"), "call_isSingular_1213877254557", new Class[]{SNode.class}));
      }
    }
    return false;
  }

  public static boolean isChildInSingleRole(@NotNull SModelChildEvent e) {
    return SModelUtils.isChildInSingleRole(e.getChildRole(), e.getParent(), e.getModelDescriptor());
  }

  @NotNull
  public static List<SNode> getPathToRoot(@NotNull SNode node) {
    List<SNode> nodes = ListSequence.fromList(new ArrayList<SNode>());
    while (node != null) {
      ListSequence.fromList(nodes).addElement(node);
      node = SNodeOperations.getParent(node);
    }
    nodes = ListSequence.fromList(nodes).reversedList();
    return nodes;
  }

  @NotNull
  public static List<SNode> getDominators(@NotNull List<SNode> nodes) {
    List<SNode> dominators = ListSequence.fromList(new ArrayList<SNode>());
    for (final SNode minor : ListSequence.fromList(nodes)) {
      if (!(ListSequence.fromList(nodes).any(new IWhereFilter<SNode>() {
        public boolean accept(SNode major) {
          return minor.isDescendantOf(major, false);
        }
      }))) {
        ListSequence.fromList(dominators).addElement(minor);
      }
    }
    return dominators;
  }
}
