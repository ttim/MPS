package jetbrains.mps.baseLanguage.tuples.actions;

/*Generated by MPS */

import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.action.NodeSubstitutePreconditionContext;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.typesystem.runtime.HUtil;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.smodel.action.SideTransformPreconditionContext;
import jetbrains.mps.smodel.action.NodeSetupContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import java.util.List;
import jetbrains.mps.smodel.action.INodeSubstituteAction;
import jetbrains.mps.smodel.action.NodeSubstituteActionsFactoryContext;
import java.util.ArrayList;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.util.Calculable;
import jetbrains.mps.baseLanguage.search.VisibleClassifiersScope;
import jetbrains.mps.baseLanguage.search.IClassifiersSearchScope;
import jetbrains.mps.util.Condition;
import jetbrains.mps.baseLanguage.tuples.constraints.TupleIntefaceUtils;
import jetbrains.mps.smodel.action.DefaultChildNodeSubstituteAction;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.action.SideTransformActionsBuilderContext;
import jetbrains.mps.smodel.action.AbstractSideTransformHintSubstituteAction;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class QueriesGenerated {
  public static boolean nodeSubstituteActionsBuilder_Precondition_IOperation_1239580454767(final IOperationContext operationContext, final NodeSubstitutePreconditionContext _context) {
    return (TypeChecker.getInstance().getRuntimeSupport().coerce_(TypeChecker.getInstance().getTypeOf(SLinkOperations.getTarget(SNodeOperations.as(_context.getParentNode(), "jetbrains.mps.baseLanguage.structure.DotExpression"), "operand", true)), HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.baseLanguage.tuples.structure.NamedTupleType"), false) != null);
  }

  public static boolean nodeSubstituteActionsBuilder_Precondition_ClassifierType_1240500098737(final IOperationContext operationContext, final NodeSubstitutePreconditionContext _context) {
    return SNodeOperations.isInstanceOf(_context.getParentNode(), "jetbrains.mps.baseLanguage.tuples.structure.NamedTupleDeclaration") && "extends".equals(SPropertyOperations.getString(_context.getLink(), "role"));
  }

  public static boolean sideTransformHintSubstituteActionsBuilder_Precondition_Expression_1238884718191(final IOperationContext operationContext, final SideTransformPreconditionContext _context) {
    return (TypeChecker.getInstance().getRuntimeSupport().coerce_(TypeChecker.getInstance().getTypeOf(_context.getSourceNode()), HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.baseLanguage.tuples.structure.IndexedTupleType"), false) != null);
  }

  public static boolean sideTransformHintSubstituteActionsBuilder_Precondition_Type_1240401116348(final IOperationContext operationContext, final SideTransformPreconditionContext _context) {
    return !(SPropertyOperations.getBoolean(SNodeOperations.as(SNodeOperations.getParent(_context.getSourceNode()), "jetbrains.mps.baseLanguage.tuples.structure.NamedTupleComponentDeclaration"), "final"));
  }

  public static void nodeFactory_NodeSetup_NamedTupleLiteral_1239567483801(final IOperationContext operationContext, final NodeSetupContext _context) {
    for (SNode cd : SLinkOperations.getTargets(SLinkOperations.getTarget(_context.getNewNode(), "tupleDeclaration", false), "component", true)) {
      SLinkOperations.setTarget(ListSequence.fromList(SLinkOperations.getTargets(_context.getNewNode(), "componentRef", true)).addElement(SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.tuples.structure.NamedTupleComponentReference", null)), "componentDeclaration", cd, false);
    }
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_IOperation_1239580440685(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    return result;
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_ClassifierType_1240500090073(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode outputConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType");
      SNode childConcept = (SNode) _context.getChildConcept();
      if (SConceptOperations.isSuperConceptOf(childConcept, NameUtil.nodeFQName(outputConcept))) {
        Calculable calc = new Calculable() {
          public Object calculate() {
            return (List<SNode>) new VisibleClassifiersScope(_context.getParentNode(), IClassifiersSearchScope.INTERFACE, operationContext.getScope()).getNodes(new Condition<SNode>() {
              public boolean met(SNode node) {
                return TupleIntefaceUtils.isTupleInterface((SNode) node);
              }
            });
          }
        };
        Iterable<SNode> queryResult = (Iterable) calc.calculate();
        if (queryResult != null) {
          for (final SNode item : queryResult) {
            ListSequence.fromList(result).addElement(new DefaultChildNodeSubstituteAction(outputConcept, item, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {
              public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
                return new QueriesGenerated.QuotationClass_x583g4_a0a0a0a0a0a0a0c0c0a0b0g().createNode((item));
              }
            });
          }
        }
      }
    }
    return result;
  }

  public static List<INodeSubstituteAction> sideTransform_ActionsFactory_Expression_1238884711273(final IOperationContext operationContext, final SideTransformActionsBuilderContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode concept = SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.tuples.structure.IndexedTupleMemberAccessExpression");
      ListSequence.fromList(result).addElement(new AbstractSideTransformHintSubstituteAction(concept, _context.getSourceNode()) {
        public SNode doSubstitute(String pattern) {
          SNode mae = SNodeOperations.replaceWithAnother(_context.getSourceNode(), SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.tuples.structure.IndexedTupleMemberAccessExpression", null));
          SLinkOperations.setTarget(mae, "tuple", _context.getSourceNode(), true);
          return mae;
        }

        public String getMatchingText(String pattern) {
          return "[";
        }

        public String getVisibleMatchingText(String pattern) {
          return this.getMatchingText(pattern);
        }

        public String getDescriptionText(String pattern) {
          return "access tuple member by index";
        }
      });
    }
    return result;
  }

  public static List<INodeSubstituteAction> sideTransform_ActionsFactory_Type_1240401099703(final IOperationContext operationContext, final SideTransformActionsBuilderContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode concept = SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.tuples.structure.NamedTupleComponentDeclaration");
      ListSequence.fromList(result).addElement(new AbstractSideTransformHintSubstituteAction(concept, _context.getSourceNode()) {
        public SNode doSubstitute(String pattern) {
          SPropertyOperations.set(SNodeOperations.as(SNodeOperations.getParent(_context.getSourceNode()), "jetbrains.mps.baseLanguage.tuples.structure.NamedTupleComponentDeclaration"), "final", "" + true);
          return _context.getSourceNode();
        }

        public String getMatchingText(String pattern) {
          return "final";
        }

        public String getVisibleMatchingText(String pattern) {
          return this.getMatchingText(pattern);
        }
      });
    }
    return result;
  }

  public static class QuotationClass_x583g4_a0a0a0a0a0a0a0c0c0a0b0g {
    public QuotationClass_x583g4_a0a0a0a0a0a0a0c0c0a0b0g() {
    }

    public SNode createNode(Object parameter_3) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.setReferent("classifier", (SNode) parameter_3);
        result = quotedNode1_2;
      }
      return result;
    }
  }
}
