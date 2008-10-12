package jetbrains.mps.baseLanguage.dates.actions;

/*Generated by MPS */

import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.action.SideTransformPreconditionContext;
import java.util.List;
import jetbrains.mps.smodel.action.INodeSubstituteAction;
import jetbrains.mps.smodel.action.SideTransformActionsBuilderContext;
import java.util.ArrayList;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.util.Calculable;
import jetbrains.mps.baseLanguage.dates.structure.CompareType;
import jetbrains.mps.smodel.action.AbstractSideTransformHintSubstituteAction;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.baseLanguage.collections.internal.query.ListOperations;
import jetbrains.mps.baseLanguage.collections.internal.query.SequenceOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptPropertyOperations;
import jetbrains.mps.util.NameUtil;

public class QueriesGenerated {

  public static boolean sideTransformHintSubstituteActionsBuilder_Precondition_Expression_1169657599823(final IOperationContext operationContext, final SideTransformPreconditionContext _context) {
    return DateTypeUtil.isInstanceOfDatetime(_context.getSourceNode());
  }

  public static boolean sideTransformHintSubstituteActionsBuilder_Precondition_Expression_1172507582020(final IOperationContext operationContext, final SideTransformPreconditionContext _context) {
    return DateTypeUtil.isInstanceOfInt(_context.getSourceNode());
  }

