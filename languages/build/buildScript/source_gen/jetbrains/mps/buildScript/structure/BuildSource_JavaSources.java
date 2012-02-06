package jetbrains.mps.buildScript.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class BuildSource_JavaSources extends BaseConcept {
  public static final String concept = "jetbrains.mps.buildScript.structure.BuildSource_JavaSources";

  public BuildSource_JavaSources(SNode node) {
    super(node);
  }

  public static BuildSource_JavaSources newInstance(SModel sm, boolean init) {
    return (BuildSource_JavaSources) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.buildScript.structure.BuildSource_JavaSources", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static BuildSource_JavaSources newInstance(SModel sm) {
    return BuildSource_JavaSources.newInstance(sm, false);
  }
}
