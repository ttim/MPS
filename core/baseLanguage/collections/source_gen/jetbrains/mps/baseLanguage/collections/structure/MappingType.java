package jetbrains.mps.baseLanguage.collections.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.Type;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class MappingType extends Type {
  public static final String concept = "jetbrains.mps.baseLanguage.collections.structure.MappingType";
  public static final String KEY_TYPE = "keyType";
  public static final String VALUE_TYPE = "valueType";

  public MappingType(SNode node) {
    super(node);
  }

  public Type getKeyType() {
    return (Type)this.getChild(Type.class, MappingType.KEY_TYPE);
  }

  public void setKeyType(Type node) {
    super.setChild(MappingType.KEY_TYPE, node);
  }

  public Type getValueType() {
    return (Type)this.getChild(Type.class, MappingType.VALUE_TYPE);
  }

  public void setValueType(Type node) {
    super.setChild(MappingType.VALUE_TYPE, node);
  }


  public static MappingType newInstance(SModel sm, boolean init) {
    return (MappingType)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.MappingType", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static MappingType newInstance(SModel sm) {
    return MappingType.newInstance(sm, false);
  }

}
