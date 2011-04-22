package jetbrains.mps.vcs.changesmanager;

/*Generated by MPS */

import com.intellij.openapi.components.AbstractProjectComponent;
import jetbrains.mps.ide.ui.treeMessages.TreeMessageOwner;
import jetbrains.mps.ide.ui.treeMessages.TreeMessage;
import com.intellij.openapi.vcs.FileStatus;
import java.util.Map;
import jetbrains.mps.ide.ui.MPSTreeNode;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.HashMap;
import jetbrains.mps.util.CounterMap;
import jetbrains.mps.smodel.SNode;
import java.util.List;
import jetbrains.mps.ide.ui.smodel.SNodeTreeNode;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.ide.ui.smodel.SModelTreeNode;
import jetbrains.mps.ide.ui.MPSTreeNodeListener;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.project.Project;
import jetbrains.mps.ide.projectPane.ProjectPane;
import jetbrains.mps.ide.ui.MPSTree;
import jetbrains.mps.ide.projectPane.logicalview.ProjectTree;
import jetbrains.mps.smodel.SModelStereotype;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.vcs.diff.oldchanges.Change;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.smodel.SNodeId;
import jetbrains.mps.vcs.diff.oldchanges.SetPropertyChange;
import jetbrains.mps.vcs.diff.oldchanges.SetReferenceChange;
import jetbrains.mps.vcs.diff.oldchanges.NewNodeChange;
import jetbrains.mps.ide.ui.smodel.PropertyTreeNode;
import jetbrains.mps.ide.ui.smodel.ReferenceTreeNode;
import jetbrains.mps.ide.ui.smodel.PropertiesTreeNode;
import jetbrains.mps.ide.ui.smodel.ReferencesTreeNode;
import org.apache.commons.lang.ObjectUtils;
import org.jetbrains.annotations.Nullable;
import java.awt.Color;
import java.util.Set;
import jetbrains.mps.ide.ThreadUtils;
import jetbrains.mps.internal.collections.runtime.IVisitor;

public class ProjectTreeChangesHighlighter extends AbstractProjectComponent implements TreeMessageOwner {
  private static final boolean EXTRA_CHECKS_ENABLED = true;

  private TreeMessage myDefaultTreeMessage = new TreeMessage(FileStatus.COLOR_MODIFIED, null, this);
  private ChangesManager myChangesManager;
  private SimpleCommandQueue myCommandQueue;
  private Map<MPSTreeNode, ProjectTreeChangesHighlighter.PrimaryMessage> myPrimaryMessageForTreeNode = MapSequence.fromMap(new HashMap<MPSTreeNode, ProjectTreeChangesHighlighter.PrimaryMessage>());
  private CounterMap<SNode> myChangeCountForNode = new CounterMap<SNode>(new ProjectTreeChangesHighlighter.MyChangeCountForNodeHandler());
  private CounterMap<SNode> myPropertyChangeCountForNode = new CounterMap<SNode>(new ProjectTreeChangesHighlighter.MyPropertyChangeCountForNodeHandler());
  private CounterMap<SNode> myReferenceChangeCountForNode = new CounterMap<SNode>(new ProjectTreeChangesHighlighter.MyReferenceChangeCountForNodeHandler());
  private Map<SNode, List<SNodeTreeNode>> mySNodesToTreeNodes = MapSequence.fromMap(new HashMap<SNode, List<SNodeTreeNode>>());
  private Map<SModelDescriptor, List<SModelTreeNode>> mySModelDescriptorsToTreeNodes = MapSequence.fromMap(new HashMap<SModelDescriptor, List<SModelTreeNode>>());
  private ChangeListener myChangeListener = new ProjectTreeChangesHighlighter.MyChangeListener();
  private MPSTreeNodeListener myTreeNodeListener = new ProjectTreeChangesHighlighter.MyMPSTreeNodeListener();

