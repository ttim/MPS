package jetbrains.mps.lang.actions.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.structure.Type;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ParameterizedSideTransformMenuPart extends SideTransformMenuPart {
  public static final String concept = "jetbrains.mps.lang.actions.structure.ParameterizedSideTransformMenuPart";
  public static final String TYPE = "type";
  public static final String QUERY = "query";
  public static final String MATCHING_TEXT = "matchingText";
  public static final String DESCRIPTION_TEXT = "descriptionText";
  public static final String ICON = "icon";
  public static final String HANDLER = "handler";

  public ParameterizedSideTransformMenuPart(SNode node) {
    super(node);
  }

  public Type getType() {
    return (Type) this.getChild(Type.class, ParameterizedSideTransformMenuPart.TYPE);
  }

  public void setType(Type node) {
    super.setChild(ParameterizedSideTransformMenuPart.TYPE, node);
  }

  public QueryFunction_ParameterizedSideTransform_Query getQuery() {
    return (QueryFunction_ParameterizedSideTransform_Query) this.getChild(QueryFunction_ParameterizedSideTransform_Query.class, ParameterizedSideTransformMenuPart.QUERY);
  }

  public void setQuery(QueryFunction_ParameterizedSideTransform_Query node) {
    super.setChild(ParameterizedSideTransformMenuPart.QUERY, node);
  }

  public ISideTransform_String getMatchingText() {
    return (ISideTransform_String) this.getChild(ISideTransform_String.class, ParameterizedSideTransformMenuPart.MATCHING_TEXT);
  }

  public void setMatchingText(ISideTransform_String node) {
    super.setChild(ParameterizedSideTransformMenuPart.MATCHING_TEXT, node);
  }

  public ISideTransform_String getDescriptionText() {
    return (ISideTransform_String) this.getChild(ISideTransform_String.class, ParameterizedSideTransformMenuPart.DESCRIPTION_TEXT);
  }

  public void setDescriptionText(ISideTransform_String node) {
    super.setChild(ParameterizedSideTransformMenuPart.DESCRIPTION_TEXT, node);
  }

  public QueryFunction_SideTransform_Icon getIcon() {
    return (QueryFunction_SideTransform_Icon) this.getChild(QueryFunction_SideTransform_Icon.class, ParameterizedSideTransformMenuPart.ICON);
  }

  public void setIcon(QueryFunction_SideTransform_Icon node) {
    super.setChild(ParameterizedSideTransformMenuPart.ICON, node);
  }

  public QueryFunction_ParameterizedSideTransform_Handler getHandler() {
    return (QueryFunction_ParameterizedSideTransform_Handler) this.getChild(QueryFunction_ParameterizedSideTransform_Handler.class, ParameterizedSideTransformMenuPart.HANDLER);
  }

  public void setHandler(QueryFunction_ParameterizedSideTransform_Handler node) {
    super.setChild(ParameterizedSideTransformMenuPart.HANDLER, node);
  }

  public static ParameterizedSideTransformMenuPart newInstance(SModel sm, boolean init) {
    return (ParameterizedSideTransformMenuPart) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.actions.structure.ParameterizedSideTransformMenuPart", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ParameterizedSideTransformMenuPart newInstance(SModel sm) {
    return ParameterizedSideTransformMenuPart.newInstance(sm, false);
  }
}
