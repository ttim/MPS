package jetbrains.mps.lang.actions.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.PropertySupport;
import java.util.Iterator;
import jetbrains.mps.internal.collections.runtime.ListSequence;

public class Side_PropertySupport extends PropertySupport {
  public boolean canSetValue(String value) {
    if (value == null) {
      return true;
    }
    Iterator<Side> constants = ListSequence.fromList(Side.getConstants()).iterator();
    while (constants.hasNext()) {
      Side constant = constants.next();
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
    Iterator<Side> constants = ListSequence.fromList(Side.getConstants()).iterator();
    while (constants.hasNext()) {
      Side constant = constants.next();
      if (value.equals(constant.getName())) {
        return constant.getValueAsString();
      }
    }
    return null;
  }

  public String fromInternalValue(String value) {
    Side constant = Side.parseValue(value);
    if (constant != null) {
      return constant.getName();
    }
    return "";
  }
}
