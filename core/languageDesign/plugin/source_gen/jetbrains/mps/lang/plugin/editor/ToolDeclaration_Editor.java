package jetbrains.mps.lang.plugin.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.nodeEditor.cells.EditorCell_Constant;
import jetbrains.mps.baseLanguage.editor.BaseLanguageStyle_StyleSheet;
import jetbrains.mps.nodeEditor.MPSColors;
import jetbrains.mps.nodeEditor.cells.EditorCell_Image;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.nodeEditor.cells.EditorCell_Property;
import jetbrains.mps.nodeEditor.cells.ModelAccessor;
import jetbrains.mps.util.EqualUtil;
import jetbrains.mps.nodeEditor.CellActionType;
import jetbrains.mps.nodeEditor.cellActions.CellAction_Empty;
import jetbrains.mps.nodeEditor.cellProviders.AbstractCellListHandler;
import jetbrains.mps.nodeEditor.cellLayout.CellLayout_Vertical;
import jetbrains.mps.nodeEditor.cells.EditorCell_Indent;
import jetbrains.mps.nodeEditor.cells.EditorCell_Component;
import jetbrains.mps.nodeEditor.cellProviders.CellProviderWithRole;
import jetbrains.mps.lang.editor.cellProviders.PropertyCellProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;
import jetbrains.mps.lang.editor.cellProviders.RefNodeCellProvider;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.lang.plugin.behavior.ToolDeclaration_Behavior;
import jetbrains.mps.project.IModule;
import jetbrains.mps.lang.structure.editor.EditorUtil;
import jetbrains.mps.plugins.MacrosUtil;
import jetbrains.mps.vfs.FileSystem;
import jetbrains.mps.nodeEditor.BlockCells;
import javax.swing.JComponent;
import jetbrains.mps.lang.editor.cellProviders.RefNodeListHandler;
import jetbrains.mps.smodel.action.NodeFactoryManager;
import jetbrains.mps.nodeEditor.cellActions.CellAction_DeleteNode;
import jetbrains.mps.nodeEditor.cellMenu.DefaultReferenceSubstituteInfo;
import jetbrains.mps.nodeEditor.cellMenu.DefaultChildSubstituteInfo;
import jetbrains.mps.lang.editor.cellProviders.RefNodeListHandlerElementKeyMap;

public class ToolDeclaration_Editor extends DefaultNodeEditor {

  public EditorCell createEditorCell(EditorContext editorContext, SNode node) {
    return this.createCollection_4170_7(editorContext, node);
  }

  private EditorCell createAlternation_4170_0(EditorContext editorContext, SNode node) {
    boolean alternationCondition = true;
    alternationCondition = ToolDeclaration_Editor.renderingCondition4170_1(node, editorContext, editorContext.getOperationContext().getScope());
    EditorCell editorCell = null;
    if (alternationCondition) {
      editorCell = this.createCollection_4170_6(editorContext, node);
    } else
    {
      editorCell = this.createConstant_4170_7(editorContext, node);
    }
    return editorCell;
  }

  private EditorCell createCollection_4170_0(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(editorContext, node);
    editorCell.setCellId("Collection_4170_0");
    editorCell.addEditorCell(this.createConstant_4170_0(editorContext, node));
    editorCell.addEditorCell(this.createProperty_4170_0(editorContext, node));
    return editorCell;
  }

  private EditorCell createCollection_4170_1(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createVertical(editorContext, node);
    editorCell.setCellId("Collection_4170_1");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.addEditorCell(this.createCollection_4170_2(editorContext, node));
    editorCell.addEditorCell(this.createCollection_4170_3(editorContext, node));
    editorCell.addEditorCell(this.createCollection_4170_5(editorContext, node));
    editorCell.addEditorCell(this.createConstant_4170_8(editorContext, node));
    editorCell.addEditorCell(this.createRefNodeList_4170_0(editorContext, node));
    editorCell.addEditorCell(this.createConstant_4170_9(editorContext, node));
    editorCell.addEditorCell(this.createRefNode_4170_0(editorContext, node));
    editorCell.addEditorCell(this.createConstant_4170_10(editorContext, node));
    editorCell.addEditorCell(this.createRefNode_4170_1(editorContext, node));
    editorCell.addEditorCell(this.createConstant_4170_11(editorContext, node));
    editorCell.addEditorCell(this.createRefNode_4170_2(editorContext, node));
    editorCell.addEditorCell(this.createConstant_4170_12(editorContext, node));
    editorCell.addEditorCell(this.createRefNodeList_4170_1(editorContext, node));
    return editorCell;
  }

