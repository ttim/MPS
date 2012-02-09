package jetbrains.mps.lang.dataFlow.pluginSolution.plugin;

/*Generated by MPS */

import jetbrains.mps.ide.editorTabs.EditorTabDescriptor;
import javax.swing.Icon;
import jetbrains.mps.util.IconUtil;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.structure.pluginSolution.plugin.ConceptEditorOpenHelper;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import org.jetbrains.annotations.Nullable;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.lang.structure.behavior.AbstractConceptDeclaration_Behavior;
import jetbrains.mps.smodel.LanguageAspect;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.lang.structure.plugin.ConceptEditorHelper;

public class Data_Flow_TabDescriptor extends EditorTabDescriptor {
  private static final Icon ICON = IconUtil.getIcon("goRound.png");

  public Data_Flow_TabDescriptor() {
  }

  public String getTitle() {
    return "Data Flow";
  }

  public Character getShortcutChar() {
    return 'D';
  }

  public int compareTo(EditorTabDescriptor descriptor) {
    return new DataFlow_Order().compare(this, descriptor);
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
    List<SNode> nodes = AbstractConceptDeclaration_Behavior.call_findConceptAspectCollection_1567570417158062208(node, LanguageAspect.DATA_FLOW);
    return (ListSequence.fromList(nodes).isEmpty() ?
      null :
      ListSequence.fromList(nodes).first()
    );
  }

  public List<SNode> getConcepts(final SNode node) {
    return ListSequence.fromListAndArray(new ArrayList<SNode>(), SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.dataFlow.structure.DataFlowBuilderDeclaration"));
  }

  public SNode createNode(final SNode node, final SNode concept) {
    return ConceptEditorHelper.createNewConceptAspectInstance(LanguageAspect.DATA_FLOW, node, SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.dataFlow.structure.DataFlowBuilderDeclaration"));
  }
}
