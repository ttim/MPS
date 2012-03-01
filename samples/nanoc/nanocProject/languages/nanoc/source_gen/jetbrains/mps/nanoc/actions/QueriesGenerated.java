package jetbrains.mps.nanoc.actions;

/*Generated by MPS */

import java.util.regex.Pattern;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.action.SideTransformPreconditionContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.action.NodeSetupContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.SNode;
import java.util.List;
import jetbrains.mps.smodel.action.INodeSubstituteAction;
import jetbrains.mps.smodel.action.NodeSubstituteActionsFactoryContext;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.smodel.action.IChildNodeSetter;
import jetbrains.mps.smodel.action.AbstractChildNodeSetter;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.action.SNodeFactoryOperations;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.smodel.action.ModelActions;
import jetbrains.mps.smodel.action.DefaultSimpleSubstituteAction;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.smodel.action.SideTransformActionsBuilderContext;
import jetbrains.mps.smodel.action.NodeSubstituteActionWrapper;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.action.AbstractSideTransformHintSubstituteAction;

public class QueriesGenerated {
  private static Pattern REGEXP_x583g4_a0a0a0a2a0a0a0a2a0a1a3 = Pattern.compile("-?\\d+", 0);
  private static Pattern REGEXP_x583g4_a0a0a0a0c0a0a0a0c0a0b0d = Pattern.compile("-?\\d*", 0);

  public static boolean sideTransformHintSubstituteActionsBuilder_Precondition_VarDecl_6585869519574765728(final IOperationContext operationContext, final SideTransformPreconditionContext _context) {
    return (SLinkOperations.getTarget(_context.getSourceNode(), "initializer", true) == null);
  }

