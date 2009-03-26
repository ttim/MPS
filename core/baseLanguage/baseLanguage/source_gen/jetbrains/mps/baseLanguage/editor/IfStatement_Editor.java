package jetbrains.mps.baseLanguage.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.cellProviders.AbstractCellListHandler;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import jetbrains.mps.nodeEditor.cells.EditorCell_Constant;
import jetbrains.mps.nodeEditor.cellMenu.CompositeSubstituteInfo;
import jetbrains.mps.nodeEditor.cellMenu.BasicCellContext;
import jetbrains.mps.nodeEditor.cellMenu.SubstituteInfoPart;
import jetbrains.mps.nodeEditor.cellLayout.CellLayout_Indent;
import jetbrains.mps.nodeEditor.cellProviders.CellProviderWithRole;
import jetbrains.mps.nodeEditor.cells.EditorCell_Label;
import jetbrains.mps.lang.editor.cellProviders.RefNodeCellProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;
import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.baseLanguage.editor.BaseLanguageStyle_StyleSheet;
import jetbrains.mps.nodeEditor.style.AttributeCalculator;
import jetbrains.mps.baseLanguage.editor.IfStatement_LastBrace;
import jetbrains.mps.baseLanguage.editor.IfStatement_elseDelete_action;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.baseLanguage.behavior.IfStatement_Behavior;
import jetbrains.mps.lang.editor.cellProviders.RefNodeListHandler;
import jetbrains.mps.smodel.action.NodeFactoryManager;
import jetbrains.mps.nodeEditor.CellActionType;
import jetbrains.mps.nodeEditor.cellActions.CellAction_DeleteNode;
import jetbrains.mps.nodeEditor.cellMenu.DefaultReferenceSubstituteInfo;
import jetbrains.mps.nodeEditor.cellMenu.DefaultChildSubstituteInfo;
import jetbrains.mps.lang.editor.generator.internal.AbstractCellMenuPart_Generic_Item;
import jetbrains.mps.smodel.SModel;

public class IfStatement_Editor extends DefaultNodeEditor {

