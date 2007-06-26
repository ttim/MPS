package jetbrains.mpslite.actions;

/*Generated by MPS */

import java.util.List;
import jetbrains.mps.smodel.action.INodeSubstituteAction;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.bootstrap.structureLanguage.structure.AbstractConceptDeclaration;
import jetbrains.mps.smodel.action.IChildNodeSetter;
import jetbrains.mps.smodel.IOperationContext;
import java.util.ArrayList;
import jetbrains.mps.bootstrap.structureLanguage.structure.ConceptDeclaration;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.smodel.action.DefaultSimpleSubstituteAction;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SPropertyOperations;

public class QueriesGenerated {

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_LinePart_1182843946099(final SNode parentNode, final SNode currentTargetNode, final AbstractConceptDeclaration childConcept, final IChildNodeSetter childSetter, final IOperationContext operationContext) {
    List<INodeSubstituteAction> result = new ArrayList<INodeSubstituteAction>();
    {
      ConceptDeclaration concept = SModelUtil_new.findConceptDeclaration("jetbrains.mpslite.structure.ConstantLinePart", operationContext.getScope());
      result.add(new DefaultSimpleSubstituteAction(concept, parentNode, currentTargetNode, childSetter, operationContext.getScope()) {

        public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
          SNode part = SModelOperations.createNewNode(model, "jetbrains.mpslite.structure.ConstantLinePart", null);
          SPropertyOperations.set(part, "text", pattern.substring(1));
          return part;
        }
        public boolean hasSubstitute() {
          return true;
        }
        public boolean canSubstitute_internal(String pattern) {
          return pattern.startsWith("/");
        }
        public String getDescriptionText(String pattern) {
          return "";
        }
        public String getMatchingText(String pattern) {
          return "/constant text";
        }
      });
    }
    return result;
  }
}
