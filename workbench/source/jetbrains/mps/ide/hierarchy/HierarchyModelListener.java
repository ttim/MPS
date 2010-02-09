package jetbrains.mps.ide.hierarchy;

import jetbrains.mps.ide.ui.MPSTreeNode;
import jetbrains.mps.smodel.INodeAdapter;
import jetbrains.mps.smodel.SModelAdapter;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.event.SModelReferenceEvent;
import jetbrains.mps.smodel.event.SModelRootEvent;

import java.util.ArrayList;
import java.util.List;

public class HierarchyModelListener extends SModelAdapter {
  private AbstractHierarchyTree myHierarchyTree;

  public HierarchyModelListener(AbstractHierarchyTree hierarchyTree) {
    myHierarchyTree = hierarchyTree;
  }

  private void collectNodes(MPSTreeNode target, List<SNode> list) {
    for (MPSTreeNode child : target) {
      if (child.getUserObject() instanceof INodeAdapter) {
        INodeAdapter nodeAdapter = (INodeAdapter) child.getUserObject();
        list.add(nodeAdapter.getNode());
      }
      collectNodes(child, list);
    }
  }

  private void structureEvent(List<SNode> searchedNodes) {
    List<SNode> nodeInTree = new ArrayList<SNode>();
    MPSTreeNode treeNode  = myHierarchyTree.getRootNode();
    collectNodes(treeNode, nodeInTree);
    for (SNode searchedNode : searchedNodes) {
      if (searchedNode == null) continue;
      if (nodeInTree.contains(searchedNode)) {
        myHierarchyTree.rebuildLater();
      }
    }
  }

  private void structureReferenceEvent(SModelReferenceEvent event) {
    List<SNode> nodes = new ArrayList<SNode>();
    nodes.add(event.getReference().getSourceNode());
    nodes.add(event.getReference().getTargetNode());
    structureEvent(nodes);
  }

  private void structureRootEvent(SModelRootEvent event) {
    List<SNode> nodes = new ArrayList<SNode>();
    nodes.add(event.getAffectedRoot());
    nodes.add(event.getRoot());
    structureEvent(nodes);
  }

  public void rootAdded(SModelRootEvent event) {
    structureRootEvent(event);
  }

  public void rootRemoved(SModelRootEvent event) {
    structureRootEvent(event);
  }

  public void referenceRemoved(SModelReferenceEvent event) {
    structureReferenceEvent(event);
  }

  public void referenceAdded(SModelReferenceEvent event) {
    structureReferenceEvent(event);
  }
}
