package jetbrains.mps.bootstrap.smodelLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class Model_CreateNewRootNodeOperation extends Model_CreateNewNodeOperation {

  public  Model_CreateNewRootNodeOperation(SNode node) {
    super(node);
  }

  public static Model_CreateNewRootNodeOperation newInstance(SModel sm, boolean init) {
    return (Model_CreateNewRootNodeOperation)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.bootstrap.smodelLanguage.structure.Model_CreateNewRootNodeOperation", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static Model_CreateNewRootNodeOperation newInstance(SModel sm) {
    return Model_CreateNewRootNodeOperation.newInstance(sm, false);
  }

}
