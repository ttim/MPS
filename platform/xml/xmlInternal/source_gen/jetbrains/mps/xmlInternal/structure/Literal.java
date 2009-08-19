package jetbrains.mps.xmlInternal.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class Literal extends BaseConcept {
  public static final String concept = "jetbrains.mps.xmlInternal.structure.Literal";
  public static final String VALUE = "value";

  public Literal(SNode node) {
    super(node);
  }

  public String getValue() {
    return this.getProperty(Literal.VALUE);
  }

  public void setValue(String value) {
    this.setProperty(Literal.VALUE, value);
  }

  public static Literal newInstance(SModel sm, boolean init) {
    return (Literal)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.xmlInternal.structure.Literal", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static Literal newInstance(SModel sm) {
    return Literal.newInstance(sm, false);
  }
}
