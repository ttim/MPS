package jetbrains.mps.baseLanguage.search;

/*Generated by MPS */

import jetbrains.mps.smodel.search.AbstractSearchScope;
import java.util.List;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.util.Condition;

public class ParameterScope extends AbstractSearchScope {
  private List<SNode> params;

  public ParameterScope(SNode contextNode) {
    List<SNode> methods = SNodeOperations.getAncestors(contextNode, "jetbrains.mps.baseLanguage.structure.IStatementListContainer", true);
    this.params = ListSequence.fromList(new ArrayList<SNode>());
    for (SNode bmd : methods) {
      for (SNode child : SNodeOperations.getChildren(bmd)) {
        if (SNodeOperations.isInstanceOf(child, "jetbrains.mps.baseLanguage.structure.ParameterDeclaration")) {
          ListSequence.fromList(this.params).addElement(SNodeOperations.cast(child, "jetbrains.mps.baseLanguage.structure.ParameterDeclaration"));
        }
      }
    }
  }

  @NotNull
  public List<SNode> getNodes(Condition<SNode> condition) {
    List<SNode> result = new ArrayList();
    for (SNode node : this.params) {
      if (condition.met(node)) {
        result.add(node);
      }
    }
    return result;
  }
}
