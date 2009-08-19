package jetbrains.mps.baseLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class DefaultGetAccessor extends BaseConcept {
  public static final String concept = "jetbrains.mps.baseLanguage.structure.DefaultGetAccessor";

  public DefaultGetAccessor(SNode node) {
    super(node);
  }

  public static DefaultGetAccessor newInstance(SModel sm, boolean init) {
    return (DefaultGetAccessor)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.DefaultGetAccessor", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static DefaultGetAccessor newInstance(SModel sm) {
    return DefaultGetAccessor.newInstance(sm, false);
  }
}
