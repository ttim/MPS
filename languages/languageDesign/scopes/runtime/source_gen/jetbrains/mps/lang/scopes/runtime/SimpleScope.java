package jetbrains.mps.lang.scopes.runtime;

/*Generated by MPS */

import jetbrains.mps.scope.Scope;
import java.util.LinkedHashSet;
import jetbrains.mps.smodel.SNode;
import java.util.List;
import org.jetbrains.annotations.Nullable;
import java.util.ArrayList;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;

public class SimpleScope extends Scope {
  private final LinkedHashSet<SNode> nodes;

  public SimpleScope(Iterable<SNode> nodes) {
    // why i need hash set? 
    this.nodes = new LinkedHashSet();
    for (SNode node : nodes) {
      if ((node != null)) {
        this.nodes.add(node);
      }
    }
  }

  public SimpleScope(SNode node) {
    this.nodes = new LinkedHashSet(1);
    if ((node != null)) {
      nodes.add(node);
    }
  }

  public List<SNode> getAvailableElements(@Nullable String prefix) {
    List<SNode> result = new ArrayList<SNode>();
    for (SNode node : nodes) {
      if ((node != null) && SPropertyOperations.getString(node, "name") != null) {
        if (prefix == null || SPropertyOperations.getString(node, "name").startsWith(prefix)) {
          ListSequence.fromList(result).addElement(node);
        }
      }
    }
    return result;
  }

  @Nullable
  public SNode resolve(SNode contextNode, @NotNull String refText) {
    // todo: maybe map name -> node? 
    SNode result = null;
    for (SNode node : nodes) {
      if (SPropertyOperations.getString(node, "name").equals(refText)) {
        if (result == null) {
          result = node;
        } else {
          // ambiguity 
          return null;
        }
      }
    }
    return result;
  }

  @Nullable
  public String getReferenceText(SNode contextNode, @NotNull SNode target) {
    return SPropertyOperations.getString(SNodeOperations.cast(target, "jetbrains.mps.lang.core.structure.INamedConcept"), "name");
  }
}