  public ProjectTreeChangesHighlighter(@NotNull Project project, @NotNull ChangesManager changesManager) {
    super(project);
    myChangesManager = changesManager;
    myCommandQueue = myChangesManager.getCommandQueue();
  }

  public void projectOpened() {
    final ProjectPane projectPane = ProjectPane.getInstance(myProject);
    MPSTree tree = ProjectPane.getInstance(myProject).getTree();
    if (tree != null) {
      registerTreeNodesRecursively(tree.getRootNode());
      tree.addTreeNodeListener(myTreeNodeListener);
    } else {
      projectPane.addComponentCreationListener(new ProjectPane.ComponentCreationListener() {
        public void componentCreated(ProjectPane pane) {
          pane.removeComponentCreationListener(this);
          ProjectTree createdTree = pane.getTree();
          registerTreeNodesRecursively(createdTree.getRootNode());
          createdTree.addTreeNodeListener(myTreeNodeListener);
        }
      });
    }
  }

  public void projectClosed() {
    MPSTree tree = ProjectPane.getInstance(myProject).getTree();
    if (tree == null) {
      return;
    }
    tree.removeTreeNodeListener(myTreeNodeListener);
    MapSequence.fromMap(mySNodesToTreeNodes).clear();
  }

  private void registerTreeNode(@NotNull MPSTreeNode treeNode) {
    if (treeNode instanceof SModelTreeNode) {
      final SModelTreeNode sModelTreeNode = ((SModelTreeNode) treeNode);
      final SModelDescriptor modelDescriptor = sModelTreeNode.getSModelDescriptor();
      if (SModelStereotype.isUserModel(modelDescriptor)) {
        myCommandQueue.runTask(new Runnable() {
          public void run() {
            if (!(MapSequence.fromMap(mySModelDescriptorsToTreeNodes).containsKey(modelDescriptor))) {
              MapSequence.fromMap(mySModelDescriptorsToTreeNodes).put(modelDescriptor, ListSequence.fromList(new ArrayList<SModelTreeNode>()));
              ModelChangesManager modelChangesManager = myChangesManager.getModelChangesManager(modelDescriptor);
              for (Change change : ListSequence.fromList(modelChangesManager.getChangeList())) {
                highlightChange(change, sModelTreeNode.getSModel());
              }
              modelChangesManager.addChangeListener(myChangeListener);
            }
            ListSequence.fromList(MapSequence.fromMap(mySModelDescriptorsToTreeNodes).get(modelDescriptor)).addElement(sModelTreeNode);
          }
        });
      }
    }
    if (!(treeNode instanceof SNodeTreeNode)) {
      return;
    }
    SNodeTreeNode sNodeTreeNode = ((SNodeTreeNode) treeNode);
    final SNode node = sNodeTreeNode.getSNode();
    if (node != null) {
      if (MapSequence.fromMap(mySNodesToTreeNodes).containsKey(node)) {
        ListSequence.fromList(MapSequence.fromMap(mySNodesToTreeNodes).get(node)).addElement(sNodeTreeNode);
      } else {
        MapSequence.fromMap(mySNodesToTreeNodes).put(node, ListSequence.fromListAndArray(new ArrayList<SNodeTreeNode>(), sNodeTreeNode));
        myCommandQueue.runTask(new Runnable() {
          public void run() {
            if (node.isDisposed()) {
              return;
            }
            final Wrappers._T<SModel> model = new Wrappers._T<SModel>();
            ModelAccess.instance().runReadAction(new Runnable() {
              public void run() {
                model.value = SNodeOperations.getModel(node);
              }
            });
            if (model.value.getModelDescriptor() == null) {
              return;
            }
            ModelChangesManager modelChangesManager = myChangesManager.getModelChangesManager(model.value);
            if (modelChangesManager != null) {
              modelChangesManager.setEnabled(true);
            }
          }
        });
      }
    }
  }

