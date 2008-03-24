package jetbrains.mps.bootstrap.smodelLanguage.actions;

/*Generated by MPS */

import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.action.RTransformPreconditionContext;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.baseLanguage.ext.collections.internal.query.SequenceOperations;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.bootstrap.helgins.runtime.HUtil;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.action.NodeSetupContext;
import java.util.List;
import jetbrains.mps.baseLanguage.ext.collections.internal.ICursor;
import jetbrains.mps.baseLanguage.ext.collections.internal.CursorFactory;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.smodel.action.INodeSubstituteAction;
import jetbrains.mps.smodel.action.NodeSubstituteActionsFactoryContext;
import java.util.ArrayList;
import jetbrains.mps.util.Calculable;
import jetbrains.mps.smodel.search.ISearchScope;
import jetbrains.mps.smodel.search.ConceptAndSuperConceptsScope;
import jetbrains.mps.bootstrap.structureLanguage.structure.AbstractConceptDeclaration;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.smodel.BaseAdapter;
import jetbrains.mps.bootstrap.structureLanguage.structure.ConceptPropertyDeclaration;
import jetbrains.mps.smodel.action.DefaultChildNodeSubstituteAction;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.bootstrap.structureLanguage.structure.ConceptLinkDeclaration;
import jetbrains.mps.bootstrap.smodelLanguage.constraints.StaticConceptMethodCall_Behavior;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.smodel.action.RTActionsBuilderContext;
import jetbrains.mps.smodel.action.AbstractRTransformHintSubstituteAction;
import jetbrains.mps.smodel.action.ModelActions;
import jetbrains.mps.smodel.action.RemoveSubstituteActionByConditionContext;
import java.util.Iterator;
import jetbrains.mps.util.Condition;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SConceptPropertyOperations;

public class QueriesGenerated {

  public static boolean rightTransformHintSubstituteActionsBuilder_Precondition_SNodeOperation_1154637518825(final IOperationContext operationContext, final RTransformPreconditionContext _context) {
    boolean alreadyHasParms = SLinkOperations.getCount(_context.getSourceNode(), "parameter") > 0;
    if (alreadyHasParms) {
      return false;
    }
    return SequenceOperations.getSize(SLinkOperations.getConceptLinkTargets(_context.getSourceNode(), "applicableParameter")) > 0;
  }

