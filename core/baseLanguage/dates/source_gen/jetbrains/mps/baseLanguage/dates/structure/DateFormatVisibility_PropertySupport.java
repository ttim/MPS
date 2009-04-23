package jetbrains.mps.baseLanguage.dates.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.PropertySupport;
import java.util.Iterator;
import jetbrains.mps.internal.collections.runtime.ListSequence;

public class DateFormatVisibility_PropertySupport extends PropertySupport {

  public boolean canSetValue(String value) {
    if (value == null) {
      return true;
    }
    Iterator<DateFormatVisibility> constants = ListSequence.fromList(DateFormatVisibility.getConstants()).iterator();
    while (constants.hasNext()) {
      DateFormatVisibility constant = constants.next();
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
    Iterator<DateFormatVisibility> constants = ListSequence.fromList(DateFormatVisibility.getConstants()).iterator();
    while (constants.hasNext()) {
      DateFormatVisibility constant = constants.next();
      if (value.equals(constant.getName())) {
        return constant.getValueAsString();
      }
    }
    return null;
  }

  public String fromInternalValue(String value) {
    DateFormatVisibility constant = DateFormatVisibility.parseValue(value);
    if (constant != null) {
      return constant.getName();
    }
    return "";
  }

}