  private void unregisterTreeNode(@NotNull MPSTreeNode treeNode) {
    if (EXTRA_CHECKS_ENABLED && treeNode.isRoot()) {
      for (MPSTreeNode descendant : Sequence.fromIterable(MPSTreeUtils.getDescendants(treeNode))) {
        if (MapSequence.fromMap(myPrimaryMessageForTreeNode).containsKey(descendant)) {
          MapSequence.fromMap(myPrimaryMessageForTreeNode).removeKey(descendant);
        }
      }
    }
    if (treeNode instanceof SModelTreeNode) {
      final SModelTreeNode sModelTreeNode = ((SModelTreeNode) treeNode);
      final SModelDescriptor modelDescriptor = sModelTreeNode.getSModelDescriptor();
      if (SModelStereotype.isUserModel(modelDescriptor)) {
        myCommandQueue.runTask(new Runnable() {
          public void run() {
            if (MapSequence.fromMap(mySModelDescriptorsToTreeNodes).containsKey(modelDescriptor)) {
              ListSequence.fromList(MapSequence.fromMap(mySModelDescriptorsToTreeNodes).get(modelDescriptor)).removeElement(sModelTreeNode);
              if (ListSequence.fromList(MapSequence.fromMap(mySModelDescriptorsToTreeNodes).get(modelDescriptor)).isEmpty()) {
                MapSequence.fromMap(mySModelDescriptorsToTreeNodes).removeKey(modelDescriptor);
                ModelChangesManager modelChangesManager = myChangesManager.getModelChangesManager(modelDescriptor);
                modelChangesManager.removeChangeListener(myChangeListener);
              }
            }
          }
        });
      }
    }
    if (!(treeNode instanceof SNodeTreeNode)) {
      return;
    }
    SNodeTreeNode sNodeTreeNode = ((SNodeTreeNode) treeNode);
    SNode node = sNodeTreeNode.getSNode();
    if (node != null) {
      if (MapSequence.fromMap(mySNodesToTreeNodes).containsKey(node)) {
        ListSequence.fromList(MapSequence.fromMap(mySNodesToTreeNodes).get(node)).removeElement(sNodeTreeNode);
        if (ListSequence.fromList(MapSequence.fromMap(mySNodesToTreeNodes).get(node)).isEmpty()) {
          MapSequence.fromMap(mySNodesToTreeNodes).removeKey(node);
        }
      }
    }
  }

  private void highlightChange(@NotNull final Change change, @NotNull final SModel model) {
    myCommandQueue.runTask(new Runnable() {
      public void run() {
        updateModelHighlighting(model.getModelDescriptor());

        final SNodeId affectedNodeId = change.getAffectedNodeId();
        if (affectedNodeId == null) {
          return;
        }
        SNode node = model.getNodeById(affectedNodeId);
        final Wrappers._T<SNode> nodeToIncrement = new Wrappers._T<SNode>(node);
        if (nodeToIncrement.value == null) {
          ModelAccess.instance().runReadAction(new Runnable() {
            public void run() {
              nodeToIncrement.value = findNearestBaseAncestor(affectedNodeId, model);
            }
          });
        }
        ModelAccess.instance().runReadAction(new Runnable() {
          public void run() {
            for (SNode ancestor : ListSequence.fromList(SNodeOperations.getAncestors(nodeToIncrement.value, null, true))) {
              myChangeCountForNode.increment(ancestor);
            }
          }
        });
        if (node == null) {
          return;
        }
        if (change instanceof SetPropertyChange) {
          myPropertyChangeCountForNode.increment(node);
        } else if (change instanceof SetReferenceChange) {
          myReferenceChangeCountForNode.increment(node);
        }
        if (change instanceof NewNodeChange) {
          for (SNodeTreeNode treeNode : ListSequence.fromList(MapSequence.fromMap(mySNodesToTreeNodes).get(node))) {
            highlightTreeNodeWithMessage(treeNode, new ProjectTreeChangesHighlighter.PrimaryMessage(getColor(change, myChangesManager.getModelChangesManager(model).getFileStatus())));
          }
        } else if (change instanceof SetPropertyChange) {
          String propertyName = ((SetPropertyChange) change).getProperty();
          for (SNodeTreeNode treeNode : ListSequence.fromList(MapSequence.fromMap(mySNodesToTreeNodes).get(node))) {
            PropertyTreeNode propertyTreeNode = MPSTreeUtils.findPropertyTreeNode(treeNode, propertyName);
            if (propertyTreeNode != null) {
              highlightTreeNodeWithMessage(propertyTreeNode, new ProjectTreeChangesHighlighter.PrimaryMessage(getColor(change)));
            }
          }
        } else if (change instanceof SetReferenceChange) {
          String role = ((SetReferenceChange) change).getRole();
          for (SNodeTreeNode treeNode : ListSequence.fromList(MapSequence.fromMap(mySNodesToTreeNodes).get(node))) {
            ReferenceTreeNode referenceTreeNode = MPSTreeUtils.findReferenceTreeNode(treeNode, role);
            if (referenceTreeNode != null) {
              highlightTreeNodeWithMessage(referenceTreeNode, new ProjectTreeChangesHighlighter.PrimaryMessage(getColor(change)));
            }
          }
        }
      }
    });
  }

