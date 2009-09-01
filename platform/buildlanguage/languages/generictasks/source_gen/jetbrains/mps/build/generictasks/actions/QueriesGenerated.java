package jetbrains.mps.build.generictasks.actions;

/*Generated by MPS */

import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.action.NodeSubstitutePreconditionContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import java.util.List;
import jetbrains.mps.smodel.action.INodeSubstituteAction;
import jetbrains.mps.smodel.action.NodeSubstituteActionsFactoryContext;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.util.Calculable;
import jetbrains.mps.smodel.action.DefaultChildNodeSubstituteAction;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.build.generictasks.behavior.AbstractMethodCall_Behavior;

public class QueriesGenerated {
  public static boolean nodeSubstituteActionsBuilder_Precondition_PropertyValueExpression_353793545802854369(final IOperationContext operationContext, final NodeSubstitutePreconditionContext _context) {
    if (!(SNodeOperations.isInstanceOf(_context.getParentNode(), "jetbrains.mps.build.generictasks.structure.Attribute"))) {
      return false;
    }
    SNode decl = SLinkOperations.getTarget(SNodeOperations.cast(_context.getParentNode(), "jetbrains.mps.build.generictasks.structure.Attribute"), "attributeDeclaration", false);
    return ((SLinkOperations.getTarget(decl, "enum", true) != null)) && SNodeOperations.isInstanceOf(SLinkOperations.getTarget(decl, "enum", true), "jetbrains.mps.buildlanguage.structure.StringEnum");
  }

  public static boolean nodeSubstituteActionsBuilder_Precondition_IOperation_8167803625326067082(final IOperationContext operationContext, final NodeSubstitutePreconditionContext _context) {
    return SNodeOperations.isInstanceOf(_context.getParentNode(), "jetbrains.mps.baseLanguage.structure.DotExpression") && SNodeOperations.isInstanceOf(SLinkOperations.getTarget(SNodeOperations.cast(_context.getParentNode(), "jetbrains.mps.baseLanguage.structure.DotExpression"), "operand", true), "jetbrains.mps.build.generictasks.structure.CustomNestedReference");
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_PropertyValueExpression_353793545802854368(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode outputConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.buildlanguage.structure.StringLiteral");
      SNode childConcept = (SNode)_context.getChildConcept();
      if (SConceptOperations.isSuperConceptOf(childConcept, NameUtil.nodeFQName(outputConcept))) {
        Calculable calc = new Calculable() {
          public Object calculate() {
            SNode decl = SLinkOperations.getTarget(SNodeOperations.cast(_context.getParentNode(), "jetbrains.mps.build.generictasks.structure.Attribute"), "attributeDeclaration", false);
            return SLinkOperations.getTargets(SLinkOperations.getTarget(decl, "enum", true), "constants", true);
          }
        };
        Iterable<SNode> queryResult = (Iterable)calc.calculate();
        if (queryResult != null) {
          for (final SNode item : queryResult) {
            ListSequence.fromList(result).addElement(new DefaultChildNodeSubstituteAction(outputConcept, item, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {
              public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
                SNode node = SConceptOperations.createNewNode("jetbrains.mps.buildlanguage.structure.StringLiteral", null);
                SPropertyOperations.set(node, "value", SPropertyOperations.getString((item), "value"));
                return node;
              }
            });
          }
        }
      }
    }
    return result;
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_Expression_3442822536477596446(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode outputConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.build.generictasks.structure.CustomNestedReference");
      SNode childConcept = (SNode)_context.getChildConcept();
      if (SConceptOperations.isSuperConceptOf(childConcept, NameUtil.nodeFQName(outputConcept))) {
        Calculable calc = new Calculable() {
          public Object calculate() {
            return SLinkOperations.getTargets(SNodeOperations.getAncestor(_context.getParentNode(), "jetbrains.mps.build.generictasks.structure.CustomTaskDeclaration", false, false), "nested", true);
          }
        };
        Iterable<SNode> queryResult = (Iterable)calc.calculate();
        if (queryResult != null) {
          for (final SNode item : queryResult) {
            ListSequence.fromList(result).addElement(new DefaultChildNodeSubstituteAction(outputConcept, item, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {
              public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
                SNode ref = SConceptOperations.createNewNode("jetbrains.mps.build.generictasks.structure.CustomNestedReference", null);
                SLinkOperations.setTarget(ref, "nestedDeclaration", (item), false);
                return ref;
              }
            });
          }
        }
      }
    }
    return result;
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_IOperation_8167803625326067081(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode outputConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.build.generictasks.structure.CustomNestedMethodCall");
      SNode childConcept = (SNode)_context.getChildConcept();
      if (SConceptOperations.isSuperConceptOf(childConcept, NameUtil.nodeFQName(outputConcept))) {
        Calculable calc = new Calculable() {
          public Object calculate() {
            return Sequence.fromIterable(AbstractMethodCall_Behavior.call_getMethods_8167803625326067118(SConceptOperations.createNewNode("jetbrains.mps.build.generictasks.structure.CustomNestedMethodCall", null), SLinkOperations.getTarget(SNodeOperations.cast(_context.getParentNode(), "jetbrains.mps.baseLanguage.structure.DotExpression"), "operand", true), _context.getModel(), operationContext.getScope())).toListSequence();
          }
        };
        Iterable<SNode> queryResult = (Iterable)calc.calculate();
        if (queryResult != null) {
          for (final SNode item : queryResult) {
            ListSequence.fromList(result).addElement(new DefaultChildNodeSubstituteAction(outputConcept, item, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {
              public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
                SNode call = SConceptOperations.createNewNode("jetbrains.mps.build.generictasks.structure.CustomNestedMethodCall", null);
                SLinkOperations.setTarget(call, "methodDeclaration", (item), false);
                return call;
              }
            });
          }
        }
      }
    }
    return result;
  }
}
