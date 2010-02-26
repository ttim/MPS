package jetbrains.mps.lang.generator.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import jetbrains.mps.nodeEditor.AbstractCellProvider;
import jetbrains.mps.nodeEditor.cells.EditorCell_Constant;
import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.nodeEditor.FocusPolicy;
import jetbrains.mps.nodeEditor.cellMenu.CompositeSubstituteInfo;
import jetbrains.mps.nodeEditor.cellMenu.BasicCellContext;
import jetbrains.mps.nodeEditor.cellMenu.SubstituteInfoPart;
import jetbrains.mps.lang.editor.generator.internal.AbstractCellMenuPart_ReplaceNode_CustomNodeConcept;

public class CopySrcNodeMacro_Editor extends DefaultNodeEditor {
  public EditorCell createEditorCell(EditorContext editorContext, SNode node) {
    return this.createCollection_jiideg_a(editorContext, node);
  }

  public EditorCell createInspectedCell(EditorContext editorContext, SNode node) {
    return this.createComponent_jiideg_a(editorContext, node);
  }

  private EditorCell createCollection_jiideg_a(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(editorContext, node);
    editorCell.setCellId("Collection_jiideg_a");
    editorCell.addEditorCell(this.createConstant_jiideg_a0(editorContext, node));
    editorCell.addEditorCell(this.createComponent_jiideg_b0(editorContext, node));
    return editorCell;
  }

  private EditorCell createComponent_jiideg_a(EditorContext editorContext, SNode node) {
    AbstractCellProvider provider = new CopyScrNodeMacro_inspector(node);
    EditorCell editorCell = provider.createEditorCell(editorContext);
    return editorCell;
  }

  private EditorCell createComponent_jiideg_b0(EditorContext editorContext, SNode node) {
    AbstractCellProvider provider = new NodeMacro_postfix(node);
    EditorCell editorCell = provider.createEditorCell(editorContext);
    return editorCell;
  }

  private EditorCell createConstant_jiideg_a0(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "$COPY_SRC$");
    editorCell.setCellId("Constant_jiideg_a0");
    Styles_StyleSheet.getMacroStart(editorCell).apply(editorCell);
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.PUNCTUATION_RIGHT, true);
    }
    if (true) {
      editorCell.setFocusPolicy(FocusPolicy.ATTRACTS_FOCUS);
    }
    MacroSymbol_Actions.setCellActions(editorCell, node, editorContext);
    editorCell.setDefaultText("");
    editorCell.setSubstituteInfo(new CompositeSubstituteInfo(editorContext, new BasicCellContext(node), new SubstituteInfoPart[]{new CopySrcNodeMacro_Editor.CopySrcNodeMacro_Editor_replaceWith_NodeMacro_cellMenu_a0a0()}));
    return editorCell;
  }

  public static class CopySrcNodeMacro_Editor_replaceWith_NodeMacro_cellMenu_a0a0 extends AbstractCellMenuPart_ReplaceNode_CustomNodeConcept {
    public CopySrcNodeMacro_Editor_replaceWith_NodeMacro_cellMenu_a0a0() {
    }

    public String getReplacementConceptName() {
      return "jetbrains.mps.lang.generator.structure.NodeMacro";
    }
  }
}
