package jetbrains.mps.bootstrap.smodelLanguage.editor;

/*Generated by MPS  */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.AbstractCellProvider;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.nodeEditor.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import java.awt.Color;
import jetbrains.mps.nodeEditor.EditorCell_Collection;
import jetbrains.mps.nodeEditor.EditorCell_Constant;

public class Node_GetPrevSiblingsOperation_Editor extends DefaultNodeEditor {

  /* package */AbstractCellProvider myOperationParameters_Component2;

  public static boolean _QueryFunction_NodeCondition_1146258693208(SNode node, IScope scope) {
    return SLinkOperations.getCount(node, "parameter") == 0;
  }

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createCellAlternation(context, node);
  }
  public EditorCell createCellAlternation(EditorContext context, SNode node) {
    boolean alternationCondition = true;
    alternationCondition = Node_GetPrevSiblingsOperation_Editor._QueryFunction_NodeCondition_1146258693208(node, context.getOperationContext().getScope());
    EditorCell editorCell = null;
    if(alternationCondition) {
      editorCell = this.createConstantCell(context, node, "prev-siblings");
    } else 
    {
      editorCell = this.createRowCell(context, node);
    }
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1145572861644");
    editorCell.setLayoutConstraint("");
    return editorCell;
  }
  public EditorCell createRowCell(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    editorCell.setSelectable(true);
    editorCell.setDrawBorder(false);
    editorCell.setGridLayout(false);
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createConstantCell1(context, node, "prev-siblings"));
    editorCell.addEditorCell(this.createOperationParameters_ComponentCell(context, node));
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1145572861646");
    editorCell.setLayoutConstraint("");
    return editorCell;
  }
  public EditorCell createOperationParameters_ComponentCell(EditorContext context, SNode node) {
    if(this.myOperationParameters_Component2 == null) {
      this.myOperationParameters_Component2 = new OperationParameters_Component(node);
    }
    EditorCell componentCell = this.myOperationParameters_Component2.createEditorCell(context);
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    editorCell.addEditorCell(componentCell);
    editorCell.setSelectable(true);
    editorCell.setDrawBorder(false);
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1145572861648");
    editorCell.setLayoutConstraint("");
    return editorCell;
  }
  public EditorCell createConstantCell(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(context, node, text, false);
    editorCell.setSelectable(true);
    editorCell.setDrawBorder(false);
    editorCell.setEditable(true);
    editorCell.setDefaultText("");
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1145572861645");
    editorCell.setLayoutConstraint("");
    return editorCell;
  }
  public EditorCell createConstantCell1(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(context, node, text, false);
    editorCell.setSelectable(true);
    editorCell.setDrawBorder(false);
    editorCell.setEditable(true);
    editorCell.setDefaultText("");
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1145572861647");
    editorCell.setLayoutConstraint("");
    return editorCell;
  }
}
