package jetbrains.mpslite.structure;

/*Generated by MPS */

import java.util.List;
import java.util.LinkedList;
import jetbrains.mps.baseLanguage.collections.internal.query.ListOperations;

public enum MPSLitePropertyType_Enum {
  string("string", "string"),
  numeric("numeric", "numeric");

  private String myName;
  private String myValue;

  MPSLitePropertyType_Enum(String name, String value) {
    this.myName = name;
    this.myValue = value;
  }

  public static List<MPSLitePropertyType_Enum> getConstants() {
    List<MPSLitePropertyType_Enum> list = new LinkedList<MPSLitePropertyType_Enum>();
    ListOperations.addElement(list, MPSLitePropertyType_Enum.string);
    ListOperations.addElement(list, MPSLitePropertyType_Enum.numeric);
    return list;
  }

  public static MPSLitePropertyType_Enum getDefault() {
    return MPSLitePropertyType_Enum.string;
  }

  public static MPSLitePropertyType_Enum parseValue(String value) {
    if (value == null) {
      return MPSLitePropertyType_Enum.getDefault();
    }
    if (value.equals(MPSLitePropertyType_Enum.string.getValueAsString())) {
      return MPSLitePropertyType_Enum.string;
    }
    if (value.equals(MPSLitePropertyType_Enum.numeric.getValueAsString())) {
      return MPSLitePropertyType_Enum.numeric;
    }
    return MPSLitePropertyType_Enum.getDefault();
  }


  public String getName() {
    return this.myName;
  }

  public String getValueAsString() {
    return this.myValue;
  }

  public String getValue() {
    return this.myValue;
  }

}
