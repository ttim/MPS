package jetbrains.mps.checkers;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.smodel.SModelStereotype;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.AttributeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.IAttributeDescriptor;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;

public class ErrorReportUtil {
  public ErrorReportUtil() {
  }

  public static boolean shouldReportError(SNode node) {
    final Wrappers._T<SNode> _node = new Wrappers._T<SNode>(node);
    if (SModelStereotype.isStubModelStereotype(_node.value.getModel().getStereotype())) {
      return false;
    }
    SNode parent = _node.value;
    while (parent != null) {
      if (SNodeOperations.isInstanceOf(parent, "jetbrains.mps.lang.core.structure.ISuppressErrors") && ((Boolean) BehaviorManager.getInstance().invoke(Boolean.class, SNodeOperations.cast(parent, "jetbrains.mps.lang.core.structure.ISuppressErrors"), "virtual_suppress_3393165121846091591", new Class[]{SNode.class, SNode.class}, _node.value))) {
        return false;
      }
      if (ListSequence.fromList(AttributeOperations.getAttributeList(parent, new IAttributeDescriptor.AllAttributes())).any(new IWhereFilter<SNode>() {
        public boolean accept(SNode attr) {
          return SNodeOperations.isInstanceOf(attr, "jetbrains.mps.lang.core.structure.ISuppressErrors") && ((Boolean) BehaviorManager.getInstance().invoke(Boolean.class, SNodeOperations.cast(attr, "jetbrains.mps.lang.core.structure.ISuppressErrors"), "virtual_suppress_3393165121846091591", new Class[]{SNode.class, SNode.class}, _node.value));
        }
      })) {
        return false;
      }
      if (SNodeOperations.isInstanceOf(parent, "jetbrains.mps.lang.core.structure.IAntisuppressErrors")) {
        return true;
      }
      _node.value = parent;
      parent = SNodeOperations.getParent(_node.value);
    }
    return true;
  }
}
