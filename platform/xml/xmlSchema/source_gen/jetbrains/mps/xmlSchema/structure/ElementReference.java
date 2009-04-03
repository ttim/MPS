package jetbrains.mps.xmlSchema.structure;

/*Generated by MPS */

import jetbrains.mps.xmlSchema.structure.TypeExpression;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.xmlSchema.structure.ElementDeclaration;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ElementReference extends TypeExpression {
  public static final String concept = "jetbrains.mps.xmlSchema.structure.ElementReference";
  public static final String ELEMENT_DECLARATION = "elementDeclaration";

  public ElementReference(SNode node) {
    super(node);
  }

  public ElementDeclaration getElementDeclaration() {
    return (ElementDeclaration)this.getReferent(ElementDeclaration.class, ElementReference.ELEMENT_DECLARATION);
  }

  public void setElementDeclaration(ElementDeclaration node) {
    super.setReferent(ElementReference.ELEMENT_DECLARATION, node);
  }


  public static ElementReference newInstance(SModel sm, boolean init) {
    return (ElementReference)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.xmlSchema.structure.ElementReference", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ElementReference newInstance(SModel sm) {
    return ElementReference.newInstance(sm, false);
  }

}
