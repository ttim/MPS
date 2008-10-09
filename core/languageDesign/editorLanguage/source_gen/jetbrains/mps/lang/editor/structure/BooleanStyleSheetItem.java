package jetbrains.mps.lang.editor.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class BooleanStyleSheetItem extends StyleClassItem {
  public static final String concept = "jetbrains.mps.lang.editor.structure.BooleanStyleSheetItem";
  public static String FLAG = "flag";
  public static String QUERY = "query";

  public BooleanStyleSheetItem(SNode node) {
    super(node);
  }

  public boolean getFlag() {
    return this.getBooleanProperty(BooleanStyleSheetItem.FLAG);
  }

  public void setFlag(boolean value) {
    this.setBooleanProperty(BooleanStyleSheetItem.FLAG, value);
  }

  public QueryFunction_Boolean getQuery() {
    return (QueryFunction_Boolean)this.getChild(BooleanStyleSheetItem.QUERY);
  }

  public void setQuery(QueryFunction_Boolean node) {
    super.setChild(BooleanStyleSheetItem.QUERY, node);
  }


  public static BooleanStyleSheetItem newInstance(SModel sm, boolean init) {
    return (BooleanStyleSheetItem)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.editor.structure.BooleanStyleSheetItem", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static BooleanStyleSheetItem newInstance(SModel sm) {
    return BooleanStyleSheetItem.newInstance(sm, false);
  }

}
