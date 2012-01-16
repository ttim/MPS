package jetbrains.mps.buildScript.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class BuildSource_JavaLibraryJar extends BuildSource_JavaLibraryElement {
  public static final String concept = "jetbrains.mps.buildScript.structure.BuildSource_JavaLibraryJar";
  public static final String PATH = "path";

  public BuildSource_JavaLibraryJar(SNode node) {
    super(node);
  }

  public BuildSourcePath getPath() {
    return (BuildSourcePath) this.getChild(BuildSourcePath.class, BuildSource_JavaLibraryJar.PATH);
  }

  public void setPath(BuildSourcePath node) {
    super.setChild(BuildSource_JavaLibraryJar.PATH, node);
  }

  public static BuildSource_JavaLibraryJar newInstance(SModel sm, boolean init) {
    return (BuildSource_JavaLibraryJar) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.buildScript.structure.BuildSource_JavaLibraryJar", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static BuildSource_JavaLibraryJar newInstance(SModel sm) {
    return BuildSource_JavaLibraryJar.newInstance(sm, false);
  }
}
