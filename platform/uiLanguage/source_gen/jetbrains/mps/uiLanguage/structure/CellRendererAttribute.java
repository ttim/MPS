package jetbrains.mps.uiLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.core.structure.BaseConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class CellRendererAttribute extends BaseConcept implements IComponentPart {
  public static final String concept = "jetbrains.mps.uiLanguage.structure.CellRendererAttribute";
  public static String SHORT_DESCRIPTION = "shortDescription";
  public static String ALIAS = "alias";
  public static String VIRTUAL_PACKAGE = "virtualPackage";
  public static String RENDERER = "renderer";
  public static String BINDING = "binding";

  public CellRendererAttribute(SNode node) {
    super(node);
  }

  public static CellRendererAttribute newInstance(SModel sm, boolean init) {
    return (CellRendererAttribute) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.uiLanguage.structure.CellRendererAttribute", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static CellRendererAttribute newInstance(SModel sm) {
    return CellRendererAttribute.newInstance(sm, false);
  }


  public String getShortDescription() {
    return this.getProperty(CellRendererAttribute.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(CellRendererAttribute.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(CellRendererAttribute.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(CellRendererAttribute.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(CellRendererAttribute.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(CellRendererAttribute.VIRTUAL_PACKAGE, value);
  }

  public ComponentDeclaration getRenderer() {
    return (ComponentDeclaration) this.getReferent(CellRendererAttribute.RENDERER);
  }

  public void setRenderer(ComponentDeclaration node) {
    super.setReferent(CellRendererAttribute.RENDERER, node);
  }

  public BindExpression getBinding() {
    return (BindExpression) this.getChild(CellRendererAttribute.BINDING);
  }

  public void setBinding(BindExpression node) {
    super.setChild(CellRendererAttribute.BINDING, node);
  }

}
