package jetbrains.mps.baseLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.baseLanguage.structure.IValidIdentifier;
import jetbrains.mps.lang.core.structure.IResolveInfo;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.structure.Type;
import java.util.Iterator;
import jetbrains.mps.baseLanguage.structure.ClassifierType;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class TypeVariableDeclaration extends BaseConcept implements IValidIdentifier, IResolveInfo {
  public static final String concept = "jetbrains.mps.baseLanguage.structure.TypeVariableDeclaration";
  public static final String NAME = "name";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String RESOLVE_INFO = "resolveInfo";
  public static final String EXTENDS = "extends";
  public static final String BOUND = "bound";
  public static final String AUX_BOUNDS = "auxBounds";

  public TypeVariableDeclaration(SNode node) {
    super(node);
  }

  public String getName() {
    return this.getProperty(TypeVariableDeclaration.NAME);
  }

  public void setName(String value) {
    this.setProperty(TypeVariableDeclaration.NAME, value);
  }

  public String getShortDescription() {
    return this.getProperty(TypeVariableDeclaration.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(TypeVariableDeclaration.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(TypeVariableDeclaration.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(TypeVariableDeclaration.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(TypeVariableDeclaration.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(TypeVariableDeclaration.VIRTUAL_PACKAGE, value);
  }

  public String getResolveInfo() {
    return this.getProperty(TypeVariableDeclaration.RESOLVE_INFO);
  }

  public void setResolveInfo(String value) {
    this.setProperty(TypeVariableDeclaration.RESOLVE_INFO, value);
  }

  public boolean getExtends() {
    return this.getBooleanProperty(TypeVariableDeclaration.EXTENDS);
  }

  public void setExtends(boolean value) {
    this.setBooleanProperty(TypeVariableDeclaration.EXTENDS, value);
  }

  public Type getBound() {
    return (Type)this.getChild(Type.class, TypeVariableDeclaration.BOUND);
  }

  public void setBound(Type node) {
    super.setChild(TypeVariableDeclaration.BOUND, node);
  }

  public int getAuxBoundsesCount() {
    return this.getChildCount(TypeVariableDeclaration.AUX_BOUNDS);
  }

  public Iterator<ClassifierType> auxBoundses() {
    return this.children(ClassifierType.class, TypeVariableDeclaration.AUX_BOUNDS);
  }

  public List<ClassifierType> getAuxBoundses() {
    return this.getChildren(ClassifierType.class, TypeVariableDeclaration.AUX_BOUNDS);
  }

  public void addAuxBounds(ClassifierType node) {
    this.addChild(TypeVariableDeclaration.AUX_BOUNDS, node);
  }

  public void insertAuxBounds(ClassifierType prev, ClassifierType node) {
    this.insertChild(prev, TypeVariableDeclaration.AUX_BOUNDS, node);
  }


  public static TypeVariableDeclaration newInstance(SModel sm, boolean init) {
    return (TypeVariableDeclaration)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.TypeVariableDeclaration", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static TypeVariableDeclaration newInstance(SModel sm) {
    return TypeVariableDeclaration.newInstance(sm, false);
  }

}
