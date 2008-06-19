package jetbrains.mps.bootstrap.structureLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.PropertySupport;
import java.util.Iterator;

public class AnnotationLinkStereotype_PropertySupport extends PropertySupport {

  public boolean canSetValue(String value) {
    if (value == null) {
      return true;
    }
    Iterator<AnnotationLinkStereotype> constants = AnnotationLinkStereotype.getConstants().iterator();
    while (constants.hasNext()) {
      AnnotationLinkStereotype constant = constants.next();
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
    Iterator<AnnotationLinkStereotype> constants = AnnotationLinkStereotype.getConstants().iterator();
    while (constants.hasNext()) {
      AnnotationLinkStereotype constant = constants.next();
      if (value.equals(constant.getName())) {
        return constant.getValueAsString();
      }
    }
    return null;
  }

  public String fromInternalValue(String value) {
    AnnotationLinkStereotype constant = AnnotationLinkStereotype.parseValue(value);
    if (constant != null) {
      return constant.getName();
    }
    return "";
  }

}
