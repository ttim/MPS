package jetbrains.mps.baseLanguage.collections.actions;

/*Generated by MPS */

import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.action.NodeSubstitutePreconditionContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.action.SideTransformPreconditionContext;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.lang.typesystem.runtime.HUtil;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import java.util.Collection;
import java.util.Arrays;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.smodel.action.NodeSetupContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import java.util.List;
import jetbrains.mps.smodel.action.INodeSubstituteAction;
import jetbrains.mps.smodel.action.NodeSubstituteActionsFactoryContext;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.util.Calculable;
import jetbrains.mps.baseLanguage.collections.internal.query.ListOperations;
import jetbrains.mps.smodel.action.ChildSubstituteActionsHelper;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.smodel.action.DefaultSimpleSubstituteAction;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.smodel.action.SideTransformActionsBuilderContext;
import jetbrains.mps.smodel.action.AbstractSideTransformHintSubstituteAction;
import jetbrains.mps.smodel.action.RemoveSubstituteActionByConditionContext;
import java.util.Iterator;
import jetbrains.mps.util.Condition;

public class QueriesGenerated {

  public static boolean nodeSubstituteActionsBuilder_Precondition_Statement_1160672994889(final IOperationContext operationContext, final NodeSubstitutePreconditionContext _context) {
    SNode block = SNodeOperations.getAncestorWhereConceptInList(_context.getParentNode(), new String[]{"jetbrains.mps.baseLanguage.collections.structure.ValueSupplierBlock","jetbrains.mps.baseLanguage.collections.structure.MapperBlock","jetbrains.mps.baseLanguage.collections.structure.ForEachBlock","jetbrains.mps.baseLanguage.collections.structure.SortBlock"}, false, false);
    return block != null;
  }

  public static boolean nodeSubstituteActionsBuilder_Precondition_Expression_1178286539824(final IOperationContext operationContext, final NodeSubstitutePreconditionContext _context) {
    return SNodeOperations.isInstanceOf(_context.getParentNode(), "jetbrains.mps.baseLanguage.collections.structure.SortOperation") || SNodeOperations.isInstanceOf(_context.getParentNode(), "jetbrains.mps.baseLanguage.collections.structure.SortOperationNew") || SNodeOperations.isInstanceOf(_context.getParentNode(), "jetbrains.mps.baseLanguage.collections.structure.ComparatorSortOperation");
  }

  public static boolean nodeSubstituteActionsBuilder_Precondition_Statement_1224446775945(final IOperationContext operationContext, final NodeSubstitutePreconditionContext _context) {
    SNode cl = SNodeOperations.getAncestor(_context.getParentNode(), "jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral", true, false);
    SNode parent = SNodeOperations.getParent(cl);
    return (cl == null) || !(SNodeOperations.isInstanceOf(parent, "jetbrains.mps.baseLanguage.collections.structure.VisitAllOperation") || SNodeOperations.isInstanceOf(parent, "jetbrains.mps.baseLanguage.collections.structure.TranslateOperation"));
  }

  public static boolean nodeSubstituteActionsBuilder_Precondition_Statement_1224451929757(final IOperationContext operationContext, final NodeSubstitutePreconditionContext _context) {
    SNode cl = SNodeOperations.getAncestor(_context.getParentNode(), "jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral", true, false);
    SNode parent = SNodeOperations.getParent(cl);
    return (cl == null) || !(SNodeOperations.isInstanceOf(parent, "jetbrains.mps.baseLanguage.collections.structure.VisitAllOperation") || SNodeOperations.isInstanceOf(parent, "jetbrains.mps.baseLanguage.collections.structure.TranslateOperation") || SNodeOperations.isInstanceOf(parent, "jetbrains.mps.baseLanguage.collections.structure.SequenceCreator"));
  }

  public static boolean nodeSubstituteActionsBuilder_Precondition_IOperation_1224668332374(final IOperationContext operationContext, final NodeSubstitutePreconditionContext _context) {
    return false;
  }

  public static boolean nodeSubstituteActionsBuilder_Precondition_Expression_1237785981936(final IOperationContext operationContext, final NodeSubstitutePreconditionContext _context) {
    return SNodeOperations.isInstanceOf(_context.getParentNode(), "jetbrains.mps.baseLanguage.collections.structure.TakeOperation");
  }

