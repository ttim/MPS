package jetbrains.mps.build.distrib.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class MacConfig extends SystemSpecificConfig {
  public static final String concept = "jetbrains.mps.build.distrib.structure.MacConfig";

  public MacConfig(SNode node) {
    super(node);
  }

  public static MacConfig newInstance(SModel sm, boolean init) {
    return (MacConfig)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.build.distrib.structure.MacConfig", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static MacConfig newInstance(SModel sm) {
    return MacConfig.newInstance(sm, false);
  }

}
