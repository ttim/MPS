package jetbrains.mps.lang.smodel.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.IModelConstraints;
import java.util.List;
import java.util.ArrayList;
import jetbrains.mps.lang.smodel.constraints.SPropertyAccess_property_ReferentConstraint;
import jetbrains.mps.lang.smodel.constraints.PropertyAttributeAccessQualifier_annotationLink_ReferentConstraint;
import jetbrains.mps.lang.smodel.constraints.Node_ConceptMethodCall_conceptMethodDeclaration_ReferentConstraint;
import jetbrains.mps.lang.smodel.constraints.NodeAttributeAccessQualifier_annotationLink_ReferentConstraint;
import jetbrains.mps.lang.smodel.constraints.SConceptLinkAccess_conceptLinkDeclaration_ReferentConstraint;
import jetbrains.mps.lang.smodel.constraints.SLinkAccess_link_ReferentConstraint;
import jetbrains.mps.lang.smodel.constraints.Node_IsRoleOperation_linkInParent_ReferentConstraint;
import jetbrains.mps.lang.smodel.constraints.StaticConceptMethodCall_concept_ReferentConstraint;
import jetbrains.mps.lang.smodel.constraints.StaticConceptMethodCall_methodDeclaration_ReferentConstraint;
import jetbrains.mps.lang.smodel.constraints.SLinkListAccess_link_ReferentConstraint;
import jetbrains.mps.lang.smodel.constraints.LinkAttributeAccessQualifier_annotationLink_ReferentConstraint;
import jetbrains.mps.lang.smodel.constraints.EnumMemberReference_enumMember_ReferentConstraint;
import jetbrains.mps.lang.smodel.constraints.LinkRefQualifier_link_ReferentConstraint;
import jetbrains.mps.lang.smodel.constraints.SConceptPropertyAccess_conceptProperty_ReferentConstraint;
import jetbrains.mps.lang.smodel.constraints.PropertyRefQualifier_property_ReferentConstraint;
import jetbrains.mps.lang.smodel.constraints.NodeRefExpression_referentNode_ReferentConstraint;
import jetbrains.mps.lang.smodel.constraints.Node_GetReferentSearchScopeOperation_referenceLink_ReferentConstraint;
import jetbrains.mps.lang.smodel.constraints.LinkRefExpression_linkDeclaration_ReferentConstraint;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;

public class ConstraintsDescriptor implements IModelConstraints {

  private List<IModelConstraints> myConstraints = new ArrayList<IModelConstraints>();

  public ConstraintsDescriptor() {
    this.myConstraints.add(new SPropertyAccess_property_ReferentConstraint());
    this.myConstraints.add(new PropertyAttributeAccessQualifier_annotationLink_ReferentConstraint());
    this.myConstraints.add(new Node_ConceptMethodCall_conceptMethodDeclaration_ReferentConstraint());
    this.myConstraints.add(new NodeAttributeAccessQualifier_annotationLink_ReferentConstraint());
    this.myConstraints.add(new SConceptLinkAccess_conceptLinkDeclaration_ReferentConstraint());
    this.myConstraints.add(new SLinkAccess_link_ReferentConstraint());
    this.myConstraints.add(new Node_IsRoleOperation_linkInParent_ReferentConstraint());
    this.myConstraints.add(new StaticConceptMethodCall_concept_ReferentConstraint());
    this.myConstraints.add(new StaticConceptMethodCall_methodDeclaration_ReferentConstraint());
    this.myConstraints.add(new SLinkListAccess_link_ReferentConstraint());
    this.myConstraints.add(new LinkAttributeAccessQualifier_annotationLink_ReferentConstraint());
    this.myConstraints.add(new EnumMemberReference_enumMember_ReferentConstraint());
    this.myConstraints.add(new LinkRefQualifier_link_ReferentConstraint());
    this.myConstraints.add(new SConceptPropertyAccess_conceptProperty_ReferentConstraint());
    this.myConstraints.add(new PropertyRefQualifier_property_ReferentConstraint());
    this.myConstraints.add(new NodeRefExpression_referentNode_ReferentConstraint());
    this.myConstraints.add(new Node_GetReferentSearchScopeOperation_referenceLink_ReferentConstraint());
    this.myConstraints.add(new LinkRefExpression_linkDeclaration_ReferentConstraint());
  }

  public void unRegisterSelf(ModelConstraintsManager p0) {
    for(IModelConstraints c : this.myConstraints) {
      c.unRegisterSelf(p0);
    }
  }

  public void registerSelf(ModelConstraintsManager p0) {
    for(IModelConstraints c : this.myConstraints) {
      c.registerSelf(p0);
    }
  }

}
