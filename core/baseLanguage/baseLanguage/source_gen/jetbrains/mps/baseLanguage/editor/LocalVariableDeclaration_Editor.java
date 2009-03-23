package jetbrains.mps.baseLanguage.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.AbstractCellProvider;
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
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.editor.cellProviders.RefNodeListHandler;
import jetbrains.mps.smodel.action.NodeFactoryManager;
import jetbrains.mps.nodeEditor.CellActionType;
import jetbrains.mps.nodeEditor.cellActions.CellAction_DeleteNode;
import jetbrains.mps.nodeEditor.cellMenu.DefaultReferenceSubstituteInfo;
import jetbrains.mps.nodeEditor.cellMenu.DefaultChildSubstituteInfo;

public class LocalVariableDeclaration_Editor extends DefaultNodeEditor {

  /* package */AbstractCellProvider myVariableDeclaration_NameCellComponent2231_0;
  /* package */AbstractCellListHandler myListHandler_2231_0;
  /* package */AbstractCellListHandler myListHandler_2231_1;

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createCollection_2231_1(context, node);
  }

  public EditorCell createInspectedCell(EditorContext context, SNode node) {
    return this.createCollection_2231_0(context, node);
  }

  public EditorCell createCollection_2231_0(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createIndent2(context, node);
    setupBasic_Collection_2231_0(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createConstant_2231_0(context, node, "final"));
    editorCell.addEditorCell(this.createProperty_2231_1(context, node));
    editorCell.addEditorCell(this.createConstant_2231_3(context, node, "annotations:"));
    editorCell.addEditorCell(this.createRefNodeList_2231_0(context, node));
    return editorCell;
  }

  public EditorCell createCollection_2231_1(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createIndent2(context, node);
    setupBasic_Collection_2231_1(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    if (renderingCondition2231_2(node, context, context.getOperationContext().getScope())) {
      editorCell.addEditorCell(this.createCollection_2231_3(context, node));
    }
    if (renderingCondition2231_0(node, context, context.getOperationContext().getScope())) {
      editorCell.addEditorCell(this.createConstant_2231_1(context, node, "final"));
    }
    editorCell.addEditorCell(this.createRefNode_2231_1(context, node));
    editorCell.addEditorCell(this.createComponent_2231_0(context, node));
    if (renderingCondition2231_1(node, context, context.getOperationContext().getScope())) {
      editorCell.addEditorCell(this.createCollection_2231_2(context, node));
    }
    return editorCell;
  }

  public EditorCell createCollection_2231_2(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createIndent2(context, node);
    setupBasic_Collection_2231_2(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createConstant_2231_2(context, node, "="));
    editorCell.addEditorCell(this.createRefNode_2231_3(context, node));
    return editorCell;
  }

  public EditorCell createCollection_2231_3(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createIndent2(context, node);
    setupBasic_Collection_2231_3(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createRefNodeList_2231_1(context, node));
    return editorCell;
  }

  public EditorCell createComponent_2231_0(EditorContext context, SNode node) {
    if (this.myVariableDeclaration_NameCellComponent2231_0 == null) {
      this.myVariableDeclaration_NameCellComponent2231_0 = new VariableDeclaration_NameCellComponent(node);
    }
    EditorCell editorCell = this.myVariableDeclaration_NameCellComponent2231_0.createEditorCell(context);
    setupBasic_Component_2231_0(editorCell, node, context);
    return editorCell;
  }

  public EditorCell createConstant_2231_0(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_2231_0(editorCell, node, context);
    setupLabel_Constant_2231_0(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_2231_1(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_2231_1(editorCell, node, context);
    setupLabel_Constant_2231_1(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_2231_2(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_2231_2(editorCell, node, context);
    setupLabel_Constant_2231_2(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant_2231_3(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_2231_3(editorCell, node, context);
    setupLabel_Constant_2231_3(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createRefNodeList_2231_0(EditorContext context, SNode node) {
    if (this.myListHandler_2231_0 == null) {
      this.myListHandler_2231_0 = new LocalVariableDeclaration_Editor.annotationListHandler_2231_0(node, "annotation", context);
    }
    EditorCell_Collection editorCell = this.myListHandler_2231_0.createCells(context, new CellLayout_Indent(), false);
    setupBasic_RefNodeList_2231_0(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.setRole(this.myListHandler_2231_0.getElementRole());
    return editorCell;
  }

  public EditorCell createRefNodeList_2231_1(EditorContext context, SNode node) {
    if (this.myListHandler_2231_1 == null) {
      this.myListHandler_2231_1 = new LocalVariableDeclaration_Editor.annotationListHandler_2231_1(node, "annotation", context);
    }
    EditorCell_Collection editorCell = this.myListHandler_2231_1.createCells(context, new CellLayout_Indent(), false);
    setupBasic_RefNodeList_2231_1(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.setRole(this.myListHandler_2231_1.getElementRole());
    return editorCell;
  }

  public EditorCell createProperty_2231_0_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(null);
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_Property_2231_0(editorCell, node, context);
    if (editorCell instanceof EditorCell_Label) {
      setupLabel_Property_2231_0((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell createProperty_2231_1(EditorContext context, SNode node) {
    CellProviderWithRole provider = new PropertyCellProvider(node, context);
    provider.setRole("isFinal");
    provider.setNoTargetText("<no isFinal>");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createProperty_2231_0_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }

  public EditorCell createRefNode_2231_0_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(null);
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_RefNode_2231_0(editorCell, node, context);
    if (editorCell instanceof EditorCell_Label) {
      setupLabel_RefNode_2231_0((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell createRefNode_2231_1(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, context);
    provider.setRole("type");
    provider.setNoTargetText("<no type>");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createRefNode_2231_0_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }

  public EditorCell createRefNode_2231_2_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(null);
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_RefNode_2231_1(editorCell, node, context);
    if (editorCell instanceof EditorCell_Label) {
      setupLabel_RefNode_2231_1((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell createRefNode_2231_3(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, context);
    provider.setRole("initializer");
    provider.setNoTargetText("<no initializer>");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createRefNode_2231_2_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }


  private static void setupBasic_Collection_2231_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Collection_2231_0");
  }

  private static void setupBasic_Constant_2231_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_2231_0");
  }

  private static void setupBasic_Property_2231_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("property_isFinal");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.INDENT_LAYOUT_NEW_LINE, true);
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Collection_2231_1(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Collection_2231_1");
  }

  private static void setupBasic_Constant_2231_1(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_2231_1");
    BaseLanguageStyle_StyleSheet.getKeyWord(editorCell).apply(editorCell);
    VariableDeclaration_RemoveFinalOnDelete.setCellActions(editorCell, node, context);
  }

  private static void setupBasic_RefNode_2231_0(EditorCell editorCell, SNode node, EditorContext context) {
  }

  private static void setupBasic_Component_2231_0(EditorCell editorCell, SNode node, EditorContext context) {
  }

  private static void setupBasic_Collection_2231_2(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Collection_2231_2");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, false);
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Constant_2231_2(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_2231_2");
    BaseLanguageStyle_StyleSheet.getOperator(editorCell).apply(editorCell);
    LocalVariableDeclaration_Initializer_Actions.setCellActions(editorCell, node, context);
  }

  private static void setupBasic_RefNode_2231_1(EditorCell editorCell, SNode node, EditorContext context) {
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.AUTO_DELETABLE, false);
        }

      };
      inlineStyle.apply(editorCell);
    }
    LocalVariableDeclaration_Initializer_Actions.setCellActions(editorCell, node, context);
  }

  private static void setupBasic_Constant_2231_3(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_2231_3");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.INDENT_LAYOUT_NEW_LINE, true);
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_RefNodeList_2231_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("refNodeList_annotation");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.INDENT_LAYOUT_NEW_LINE, true);
          this.set(StyleAttributes.INDENT_LAYOUT_NEW_LINE, false);
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Collection_2231_3(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Collection_2231_3");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, false);
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_RefNodeList_2231_1(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("refNodeList_annotation_1");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.INDENT_LAYOUT_NEW_LINE, false);
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupLabel_Constant_2231_0(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Property_2231_0(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_2231_1(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_RefNode_2231_0(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_2231_2(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_RefNode_2231_1(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_2231_3(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_RefNodeList_2231_0(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_RefNodeList_2231_1(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  public static boolean renderingCondition2231_0(SNode node, EditorContext editorContext, IScope scope) {
    return SPropertyOperations.getBoolean(node, "isFinal");
  }

  public static boolean renderingCondition2231_1(SNode node, EditorContext editorContext, IScope scope) {
    return SLinkOperations.getTarget(node, "initializer", true) != null;
  }

  public static boolean renderingCondition2231_2(SNode node, EditorContext editorContext, IScope scope) {
    return SLinkOperations.getCount(node, "annotation") > 0;
  }

  public static class annotationListHandler_2231_0 extends RefNodeListHandler {

    public annotationListHandler_2231_0(SNode ownerNode, String childRole, EditorContext context) {
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
  public static class annotationListHandler_2231_1 extends RefNodeListHandler {

    public annotationListHandler_2231_1(SNode ownerNode, String childRole, EditorContext context) {
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
