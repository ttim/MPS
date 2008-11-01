package jetbrains.mps.uiLanguage.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.cellProviders.AbstractCellListHandler;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import jetbrains.mps.nodeEditor.cells.EditorCell_Constant;
import jetbrains.mps.nodeEditor.cellLayout.CellLayout_Horizontal;
import jetbrains.mps.nodeEditor.cells.EditorCell_Indent;
import jetbrains.mps.nodeEditor.cellProviders.CellProviderWithRole;
import jetbrains.mps.nodeEditor.cells.EditorCell_Label;
import jetbrains.mps.lang.editor.cellProviders.RefNodeCellProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;
import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.lang.editor.cellProviders.RefNodeListHandler;
import jetbrains.mps.smodel.action.NodeFactoryManager;
import jetbrains.mps.nodeEditor.CellActionType;
import jetbrains.mps.nodeEditor.cellActions.CellAction_DeleteNode;
import jetbrains.mps.nodeEditor.cellMenu.DefaultReferenceSubstituteInfo;
import jetbrains.mps.nodeEditor.cellMenu.DefaultChildSubstituteInfo;

public class StandardDialog_Editor extends DefaultNodeEditor {

  /* package */AbstractCellListHandler myListHandler_1202832121933;

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createCollection1202830198645(context, node);
  }

  public EditorCell createCollection1202830198645(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createVertical(context, node);
    setupBasic_Collection_12028301986451202830198645(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createConstant1202830199694(context, node, "Dialog"));
    editorCell.addEditorCell(this.createCollection1202831750054(context, node));
    editorCell.addEditorCell(this.createCollection1202831768020(context, node));
    return editorCell;
  }

  public EditorCell createCollection1202831750054(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    setupBasic_Collection_12028317500541202831750054(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createIndentCell4953_0(context, node));
    editorCell.addEditorCell(this.createCollection1202831750055(context, node));
    return editorCell;
  }

  public EditorCell createCollection1202831750055(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createVertical(context, node);
    setupBasic_Collection_12028317500551202831750055(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createConstant1202831750056(context, node, "Content"));
    editorCell.addEditorCell(this.createCollection1202832118131(context, node));
    return editorCell;
  }

  public EditorCell createCollection1202831768020(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    setupBasic_Collection_12028317680201202831768020(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createIndentCell4953_1(context, node));
    editorCell.addEditorCell(this.createCollection1202831768021(context, node));
    return editorCell;
  }

  public EditorCell createCollection1202831768021(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createVertical(context, node);
    setupBasic_Collection_12028317680211202831768021(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createConstant1202831774447(context, node, "Buttons"));
    editorCell.addEditorCell(this.createCollection1202832121932(context, node));
    return editorCell;
  }

  public EditorCell createCollection1202832118131(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    setupBasic_Collection_12028321181311202832118131(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createIndentCell4953_2(context, node));
    editorCell.addEditorCell(this.createRefNode1202832118132(context, node));
    return editorCell;
  }

  public EditorCell createCollection1202832121932(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    setupBasic_Collection_12028321219321202832121932(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createIndentCell4953_3(context, node));
    editorCell.addEditorCell(this.createRefNodeList1202832121933(context, node));
    return editorCell;
  }

  public EditorCell createConstant1202830199694(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_12028301996941202830199694(editorCell, node, context);
    setupLabel_Constant_1202830199694_1202830199694(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant1202831750056(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_12028317500561202831750056(editorCell, node, context);
    setupLabel_Constant_1202831750056_1202831750056(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant1202831774447(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_12028317744471202831774447(editorCell, node, context);
    setupLabel_Constant_1202831774447_1202831774447(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createRefNodeList1202832121933(EditorContext context, SNode node) {
    if (this.myListHandler_1202832121933 == null) {
      this.myListHandler_1202832121933 = new StandardDialog_Editor.buttonListHandler_4953_0(node, "button", context);
    }
    EditorCell_Collection editorCell = this.myListHandler_1202832121933.createCells(context, new CellLayout_Horizontal(), false);
    setupBasic_refNodeList_button1202832121933(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.setRole(this.myListHandler_1202832121933.getElementRole());
    return editorCell;
  }

  public EditorCell createIndentCell4953_0(EditorContext context, SNode node) {
    EditorCell_Indent result = new EditorCell_Indent(context, node);
    return result;
  }

  public EditorCell createIndentCell4953_1(EditorContext context, SNode node) {
    EditorCell_Indent result = new EditorCell_Indent(context, node);
    return result;
  }

  public EditorCell createIndentCell4953_2(EditorContext context, SNode node) {
    EditorCell_Indent result = new EditorCell_Indent(context, node);
    return result;
  }

  public EditorCell createIndentCell4953_3(EditorContext context, SNode node) {
    EditorCell_Indent result = new EditorCell_Indent(context, node);
    return result;
  }

  public EditorCell createRefNode1202832118132_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(null);
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_refNode_rootComponent1202832118132(editorCell, node, context);
    if (editorCell instanceof EditorCell_Label) {
      setupLabel_refNode_rootComponent_1202832118132((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell createRefNode1202832118132(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, context);
    provider.setRole("rootComponent");
    provider.setNoTargetText("<no rootComponent>");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createRefNode1202832118132_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }


  private static void setupBasic_Collection_12028301986451202830198645(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Collection_1202830198645");
  }

  private static void setupBasic_Constant_12028301996941202830199694(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_1202830199694");
    Stylesheet_StyleSheet.getComponent(editorCell).apply(editorCell);
  }

  private static void setupBasic_Collection_12028317500541202831750054(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Collection_1202831750054");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, false);
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Collection_12028317500551202831750055(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Collection_1202831750055");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, false);
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Constant_12028317500561202831750056(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_1202831750056");
    Stylesheet_StyleSheet.getComponent(editorCell).apply(editorCell);
  }

  private static void setupBasic_Indent_12028317519491202831751949(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Indent_1202831751949");
  }

  private static void setupBasic_Collection_12028317680201202831768020(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Collection_1202831768020");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, false);
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Collection_12028317680211202831768021(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Collection_1202831768021");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, false);
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Indent_12028317711961202831771196(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Indent_1202831771196");
  }

  private static void setupBasic_Constant_12028317744471202831774447(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_1202831774447");
    Stylesheet_StyleSheet.getComponent(editorCell).apply(editorCell);
  }

  private static void setupBasic_Collection_12028321181311202832118131(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Collection_1202832118131");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, false);
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_refNode_rootComponent1202832118132(EditorCell editorCell, SNode node, EditorContext context) {
  }

  private static void setupBasic_Indent_12028321192751202832119275(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Indent_1202832119275");
  }

  private static void setupBasic_Collection_12028321219321202832121932(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Collection_1202832121932");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, false);
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_refNodeList_button1202832121933(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("refNodeList_button");
  }

  private static void setupBasic_Indent_12028321235291202832123529(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Indent_1202832123529");
  }

  private static void setupLabel_Constant_1202830199694_1202830199694(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_1202831750056_1202831750056(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_1202831774447_1202831774447(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_refNode_rootComponent_1202832118132(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_refNodeList_button_1202832121933(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  public static class buttonListHandler_4953_0 extends RefNodeListHandler {

    public buttonListHandler_4953_0(SNode ownerNode, String childRole, EditorContext context) {
      super(ownerNode, childRole, context, false);
    }

    public SNode createNodeToInsert(EditorContext context) {
      SNode listOwner = super.getOwner();
      return NodeFactoryManager.createNode(listOwner, context, super.getElementRole());
    }

    public EditorCell createNodeCell(EditorContext context, SNode elementNode) {
      EditorCell elementCell = super.createNodeCell(context, elementNode);
      this.installElementCellActions(this.getOwner(), elementNode, elementCell, context);
      return elementCell;
    }

    public EditorCell createEmptyCell(EditorContext context) {
      EditorCell emptyCell = null;
      emptyCell = super.createEmptyCell(context);
      this.installElementCellActions(super.getOwner(), null, emptyCell, context);
      return emptyCell;
    }

    public void installElementCellActions(SNode listOwner, SNode elementNode, EditorCell elementCell, EditorContext context) {
      if (elementCell.getUserObject(AbstractCellListHandler.ELEMENT_CELL_ACTIONS_SET) == null) {
        elementCell.putUserObject(AbstractCellListHandler.ELEMENT_CELL_ACTIONS_SET, AbstractCellListHandler.ELEMENT_CELL_ACTIONS_SET);
        SNode substituteInfoNode = listOwner;
        if (elementNode != null) {
          substituteInfoNode = elementNode;
          elementCell.setAction(CellActionType.DELETE, new CellAction_DeleteNode(elementNode));
        }
        if (elementCell.getSubstituteInfo() == null || elementCell.getSubstituteInfo() instanceof DefaultReferenceSubstituteInfo) {
          elementCell.setSubstituteInfo(new DefaultChildSubstituteInfo(listOwner, elementNode, super.getLinkDeclaration(), context));
        }
      }
    }

    public EditorCell createSeparatorCell(EditorContext context) {
      return super.createSeparatorCell(context);
    }

}

}
