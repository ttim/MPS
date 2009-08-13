package jetbrains.mps.ypath.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.nodeEditor.cells.EditorCell_Constant;
import jetbrains.mps.nodeEditor.MPSColors;
import jetbrains.mps.nodeEditor.cellMenu.CompositeSubstituteInfo;
import jetbrains.mps.nodeEditor.cellMenu.BasicCellContext;
import jetbrains.mps.nodeEditor.cellMenu.SubstituteInfoPart;
import jetbrains.mps.baseLanguage.editor.BaseLanguageStyle_StyleSheet;
import jetbrains.mps.nodeEditor.cells.EditorCell_Property;
import jetbrains.mps.nodeEditor.cells.ModelAccessor;
import jetbrains.mps.ypath.behavior.IterateOperation_Behavior;
import jetbrains.mps.util.EqualUtil;
import jetbrains.mps.nodeEditor.CellActionType;
import jetbrains.mps.nodeEditor.cellActions.CellAction_Empty;
import jetbrains.mps.baseLanguage.collections.editor.Collections_Style_StyleSheet;
import jetbrains.mps.ypath.runtime.TraversalAxis;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.nodeEditor.cellProviders.CellProviderWithRole;
import jetbrains.mps.lang.editor.cellProviders.RefCellCellProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;
import jetbrains.mps.lang.editor.cellProviders.RefNodeCellProvider;
import jetbrains.mps.nodeEditor.MPSFonts;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.ypath.actions.TraversalAxisUtil;
import jetbrains.mps.nodeEditor.AbstractCellProvider;
import jetbrains.mps.lang.editor.cellProviders.PropertyCellProvider;
import java.util.List;
import jetbrains.mps.smodel.action.INodeSubstituteAction;
import jetbrains.mps.nodeEditor.cellMenu.CellContext;

