package jetbrains.mps.baseLanguage.classifiers.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.IModelConstraints;
import java.util.List;
import java.util.ArrayList;
import jetbrains.mps.baseLanguage.classifiers.constraints.IMemberOperation_member_ReferentConstraint;
import jetbrains.mps.baseLanguage.classifiers.constraints.ThisClassifierExpresson_classifier_ReferentConstraint;
import jetbrains.mps.baseLanguage.classifiers.constraints.DefaultClassifierType_classifier_ReferentConstraint;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;

public class ConstraintsDescriptor implements IModelConstraints {

  private List<IModelConstraints> myConstraints = new ArrayList<IModelConstraints>();

  public ConstraintsDescriptor() {
    this.myConstraints.add(new IMemberOperation_member_ReferentConstraint());
    this.myConstraints.add(new ThisClassifierExpresson_classifier_ReferentConstraint());
    this.myConstraints.add(new DefaultClassifierType_classifier_ReferentConstraint());
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
