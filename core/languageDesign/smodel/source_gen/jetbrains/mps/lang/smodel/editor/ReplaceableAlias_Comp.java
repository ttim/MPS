package jetbrains.mps.lang.smodel.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.AbstractCellProvider;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.nodeEditor.cells.EditorCell_Error;
import jetbrains.mps.nodeEditor.cellProviders.CellProviderWithRole;
import jetbrains.mps.nodeEditor.cellMenu.CompositeSubstituteInfo;
import jetbrains.mps.nodeEditor.cellMenu.SubstituteInfoPart;
import jetbrains.mps.lang.editor.cellProviders.ConceptPropertyCellProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;
import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.nodeEditor.MPSFonts;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.editor.generator.internal.AbstractCellMenuPart_ReplaceNode_CustomNodeConcept;

public class ReplaceableAlias_Comp extends AbstractCellProvider {

  public ReplaceableAlias_Comp(SNode node) {
    super(node);
  }

  public EditorCell createEditorCell(EditorContext context) {
    return this.createEditorCell(context, this.getSNode());
  }

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createAlternation_3900_0(context, node);
  }

  public EditorCell createAlternation_3900_0(EditorContext context, SNode node) {
    boolean alternationCondition = true;
    alternationCondition = ReplaceableAlias_Comp.renderingCondition3900_0(node, context, context.getOperationContext().getScope());
    EditorCell editorCell = null;
    if (alternationCondition) {
      editorCell = this.createConceptProperty_3900_1(context, node);
    } else
    {
      editorCell = this.createError_3900_0(context, node);
    }
    setupBasic_Alternation_3900_0(editorCell, node, context);
    return editorCell;
  }

  public EditorCell createError_3900_0(EditorContext context, SNode node) {
    EditorCell_Error editorCell = new EditorCell_Error(context, node, "<choose operaion>");
    setupBasic_Error_3900_0(editorCell, node, context);
    return editorCell;
  }

  public EditorCell createConceptProperty_3900_0_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(null);
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_ConceptProperty_3900_0(editorCell, node, context);
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    editorCell.setSubstituteInfo(new CompositeSubstituteInfo(context, provider.getCellContext(), new SubstituteInfoPart[]{new ReplaceableAlias_Comp.ReplaceableAlias_Comp_replaceWith_SNodeOperation_cellMenu0()}));
    return editorCell;
  }

  public EditorCell createConceptProperty_3900_1(EditorContext context, SNode node) {
    CellProviderWithRole provider = new ConceptPropertyCellProvider(node, context);
    provider.setRole("alias");
    provider.setNoTargetText("<no alias>");
    EditorCell cellWithRole = this.createConceptProperty_3900_0_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }


  private static void setupBasic_Alternation_3900_0(EditorCell editorCell, SNode node, EditorContext context) {
  }

  private static void setupBasic_ConceptProperty_3900_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("conceptProperty_alias");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.FONT_STYLE, MPSFonts.BOLD);
    }
  }

  private static void setupBasic_Error_3900_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Error_3900_0");
  }

  public static boolean renderingCondition3900_0(SNode node, EditorContext editorContext, IScope scope) {
    return !(SConceptOperations.isExactly(SNodeOperations.getConceptDeclaration(node), "jetbrains.mps.lang.smodel.structure.SNodeOperation"));
  }

  public static class ReplaceableAlias_Comp_replaceWith_SNodeOperation_cellMenu0 extends AbstractCellMenuPart_ReplaceNode_CustomNodeConcept {

    public ReplaceableAlias_Comp_replaceWith_SNodeOperation_cellMenu0() {
    }

    public String getReplacementConceptName() {
      return "jetbrains.mps.lang.smodel.structure.SNodeOperation";
    }

}

}
