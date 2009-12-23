package jetbrains.mps.lang.typesystem.actions;

/*Generated by MPS */

import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.action.NodeSubstitutePreconditionContext;
import jetbrains.mps.lang.typesystem.typesystem.RulesUtil;
import jetbrains.mps.smodel.action.NodeSetupContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import java.util.List;
import jetbrains.mps.smodel.action.INodeSubstituteAction;
import jetbrains.mps.smodel.action.NodeSubstituteActionsFactoryContext;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.smodel.action.IChildNodeSetter;
import jetbrains.mps.smodel.action.AbstractChildNodeSetter;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.smodel.action.ModelActions;
import jetbrains.mps.smodel.action.ChildSubstituteActionsHelper;
import jetbrains.mps.smodel.action.SideTransformActionsBuilderContext;
import jetbrains.mps.util.Calculable;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.lang.structure.behavior.AbstractConceptDeclaration_Behavior;
import jetbrains.mps.smodel.action.AbstractSideTransformHintSubstituteAction;
import jetbrains.mps.util.NameUtil;

public class QueriesGenerated {
  public static boolean nodeSubstituteActionsBuilder_Precondition_SNodeOperation_1201878705329(final IOperationContext operationContext, final NodeSubstitutePreconditionContext _context) {
    return !(RulesUtil.withinInferenceItem(_context.getParentNode()));
  }

  public static void nodeFactory_NodeSetup_AbstractEquationStatement_1174664649251(final IOperationContext operationContext, final NodeSetupContext _context) {
    if (SNodeOperations.isInstanceOf(_context.getSampleNode(), "jetbrains.mps.lang.typesystem.structure.AbstractEquationStatement")) {
      SLinkOperations.setTarget(_context.getNewNode(), "leftExpression", SLinkOperations.getTarget(SNodeOperations.cast(_context.getSampleNode(), "jetbrains.mps.lang.typesystem.structure.AbstractEquationStatement"), "leftExpression", true), true);
      SLinkOperations.setTarget(_context.getNewNode(), "rightExpression", SLinkOperations.getTarget(SNodeOperations.cast(_context.getSampleNode(), "jetbrains.mps.lang.typesystem.structure.AbstractEquationStatement"), "rightExpression", true), true);
      SLinkOperations.setTarget(_context.getNewNode(), "nodeToCheck", SLinkOperations.getTarget(SNodeOperations.cast(_context.getSampleNode(), "jetbrains.mps.lang.typesystem.structure.AbstractEquationStatement"), "nodeToCheck", true), true);
    }
  }

  public static void nodeFactory_NodeSetup_IsSubtypeExpression_1177408248540(final IOperationContext operationContext, final NodeSetupContext _context) {
    if (SNodeOperations.isInstanceOf(_context.getSampleNode(), "jetbrains.mps.lang.typesystem.structure.IsSubtypeExpression")) {
      SLinkOperations.setTarget(_context.getNewNode(), "subtypeExpression", SLinkOperations.getTarget(SNodeOperations.cast(_context.getSampleNode(), "jetbrains.mps.lang.typesystem.structure.IsSubtypeExpression"), "subtypeExpression", true), true);
      SLinkOperations.setTarget(_context.getNewNode(), "supertypeExpression", SLinkOperations.getTarget(SNodeOperations.cast(_context.getSampleNode(), "jetbrains.mps.lang.typesystem.structure.IsSubtypeExpression"), "supertypeExpression", true), true);
    }
  }

  public static void nodeFactory_NodeSetup_CoerceExpression_1178879020941(final IOperationContext operationContext, final NodeSetupContext _context) {
    if (SNodeOperations.isInstanceOf(_context.getSampleNode(), "jetbrains.mps.lang.typesystem.structure.CoerceExpression")) {
      SLinkOperations.setTarget(_context.getNewNode(), "nodeToCoerce", SLinkOperations.getTarget(SNodeOperations.cast(_context.getSampleNode(), "jetbrains.mps.lang.typesystem.structure.CoerceExpression"), "nodeToCoerce", true), true);
      SLinkOperations.setTarget(_context.getNewNode(), "pattern", SLinkOperations.getTarget(SNodeOperations.cast(_context.getSampleNode(), "jetbrains.mps.lang.typesystem.structure.CoerceExpression"), "pattern", true), true);
    }
  }

