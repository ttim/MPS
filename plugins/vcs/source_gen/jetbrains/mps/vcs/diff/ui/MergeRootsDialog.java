package jetbrains.mps.vcs.diff.ui;

/*Generated by MPS */

import jetbrains.mps.ide.dialogs.BaseDialog;
import jetbrains.mps.nodeEditor.EditorMessageOwner;
import jetbrains.mps.vcs.diff.MergeContext;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.SNodeId;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.vcs.diff.MergeContextState;
import javax.swing.JSplitPane;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import jetbrains.mps.workbench.action.ActionUtils;
import com.intellij.openapi.actionSystem.Separator;
import com.intellij.openapi.actionSystem.ActionToolbar;
import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.ActionPlaces;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.internal.collections.runtime.IVisitor;
import jetbrains.mps.vcs.diff.changes.ModelChange;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.internal.collections.runtime.Sequence;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.Dimension;
import javax.swing.JComponent;
import jetbrains.mps.ide.dialogs.DialogDimensionsSettings;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;

public class MergeRootsDialog extends BaseDialog implements EditorMessageOwner {
  private MergeContext myMergeContext;
  private MergeModelsDialog myModelsDialog;
  private IOperationContext myOperationContext;
  private SNodeId myRootId;
  private JPanel myContainer = new JPanel(new BorderLayout());
  private JPanel myTopPanel = new JPanel(new GridBagLayout());
  private JPanel myBottomPanel = new JPanel(new GridBagLayout());
  private DiffEditor myResultEditor;
  private DiffEditor myMineEditor;
  private DiffEditor myRepositoryEditor;
  private List<ChangeGroupBuilder> myChangeGroupBuilders = ListSequence.fromList(new ArrayList<ChangeGroupBuilder>());
  private DiffEditorComponentsGroup myDiffEditorsGroup = new DiffEditorComponentsGroup();
  private MergeContextState myStateToRestore;

  public MergeRootsDialog(MergeModelsDialog mergeModelsDialog, MergeContext mergeContext, SNodeId rootId, String rootName) {
    super(mergeModelsDialog, "Merging " + rootName);
    myModelsDialog = mergeModelsDialog;
    myOperationContext = mergeModelsDialog.getOperationContext();
    myMergeContext = mergeContext;
    myRootId = rootId;
    myStateToRestore = myMergeContext.getCurrentState();

    myMineEditor = addEditor(0, myMergeContext.getMyModel());
    myResultEditor = addEditor(1, myMergeContext.getResultModel());
    myRepositoryEditor = addEditor(2, myMergeContext.getRepositoryModel());

    linkEditors(true, false);
    linkEditors(false, false);
    linkEditors(true, true);
    linkEditors(false, true);

    JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, myTopPanel, myBottomPanel);
    splitPane.setResizeWeight(0.7);
    myContainer = new JPanel(new BorderLayout());
    DefaultActionGroup actionGroup = ActionUtils.groupFromActions(GoToNeighbourOccurence.previousInstance(myMergeContext, this), GoToNeighbourOccurence.nextInstance(myMergeContext, this), Separator.getInstance(), new ApplyNonConflictsForRoot(myMergeContext, this));
    ActionToolbar toolbar = ActionManager.getInstance().createActionToolbar(ActionPlaces.UNKNOWN, actionGroup, true);
    toolbar.updateActionsImmediately();

