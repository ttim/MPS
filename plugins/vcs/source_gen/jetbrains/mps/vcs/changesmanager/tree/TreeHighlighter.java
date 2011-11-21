package jetbrains.mps.vcs.changesmanager.tree;

/*Generated by MPS */

import jetbrains.mps.ide.ui.treeMessages.TreeMessageOwner;
import java.util.Map;
import com.intellij.openapi.vcs.FileStatus;
import jetbrains.mps.ide.ui.treeMessages.TreeMessage;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.HashMap;
import jetbrains.mps.vcs.changesmanager.CurrentDifferenceRegistry;
import jetbrains.mps.vcs.changesmanager.SimpleCommandQueue;
import jetbrains.mps.vcs.diff.changes.ModelChange;
import jetbrains.mps.ide.ui.MPSTree;
import com.intellij.util.containers.MultiMap;
import jetbrains.mps.vcs.changesmanager.tree.features.Feature;
import jetbrains.mps.ide.ui.MPSTreeNode;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.SModelRepository;
import jetbrains.mps.smodel.descriptor.EditableSModelDescriptor;
import jetbrains.mps.ide.ui.MPSTreeNodeListener;

public class TreeHighlighter implements TreeMessageOwner {
  private Map<FileStatus, TreeMessage> myTreeMessages = MapSequence.fromMap(new HashMap<FileStatus, TreeMessage>());
  private CurrentDifferenceRegistry myRegistry;
  private SimpleCommandQueue myCommandQueue;
  private FeatureForestMap<ModelChange> myMap;
  private MPSTree myTree;
  private TreeNodeFeatureExtractor myFeatureExtractor;
  private boolean myInitialized;
  private TreeHighlighter.MyTreeNodeListener myTreeNodeListener = new TreeHighlighter.MyTreeNodeListener();
  private TreeHighlighter.MyFeatureForestMapListener myFeatureListener = new TreeHighlighter.MyFeatureForestMapListener();
  private MultiMap<Feature, MPSTreeNode> myFeatureToNodes = new MultiMap<Feature, MPSTreeNode>();

  public TreeHighlighter(@NotNull CurrentDifferenceRegistry registry, @NotNull FeatureForestMapSupport featureForestMapSupport, @NotNull MPSTree tree, @NotNull TreeNodeFeatureExtractor featureExtractor) {
    myRegistry = registry;
    myCommandQueue = registry.getCommandQueue();
    myMap = featureForestMapSupport.getMap();
    myTree = tree;
    myFeatureExtractor = featureExtractor;
  }

  public synchronized void init() {
    if (myInitialized) {
      return;
    }
    myInitialized = true;
    myMap.addListener(myFeatureListener);
    myTree.addTreeNodeListener(myTreeNodeListener);
    ModelAccess.instance().runReadInEDT(new Runnable() {
      public void run() {
        registerNodeRecursively(myTree.getRootNode());
      }
    });
  }

  public synchronized void dispose() {
    if (!(myInitialized)) {
      return;
    }
    myInitialized = false;
    myTree.removeTreeNodeListener(myTreeNodeListener);
    myMap.removeListener(myFeatureListener);
  }

  private void registerNodeRecursively(@NotNull MPSTreeNode node) {
    registerNode(node);
    for (MPSTreeNode child : Sequence.fromIterable(node)) {
      registerNodeRecursively(child);
    }
  }

  private void registerNode(@NotNull final MPSTreeNode node) {
    final Feature feature = myFeatureExtractor.getFeature(node);
    if (feature != null) {
      myFeatureToNodes.putValue(feature, node);
      myCommandQueue.runTask(new Runnable() {
        public void run() {
          ModelAccess.instance().runReadAction(new Runnable() {
            public void run() {
              rehighlightNode(node, feature);
            }
          });
        }
      });
    }
  }

  private void unregisterNode(@NotNull MPSTreeNode node) {
    Feature feature = myFeatureExtractor.getFeature(node);
    if (feature != null) {
      myFeatureToNodes.removeValue(feature, node);
      unhighlightNode(node);
    }
  }

  private void unhighlightNode(@NotNull MPSTreeNode node) {
    node.removeTreeMessages(this, true);
  }

  private void rehighlightNode(@NotNull MPSTreeNode node, @NotNull Feature feature) {
    unhighlightNode(node);

    SModelDescriptor model = SModelRepository.getInstance().getModelDescriptor(feature.getNodePointer().getModelReference());
    if (model instanceof EditableSModelDescriptor) {
      myRegistry.getCurrentDifference((EditableSModelDescriptor) model).setEnabled(true);
    }

    ModelChange change = myMap.get(feature);
    if (change == null) {
      change = myMap.getAddedAncestorValue(feature);
    }
    if (change != null) {
      node.addTreeMessage(getMessage(change));
    } else if (myMap.isAncestorOfAddedFeature(feature)) {
      node.addTreeMessage(getMessage(FileStatus.MODIFIED));
    }
  }

  private void rehighlightFeature(@NotNull final Feature feature) {
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        for (MPSTreeNode node : Sequence.fromIterable(myFeatureToNodes.get(feature))) {
          rehighlightNode(node, feature);
        }
      }
    });
  }

  @NotNull
  private TreeMessage getMessage(@NotNull FileStatus fileStatus) {
    if (!(MapSequence.fromMap(myTreeMessages).containsKey(fileStatus))) {
      MapSequence.fromMap(myTreeMessages).put(fileStatus, new TreeMessage(fileStatus.getColor(), null, this));
    }
    return MapSequence.fromMap(myTreeMessages).get(fileStatus);
  }

  @NotNull
  private TreeMessage getMessage(@NotNull ModelChange modelChange) {
    switch (modelChange.getType()) {
      case ADD:
        return getMessage(FileStatus.ADDED);
      case CHANGE:
        return getMessage(FileStatus.MODIFIED);
      default:
        assert false;
        return getMessage(FileStatus.MERGED_WITH_CONFLICTS);
    }
  }

  private class MyTreeNodeListener implements MPSTreeNodeListener {
    public MyTreeNodeListener() {
    }

    public void treeNodeAdded(MPSTreeNode node, MPSTree tree) {
      registerNode(node);
    }

    public void treeNodeRemoved(MPSTreeNode node, MPSTree tree) {
      unregisterNode(node);
    }

    public void treeNodeUpdated(MPSTreeNode node, MPSTree tree) {
    }
  }

  private class MyFeatureForestMapListener implements FeatureForestMapListener {
    public MyFeatureForestMapListener() {
    }

    public void featureAdded(Feature feature) {
      rehighlightFeature(feature);
    }

    public void featureRemoved(Feature feature) {
      rehighlightFeature(feature);
    }

    public void allDescendantsRemoved(Feature feature) {
      rehighlightFeature(feature);
    }

    public void descendantAdded(Feature feature) {
      rehighlightFeature(feature);
    }
  }
}
