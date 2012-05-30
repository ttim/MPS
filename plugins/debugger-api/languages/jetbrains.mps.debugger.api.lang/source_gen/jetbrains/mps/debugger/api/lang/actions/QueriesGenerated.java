package jetbrains.mps.debugger.api.lang.actions;

/*Generated by MPS */

import java.util.List;
import jetbrains.mps.smodel.action.INodeSubstituteAction;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.action.NodeSubstituteActionsFactoryContext;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.util.Computable;
import jetbrains.mps.debug.api.IDebugger;
import jetbrains.mps.debug.api.Debuggers;
import jetbrains.mps.smodel.action.DefaultChildNodeSubstituteAction;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.action.SNodeFactoryOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.typesystem.runtime.HUtil;
import jetbrains.mps.debug.api.breakpoints.IBreakpointsProvider;
import jetbrains.mps.debug.api.breakpoints.IBreakpointKind;

public class QueriesGenerated {
  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_DebuggerReference_1104094430779069345(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode outputConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.debugger.api.lang.structure.DebuggerReference");
      SNode childConcept = (SNode) _context.getChildConcept();
      if (SConceptOperations.isSuperConceptOf(childConcept, NameUtil.nodeFQName(outputConcept))) {
        Computable computable = new Computable() {
          public Object compute() {
            List<String> debuggerNames = ListSequence.fromList(new ArrayList<String>());
            for (IDebugger debugger : ListSequence.fromList(Debuggers.getInstance().getDebuggers())) {
              ListSequence.fromList(debuggerNames).addElement(debugger.getName());
            }
            return debuggerNames;
          }
        };
        Iterable<String> queryResult = (Iterable) computable.compute();
        if (queryResult != null) {
          for (final String item : queryResult) {
            ListSequence.fromList(result).addElement(new DefaultChildNodeSubstituteAction(outputConcept, item, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {
              public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
                SNode debuggerReference = SNodeFactoryOperations.createNewNode("jetbrains.mps.debugger.api.lang.structure.DebuggerReference", null);
                SPropertyOperations.set(debuggerReference, "debuggerName", (item));
                return debuggerReference;
              }

              public String getMatchingText(String pattern) {
                return "debugger<" + (item) + ">";
              }

              public String getVisibleMatchingText(String pattern) {
                return this.getMatchingText(pattern);
              }

              public String getDescriptionText(String pattern) {
                return (item) + " Debugger";
              }
            });
          }
        }
      }
    }
    return result;
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_IOperation_2569394751387978976(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode outputConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.debugger.api.lang.structure.CreateBreakpointOperation");
      SNode childConcept = (SNode) _context.getChildConcept();
      if (SConceptOperations.isSuperConceptOf(childConcept, NameUtil.nodeFQName(outputConcept))) {
        Computable computable = new Computable() {
          public Object compute() {
            SNode debuggerType = TypeChecker.getInstance().getRuntimeSupport().coerce_(TypeChecker.getInstance().getTypeOf(SLinkOperations.getTarget(SNodeOperations.cast(_context.getParentNode(), "jetbrains.mps.baseLanguage.structure.DotExpression"), "operand", true)), HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.debugger.api.lang.structure.DebuggerType"), true);
            if (debuggerType != null && StringUtils.isNotEmpty(SPropertyOperations.getString(debuggerType, "name"))) {
              IBreakpointsProvider provider = Debuggers.getInstance().getDebuggerByName(SPropertyOperations.getString(debuggerType, "name")).getBreakpointsProvider();
              if (provider != null) {
                return (List<IBreakpointKind>) provider.getAllKinds();
              }
            }
            return ListSequence.fromList(new ArrayList<IBreakpointKind>());
          }
        };
        Iterable<IBreakpointKind> queryResult = (Iterable) computable.compute();
        if (queryResult != null) {
          for (final IBreakpointKind item : queryResult) {
            ListSequence.fromList(result).addElement(new DefaultChildNodeSubstituteAction(outputConcept, item, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {
              public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
                SNode createBreakpointOperation = SNodeFactoryOperations.createNewNode("jetbrains.mps.debugger.api.lang.structure.CreateBreakpointOperation", null);
                SPropertyOperations.set(createBreakpointOperation, "kindName", (item).getName());
                SPropertyOperations.set(createBreakpointOperation, "kindPresentation", (item).getPresentation());
                return createBreakpointOperation;
              }

              public String getMatchingText(String pattern) {
                return (item).getPresentation();
              }

              public String getVisibleMatchingText(String pattern) {
                return this.getMatchingText(pattern);
              }

              public String getDescriptionText(String pattern) {
                return "create " + (item).getPresentation();
              }
            });
          }
        }
      }
    }
    return result;
  }
}
