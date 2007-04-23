package jetbrains.mps.baseLanguage.actions;

/*Generated by MPS  */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.baseLanguage.structure.ClassifierType;
import jetbrains.mps.baseLanguage.types.BaseLanguageTypesUtil_new;
import jetbrains.mps.baseLanguage.structure.Expression;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.smodel.BaseAdapter;
import jetbrains.mps.baseLanguage.structure.ArrayType;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.generator.JavaModelUtil_new;
import jetbrains.mps.baseLanguage.ext.collections.internal.ICursor;
import jetbrains.mps.baseLanguage.ext.collections.internal.CursorFactory;
import jetbrains.mps.baseLanguage.ext.collections.internal.query.SequenceOperations;
import java.util.List;
import jetbrains.mps.smodel.action.INodeSubstituteAction;
import jetbrains.mps.bootstrap.structureLanguage.structure.ConceptDeclaration;
import jetbrains.mps.smodel.action.IChildNodeSetter;
import java.util.ArrayList;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.smodel.action.DefaultSimpleSubstituteAction;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SPropertyOperations;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import jetbrains.mps.util.Calculable;
import jetbrains.mps.baseLanguage.ext.collections.internal.query.ListOperations;
import jetbrains.mps.smodel.action.DefaultChildNodeSubstituteAction;

public class QueriesGenerated {

