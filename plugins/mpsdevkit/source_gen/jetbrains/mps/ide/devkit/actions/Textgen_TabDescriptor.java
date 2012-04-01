package jetbrains.mps.ide.devkit.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.relations.RelationDescriptor;
import javax.swing.Icon;
import jetbrains.mps.util.IconUtil;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import org.jetbrains.annotations.Nullable;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.smodel.behaviour.BehaviorManager;
import jetbrains.mps.smodel.LanguageAspect;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;

public class Textgen_TabDescriptor extends RelationDescriptor {
  private static final Icon ICON = IconUtil.getIcon("textGen.png");

  public Textgen_TabDescriptor() {
  }

  public String getTitle() {
    return "Textgen";
  }

  public int compareTo(RelationDescriptor descriptor) {
    return new Textgen_Order().compare(this, descriptor);
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
    List<SNode> list = ListSequence.fromList(new ArrayList<SNode>());
    SNode n = getNode(node);
    if (n == null) {
      return list;
    }
    ListSequence.fromList(list).addElement(n);
    return list;
  }

  public boolean isSingle() {
    return true;
  }

  public SNode getNode(SNode node) {
    List<SNode> nodes = ((List<SNode>) BehaviorManager.getInstance().invoke(Object.class, node, "call_findConceptAspectCollection_1567570417158062208", new Class[]{SNode.class, LanguageAspect.class}, LanguageAspect.TEXT_GEN));
    return (ListSequence.fromList(nodes).isEmpty() ?
      null :
      ListSequence.fromList(nodes).first()
    );
  }

  public List<SNode> getConcepts(final SNode node) {
    return ListSequence.fromListAndArray(new ArrayList<SNode>(), SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.textGen.structure.ConceptTextGenDeclaration"));
  }

  public SNode createNode(final SNode node, final SNode concept) {
    return ConceptEditorHelper.createNewConceptAspectInstance(LanguageAspect.TEXT_GEN, node, SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.textGen.structure.ConceptTextGenDeclaration"));
  }
}