  public static List<INodeSubstituteAction> sideTransform_ActionsFactory_Expression_1169657550853(final IOperationContext operationContext, final SideTransformActionsBuilderContext _context) {
    List<INodeSubstituteAction> result = new ArrayList<INodeSubstituteAction>();
    {
      final SNode concept = SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.dates.structure.DateTimeCompareOperation");
      Calculable calculable = new Calculable() {

        public Object calculate() {
          return CompareType.getConstants();
        }

      };
      Iterable<CompareType> parameterObjects = (Iterable<CompareType>)calculable.calculate();
      assert parameterObjects != null;
      for(final CompareType item : parameterObjects) {
        result.add(new AbstractSideTransformHintSubstituteAction(item, _context.getSourceNode()) {

          public SNode doSubstitute(String pattern) {
            SNode result = SModelOperations.createNewNode(_context.getModel(), "jetbrains.mps.baseLanguage.dates.structure.DateTimeCompareOperation", null);
            SNodeOperations.replaceWithAnother(_context.getSourceNode(), result);
            SLinkOperations.setTarget(result, "op1", _context.getSourceNode(), true);
            SPropertyOperations.set(result, "compareType", (item).getValueAsString());
            return result;
          }

          public SNode getOutputConcept() {
            return concept;
          }

          public String getMatchingText(String text) {
            return (item).getName();
          }

          public String getVisibleMatchingText(String text) {
            return this.getMatchingText(text);
          }

          public String getDescriptionText(String text) {
            return (item).getValue();
          }

        });
      }
    }
    {
      SNode concept = SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.dates.structure.InlineFormatExpression");
      Iterable<SNode> concepts = ListOperations.<SNode>createList(concept);
      concepts = SequenceOperations.concat(concepts, SConceptOperations.getAllSubConcepts(concept, _context.getModel(), operationContext.getScope()));
      for(final SNode subconcept : concepts) {
        if (!(SNodeOperations.isInstanceOf(subconcept, "jetbrains.mps.bootstrap.structureLanguage.structure.ConceptDeclaration"))) {
          continue;
        }
        if (SConceptPropertyOperations.getBoolean(subconcept, "abstract")) {
          continue;
        }
        result.add(new AbstractSideTransformHintSubstituteAction(subconcept, _context.getSourceNode()) {

          public SNode doSubstitute(String pattern) {
            SNode result = SConceptOperations.createNewNode(NameUtil.nodeFQName(subconcept), null);
            SNodeOperations.replaceWithAnother(_context.getSourceNode(), result);
            SLinkOperations.setTarget(result, "datetime", _context.getSourceNode(), true);
            return result;
          }

        });
      }
    }
    {
      SNode concept = SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.dates.structure.FormatExpression");
      Iterable<SNode> concepts = ListOperations.<SNode>createList(concept);
      concepts = SequenceOperations.concat(concepts, SConceptOperations.getAllSubConcepts(concept, _context.getModel(), operationContext.getScope()));
      for(final SNode subconcept : concepts) {
        if (!(SNodeOperations.isInstanceOf(subconcept, "jetbrains.mps.bootstrap.structureLanguage.structure.ConceptDeclaration"))) {
          continue;
        }
        if (SConceptPropertyOperations.getBoolean(subconcept, "abstract")) {
          continue;
        }
        result.add(new AbstractSideTransformHintSubstituteAction(subconcept, _context.getSourceNode()) {

          public SNode doSubstitute(String pattern) {
            SNode result = SConceptOperations.createNewNode(NameUtil.nodeFQName(subconcept), null);
            SNodeOperations.replaceWithAnother(_context.getSourceNode(), result);
            SLinkOperations.setTarget(result, "dateExpression", _context.getSourceNode(), true);
            return result;
          }

        });
      }
    }
    {
      SNode concept = SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.dates.structure.DateTimeWithPropertyOperation");
      Iterable<SNode> concepts = ListOperations.<SNode>createList(concept);
      concepts = SequenceOperations.concat(concepts, SConceptOperations.getAllSubConcepts(concept, _context.getModel(), operationContext.getScope()));
      for(final SNode subconcept : concepts) {
        if (!(SNodeOperations.isInstanceOf(subconcept, "jetbrains.mps.bootstrap.structureLanguage.structure.ConceptDeclaration"))) {
          continue;
        }
        if (SConceptPropertyOperations.getBoolean(subconcept, "abstract")) {
          continue;
        }
        result.add(new AbstractSideTransformHintSubstituteAction(subconcept, _context.getSourceNode()) {

          public SNode doSubstitute(String pattern) {
            SNode result = SConceptOperations.createNewNode(NameUtil.nodeFQName(subconcept), null);
            SNodeOperations.replaceWithAnother(_context.getSourceNode(), result);
            SLinkOperations.setTarget(result, "datetime", _context.getSourceNode(), true);
            return result;
          }

        });
      }
    }
    {
      SNode concept = SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.dates.structure.DateTimeMinusOperation");
      Iterable<SNode> concepts = ListOperations.<SNode>createList(concept);
      concepts = SequenceOperations.concat(concepts, SConceptOperations.getAllSubConcepts(concept, _context.getModel(), operationContext.getScope()));
      for(final SNode subconcept : concepts) {
        if (!(SNodeOperations.isInstanceOf(subconcept, "jetbrains.mps.bootstrap.structureLanguage.structure.ConceptDeclaration"))) {
          continue;
        }
        if (SConceptPropertyOperations.getBoolean(subconcept, "abstract")) {
          continue;
        }
        result.add(new AbstractSideTransformHintSubstituteAction(subconcept, _context.getSourceNode()) {

          public SNode doSubstitute(String pattern) {
            SNode result = SConceptOperations.createNewNode(NameUtil.nodeFQName(subconcept), null);
            SNodeOperations.replaceWithAnother(_context.getSourceNode(), result);
            SLinkOperations.setTarget(result, "leftValue", _context.getSourceNode(), true);
            return result;
          }

        });
      }
    }
    {
      SNode concept = SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.dates.structure.DateTimePlusPeriodOperation");
      Iterable<SNode> concepts = ListOperations.<SNode>createList(concept);
      concepts = SequenceOperations.concat(concepts, SConceptOperations.getAllSubConcepts(concept, _context.getModel(), operationContext.getScope()));
      for(final SNode subconcept : concepts) {
        if (!(SNodeOperations.isInstanceOf(subconcept, "jetbrains.mps.bootstrap.structureLanguage.structure.ConceptDeclaration"))) {
          continue;
        }
        if (SConceptPropertyOperations.getBoolean(subconcept, "abstract")) {
          continue;
        }
        result.add(new AbstractSideTransformHintSubstituteAction(subconcept, _context.getSourceNode()) {

          public SNode doSubstitute(String pattern) {
            SNode result = SConceptOperations.createNewNode(NameUtil.nodeFQName(subconcept), null);
            SNodeOperations.replaceWithAnother(_context.getSourceNode(), result);
            SLinkOperations.setTarget(result, "leftValue", _context.getSourceNode(), true);
            return result;
          }

        });
      }
    }
    {
      SNode concept = SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.dates.structure.DateTimeMinusPeriodOperation");
      Iterable<SNode> concepts = ListOperations.<SNode>createList(concept);
      concepts = SequenceOperations.concat(concepts, SConceptOperations.getAllSubConcepts(concept, _context.getModel(), operationContext.getScope()));
      for(final SNode subconcept : concepts) {
        if (!(SNodeOperations.isInstanceOf(subconcept, "jetbrains.mps.bootstrap.structureLanguage.structure.ConceptDeclaration"))) {
          continue;
        }
        if (SConceptPropertyOperations.getBoolean(subconcept, "abstract")) {
          continue;
        }
        result.add(new AbstractSideTransformHintSubstituteAction(subconcept, _context.getSourceNode()) {

          public SNode doSubstitute(String pattern) {
            SNode result = SConceptOperations.createNewNode(NameUtil.nodeFQName(subconcept), null);
            SNodeOperations.replaceWithAnother(_context.getSourceNode(), result);
            SLinkOperations.setTarget(result, "leftValue", _context.getSourceNode(), true);
            return result;
          }

        });
      }
    }
    {
      SNode concept = SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.dates.structure.RoundDateTimeOperation");
      Iterable<SNode> concepts = ListOperations.<SNode>createList(concept);
      concepts = SequenceOperations.concat(concepts, SConceptOperations.getAllSubConcepts(concept, _context.getModel(), operationContext.getScope()));
      for(final SNode subconcept : concepts) {
        if (!(SNodeOperations.isInstanceOf(subconcept, "jetbrains.mps.bootstrap.structureLanguage.structure.ConceptDeclaration"))) {
          continue;
        }
        if (SConceptPropertyOperations.getBoolean(subconcept, "abstract")) {
          continue;
        }
        result.add(new AbstractSideTransformHintSubstituteAction(subconcept, _context.getSourceNode()) {

          public SNode doSubstitute(String pattern) {
            SNode result = SConceptOperations.createNewNode(NameUtil.nodeFQName(subconcept), null);
            SNodeOperations.replaceWithAnother(_context.getSourceNode(), result);
            SLinkOperations.setTarget(result, "datetime", _context.getSourceNode(), true);
            return result;
          }

        });
      }
    }
    return result;
  }

