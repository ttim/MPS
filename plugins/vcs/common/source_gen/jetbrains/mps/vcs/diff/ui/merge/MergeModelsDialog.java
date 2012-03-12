package jetbrains.mps.vcs.diff.ui.merge;

/*Generated by MPS */

import com.intellij.openapi.ui.DialogWrapper;
import javax.swing.Icon;
import com.intellij.openapi.util.IconLoader;
import com.intellij.openapi.project.Project;
import jetbrains.mps.vcs.diff.merge.MergeSession;
import jetbrains.mps.vcs.diff.merge.MergeSessionState;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.util.Set;
import jetbrains.mps.vcs.diff.changes.ModelChange;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import java.util.HashSet;
import com.intellij.openapi.actionSystem.ActionToolbar;
import jetbrains.mps.smodel.SModel;
import com.intellij.openapi.diff.DiffRequest;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.ide.project.ProjectHelper;
import jetbrains.mps.vcs.diff.ui.common.DiffTemporaryModule;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import jetbrains.mps.workbench.action.ActionUtils;
import com.intellij.openapi.actionSystem.Separator;
import jetbrains.mps.vcs.diff.ui.common.InvokeTextDiffAction;
import com.intellij.openapi.diff.impl.mergeTool.MergeTool;
import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.ActionPlaces;
import com.intellij.ui.ScrollPaneFactory;
import java.awt.Dimension;
import com.intellij.openapi.util.DimensionService;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import javax.swing.Action;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.smodel.SNodeId;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.internal.collections.runtime.Sequence;
import com.intellij.openapi.ui.Messages;
import javax.swing.SwingUtilities;
import jetbrains.mps.vcs.diff.changes.MetadataChange;
import jetbrains.mps.vcs.diff.ui.common.DiffModelTree;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.internal.collections.runtime.ITranslator2;
import javax.swing.JComponent;
import jetbrains.mps.util.NameUtil;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import jetbrains.mps.workbench.action.BaseAction;
import java.util.Arrays;
import jetbrains.mps.vcs.diff.changes.ChangeType;
import com.intellij.ui.SimpleTextAttributes;
import jetbrains.mps.vcs.diff.changes.AddRootChange;
import jetbrains.mps.vcs.diff.changes.DeleteRootChange;
import jetbrains.mps.vcs.diff.ui.common.ChangeColors;

public class MergeModelsDialog extends DialogWrapper {
  public static final Icon APPLY_NON_CONFLICTS = IconLoader.getIcon("/diff/applyNotConflicts.png");
  public static final Icon RESET = IconLoader.getIcon("/actions/reset.png");

  private Project myProject;
  private MergeSession myMergeSession;
  private MergeSessionState myInitialState;
  private MergeModelsDialog.MergeModelsTree myMergeTree;
  private JPanel myPanel = new JPanel(new BorderLayout());
  private boolean myApplyChanges = false;
  private boolean myRootsDialogInvoked = false;
  private String[] myContentTitles;
  private Set<ModelChange> myAppliedMetadataChanges = SetSequence.fromSet(new HashSet<ModelChange>());
  private ActionToolbar myToolbar;

