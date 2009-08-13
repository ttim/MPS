package jetbrains.mps.ypath.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cellMenu.CompositeSubstituteInfo;
import jetbrains.mps.nodeEditor.cellMenu.BasicCellContext;
import jetbrains.mps.nodeEditor.cellMenu.SubstituteInfoPart;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.nodeEditor.AbstractCellProvider;
import jetbrains.mps.nodeEditor.cells.EditorCell_Constant;
import jetbrains.mps.nodeEditor.MPSColors;
import jetbrains.mps.baseLanguage.editor.BaseLanguageStyle_StyleSheet;
import jetbrains.mps.nodeEditor.cells.EditorCell_Property;
import jetbrains.mps.nodeEditor.cells.ModelAccessor;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.ypath.behavior.IFeature_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.util.EqualUtil;
import jetbrains.mps.nodeEditor.CellActionType;
import jetbrains.mps.nodeEditor.cellActions.CellAction_Empty;
import jetbrains.mps.nodeEditor.cellProviders.CellProviderWithRole;
import jetbrains.mps.lang.editor.cellProviders.PropertyCellProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;
import jetbrains.mps.lang.editor.cellProviders.RefNodeCellProvider;
import jetbrains.mps.lang.editor.cellProviders.RefCellCellProvider;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.editor.generator.internal.AbstractCellMenuPart_Generic_Group;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.action.INodeSubstituteAction;
import jetbrains.mps.nodeEditor.cellMenu.CellContext;

public class ParamListFeature_Editor extends DefaultNodeEditor {

  public EditorCell createEditorCell(EditorContext editorContext, SNode node) {
    return this.createCollection_9311_0(editorContext, node);
  }

  private EditorCell createAlternation_9311_0(EditorContext editorContext, SNode node) {
    boolean alternationCondition = true;
    alternationCondition = ParamListFeature_Editor.renderingCondition9311_0(node, editorContext, editorContext.getOperationContext().getScope());
    EditorCell editorCell = null;
    if (alternationCondition) {
      editorCell = this.createConstant_9311_10(editorContext, node);
    } else
    {
      editorCell = this.createConstant_9311_11(editorContext, node);
    }
    IFeature_default_DELETE.setCellActions(editorCell, node, editorContext);
    editorCell.setSubstituteInfo(new CompositeSubstituteInfo(editorContext, new BasicCellContext(node), new SubstituteInfoPart[]{new ParamListFeature_Editor.ParamListFeature_generic_cellMenu0()}));
    return editorCell;
  }

  private EditorCell createAlternation_9311_1(EditorContext editorContext, SNode node) {
    boolean alternationCondition = true;
    alternationCondition = ParamListFeature_Editor.renderingCondition9311_1(node, editorContext, editorContext.getOperationContext().getScope());
    EditorCell editorCell = null;
    if (alternationCondition) {
      editorCell = this.createCollection_9311_14(editorContext, node);
    } else
    {
      editorCell = this.createCollection_9311_15(editorContext, node);
    }
    return editorCell;
  }

  private EditorCell createCollection_9311_0(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createVertical(editorContext, node);
    editorCell.setCellId("Collection_9311_0");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.addEditorCell(this.createCollection_9311_1(editorContext, node));
    editorCell.addEditorCell(this.createCollection_9311_2(editorContext, node));
    editorCell.addEditorCell(this.createCollection_9311_5(editorContext, node));
    return editorCell;
  }

  private EditorCell createCollection_9311_1(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(editorContext, node);
    editorCell.setCellId("Collection_9311_1");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.addKeyMap(new keymap_ListFeature());
    if (renderingCondition9311_5(node, editorContext, editorContext.getOperationContext().getScope())) {
      editorCell.addEditorCell(this.createAlternation_9311_0(editorContext, node));
    }
    editorCell.addEditorCell(this.createProperty_9311_0(editorContext, node));
    editorCell.addEditorCell(this.createConstant_9311_15(editorContext, node));
    editorCell.addEditorCell(this.createRefNode_9311_2(editorContext, node));
    editorCell.addEditorCell(this.createConstant_9311_16(editorContext, node));
    editorCell.addEditorCell(this.createCollection_9311_13(editorContext, node));
    editorCell.addEditorCell(this.createConstant_9311_2(editorContext, node));
    return editorCell;
  }

  private EditorCell createCollection_9311_2(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(editorContext, node);
    editorCell.setCellId("Collection_9311_2");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.addEditorCell(this.createConstant_9311_0(editorContext, node));
    editorCell.addEditorCell(this.createCollection_9311_3(editorContext, node));
    return editorCell;
  }

