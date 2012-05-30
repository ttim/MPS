package jetbrains.mps.ide.editor.actions;

/*Generated by MPS */

import jetbrains.mps.workbench.action.BaseAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.internal.collections.runtime.Sequence;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.ide.editor.MPSEditorDataKeys;
import jetbrains.mps.ide.actions.MPSCommonDataKeys;
import jetbrains.mps.openapi.editor.EditorCell;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import com.intellij.openapi.ui.popup.ListPopup;
import jetbrains.mps.smodel.ModelAccess;
import com.intellij.openapi.actionSystem.ActionGroup;
import com.intellij.openapi.ui.popup.JBPopupFactory;
import com.intellij.ui.awt.RelativePoint;
import jetbrains.mps.nodeEditor.EditorContext;
import java.awt.Point;
import jetbrains.mps.nodeEditor.selection.Selection;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.util.Pair;
import jetbrains.mps.intentions.Intention;
import jetbrains.mps.smodel.SNode;
import java.util.Comparator;
import com.intellij.openapi.actionSystem.AnAction;
import jetbrains.mps.project.MPSProject;
import jetbrains.mps.intentions.IntentionsManager;
import jetbrains.mps.intentions.SurroundWithIntention;

public class ShowSurroundWithIntentions_Action extends BaseAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(ShowSurroundWithIntentions_Action.class);

  public ShowSurroundWithIntentions_Action() {
    super("Surround with...", "", ICON);
    this.setIsAlwaysVisible(true);
    this.setExecuteOutsideCommand(true);
  }

  @Override
  public boolean isDumbAware() {
    return true;
  }

  public boolean isApplicable(AnActionEvent event, final Map<String, Object> _params) {
    if (ShowSurroundWithIntentions_Action.this.getAnchorCell(_params) == null) {
      return false;
    }
    return Sequence.fromIterable(ShowSurroundWithIntentions_Action.this.getAvailableIntentions(_params)).isNotEmpty();
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      {
        boolean enabled = this.isApplicable(event, _params);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "ShowSurroundWithIntentions", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.fromMap(_params).put("editorContext", event.getData(MPSEditorDataKeys.EDITOR_CONTEXT));
    if (MapSequence.fromMap(_params).get("editorContext") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("mpsProject", event.getData(MPSCommonDataKeys.MPS_PROJECT));
    MapSequence.fromMap(_params).put("node", event.getData(MPSCommonDataKeys.NODE));
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      final EditorCell selectedCell = ShowSurroundWithIntentions_Action.this.getAnchorCell(_params);
      int x = selectedCell.getX();
      int y = selectedCell.getY();
      y += selectedCell.getHeight();
      final Wrappers._T<ListPopup> popup = new Wrappers._T<ListPopup>(null);
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          ActionGroup group = ShowSurroundWithIntentions_Action.this.getActionGroup(_params);
          if (group.getChildren(event).length == 0) {
            return;
          }
          popup.value = JBPopupFactory.getInstance().createActionGroupPopup("Surround with", group, event.getDataContext(), JBPopupFactory.ActionSelectionAid.ALPHA_NUMBERING, false);
        }
      });
      if (popup.value == null) {
        return;
      }

      RelativePoint relativePoint = new RelativePoint(((EditorContext) MapSequence.fromMap(_params).get("editorContext")).getNodeEditorComponent(), new Point(x, y));
      popup.value.show(relativePoint);
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "ShowSurroundWithIntentions", t);
      }
    }
  }

  private jetbrains.mps.nodeEditor.cells.EditorCell getAnchorCell(final Map<String, Object> _params) {
    Selection selection = ((EditorContext) MapSequence.fromMap(_params).get("editorContext")).getNodeEditorComponent().getSelectionManager().getSelection();
    if (selection == null) {
      return null;
    }
    List<jetbrains.mps.nodeEditor.cells.EditorCell> selectedCells = selection.getSelectedCells();
    if (ListSequence.fromList(selectedCells).isNotEmpty()) {
      return ListSequence.fromList(selectedCells).first();
    }
    return null;
  }

  private ActionGroup getActionGroup(final Map<String, Object> _params) {
    DefaultActionGroup actionGroup = new DefaultActionGroup();

    Iterable<Pair<Intention, SNode>> availableIntentions = Sequence.fromIterable(ShowSurroundWithIntentions_Action.this.getAvailableIntentions(_params)).sort(new Comparator<Pair<Intention, SNode>>() {
      public int compare(Pair<Intention, SNode> a, Pair<Intention, SNode> b) {
        return ShowSurroundWithIntentions_Action.this.getDescriptior(a, _params).compareTo(ShowSurroundWithIntentions_Action.this.getDescriptior(b, _params));
      }
    }, true);

    for (Pair<Intention, SNode> pair : Sequence.fromIterable(availableIntentions)) {
      final Pair<Intention, SNode> finalPair = pair;
      actionGroup.add(new AnAction(ShowSurroundWithIntentions_Action.this.getDescriptior(pair, _params)) {
        public void actionPerformed(AnActionEvent event) {
          ModelAccess.instance().runCommandInEDT(new Runnable() {
            public void run() {
              finalPair.getFirst().execute(finalPair.getSecond(), ((EditorContext) MapSequence.fromMap(_params).get("editorContext")));
            }
          }, ((MPSProject) MapSequence.fromMap(_params).get("mpsProject")));
        }
      });
    }

    return actionGroup;
  }

  private Iterable<Pair<Intention, SNode>> getAvailableIntentions(final Map<String, Object> _params) {
    IntentionsManager.QueryDescriptor query = new IntentionsManager.QueryDescriptor();
    query.setIntentionClass(SurroundWithIntention.class);
    query.setInstantiate(true);
    query.setCurrentNodeOnly(true);
    return IntentionsManager.getInstance().getAvailableIntentions(query, ((SNode) MapSequence.fromMap(_params).get("node")), ((EditorContext) MapSequence.fromMap(_params).get("editorContext")));
  }

  private String getDescriptior(Pair<Intention, SNode> pair, final Map<String, Object> _params) {
    return pair.getFirst().getDescription(pair.getSecond(), ((EditorContext) MapSequence.fromMap(_params).get("editorContext")));
  }
}
