package jetbrains.mps.baseLanguage.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.cellProviders.AbstractCellListHandler;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import jetbrains.mps.nodeEditor.cells.EditorCell_Constant;
import jetbrains.mps.nodeEditor.cellLayout.CellLayout_Indent;
import jetbrains.mps.nodeEditor.cellProviders.CellProviderWithRole;
import jetbrains.mps.nodeEditor.cells.EditorCell_Label;
import jetbrains.mps.lang.editor.cellProviders.RefNodeCellProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;
import jetbrains.mps.nodeEditor.FocusPolicy;
import jetbrains.mps.baseLanguage.editor.BaseLanguageStyle_StyleSheet;
import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.lang.editor.cellProviders.RefNodeListHandler;
import jetbrains.mps.smodel.action.NodeFactoryManager;
import jetbrains.mps.nodeEditor.CellActionType;
import jetbrains.mps.nodeEditor.cellActions.CellAction_DeleteNode;
import jetbrains.mps.lang.editor.cellProviders.RefNodeListHandlerElementKeyMap;
import jetbrains.mps.nodeEditor.cellMenu.DefaultReferenceSubstituteInfo;
import jetbrains.mps.nodeEditor.cellMenu.DefaultChildSubstituteInfo;

public class ArrayCreatorWithInitializer_Editor extends DefaultNodeEditor {

  /* package */AbstractCellListHandler myListHandler_0557_0;

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createCollection_0557_0(context, node);
  }

  public EditorCell createCollection_0557_0(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createIndent2(context, node);
    setupBasic_Collection_0557_0(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createRefNode_0557_1(context, node));
    editorCell.addEditorCell(this.createConstant_0557_0(context, node, "[]"));
    editorCell.addEditorCell(this.createConstant_0557_1(context, node, "{"));
    editorCell.addEditorCell(this.createRefNodeList_0557_0(context, node));
    editorCell.addEditorCell(this.createConstant_0557_2(context, node, "}"));
    return editorCell;
  }

  public EditorCell createConstant_0557_0(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_0557_0(editorCell, node, context);
    setupLabel_Constant_0557_0(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_0557_1(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_0557_1(editorCell, node, context);
    setupLabel_Constant_0557_1(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_0557_2(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_0557_2(editorCell, node, context);
    setupLabel_Constant_0557_2(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createRefNodeList_0557_0(EditorContext context, SNode node) {
    if (this.myListHandler_0557_0 == null) {
      this.myListHandler_0557_0 = new ArrayCreatorWithInitializer_Editor.initValueListHandler_0557_0(node, "initValue", context);
    }
    EditorCell_Collection editorCell = this.myListHandler_0557_0.createCells(context, new CellLayout_Indent(), false);
    setupBasic_RefNodeList_0557_0(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.setRole(this.myListHandler_0557_0.getElementRole());
    return editorCell;
  }

  public EditorCell createRefNode_0557_0_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(null);
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_RefNode_0557_0(editorCell, node, context);
    if (editorCell instanceof EditorCell_Label) {
      setupLabel_RefNode_0557_0((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell createRefNode_0557_1(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, context);
    provider.setRole("componentType");
    provider.setNoTargetText("<no componentType>");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createRefNode_0557_0_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }


  private static void setupBasic_Collection_0557_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Collection_0557_0");
  }

  private static void setupBasic_RefNode_0557_0(EditorCell editorCell, SNode node, EditorContext context) {
    if (true) {
      editorCell.setFocusPolicy(FocusPolicy.FIRST_EDITABLE_CELL);
    }
  }

  private static void setupBasic_Constant_0557_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_0557_0");
    BaseLanguageStyle_StyleSheet.getBracket(editorCell).apply(editorCell);
  }

  private static void setupBasic_Constant_0557_1(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_0557_1");
    BaseLanguageStyle_StyleSheet.getLeftBrace(editorCell).apply(editorCell);
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.PUNCTUATION_LEFT, true);
          this.set(StyleAttributes.PUNCTUATION_RIGTH, true);
        }
      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_RefNodeList_0557_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("refNodeList_initValue");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, false);
        }
      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Constant_0557_2(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_0557_2");
    BaseLanguageStyle_StyleSheet.getRightBrace(editorCell).apply(editorCell);
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.PUNCTUATION_LEFT, true);
        }
      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupLabel_RefNode_0557_0(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_0557_0(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_0557_1(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_RefNodeList_0557_0(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_0557_2(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  public static class initValueListHandler_0557_0 extends RefNodeListHandler {

    public initValueListHandler_0557_0(SNode ownerNode, String childRole, EditorContext context) {
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
      emptyCell = this.createEmptyCell_internal(context, this.getOwner());
      this.installElementCellActions(super.getOwner(), null, emptyCell, context);
      return emptyCell;
    }

    public EditorCell createEmptyCell_internal(EditorContext context, SNode node) {
      return this.createConstant_0557_3(context, node, "");
    }

    public void installElementCellActions(SNode listOwner, SNode elementNode, EditorCell elementCell, EditorContext context) {
      if (elementCell.getUserObject(AbstractCellListHandler.ELEMENT_CELL_ACTIONS_SET) == null) {
        elementCell.putUserObject(AbstractCellListHandler.ELEMENT_CELL_ACTIONS_SET, AbstractCellListHandler.ELEMENT_CELL_ACTIONS_SET);
        SNode substituteInfoNode = listOwner;
        if (elementNode != null) {
          substituteInfoNode = elementNode;
          elementCell.setAction(CellActionType.DELETE, new CellAction_DeleteNode(elementNode));
          elementCell.addKeyMap(new RefNodeListHandlerElementKeyMap(this, ","));
        }
        if (elementCell.getSubstituteInfo() == null || elementCell.getSubstituteInfo() instanceof DefaultReferenceSubstituteInfo) {
          elementCell.setSubstituteInfo(new DefaultChildSubstituteInfo(listOwner, elementNode, super.getLinkDeclaration(), context));
        }
      }
    }

    public EditorCell createSeparatorCell(EditorContext context) {
      {
        EditorCell_Constant editorCell = new EditorCell_Constant(context, this.getOwner(), ",");
        editorCell.setSelectable(false);
        editorCell.getStyle().set(StyleAttributes.LAYOUT_CONSTRAINT, "");
        editorCell.getStyle().set(StyleAttributes.PUNCTUATION_LEFT, true);
        return editorCell;
      }
    }

    public EditorCell createConstant_0557_3(EditorContext context, SNode node, String text) {
      EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
      setupBasic_Constant_0557_3(editorCell, node, context);
      setupLabel_Constant_0557_3(editorCell, node, context);
      editorCell.setDefaultText("");
      return editorCell;
    }


    private static void setupBasic_Constant_0557_3(EditorCell editorCell, SNode node, EditorContext context) {
      editorCell.setCellId("Constant_0557_3");
      {
        Style inlineStyle = new Style(editorCell) {
          {
            this.set(StyleAttributes.SELECTABLE, true);
            this.set(StyleAttributes.EDITABLE, true);
          }
        };
        inlineStyle.apply(editorCell);
      }
    }

    private static void setupLabel_Constant_0557_3(EditorCell_Label editorCell, SNode node, EditorContext context) {
    }

}

}
