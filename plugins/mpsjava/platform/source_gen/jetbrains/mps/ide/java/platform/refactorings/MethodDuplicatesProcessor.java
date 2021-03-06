package jetbrains.mps.ide.java.platform.refactorings;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.util.plugin.refactorings.MethodMatch;
import jetbrains.mps.nodeEditor.EditorMessageOwner;
import jetbrains.mps.nodeEditor.EditorContext;
import java.util.List;
import jetbrains.mps.nodeEditor.EditorMessage;
import java.util.ArrayList;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.nodeEditor.DefaultEditorMessage;
import java.awt.Color;

public abstract class MethodDuplicatesProcessor extends DuplicatesProcessor<MethodMatch> {
  private EditorMessageOwner myOwner = new EditorMessageOwner() {};

  public MethodDuplicatesProcessor(EditorContext context) {
    super(context);
  }

  protected List<EditorMessage> createEditorMessages(MethodMatch duplicate) {
    List<EditorMessage> result = new ArrayList();
    for (SNode node : ListSequence.fromList(duplicate.getNodes())) {
      result.add(new DefaultEditorMessage(node, Color.BLUE, null, this.myOwner));
    }
    return result;
  }
}
