package jetbrains.mps.lang.smodel.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import java.util.List;
import jetbrains.mps.lang.structure.behavior.AbstractConceptDeclaration_Behavior;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeof_PropertyAttributeAccessQualifier_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {

  public typeof_PropertyAttributeAccessQualifier_InferenceRule() {
  }

  public void applyRule(final SNode nodeToCheck, final TypeCheckingContext typeCheckingContext) {
    SNode annotationLink = SLinkOperations.getTarget(nodeToCheck, "annotationLink", false);
    if (annotationLink == null) {
      return;
    }
    // assign type
    {
      SNode _nodeToCheck_1029348928467 = nodeToCheck;
      BaseIntentionProvider intentionProvider = null;
      typeCheckingContext.createEquation(typeCheckingContext.typeOf(nodeToCheck, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "1206103035534", true), new _Quotations.QuotationClass_82().createNode(SPropertyOperations.hasValue(annotationLink, "sourceCardinality", "0..1", "0..1") + "", SLinkOperations.getTarget(annotationLink, "target", false), typeCheckingContext), _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "1206103041053", intentionProvider);
    }
    // ---
    if (!(SPropertyOperations.hasValue(annotationLink, "stereotype", "property", "node"))) {
      BaseIntentionProvider intentionProvider = null;
      typeCheckingContext.reportTypeError(nodeToCheck, "property annotation link is expected", "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "1204832870610", intentionProvider);
    }
    final SNode propQ = SLinkOperations.getTarget(nodeToCheck, "propertyQualifier", true);
    if (SNodeOperations.isInstanceOf(propQ, "jetbrains.mps.lang.smodel.structure.PoundExpression")) {
      // # property name
      {
        SNode _nodeToCheck_1029348928467 = nodeToCheck;
        BaseIntentionProvider intentionProvider = null;
        typeCheckingContext.createLessThanInequation(typeCheckingContext.typeOf(SLinkOperations.getTarget(propQ, "expression", true), "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "1204835998062", false), new _Quotations.QuotationClass_83().createNode(typeCheckingContext), _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "1204835998060", false, 0, intentionProvider);
      }
    } else
    if (SNodeOperations.isInstanceOf(propQ, "jetbrains.mps.lang.smodel.structure.PropertyRefQualifier")) {
      // check that property is in scope
      final SNode property = SLinkOperations.getTarget(propQ, "property", false);
      final SNode Concept_typevar_1204914077372 = typeCheckingContext.createNewRuntimeTypesVariable();
      RulesUtil.equate_inputNodeConcept(typeCheckingContext, SNodeOperations.getAncestor(nodeToCheck, "jetbrains.mps.lang.smodel.structure.SNodeOperation", false, false), typeCheckingContext.getEquationManager().getRepresentator(Concept_typevar_1204914077372));
      {
        final SNode C = typeCheckingContext.getEquationManager().getRepresentator(Concept_typevar_1204914077372);
        typeCheckingContext.whenConcrete(C, new Runnable() {

          public void run() {
            SNode inputNodeConcept = typeCheckingContext.getEquationManager().getRepresentator(C);
            List<SNode> declaredProperties = AbstractConceptDeclaration_Behavior.call_getPropertyDeclarations_1213877394546(inputNodeConcept);
            if (!(ListSequence.fromList(declaredProperties).contains(property))) {
              BaseIntentionProvider intentionProvider = null;
              typeCheckingContext.reportTypeError(propQ, "access to property '" + SPropertyOperations.getString(property, "name") + "' is not expected here", "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "1204914077394", intentionProvider);
            }
          }

        }, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "1204914077379");
      }
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.lang.smodel.structure.PropertyAttributeAccessQualifier";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

}
