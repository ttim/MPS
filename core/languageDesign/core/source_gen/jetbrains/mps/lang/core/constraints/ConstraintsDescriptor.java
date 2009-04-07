package jetbrains.mps.lang.core.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.IModelConstraints;
import java.util.List;
import jetbrains.mps.baseLanguage.collections.internal.query.ListOperations;
import jetbrains.mps.lang.core.constraints.BaseConcept_virtualPackage_PropertyConstraint;
import jetbrains.mps.lang.core.constraints.IResolveInfo_resolveInfo_PropertyConstraint;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;

public class ConstraintsDescriptor implements IModelConstraints {

  private List<IModelConstraints> myConstraints = ListOperations.<IModelConstraints>createList();

  public ConstraintsDescriptor() {
    ListOperations.addElement(this.myConstraints, new BaseConcept_virtualPackage_PropertyConstraint());
    ListOperations.addElement(this.myConstraints, new IResolveInfo_resolveInfo_PropertyConstraint());
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
