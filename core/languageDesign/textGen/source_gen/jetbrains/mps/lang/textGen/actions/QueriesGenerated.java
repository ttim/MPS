package jetbrains.mps.lang.textGen.actions;

/*Generated by MPS */

import java.util.List;
import jetbrains.mps.smodel.action.INodeSubstituteAction;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.action.NodeSubstituteActionsFactoryContext;
import java.util.ArrayList;
import jetbrains.mps.util.Calculable;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.textGen.behavior.LanguageTextGenDeclaration_Behavior;
import jetbrains.mps.smodel.action.ChildSubstituteActionsHelper;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.baseLanguage.search.VisibleClassifiersScope;
import jetbrains.mps.baseLanguage.search.IClassifiersSearchScope;
import jetbrains.mps.smodel.action.DefaultChildNodeSubstituteAction;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;

public class QueriesGenerated {

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_Expression_1234362700251(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = new ArrayList<INodeSubstituteAction>();
    {
      Calculable calc = new Calculable() {

        public Object calculate() {
          List<SNode> langTextGenComponents = SNodeOperations.getAncestors(_context.getParentNode(), "jetbrains.mps.lang.textGen.structure.LanguageTextGenDeclaration", false);
          SNode langTextGen = ListSequence.fromList(langTextGenComponents).first();
          if (langTextGen != null) {
            return LanguageTextGenDeclaration_Behavior.call_getParameters_1234799367488(langTextGen);
          } else
          {
            return ListSequence.<SNode>fromArray();
          }
        }

      };
      Iterable queryResult = (Iterable)calc.calculate();
      if (queryResult != null) {
        for(Object item : queryResult) {
          List<INodeSubstituteAction> defaultActions = ChildSubstituteActionsHelper.createDefaultActions((SNode)item, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext);
          result.addAll(defaultActions);
        }
      }
    }
    return result;
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_ClassifierType_1234371562998(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = new ArrayList<INodeSubstituteAction>();
    {
      SNode outputConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType");
      SNode childConcept = (SNode)_context.getChildConcept();
      if (SConceptOperations.isSuperConceptOf(childConcept, NameUtil.nodeFQName(outputConcept))) {
        Calculable calc = new Calculable() {

          public Object calculate() {
            return (List<SNode>)new VisibleClassifiersScope(_context.getModel(), IClassifiersSearchScope.NON_FINAL_CLASS, operationContext.getScope()).getNodes();
          }

        };
        Iterable<SNode> queryResult = (Iterable)calc.calculate();
        if (queryResult != null) {
          for(final SNode item : queryResult) {
            result.add(new DefaultChildNodeSubstituteAction(outputConcept, item, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {

              public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
                SNode result = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.ClassifierType", null);
                SLinkOperations.setTarget(result, "classifier", (item), false);
                return result;
              }

            });
          }
        }
      }
    }
    return result;
  }

}
