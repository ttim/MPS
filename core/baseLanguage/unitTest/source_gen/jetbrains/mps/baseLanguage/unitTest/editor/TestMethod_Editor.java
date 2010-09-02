package jetbrains.mps.baseLanguage.unitTest.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import jetbrains.mps.nodeEditor.AbstractCellProvider;
import jetbrains.mps.baseLanguage.editor._DeprecatedPart;
import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.baseLanguage.editor.HasAnnotation_AnnotationComponent;
import jetbrains.mps.baseLanguage.editor.BaseMethodDeclaration_BodyComponent;
import jetbrains.mps.nodeEditor.cells.EditorCell_Constant;
import jetbrains.mps.baseLanguage.editor.BaseLanguageStyle_StyleSheet;
import jetbrains.mps.nodeEditor.cellProviders.CellProviderWithRole;
import jetbrains.mps.lang.editor.cellProviders.PropertyCellProvider;
import jetbrains.mps.nodeEditor.style.Padding;
import jetbrains.mps.nodeEditor.style.Measure;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;
import jetbrains.mps.smodel.IScope;
import java.util.List;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;

public class TestMethod_Editor extends DefaultNodeEditor {
  public EditorCell createEditorCell(EditorContext editorContext, SNode node) {
    return this.createCollection_ml6tu4_a(editorContext, node);
  }

  private EditorCell createCollection_ml6tu4_a(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createIndent2(editorContext, node);
    editorCell.setCellId("Collection_ml6tu4_a");
    editorCell.addEditorCell(this.createComponent_ml6tu4_a0(editorContext, node));
    editorCell.addEditorCell(this.createComponent_ml6tu4_b0(editorContext, node));
    editorCell.addEditorCell(this.createConstant_ml6tu4_c0(editorContext, node));
    editorCell.addEditorCell(this.createProperty_ml6tu4_d0(editorContext, node));
    editorCell.addEditorCell(this.createComponent_ml6tu4_e0(editorContext, node));
    if (renderingCondition_ml6tu4_a5a(node, editorContext, editorContext.getOperationContext().getScope())) {
      editorCell.addEditorCell(this.createConstant_ml6tu4_f0(editorContext, node));
    }
    return editorCell;
  }

  private EditorCell createComponent_ml6tu4_a0(EditorContext editorContext, SNode node) {
    AbstractCellProvider provider = new _DeprecatedPart(node);
    EditorCell editorCell = provider.createEditorCell(editorContext);
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.INDENT_LAYOUT_NEW_LINE, true);
    }
    return editorCell;
  }

  private EditorCell createComponent_ml6tu4_b0(EditorContext editorContext, SNode node) {
    AbstractCellProvider provider = new HasAnnotation_AnnotationComponent(node);
    EditorCell editorCell = provider.createEditorCell(editorContext);
    return editorCell;
  }

  private EditorCell createComponent_ml6tu4_e0(EditorContext editorContext, SNode node) {
    AbstractCellProvider provider = new BaseMethodDeclaration_BodyComponent(node);
    EditorCell editorCell = provider.createEditorCell(editorContext);
    return editorCell;
  }

  private EditorCell createConstant_ml6tu4_c0(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "test");
    editorCell.setCellId("Constant_ml6tu4_c0");
    BaseLanguageStyle_StyleSheet.getKeyWord(editorCell).apply(editorCell);
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_ml6tu4_f0(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "");
    editorCell.setCellId("Constant_ml6tu4_f0");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
      style.set(StyleAttributes.INDENT_LAYOUT_NEW_LINE, true);
    }
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createProperty_ml6tu4_d0(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new PropertyCellProvider(node, editorContext);
    provider.setRole("methodName");
    provider.setNoTargetText("<no methodName>");
    EditorCell editorCell;
    editorCell = provider.createEditorCell(editorContext);
    editorCell.setCellId("property_methodName");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.PADDING_RIGHT, new Padding(0.0, Measure.SPACES));
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

  private static boolean renderingCondition_ml6tu4_a5a(SNode node, EditorContext editorContext, IScope scope) {
    List<SNode> nextSiblings = SNodeOperations.getNextSiblings(node, false);
    return ListSequence.fromList(nextSiblings).isNotEmpty();
  }
}