  private EditorCell createCollection_9311_3(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createVertical(editorContext, node);
    editorCell.setCellId("Collection_9311_3");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.setCanBeFolded(true);
    editorCell.addEditorCell(this.createCollection_9311_6(editorContext, node));
    editorCell.addEditorCell(this.createCollection_9311_7(editorContext, node));
    editorCell.addEditorCell(this.createComponent_9311_0(editorContext, node));
    editorCell.addEditorCell(this.createCollection_9311_16(editorContext, node));
    editorCell.addEditorCell(this.createCollection_9311_4(editorContext, node));
    return editorCell;
  }

  private EditorCell createCollection_9311_4(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(editorContext, node);
    editorCell.setCellId("Collection_9311_4");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.addEditorCell(this.createConstant_9311_1(editorContext, node));
    editorCell.addEditorCell(this.createCollection_9311_17(editorContext, node));
    return editorCell;
  }

  private EditorCell createCollection_9311_5(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(editorContext, node);
    editorCell.setCellId("Collection_9311_5");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.addEditorCell(this.createConstant_9311_3(editorContext, node));
    return editorCell;
  }

  private EditorCell createCollection_9311_6(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(editorContext, node);
    editorCell.setCellId("Collection_9311_6");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.addEditorCell(this.createConstant_9311_4(editorContext, node));
    return editorCell;
  }

  private EditorCell createCollection_9311_7(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(editorContext, node);
    editorCell.setCellId("Collection_9311_7");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.addEditorCell(this.createConstant_9311_5(editorContext, node));
    editorCell.addEditorCell(this.createCollection_9311_8(editorContext, node));
    return editorCell;
  }

  private EditorCell createCollection_9311_8(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createVertical(editorContext, node);
    editorCell.setCellId("Collection_9311_8");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.addEditorCell(this.createCollection_9311_9(editorContext, node));
    editorCell.addEditorCell(this.createCollection_9311_10(editorContext, node));
    editorCell.addEditorCell(this.createCollection_9311_11(editorContext, node));
    editorCell.addEditorCell(this.createCollection_9311_12(editorContext, node));
    return editorCell;
  }

  private EditorCell createCollection_9311_9(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(editorContext, node);
    editorCell.setCellId("Collection_9311_9");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.addEditorCell(this.createConstant_9311_6(editorContext, node));
    return editorCell;
  }

  private EditorCell createCollection_9311_10(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(editorContext, node);
    editorCell.setCellId("Collection_9311_10");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.addEditorCell(this.createConstant_9311_7(editorContext, node));
    editorCell.addEditorCell(this.createRefNode_9311_0(editorContext, node));
    return editorCell;
  }

  private EditorCell createCollection_9311_11(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(editorContext, node);
    editorCell.setCellId("Collection_9311_11");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.addEditorCell(this.createConstant_9311_8(editorContext, node));
    return editorCell;
  }

  private EditorCell createCollection_9311_12(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(editorContext, node);
    editorCell.setCellId("Collection_9311_12");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.addEditorCell(this.createConstant_9311_9(editorContext, node));
    editorCell.addEditorCell(this.createRefNode_9311_1(editorContext, node));
    return editorCell;
  }

  private EditorCell createCollection_9311_13(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(editorContext, node);
    editorCell.setCellId("Collection_9311_13");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    IFeature_opposite_DELETE.setCellActions(editorCell, node, editorContext);
    editorCell.addEditorCell(this.createAlternation_9311_1(editorContext, node));
    return editorCell;
  }

  private EditorCell createCollection_9311_14(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(editorContext, node);
    editorCell.setCellId("Collection_9311_14");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.addEditorCell(this.createConstant_9311_12(editorContext, node));
    editorCell.addEditorCell(this.createReadOnlyModelAccessor_9311_0(editorContext, node));
    return editorCell;
  }

  private EditorCell createCollection_9311_15(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(editorContext, node);
    editorCell.setCellId("Collection_9311_15");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    if (renderingCondition9311_2(node, editorContext, editorContext.getOperationContext().getScope())) {
      editorCell.addEditorCell(this.createConstant_9311_13(editorContext, node));
    }
    if (renderingCondition9311_3(node, editorContext, editorContext.getOperationContext().getScope())) {
      editorCell.addEditorCell(this.createConstant_9311_14(editorContext, node));
    }
    if (renderingCondition9311_4(node, editorContext, editorContext.getOperationContext().getScope())) {
      editorCell.addEditorCell(this.createRefCell_9311_0(editorContext, node));
    }
    return editorCell;
  }

