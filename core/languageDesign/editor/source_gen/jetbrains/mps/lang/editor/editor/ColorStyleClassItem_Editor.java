package jetbrains.mps.lang.editor.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import jetbrains.mps.nodeEditor.cells.EditorCell_Constant;
import jetbrains.mps.nodeEditor.cellProviders.CellProviderWithRole;
import jetbrains.mps.nodeEditor.cells.EditorCell_Label;
import jetbrains.mps.nodeEditor.cellMenu.CompositeSubstituteInfo;
import jetbrains.mps.nodeEditor.cellMenu.SubstituteInfoPart;
import jetbrains.mps.lang.editor.cellProviders.ConceptPropertyCellProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;
import jetbrains.mps.lang.editor.cellProviders.PropertyCellProvider;
import jetbrains.mps.lang.editor.cellProviders.RefNodeCellProvider;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.editor.generator.internal.AbstractCellMenuPart_ReplaceNode_CustomNodeConcept;
import jetbrains.mps.lang.editor.generator.internal.AbstractCellMenuPart_Generic_Group;
import java.util.List;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SEnumOperations;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.editor.generator.internal.AbstractCellMenuPart_Generic_Item;

public class ColorStyleClassItem_Editor extends DefaultNodeEditor {

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createCollection_4607_0(context, node);
  }

  public EditorCell createCollection_4607_0(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    setupBasic_Collection_4607_0(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createConceptProperty_4607_1(context, node));
    editorCell.addEditorCell(this.createConstant_4607_0(context, node, ":"));
    if (renderingCondition4607_0(node, context, context.getOperationContext().getScope())) {
      editorCell.addEditorCell(this.createProperty_4607_1(context, node));
    }
    if (renderingCondition4607_1(node, context, context.getOperationContext().getScope())) {
      editorCell.addEditorCell(this.createRefNode_4607_1(context, node));
    }
    return editorCell;
  }

  public EditorCell createConstant_4607_0(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_4607_0(editorCell, node, context);
    setupLabel_Constant_4607_0(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConceptProperty_4607_0_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(null);
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_ConceptProperty_4607_0(editorCell, node, context);
    if (editorCell instanceof EditorCell_Label) {
      setupLabel_ConceptProperty_4607_0((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    editorCell.setSubstituteInfo(new CompositeSubstituteInfo(context, provider.getCellContext(), new SubstituteInfoPart[]{new ColorStyleClassItem_Editor.ColorStyleClassItem_Editor_replaceWith_StyleClassItem_cellMenu0()}));
    return editorCell;
  }

  public EditorCell createConceptProperty_4607_1(EditorContext context, SNode node) {
    CellProviderWithRole provider = new ConceptPropertyCellProvider(node, context);
    provider.setRole("alias");
    provider.setNoTargetText("<no alias>");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createConceptProperty_4607_0_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }

  public EditorCell createProperty_4607_0_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(null);
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_Property_4607_0(editorCell, node, context);
    if (editorCell instanceof EditorCell_Label) {
      setupLabel_Property_4607_0((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    editorCell.setSubstituteInfo(new CompositeSubstituteInfo(context, provider.getCellContext(), new SubstituteInfoPart[]{new ColorStyleClassItem_Editor.ColorStyleClassItem_generic_cellMenu0(),new ColorStyleClassItem_Editor.ColorStyleClassItem_generic_cellMenu2(),new ColorStyleClassItem_Editor.ColorStyleClassItem_generic_cellMenu3()}));
    return editorCell;
  }

  public EditorCell createProperty_4607_1(EditorContext context, SNode node) {
    CellProviderWithRole provider = new PropertyCellProvider(node, context);
    provider.setRole("color");
    provider.setNoTargetText("<no color>");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createProperty_4607_0_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }

  public EditorCell createRefNode_4607_0_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(null);
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_RefNode_4607_0(editorCell, node, context);
    if (editorCell instanceof EditorCell_Label) {
      setupLabel_RefNode_4607_0((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    editorCell.setSubstituteInfo(new CompositeSubstituteInfo(context, provider.getCellContext(), new SubstituteInfoPart[]{new ColorStyleClassItem_Editor.ColorStyleClassItem_generic_cellMenu1(),new ColorStyleClassItem_Editor.ColorStyleClassItem_generic_cellMenu4(),new ColorStyleClassItem_Editor.ColorStyleClassItem_generic_cellMenu5()}));
    return editorCell;
  }

  public EditorCell createRefNode_4607_1(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, context);
    provider.setRole("query");
    provider.setNoTargetText("<no query>");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createRefNode_4607_0_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }


  private static void setupBasic_Collection_4607_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Collection_4607_0");
  }

  private static void setupBasic_ConceptProperty_4607_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("conceptProperty_alias");
    Styles_StyleSheet.getItem(editorCell).apply(editorCell);
  }

  private static void setupBasic_Constant_4607_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_4607_0");
  }

  private static void setupBasic_Property_4607_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("property_color");
  }

  private static void setupBasic_RefNode_4607_0(EditorCell editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_ConceptProperty_4607_0(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_4607_0(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Property_4607_0(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_RefNode_4607_0(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  public static boolean renderingCondition4607_0(SNode node, EditorContext editorContext, IScope scope) {
    return SLinkOperations.getTarget(node, "query", true) == null;
  }

  public static boolean renderingCondition4607_1(SNode node, EditorContext editorContext, IScope scope) {
    return SLinkOperations.getTarget(node, "query", true) != null;
  }

  public static class ColorStyleClassItem_Editor_replaceWith_StyleClassItem_cellMenu0 extends AbstractCellMenuPart_ReplaceNode_CustomNodeConcept {

    public ColorStyleClassItem_Editor_replaceWith_StyleClassItem_cellMenu0() {
    }

    public String getReplacementConceptName() {
      return "jetbrains.mps.lang.editor.structure.StyleClassItem";
    }

}
  public static class ColorStyleClassItem_generic_cellMenu0 extends AbstractCellMenuPart_Generic_Group {

    public ColorStyleClassItem_generic_cellMenu0() {
    }

    public List<?> createParameterObjects(SNode node, IScope scope, IOperationContext operationContext) {
      return SEnumOperations.getEnumMembers(SEnumOperations.getEnum("r:00000000-0000-4000-0000-011c8959029e(jetbrains.mps.lang.editor.structure)", "1083952545109"));
    }

    public void handleAction(Object parameterObject, SNode node, SModel model, IScope scope, IOperationContext operationContext) {
      this.handleAction_impl((SNode)parameterObject, node, model, scope, operationContext);
    }

    public void handleAction_impl(SNode parameterObject, SNode node, SModel model, IScope scope, IOperationContext operationContext) {
      SNodeOperations.detachNode(SLinkOperations.getTarget(node, "query", true));
      SPropertyOperations.set(node, "color", "" + (SEnumOperations.getEnumMemberValue(parameterObject)));
    }

    public boolean isReferentPresentation() {
      return false;
    }

}
  public static class ColorStyleClassItem_generic_cellMenu1 extends AbstractCellMenuPart_Generic_Group {

    public ColorStyleClassItem_generic_cellMenu1() {
    }

    public List<?> createParameterObjects(SNode node, IScope scope, IOperationContext operationContext) {
      return SEnumOperations.getEnumMembers(SEnumOperations.getEnum("r:00000000-0000-4000-0000-011c8959029e(jetbrains.mps.lang.editor.structure)", "1083952545109"));
    }

    public void handleAction(Object parameterObject, SNode node, SModel model, IScope scope, IOperationContext operationContext) {
      this.handleAction_impl((SNode)parameterObject, node, model, scope, operationContext);
    }

    public void handleAction_impl(SNode parameterObject, SNode node, SModel model, IScope scope, IOperationContext operationContext) {
      SNodeOperations.detachNode(SLinkOperations.getTarget(node, "query", true));
      SPropertyOperations.set(node, "color", "" + (SEnumOperations.getEnumMemberValue(parameterObject)));
    }

    public boolean isReferentPresentation() {
      return false;
    }

}
  public static class ColorStyleClassItem_generic_cellMenu2 extends AbstractCellMenuPart_Generic_Item {

    public ColorStyleClassItem_generic_cellMenu2() {
    }

    public void handleAction(SNode node, SModel model, IScope scope, IOperationContext operationContext) {
      SLinkOperations.setNewChild(node, "query", "jetbrains.mps.lang.editor.structure.RGBColor");
    }

    public String getMatchingText() {
      return "#RRGGBB";
    }

}
  public static class ColorStyleClassItem_generic_cellMenu3 extends AbstractCellMenuPart_Generic_Item {

    public ColorStyleClassItem_generic_cellMenu3() {
    }

    public void handleAction(SNode node, SModel model, IScope scope, IOperationContext operationContext) {
      SLinkOperations.setNewChild(node, "query", "jetbrains.mps.lang.editor.structure.QueryFunction_Color");
    }

    public String getMatchingText() {
      return "query";
    }

}
  public static class ColorStyleClassItem_generic_cellMenu4 extends AbstractCellMenuPart_Generic_Item {

    public ColorStyleClassItem_generic_cellMenu4() {
    }

    public void handleAction(SNode node, SModel model, IScope scope, IOperationContext operationContext) {
      SLinkOperations.setNewChild(node, "query", "jetbrains.mps.lang.editor.structure.RGBColor");
    }

    public String getMatchingText() {
      return "#RRGGBB";
    }

}
  public static class ColorStyleClassItem_generic_cellMenu5 extends AbstractCellMenuPart_Generic_Item {

    public ColorStyleClassItem_generic_cellMenu5() {
    }

    public void handleAction(SNode node, SModel model, IScope scope, IOperationContext operationContext) {
      SLinkOperations.setNewChild(node, "query", "jetbrains.mps.lang.editor.structure.QueryFunction_Color");
    }

    public String getMatchingText() {
      return "query";
    }

}

}
