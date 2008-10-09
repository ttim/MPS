package jetbrains.mps.lang.editor.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.PropertySupport;
import java.util.Iterator;

public class _YesNoDefault_Enum_PropertySupport extends PropertySupport {

  public boolean canSetValue(String value) {
    if (value == null) {
      return true;
    }
    Iterator<_YesNoDefault_Enum> constants = _YesNoDefault_Enum.getConstants().iterator();
    while (constants.hasNext()) {
      _YesNoDefault_Enum constant = constants.next();
      if (value.equals(constant.getName())) {
        return true;
      }
    }
    return false;
  }

  public String toInternalValue(String value) {
    if (value == null) {
      return null;
    }
    Iterator<_YesNoDefault_Enum> constants = _YesNoDefault_Enum.getConstants().iterator();
    while (constants.hasNext()) {
      _YesNoDefault_Enum constant = constants.next();
      if (value.equals(constant.getName())) {
        return constant.getValueAsString();
      }
    }
    return null;
  }

  public String fromInternalValue(String value) {
    _YesNoDefault_Enum constant = _YesNoDefault_Enum.parseValue(value);
    if (constant != null) {
      return constant.getName();
    }
    return "";
  }

}
