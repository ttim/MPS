package jetbrains.mps.lang.editor.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.AbstractCellProvider;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import jetbrains.mps.nodeEditor.cells.EditorCell_Indent;
import jetbrains.mps.nodeEditor.cellProviders.CellProviderWithRole;
import jetbrains.mps.nodeEditor.cells.EditorCell_Label;
import jetbrains.mps.lang.editor.cellProviders.RefNodeCellProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;
import jetbrains.mps.lang.editor.cellProviders.PropertyCellProvider;
import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.nodeEditor.MPSColors;

public class CellModel_Block_Editor extends DefaultNodeEditor {

  /* package */AbstractCellProvider my_CellModel_Common0905_0;

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createCollection1198490019130(context, node);
  }

  public EditorCell createInspectedCell(EditorContext context, SNode node) {
    return this.createCollection1198502445685(context, node);
  }

  public EditorCell createCollection1198490019130(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createVertical(context, node);
    setupBasic_Collection_11984900191301198490019130(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createCollection1198490032195(context, node));
    editorCell.addEditorCell(this.createCollection1198490035838(context, node));
    editorCell.addEditorCell(this.createProperty1198508750539(context, node));
    return editorCell;
  }

  public EditorCell createCollection1198490032195(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    setupBasic_Collection_11984900321951198490032195(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createRefNode1198490071435(context, node));
    editorCell.addEditorCell(this.createProperty1198508746535(context, node));
    return editorCell;
  }

  public EditorCell createCollection1198490035838(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    setupBasic_Collection_11984900358381198490035838(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createIndentCell0905_0(context, node));
    editorCell.addEditorCell(this.createRefNode1198490067105(context, node));
    return editorCell;
  }

  public EditorCell createCollection1198502445685(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createVertical(context, node);
    setupBasic_Collection_11985024456851198502445685(editorCell, node, context);
    editorCell.setGridLayout(true);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createComponent1214478832452(context, node));
    return editorCell;
  }

  public EditorCell createComponent1214478832452(EditorContext context, SNode node) {
    if (this.my_CellModel_Common0905_0 == null) {
      this.my_CellModel_Common0905_0 = new _CellModel_Common(node);
    }
    EditorCell editorCell = this.my_CellModel_Common0905_0.createEditorCell(context);
    setupBasic_component__CellModel_Common1214478832452(editorCell, node, context);
    return editorCell;
  }

  public EditorCell createIndentCell0905_0(EditorContext context, SNode node) {
    EditorCell_Indent result = new EditorCell_Indent(context, node);
    return result;
  }

  public EditorCell createRefNode1198490067105_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(null);
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_refNode_body1198490067105(editorCell, node, context);
    if (editorCell instanceof EditorCell_Label) {
      setupLabel_refNode_body_1198490067105((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell createRefNode1198490067105(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, context);
    provider.setRole("body");
    provider.setNoTargetText("<no body>");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createRefNode1198490067105_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }

  public EditorCell createRefNode1198490071435_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(null);
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_refNode_header1198490071435(editorCell, node, context);
    if (editorCell instanceof EditorCell_Label) {
      setupLabel_refNode_header_1198490071435((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell createRefNode1198490071435(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, context);
    provider.setRole("header");
    provider.setNoTargetText("<no header>");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createRefNode1198490071435_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }

  public EditorCell createProperty1198508746535_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(null);
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_property_openBrace1198508746535(editorCell, node, context);
    if (editorCell instanceof EditorCell_Label) {
      setupLabel_property_openBrace_1198508746535((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell createProperty1198508746535(EditorContext context, SNode node) {
    CellProviderWithRole provider = new PropertyCellProvider(node, context);
    provider.setRole("openBrace");
    provider.setNoTargetText("{");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(true);
    EditorCell cellWithRole = this.createProperty1198508746535_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }

  public EditorCell createProperty1198508750539_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(null);
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_property_closeBrace1198508750539(editorCell, node, context);
    if (editorCell instanceof EditorCell_Label) {
      setupLabel_property_closeBrace_1198508750539((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell createProperty1198508750539(EditorContext context, SNode node) {
    CellProviderWithRole provider = new PropertyCellProvider(node, context);
    provider.setRole("closeBrace");
    provider.setNoTargetText("}");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(true);
    EditorCell cellWithRole = this.createProperty1198508750539_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }


  private static void setupBasic_Collection_11984900191301198490019130(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Collection_1198490019130");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.DRAW_BORDER, true);
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Collection_11984900321951198490032195(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Collection_1198490032195");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, false);
          this.set(StyleAttributes.DRAW_BORDER, true);
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Collection_11984900358381198490035838(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Collection_1198490035838");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, false);
          this.set(StyleAttributes.DRAW_BORDER, true);
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Indent_11984900628061198490062806(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Indent_1198490062806");
  }

  private static void setupBasic_refNode_body1198490067105(EditorCell editorCell, SNode node, EditorContext context) {
  }

  private static void setupBasic_refNode_header1198490071435(EditorCell editorCell, SNode node, EditorContext context) {
  }

  private static void setupBasic_Collection_11985024456851198502445685(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Collection_1198502445685");
  }

  private static void setupBasic_property_openBrace1198508746535(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "property_openBrace");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.DRAW_BORDER, true);
          this.set(StyleAttributes.TEXT_COLOR, MPSColors.blue);
          this.set(StyleAttributes.NULL_TEXT_COLOR, MPSColors.blue);
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_property_closeBrace1198508750539(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "property_closeBrace");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.DRAW_BORDER, true);
          this.set(StyleAttributes.TEXT_COLOR, MPSColors.blue);
          this.set(StyleAttributes.NULL_TEXT_COLOR, MPSColors.blue);
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_component__CellModel_Common1214478832452(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "component__CellModel_Common");
  }

  private static void setupLabel_refNode_body_1198490067105(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_refNode_header_1198490071435(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_property_openBrace_1198508746535(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_property_closeBrace_1198508750539(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

}
