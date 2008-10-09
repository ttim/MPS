package jetbrains.mps.baseLanguage.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.cellProviders.AbstractCellListHandler;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import jetbrains.mps.nodeEditor.cells.EditorCell_Constant;
import jetbrains.mps.nodeEditor.cellLayout.CellLayout_Horizontal;
import jetbrains.mps.nodeEditor.cellProviders.CellProviderWithRole;
import jetbrains.mps.nodeEditor.cells.EditorCell_Label;
import jetbrains.mps.lang.editor.cellProviders.RefNodeCellProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;
import jetbrains.mps.nodeEditor.FocusPolicy;
import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.nodeEditor.style.AttributeCalculator;
import jetbrains.mps.lang.editor.cellProviders.RefNodeListHandler;
import jetbrains.mps.smodel.action.NodeFactoryManager;
import jetbrains.mps.nodeEditor.CellActionType;
import jetbrains.mps.nodeEditor.cellActions.CellAction_DeleteNode;
import jetbrains.mps.lang.editor.cellProviders.RefNodeListHandlerElementKeyMap;
import jetbrains.mps.nodeEditor.cellMenu.DefaultReferenceSubstituteInfo;
import jetbrains.mps.nodeEditor.cellMenu.DefaultChildSubstituteInfo;

public class ArrayCreatorWithInitializer_Editor extends DefaultNodeEditor {

  /* package */AbstractCellListHandler myListHandler_1154543050632;

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createCollection1154543006078(context, node);
  }

  public EditorCell createCollection1154543006078(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    setupBasic_Collection_11545430060781154543006078(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createRefNode1154543009938(context, node));
    editorCell.addEditorCell(this.createConstant1154543021847(context, node, "[]"));
    editorCell.addEditorCell(this.createConstant1154543041458(context, node, "{"));
    editorCell.addEditorCell(this.createRefNodeList1154543050632(context, node));
    editorCell.addEditorCell(this.createConstant1154543071509(context, node, "}"));
    return editorCell;
  }

  public EditorCell createConstant1154543021847(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_11545430218471154543021847(editorCell, node, context);
    setupLabel_Constant_1154543021847_1154543021847(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant1154543041458(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_11545430414581154543041458(editorCell, node, context);
    setupLabel_Constant_1154543041458_1154543041458(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant1154543071509(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_11545430715091154543071509(editorCell, node, context);
    setupLabel_Constant_1154543071509_1154543071509(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createRefNodeList1154543050632(EditorContext context, SNode node) {
    if (this.myListHandler_1154543050632 == null) {
      this.myListHandler_1154543050632 = new ArrayCreatorWithInitializer_Editor.initValueListHandler_0557_0(node, "initValue", context);
    }
    EditorCell_Collection editorCell = this.myListHandler_1154543050632.createCells(context, new CellLayout_Horizontal(), false);
    setupBasic_refNodeList_initValue1154543050632(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.putUserObject(EditorCell.ROLE, this.myListHandler_1154543050632.getElementRole());
    return editorCell;
  }

  public EditorCell createRefNode1154543009938_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(null);
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_refNode_componentType1154543009938(editorCell, node, context);
    if (editorCell instanceof EditorCell_Label) {
      setupLabel_refNode_componentType_1154543009938((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell createRefNode1154543009938(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, context);
    provider.setRole("componentType");
    provider.setNoTargetText("<no componentType>");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createRefNode1154543009938_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }


  private static void setupBasic_Collection_11545430060781154543006078(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Collection_1154543006078");
  }

  private static void setupBasic_refNode_componentType1154543009938(EditorCell editorCell, SNode node, EditorContext context) {
    if (true) {
      editorCell.setFocusPolicy(FocusPolicy.FIRST_EDITABLE_CELL);
    }
  }

  private static void setupBasic_Constant_11545430218471154543021847(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Constant_1154543021847");
    BaseLanguageStyle_StyleSheet.getBracket(editorCell).apply(editorCell);
  }

  private static void setupBasic_Constant_11545430414581154543041458(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Constant_1154543041458");
    BaseLanguageStyle_StyleSheet.getLeftBrace(editorCell).apply(editorCell);
  }

  private static void setupBasic_refNodeList_initValue1154543050632(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "refNodeList_initValue");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, new AttributeCalculator <Boolean>() {

            public Boolean calculate(EditorCell cell) {
              return ArrayCreatorWithInitializer_Editor.calculateBoolean0557_1(cell);
            }

          });
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Constant_11545430715091154543071509(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Constant_1154543071509");
    BaseLanguageStyle_StyleSheet.getRightBrace(editorCell).apply(editorCell);
  }

  private static void setupLabel_refNode_componentType_1154543009938(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_1154543021847_1154543021847(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_1154543041458_1154543041458(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_refNodeList_initValue_1154543050632(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_1154543071509_1154543071509(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  public static Boolean calculateBoolean0557_0(EditorCell cell) {
    boolean result;
    result = true;
    return result;
  }

  public static Boolean calculateBoolean0557_1(EditorCell cell) {
    boolean result;
    result = false;
    return result;
  }

  public static Boolean calculateBoolean0557_2(EditorCell cell) {
    boolean result;
    result = true;
    return result;
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
      return this.createConstant1154543473706(context, node, "");
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
        return editorCell;
      }
    }

    public EditorCell createConstant1154543473706(EditorContext context, SNode node, String text) {
      EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
      setupBasic_Constant_11545434737061154543473706(editorCell, node, context);
      setupLabel_Constant_1154543473706_1154543473706(editorCell, node, context);
      editorCell.setDefaultText("");
      return editorCell;
    }


    private static void setupBasic_Constant_11545434737061154543473706(EditorCell editorCell, SNode node, EditorContext context) {
      editorCell.putUserObject(EditorCell.CELL_ID, "Constant_1154543473706");
      {
        Style inlineStyle = new Style(editorCell) {
          {
            this.set(StyleAttributes.SELECTABLE, new AttributeCalculator <Boolean>() {

              public Boolean calculate(EditorCell cell) {
                return ArrayCreatorWithInitializer_Editor.calculateBoolean0557_0(cell);
              }

            });
            this.set(StyleAttributes.EDITABLE, new AttributeCalculator <Boolean>() {

              public Boolean calculate(EditorCell cell) {
                return ArrayCreatorWithInitializer_Editor.calculateBoolean0557_2(cell);
              }

            });
          }

        };
        inlineStyle.apply(editorCell);
      }
    }

    private static void setupLabel_Constant_1154543473706_1154543473706(EditorCell_Label editorCell, SNode node, EditorContext context) {
    }

}

}
