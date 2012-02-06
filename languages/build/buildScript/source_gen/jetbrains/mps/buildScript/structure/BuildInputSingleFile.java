package jetbrains.mps.buildScript.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class BuildInputSingleFile extends BuildInputFileSet {
  public static final String concept = "jetbrains.mps.buildScript.structure.BuildInputSingleFile";
  public static final String PATH = "path";

  public BuildInputSingleFile(SNode node) {
    super(node);
  }

  public BuildSourcePath getPath() {
    return (BuildSourcePath) this.getChild(BuildSourcePath.class, BuildInputSingleFile.PATH);
  }

  public void setPath(BuildSourcePath node) {
    super.setChild(BuildInputSingleFile.PATH, node);
  }

  public static BuildInputSingleFile newInstance(SModel sm, boolean init) {
    return (BuildInputSingleFile) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.buildScript.structure.BuildInputSingleFile", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static BuildInputSingleFile newInstance(SModel sm) {
    return BuildInputSingleFile.newInstance(sm, false);
  }
}
