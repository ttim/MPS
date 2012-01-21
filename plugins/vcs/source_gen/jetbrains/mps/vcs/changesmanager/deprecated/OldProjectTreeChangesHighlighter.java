package jetbrains.mps.vcs.changesmanager.deprecated;

/*Generated by MPS */

import com.intellij.openapi.components.AbstractProjectComponent;
import jetbrains.mps.ide.ui.treeMessages.TreeMessageOwner;
import jetbrains.mps.ide.ui.treeMessages.TreeMessage;
import com.intellij.openapi.vcs.FileStatus;
import jetbrains.mps.vcs.changesmanager.SimpleCommandQueue;
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
import jetbrains.mps.smodel.descriptor.EditableSModelDescriptor;
import jetbrains.mps.smodel.SModelStereotype;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.vcs.changesmanager.deprecated.changes.OldChange;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.smodel.SNodeId;
import jetbrains.mps.vcs.changesmanager.deprecated.changes.OldSetPropertyChange;
import jetbrains.mps.vcs.changesmanager.deprecated.changes.OldSetReferenceChange;
import jetbrains.mps.vcs.changesmanager.deprecated.changes.NewNodeChange;
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
import javax.swing.tree.TreeNode;

public class OldProjectTreeChangesHighlighter extends AbstractProjectComponent implements TreeMessageOwner {
  private static final boolean EXTRA_CHECKS_ENABLED = true;

  private TreeMessage myDefaultTreeMessage = new TreeMessage(FileStatus.COLOR_MODIFIED, null, this);
  private OldChangesManager myChangesManager;
  private SimpleCommandQueue myCommandQueue;
  private Map<MPSTreeNode, OldProjectTreeChangesHighlighter.PrimaryMessage> myPrimaryMessageForTreeNode = MapSequence.fromMap(new HashMap<MPSTreeNode, OldProjectTreeChangesHighlighter.PrimaryMessage>());
  private CounterMap<SNode> myChangeCountForNode = new CounterMap<SNode>(new OldProjectTreeChangesHighlighter.MyChangeCountForNodeHandler());
  private CounterMap<SNode> myPropertyChangeCountForNode = new CounterMap<SNode>(new OldProjectTreeChangesHighlighter.MyPropertyChangeCountForNodeHandler());
  private CounterMap<SNode> myReferenceChangeCountForNode = new CounterMap<SNode>(new OldProjectTreeChangesHighlighter.MyReferenceChangeCountForNodeHandler());
  private Map<SNode, List<SNodeTreeNode>> mySNodesToTreeNodes = MapSequence.fromMap(new HashMap<SNode, List<SNodeTreeNode>>());
  private Map<SModelDescriptor, List<SModelTreeNode>> mySModelDescriptorsToTreeNodes = MapSequence.fromMap(new HashMap<SModelDescriptor, List<SModelTreeNode>>());
  private OldChangeListener myChangeListener = new OldProjectTreeChangesHighlighter.MyChangeListener();
  private MPSTreeNodeListener myTreeNodeListener = new OldProjectTreeChangesHighlighter.MyMPSTreeNodeListener();

