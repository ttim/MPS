package jetbrains.mps.lang.extension.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.Expression;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ExtensionPointExpression extends Expression {
  public static final String concept = "jetbrains.mps.lang.extension.structure.ExtensionPointExpression";
  public static final String EXTENSION_POINT = "extensionPoint";

  public ExtensionPointExpression(SNode node) {
    super(node);
  }

  public ExtensionPointDeclaration getExtensionPoint() {
    return (ExtensionPointDeclaration) this.getReferent(ExtensionPointDeclaration.class, ExtensionPointExpression.EXTENSION_POINT);
  }

  public void setExtensionPoint(ExtensionPointDeclaration node) {
    super.setReferent(ExtensionPointExpression.EXTENSION_POINT, node);
  }

  public static ExtensionPointExpression newInstance(SModel sm, boolean init) {
    return (ExtensionPointExpression) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.extension.structure.ExtensionPointExpression", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ExtensionPointExpression newInstance(SModel sm) {
    return ExtensionPointExpression.newInstance(sm, false);
  }
}
