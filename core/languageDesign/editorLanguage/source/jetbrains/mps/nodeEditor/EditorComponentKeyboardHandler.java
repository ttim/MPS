/*
 * Created by IntelliJ IDEA.
 * User: alshan
 * Date: Mar 25, 2004
 * Time: 3:44:49 PM
 */
package jetbrains.mps.nodeEditor;


import jetbrains.mps.smodel.SNode;
import jetbrains.mps.util.Pair;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.cells.EditorCell_Label;
import jetbrains.mps.nodeEditor.cells.CellConditions;
import jetbrains.mps.bootstrap.structureLanguage.structure.LinkDeclaration;
import jetbrains.mps.bootstrap.structureLanguage.structure.Cardinality;

import java.awt.event.KeyEvent;
import java.util.List;

public class EditorComponentKeyboardHandler implements KeyboardHandler {
  public boolean processKeyReleased(EditorContext editorContext, KeyEvent keyEvent) {
    return false;
  }

  public boolean processKeyPressed(final EditorContext editorContext, final KeyEvent keyEvent) {
    EditorComponent nodeEditor = editorContext.getNodeEditorComponent();
    nodeEditor.hideMessageToolTip();

    if (keyEvent.isConsumed() || !editorContext.isEditable()) {
      return false;
    }

    if (processSelectedCell(editorContext, keyEvent, false)) {
      return true;
    }

    if (processKeyMaps(editorContext, keyEvent)) {
      return true;
    }

    if (processSideDeletes(editorContext, keyEvent)) {
      return true;
    }

    CellActionType actionType = editorContext.getNodeEditorComponent().getActionType(keyEvent, editorContext);
    EditorCell selectedCell = editorContext.getSelectedCell();

    if (selectedCell != null) {
      boolean endEditKeystroke = isEndEditKeystroke(keyEvent);      
      boolean strictMatching = endEditKeystroke || CellActionType.RIGHT_TRANSFORM.equals(actionType) || CellActionType.LEFT_TRANSFORM.equals(actionType);

      if (selectedCell.isErrorState()) {
        if (endEditKeystroke ||
          actionType == CellActionType.INSERT ||
          actionType == CellActionType.INSERT_BEFORE) {
          if (selectedCell.validate(strictMatching, true)) {
            return true;
          }
        }

        if (actionType == CellActionType.RIGHT_TRANSFORM || actionType == CellActionType.LEFT_TRANSFORM) {
          // !side effect: can change selection!
          if (selectedCell.validate(strictMatching, false)) {
            return true;
          }
        }

        selectedCell = editorContext.getNodeEditorComponent().getSelectedCell();
        if (selectedCell == null) {
          return true;
        }
      }
    }

    // process action
    if (selectedCell != null) {
      if (selectedCell instanceof EditorCell_Label &&
        !isOneToManyCollection(selectedCell) &&
        (actionType == CellActionType.INSERT || actionType == CellActionType.INSERT_BEFORE)) {

        EditorCell cellWithRole = new ChildrenCollectionFinder(selectedCell, actionType == CellActionType.INSERT).find();

        if (cellWithRole == null && actionType == CellActionType.INSERT_BEFORE &&
          selectedCell.isFirstPositionInBigCell() && hasSingleRole(selectedCell.getSNode())) {
          cellWithRole = new ChildrenCollectionFinder(selectedCell.getPrevLeaf(), false).find();
        }

        if (cellWithRole == null && actionType == CellActionType.INSERT &&
          selectedCell.isLastPositionInBigCell() && hasSingleRole(selectedCell.getSNode())) {
          cellWithRole = new ChildrenCollectionFinder(selectedCell.getNextLeaf(), true).find();
        }

        if (cellWithRole != null && cellWithRole.executeAction(actionType)) {
          return true;
        }
      }

      if (actionType != null && actionType != CellActionType.DELETE) {
        if (selectedCell.executeAction(actionType)) {
          return true;
        }
      }

      if (!keyEvent.isConsumed()) {        
        if (editorContext.getNodeEditorComponent().getNodeRangeSelection().isSelectionKeystroke(keyEvent)) {
          if (editorContext.getNodeEditorComponent().getNodeRangeSelection().activate(keyEvent)) {
            return true;
          }
        }

        // allow selected cell to process event.
        if (selectedCell.processKeyPressed(keyEvent, true)) {
          return true;
        }
      }

      if (actionType == CellActionType.DELETE) {
        if (selectedCell.executeAction(actionType)) {
          return true;
        }
      }
    }

    // special case - don't allow kbd focus to leave editor area
    if (keyEvent.getKeyCode() == KeyEvent.VK_UP && keyEvent.isControlDown() && !keyEvent.isAltDown() && !keyEvent.isShiftDown()) {
      keyEvent.consume();
    }

    return false;
  }