  private SNode findNearestBaseAncestor(@NotNull SNodeId nodeId, @NotNull SModel model) {
    // this should be executed inside read action 
    ModelChangesManager modelChangesManager = myChangesManager.getModelChangesManager(model);
    SNodeId currentNodeId = nodeId;
    while (currentNodeId != null && model.getNodeById(currentNodeId) == null) {
      currentNodeId = modelChangesManager.getBaseParentId(currentNodeId);
    }
    if (currentNodeId == null) {
      return null;
    }
    return model.getNodeById(currentNodeId);
  }

  private void unhighlightChange(@NotNull final Change change, @NotNull final SModel model) {
    myCommandQueue.runTask(new Runnable() {
      public void run() {
        updateModelHighlighting(model.getModelDescriptor());

        final SNodeId affectedNodeId = change.getAffectedNodeId();
        if (affectedNodeId == null) {
          return;
        }
        if (model.isDisposed()) {
          return;
        }
        SNode node = model.getNodeById(affectedNodeId);
        final Wrappers._T<SNode> nodeToDecrement = new Wrappers._T<SNode>(node);
        if (nodeToDecrement.value == null) {
          ModelAccess.instance().runReadAction(new Runnable() {
            public void run() {
              nodeToDecrement.value = findNearestBaseAncestor(affectedNodeId, model);
            }
          });
        }
        if (nodeToDecrement.value == null && change instanceof NewNodeChange) {
          final SNodeId parentId = ((NewNodeChange) change).getNodeParent();
          if (parentId != null) {
            nodeToDecrement.value = model.getNodeById(parentId);
            if (nodeToDecrement.value == null && parentId != null) {
              ModelAccess.instance().runReadAction(new Runnable() {
                public void run() {
                  nodeToDecrement.value = findNearestBaseAncestor(parentId, model);
                }
              });
            }
          }
        }
        if (nodeToDecrement.value != null) {
          ModelAccess.instance().runReadAction(new Runnable() {
            public void run() {
              for (SNode ancestor : ListSequence.fromList(SNodeOperations.getAncestors(nodeToDecrement.value, null, true))) {
                myChangeCountForNode.decrement(ancestor);
              }
            }
          });
        }
        if (node == null) {
          return;
        }
        if (change instanceof SetPropertyChange) {
          myPropertyChangeCountForNode.decrement(node);
        } else if (change instanceof SetReferenceChange) {
          myReferenceChangeCountForNode.decrement(node);
        }
        if (change instanceof NewNodeChange) {
          for (SNodeTreeNode treeNode : ListSequence.fromList(MapSequence.fromMap(mySNodesToTreeNodes).get(node))) {
            unhighlightTreeNode(treeNode);
          }
        } else if (change instanceof SetPropertyChange) {
          String propertyName = ((SetPropertyChange) change).getProperty();
          for (SNodeTreeNode treeNode : ListSequence.fromList(MapSequence.fromMap(mySNodesToTreeNodes).get(node))) {
            PropertyTreeNode propertyTreeNode = MPSTreeUtils.findPropertyTreeNode(treeNode, propertyName);
            if (propertyTreeNode != null) {
              unhighlightTreeNode(propertyTreeNode);
            }
          }
        } else if (change instanceof SetReferenceChange) {
          String role = ((SetReferenceChange) change).getRole();
          for (SNodeTreeNode treeNode : ListSequence.fromList(MapSequence.fromMap(mySNodesToTreeNodes).get(node))) {
            ReferenceTreeNode referenceTreeNode = MPSTreeUtils.findReferenceTreeNode(treeNode, role);
            if (referenceTreeNode != null) {
              unhighlightTreeNode(referenceTreeNode);
            }
          }
        }
      }
    });
  }

