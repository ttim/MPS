package jetbrains.mps.baseLanguage.overloadedOperators.actions;

/*Generated by MPS */

import java.util.List;
import jetbrains.mps.smodel.action.INodeSubstituteAction;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.action.SideTransformActionsBuilderContext;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.util.Computable;
import jetbrains.mps.baseLanguage.overloadedOperators.behavior.CustomOperatorUsage_Behavior;
import jetbrains.mps.smodel.action.AbstractSideTransformHintSubstituteAction;
import jetbrains.mps.smodel.action.SNodeFactoryOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;

public class QueriesGenerated {
  public static List<INodeSubstituteAction> sideTransform_ActionsFactory_Expression_1141736782992981496(final IOperationContext operationContext, final SideTransformActionsBuilderContext _context) {
    List<INodeSubstituteAction> result = ListSequence.fromList(new ArrayList<INodeSubstituteAction>());
    {
      final SNode concept = SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.overloadedOperators.structure.CustomOperatorUsage");
      Computable computable = new Computable() {
        public Object compute() {
          return CustomOperatorUsage_Behavior.getVisibleCustomOperators_1141736782992984505(_context.getModel());
        }
      };
      Iterable<SNode> parameterObjects = (Iterable<SNode>) computable.compute();
      assert parameterObjects != null;
      for (final SNode item : parameterObjects) {
        ListSequence.fromList(result).addElement(new AbstractSideTransformHintSubstituteAction(concept, item, _context.getSourceNode()) {
          public SNode doSubstitute(String pattern) {
            SNode usage = SNodeFactoryOperations.createNewNode("jetbrains.mps.baseLanguage.overloadedOperators.structure.CustomOperatorUsage", null);
            SNodeOperations.replaceWithAnother(_context.getSourceNode(), usage);
            SLinkOperations.setTarget(usage, "operator", (item), false);
            SLinkOperations.setTarget(usage, "leftExpression", _context.getSourceNode(), true);
            return usage;
          }

          public String getMatchingText(String pattern) {
            return SPropertyOperations.getString((item), "name");
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
