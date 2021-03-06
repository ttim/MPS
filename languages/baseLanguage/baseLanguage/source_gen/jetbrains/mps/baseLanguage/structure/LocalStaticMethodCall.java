package jetbrains.mps.baseLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class LocalStaticMethodCall extends BaseMethodCall {
  public static final String concept = "jetbrains.mps.baseLanguage.structure.LocalStaticMethodCall";

  public LocalStaticMethodCall(SNode node) {
    super(node);
  }

  public StaticMethodDeclaration getStaticMethodDeclaration() {
    return this.ensureAdapter(StaticMethodDeclaration.class, "baseMethodDeclaration", this.getBaseMethodDeclaration());
  }

  public void setStaticMethodDeclaration(StaticMethodDeclaration node) {
    this.setBaseMethodDeclaration(node);
  }

  public static LocalStaticMethodCall newInstance(SModel sm, boolean init) {
    return (LocalStaticMethodCall) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.LocalStaticMethodCall", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static LocalStaticMethodCall newInstance(SModel sm) {
    return LocalStaticMethodCall.newInstance(sm, false);
  }
}
