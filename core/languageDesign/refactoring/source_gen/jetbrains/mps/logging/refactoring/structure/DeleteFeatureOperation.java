package jetbrains.mps.logging.refactoring.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.Statement;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.baseLanguage.structure.Expression;

public class DeleteFeatureOperation extends Statement {
  public static final String concept = "jetbrains.mps.logging.refactoring.structure.DeleteFeatureOperation";
  public static String FEATURE = "feature";

  public  DeleteFeatureOperation(SNode node) {
    super(node);
  }

  public static DeleteFeatureOperation newInstance(SModel sm, boolean init) {
    return (DeleteFeatureOperation)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.logging.refactoring.structure.DeleteFeatureOperation", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static DeleteFeatureOperation newInstance(SModel sm) {
    return DeleteFeatureOperation.newInstance(sm, false);
  }


  public Expression getFeature() {
    return (Expression)this.getChild(DeleteFeatureOperation.FEATURE);
  }

  public void setFeature(Expression node) {
    super.setChild(DeleteFeatureOperation.FEATURE, node);
  }

}