    myContainer.add(toolbar.getComponent(), BorderLayout.NORTH);
    myContainer.add(splitPane, BorderLayout.CENTER);
    highlightAllChanges();
  }

  private ChangeGroupBuilder createChangeGroupBuilder(boolean mine, boolean inspector) {
    return new ChangeGroupBuilder(myMergeContext, (mine ?
      myMergeContext.getMyChangeSet() :
      myMergeContext.getRepositoryChangeSet()
    ), (mine ?
      myMineEditor :
      myResultEditor
    ), (mine ?
      myResultEditor :
      myRepositoryEditor
    ), inspector);
  }

  public void rehighlight() {
    myMineEditor.unhighlightAllChanges();
    myResultEditor.unhighlightAllChanges();
    myRepositoryEditor.unhighlightAllChanges();

    if (myResultEditor.getMainEditor().getEditedNode() == null) {
      SNode node = myMergeContext.getResultModel().getNodeById(myRootId);
      if (node != null) {
        myResultEditor.getMainEditor().editNode(node, myOperationContext);
      }
    }

    myResultEditor.getMainEditor().rebuildEditorContent();

    ListSequence.fromList(myChangeGroupBuilders).visitAll(new IVisitor<ChangeGroupBuilder>() {
      public void visit(ChangeGroupBuilder b) {
        b.invalidate();
      }
    });

    highlightAllChanges();
  }

  private void highlightAllChanges() {
    for (ModelChange change : ListSequence.fromList(myMergeContext.getChangesForRoot(myRootId))) {
      if (!(myMergeContext.isChangeResolved(change))) {
        higlightChange(myResultEditor, myMergeContext.getResultModel(), change);
        if (myMergeContext.isMyChange(change)) {
          higlightChange(myMineEditor, myMergeContext.getMyModel(), change);
        } else {
          higlightChange(myRepositoryEditor, myMergeContext.getRepositoryModel(), change);
        }
      }
    }
    myMineEditor.repaintAndRebuildEditorMessages();
    myResultEditor.repaintAndRebuildEditorMessages();
    myRepositoryEditor.repaintAndRebuildEditorMessages();
  }

  private void higlightChange(DiffEditor diffEditor, SModel model, ModelChange change) {
    diffEditor.highlightChange(new ChangeEditorMessage(model, change, diffEditor) {
      @Override
      public boolean isConflicted() {
        return Sequence.fromIterable(myMergeContext.getConflictedWith(getChange())).isNotEmpty();
      }
    });
  }

  private void linkEditors(boolean mine, boolean inspector) {
    // create change group builder, trapecium strip and merge buttons painter 
    // 'mine' parameter means mine changeset, 'inspector' - highlight inspector editor component 
    ChangeGroupBuilder changeGroupBuilder = createChangeGroupBuilder(mine, inspector);
    ListSequence.fromList(myChangeGroupBuilders).addElement(changeGroupBuilder);
    ChangeTrapeciumStrip strip = new ChangeTrapeciumStrip(changeGroupBuilder);
    JPanel panel = (inspector ?
      myBottomPanel :
      myTopPanel
    );
    ((GridBagLayout) panel.getLayout()).setConstraints(strip, new GridBagConstraints((mine ?
      1 :
      3
    ), 0, 1, 1, 0, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(5, 0, 5, 0), 0, 0));
    panel.add(strip);
    MergeButtonsPainter.addTo(this, (mine ?
      myMineEditor :
      myRepositoryEditor
    ), changeGroupBuilder, inspector);
  }

  private DiffEditor addEditor(int index, SModel model) {
    SNode node = model.getNodeById(myRootId);
    final DiffEditor result = new DiffEditor(myOperationContext, node);
    result.getMainEditor().editNode(node, myOperationContext);
    result.setReadOnly(true);

    JPanel panel = new JPanel(new BorderLayout());
    JLabel title = new JLabel(myModelsDialog.getContentTitles()[index]);
    title.setToolTipText(myModelsDialog.getContentTitles()[index]);
    panel.add(title, BorderLayout.NORTH);
    panel.add(result.getMainEditor().getExternalComponent(), BorderLayout.CENTER);
    panel.setPreferredSize(new Dimension());

    GridBagConstraints gbc = new GridBagConstraints(index * 2, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(5, (index == 0 ?
      5 :
      0
    ), 5, (index == 2 ?
      5 :
      0
    )), 0, 0);
    ((GridBagLayout) myTopPanel.getLayout()).setConstraints(panel, gbc);
    myTopPanel.add(panel);
    JComponent inspector = result.getInspector().getExternalComponent();
    inspector.setPreferredSize(new Dimension());
    ((GridBagLayout) myBottomPanel.getLayout()).setConstraints(inspector, gbc);
    myBottomPanel.add(inspector);

    myDiffEditorsGroup.add(result);
    return result;
  }

  public SNodeId getRootId() {
    return myRootId;
  }

  /*package*/ MergeModelsDialog getModelsDialog() {
    return myModelsDialog;
  }

  protected JComponent getMainComponent() {
    return myContainer;
  }

  @Override
  public DialogDimensionsSettings.DialogDimensions getDefaultDimensionSettings() {
    return new DialogDimensionsSettings.DialogDimensions(10, 10, 1000, 900);
  }

  @BaseDialog.Button(name = "OK", mnemonic = 'O', position = 0, defaultButton = true)
  public void ok() {
    MergeConfirmation.showMergeConfirmationAndTakeAction(this, myMergeContext, myMergeContext.getChangesForRoot(myRootId), new _FunctionTypes._void_P0_E0() {
      public void invoke() {
        myMergeContext.applyAllChangesForNonConflictingRoots();
      }
    }, new _FunctionTypes._void_P0_E0() {
      public void invoke() {
        saveAndClose();
      }
    });
  }

  public void saveAndClose() {
    myStateToRestore = null;
    dispose();
  }

  @BaseDialog.Button(name = "Cancel", mnemonic = 'C', position = 1)
  public void cancel() {
    dispose();
  }

  @Override
  public void dispose() {
    if (myStateToRestore == null) {
      myModelsDialog.rebuildLater();
    } else {
      myMergeContext.restoreState(myStateToRestore);
    }
    myModelsDialog.rootsDialogClosed();
    super.dispose();
  }
}
