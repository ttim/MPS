package jetbrains.mps.lang.editor.structure;

/*Generated by MPS */

import java.util.List;
import java.util.LinkedList;
import jetbrains.mps.baseLanguage.collections.internal.query.ListOperations;

public enum _Enum_Measure {
  pixels("pixels", "PIXELS"),
  spaces("spaces", "SPACES");

  private String myName;
  private String myValue;

  _Enum_Measure(String name, String value) {
    this.myName = name;
    this.myValue = value;
  }

  public static List<_Enum_Measure> getConstants() {
    List<_Enum_Measure> list = new LinkedList<_Enum_Measure>();
    ListOperations.addElement(list, _Enum_Measure.pixels);
    ListOperations.addElement(list, _Enum_Measure.spaces);
    return list;
  }

  public static _Enum_Measure getDefault() {
    return _Enum_Measure.spaces;
  }

  public static _Enum_Measure parseValue(String value) {
    if (value == null) {
      return _Enum_Measure.getDefault();
    }
    if (value.equals(_Enum_Measure.pixels.getValueAsString())) {
      return _Enum_Measure.pixels;
    }
    if (value.equals(_Enum_Measure.spaces.getValueAsString())) {
      return _Enum_Measure.spaces;
    }
    return _Enum_Measure.getDefault();
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
