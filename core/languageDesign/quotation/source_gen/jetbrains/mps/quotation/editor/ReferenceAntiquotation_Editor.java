package jetbrains.mps.quotation.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import jetbrains.mps.nodeEditor.cells.EditorCell_Constant;
import jetbrains.mps.nodeEditor.cells.ModelAccessor;
import jetbrains.mps.nodeEditor.cells.EditorCell_Property;
import jetbrains.mps.nodeEditor.CellActionType;
import jetbrains.mps.nodeEditor.cellActions.CellAction_Empty;
import jetbrains.mps.smodel.AttributesRolesUtil;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.nodeEditor.cellProviders.CellProviderWithRole;
import jetbrains.mps.nodeEditor.cells.EditorCell_Label;
import jetbrains.mps.lang.editor.cellProviders.RefNodeCellProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;
import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.nodeEditor.style.AttributeCalculator;
import java.awt.Color;

public class ReferenceAntiquotation_Editor extends DefaultNodeEditor {

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createCollection1196350915674(context, node);
  }

  public EditorCell createInspectedCell(EditorContext context, SNode node) {
    return this.createCollection1196350915686(context, node);
  }

  public EditorCell createCollection1196350915674(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    setupBasic_Collection_11963509156741196350915674(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createConstant1196350915675(context, node, "^("));
    editorCell.addEditorCell(this.createRefNode1196350915680(context, node));
    editorCell.addEditorCell(this.createConstant1196350915681(context, node, ")^"));
    return editorCell;
  }

  public EditorCell createCollection1196350915686(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createVertical(context, node);
    setupBasic_Collection_11963509156861196350915686(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createCollection1196350915687(context, node));
    editorCell.addEditorCell(this.createConstant1196350915689(context, node, ""));
    editorCell.addEditorCell(this.createCollection1196350915690(context, node));
    editorCell.addEditorCell(this.createCollection1196350915707(context, node));
    return editorCell;
  }

  public EditorCell createCollection1196350915687(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    setupBasic_Collection_11963509156871196350915687(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createConstant1196350915688(context, node, "reference antiquotation"));
    return editorCell;
  }

  public EditorCell createCollection1196350915690(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    setupBasic_Collection_11963509156901196350915690(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createConstant1196350915691(context, node, "reference role:"));
    editorCell.addEditorCell(this.createModelAccess1196350915692(context, node));
    return editorCell;
  }

  public EditorCell createCollection1196350915707(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    setupBasic_Collection_11963509157071196350915707(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createConstant1196350915708(context, node, "source concept:"));
    editorCell.addEditorCell(this.createModelAccess1196350915709(context, node));
    return editorCell;
  }

  public EditorCell createConstant1196350915675(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_11963509156751196350915675(editorCell, node, context);
    setupLabel_Constant_1196350915675_1196350915675(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant1196350915681(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_11963509156811196350915681(editorCell, node, context);
    setupLabel_Constant_1196350915681_1196350915681(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant1196350915688(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_11963509156881196350915688(editorCell, node, context);
    setupLabel_Constant_1196350915688_1196350915688(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant1196350915689(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_11963509156891196350915689(editorCell, node, context);
    setupLabel_Constant_1196350915689_1196350915689(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant1196350915691(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_11963509156911196350915691(editorCell, node, context);
    setupLabel_Constant_1196350915691_1196350915691(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant1196350915708(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_11963509157081196350915708(editorCell, node, context);
    setupLabel_Constant_1196350915708_1196350915708(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createModelAccess1196350915692(EditorContext context, SNode node) {
    ModelAccessor modelAccessor = this._modelAcessorFactory_1196350915692(context, node);
    EditorCell_Property editorCell = EditorCell_Property.create(context, modelAccessor, node);
    editorCell.setAction(CellActionType.DELETE, new CellAction_Empty());
    setupBasic_ModelAccess_11963509156921196350915692(editorCell, node, context);
    setupLabel_ModelAccess_1196350915692_1196350915692(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public ModelAccessor _modelAcessorFactory_1196350915692(final EditorContext editorContext, final SNode node) {
    return new ModelAccessor() {

      public String getText() {
        return AttributesRolesUtil.getLinkRoleFromLinkAttributeRole(node.getRole_());
      }

      public void setText(String text) {
      }

      public boolean isValidText(String text) {
        return true;
      }

    };
  }

  public EditorCell createModelAccess1196350915709(EditorContext context, SNode node) {
    ModelAccessor modelAccessor = this._modelAcessorFactory_1196350915709(context, node);
    EditorCell_Property editorCell = EditorCell_Property.create(context, modelAccessor, node);
    editorCell.setAction(CellActionType.DELETE, new CellAction_Empty());
    setupBasic_ModelAccess_11963509157091196350915709(editorCell, node, context);
    setupLabel_ModelAccess_1196350915709_1196350915709(editorCell, node, context);
    editorCell.setDefaultText("<no concept>");
    return editorCell;
  }

  public ModelAccessor _modelAcessorFactory_1196350915709(final EditorContext editorContext, final SNode node) {
    return new ModelAccessor() {

      public String getText() {
        SNode parent = SNodeOperations.getParent(node);
        if ((parent != null)) {
          return SPropertyOperations.getString(SNodeOperations.getConceptDeclaration(parent), "name");
        } else
        {
          return "";
        }
      }

      public void setText(String text) {
      }

      public boolean isValidText(String text) {
        return true;
      }

    };
  }

  public EditorCell createRefNode1196350915680_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(null);
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_refNode_expression1196350915680(editorCell, node, context);
    if (editorCell instanceof EditorCell_Label) {
      setupLabel_refNode_expression_1196350915680((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell createRefNode1196350915680(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, context);
    provider.setRole("expression");
    provider.setNoTargetText("<expr>");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createRefNode1196350915680_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }


  private static void setupBasic_Collection_11963509156741196350915674(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Collection_1196350915674");
  }

  private static void setupBasic_Constant_11963509156751196350915675(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Constant_1196350915675");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.TEXT_COLOR, new AttributeCalculator <Color>() {

            public Color calculate(EditorCell cell) {
              return ReferenceAntiquotation_Editor.calculateColor6627_1(cell);
            }

          });
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_refNode_expression1196350915680(EditorCell editorCell, SNode node, EditorContext context) {
  }

  private static void setupBasic_Constant_11963509156811196350915681(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Constant_1196350915681");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.TEXT_COLOR, new AttributeCalculator <Color>() {

            public Color calculate(EditorCell cell) {
              return ReferenceAntiquotation_Editor.calculateColor6627_0(cell);
            }

          });
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Collection_11963509156861196350915686(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Collection_1196350915686");
  }

  private static void setupBasic_Collection_11963509156871196350915687(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Collection_1196350915687");
  }

  private static void setupBasic_Constant_11963509156881196350915688(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Constant_1196350915688");
  }

  private static void setupBasic_Constant_11963509156891196350915689(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Constant_1196350915689");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, false);
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Collection_11963509156901196350915690(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Collection_1196350915690");
  }

  private static void setupBasic_Constant_11963509156911196350915691(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Constant_1196350915691");
  }

  private static void setupBasic_ModelAccess_11963509156921196350915692(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "ModelAccess_1196350915692");
  }

  private static void setupBasic_Collection_11963509157071196350915707(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Collection_1196350915707");
  }

  private static void setupBasic_Constant_11963509157081196350915708(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Constant_1196350915708");
  }

  private static void setupBasic_ModelAccess_11963509157091196350915709(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "ModelAccess_1196350915709");
  }

  private static void setupLabel_Constant_1196350915675_1196350915675(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_refNode_expression_1196350915680(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_1196350915681_1196350915681(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_1196350915688_1196350915688(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_1196350915689_1196350915689(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_1196350915691_1196350915691(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_ModelAccess_1196350915692_1196350915692(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_1196350915708_1196350915708(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_ModelAccess_1196350915709_1196350915709(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  public static Color _StyleParameter_QueryFunction_1214399678256(SNode node, EditorContext editorContext) {
    return Colors.BROWN;
  }

  public static Color _StyleParameter_QueryFunction_1214399678855(SNode node, EditorContext editorContext) {
    return Colors.BROWN;
  }

  private static Color calculateColor6627_0(EditorCell cell) {
    Color result;
    result = ReferenceAntiquotation_Editor._StyleParameter_QueryFunction_1214399678256((cell == null ?
      null :
      cell.getSNode()
    ), (cell == null ?
      null :
      cell.getEditorContext()
    ));
    return result;
  }

  private static Color calculateColor6627_1(EditorCell cell) {
    Color result;
    result = ReferenceAntiquotation_Editor._StyleParameter_QueryFunction_1214399678855((cell == null ?
      null :
      cell.getSNode()
    ), (cell == null ?
      null :
      cell.getEditorContext()
    ));
    return result;
  }

}
