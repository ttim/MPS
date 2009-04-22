package jetbrains.mps.buildlanguage.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.IModelConstraints;
import java.util.List;
import jetbrains.mps.baseLanguage.collections.internal.query.ListOperations;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;

public class ConstraintsDescriptor implements IModelConstraints {

  private List<IModelConstraints> myConstraints = ListOperations.<IModelConstraints>createList();

  public ConstraintsDescriptor() {
    ListOperations.addElement(this.myConstraints, new GenericCall_name_PropertyConstraint());
    ListOperations.addElement(this.myConstraints, new TargetReferencePropertyValueExpression_fullName_PropertyConstraint());
    ListOperations.addElement(this.myConstraints, new StringLiteral_name_PropertyConstraint());
    ListOperations.addElement(this.myConstraints, new MultiLineString_name_PropertyConstraint());
    ListOperations.addElement(this.myConstraints, new TargetReference_targetDeclaration_ReferentConstraint());
    ListOperations.addElement(this.myConstraints, new GenericCall_declaration_ReferentConstraint());
    ListOperations.addElement(this.myConstraints, new PathReference_call_ReferentConstraint());
    ListOperations.addElement(this.myConstraints, new Reference_declaration_ReferentConstraint());
    ListOperations.addElement(this.myConstraints, new GenericAttribute_attributeDeclaration_ReferentConstraint());
    ListOperations.addElement(this.myConstraints, new PropertyReference_propertyDeclaration_ReferentConstraint());
    ListOperations.addElement(this.myConstraints, new GenericCall_DefaultSearchScope());
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
