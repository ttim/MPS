package jetbrains.mps.xmlInternal.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class PublicExternalId extends ExternalId {
  public static final String concept = "jetbrains.mps.xmlInternal.structure.PublicExternalId";
  public static final String PUBID_LITERAL = "pubidLiteral";
  public static final String SYSTEM_LITERAL = "systemLiteral";

  public PublicExternalId(SNode node) {
    super(node);
  }

  public Literal getPubidLiteral() {
    return (Literal)this.getChild(Literal.class, PublicExternalId.PUBID_LITERAL);
  }

  public void setPubidLiteral(Literal node) {
    super.setChild(PublicExternalId.PUBID_LITERAL, node);
  }

  public Literal getSystemLiteral() {
    return (Literal)this.getChild(Literal.class, PublicExternalId.SYSTEM_LITERAL);
  }

  public void setSystemLiteral(Literal node) {
    super.setChild(PublicExternalId.SYSTEM_LITERAL, node);
  }

  public static PublicExternalId newInstance(SModel sm, boolean init) {
    return (PublicExternalId)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.xmlInternal.structure.PublicExternalId", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static PublicExternalId newInstance(SModel sm) {
    return PublicExternalId.newInstance(sm, false);
  }
}
