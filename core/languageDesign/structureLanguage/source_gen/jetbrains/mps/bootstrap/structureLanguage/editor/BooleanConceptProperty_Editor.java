package jetbrains.mps.bootstrap.structureLanguage.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cellProviders.CellProviderWithRole;
import jetbrains.mps.nodeEditor.cells.EditorCell_Label;
import jetbrains.mps.bootstrap.editorLanguage.cellProviders.RefCellCellProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;
import jetbrains.mps.nodeEditor.MPSFonts;
import java.awt.Color;
import jetbrains.mps.nodeEditor.MPSColors;
import jetbrains.mps.nodeEditor.AbstractCellProvider;
import jetbrains.mps.bootstrap.editorLanguage.cellProviders.PropertyCellProvider;
import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.nodeEditor.style.AttributeCalculator;

public class BooleanConceptProperty_Editor extends DefaultNodeEditor {

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createRefCell1146699642295(context, node);
  }

  public EditorCell createRefCell1146699642295_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(new BooleanConceptProperty_Editor._Inline0119_0());
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_refCell_booleanConceptPropertyDeclaration1146699642295(editorCell, node, context);
    if (editorCell instanceof EditorCell_Label) {
      setupLabel_refCell_booleanConceptPropertyDeclaration_1146699642295((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell createRefCell1146699642295(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefCellCellProvider(node, context);
    provider.setRole("booleanConceptPropertyDeclaration");
    provider.setNoTargetText("<no property>");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createRefCell1146699642295_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }


  private static void setupBasic_refCell_booleanConceptPropertyDeclaration1146699642295(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "refCell_booleanConceptPropertyDeclaration");
  }

  private static void setupLabel_refCell_booleanConceptPropertyDeclaration_1146699642295(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static Integer calculateFontStyle0119_0(EditorCell cell) {
    int result;
    result = MPSFonts.BOLD;
    return result;
  }

  private static Color calculateColor0119_0(EditorCell cell) {
    Color result;
    result = MPSColors.DARK_MAGENTA;
    return result;
  }

  public static class _Inline0119_0 extends AbstractCellProvider {

    public _Inline0119_0() {
      super();
    }

    public EditorCell createEditorCell(EditorContext context) {
      return this.createEditorCell(context, this.getSNode());
    }

    public EditorCell createEditorCell(EditorContext context, SNode node) {
      return this.createProperty1146699642297(context, node);
    }

    public EditorCell createProperty1146699642297_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
      CellProviderWithRole provider = aProvider;
      provider.setAuxiliaryCellProvider(null);
      EditorCell editorCell = provider.createEditorCell(context);
      setupBasic_property_name1146699642297(editorCell, node, context);
      if (editorCell instanceof EditorCell_Label) {
        setupLabel_property_name_1146699642297((EditorCell_Label)editorCell, node, context);
      }
      editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
      return editorCell;
    }

    public EditorCell createProperty1146699642297(EditorContext context, SNode node) {
      CellProviderWithRole provider = new PropertyCellProvider(node, context);
      provider.setRole("name");
      provider.setNoTargetText("<no name>");
      provider.setReadOnly(true);
      provider.setAllowsEmptyTarget(false);
      EditorCell cellWithRole = this.createProperty1146699642297_internal(context, node, provider);
      SNode attributeConcept = provider.getRoleAttribute();
      Class attributeKind = provider.getRoleAttributeClass();
      if (attributeConcept != null) {
        IOperationContext opContext = context.getOperationContext();
        EditorManager manager = EditorManager.getInstanceFromContext(opContext);
        return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
      } else
      return cellWithRole;
    }


    private static void setupBasic_property_name1146699642297(EditorCell editorCell, SNode node, EditorContext context) {
      editorCell.putUserObject(EditorCell.CELL_ID, "property_name");
      {
        Style inlineStyle = new Style(editorCell) {
          {
            this.set(StyleAttributes.FONT_STYLE, new AttributeCalculator <Integer>() {

              public Integer calculate(EditorCell cell) {
                return BooleanConceptProperty_Editor.calculateFontStyle0119_0(cell);
              }

            });
            this.set(StyleAttributes.TEXT_COLOR, new AttributeCalculator <Color>() {

              public Color calculate(EditorCell cell) {
                return BooleanConceptProperty_Editor.calculateColor0119_0(cell);
              }

            });
          }

        };
        inlineStyle.apply(editorCell);
      }
    }

    private static void setupLabel_property_name_1146699642297(EditorCell_Label editorCell, SNode node, EditorContext context) {
    }

}

}
