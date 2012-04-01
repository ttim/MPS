package jetbrains.mps.ide.devkit.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.relations.RelationDescriptor;
import javax.swing.Icon;
import jetbrains.mps.util.IconUtil;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import org.jetbrains.annotations.Nullable;
import java.util.List;
import jetbrains.mps.smodel.behaviour.BehaviorManager;
import jetbrains.mps.smodel.LanguageAspect;

public class Refactorings_TabDescriptor extends RelationDescriptor {
  private static final Icon ICON = IconUtil.getIcon("refactoring.png");

  public Refactorings_TabDescriptor() {
  }

  public String getTitle() {
    return "Refactorings";
  }

  public Character getShortcutChar() {
    return 'R';
  }

  public int compareTo(RelationDescriptor descriptor) {
    return new Refactorings_Order().compare(this, descriptor);
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
    return ((List<SNode>) BehaviorManager.getInstance().invoke(Object.class, node, "call_findConceptAspectCollection_1567570417158062208", new Class[]{SNode.class, LanguageAspect.class}, LanguageAspect.REFACTORINGS));
  }

  public boolean isSingle() {
    return false;
  }

  public List<SNode> getConcepts(final SNode node) {
    return ConceptEditorHelper.getAvailableConceptAspects(LanguageAspect.REFACTORINGS, node);
  }

  public SNode createNode(final SNode node, final SNode concept) {
    return ConceptEditorHelper.createNewConceptAspectInstance(LanguageAspect.REFACTORINGS, node, concept);
  }
}
