package jetbrains.mps.xmlSchema.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class IntegerSchemaType extends SchemaType {
  public static final String concept = "jetbrains.mps.xmlSchema.structure.IntegerSchemaType";
  public static final String DEFAULT_VALUE = "defaultValue";

  public IntegerSchemaType(SNode node) {
    super(node);
  }

  public int getDefaultValue() {
    return this.getIntegerProperty(IntegerSchemaType.DEFAULT_VALUE);
  }

  public void setDefaultValue(int value) {
    this.setIntegerProperty(IntegerSchemaType.DEFAULT_VALUE, value);
  }

  public static IntegerSchemaType newInstance(SModel sm, boolean init) {
    return (IntegerSchemaType) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.xmlSchema.structure.IntegerSchemaType", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static IntegerSchemaType newInstance(SModel sm) {
    return IntegerSchemaType.newInstance(sm, false);
  }
}
