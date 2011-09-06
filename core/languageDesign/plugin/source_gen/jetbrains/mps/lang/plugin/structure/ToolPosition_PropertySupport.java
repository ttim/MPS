package jetbrains.mps.lang.plugin.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.PropertySupport;
import java.util.Iterator;
import jetbrains.mps.internal.collections.runtime.ListSequence;

public class ToolPosition_PropertySupport extends PropertySupport {
  public boolean canSetValue(String value) {
    if (value == null) {
      return true;
    }
    Iterator<ToolPosition> constants = ListSequence.fromList(ToolPosition.getConstants()).iterator();
    while (constants.hasNext()) {
      ToolPosition constant = constants.next();
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
    Iterator<ToolPosition> constants = ListSequence.fromList(ToolPosition.getConstants()).iterator();
    while (constants.hasNext()) {
      ToolPosition constant = constants.next();
      if (value.equals(constant.getName())) {
        return constant.getValueAsString();
      }
    }
    return null;
  }

  public String fromInternalValue(String value) {
    ToolPosition constant = ToolPosition.parseValue(value);
    if (constant != null) {
      return constant.getName();
    }
    return "";
  }
}
