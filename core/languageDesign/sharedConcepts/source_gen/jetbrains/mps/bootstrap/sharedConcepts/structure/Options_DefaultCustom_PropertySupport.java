package jetbrains.mps.bootstrap.sharedConcepts.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.PropertySupport;

import java.util.Iterator;

public class Options_DefaultCustom_PropertySupport extends PropertySupport {

  public boolean canSetValue(String value) {
    if (value == null) {
      return true;
    }
    Iterator<Options_DefaultCustom> constants = Options_DefaultCustom.getConstants().iterator();
    while (constants.hasNext()) {
      Options_DefaultCustom constant = constants.next();
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
    Iterator<Options_DefaultCustom> constants = Options_DefaultCustom.getConstants().iterator();
    while (constants.hasNext()) {
      Options_DefaultCustom constant = constants.next();
      if (value.equals(constant.getName())) {
        return constant.getValueAsString();
      }
    }
    return null;
  }

  public String fromInternalValue(String value) {
    Options_DefaultCustom constant = Options_DefaultCustom.parseValue(value);
    if (constant != null) {
      return constant.getName();
    }
    return null;
  }

}
