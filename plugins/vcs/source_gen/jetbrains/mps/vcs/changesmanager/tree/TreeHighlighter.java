package jetbrains.mps.vcs.changesmanager.tree;

/*Generated by MPS */

import jetbrains.mps.ide.ui.treeMessages.TreeMessageOwner;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
import com.intellij.openapi.vcs.FileStatusManager;
import jetbrains.mps.smodel.GlobalSModelEventsManager;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.SModelRepository;
import jetbrains.mps.smodel.descriptor.EditableSModelDescriptor;
import jetbrains.mps.vcs.changesmanager.tree.features.ModelFeature;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.vcs.diff.changes.AddRootChange;
import jetbrains.mps.vcs.changesmanager.BaseVersionUtil;
import org.jetbrains.annotations.Nullable;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import jetbrains.mps.ide.vfs.VirtualFileUtils;
import jetbrains.mps.ide.ui.MPSTreeNodeListener;
import com.intellij.openapi.vcs.FileStatusListener;
import jetbrains.mps.vfs.IFile;
import jetbrains.mps.smodel.SModelAdapter;
import jetbrains.mps.smodel.SModel;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.IVisitor;

public class TreeHighlighter implements TreeMessageOwner {
  protected static Log log = LogFactory.getLog(TreeHighlighter.class);

  private Map<FileStatus, TreeMessage> myTreeMessages = MapSequence.fromMap(new HashMap<FileStatus, TreeMessage>());
  private CurrentDifferenceRegistry myRegistry;
  private SimpleCommandQueue myCommandQueue;
  private FeatureForestMap<ModelChange> myMap;
  private MPSTree myTree;
  private TreeNodeFeatureExtractor myFeatureExtractor;
  private boolean myInitialized;
  private TreeHighlighter.MyTreeNodeListener myTreeNodeListener = new TreeHighlighter.MyTreeNodeListener();
  private TreeHighlighter.MyFeatureForestMapListener myFeatureListener = new TreeHighlighter.MyFeatureForestMapListener();
  private final MultiMap<Feature, MPSTreeNode> myFeatureToNodes = new MultiMap<Feature, MPSTreeNode>();
  private TreeHighlighter.MyFileStatusListener myFileStatusListener = new TreeHighlighter.MyFileStatusListener();
  private TreeHighlighter.MyModelListener myGlobalModelListener;

  public TreeHighlighter(@NotNull CurrentDifferenceRegistry registry, @NotNull FeatureForestMapSupport featureForestMapSupport, @NotNull MPSTree tree, @NotNull TreeNodeFeatureExtractor featureExtractor, boolean removeNodesOnModelDisposal) {
    myRegistry = registry;
    myCommandQueue = registry.getCommandQueue();
    myMap = featureForestMapSupport.getMap();
    myTree = tree;
    myFeatureExtractor = featureExtractor;
    if (removeNodesOnModelDisposal) {
      myGlobalModelListener = new TreeHighlighter.MyModelListener();
    }
  }

