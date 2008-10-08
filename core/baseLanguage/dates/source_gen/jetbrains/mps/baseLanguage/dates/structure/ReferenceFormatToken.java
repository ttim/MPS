package jetbrains.mps.baseLanguage.dates.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.dates.internal.structure.IDateFormat;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ReferenceFormatToken extends FormatToken {
  public static final String concept = "jetbrains.mps.baseLanguage.dates.structure.ReferenceFormatToken";
  public static String DATE_FORMAT = "dateFormat";

  public ReferenceFormatToken(SNode node) {
    super(node);
  }

  public IDateFormat getDateFormat() {
    return (IDateFormat)this.getReferent(ReferenceFormatToken.DATE_FORMAT);
  }

  public void setDateFormat(IDateFormat node) {
    super.setReferent(ReferenceFormatToken.DATE_FORMAT, node);
  }


  public static ReferenceFormatToken newInstance(SModel sm, boolean init) {
    return (ReferenceFormatToken)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.dates.structure.ReferenceFormatToken", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ReferenceFormatToken newInstance(SModel sm) {
    return ReferenceFormatToken.newInstance(sm, false);
  }

}
