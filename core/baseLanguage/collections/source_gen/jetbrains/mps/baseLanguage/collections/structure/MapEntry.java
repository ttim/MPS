package jetbrains.mps.baseLanguage.collections.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.structure.Expression;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class MapEntry extends BaseConcept {
  public static final String concept = "jetbrains.mps.baseLanguage.collections.structure.MapEntry";
  public static final String KEY = "key";
  public static final String VALUE = "value";

  public MapEntry(SNode node) {
    super(node);
  }

  public Expression getKey() {
    return (Expression)this.getChild(Expression.class, MapEntry.KEY);
  }

  public void setKey(Expression node) {
    super.setChild(MapEntry.KEY, node);
  }

  public Expression getValue() {
    return (Expression)this.getChild(Expression.class, MapEntry.VALUE);
  }

  public void setValue(Expression node) {
    super.setChild(MapEntry.VALUE, node);
  }

  public static MapEntry newInstance(SModel sm, boolean init) {
    return (MapEntry)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.MapEntry", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static MapEntry newInstance(SModel sm) {
    return MapEntry.newInstance(sm, false);
  }
}