public class IterateOperation_Editor extends DefaultNodeEditor {

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createCollection_7857_0(context, node);
  }

  public EditorCell createInspectedCell(EditorContext context, SNode node) {
    return this.createCollection_7857_1(context, node);
  }

  private EditorCell createCollection_7857_0(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    editorCell.setCellId("Collection_7857_0");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.addEditorCell(this.createReadOnlyModelAccessor_7857_0(context, node));
    editorCell.addEditorCell(this.createCollection_7857_3(context, node));
    return editorCell;
  }

  private EditorCell createCollection_7857_1(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createVertical(context, node);
    editorCell.setCellId("Collection_7857_1");
    editorCell.addEditorCell(this.createCollection_7857_5(context, node));
    editorCell.addEditorCell(this.createCollection_7857_2(context, node));
    return editorCell;
  }

  private EditorCell createCollection_7857_2(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    editorCell.setCellId("Collection_7857_2");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.addEditorCell(this.createConstant_7857_0(context, node, "used feature:"));
    editorCell.addEditorCell(this.createRefCell_7857_0(context, node));
    if (renderingCondition7857_3(node, context, context.getOperationContext().getScope())) {
      editorCell.addEditorCell(this.createCollection_7857_4(context, node));
    }
    return editorCell;
  }

  private EditorCell createCollection_7857_3(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    editorCell.setCellId("Collection_7857_3");
    if (renderingCondition7857_4(node, context, context.getOperationContext().getScope())) {
      editorCell.addEditorCell(this.createConstant_7857_4(context, node, "::"));
    }
    if (renderingCondition7857_0(node, context, context.getOperationContext().getScope())) {
      editorCell.addEditorCell(this.createConstant_7857_1(context, node, "*"));
    }
    if (renderingCondition7857_1(node, context, context.getOperationContext().getScope())) {
      editorCell.addEditorCell(this.createRefCell_7857_1(context, node));
    }
    if (renderingCondition7857_2(node, context, context.getOperationContext().getScope())) {
      editorCell.addEditorCell(this.createRefNode_7857_0(context, node));
    }
    return editorCell;
  }

  private EditorCell createCollection_7857_4(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    editorCell.setCellId("Collection_7857_4");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.addEditorCell(this.createConstant_7857_2(context, node, "/"));
    editorCell.addEditorCell(this.createRefNode_7857_1(context, node));
    return editorCell;
  }

  private EditorCell createCollection_7857_5(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    editorCell.setCellId("Collection_7857_5");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.addEditorCell(this.createConstant_7857_3(context, node, "iterate: "));
    editorCell.addEditorCell(this.createReadOnlyModelAccessor_7857_1(context, node));
    return editorCell;
  }

  private EditorCell createConstant_7857_0(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    editorCell.setCellId("Constant_7857_0");
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_7857_1(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    editorCell.setCellId("Constant_7857_1");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.TEXT_COLOR, MPSColors.blue);
      style.set(StyleAttributes.EDITABLE, false);
    }
    IterateOperation_DELETE.setCellActions(editorCell, node, context);
    editorCell.setDefaultText("");
    editorCell.setSubstituteInfo(new CompositeSubstituteInfo(context, new BasicCellContext(node), new SubstituteInfoPart[]{new IterateOperation_Editor.IterateOperation_component_cellMenu0()}));
    return editorCell;
  }

  private EditorCell createConstant_7857_2(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    editorCell.setCellId("Constant_7857_2");
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_7857_3(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    editorCell.setCellId("Constant_7857_3");
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_7857_4(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    editorCell.setCellId("Constant_7857_4");
    BaseLanguageStyle_StyleSheet.getDot(editorCell).apply(editorCell);
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createReadOnlyModelAccessor_7857_0(final EditorContext context, final SNode node) {
    EditorCell_Property editorCell = EditorCell_Property.create(context, new ModelAccessor() {

      public String getText() {
        return IterateOperation_Behavior.call_getAxisInternalValue_1213877293456(node);
      }

      public void setText(String s) {
      }

      public boolean isValidText(String s) {
        return EqualUtil.equals(s, this.getText());
      }
    }, node);
    editorCell.setAction(CellActionType.DELETE, new CellAction_Empty());
    editorCell.setCellId("ReadOnlyModelAccessor_7857_0");
    Collections_Style_StyleSheet.getOperation(editorCell).apply(editorCell);
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.EDITABLE, false);
      style.set(StyleAttributes.PUNCTUATION_LEFT, true);
      style.set(StyleAttributes.PUNCTUATION_RIGHT, true);
    }
    return editorCell;
  }

  private EditorCell createReadOnlyModelAccessor_7857_1(final EditorContext context, final SNode node) {
    EditorCell_Property editorCell = EditorCell_Property.create(context, new ModelAccessor() {

      public String getText() {
        return TraversalAxis.parseValue(SPropertyOperations.getString_def(node, "axis", "DESCENDANTS")).getName();
      }

      public void setText(String s) {
      }

      public boolean isValidText(String s) {
        return EqualUtil.equals(s, this.getText());
      }
    }, node);
    editorCell.setAction(CellActionType.DELETE, new CellAction_Empty());
    editorCell.setCellId("ReadOnlyModelAccessor_7857_1");
    return editorCell;
  }

  private EditorCell createRefCell_7857_0(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefCellCellProvider(node, context);
    provider.setRole("usedFeature");
    provider.setNoTargetText("<no usedFeature>");
    EditorCell editorCell;
    provider.setAuxiliaryCellProvider(new IterateOperation_Editor._Inline7857_0());
    editorCell = provider.createEditorCell(context);
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, editorCell);
    } else
    return editorCell;
  }

  private EditorCell createRefCell_7857_1(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefCellCellProvider(node, context);
    provider.setRole("usedFeature");
    provider.setNoTargetText("<no usedFeature>");
    EditorCell editorCell;
    provider.setAuxiliaryCellProvider(new IterateOperation_Editor._Inline7857_1());
    editorCell = provider.createEditorCell(context);
    IterateOperation_DELETE.setCellActions(editorCell, node, context);
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    editorCell.setSubstituteInfo(new CompositeSubstituteInfo(context, provider.getCellContext(), new SubstituteInfoPart[]{new IterateOperation_Editor.IterateOperation_component_cellMenu1()}));
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, editorCell);
    } else
    return editorCell;
  }

  private EditorCell createRefNode_7857_0(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, context);
    provider.setRole("paramObject");
    provider.setNoTargetText("<no paramObject>");
    EditorCell editorCell;
    editorCell = provider.createEditorCell(context);
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.FONT_STYLE, MPSFonts.ITALIC);
      style.set(StyleAttributes.TEXT_COLOR, MPSColors.gray);
    }
    IterateOperation_DELETE.setCellActions(editorCell, node, context);
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    editorCell.setSubstituteInfo(new CompositeSubstituteInfo(context, provider.getCellContext(), new SubstituteInfoPart[]{new IterateOperation_Editor.IterateOperation_component_cellMenu2()}));
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, editorCell);
    } else
    return editorCell;
  }

  private EditorCell createRefNode_7857_1(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, context);
    provider.setRole("paramObject");
    provider.setNoTargetText("<no paramObject>");
    EditorCell editorCell;
    editorCell = provider.createEditorCell(context);
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, editorCell);
    } else
    return editorCell;
  }


  private static boolean renderingCondition7857_0(SNode node, EditorContext editorContext, IScope scope) {
    return (SLinkOperations.getTarget(node, "usedFeature", false) == null);
  }

  private static boolean renderingCondition7857_1(SNode node, EditorContext editorContext, IScope scope) {
    return !((SLinkOperations.getTarget(node, "usedFeature", false) == null)) && !(SNodeOperations.isInstanceOf(SLinkOperations.getTarget(node, "usedFeature", false), "jetbrains.mps.ypath.structure.IParamFeature"));
  }

  private static boolean renderingCondition7857_2(SNode node, EditorContext editorContext, IScope scope) {
    return SNodeOperations.isInstanceOf(SLinkOperations.getTarget(node, "usedFeature", false), "jetbrains.mps.ypath.structure.IParamFeature");
  }

  private static boolean renderingCondition7857_3(SNode node, EditorContext editorContext, IScope scope) {
    return (SLinkOperations.getTarget(node, "paramObject", true) != null);
  }

  private static boolean renderingCondition7857_4(SNode node, EditorContext editorContext, IScope scope) {
    return !(TraversalAxisUtil.isAbbreviated(TraversalAxis.parseValue(SPropertyOperations.getString_def(node, "axis", "DESCENDANTS"))));
  }

  public static class _Inline7857_0 extends AbstractCellProvider {

    public _Inline7857_0() {
      super();
    }

    public EditorCell createEditorCell(EditorContext context) {
      return this.createEditorCell(context, this.getSNode());
    }

    public EditorCell createEditorCell(EditorContext context, SNode node) {
      return this.createProperty_7857_0(context, node);
    }

    private EditorCell createProperty_7857_0(EditorContext context, SNode node) {
      CellProviderWithRole provider = new PropertyCellProvider(node, context);
      provider.setRole("name");
      provider.setNoTargetText("<no name>");
      provider.setReadOnly(true);
      EditorCell editorCell;
      editorCell = provider.createEditorCell(context);
      editorCell.setCellId("property_name");
      {
        Style style = editorCell.getStyle();
        style.set(StyleAttributes.EDITABLE, false);
      }
      editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
      SNode attributeConcept = provider.getRoleAttribute();
      Class attributeKind = provider.getRoleAttributeClass();
      if (attributeConcept != null) {
        IOperationContext opContext = context.getOperationContext();
        EditorManager manager = EditorManager.getInstanceFromContext(opContext);
        return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, editorCell);
      } else
      return editorCell;
    }

}
  public static class _Inline7857_1 extends AbstractCellProvider {

    public _Inline7857_1() {
      super();
    }

    public EditorCell createEditorCell(EditorContext context) {
      return this.createEditorCell(context, this.getSNode());
    }

    public EditorCell createEditorCell(EditorContext context, SNode node) {
      return this.createProperty_7857_1(context, node);
    }

    private EditorCell createProperty_7857_1(EditorContext context, SNode node) {
      CellProviderWithRole provider = new PropertyCellProvider(node, context);
      provider.setRole("name");
      provider.setNoTargetText("<no name>");
      provider.setReadOnly(true);
      EditorCell editorCell;
      editorCell = provider.createEditorCell(context);
      editorCell.setCellId("property_name_1");
      {
        Style style = editorCell.getStyle();
        style.set(StyleAttributes.TEXT_COLOR, MPSColors.blue);
        style.set(StyleAttributes.EDITABLE, false);
      }
      editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
      SNode attributeConcept = provider.getRoleAttribute();
      Class attributeKind = provider.getRoleAttributeClass();
      if (attributeConcept != null) {
        IOperationContext opContext = context.getOperationContext();
        EditorManager manager = EditorManager.getInstanceFromContext(opContext);
        return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, editorCell);
      } else
      return editorCell;
    }

}
  public static class IterateOperation_component_cellMenu0 implements SubstituteInfoPart {

    private menu_SubstituteFeatureAndParameter myComponent;

    public IterateOperation_component_cellMenu0() {
      this.myComponent = new menu_SubstituteFeatureAndParameter();
    }

    public List<INodeSubstituteAction> createActions(CellContext cellContext, EditorContext editorContext) {
      return this.myComponent.createActions(cellContext, editorContext);
    }

}
  public static class IterateOperation_component_cellMenu1 implements SubstituteInfoPart {

    private menu_SubstituteFeatureAndParameter myComponent;

    public IterateOperation_component_cellMenu1() {
      this.myComponent = new menu_SubstituteFeatureAndParameter();
    }

    public List<INodeSubstituteAction> createActions(CellContext cellContext, EditorContext editorContext) {
      return this.myComponent.createActions(cellContext, editorContext);
    }

}
  public static class IterateOperation_component_cellMenu2 implements SubstituteInfoPart {

    private menu_SubstituteFeatureAndParameter myComponent;

    public IterateOperation_component_cellMenu2() {
      this.myComponent = new menu_SubstituteFeatureAndParameter();
    }

    public List<INodeSubstituteAction> createActions(CellContext cellContext, EditorContext editorContext) {
      return this.myComponent.createActions(cellContext, editorContext);
    }

}

}
