package jetbrains.mps.vcs.diff.ui;

/*Generated by MPS */

import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.project.Project;
import jetbrains.mps.vcs.diff.ChangeSet;
import java.util.Map;
import jetbrains.mps.smodel.SNodeId;
import java.util.List;
import jetbrains.mps.vcs.diff.changes.ModelChange;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.HashMap;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import jetbrains.mps.smodel.SModel;
import com.intellij.openapi.diff.DiffRequest;
import jetbrains.mps.ide.project.ProjectHelper;
import jetbrains.mps.vcs.diff.ui.common.DiffTemporaryModule;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.vcs.diff.ChangeSetBuilder;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import jetbrains.mps.workbench.action.ActionUtils;
import jetbrains.mps.vcs.diff.ui.common.InvokeTextDiffAction;
import com.intellij.openapi.diff.DiffManager;
import com.intellij.openapi.actionSystem.ActionToolbar;
import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.ActionPlaces;
import com.intellij.ui.ScrollPaneFactory;
import java.awt.Dimension;
import com.intellij.openapi.util.DimensionService;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.vcs.diff.ui.common.SimpleDiffRequest;
import org.jetbrains.annotations.Nullable;
import javax.swing.JComponent;
import javax.swing.Action;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.vcs.diff.changes.NodeCopier;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.vcs.diff.changes.NodeGroupChange;
import jetbrains.mps.internal.collections.runtime.IVisitor;
import jetbrains.mps.vcs.diff.ui.common.Bounds;
import com.intellij.openapi.ui.Messages;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import com.intellij.openapi.wm.WindowManager;
import javax.swing.SwingUtilities;
import jetbrains.mps.vcs.diff.ui.common.DiffModelTree;
import jetbrains.mps.workbench.action.BaseAction;
import java.util.Arrays;
import jetbrains.mps.vcs.diff.changes.ChangeType;
import jetbrains.mps.vcs.diff.changes.AddRootChange;
import jetbrains.mps.vcs.diff.changes.DeleteRootChange;
import jetbrains.mps.vcs.diff.ui.common.ChangeColors;
import jetbrains.mps.internal.collections.runtime.SetSequence;

public class ModelDifferenceDialog extends DialogWrapper {
  private Project myProject;
  private ChangeSet myChangeSet;
  private Map<SNodeId, List<ModelChange>> myRootToChanges = MapSequence.fromMap(new HashMap<SNodeId, List<ModelChange>>());
  private List<ModelChange> myMetadataChanges = ListSequence.fromList(new ArrayList<ModelChange>());
  private ModelDifferenceDialog.ModelDifferenceTree myTree;
  private JPanel myPanel = new JPanel(new BorderLayout());
  private boolean myRootsDialogInvoked = false;
  private boolean myGoingToNeighbour = false;
  private String[] myContentTitles;

