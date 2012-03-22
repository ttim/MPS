package jetbrains.mps.lang.scopes.runtime;

/*Generated by MPS */

import jetbrains.mps.scope.Scope;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import jetbrains.mps.smodel.SNode;
import java.util.List;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import org.jetbrains.annotations.NotNull;

public class FilteringScope extends Scope {
  private final Scope inner;
  private final _FunctionTypes._return_P1_E0<? extends Boolean, ? super SNode> predicate;

  public FilteringScope(Scope inner, _FunctionTypes._return_P1_E0<? extends Boolean, ? super SNode> predicate) {
    this.inner = inner;
    this.predicate = predicate;
  }

  public List<SNode> getAvailableElements(@Nullable String prefix) {
    return ListSequence.fromListWithValues(new ArrayList(), ListSequence.fromList(inner.getAvailableElements(prefix)).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return predicate.invoke(it);
      }
    }));
  }

  @Nullable
  public SNode resolve(SNode contextNode, @NotNull String refText) {
    return null;
  }

  @Nullable
  public String getReferenceText(SNode contextNode, @NotNull SNode node) {
    return null;
  }
}
