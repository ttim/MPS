package jetbrains.mps.baseLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.core.structure.BaseConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class DefaultSetAccessor extends BaseConcept {
  public static final String concept = "jetbrains.mps.baseLanguage.structure.DefaultSetAccessor";
  public static String VISIBILITY = "visibility";

  public DefaultSetAccessor(SNode node) {
    super(node);
  }

  public Visibility getVisibility() {
    return (Visibility)this.getChild(DefaultSetAccessor.VISIBILITY);
  }

  public void setVisibility(Visibility node) {
    super.setChild(DefaultSetAccessor.VISIBILITY, node);
  }


  public static DefaultSetAccessor newInstance(SModel sm, boolean init) {
    return (DefaultSetAccessor)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.DefaultSetAccessor", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static DefaultSetAccessor newInstance(SModel sm) {
    return DefaultSetAccessor.newInstance(sm, false);
  }

}
