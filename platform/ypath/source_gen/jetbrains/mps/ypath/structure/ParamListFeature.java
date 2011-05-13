package jetbrains.mps.ypath.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.structure.Type;
import java.util.Iterator;
import jetbrains.mps.lang.core.structure.Attribute;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ParamListFeature extends ListFeature implements IParamFeature {
  public static final String concept = "jetbrains.mps.ypath.structure.ParamListFeature";
  public static final String NAME = "name";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String WRITABLE = "writable";
  public static final String DEFAULT = "default";
  public static final String ASCENDING = "ascending";
  public static final String OPPOSITE = "opposite";
  public static final String PARAMETER_TYPE = "parameterType";
  public static final String PARAMETER_QUERY_FUNCTION = "parameterQueryFunction";
  public static final String TARGET_TYPE_FUNCTION = "targetTypeFunction";
  public static final String TO_STRING_FUNCTION = "toStringFunction";
  public static final String CARDINAL = "cardinal";
  public static final String SMODEL_ATTRIBUTE = "smodelAttribute";

  public ParamListFeature(SNode node) {
    super(node);
  }

  public String getName() {
    return this.getProperty(ParamListFeature.NAME);
  }

  public void setName(String value) {
    this.setProperty(ParamListFeature.NAME, value);
  }

  public String getShortDescription() {
    return this.getProperty(ParamListFeature.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(ParamListFeature.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(ParamListFeature.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(ParamListFeature.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(ParamListFeature.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(ParamListFeature.VIRTUAL_PACKAGE, value);
  }

  public boolean getWritable() {
    return this.getBooleanProperty(ParamListFeature.WRITABLE);
  }

  public void setWritable(boolean value) {
    this.setBooleanProperty(ParamListFeature.WRITABLE, value);
  }

  public boolean getDefault() {
    return this.getBooleanProperty(ParamListFeature.DEFAULT);
  }

  public void setDefault(boolean value) {
    this.setBooleanProperty(ParamListFeature.DEFAULT, value);
  }

  public boolean getAscending() {
    return this.getBooleanProperty(ParamListFeature.ASCENDING);
  }

  public void setAscending(boolean value) {
    this.setBooleanProperty(ParamListFeature.ASCENDING, value);
  }

  public IFeature getOpposite() {
    return (IFeature) this.getReferent(IFeature.class, ParamListFeature.OPPOSITE);
  }

  public void setOpposite(IFeature node) {
    super.setReferent(ParamListFeature.OPPOSITE, node);
  }

  public Type getParameterType() {
    return (Type) this.getChild(Type.class, ParamListFeature.PARAMETER_TYPE);
  }

  public void setParameterType(Type node) {
    super.setChild(ParamListFeature.PARAMETER_TYPE, node);
  }

  public ParameterQueryFun getParameterQueryFunction() {
    return (ParameterQueryFun) this.getChild(ParameterQueryFun.class, ParamListFeature.PARAMETER_QUERY_FUNCTION);
  }

  public void setParameterQueryFunction(ParameterQueryFun node) {
    super.setChild(ParamListFeature.PARAMETER_QUERY_FUNCTION, node);
  }

  public TargetTypeFun getTargetTypeFunction() {
    return (TargetTypeFun) this.getChild(TargetTypeFun.class, ParamListFeature.TARGET_TYPE_FUNCTION);
  }

  public void setTargetTypeFunction(TargetTypeFun node) {
    super.setChild(ParamListFeature.TARGET_TYPE_FUNCTION, node);
  }

  public ToStringFun getToStringFunction() {
    return (ToStringFun) this.getChild(ToStringFun.class, ParamListFeature.TO_STRING_FUNCTION);
  }

  public void setToStringFunction(ToStringFun node) {
    super.setChild(ParamListFeature.TO_STRING_FUNCTION, node);
  }

  public GFCardinalParamFun getCardinal() {
    return (GFCardinalParamFun) this.getChild(GFCardinalParamFun.class, ParamListFeature.CARDINAL);
  }

  public void setCardinal(GFCardinalParamFun node) {
    super.setChild(ParamListFeature.CARDINAL, node);
  }

  public int getSmodelAttributesCount() {
    return this.getChildCount(ParamListFeature.SMODEL_ATTRIBUTE);
  }

  public Iterator<Attribute> smodelAttributes() {
    return this.children(Attribute.class, ParamListFeature.SMODEL_ATTRIBUTE);
  }

  public List<Attribute> getSmodelAttributes() {
    return this.getChildren(Attribute.class, ParamListFeature.SMODEL_ATTRIBUTE);
  }

  public void addSmodelAttribute(Attribute node) {
    this.addChild(ParamListFeature.SMODEL_ATTRIBUTE, node);
  }

  public void insertSmodelAttribute(Attribute prev, Attribute node) {
    this.insertChild(prev, ParamListFeature.SMODEL_ATTRIBUTE, node);
  }

  public static ParamListFeature newInstance(SModel sm, boolean init) {
    return (ParamListFeature) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.ypath.structure.ParamListFeature", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ParamListFeature newInstance(SModel sm) {
    return ParamListFeature.newInstance(sm, false);
  }
}
