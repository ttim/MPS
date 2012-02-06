package jetbrains.mps.buildScript.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import org.apache.commons.lang.StringUtils;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.buildScript.util.Context;

public class BuildSourceProjectRelativePath_Behavior {
  public static void init(SNode thisNode) {
  }

  public static String virtual_getRelativePath_5481553824944787371(SNode thisNode) {
    return (StringUtils.isEmpty(SPropertyOperations.getString(thisNode, "relativePath")) ?
      "${basedir}" :
      "${basedir}/" + SPropertyOperations.getString(thisNode, "relativePath")
    );
  }

  public static String virtual_getBasePath_4959435991187140515(SNode thisNode, Context context) {
    return context.getBasePath_Local(thisNode);
  }
}
