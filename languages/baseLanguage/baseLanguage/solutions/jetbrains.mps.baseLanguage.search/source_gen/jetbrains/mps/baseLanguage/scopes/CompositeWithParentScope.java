package jetbrains.mps.baseLanguage.scopes;

/*Generated by MPS */

import jetbrains.mps.scope.Scope;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.scope.CompositeScope;
import java.util.List;

public class CompositeWithParentScope {
  public static Scope from(Scope original, SNode node, SNode kind) {
    // todo: from? 
    Scope nextScope = Scope.getScope(Scope.parent(node), node, kind);
    return (nextScope == null ?
      original :
      new CompositeScope(original, nextScope)
    );
  }

  public static Scope from(List<SNode> elements, SNode node, SNode kind) {
    return from(new SimpleScope(elements), node, kind);
  }

  public static Scope from(SNode element, SNode node, SNode kind) {
    return from(new SimpleScope(element), node, kind);
  }
}
