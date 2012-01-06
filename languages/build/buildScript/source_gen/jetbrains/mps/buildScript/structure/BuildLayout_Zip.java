package jetbrains.mps.buildScript.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class BuildLayout_Zip extends BuildLayout_NamedContainer {
  public static final String concept = "jetbrains.mps.buildScript.structure.BuildLayout_Zip";

  public BuildLayout_Zip(SNode node) {
    super(node);
  }

  public static BuildLayout_Zip newInstance(SModel sm, boolean init) {
    return (BuildLayout_Zip) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.buildScript.structure.BuildLayout_Zip", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static BuildLayout_Zip newInstance(SModel sm) {
    return BuildLayout_Zip.newInstance(sm, false);
  }
}
