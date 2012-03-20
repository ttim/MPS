package jetbrains.mps.build.workflow.actions;

/*Generated by MPS */

import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.action.NodeSubstitutePreconditionContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.action.SideTransformPreconditionContext;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import java.util.List;
import jetbrains.mps.smodel.action.INodeSubstituteAction;
import jetbrains.mps.smodel.action.NodeSubstituteActionsFactoryContext;
import java.util.ArrayList;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.util.Computable;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.smodel.action.DefaultChildNodeSubstituteAction;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.smodel.action.IChildNodeSetter;
import jetbrains.mps.smodel.action.AbstractChildNodeSetter;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.smodel.action.ModelActions;
import jetbrains.mps.smodel.action.SideTransformActionsBuilderContext;
import jetbrains.mps.smodel.action.AbstractSideTransformHintSubstituteAction;

public class QueriesGenerated {
  public static boolean nodeSubstituteActionsBuilder_Precondition_XmlBaseElement_7926701909975919246(final IOperationContext operationContext, final NodeSubstitutePreconditionContext _context) {
    return SNodeOperations.isInstanceOf(_context.getParentNode(), "jetbrains.mps.build.workflow.structure.BwfJavaModule") || SNodeOperations.isInstanceOf(_context.getParentNode(), "jetbrains.mps.build.workflow.structure.BwfFileSet") || SNodeOperations.isInstanceOf(_context.getParentNode(), "jetbrains.mps.build.workflow.structure.BwfJavaClassPath");
  }

  public static boolean sideTransformHintSubstituteActionsBuilder_Precondition_BwfSubTask_3961775458390293278(final IOperationContext operationContext, final SideTransformPreconditionContext _context) {
    return ListSequence.fromList(SLinkOperations.getTargets(_context.getSourceNode(), "before", true)).isEmpty();
  }

  public static boolean sideTransformHintSubstituteActionsBuilder_Precondition_BwfSubTask_2769948622284767743(final IOperationContext operationContext, final SideTransformPreconditionContext _context) {
    return ListSequence.fromList(SLinkOperations.getTargets(_context.getSourceNode(), "after", true)).isEmpty();
  }

  public static boolean sideTransformHintSubstituteActionsBuilder_Precondition_BwfTask_2769948622284761933(final IOperationContext operationContext, final SideTransformPreconditionContext _context) {
    return ListSequence.fromList(SLinkOperations.getTargets(_context.getSourceNode(), "dependencies", true)).isEmpty();
  }

