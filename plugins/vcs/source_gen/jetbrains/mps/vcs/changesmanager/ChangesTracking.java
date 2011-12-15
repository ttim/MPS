package jetbrains.mps.vcs.changesmanager;

/*Generated by MPS */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.intellij.openapi.project.Project;
import jetbrains.mps.smodel.descriptor.EditableSModelDescriptor;
import com.intellij.util.containers.BidirectionalMultiMap;
import jetbrains.mps.smodel.SNodeId;
import jetbrains.mps.vcs.diff.changes.ModelChange;
import com.intellij.util.containers.BidirectionalMap;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.vcs.diff.changes.AddRootChange;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.vcs.diff.changes.NodeGroupChange;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.vfs.IFile;
import com.intellij.openapi.vfs.VirtualFile;
import jetbrains.mps.ide.vfs.VirtualFileUtils;
import com.intellij.openapi.vcs.ProjectLevelVcsManager;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.smodel.SModel;
import com.intellij.openapi.vcs.FileStatus;
import com.intellij.openapi.vcs.FileStatusManager;
import jetbrains.mps.smodel.persistence.def.ModelPersistence;
import jetbrains.mps.smodel.persistence.def.ModelReadException;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.vcs.diff.ChangeSet;
import jetbrains.mps.vcs.diff.ChangeSetBuilder;
import jetbrains.mps.vcs.diff.ChangeSetImpl;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import java.util.Set;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.internal.collections.runtime.IVisitor;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.vcs.diff.changes.NodeChange;
import jetbrains.mps.vcs.diff.changes.DeleteRootChange;
import jetbrains.mps.smodel.SModelAdapter;
import jetbrains.mps.smodel.event.SModelPropertyEvent;
import jetbrains.mps.vcs.diff.changes.SetPropertyChange;
import jetbrains.mps.smodel.event.SModelReferenceEvent;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.vcs.diff.changes.SetReferenceChange;
import jetbrains.mps.smodel.event.SModelChildEvent;
import jetbrains.mps.smodel.event.SModelRootEvent;

public class ChangesTracking {
  protected static Log log = LogFactory.getLog(ChangesTracking.class);

  private Project myProject;
  private CurrentDifference myDifference;
  private SimpleCommandQueue myQueue;
  private EditableSModelDescriptor myModelDescriptor;
  private ChangesTracking.MyModelListener myModelListener = new ChangesTracking.MyModelListener();
  private boolean myDisposed = false;
  private BidirectionalMultiMap<SNodeId, ModelChange> myNodesToChanges = new BidirectionalMultiMap<SNodeId, ModelChange>();
  private BidirectionalMap<SNodeId, ModelChange> myAddedNodesToChanges = new BidirectionalMap<SNodeId, ModelChange>();
  private List<SNodeId> myLastNewChildrenIds;

  public ChangesTracking(@NotNull Project project, @NotNull CurrentDifference difference) {
    myDifference = difference;
    myProject = project;
    myModelDescriptor = myDifference.getModelDescriptor();
    myQueue = CurrentDifferenceRegistry.getInstance(project).getCommandQueue();
    synchronized (this) {
      myModelDescriptor.addModelListener(myModelListener);
    }
  }

  public void dispose() {
    synchronized (this) {
      if (!(myDisposed)) {
        myDisposed = true;
        myModelDescriptor.removeModelListener(myModelListener);
      }
    }
  }

  private void updateCacheForChange(@NotNull ModelChange change) {
    SNodeId id = getNodeIdForChange(change);
    if (id != null) {
      myNodesToChanges.put(id, change);
    }
    if (change instanceof AddRootChange) {
      MapSequence.fromMap(myAddedNodesToChanges).put(change.getRootId(), change);
    } else if (change instanceof NodeGroupChange) {
      for (SNodeId i : Sequence.fromIterable(getNodeIdsForNodeGroupChange((NodeGroupChange) change, myLastNewChildrenIds))) {
        MapSequence.fromMap(myAddedNodesToChanges).put(i, change);
      }
    }
  }

