package jetbrains.mps.lang.plugin.actions;

/*Generated by MPS */

import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.action.NodeSubstitutePreconditionContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.action.NodeSetupContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.action.SNodeFactoryOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import java.util.List;
import jetbrains.mps.smodel.action.INodeSubstituteAction;
import jetbrains.mps.smodel.action.NodeSubstituteActionsFactoryContext;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.util.Computable;
import jetbrains.mps.smodel.action.DefaultChildNodeSubstituteAction;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.lang.plugin.behavior.ActionDataParameterDeclaration_Behavior;
import jetbrains.mps.smodel.action.ChildSubstituteActionsHelper;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.smodel.action.RemoveSubstituteActionByConditionContext;
import java.util.Iterator;
import jetbrains.mps.util.Condition;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class QueriesGenerated {
  public static boolean nodeSubstituteActionsBuilder_Precondition_Type_1217414480519(final IOperationContext operationContext, final NodeSubstitutePreconditionContext _context) {
    return SNodeOperations.getAncestor(_context.getParentNode(), "jetbrains.mps.lang.plugin.structure.ActionParameterDeclaration", true, false) != null;
  }

  public static void nodeFactory_NodeSetup_ToolTab_485694842828664422(final IOperationContext operationContext, final NodeSetupContext _context) {
    SNode disposeTabClosure = SLinkOperations.getTarget(_context.getNewNode(), "disposeTabClosure", true);
    if ((disposeTabClosure == null)) {
      disposeTabClosure = SNodeFactoryOperations.setNewChild(_context.getNewNode(), "disposeTabClosure", "jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral");
    }
    SNode pd = SNodeFactoryOperations.addNewChild(SNodeOperations.cast(disposeTabClosure, "jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral"), "parameter", "jetbrains.mps.lang.plugin.structure.SmartDisposeClosureParameterDeclaration");
    SPropertyOperations.set(pd, "name", "component");
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_Type_1217414463812(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    return result;
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_ActionParameter_1218807115883(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode outputConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.plugin.structure.ActionParameter");
      SNode childConcept = (SNode) _context.getChildConcept();
      if (SConceptOperations.isSuperConceptOf(childConcept, NameUtil.nodeFQName(outputConcept))) {
        Computable computable = new Computable() {
          public Object compute() {
            return ListSequence.fromListAndArray(new ArrayList<SNode>(), new QueriesGenerated.QuotationClass_x583g4_a1a0a0a0a0a0c0a0b0d().createNode(), new QueriesGenerated.QuotationClass_x583g4_a2a0a0a0a0a0c0a0b0d().createNode(), new QueriesGenerated.QuotationClass_x583g4_a3a0a0a0a0a0c0a0b0d().createNode());
          }
        };
        Iterable<SNode> queryResult = (Iterable) computable.compute();
        if (queryResult != null) {
          for (final SNode item : queryResult) {
            ListSequence.fromList(result).addElement(new DefaultChildNodeSubstituteAction(outputConcept, item, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {
              public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
                SNode result = SNodeFactoryOperations.createNewNode(model, "jetbrains.mps.lang.plugin.structure.ActionParameterDeclaration", null);
                SLinkOperations.setTarget(result, "type", (item), true);
                return result;
              }

              public String getDescriptionText(String pattern) {
                if (SNodeOperations.isInstanceOf((item), "jetbrains.mps.lang.smodel.structure.SNodeType")) {
                  return "current node";
                } else if (SNodeOperations.isInstanceOf((item), "jetbrains.mps.lang.smodel.structure.SNodeListType")) {
                  return "current nodes";
                } else if (SNodeOperations.isInstanceOf((item), "jetbrains.mps.lang.smodel.structure.SModelType")) {
                  return "current model";
                }
                return "";
              }
            });
          }
        }
      }
    }
    {
      SNode outputConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.plugin.structure.ActionParameter");
      SNode childConcept = (SNode) _context.getChildConcept();
      if (SConceptOperations.isSuperConceptOf(childConcept, NameUtil.nodeFQName(outputConcept))) {
        Computable computable = new Computable() {
          public Object compute() {
            return ActionDataParameterDeclaration_Behavior.getVariants_1227641865136();
          }
        };
        Iterable<SNode> queryResult = (Iterable) computable.compute();
        if (queryResult != null) {
          for (final SNode item : queryResult) {
            ListSequence.fromList(result).addElement(new DefaultChildNodeSubstituteAction(outputConcept, item, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {
              public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
                SNode result = SNodeFactoryOperations.createNewNode(model, "jetbrains.mps.lang.plugin.structure.ActionDataParameterDeclaration", null);
                SLinkOperations.setTarget(result, "key", (item), false);
                return result;
              }

              public String getDescriptionText(String pattern) {
                return ActionDataParameterDeclaration_Behavior.getDescription_47694270442103157((item));
              }
            });
          }
        }
      }
    }
    return result;
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_ActionGroupMember_1218809043213(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode conceptToAdd = SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.plugin.structure.Separator");
      List<INodeSubstituteAction> defaultActions = ChildSubstituteActionsHelper.createDefaultActions(conceptToAdd, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext);
      ListSequence.fromList(result).addSequence(ListSequence.fromList(defaultActions));
    }
    {
      SNode conceptToAdd = SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.plugin.structure.GroupAnchor");
      List<INodeSubstituteAction> defaultActions = ChildSubstituteActionsHelper.createDefaultActions(conceptToAdd, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext);
      ListSequence.fromList(result).addSequence(ListSequence.fromList(defaultActions));
    }
    {
      SNode conceptToAdd = SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.plugin.structure.ActionGroupDeclaration");
      List<INodeSubstituteAction> defaultActions = ChildSubstituteActionsHelper.createDefaultActions(conceptToAdd, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext);
      ListSequence.fromList(result).addSequence(ListSequence.fromList(defaultActions));
    }
    {
      SNode outputConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.plugin.structure.ActionInstance");
      SNode childConcept = (SNode) _context.getChildConcept();
      if (SConceptOperations.isSuperConceptOf(childConcept, NameUtil.nodeFQName(outputConcept))) {
        Computable computable = new Computable() {
          public Object compute() {
            return SModelOperations.getRootsIncludingImported(_context.getModel(), operationContext.getScope(), "jetbrains.mps.lang.plugin.structure.ActionDeclaration");
          }
        };
        Iterable<SNode> queryResult = (Iterable) computable.compute();
        if (queryResult != null) {
          for (final SNode item : queryResult) {
            ListSequence.fromList(result).addElement(new DefaultChildNodeSubstituteAction(outputConcept, item, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {
              public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
                SNode result = SNodeFactoryOperations.createNewNode(model, "jetbrains.mps.lang.plugin.structure.ActionInstance", null);
                SLinkOperations.setTarget(result, "action", (item), false);
                return result;
              }
            });
          }
        }
      }
    }
    return result;
  }

  public static void removeActionsByCondition_1217414474266(final IOperationContext operationContext, final RemoveSubstituteActionByConditionContext _context) {
    Iterator<INodeSubstituteAction> actions = _context.getActions();
    while (actions.hasNext()) {
      INodeSubstituteAction current = actions.next();
      final SNode concept = current.getOutputConcept();
      SNode applicableConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.Type");
      Condition cond = new Condition() {
        public boolean met(Object object) {
          boolean isNode = SConceptOperations.isExactly(concept, "jetbrains.mps.lang.smodel.structure.SNodeType");
          boolean isNList = SConceptOperations.isExactly(concept, "jetbrains.mps.lang.smodel.structure.SNodeListType");
          boolean isModel = SConceptOperations.isExactly(concept, "jetbrains.mps.lang.smodel.structure.SModelType");
          return !(isNode || isNList || isModel);
        }
      };
      if (SConceptOperations.isSuperConceptOf(applicableConcept, NameUtil.nodeFQName(concept)) && cond.met(concept)) {
        actions.remove();
      }
    }
  }

  public static class QuotationClass_x583g4_a1a0a0a0a0a0c0a0b0d {
    public QuotationClass_x583g4_a1a0a0a0a0a0c0a0b0d() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SNodeType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        result = quotedNode1_2;
      }
      return result;
    }
  }

  public static class QuotationClass_x583g4_a2a0a0a0a0a0c0a0b0d {
    public QuotationClass_x583g4_a2a0a0a0a0a0c0a0b0d() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SNodeListType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        result = quotedNode1_2;
      }
      return result;
    }
  }

  public static class QuotationClass_x583g4_a3a0a0a0a0a0c0a0b0d {
    public QuotationClass_x583g4_a3a0a0a0a0a0c0a0b0d() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SModelType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        result = quotedNode1_2;
      }
      return result;
    }
  }
}
