package jetbrains.mps.baseLanguage.logging.actions;

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
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SEnumOperations;
import jetbrains.mps.smodel.action.DefaultChildNodeSubstituteAction;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.action.SNodeFactoryOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;

public class QueriesGenerated {
  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_Statement_1167245930434(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      SNode outputConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.logging.structure.LogStatement");
      SNode childConcept = (SNode) _context.getChildConcept();
      if (SConceptOperations.isSuperConceptOf(childConcept, NameUtil.nodeFQName(outputConcept))) {
        Computable computable = new Computable() {
          public Object compute() {
            return SEnumOperations.getEnumMembers(SEnumOperations.getEnum("r:00000000-0000-4000-0000-011c8959057f(jetbrains.mps.baseLanguage.logging.structure)", "Severity"));
          }
        };
        Iterable<SNode> queryResult = (Iterable) computable.compute();
        if (queryResult != null) {
          for (final SNode item : queryResult) {
            ListSequence.fromList(result).addElement(new DefaultChildNodeSubstituteAction(outputConcept, item, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {
              public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
                SNode logStatement = SNodeFactoryOperations.createNewNode(model, "jetbrains.mps.baseLanguage.logging.structure.LogStatement", null);
                SPropertyOperations.set(logStatement, "severity", SEnumOperations.getEnumMemberValue((item)));
                SNodeFactoryOperations.setNewChild(logStatement, "logExpression", "jetbrains.mps.baseLanguage.structure.StringLiteral");
                SNode catchClause = SNodeOperations.getAncestor(_context.getParentNode(), "jetbrains.mps.baseLanguage.structure.CatchClause", true, false);
                if ((catchClause != null) && (SLinkOperations.getTarget(catchClause, "throwable", true) != null)) {
                  SPropertyOperations.set(logStatement, "hasException", "" + (true));
                  SNode lvr = SNodeFactoryOperations.setNewChild(logStatement, "exception", "jetbrains.mps.baseLanguage.structure.LocalVariableReference");
                  SLinkOperations.setTarget(lvr, "variableDeclaration", SLinkOperations.getTarget(catchClause, "throwable", true), false);
                }
                return logStatement;
              }

              public String getMatchingText(String pattern) {
                return SEnumOperations.getEnumMemberValue((item));
              }

              public String getVisibleMatchingText(String pattern) {
                return this.getMatchingText(pattern);
              }

              public String getDescriptionText(String pattern) {
                return "Log statement";
              }
            });
          }
        }
      }
    }
    return result;
  }
}
