package jetbrains.mps.ide.editor;

/*Generated by MPS */

import org.jetbrains.annotations.Nullable;
import jetbrains.mps.nodeEditor.EditorComponent;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.smodel.SNode;
import com.intellij.openapi.fileEditor.FileEditorManager;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import java.util.List;
import jetbrains.mps.smodel.ModelAccess;
import java.util.ArrayList;
import jetbrains.mps.nodeEditor.inspector.InspectorEditorComponent;
import java.util.Collections;
import jetbrains.mps.nodeEditor.highlighter.EditorsHelper;
import jetbrains.mps.nodeEditor.InspectorTool;

public class EditorUtil {
  public EditorUtil() {
  }

  @Nullable
  public static EditorComponent scrollToNode(@NotNull SNode node, @Nullable EditorComponent component, FileEditorManager manager) {
    EditorComponent inspector = EditorUtil.findInspector(manager);
    if (inspector != null && component != null) {
      boolean searchInInspector = false;
      SNode currentTargetNode = node;
      while (currentTargetNode != null) {
        EditorCell cell = component.findNodeCell(currentTargetNode);
        if (cell != null) {
          if (currentTargetNode != node) {
            //  so we are probably in inspector... 
            //  we need to select to find a node in inspector 
            component.changeSelection(cell);
            searchInInspector = true;
          }
          break;
        }
        currentTargetNode = currentTargetNode.getParent();
      }
      currentTargetNode = node;
      while (currentTargetNode != null && searchInInspector) {
        EditorCell cellInInspector = inspector.findNodeCell(currentTargetNode);
        if (cellInInspector != null) {
          inspector.scrollToCell(cellInInspector);
          return inspector;
        }
        currentTargetNode = currentTargetNode.getParent();
      }
    }
    if (component == null) {
      return null;
    }
    component.scrollToNode(node);
    return component;
  }

  @NotNull
  public static List<EditorComponent> findComponentForNode(SNode node, FileEditorManager fileEditorManager) {
    ModelAccess.assertLegalRead();
    List<EditorComponent> result = new ArrayList<EditorComponent>();
    EditorComponent inspector = EditorUtil.findInspector(fileEditorManager);
    if (inspector != null) {
      if (EditorUtil.isNodeShownInTheComponent(inspector, node)) {
        result.add(inspector);
      }
    }
    for (EditorComponent editorComponent : EditorUtil.getAllEditorComponents(fileEditorManager, false)) {
      if (EditorUtil.isNodeShownInTheComponent(editorComponent, node)) {
        result.add(editorComponent);
      }
    }
    return result;
  }

  public static boolean isNodeShownInTheComponent(@NotNull EditorComponent component, @NotNull SNode node) {
    if (component instanceof InspectorEditorComponent) {
      SNode editedNode = component.getEditedNode();
      return editedNode != null && editedNode.isAncestorOf(node) && (editedNode != node);
    } else {
      return component.getEditedNode() == node.getContainingRoot();
    }
  }

  public static List<EditorComponent> getAllEditorComponents(FileEditorManager manager, boolean includeInspector) {
    if (manager.getProject().isDisposed()) {
      return Collections.emptyList();
    }
    List<EditorComponent> result = new ArrayList<EditorComponent>();
    if (includeInspector) {
      EditorComponent inspector = EditorUtil.findInspector(manager);
      if (inspector != null) {
        result.add(inspector);
      }
    }
    List<MPSFileNodeEditor> allEditors = EditorsHelper.getAllEditors(manager);
    for (MPSFileNodeEditor editor : allEditors) {
      EditorComponent currentEditorComponent = (EditorComponent) editor.getNodeEditor().getCurrentEditorComponent();
      if (currentEditorComponent != null) {
        result.add(currentEditorComponent);
      }
    }
    return result;
  }

  @Nullable
  public static EditorComponent findInspector(FileEditorManager manager) {
    if (manager.getProject().isDisposed()) {
      return null;
    }
    InspectorTool tool = manager.getProject().getComponent(InspectorTool.class);
    if (tool == null) {
      return null;
    }
    return tool.getInspector();
  }
}
