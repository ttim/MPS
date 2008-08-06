package jetbrains.mps.baseLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.core.structure.BaseConcept;
import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class VariableDeclaration extends BaseConcept implements IValidIdentifier, HasAnnotation, TypeDerivable {
  public static final String concept = "jetbrains.mps.baseLanguage.structure.VariableDeclaration";
  public static String NAME = "name";
  public static String SHORT_DESCRIPTION = "shortDescription";
  public static String ALIAS = "alias";
  public static String VIRTUAL_PACKAGE = "virtualPackage";
  public static String IS_FINAL = "isFinal";
  public static String TYPE = "type";
  public static String INITIALIZER = "initializer";
  public static String ANNOTATION = "annotation";

  public VariableDeclaration(SNode node) {
    super(node);
  }

  public String getName() {
    return this.getProperty(VariableDeclaration.NAME);
  }

  public void setName(String value) {
    this.setProperty(VariableDeclaration.NAME, value);
  }

  public String getShortDescription() {
    return this.getProperty(VariableDeclaration.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(VariableDeclaration.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(VariableDeclaration.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(VariableDeclaration.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(VariableDeclaration.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(VariableDeclaration.VIRTUAL_PACKAGE, value);
  }

  public boolean getIsFinal() {
    return this.getBooleanProperty(VariableDeclaration.IS_FINAL);
  }

  public void setIsFinal(boolean value) {
    this.setBooleanProperty(VariableDeclaration.IS_FINAL, value);
  }

  public Type getType() {
    return (Type)this.getChild(VariableDeclaration.TYPE);
  }

  public void setType(Type node) {
    super.setChild(VariableDeclaration.TYPE, node);
  }

  public Expression getInitializer() {
    return (Expression)this.getChild(VariableDeclaration.INITIALIZER);
  }

  public void setInitializer(Expression node) {
    super.setChild(VariableDeclaration.INITIALIZER, node);
  }

  public int getAnnotationsCount() {
    return this.getChildCount(VariableDeclaration.ANNOTATION);
  }

  public Iterator<AnnotationInstance> annotations() {
    return this.children(VariableDeclaration.ANNOTATION);
  }

  public List<AnnotationInstance> getAnnotations() {
    return this.getChildren(VariableDeclaration.ANNOTATION);
  }

  public void addAnnotation(AnnotationInstance node) {
    this.addChild(VariableDeclaration.ANNOTATION, node);
  }

  public void insertAnnotation(AnnotationInstance prev, AnnotationInstance node) {
    this.insertChild(prev, VariableDeclaration.ANNOTATION, node);
  }


  public static VariableDeclaration newInstance(SModel sm, boolean init) {
    return (VariableDeclaration)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.VariableDeclaration", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static VariableDeclaration newInstance(SModel sm) {
    return VariableDeclaration.newInstance(sm, false);
  }

}
