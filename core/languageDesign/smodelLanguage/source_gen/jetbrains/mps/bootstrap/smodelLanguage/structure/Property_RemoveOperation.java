package jetbrains.mps.bootstrap.smodelLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class Property_RemoveOperation extends SNodeOperation {
  public static final String concept = "jetbrains.mps.bootstrap.smodelLanguage.structure.Property_RemoveOperation";

  public Property_RemoveOperation(SNode node) {
    super(node);
  }

  public static Property_RemoveOperation newInstance(SModel sm, boolean init) {
    return (Property_RemoveOperation)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.bootstrap.smodelLanguage.structure.Property_RemoveOperation", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static Property_RemoveOperation newInstance(SModel sm) {
    return Property_RemoveOperation.newInstance(sm, false);
  }

}
