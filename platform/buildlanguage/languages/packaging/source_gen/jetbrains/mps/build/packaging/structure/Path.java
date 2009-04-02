package jetbrains.mps.build.packaging.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.build.packaging.structure.IPath;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.build.packaging.structure.MacroReference;
import jetbrains.mps.build.packaging.structure.CompositePathComponent;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class Path extends BaseConcept implements IPath {
  public static final String concept = "jetbrains.mps.build.packaging.structure.Path";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String MACRO = "macro";
  public static final String COMPOSITE_PATH_COMPONENT = "compositePathComponent";

  public Path(SNode node) {
    super(node);
  }

  public String getShortDescription() {
    return this.getProperty(Path.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(Path.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(Path.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(Path.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(Path.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(Path.VIRTUAL_PACKAGE, value);
  }

  public MacroReference getMacro() {
    return (MacroReference)this.getChild(MacroReference.class, Path.MACRO);
  }

  public void setMacro(MacroReference node) {
    super.setChild(Path.MACRO, node);
  }

  public CompositePathComponent getCompositePathComponent() {
    return (CompositePathComponent)this.getChild(CompositePathComponent.class, Path.COMPOSITE_PATH_COMPONENT);
  }

  public void setCompositePathComponent(CompositePathComponent node) {
    super.setChild(Path.COMPOSITE_PATH_COMPONENT, node);
  }


  public static Path newInstance(SModel sm, boolean init) {
    return (Path)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.build.packaging.structure.Path", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static Path newInstance(SModel sm) {
    return Path.newInstance(sm, false);
  }

}