  public static List<INodeSubstituteAction> sideTransform_ActionsFactory_Expression_1172507550761(final IOperationContext operationContext, final SideTransformActionsBuilderContext _context) {
    List<INodeSubstituteAction> result = new ArrayList<INodeSubstituteAction>();
    {
      final SNode concept = SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.dates.structure.PeriodConstant");
      Calculable calculable = new Calculable() {

        public Object calculate() {
          return DateTypeUtil.findDateTimeProperties(operationContext.getScope(), _context.getModel());
        }

      };
      Iterable<SNode> parameterObjects = (Iterable<SNode>)calculable.calculate();
      assert parameterObjects != null;
      for(final SNode item : parameterObjects) {
        result.add(new AbstractSideTransformHintSubstituteAction(item, _context.getSourceNode()) {

          public SNode doSubstitute(String pattern) {
            SNode result = SNodeOperations.replaceWithNewChild(_context.getSourceNode(), "jetbrains.mps.baseLanguage.dates.structure.PeriodConstant");
            SLinkOperations.setTarget(result, "count", _context.getSourceNode(), true);
            SLinkOperations.setTarget(result, "dateTimeProperty", (item), false);
            return result;
          }

          public SNode getOutputConcept() {
            return concept;
          }

          public String getMatchingText(String text) {
            return SPropertyOperations.getString((item), "pluralForm");
          }

          public String getVisibleMatchingText(String text) {
            return this.getMatchingText(text);
          }

          public String getDescriptionText(String text) {
            return "Period constant";
          }

        });
      }
    }
    return result;
  }

}
