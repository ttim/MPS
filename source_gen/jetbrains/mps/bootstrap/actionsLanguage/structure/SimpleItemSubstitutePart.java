package jetbrains.mps.bootstrap.actionsLanguage.structure;

/*Generated by MPS  */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class SimpleItemSubstitutePart extends SubstituteMenuPart {
  public static String MATCHING_TEXT = "matchingText";
  public static String DESCRIPTION_TEXT = "descriptionText";
  public static String CAN_SUBSTITUTE = "canSubstitute";
  public static String HANDLER = "handler";

  public  SimpleItemSubstitutePart(SNode node) {
    super(node);
  }

  public static SimpleItemSubstitutePart newInstance(SModel sm, boolean init) {
    return (SimpleItemSubstitutePart)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.bootstrap.actionsLanguage.SimpleItemSubstitutePart", sm, GlobalScope.getInstance(), init).getAdapter();
  }
  public static SimpleItemSubstitutePart newInstance(SModel sm) {
    return SimpleItemSubstitutePart.newInstance(sm, false);
  }

  public QueryFunction_SubstituteString getMatchingText() {
    return (QueryFunction_SubstituteString)this.getChild(SimpleItemSubstitutePart.MATCHING_TEXT);
  }
  public void setMatchingText(QueryFunction_SubstituteString node) {
    super.setChild(SimpleItemSubstitutePart.MATCHING_TEXT, node);
  }
  public QueryFunction_SubstituteString getDescriptionText() {
    return (QueryFunction_SubstituteString)this.getChild(SimpleItemSubstitutePart.DESCRIPTION_TEXT);
  }
  public void setDescriptionText(QueryFunction_SubstituteString node) {
    super.setChild(SimpleItemSubstitutePart.DESCRIPTION_TEXT, node);
  }
  public QueryFunction_CanSubstitute getCanSubstitute() {
    return (QueryFunction_CanSubstitute)this.getChild(SimpleItemSubstitutePart.CAN_SUBSTITUTE);
  }
  public void setCanSubstitute(QueryFunction_CanSubstitute node) {
    super.setChild(SimpleItemSubstitutePart.CAN_SUBSTITUTE, node);
  }
  public QueryFunction_SubstituteHandler getHandler() {
    return (QueryFunction_SubstituteHandler)this.getChild(SimpleItemSubstitutePart.HANDLER);
  }
  public void setHandler(QueryFunction_SubstituteHandler node) {
    super.setChild(SimpleItemSubstitutePart.HANDLER, node);
  }
}
