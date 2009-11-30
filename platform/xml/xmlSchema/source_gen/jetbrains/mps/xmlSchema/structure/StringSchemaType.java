package jetbrains.mps.xmlSchema.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class StringSchemaType extends SchemaType {
  public static final String concept = "jetbrains.mps.xmlSchema.structure.StringSchemaType";
  public static final String DEFAULT_VALUE = "defaultValue";

  public StringSchemaType(SNode node) {
    super(node);
  }

  public String getDefaultValue() {
    return this.getProperty(StringSchemaType.DEFAULT_VALUE);
  }

  public void setDefaultValue(String value) {
    this.setProperty(StringSchemaType.DEFAULT_VALUE, value);
  }

  public static StringSchemaType newInstance(SModel sm, boolean init) {
    return (StringSchemaType)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.xmlSchema.structure.StringSchemaType", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static StringSchemaType newInstance(SModel sm) {
    return StringSchemaType.newInstance(sm, false);
  }
}