  public static void nodeFactory_NodeSetup_CBinaryOp_6585869519574724396(final IOperationContext operationContext, final NodeSetupContext _context) {
    if (SNodeOperations.isInstanceOf(_context.getSampleNode(), "jetbrains.mps.nanoc.structure.CBinaryOp")) {
      SNode binaryOp = SNodeOperations.cast(_context.getSampleNode(), "jetbrains.mps.nanoc.structure.CBinaryOp");
      SLinkOperations.setTarget(_context.getNewNode(), "left", SLinkOperations.getTarget(binaryOp, "left", true), true);
      SLinkOperations.setTarget(_context.getNewNode(), "right", SLinkOperations.getTarget(binaryOp, "right", true), true);
    }
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_CStatement_6585869519574700079(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode outputConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.nanoc.structure.VarDeclStatement");
      SNode childConcept = (SNode) _context.getChildConcept();
      if (SConceptOperations.isSuperConceptOf(childConcept, NameUtil.nodeFQName(outputConcept))) {
        SNode wrappedConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.nanoc.structure.CType");
        IChildNodeSetter setter = new AbstractChildNodeSetter() {
          public SNode wrapNode(SNode nodeToWrap, SModel model) {
            SNode result = SNodeFactoryOperations.createNewNode("jetbrains.mps.nanoc.structure.VarDeclStatement", null);
            SLinkOperations.setTarget(result, "type", nodeToWrap, true);
            return result;
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
    }
    {
      SNode outputConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.nanoc.structure.CExpressionStatement");
      SNode childConcept = (SNode) _context.getChildConcept();
      if (SConceptOperations.isSuperConceptOf(childConcept, NameUtil.nodeFQName(outputConcept))) {
        SNode wrappedConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.nanoc.structure.CExpression");
        IChildNodeSetter setter = new AbstractChildNodeSetter() {
          public SNode wrapNode(SNode nodeToWrap, SModel model) {
            SNode expressionStatement = SNodeFactoryOperations.createNewNode("jetbrains.mps.nanoc.structure.CExpressionStatement", null);
            SLinkOperations.setTarget(expressionStatement, "expression", nodeToWrap, true);
            return expressionStatement;
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
    }
    return result;
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_CExpression_6585869519574739818(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode outputConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.nanoc.structure.CExpression");
      SNode childConcept = (SNode) _context.getChildConcept();
      if (outputConcept == null || SConceptOperations.isSuperConceptOf(childConcept, NameUtil.nodeFQName(outputConcept))) {
        ListSequence.fromList(result).addElement(new DefaultSimpleSubstituteAction(outputConcept, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {
          public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
            SNode result = SNodeFactoryOperations.createNewNode("jetbrains.mps.nanoc.structure.IntConst", null);
            SPropertyOperations.set(result, "value", pattern);
            return result;
          }

          public boolean hasSubstitute() {
            return true;
          }

          public boolean canSubstitute_internal(String pattern, boolean strictly) {
            if (strictly) {
              return REGEXP_x583g4_a0a0a0a2a0a0a0a2a0a1a3.matcher(pattern).matches();
            } else {
              return REGEXP_x583g4_a0a0a0a0c0a0a0a0c0a0b0d.matcher(pattern).matches();
            }
          }

          public String getMatchingText(String pattern) {
            return pattern;
          }

          public String getVisibleMatchingText(String pattern) {
            return this.getMatchingText(pattern);
          }
        });
      }
    }
    return result;
  }

  public static List<INodeSubstituteAction> sideTransform_ActionsFactory_CExpression_6585869519574743564(final IOperationContext operationContext, final SideTransformActionsBuilderContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      final String[] lastPattern = new String[1];
      List<INodeSubstituteAction> list = ModelActions.createChildSubstituteActions(_context.getSourceNode(), null, SConceptOperations.findConceptDeclaration("jetbrains.mps.nanoc.structure.CBinaryOp"), new AbstractChildNodeSetter() {
        public SNode doExecute(SNode parentNode, SNode oldChild, SNode newChild, IScope p3) {
          return substitute(newChild, lastPattern[0]);
        }

        private SNode substitute(SNode result, String pattern) {
          SNodeOperations.replaceWithAnother(_context.getSourceNode(), result);
          SLinkOperations.setTarget(result, "left", _context.getSourceNode(), true);
          return result;
        }
      }, operationContext);
      for (final INodeSubstituteAction action : list) {
        ListSequence.fromList(result).addElement(new NodeSubstituteActionWrapper(action) {
          @Override
          public SNode substitute(@Nullable EditorContext context, String pattern) {
            lastPattern[0] = pattern;
            return super.substitute(context, pattern);
          }
        });
      }
    }
    return result;
  }

  public static List<INodeSubstituteAction> sideTransform_ActionsFactory_CExpression_6585869519574743615(final IOperationContext operationContext, final SideTransformActionsBuilderContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      final String[] lastPattern = new String[1];
      List<INodeSubstituteAction> list = ModelActions.createChildSubstituteActions(_context.getSourceNode(), null, SConceptOperations.findConceptDeclaration("jetbrains.mps.nanoc.structure.CBinaryOp"), new AbstractChildNodeSetter() {
        public SNode doExecute(SNode parentNode, SNode oldChild, SNode newChild, IScope p3) {
          return substitute(newChild, lastPattern[0]);
        }

        private SNode substitute(SNode result, String pattern) {
          SNodeOperations.replaceWithAnother(_context.getSourceNode(), result);
          SLinkOperations.setTarget(result, "right", _context.getSourceNode(), true);
          return result;
        }
      }, operationContext);
      for (final INodeSubstituteAction action : list) {
        ListSequence.fromList(result).addElement(new NodeSubstituteActionWrapper(action) {
          @Override
          public SNode substitute(@Nullable EditorContext context, String pattern) {
            lastPattern[0] = pattern;
            return super.substitute(context, pattern);
          }
        });
      }
    }
    return result;
  }

  public static List<INodeSubstituteAction> sideTransform_ActionsFactory_VarRef_6585869519574772785(final IOperationContext operationContext, final SideTransformActionsBuilderContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode concept = SConceptOperations.findConceptDeclaration("jetbrains.mps.nanoc.structure.CAssignmentExpression");
      ListSequence.fromList(result).addElement(new AbstractSideTransformHintSubstituteAction(concept, _context.getSourceNode()) {
        public SNode doSubstitute(String pattern) {
          SNode result = SNodeOperations.replaceWithAnother(_context.getSourceNode(), SNodeFactoryOperations.createNewNode("jetbrains.mps.nanoc.structure.CAssignmentExpression", null));
          return SLinkOperations.setTarget(result, "variable", _context.getSourceNode(), true);
        }

        public String getMatchingText(String pattern) {
          return "=";
        }

        public String getVisibleMatchingText(String pattern) {
          return this.getMatchingText(pattern);
        }
      });
    }
    return result;
  }

  public static List<INodeSubstituteAction> sideTransform_ActionsFactory_VarDecl_6585869519574765725(final IOperationContext operationContext, final SideTransformActionsBuilderContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode concept = SConceptOperations.findConceptDeclaration("jetbrains.mps.nanoc.structure.CExpression");
      ListSequence.fromList(result).addElement(new AbstractSideTransformHintSubstituteAction(concept, _context.getSourceNode()) {
        public SNode doSubstitute(String pattern) {
          return SNodeFactoryOperations.setNewChild(_context.getSourceNode(), "initializer", "jetbrains.mps.nanoc.structure.CExpression");
        }

        public String getMatchingText(String pattern) {
          return "=";
        }

        public String getVisibleMatchingText(String pattern) {
          return this.getMatchingText(pattern);
        }
      });
    }
    return result;
  }
}
