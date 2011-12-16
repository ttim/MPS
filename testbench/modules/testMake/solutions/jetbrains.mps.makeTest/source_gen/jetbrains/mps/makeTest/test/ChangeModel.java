package jetbrains.mps.makeTest.test;

/*Generated by MPS */

import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.CopyUtil;
import jetbrains.mps.smodel.DefaultSModelDescriptor;
import jetbrains.mps.smodel.ModelLoadingState;

public abstract class ChangeModel {
  private SModel myModel;

  public ChangeModel() {
  }

  public void change(SModel model) {
    this.myModel = CopyUtil.copyModel(model);
  }

  public void rollback(SModel model) {
    ((DefaultSModelDescriptor) model.getModelDescriptor()).replaceModel(this.myModel, ModelLoadingState.FULLY_LOADED);
  }
}
