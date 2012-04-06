package jetbrains.mps.build.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import jetbrains.mps.nodeEditor.cells.EditorCell_Constant;
import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.nodeEditor.cellMenu.CompositeSubstituteInfo;
import jetbrains.mps.nodeEditor.cellMenu.BasicCellContext;
import jetbrains.mps.nodeEditor.cellMenu.SubstituteInfoPart;
import jetbrains.mps.nodeEditor.cellProviders.CellProviderWithRole;
import jetbrains.mps.lang.editor.cellProviders.RefCellCellProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;
import jetbrains.mps.lang.editor.generator.internal.AbstractCellMenuPart_ReplaceNode_CustomNodeConcept;
import jetbrains.mps.nodeEditor.InlineCellProvider;
import jetbrains.mps.nodeEditor.cells.EditorCell_Property;
import jetbrains.mps.nodeEditor.cells.EditorCell_RefPresentation;

public class BuildLayout_Import_Editor extends DefaultNodeEditor {
  public EditorCell createEditorCell(EditorContext editorContext, SNode node) {
    return this.createCollection_4dmy40_a(editorContext, node);
  }

  private EditorCell createCollection_4dmy40_a(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createIndent2(editorContext, node);
    editorCell.setCellId("Collection_4dmy40_a");
    editorCell.addEditorCell(this.createConstant_4dmy40_a0(editorContext, node));
    editorCell.addEditorCell(this.createRefCell_4dmy40_b0(editorContext, node));
    return editorCell;
  }

  private EditorCell createConstant_4dmy40_a0(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "import");
    editorCell.setCellId("Constant_4dmy40_a0");
    buildStyles_StyleSheet.getKeyword(editorCell).apply(editorCell);
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.EDITABLE, true);
    }
    editorCell.setDefaultText("");
    editorCell.setSubstituteInfo(new CompositeSubstituteInfo(editorContext, new BasicCellContext(node), new SubstituteInfoPart[]{new BuildLayout_Import_Editor.ReplaceWith_BuildLayout_Node_cellMenu_a0a0()}));
    return editorCell;
  }

  private EditorCell createRefCell_4dmy40_b0(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new RefCellCellProvider(node, editorContext);
    provider.setRole("target");
    provider.setNoTargetText("<no target>");
    EditorCell editorCell;
    provider.setAuxiliaryCellProvider(new BuildLayout_Import_Editor._Inline_4dmy40_a1a());
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

  public static class ReplaceWith_BuildLayout_Node_cellMenu_a0a0 extends AbstractCellMenuPart_ReplaceNode_CustomNodeConcept {
    public ReplaceWith_BuildLayout_Node_cellMenu_a0a0() {
    }

    public String getReplacementConceptName() {
      return "jetbrains.mps.build.structure.BuildLayout_Node";
    }
  }

  public static class _Inline_4dmy40_a1a extends InlineCellProvider {
    public _Inline_4dmy40_a1a() {
      super();
    }

    public EditorCell createEditorCell(EditorContext editorContext) {
      return this.createEditorCell(editorContext, this.getSNode());
    }

    public EditorCell createEditorCell(EditorContext editorContext, SNode node) {
      return this.createReferencePresentation_4dmy40_a0b0(editorContext, node);
    }

    private EditorCell createReferencePresentation_4dmy40_a0b0(EditorContext editorContext, SNode node) {
      EditorCell_Property editorCell = EditorCell_RefPresentation.create(editorContext, node, this.getRefNode(), this.getLinkDeclaration());
      editorCell.setCellId("ReferencePresentation_4dmy40_a0b0");
      return editorCell;
    }
  }
}
