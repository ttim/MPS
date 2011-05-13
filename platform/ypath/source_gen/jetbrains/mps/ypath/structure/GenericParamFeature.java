package jetbrains.mps.ypath.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.lang.core.structure.INamedConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.structure.Type;
import java.util.Iterator;
import jetbrains.mps.lang.core.structure.Attribute;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class GenericParamFeature extends BaseConcept implements IGenericFeature, INamedConcept, IFeature, IParamFeature {
  public static final String concept = "jetbrains.mps.ypath.structure.GenericParamFeature";
  public static final String NAME = "name";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String WRITABLE = "writable";
  public static final String DEFAULT = "default";
  public static final String ASCENDING = "ascending";
  public static final String OPPOSITE = "opposite";
  public static final String GETTER = "getter";
  public static final String PARAMETER_TYPE = "parameterType";
  public static final String PARAMETER_QUERY_FUNCTION = "parameterQueryFunction";
  public static final String TARGET_TYPE_FUNCTION = "targetTypeFunction";
  public static final String TO_STRING_FUNCTION = "toStringFunction";
  public static final String CARDINAL = "cardinal";
  public static final String SMODEL_ATTRIBUTE = "smodelAttribute";

  public GenericParamFeature(SNode node) {
    super(node);
  }

  public String getName() {
    return this.getProperty(GenericParamFeature.NAME);
  }

  public void setName(String value) {
    this.setProperty(GenericParamFeature.NAME, value);
  }

  public String getShortDescription() {
    return this.getProperty(GenericParamFeature.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(GenericParamFeature.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(GenericParamFeature.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(GenericParamFeature.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(GenericParamFeature.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(GenericParamFeature.VIRTUAL_PACKAGE, value);
  }

  public boolean getWritable() {
    return this.getBooleanProperty(GenericParamFeature.WRITABLE);
  }

  public void setWritable(boolean value) {
    this.setBooleanProperty(GenericParamFeature.WRITABLE, value);
  }

  public boolean getDefault() {
    return this.getBooleanProperty(GenericParamFeature.DEFAULT);
  }

  public void setDefault(boolean value) {
    this.setBooleanProperty(GenericParamFeature.DEFAULT, value);
  }

  public boolean getAscending() {
    return this.getBooleanProperty(GenericParamFeature.ASCENDING);
  }

  public void setAscending(boolean value) {
    this.setBooleanProperty(GenericParamFeature.ASCENDING, value);
  }

  public IFeature getOpposite() {
    return (IFeature) this.getReferent(IFeature.class, GenericParamFeature.OPPOSITE);
  }

  public void setOpposite(IFeature node) {
    super.setReferent(GenericParamFeature.OPPOSITE, node);
  }

  public GFGetterFun getGetter() {
    return (GFGetterFun) this.getChild(GFGetterFun.class, GenericParamFeature.GETTER);
  }

  public void setGetter(GFGetterFun node) {
    super.setChild(GenericParamFeature.GETTER, node);
  }

  public Type getParameterType() {
    return (Type) this.getChild(Type.class, GenericParamFeature.PARAMETER_TYPE);
  }

  public void setParameterType(Type node) {
    super.setChild(GenericParamFeature.PARAMETER_TYPE, node);
  }

  public ParameterQueryFun getParameterQueryFunction() {
    return (ParameterQueryFun) this.getChild(ParameterQueryFun.class, GenericParamFeature.PARAMETER_QUERY_FUNCTION);
  }

  public void setParameterQueryFunction(ParameterQueryFun node) {
    super.setChild(GenericParamFeature.PARAMETER_QUERY_FUNCTION, node);
  }

  public TargetTypeFun getTargetTypeFunction() {
    return (TargetTypeFun) this.getChild(TargetTypeFun.class, GenericParamFeature.TARGET_TYPE_FUNCTION);
  }

  public void setTargetTypeFunction(TargetTypeFun node) {
    super.setChild(GenericParamFeature.TARGET_TYPE_FUNCTION, node);
  }

  public ToStringFun getToStringFunction() {
    return (ToStringFun) this.getChild(ToStringFun.class, GenericParamFeature.TO_STRING_FUNCTION);
  }

  public void setToStringFunction(ToStringFun node) {
    super.setChild(GenericParamFeature.TO_STRING_FUNCTION, node);
  }

  public GFCardinalParamFun getCardinal() {
    return (GFCardinalParamFun) this.getChild(GFCardinalParamFun.class, GenericParamFeature.CARDINAL);
  }

  public void setCardinal(GFCardinalParamFun node) {
    super.setChild(GenericParamFeature.CARDINAL, node);
  }

  public int getSmodelAttributesCount() {
    return this.getChildCount(GenericParamFeature.SMODEL_ATTRIBUTE);
  }

  public Iterator<Attribute> smodelAttributes() {
    return this.children(Attribute.class, GenericParamFeature.SMODEL_ATTRIBUTE);
  }

  public List<Attribute> getSmodelAttributes() {
    return this.getChildren(Attribute.class, GenericParamFeature.SMODEL_ATTRIBUTE);
  }

  public void addSmodelAttribute(Attribute node) {
    this.addChild(GenericParamFeature.SMODEL_ATTRIBUTE, node);
  }

  public void insertSmodelAttribute(Attribute prev, Attribute node) {
    this.insertChild(prev, GenericParamFeature.SMODEL_ATTRIBUTE, node);
  }

  public static GenericParamFeature newInstance(SModel sm, boolean init) {
    return (GenericParamFeature) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.ypath.structure.GenericParamFeature", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static GenericParamFeature newInstance(SModel sm) {
    return GenericParamFeature.newInstance(sm, false);
  }
}