  private EditorCell createCollection_4170_2(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(editorContext, node);
    editorCell.setCellId("Collection_4170_2");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.addEditorCell(this.createConstant_4170_1(editorContext, node));
    editorCell.addEditorCell(this.createProperty_4170_1(editorContext, node));
    return editorCell;
  }

  private EditorCell createCollection_4170_3(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(editorContext, node);
    editorCell.setCellId("Collection_4170_3");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.addEditorCell(this.createConstant_4170_2(editorContext, node));
    editorCell.addEditorCell(this.createProperty_4170_2(editorContext, node));
    if (renderingCondition4170_0(node, editorContext, editorContext.getOperationContext().getScope())) {
      editorCell.addEditorCell(this.createCollection_4170_4(editorContext, node));
    }
    return editorCell;
  }

  private EditorCell createCollection_4170_4(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(editorContext, node);
    editorCell.setCellId("Collection_4170_4");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.addEditorCell(this.createConstant_4170_3(editorContext, node));
    editorCell.addEditorCell(this.createConstant_4170_4(editorContext, node));
    editorCell.addEditorCell(this.createReadOnlyModelAccessor_4170_0(editorContext, node));
    editorCell.addEditorCell(this.createConstant_4170_5(editorContext, node));
    return editorCell;
  }

  private EditorCell createCollection_4170_5(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(editorContext, node);
    editorCell.setCellId("Collection_4170_5");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.addEditorCell(this.createConstant_4170_6(editorContext, node));
    editorCell.addEditorCell(this.createAlternation_4170_0(editorContext, node));
    editorCell.addEditorCell(this.createJComponent_4170_0(editorContext, node));
    return editorCell;
  }

  private EditorCell createCollection_4170_6(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(editorContext, node);
    editorCell.setCellId("Collection_4170_6");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.addEditorCell(this.createImage_4170_0(editorContext, node));
    editorCell.addEditorCell(this.createProperty_4170_3(editorContext, node));
    return editorCell;
  }

  private EditorCell createCollection_4170_7(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createVertical(editorContext, node);
    editorCell.setCellId("Collection_4170_7");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.addEditorCell(this.createCollection_4170_8(editorContext, node));
    editorCell.addEditorCell(this.createCollection_4170_9(editorContext, node));
    if (renderingCondition4170_3(node, editorContext, editorContext.getOperationContext().getScope())) {
      editorCell.addEditorCell(this.createConstant_4170_14(editorContext, node));
    }
    return editorCell;
  }

  private EditorCell createCollection_4170_8(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(editorContext, node);
    editorCell.setCellId("Collection_4170_8");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.addEditorCell(this.createCollection_4170_0(editorContext, node));
    if (renderingCondition4170_2(node, editorContext, editorContext.getOperationContext().getScope())) {
      editorCell.addEditorCell(this.createConstant_4170_13(editorContext, node));
    }
    return editorCell;
  }

  private EditorCell createCollection_4170_9(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(editorContext, node);
    editorCell.setCellId("Collection_4170_9");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.addEditorCell(this.createIndentCell4170_0(editorContext, node));
    editorCell.addEditorCell(this.createCollection_4170_1(editorContext, node));
    return editorCell;
  }

