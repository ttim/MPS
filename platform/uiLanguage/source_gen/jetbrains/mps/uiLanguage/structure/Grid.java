package jetbrains.mps.uiLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class Grid extends BaseConcept implements IComponentInstance {
  public static final String concept = "jetbrains.mps.uiLanguage.structure.Grid";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String ROW = "row";
  public static final String CONTENT = "content";

  public Grid(SNode node) {
    super(node);
  }

  public String getShortDescription() {
    return this.getProperty(Grid.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(Grid.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(Grid.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(Grid.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(Grid.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(Grid.VIRTUAL_PACKAGE, value);
  }

  public int getRowsCount() {
    return this.getChildCount(Grid.ROW);
  }

  public Iterator<GridRow> rows() {
    return this.children(GridRow.class, Grid.ROW);
  }

  public List<GridRow> getRows() {
    return this.getChildren(GridRow.class, Grid.ROW);
  }

  public void addRow(GridRow node) {
    this.addChild(Grid.ROW, node);
  }

  public void insertRow(GridRow prev, GridRow node) {
    this.insertChild(prev, Grid.ROW, node);
  }

  public int getContentsCount() {
    return this.getChildCount(Grid.CONTENT);
  }

  public Iterator<IComponentPart> contents() {
    return this.children(IComponentPart.class, Grid.CONTENT);
  }

  public List<IComponentPart> getContents() {
    return this.getChildren(IComponentPart.class, Grid.CONTENT);
  }

  public void addContent(IComponentPart node) {
    this.addChild(Grid.CONTENT, node);
  }

  public void insertContent(IComponentPart prev, IComponentPart node) {
    this.insertChild(prev, Grid.CONTENT, node);
  }

  public static Grid newInstance(SModel sm, boolean init) {
    return (Grid) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.uiLanguage.structure.Grid", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static Grid newInstance(SModel sm) {
    return Grid.newInstance(sm, false);
  }
}