  /* package */AbstractCellListHandler myListHandler_1754_0;

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createCollection_1754_0(context, node);
  }

  public EditorCell createCollection_1754_0(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createIndent2(context, node);
    setupBasic_Collection_1754_0(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createConstant_1754_0(context, node, "if"));
    editorCell.addEditorCell(this.createConstant_1754_1(context, node, "("));
    editorCell.addEditorCell(this.createRefNode_1754_1(context, node));
    editorCell.addEditorCell(this.createConstant_1754_2(context, node, ")"));
    editorCell.addEditorCell(this.createCollection_1754_3(context, node));
    if (renderingCondition1754_0(node, context, context.getOperationContext().getScope())) {
      editorCell.addEditorCell(this.createRefNodeList_1754_0(context, node));
    }
    if (renderingCondition1754_1(node, context, context.getOperationContext().getScope())) {
      editorCell.addEditorCell(this.createCollection_1754_1(context, node));
    }
    return editorCell;
  }

  public EditorCell createCollection_1754_1(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createIndent2(context, node);
    setupBasic_Collection_1754_1(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createConstant_1754_5(context, node, "else"));
    editorCell.addEditorCell(this.createRefNode_1754_3(context, node));
    return editorCell;
  }

  public EditorCell createCollection_1754_2(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createIndent2(context, node);
    setupBasic_Collection_1754_2(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createRefNode_1754_5(context, node));
    return editorCell;
  }

  public EditorCell createCollection_1754_3(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createIndent2(context, node);
    setupBasic_Collection_1754_3(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createConstant_1754_3(context, node, "{"));
    editorCell.addEditorCell(this.createCollection_1754_2(context, node));
    editorCell.addEditorCell(this.createConstant_1754_4(context, node, "}"));
    return editorCell;
  }

  public EditorCell createConstant_1754_0(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_1754_0(editorCell, node, context);
    setupLabel_Constant_1754_0(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_1754_1(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_1754_1(editorCell, node, context);
    setupLabel_Constant_1754_1(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_1754_2(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_1754_2(editorCell, node, context);
    setupLabel_Constant_1754_2(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_1754_3(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_1754_3(editorCell, node, context);
    setupLabel_Constant_1754_3(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_1754_4(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_1754_4(editorCell, node, context);
    setupLabel_Constant_1754_4(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_1754_5(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_1754_5(editorCell, node, context);
    setupLabel_Constant_1754_5(editorCell, node, context);
    editorCell.setDefaultText("");
    editorCell.setSubstituteInfo(new CompositeSubstituteInfo(context, new BasicCellContext(node), new SubstituteInfoPart[]{new IfStatement_Editor.IfStatement_generic_cellMenu0(),new IfStatement_Editor.IfStatement_generic_cellMenu1()}));
    return editorCell;
  }

  public EditorCell createRefNodeList_1754_0(EditorContext context, SNode node) {
    if (this.myListHandler_1754_0 == null) {
      this.myListHandler_1754_0 = new IfStatement_Editor.elsifClausesListHandler_1754_0(node, "elsifClauses", context);
    }
    EditorCell_Collection editorCell = this.myListHandler_1754_0.createCells(context, new CellLayout_Indent(), false);
    setupBasic_RefNodeList_1754_0(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.setRole(this.myListHandler_1754_0.getElementRole());
    return editorCell;
  }

  public EditorCell createRefNode_1754_0_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(null);
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_RefNode_1754_0(editorCell, node, context);
    if (editorCell instanceof EditorCell_Label) {
      setupLabel_RefNode_1754_0((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell createRefNode_1754_1(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, context);
    provider.setRole("condition");
    provider.setNoTargetText("<no condition>");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createRefNode_1754_0_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }

  public EditorCell createRefNode_1754_2_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(null);
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_RefNode_1754_1(editorCell, node, context);
    if (editorCell instanceof EditorCell_Label) {
      setupLabel_RefNode_1754_1((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell createRefNode_1754_3(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, context);
    provider.setRole("ifFalseStatement");
    provider.setNoTargetText("<no ifFalseStatement>");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createRefNode_1754_2_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }

  public EditorCell createRefNode_1754_4_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(null);
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_RefNode_1754_2(editorCell, node, context);
    if (editorCell instanceof EditorCell_Label) {
      setupLabel_RefNode_1754_2((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell createRefNode_1754_5(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, context);
    provider.setRole("ifTrue");
    provider.setNoTargetText("<no ifTrue>");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createRefNode_1754_4_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }


  private static void setupBasic_Collection_1754_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Collection_1754_0");
  }

  private static void setupBasic_Collection_1754_1(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Collection_1754_1");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, false);
        }
      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_RefNodeList_1754_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("refNodeList_elsifClauses");
  }

  private static void setupBasic_Constant_1754_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_1754_0");
    BaseLanguageStyle_StyleSheet.getKeyWord(editorCell).apply(editorCell);
  }

  private static void setupBasic_Constant_1754_1(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_1754_1");
    BaseLanguageStyle_StyleSheet.getLeftParen(editorCell).apply(editorCell);
  }

  private static void setupBasic_RefNode_1754_0(EditorCell editorCell, SNode node, EditorContext context) {
  }

  private static void setupBasic_Constant_1754_2(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_1754_2");
    BaseLanguageStyle_StyleSheet.getRightParen(editorCell).apply(editorCell);
  }

  private static void setupBasic_Constant_1754_3(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_1754_3");
    BaseLanguageStyle_StyleSheet.getLeftBlockBrace(editorCell).apply(editorCell);
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.INDENT_LAYOUT_NEW_LINE, new AttributeCalculator <Boolean>() {

            public Boolean calculate(EditorCell cell) {
              return IfStatement_Editor._StyleParameter_QueryFunction_1237573132288((cell == null ?
                null :
                cell.getSNode()
              ), (cell == null ?
                null :
                cell.getEditorContext()
              ));
            }
          });
        }
      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Constant_1754_4(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_1754_4");
    BaseLanguageStyle_StyleSheet.getRightBlockBrace(editorCell).apply(editorCell);
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, true);
          this.set(StyleAttributes.RT_ANCHOR_TAG, "ext_1_RTransform");
        }
      };
      inlineStyle.apply(editorCell);
    }
    IfStatement_LastBrace.setCellActions(editorCell, node, context);
  }

  private static void setupBasic_Constant_1754_5(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_1754_5");
    BaseLanguageStyle_StyleSheet.getKeyWord(editorCell).apply(editorCell);
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.EDITABLE, true);
        }
      };
      inlineStyle.apply(editorCell);
    }
    IfStatement_elseDelete_action.setCellActions(editorCell, node, context);
  }

  private static void setupBasic_RefNode_1754_1(EditorCell editorCell, SNode node, EditorContext context) {
  }

  private static void setupBasic_Collection_1754_2(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Collection_1754_2");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, false);
          this.set(StyleAttributes.INDENT_LAYOUT_NEW_LINE, new AttributeCalculator <Boolean>() {

            public Boolean calculate(EditorCell cell) {
              return IfStatement_Editor._StyleParameter_QueryFunction_1237575954793((cell == null ?
                null :
                cell.getSNode()
              ), (cell == null ?
                null :
                cell.getEditorContext()
              ));
            }
          });
          this.set(StyleAttributes.INDENT_LAYOUT_INDENT, new AttributeCalculator <Boolean>() {

            public Boolean calculate(EditorCell cell) {
              return IfStatement_Editor._StyleParameter_QueryFunction_1237575954801((cell == null ?
                null :
                cell.getSNode()
              ), (cell == null ?
                null :
                cell.getEditorContext()
              ));
            }
          });
        }
      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_RefNode_1754_2(EditorCell editorCell, SNode node, EditorContext context) {
  }

  private static void setupBasic_Collection_1754_3(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Collection_1754_3");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, false);
          this.set(StyleAttributes.SELECTABLE, false);
        }
      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupLabel_RefNodeList_1754_0(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_1754_0(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_1754_1(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_RefNode_1754_0(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_1754_2(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_1754_3(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_1754_4(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_1754_5(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_RefNode_1754_1(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_RefNode_1754_2(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  public static boolean renderingCondition1754_0(SNode node, EditorContext editorContext, IScope scope) {
    return ListSequence.fromList(SLinkOperations.getTargets(node, "elsifClauses", true)).isNotEmpty();
  }

  public static boolean renderingCondition1754_1(SNode node, EditorContext editorContext, IScope scope) {
    return (SLinkOperations.getTarget(node, "ifFalseStatement", true) != null);
  }

  public static boolean _StyleParameter_QueryFunction_1237573132288(SNode node, EditorContext editorContext) {
    return !(IfStatement_Behavior.call_isGuardIf_1237547453258(node));
  }

  public static boolean _StyleParameter_QueryFunction_1237575954793(SNode node, EditorContext editorContext) {
    return !(IfStatement_Behavior.call_isGuardIf_1237547453258(node));
  }

  public static boolean _StyleParameter_QueryFunction_1237575954801(SNode node, EditorContext editorContext) {
    return !(IfStatement_Behavior.call_isGuardIf_1237547453258(node));
  }

  public static class elsifClausesListHandler_1754_0 extends RefNodeListHandler {

    public elsifClausesListHandler_1754_0(SNode ownerNode, String childRole, EditorContext context) {
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
  public static class IfStatement_generic_cellMenu0 extends AbstractCellMenuPart_Generic_Item {

    public IfStatement_generic_cellMenu0() {
    }

    public void handleAction(SNode node, SModel model, IScope scope, IOperationContext operationContext) {
    }

    public String getMatchingText() {
      return "else";
    }

}
  public static class IfStatement_generic_cellMenu1 extends AbstractCellMenuPart_Generic_Item {

    public IfStatement_generic_cellMenu1() {
    }

    public void handleAction(SNode node, SModel model, IScope scope, IOperationContext operationContext) {
      IfStatement_Behavior.call_convertElseToElseIf_1217845914183(node);
    }

    public String getMatchingText() {
      return "else if";
    }

}

}
