package jetbrains.mps.baseLanguage.math.actions;

/*Generated by MPS */

import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.action.SideTransformPreconditionContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.smodel.action.NodeSetupContext;
import java.util.List;
import jetbrains.mps.smodel.action.INodeSubstituteAction;
import jetbrains.mps.smodel.action.NodeSubstituteActionsFactoryContext;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.smodel.action.DefaultSimpleSubstituteAction;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.action.SNodeFactoryOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.smodel.action.SideTransformActionsBuilderContext;
import jetbrains.mps.smodel.action.AbstractSideTransformHintSubstituteAction;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.util.Calculable;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptPropertyOperations;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.lang.typesystem.runtime.HUtil;

public class QueriesGenerated {
  public static boolean sideTransformHintSubstituteActionsBuilder_Precondition_LocalVariableDeclaration_5853558151363158391(final IOperationContext operationContext, final SideTransformPreconditionContext _context) {
    return SNodeOperations.isInstanceOf(SLinkOperations.getTarget(_context.getSourceNode(), "type", true), "jetbrains.mps.baseLanguage.math.structure.MatrixOrVectorType");
  }

  public static boolean sideTransformHintSubstituteActionsBuilder_Precondition_Expression_6389121991274660120(final IOperationContext operationContext, final SideTransformPreconditionContext _context) {
    return TypeChecker.getInstance().getSubtypingManager().isSubtype(TypeChecker.getInstance().getTypeOf(_context.getSourceNode()), new QueriesGenerated.QuotationClass_x583g4_a1a0a0b().createNode());
  }

  public static boolean sideTransformHintSubstituteActionsBuilder_Precondition_Expression_7388416617632092630(final IOperationContext operationContext, final SideTransformPreconditionContext _context) {
    return SNodeOperations.isInstanceOf(TypeChecker.getInstance().getTypeOf(_context.getSourceNode()), "jetbrains.mps.baseLanguage.math.structure.MatrixType") || SNodeOperations.isInstanceOf(TypeChecker.getInstance().getTypeOf(_context.getSourceNode()), "jetbrains.mps.baseLanguage.math.structure.VectorType");
  }

  public static void nodeFactory_NodeSetup_ExponentialOperation_4334427517307386393(final IOperationContext operationContext, final NodeSetupContext _context) {
    if (SNodeOperations.isInstanceOf(_context.getSampleNode(), "jetbrains.mps.baseLanguage.structure.Expression")) {
      SLinkOperations.setTarget(_context.getNewNode(), "expr", SNodeOperations.cast(_context.getSampleNode(), "jetbrains.mps.baseLanguage.structure.Expression"), true);
    }
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_Expression_3498370411873438848(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode outputConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.math.structure.MatrixConstructor");
      SNode childConcept = (SNode) _context.getChildConcept();
      if (outputConcept == null || SConceptOperations.isSuperConceptOf(childConcept, NameUtil.nodeFQName(outputConcept))) {
        ListSequence.fromList(result).addElement(new DefaultSimpleSubstituteAction(outputConcept, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {
          public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
            SNode n = SNodeFactoryOperations.createNewNode("jetbrains.mps.baseLanguage.math.structure.MatrixConstructor", null);
            SPropertyOperations.set(n, "column", "" + true);
            return n;
          }

          public String getDescriptionText(String pattern) {
            return "Matrix column constructor";
          }

          public String getMatchingText(String pattern) {
            return "<";
          }

          public String getVisibleMatchingText(String pattern) {
            return this.getMatchingText(pattern);
          }
        });
      }
    }
    return result;
  }

