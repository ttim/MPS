package jetbrains.mps.lang.editor.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.AbstractCellProvider;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.nodeEditor.cellProviders.CellProviderWithRole;
import jetbrains.mps.lang.editor.cellProviders.RefCellCellProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;
import jetbrains.mps.lang.editor.cellProviders.PropertyCellProvider;

public class CellModel_Component_Editor extends DefaultNodeEditor {

  private AbstractCellProvider my_OpenTag6025_0;
  private AbstractCellProvider my_CloseTag6025_0;
  private AbstractCellProvider my_CellModel_Common6025_0;

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createCollection_6025_0(context, node);
  }

  public EditorCell createInspectedCell(EditorContext context, SNode node) {
    return this.createCollection_6025_1(context, node);
  }

  private EditorCell createCollection_6025_0(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    editorCell.setCellId("Collection_6025_0");
    Styles_StyleSheet.getRootCellModelStyle(editorCell).apply(editorCell);
    editorCell.addKeyMap(new CellModel_Component_KeyMap());
    editorCell.addEditorCell(this.createComponent_6025_0(context, node));
    editorCell.addEditorCell(this.createRefCell_6025_0(context, node));
    editorCell.addEditorCell(this.createComponent_6025_1(context, node));
    return editorCell;
  }

  private EditorCell createCollection_6025_1(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createVertical(context, node);
    editorCell.setCellId("Collection_6025_1");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.addEditorCell(this.createComponent_6025_2(context, node));
    return editorCell;
  }

  private EditorCell createComponent_6025_0(EditorContext context, SNode node) {
    if (this.my_OpenTag6025_0 == null) {
      this.my_OpenTag6025_0 = new _OpenTag(node);
    }
    EditorCell editorCell = this.my_OpenTag6025_0.createEditorCell(context);
    return editorCell;
  }

  private EditorCell createComponent_6025_1(EditorContext context, SNode node) {
    if (this.my_CloseTag6025_0 == null) {
      this.my_CloseTag6025_0 = new _CloseTag(node);
    }
    EditorCell editorCell = this.my_CloseTag6025_0.createEditorCell(context);
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.DRAW_BORDER, true);
    }
    return editorCell;
  }

  private EditorCell createComponent_6025_2(EditorContext context, SNode node) {
    if (this.my_CellModel_Common6025_0 == null) {
      this.my_CellModel_Common6025_0 = new _CellModel_Common(node);
    }
    EditorCell editorCell = this.my_CellModel_Common6025_0.createEditorCell(context);
    return editorCell;
  }

  private EditorCell createRefCell_6025_0(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefCellCellProvider(node, context);
    provider.setRole("editorComponent");
    provider.setNoTargetText("<no component>");
    EditorCell editorCell;
    provider.setAuxiliaryCellProvider(new CellModel_Component_Editor._Inline6025_0());
    editorCell = provider.createEditorCell(context);
    Styles_StyleSheet.getBordered(editorCell).apply(editorCell);
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

  public static class _Inline6025_0 extends AbstractCellProvider {

    public _Inline6025_0() {
      super();
    }

    public EditorCell createEditorCell(EditorContext context) {
      return this.createEditorCell(context, this.getSNode());
    }

    public EditorCell createEditorCell(EditorContext context, SNode node) {
      return this.createProperty_6025_0(context, node);
    }

    private EditorCell createProperty_6025_0(EditorContext context, SNode node) {
      CellProviderWithRole provider = new PropertyCellProvider(node, context);
      provider.setRole("name");
      provider.setNoTargetText("<no name>");
      provider.setReadOnly(true);
      EditorCell editorCell;
      editorCell = provider.createEditorCell(context);
      editorCell.setCellId("property_name");
      {
        Style style = editorCell.getStyle();
        style.set(StyleAttributes.DRAW_BORDER, true);
      }
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

}
