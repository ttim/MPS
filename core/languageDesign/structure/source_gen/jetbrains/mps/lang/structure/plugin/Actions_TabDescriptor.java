package jetbrains.mps.lang.structure.plugin;

/*Generated by MPS */

import jetbrains.mps.ide.editorTabs.EditorTabDescriptor;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import java.util.List;
import jetbrains.mps.lang.structure.behavior.AbstractConceptDeclaration_Behavior;
import jetbrains.mps.smodel.LanguageAspect;

public class Actions_TabDescriptor extends EditorTabDescriptor {
  public Actions_TabDescriptor() {
  }

  public String getTitle() {
    return "Actions";
  }

  public Character getShortcutChar() {
    return 'A';
  }

  public int compareTo(EditorTabDescriptor descriptor) {
    return new ConceptDeclaration_Order().compare(this, descriptor);
  }

  public void startListening() {
  }

  public SNode getBaseNode(SNode node) {
    return ConceptEditorOpenHelper.getBaseNode(node);
  }

  public boolean isApplicable(SNode node) {
    return SNodeOperations.isInstanceOf(node, "jetbrains.mps.lang.structure.structure.AbstractConceptDeclaration");
  }

  public List<SNode> getNodes(SNode node) {
    return AbstractConceptDeclaration_Behavior.call_findConceptAspectCollection_1567570417158062208(node, LanguageAspect.ACTIONS);
  }

  public List<SNode> getConcepts(final SNode node) {
    return ConceptEditorHelper.getAvailableConceptAspects(LanguageAspect.ACTIONS, node);
  }

  public SNode createNode(final SNode node, final SNode concept) {
    return ConceptEditorHelper.createNewConceptAspectInstance(LanguageAspect.ACTIONS, node, concept);
  }
}