  private void highlightTreeNodeWithMessage(@NotNull MPSTreeNode treeNode, @NotNull ProjectTreeChangesHighlighter.PrimaryMessage primaryMessage) {
    if (MapSequence.fromMap(myPrimaryMessageForTreeNode).containsKey(treeNode)) {
      unhighlightTreeNode(treeNode);
    }
    treeNode.addTreeMessage(primaryMessage);
    MapSequence.fromMap(myPrimaryMessageForTreeNode).put(treeNode, primaryMessage);
    for (MPSTreeNode descendant : Sequence.fromIterable(MPSTreeUtils.getDescendants(treeNode))) {
      descendant.addTreeMessage(primaryMessage.getDescendantSecondaryMessage());
    }
  }

  private void unhighlightTreeNode(@NotNull MPSTreeNode treeNode) {
    ProjectTreeChangesHighlighter.PrimaryMessage primaryMessage = MapSequence.fromMap(myPrimaryMessageForTreeNode).get(treeNode);
    if (EXTRA_CHECKS_ENABLED && primaryMessage == null) {
      return;
    }
    MapSequence.fromMap(myPrimaryMessageForTreeNode).removeKey(treeNode);
    treeNode.removeTreeMessage(primaryMessage);
    for (MPSTreeNode descendant : Sequence.fromIterable(MPSTreeUtils.getDescendants(treeNode))) {
      descendant.removeTreeMessage(primaryMessage.getDescendantSecondaryMessage());
    }
  }

