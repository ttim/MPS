package jetbrains.mps.baseLanguage.math.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.PropertySupport;
import java.util.Iterator;
import jetbrains.mps.internal.collections.runtime.ListSequence;

public class PrecisionSetting_PropertySupport extends PropertySupport {
  public boolean canSetValue(String value) {
    if (value == null) {
      return true;
    }
    Iterator<PrecisionSetting> constants = ListSequence.fromList(PrecisionSetting.getConstants()).iterator();
    while (constants.hasNext()) {
      PrecisionSetting constant = constants.next();
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
    Iterator<PrecisionSetting> constants = ListSequence.fromList(PrecisionSetting.getConstants()).iterator();
    while (constants.hasNext()) {
      PrecisionSetting constant = constants.next();
      if (value.equals(constant.getName())) {
        return constant.getValueAsString();
      }
    }
    return null;
  }

  public String fromInternalValue(String value) {
    PrecisionSetting constant = PrecisionSetting.parseValue(value);
    if (constant != null) {
      return constant.getName();
    }
    return "";
  }
}
