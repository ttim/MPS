package jetbrains.mps.debug.customViewers.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.lang.core.structure.INamedConcept;
import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class CustomWatchablesContainer extends BaseConcept implements INamedConcept {
  public static final String concept = "jetbrains.mps.debug.customViewers.structure.CustomWatchablesContainer";
  public static final String NAME = "name";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String WATCHABLE = "watchable";

  public CustomWatchablesContainer(SNode node) {
    super(node);
  }

  public String getName() {
    return this.getProperty(CustomWatchablesContainer.NAME);
  }

  public void setName(String value) {
    this.setProperty(CustomWatchablesContainer.NAME, value);
  }

  public String getShortDescription() {
    return this.getProperty(CustomWatchablesContainer.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(CustomWatchablesContainer.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(CustomWatchablesContainer.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(CustomWatchablesContainer.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(CustomWatchablesContainer.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(CustomWatchablesContainer.VIRTUAL_PACKAGE, value);
  }

  public int getWatchablesCount() {
    return this.getChildCount(CustomWatchablesContainer.WATCHABLE);
  }

  public Iterator<CustomWatchable> watchables() {
    return this.children(CustomWatchable.class, CustomWatchablesContainer.WATCHABLE);
  }

  public List<CustomWatchable> getWatchables() {
    return this.getChildren(CustomWatchable.class, CustomWatchablesContainer.WATCHABLE);
  }

  public void addWatchable(CustomWatchable node) {
    this.addChild(CustomWatchablesContainer.WATCHABLE, node);
  }

  public void insertWatchable(CustomWatchable prev, CustomWatchable node) {
    this.insertChild(prev, CustomWatchablesContainer.WATCHABLE, node);
  }

  public static CustomWatchablesContainer newInstance(SModel sm, boolean init) {
    return (CustomWatchablesContainer) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.debug.customViewers.structure.CustomWatchablesContainer", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static CustomWatchablesContainer newInstance(SModel sm) {
    return CustomWatchablesContainer.newInstance(sm, false);
  }
}