  public static List<INodeSubstituteAction> sideTransform_ActionsFactory_LocalVariableDeclaration_5853558151363158390(final IOperationContext operationContext, final SideTransformActionsBuilderContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode concept = SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.math.structure.LinearSolveOperation");
      ListSequence.fromList(result).addElement(new AbstractSideTransformHintSubstituteAction(concept, _context.getSourceNode()) {
        public SNode doSubstitute(String pattern) {
          SNode lso = SNodeFactoryOperations.createNewNode("jetbrains.mps.baseLanguage.math.structure.LinearSolveOperation", null);
          {
            SNode matchedNode_fo7if3_b0a0a0 = SLinkOperations.getTarget(_context.getSourceNode(), "type", true);
            {
              boolean matches_fo7if3_a1a0a0a = false;
              {
                SNode matchingNode_fo7if3_a1a0a0a = SLinkOperations.getTarget(_context.getSourceNode(), "type", true);
                if (matchingNode_fo7if3_a1a0a0a != null) {
                  matches_fo7if3_a1a0a0a = SModelUtil_new.isAssignableConcept(matchingNode_fo7if3_a1a0a0a.getConceptFqName(), "jetbrains.mps.baseLanguage.math.structure.MatrixType");
                }
              }
              if (matches_fo7if3_a1a0a0a) {
                SLinkOperations.setTarget(lso, "type", SNodeOperations.cast(SLinkOperations.getTarget(_context.getSourceNode(), "type", true), "jetbrains.mps.baseLanguage.math.structure.MatrixType"), true);
              } else {
                boolean matches_fo7if3_b1a0a0a = false;
                {
                  SNode matchingNode_fo7if3_b1a0a0a = SLinkOperations.getTarget(_context.getSourceNode(), "type", true);
                  if (matchingNode_fo7if3_b1a0a0a != null) {
                    matches_fo7if3_b1a0a0a = SModelUtil_new.isAssignableConcept(matchingNode_fo7if3_b1a0a0a.getConceptFqName(), "jetbrains.mps.baseLanguage.math.structure.VectorType");
                  }
                }
                if (matches_fo7if3_b1a0a0a) {
                  SLinkOperations.setTarget(lso, "type", SNodeOperations.cast(SLinkOperations.getTarget(_context.getSourceNode(), "type", true), "jetbrains.mps.baseLanguage.math.structure.VectorType"), true);
                }
              }
            }
          }
          SPropertyOperations.set(lso, "name", SPropertyOperations.getString(_context.getSourceNode(), "name"));
          SNodeOperations.replaceWithAnother(_context.getSourceNode(), lso);
          return SLinkOperations.getTarget(lso, "matrix", true);
        }

        public String getMatchingText(String pattern) {
          return ":";
        }

        public String getVisibleMatchingText(String pattern) {
          return this.getMatchingText(pattern);
        }

        public String getDescriptionText(String pattern) {
          return "Initialize as a vector satisfying linear equation";
        }
      });
    }
    return result;
  }

  public static List<INodeSubstituteAction> sideTransform_ActionsFactory_Expression_6389121991274660119(final IOperationContext operationContext, final SideTransformActionsBuilderContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode concept = SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.Expression");
      ListSequence.fromList(result).addElement(new AbstractSideTransformHintSubstituteAction(concept, _context.getSourceNode()) {
        public SNode doSubstitute(String pattern) {
          SNode result = SNodeFactoryOperations.createNewNode("jetbrains.mps.baseLanguage.math.structure.MatrixElementAccessExpression", null);
          SNodeOperations.replaceWithAnother(_context.getSourceNode(), result);
          SLinkOperations.setTarget(result, "expression", _context.getSourceNode(), true);
          return SLinkOperations.getTarget(result, "rowIndex", true);
        }

        public String getMatchingText(String pattern) {
          return "[";
        }

        public String getVisibleMatchingText(String pattern) {
          return this.getMatchingText(pattern);
        }

        public String getDescriptionText(String pattern) {
          return "Matrix element access";
        }
      });
    }
    return result;
  }

  public static List<INodeSubstituteAction> sideTransform_ActionsFactory_Expression_963844843316088781(final IOperationContext operationContext, final SideTransformActionsBuilderContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode concept = SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.Expression");
      ListSequence.fromList(result).addElement(new AbstractSideTransformHintSubstituteAction(concept, _context.getSourceNode()) {
        public SNode doSubstitute(String pattern) {
          SNode result = SNodeOperations.replaceWithAnother(_context.getSourceNode(), new QueriesGenerated.QuotationClass_x583g4_a1a0a0a0a0a0b0a0b0h().createNode(_context.getSourceNode()));
          return SLinkOperations.getTarget(result, "exponent", true);
        }

        public String getMatchingText(String pattern) {
          return "^";
        }

        public String getVisibleMatchingText(String pattern) {
          return this.getMatchingText(pattern);
        }

        public String getDescriptionText(String pattern) {
          return "Raise to power";
        }
      });
    }
    return result;
  }

  public static List<INodeSubstituteAction> sideTransform_ActionsFactory_Expression_7255837154369265165(final IOperationContext operationContext, final SideTransformActionsBuilderContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      final SNode concept = SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.Expression");
      Calculable calculable = new Calculable() {
        public Object calculate() {
          List<SNode> result = ListSequence.fromList(new ArrayList<SNode>());
          for (SNode a : ListSequence.fromList(SConceptOperations.getAllSubConcepts(SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.math.structure.MatrixExponentialOperation"), _context.getModel(), operationContext.getScope()))) {
            if (!(SConceptPropertyOperations.getBoolean(a, "abstract"))) {
              ListSequence.fromList(result).addElement(a);
            }
          }
          return result;
        }
      };
      Iterable<SNode> parameterObjects = (Iterable<SNode>) calculable.calculate();
      assert parameterObjects != null;
      for (final SNode item : parameterObjects) {
        ListSequence.fromList(result).addElement(new AbstractSideTransformHintSubstituteAction(concept, item, _context.getSourceNode()) {
          public SNode doSubstitute(String pattern) {
            return SNodeOperations.replaceWithAnother(_context.getSourceNode(), SNodeFactoryOperations.createNewNode(NameUtil.nodeFQName((item)), new QueriesGenerated.QuotationClass_x583g4_a1b0a0a0a0a0a0e0a0b0i().createNode(_context.getSourceNode())));
          }

          public String getMatchingText(String pattern) {
            return "^" + SConceptPropertyOperations.getString((item), "operationSymbol");
          }

          public String getVisibleMatchingText(String pattern) {
            return this.getMatchingText(pattern);
          }

          public String getDescriptionText(String pattern) {
            return SPropertyOperations.getString((item), "shortDescription");
          }
        });
      }
    }
    return result;
  }

  public static class QuotationClass_x583g4_a1a0a0b {
    public QuotationClass_x583g4_a1a0a0b() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      SNode quotedNode_2 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.math.structure.MatrixType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_3 = quotedNode_1;
        {
          quotedNode_2 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.math.structure.BigComplexType", null, GlobalScope.getInstance(), false);
          SNode quotedNode1_4 = quotedNode_2;
          quotedNode_1.addChild("elementType", quotedNode1_4);
        }
        result = quotedNode1_3;
      }
      return result;
    }
  }

  public static class QuotationClass_x583g4_a1a0a0a0a0a0b0a0b0h {
    public QuotationClass_x583g4_a1a0a0a0a0a0b0a0b0h() {
    }

    public SNode createNode(Object parameter_7) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      SNode quotedNode_2 = null;
      SNode quotedNode_3 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.math.structure.PowExpression", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_4 = quotedNode_1;
        {
          quotedNode_2 = (SNode) parameter_7;
          SNode quotedNode1_5;
          if (_parameterValues_129834374.contains(quotedNode_2)) {
            quotedNode1_5 = HUtil.copyIfNecessary(quotedNode_2);
          } else {
            _parameterValues_129834374.add(quotedNode_2);
            quotedNode1_5 = quotedNode_2;
          }
          if (quotedNode1_5 != null) {
            quotedNode_1.addChild("base", HUtil.copyIfNecessary(quotedNode1_5));
          }
        }
        {
          quotedNode_3 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.Expression", null, GlobalScope.getInstance(), false);
          SNode quotedNode1_6 = quotedNode_3;
          quotedNode_1.addChild("exponent", quotedNode1_6);
        }
        result = quotedNode1_4;
      }
      return result;
    }
  }

  public static class QuotationClass_x583g4_a1b0a0a0a0a0a0e0a0b0i {
    public QuotationClass_x583g4_a1b0a0a0a0a0a0e0a0b0i() {
    }

    public SNode createNode(Object parameter_3) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = (SNode) parameter_3;
        SNode quotedNode1_2;
        if (_parameterValues_129834374.contains(quotedNode_1)) {
          quotedNode1_2 = HUtil.copyIfNecessary(quotedNode_1);
        } else {
          _parameterValues_129834374.add(quotedNode_1);
          quotedNode1_2 = quotedNode_1;
        }
        if (quotedNode1_2 != null) {
          result = quotedNode1_2;
        }
      }
      return result;
    }
  }
}
