package jetbrains.mps.lang.editor.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.PropertySupport;
import java.util.Iterator;
import jetbrains.mps.lang.editor.structure.CellActionId;

public class CellActionId_PropertySupport extends PropertySupport {

  public boolean canSetValue(String value) {
    if (value == null) {
      return true;
    }
    Iterator<CellActionId> constants = CellActionId.getConstants().iterator();
    while (constants.hasNext()) {
      CellActionId constant = constants.next();
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
    Iterator<CellActionId> constants = CellActionId.getConstants().iterator();
    while (constants.hasNext()) {
      CellActionId constant = constants.next();
      if (value.equals(constant.getName())) {
        return constant.getValueAsString();
      }
    }
    return null;
  }

  public String fromInternalValue(String value) {
    CellActionId constant = CellActionId.parseValue(value);
    if (constant != null) {
      return constant.getName();
    }
    return "";
  }

}
