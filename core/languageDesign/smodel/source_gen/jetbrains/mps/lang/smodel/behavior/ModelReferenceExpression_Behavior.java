package jetbrains.mps.lang.smodel.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelRepository;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;

public class ModelReferenceExpression_Behavior {
  public static void init(SNode thisNode) {
  }

  public static SModel call_getModel_559557797393017730(SNode thisNode) {
    return SModelRepository.getInstance().getModelDescriptor(new SModelReference(SPropertyOperations.getString(thisNode, "name"), SPropertyOperations.getString(thisNode, "stereotype"))).getSModel();
  }
}
