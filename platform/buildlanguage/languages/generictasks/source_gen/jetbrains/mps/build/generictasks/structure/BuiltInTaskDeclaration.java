package jetbrains.mps.build.generictasks.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class BuiltInTaskDeclaration extends BaseConcept implements ITaskDeclaration {
  public static final String concept = "jetbrains.mps.build.generictasks.structure.BuiltInTaskDeclaration";
  public static final String CLASSNAME = "classname";
  public static final String NAME = "name";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String FAKE = "fake";
  public static final String CAN_HAVE_INTERNAL_TEXT = "canHaveInternalText";
  public static final String ABSTRACT = "abstract";
  public static final String DEPRACATED = "depracated";
  public static final String PARENT_REF = "parentRef";
  public static final String NESTED = "nested";
  public static final String FAKE_DECLARATION = "fakeDeclaration";
  public static final String ATTRIBUTES_DECL = "attributesDecl";
  public static final String INTERFACES = "interfaces";

  public BuiltInTaskDeclaration(SNode node) {
    super(node);
  }

  public String getClassname() {
    return this.getProperty(BuiltInTaskDeclaration.CLASSNAME);
  }

  public void setClassname(String value) {
    this.setProperty(BuiltInTaskDeclaration.CLASSNAME, value);
  }

  public String getName() {
    return this.getProperty(BuiltInTaskDeclaration.NAME);
  }

  public void setName(String value) {
    this.setProperty(BuiltInTaskDeclaration.NAME, value);
  }

  public String getShortDescription() {
    return this.getProperty(BuiltInTaskDeclaration.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(BuiltInTaskDeclaration.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(BuiltInTaskDeclaration.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(BuiltInTaskDeclaration.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(BuiltInTaskDeclaration.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(BuiltInTaskDeclaration.VIRTUAL_PACKAGE, value);
  }

  public boolean getFake() {
    return this.getBooleanProperty(BuiltInTaskDeclaration.FAKE);
  }

  public void setFake(boolean value) {
    this.setBooleanProperty(BuiltInTaskDeclaration.FAKE, value);
  }

  public boolean getCanHaveInternalText() {
    return this.getBooleanProperty(BuiltInTaskDeclaration.CAN_HAVE_INTERNAL_TEXT);
  }

  public void setCanHaveInternalText(boolean value) {
    this.setBooleanProperty(BuiltInTaskDeclaration.CAN_HAVE_INTERNAL_TEXT, value);
  }

  public boolean getAbstract() {
    return this.getBooleanProperty(BuiltInTaskDeclaration.ABSTRACT);
  }

  public void setAbstract(boolean value) {
    this.setBooleanProperty(BuiltInTaskDeclaration.ABSTRACT, value);
  }

  public boolean getDepracated() {
    return this.getBooleanProperty(BuiltInTaskDeclaration.DEPRACATED);
  }

  public void setDepracated(boolean value) {
    this.setBooleanProperty(BuiltInTaskDeclaration.DEPRACATED, value);
  }

  public TaskReference getParentRef() {
    return (TaskReference)this.getChild(TaskReference.class, BuiltInTaskDeclaration.PARENT_REF);
  }

  public void setParentRef(TaskReference node) {
    super.setChild(BuiltInTaskDeclaration.PARENT_REF, node);
  }

  public int getNestedsCount() {
    return this.getChildCount(BuiltInTaskDeclaration.NESTED);
  }

  public Iterator<NestedDeclaration> nesteds() {
    return this.children(NestedDeclaration.class, BuiltInTaskDeclaration.NESTED);
  }

  public List<NestedDeclaration> getNesteds() {
    return this.getChildren(NestedDeclaration.class, BuiltInTaskDeclaration.NESTED);
  }

  public void addNested(NestedDeclaration node) {
    this.addChild(BuiltInTaskDeclaration.NESTED, node);
  }

  public void insertNested(NestedDeclaration prev, NestedDeclaration node) {
    this.insertChild(prev, BuiltInTaskDeclaration.NESTED, node);
  }

  public int getFakeDeclarationsCount() {
    return this.getChildCount(BuiltInTaskDeclaration.FAKE_DECLARATION);
  }

  public Iterator<BuiltInTaskDeclaration> fakeDeclarations() {
    return this.children(BuiltInTaskDeclaration.class, BuiltInTaskDeclaration.FAKE_DECLARATION);
  }

  public List<BuiltInTaskDeclaration> getFakeDeclarations() {
    return this.getChildren(BuiltInTaskDeclaration.class, BuiltInTaskDeclaration.FAKE_DECLARATION);
  }

  public void addFakeDeclaration(BuiltInTaskDeclaration node) {
    this.addChild(BuiltInTaskDeclaration.FAKE_DECLARATION, node);
  }

  public void insertFakeDeclaration(BuiltInTaskDeclaration prev, BuiltInTaskDeclaration node) {
    this.insertChild(prev, BuiltInTaskDeclaration.FAKE_DECLARATION, node);
  }

  public int getAttributesDeclsCount() {
    return this.getChildCount(BuiltInTaskDeclaration.ATTRIBUTES_DECL);
  }

  public Iterator<AttributeDeclaration> attributesDecls() {
    return this.children(AttributeDeclaration.class, BuiltInTaskDeclaration.ATTRIBUTES_DECL);
  }

  public List<AttributeDeclaration> getAttributesDecls() {
    return this.getChildren(AttributeDeclaration.class, BuiltInTaskDeclaration.ATTRIBUTES_DECL);
  }

  public void addAttributesDecl(AttributeDeclaration node) {
    this.addChild(BuiltInTaskDeclaration.ATTRIBUTES_DECL, node);
  }

  public void insertAttributesDecl(AttributeDeclaration prev, AttributeDeclaration node) {
    this.insertChild(prev, BuiltInTaskDeclaration.ATTRIBUTES_DECL, node);
  }

  public int getInterfacesesCount() {
    return this.getChildCount(BuiltInTaskDeclaration.INTERFACES);
  }

  public Iterator<TaskReference> interfaceses() {
    return this.children(TaskReference.class, BuiltInTaskDeclaration.INTERFACES);
  }

  public List<TaskReference> getInterfaceses() {
    return this.getChildren(TaskReference.class, BuiltInTaskDeclaration.INTERFACES);
  }

  public void addInterfaces(TaskReference node) {
    this.addChild(BuiltInTaskDeclaration.INTERFACES, node);
  }

  public void insertInterfaces(TaskReference prev, TaskReference node) {
    this.insertChild(prev, BuiltInTaskDeclaration.INTERFACES, node);
  }

  public static BuiltInTaskDeclaration newInstance(SModel sm, boolean init) {
    return (BuiltInTaskDeclaration)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.build.generictasks.structure.BuiltInTaskDeclaration", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static BuiltInTaskDeclaration newInstance(SModel sm) {
    return BuiltInTaskDeclaration.newInstance(sm, false);
  }
}
