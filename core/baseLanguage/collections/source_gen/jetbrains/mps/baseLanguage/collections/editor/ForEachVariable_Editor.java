package jetbrains.mps.baseLanguage.collections.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.nodeEditor.cellProviders.CellProviderWithRole;
import jetbrains.mps.lang.editor.cellProviders.PropertyCellProvider;
import jetbrains.mps.nodeEditor.cellMenu.CompositeSubstituteInfo;
import jetbrains.mps.nodeEditor.cellMenu.SubstituteInfoPart;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;
import jetbrains.mps.lang.editor.generator.internal.AbstractCellMenuPart_PropertyPostfixHints;
import java.util.List;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.baseLanguage.behavior.Type_Behavior;

public class ForEachVariable_Editor extends DefaultNodeEditor {
  public EditorCell createEditorCell(EditorContext editorContext, SNode node) {
    return this.createCollection_ufuydf_a(editorContext, node);
  }

  private EditorCell createCollection_ufuydf_a(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createIndent2(editorContext, node);
    editorCell.setCellId("Collection_ufuydf_a");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.addEditorCell(this.createProperty_ufuydf_a0(editorContext, node));
    return editorCell;
  }

  private EditorCell createProperty_ufuydf_a0(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new PropertyCellProvider(node, editorContext);
    provider.setRole("name");
    provider.setNoTargetText("<no name>");
    EditorCell editorCell;
    editorCell = provider.createEditorCell(editorContext);
    editorCell.setCellId("property_name");
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    editorCell.setSubstituteInfo(new CompositeSubstituteInfo(editorContext, provider.getCellContext(), new SubstituteInfoPart[]{new ForEachVariable_Editor.ForEachVariable_name_postfixCellMenu_a0a0()}));
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = editorContext.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(editorContext, attributeConcept, attributeKind, editorCell);
    } else
    return editorCell;
  }

  public static class ForEachVariable_name_postfixCellMenu_a0a0 extends AbstractCellMenuPart_PropertyPostfixHints {
    public ForEachVariable_name_postfixCellMenu_a0a0() {
    }

    public List<String> getPostfixes(SNode node, IScope scope, IOperationContext operationContext) {
      List<String> postfixes = ListSequence.fromList(new ArrayList<String>());
      if (SNodeOperations.isInstanceOf(TypeChecker.getInstance().getTypeOf(node), "jetbrains.mps.baseLanguage.structure.Type")) {
        ListSequence.fromList(postfixes).addSequence(ListSequence.fromList(Type_Behavior.call_getVariableSuffixes_1213877337304(SNodeOperations.cast(TypeChecker.getInstance().getTypeOf(node), "jetbrains.mps.baseLanguage.structure.Type"))));
      }
      return postfixes;
    }
  }
}
