package jetbrains.mps.vcs.changesmanager.tree;

/*Generated by MPS */

import org.jetbrains.annotations.Nullable;
import jetbrains.mps.vcs.changesmanager.tree.features.Feature;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.ide.ui.MPSTreeNode;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.ide.ui.MPSTreeNodeEx;
import jetbrains.mps.smodel.SNodePointer;
import jetbrains.mps.ide.ui.smodel.SNodeTreeNode;
import jetbrains.mps.ide.ui.smodel.ConceptTreeNode;
import jetbrains.mps.vcs.changesmanager.tree.features.NodeFeature;
import jetbrains.mps.ide.ui.smodel.PropertyTreeNode;
import jetbrains.mps.vcs.changesmanager.tree.features.PropertyFeature;
import jetbrains.mps.ide.ui.smodel.ReferenceTreeNode;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.ide.ui.smodel.PropertiesTreeNode;
import jetbrains.mps.vcs.changesmanager.tree.features.PropertiesFeature;
import jetbrains.mps.ide.ui.smodel.ReferencesTreeNode;
import jetbrains.mps.vcs.changesmanager.tree.features.ReferencesFeature;
import jetbrains.mps.ide.ui.smodel.PackageNode;
import jetbrains.mps.vcs.changesmanager.tree.features.VirtualPackageFeature;
import jetbrains.mps.ide.ui.smodel.SModelTreeNode;
import jetbrains.mps.vcs.changesmanager.tree.features.ModelFeature;

public class ProjectTreeFeatureExtractor implements TreeNodeFeatureExtractor {
  public ProjectTreeFeatureExtractor() {
  }

  @Nullable
  public Feature getFeature(@NotNull MPSTreeNode treeNode) {
    SNode node = null;
    if (treeNode instanceof MPSTreeNodeEx) {
      node = ((MPSTreeNodeEx) treeNode).getSNode();
    } else if (treeNode.getParent() instanceof MPSTreeNodeEx) {
      node = ((MPSTreeNodeEx) treeNode.getParent()).getSNode();
    }
    SNodePointer nodePointer = null;
    if (node != null) {
      if (node.isDisposed()) {
        return null;
      }
      nodePointer = new SNodePointer(node);
    }
    if (treeNode instanceof SNodeTreeNode || treeNode instanceof ConceptTreeNode) {
      return new NodeFeature(nodePointer);
    } else if (treeNode instanceof PropertyTreeNode && treeNode.getParent() instanceof MPSTreeNodeEx) {
      return new PropertyFeature(nodePointer, ((PropertyTreeNode) treeNode).getProperty());
    } else if (treeNode instanceof ReferenceTreeNode) {
      SReference ref = ((ReferenceTreeNode) treeNode).getRef();
      return new PropertyFeature(new SNodePointer(ref.getSourceNode()), ref.getRole());
    } else if (treeNode instanceof PropertiesTreeNode) {
      return new PropertiesFeature(nodePointer);
    } else if (treeNode instanceof ReferencesTreeNode) {
      return new ReferencesFeature(nodePointer);
    } else if (treeNode instanceof PackageNode) {
      PackageNode pn = ((PackageNode) treeNode);
      return new VirtualPackageFeature(pn.getModelReference(), pn.getPackage());
    } else if (treeNode instanceof SModelTreeNode) {
      return new ModelFeature(((SModelTreeNode) treeNode).getSModelDescriptor().getSModelReference());
    }
    return null;
  }
}
