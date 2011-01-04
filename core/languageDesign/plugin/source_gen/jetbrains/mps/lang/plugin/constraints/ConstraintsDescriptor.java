package jetbrains.mps.lang.plugin.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.IModelConstraints;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;

public class ConstraintsDescriptor implements IModelConstraints {
  private List<IModelConstraints> myConstraints = ListSequence.fromList(new ArrayList<IModelConstraints>());

  public ConstraintsDescriptor() {
    ListSequence.fromList(this.myConstraints).addElement(new RunConfigPropertyInstance_name_PropertyConstraint());
    ListSequence.fromList(this.myConstraints).addElement(new ModificationStatement_point_ReferentConstraint());
    ListSequence.fromList(this.myConstraints).addElement(new ModificationStatement_modifiedGroup_ReferentConstraint());
    ListSequence.fromList(this.myConstraints).addElement(new ActionDataParameterDeclaration_key_ReferentConstraint());
    ListSequence.fromList(this.myConstraints).addElement(new ShortcutChange_action_ReferentConstraint());
    ListSequence.fromList(this.myConstraints).addElement(new PropertyRefExpression_propertyDeclaration_ReferentConstraint());
    ListSequence.fromList(this.myConstraints).addElement(new RunConfigPropertyInstance_property_ReferentConstraint());
    ListSequence.fromList(this.myConstraints).addElement(new ActionParameterReference_parameter_ReferentConstraint());
    ListSequence.fromList(this.myConstraints).addElement(new ActionInstance_action_ReferentConstraint());
  }

  public void unRegisterSelf(ModelConstraintsManager p0) {
    for (IModelConstraints c : this.myConstraints) {
      c.unRegisterSelf(p0);
    }
  }

  public void registerSelf(ModelConstraintsManager p0) {
    for (IModelConstraints c : this.myConstraints) {
      c.registerSelf(p0);
    }
  }
}
