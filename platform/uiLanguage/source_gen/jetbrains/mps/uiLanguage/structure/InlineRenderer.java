package jetbrains.mps.uiLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.uiLanguage.structure.IComponentPart;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.uiLanguage.structure.ComponentInstance;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class InlineRenderer extends BaseConcept implements IComponentPart {
  public static final String concept = "jetbrains.mps.uiLanguage.structure.InlineRenderer";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String RENDERER = "renderer";

  public InlineRenderer(SNode node) {
    super(node);
  }

  public String getShortDescription() {
    return this.getProperty(InlineRenderer.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(InlineRenderer.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(InlineRenderer.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(InlineRenderer.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(InlineRenderer.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(InlineRenderer.VIRTUAL_PACKAGE, value);
  }

  public ComponentInstance getRenderer() {
    return (ComponentInstance)this.getChild(ComponentInstance.class, InlineRenderer.RENDERER);
  }

  public void setRenderer(ComponentInstance node) {
    super.setChild(InlineRenderer.RENDERER, node);
  }


  public static InlineRenderer newInstance(SModel sm, boolean init) {
    return (InlineRenderer)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.uiLanguage.structure.InlineRenderer", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static InlineRenderer newInstance(SModel sm) {
    return InlineRenderer.newInstance(sm, false);
  }

}