  public ModelDifferenceDialog(final SModel oldModel, final SModel newModel, DiffRequest diffRequest) {
    super(diffRequest.getProject());
    myProject = diffRequest.getProject();
    jetbrains.mps.project.Project p = ProjectHelper.toMPSProject(myProject);
    DiffTemporaryModule.createModuleForModel(oldModel, "old", p);
    DiffTemporaryModule.createModuleForModel(newModel, "new", p);
    myContentTitles = diffRequest.getContentTitles();
    assert myContentTitles.length == 2;
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        myChangeSet = ChangeSetBuilder.buildChangeSet(oldModel, newModel, true);
        fillRootToChange();
      }
    });
    myTree = new ModelDifferenceDialog.ModelDifferenceTree();

    DefaultActionGroup actionGroup = ActionUtils.groupFromActions(new InvokeTextDiffAction("View as Text", "View model difference using as text difference of XML contents", this, diffRequest, DiffManager.getInstance().getIdeaDiffTool()));
    ActionToolbar toolbar = ActionManager.getInstance().createActionToolbar(ActionPlaces.UNKNOWN, actionGroup, true);
    toolbar.updateActionsImmediately();
    myPanel.add(toolbar.getComponent(), BorderLayout.NORTH);
    myPanel.add(ScrollPaneFactory.createScrollPane(myTree), BorderLayout.CENTER);
    Dimension size = DimensionService.getInstance().getSize(getDimensionServiceKey());
    if (size == null) {
      myPanel.setPreferredSize(new Dimension(500, 700));
    }
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        setTitle("Difference for model: " + SModelOperations.getModelName(oldModel));
      }
    });
    init();
  }

  public ModelDifferenceDialog(SModel oldModel, SModel newModel, Project project, String oldTitle, String newTitle) {
    this(oldModel, newModel, new SimpleDiffRequest(project, new SModel[]{oldModel, newModel}, new String[]{oldTitle, newTitle}));
  }

  @Nullable
  protected JComponent createCenterPanel() {
    return myPanel;
  }

  protected Action[] createActions() {
    return new Action[0];
  }

  public String getDimensionServiceKey() {
    return getClass().getName();
  }

  private void fillRootToChange() {
    MapSequence.fromMap(myRootToChanges).clear();
    ListSequence.fromList(myMetadataChanges).clear();
    for (ModelChange c : ListSequence.fromList(myChangeSet.getModelChanges())) {
      SNodeId id = c.getRootId();
      if (id == null) {
        ListSequence.fromList(myMetadataChanges).addElement(c);
      } else {
        if (!(MapSequence.fromMap(myRootToChanges).containsKey(id))) {
          MapSequence.fromMap(myRootToChanges).put(id, ListSequence.fromList(new ArrayList<ModelChange>()));
        }
        ListSequence.fromList(MapSequence.fromMap(myRootToChanges).get(id)).addElement(c);
      }
    }
  }

  /*package*/ void rebuildChangeSet() {
    ChangeSetBuilder.rebuildChangeSet(myChangeSet);
    fillRootToChange();
    myTree.rebuildLater();
  }

  public ChangeSet getChangeSet() {
    return myChangeSet;
  }

  public String[] getContentTitles() {
    return myContentTitles;
  }

  /*package*/ Project getProject() {
    return myProject;
  }

  @Nullable
  public SNodeId getNeighbourRoot(@NotNull SNodeId rootId, boolean next) {
    return myTree.getNeighbourRoot(rootId, next);
  }

  /*package*/ void startGoingToNeighbour() {
    myGoingToNeighbour = true;
  }

  /*package*/ void rollbackChanges(final Iterable<ModelChange> changes, @Nullable final _FunctionTypes._void_P0_E0 after) {
    ModelAccess.instance().runWriteActionInCommand(new Runnable() {
      public void run() {
        assert Sequence.fromIterable(changes).isNotEmpty();
        final SModel model = Sequence.fromIterable(changes).first().getChangeSet().getNewModel();
        final NodeCopier nc = new NodeCopier(model);
        Iterable<ModelChange> oppositeChanges = Sequence.fromIterable(changes).select(new ISelector<ModelChange, ModelChange>() {
          public ModelChange select(ModelChange ch) {
            return ch.getOppositeChange();
          }
        });
        for (ModelChange ch : Sequence.fromIterable(oppositeChanges)) {
          if (ch instanceof NodeGroupChange) {
            ((NodeGroupChange) ch).prepare();
          }
        }
        Sequence.fromIterable(oppositeChanges).visitAll(new IVisitor<ModelChange>() {
          public void visit(ModelChange ch) {
            ch.apply(model, nc);
          }
        });
        nc.restoreIds(true);
        if (after != null) {
          after.invoke();
        }
      }
    });
  }

  public void invokeRootDifference(SNodeId rootId) {
    invokeRootDifference(rootId, null);
  }

  public void invokeRootDifference(final SNodeId rootId, @Nullable final Bounds scrollTo) {
    if (rootId == null) {
      StringBuilder sb = new StringBuilder();
      for (ModelChange mc : ListSequence.fromList(myMetadataChanges)) {
        if (mc != ListSequence.fromList(myMetadataChanges).first()) {
          sb.append("\n");
        }
        sb.append(mc);
      }
      Messages.showInfoMessage(myPanel, sb.toString(), "Model Properties Difference");
      return;
    }
    if (myRootsDialogInvoked) {
      return;
    }
    myGoingToNeighbour = false;
    myRootsDialogInvoked = true;
    final Wrappers._T<RootDifferenceDialog> rootDialog = new Wrappers._T<RootDifferenceDialog>();
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        if (isVisible()) {
          rootDialog.value = new RootDifferenceDialog(ModelDifferenceDialog.this, rootId, myTree.getNameForRoot(rootId), scrollTo);
        } else {
          rootDialog.value = new RootDifferenceDialog(ModelDifferenceDialog.this, rootId, myTree.getNameForRoot(rootId), WindowManager.getInstance().getFrame(myProject), scrollTo);
        }
      }
    });
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        rootDialog.value.toFront();
      }
    });
    rootDialog.value.show();
  }

  /*package*/ void rootDialogClosed() {
    myRootsDialogInvoked = false;
    if (!(myGoingToNeighbour) && !(isVisible())) {
      close(DialogWrapper.NEXT_USER_EXIT_CODE);
    }
  }

  public List<ModelChange> getChangesForRoot(SNodeId rootId) {
    return MapSequence.fromMap(myRootToChanges).get(rootId);
  }

  public List<ModelChange> getMetadataChanges() {
    return myMetadataChanges;
  }

  private class ModelDifferenceTree extends DiffModelTree {
    private ModelDifferenceTree() {
      super(DiffTemporaryModule.getOperationContext(myProject, myChangeSet.getNewModel()));
    }

    protected Iterable<BaseAction> getRootActions() {
      return Arrays.<BaseAction>asList(new InvokeRootDifferenceAction(ModelDifferenceDialog.this), new RevertRootsAction(ModelDifferenceDialog.this) {
        protected SNodeId[] getRoots() {
          return Sequence.fromIterable(Sequence.fromArray(getSelectedNodes(DiffModelTree.RootTreeNode.class, null))).select(new ISelector<DiffModelTree.RootTreeNode, SNodeId>() {
            public SNodeId select(DiffModelTree.RootTreeNode rtn) {
              return rtn.getRootId();
            }
          }).toGenericArray(SNodeId.class);
        }

        protected void after() {
          ModelDifferenceDialog.this.rebuildChangeSet();
        }
      });
    }

    protected void updateRootCustomPresentation(@NotNull DiffModelTree.RootTreeNode rootTreeNode) {
      ChangeType compositeChangeType = ChangeType.CHANGE;
      if (rootTreeNode.getRootId() != null) {
        ModelChange firstChange = ListSequence.fromList(MapSequence.fromMap(myRootToChanges).get(rootTreeNode.getRootId())).first();
        if (firstChange instanceof AddRootChange || firstChange instanceof DeleteRootChange) {
          compositeChangeType = firstChange.getType();
        }
      }
      rootTreeNode.setColor(ChangeColors.getForTree(compositeChangeType));
    }

    protected Iterable<SModel> getModels() {
      return Arrays.asList(myChangeSet.getNewModel(), myChangeSet.getOldModel());
    }

    protected Iterable<SNodeId> getAffectedRoots() {
      return (ListSequence.fromList(myMetadataChanges).isEmpty() ?
        MapSequence.fromMap(myRootToChanges).keySet() :
        SetSequence.fromSet(MapSequence.fromMap(myRootToChanges).keySet()).concat(ListSequence.fromList(ListSequence.fromListAndArray(new ArrayList<SNodeId>(), null)))
      );
    }
  }
}
