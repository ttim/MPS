package jetbrains.mps.baseLanguage.editor;

/*Generated by MPS Jul 3, 2006 5:50:18 PM */


import jetbrains.mps.nodeEditor.EditorCell;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;

public class ParameterDeclaration_Name_Actions {

  public static void setCellActions(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setAction("RIGHT_TRANSFORM", new ParameterDeclaration_Name_Actions_RIGHT_TRANSFORM(node));
  }
}
