package jetbrains.mps.debugger.decisionTable.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.runtime.base.BaseConstraintsDescriptor;
import jetbrains.mps.smodel.SNodePointer;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.runtime.CheckingNodeContext;
import java.util.Map;
import jetbrains.mps.smodel.runtime.PropertyConstraintsDescriptor;
import java.util.HashMap;
import jetbrains.mps.smodel.runtime.base.BasePropertyConstraintsDescriptor;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;

public class XVariableReference_Constraints extends BaseConstraintsDescriptor {
  private static SNodePointer canBeChildBreakingPoint = new SNodePointer("r:f9895147-288e-44e3-852e-62d0bff7f07d(jetbrains.mps.debugger.decisionTable.constraints)", "5202024118203914180");

  public XVariableReference_Constraints() {
    super("jetbrains.mps.debugger.decisionTable.structure.XVariableReference");
  }

  @Override
  public boolean hasOwnCanBeChildMethod() {
    return true;
  }

  @Override
  public boolean canBeChild(@Nullable SNode node, SNode parentNode, SNode link, SNode childConcept, final IOperationContext operationContext, @Nullable final CheckingNodeContext checkingNodeContext) {
    boolean result = static_canBeAChild(node, parentNode, link, childConcept, operationContext);

    if (!(result) && checkingNodeContext != null) {
      checkingNodeContext.setBreakingNode(canBeChildBreakingPoint);
    }

    return result;
  }

  @Override
  protected Map<String, PropertyConstraintsDescriptor> getNotDefaultProperties() {
    Map<String, PropertyConstraintsDescriptor> properties = new HashMap();
    properties.put("name", new BasePropertyConstraintsDescriptor("name", this) {
      @Override
      public boolean hasOwnGetter() {
        return true;
      }

      @Override
      public Object getValue(SNode node, IScope scope) {
        String propertyName = "name";
        return "x";
      }
    });
    return properties;
  }

  public static boolean static_canBeAChild(SNode node, SNode parentNode, SNode link, SNode childConcept, final IOperationContext operationContext) {
    SNode startNode = node;
    if (node == null) {
      if (SNodeOperations.isInstanceOf(parentNode, "jetbrains.mps.debugger.decisionTable.structure.DecisionTable")) {
        return eq_bsk2mf_a0a0a0b0a(link, SLinkOperations.findLinkDeclaration("jetbrains.mps.debugger.decisionTable.structure.DecisionTable", "caseX"));
      }
      startNode = parentNode;
    }
    SNode current = startNode;
    while (current != null) {
      SNode parent = SNodeOperations.getParent(current);
      if (parent != null && SNodeOperations.isInstanceOf(parent, "jetbrains.mps.debugger.decisionTable.structure.DecisionTable")) {
        if (eq_bsk2mf_a0a0b0d0a(SNodeOperations.getContainingLinkRole(current), SPropertyOperations.getString(SLinkOperations.findLinkDeclaration("jetbrains.mps.debugger.decisionTable.structure.DecisionTable", "caseX"), "role"))) {
          return true;
        }
      }
      current = parent;
    }
    return false;
  }

  private static boolean eq_bsk2mf_a0a0a0b0a(Object a, Object b) {
    return (a != null ?
      a.equals(b) :
      a == b
    );
  }

  private static boolean eq_bsk2mf_a0a0b0d0a(Object a, Object b) {
    return (a != null ?
      a.equals(b) :
      a == b
    );
  }
}
