package jetbrains.mps.lang.core.pluginSolution.plugin;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.checking.EditorCheckerAdapter;
import java.util.Set;
import jetbrains.mps.nodeEditor.EditorMessage;
import jetbrains.mps.smodel.SNode;
import java.util.List;
import jetbrains.mps.smodel.event.SModelEvent;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import java.util.LinkedHashSet;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.AttributeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.IAttributeDescriptor;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;

public class SuppressErrorsChecker extends EditorCheckerAdapter {
  public SuppressErrorsChecker() {
  }

  protected Set<EditorMessage> createMessages(SNode root, List<SModelEvent> list, boolean b, EditorContext context) {
    Set<EditorMessage> messages = SetSequence.fromSet(new LinkedHashSet<EditorMessage>());
    SNode node = root;
    for (SNode n : SNodeOperations.getDescendants(node, null, false, new String[]{})) {
      if (AttributeOperations.getAttribute(n, new IAttributeDescriptor.NodeAttribute(SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.core.structure.SuppressErrorsAnnotation"))) != null) {
        SetSequence.fromSet(messages).addElement(new SuppressErrorsMessage(n, this, "Errors suppressed"));
      }
    }
    return messages;
  }
}
