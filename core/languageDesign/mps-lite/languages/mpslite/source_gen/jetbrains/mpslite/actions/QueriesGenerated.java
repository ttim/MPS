package jetbrains.mpslite.actions;

/*Generated by MPS */

import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.action.NodeSubstitutePreconditionContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.action.SideTransformPreconditionContext;
import jetbrains.mps.typesystem.inference.TypeChecker;
import java.util.List;
import jetbrains.mps.smodel.action.INodeSubstituteAction;
import jetbrains.mps.smodel.action.NodeSubstituteActionsFactoryContext;
import java.util.ArrayList;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.smodel.action.DefaultSimpleSubstituteAction;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.smodel.action.ChildSubstituteActionsHelper;
import jetbrains.mps.smodel.action.SideTransformActionsBuilderContext;
import jetbrains.mps.smodel.action.AbstractSideTransformHintSubstituteAction;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.util.Calculable;
import jetbrains.mps.smodel.action.ModelActions;
import jetbrains.mps.nodeEditor.CellSide;

public class QueriesGenerated {

  public static boolean nodeSubstituteActionsBuilder_Precondition_Expression_1197284175669(final IOperationContext operationContext, final NodeSubstitutePreconditionContext _context) {
    return SNodeOperations.getAncestor(_context.getParentNode(), "jetbrains.mpslite.structure.ConceptDeclaration", true, false) != null;
  }

  public static boolean nodeSubstituteActionsBuilder_Precondition_Statement_1197293111675(final IOperationContext operationContext, final NodeSubstitutePreconditionContext _context) {
    return SNodeOperations.getAncestor(_context.getParentNode(), "jetbrains.mpslite.structure.TypesBlock", true, false) != null;
  }

  public static boolean nodeSubstituteActionsBuilder_Precondition_Expression_1197554046539(final IOperationContext operationContext, final NodeSubstitutePreconditionContext _context) {
    return SNodeOperations.getAncestor(_context.getParentNode(), "jetbrains.mpslite.structure.DotConceptDeclaration", true, false) != null;
  }

  public static boolean nodeSubstituteActionsBuilder_Precondition_Expression_1197631213003(final IOperationContext operationContext, final NodeSubstitutePreconditionContext _context) {
    return SNodeOperations.getAncestor(_context.getParentNode(), "jetbrains.mpslite.structure.BinaryOperationConceptDeclaration", true, false) != null;
  }

