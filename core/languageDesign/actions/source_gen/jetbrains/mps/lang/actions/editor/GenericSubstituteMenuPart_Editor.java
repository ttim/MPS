package jetbrains.mps.lang.actions.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.nodeEditor.cells.EditorCell_Constant;
import jetbrains.mps.nodeEditor.MPSColors;
import jetbrains.mps.nodeEditor.cells.EditorCell_Indent;
import jetbrains.mps.nodeEditor.cellProviders.CellProviderWithRole;
import jetbrains.mps.lang.editor.cellProviders.RefNodeCellProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;

public class GenericSubstituteMenuPart_Editor extends DefaultNodeEditor {

  public EditorCell createEditorCell(EditorContext editorContext, SNode node) {
    return this.createCollection_0295_0(editorContext, node);
  }

  private EditorCell createCollection_0295_0(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createVertical(editorContext, node);
    editorCell.setCellId("Collection_0295_0");
    editorCell.addEditorCell(this.createCollection_0295_1(editorContext, node));
    editorCell.addEditorCell(this.createCollection_0295_2(editorContext, node));
    return editorCell;
  }

  private EditorCell createCollection_0295_1(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(editorContext, node);
    editorCell.setCellId("Collection_0295_1");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.addEditorCell(this.createConstant_0295_0(editorContext, node));
    return editorCell;
  }

  private EditorCell createCollection_0295_2(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(editorContext, node);
    editorCell.setCellId("Collection_0295_2");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.addEditorCell(this.createIndentCell0295_0(editorContext, node));
    editorCell.addEditorCell(this.createRefNode_0295_0(editorContext, node));
    return editorCell;
  }

  private EditorCell createConstant_0295_0(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "generic query");
    editorCell.setCellId("Constant_0295_0");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.TEXT_COLOR, MPSColors.DARK_BLUE);
    }
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createIndentCell0295_0(EditorContext editorContext, SNode node) {
    EditorCell_Indent result = new EditorCell_Indent(editorContext, node);
    return result;
  }

  private EditorCell createRefNode_0295_0(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, editorContext);
    provider.setRole("query");
    provider.setNoTargetText("<no query>");
    EditorCell editorCell;
    editorCell = provider.createEditorCell(editorContext);
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = editorContext.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(editorContext, attributeConcept, attributeKind, editorCell);
    } else
    return editorCell;
  }

}
