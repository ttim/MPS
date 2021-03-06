package jetbrains.mps.ide.java.platform.highlighters;

/*Generated by MPS */

import jetbrains.mps.editor.runtime.AbstractLeftEditorHighlighterMessage;
import jetbrains.mps.nodeEditor.cells.CellFinder;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorMessageOwner;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.nodeEditor.cells.CellFinders;
import jetbrains.mps.util.Condition;
import javax.swing.JPopupMenu;

public abstract class AbstractOverrideEditorMessage extends AbstractLeftEditorHighlighterMessage {
  private CellFinder<EditorCell> myReturnTypeCellFinder;

  public AbstractOverrideEditorMessage(SNode node, EditorMessageOwner owner, String tooltip) {
    super(node, owner, tooltip);
    final SNode returnTypeNode = SLinkOperations.getTarget(node, "returnType", true);
    this.myReturnTypeCellFinder = CellFinders.byCondition(new Condition<EditorCell>() {
      public boolean met(EditorCell cell) {
        return cell.getSNode() == returnTypeNode;
      }
    }, true);
  }

  public EditorCell getAnchorCell(EditorCell bigCell) {
    EditorCell returnTypeCell = bigCell.findChild(this.myReturnTypeCellFinder);
    return (returnTypeCell != null ?
      returnTypeCell :
      bigCell
    );
  }

  public JPopupMenu getPopupMenu() {
    return null;
  }
}
