package jetbrains.mps.build.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.AbstractCellProvider;

public class BuildLayout_Editor extends DefaultNodeEditor {
  public EditorCell createEditorCell(EditorContext editorContext, SNode node) {
    return this.createComponent_5wtg0a_a(editorContext, node);
  }

  private EditorCell createComponent_5wtg0a_a(EditorContext editorContext, SNode node) {
    AbstractCellProvider provider = new BuildLayout_containerElements(node);
    EditorCell editorCell = provider.createEditorCell(editorContext);
    return editorCell;
  }
}
