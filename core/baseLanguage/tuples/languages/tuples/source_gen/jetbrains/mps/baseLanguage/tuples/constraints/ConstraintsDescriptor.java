package jetbrains.mps.baseLanguage.tuples.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.IModelConstraints;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;

public class ConstraintsDescriptor implements IModelConstraints {
  private List<IModelConstraints> myConstraints = ListSequence.fromList(new ArrayList<IModelConstraints>());

  public ConstraintsDescriptor() {
    ListSequence.fromList(this.myConstraints).addElement(new NamedTupleDeclaration_resolveInfo_PropertyConstraint());
    ListSequence.fromList(this.myConstraints).addElement(new NamedTupleComponentAccessOperation_alias_PropertyConstraint());
    ListSequence.fromList(this.myConstraints).addElement(new NamedTupleDeclaration_extends_ReferentConstraint());
    ListSequence.fromList(this.myConstraints).addElement(new NamedTupleComponentReference_componentDeclaration_ReferentConstraint());
    ListSequence.fromList(this.myConstraints).addElement(new NamedTupleComponentAccessOperation_component_ReferentConstraint());
    ListSequence.fromList(this.myConstraints).addElement(new NamedTupleType_tupleDeclaration_ReferentConstraint());
    ListSequence.fromList(this.myConstraints).addElement(new NamedTupleDeclaration_DefaultSearchScope());
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