  private void buildCaches() {
    myNodesToChanges.clear();
    myAddedNodesToChanges.clear();
    myLastNewChildrenIds = null;
    for (ModelChange ch : ListSequence.fromList(myDifference.getChangeSet().getModelChanges())) {
      updateCacheForChange(ch);
    }
  }

  /*package*/ void scheduleFullUpdate() {
    myQueue.addTask(new Runnable() {
      public void run() {
        update(false);
      }
    });
  }

  private void update(boolean force) {
    myQueue.assertSoftlyIsCommandThread();
    if (!(myDifference.isEnabled())) {
      return;
    }
    myDifference.removeChangeSet();

    IFile modelFile = myModelDescriptor.getModelFile();
    if (modelFile == null || !(modelFile.exists())) {
      return;
    }
    VirtualFile modelVFile = VirtualFileUtils.getVirtualFile(modelFile);

    if (modelVFile == null || ProjectLevelVcsManager.getInstance(myProject).getVcsFor(modelVFile) == null) {
      return;
    }

    final Wrappers._T<SModel> baseVersionModel = new Wrappers._T<SModel>(null);
    FileStatus status = FileStatusManager.getInstance(myProject).getStatus(modelVFile);
    if (FileStatus.NOT_CHANGED == status && !(force)) {
      return;
    }
    if (BaseVersionUtil.isAddedFileStatus(status)) {
      baseVersionModel.value = new SModel(myModelDescriptor.getSModelReference());
    } else {
      String content = BaseVersionUtil.getBaseVersionContent(modelVFile, myProject);
      if (content == null && status != FileStatus.NOT_CHANGED && !(BaseVersionUtil.isAddedFileStatus(status))) {
        if (log.isErrorEnabled()) {
          log.error("Base version content is null while file status is " + status);
        }
      }
      if (content == null) {
        return;
      }
      try {
        baseVersionModel.value = ModelPersistence.readModel(content, false);
      } catch (ModelReadException e) {
        if (log.isWarnEnabled()) {
          log.warn("", e);
        }
        return;
      }
    }
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        ChangeSet changeSet = ChangeSetBuilder.buildChangeSet(baseVersionModel.value, myModelDescriptor.getSModel(), true);
        myDifference.setChangeSet((ChangeSetImpl) changeSet);
        buildCaches();
      }
    });
  }

  private void addChange(@NotNull ModelChange change) {
    updateCacheForChange(change);
    myDifference.addChange(change);
  }

  private void removeChange(@NotNull ModelChange change) {
    myNodesToChanges.removeValue(change);
    myAddedNodesToChanges.removeValue(change);
    myDifference.removeChange(change);
  }

  private <C extends ModelChange> int removeChanges(SNodeId nodeId, final Class<C> changeClass, final _FunctionTypes._return_P1_E0<? extends Boolean, ? super C> condition) {
    Set<ModelChange> changes = myNodesToChanges.getValues(nodeId);
    List<ModelChange> toRemove = SetSequence.fromSet(changes).where(new IWhereFilter<ModelChange>() {
      public boolean accept(ModelChange ch) {
        return changeClass.isInstance(ch) && condition.invoke((C) ch);
      }
    }).toListSequence();
    ListSequence.fromList(toRemove).visitAll(new IVisitor<ModelChange>() {
      public void visit(ModelChange it) {
        removeChange(it);
      }
    });
    return ListSequence.fromList(toRemove).count();
  }

  private void removeDescendantChanges(SNodeId parentId, String role) {
    SNode oldNode = getOldNode(parentId);
    assert oldNode != null;
    List<SNode> children = oldNode.getChildren(role);
    ListSequence.fromList(children).visitAll(new IVisitor<SNode>() {
      public void visit(SNode c) {
        removeDescendantChanges(c.getSNodeId());
      }
    });
  }

  private void removeDescendantChanges(SNodeId nodeId) {
    SNode oldNode = getOldNode(nodeId);
    assert oldNode != null;
    for (SNode d : ListSequence.fromList(SNodeOperations.getDescendants(oldNode, null, true, new String[]{}))) {
      removeChanges(d.getSNodeId(), ModelChange.class, new _FunctionTypes._return_P1_E0<Boolean, ModelChange>() {
        public Boolean invoke(ModelChange ch) {
          return true;
        }
      });
    }
  }

  private void buildAndAddChanges(_FunctionTypes._void_P1_E0<? super ChangeSetBuilder> buildAction) {
    ChangeSet cs = myDifference.getChangeSet();
    ChangeSetBuilder builder = ChangeSetBuilder.createBuilder(cs);
    buildAction.invoke(builder);
    ListSequence.fromList(builder.getNewChanges()).visitAll(new IVisitor<ModelChange>() {
      public void visit(ModelChange ch) {
        addChange(ch);
      }
    });
  }

  @Nullable
  private SNode getOldNode(@NotNull SNodeId id) {
    return check_5iuzi5_a0a0a11(myDifference.getChangeSet()).getNodeById(id);
  }

  private void runUpdateTask(final _FunctionTypes._void_P0_E0 task, SNode currentNode) {
    final List<SNodeId> ancestors = ListSequence.fromList(SNodeOperations.getAncestors(currentNode, null, true)).select(new ISelector<SNode, SNodeId>() {
      public SNodeId select(SNode a) {
        return a.getSNodeId();
      }
    }).toListSequence();
    if (myDifference.getChangeSet() == null) {
      myQueue.runTask(new Runnable() {
        public void run() {
          update(true);
        }
      });
    } else {
      myQueue.runTask(new Runnable() {
        public void run() {
          if (myDifference.getChangeSet() == null) {
            return;
          }
          if (ListSequence.fromList(ancestors).any(new IWhereFilter<SNodeId>() {
            public boolean accept(SNodeId a) {
              return myAddedNodesToChanges.containsKey(a);
            }
          })) {
            // ignore 
          } else {
            myDifference.getBroadcaster().changeUpdateStarted();
            ModelAccess.instance().runReadAction(new Runnable() {
              public void run() {
                task.invoke();
              }
            });
            myDifference.getBroadcaster().changeUpdateFinished();
          }
        }
      });
    }
  }

  private static Iterable<SNodeId> getNodeIdsForNodeGroupChange(@NotNull NodeGroupChange ngc, @Nullable List<SNodeId> lastNewChildrenIds) {
    if (lastNewChildrenIds == null) {
      List<SNode> children = ngc.getChangeSet().getNewModel().getNodeById(ngc.getParentNodeId()).getChildren(ngc.getRole());
      lastNewChildrenIds = ListSequence.fromList(children).select(new ISelector<SNode, SNodeId>() {
        public SNodeId select(SNode n) {
          return n.getSNodeId();
        }
      }).toListSequence();
    }
    return ListSequence.fromList(lastNewChildrenIds).page(ngc.getResultBegin(), ngc.getResultEnd());
  }

  @Nullable
  private static SNodeId getNodeIdForChange(@NotNull ModelChange change) {
    if (change instanceof NodeChange) {
      return ((NodeChange) change).getAffectedNodeId();
    } else if (change instanceof AddRootChange || change instanceof DeleteRootChange) {
      return change.getRootId();
    } else if (change instanceof NodeGroupChange) {
      return ((NodeGroupChange) change).getParentNodeId();
    }
    return null;
  }

  private static SModel check_5iuzi5_a0a0a11(ChangeSet checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getOldModel();
    }
    return null;
  }

  private class MyModelListener extends SModelAdapter {
    public MyModelListener() {
    }

    @Override
    public void propertyChanged(final SModelPropertyEvent event) {
      runUpdateTask(new _FunctionTypes._void_P0_E0() {
        public void invoke() {
          final SNodeId nodeId = event.getNode().getSNodeId();
          final String propertyName = event.getPropertyName();

          removeChanges(nodeId, SetPropertyChange.class, new _FunctionTypes._return_P1_E0<Boolean, SetPropertyChange>() {
            public Boolean invoke(SetPropertyChange ch) {
              return propertyName.equals(ch.getPropertyName());
            }
          });
          buildAndAddChanges(new _FunctionTypes._void_P1_E0<ChangeSetBuilder>() {
            public void invoke(ChangeSetBuilder b) {
              b.buildForProperty(getOldNode(nodeId), event.getNode(), propertyName);
            }
          });
        }
      }, event.getNode());
    }

    private void processReferenceEvent(final SModelReferenceEvent event) {
      runUpdateTask(new _FunctionTypes._void_P0_E0() {
        public void invoke() {
          final SReference ref = event.getReference();
          final SNodeId nodeId = ref.getSourceNode().getSNodeId();
          final String role = ref.getRole();

          removeChanges(nodeId, SetReferenceChange.class, new _FunctionTypes._return_P1_E0<Boolean, SetReferenceChange>() {
            public Boolean invoke(SetReferenceChange ch) {
              return role.equals(ch.getRole());
            }
          });
          buildAndAddChanges(new _FunctionTypes._void_P1_E0<ChangeSetBuilder>() {
            public void invoke(ChangeSetBuilder b) {
              b.buildForReference(getOldNode(nodeId), ref.getSourceNode(), role);
            }
          });
        }
      }, event.getReference().getSourceNode());
    }

    @Override
    public void referenceAdded(SModelReferenceEvent event) {
      processReferenceEvent(event);
    }

    @Override
    public void referenceRemoved(SModelReferenceEvent event) {
      processReferenceEvent(event);
    }

    private void processChildEvent(final SModelChildEvent event) {
      final List<SNode> childrenRightAfterEvent = event.getParent().getChildren(event.getChildRole());
      runUpdateTask(new _FunctionTypes._void_P0_E0() {
        public void invoke() {
          final SNodeId parentId = event.getParent().getSNodeId();
          final String role = event.getChildRole();

          removeChanges(parentId, NodeGroupChange.class, new _FunctionTypes._return_P1_E0<Boolean, NodeGroupChange>() {
            public Boolean invoke(NodeGroupChange ch) {
              return role.equals(ch.getRole());
            }
          });
          removeDescendantChanges(parentId, role);
          if (event.getModel().getNodeById(parentId) == null) {
            // node is already deleted, no need to build diff for it 
            return;
          }
          myLastNewChildrenIds = ListSequence.fromList(childrenRightAfterEvent).select(new ISelector<SNode, SNodeId>() {
            public SNodeId select(SNode n) {
              return n.getSNodeId();
            }
          }).toListSequence();
          buildAndAddChanges(new _FunctionTypes._void_P1_E0<ChangeSetBuilder>() {
            public void invoke(ChangeSetBuilder b) {
              b.buildForNodeRole(getOldNode(parentId).getChildren(role), childrenRightAfterEvent);
            }
          });
        }
      }, event.getParent());
    }

    @Override
    public void childAdded(SModelChildEvent event) {
      processChildEvent(event);
    }

    @Override
    public void childRemoved(SModelChildEvent event) {
      processChildEvent(event);
    }

    @Override
    public void rootRemoved(final SModelRootEvent event) {
      runUpdateTask(new _FunctionTypes._void_P0_E0() {
        public void invoke() {
          final SNodeId rootId = event.getRoot().getSNodeId();

          if (removeChanges(rootId, AddRootChange.class, new _FunctionTypes._return_P1_E0<Boolean, AddRootChange>() {
            public Boolean invoke(AddRootChange ch) {
              return true;
            }
          }) == 0) {
            // root was not added 
            removeDescendantChanges(rootId);
            buildAndAddChanges(new _FunctionTypes._void_P1_E0<ChangeSetBuilder>() {
              public void invoke(ChangeSetBuilder b) {
                b.buildForNode(getOldNode(rootId), null);
              }
            });
          }
        }
      }, event.getRoot());
    }

    @Override
    public void rootAdded(final SModelRootEvent event) {
      runUpdateTask(new _FunctionTypes._void_P0_E0() {
        public void invoke() {
          final SNodeId rootId = event.getRoot().getSNodeId();
          removeChanges(rootId, DeleteRootChange.class, new _FunctionTypes._return_P1_E0<Boolean, DeleteRootChange>() {
            public Boolean invoke(DeleteRootChange ch) {
              return true;
            }
          });
          buildAndAddChanges(new _FunctionTypes._void_P1_E0<ChangeSetBuilder>() {
            public void invoke(ChangeSetBuilder b) {
              b.buildForNode(getOldNode(rootId), event.getRoot());
            }
          });
        }
      }, event.getRoot());
    }
  }
}
