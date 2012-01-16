package jetbrains.mps.baseLanguage.tuples.actions;

/*Generated by MPS */

import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.action.NodeSubstitutePreconditionContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.smodel.action.SideTransformPreconditionContext;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.lang.typesystem.runtime.HUtil;
import jetbrains.mps.smodel.action.NodeSetupContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.baseLanguage.tuples.behavior.NamedTupleDeclaration_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.ITranslator2;
import jetbrains.mps.smodel.action.SNodeFactoryOperations;
import java.util.List;
import jetbrains.mps.smodel.action.INodeSubstituteAction;
import jetbrains.mps.smodel.action.NodeSubstituteActionsFactoryContext;
import java.util.ArrayList;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.util.Computable;
import jetbrains.mps.baseLanguage.search.VisibleClassifiersScope;
import jetbrains.mps.baseLanguage.search.IClassifiersSearchScope;
import jetbrains.mps.util.Condition;
import jetbrains.mps.baseLanguage.tuples.constraints.TupleIntefaceUtils;
import jetbrains.mps.smodel.action.DefaultChildNodeSubstituteAction;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.baseLanguage.search.VisibilityUtil;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import jetbrains.mps.lang.core.behavior.BaseConcept_Behavior;
import jetbrains.mps.smodel.action.SideTransformActionsBuilderContext;
import jetbrains.mps.smodel.action.AbstractSideTransformHintSubstituteAction;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class QueriesGenerated {
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
    for (SNode cd : ListSequence.fromList(NamedTupleDeclaration_Behavior.call_allExtends_3142843783245461132(SLinkOperations.getTarget(_context.getNewNode(), "tupleDeclaration", false))).reversedList().translate(new ITranslator2<SNode, SNode>() {
      public Iterable<SNode> translate(SNode ntd) {
        return SLinkOperations.getTargets(ntd, "component", true);
      }
    })) {
      SLinkOperations.setTarget(ListSequence.fromList(SLinkOperations.getTargets(_context.getNewNode(), "componentRef", true)).addElement(SNodeFactoryOperations.createNewNode("jetbrains.mps.baseLanguage.tuples.structure.NamedTupleComponentReference", null)), "componentDeclaration", cd, false);
    }
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_ClassifierType_1240500090073(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode outputConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType");
      SNode childConcept = (SNode) _context.getChildConcept();
      if (SConceptOperations.isSuperConceptOf(childConcept, NameUtil.nodeFQName(outputConcept))) {
        Computable computable = new Computable() {
          public Object compute() {
            return (List<SNode>) new VisibleClassifiersScope(_context.getParentNode(), IClassifiersSearchScope.INTERFACE, operationContext.getScope()).getNodes(new Condition<SNode>() {
              public boolean met(SNode node) {
                return TupleIntefaceUtils.isTupleInterface((SNode) node);
              }
            });
          }
        };
        Iterable<SNode> queryResult = (Iterable) computable.compute();
        if (queryResult != null) {
          for (final SNode item : queryResult) {
            ListSequence.fromList(result).addElement(new DefaultChildNodeSubstituteAction(outputConcept, item, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {
              public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
                return new QueriesGenerated.QuotationClass_x583g4_a0a0a0a0a0a0a0c0c0a0b0e().createNode((item));
              }
            });
          }
        }
      }
    }
    return result;
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_Expression_6880792723344953334(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode outputConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.tuples.structure.NamedTupleLiteral");
      SNode childConcept = (SNode) _context.getChildConcept();
      if (SConceptOperations.isSuperConceptOf(childConcept, NameUtil.nodeFQName(outputConcept))) {
        Computable computable = new Computable() {
          public Object compute() {
            return ListSequence.fromList(SModelOperations.getNodesIncludingImported(_context.getModel(), operationContext.getScope(), "jetbrains.mps.baseLanguage.tuples.structure.NamedTupleDeclaration")).where(new IWhereFilter<SNode>() {
              public boolean accept(SNode ntd) {
                return VisibilityUtil.isVisible(_context.getParentNode(), ntd);
              }
            }).toListSequence();
          }
        };
        Iterable<SNode> queryResult = (Iterable) computable.compute();
        if (queryResult != null) {
          for (final SNode item : queryResult) {
            ListSequence.fromList(result).addElement(new DefaultChildNodeSubstituteAction(outputConcept, item, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {
              public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
                _FunctionTypes._return_P1_E0<? extends SNode, ? super SNode> toRef = new _FunctionTypes._return_P1_E0<SNode, Object>() {
                  public SNode invoke(Object cmp) {
                    return new QueriesGenerated.QuotationClass_x583g4_a0a0a0a0a0a0a0a0a0c0c0a0b0f().createNode(cmp);
                  }
                };
                return new QueriesGenerated.QuotationClass_x583g4_a0b0a0a0a0a0a0c0c0a0b0f().createNode(ListSequence.fromList(SLinkOperations.getTargets((item), "component", true)).select(toRef).toListSequence(), (item));
              }

              public String getMatchingText(String pattern) {
                return BaseConcept_Behavior.call_getPresentation_1213877396640((item)) + " literal";
              }

              public String getVisibleMatchingText(String pattern) {
                return this.getMatchingText(pattern);
              }
            });
          }
        }
      }
    }
    return result;
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_Type_6880792723345030575(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode outputConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.tuples.structure.NamedTupleType");
      SNode childConcept = (SNode) _context.getChildConcept();
      if (SConceptOperations.isSuperConceptOf(childConcept, NameUtil.nodeFQName(outputConcept))) {
        Computable computable = new Computable() {
          public Object compute() {
            return ListSequence.fromList(SModelOperations.getNodesIncludingImported(_context.getModel(), operationContext.getScope(), "jetbrains.mps.baseLanguage.tuples.structure.NamedTupleDeclaration")).where(new IWhereFilter<SNode>() {
              public boolean accept(SNode ntd) {
                return VisibilityUtil.isVisible(_context.getParentNode(), ntd);
              }
            }).toListSequence();
          }
        };
        Iterable<SNode> queryResult = (Iterable) computable.compute();
        if (queryResult != null) {
          for (final SNode item : queryResult) {
            ListSequence.fromList(result).addElement(new DefaultChildNodeSubstituteAction(outputConcept, item, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {
              public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
                return new QueriesGenerated.QuotationClass_x583g4_a0a0a0a0a0a0a0c0c0a0b0g().createNode((item));
              }

              public String getMatchingText(String pattern) {
                return BaseConcept_Behavior.call_getPresentation_1213877396640((item)) + " type";
              }

              public String getVisibleMatchingText(String pattern) {
                return this.getMatchingText(pattern);
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
          SNode mae = SNodeOperations.replaceWithAnother(_context.getSourceNode(), SNodeFactoryOperations.createNewNode("jetbrains.mps.baseLanguage.tuples.structure.IndexedTupleMemberAccessExpression", null));
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

  public static class QuotationClass_x583g4_a0a0a0a0a0a0a0c0c0a0b0e {
    public QuotationClass_x583g4_a0a0a0a0a0a0a0c0c0a0b0e() {
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

  public static class QuotationClass_x583g4_a0a0a0a0a0a0a0a0a0c0c0a0b0f {
    public QuotationClass_x583g4_a0a0a0a0a0a0a0a0a0c0c0a0b0f() {
    }

    public SNode createNode(Object parameter_5) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      SNode quotedNode_2 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.tuples.structure.NamedTupleComponentReference", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_3 = quotedNode_1;
        quotedNode1_3.setReferent("componentDeclaration", (SNode) parameter_5);
        {
          quotedNode_2 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.Expression", null, GlobalScope.getInstance(), false);
          SNode quotedNode1_4 = quotedNode_2;
          quotedNode_1.addChild("value", quotedNode1_4);
        }
        result = quotedNode1_3;
      }
      return result;
    }
  }

  public static class QuotationClass_x583g4_a0b0a0a0a0a0a0c0c0a0b0f {
    public QuotationClass_x583g4_a0b0a0a0a0a0a0c0c0a0b0f() {
    }

    public SNode createNode(Object parameter_5, Object parameter_6) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      SNode quotedNode_2 = null;
      SNode quotedNode_3 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.tuples.structure.NamedTupleLiteral", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_4 = quotedNode_1;
        quotedNode1_4.setReferent("tupleDeclaration", (SNode) parameter_6);
        {
          List<SNode> nodes = (List<SNode>) parameter_5;
          for (SNode child : nodes) {
            quotedNode_1.addChild("componentRef", HUtil.copyIfNecessary(child));
          }
        }
        result = quotedNode1_4;
      }
      return result;
    }
  }

  public static class QuotationClass_x583g4_a0a0a0a0a0a0a0c0c0a0b0g {
    public QuotationClass_x583g4_a0a0a0a0a0a0a0c0c0a0b0g() {
    }

    public SNode createNode(Object parameter_3) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.tuples.structure.NamedTupleType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.setReferent("classifier", (SNode) parameter_3);
        result = quotedNode1_2;
      }
      return result;
    }
  }
}
