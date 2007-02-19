package jetbrains.mps.bootstrap.smodelLanguage.structure;

/*Generated by MPS  */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.baseLanguage.structure.Expression;

public class Property_SetOperation extends SNodeOperation {
  public static String VALUE = "value";

  public  Property_SetOperation(SNode node) {
    super(node);
  }

  public static Property_SetOperation newInstance(SModel sm, boolean init) {
    return (Property_SetOperation)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.bootstrap.smodelLanguage.Property_SetOperation", sm, GlobalScope.getInstance(), init).getAdapter();
  }
  public static Property_SetOperation newInstance(SModel sm) {
    return Property_SetOperation.newInstance(sm, false);
  }

  public Expression getValue() {
    return (Expression)this.getChild(Property_SetOperation.VALUE);
  }
  public void setValue(Expression node) {
    super.setChild(Property_SetOperation.VALUE, node);
  }
}
