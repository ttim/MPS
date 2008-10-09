package jetbrains.mps.baseLanguage.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.AbstractCellProvider;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.nodeEditor.cellProviders.CellProviderWithRole;
import jetbrains.mps.nodeEditor.cells.EditorCell_Label;
import jetbrains.mps.lang.editor.cellProviders.RefNodeCellProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;
import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.style.StyleAttributes;

public class _Component_Visibility extends AbstractCellProvider {

  public _Component_Visibility(SNode node) {
    super(node);
  }

  public EditorCell createEditorCell(EditorContext context) {
    return this.createEditorCell(context, this.getSNode());
  }

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createRefNode1178547765558(context, node);
  }

  public EditorCell createRefNode1178547765558_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(null);
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_refNode_visibility1178547765558(editorCell, node, context);
    if (editorCell instanceof EditorCell_Label) {
      setupLabel_refNode_visibility_1178547765558((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell createRefNode1178547765558(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, context);
    provider.setRole("visibility");
    provider.setNoTargetText("/*package*/");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createRefNode1178547765558_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }


  private static void setupBasic_refNode_visibility1178547765558(EditorCell editorCell, SNode node, EditorContext context) {
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.RT_ANCHOR_TAG, "ext_1_RTransform");
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupLabel_refNode_visibility_1178547765558(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

}
