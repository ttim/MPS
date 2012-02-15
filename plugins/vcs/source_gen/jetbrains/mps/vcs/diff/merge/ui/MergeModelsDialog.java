package jetbrains.mps.vcs.diff.merge.ui;

/*Generated by MPS */

import jetbrains.mps.ide.dialogs.BaseDialog;
import javax.swing.Icon;
import com.intellij.openapi.util.IconLoader;
import jetbrains.mps.ide.projectPane.Icons;
import com.intellij.openapi.project.Project;
import jetbrains.mps.vcs.diff.merge.MergeContext;
import jetbrains.mps.vcs.diff.merge.MergeContextState;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.util.Set;
import jetbrains.mps.vcs.diff.changes.ModelChange;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import java.util.HashSet;
import com.intellij.openapi.actionSystem.ActionToolbar;
import jetbrains.mps.smodel.SModel;
import com.intellij.openapi.diff.DiffRequest;
import com.intellij.openapi.wm.WindowManager;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.vcs.diff.ui.DiffTemporaryModule;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import jetbrains.mps.workbench.action.ActionUtils;
import com.intellij.openapi.actionSystem.Separator;
import jetbrains.mps.vcs.diff.ui.InvokeTextDiffAction;
import com.intellij.openapi.diff.impl.mergeTool.MergeTool;
import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.ActionPlaces;
import com.intellij.ui.ScrollPaneFactory;
import javax.swing.JComponent;
import jetbrains.mps.ide.dialogs.DialogDimensionsSettings;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.smodel.SNodeId;
import org.jetbrains.annotations.NotNull;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.internal.collections.runtime.Sequence;
import com.intellij.openapi.ui.Messages;
import java.util.ArrayList;
import jetbrains.mps.vcs.diff.ui.DiffModelTree;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.workbench.action.BaseAction;
import java.util.Arrays;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.vcs.diff.changes.ChangeType;
import jetbrains.mps.vcs.diff.changes.AddRootChange;
import jetbrains.mps.vcs.diff.changes.DeleteRootChange;
import jetbrains.mps.vcs.diff.ui.ChangeColors;

public class MergeModelsDialog extends BaseDialog {
  public static final Icon APPLY_NON_CONFLICTS = IconLoader.getIcon("/diff/applyNotConflicts.png", Icons.class);
  public static final Icon RESET = IconLoader.getIcon("/actions/reset.png", Icons.class);

  private Project myProject;
  private MergeContext myMergeContext;
  private MergeContextState myInitialState;
  private MergeModelsDialog.MergeModelsTree myMergeTree;
  private JPanel myPanel = new JPanel(new BorderLayout());
  private boolean myApplyChanges = false;
  private boolean myRootsDialogInvoked = false;
  private String[] myContentTitles;
  private Set<ModelChange> myAppliedMetadataChanges = SetSequence.fromSet(new HashSet<ModelChange>());
  private ActionToolbar myToolbar;

