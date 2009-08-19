package jetbrains.mps.baseLanguage.collections.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.AbstractCreator;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.structure.Type;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class HashMapCreator extends AbstractCreator {
  public static final String concept = "jetbrains.mps.baseLanguage.collections.structure.HashMapCreator";
  public static final String KEY_TYPE = "keyType";
  public static final String VALUE_TYPE = "valueType";
  public static final String INITIALIZER = "initializer";

  public HashMapCreator(SNode node) {
    super(node);
  }

  public Type getKeyType() {
    return (Type)this.getChild(Type.class, HashMapCreator.KEY_TYPE);
  }

  public void setKeyType(Type node) {
    super.setChild(HashMapCreator.KEY_TYPE, node);
  }

  public Type getValueType() {
    return (Type)this.getChild(Type.class, HashMapCreator.VALUE_TYPE);
  }

  public void setValueType(Type node) {
    super.setChild(HashMapCreator.VALUE_TYPE, node);
  }

  public MapInitializer getInitializer() {
    return (MapInitializer)this.getChild(MapInitializer.class, HashMapCreator.INITIALIZER);
  }

  public void setInitializer(MapInitializer node) {
    super.setChild(HashMapCreator.INITIALIZER, node);
  }

  public static HashMapCreator newInstance(SModel sm, boolean init) {
    return (HashMapCreator)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.HashMapCreator", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static HashMapCreator newInstance(SModel sm) {
    return HashMapCreator.newInstance(sm, false);
  }
}
