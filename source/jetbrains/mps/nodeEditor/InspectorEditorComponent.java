/*
 * Created by IntelliJ IDEA.
 * User: alshan
 * Date: Feb 25, 2004
 * Time: 2:04:52 PM
 */
package jetbrains.mps.nodeEditor;

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SNodeProxy;
import jetbrains.mps.project.MPSProject;

public class InspectorEditorComponent extends AbstractEditorComponent {
  private EditorContext myEditorContext;
  private SNodeProxy myNodeReference = new SNodeProxy(null);

  public InspectorEditorComponent(MPSProject project) {
    super(project);
    reinitEditor();
    rebuildEditorContent();
  }

  public SNode getNode() {
    return myNodeReference.getNode();
  }

  private void reinitEditor() {
    if (getNode() == null) {
      myEditorContext = new EditorContext(this, null, getProject());
    } else {
      myEditorContext = new EditorContext(this, getNode().getModel(), getProject());
    }
  }


  public void inspectNode(SNode semanticNode) {
    if (getNode() == semanticNode) {
      return;
    }
    myNodeReference = new SNodeProxy(semanticNode);
    reinitEditor();
    rebuildEditorContent();
    repaint();
  }

  public EditorContext getContext() {
    return myEditorContext;
  }

  public EditorCell createRootCell() {
    if (getNode() == null || getNode().isDeleted()) {
      return EditorCell_Constant.create(getContext(), null, "<no inspect info>", true);
    }
    return getProject().getComponent(EditorManager.class).createInspectedCell(getContext(), getNode());
  }

  public SNode getInspectedNode() {
    return getNode();
  }
}