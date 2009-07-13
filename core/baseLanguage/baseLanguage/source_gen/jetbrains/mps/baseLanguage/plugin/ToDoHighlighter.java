package jetbrains.mps.baseLanguage.plugin;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.EditorCheckerAdapter;
import java.util.Set;
import jetbrains.mps.nodeEditor.EditorMessage;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.IOperationContext;
import java.util.List;
import jetbrains.mps.smodel.event.SModelEvent;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import java.util.LinkedHashSet;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.baseLanguage.behavior.RemarkStatement_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.smodel.event.SModelPropertyEvent;

public class ToDoHighlighter extends EditorCheckerAdapter {

  public ToDoHighlighter() {
  }

  public Set<EditorMessage> createMessages(SNode rootNode, IOperationContext operationContext, List<SModelEvent> events, boolean wasCheckedOnce) {
    Set<EditorMessage> messages = SetSequence.fromSet(new LinkedHashSet<EditorMessage>());
    SNode node = rootNode;
    for(SNode remark : SNodeOperations.getDescendants(node, "jetbrains.mps.baseLanguage.structure.RemarkStatement", false, new String[]{})) {
      if (RemarkStatement_Behavior.call_isTodo_1213877427548(remark)) {
        SetSequence.fromSet(messages).addElement(new ToDoMessage(remark, SPropertyOperations.getString(remark, "value"), this.getOwner(rootNode)));
      }
    }
    return messages;
  }

  public boolean isPropertyEventDramatical(SModelPropertyEvent propertyEvent) {
    SNode node = propertyEvent.getNode();
    if (SNodeOperations.isInstanceOf(node, "jetbrains.mps.baseLanguage.structure.RemarkStatement")) {
      if (propertyEvent.getPropertyName().equals("value")) {
        return true;
      }
    }
    return false;
  }

}
