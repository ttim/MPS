package jetbrains.mps.nodeEditor;

/**
 * Created by IntelliJ IDEA.
 * User: Cyril.Konopko
 * Date: 04.11.2005
 * Time: 12:32:03
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractCellLayout implements CellLayout {


  public int getAscent(EditorCell_Collection editorCells) {
    int ascent = 0;
    for (EditorCell cell : editorCells) {
      ascent = Math.max(ascent, cell.getAscent());
    }
    return ascent;
  }

  public int getDescent(EditorCell_Collection editorCells) {
    return editorCells.getHeight() - getAscent(editorCells);
  }
}
