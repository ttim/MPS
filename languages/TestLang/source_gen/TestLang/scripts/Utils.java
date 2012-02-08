package TestLang.scripts;

/*Generated by MPS */

import jetbrains.mps.logging.Logger;
import java.util.Set;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.scope.Scope;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import java.util.HashSet;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.smodel.constraints.ModelConstraintsUtil;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;

public class Utils {
  private static Logger LOG = Logger.getLogger(Utils.class);

  public Utils() {
  }

  public static Set<SNode> getNodes(Scope scope) {
    return (scope == null ?
      SetSequence.fromSet(new HashSet()) :
      SetSequence.fromSetWithValues(new HashSet(), scope.getAvailableElements(null))
    );
  }

  public static boolean checkScopes(SNode node, Scope oldScope, Scope newScope, boolean debugInfo) {
    Set<SNode> oldNodes = Utils.getNodes(oldScope);
    Set<SNode> newNodes = Utils.getNodes(newScope);
    Set<SNode> intersect = SetSequence.fromSetWithValues(new HashSet(), SetSequence.fromSet(oldNodes).intersect(SetSequence.fromSet(newNodes)));
    SetSequence.fromSet(oldNodes).removeSequence(SetSequence.fromSet(intersect));
    SetSequence.fromSet(newNodes).removeSequence(SetSequence.fromSet(intersect));
    if (SetSequence.fromSet(oldNodes).count() != 0 || SetSequence.fromSet(newNodes).count() != 0) {
      if (debugInfo) {
        LOG.warning("Something wrong with " + node + " with id " + node.getId());
        LOG.warning("in common size " + SetSequence.fromSet(intersect).count());
        LOG.warning("in old but not new " + oldNodes);
        LOG.warning("in new but not old " + newNodes);
      }
      return false;
    } else {
      return true;
    }
  }

  public static Scope getOldScopeFromRef(SReference ref) {
    ModelConstraintsUtil.ReferenceDescriptor descriptor = ModelConstraintsUtil.getReferenceDescriptor(ref, null);
    return descriptor.getScope();
  }

  public static Scope getNewScopeFromRef(SReference ref, SNode kind) {
    return Scope.getScope(ref.getSourceNode(), ref.getSourceNode(), kind);
  }

  public static boolean isInComment(SNode node) {
    return (SNodeOperations.getAncestor(node, "jetbrains.mps.baseLanguage.structure.SingleLineComment", false, false) != null) || (SNodeOperations.getAncestor(node, "jetbrains.mps.baseLanguage.structure.CommentedStatementsBlock", false, false) != null);
  }
}