  public static boolean rightTransformHintSubstituteActionsBuilder_Precondition_Expression_1179535189126(final IOperationContext operationContext, final RTransformPreconditionContext _context) {
    SNode nodeType = TypeChecker.getInstance().getRuntimeSupport().coerce(TypeChecker.getInstance().getTypeOf(_context.getSourceNode()), HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType"), false);
    return nodeType != null;
  }

  public static boolean rightTransformHintSubstituteActionsBuilder_Precondition_Expression_1179535648215(final IOperationContext operationContext, final RTransformPreconditionContext _context) {
    SNode expressionType = TypeChecker.getInstance().getTypeOf(_context.getSourceNode());
    if (SNodeOperations.isInstanceOf(expressionType, "jetbrains.mps.bootstrap.smodelLanguage.structure._LinkAccessT")) {
      return true;
    }
    if (SNodeOperations.isInstanceOf(expressionType, "jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType")) {
      return true;
    }
    if (SNodeOperations.isInstanceOf(expressionType, "jetbrains.mps.bootstrap.smodelLanguage.structure.SConceptType")) {
      return true;
    }
    if (SNodeOperations.isInstanceOf(expressionType, "jetbrains.mps.bootstrap.smodelLanguage.structure.SModelType")) {
      return true;
    }
    return false;
  }

  public static void nodeFactory_NodeSetup_Node_GetAncestorOperation_1171415364778(final IOperationContext operationContext, final NodeSetupContext _context) {
    if (SNodeOperations.isInstanceOf(_context.getSampleNode(), "jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeOperation")) {
      List<SNode> parms = SLinkOperations.getTargets(_context.getSampleNode(), "parameter", true);
      {
        ICursor<SNode> _zCursor = CursorFactory.createCursor(parms);
        try {
          while(_zCursor.moveToNext()) {
            SNode parm = _zCursor.getCurrent();
            SLinkOperations.addChild(_context.getNewNode(), "parameter", parm);
          }
        } finally {
          _zCursor.release();
        }
      }
    }
  }

  public static void nodeFactory_NodeSetup_Concept_IsSuperConceptOfOperation_1203553726915(final IOperationContext operationContext, final NodeSetupContext _context) {
    if (SNodeOperations.isInstanceOf(_context.getSampleNode(), "jetbrains.mps.bootstrap.smodelLanguage.structure.Concept_IsAssignableFromOperation")) {
      SNode conceptExpression = SLinkOperations.getTarget(_context.getSampleNode(), "sconceptExpression", true);
      SNode refConceptExpression = SConceptOperations.createNewNode("jetbrains.mps.bootstrap.smodelLanguage.structure.RefConcept_Expression", null);
      SLinkOperations.setTarget(refConceptExpression, "expression", conceptExpression, true);
      SLinkOperations.setTarget(_context.getNewNode(), "conceptArgument", refConceptExpression, true);
    }
    if (SNodeOperations.isInstanceOf(_context.getSampleNode(), "jetbrains.mps.bootstrap.smodelLanguage.structure.Concept_IsSubConceptOfOperation")) {
      SLinkOperations.setTarget(_context.getNewNode(), "conceptArgument", SLinkOperations.getTarget(_context.getSampleNode(), "conceptArgument", true), true);
    }
  }

  public static void nodeFactory_NodeSetup_Concept_IsSubConceptOfOperation_1203553739271(final IOperationContext operationContext, final NodeSetupContext _context) {
    if (SNodeOperations.isInstanceOf(_context.getSampleNode(), "jetbrains.mps.bootstrap.smodelLanguage.structure.Concept_IsSuperConceptOfOperation")) {
      SLinkOperations.setTarget(_context.getNewNode(), "conceptArgument", SLinkOperations.getTarget(_context.getSampleNode(), "conceptArgument", true), true);
    }
  }

  public static void nodeFactory_NodeSetup_SNodeListType_1205353787834(final IOperationContext operationContext, final NodeSetupContext _context) {
    if (SNodeOperations.isInstanceOf(_context.getSampleNode(), "jetbrains.mps.baseLanguage.ext.collections.lang.structure.SequenceType")) {
      SNode elementType = SLinkOperations.getTarget(_context.getSampleNode(), "elementType", true);
      if (SNodeOperations.isInstanceOf(elementType, "jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType")) {
        SLinkOperations.setTarget(_context.getNewNode(), "elementConcept", SLinkOperations.getTarget(elementType, "concept", false), false);
      }
    }
    if (SNodeOperations.isInstanceOf(_context.getSampleNode(), "jetbrains.mps.baseLanguage.ext.collections.lang.structure.ListType")) {
      SNode elementType = SLinkOperations.getTarget(_context.getSampleNode(), "elementType", true);
      if (SNodeOperations.isInstanceOf(elementType, "jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType")) {
        SLinkOperations.setTarget(_context.getNewNode(), "elementConcept", SLinkOperations.getTarget(elementType, "concept", false), false);
      }
    }
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_SNodeOperation_1138413233760(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = new ArrayList<INodeSubstituteAction>();
    final ApplicableTypesInfo appTypesInfo;
    {
      Calculable calc = new Calculable() {

        public Object calculate() {
          ApplicableTypesInfo result = new ApplicableTypesInfo();
          SNode leftExpression = SLinkOperations.getTarget(_context.getParentNode(), "operand", true);
          if (SNodeOperations.isInstanceOf(_context.getParentNode(), "jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeOperationExpression")) {
            leftExpression = SLinkOperations.getTarget(_context.getParentNode(), "leftExpression", true);
          }
          SNode leftOperation = SLinkOperations.getTarget(leftExpression, "operation", true);
          if (SNodeOperations.isInstanceOf(leftExpression, "jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeOperationExpression")) {
            leftOperation = SLinkOperations.getTarget(leftExpression, "nodeOperation", true);
          }
          SNode leftType = TypeChecker.getInstance().getTypeOf(leftExpression);
          SNode linkAccessT = TypeChecker.getInstance().getRuntimeSupport().coerce(leftType, HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.bootstrap.smodelLanguage.structure._LinkAccessT"), false);
          result.myLinkAccessT = linkAccessT;
          // is concept ?
          if (TypeChecker.getInstance().getRuntimeSupport().coerce(leftType, HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.bootstrap.smodelLanguage.structure.SConceptType"), false) != null) {
            result.myToConcept = true;
          }
          // is node ?
          if (TypeChecker.getInstance().getRuntimeSupport().coerce(leftType, HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType"), false) != null) {
            result.myToNode = true;
          }
          // is smodel ?
          if (TypeChecker.getInstance().getRuntimeSupport().coerce(leftType, HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.bootstrap.smodelLanguage.structure.SModelType"), false) != null) {
            result.myToModel = true;
          }
          return result;
        }

      };
      appTypesInfo = (ApplicableTypesInfo)calc.calculate();
    }
    return result;
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_SNodeOperation_1180538139816(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = new ArrayList<INodeSubstituteAction>();
    final SNode leftConcept;
    final ISearchScope hierarchyScope;
    {
      Calculable calc = new Calculable() {

        public Object calculate() {
          SNode leftExpression = SLinkOperations.getTarget(_context.getParentNode(), "operand", true);
          if (SNodeOperations.isInstanceOf(_context.getParentNode(), "jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeOperationExpression")) {
            // old
            leftExpression = SLinkOperations.getTarget(_context.getParentNode(), "leftExpression", true);
          }
          SNode maybeConceptType = TypeChecker.getInstance().getRuntimeSupport().coerce(TypeChecker.getInstance().getTypeOf(leftExpression), HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.bootstrap.smodelLanguage.structure.SConceptType"), false);
          if (maybeConceptType != null) {
            if (SLinkOperations.getTarget(maybeConceptType, "conceptDeclaraton", false) != null) {
              return SLinkOperations.getTarget(maybeConceptType, "conceptDeclaraton", false);
            } else
            {
              return SConceptOperations.findConceptDeclaration("jetbrains.mps.bootstrap.structureLanguage.structure.AbstractConceptDeclaration");
            }
          }
          SNode maybeNodeType = TypeChecker.getInstance().getRuntimeSupport().coerce(TypeChecker.getInstance().getTypeOf(leftExpression), HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType"), false);
          if (maybeNodeType != null) {
            if (SLinkOperations.getTarget(maybeNodeType, "concept", false) != null) {
              return SLinkOperations.getTarget(maybeNodeType, "concept", false);
            } else
            {
              return SConceptOperations.findConceptDeclaration("jetbrains.mps.core.structure.BaseConcept");
            }
          }
          return null;
        }

      };
      leftConcept = (SNode)calc.calculate();
    }
    {
      Calculable calc = new Calculable() {

        public Object calculate() {
          return new ConceptAndSuperConceptsScope(((AbstractConceptDeclaration)SNodeOperations.getAdapter(leftConcept)));
        }

      };
      hierarchyScope = (ISearchScope)calc.calculate();
    }
    {
      AbstractConceptDeclaration outputConcept = SModelUtil_new.findConceptDeclaration("jetbrains.mps.bootstrap.smodelLanguage.structure.SConceptPropertyAccess", operationContext.getScope());
      SNode childConcept = (SNode)_context.getChildConcept();
      if (SConceptOperations.isSuperConceptOf(childConcept, NameUtil.nodeFQName((SNode)BaseAdapter.fromAdapter(outputConcept)))) {
        Calculable calc = new Calculable() {

          public Object calculate() {
            List<ConceptPropertyDeclaration> adapters = hierarchyScope.getAdapters(ConceptPropertyDeclaration.class);
            return (List<SNode>)BaseAdapter.toNodes(adapters);
          }

        };
        Iterable<SNode> queryResult = (Iterable)calc.calculate();
        assert queryResult != null;
        for(final SNode item : queryResult) {
          result.add(new DefaultChildNodeSubstituteAction(outputConcept, item, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {

            public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
              SNode newNode = SConceptOperations.createNewNode("jetbrains.mps.bootstrap.smodelLanguage.structure.SConceptPropertyAccess", null);
              SLinkOperations.setTarget(newNode, "conceptProperty", (item), false);
              return newNode;
            }

          });
        }
      }
    }
    {
      AbstractConceptDeclaration outputConcept = SModelUtil_new.findConceptDeclaration("jetbrains.mps.bootstrap.smodelLanguage.structure.SConceptLinkAccess", operationContext.getScope());
      SNode childConcept = (SNode)_context.getChildConcept();
      if (SConceptOperations.isSuperConceptOf(childConcept, NameUtil.nodeFQName((SNode)BaseAdapter.fromAdapter(outputConcept)))) {
        Calculable calc = new Calculable() {

          public Object calculate() {
            List<ConceptLinkDeclaration> adapters = hierarchyScope.getAdapters(ConceptLinkDeclaration.class);
            return (List<SNode>)BaseAdapter.toNodes(adapters);
          }

        };
        Iterable<SNode> queryResult = (Iterable)calc.calculate();
        assert queryResult != null;
        for(final SNode item : queryResult) {
          result.add(new DefaultChildNodeSubstituteAction(outputConcept, item, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {

            public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
              SNode newNode = SConceptOperations.createNewNode("jetbrains.mps.bootstrap.smodelLanguage.structure.SConceptLinkAccess", null);
              SLinkOperations.setTarget(newNode, "conceptLinkDeclaration", (item), false);
              return newNode;
            }

          });
        }
      }
    }
    return result;
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_Expression_1206022149742(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = new ArrayList<INodeSubstituteAction>();
    {
      AbstractConceptDeclaration outputConcept = SModelUtil_new.findConceptDeclaration("jetbrains.mps.bootstrap.smodelLanguage.structure.StaticConceptMethodCall", operationContext.getScope());
      SNode childConcept = (SNode)_context.getChildConcept();
      if (SConceptOperations.isSuperConceptOf(childConcept, NameUtil.nodeFQName((SNode)BaseAdapter.fromAdapter(outputConcept)))) {
        Calculable calc = new Calculable() {

          public Object calculate() {
            return StaticConceptMethodCall_Behavior.getClassifiersWithStaticMethods_1206021753918(_context.getModel(), operationContext.getScope(), _context.getParentNode());
          }

        };
        Iterable<SNode> queryResult = (Iterable)calc.calculate();
        assert queryResult != null;
        for(final SNode item : queryResult) {
          result.add(new DefaultChildNodeSubstituteAction(outputConcept, item, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {

            public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
              SNode result = SConceptOperations.createNewNode("jetbrains.mps.bootstrap.smodelLanguage.structure.StaticConceptMethodCall", null);
              SLinkOperations.setTarget(result, "concept", (item), false);
              return result;
            }

            public String getMatchingText(String pattern) {
              return SPropertyOperations.getString((item), "name") + ".";
            }

            public String getDescriptionText(String pattern) {
              return "static access";
            }

          });
        }
      }
    }
    return result;
  }

  public static List<INodeSubstituteAction> rightTransform_ActionsFactory_SNodeOperation_1144103719164(final IOperationContext operationContext, final RTActionsBuilderContext _context) {
    List<INodeSubstituteAction> result = new ArrayList<INodeSubstituteAction>();
    {
      AbstractConceptDeclaration concept = SModelUtil_new.findConceptDeclaration("jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeOperation", operationContext.getScope());
      result.add(new AbstractRTransformHintSubstituteAction(BaseAdapter.fromAdapter(concept), _context.getSourceNode()) {

        public SNode doSubstitute(String pattern) {
          SLinkOperations.addNewChild(_context.getSourceNode(), "parameter", "jetbrains.mps.bootstrap.smodelLanguage.structure.AbstractOperationParameter");
          return _context.getSourceNode();
        }

        public String getMatchingText(String pattern) {
          return "< .. >";
        }

        public String getDescriptionText(String pattern) {
          return "add operation parameters";
        }

      });
    }
    return result;
  }

  public static List<INodeSubstituteAction> rightTransform_ActionsFactory_Expression_1179535189125(final IOperationContext operationContext, final RTActionsBuilderContext _context) {
    List<INodeSubstituteAction> result = new ArrayList<INodeSubstituteAction>();
    {
      AbstractConceptDeclaration concept = SModelUtil_new.findConceptDeclaration("jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeTypeCastExpression", operationContext.getScope());
      result.add(new AbstractRTransformHintSubstituteAction(BaseAdapter.fromAdapter(concept), _context.getSourceNode()) {

        public SNode doSubstitute(String pattern) {
          SNode newNode = SNodeOperations.replaceWithNewChild(_context.getSourceNode(), "jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeTypeCastExpression");
          SLinkOperations.setTarget(newNode, "leftExpression", _context.getSourceNode(), true);
          return newNode;
        }

        public String getMatchingText(String pattern) {
          return ":";
        }

        public String getDescriptionText(String pattern) {
          return "node type cast";
        }

      });
    }
    return result;
  }

  public static List<INodeSubstituteAction> rightTransform_ActionsFactory_Expression_1179535648214(final IOperationContext operationContext, final RTActionsBuilderContext _context) {
    List<INodeSubstituteAction> result = new ArrayList<INodeSubstituteAction>();
    {
      AbstractConceptDeclaration concept = SModelUtil_new.findConceptDeclaration("jetbrains.mps.bootstrap.smodelLanguage.structure.SemanticDowncastExpression", operationContext.getScope());
      result.add(new AbstractRTransformHintSubstituteAction(BaseAdapter.fromAdapter(concept), _context.getSourceNode()) {

        public SNode doSubstitute(String pattern) {
          SNode newNode = SNodeOperations.replaceWithNewChild(_context.getSourceNode(), "jetbrains.mps.bootstrap.smodelLanguage.structure.SemanticDowncastExpression");
          SLinkOperations.setTarget(newNode, "leftExpression", _context.getSourceNode(), true);
          return newNode;
        }

        public String getMatchingText(String pattern) {
          return "/";
        }

        public String getDescriptionText(String pattern) {
          return "downcast to lower semantic level";
        }

      });
    }
    return result;
  }

  public static List<INodeSubstituteAction> rightTransform_ActionsFactory_IAttributeAccessQualifier_1205263933103(final IOperationContext operationContext, final RTActionsBuilderContext _context) {
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

  public static void removeActionsByCondition_1180467401112(final IOperationContext operationContext, final RemoveSubstituteActionByConditionContext _context) {
    final ApplicableTypesInfo appTypesInfo;
    {
      Calculable calc = new Calculable() {

        public Object calculate() {
          ApplicableTypesInfo result = new ApplicableTypesInfo();
          SNode leftExpression = SLinkOperations.getTarget(_context.getParentNode(), "operand", true);
          if (SNodeOperations.isInstanceOf(_context.getParentNode(), "jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeOperationExpression")) {
            leftExpression = SLinkOperations.getTarget(_context.getParentNode(), "leftExpression", true);
          }
          SNode leftOperation = SLinkOperations.getTarget(leftExpression, "operation", true);
          if (SNodeOperations.isInstanceOf(leftExpression, "jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeOperationExpression")) {
            leftOperation = SLinkOperations.getTarget(leftExpression, "nodeOperation", true);
          }
          SNode leftType = TypeChecker.getInstance().getTypeOf(leftExpression);
          SNode linkAccessT = TypeChecker.getInstance().getRuntimeSupport().coerce(leftType, HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.bootstrap.smodelLanguage.structure._LinkAccessT"), false);
          result.myLinkAccessT = linkAccessT;
          // is concept ?
          if (TypeChecker.getInstance().getRuntimeSupport().coerce(leftType, HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.bootstrap.smodelLanguage.structure.SConceptType"), false) != null) {
            result.myToConcept = true;
          }
          // is node ?
          if (TypeChecker.getInstance().getRuntimeSupport().coerce(leftType, HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType"), false) != null) {
            result.myToNode = true;
          }
          // is smodel ?
          if (TypeChecker.getInstance().getRuntimeSupport().coerce(leftType, HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.bootstrap.smodelLanguage.structure.SModelType"), false) != null) {
            result.myToModel = true;
          }
          return result;
        }

      };
      appTypesInfo = (ApplicableTypesInfo)calc.calculate();
    }
    Iterator<INodeSubstituteAction> actions = _context.getActions();
    while(actions.hasNext()) {
      INodeSubstituteAction current = actions.next();
      final SNode concept = current.getOutputConcept();
      SNode applicableConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeOperation");
      Condition cond = new Condition() {

        public boolean met(Object object) {
          SNode parameterOp = (SNode)concept;
          SNode leftExpression = SLinkOperations.getTarget(_context.getParentNode(), "operand", true);
          if (SNodeOperations.isInstanceOf(_context.getParentNode(), "jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeOperationExpression")) {
            leftExpression = SLinkOperations.getTarget(_context.getParentNode(), "leftExpression", true);
          }
          SNode leftOperation = SLinkOperations.getTarget(leftExpression, "operation", true);
          if (SNodeOperations.isInstanceOf(leftExpression, "jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeOperationExpression")) {
            leftOperation = SLinkOperations.getTarget(leftExpression, "nodeOperation", true);
          }
          // ---
          if (leftOperation != null) {
            if (SNodeOperations.isInstanceOf(leftOperation, "jetbrains.mps.bootstrap.smodelLanguage.structure.SPropertyAccess")) {
              SNode dataType = SLinkOperations.getTarget(SLinkOperations.getTarget(leftOperation, "property", false), "dataType", false);
              if (SNodeOperations.isInstanceOf(dataType, "jetbrains.mps.bootstrap.structureLanguage.structure.EnumerationDataTypeDeclaration")) {
                return !(SConceptPropertyOperations.getBoolean(parameterOp, "applicable_to_enum_property"));
              } else
              {
                return !(SConceptPropertyOperations.getBoolean(parameterOp, "applicable_to_simple_property"));
              }
            }
            if (SNodeOperations.isInstanceOf(leftOperation, "jetbrains.mps.bootstrap.smodelLanguage.structure.SConceptPropertyAccess")) {
              return !(SConceptPropertyOperations.getBoolean(parameterOp, "applicable_to_concept_property"));
            }
          }
          // ==========
          SNode linkAccessT = appTypesInfo.myLinkAccessT;
          if (linkAccessT != null) {
            if (SPropertyOperations.getBoolean(linkAccessT, "singularCradinality")) {
              return !(SConceptPropertyOperations.getBoolean(parameterOp, "applicable_to_link"));
            }
            return !(SConceptPropertyOperations.getBoolean(parameterOp, "applicable_to_linkList"));
          }
          // is concept ?
          if (appTypesInfo.myToConcept) {
            return !(SConceptPropertyOperations.getBoolean(parameterOp, "applicable_to_concept"));
          }
          // is node ?
          if (appTypesInfo.myToNode) {
            return !(SConceptPropertyOperations.getBoolean(parameterOp, "applicable_to_node"));
          }
          // is smodel ?
          if (appTypesInfo.myToModel) {
            return !(SConceptPropertyOperations.getBoolean(parameterOp, "applicable_to_model"));
          }
          return true;
        }

      };
      if (SConceptOperations.isSuperConceptOf(applicableConcept, NameUtil.nodeFQName(concept)) && cond.met(concept)) {
        actions.remove();
      }
    }
  }

}
