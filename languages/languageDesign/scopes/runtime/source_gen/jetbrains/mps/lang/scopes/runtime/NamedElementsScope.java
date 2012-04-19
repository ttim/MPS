package jetbrains.mps.lang.scopes.runtime;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;

public class NamedElementsScope extends SimpleScope {
  public NamedElementsScope(Iterable<SNode> nodes) {
    super(nodes);
  }

  public NamedElementsScope(SNode node) {
    super(node);
  }

  @Nullable
  public String getReferenceText(@NotNull SNode target) {
    // todo: is it right? 
    // <node> 
    return target.getName();
  }
}