  public static boolean sideTransformHintSubstituteActionsBuilder_Precondition_Expression_1197932868400(final IOperationContext operationContext, final SideTransformPreconditionContext _context) {
    SNode type = TypeChecker.getInstance().getTypeOf(_context.getSourceNode());
    return (TypeChecker.getInstance().getRuntimeSupport().coerce_(type, HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.baseLanguage.collections.structure.MapType"), false) != null);
  }

  public static boolean sideTransformHintSubstituteActionsBuilder_Precondition_SequenceCreatorWithSupplier_1207757132200(final IOperationContext operationContext, final SideTransformPreconditionContext _context) {
    return (SLinkOperations.getTarget(_context.getSourceNode(), "elementType", true) == null);
  }

  public static boolean sideTransformHintSubstituteActionsBuilder_Precondition_Expression_1225711446897(final IOperationContext operationContext, final SideTransformPreconditionContext _context) {
    return (TypeChecker.getInstance().getRuntimeSupport().coerce_(TypeChecker.getInstance().getTypeOf(_context.getSourceNode()), HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.baseLanguage.collections.structure.ListType"), false) != null);
  }

  public static boolean sideTransformHintSubstituteActionsBuilder_Precondition_Expression_1228229429859(final IOperationContext operationContext, final SideTransformPreconditionContext _context) {
    Collection<SNode> accepted = Arrays.asList(SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.SequenceType"), SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.ListType"), SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.MapType"), SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.SetType"));
    return accepted.contains(SNodeOperations.getConceptDeclaration(TypeChecker.getInstance().getTypeOf(_context.getSourceNode())));
  }

  public static boolean sideTransformHintSubstituteActionsBuilder_Precondition_AbstractContainerCreator_1237731265768(final IOperationContext operationContext, final SideTransformPreconditionContext _context) {
    return SLinkOperations.getCount(_context.getSourceNode(), "initValue") == 0 && (SLinkOperations.getTarget(_context.getSourceNode(), "copyFrom", true) == null);
  }

  public static boolean sideTransformHintSubstituteActionsBuilder_Precondition_HashMapCreator_1240226454998(final IOperationContext operationContext, final SideTransformPreconditionContext _context) {
    return (SLinkOperations.getTarget(_context.getSourceNode(), "initializer", true) == null);
  }

  public static boolean sideTransformHintSubstituteActionsBuilder_Precondition_JoinOperation_1240688931530(final IOperationContext operationContext, final SideTransformPreconditionContext _context) {
    return (SLinkOperations.getTarget(_context.getSourceNode(), "delimiter", true) == null);
  }

  public static void nodeFactory_NodeSetup_DefaultInputElement_1174261447073(final IOperationContext operationContext, final NodeSetupContext _context) {
    SPropertyOperations.set(_context.getNewNode(), "name", "it");
  }

  public static void nodeFactory_NodeSetup_SortOperation_1178286959323(final IOperationContext operationContext, final NodeSetupContext _context) {
    SPropertyOperations.set(SLinkOperations.setNewChild(_context.getNewNode(), "order", "jetbrains.mps.baseLanguage.collections.structure.SortDirection"), "value", "" + (true));
  }

  public static void nodeFactory_NodeSetup_ComparatorSortOperation_1225110009889(final IOperationContext operationContext, final NodeSetupContext _context) {
    SNode sel = SLinkOperations.getTarget(_context.getNewNode(), "closure", true);
    if ((sel == null)) {
      sel = SLinkOperations.setNewChild(_context.getNewNode(), "closure", "jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral");
    }
    SNode pda = SLinkOperations.addNewChild(SNodeOperations.cast(sel, "jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral"), "parameter", "jetbrains.mps.baseLanguage.collections.structure.SmartClosureParameterDeclaration");
    SPropertyOperations.set(pda, "name", "a");
    SNode pdb = SLinkOperations.addNewChild(SNodeOperations.cast(sel, "jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral"), "parameter", "jetbrains.mps.baseLanguage.collections.structure.SmartClosureParameterDeclaration");
    SPropertyOperations.set(pdb, "name", "b");
  }

  public static void nodeFactory_NodeSetup_SelectOperationNew_1225118817882(final IOperationContext operationContext, final NodeSetupContext _context) {
    SNode sel = SLinkOperations.getTarget(_context.getNewNode(), "closure", true);
    if ((sel == null)) {
      sel = SLinkOperations.setNewChild(_context.getNewNode(), "closure", "jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral");
    }
    SNode pd = SLinkOperations.addNewChild(SNodeOperations.cast(sel, "jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral"), "parameter", "jetbrains.mps.baseLanguage.collections.structure.SmartClosureParameterDeclaration");
    SPropertyOperations.set(pd, "name", "it");
  }

  public static void nodeFactory_NodeSetup_WhereOperationNew_1225119083461(final IOperationContext operationContext, final NodeSetupContext _context) {
    SNode sel = SLinkOperations.getTarget(_context.getNewNode(), "closure", true);
    if ((sel == null)) {
      sel = SLinkOperations.setNewChild(_context.getNewNode(), "closure", "jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral");
    }
    SNode pd = SLinkOperations.addNewChild(SNodeOperations.cast(sel, "jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral"), "parameter", "jetbrains.mps.baseLanguage.collections.structure.SmartClosureParameterDeclaration");
    SPropertyOperations.set(pd, "name", "it");
  }

  public static void nodeFactory_NodeSetup_SortOperationNew_1225119114839(final IOperationContext operationContext, final NodeSetupContext _context) {
    SNode sel = SLinkOperations.getTarget(_context.getNewNode(), "closure", true);
    if ((sel == null)) {
      sel = SLinkOperations.setNewChild(_context.getNewNode(), "closure", "jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral");
    }
    SNode pd = SLinkOperations.addNewChild(SNodeOperations.cast(sel, "jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral"), "parameter", "jetbrains.mps.baseLanguage.collections.structure.SmartClosureParameterDeclaration");
    SPropertyOperations.set(pd, "name", "it");
  }

  public static void nodeFactory_NodeSetup_TranslateOperation_1225119174307(final IOperationContext operationContext, final NodeSetupContext _context) {
    SNode sel = SLinkOperations.getTarget(_context.getNewNode(), "closure", true);
    if ((sel == null)) {
      sel = SLinkOperations.setNewChild(_context.getNewNode(), "closure", "jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral");
    }
    SNode pd = SLinkOperations.addNewChild(SNodeOperations.cast(sel, "jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral"), "parameter", "jetbrains.mps.baseLanguage.collections.structure.SmartClosureParameterDeclaration");
    SPropertyOperations.set(pd, "name", "it");
  }

  public static void nodeFactory_NodeSetup_VisitAllOperation_1225119188771(final IOperationContext operationContext, final NodeSetupContext _context) {
    SNode sel = SLinkOperations.getTarget(_context.getNewNode(), "closure", true);
    if ((sel == null)) {
      sel = SLinkOperations.setNewChild(_context.getNewNode(), "closure", "jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral");
    }
    SNode pd = SLinkOperations.addNewChild(SNodeOperations.cast(sel, "jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral"), "parameter", "jetbrains.mps.baseLanguage.collections.structure.SmartClosureParameterDeclaration");
    SPropertyOperations.set(pd, "name", "it");
  }

  public static void nodeFactory_NodeSetup_SortOperationNew_1225119783188(final IOperationContext operationContext, final NodeSetupContext _context) {
    SNode sd = SLinkOperations.setNewChild(_context.getNewNode(), "ascending", "jetbrains.mps.baseLanguage.collections.structure.SortDirection");
    SPropertyOperations.set(sd, "value", "" + (true));
  }

  public static void nodeFactory_NodeSetup_ComparatorSortOperation_1225119833431(final IOperationContext operationContext, final NodeSetupContext _context) {
    SNode sd = SLinkOperations.setNewChild(_context.getNewNode(), "ascending", "jetbrains.mps.baseLanguage.collections.structure.SortDirection");
    SPropertyOperations.set(sd, "value", "" + (true));
  }

  public static void nodeFactory_NodeSetup_FindFirstOperation_1225728791328(final IOperationContext operationContext, final NodeSetupContext _context) {
    SNode filter = SLinkOperations.getTarget(_context.getNewNode(), "closure", true);
    if ((filter == null)) {
      filter = SLinkOperations.setNewChild(_context.getNewNode(), "closure", "jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral");
    }
    SNode pd = SLinkOperations.addNewChild(SNodeOperations.cast(filter, "jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral"), "parameter", "jetbrains.mps.baseLanguage.collections.structure.SmartClosureParameterDeclaration");
    SPropertyOperations.set(pd, "name", "it");
  }

  public static void nodeFactory_NodeSetup_FindLastOperation_1225730740848(final IOperationContext operationContext, final NodeSetupContext _context) {
    SNode filter = SLinkOperations.getTarget(_context.getNewNode(), "closure", true);
    if ((filter == null)) {
      filter = SLinkOperations.setNewChild(_context.getNewNode(), "closure", "jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral");
    }
    SNode pd = SLinkOperations.addNewChild(SNodeOperations.cast(filter, "jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral"), "parameter", "jetbrains.mps.baseLanguage.collections.structure.SmartClosureParameterDeclaration");
    SPropertyOperations.set(pd, "name", "it");
  }

  public static void nodeFactory_NodeSetup_AllOperation_1235567398002(final IOperationContext operationContext, final NodeSetupContext _context) {
    SNode filter = SLinkOperations.getTarget(_context.getNewNode(), "closure", true);
    if ((filter == null)) {
      filter = SLinkOperations.setNewChild(_context.getNewNode(), "closure", "jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral");
    }
    SNode pd = SLinkOperations.addNewChild(SNodeOperations.cast(filter, "jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral"), "parameter", "jetbrains.mps.baseLanguage.collections.structure.SmartClosureParameterDeclaration");
    SPropertyOperations.set(pd, "name", "it");
  }

  public static void nodeFactory_NodeSetup_AnyOperation_1235567424421(final IOperationContext operationContext, final NodeSetupContext _context) {
    SNode filter = SLinkOperations.getTarget(_context.getNewNode(), "closure", true);
    if ((filter == null)) {
      filter = SLinkOperations.setNewChild(_context.getNewNode(), "closure", "jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral");
    }
    SNode pd = SLinkOperations.addNewChild(SNodeOperations.cast(filter, "jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral"), "parameter", "jetbrains.mps.baseLanguage.collections.structure.SmartClosureParameterDeclaration");
    SPropertyOperations.set(pd, "name", "it");
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_Statement_1152144005896(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      Calculable calc = new Calculable() {

        public Object calculate() {
          boolean yieldAllowed = false;
          boolean stopAllowed = false;
          boolean skipAllowed = false;
          SNode parentClosure = SNodeOperations.getAncestor(_context.getParentNode(), "jetbrains.mps.baseLanguage.structure.Closure", false, false);
          if (SNodeOperations.isInstanceOf(parentClosure, "jetbrains.mps.baseLanguage.collections.structure.ValueSupplierBlock")) {
            yieldAllowed = true;
            stopAllowed = true;
          }
          if (SNodeOperations.isInstanceOf(parentClosure, "jetbrains.mps.baseLanguage.collections.structure.MapperBlock")) {
            yieldAllowed = true;
            stopAllowed = true;
            skipAllowed = true;
          }
          if (SNodeOperations.isInstanceOf(parentClosure, "jetbrains.mps.baseLanguage.collections.structure.ForEachBlock")) {
            stopAllowed = true;
            skipAllowed = true;
          }
          List<SNode> concepts = ListOperations.<SNode>createList();
          if (yieldAllowed) {
            ListSequence.fromList(concepts).addElement(SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.TraversalYieldStatement"));
          }
          if (stopAllowed) {
            ListSequence.fromList(concepts).addElement(SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.TraversalStopStatement"));
          }
          if (skipAllowed) {
            ListSequence.fromList(concepts).addElement(SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.TraversalSkipStatement"));
          }
          return concepts;
        }
      };
      Iterable queryResult = (Iterable)calc.calculate();
      if (queryResult != null) {
        for(Object item : queryResult) {
          List<INodeSubstituteAction> defaultActions = ChildSubstituteActionsHelper.createDefaultActions((SNode)item, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext);
          ListSequence.fromList(result).addSequence(ListSequence.fromList(defaultActions));
        }
      }
    }
    return result;
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_IOperation_1160663024951(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    final ApplicableTypesInfo applicableTypesInfo;
    {
      Calculable calc = new Calculable() {

        public Object calculate() {
          ApplicableTypesInfo result = new ApplicableTypesInfo();
          SNode leftExpression = null;
          if (SNodeOperations.isInstanceOf(_context.getParentNode(), "jetbrains.mps.baseLanguage.structure.DotExpression")) {
            leftExpression = SLinkOperations.getTarget(SNodeOperations.cast(_context.getParentNode(), "jetbrains.mps.baseLanguage.structure.DotExpression"), "operand", true);
          }
          if ((leftExpression != null)) {
            SNode leftType = TypeChecker.getInstance().getTypeOf(leftExpression);
            if (TypeChecker.getInstance().getRuntimeSupport().coerce_(leftType, HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.baseLanguage.collections.structure.SequenceType"), false) != null) {
              result.myApplicableToSequence = true;
            }
            if (TypeChecker.getInstance().getRuntimeSupport().coerce_(leftType, HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.baseLanguage.collections.structure.ListType"), false) != null) {
              result.myApplicableToList = true;
            }
          }
          return result;
        }
      };
      applicableTypesInfo = (ApplicableTypesInfo)calc.calculate();
    }
    return result;
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_Expression_1178286508713(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode outputConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.SortDirection");
      SNode childConcept = (SNode)_context.getChildConcept();
      if (outputConcept == null || SConceptOperations.isSuperConceptOf(childConcept, NameUtil.nodeFQName(outputConcept))) {
        ListSequence.fromList(result).addElement(new DefaultSimpleSubstituteAction(outputConcept, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {

          public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
            SNode direction = SModelOperations.createNewNode(model, "jetbrains.mps.baseLanguage.collections.structure.SortDirection", null);
            SPropertyOperations.set(direction, "value", "" + (true));
            return direction;
          }

          public String getDescriptionText(String pattern) {
            return "Sort in ascending order";
          }

          public String getMatchingText(String pattern) {
            return "asc";
          }

          public String getVisibleMatchingText(String pattern) {
            return this.getMatchingText(pattern);
          }
        });
      }
    }
    {
      SNode outputConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.SortDirection");
      SNode childConcept = (SNode)_context.getChildConcept();
      if (outputConcept == null || SConceptOperations.isSuperConceptOf(childConcept, NameUtil.nodeFQName(outputConcept))) {
        ListSequence.fromList(result).addElement(new DefaultSimpleSubstituteAction(outputConcept, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {

          public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
            SNode direction = SModelOperations.createNewNode(model, "jetbrains.mps.baseLanguage.collections.structure.SortDirection", null);
            SPropertyOperations.set(direction, "value", "" + (false));
            return direction;
          }

          public String getDescriptionText(String pattern) {
            return "Sort in descending order";
          }

          public String getMatchingText(String pattern) {
            return "desc";
          }

          public String getVisibleMatchingText(String pattern) {
            return this.getMatchingText(pattern);
          }
        });
      }
    }
    return result;
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_Statement_1224446770027(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    return result;
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_Statement_1224451907809(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    return result;
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_Expression_1237785975244(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode conceptToAdd = SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.AllConstant");
      List<INodeSubstituteAction> defaultActions = ChildSubstituteActionsHelper.createDefaultActions(conceptToAdd, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext);
      ListSequence.fromList(result).addSequence(ListSequence.fromList(defaultActions));
    }
    return result;
  }

  public static List<INodeSubstituteAction> sideTransform_ActionsFactory_Expression_1197932848431(final IOperationContext operationContext, final SideTransformActionsBuilderContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    final SNode mapType;
    {
      Calculable calculable = new Calculable() {

        public Object calculate() {
          return TypeChecker.getInstance().getRuntimeSupport().coerce_(TypeChecker.getInstance().getTypeOf(_context.getSourceNode()), HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.baseLanguage.collections.structure.MapType"), false);
        }
      };
      mapType = (SNode)calculable.calculate();
    }
    {
      SNode concept = SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.MapElement");
      ListSequence.fromList(result).addElement(new AbstractSideTransformHintSubstituteAction(concept, _context.getSourceNode()) {

        public SNode doSubstitute(String pattern) {
          SNode mapElement = SNodeOperations.replaceWithNewChild(_context.getSourceNode(), "jetbrains.mps.baseLanguage.collections.structure.MapElement");
          SLinkOperations.setTarget(mapElement, "map", _context.getSourceNode(), true);
          return mapElement;
        }

        public String getMatchingText(String pattern) {
          return "[";
        }

        public String getVisibleMatchingText(String pattern) {
          return this.getMatchingText(pattern);
        }

        public SNode getActionType(String pattern) {
          return SLinkOperations.getTarget(mapType, "valueType", true);
        }
      });
    }
    return result;
  }

  public static List<INodeSubstituteAction> sideTransform_ActionsFactory_SequenceCreatorWithSupplier_1207757118239(final IOperationContext operationContext, final SideTransformActionsBuilderContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode concept = SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.SequenceCreatorWithSupplier");
      ListSequence.fromList(result).addElement(new AbstractSideTransformHintSubstituteAction(concept, _context.getSourceNode()) {

        public SNode doSubstitute(String pattern) {
          SLinkOperations.setNewChild(_context.getSourceNode(), "elementType", "jetbrains.mps.baseLanguage.structure.Type");
          return _context.getSourceNode();
        }

        public String getMatchingText(String pattern) {
          return "<";
        }

        public String getVisibleMatchingText(String pattern) {
          return this.getMatchingText(pattern);
        }

        public String getDescriptionText(String pattern) {
          return "add type parameter";
        }
      });
    }
    return result;
  }

  public static List<INodeSubstituteAction> sideTransform_ActionsFactory_Expression_1225711439964(final IOperationContext operationContext, final SideTransformActionsBuilderContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode concept = SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.Expression");
      ListSequence.fromList(result).addElement(new AbstractSideTransformHintSubstituteAction(concept, _context.getSourceNode()) {

        public SNode doSubstitute(String pattern) {
          SNode lea = SNodeOperations.replaceWithNewChild(_context.getSourceNode(), "jetbrains.mps.baseLanguage.collections.structure.ListElementAccessExpression");
          SLinkOperations.setTarget(lea, "list", _context.getSourceNode(), true);
          return lea;
        }

        public String getMatchingText(String pattern) {
          return "[";
        }

        public String getVisibleMatchingText(String pattern) {
          return this.getMatchingText(pattern);
        }

        public String getDescriptionText(String pattern) {
          return "list element access";
        }
      });
    }
    return result;
  }

  public static List<INodeSubstituteAction> sideTransform_ActionsFactory_Expression_1228229423802(final IOperationContext operationContext, final SideTransformActionsBuilderContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode concept = SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.Expression");
      ListSequence.fromList(result).addElement(new AbstractSideTransformHintSubstituteAction(concept, _context.getSourceNode()) {

        public SNode doSubstitute(String pattern) {
          SNode de = SNodeOperations.replaceWithNewChild(_context.getSourceNode(), "jetbrains.mps.baseLanguage.collections.structure.DowncastExpression");
          SLinkOperations.setTarget(de, "expression", _context.getSourceNode(), true);
          return de;
        }

        public String getMatchingText(String pattern) {
          return "/";
        }

        public String getVisibleMatchingText(String pattern) {
          return this.getMatchingText(pattern);
        }

        public String getDescriptionText(String pattern) {
          return "downcast to lower level";
        }
      });
    }
    return result;
  }

  public static List<INodeSubstituteAction> sideTransform_ActionsFactory_AbstractContainerCreator_1237731255229(final IOperationContext operationContext, final SideTransformActionsBuilderContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode concept = SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.AbstractContainerCreator");
      ListSequence.fromList(result).addElement(new AbstractSideTransformHintSubstituteAction(concept, _context.getSourceNode()) {

        public SNode doSubstitute(String pattern) {
          SLinkOperations.addNewChild(_context.getSourceNode(), "initValue", "jetbrains.mps.baseLanguage.structure.Expression");
          return _context.getSourceNode();
        }

        public String getMatchingText(String pattern) {
          return "{";
        }

        public String getVisibleMatchingText(String pattern) {
          return this.getMatchingText(pattern);
        }

        public String getDescriptionText(String pattern) {
          return "initialize with values";
        }
      });
    }
    {
      SNode concept = SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.AbstractContainerCreator");
      ListSequence.fromList(result).addElement(new AbstractSideTransformHintSubstituteAction(concept, _context.getSourceNode()) {

        public SNode doSubstitute(String pattern) {
          SLinkOperations.setNewChild(_context.getSourceNode(), "copyFrom", "jetbrains.mps.baseLanguage.structure.Expression");
          return _context.getSourceNode();
        }

        public String getMatchingText(String pattern) {
          return "(";
        }

        public String getVisibleMatchingText(String pattern) {
          return this.getMatchingText(pattern);
        }

        public String getDescriptionText(String pattern) {
          return "copy elements from sequence";
        }
      });
    }
    return result;
  }

  public static List<INodeSubstituteAction> sideTransform_ActionsFactory_HashMapCreator_1240226447248(final IOperationContext operationContext, final SideTransformActionsBuilderContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode concept = SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.HashMapCreator");
      ListSequence.fromList(result).addElement(new AbstractSideTransformHintSubstituteAction(concept, _context.getSourceNode()) {

        public SNode doSubstitute(String pattern) {
          SLinkOperations.setNewChild(_context.getSourceNode(), "initializer", "jetbrains.mps.baseLanguage.collections.structure.MapInitializer");
          return _context.getSourceNode();
        }

        public String getMatchingText(String pattern) {
          return "{";
        }

        public String getVisibleMatchingText(String pattern) {
          return this.getMatchingText(pattern);
        }

        public String getDescriptionText(String pattern) {
          return "initialize with values";
        }
      });
    }
    return result;
  }

  public static List<INodeSubstituteAction> sideTransform_ActionsFactory_JoinOperation_1240688910490(final IOperationContext operationContext, final SideTransformActionsBuilderContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode concept = SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.JoinOperation");
      ListSequence.fromList(result).addElement(new AbstractSideTransformHintSubstituteAction(concept, _context.getSourceNode()) {

        public SNode doSubstitute(String pattern) {
          SLinkOperations.setNewChild(_context.getSourceNode(), "delimiter", "jetbrains.mps.baseLanguage.structure.Expression");
          return _context.getSourceNode();
        }

        public String getMatchingText(String pattern) {
          return "(";
        }

        public String getVisibleMatchingText(String pattern) {
          return this.getMatchingText(pattern);
        }
      });
    }
    return result;
  }

  public static void removeActionsByCondition_1177414262137(final IOperationContext operationContext, final RemoveSubstituteActionByConditionContext _context) {
    final ApplicableTypesInfo applicableTypesInfo;
    {
      Calculable calc = new Calculable() {

        public Object calculate() {
          ApplicableTypesInfo result = new ApplicableTypesInfo();
          SNode leftExpression = null;
          if (SNodeOperations.isInstanceOf(_context.getParentNode(), "jetbrains.mps.baseLanguage.structure.DotExpression")) {
            leftExpression = SLinkOperations.getTarget(SNodeOperations.cast(_context.getParentNode(), "jetbrains.mps.baseLanguage.structure.DotExpression"), "operand", true);
          }
          if ((leftExpression != null)) {
            SNode leftType = TypeChecker.getInstance().getTypeOf(leftExpression);
            if (TypeChecker.getInstance().getRuntimeSupport().coerce_(leftType, HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.baseLanguage.collections.structure.SequenceType"), false) != null) {
              result.myApplicableToSequence = true;
            }
            if (TypeChecker.getInstance().getRuntimeSupport().coerce_(leftType, HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.baseLanguage.collections.structure.ListType"), false) != null) {
              result.myApplicableToList = true;
            }
          }
          return result;
        }
      };
      applicableTypesInfo = (ApplicableTypesInfo)calc.calculate();
    }
    Iterator<INodeSubstituteAction> actions = _context.getActions();
    while (actions.hasNext()) {
      INodeSubstituteAction current = actions.next();
      final SNode concept = current.getOutputConcept();
      SNode applicableConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.IOperation");
      Condition cond = new Condition() {

        public boolean met(Object object) {
          if (!(applicableTypesInfo.myApplicableToSequence)) {
            // remove all subconcepts of SequenceOperation
            return SConceptOperations.isSubConceptOf(concept, "jetbrains.mps.baseLanguage.collections.structure.SequenceOperation");
          }
          if (!(applicableTypesInfo.myApplicableToList)) {
            // remove all subconcepts of AbstractListOperation
            return SConceptOperations.isSubConceptOf(concept, "jetbrains.mps.baseLanguage.collections.structure.AbstractListOperation");
          }
          // don't touch anything else
          return false;
        }
      };
      if (SConceptOperations.isSuperConceptOf(applicableConcept, NameUtil.nodeFQName(concept)) && cond.met(concept)) {
        actions.remove();
      }
    }
  }

}