  private EditorCell createCollection_9311_16(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(editorContext, node);
    editorCell.setCellId("Collection_9311_16");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.addEditorCell(this.createConstant_9311_17(editorContext, node));
    return editorCell;
  }

  private EditorCell createCollection_9311_17(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createVertical(editorContext, node);
    editorCell.setCellId("Collection_9311_17");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.addEditorCell(this.createCollection_9311_18(editorContext, node));
    editorCell.addEditorCell(this.createCollection_9311_19(editorContext, node));
    editorCell.addEditorCell(this.createCollection_9311_20(editorContext, node));
    editorCell.addEditorCell(this.createCollection_9311_21(editorContext, node));
    return editorCell;
  }

  private EditorCell createCollection_9311_18(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(editorContext, node);
    editorCell.setCellId("Collection_9311_18");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.addEditorCell(this.createConstant_9311_18(editorContext, node));
    return editorCell;
  }

  private EditorCell createCollection_9311_19(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(editorContext, node);
    editorCell.setCellId("Collection_9311_19");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.addEditorCell(this.createConstant_9311_19(editorContext, node));
    editorCell.addEditorCell(this.createRefNode_9311_3(editorContext, node));
    return editorCell;
  }

  private EditorCell createCollection_9311_20(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(editorContext, node);
    editorCell.setCellId("Collection_9311_20");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.addEditorCell(this.createConstant_9311_20(editorContext, node));
    return editorCell;
  }

  private EditorCell createCollection_9311_21(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(editorContext, node);
    editorCell.setCellId("Collection_9311_21");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.addEditorCell(this.createConstant_9311_21(editorContext, node));
    editorCell.addEditorCell(this.createRefNode_9311_4(editorContext, node));
    return editorCell;
  }

  private EditorCell createComponent_9311_0(EditorContext editorContext, SNode node) {
    AbstractCellProvider provider = new IParamFeature_Properties(node);
    EditorCell editorCell = provider.createEditorCell(editorContext);
    return editorCell;
  }

