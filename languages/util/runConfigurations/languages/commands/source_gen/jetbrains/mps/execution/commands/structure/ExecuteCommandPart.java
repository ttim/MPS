package jetbrains.mps.execution.commands.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.lang.core.structure.INamedConcept;
import jetbrains.mps.baseLanguage.structure.IMethodLike;
import jetbrains.mps.lang.structure.structure.IStructureDeprecatable;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.structure.BlockStatement;
import java.util.Iterator;
import java.util.List;
import jetbrains.mps.lang.core.structure.Attribute;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ExecuteCommandPart extends BaseConcept implements INamedConcept, IMethodLike, IStructureDeprecatable {
  public static final String concept = "jetbrains.mps.execution.commands.structure.ExecuteCommandPart";
  public static final String NAME = "name";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String EXECUTE = "execute";
  public static final String PARAMETER_DECLARATION = "parameterDeclaration";
  public static final String SMODEL_ATTRIBUTE = "smodelAttribute";

  public ExecuteCommandPart(SNode node) {
    super(node);
  }

  public String getName() {
    return this.getProperty(ExecuteCommandPart.NAME);
  }

  public void setName(String value) {
    this.setProperty(ExecuteCommandPart.NAME, value);
  }

  public String getShortDescription() {
    return this.getProperty(ExecuteCommandPart.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(ExecuteCommandPart.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(ExecuteCommandPart.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(ExecuteCommandPart.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(ExecuteCommandPart.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(ExecuteCommandPart.VIRTUAL_PACKAGE, value);
  }

  public BlockStatement getExecute() {
    return (BlockStatement) this.getChild(BlockStatement.class, ExecuteCommandPart.EXECUTE);
  }

  public void setExecute(BlockStatement node) {
    super.setChild(ExecuteCommandPart.EXECUTE, node);
  }

  public int getParameterDeclarationsCount() {
    return this.getChildCount(ExecuteCommandPart.PARAMETER_DECLARATION);
  }

  public Iterator<ExplicitCommandParameterDeclaration> parameterDeclarations() {
    return this.children(ExplicitCommandParameterDeclaration.class, ExecuteCommandPart.PARAMETER_DECLARATION);
  }

  public List<ExplicitCommandParameterDeclaration> getParameterDeclarations() {
    return this.getChildren(ExplicitCommandParameterDeclaration.class, ExecuteCommandPart.PARAMETER_DECLARATION);
  }

  public void addParameterDeclaration(ExplicitCommandParameterDeclaration node) {
    this.addChild(ExecuteCommandPart.PARAMETER_DECLARATION, node);
  }

  public void insertParameterDeclaration(ExplicitCommandParameterDeclaration prev, ExplicitCommandParameterDeclaration node) {
    this.insertChild(prev, ExecuteCommandPart.PARAMETER_DECLARATION, node);
  }

  public int getSmodelAttributesCount() {
    return this.getChildCount(ExecuteCommandPart.SMODEL_ATTRIBUTE);
  }

  public Iterator<Attribute> smodelAttributes() {
    return this.children(Attribute.class, ExecuteCommandPart.SMODEL_ATTRIBUTE);
  }

  public List<Attribute> getSmodelAttributes() {
    return this.getChildren(Attribute.class, ExecuteCommandPart.SMODEL_ATTRIBUTE);
  }

  public void addSmodelAttribute(Attribute node) {
    this.addChild(ExecuteCommandPart.SMODEL_ATTRIBUTE, node);
  }

  public void insertSmodelAttribute(Attribute prev, Attribute node) {
    this.insertChild(prev, ExecuteCommandPart.SMODEL_ATTRIBUTE, node);
  }

  public static ExecuteCommandPart newInstance(SModel sm, boolean init) {
    return (ExecuteCommandPart) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.execution.commands.structure.ExecuteCommandPart", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ExecuteCommandPart newInstance(SModel sm) {
    return ExecuteCommandPart.newInstance(sm, false);
  }
}
