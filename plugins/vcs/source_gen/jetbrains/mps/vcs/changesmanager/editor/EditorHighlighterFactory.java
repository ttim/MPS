package jetbrains.mps.vcs.changesmanager.editor;

/*Generated by MPS */

import com.intellij.openapi.components.AbstractProjectComponent;
import java.util.Map;
import jetbrains.mps.nodeEditor.EditorComponent;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.HashMap;
import com.intellij.util.messages.MessageBusConnection;
import com.intellij.openapi.project.Project;
import jetbrains.mps.nodeEditor.highlighter.EditorComponentCreateListener;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.nodeEditor.NodeEditorComponent;
import jetbrains.mps.nodeEditor.InspectorTool;

public class EditorHighlighterFactory extends AbstractProjectComponent {
  private Map<EditorComponent, EditorHighlighter> myEditorsHighlighters = MapSequence.fromMap(new HashMap<EditorComponent, EditorHighlighter>());
  private MessageBusConnection myMessageBusConnection;

  public EditorHighlighterFactory(Project project) {
    super(project);
  }

  @Override
  public void projectOpened() {
    myMessageBusConnection = myProject.getMessageBus().connect();
    myMessageBusConnection.subscribe(EditorComponentCreateListener.EDITOR_COMPONENT_CREATION, new EditorHighlighterFactory.MyEditorComponentCreateListener());
  }

  @Override
  public void projectClosed() {
    myMessageBusConnection.disconnect();
  }

  private void addHighighlighterIfNeeded(@NotNull EditorComponent editorComponent) {
    if (editorComponent instanceof NodeEditorComponent || editorComponent == myProject.getComponent(InspectorTool.class).getInspector()) {
      MapSequence.fromMap(myEditorsHighlighters).put(editorComponent, new EditorHighlighter(myProject, editorComponent));
    }
  }

  private void disposeHighlighterIfNeeded(@NotNull EditorComponent editorComponent) {
    if (MapSequence.fromMap(myEditorsHighlighters).containsKey(editorComponent)) {
      MapSequence.fromMap(myEditorsHighlighters).get(editorComponent).dispose();
      MapSequence.fromMap(myEditorsHighlighters).removeKey(editorComponent);
    }
  }

  public EditorHighlighter getHighlighter(@NotNull EditorComponent editorComponent) {
    return MapSequence.fromMap(myEditorsHighlighters).get(editorComponent);
  }

  private class MyEditorComponentCreateListener implements EditorComponentCreateListener {
    public MyEditorComponentCreateListener() {
    }

    public void editorComponentCreated(@NotNull EditorComponent editorComponent) {
      addHighighlighterIfNeeded(editorComponent);
    }

    public void editorComponentDisposed(@NotNull EditorComponent editorComponent) {
      disposeHighlighterIfNeeded(editorComponent);
    }
  }
}
