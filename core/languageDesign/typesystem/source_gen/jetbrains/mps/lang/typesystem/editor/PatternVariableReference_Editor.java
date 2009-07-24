package jetbrains.mps.lang.typesystem.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import jetbrains.mps.nodeEditor.cellProviders.CellProviderWithRole;
import jetbrains.mps.lang.editor.cellProviders.RefCellCellProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;
import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.nodeEditor.AbstractCellProvider;
import jetbrains.mps.lang.editor.cellProviders.PropertyCellProvider;
import jetbrains.mps.nodeEditor.MPSFonts;
import jetbrains.mps.nodeEditor.MPSColors;

public class PatternVariableReference_Editor extends DefaultNodeEditor {

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createCollection_2605_0(context, node);
  }

  public EditorCell createCollection_2605_0(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createIndent2(context, node);
    setupBasic_Collection_2605_0(editorCell, node, context);
    editorCell.addEditorCell(this.createRefCell_2605_1(context, node));
    return editorCell;
  }

  public EditorCell createRefCell_2605_0_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(new PatternVariableReference_Editor._Inline2605_0());
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_RefCell_2605_0(editorCell, node, context);
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell createRefCell_2605_1(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefCellCellProvider(node, context);
    provider.setRole("patternVarDecl");
    provider.setNoTargetText("<no patternVarDecl>");
    EditorCell cellWithRole = this.createRefCell_2605_0_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }


  private static void setupBasic_RefCell_2605_0(EditorCell editorCell, SNode node, EditorContext context) {
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.GET_PARENT_SUBSTITUDE_INFO, true);
    }
  }

  private static void setupBasic_Collection_2605_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Collection_2605_0");
  }

  public static class _Inline2605_0 extends AbstractCellProvider {

    public _Inline2605_0() {
      super();
    }

    public EditorCell createEditorCell(EditorContext context) {
      return this.createEditorCell(context, this.getSNode());
    }

    public EditorCell createEditorCell(EditorContext context, SNode node) {
      return this.createProperty_2605_1(context, node);
    }

    public EditorCell createProperty_2605_0_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
      CellProviderWithRole provider = aProvider;
      provider.setAuxiliaryCellProvider(null);
      EditorCell editorCell = provider.createEditorCell(context);
      setupBasic_Property_2605_0(editorCell, node, context);
      editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
      return editorCell;
    }

    public EditorCell createProperty_2605_1(EditorContext context, SNode node) {
      CellProviderWithRole provider = new PropertyCellProvider(node, context);
      provider.setRole("name");
      provider.setNoTargetText("<no name>");
      provider.setReadOnly(true);
      EditorCell cellWithRole = this.createProperty_2605_0_internal(context, node, provider);
      SNode attributeConcept = provider.getRoleAttribute();
      Class attributeKind = provider.getRoleAttributeClass();
      if (attributeConcept != null) {
        IOperationContext opContext = context.getOperationContext();
        EditorManager manager = EditorManager.getInstanceFromContext(opContext);
        return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
      } else
      return cellWithRole;
    }


    private static void setupBasic_Property_2605_0(EditorCell editorCell, SNode node, EditorContext context) {
      editorCell.setCellId("property_name");
      {
        Style style = editorCell.getStyle();
        style.set(StyleAttributes.FONT_STYLE, MPSFonts.BOLD);
        style.set(StyleAttributes.TEXT_COLOR, MPSColors.DARK_GREEN);
      }
    }

}

}
