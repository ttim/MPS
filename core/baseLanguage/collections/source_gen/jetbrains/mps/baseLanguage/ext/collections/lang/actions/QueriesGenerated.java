package jetbrains.mps.baseLanguage.ext.collections.lang.actions;

/*Generated by MPS */

import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.action.NodeSubstitutePreconditionContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.bootstrap.helgins.runtime.HUtil;
import jetbrains.mps.smodel.action.RTransformPreconditionContext;
import jetbrains.mps.smodel.action.NodeSetupContext;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SPropertyOperations;
import java.util.List;
import jetbrains.mps.smodel.action.INodeSubstituteAction;
import jetbrains.mps.smodel.action.NodeSubstituteActionsFactoryContext;
import java.util.ArrayList;
import jetbrains.mps.bootstrap.structureLanguage.structure.ConceptDeclaration;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.util.Calculable;
import jetbrains.mps.baseLanguage.ext.collections.internal.query.ListOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.smodel.action.ChildSubstituteActionsHelper;
import jetbrains.mps.smodel.BaseAdapter;
import jetbrains.mps.smodel.action.DefaultSimpleSubstituteAction;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.smodel.action.RTActionsBuilderContext;
import jetbrains.mps.smodel.action.AbstractRTransformHintSubstituteAction;
import jetbrains.mps.smodel.action.ModelActions;
import jetbrains.mps.smodel.action.RemoveSubstituteActionByConditionContext;
import java.util.Iterator;
import jetbrains.mps.util.Condition;

public class QueriesGenerated {

  public static boolean nodeSubstituteActionsBuilder_Precondition_Statement_1160672994889(final IOperationContext operationContext, final NodeSubstitutePreconditionContext _context) {
    SNode block = SNodeOperations.getAncestorWhereConceptInList(_context.getParentNode(), new String[]{"jetbrains.mps.baseLanguage.ext.collections.lang.structure.ValueSupplierBlock","jetbrains.mps.baseLanguage.ext.collections.lang.structure.MapperBlock","jetbrains.mps.baseLanguage.ext.collections.lang.structure.ForEachBlock","jetbrains.mps.baseLanguage.ext.collections.lang.structure.SortBlock"}, false, false);
    return block != null;
  }

  public static boolean nodeSubstituteActionsBuilder_Precondition_Expression_1178286539824(final IOperationContext operationContext, final NodeSubstitutePreconditionContext _context) {
    return SNodeOperations.isInstanceOf(_context.getParentNode(), "jetbrains.mps.baseLanguage.ext.collections.lang.structure.SortOperation");
  }

