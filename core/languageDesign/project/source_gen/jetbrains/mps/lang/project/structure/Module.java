package jetbrains.mps.lang.project.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.lang.core.structure.INamedConcept;
import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import java.util.List;
import jetbrains.mps.lang.core.structure.Attribute;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class Module extends BaseConcept implements INamedConcept {
  public static final String concept = "jetbrains.mps.lang.project.structure.Module";
  public static final String UUID = "uuid";
  public static final String NAMESPACE = "namespace";
  public static final String NAME = "name";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String COMPILE_IN_M_P_S = "compileInMPS";
  public static final String MODEL = "model";
  public static final String DEPENDENCY = "dependency";
  public static final String _$ATTRIBUTE = "_$attribute";

  public Module(SNode node) {
    super(node);
  }

  public String getUuid() {
    return this.getProperty(Module.UUID);
  }

  public void setUuid(String value) {
    this.setProperty(Module.UUID, value);
  }

  public String getNamespace() {
    return this.getProperty(Module.NAMESPACE);
  }

  public void setNamespace(String value) {
    this.setProperty(Module.NAMESPACE, value);
  }

  public String getName() {
    return this.getProperty(Module.NAME);
  }

  public void setName(String value) {
    this.setProperty(Module.NAME, value);
  }

  public String getShortDescription() {
    return this.getProperty(Module.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(Module.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(Module.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(Module.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(Module.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(Module.VIRTUAL_PACKAGE, value);
  }

  public boolean getCompileInMPS() {
    return this.getBooleanProperty(Module.COMPILE_IN_M_P_S);
  }

  public void setCompileInMPS(boolean value) {
    this.setBooleanProperty(Module.COMPILE_IN_M_P_S, value);
  }

  public int getModelsCount() {
    return this.getChildCount(Module.MODEL);
  }

  public Iterator<ModelReference> models() {
    return this.children(ModelReference.class, Module.MODEL);
  }

  public List<ModelReference> getModels() {
    return this.getChildren(ModelReference.class, Module.MODEL);
  }

  public void addModel(ModelReference node) {
    this.addChild(Module.MODEL, node);
  }

  public void insertModel(ModelReference prev, ModelReference node) {
    this.insertChild(prev, Module.MODEL, node);
  }

  public int getDependenciesCount() {
    return this.getChildCount(Module.DEPENDENCY);
  }

  public Iterator<ModuleDependency> dependencies() {
    return this.children(ModuleDependency.class, Module.DEPENDENCY);
  }

  public List<ModuleDependency> getDependencies() {
    return this.getChildren(ModuleDependency.class, Module.DEPENDENCY);
  }

  public void addDependency(ModuleDependency node) {
    this.addChild(Module.DEPENDENCY, node);
  }

  public void insertDependency(ModuleDependency prev, ModuleDependency node) {
    this.insertChild(prev, Module.DEPENDENCY, node);
  }

  public int get_$attributesCount() {
    return this.getChildCount(Module._$ATTRIBUTE);
  }

  public Iterator<Attribute> _$attributes() {
    return this.children(Attribute.class, Module._$ATTRIBUTE);
  }

  public List<Attribute> get_$attributes() {
    return this.getChildren(Attribute.class, Module._$ATTRIBUTE);
  }

  public void add_$attribute(Attribute node) {
    this.addChild(Module._$ATTRIBUTE, node);
  }

  public void insert_$attribute(Attribute prev, Attribute node) {
    this.insertChild(prev, Module._$ATTRIBUTE, node);
  }

  public static Module newInstance(SModel sm, boolean init) {
    return (Module) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.project.structure.Module", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static Module newInstance(SModel sm) {
    return Module.newInstance(sm, false);
  }
}