  public static boolean sideTransformHintSubstituteActionsBuilder_Precondition_BwfTaskPart_7306485738221408337(final IOperationContext operationContext, final SideTransformPreconditionContext _context) {
    return ListSequence.fromList(SLinkOperations.getTargets(_context.getSourceNode(), "additionalDependencies", true)).isEmpty();
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_XmlBaseElement_7926701909975919245(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode outputConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.core.xml.structure.XmlElement");
      SNode childConcept = (SNode) _context.getChildConcept();
      if (SConceptOperations.isSuperConceptOf(childConcept, NameUtil.nodeFQName(outputConcept))) {
        Computable computable = new Computable() {
          public Object compute() {
            return Sequence.fromIterable(Sequence.fromArray(new String[]{"fileset", "pathelement", "dirset"})).toListSequence();
          }
        };
        Iterable<String> queryResult = (Iterable) computable.compute();
        if (queryResult != null) {
          for (final String item : queryResult) {
            ListSequence.fromList(result).addElement(new DefaultChildNodeSubstituteAction(outputConcept, item, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {
              public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
                SNode res = SModelOperations.createNewNode(model, "jetbrains.mps.core.xml.structure.XmlElement", null);
                SPropertyOperations.set(res, "tagName", (item));
                SPropertyOperations.set(res, "shortEmptyNotation", "" + true);
                return res;
              }

              public String getMatchingText(String pattern) {
                return "<" + (item) + "/>";
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

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_BwfFileSet_7926701909975921570(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode outputConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.build.workflow.structure.BwfFileSet");
      SNode childConcept = (SNode) _context.getChildConcept();
      if (SConceptOperations.isSuperConceptOf(childConcept, NameUtil.nodeFQName(outputConcept))) {
        SNode wrappedConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.core.xml.structure.XmlBaseElement");
        IChildNodeSetter setter = new AbstractChildNodeSetter() {
          public SNode wrapNode(SNode nodeToWrap, SModel model) {
            SNode cp = SModelOperations.createNewNode(model, "jetbrains.mps.build.workflow.structure.BwfFileSet", null);
            ListSequence.fromList(SLinkOperations.getTargets(cp, "elements", true)).addElement(nodeToWrap);
            return cp;
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

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_BwfJavaDependency_7926701909975917808(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode outputConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.build.workflow.structure.BwfJavaClassPath");
      SNode childConcept = (SNode) _context.getChildConcept();
      if (SConceptOperations.isSuperConceptOf(childConcept, NameUtil.nodeFQName(outputConcept))) {
        SNode wrappedConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.core.xml.structure.XmlBaseElement");
        IChildNodeSetter setter = new AbstractChildNodeSetter() {
          public SNode wrapNode(SNode nodeToWrap, SModel model) {
            SNode cp = SModelOperations.createNewNode(model, "jetbrains.mps.build.workflow.structure.BwfJavaClassPath", null);
            SLinkOperations.setTarget(cp, "classpath", nodeToWrap, true);
            return cp;
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

  public static List<INodeSubstituteAction> sideTransform_ActionsFactory_BwfSubTask_3961775458390293277(final IOperationContext operationContext, final SideTransformActionsBuilderContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode concept = SConceptOperations.findConceptDeclaration("jetbrains.mps.build.workflow.structure.BwfSubTask");
      ListSequence.fromList(result).addElement(new AbstractSideTransformHintSubstituteAction(concept, _context.getSourceNode()) {
        public SNode doSubstitute(String pattern) {
          ListSequence.fromList(SLinkOperations.getTargets(_context.getSourceNode(), "before", true)).addElement(SModelOperations.createNewNode(_context.getModel(), "jetbrains.mps.build.workflow.structure.BwfSubTaskDependency", null));
          return _context.getSourceNode();
        }

        public String getMatchingText(String pattern) {
          return "before";
        }

        public String getVisibleMatchingText(String pattern) {
          return this.getMatchingText(pattern);
        }
      });
    }
    return result;
  }

  public static List<INodeSubstituteAction> sideTransform_ActionsFactory_BwfSubTask_2769948622284767742(final IOperationContext operationContext, final SideTransformActionsBuilderContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode concept = SConceptOperations.findConceptDeclaration("jetbrains.mps.build.workflow.structure.BwfSubTask");
      ListSequence.fromList(result).addElement(new AbstractSideTransformHintSubstituteAction(concept, _context.getSourceNode()) {
        public SNode doSubstitute(String pattern) {
          ListSequence.fromList(SLinkOperations.getTargets(_context.getSourceNode(), "after", true)).addElement(SModelOperations.createNewNode(_context.getModel(), "jetbrains.mps.build.workflow.structure.BwfSubTaskDependency", null));
          return _context.getSourceNode();
        }

        public String getMatchingText(String pattern) {
          return "after";
        }

        public String getVisibleMatchingText(String pattern) {
          return this.getMatchingText(pattern);
        }
      });
    }
    return result;
  }

  public static List<INodeSubstituteAction> sideTransform_ActionsFactory_BwfTask_2769948622284761907(final IOperationContext operationContext, final SideTransformActionsBuilderContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode concept = SConceptOperations.findConceptDeclaration("jetbrains.mps.build.workflow.structure.BwfTask");
      ListSequence.fromList(result).addElement(new AbstractSideTransformHintSubstituteAction(concept, _context.getSourceNode()) {
        public SNode doSubstitute(String pattern) {
          ListSequence.fromList(SLinkOperations.getTargets(_context.getSourceNode(), "dependencies", true)).addElement(SModelOperations.createNewNode(_context.getModel(), "jetbrains.mps.build.workflow.structure.BwfTaskDependency", null));
          return _context.getSourceNode();
        }

        public String getMatchingText(String pattern) {
          return "depends";
        }

        public String getVisibleMatchingText(String pattern) {
          return this.getMatchingText(pattern);
        }
      });
    }
    return result;
  }

  public static List<INodeSubstituteAction> sideTransform_ActionsFactory_BwfTaskPart_7306485738221408320(final IOperationContext operationContext, final SideTransformActionsBuilderContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode concept = SConceptOperations.findConceptDeclaration("jetbrains.mps.build.workflow.structure.BwfTaskPart");
      ListSequence.fromList(result).addElement(new AbstractSideTransformHintSubstituteAction(concept, _context.getSourceNode()) {
        public SNode doSubstitute(String pattern) {
          ListSequence.fromList(SLinkOperations.getTargets(_context.getSourceNode(), "additionalDependencies", true)).addElement(SModelOperations.createNewNode(_context.getModel(), "jetbrains.mps.build.workflow.structure.BwfTaskDependency", null));
          return _context.getSourceNode();
        }

        public String getMatchingText(String pattern) {
          return "depends";
        }

        public String getVisibleMatchingText(String pattern) {
          return this.getMatchingText(pattern);
        }
      });
    }
    return result;
  }
}