  public static void nodeFactory_NodeSetup_TypeOfExpression_1179476271704(final IOperationContext operationContext, final NodeSetupContext _context) {
    if (SNodeOperations.isInstanceOf(_context.getSampleNode(), "jetbrains.mps.baseLanguage.structure.Expression")) {
      if (!(SNodeOperations.isInstanceOf(_context.getSampleNode(), "jetbrains.mps.lang.typesystem.structure.TypeOfExpression"))) {
        SLinkOperations.setTarget(_context.getNewNode(), "term", SNodeOperations.cast(_context.getSampleNode(), "jetbrains.mps.baseLanguage.structure.Expression"), true);
      } else {
        SLinkOperations.setTarget(_context.getNewNode(), "term", SLinkOperations.getTarget(SNodeOperations.cast(_context.getSampleNode(), "jetbrains.mps.lang.typesystem.structure.TypeOfExpression"), "term", true), true);
      }
    }
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_TypeClause_1185801400389(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode wrappedConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.Expression");
      IChildNodeSetter setter = new AbstractChildNodeSetter() {
        public SNode wrapNode(SNode nodeToWrap, SModel model) {
          SNode normalTypeClause = SModelOperations.createNewNode(model, "jetbrains.mps.lang.typesystem.structure.NormalTypeClause", null);
          SLinkOperations.setTarget(normalTypeClause, "normalType", nodeToWrap, true);
          return normalTypeClause;
        }

        public boolean returnSmallPart(SNode nodeToWrap) {
          return false;
        }

        public SNode doExecute(SNode pn, SNode oc, SNode nc, IScope sc) {
          SNode wrappedNode = this.wrapNode(nc, nc.getModel());
          _context.getChildSetter().execute(_context.getParentNode(), _context.getCurrentTargetNode(), wrappedNode, operationContext.getScope());
          if (this.returnSmallPart(nc)) {
            return nc;
          } else {
            return wrappedNode;
          }
        }
      };
      ListSequence.fromList(result).addSequence(ListSequence.fromList(ModelActions.createChildSubstituteActions(_context.getParentNode(), _context.getCurrentTargetNode(), wrappedConcept, setter, operationContext)));
    }
    return result;
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_SNodeOperation_1201875763403(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode conceptToAdd = SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.typesystem.structure.Node_TypeOperation");
      List<INodeSubstituteAction> defaultActions = ChildSubstituteActionsHelper.createDefaultActions(conceptToAdd, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext);
      ListSequence.fromList(result).addSequence(ListSequence.fromList(defaultActions));
    }
    {
      SNode conceptToAdd = SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.typesystem.structure.Node_InferTypeOperation");
      List<INodeSubstituteAction> defaultActions = ChildSubstituteActionsHelper.createDefaultActions(conceptToAdd, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext);
      ListSequence.fromList(result).addSequence(ListSequence.fromList(defaultActions));
    }
    return result;
  }

  public static List<INodeSubstituteAction> sideTransform_ActionsFactory_Expression_1175609466956(final IOperationContext operationContext, final SideTransformActionsBuilderContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      final SNode concept = SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.typesystem.structure.AbstractEquationStatement");
      Calculable calculable = new Calculable() {
        public Object calculate() {
          List<SNode> subconcepts = SConceptOperations.getAllSubConcepts(SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.typesystem.structure.AbstractEquationStatement"), _context.getModel(), operationContext.getScope());
          final IScope scope = operationContext.getScope();
          return ListSequence.fromList(subconcepts).where(new IWhereFilter<SNode>() {
            public boolean accept(SNode it) {
              return AbstractConceptDeclaration_Behavior.call_isDefaultSubstitutableConcept_1213877394594(it, SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.typesystem.structure.AbstractEquationStatement"), scope);
            }
          });
        }
      };
      Iterable<SNode> parameterObjects = (Iterable<SNode>) calculable.calculate();
      assert parameterObjects != null;
      for (final SNode item : parameterObjects) {
        ListSequence.fromList(result).addElement(new AbstractSideTransformHintSubstituteAction(item, _context.getSourceNode()) {
          public SNode doSubstitute(String pattern) {
            SNode result = SConceptOperations.createNewNode(NameUtil.nodeFQName((item)), null);
            SNode statement = SNodeOperations.getAncestor(_context.getSourceNode(), "jetbrains.mps.baseLanguage.structure.Statement", false, false);
            if (statement == null) {
              return null;
            }
            SNodeOperations.replaceWithAnother(statement, result);
            SNode left = SConceptOperations.createNewNode("jetbrains.mps.lang.typesystem.structure.NormalTypeClause", null);
            SLinkOperations.setTarget(left, "normalType", _context.getSourceNode(), true);
            SLinkOperations.setTarget(result, "leftExpression", left, true);
            return result;
          }

          public SNode getOutputConcept() {
            return concept;
          }
        });
      }
    }
    return result;
  }
}
