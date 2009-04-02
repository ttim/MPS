package jetbrains.mps.build.packaging.structure;

/*Generated by MPS */

import jetbrains.mps.build.packaging.structure.PostProcessingTask;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class Delete extends PostProcessingTask {
  public static final String concept = "jetbrains.mps.build.packaging.structure.Delete";
  public static final String PATH = "path";

  public Delete(SNode node) {
    super(node);
  }

  public String getPath() {
    return this.getProperty(Delete.PATH);
  }

  public void setPath(String value) {
    this.setProperty(Delete.PATH, value);
  }


  public static Delete newInstance(SModel sm, boolean init) {
    return (Delete)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.build.packaging.structure.Delete", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static Delete newInstance(SModel sm) {
    return Delete.newInstance(sm, false);
  }

}