  public MergeModelsDialog(SModel baseModel, SModel mineModel, SModel repositoryModel, DiffRequest request) {
    super(request.getProject(), true);
    setTitle("Merging " + SModelOperations.getModelName(baseModel));
    myProject = request.getProject();
    myContentTitles = request.getContentTitles();
    assert myContentTitles.length == 3;
    myMergeSession = new MergeSession(baseModel, mineModel, repositoryModel);
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        myInitialState = myMergeSession.getCurrentState();
      }
    });
    jetbrains.mps.project.Project p = ProjectHelper.toMPSProject(myProject);
    DiffTemporaryModule.createModuleForModel(myMergeSession.getResultModel(), "result", p, true);
    myMergeSession.installResultModelListener();
    DiffTemporaryModule.createModuleForModel(mineModel, "mine", p);
    DiffTemporaryModule.createModuleForModel(repositoryModel, "repository", p);

    myMergeTree = new MergeModelsDialog.MergeModelsTree();

    DefaultActionGroup actionGroup = ActionUtils.groupFromActions(new ResetState(this), new MergeNonConflictingRoots(this), Separator.getInstance(), AcceptYoursTheirs.yoursInstance(this), AcceptYoursTheirs.theirsInstance(this), Separator.getInstance(), new InvokeTextDiffAction("Merge as Text (Use Carefully!)", "Merge models using text merge for XML contents", this, request, new MergeTool()));
    myToolbar = ActionManager.getInstance().createActionToolbar(ActionPlaces.UNKNOWN, actionGroup, true);
    myToolbar.updateActionsImmediately();
    myPanel.add(myToolbar.getComponent(), BorderLayout.NORTH);
    myPanel.add(ScrollPaneFactory.createScrollPane(myMergeTree), BorderLayout.CENTER);
    final Dimension size = DimensionService.getInstance().getSize(getDimensionServiceKey());
    if (size == null) {
      DimensionService.getInstance().setSize(getDimensionServiceKey(), new Dimension(500, 450));
      setSize(400, 500);
    } else {
      setSize(((int) size.getWidth()), ((int) size.getHeight()));
    }
    init();
  }

  public String getDimensionServiceKey() {
    return "#jetbrains.mps.vcs.diff.ui.merge.MergeModelsdialog";
  }

  protected void doOKAction() {
    MergeConfirmation.showMergeConfirmationAndTakeAction(this, myMergeSession, myMergeSession.getAllChanges(), new _FunctionTypes._void_P0_E0() {
      public void invoke() {
        myMergeSession.applyChanges(myMergeSession.getApplicableChangesInNonConflictingRoots());
      }
    }, new _FunctionTypes._void_P0_E0() {
      public void invoke() {
        myApplyChanges = true;
        close(OK_EXIT_CODE);
      }
    });
  }

  protected Action[] createActions() {
    List<Action> actions = ListSequence.fromList(new ArrayList<Action>());
    ListSequence.fromList(actions).addElement(getOKAction());
    ListSequence.fromList(actions).addElement(getCancelAction());
    return ListSequence.fromList(actions).toGenericArray(Action.class);
  }

  public SModel getResultModel() {
    return (myApplyChanges ?
      myMergeSession.getResultModel() :
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
    List<ModelChange> allChanges = myMergeSession.getMetadataChanges();
    assert ListSequence.fromList(allChanges).isNotEmpty();
    boolean allResolved = false;
    boolean conflictsOnly = false;
    final Wrappers._T<Iterable<ModelChange>> interestingChanges = new Wrappers._T<Iterable<ModelChange>>();

    Iterable<ModelChange> unresolvedChanges = ListSequence.fromList(allChanges).where(new IWhereFilter<ModelChange>() {
      public boolean accept(ModelChange ch) {
        return !(myMergeSession.isChangeResolved(ch));
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
            return Sequence.fromIterable(myMergeSession.getConflictedWith(ch)).isNotEmpty();
          }
        });

        conflictsOnly = true;
      }

    } else {
      // all changes are unresolved 

      if (ListSequence.fromList(allChanges).all(new IWhereFilter<ModelChange>() {
        public boolean accept(ModelChange ch) {
          return Sequence.fromIterable(myMergeSession.getConflictedWith(ch)).isNotEmpty();
        }
      })) {
        // all changes are conflicting 
        interestingChanges.value = allChanges;
        conflictsOnly = true;
      } else {
        // some or none are conflicting 
        interestingChanges.value = ListSequence.fromList(allChanges).where(new IWhereFilter<ModelChange>() {
          public boolean accept(ModelChange ch) {
            return Sequence.fromIterable(myMergeSession.getConflictedWith(ch)).isEmpty();
          }
        });
      }
    }
    Iterable<ModelChange> mine = Sequence.fromIterable(interestingChanges.value).where(new IWhereFilter<ModelChange>() {
      public boolean accept(ModelChange ch) {
        return myMergeSession.isMyChange(ch);
      }
    });
    Iterable<ModelChange> repository = Sequence.fromIterable(interestingChanges.value).where(new IWhereFilter<ModelChange>() {
      public boolean accept(ModelChange ch) {
        return !(myMergeSession.isMyChange(ch));
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
      Messages.showInfoMessage(this.getOwner(), "You have unresolved model property conflicts. Please resolve them manually using \"Accept Theirs\" or \"Accept Yours\":" + sb.toString(), "Model Properites Changes");
    } else if (allResolved) {
      if (sb.length() == 0) {
        Messages.showInfoMessage(this.getOwner(), "You have excluded all model property changes.", "Model Properites Changes");
      } else {
        Messages.showInfoMessage(this.getOwner(), "You have applied the following changes:" + sb.toString(), "Model Properites Changes");
      }
    } else {
      int ans = Messages.showYesNoCancelDialog(this.getOwner(), "There are pending model properties changes:" + sb.toString() + "\n\nDo you want to apply them all?", "Merge Model Properties", Messages.getQuestionIcon());
      if (ans == Messages.YES) {
        ModelAccess.instance().runWriteActionInCommand(new Runnable() {
          public void run() {
            SetSequence.fromSet(myAppliedMetadataChanges).addSequence(Sequence.fromIterable(interestingChanges.value));
            myMergeSession.applyChanges(interestingChanges.value);
            rebuildLater();
          }
        });
      } else if (ans == Messages.NO) {
        myMergeSession.excludeChanges(interestingChanges.value);
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
        mergeRootsDialog.value = new MergeRootsDialog(MergeModelsDialog.this, myMergeSession, rootId, myMergeTree.getNameForRoot(rootId));
      }
    });
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        mergeRootsDialog.value.toFront();
      }
    });
    mergeRootsDialog.value.show();
  }

  public boolean isAcceptYoursTheirsEnabled() {
    return Sequence.fromIterable(getUnresolvedChangesForSelection()).isNotEmpty();
  }

  public void acceptVersionForSelectedRoots(boolean mine) {
    final List<ModelChange> changesToApply = ListSequence.fromList(new ArrayList<ModelChange>());
    final List<ModelChange> changesToExclude = ListSequence.fromList(new ArrayList<ModelChange>());
    for (ModelChange change : Sequence.fromIterable(getUnresolvedChangesForSelection())) {
      if (mine == myMergeSession.isMyChange(change)) {
        ListSequence.fromList(changesToApply).addElement(change);
        if (change instanceof MetadataChange) {
          SetSequence.fromSet(myAppliedMetadataChanges).addElement(change);
        }
      } else {
        ListSequence.fromList(changesToExclude).addElement(change);
      }
    }
    ModelAccess.instance().runWriteActionInCommand(new Runnable() {
      public void run() {
        myMergeSession.applyChanges(changesToApply);
        myMergeSession.excludeChanges(changesToExclude);
        myMergeTree.rebuildNow();
      }
    });
  }

  private Iterable<ModelChange> getUnresolvedChangesForSelection() {
    Iterable<ModelChange> changesForRoots;
    if (myMergeTree.getSelectedNodes(DiffModelTree.ModelTreeNode.class, null).length == 1) {
      changesForRoots = myMergeSession.getAllChanges();
    } else {
      changesForRoots = Sequence.fromIterable(Sequence.fromArray(myMergeTree.getSelectedNodes(DiffModelTree.RootTreeNode.class, null))).select(new ISelector<DiffModelTree.RootTreeNode, SNodeId>() {
        public SNodeId select(DiffModelTree.RootTreeNode rtn) {
          return rtn.getRootId();
        }
      }).translate(new ITranslator2<SNodeId, ModelChange>() {
        public Iterable<ModelChange> translate(SNodeId root) {
          return (root == null ?
            myMergeSession.getMetadataChanges() :
            myMergeSession.getChangesForRoot(root)
          );
        }
      });
    }
    return Sequence.fromIterable(changesForRoots).where(new IWhereFilter<ModelChange>() {
      public boolean accept(ModelChange ch) {
        return !(myMergeSession.isChangeResolved(ch));
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

  /*package*/ MergeSession getMergeSession() {
    return myMergeSession;
  }

  /*package*/ void restoreState(MergeSessionState state) {
    myMergeSession.restoreState(state);
  }

  public void resetState() {
    restoreState(myInitialState);
    rebuildLater();
  }

  @Nullable
  protected JComponent createCenterPanel() {
    return myPanel;
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
      super(DiffTemporaryModule.getOperationContext(myProject, myMergeSession.getResultModel()));
      addTreeSelectionListener(new TreeSelectionListener() {
        public void valueChanged(TreeSelectionEvent event) {
          myToolbar.updateActionsImmediately();
        }
      });
    }

    protected Iterable<BaseAction> getRootActions() {
      MergeModelsDialog md = MergeModelsDialog.this;
      return Arrays.asList(new InvokeMergeRootsAction(md), AcceptYoursTheirs.yoursInstance(md), AcceptYoursTheirs.theirsInstance(md));
    }

    protected void updateRootCustomPresentation(@NotNull DiffModelTree.RootTreeNode rootTreeNode) {
      List<ModelChange> changes = (rootTreeNode.getRootId() == null ?
        ListSequence.fromList(myMergeSession.getMetadataChanges()).select(new ISelector<ModelChange, ModelChange>() {
          public ModelChange select(ModelChange ch) {
            return (ModelChange) ch;
          }
        }).toListSequence() :
        myMergeSession.getChangesForRoot(rootTreeNode.getRootId())
      );
      changes = ListSequence.fromList(changes).where(new IWhereFilter<ModelChange>() {
        public boolean accept(ModelChange ch) {
          return !(myMergeSession.isChangeResolved(ch));
        }
      }).toListSequence();

      int conflictedCount = ListSequence.fromList(changes).where(new IWhereFilter<ModelChange>() {
        public boolean accept(ModelChange ch) {
          return Sequence.fromIterable(myMergeSession.getConflictedWith(ch)).isNotEmpty();
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
          if (rootTreeNode.getRootId() != null && myMergeSession.getResultModel().getNodeById(rootTreeNode.getRootId()) == null) {
            rootTreeNode.setTextStyle(SimpleTextAttributes.STYLE_STRIKEOUT);
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
              return myMergeSession.isMyChange(ch);
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
      return Arrays.asList(myMergeSession.getBaseModel(), myMergeSession.getMyModel(), myMergeSession.getRepositoryModel());
    }

    protected Iterable<SNodeId> getAffectedRoots() {
      return myMergeSession.getAffectedRoots();
    }

    @Override
    protected boolean isMultipleRootNames() {
      return true;
    }
  }
}
