package jetbrains.mps.baseLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.core.structure.NamedConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.baseLanguage.structure.Type;
import jetbrains.mps.baseLanguage.structure.StatementList;
import java.util.Iterator;
import jetbrains.mps.baseLanguage.structure.ParameterDeclaration;
import java.util.List;
import jetbrains.mps.baseLanguage.structure.ClassifierType;

public class BaseMethodDeclaration extends NamedConcept {
  public static String NAME = "name";
  public static String RETURN_TYPE = "returnType";
  public static String BODY = "body";
  public static String PARAMETER = "parameter";
  public static String THROWS_ITEM = "throwsItem";

  public  BaseMethodDeclaration(SNode node) {
    super(node);
  }

  public static BaseMethodDeclaration newInstance(SModel sm, boolean init) {
    return (BaseMethodDeclaration)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.BaseMethodDeclaration", sm, GlobalScope.getInstance(), init).getAdapter();
  }
  public static BaseMethodDeclaration newInstance(SModel sm) {
    return BaseMethodDeclaration.newInstance(sm, false);
  }

  public String getName() {
    return this.getProperty(BaseMethodDeclaration.NAME);
  }
  public void setName(String value) {
    this.setProperty(BaseMethodDeclaration.NAME, value);
  }
  public Type getReturnType() {
    return (Type)this.getChild(BaseMethodDeclaration.RETURN_TYPE);
  }
  public void setReturnType(Type node) {
    super.setChild(BaseMethodDeclaration.RETURN_TYPE, node);
  }
  public StatementList getBody() {
    return (StatementList)this.getChild(BaseMethodDeclaration.BODY);
  }
  public void setBody(StatementList node) {
    super.setChild(BaseMethodDeclaration.BODY, node);
  }
  public int getParametersCount() {
    return this.getChildCount(BaseMethodDeclaration.PARAMETER);
  }
  public Iterator<ParameterDeclaration> parameters() {
    return this.children(BaseMethodDeclaration.PARAMETER);
  }
  public List<ParameterDeclaration> getParameters() {
    return this.getChildren(BaseMethodDeclaration.PARAMETER);
  }
  public void addParameter(ParameterDeclaration node) {
    this.addChild(BaseMethodDeclaration.PARAMETER, node);
  }
  public void insertParameter(ParameterDeclaration prev, ParameterDeclaration node) {
    this.insertChild(prev, BaseMethodDeclaration.PARAMETER, node);
  }
  public int getThrowsItemsCount() {
    return this.getChildCount(BaseMethodDeclaration.THROWS_ITEM);
  }
  public Iterator<ClassifierType> throwsItems() {
    return this.children(BaseMethodDeclaration.THROWS_ITEM);
  }
  public List<ClassifierType> getThrowsItems() {
    return this.getChildren(BaseMethodDeclaration.THROWS_ITEM);
  }
  public void addThrowsItem(ClassifierType node) {
    this.addChild(BaseMethodDeclaration.THROWS_ITEM, node);
  }
  public void insertThrowsItem(ClassifierType prev, ClassifierType node) {
    this.insertChild(prev, BaseMethodDeclaration.THROWS_ITEM, node);
  }
}
