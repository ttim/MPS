package jetbrains.mps.baseLanguage.constructors.actions;

/*Generated by MPS */

import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.action.NodeSubstitutePreconditionContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import java.util.List;
import jetbrains.mps.smodel.action.INodeSubstituteAction;
import jetbrains.mps.smodel.action.NodeSubstituteActionsFactoryContext;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.util.Computable;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.smodel.action.DefaultChildNodeSubstituteAction;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.action.SNodeFactoryOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.smodel.action.IChildNodeSetter;
import jetbrains.mps.smodel.action.AbstractChildNodeSetter;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.smodel.action.ModelActions;
import jetbrains.mps.smodel.action.DefaultSimpleSubstituteAction;

public class QueriesGenerated {
  public static boolean nodeSubstituteActionsBuilder_Precondition_ArgumentClause_994932413699396077(final IOperationContext operationContext, final NodeSubstitutePreconditionContext _context) {
    if (SNodeOperations.isInstanceOf(_context.getParentNode(), "jetbrains.mps.baseLanguage.constructors.structure.CustomConstructor")) {
      return !(SNodeOperations.isInstanceOf(SLinkOperations.getTarget(SNodeOperations.cast(_context.getParentNode(), "jetbrains.mps.baseLanguage.constructors.structure.CustomConstructor"), "arguments", true), "jetbrains.mps.baseLanguage.constructors.structure.CustomArgumentClause"));
    }
    return false;
  }

  public static boolean nodeSubstituteActionsBuilder_Precondition_ArgumentClause_3391577739832644592(final IOperationContext operationContext, final NodeSubstitutePreconditionContext _context) {
    if (SNodeOperations.isInstanceOf(_context.getParentNode(), "jetbrains.mps.baseLanguage.constructors.structure.CustomConstructor")) {
      return !(SNodeOperations.isInstanceOf(SLinkOperations.getTarget(SNodeOperations.cast(_context.getParentNode(), "jetbrains.mps.baseLanguage.constructors.structure.CustomConstructor"), "arguments", true), "jetbrains.mps.baseLanguage.constructors.structure.ListArgumentsClause"));
    }
    return false;
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_Expression_1592896280557600187(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode outputConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.constructors.structure.CustomConstructorUsage");
      SNode childConcept = (SNode) _context.getChildConcept();
      if (SConceptOperations.isSuperConceptOf(childConcept, NameUtil.nodeFQName(outputConcept))) {
        Computable computable = new Computable() {
          public Object compute() {
            List<SNode> containers = SModelOperations.getRootsIncludingImported(_context.getModel(), operationContext.getScope(), "jetbrains.mps.baseLanguage.constructors.structure.CustomConstructorContainer");
            List<SNode> customConstructors = new ArrayList<SNode>();
            for (SNode container : ListSequence.fromList(containers)) {
              ListSequence.fromList(customConstructors).addSequence(ListSequence.fromList(SLinkOperations.getTargets(container, "constructors", true)));
            }
            return customConstructors;
          }
        };
        Iterable<SNode> queryResult = (Iterable) computable.compute();
        if (queryResult != null) {
          for (final SNode item : queryResult) {
            ListSequence.fromList(result).addElement(new DefaultChildNodeSubstituteAction(outputConcept, item, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {
              public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
                SNode usage = SNodeFactoryOperations.createNewNode("jetbrains.mps.baseLanguage.constructors.structure.CustomConstructorUsage", null);
                SLinkOperations.setTarget(usage, "customConstructor", (item), false);
                return usage;
              }

              public String getMatchingText(String pattern) {
                return SPropertyOperations.getString((item), "leftParenthesis") + "..." + SPropertyOperations.getString((item), "rightParenthesis");
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
      }
    }
    return result;
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_ArgumentClause_994932413699396071(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode outputConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.constructors.structure.CustomArgumentClause");
      SNode childConcept = (SNode) _context.getChildConcept();
      if (SConceptOperations.isSuperConceptOf(childConcept, NameUtil.nodeFQName(outputConcept))) {
        SNode wrappedConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.Type");
        IChildNodeSetter setter = new AbstractChildNodeSetter() {
          public SNode wrapNode(SNode nodeToWrap, SModel model) {
            SNode result = SNodeFactoryOperations.createNewNode("jetbrains.mps.baseLanguage.constructors.structure.CustomArgumentClause", null);
            SNode parameter = SNodeFactoryOperations.addNewChild(result, "parameter", "jetbrains.mps.baseLanguage.constructors.structure.CustomConstructorParameter");
            SLinkOperations.setTarget(parameter, "type", nodeToWrap, true);
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
    return result;
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_ArgumentClause_3391577739832644582(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode outputConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.constructors.structure.ListArgumentsClause");
      SNode childConcept = (SNode) _context.getChildConcept();
      if (outputConcept == null || SConceptOperations.isSuperConceptOf(childConcept, NameUtil.nodeFQName(outputConcept))) {
        ListSequence.fromList(result).addElement(new DefaultSimpleSubstituteAction(outputConcept, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {
          public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
            return SNodeFactoryOperations.createNewNode("jetbrains.mps.baseLanguage.constructors.structure.ListArgumentsClause", null);
          }

          public String getMatchingText(String pattern) {
            return "listof";
          }

          public String getVisibleMatchingText(String pattern) {
            return this.getMatchingText(pattern);
          }
        });
      }
    }
    return result;
  }
}
