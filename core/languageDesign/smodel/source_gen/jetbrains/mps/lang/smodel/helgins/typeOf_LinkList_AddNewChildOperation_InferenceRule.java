package jetbrains.mps.lang.smodel.helgins;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeOf_LinkList_AddNewChildOperation_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {

  public typeOf_LinkList_AddNewChildOperation_InferenceRule() {
  }

  public void applyRule(final SNode op, final TypeCheckingContext typeCheckingContext) {
    RulesUtil.checkAppliedTo_LinkListAccess_aggregation(typeCheckingContext, op);
    final SNode Concept_typevar_1206099501305 = typeCheckingContext.createNewRuntimeTypesVariable();
    RulesUtil.equate_inputNodeConcept(typeCheckingContext, op, typeCheckingContext.getEquationManager().getRepresentator(Concept_typevar_1206099501305));
    {
      final SNode concreteConcept = typeCheckingContext.getEquationManager().getRepresentator(Concept_typevar_1206099501305);
      typeCheckingContext.whenConcrete(concreteConcept, new Runnable() {

        public void run() {
          SNode resultConcept;
          SNode parameterConcept = SLinkOperations.getTarget(op, "concept", false);
          if (parameterConcept == null) {
            resultConcept = typeCheckingContext.getEquationManager().getRepresentator(concreteConcept);
          } else
          {
            resultConcept = parameterConcept;
            if (!(SConceptOperations.isSubConceptOf(parameterConcept, NameUtil.nodeFQName(typeCheckingContext.getEquationManager().getRepresentator(concreteConcept))))) {
              BaseIntentionProvider intentionProvider = null;
              typeCheckingContext.reportTypeError(op, SPropertyOperations.getString(parameterConcept, "name") + " is not sub-concept of " + SPropertyOperations.getString(typeCheckingContext.getEquationManager().getRepresentator(concreteConcept), "name"), "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.helgins)", "1205771608879", intentionProvider);
            }
          }
          {
            SNode _nodeToCheck_1029348928467 = op;
            BaseIntentionProvider intentionProvider = null;
            typeCheckingContext.createEquation(typeCheckingContext.typeOf(op, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.helgins)", "1205771608897", true), new QuotationClass_65().createNode(resultConcept), _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.helgins)", "1205771608895", intentionProvider);
          }
        }

      }, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.helgins)", "1205771551269");
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.lang.smodel.structure.LinkList_AddNewChildOperation";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return true;
  }

}
