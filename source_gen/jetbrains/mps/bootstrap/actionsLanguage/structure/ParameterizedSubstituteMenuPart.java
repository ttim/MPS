package jetbrains.mps.bootstrap.actionsLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.baseLanguage.structure.Type;

public class ParameterizedSubstituteMenuPart extends SubstituteMenuPart {
  public static final String concept = "jetbrains.mps.bootstrap.actionsLanguage.structure.ParameterizedSubstituteMenuPart";
  public static String TYPE = "type";
  public static String QUERY = "query";
  public static String MATCHING_TEXT = "matchingText";
  public static String DESCRIPTION_TEXT = "descriptionText";
  public static String HANDLER = "handler";

  public  ParameterizedSubstituteMenuPart(SNode node) {
    super(node);
  }

  public static ParameterizedSubstituteMenuPart newInstance(SModel sm, boolean init) {
    return (ParameterizedSubstituteMenuPart)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.bootstrap.actionsLanguage.structure.ParameterizedSubstituteMenuPart", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ParameterizedSubstituteMenuPart newInstance(SModel sm) {
    return ParameterizedSubstituteMenuPart.newInstance(sm, false);
  }


  public Type getType() {
    return (Type)this.getChild(ParameterizedSubstituteMenuPart.TYPE);
  }

  public void setType(Type node) {
    super.setChild(ParameterizedSubstituteMenuPart.TYPE, node);
  }

  public QueryFunction_ParameterizedSubstitute_Query getQuery() {
    return (QueryFunction_ParameterizedSubstitute_Query)this.getChild(ParameterizedSubstituteMenuPart.QUERY);
  }

  public void setQuery(QueryFunction_ParameterizedSubstitute_Query node) {
    super.setChild(ParameterizedSubstituteMenuPart.QUERY, node);
  }

  public QueryFunction_ParameterizedSubstitute_String getMatchingText() {
    return (QueryFunction_ParameterizedSubstitute_String)this.getChild(ParameterizedSubstituteMenuPart.MATCHING_TEXT);
  }

  public void setMatchingText(QueryFunction_ParameterizedSubstitute_String node) {
    super.setChild(ParameterizedSubstituteMenuPart.MATCHING_TEXT, node);
  }

  public QueryFunction_ParameterizedSubstitute_String getDescriptionText() {
    return (QueryFunction_ParameterizedSubstitute_String)this.getChild(ParameterizedSubstituteMenuPart.DESCRIPTION_TEXT);
  }

  public void setDescriptionText(QueryFunction_ParameterizedSubstitute_String node) {
    super.setChild(ParameterizedSubstituteMenuPart.DESCRIPTION_TEXT, node);
  }

  public QueryFunction_ParameterizedSubstitute_Handler getHandler() {
    return (QueryFunction_ParameterizedSubstitute_Handler)this.getChild(ParameterizedSubstituteMenuPart.HANDLER);
  }

  public void setHandler(QueryFunction_ParameterizedSubstitute_Handler node) {
    super.setChild(ParameterizedSubstituteMenuPart.HANDLER, node);
  }

}
