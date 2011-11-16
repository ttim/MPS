package jetbrains.mps.vcs.changesmanager.editor;

/*Generated by MPS */

import org.jetbrains.annotations.Nullable;
import jetbrains.mps.vcs.diff.ui.common.ChangeGroup;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.nodeEditor.EditorComponent;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import java.util.List;
import jetbrains.mps.vcs.diff.changes.ModelChange;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.vcs.diff.changes.NodeCopier;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.vcs.diff.changes.NodeGroupChange;
import jetbrains.mps.internal.collections.runtime.IVisitor;

public class ChangesStripActionsHelper {
  private ChangesStripActionsHelper() {
  }

  @Nullable
  private static ChangeGroup getNeighbourChangeGroup(@NotNull EditorContext editorContext, boolean next) {
    EditorComponent editorComponent = editorContext.getNodeEditorComponent();
    ChangesEditorHighlighter highlighter = check_ikrecr_a0b0a(editorContext.getOperationContext().getComponent(ChangesEditorHighlighterFactory.class), editorComponent);
    return check_ikrecr_a2a0(check_ikrecr_a0c0a(highlighter), editorContext, next);
  }

  public static boolean isNeighbourGroupAvailable(@NotNull EditorContext editorContext, boolean next) {
    return getNeighbourChangeGroup(editorContext, next) != null;
  }

  public static void goToNeighbourGroup(@NotNull EditorContext editorContext, boolean next) {
    ChangeGroup group = getNeighbourChangeGroup(editorContext, next);
    if (group == null) {
      return;
    }
    EditorComponent editorComponent = editorContext.getNodeEditorComponent();
    ChangesEditorHighlighter highlighter = check_ikrecr_a0d0c(editorContext.getOperationContext().getComponent(ChangesEditorHighlighterFactory.class), editorComponent);
    goToY(editorComponent, (int) group.getBounds(true).end());
    goToY(editorComponent, (int) group.getBounds(true).start());
    check_ikrecr_a0g0c(highlighter).showPopupForGroup(group);
  }

  private static void goToY(EditorComponent editorComponent, int y) {
    EditorCell editorCell = editorComponent.findCellWeak(1, y + 1);
    if (editorCell != null) {
      editorComponent.changeSelection(editorCell);
    }
  }

  public static void rollbackChanges(@NotNull EditorContext editorContext) {
    EditorComponent editorComponent = editorContext.getNodeEditorComponent();
    ChangesEditorHighlighter highlighter = check_ikrecr_a0b0e(editorContext.getOperationContext().getComponent(ChangesEditorHighlighterFactory.class), editorComponent);
    final ChangeStripsPainter painter = check_ikrecr_a0c0e(highlighter);
    final List<ModelChange> changes = check_ikrecr_a0d0e(check_ikrecr_a0a3a4(painter));
    if (changes == null) {
      return;
    }
    ModelAccess.instance().runWriteActionInCommand(new Runnable() {
      public void run() {
        final SModel model = ListSequence.fromList(changes).first().getChangeSet().getNewModel();
        final NodeCopier nc = new NodeCopier(model);
        Iterable<ModelChange> oppositeChanges = ListSequence.fromList(changes).select(new ISelector<ModelChange, ModelChange>() {
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
        painter.showPopupForGroup(null);
      }
    });
  }

  private static ChangesEditorHighlighter check_ikrecr_a0b0a(ChangesEditorHighlighterFactory checkedDotOperand, EditorComponent editorComponent) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getHighlighter(editorComponent);
    }
    return null;
  }

  private static ChangeGroup check_ikrecr_a2a0(ChangeStripsPainter checkedDotOperand, EditorContext editorContext, boolean next) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getNeighbourChangeGroup(check_ikrecr_a0a2a0(editorContext), next);
    }
    return null;
  }

  private static EditorCell check_ikrecr_a0a2a0(EditorContext checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getContextCell();
    }
    return null;
  }

  private static ChangeStripsPainter check_ikrecr_a0c0a(ChangesEditorHighlighter checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getStripsPainter();
    }
    return null;
  }

  private static ChangesEditorHighlighter check_ikrecr_a0d0c(ChangesEditorHighlighterFactory checkedDotOperand, EditorComponent editorComponent) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getHighlighter(editorComponent);
    }
    return null;
  }

  private static ChangeStripsPainter check_ikrecr_a0g0c(ChangesEditorHighlighter checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getStripsPainter();
    }
    return null;
  }

  private static ChangesEditorHighlighter check_ikrecr_a0b0e(ChangesEditorHighlighterFactory checkedDotOperand, EditorComponent editorComponent) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getHighlighter(editorComponent);
    }
    return null;
  }

  private static ChangeStripsPainter check_ikrecr_a0c0e(ChangesEditorHighlighter checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getStripsPainter();
    }
    return null;
  }

  private static List<ModelChange> check_ikrecr_a0d0e(ChangeGroup checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getChanges();
    }
    return null;
  }

  private static ChangeGroup check_ikrecr_a0a3a4(ChangeStripsPainter checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getCurrentChangeGroup();
    }
    return null;
  }
}
