package jetbrains.mps.ide.devkit.actions;

/*Generated by MPS */

import jetbrains.mps.ide.editorTabs.EditorTabDescriptor;
import javax.swing.Icon;
import jetbrains.mps.util.IconUtil;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import org.jetbrains.annotations.Nullable;
import java.util.List;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.smodel.behaviour.BehaviorManager;
import jetbrains.mps.smodel.LanguageAspect;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;

public class Editor_TabDescriptor extends EditorTabDescriptor {
  private static final Icon ICON = IconUtil.getIcon("editor.png");

  public Editor_TabDescriptor() {
  }

  public String getTitle() {
    return "Editor";
  }

  public Character getShortcutChar() {
    return 'E';
  }

  public int compareTo(EditorTabDescriptor descriptor) {
    return new Editor_Order().compare(this, descriptor);
  }

  public void startListening() {
  }

  public SNode getBaseNode(SNode node) {
    return ConceptEditorOpenHelper.getBaseNode(node);
  }

  public boolean isApplicable(SNode node) {
    return SNodeOperations.isInstanceOf(node, "jetbrains.mps.lang.structure.structure.AbstractConceptDeclaration");
  }

  @Nullable
  public Icon getIcon() {
    return ICON;
  }

  public List<SNode> getNodes(SNode node) {
    List<SNode> nodes = new ArrayList<SNode>();
    ListSequence.fromList(nodes).addSequence(ListSequence.fromList(((List<SNode>) BehaviorManager.getInstance().invoke(Object.class, node, "call_findConceptAspectCollection_1567570417158062208", new Class[]{SNode.class, LanguageAspect.class}, LanguageAspect.EDITOR))));
    return ConceptEditorHelper.sortRootsByConcept(nodes, new SNode[]{SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.editor.structure.ConceptEditorDeclaration"), SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.editor.structure.EditorComponentDeclaration"), SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.editor.structure.CellKeyMapDeclaration"), SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.editor.structure.CellActionMapDeclaration"), SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.editor.structure.CellMenuComponent"), SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.editor.structure.StyleSheet")});
  }

  public boolean isSingle() {
    return false;
  }

  public List<SNode> getConcepts(final SNode node) {
    return ConceptEditorHelper.getAvailableConceptAspects(LanguageAspect.EDITOR, node);
  }

  public SNode createNode(final SNode node, final SNode concept) {
    return ConceptEditorHelper.createNewConceptAspectInstance(LanguageAspect.EDITOR, node, concept);
  }
}