  private void highlightAllChanges(@NotNull final MPSTreeNode treeNode) {
    myCommandQueue.runTask(new Runnable() {
      public void run() {
        // Node can be already detached 
        if (treeNode.getTree() == null) {
          return;
        }

        if (treeNode instanceof SModelTreeNode) {
          updateModelHighlighting(((SModelTreeNode) treeNode).getSModelDescriptor());
          return;
        }
        final Wrappers._T<ProjectTreeChangesHighlighter.PrimaryMessage> primaryMessage = new Wrappers._T<ProjectTreeChangesHighlighter.PrimaryMessage>(null);
        if (treeNode instanceof SNodeTreeNode) {
          final SNode node = ((SNodeTreeNode) treeNode).getSNode();
          if (node == null) {
            return;
          }
          ModelAccess.instance().runReadAction(new Runnable() {
            public void run() {
              if (check_ybywwq_a0a0a2a5a0a0a0j(SNodeOperations.getModel(node)) == null) {
                return;
              }
              ModelChangesManager modelChangesManager = myChangesManager.getModelChangesManager(SNodeOperations.getModel(node));
              for (Change c : ListSequence.fromList(modelChangesManager.getChangeList())) {
                if ((c instanceof NewNodeChange) && node.getSNodeId().equals(c.getAffectedNodeId())) {
                  assert primaryMessage.value == null;
                  primaryMessage.value = new ProjectTreeChangesHighlighter.PrimaryMessage(getColor(c, modelChangesManager.getFileStatus()));
                }
              }
            }
          });
        } else if (treeNode instanceof PropertiesTreeNode) {
          if (myPropertyChangeCountForNode.get(((PropertiesTreeNode) treeNode).getSNode()) != 0) {
            treeNode.addTreeMessage(myDefaultTreeMessage);
          }
        } else if (treeNode instanceof ReferencesTreeNode) {
          if (myReferenceChangeCountForNode.get(((ReferencesTreeNode) treeNode).getSNode()) != 0) {
            treeNode.addTreeMessage(myDefaultTreeMessage);
          }
        } else if (treeNode instanceof PropertyTreeNode) {
          final SNode node = ((PropertiesTreeNode) treeNode.getParent()).getSNode();
          if (node == null) {
            return;
          }
          ModelAccess.instance().runReadAction(new Runnable() {
            public void run() {
              ModelChangesManager modelChangesManager = myChangesManager.getModelChangesManager(SNodeOperations.getModel(node));
              for (Change c : ListSequence.fromList(modelChangesManager.getChangeList())) {
                if (c instanceof SetPropertyChange && node.getSNodeId().equals(c.getAffectedNodeId()) && ObjectUtils.equals(((SetPropertyChange) c).getProperty(), ((PropertyTreeNode) treeNode).getProperty())) {
                  assert primaryMessage.value == null;
                  primaryMessage.value = new ProjectTreeChangesHighlighter.PrimaryMessage(getColor(c));
                }
              }
            }
          });
        } else if (treeNode instanceof ReferenceTreeNode) {
          final SNode node = ((ReferencesTreeNode) treeNode.getParent()).getSNode();
          if (node == null) {
            return;
          }
          ModelAccess.instance().runReadAction(new Runnable() {
            public void run() {
              ModelChangesManager modelChangesManager = myChangesManager.getModelChangesManager(SNodeOperations.getModel(node));
              for (Change c : ListSequence.fromList(modelChangesManager.getChangeList())) {
                if (c instanceof SetReferenceChange && node.getSNodeId().equals(c.getAffectedNodeId()) && ObjectUtils.equals(((SetReferenceChange) c).getRole(), ((ReferenceTreeNode) treeNode).getRef().getRole())) {
                  assert primaryMessage.value == null;
                  primaryMessage.value = new ProjectTreeChangesHighlighter.PrimaryMessage(getColor(c));
                }
              }
            }
          });
        }
        if (primaryMessage.value == null) {
          MPSTreeNode currentTreeNode = treeNode;
          while (currentTreeNode != null && !(currentTreeNode instanceof SModelTreeNode)) {
            if (MapSequence.fromMap(myPrimaryMessageForTreeNode).containsKey(currentTreeNode)) {
              primaryMessage.value = MapSequence.fromMap(myPrimaryMessageForTreeNode).get(currentTreeNode);
              break;
            }
            currentTreeNode = ((MPSTreeNode) currentTreeNode.getParent());
          }
          if (primaryMessage.value != null) {
            treeNode.addTreeMessage(primaryMessage.value.getDescendantSecondaryMessage());
          } else {
            if (treeNode instanceof SNodeTreeNode) {
              SNode node = ((SNodeTreeNode) treeNode).getSNode();
              if (node != null) {
                if (!(myChangeCountForNode.isZero(node))) {
                  treeNode.addTreeMessage(myDefaultTreeMessage);
                }
              }
            }
          }
        } else {
          highlightTreeNodeWithMessage(treeNode, primaryMessage.value);
        }
      }
    });
  }