  public static boolean nodeSubstituteActionsBuilder_Precondition_IOperation_1201315815229(final IOperationContext operationContext, final NodeSubstitutePreconditionContext _context) {
    return SNodeOperations.isInstanceOf(_context.getParentNode(), "jetbrains.mps.baseLanguage.structure.OperationExpression") && (TypeChecker.getInstance().getRuntimeSupport().coerce(TypeChecker.getInstance().getTypeOf(SLinkOperations.getTarget(_context.getParentNode(), "operand", true)), HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.baseLanguage.ext.collections.lang.structure.MapType"), true) != null);
  }

  public static boolean rightTransformHintSubstituteActionsBuilder_Precondition_Expression_1161719130431(final IOperationContext operationContext, final RTransformPreconditionContext _context) {
    SNode type = TypeChecker.getInstance().getTypeOf(_context.getSourceNode());
    SNode sequenceType = TypeChecker.getInstance().getRuntimeSupport().coerce(type, HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.baseLanguage.ext.collections.lang.structure.SequenceType"), false);
    return (sequenceType != null);
  }

  public static boolean rightTransformHintSubstituteActionsBuilder_Precondition_Expression_1197932868400(final IOperationContext operationContext, final RTransformPreconditionContext _context) {
    SNode type = TypeChecker.getInstance().getTypeOf(_context.getSourceNode());
    return (TypeChecker.getInstance().getRuntimeSupport().coerce(type, HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.baseLanguage.ext.collections.lang.structure.MapType"), false) != null);
  }

  public static void nodeFactory_NodeSetup_DefaultInputElement_1174261447073(final IOperationContext operationContext, final NodeSetupContext _context) {
    SPropertyOperations.set(_context.getNewNode(), "name", "it");
  }

  public static void nodeFactory_NodeSetup_SortOperation_1178286959323(final IOperationContext operationContext, final NodeSetupContext _context) {
    SPropertyOperations.set(SLinkOperations.setNewChild(_context.getNewNode(), "order", "jetbrains.mps.baseLanguage.ext.collections.lang.structure.SortDirection"), "value", "" + (true));
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_Statement_1152144005896(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = new ArrayList<INodeSubstituteAction>();
    {
      ConceptDeclaration concept = SModelUtil_new.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.Statement", operationContext.getScope());
      Calculable calc = new Calculable() {

        public Object calculate() {
          boolean yieldAllowed = false;
          boolean stopAllowed = false;
          boolean skipAllowed = false;
          SNode parentClosure = SNodeOperations.getAncestor(_context.getParentNode(), "jetbrains.mps.baseLanguage.structure.Closure", false, false);
          if(SNodeOperations.isInstanceOf(parentClosure, "jetbrains.mps.baseLanguage.ext.collections.lang.structure.ValueSupplierBlock")) {
            yieldAllowed = true;
            stopAllowed = true;
          }
          if(SNodeOperations.isInstanceOf(parentClosure, "jetbrains.mps.baseLanguage.ext.collections.lang.structure.MapperBlock")) {
            yieldAllowed = true;
            stopAllowed = true;
            skipAllowed = true;
          }
          if(SNodeOperations.isInstanceOf(parentClosure, "jetbrains.mps.baseLanguage.ext.collections.lang.structure.ForEachBlock")) {
            stopAllowed = true;
            skipAllowed = true;
          }
          List<SNode> concepts = new ArrayList<SNode>();
          if(yieldAllowed) {
            ListOperations.addElement(concepts, SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.ext.collections.lang.structure.TraversalYieldStatement"));
          }
          if(stopAllowed) {
            ListOperations.addElement(concepts, SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.ext.collections.lang.structure.TraversalStopStatement"));
          }
          if(skipAllowed) {
            ListOperations.addElement(concepts, SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.ext.collections.lang.structure.TraversalSkipStatement"));
          }
          return concepts;
        }

      };
      Iterable queryResult = (Iterable)calc.calculate();
      assert queryResult != null;
      for(Object item : queryResult) {
        List<INodeSubstituteAction> defaultActions = ChildSubstituteActionsHelper.createDefaultActions((ConceptDeclaration)BaseAdapter.fromNode((SNode)item), _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext);
        result.addAll(defaultActions);
      }
    }
    return result;
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_Expression_1178286508713(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = new ArrayList<INodeSubstituteAction>();
    {
      ConceptDeclaration concept = SModelUtil_new.findConceptDeclaration("jetbrains.mps.baseLanguage.ext.collections.lang.structure.SortDirection", operationContext.getScope());
      result.add(new DefaultSimpleSubstituteAction(concept, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {

        public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
          SNode direction = SModelOperations.createNewNode(model, "jetbrains.mps.baseLanguage.ext.collections.lang.structure.SortDirection", _context.getCurrentTargetNode());
          SPropertyOperations.set(direction, "value", "" + (true));
          return direction;
        }

        public String getDescriptionText(String pattern) {
          return "Sort in ascending order";
        }

        public String getMatchingText(String pattern) {
          return "asc";
        }

      });
    }
    {
      ConceptDeclaration concept = SModelUtil_new.findConceptDeclaration("jetbrains.mps.baseLanguage.ext.collections.lang.structure.SortDirection", operationContext.getScope());
      result.add(new DefaultSimpleSubstituteAction(concept, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {

        public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
          SNode direction = SModelOperations.createNewNode(model, "jetbrains.mps.baseLanguage.ext.collections.lang.structure.SortDirection", _context.getCurrentTargetNode());
          SPropertyOperations.set(direction, "value", "" + (false));
          return direction;
        }

        public String getDescriptionText(String pattern) {
          return "Sort in descending order";
        }

        public String getMatchingText(String pattern) {
          return "desc";
        }

      });
    }
    return result;
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_SequenceOperation_1160663024951(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = new ArrayList<INodeSubstituteAction>();
    return result;
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_IOperation_1201315808525(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = new ArrayList<INodeSubstituteAction>();
    {
      ConceptDeclaration concept = SModelUtil_new.findConceptDeclaration("null", operationContext.getScope());
      Calculable calc = new Calculable() {

        public Object calculate() {
          return SConceptOperations.getAllSubConcepts(SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.ext.collections.lang.structure.MapOperation"), SNodeOperations.getModel(_context.getParentNode()), operationContext.getScope());
        }

      };
      Iterable queryResult = (Iterable)calc.calculate();
      assert queryResult != null;
      for(Object item : queryResult) {
        List<INodeSubstituteAction> defaultActions = ChildSubstituteActionsHelper.createDefaultActions((ConceptDeclaration)BaseAdapter.fromNode((SNode)item), _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext);
        result.addAll(defaultActions);
      }
    }
    return result;
  }

  public static List<INodeSubstituteAction> rightTransform_ActionsFactory_Expression_1151703707960(final IOperationContext operationContext, final RTActionsBuilderContext _context) {
    List<INodeSubstituteAction> result = new ArrayList<INodeSubstituteAction>();
    {
      ConceptDeclaration concept = SModelUtil_new.findConceptDeclaration("null", operationContext.getScope());
      result.add(new AbstractRTransformHintSubstituteAction(BaseAdapter.fromAdapter(concept), _context.getSourceNode()) {

        public SNode doSubstitute(String pattern) {
          SNode result = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.ext.collections.lang.structure.SequenceOperationExpression", null);
          SNodeOperations.replaceWithAnother(_context.getSourceNode(), result);
          SLinkOperations.setTarget(result, "leftExpression", _context.getSourceNode(), true);
          return result;
        }

        public String getMatchingText(String pattern) {
          return ".";
        }

        public String getDescriptionText(String pattern) {
          return "sequence operation";
        }

      });
    }
    return result;
  }

  public static List<INodeSubstituteAction> rightTransform_ActionsFactory_SequenceOperation_1153773758797(final IOperationContext operationContext, final RTActionsBuilderContext _context) {
    List<INodeSubstituteAction> result = new ArrayList<INodeSubstituteAction>();
    {
      Calculable calc = new Calculable() {

        public Object calculate() {
          return SNodeOperations.getParent(_context.getSourceNode(), null, false, false);
        }

      };
      SNode node = (SNode)calc.calculate();
      result.addAll(ModelActions.createRightTransformHintSubstituteActions(node, _context.getTransformationTag(), operationContext));
    }
    return result;
  }

  public static List<INodeSubstituteAction> rightTransform_ActionsFactory_Expression_1197932848431(final IOperationContext operationContext, final RTActionsBuilderContext _context) {
    List<INodeSubstituteAction> result = new ArrayList<INodeSubstituteAction>();
    {
      ConceptDeclaration concept = SModelUtil_new.findConceptDeclaration("null", operationContext.getScope());
      result.add(new AbstractRTransformHintSubstituteAction(BaseAdapter.fromAdapter(concept), _context.getSourceNode()) {

        public SNode doSubstitute(String pattern) {
          SNode mapElement = SNodeOperations.replaceWithNewChild(_context.getSourceNode(), "jetbrains.mps.baseLanguage.ext.collections.lang.structure.MapElement");
          SLinkOperations.setTarget(mapElement, "map", _context.getSourceNode(), true);
          return mapElement;
        }

        public String getMatchingText(String pattern) {
          return "[";
        }

      });
    }
    return result;
  }

  public static void removeActionsByCondition_1177414262137(final IOperationContext operationContext, final RemoveSubstituteActionByConditionContext _context) {
    Iterator<INodeSubstituteAction> actions = _context.getActions();
    while(actions.hasNext()) {
      INodeSubstituteAction current = actions.next();
      if(!(current.getParameterObject() instanceof SNode)) {
        continue;
      }
      final SNode concept = (SNode)current.getParameterObject();
      SNode applicableConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.ext.collections.lang.structure.SequenceOperation");
      Condition cond = new Condition() {

        public boolean met(Object object) {
          boolean applicableToSequence = false;
          boolean applicableToList = false;
          if(SNodeOperations.isInstanceOf(_context.getParentNode(), "jetbrains.mps.baseLanguage.ext.collections.lang.structure.SequenceOperationExpression")) {
            SNode leftExpression = SLinkOperations.getTarget(_context.getParentNode(), "leftExpression", true);
            SNode leftType = TypeChecker.getInstance().getTypeOf(leftExpression);
            if(TypeChecker.getInstance().getRuntimeSupport().coerce(leftType, HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.baseLanguage.ext.collections.lang.structure.SequenceType"), false) != null) {
              applicableToSequence = true;
            }
            if(TypeChecker.getInstance().getRuntimeSupport().coerce(leftType, HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.baseLanguage.ext.collections.lang.structure.ListType"), false) != null) {
              applicableToList = true;
            }
          }
          if(!(applicableToSequence)) {
            return true;
          }
          if(applicableToList) {
            return false;
          }
          return SConceptOperations.isSubConceptOf(concept, "jetbrains.mps.baseLanguage.ext.collections.lang.structure.AbstractListOperation");
        }

      };
      if(SConceptOperations.isAssignableFrom(applicableConcept, concept) && cond.met(null)) {
        actions.remove();
      }
    }
  }

}