  public MergeModelsDialog(SModel baseModel, SModel mineModel, SModel repositoryModel, DiffRequest request) {
    super(WindowManager.getInstance().getFrame(request.getProject()), "Merging " + SModelOperations.getModelName(baseModel));
    myProject = request.getProject();
    myContentTitles = request.getContentTitles();
    assert myContentTitles.length == 3;
    myMergeContext = new MergeContext(baseModel, mineModel, repositoryModel);
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        myInitialState = myMergeContext.getCurrentState();
      }
    });
    DiffTemporaryModule.createModuleForModel(myMergeContext.getResultModel(), "result", myProject, true);
    myMergeContext.installResultModelListener();
    DiffTemporaryModule.createModuleForModel(mineModel, "mine", myProject);
    DiffTemporaryModule.createModuleForModel(repositoryModel, "repository", myProject);

    myMergeTree = new MergeModelsDialog.MergeModelsTree();

    DefaultActionGroup actionGroup = ActionUtils.groupFromActions(new ResetState(this), new MergeNonConflictingRoots(this), Separator.getInstance(), AcceptYoursTheirs.yoursInstance(this), AcceptYoursTheirs.theirsInstance(this), Separator.getInstance(), new InvokeTextDiffAction("Merge as Text (Use Carefully!)", "Merge models using text merge for XML contents", this, request, new MergeTool()));
    myToolbar = ActionManager.getInstance().createActionToolbar(ActionPlaces.UNKNOWN, actionGroup, true);
    myToolbar.updateActionsImmediately();
    myPanel.add(myToolbar.getComponent(), BorderLayout.NORTH);
    myPanel.add(ScrollPaneFactory.createScrollPane(myMergeTree), BorderLayout.CENTER);
  }

  protected JComponent getMainComponent() {
    return myPanel;
  }

  @Override
  public DialogDimensionsSettings.DialogDimensions getDefaultDimensionSettings() {
    return DialogDimensionsSettings.generateDialogDimensions(500, 700);
  }

  @BaseDialog.Button(position = 0, name = "OK", mnemonic = 'O', defaultButton = true)
  public void ok() {
    MergeConfirmation.showMergeConfirmationAndTakeAction(this, myMergeContext, myMergeContext.getAllChanges(), new _FunctionTypes._void_P0_E0() {
      public void invoke() {
        myMergeContext.applyChanges(myMergeContext.getApplicableChangesInNonConflictingRoots());
      }
    }, new _FunctionTypes._void_P0_E0() {
      public void invoke() {
        myApplyChanges = true;
        dispose();
      }
    });
  }

  @BaseDialog.Button(position = 1, name = "Cancel", mnemonic = 'C')
  public void cancel() {
    dispose();
  }

  public SModel getResultModel() {
    return (myApplyChanges ?
      myMergeContext.getResultModel() :
      null
    );
  }

  /*package*/ void rebuildLater() {
    myToolbar.updateActionsImmediately();
    myMergeTree.rebuildLater();
  }

  /*package*/ Project getProject() {
    return myProject;
  }

  @Nullable
  public SNodeId getNeighbourRoot(@NotNull SNodeId rootId, boolean next) {
    return myMergeTree.getNeighbourRoot(rootId, next);
  }

  private void invokeMergeMetadata() {
    List<ModelChange> allChanges = myMergeContext.getMetadataChanges();
    assert ListSequence.fromList(allChanges).isNotEmpty();
    boolean allResolved = false;
    boolean conflictsOnly = false;
    final Wrappers._T<Iterable<ModelChange>> interestingChanges = new Wrappers._T<Iterable<ModelChange>>();

    Iterable<ModelChange> unresolvedChanges = ListSequence.fromList(allChanges).where(new IWhereFilter<ModelChange>() {
      public boolean accept(ModelChange ch) {
        return !(myMergeContext.isChangeResolved(ch));
      }
    });
    if (Sequence.fromIterable(unresolvedChanges).count() != ListSequence.fromList(allChanges).count()) {
      // some or all changes are resolved 

      if (Sequence.fromIterable(unresolvedChanges).isEmpty()) {
        // all are resolved 
        interestingChanges.value = myAppliedMetadataChanges;
        allResolved = true;
      } else {
        // some are resolved, assert that only conflicting left 
        interestingChanges.value = unresolvedChanges;
        assert Sequence.fromIterable(interestingChanges.value).all(new IWhereFilter<ModelChange>() {
          public boolean accept(ModelChange ch) {
            return Sequence.fromIterable(myMergeContext.getConflictedWith(ch)).isNotEmpty();
          }
        });

        conflictsOnly = true;
      }
    } else {
      // all changes are unresolved 

      if (ListSequence.fromList(allChanges).all(new IWhereFilter<ModelChange>() {
        public boolean accept(ModelChange ch) {
          return Sequence.fromIterable(myMergeContext.getConflictedWith(ch)).isNotEmpty();
        }
      })) {
        // all changes are conflicting 
        interestingChanges.value = allChanges;
        conflictsOnly = true;
      } else {
        // some or none are conflicting 
        interestingChanges.value = ListSequence.fromList(allChanges).where(new IWhereFilter<ModelChange>() {
          public boolean accept(ModelChange ch) {
            return Sequence.fromIterable(myMergeContext.getConflictedWith(ch)).isEmpty();
          }
        });
      }
    }
    Iterable<ModelChange> mine = Sequence.fromIterable(interestingChanges.value).where(new IWhereFilter<ModelChange>() {
      public boolean accept(ModelChange ch) {
        return myMergeContext.isMyChange(ch);
      }
    });
    Iterable<ModelChange> repository = Sequence.fromIterable(interestingChanges.value).where(new IWhereFilter<ModelChange>() {
      public boolean accept(ModelChange ch) {
        return !(myMergeContext.isMyChange(ch));
      }
    });

    StringBuilder sb = new StringBuilder();
    if (Sequence.fromIterable(mine).isNotEmpty()) {
      sb.append("\n\n    ").append(myContentTitles[0]);
      for (ModelChange ch : Sequence.fromIterable(mine)) {
        sb.append("\n").append(ch.toString());
      }
    }
    if (Sequence.fromIterable(repository).isNotEmpty()) {
      sb.append("\n\n    ").append(myContentTitles[2]);
      for (ModelChange ch : Sequence.fromIterable(repository)) {
        sb.append("\n").append(ch.toString());
      }
    }

    if (conflictsOnly) {
      Messages.showInfoMessage(this, "You have unresolved model property conflicts. Please resolve them manually using \"Accept Theirs\" or \"Accept Yours\":" + sb.toString(), "Model Properites Changes");
    } else if (allResolved) {
      if (sb.length() == 0) {
        Messages.showInfoMessage(this, "You have excluded all model property changes.", "Model Properites Changes");
      } else {
        Messages.showInfoMessage(this, "You have applied the following changes:" + sb.toString(), "Model Properites Changes");
      }
    } else {
      int ans = Messages.showYesNoCancelDialog(this, "There are pending model properties changes:" + sb.toString() + "\n\nDo you want to apply them all?", "Merge Model Properties", Messages.getQuestionIcon());
      if (ans == Messages.YES) {
        ModelAccess.instance().runWriteActionInCommand(new Runnable() {
          public void run() {
            SetSequence.fromSet(myAppliedMetadataChanges).addSequence(Sequence.fromIterable(interestingChanges.value));
            myMergeContext.applyChanges(interestingChanges.value);
            rebuildLater();
          }
        });
      } else if (ans == Messages.NO) {
        myMergeContext.excludeChanges(interestingChanges.value);
        rebuildLater();
      }
    }
  }

  public void invokeMergeRoots(final SNodeId rootId) {
    if (rootId == null) {
      invokeMergeMetadata();
      return;
    }
    if (myRootsDialogInvoked) {
      return;
    }
    myRootsDialogInvoked = true;
    final Wrappers._T<MergeRootsDialog> mergeRootsDialog = new Wrappers._T<MergeRootsDialog>();
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        mergeRootsDialog.value = new MergeRootsDialog(MergeModelsDialog.this, myMergeContext, rootId, myMergeTree.getNameForRoot(rootId));
      }
    });
    mergeRootsDialog.value.showDialog();
    mergeRootsDialog.value.toFront();
  }

  public void acceptVersionForSelectedRoots(boolean mine) {
    final List<ModelChange> changesToApply = ListSequence.fromList(new ArrayList<ModelChange>());
    final List<ModelChange> changesToExclude = ListSequence.fromList(new ArrayList<ModelChange>());
    for (DiffModelTree.RootTreeNode rtn : Sequence.fromIterable(Sequence.fromArray(myMergeTree.getSelectedNodes(DiffModelTree.RootTreeNode.class, null)))) {
      SNodeId root = rtn.getRootId();
      List<ModelChange> changes = (root == null ?
        myMergeContext.getMetadataChanges() :
        myMergeContext.getChangesForRoot(root)
      );
      for (ModelChange change : ListSequence.fromList(changes)) {
        if (!(myMergeContext.isChangeResolved(change))) {
          if (mine == myMergeContext.isMyChange(change)) {
            ListSequence.fromList(changesToApply).addElement(change);
            if (root == null) {
              SetSequence.fromSet(myAppliedMetadataChanges).addElement(change);
            }
          } else {
            ListSequence.fromList(changesToExclude).addElement(change);
          }
        }
      }
    }
    ModelAccess.instance().runWriteActionInCommand(new Runnable() {
      public void run() {
        myMergeContext.applyChanges(changesToApply);
        myMergeContext.excludeChanges(changesToExclude);
        myMergeTree.rebuildNow();
      }
    });
  }

  /*package*/ void markMetadataChangesAsApplied(Iterable<ModelChange> changes) {
    SetSequence.fromSet(myAppliedMetadataChanges).addSequence(Sequence.fromIterable(changes));
  }

  /*package*/ void rootsDialogClosed() {
    myRootsDialogInvoked = false;
  }

  /*package*/ String[] getContentTitles() {
    return myContentTitles;
  }

  /*package*/ MergeContext getMergeContext() {
    return myMergeContext;
  }

  /*package*/ void restoreState(MergeContextState state) {
    myMergeContext.restoreState(state);
  }

  public void resetState() {
    restoreState(myInitialState);
    rebuildLater();
  }

  /*package*/ static String generateUnresolvedChangesText(int totalChanges, int conflictingChanges) {
    if (conflictingChanges != 0) {
      String text = NameUtil.formatNumericalString(conflictingChanges, "conficting change");
      if (totalChanges == conflictingChanges) {
        return text;
      } else {
        return text + " of " + totalChanges + " total";
      }
    } else {
      if (totalChanges == 0) {
        return "All changes resolved";
      } else {
        return NameUtil.formatNumericalString(totalChanges, " change");
      }
    }
  }

  private class MergeModelsTree extends DiffModelTree {
    private MergeModelsTree() {
      super(DiffTemporaryModule.getOperationContext(myProject, myMergeContext.getResultModel()));
    }

    protected Iterable<BaseAction> getRootActions() {
      MergeModelsDialog md = MergeModelsDialog.this;
      return Arrays.asList(new InvokeMergeRootsAction(md), AcceptYoursTheirs.yoursInstance(md), AcceptYoursTheirs.theirsInstance(md));
    }

    protected void updateRootCustomPresentation(@NotNull DiffModelTree.RootTreeNode rootTreeNode) {
      List<ModelChange> changes = (rootTreeNode.getRootId() == null ?
        ListSequence.fromList(myMergeContext.getMetadataChanges()).select(new ISelector<ModelChange, ModelChange>() {
          public ModelChange select(ModelChange ch) {
            return (ModelChange) ch;
          }
        }).toListSequence() :
        myMergeContext.getChangesForRoot(rootTreeNode.getRootId())
      );
      changes = ListSequence.fromList(changes).where(new IWhereFilter<ModelChange>() {
        public boolean accept(ModelChange ch) {
          return !(myMergeContext.isChangeResolved(ch));
        }
      }).toListSequence();

      int conflictedCount = ListSequence.fromList(changes).where(new IWhereFilter<ModelChange>() {
        public boolean accept(ModelChange ch) {
          return Sequence.fromIterable(myMergeContext.getConflictedWith(ch)).isNotEmpty();
        }
      }).count();
      int nonConflictedCount = ListSequence.fromList(changes).count() - conflictedCount;
      ChangeType compositeChangeType = null;
      rootTreeNode.setTooltipText(generateUnresolvedChangesText(ListSequence.fromList(changes).count(), conflictedCount));
      if (conflictedCount != 0) {
        compositeChangeType = ChangeType.CONFLICTED;
        rootTreeNode.setAdditionalText("with conflicts");
      } else {
        if (nonConflictedCount == 0) {
          if (rootTreeNode.getRootId() != null && myMergeContext.getResultModel().getNodeById(rootTreeNode.getRootId()) == null) {
            rootTreeNode.setText(String.format("<html><s>%s</s></html>", rootTreeNode.getText()));
          }
        } else {
          compositeChangeType = ChangeType.CHANGE;
          if (ListSequence.fromList(changes).all(new IWhereFilter<ModelChange>() {
            public boolean accept(ModelChange ch) {
              return ch instanceof AddRootChange || ch instanceof DeleteRootChange;
            }
          })) {
            compositeChangeType = ListSequence.fromList(changes).first().getType();
          }

          int myChangesCount = ListSequence.fromList(changes).where(new IWhereFilter<ModelChange>() {
            public boolean accept(ModelChange ch) {
              return myMergeContext.isMyChange(ch);
            }
          }).count();
          if (myChangesCount == nonConflictedCount) {
            rootTreeNode.setAdditionalText("local");
          } else if (myChangesCount == 0) {
            rootTreeNode.setAdditionalText("remote");
          } else {
            rootTreeNode.setAdditionalText("both modified");
          }
        }
      }

      if (compositeChangeType != null) {
        rootTreeNode.setColor(ChangeColors.getForTree(compositeChangeType));
      }
    }

    protected Iterable<SModel> getModels() {
      return Arrays.asList(myMergeContext.getBaseModel(), myMergeContext.getMyModel(), myMergeContext.getRepositoryModel());
    }

    protected Iterable<SNodeId> getAffectedRoots() {
      return myMergeContext.getAffectedRoots();
    }

    @Override
    protected boolean isMultipleRootNames() {
      return true;
    }
  }
}
