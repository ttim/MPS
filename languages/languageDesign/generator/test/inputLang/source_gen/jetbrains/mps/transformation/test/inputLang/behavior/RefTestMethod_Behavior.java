package jetbrains.mps.transformation.test.inputLang.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.scope.Scope;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.scope.SimpleRoleScope;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;

public class RefTestMethod_Behavior {
  public static void init(SNode thisNode) {
  }

  public static Scope virtual_getScope_3734116213129936182(SNode thisNode, SNode kind, SNode child) {
    if (kind == SConceptOperations.findConceptDeclaration("jetbrains.mps.transformation.test.inputLang.structure.RefTestParam")) {
      return new SimpleRoleScope(thisNode, SLinkOperations.findLinkDeclaration("jetbrains.mps.transformation.test.inputLang.structure.RefTestMethod", "params")) {
        public String getName(SNode child) {
          return SPropertyOperations.getString(SNodeOperations.cast(child, "jetbrains.mps.transformation.test.inputLang.structure.RefTestParam"), "name");
        }
      };
    }
    return null;
  }
}
