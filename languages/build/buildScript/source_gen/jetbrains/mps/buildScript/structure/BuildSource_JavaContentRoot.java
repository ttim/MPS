package jetbrains.mps.buildScript.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class BuildSource_JavaContentRoot extends BuildSource_JavaSources {
  public static final String concept = "jetbrains.mps.buildScript.structure.BuildSource_JavaContentRoot";
  public static final String BASE_PATH = "basePath";
  public static final String FOLDERS = "folders";

  public BuildSource_JavaContentRoot(SNode node) {
    super(node);
  }

  public BuildSourcePath getBasePath() {
    return (BuildSourcePath) this.getChild(BuildSourcePath.class, BuildSource_JavaContentRoot.BASE_PATH);
  }

  public void setBasePath(BuildSourcePath node) {
    super.setChild(BuildSource_JavaContentRoot.BASE_PATH, node);
  }

  public int getFoldersesCount() {
    return this.getChildCount(BuildSource_JavaContentRoot.FOLDERS);
  }

  public Iterator<BuildSource_JavaContentFolder> folderses() {
    return this.children(BuildSource_JavaContentFolder.class, BuildSource_JavaContentRoot.FOLDERS);
  }

  public List<BuildSource_JavaContentFolder> getFolderses() {
    return this.getChildren(BuildSource_JavaContentFolder.class, BuildSource_JavaContentRoot.FOLDERS);
  }

  public void addFolders(BuildSource_JavaContentFolder node) {
    this.addChild(BuildSource_JavaContentRoot.FOLDERS, node);
  }

  public void insertFolders(BuildSource_JavaContentFolder prev, BuildSource_JavaContentFolder node) {
    this.insertChild(prev, BuildSource_JavaContentRoot.FOLDERS, node);
  }

  public static BuildSource_JavaContentRoot newInstance(SModel sm, boolean init) {
    return (BuildSource_JavaContentRoot) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.buildScript.structure.BuildSource_JavaContentRoot", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static BuildSource_JavaContentRoot newInstance(SModel sm) {
    return BuildSource_JavaContentRoot.newInstance(sm, false);
  }
}
