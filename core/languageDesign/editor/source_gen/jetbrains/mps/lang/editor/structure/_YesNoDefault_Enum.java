package jetbrains.mps.lang.editor.structure;

/*Generated by MPS */

import java.util.List;
import java.util.LinkedList;
import jetbrains.mps.baseLanguage.collections.internal.query.ListOperations;

public enum _YesNoDefault_Enum {
  yes("yes", "true"),
  no("no", "false"),
  none("none", null);

  private String myName;
  private String myValue;

  _YesNoDefault_Enum(String name, String value) {
    this.myName = name;
    this.myValue = value;
  }

  public static List<_YesNoDefault_Enum> getConstants() {
    List<_YesNoDefault_Enum> list = new LinkedList<_YesNoDefault_Enum>();
    ListOperations.addElement(list, _YesNoDefault_Enum.yes);
    ListOperations.addElement(list, _YesNoDefault_Enum.no);
    ListOperations.addElement(list, _YesNoDefault_Enum.none);
    return list;
  }

  public static _YesNoDefault_Enum getDefault() {
    return _YesNoDefault_Enum.none;
  }

  public static _YesNoDefault_Enum parseValue(String value) {
    if (value == null) {
      return _YesNoDefault_Enum.getDefault();
    }
    if (value.equals(_YesNoDefault_Enum.yes.getValueAsString())) {
      return _YesNoDefault_Enum.yes;
    }
    if (value.equals(_YesNoDefault_Enum.no.getValueAsString())) {
      return _YesNoDefault_Enum.no;
    }
    if (value.equals(_YesNoDefault_Enum.none.getValueAsString())) {
      return _YesNoDefault_Enum.none;
    }
    return _YesNoDefault_Enum.getDefault();
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
