package jetbrains.mps.baseLanguage.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import jetbrains.mps.nodeEditor.cells.EditorCell_Constant;
import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.nodeEditor.MPSFonts;
import jetbrains.mps.nodeEditor.cellProviders.CellProviderWithRole;
import jetbrains.mps.lang.editor.cellProviders.RefNodeCellProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;

public class NotExpression_Editor extends DefaultNodeEditor {

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createCollection_5487_0(context, node);
  }

  private EditorCell createCollection_5487_0(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createIndent2(context, node);
    editorCell.setCellId("Collection_5487_0");
    editorCell.addEditorCell(this.createConstant_5487_0(context, node, "!"));
    editorCell.addEditorCell(this.createConstant_5487_2(context, node, "("));
    editorCell.addEditorCell(this.createRefNode_5487_0(context, node));
    editorCell.addEditorCell(this.createConstant_5487_1(context, node, ")"));
    return editorCell;
  }

  private EditorCell createConstant_5487_0(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    editorCell.setCellId("Constant_5487_0");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.FONT_STYLE, MPSFonts.PLAIN);
      style.set(StyleAttributes.PUNCTUATION_RIGHT, true);
    }
    NotExpression_Parens_Actions.setCellActions(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_5487_1(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    editorCell.setCellId("Constant_5487_1");
    BaseLanguageStyle_StyleSheet.getRightParen(editorCell).apply(editorCell);
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, true);
    }
    NotExpression_Parens_Actions.setCellActions(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_5487_2(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    editorCell.setCellId("Constant_5487_2");
    BaseLanguageStyle_StyleSheet.getLeftParen(editorCell).apply(editorCell);
    NotExpression_Parens_Actions.setCellActions(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createRefNode_5487_0(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, context);
    provider.setRole("expression");
    provider.setNoTargetText("<no expression>");
    EditorCell editorCell;
    editorCell = provider.createEditorCell(context);
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, editorCell);
    } else
    return editorCell;
  }

}
