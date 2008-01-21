package jetbrains.mps.buildlanguage.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.IModelConstraints;
import java.util.List;
import java.util.ArrayList;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;

public class ConstraintsDescriptor implements IModelConstraints {

  private List<IModelConstraints> myConstraints = new ArrayList<IModelConstraints>();

  public  ConstraintsDescriptor() {
    this.myConstraints.add(new StringLiteral_name_PropertyConstraint());
    this.myConstraints.add(new GenericCall_pseudonymProperty_PropertyConstraint());
    this.myConstraints.add(new GenericCall_name_PropertyConstraint());
    this.myConstraints.add(new TargetReference_targetDeclaration_ReferentConstraint());
    this.myConstraints.add(new PropertyReference_propertyDeclaration_ReferentConstraint());
    this.myConstraints.add(new GenericCall_declaration_ReferentConstraint());
    this.myConstraints.add(new GenericAttribute_attributeDeclaration_ReferentConstraint());
    this.myConstraints.add(new Reference_declaration_ReferentConstraint());
    this.myConstraints.add(new PathReference_call_ReferentConstraint());
    this.myConstraints.add(new StringLiteralReference_ref_ReferentConstraint());
    this.myConstraints.add(new CallReference_call_ReferentConstraint());
    this.myConstraints.add(new GenericCall_DefaultSearchScope());
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
