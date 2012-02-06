package jetbrains.mps.buildScript.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.PropertySupport;
import java.util.Iterator;
import jetbrains.mps.internal.collections.runtime.ListSequence;

public class BuildSource_JavaContentFolderKind_PropertySupport extends PropertySupport {
  public boolean canSetValue(String value) {
    if (value == null) {
      return true;
    }
    Iterator<BuildSource_JavaContentFolderKind> constants = ListSequence.fromList(BuildSource_JavaContentFolderKind.getConstants()).iterator();
    while (constants.hasNext()) {
      BuildSource_JavaContentFolderKind constant = constants.next();
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
    Iterator<BuildSource_JavaContentFolderKind> constants = ListSequence.fromList(BuildSource_JavaContentFolderKind.getConstants()).iterator();
    while (constants.hasNext()) {
      BuildSource_JavaContentFolderKind constant = constants.next();
      if (value.equals(constant.getName())) {
        return constant.getValueAsString();
      }
    }
    return null;
  }

  public String fromInternalValue(String value) {
    BuildSource_JavaContentFolderKind constant = BuildSource_JavaContentFolderKind.parseValue(value);
    if (constant != null) {
      return constant.getName();
    }
    return "<no kind>";
  }
}
