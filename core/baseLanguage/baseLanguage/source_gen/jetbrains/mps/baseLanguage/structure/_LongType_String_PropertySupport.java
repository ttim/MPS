package jetbrains.mps.baseLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.PropertySupport;

public class _LongType_String_PropertySupport extends PropertySupport {

  public boolean canSetValue(String value) {
    String testValue = null;
    if (value == null) {
      testValue = "";
    } else
    {
      testValue = value;
    }
    return testValue.matches("[0-9]+(l|L)");
  }

}
