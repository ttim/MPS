package jetbrains.mps.nanoj.actions;

/*Generated by MPS */

import java.util.List;
import jetbrains.mps.smodel.action.INodeSubstituteAction;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.bootstrap.structureLanguage.structure.AbstractConceptDeclaration;
import jetbrains.mps.smodel.action.IChildNodeSetter;
import jetbrains.mps.smodel.IOperationContext;
import java.util.ArrayList;
import jetbrains.mps.bootstrap.structureLanguage.structure.ConceptDeclaration;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.smodel.action.DefaultSimpleSubstituteAction;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.smodel.action.AbstractChildNodeSetter;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.smodel.action.ModelActions;
import jetbrains.mps.smodel.action.AbstractRTransformHintSubstituteAction;
import jetbrains.mps.smodel.BaseAdapter;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.util.Calculable;

public class QueriesGenerated {

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_Expression_1197555611566(final SNode parentNode, final SNode currentTargetNode, final AbstractConceptDeclaration childConcept, final IChildNodeSetter childSetter, final IOperationContext operationContext) {
    List<INodeSubstituteAction> result = new ArrayList<INodeSubstituteAction>();
    {
      ConceptDeclaration concept = SModelUtil_new.findConceptDeclaration("jetbrains.mps.nanoj.structure.Expression", operationContext.getScope());
      result.add(new DefaultSimpleSubstituteAction(concept, parentNode, currentTargetNode, childSetter, operationContext.getScope()) {

        public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
          int value = Integer.parseInt(pattern);
          SNode result = SModelOperations.createNewNode(model, "jetbrains.mps.nanoj.structure.NumberExpression", null);
          SPropertyOperations.set(result, "number", "" + (value));
          return result;
        }

        public boolean hasSubstitute() {
          return true;
        }

        public boolean canSubstitute_internal(String pattern) {
          return _PrecompiledPatterns.REGEXP.matcher(pattern).matches();
        }

      });
    }
    return result;
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_Statement_1197555611600(final SNode parentNode, final SNode currentTargetNode, final AbstractConceptDeclaration childConcept, final IChildNodeSetter childSetter, final IOperationContext operationContext) {
    List<INodeSubstituteAction> result = new ArrayList<INodeSubstituteAction>();
    {
      ConceptDeclaration concept = SModelUtil_new.findConceptDeclaration("jetbrains.mps.nanoj.structure.Statement", operationContext.getScope());
      ConceptDeclaration wrappedConcept = SModelUtil_new.findConceptDeclaration("jetbrains.mps.nanoj.structure.LocalVariableDeclaration", operationContext.getScope());
      IChildNodeSetter setter = new AbstractChildNodeSetter() {

        public SNode wrapNode(SNode nodeToWrap, SModel model) {
          SNode result = SModelOperations.createNewNode(model, "jetbrains.mps.nanoj.structure.LocalVariableDeclarationStatement", null);
          SLinkOperations.setTarget(result, "declaration", nodeToWrap, true);
          return result;
        }

        public void doExecute(SNode pn, SNode oc, SNode nc, IScope sc) {
          childSetter.execute(parentNode, currentTargetNode, this.wrapNode(nc, nc.getModel()), operationContext.getScope());
        }

      };
      result.addAll(ModelActions.createChildSubstituteActions(parentNode, currentTargetNode, wrappedConcept, setter, operationContext));
    }
    return result;
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_Statement_1197555611621(final SNode parentNode, final SNode currentTargetNode, final AbstractConceptDeclaration childConcept, final IChildNodeSetter childSetter, final IOperationContext operationContext) {
    List<INodeSubstituteAction> result = new ArrayList<INodeSubstituteAction>();
    {
      ConceptDeclaration concept = SModelUtil_new.findConceptDeclaration("jetbrains.mps.nanoj.structure.Statement", operationContext.getScope());
      ConceptDeclaration wrappedConcept = SModelUtil_new.findConceptDeclaration("jetbrains.mps.nanoj.structure.Expression", operationContext.getScope());
      IChildNodeSetter setter = new AbstractChildNodeSetter() {

        public SNode wrapNode(SNode nodeToWrap, SModel model) {
          SNode result = SModelOperations.createNewNode(model, "jetbrains.mps.nanoj.structure.ExpressionStatement", null);
          SLinkOperations.setTarget(result, "expr", nodeToWrap, true);
          return result;
        }

        public void doExecute(SNode pn, SNode oc, SNode nc, IScope sc) {
          childSetter.execute(parentNode, currentTargetNode, this.wrapNode(nc, nc.getModel()), operationContext.getScope());
        }

      };
      result.addAll(ModelActions.createChildSubstituteActions(parentNode, currentTargetNode, wrappedConcept, setter, operationContext));
    }
    return result;
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_LocalVariableDeclaration_1197555611642(final SNode parentNode, final SNode currentTargetNode, final AbstractConceptDeclaration childConcept, final IChildNodeSetter childSetter, final IOperationContext operationContext) {
    List<INodeSubstituteAction> result = new ArrayList<INodeSubstituteAction>();
    {
      ConceptDeclaration concept = SModelUtil_new.findConceptDeclaration("jetbrains.mps.nanoj.structure.LocalVariableDeclaration", operationContext.getScope());
      ConceptDeclaration wrappedConcept = SModelUtil_new.findConceptDeclaration("jetbrains.mps.nanoj.structure.Type", operationContext.getScope());
      IChildNodeSetter setter = new AbstractChildNodeSetter() {

        public SNode wrapNode(SNode nodeToWrap, SModel model) {
          SNode result = SModelOperations.createNewNode(model, "jetbrains.mps.nanoj.structure.LocalVariableDeclaration", null);
          SLinkOperations.setTarget(result, "type", nodeToWrap, true);
          return result;
        }

        public void doExecute(SNode pn, SNode oc, SNode nc, IScope sc) {
          childSetter.execute(parentNode, currentTargetNode, this.wrapNode(nc, nc.getModel()), operationContext.getScope());
        }

      };
      result.addAll(ModelActions.createChildSubstituteActions(parentNode, currentTargetNode, wrappedConcept, setter, operationContext));
    }
    return result;
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_ParameterDeclaration_1197555611663(final SNode parentNode, final SNode currentTargetNode, final AbstractConceptDeclaration childConcept, final IChildNodeSetter childSetter, final IOperationContext operationContext) {
    List<INodeSubstituteAction> result = new ArrayList<INodeSubstituteAction>();
    {
      ConceptDeclaration concept = SModelUtil_new.findConceptDeclaration("jetbrains.mps.nanoj.structure.ParameterDeclaration", operationContext.getScope());
      ConceptDeclaration wrappedConcept = SModelUtil_new.findConceptDeclaration("jetbrains.mps.nanoj.structure.Type", operationContext.getScope());
      IChildNodeSetter setter = new AbstractChildNodeSetter() {

        public SNode wrapNode(SNode nodeToWrap, SModel model) {
          SNode result = SModelOperations.createNewNode(model, "jetbrains.mps.nanoj.structure.ParameterDeclaration", null);
          SLinkOperations.setTarget(result, "type", nodeToWrap, true);
          return result;
        }

        public void doExecute(SNode pn, SNode oc, SNode nc, IScope sc) {
          childSetter.execute(parentNode, currentTargetNode, this.wrapNode(nc, nc.getModel()), operationContext.getScope());
        }

      };
      result.addAll(ModelActions.createChildSubstituteActions(parentNode, currentTargetNode, wrappedConcept, setter, operationContext));
    }
    return result;
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_FieldDeclaration_1197555611684(final SNode parentNode, final SNode currentTargetNode, final AbstractConceptDeclaration childConcept, final IChildNodeSetter childSetter, final IOperationContext operationContext) {
    List<INodeSubstituteAction> result = new ArrayList<INodeSubstituteAction>();
    {
      ConceptDeclaration concept = SModelUtil_new.findConceptDeclaration("jetbrains.mps.nanoj.structure.FieldDeclaration", operationContext.getScope());
      ConceptDeclaration wrappedConcept = SModelUtil_new.findConceptDeclaration("jetbrains.mps.nanoj.structure.Type", operationContext.getScope());
      IChildNodeSetter setter = new AbstractChildNodeSetter() {

        public SNode wrapNode(SNode nodeToWrap, SModel model) {
          SNode result = SModelOperations.createNewNode(model, "jetbrains.mps.nanoj.structure.FieldDeclaration", null);
          SLinkOperations.setTarget(result, "type", nodeToWrap, true);
          return result;
        }

        public void doExecute(SNode pn, SNode oc, SNode nc, IScope sc) {
          childSetter.execute(parentNode, currentTargetNode, this.wrapNode(nc, nc.getModel()), operationContext.getScope());
        }

      };
      result.addAll(ModelActions.createChildSubstituteActions(parentNode, currentTargetNode, wrappedConcept, setter, operationContext));
    }
    return result;
  }

  public static List<INodeSubstituteAction> rightTransform_ActionsFactory_Expression_1197555611296(final SNode sourceNode, final SModel model, String transformationTag, final IOperationContext operationContext) {
    List<INodeSubstituteAction> result = new ArrayList<INodeSubstituteAction>();
    {
      ConceptDeclaration concept = SModelUtil_new.findConceptDeclaration("jetbrains.mps.nanoj.structure.BinaryExpression", operationContext.getScope());
      result.add(new AbstractRTransformHintSubstituteAction(BaseAdapter.fromAdapter(concept), sourceNode) {

        public SNode doSubstitute(String pattern) {
          SNode newNode = SModelOperations.createNewNode(model, "jetbrains.mps.nanoj.structure.BinaryExpression", null);
          SNodeOperations.replaceWithAnother(sourceNode, newNode);
          SLinkOperations.setTarget(newNode, "left", sourceNode, true);
          return newNode;
        }

        public String getMatchingText(String pattern) {
          return "sign";
        }

      });
    }
    return result;
  }

  public static List<INodeSubstituteAction> rightTransform_ActionsFactory_Expression_1197555611326(final SNode sourceNode, final SModel model, String transformationTag, final IOperationContext operationContext) {
    List<INodeSubstituteAction> result = new ArrayList<INodeSubstituteAction>();
    {
      ConceptDeclaration concept = SModelUtil_new.findConceptDeclaration("jetbrains.mps.nanoj.structure.PlusExpression", operationContext.getScope());
      result.add(new AbstractRTransformHintSubstituteAction(BaseAdapter.fromAdapter(concept), sourceNode) {

        public SNode doSubstitute(String pattern) {
          SNode newNode = SModelOperations.createNewNode(model, "jetbrains.mps.nanoj.structure.PlusExpression", null);
          SNodeOperations.replaceWithAnother(sourceNode, newNode);
          SLinkOperations.setTarget(newNode, "left", sourceNode, true);
          return newNode;
        }

        public String getMatchingText(String pattern) {
          return "+";
        }

      });
    }
    return result;
  }

  public static List<INodeSubstituteAction> rightTransform_ActionsFactory_Expression_1197555611356(final SNode sourceNode, final SModel model, String transformationTag, final IOperationContext operationContext) {
    List<INodeSubstituteAction> result = new ArrayList<INodeSubstituteAction>();
    {
      ConceptDeclaration concept = SModelUtil_new.findConceptDeclaration("jetbrains.mps.nanoj.structure.MinusExpression", operationContext.getScope());
      result.add(new AbstractRTransformHintSubstituteAction(BaseAdapter.fromAdapter(concept), sourceNode) {

        public SNode doSubstitute(String pattern) {
          SNode newNode = SModelOperations.createNewNode(model, "jetbrains.mps.nanoj.structure.MinusExpression", null);
          SNodeOperations.replaceWithAnother(sourceNode, newNode);
          SLinkOperations.setTarget(newNode, "left", sourceNode, true);
          return newNode;
        }

        public String getMatchingText(String pattern) {
          return "-";
        }

      });
    }
    return result;
  }

  public static List<INodeSubstituteAction> rightTransform_ActionsFactory_Expression_1197555611386(final SNode sourceNode, final SModel model, String transformationTag, final IOperationContext operationContext) {
    List<INodeSubstituteAction> result = new ArrayList<INodeSubstituteAction>();
    {
      ConceptDeclaration concept = SModelUtil_new.findConceptDeclaration("jetbrains.mps.nanoj.structure.MulExpression", operationContext.getScope());
      result.add(new AbstractRTransformHintSubstituteAction(BaseAdapter.fromAdapter(concept), sourceNode) {

        public SNode doSubstitute(String pattern) {
          SNode newNode = SModelOperations.createNewNode(model, "jetbrains.mps.nanoj.structure.MulExpression", null);
          SNodeOperations.replaceWithAnother(sourceNode, newNode);
          SLinkOperations.setTarget(newNode, "left", sourceNode, true);
          return newNode;
        }

        public String getMatchingText(String pattern) {
          return "*";
        }

      });
    }
    return result;
  }

  public static List<INodeSubstituteAction> rightTransform_ActionsFactory_Expression_1197555611416(final SNode sourceNode, final SModel model, String transformationTag, final IOperationContext operationContext) {
    List<INodeSubstituteAction> result = new ArrayList<INodeSubstituteAction>();
    {
      ConceptDeclaration concept = SModelUtil_new.findConceptDeclaration("jetbrains.mps.nanoj.structure.DivExpression", operationContext.getScope());
      result.add(new AbstractRTransformHintSubstituteAction(BaseAdapter.fromAdapter(concept), sourceNode) {

        public SNode doSubstitute(String pattern) {
          SNode newNode = SModelOperations.createNewNode(model, "jetbrains.mps.nanoj.structure.DivExpression", null);
          SNodeOperations.replaceWithAnother(sourceNode, newNode);
          SLinkOperations.setTarget(newNode, "left", sourceNode, true);
          return newNode;
        }

        public String getMatchingText(String pattern) {
          return "/";
        }

      });
    }
    return result;
  }

  public static List<INodeSubstituteAction> rightTransform_ActionsFactory_Expression_1197555611446(final SNode sourceNode, final SModel model, String transformationTag, final IOperationContext operationContext) {
    List<INodeSubstituteAction> result = new ArrayList<INodeSubstituteAction>();
    {
      ConceptDeclaration concept = SModelUtil_new.findConceptDeclaration("jetbrains.mps.nanoj.structure.AssignmentExpression", operationContext.getScope());
      result.add(new AbstractRTransformHintSubstituteAction(BaseAdapter.fromAdapter(concept), sourceNode) {

        public SNode doSubstitute(String pattern) {
          SNode newNode = SModelOperations.createNewNode(model, "jetbrains.mps.nanoj.structure.AssignmentExpression", null);
          SNodeOperations.replaceWithAnother(sourceNode, newNode);
          SLinkOperations.setTarget(newNode, "left", sourceNode, true);
          return newNode;
        }

        public String getMatchingText(String pattern) {
          return "=";
        }

      });
    }
    return result;
  }

  public static List<INodeSubstituteAction> rightTransform_ActionsFactory_Expression_1197555611476(final SNode sourceNode, final SModel model, String transformationTag, final IOperationContext operationContext) {
    List<INodeSubstituteAction> result = new ArrayList<INodeSubstituteAction>();
    {
      ConceptDeclaration concept = SModelUtil_new.findConceptDeclaration("jetbrains.mps.nanoj.structure.EqualsExpression", operationContext.getScope());
      result.add(new AbstractRTransformHintSubstituteAction(BaseAdapter.fromAdapter(concept), sourceNode) {

        public SNode doSubstitute(String pattern) {
          SNode newNode = SModelOperations.createNewNode(model, "jetbrains.mps.nanoj.structure.EqualsExpression", null);
          SNodeOperations.replaceWithAnother(sourceNode, newNode);
          SLinkOperations.setTarget(newNode, "left", sourceNode, true);
          return newNode;
        }

        public String getMatchingText(String pattern) {
          return "==";
        }

      });
    }
    return result;
  }

  public static List<INodeSubstituteAction> rightTransform_ActionsFactory_Expression_1197555611506(final SNode sourceNode, final SModel model, String transformationTag, final IOperationContext operationContext) {
    List<INodeSubstituteAction> result = new ArrayList<INodeSubstituteAction>();
    {
      ConceptDeclaration concept = SModelUtil_new.findConceptDeclaration("jetbrains.mps.nanoj.structure.NotEqualsExpression", operationContext.getScope());
      result.add(new AbstractRTransformHintSubstituteAction(BaseAdapter.fromAdapter(concept), sourceNode) {

        public SNode doSubstitute(String pattern) {
          SNode newNode = SModelOperations.createNewNode(model, "jetbrains.mps.nanoj.structure.NotEqualsExpression", null);
          SNodeOperations.replaceWithAnother(sourceNode, newNode);
          SLinkOperations.setTarget(newNode, "left", sourceNode, true);
          return newNode;
        }

        public String getMatchingText(String pattern) {
          return "!=";
        }

      });
    }
    return result;
  }

  public static List<INodeSubstituteAction> rightTransform_ActionsFactory_Expression_1197555611536(final SNode sourceNode, final SModel model, String transformationTag, final IOperationContext operationContext) {
    List<INodeSubstituteAction> result = new ArrayList<INodeSubstituteAction>();
    {
      ConceptDeclaration concept = SModelUtil_new.findConceptDeclaration("jetbrains.mps.nanoj.structure.InstanceMethodCallExpression", operationContext.getScope());
      result.add(new AbstractRTransformHintSubstituteAction(BaseAdapter.fromAdapter(concept), sourceNode) {

        public SNode doSubstitute(String pattern) {
          SNode newNode = SModelOperations.createNewNode(model, "jetbrains.mps.nanoj.structure.InstanceMethodCallExpression", null);
          SNodeOperations.replaceWithAnother(sourceNode, newNode);
          SLinkOperations.setTarget(newNode, "instance", sourceNode, true);
          return newNode;
        }

        public String getMatchingText(String pattern) {
          return ".";
        }

      });
    }
    return result;
  }

  public static List<INodeSubstituteAction> rightTransform_ActionsFactory_Expression_1197555611705(final SNode sourceNode, final SModel model, String transformationTag, final IOperationContext operationContext) {
    List<INodeSubstituteAction> result = new ArrayList<INodeSubstituteAction>();
    {
      ConceptDeclaration concept = SModelUtil_new.findConceptDeclaration("null", operationContext.getScope());
      result.add(new AbstractRTransformHintSubstituteAction(BaseAdapter.fromAdapter(concept), sourceNode) {

        public SNode doSubstitute(String pattern) {
          SNode dotConceptInstance = SConceptOperations.createNewNode("jetbrains.mps.nanoj.structure.DotExpression", null);
          SNodeOperations.replaceWithAnother(sourceNode, dotConceptInstance);
          SLinkOperations.setTarget(dotConceptInstance, "leftPart", sourceNode, true);
          return dotConceptInstance;
        }

        public String getMatchingText(String pattern) {
          return ". dot";
        }

      });
    }
    return result;
  }

  public static List<INodeSubstituteAction> rightTransform_ActionsFactory_ExpressionDotOperation_1197555611731(final SNode sourceNode, final SModel model, String transformationTag, final IOperationContext operationContext) {
    List<INodeSubstituteAction> result = new ArrayList<INodeSubstituteAction>();
    {
      Calculable calc = new Calculable() {

        public Object calculate() {
          return SNodeOperations.getParent(sourceNode, null, false, false);
        }

      };
      SNode node = (SNode)calc.calculate();
      result.addAll(ModelActions.createRightTransformHintSubstituteActions(node, transformationTag, operationContext));
    }
    return result;
  }

}
