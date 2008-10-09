package jetbrains.mps.lang.editor.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.structure.structure.AbstractConceptDeclaration;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class AbstractComponent extends BaseConcept {
  public static final String concept = "jetbrains.mps.lang.editor.structure.AbstractComponent";
  public static String CONCEPT_DECLARATION = "conceptDeclaration";

  public AbstractComponent(SNode node) {
    super(node);
  }

  public AbstractConceptDeclaration getConceptDeclaration() {
    return (AbstractConceptDeclaration)this.getReferent(AbstractComponent.CONCEPT_DECLARATION);
  }

  public void setConceptDeclaration(AbstractConceptDeclaration node) {
    super.setReferent(AbstractComponent.CONCEPT_DECLARATION, node);
  }


  public static AbstractComponent newInstance(SModel sm, boolean init) {
    return (AbstractComponent)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.editor.structure.AbstractComponent", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static AbstractComponent newInstance(SModel sm) {
    return AbstractComponent.newInstance(sm, false);
  }

}
