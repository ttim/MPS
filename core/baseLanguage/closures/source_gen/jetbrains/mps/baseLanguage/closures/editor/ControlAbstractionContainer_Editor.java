package jetbrains.mps.baseLanguage.closures.editor;

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
import jetbrains.mps.lang.editor.cellProviders.PropertyCellProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;
import jetbrains.mps.lang.editor.cellProviders.RefNodeCellProvider;
import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.baseLanguage.editor.BaseLanguageStyle_StyleSheet;
import jetbrains.mps.nodeEditor.style.Padding;
import jetbrains.mps.nodeEditor.style.Measure;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.editor.cellProviders.RefNodeListHandler;
import jetbrains.mps.smodel.action.NodeFactoryManager;
import jetbrains.mps.nodeEditor.CellActionType;
import jetbrains.mps.nodeEditor.cellActions.CellAction_DeleteNode;
import jetbrains.mps.nodeEditor.cellMenu.DefaultReferenceSubstituteInfo;
import jetbrains.mps.nodeEditor.cellMenu.DefaultChildSubstituteInfo;
import jetbrains.mps.lang.editor.cellProviders.RefNodeListHandlerElementKeyMap;

public class ControlAbstractionContainer_Editor extends DefaultNodeEditor {

  /* package */AbstractCellListHandler myListHandler_0500_0;
  /* package */AbstractCellListHandler myListHandler_0500_1;
  /* package */AbstractCellListHandler myListHandler_0500_2;

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createCollection_0500_0(context, node);
  }

  public EditorCell createCollection_0500_0(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createIndent2(context, node);
    setupBasic_Collection_0500_0(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    if (renderingCondition0500_0(node, context, context.getOperationContext().getScope())) {
      editorCell.addEditorCell(this.createCollection_0500_1(context, node));
    }
    editorCell.addEditorCell(this.createRefNode_0500_1(context, node));
    if (renderingCondition0500_1(node, context, context.getOperationContext().getScope())) {
      editorCell.addEditorCell(this.createConstant_0500_0(context, node, "static"));
    }
    editorCell.addEditorCell(this.createConstant_0500_1(context, node, "container"));
    editorCell.addEditorCell(this.createConstant_0500_2(context, node, " "));
    editorCell.addEditorCell(this.createProperty_0500_1(context, node));
    if (renderingCondition0500_2(node, context, context.getOperationContext().getScope())) {
      editorCell.addEditorCell(this.createCollection_0500_2(context, node));
    }
    editorCell.addEditorCell(this.createConstant_0500_3(context, node, "{"));
    editorCell.addEditorCell(this.createConstant_0500_8(context, node, ""));
    editorCell.addEditorCell(this.createRefNodeList_0500_2(context, node));
    editorCell.addEditorCell(this.createConstant_0500_7(context, node, "}"));
    return editorCell;
  }

  public EditorCell createCollection_0500_1(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createIndent2(context, node);
    setupBasic_Collection_0500_1(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createRefNodeList_0500_0(context, node));
    return editorCell;
  }

  public EditorCell createCollection_0500_2(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createIndent2(context, node);
    setupBasic_Collection_0500_2(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createConstant_0500_4(context, node, "<"));
    editorCell.addEditorCell(this.createRefNodeList_0500_1(context, node));
    editorCell.addEditorCell(this.createConstant_0500_5(context, node, ">"));
    return editorCell;
  }

  public EditorCell createConstant_0500_0(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_0500_0(editorCell, node, context);
    setupLabel_Constant_0500_0(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_0500_1(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_0500_1(editorCell, node, context);
    setupLabel_Constant_0500_1(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_0500_2(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_0500_2(editorCell, node, context);
    setupLabel_Constant_0500_2(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_0500_3(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_0500_3(editorCell, node, context);
    setupLabel_Constant_0500_3(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_0500_4(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_0500_4(editorCell, node, context);
    setupLabel_Constant_0500_4(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_0500_5(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_0500_5(editorCell, node, context);
    setupLabel_Constant_0500_5(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_0500_7(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_0500_7(editorCell, node, context);
    setupLabel_Constant_0500_7(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_0500_8(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_0500_8(editorCell, node, context);
    setupLabel_Constant_0500_8(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createRefNodeList_0500_0(EditorContext context, SNode node) {
    if (this.myListHandler_0500_0 == null) {
      this.myListHandler_0500_0 = new ControlAbstractionContainer_Editor.annotationListHandler_0500_0(node, "annotation", context);
    }
    EditorCell_Collection editorCell = this.myListHandler_0500_0.createCells(context, new CellLayout_Indent(), false);
    setupBasic_RefNodeList_0500_0(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.setRole(this.myListHandler_0500_0.getElementRole());
    return editorCell;
  }

  public EditorCell createRefNodeList_0500_1(EditorContext context, SNode node) {
    if (this.myListHandler_0500_1 == null) {
      this.myListHandler_0500_1 = new ControlAbstractionContainer_Editor.typeVariableDeclarationListHandler_0500_0(node, "typeVariableDeclaration", context);
    }
    EditorCell_Collection editorCell = this.myListHandler_0500_1.createCells(context, new CellLayout_Indent(), false);
    setupBasic_RefNodeList_0500_1(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.setRole(this.myListHandler_0500_1.getElementRole());
    return editorCell;
  }

  public EditorCell createRefNodeList_0500_2(EditorContext context, SNode node) {
    if (this.myListHandler_0500_2 == null) {
      this.myListHandler_0500_2 = new ControlAbstractionContainer_Editor.controlAbstractionListHandler_0500_0(node, "controlAbstraction", context);
    }
    EditorCell_Collection editorCell = this.myListHandler_0500_2.createCells(context, new CellLayout_Indent(), false);
    setupBasic_RefNodeList_0500_2(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.setRole(this.myListHandler_0500_2.getElementRole());
    return editorCell;
  }

  public EditorCell createProperty_0500_0_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(null);
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_Property_0500_0(editorCell, node, context);
    if (editorCell instanceof EditorCell_Label) {
      setupLabel_Property_0500_0((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell createProperty_0500_1(EditorContext context, SNode node) {
    CellProviderWithRole provider = new PropertyCellProvider(node, context);
    provider.setRole("name");
    provider.setNoTargetText("<no name>");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createProperty_0500_0_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }

  public EditorCell createRefNode_0500_0_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(null);
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_RefNode_0500_0(editorCell, node, context);
    if (editorCell instanceof EditorCell_Label) {
      setupLabel_RefNode_0500_0((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell createRefNode_0500_1(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, context);
    provider.setRole("visibility");
    provider.setNoTargetText("<no visibility>");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createRefNode_0500_0_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }


  private static void setupBasic_Collection_0500_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Collection_0500_0");
  }

  private static void setupBasic_Collection_0500_1(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Collection_0500_1");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, false);
          this.set(StyleAttributes.INDENT_LAYOUT_NEW_LINE, true);
        }
      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_RefNodeList_0500_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("refNodeList_annotation");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.POSITION_CHILDREN, "next-line");
          this.set(StyleAttributes.INDENT_LAYOUT_NEW_LINE, true);
          this.set(StyleAttributes.INDENT_LAYOUT_NEW_LINE, false);
        }
      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Constant_0500_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_0500_0");
    BaseLanguageStyle_StyleSheet.getKeyWord(editorCell).apply(editorCell);
  }

  private static void setupBasic_Constant_0500_1(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_0500_1");
    BaseLanguageStyle_StyleSheet.getKeyWord(editorCell).apply(editorCell);
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.PADDING_RIGHT, new Padding(0.0, Measure.SPACES));
        }
      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Constant_0500_2(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_0500_2");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, false);
          this.set(StyleAttributes.PADDING_LEFT, new Padding(0.0, Measure.SPACES));
          this.set(StyleAttributes.PADDING_RIGHT, new Padding(0.0, Measure.SPACES));
        }
      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Property_0500_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("property_name");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.PADDING_RIGHT, new Padding(1.0, Measure.SPACES));
          this.set(StyleAttributes.SELECTABLE, true);
          this.set(StyleAttributes.RT_ANCHOR_TAG, "default_RTransform");
        }
      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Constant_0500_3(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_0500_3");
    BaseLanguageStyle_StyleSheet.getLeftBrace(editorCell).apply(editorCell);
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.INDENT_LAYOUT_NEW_LINE, true);
        }
      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_RefNode_0500_0(EditorCell editorCell, SNode node, EditorContext context) {
  }

  private static void setupBasic_Collection_0500_2(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Collection_0500_2");
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

  private static void setupBasic_Constant_0500_4(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_0500_4");
    BaseLanguageStyle_StyleSheet.getBaseAngleBracket(editorCell).apply(editorCell);
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.PADDING_RIGHT, new Padding(0.0, Measure.SPACES));
          this.set(StyleAttributes.SELECTABLE, false);
        }
      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_RefNodeList_0500_1(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("refNodeList_typeVariableDeclaration");
  }

  private static void setupBasic_Constant_0500_5(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_0500_5");
    BaseLanguageStyle_StyleSheet.getBaseAngleBracket(editorCell).apply(editorCell);
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, false);
        }
      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_RefNodeList_0500_2(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("refNodeList_controlAbstraction");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, false);
          this.set(StyleAttributes.POSITION_CHILDREN, "indented");
          this.set(StyleAttributes.INDENT_LAYOUT_INDENT, true);
          this.set(StyleAttributes.INDENT_LAYOUT_NEW_LINE, true);
          this.set(StyleAttributes.INDENT_LAYOUT_NEW_LINE, false);
        }
      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Constant_0500_7(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_0500_7");
    BaseLanguageStyle_StyleSheet.getRightBrace(editorCell).apply(editorCell);
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.INDENT_LAYOUT_NEW_LINE, true);
        }
      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Constant_0500_8(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_0500_8");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, false);
          this.set(StyleAttributes.INDENT_LAYOUT_NEW_LINE, true);
        }
      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupLabel_RefNodeList_0500_0(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_0500_0(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_0500_1(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_0500_2(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Property_0500_0(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_0500_3(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_RefNode_0500_0(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_0500_4(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_RefNodeList_0500_1(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_0500_5(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_RefNodeList_0500_2(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_0500_7(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_0500_8(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  public static boolean renderingCondition0500_0(SNode node, EditorContext editorContext, IScope scope) {
    return SLinkOperations.getCount(node, "annotation") > 0;
  }

  public static boolean renderingCondition0500_1(SNode node, EditorContext editorContext, IScope scope) {
    return SNodeOperations.isInstanceOf(SNodeOperations.getParent(node), "jetbrains.mps.baseLanguage.structure.Classifier");
  }

  public static boolean renderingCondition0500_2(SNode node, EditorContext editorContext, IScope scope) {
    return SLinkOperations.getCount(node, "typeVariableDeclaration") > 0;
  }

  public static class annotationListHandler_0500_0 extends RefNodeListHandler {

    public annotationListHandler_0500_0(SNode ownerNode, String childRole, EditorContext context) {
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
  public static class typeVariableDeclarationListHandler_0500_0 extends RefNodeListHandler {

    public typeVariableDeclarationListHandler_0500_0(SNode ownerNode, String childRole, EditorContext context) {
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

}
  public static class controlAbstractionListHandler_0500_0 extends RefNodeListHandler {

    public controlAbstractionListHandler_0500_0(SNode ownerNode, String childRole, EditorContext context) {
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
      return this.createConstant_0500_6(context, node, "");
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

    public EditorCell createConstant_0500_6(EditorContext context, SNode node, String text) {
      EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
      setupBasic_Constant_0500_6(editorCell, node, context);
      setupLabel_Constant_0500_6(editorCell, node, context);
      editorCell.setDefaultText("<<control abstractions>>");
      return editorCell;
    }


    private static void setupBasic_Constant_0500_6(EditorCell editorCell, SNode node, EditorContext context) {
      editorCell.setCellId("Constant_0500_6");
      {
        Style inlineStyle = new Style(editorCell) {
          {
            this.set(StyleAttributes.EDITABLE, true);
          }
        };
        inlineStyle.apply(editorCell);
      }
    }

    private static void setupLabel_Constant_0500_6(EditorCell_Label editorCell, SNode node, EditorContext context) {
    }

}

}
