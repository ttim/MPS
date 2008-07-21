package jetbrains.mps.bootstrap.smodelLanguage.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.AbstractCellProvider;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;

public class Concept_GetAllSuperConcepts_Editor extends DefaultNodeEditor {

  /* package */AbstractCellProvider myReplaceableAliasAndParms_Comp1;

  private static void setupBasic_CollectionCell20772_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_CollectionCell20772_0");
  }

  private static void setupBasic_ReplaceableAliasAndParms_CompComponentCell20772_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_ReplaceableAliasAndParms_CompComponentCell20772_0");
  }


  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.create_CollectionCell20772_0(context, node);
  }

  public EditorCell create_CollectionCell20772_0(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    setupBasic_CollectionCell20772_0(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.create_ReplaceableAliasAndParms_CompComponentCell20772_0(context, node));
    return editorCell;
  }

  public EditorCell create_ReplaceableAliasAndParms_CompComponentCell20772_0(EditorContext context, SNode node) {
    if (this.myReplaceableAliasAndParms_Comp1 == null) {
      this.myReplaceableAliasAndParms_Comp1 = new ReplaceableAliasAndParms_Comp(node);
    }
    EditorCell editorCell = this.myReplaceableAliasAndParms_Comp1.createEditorCell(context);
    setupBasic_ReplaceableAliasAndParms_CompComponentCell20772_0(editorCell, node, context);
    return editorCell;
  }

}