  public OldProjectTreeChangesHighlighter(@NotNull Project project, @NotNull OldChangesManager changesManager) {
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
      if (modelDescriptor instanceof EditableSModelDescriptor && SModelStereotype.isUserModel(modelDescriptor)) {
        myCommandQueue.runTask(new Runnable() {
          public void run() {
            if (!(MapSequence.fromMap(mySModelDescriptorsToTreeNodes).containsKey(modelDescriptor))) {
              MapSequence.fromMap(mySModelDescriptorsToTreeNodes).put(modelDescriptor, ListSequence.fromList(new ArrayList<SModelTreeNode>()));
              OldModelChangesManager modelChangesManager = myChangesManager.getModelChangesManager((EditableSModelDescriptor) modelDescriptor);
              for (OldChange change : ListSequence.fromList(modelChangesManager.getChangeList())) {
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
            OldModelChangesManager modelChangesManager = myChangesManager.getModelChangesManager(model.value);
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
      for (MPSTreeNode descendant : Sequence.fromIterable(OldMPSTreeUtil.getDescendants(treeNode))) {
        if (MapSequence.fromMap(myPrimaryMessageForTreeNode).containsKey(descendant)) {
          MapSequence.fromMap(myPrimaryMessageForTreeNode).removeKey(descendant);
        }
      }
    }
    if (treeNode instanceof SModelTreeNode) {
      final SModelTreeNode sModelTreeNode = ((SModelTreeNode) treeNode);
      final SModelDescriptor modelDescriptor = sModelTreeNode.getSModelDescriptor();
      if (modelDescriptor instanceof EditableSModelDescriptor && SModelStereotype.isUserModel(modelDescriptor)) {
        myCommandQueue.runTask(new Runnable() {
          public void run() {
            if (MapSequence.fromMap(mySModelDescriptorsToTreeNodes).containsKey(modelDescriptor)) {
              ListSequence.fromList(MapSequence.fromMap(mySModelDescriptorsToTreeNodes).get(modelDescriptor)).removeElement(sModelTreeNode);
              if (ListSequence.fromList(MapSequence.fromMap(mySModelDescriptorsToTreeNodes).get(modelDescriptor)).isEmpty()) {
                MapSequence.fromMap(mySModelDescriptorsToTreeNodes).removeKey(modelDescriptor);
                OldModelChangesManager modelChangesManager = myChangesManager.getModelChangesManager((EditableSModelDescriptor) modelDescriptor);
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

  private void highlightChange(@NotNull final OldChange change, @NotNull final SModel model) {
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
        if (change instanceof OldSetPropertyChange) {
          myPropertyChangeCountForNode.increment(node);
        } else if (change instanceof OldSetReferenceChange) {
          myReferenceChangeCountForNode.increment(node);
        }
        if (change instanceof NewNodeChange) {
          OldModelChangesManager changesManager = myChangesManager.getModelChangesManager(model);
          if (changesManager == null) {
            return;
          }
          for (SNodeTreeNode treeNode : ListSequence.fromList(MapSequence.fromMap(mySNodesToTreeNodes).get(node))) {
            highlightTreeNodeWithMessage(treeNode, new OldProjectTreeChangesHighlighter.PrimaryMessage(getColor(change, changesManager.getFileStatus())));
          }
        } else if (change instanceof OldSetPropertyChange) {
          String propertyName = ((OldSetPropertyChange) change).getProperty();
          for (SNodeTreeNode treeNode : ListSequence.fromList(MapSequence.fromMap(mySNodesToTreeNodes).get(node))) {
            PropertyTreeNode propertyTreeNode = OldMPSTreeUtil.findPropertyTreeNode(treeNode, propertyName);
            if (propertyTreeNode != null) {
              highlightTreeNodeWithMessage(propertyTreeNode, new OldProjectTreeChangesHighlighter.PrimaryMessage(getColor(change)));
            }
          }
        } else if (change instanceof OldSetReferenceChange) {
          String role = ((OldSetReferenceChange) change).getRole();
          for (SNodeTreeNode treeNode : ListSequence.fromList(MapSequence.fromMap(mySNodesToTreeNodes).get(node))) {
            ReferenceTreeNode referenceTreeNode = OldMPSTreeUtil.findReferenceTreeNode(treeNode, role);
            if (referenceTreeNode != null) {
              highlightTreeNodeWithMessage(referenceTreeNode, new OldProjectTreeChangesHighlighter.PrimaryMessage(getColor(change)));
            }
          }
        }
      }
    });
  }

  private SNode findNearestBaseAncestor(@NotNull SNodeId nodeId, @NotNull SModel model) {
    // this should be executed inside read action 
    OldModelChangesManager modelChangesManager = myChangesManager.getModelChangesManager(model);
    SNodeId currentNodeId = nodeId;
    while (currentNodeId != null && model.getNodeById(currentNodeId) == null) {
      currentNodeId = modelChangesManager.getBaseParentId(currentNodeId);
    }
    if (currentNodeId == null) {
      return null;
    }
    return model.getNodeById(currentNodeId);
  }

  private void unhighlightChange(@NotNull final OldChange change, @NotNull final SModel model) {
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
        if (change instanceof OldSetPropertyChange) {
          myPropertyChangeCountForNode.decrement(node);
        } else if (change instanceof OldSetReferenceChange) {
          myReferenceChangeCountForNode.decrement(node);
        }
        if (change instanceof NewNodeChange) {
          for (SNodeTreeNode treeNode : ListSequence.fromList(MapSequence.fromMap(mySNodesToTreeNodes).get(node))) {
            unhighlightTreeNode(treeNode);
          }
        } else if (change instanceof OldSetPropertyChange) {
          String propertyName = ((OldSetPropertyChange) change).getProperty();
          for (SNodeTreeNode treeNode : ListSequence.fromList(MapSequence.fromMap(mySNodesToTreeNodes).get(node))) {
            PropertyTreeNode propertyTreeNode = OldMPSTreeUtil.findPropertyTreeNode(treeNode, propertyName);
            if (propertyTreeNode != null) {
              unhighlightTreeNode(propertyTreeNode);
            }
          }
        } else if (change instanceof OldSetReferenceChange) {
          String role = ((OldSetReferenceChange) change).getRole();
          for (SNodeTreeNode treeNode : ListSequence.fromList(MapSequence.fromMap(mySNodesToTreeNodes).get(node))) {
            ReferenceTreeNode referenceTreeNode = OldMPSTreeUtil.findReferenceTreeNode(treeNode, role);
            if (referenceTreeNode != null) {
              unhighlightTreeNode(referenceTreeNode);
            }
          }
        }
      }
    });
  }

  private void highlightTreeNodeWithMessage(@NotNull MPSTreeNode treeNode, @NotNull OldProjectTreeChangesHighlighter.PrimaryMessage primaryMessage) {
    if (MapSequence.fromMap(myPrimaryMessageForTreeNode).containsKey(treeNode)) {
      unhighlightTreeNode(treeNode);
    }
    treeNode.addTreeMessage(primaryMessage);
    MapSequence.fromMap(myPrimaryMessageForTreeNode).put(treeNode, primaryMessage);
    for (MPSTreeNode descendant : Sequence.fromIterable(OldMPSTreeUtil.getDescendants(treeNode))) {
      descendant.addTreeMessage(primaryMessage.getDescendantSecondaryMessage());
    }
  }

  private void unhighlightTreeNode(@NotNull MPSTreeNode treeNode) {
    OldProjectTreeChangesHighlighter.PrimaryMessage primaryMessage = MapSequence.fromMap(myPrimaryMessageForTreeNode).get(treeNode);
    if (EXTRA_CHECKS_ENABLED && primaryMessage == null) {
      return;
    }
    MapSequence.fromMap(myPrimaryMessageForTreeNode).removeKey(treeNode);
    treeNode.removeTreeMessage(primaryMessage);
    for (MPSTreeNode descendant : Sequence.fromIterable(OldMPSTreeUtil.getDescendants(treeNode))) {
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
        final Wrappers._T<OldProjectTreeChangesHighlighter.PrimaryMessage> primaryMessage = new Wrappers._T<OldProjectTreeChangesHighlighter.PrimaryMessage>(null);
        if (treeNode instanceof SNodeTreeNode) {
          final SNode node = ((SNodeTreeNode) treeNode).getSNode();
          if (node == null) {
            return;
          }
          ModelAccess.instance().runReadAction(new Runnable() {
            public void run() {
              if (check_2ryzlz_a0a0a2a5a0a0a0j(SNodeOperations.getModel(node)) == null) {
                return;
              }
              OldModelChangesManager modelChangesManager = myChangesManager.getModelChangesManager(SNodeOperations.getModel(node));
              if (modelChangesManager == null) {
                return;
              }
              for (OldChange c : ListSequence.fromList(modelChangesManager.getChangeList())) {
                if ((c instanceof NewNodeChange) && node.getSNodeId().equals(c.getAffectedNodeId())) {
                  assert primaryMessage.value == null;
                  primaryMessage.value = new OldProjectTreeChangesHighlighter.PrimaryMessage(getColor(c, modelChangesManager.getFileStatus()));
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
          final SNode node = check_2ryzlz_a0a0c5a0a0a0j(((PropertiesTreeNode) check_2ryzlz_a0a0a0a2f0a0a0a9(treeNode)));
          if (node == null) {
            return;
          }
          ModelAccess.instance().runReadAction(new Runnable() {
            public void run() {
              OldModelChangesManager modelChangesManager = myChangesManager.getModelChangesManager(SNodeOperations.getModel(node));
              if (modelChangesManager == null) {
                return;
              }
              for (OldChange c : ListSequence.fromList(modelChangesManager.getChangeList())) {
                if (c instanceof OldSetPropertyChange && node.getSNodeId().equals(c.getAffectedNodeId()) && ObjectUtils.equals(((OldSetPropertyChange) c).getProperty(), ((PropertyTreeNode) treeNode).getProperty())) {
                  assert primaryMessage.value == null;
                  primaryMessage.value = new OldProjectTreeChangesHighlighter.PrimaryMessage(getColor(c));
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
              OldModelChangesManager modelChangesManager = myChangesManager.getModelChangesManager(SNodeOperations.getModel(node));
              if (modelChangesManager == null) {
                return;
              }
              for (OldChange c : ListSequence.fromList(modelChangesManager.getChangeList())) {
                if (c instanceof OldSetReferenceChange && node.getSNodeId().equals(c.getAffectedNodeId()) && ObjectUtils.equals(((OldSetReferenceChange) c).getRole(), ((ReferenceTreeNode) treeNode).getRef().getRole())) {
                  assert primaryMessage.value == null;
                  primaryMessage.value = new OldProjectTreeChangesHighlighter.PrimaryMessage(getColor(c));
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
    if (!(modelDescriptor instanceof EditableSModelDescriptor) || !(SModelStereotype.isUserModel(modelDescriptor))) {
      return;
    }

    myCommandQueue.runTask(new Runnable() {
      public void run() {
        FileStatus fileStatus = myChangesManager.getModelChangesManager((EditableSModelDescriptor) modelDescriptor).getFileStatus();
        Color color = check_2ryzlz_a0b0a0a2a01(fileStatus);
        for (SModelTreeNode modelTreeNode : ListSequence.fromList(MapSequence.fromMap(mySModelDescriptorsToTreeNodes).get(modelDescriptor))) {
          Set<TreeMessage> wereMessages = modelTreeNode.removeTreeMessages(OldProjectTreeChangesHighlighter.this, true);
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
                            tn.removeTreeMessages(OldProjectTreeChangesHighlighter.this, true);
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
            modelTreeNode.addTreeMessage(new TreeMessage(color, null, OldProjectTreeChangesHighlighter.this));
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
  private static Color getColor(@NotNull OldChange change) {
    return getColor(change, null);
  }

  @Nullable
  private static Color getColor(@NotNull OldChange change, FileStatus modelFileStatus) {
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

  private static SModelDescriptor check_2ryzlz_a0a0a2a5a0a0a0j(SModel checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getModelDescriptor();
    }
    return null;
  }

  private static SNode check_2ryzlz_a0a0c5a0a0a0j(PropertiesTreeNode checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getSNode();
    }
    return null;
  }

  private static TreeNode check_2ryzlz_a0a0a0a2f0a0a0a9(MPSTreeNode checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getParent();
    }
    return null;
  }

  private static Color check_2ryzlz_a0b0a0a2a01(FileStatus checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getColor();
    }
    return null;
  }

  private class PrimaryMessage extends TreeMessage {
    private TreeMessage myDescendantSecondaryMessage;

    public PrimaryMessage(@Nullable Color color) {
      super(color, null, OldProjectTreeChangesHighlighter.this);
      myDescendantSecondaryMessage = new TreeMessage(color, null, OldProjectTreeChangesHighlighter.this) {
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
        PropertiesTreeNode propertiesTreeNode = OldMPSTreeUtil.findPropertiesTreeNode(sNodeTreeNode);
        if (propertiesTreeNode != null) {
          propertiesTreeNode.removeTreeMessage(myDefaultTreeMessage);
        }
      }
    }

    public void counterNonZero(@NotNull SNode key) {
      for (SNodeTreeNode sNodeTreeNode : ListSequence.fromList(MapSequence.fromMap(mySNodesToTreeNodes).get(key))) {
        PropertiesTreeNode propertiesTreeNode = OldMPSTreeUtil.findPropertiesTreeNode(sNodeTreeNode);
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
        ReferencesTreeNode referencesTreeNode = OldMPSTreeUtil.findReferencesTreeNode(sNodeTreeNode);
        if (referencesTreeNode != null) {
          referencesTreeNode.removeTreeMessage(myDefaultTreeMessage);
        }
      }
    }

    public void counterNonZero(@NotNull SNode key) {
      for (SNodeTreeNode sNodeTreeNode : ListSequence.fromList(MapSequence.fromMap(mySNodesToTreeNodes).get(key))) {
        ReferencesTreeNode referencesTreeNode = OldMPSTreeUtil.findReferencesTreeNode(sNodeTreeNode);
        if (referencesTreeNode != null) {
          referencesTreeNode.addTreeMessage(myDefaultTreeMessage);
        }
      }
    }
  }

  private class MyChangeListener implements OldChangeListener {
    public MyChangeListener() {
    }

    public void changeAdded(@NotNull OldChange change, @NotNull SModel model) {
      highlightChange(change, model);
    }

    public void changeRemoved(@NotNull OldChange change, @NotNull SModel model) {
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

    public void beforeTreeDisposed(MPSTree tree) {
    }
  }
}
