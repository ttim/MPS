package jetbrains.mps.lang.typesystem.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import jetbrains.mps.nodeEditor.cellProviders.CellProviderWithRole;
import jetbrains.mps.lang.editor.cellProviders.RefCellCellProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;
import jetbrains.mps.nodeEditor.InlineCellProvider;
import jetbrains.mps.nodeEditor.cells.ModelAccessor;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.nodeEditor.cells.EditorCell_Property;
import jetbrains.mps.nodeEditor.CellActionType;
import jetbrains.mps.nodeEditor.cellActions.CellAction_Empty;
import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.lang.editor.cellProviders.PropertyCellProvider;

public class InequationReference_Editor extends DefaultNodeEditor {
  public EditorCell createEditorCell(EditorContext editorContext, SNode node) {
    return this.createCollection_boi5ax_a(editorContext, node);
  }

  private EditorCell createCollection_boi5ax_a(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createIndent2(editorContext, node);
    editorCell.setCellId("Collection_boi5ax_a");
    editorCell.addEditorCell(this.createRefCell_boi5ax_a0(editorContext, node));
    return editorCell;
  }

  private EditorCell createRefCell_boi5ax_a0(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new RefCellCellProvider(node, editorContext);
    provider.setRole("inequation");
    provider.setNoTargetText("<no inequation>");
    EditorCell editorCell;
    provider.setAuxiliaryCellProvider(new InequationReference_Editor._Inline_boi5ax_a0a());
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

  public static class _Inline_boi5ax_a0a extends InlineCellProvider {
    public _Inline_boi5ax_a0a() {
      super();
    }

    public EditorCell createEditorCell(EditorContext editorContext) {
      return this.createEditorCell(editorContext, this.getSNode());
    }

    public EditorCell createEditorCell(EditorContext editorContext, SNode node) {
      return this.createCollection_boi5ax_a0a0(editorContext, node);
    }

    private EditorCell createCollection_boi5ax_a0a0(EditorContext editorContext, SNode node) {
      EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(editorContext, node);
      editorCell.setCellId("Collection_boi5ax_a0a0");
      editorCell.addEditorCell(this.createModelAccess_boi5ax_a0a0a(editorContext, node));
      editorCell.addEditorCell(this.createProperty_boi5ax_b0a0a(editorContext, node));
      return editorCell;
    }

    private EditorCell createModelAccess_boi5ax_a0a0a(final EditorContext editorContext, final SNode node) {
      ModelAccessor modelAccessor = new ModelAccessor() {
        public String getText() {
          return SModelOperations.getModelName(SNodeOperations.getModel(node)) + (SPropertyOperations.getString(SNodeOperations.as(SNodeOperations.getAncestor(node, null, false, true), "jetbrains.mps.lang.core.structure.INamedConcept"), "name"));
        }

        public void setText(String text) {
        }

        public boolean isValidText(String text) {
          return true;
        }
      };
      EditorCell_Property editorCell = EditorCell_Property.create(editorContext, modelAccessor, node);
      editorCell.setAction(CellActionType.DELETE, new CellAction_Empty());
      editorCell.setCellId("ModelAccess_boi5ax_a0a0a");
      {
        Style style = editorCell.getStyle();
        style.set(StyleAttributes.EDITABLE, false);
      }
      editorCell.setDefaultText("<no name>");
      return editorCell;
    }

    private EditorCell createProperty_boi5ax_b0a0a(EditorContext editorContext, SNode node) {
      CellProviderWithRole provider = new PropertyCellProvider(node, editorContext);
      provider.setRole("label");
      provider.setNoTargetText("<no label>");
      provider.setReadOnly(true);
      EditorCell editorCell;
      editorCell = provider.createEditorCell(editorContext);
      editorCell.setCellId("property_label");
      TypesystemStyles_StyleSheet.getInequationLabel(editorCell).apply(editorCell);
      {
        Style style = editorCell.getStyle();
        style.set(StyleAttributes.EDITABLE, false);
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
  }
}