  private boolean processSelectedCell(EditorContext editorContext, KeyEvent event, boolean allowErrors) {
    EditorCell selectedCell = editorContext.getSelectedCell();
    if (selectedCell != null) {
      if (selectedCell.processKeyPressed(event, allowErrors)) {
        return true;
      }
    }
    return false;
  }

  private boolean processKeyMaps(EditorContext editorContext, KeyEvent keyEvent) {
    EditorCell selectedCell = editorContext.getSelectedCell();
    if (selectedCell != null) {
      List<Pair<EditorCellKeyMapAction, EditorCell>> actionsInfo = KeyMapUtil.getKeyMapActionsForEvent(selectedCell, keyEvent, editorContext);
      if (actionsInfo.size() == 1 && !(actionsInfo.get(0).o1.isMenuAlwaysShown())) {
        EditorCellKeyMapAction action = actionsInfo.get(0).o1;
        EditorCell contextCell = actionsInfo.get(0).o2;
        KeyMapUtil.executeKeyMapAction(action, keyEvent, contextCell, editorContext);
        return true;
      } else if (actionsInfo.size() > 1 ||
        (actionsInfo.size() == 1 && actionsInfo.get(0).o1.isMenuAlwaysShown())) {
        // show menu
        KeyMapUtil.showActionsMenu(actionsInfo, keyEvent, editorContext, selectedCell);
        return true;
      }
    }
    return false;
  }

  private boolean isFirstPosition(EditorCell cell) {
    if (!(cell instanceof EditorCell_Label)) return false;
    return ((EditorCell_Label) cell).isFirstCaretPosition();
  }

  private boolean isLastCaretPosition(EditorCell cell) {
    if (!(cell instanceof EditorCell_Label)) return false;
    return ((EditorCell_Label) cell).isLastCaretPosition();
  }

  private boolean processSideDeletes(EditorContext editorContext, KeyEvent keyEvent) {
    EditorCell selectedCell = editorContext.getSelectedCell();
    if (selectedCell == null) return false;
    if (areModifiersPressed(keyEvent)) return false;

    if (keyEvent.getKeyCode() == KeyEvent.VK_DELETE && isLastCaretPosition(selectedCell)) {
      EditorCell target;
      if (selectedCell.isLastPositionInBigCell() && selectedCell.getContainingBigCell().getNextSibling() != null) {
        target = selectedCell.getContainingBigCell().getNextSibling();
      } else if (selectedCell.getNextSibling() != null) {
        target = selectedCell.getNextSibling();
      } else {
        target = selectedCell.getNextLeaf(CellConditions.SELECTABLE);
      }

      if (target == null || target.getSNode().isAncestorOf(selectedCell.getSNode())) return false;
      return target.executeAction(CellActionType.DELETE);
    }

    if (keyEvent.getKeyCode() == KeyEvent.VK_BACK_SPACE && isFirstPosition(selectedCell)) {
      EditorCell target;
      if (selectedCell.isFirstPositionInBigCell() && selectedCell.getContainingBigCell().getPrevSibling() != null) {
        target = selectedCell.getContainingBigCell().getPrevSibling();
      } else if (selectedCell.getPrevSibling() != null) {
        target = selectedCell.getPrevSibling();
      } else {
        target = selectedCell.getPrevLeaf(CellConditions.SELECTABLE);
      }
      if (target == null || target.getSNode().isAncestorOf(selectedCell.getSNode())) return false;
      return target.executeAction(CellActionType.DELETE);
    }

    return false;
  }

  private boolean areModifiersPressed(KeyEvent e) {
    return e.isControlDown() || e.isAltDown() || e.isShiftDown();
  }

  private boolean isEndEditKeystroke(final KeyEvent keyEvent) {
    return (keyEvent.getKeyCode() == KeyEvent.VK_ENTER && !(keyEvent.isControlDown() || keyEvent.isAltDown() || keyEvent.isShiftDown()));
  }

  private boolean isOneToManyCollection(EditorCell cell) {
    String role = (String) cell.getUserObject(EditorCell.ROLE);
    if (role == null) return false;
    LinkDeclaration link = cell.getSNode().getLinkDeclaration(role);
    if (link == null) return false;
    return link.getSourceCardinality() == Cardinality._0__n || link.getSourceCardinality() == Cardinality._1__n;
  }

  private boolean hasSingleRole(SNode node) {
    String role = node.getRole_();
    if (role == null) return false;
    LinkDeclaration link = node.getParent().getLinkDeclaration(role);
    return link.getSourceCardinality() == Cardinality._0__1 || link.getSourceCardinality() == Cardinality._1;
  }
}