  private EditorCell createConstant_4170_0(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "tool");
    editorCell.setCellId("Constant_4170_0");
    BaseLanguageStyle_StyleSheet.getKeyWord(editorCell).apply(editorCell);
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_4170_1(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "caption:");
    editorCell.setCellId("Constant_4170_1");
    BaseLanguageStyle_StyleSheet.getKeyWord(editorCell).apply(editorCell);
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_4170_2(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "number:");
    editorCell.setCellId("Constant_4170_2");
    BaseLanguageStyle_StyleSheet.getKeyWord(editorCell).apply(editorCell);
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_4170_3(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "(");
    editorCell.setCellId("Constant_4170_3");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.MATCHING_LABEL, "parenthesis");
      style.set(StyleAttributes.TEXT_COLOR, MPSColors.lightGray);
    }
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_4170_4(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "show keystroke: ");
    editorCell.setCellId("Constant_4170_4");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
      style.set(StyleAttributes.TEXT_COLOR, MPSColors.lightGray);
    }
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_4170_5(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, ")");
    editorCell.setCellId("Constant_4170_5");
    BaseLanguageStyle_StyleSheet.getKeyWord(editorCell).apply(editorCell);
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.MATCHING_LABEL, "parenthesis");
      style.set(StyleAttributes.TEXT_COLOR, MPSColors.lightGray);
    }
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_4170_6(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "icon:");
    editorCell.setCellId("Constant_4170_6");
    BaseLanguageStyle_StyleSheet.getKeyWord(editorCell).apply(editorCell);
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_4170_7(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "<no icon>");
    editorCell.setCellId("Constant_4170_7");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.TEXT_COLOR, MPSColors.lightGray);
    }
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_4170_8(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "");
    editorCell.setCellId("Constant_4170_8");
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_4170_9(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "");
    editorCell.setCellId("Constant_4170_9");
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_4170_10(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "");
    editorCell.setCellId("Constant_4170_10");
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_4170_11(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "");
    editorCell.setCellId("Constant_4170_11");
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_4170_12(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "");
    editorCell.setCellId("Constant_4170_12");
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_4170_13(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "{");
    editorCell.setCellId("Constant_4170_13");
    BaseLanguageStyle_StyleSheet.getLeftBrace(editorCell).apply(editorCell);
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_4170_14(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "}");
    editorCell.setCellId("Constant_4170_14");
    BaseLanguageStyle_StyleSheet.getRightBrace(editorCell).apply(editorCell);
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createImage_4170_0(final EditorContext editorContext, final SNode node) {
    EditorCell_Image editorCell;
    editorCell = EditorCell_Image.createImageCell(editorContext, node, new _FunctionTypes._return_P0_E0 <String>() {

      public String invoke() {
        return SPropertyOperations.getString(node, "icon");
      }
    }.invoke());
    editorCell.setCellId("Image_4170_0");
    editorCell.setDescent(0);
    return editorCell;
  }

  private EditorCell createReadOnlyModelAccessor_4170_0(final EditorContext editorContext, final SNode node) {
    EditorCell_Property editorCell = EditorCell_Property.create(editorContext, new ModelAccessor() {

      public String getText() {
        return "Alt-" + SPropertyOperations.getString(node, "number");
      }

      public void setText(String s) {
      }

      public boolean isValidText(String s) {
        return EqualUtil.equals(s, this.getText());
      }
    }, node);
    editorCell.setAction(CellActionType.DELETE, new CellAction_Empty());
    editorCell.setCellId("ReadOnlyModelAccessor_4170_0");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
      style.set(StyleAttributes.TEXT_COLOR, MPSColors.darkGray);
    }
    return editorCell;
  }

  private EditorCell createRefNodeList_4170_0(EditorContext editorContext, SNode node) {
    AbstractCellListHandler handler = new ToolDeclaration_Editor.fieldDeclarationListHandler_4170_0(node, "fieldDeclaration", editorContext);
    EditorCell_Collection editorCell = handler.createCells(editorContext, new CellLayout_Vertical(), false);
    editorCell.setCellId("refNodeList_fieldDeclaration");
    editorCell.setRole(handler.getElementRole());
    return editorCell;
  }

  private EditorCell createRefNodeList_4170_1(EditorContext editorContext, SNode node) {
    AbstractCellListHandler handler = new ToolDeclaration_Editor.methodDeclarationListHandler_4170_0(node, "methodDeclaration", editorContext);
    EditorCell_Collection editorCell = handler.createCells(editorContext, new CellLayout_Vertical(), false);
    editorCell.setCellId("refNodeList_methodDeclaration");
    editorCell.setRole(handler.getElementRole());
    return editorCell;
  }

  private EditorCell createIndentCell4170_0(EditorContext editorContext, SNode node) {
    EditorCell_Indent result = new EditorCell_Indent(editorContext, node);
    return result;
  }

  private EditorCell createJComponent_4170_0(EditorContext editorContext, SNode node) {
    EditorCell editorCell = EditorCell_Component.createComponentCell(editorContext, node, ToolDeclaration_Editor._QueryFunction_JComponent_7456779980561189744(node, editorContext), "_7456779980561189743");
    editorCell.setCellId("JComponent_4170_0");
    return editorCell;
  }

  private EditorCell createProperty_4170_0(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new PropertyCellProvider(node, editorContext);
    provider.setRole("name");
    provider.setNoTargetText("<no name>");
    EditorCell editorCell;
    editorCell = provider.createEditorCell(editorContext);
    editorCell.setCellId("property_name");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, true);
      style.set(StyleAttributes.RT_ANCHOR_TAG, "default_RTransform");
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = editorContext.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(editorContext, attributeConcept, attributeKind, editorCell);
    } else
    return editorCell;
  }

  private EditorCell createProperty_4170_1(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new PropertyCellProvider(node, editorContext);
    provider.setRole("caption");
    provider.setNoTargetText("<use name>");
    provider.setAllowsEmptyTarget(true);
    EditorCell editorCell;
    editorCell = provider.createEditorCell(editorContext);
    editorCell.setCellId("property_caption");
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = editorContext.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(editorContext, attributeConcept, attributeKind, editorCell);
    } else
    return editorCell;
  }

  private EditorCell createProperty_4170_2(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new PropertyCellProvider(node, editorContext);
    provider.setRole("number");
    provider.setNoTargetText("<no>");
    provider.setAllowsEmptyTarget(true);
    EditorCell editorCell;
    editorCell = provider.createEditorCell(editorContext);
    editorCell.setCellId("property_number");
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = editorContext.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(editorContext, attributeConcept, attributeKind, editorCell);
    } else
    return editorCell;
  }

  private EditorCell createProperty_4170_3(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new PropertyCellProvider(node, editorContext);
    provider.setRole("icon");
    provider.setNoTargetText("<no icon>");
    EditorCell editorCell;
    editorCell = provider.createEditorCell(editorContext);
    editorCell.setCellId("property_icon");
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = editorContext.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(editorContext, attributeConcept, attributeKind, editorCell);
    } else
    return editorCell;
  }

  private EditorCell createRefNode_4170_0(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, editorContext);
    provider.setRole("initBlock");
    provider.setNoTargetText("<init block>");
    EditorCell editorCell;
    editorCell = provider.createEditorCell(editorContext);
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = editorContext.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(editorContext, attributeConcept, attributeKind, editorCell);
    } else
    return editorCell;
  }

  private EditorCell createRefNode_4170_1(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, editorContext);
    provider.setRole("disposeBlock");
    provider.setNoTargetText("<dispose block>");
    EditorCell editorCell;
    editorCell = provider.createEditorCell(editorContext);
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = editorContext.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(editorContext, attributeConcept, attributeKind, editorCell);
    } else
    return editorCell;
  }

  private EditorCell createRefNode_4170_2(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, editorContext);
    provider.setRole("getComponentBlock");
    provider.setNoTargetText("<getComponent block>");
    EditorCell editorCell;
    editorCell = provider.createEditorCell(editorContext);
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = editorContext.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(editorContext, attributeConcept, attributeKind, editorCell);
    } else
    return editorCell;
  }


  private static boolean renderingCondition4170_0(SNode node, EditorContext editorContext, IScope scope) {
    return ToolDeclaration_Behavior.call_hasNumber_1213877425741(node);
  }

  private static boolean renderingCondition4170_1(SNode node, EditorContext editorContext, IScope scope) {
    String path = null;
    IModule module = EditorUtil.findAnchorModule(node);
    if (module != null) {
      path = MacrosUtil.expandPath(SPropertyOperations.getString(node, "icon"), module.getModuleUID());
    }
    return path != null && FileSystem.getFile(path).exists();
  }

  private static boolean renderingCondition4170_2(SNode node, EditorContext editorContext, IScope scope) {
    return BlockCells.useBraces();
  }

  private static boolean renderingCondition4170_3(SNode node, EditorContext editorContext, IScope scope) {
    return BlockCells.useBraces();
  }

  private static JComponent _QueryFunction_JComponent_7456779980561189744(SNode node, EditorContext editorContext) {
    return EditorUtil.createSelectIconButton(node, "icon", editorContext);
  }

  private static class fieldDeclarationListHandler_4170_0 extends RefNodeListHandler {

    public fieldDeclarationListHandler_4170_0(SNode ownerNode, String childRole, EditorContext context) {
      super(ownerNode, childRole, context, false);
    }

    public SNode createNodeToInsert(EditorContext editorContext) {
      SNode listOwner = super.getOwner();
      return NodeFactoryManager.createNode(listOwner, editorContext, super.getElementRole());
    }

    public EditorCell createNodeCell(EditorContext editorContext, SNode elementNode) {
      EditorCell elementCell = super.createNodeCell(editorContext, elementNode);
      this.installElementCellActions(this.getOwner(), elementNode, elementCell, editorContext);
      return elementCell;
    }

    public EditorCell createEmptyCell(EditorContext editorContext) {
      EditorCell emptyCell = null;
      emptyCell = super.createEmptyCell(editorContext);
      this.installElementCellActions(super.getOwner(), null, emptyCell, editorContext);
      return emptyCell;
    }

    public void installElementCellActions(SNode listOwner, SNode elementNode, EditorCell elementCell, EditorContext editorContext) {
      if (elementCell.getUserObject(AbstractCellListHandler.ELEMENT_CELL_ACTIONS_SET) == null) {
        elementCell.putUserObject(AbstractCellListHandler.ELEMENT_CELL_ACTIONS_SET, AbstractCellListHandler.ELEMENT_CELL_ACTIONS_SET);
        SNode substituteInfoNode = listOwner;
        if (elementNode != null) {
          substituteInfoNode = elementNode;
          elementCell.setAction(CellActionType.DELETE, new CellAction_DeleteNode(elementNode));
        }
        if (elementCell.getSubstituteInfo() == null || elementCell.getSubstituteInfo() instanceof DefaultReferenceSubstituteInfo) {
          elementCell.setSubstituteInfo(new DefaultChildSubstituteInfo(listOwner, elementNode, super.getLinkDeclaration(), editorContext));
        }
      }
    }

    public EditorCell createSeparatorCell(EditorContext editorContext) {
      return super.createSeparatorCell(editorContext);
    }

}
  private static class methodDeclarationListHandler_4170_0 extends RefNodeListHandler {

    public methodDeclarationListHandler_4170_0(SNode ownerNode, String childRole, EditorContext context) {
      super(ownerNode, childRole, context, false);
    }

    public SNode createNodeToInsert(EditorContext editorContext) {
      SNode listOwner = super.getOwner();
      return NodeFactoryManager.createNode(listOwner, editorContext, super.getElementRole());
    }

    public EditorCell createNodeCell(EditorContext editorContext, SNode elementNode) {
      EditorCell elementCell = super.createNodeCell(editorContext, elementNode);
      this.installElementCellActions(this.getOwner(), elementNode, elementCell, editorContext);
      return elementCell;
    }

    public EditorCell createEmptyCell(EditorContext editorContext) {
      EditorCell emptyCell = null;
      emptyCell = super.createEmptyCell(editorContext);
      this.installElementCellActions(super.getOwner(), null, emptyCell, editorContext);
      return emptyCell;
    }

    public void installElementCellActions(SNode listOwner, SNode elementNode, EditorCell elementCell, EditorContext editorContext) {
      if (elementCell.getUserObject(AbstractCellListHandler.ELEMENT_CELL_ACTIONS_SET) == null) {
        elementCell.putUserObject(AbstractCellListHandler.ELEMENT_CELL_ACTIONS_SET, AbstractCellListHandler.ELEMENT_CELL_ACTIONS_SET);
        SNode substituteInfoNode = listOwner;
        if (elementNode != null) {
          substituteInfoNode = elementNode;
          elementCell.setAction(CellActionType.DELETE, new CellAction_DeleteNode(elementNode));
          elementCell.addKeyMap(new RefNodeListHandlerElementKeyMap(this, " "));
        }
        if (elementCell.getSubstituteInfo() == null || elementCell.getSubstituteInfo() instanceof DefaultReferenceSubstituteInfo) {
          elementCell.setSubstituteInfo(new DefaultChildSubstituteInfo(listOwner, elementNode, super.getLinkDeclaration(), editorContext));
        }
      }
    }

    public EditorCell createSeparatorCell(EditorContext editorContext) {
      {
        EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, this.getOwner(), " ");
        editorCell.setSelectable(false);
        editorCell.getStyle().set(StyleAttributes.LAYOUT_CONSTRAINT, "");
        editorCell.getStyle().set(StyleAttributes.PUNCTUATION_LEFT, true);
        return editorCell;
      }
    }

}

}