  private void updateModelHighlighting(@Nullable final SModelDescriptor modelDescriptor) {
    if (modelDescriptor == null || !(SModelStereotype.isUserModel(modelDescriptor))) {
      return;
    }

    myCommandQueue.runTask(new Runnable() {
      public void run() {
        FileStatus fileStatus = check_ybywwq_a0a0a0a2a01(myChangesManager.getModelChangesManager(modelDescriptor));
        Color color = check_ybywwq_a0b0a0a2a01(fileStatus);
        for (SModelTreeNode modelTreeNode : ListSequence.fromList(MapSequence.fromMap(mySModelDescriptorsToTreeNodes).get(modelDescriptor))) {
          Set<TreeMessage> wereMessages = modelTreeNode.removeTreeMessages(ProjectTreeChangesHighlighter.this, true);
          if (EXTRA_CHECKS_ENABLED && !(wereMessages.isEmpty()) && fileStatus == FileStatus.NOT_CHANGED) {
            ModelAccess.instance().runReadAction(new Runnable() {
              public void run() {
                SModel model = modelDescriptor.getSModel();
                if (model != null && !(model.isDisposed())) {
                  for (final SNode node : Sequence.fromIterable(model.nodes())) {
                    myChangeCountForNode.zeroizeKey(node);
                    myPropertyChangeCountForNode.zeroizeKey(node);
                    myReferenceChangeCountForNode.zeroizeKey(node);
                    ThreadUtils.runInUIThreadNoWait(new Runnable() {
                      public void run() {
                        ListSequence.fromList(MapSequence.fromMap(mySNodesToTreeNodes).get(node)).visitAll(new IVisitor<SNodeTreeNode>() {
                          public void visit(SNodeTreeNode tn) {
                            tn.removeTreeMessages(ProjectTreeChangesHighlighter.this, true);
                          }
                        });
                      }
                    });
                  }
                }
              }
            });
          }
          if (color != null) {
            modelTreeNode.addTreeMessage(new TreeMessage(color, null, ProjectTreeChangesHighlighter.this));
          }
        }
      }
    });
  }

  private void registerTreeNodesRecursively(@NotNull MPSTreeNode treeNode) {
    registerTreeNode(treeNode);
    for (MPSTreeNode child : Sequence.fromIterable(treeNode)) {
      registerTreeNodesRecursively(child);
    }
  }

  @Nullable
  private static Color getColor(@NotNull Change change) {
    return getColor(change, null);
  }

  @Nullable
  private static Color getColor(@NotNull Change change, FileStatus modelFileStatus) {
    switch (change.getChangeType()) {
      case ADD:
        if (modelFileStatus == FileStatus.ADDED || modelFileStatus == FileStatus.UNKNOWN) {
          return modelFileStatus.getColor();
        }
        return FileStatus.COLOR_ADDED;
      case CHANGE:
        return FileStatus.COLOR_MODIFIED;
      case DELETE:
        return null;
      default:
        return null;
    }
  }

