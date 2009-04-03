package jetbrains.mps.xmlSchema.structure;

/*Generated by MPS */

import jetbrains.mps.xmlSchema.structure.Declaration;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ElementDeclaration extends Declaration {
  public static final String concept = "jetbrains.mps.xmlSchema.structure.ElementDeclaration";
  public static final String ELEMENT_NAME = "elementName";

  public ElementDeclaration(SNode node) {
    super(node);
  }

  public String getElementName() {
    return this.getProperty(ElementDeclaration.ELEMENT_NAME);
  }

  public void setElementName(String value) {
    this.setProperty(ElementDeclaration.ELEMENT_NAME, value);
  }


  public static ElementDeclaration newInstance(SModel sm, boolean init) {
    return (ElementDeclaration)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.xmlSchema.structure.ElementDeclaration", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ElementDeclaration newInstance(SModel sm) {
    return ElementDeclaration.newInstance(sm, false);
  }

}