  public synchronized void init() {
    if (myInitialized) {
      return;
    }
    myInitialized = true;

    myMap.addListener(myFeatureListener);
    myTree.addTreeNodeListener(myTreeNodeListener);
    FileStatusManager.getInstance(myRegistry.getProject()).addFileStatusListener(myFileStatusListener);
    if (myGlobalModelListener != null) {
      GlobalSModelEventsManager.getInstance().addGlobalModelListener(myGlobalModelListener);
    }

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

    if (myGlobalModelListener != null) {
      GlobalSModelEventsManager.getInstance().addGlobalModelListener(myGlobalModelListener);
    }
    FileStatusManager.getInstance(myRegistry.getProject()).removeFileStatusListener(myFileStatusListener);
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
      synchronized (myFeatureToNodes) {
        myFeatureToNodes.putValue(feature, node);
      }
      myCommandQueue.runTask(new Runnable() {
        public void run() {
          ModelAccess.instance().runReadAction(new Runnable() {
            public void run() {
              synchronized (myFeatureToNodes) {
                // check if node isn't already removed from tree 
                if (myFeatureToNodes.get(feature).contains(node)) {
                  rehighlightNode(node, feature);
                }
              }
            }
          });
        }
      });
    }
  }

  private void unregisterNode(@NotNull MPSTreeNode node) {
    Feature feature = myFeatureExtractor.getFeature(node);
    if (feature != null) {
      synchronized (myFeatureToNodes) {
        if (myFeatureToNodes.get(feature).contains(node)) {
          myFeatureToNodes.removeValue(feature, node);
        } else {
          if (log.isErrorEnabled()) {
            log.error("trying to remove tree node which was not registered: " + node.getClass().getName() + " " + feature);
          }
        }
      }
      unhighlightNode(node);
    }
  }

  private void unhighlightNode(@NotNull MPSTreeNode node) {
    node.removeTreeMessages(this, true);
  }

  private void rehighlightNode(@NotNull MPSTreeNode node, @NotNull Feature feature) {
    unhighlightNode(node);

    SModelDescriptor model = SModelRepository.getInstance().getModelDescriptor(feature.getModelReference());
    if (model instanceof EditableSModelDescriptor) {
      EditableSModelDescriptor emd = (EditableSModelDescriptor) model;
      myRegistry.getCurrentDifference(emd).setEnabled(true);

      ModelChange change = myMap.get(feature);
      if (change == null) {
        change = myMap.getAddedAncestorValue(feature);
      }
      if (change != null) {
        node.addTreeMessage(getMessage(change, emd));
      } else if (myMap.isAncestorOfAddedFeature(feature)) {
        node.addTreeMessage(getMessage(FileStatus.MODIFIED));
      } else if (feature instanceof ModelFeature) {
        node.addTreeMessage(getMessage((ModelFeature) feature));
      }
    }
  }

  private void rehighlightFeature(@NotNull Feature feature) {
    for (MPSTreeNode node : Sequence.fromIterable(myFeatureToNodes.get(feature))) {
      rehighlightNode(node, feature);
    }
  }

  private void rehighlightFeatureAndDescendants(@NotNull final Feature feature) {
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        synchronized (myFeatureToNodes) {
          rehighlightFeature(feature);
          SModelReference modelRef = feature.getModelReference();
          for (Feature anotherFeature : SetSequence.fromSet(myFeatureToNodes.keySet())) {
            if (modelRef.equals(anotherFeature.getModelReference())) {
              if (Sequence.fromIterable(Sequence.fromArray(anotherFeature.getAncestors())).any(new IWhereFilter<Feature>() {
                public boolean accept(Feature a) {
                  return feature.equals(a);
                }
              })) {
                rehighlightFeature(anotherFeature);
              }
            }
          }
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
  private TreeMessage getMessage(@NotNull ModelChange modelChange, @NotNull EditableSModelDescriptor modelDescriptor) {
    switch (modelChange.getType()) {
      case ADD:
        if (modelChange instanceof AddRootChange) {
          FileStatus modelStatus = getModelFileStatus(modelDescriptor, myRegistry.getProject());
          if (BaseVersionUtil.isAddedFileStatus(modelStatus)) {
            return getMessage(modelStatus);
          }
        }
        return getMessage(FileStatus.ADDED);
      case CHANGE:
        return getMessage(FileStatus.MODIFIED);
      default:
        assert false;
        return getMessage(FileStatus.MERGED_WITH_CONFLICTS);
    }
  }

  @Nullable
  private TreeMessage getMessage(@NotNull ModelFeature modelFeature) {
    SModelDescriptor md = SModelRepository.getInstance().getModelDescriptor(modelFeature.getModelReference());
    if (md instanceof EditableSModelDescriptor) {
      return getMessage(getModelFileStatus((EditableSModelDescriptor) md, myRegistry.getProject()));
    } else {
      return null;
    }
  }

  @Nullable
  private static FileStatus getModelFileStatus(@NotNull EditableSModelDescriptor emd, @NotNull Project project) {
    VirtualFile vf = VirtualFileUtils.getVirtualFile(emd.getModelFile());
    if (vf != null) {
      FileStatus modelStatus = FileStatusManager.getInstance(project).getStatus(vf);
      return modelStatus;
    }
    return null;
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

    public void featureStateChanged(Feature feature) {
      rehighlightFeatureAndDescendants(feature);
    }
  }

  private class MyFileStatusListener implements FileStatusListener {
    public MyFileStatusListener() {
    }

    public void fileStatusChanged(@NotNull VirtualFile file) {
      IFile ifile = VirtualFileUtils.toIFile(file);
      EditableSModelDescriptor emd = SModelRepository.getInstance().findModel(ifile);
      if (emd != null) {
        rehighlightFeatureAndDescendants(new ModelFeature(emd.getSModelReference()));
      }
    }

    public void fileStatusesChanged() {
      synchronized (myFeatureToNodes) {
        for (Feature f : SetSequence.fromSet(myFeatureToNodes.keySet())) {
          if (f instanceof ModelFeature) {
            rehighlightFeatureAndDescendants(f);
          }
        }
      }
    }
  }

  private class MyModelListener extends SModelAdapter {
    public MyModelListener() {
    }

    @Override
    public void beforeModelDisposed(SModel model) {
      SModelReference modelRef = model.getSModelReference();
      List<MPSTreeNode> obsoleteTreeNodes = ListSequence.fromList(new ArrayList<MPSTreeNode>());
      synchronized (myFeatureToNodes) {
        for (Feature f : SetSequence.fromSet(myFeatureToNodes.keySet())) {
          if (!(f instanceof ModelFeature) && modelRef.equals(f.getModelReference())) {
            ListSequence.fromList(obsoleteTreeNodes).addSequence(Sequence.fromIterable(myFeatureToNodes.get(f)));
            myFeatureToNodes.remove(f);
          }
        }
      }
      ListSequence.fromList(obsoleteTreeNodes).visitAll(new IVisitor<MPSTreeNode>() {
        public void visit(MPSTreeNode tn) {
          unhighlightNode(tn);
        }
      });
    }
  }
}