  public static boolean sideTransformHintSubstituteActionsBuilder_Precondition_Expression_1196942343253(final IOperationContext operationContext, final SideTransformPreconditionContext _context) {
    return TypeChecker.getInstance().getSubtypingManager().isSubtype(TypeChecker.getInstance().getTypeOf(_context.getSourceNode()), new QuotationClass_0().createNode());
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_LinePart_1182843946099(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = new ArrayList<INodeSubstituteAction>();
    {
      SNode outputConcept = SConceptOperations.findConceptDeclaration("jetbrains.mpslite.structure.ConstantLinePart");
      SNode childConcept = (SNode)_context.getChildConcept();
      if (outputConcept == null || SConceptOperations.isSuperConceptOf(childConcept, NameUtil.nodeFQName(outputConcept))) {
        result.add(new DefaultSimpleSubstituteAction(outputConcept, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {

          public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
            SNode part = SModelOperations.createNewNode(_context.getModel(), "jetbrains.mpslite.structure.ConstantLinePart", null);
            SPropertyOperations.set(part, "text", pattern.substring(1));
            return part;
          }

          public boolean hasSubstitute() {
            return true;
          }

          public boolean canSubstitute_internal(String pattern, boolean strictly) {
            return pattern.startsWith("/");
          }

          public String getDescriptionText(String pattern) {
            return "";
          }

          public String getMatchingText(String pattern) {
            return "/constant text";
          }

          public String getVisibleMatchingText(String pattern) {
            return this.getMatchingText(pattern);
          }

        });
      }
    }
    return result;
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_Expression_1197284173199(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = new ArrayList<INodeSubstituteAction>();
    {
      SNode conceptToAdd = SConceptOperations.findConceptDeclaration("jetbrains.mpslite.structure.ThisNodeExpression");
      List<INodeSubstituteAction> defaultActions = ChildSubstituteActionsHelper.createDefaultActions(conceptToAdd, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext);
      result.addAll(defaultActions);
    }
    return result;
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_Statement_1197293107768(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = new ArrayList<INodeSubstituteAction>();
    {
      SNode conceptToAdd = SConceptOperations.findConceptDeclaration("jetbrains.mpslite.structure.AddEquationStatement");
      List<INodeSubstituteAction> defaultActions = ChildSubstituteActionsHelper.createDefaultActions(conceptToAdd, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext);
      result.addAll(defaultActions);
    }
    {
      SNode conceptToAdd = SConceptOperations.findConceptDeclaration("jetbrains.mpslite.structure.AddInequationStatement");
      List<INodeSubstituteAction> defaultActions = ChildSubstituteActionsHelper.createDefaultActions(conceptToAdd, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext);
      result.addAll(defaultActions);
    }
    {
      SNode conceptToAdd = SConceptOperations.findConceptDeclaration("jetbrains.mpslite.structure.AddComparableConstraintStatement");
      List<INodeSubstituteAction> defaultActions = ChildSubstituteActionsHelper.createDefaultActions(conceptToAdd, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext);
      result.addAll(defaultActions);
    }
    {
      SNode conceptToAdd = SConceptOperations.findConceptDeclaration("jetbrains.mpslite.structure.ReportErrorStatement");
      List<INodeSubstituteAction> defaultActions = ChildSubstituteActionsHelper.createDefaultActions(conceptToAdd, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext);
      result.addAll(defaultActions);
    }
    return result;
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_Expression_1197554040398(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = new ArrayList<INodeSubstituteAction>();
    {
      SNode conceptToAdd = SConceptOperations.findConceptDeclaration("jetbrains.mpslite.structure.LeftPartExpression");
      List<INodeSubstituteAction> defaultActions = ChildSubstituteActionsHelper.createDefaultActions(conceptToAdd, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext);
      result.addAll(defaultActions);
    }
    return result;
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_Expression_1197631213002(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = new ArrayList<INodeSubstituteAction>();
    {
      SNode conceptToAdd = SConceptOperations.findConceptDeclaration("jetbrains.mpslite.structure.LeftPartExpression");
      List<INodeSubstituteAction> defaultActions = ChildSubstituteActionsHelper.createDefaultActions(conceptToAdd, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext);
      result.addAll(defaultActions);
    }
    {
      SNode conceptToAdd = SConceptOperations.findConceptDeclaration("jetbrains.mpslite.structure.RightPartExpression");
      List<INodeSubstituteAction> defaultActions = ChildSubstituteActionsHelper.createDefaultActions(conceptToAdd, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext);
      result.addAll(defaultActions);
    }
    return result;
  }

  public static List<INodeSubstituteAction> sideTransform_ActionsFactory_Expression_1196942335235(final IOperationContext operationContext, final SideTransformActionsBuilderContext _context) {
    List<INodeSubstituteAction> result = new ArrayList<INodeSubstituteAction>();
    {
      SNode concept = SConceptOperations.findConceptDeclaration("jetbrains.mpslite.structure.MPSLiteOperationExpression");
      result.add(new AbstractSideTransformHintSubstituteAction(concept, _context.getSourceNode()) {

        public SNode doSubstitute(String pattern) {
          SNode expr = SModelOperations.createNewNode(_context.getModel(), "jetbrains.mpslite.structure.MPSLiteOperationExpression", null);
          SNodeOperations.replaceWithAnother(_context.getSourceNode(), expr);
          SLinkOperations.setTarget(expr, "expression", _context.getSourceNode(), true);
          return expr;
        }

        public String getMatchingText(String pattern) {
          return ".mps lite operation";
        }

        public String getVisibleMatchingText(String pattern) {
          return this.getMatchingText(pattern);
        }

      });
    }
    return result;
  }

  public static List<INodeSubstituteAction> sideTransform_ActionsFactory_MPSLiteOperation_1196956053923(final IOperationContext operationContext, final SideTransformActionsBuilderContext _context) {
    List<INodeSubstituteAction> result = new ArrayList<INodeSubstituteAction>();
    {
      Calculable calc = new Calculable() {

        public Object calculate() {
          return SNodeOperations.getParent(_context.getSourceNode());
        }

      };
      SNode node = (SNode)calc.calculate();
      result.addAll(ModelActions.createRightTransformHintSubstituteActions(node, CellSide.RIGHT, _context.getTransformationTag(), operationContext));
    }
    return result;
  }

}
