package webr.xml.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.EditorCell;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.nodeEditor.EditorCell_Label;
import java.awt.Color;
import jetbrains.mps.nodeEditor.EditorCell_Collection;
import jetbrains.mps.nodeEditor.EditorCell_Constant;
import jetbrains.mps.nodeEditor.cellProviders.CellProviderWithRole;
import jetbrains.mps.bootstrap.editorLanguage.cellProviders.RefCellCellProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;
import jetbrains.mps.bootstrap.editorLanguage.cellProviders.RefNodeCellProvider;
import jetbrains.mps.nodeEditor.AbstractCellProvider;
import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.nodeEditor.MPSFonts;
import jetbrains.mps.nodeEditor.style.AttributeCalculator;
import webr.xmlSchema.editor.XmlColorConstants;
import jetbrains.mps.bootstrap.editorLanguage.cellProviders.PropertyCellProvider;

public class Attribute_Editor extends DefaultNodeEditor {

  private static void setupBasic_CollectionCell15937_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_CollectionCell15937_0");
  }

  private static void setupBasic_ConstantCell15937_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_ConstantCell15937_0");
  }

  private static void setupBasic_attributeDeclarationRefCell15937_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_attributeDeclarationRefCell15937_0");
  }

  private static void setupBasic_ConstantCell15937_01(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_ConstantCell15937_01");
  }

  private static void setupBasic_ConstantCell15937_02(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_ConstantCell15937_02");
  }

  private static void setupBasic_valueRefNodeCell15937_0(EditorCell editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_ConstantCell15937_0(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_attributeDeclarationRefCell15937_0(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_ConstantCell15937_01(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_ConstantCell15937_02(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_valueRefNodeCell15937_0(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static Color calculateColor1(EditorCell cell) {
    Color result;
    result = Attribute_Editor._Inline._QueryFunction_Color_1214399678672((cell == null ?
      null :
      cell.getSNode()
    ), (cell == null ?
      null :
      cell.getEditorContext()
    ));
    return result;
  }


  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.create_CollectionCell15937_0(context, node);
  }

  public EditorCell create_CollectionCell15937_0(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    setupBasic_CollectionCell15937_0(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.create_attributeDeclarationRefCell15937_0(context, node));
    editorCell.addEditorCell(this.create_ConstantCell15937_0(context, node, "="));
    editorCell.addEditorCell(this.create_ConstantCell15937_01(context, node, "\""));
    editorCell.addEditorCell(this.create_valueRefNodeCell15937_0(context, node));
    editorCell.addEditorCell(this.create_ConstantCell15937_02(context, node, "\""));
    return editorCell;
  }

  public EditorCell create_ConstantCell15937_0(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_ConstantCell15937_0(editorCell, node, context);
    setupLabel_ConstantCell15937_0(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell create_ConstantCell15937_01(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_ConstantCell15937_01(editorCell, node, context);
    setupLabel_ConstantCell15937_01(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell create_ConstantCell15937_02(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_ConstantCell15937_02(editorCell, node, context);
    setupLabel_ConstantCell15937_02(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell create_attributeDeclarationRefCell15937_0_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(new Attribute_Editor._Inline());
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_attributeDeclarationRefCell15937_0(editorCell, node, context);
    if (editorCell instanceof EditorCell_Label) {
      setupLabel_attributeDeclarationRefCell15937_0((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell create_attributeDeclarationRefCell15937_0(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefCellCellProvider(node, context);
    provider.setRole("attributeDeclaration");
    provider.setNoTargetText("<no attributeDeclaration>");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.create_attributeDeclarationRefCell15937_0_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }

  public EditorCell create_valueRefNodeCell15937_0_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(null);
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_valueRefNodeCell15937_0(editorCell, node, context);
    if (editorCell instanceof EditorCell_Label) {
      setupLabel_valueRefNodeCell15937_0((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell create_valueRefNodeCell15937_0(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, context);
    provider.setRole("value");
    provider.setNoTargetText("<no value>");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.create_valueRefNodeCell15937_0_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }

  public static class _Inline extends AbstractCellProvider {

    public _Inline() {
      super();
    }

    private static void setupBasic_attributeNamePropertyCell15937_0(EditorCell editorCell, SNode node, EditorContext context) {
      editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_attributeNamePropertyCell15937_0");
      {
        Style inlineStyle = new Style(editorCell) {
          {
            this.set(StyleAttributes.FONT_STYLE, MPSFonts.BOLD_ITALIC);
            this.set(StyleAttributes.TEXT_COLOR, new AttributeCalculator <Color>() {

              public Color calculate(EditorCell cell) {
                return Attribute_Editor.calculateColor1(cell);
              }

            });
          }

        };
        inlineStyle.apply(editorCell);
      }
    }

    private static void setupLabel_attributeNamePropertyCell15937_0(EditorCell_Label editorCell, SNode node, EditorContext context) {
    }

    public static Color _QueryFunction_Color_1214399678672(SNode node, EditorContext editorContext) {
      return XmlColorConstants.XML_COLOR;
    }


    public EditorCell createEditorCell(EditorContext context) {
      return this.createEditorCell(context, this.getSNode());
    }

    public EditorCell createEditorCell(EditorContext context, SNode node) {
      return this.create_attributeNamePropertyCell15937_0(context, node);
    }

    public EditorCell create_attributeNamePropertyCell15937_0_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
      CellProviderWithRole provider = aProvider;
      provider.setAuxiliaryCellProvider(null);
      EditorCell editorCell = provider.createEditorCell(context);
      setupBasic_attributeNamePropertyCell15937_0(editorCell, node, context);
      if (editorCell instanceof EditorCell_Label) {
        setupLabel_attributeNamePropertyCell15937_0((EditorCell_Label)editorCell, node, context);
      }
      editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
      return editorCell;
    }

    public EditorCell create_attributeNamePropertyCell15937_0(EditorContext context, SNode node) {
      CellProviderWithRole provider = new PropertyCellProvider(node, context);
      provider.setRole("attributeName");
      provider.setNoTargetText("<no attributeName>");
      provider.setReadOnly(true);
      provider.setAllowsEmptyTarget(false);
      EditorCell cellWithRole = this.create_attributeNamePropertyCell15937_0_internal(context, node, provider);
      SNode attributeConcept = provider.getRoleAttribute();
      Class attributeKind = provider.getRoleAttributeClass();
      if (attributeConcept != null) {
        IOperationContext opContext = context.getOperationContext();
        EditorManager manager = EditorManager.getInstanceFromContext(opContext);
        return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
      } else
      return cellWithRole;
    }

}

}
