package jetbrains.mps.build.util;

/*Generated by MPS */

import jetbrains.mps.scope.Scope;
import jetbrains.mps.smodel.SNode;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.ITranslator2;
import jetbrains.mps.smodel.search.IsInstanceCondition;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;

public abstract class DescendantsScope extends Scope {
  private SNode node;
  private SNode link;
  private SNode concept;

  public DescendantsScope(SNode node, SNode link, SNode concept) {
    this.node = node;
    this.link = link;
    this.concept = concept;
  }

  public abstract String getName(SNode child);

  public Iterable<SNode> getAvailableElements(@Nullable final String prefix) {
    Iterable<SNode> seq = ListSequence.fromList(SNodeOperations.getChildren(node, link)).translate(new ITranslator2<SNode, SNode>() {
      public Iterable<SNode> translate(SNode it) {
        return it.getDescendantsIterable(new IsInstanceCondition(concept), true);
      }
    });
    if (prefix == null || prefix.isEmpty()) {
      return seq;
    }
    return Sequence.fromIterable(seq).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        String name = getName(it);
        return name != null && name.startsWith(prefix);
      }
    });
  }

  @Nullable
  public SNode resolve(SNode contextNode, @NotNull String refText) {
    SNode result = null;
    for (SNode n : Sequence.fromIterable(getAvailableElements(null))) {
      String name = getName(n);
      if (name.equals(refText)) {
        if (result == null) {
          result = n;
        } else {
          return null;
        }
      }
    }
    return result;
  }

  @Nullable
  public String getReferenceText(SNode contextNode, @NotNull SNode node) {
    if (!(SNodeOperations.isInstanceOf(node, NameUtil.nodeFQName(concept)))) {
      return null;
    }

    String result = getName(node);
    for (SNode n : Sequence.fromIterable(getAvailableElements(null))) {
      if (n == node) {
        continue;
      }
      String name = getName(n);
      if (name.equals(result)) {
        // ambiguity 
        return null;
      }
    }
    return result;
  }

  public static DescendantsScope forNamedElements(SNode node, SNode link, SNode concept) {
    return new DescendantsScope(node, link, concept) {
      public String getName(SNode child) {
        if (!(SNodeOperations.isInstanceOf(child, "jetbrains.mps.lang.core.structure.INamedConcept"))) {
          return child.toString();
        }
        return SPropertyOperations.getString(SNodeOperations.cast(child, "jetbrains.mps.lang.core.structure.INamedConcept"), "name");
      }
    };
  }
}