  private EditorCell createConstant_9311_0(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "  ");
    editorCell.setCellId("Constant_9311_0");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_9311_1(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "  ");
    editorCell.setCellId("Constant_9311_1");
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_9311_2(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "{");
    editorCell.setCellId("Constant_9311_2");
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_9311_3(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "}");
    editorCell.setCellId("Constant_9311_3");
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_9311_4(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "parameter");
    editorCell.setCellId("Constant_9311_4");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.TEXT_COLOR, MPSColors.gray);
    }
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_9311_5(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "  ");
    editorCell.setCellId("Constant_9311_5");
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_9311_6(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "query");
    editorCell.setCellId("Constant_9311_6");
    BaseLanguageStyle_StyleSheet.getKeyWord(editorCell).apply(editorCell);
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_9311_7(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "  ");
    editorCell.setCellId("Constant_9311_7");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_9311_8(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "toString");
    editorCell.setCellId("Constant_9311_8");
    BaseLanguageStyle_StyleSheet.getKeyWord(editorCell).apply(editorCell);
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_9311_9(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "  ");
    editorCell.setCellId("Constant_9311_9");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_9311_10(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "default");
    editorCell.setCellId("Constant_9311_10");
    BaseLanguageStyle_StyleSheet.getKeyWord(editorCell).apply(editorCell);
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.EDITABLE, false);
    }
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_9311_11(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "");
    editorCell.setCellId("Constant_9311_11");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.EDITABLE, false);
    }
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_9311_12(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "<<--");
    editorCell.setCellId("Constant_9311_12");
    stylesheet_Feature_StyleSheet.getOPPOSITE(editorCell).apply(editorCell);
    editorCell.setDefaultText("");
    editorCell.setSubstituteInfo(new CompositeSubstituteInfo(editorContext, new BasicCellContext(node), new SubstituteInfoPart[]{new ParamListFeature_Editor.ParamListFeature_component_cellMenu0()}));
    return editorCell;
  }

  private EditorCell createConstant_9311_13(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "<--");
    editorCell.setCellId("Constant_9311_13");
    stylesheet_Feature_StyleSheet.getOPPOSITE(editorCell).apply(editorCell);
    IFeature_opposite_DELETE.setCellActions(editorCell, node, editorContext);
    editorCell.setDefaultText("");
    editorCell.setSubstituteInfo(new CompositeSubstituteInfo(editorContext, new BasicCellContext(node), new SubstituteInfoPart[]{new ParamListFeature_Editor.ParamListFeature_component_cellMenu1()}));
    return editorCell;
  }

  private EditorCell createConstant_9311_14(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "<-->");
    editorCell.setCellId("Constant_9311_14");
    stylesheet_Feature_StyleSheet.getOPPOSITE(editorCell).apply(editorCell);
    IFeature_opposite_DELETE.setCellActions(editorCell, node, editorContext);
    editorCell.setDefaultText("");
    editorCell.setSubstituteInfo(new CompositeSubstituteInfo(editorContext, new BasicCellContext(node), new SubstituteInfoPart[]{new ParamListFeature_Editor.ParamListFeature_component_cellMenu2()}));
    return editorCell;
  }

  private EditorCell createConstant_9311_15(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "<");
    editorCell.setCellId("Constant_9311_15");
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_9311_16(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, ">");
    editorCell.setCellId("Constant_9311_16");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.RT_ANCHOR_TAG, "default_RTransform");
    }
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_9311_17(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "operations");
    editorCell.setCellId("Constant_9311_17");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.TEXT_COLOR, MPSColors.gray);
    }
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_9311_18(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "get");
    editorCell.setCellId("Constant_9311_18");
    BaseLanguageStyle_StyleSheet.getKeyWord(editorCell).apply(editorCell);
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_9311_19(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "  ");
    editorCell.setCellId("Constant_9311_19");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_9311_20(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "size");
    editorCell.setCellId("Constant_9311_20");
    BaseLanguageStyle_StyleSheet.getKeyWord(editorCell).apply(editorCell);
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_9311_21(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "  ");
    editorCell.setCellId("Constant_9311_21");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createReadOnlyModelAccessor_9311_0(final EditorContext editorContext, final SNode node) {
    EditorCell_Property editorCell = EditorCell_Property.create(editorContext, new ModelAccessor() {

      public String getText() {
        StringBuilder sb = new StringBuilder("[ ");
        String sep = "";
        for(SNode foo : Sequence.fromIterable(IFeature_Behavior.call_getPartialOpposites_1213877499798(node))) {
          sb.append(sep).append(SPropertyOperations.getString(foo, "name"));
          sep = ", ";
        }
        return sb.append(" ]").toString();
      }

      public void setText(String s) {
      }

      public boolean isValidText(String s) {
        return EqualUtil.equals(s, this.getText());
      }
    }, node);
    editorCell.setAction(CellActionType.DELETE, new CellAction_Empty());
    editorCell.setCellId("ReadOnlyModelAccessor_9311_0");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.EDITABLE, false);
    }
    return editorCell;
  }

  private EditorCell createProperty_9311_0(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new PropertyCellProvider(node, editorContext);
    provider.setRole("name");
    provider.setNoTargetText("?name?");
    EditorCell editorCell;
    editorCell = provider.createEditorCell(editorContext);
    editorCell.setCellId("property_name");
    BaseLanguageStyle_StyleSheet.getField(editorCell).apply(editorCell);
    {
      Style style = editorCell.getStyle();
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

  private EditorCell createRefNode_9311_0(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, editorContext);
    provider.setRole("parameterQueryFunction");
    provider.setNoTargetText("<no parameterQueryFunction>");
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

  private EditorCell createRefNode_9311_1(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, editorContext);
    provider.setRole("toStringFunction");
    provider.setNoTargetText("<no toStringFunction>");
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

  private EditorCell createRefCell_9311_0(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new RefCellCellProvider(node, editorContext);
    provider.setRole("opposite");
    provider.setNoTargetText("<no opposite>");
    EditorCell editorCell;
    provider.setAuxiliaryCellProvider(new ParamListFeature_Editor._Inline9311_0());
    editorCell = provider.createEditorCell(editorContext);
    IFeature_opposite_DELETE.setCellActions(editorCell, node, editorContext);
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

  private EditorCell createRefNode_9311_2(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, editorContext);
    provider.setRole("parameterType");
    provider.setNoTargetText("<no parameterType>");
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

  private EditorCell createRefNode_9311_3(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, editorContext);
    provider.setRole("getFunction");
    provider.setNoTargetText("<no getFunction>");
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

  private EditorCell createRefNode_9311_4(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, editorContext);
    provider.setRole("sizeFunction");
    provider.setNoTargetText("<no sizeFunction>");
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


  private static boolean renderingCondition9311_0(SNode node, EditorContext editorContext, IScope scope) {
    return SPropertyOperations.getBoolean(node, "default");
  }

  private static boolean renderingCondition9311_1(SNode node, EditorContext editorContext, IScope scope) {
    return IFeature_Behavior.call_hasPartialOpposites_1213877499758(node);
  }

  private static boolean renderingCondition9311_2(SNode node, EditorContext editorContext, IScope scope) {
    return (SLinkOperations.getTarget(node, "opposite", false) != null) && SLinkOperations.getTarget(SLinkOperations.getTarget(node, "opposite", false), "opposite", false) != node;
  }

  private static boolean renderingCondition9311_3(SNode node, EditorContext editorContext, IScope scope) {
    return IFeature_Behavior.call_hasMutualOpposite_1213877499741(node);
  }

  private static boolean renderingCondition9311_4(SNode node, EditorContext editorContext, IScope scope) {
    return (SLinkOperations.getTarget(node, "opposite", false) != null);
  }

  private static boolean renderingCondition9311_5(SNode node, EditorContext editorContext, IScope scope) {
    return false;
  }

  public static class _Inline9311_0 extends AbstractCellProvider {

    public _Inline9311_0() {
      super();
    }

    public EditorCell createEditorCell(EditorContext editorContext) {
      return this.createEditorCell(editorContext, this.getSNode());
    }

    public EditorCell createEditorCell(EditorContext editorContext, SNode node) {
      return this.createProperty_9311_1(editorContext, node);
    }

    private EditorCell createProperty_9311_1(EditorContext editorContext, SNode node) {
      CellProviderWithRole provider = new PropertyCellProvider(node, editorContext);
      provider.setRole("name");
      provider.setNoTargetText("<no name>");
      provider.setReadOnly(true);
      EditorCell editorCell;
      editorCell = provider.createEditorCell(editorContext);
      editorCell.setCellId("property_name_1");
      BaseLanguageStyle_StyleSheet.getField(editorCell).apply(editorCell);
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

}
  public static class ParamListFeature_generic_cellMenu0 extends AbstractCellMenuPart_Generic_Group {

    public ParamListFeature_generic_cellMenu0() {
    }

    public List<?> createParameterObjects(SNode node, IScope scope, IOperationContext operationContext) {
      return ListSequence.fromListAndArray(new ArrayList<Boolean>(), true, false);
    }

    public void handleAction(Object parameterObject, SNode node, SModel model, IScope scope, IOperationContext operationContext) {
      this.handleAction_impl((Boolean)parameterObject, node, model, scope, operationContext);
    }

    public void handleAction_impl(Boolean parameterObject, SNode node, SModel model, IScope scope, IOperationContext operationContext) {
      SPropertyOperations.set(node, "default", "" + (parameterObject));
    }

    public boolean isReferentPresentation() {
      return false;
    }

    public String getMatchingText(Object parameterObject) {
      return this.getMatchingText_internal((Boolean)parameterObject);
    }

    public String getMatchingText_internal(Boolean parameterObject) {
      return (parameterObject ?
        "default" :
        "regular"
      );
    }

    public String getDescriptionText(Object parameterObject) {
      return this.getDescriptionText_internal((Boolean)parameterObject);
    }

    public String getDescriptionText_internal(Boolean parameterObject) {
      return (parameterObject ?
        "allows to omit the feature when iterating" :
        "feature must be always specified"
      );
    }

}
  public static class ParamListFeature_component_cellMenu0 implements SubstituteInfoPart {

    private menu_FeatureSetOpposite myComponent;

    public ParamListFeature_component_cellMenu0() {
      this.myComponent = new menu_FeatureSetOpposite();
    }

    public List<INodeSubstituteAction> createActions(CellContext cellContext, EditorContext editorContext) {
      return this.myComponent.createActions(cellContext, editorContext);
    }

}
  public static class ParamListFeature_component_cellMenu1 implements SubstituteInfoPart {

    private menu_FeatureSetOpposite myComponent;

    public ParamListFeature_component_cellMenu1() {
      this.myComponent = new menu_FeatureSetOpposite();
    }

    public List<INodeSubstituteAction> createActions(CellContext cellContext, EditorContext editorContext) {
      return this.myComponent.createActions(cellContext, editorContext);
    }

}
  public static class ParamListFeature_component_cellMenu2 implements SubstituteInfoPart {

    private menu_FeatureSetOpposite myComponent;

    public ParamListFeature_component_cellMenu2() {
      this.myComponent = new menu_FeatureSetOpposite();
    }

    public List<INodeSubstituteAction> createActions(CellContext cellContext, EditorContext editorContext) {
      return this.myComponent.createActions(cellContext, editorContext);
    }

}

}
