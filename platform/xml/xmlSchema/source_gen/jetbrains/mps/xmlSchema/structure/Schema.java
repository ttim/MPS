package jetbrains.mps.xmlSchema.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.lang.core.structure.INamedConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.xmlSchema.structure.ElementReference;
import jetbrains.mps.xmlSchema.structure.NamespaceDeclaration;
import java.util.Iterator;
import jetbrains.mps.xmlSchema.structure.DeclarationBlock;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class Schema extends BaseConcept implements INamedConcept {
  public static final String concept = "jetbrains.mps.xmlSchema.structure.Schema";
  public static final String SCHEMA_NAME = "schemaName";
  public static final String SCHEMA_URL = "schemaUrl";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String NAME = "name";
  public static final String ALWAYS_USE_ROOT = "alwaysUseRoot";
  public static final String ROOT_ELEMENT_REFERENCE = "rootElementReference";
  public static final String DEFAULT_NAMESPACE_DECLARATION = "defaultNamespaceDeclaration";
  public static final String DECLARATION_BLOCK = "declarationBlock";

  public Schema(SNode node) {
    super(node);
  }

  public String getSchemaName() {
    return this.getProperty(Schema.SCHEMA_NAME);
  }

  public void setSchemaName(String value) {
    this.setProperty(Schema.SCHEMA_NAME, value);
  }

  public String getSchemaUrl() {
    return this.getProperty(Schema.SCHEMA_URL);
  }

  public void setSchemaUrl(String value) {
    this.setProperty(Schema.SCHEMA_URL, value);
  }

  public String getShortDescription() {
    return this.getProperty(Schema.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(Schema.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(Schema.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(Schema.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(Schema.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(Schema.VIRTUAL_PACKAGE, value);
  }

  public String getName() {
    return this.getProperty(Schema.NAME);
  }

  public void setName(String value) {
    this.setProperty(Schema.NAME, value);
  }

  public boolean getAlwaysUseRoot() {
    return this.getBooleanProperty(Schema.ALWAYS_USE_ROOT);
  }

  public void setAlwaysUseRoot(boolean value) {
    this.setBooleanProperty(Schema.ALWAYS_USE_ROOT, value);
  }

  public ElementReference getRootElementReference() {
    return (ElementReference)this.getChild(ElementReference.class, Schema.ROOT_ELEMENT_REFERENCE);
  }

  public void setRootElementReference(ElementReference node) {
    super.setChild(Schema.ROOT_ELEMENT_REFERENCE, node);
  }

  public NamespaceDeclaration getDefaultNamespaceDeclaration() {
    return (NamespaceDeclaration)this.getChild(NamespaceDeclaration.class, Schema.DEFAULT_NAMESPACE_DECLARATION);
  }

  public void setDefaultNamespaceDeclaration(NamespaceDeclaration node) {
    super.setChild(Schema.DEFAULT_NAMESPACE_DECLARATION, node);
  }

  public int getDeclarationBlocksCount() {
    return this.getChildCount(Schema.DECLARATION_BLOCK);
  }

  public Iterator<DeclarationBlock> declarationBlocks() {
    return this.children(DeclarationBlock.class, Schema.DECLARATION_BLOCK);
  }

  public List<DeclarationBlock> getDeclarationBlocks() {
    return this.getChildren(DeclarationBlock.class, Schema.DECLARATION_BLOCK);
  }

  public void addDeclarationBlock(DeclarationBlock node) {
    this.addChild(Schema.DECLARATION_BLOCK, node);
  }

  public void insertDeclarationBlock(DeclarationBlock prev, DeclarationBlock node) {
    this.insertChild(prev, Schema.DECLARATION_BLOCK, node);
  }


  public static Schema newInstance(SModel sm, boolean init) {
    return (Schema)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.xmlSchema.structure.Schema", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static Schema newInstance(SModel sm) {
    return Schema.newInstance(sm, false);
  }

}