  public static boolean nodeSubstituteActionsBuilder_Precondition_Statement_1154539862600(SNode parentNode, IScope scope, IOperationContext operationContext) {
    SNode parent = SNodeOperations.getAncestorWhereConceptInList(parentNode, new String[]{"jetbrains.mps.baseLanguage.structure.AbstractLoopStatement","jetbrains.mps.baseLanguage.structure.Closure"}, false, false);
    if(SNodeOperations.isInstanceOf(parent, "jetbrains.mps.baseLanguage.structure.AbstractLoopStatement")) {
      return true;
    }
    parent = SNodeOperations.getAncestorWhereConceptInList(parentNode, new String[]{"jetbrains.mps.baseLanguage.structure.SwitchStatement"}, false, false);
    if(SNodeOperations.isInstanceOf(parent, "jetbrains.mps.baseLanguage.structure.SwitchStatement")) {
      return true;
    }
    return false;
  }
  public static boolean rightTransformHintSubstituteActionsBuilder_Precondition_Expression_1158965431412(SNode sourceNode, IScope scope, IOperationContext operationContext) {
    ClassifierType ct = BaseLanguageTypesUtil_new.tryObtain_ClassifierType(((Expression)SNodeOperations.getAdapter(sourceNode)));
    return ct != null;
  }
  public static boolean rightTransformHintSubstituteActionsBuilder_Precondition_Expression_1173186369008(SNode sourceNode, IScope scope, IOperationContext operationContext) {
    TypeChecker typeChecker = operationContext.getComponent(TypeChecker.class);
    return BaseAdapter.fromNode(typeChecker.getTypeOf(sourceNode)) instanceof ArrayType;
  }
  public static boolean rightTransformHintSubstituteActionsBuilder_Precondition_Expression_1173186583931(SNode sourceNode, IScope scope, IOperationContext operationContext) {
    TypeChecker typeChecker = operationContext.getComponent(TypeChecker.class);
    return BaseAdapter.fromNode(typeChecker.getTypeOf(sourceNode)) instanceof ArrayType;
  }
  public static boolean rightTransformHintSubstituteActionsBuilder_Precondition_VariableDeclaration_1158969943216(SNode sourceNode, IScope scope, IOperationContext operationContext) {
    if(SLinkOperations.getTarget(sourceNode, "initializer", true) != null) {
      return false;
    }
    if(SNodeOperations.isInstanceOf(sourceNode, "jetbrains.mps.baseLanguage.structure.FieldDeclaration") || SNodeOperations.isInstanceOf(sourceNode, "jetbrains.mps.baseLanguage.structure.StaticFieldDeclaration")) {
      return true;
    }
    if(SNodeOperations.isInstanceOf(sourceNode, "jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration")) {
      SNode parent = SNodeOperations.getParent(sourceNode, null, false, false);
      if(SNodeOperations.isInstanceOf(parent, "jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement") || SNodeOperations.isInstanceOf(parent, "jetbrains.mps.baseLanguage.structure.ForStatement")) {
        return true;
      }
    }
    return false;
  }
  public static boolean rightTransformHintSubstituteActionsBuilder_Precondition_ClassifierType_1158972050511(SNode sourceNode, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getCount(sourceNode, "parameter") == 0;
  }
  public static boolean rightTransformHintSubstituteActionsBuilder_Precondition_GenericDeclaration_1159200256287(SNode sourceNode, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getCount(sourceNode, "typeVariableDeclaration") == 0;
  }
  public static boolean rightTransformHintSubstituteActionsBuilder_Precondition_NewExpression_1159200493867(SNode sourceNode, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getCount(sourceNode, "typeParameter") == 0;
  }
  public static void nodeFactory_NodeSetup_InstanceMethodDeclaration_1158793299786(SNode newNode, SNode sampleNode, SNode enclosingNode, SModel model) {
    SLinkOperations.setNewChild(newNode, "returnType", "jetbrains.mps.baseLanguage.structure.VoidType");
  }
  public static void nodeFactory_NodeSetup_BinaryOperation_1158797366355(SNode newNode, SNode sampleNode, SNode enclosingNode, SModel model) {
    if(SNodeOperations.isInstanceOf(sampleNode, "jetbrains.mps.baseLanguage.structure.BinaryOperation")) {
      SLinkOperations.setTarget(newNode, "leftExpression", SLinkOperations.getTarget(sampleNode, "leftExpression", true), true);
      SLinkOperations.setTarget(newNode, "rightExpression", SLinkOperations.getTarget(sampleNode, "rightExpression", true), true);
    }
  }
  public static void nodeFactory_NodeSetup_ParenthesizedExpression_1158857529259(SNode newNode, SNode sampleNode, SNode enclosingNode, SModel model) {
    if(SNodeOperations.isInstanceOf(sampleNode, "jetbrains.mps.baseLanguage.structure.Expression")) {
      SLinkOperations.setTarget(newNode, "expression", SNodeOperations.copyNode(sampleNode), true);
    }
  }
  public static void nodeFactory_NodeSetup_CastExpression_1158871408598(SNode newNode, SNode sampleNode, SNode enclosingNode, SModel model) {
    if(SNodeOperations.isInstanceOf(sampleNode, "jetbrains.mps.baseLanguage.structure.Expression")) {
      SLinkOperations.setTarget(newNode, "expression", SNodeOperations.copyNode(sampleNode), true);
      SNode castType = CastExpression_FactoryUtil.computeCastType(sampleNode);
      SLinkOperations.setTarget(newNode, "type", castType, true);
    }
  }
  public static void nodeFactory_NodeSetup_ReturnStatement_1158938591702(SNode newNode, SNode sampleNode, SNode enclosingNode, SModel model) {
    if(SNodeOperations.isInstanceOf(sampleNode, "jetbrains.mps.baseLanguage.structure.ExpressionStatement")) {
      SLinkOperations.setTarget(newNode, "expression", SNodeOperations.copyNode(SLinkOperations.getTarget(sampleNode, "expression", true)), true);
    }
  }
  public static void nodeFactory_NodeSetup_NotExpression_1159218040861(SNode newNode, SNode sampleNode, SNode enclosingNode, SModel model) {
    if(SNodeOperations.isInstanceOf(sampleNode, "jetbrains.mps.baseLanguage.structure.Expression")) {
      SLinkOperations.setTarget(newNode, "expression", SNodeOperations.copyNode(sampleNode), true);
    }
  }
  public static void nodeFactory_NodeSetup_SuperConstructorInvocation_1175861783127(SNode newNode, SNode sampleNode, SNode enclosingNode, SModel model) {
    SNode cls = SNodeOperations.getAncestor(enclosingNode, "jetbrains.mps.baseLanguage.structure.ClassConcept", false, false);
    SNode extendedClass = JavaModelUtil_new.findClassifier(Object.class).getNode();
    if(SLinkOperations.getTarget(SLinkOperations.getTarget(cls, "superclass", true), "classifier", false) != null) {
      extendedClass = SLinkOperations.getTarget(SLinkOperations.getTarget(cls, "superclass", true), "classifier", false);
    }
    {
      ICursor<SNode> _zCursor = CursorFactory.createCursor(SLinkOperations.getTargets(extendedClass, "constructor", true));
      try {
        while(_zCursor.moveToNext()) {
          SNode constructor = _zCursor.getCurrent();
          if(SequenceOperations.isEmpty(SLinkOperations.getTargets(constructor, "parameter", true))) {
            SLinkOperations.setTarget(newNode, "constructorDeclaration", constructor, false);
            return;
          }
        }
      } finally {
        _zCursor.release();
      }
    }
  }
  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_Expression_1177334764520(final SNode sourceNode, final SNode currentTargetNode, final ConceptDeclaration childConcept, final IChildNodeSetter childSetter, final IOperationContext operationContext) {
    List<INodeSubstituteAction> result = new ArrayList<INodeSubstituteAction>();
    {
      ConceptDeclaration concept = SModelUtil_new.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.IntegerConstant", operationContext.getScope());
      result.add(new DefaultSimpleSubstituteAction(concept, sourceNode, currentTargetNode, childSetter, operationContext.getScope()) {

        public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
          SNode boolConst = SModelOperations.createNewNode(model, "jetbrains.mps.baseLanguage.structure.IntegerConstant");
          SPropertyOperations.set(boolConst, "value", "" + (Integer.parseInt(pattern)));
          return boolConst;
        }
        public boolean hasSubstitute() {
          return true;
        }
        public boolean canSubstitute_internal(String pattern) {
          {
            Pattern _pattern_0 = Pattern.compile("(?:\\d)+", 0);
            Matcher _matcher_0 = _pattern_0.matcher(pattern);
            if(_matcher_0.matches()) {
              return true;
            }
          }
          return false;
        }
      });
    }
    {
      ConceptDeclaration concept = SModelUtil_new.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.BooleanConstant", operationContext.getScope());
      result.add(new DefaultSimpleSubstituteAction(concept, sourceNode, currentTargetNode, childSetter, operationContext.getScope()) {

        public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
          SNode integerConst = SModelOperations.createNewNode(model, "jetbrains.mps.baseLanguage.structure.BooleanConstant");
          SPropertyOperations.set(integerConst, "value", "" + (true));
          return integerConst;
        }
        public String getMatchingText(String pattern) {
          return "true";
        }
      });
    }
    {
      ConceptDeclaration concept = SModelUtil_new.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.BooleanConstant", operationContext.getScope());
      result.add(new DefaultSimpleSubstituteAction(concept, sourceNode, currentTargetNode, childSetter, operationContext.getScope()) {

        public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
          SNode boolConst = SModelOperations.createNewNode(model, "jetbrains.mps.baseLanguage.structure.BooleanConstant");
          SPropertyOperations.set(boolConst, "value", "" + (false));
          return boolConst;
        }
        public String getMatchingText(String pattern) {
          return "false";
        }
      });
    }
    {
      ConceptDeclaration concept = SModelUtil_new.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.FloatingPointConstant", operationContext.getScope());
      result.add(new DefaultSimpleSubstituteAction(concept, sourceNode, currentTargetNode, childSetter, operationContext.getScope()) {

        public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
          SNode boolConst = SModelOperations.createNewNode(model, "jetbrains.mps.baseLanguage.structure.FloatingPointConstant");
          SPropertyOperations.set(boolConst, "value", pattern);
          return boolConst;
        }
        public boolean hasSubstitute() {
          return true;
        }
        public boolean canSubstitute_internal(String pattern) {
          {
            Pattern _pattern_0 = Pattern.compile("(?:(?:(?:-)?))(?:(?:(?:\\d)+)(?:(?:\\.)(?:(?:\\d)*)))", 0);
            Matcher _matcher_0 = _pattern_0.matcher(pattern);
            if(_matcher_0.matches()) {
              return true;
            }
          }
          return false;
        }
      });
    }
    return result;
  }
  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_Expression_1177338141665(final SNode sourceNode, final SNode currentTargetNode, final ConceptDeclaration childConcept, final IChildNodeSetter childSetter, final IOperationContext operationContext) {
    List<INodeSubstituteAction> result = new ArrayList<INodeSubstituteAction>();
    {
      ConceptDeclaration concept = SModelUtil_new.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.IntegerConstant", operationContext.getScope());
      Calculable calc = new Calculable() {

        public Object calculate() {
          List<Integer> ints = new ArrayList<Integer>();
          ListOperations.addElement(ints, 239);
          ListOperations.addElement(ints, 30);
          return ints;
        }
      };
      List<Integer> queryResult = (List)calc.calculate();
      for(Integer item : queryResult) {
        result.add(new DefaultChildNodeSubstituteAction(item, sourceNode, currentTargetNode, childSetter, operationContext.getScope()) {

          public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
            SNode cons = SModelOperations.createNewNode(model, "jetbrains.mps.baseLanguage.structure.IntegerConstant");
            SPropertyOperations.set(cons, "value", "" + (((Integer)this.getParameterObject())));
            return cons;
          }
          public String getMatchingText(String pattern) {
            return ((Integer)this.getParameterObject()) + "";
          }
          public String getDescriptionText(String pattern) {
            return "predefined integer";
          }
        });
      }
    }
    return result;
  }
}
