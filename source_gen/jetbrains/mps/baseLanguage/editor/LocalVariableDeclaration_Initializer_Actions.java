package jetbrains.mps.baseLanguage.editor;

/*Generated by MPS Jul 20, 2006 1:58:08 PM */


import jetbrains.mps.nodeEditor.EditorCell;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;

public class LocalVariableDeclaration_Initializer_Actions {

  public static void setCellActions(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setAction("DELETE", new LocalVariableDeclaration_Initializer_Actions_DELETE(node));
  }
}
