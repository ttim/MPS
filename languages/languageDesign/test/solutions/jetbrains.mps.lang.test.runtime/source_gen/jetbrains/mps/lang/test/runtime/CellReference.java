package jetbrains.mps.lang.test.runtime;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import java.util.Map;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.openapi.editor.Editor;
import jetbrains.mps.nodeEditor.NodeEditorComponent;
import jetbrains.mps.smodel.behaviour.BehaviorManager;
import jetbrains.mps.nodeEditor.EditorComponent;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.nodeEditor.selection.Selection;
import jetbrains.mps.nodeEditor.selection.SingularSelection;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import junit.framework.Assert;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.nodeEditor.cells.EditorCell_Label;
import jetbrains.mps.nodeEditor.selection.NodeRangeSelection;

public class CellReference {
  private SNode myNode;
  private SNode myAnnotation;
  private Map<SNode, SNode> myMap;

  public CellReference(SNode node, SNode annotation, Map<SNode, SNode> map) {
    this.myNode = node;
    this.myAnnotation = SNodeOperations.cast(annotation, "jetbrains.mps.lang.test.structure.AnonymousCellAnnotation");
    this.myMap = map;
  }

  public SNode getNode() {
    return this.myNode;
  }

  public String toString() {
    final Wrappers._T<String> result = new Wrappers._T<String>();
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        result.value = "(node " + CellReference.this.myNode.getId() + ", id " + SPropertyOperations.getString(CellReference.this.myAnnotation, "cellId") + ")";
      }
    });
    return result.value;
  }

  public void setupSelection(Editor editor) {
    NodeEditorComponent editorComponent = ((NodeEditorComponent) editor.getCurrentEditorComponent());
    BehaviorManager.getInstance().invoke(Object.class, this.myAnnotation, "call_setupSelection_6268941039745707957", new Class[]{SNode.class, NodeEditorComponent.class, SNode.class, Map.class}, editorComponent, this.myNode, this.myMap);
  }

  public void assertEditor(Editor editor, Map<SNode, SNode> map) {
    EditorComponent component = (EditorComponent) editor.getCurrentEditorComponent();
    if (SPropertyOperations.getBoolean(this.myAnnotation, "isInInspector")) {
      component = ((NodeEditorComponent) component).getInspector();
    }
    SLinkOperations.getTarget(myAnnotation, "nodeRangeSelectionEnd", false);

    Selection selection = component.getSelectionManager().getSelection();
    assert selection != null;
    if (selection instanceof SingularSelection) {
      EditorCell selectedCell = ((SingularSelection) selection).getEditorCell();
      Assert.assertSame(this.getNode(), MapSequence.fromMap(map).get(selectedCell.getSNode()));
      Assert.assertEquals(selectedCell.getCellId(), SPropertyOperations.getString(this.myAnnotation, "cellId"));
      if (selectedCell instanceof EditorCell_Label) {
        EditorCell_Label label = (EditorCell_Label) selectedCell;
        Assert.assertEquals(SPropertyOperations.getInteger(myAnnotation, "selectionStart"), label.getSelectionStart());
        Assert.assertEquals(SPropertyOperations.getInteger(myAnnotation, "selectionEnd"), label.getSelectionEnd());
      }
      Assert.assertNull(SLinkOperations.getTarget(myAnnotation, "nodeRangeSelectionStart", false));
      Assert.assertNull(SLinkOperations.getTarget(myAnnotation, "nodeRangeSelectionEnd", false));
    } else if (selection instanceof NodeRangeSelection) {
      NodeRangeSelection rangeSelection = (NodeRangeSelection) selection;
      Assert.assertNotNull(SLinkOperations.getTarget(myAnnotation, "nodeRangeSelectionStart", false));
      Assert.assertNotNull(SLinkOperations.getTarget(myAnnotation, "nodeRangeSelectionEnd", false));
      Assert.assertEquals(MapSequence.fromMap(myMap).get(SLinkOperations.getTarget(myAnnotation, "nodeRangeSelectionStart", false)), MapSequence.fromMap(map).get(rangeSelection.getFirstNode()));
      Assert.assertEquals(MapSequence.fromMap(myMap).get(SLinkOperations.getTarget(myAnnotation, "nodeRangeSelectionEnd", false)), MapSequence.fromMap(map).get(rangeSelection.getLastNode()));
    } else {
      if (selection != null) {
        Assert.fail("Selection of unsupported type: " + selection.getClass());
      } else {
        Assert.fail("Selection was not set in resulting editor");
      }
    }

  }
}
