package jetbrains.mps.buildScript.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class BuildLayout_TransparentContainer extends BuildLayout_AbstractContainer {
  public static final String concept = "jetbrains.mps.buildScript.structure.BuildLayout_TransparentContainer";

  public BuildLayout_TransparentContainer(SNode node) {
    super(node);
  }

  public static BuildLayout_TransparentContainer newInstance(SModel sm, boolean init) {
    return (BuildLayout_TransparentContainer) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.buildScript.structure.BuildLayout_TransparentContainer", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static BuildLayout_TransparentContainer newInstance(SModel sm) {
    return BuildLayout_TransparentContainer.newInstance(sm, false);
  }
}
