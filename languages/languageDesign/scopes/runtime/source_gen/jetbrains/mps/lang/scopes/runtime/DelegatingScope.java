package jetbrains.mps.lang.scopes.runtime;

/*Generated by MPS */

import jetbrains.mps.scope.Scope;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.smodel.SNode;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.smodel.SModelReference;

public abstract class DelegatingScope extends Scope {
  public DelegatingScope() {
  }

  protected abstract Scope getScope();

  @Nullable
  public String getReferenceText(SNode contextNode, @NotNull SNode node) {
    return getScope().getReferenceText(contextNode, node);
  }

  @Nullable
  public SNode resolve(SNode contextNode, @NotNull String refText) {
    return getScope().resolve(contextNode, refText);
  }

  @Nullable
  @Override
  public SNode resolve(SNode contextNode, @NotNull String refText, @Nullable SModelReference targetModelReference) {
    return getScope().resolve(contextNode, refText, targetModelReference);
  }

  public Iterable<SNode> getAvailableElements(@Nullable String prefix) {
    return getScope().getAvailableElements(prefix);
  }

  @Override
  public boolean contains(SNode node) {
    return getScope().contains(node);
  }
}
