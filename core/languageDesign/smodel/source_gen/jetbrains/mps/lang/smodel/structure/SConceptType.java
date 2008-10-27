package jetbrains.mps.lang.smodel.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.Type;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.structure.structure.AbstractConceptDeclaration;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class SConceptType extends Type {
  public static final String concept = "jetbrains.mps.lang.smodel.structure.SConceptType";
  public static final String CONCEPT_DECLARATON = "conceptDeclaraton";

  public SConceptType(SNode node) {
    super(node);
  }

  public AbstractConceptDeclaration getConceptDeclaraton() {
    return (AbstractConceptDeclaration)this.getReferent(SConceptType.CONCEPT_DECLARATON);
  }

  public void setConceptDeclaraton(AbstractConceptDeclaration node) {
    super.setReferent(SConceptType.CONCEPT_DECLARATON, node);
  }


  public static SConceptType newInstance(SModel sm, boolean init) {
    return (SConceptType)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SConceptType", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static SConceptType newInstance(SModel sm) {
    return SConceptType.newInstance(sm, false);
  }

}