  private static SModelDescriptor check_ybywwq_a0a0a2a5a0a0a0j(SModel checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getModelDescriptor();
    }
    return null;
  }

  private static FileStatus check_ybywwq_a0a0a0a2a01(ModelChangesManager checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getFileStatus();
    }
    return null;
  }

  private static Color check_ybywwq_a0b0a0a2a01(FileStatus checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getColor();
    }
    return null;
  }

  private class PrimaryMessage extends TreeMessage {
    private TreeMessage myDescendantSecondaryMessage;

    public PrimaryMessage(@Nullable Color color) {
      super(color, null, ProjectTreeChangesHighlighter.this);
      myDescendantSecondaryMessage = new TreeMessage(color, null, ProjectTreeChangesHighlighter.this) {
        @Override
        public int getPriority() {
          return 1;
        }
      };
    }

    @NotNull
    public TreeMessage getDescendantSecondaryMessage() {
      return myDescendantSecondaryMessage;
    }

    @Override
    public int getPriority() {
      return 2;
    }
  }

  private class MyChangeCountForNodeHandler implements CounterMap.CounterMapHandler<SNode> {
    public MyChangeCountForNodeHandler() {
    }

    public void counterZero(@NotNull SNode key) {
      for (SNodeTreeNode sNodeTreeNode : ListSequence.fromList(MapSequence.fromMap(mySNodesToTreeNodes).get(key))) {
        sNodeTreeNode.removeTreeMessage(myDefaultTreeMessage);
      }
    }

    public void counterNonZero(@NotNull SNode key) {
      for (SNodeTreeNode sNodeTreeNode : ListSequence.fromList(MapSequence.fromMap(mySNodesToTreeNodes).get(key))) {
        sNodeTreeNode.addTreeMessage(myDefaultTreeMessage);
      }
    }
  }

  private class MyPropertyChangeCountForNodeHandler implements CounterMap.CounterMapHandler<SNode> {
    public MyPropertyChangeCountForNodeHandler() {
    }

    public void counterZero(@NotNull SNode key) {
      for (SNodeTreeNode sNodeTreeNode : ListSequence.fromList(MapSequence.fromMap(mySNodesToTreeNodes).get(key))) {
        PropertiesTreeNode propertiesTreeNode = MPSTreeUtils.findPropertiesTreeNode(sNodeTreeNode);
        if (propertiesTreeNode != null) {
          propertiesTreeNode.removeTreeMessage(myDefaultTreeMessage);
        }
      }
    }

    public void counterNonZero(@NotNull SNode key) {
      for (SNodeTreeNode sNodeTreeNode : ListSequence.fromList(MapSequence.fromMap(mySNodesToTreeNodes).get(key))) {
        PropertiesTreeNode propertiesTreeNode = MPSTreeUtils.findPropertiesTreeNode(sNodeTreeNode);
        if (propertiesTreeNode != null) {
          propertiesTreeNode.addTreeMessage(myDefaultTreeMessage);
        }
      }
    }
  }

  private class MyReferenceChangeCountForNodeHandler implements CounterMap.CounterMapHandler<SNode> {
    public MyReferenceChangeCountForNodeHandler() {
    }

    public void counterZero(@NotNull SNode key) {
      for (SNodeTreeNode sNodeTreeNode : ListSequence.fromList(MapSequence.fromMap(mySNodesToTreeNodes).get(key))) {
        ReferencesTreeNode referencesTreeNode = MPSTreeUtils.findReferencesTreeNode(sNodeTreeNode);
        if (referencesTreeNode != null) {
          referencesTreeNode.removeTreeMessage(myDefaultTreeMessage);
        }
      }
    }

    public void counterNonZero(@NotNull SNode key) {
      for (SNodeTreeNode sNodeTreeNode : ListSequence.fromList(MapSequence.fromMap(mySNodesToTreeNodes).get(key))) {
        ReferencesTreeNode referencesTreeNode = MPSTreeUtils.findReferencesTreeNode(sNodeTreeNode);
        if (referencesTreeNode != null) {
          referencesTreeNode.addTreeMessage(myDefaultTreeMessage);
        }
      }
    }
  }

  private class MyChangeListener implements ChangeListener {
    public MyChangeListener() {
    }

    public void changeAdded(@NotNull Change change, @NotNull SModel model) {
      highlightChange(change, model);
    }

    public void changeRemoved(@NotNull Change change, @NotNull SModel model) {
      unhighlightChange(change, model);
    }

    public void fileStatusChanged(@Nullable FileStatus newFileStatus, @NotNull SModel model) {
      updateModelHighlighting(model.getModelDescriptor());
    }

    public void changeUpdateStarted() {
    }

    public void changeUpdateFinished() {
    }
  }

  private class MyMPSTreeNodeListener implements MPSTreeNodeListener {
    public MyMPSTreeNodeListener() {
    }

    public void treeNodeAdded(MPSTreeNode treeNode, MPSTree tree) {
      registerTreeNode(treeNode);
      highlightAllChanges(treeNode);
    }

    public void treeNodeRemoved(MPSTreeNode treeNode, MPSTree tree) {
      unhighlightTreeNode(treeNode);
      unregisterTreeNode(treeNode);
    }

    public void treeNodeUpdated(MPSTreeNode node, MPSTree tree) {
    }
  }
}
