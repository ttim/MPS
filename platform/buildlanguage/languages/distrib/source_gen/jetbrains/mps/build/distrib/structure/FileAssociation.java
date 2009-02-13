package jetbrains.mps.build.distrib.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.lang.core.structure.INamedConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class FileAssociation extends BaseConcept implements INamedConcept {
  public static final String concept = "jetbrains.mps.build.distrib.structure.FileAssociation";
  public static final String EXTENSIONS = "extensions";
  public static final String NAME = "name";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String ICON = "icon";

  public FileAssociation(SNode node) {
    super(node);
  }

  public String getExtensions() {
    return this.getProperty(FileAssociation.EXTENSIONS);
  }

  public void setExtensions(String value) {
    this.setProperty(FileAssociation.EXTENSIONS, value);
  }

  public String getName() {
    return this.getProperty(FileAssociation.NAME);
  }

  public void setName(String value) {
    this.setProperty(FileAssociation.NAME, value);
  }

  public String getShortDescription() {
    return this.getProperty(FileAssociation.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(FileAssociation.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(FileAssociation.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(FileAssociation.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(FileAssociation.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(FileAssociation.VIRTUAL_PACKAGE, value);
  }

  public AbstractPath getIcon() {
    return (AbstractPath)this.getChild(AbstractPath.class, FileAssociation.ICON);
  }

  public void setIcon(AbstractPath node) {
    super.setChild(FileAssociation.ICON, node);
  }


  public static FileAssociation newInstance(SModel sm, boolean init) {
    return (FileAssociation)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.build.distrib.structure.FileAssociation", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static FileAssociation newInstance(SModel sm) {
    return FileAssociation.newInstance(sm, false);
  }

}
