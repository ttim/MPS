package jetbrains.mps.transformation.test.inputLang.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.scope.Scope;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.scope.CompositeScope;
import jetbrains.mps.scope.SimpleRoleScope;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.core.behavior.ScopeProvider_Behavior;

public class RefTestClass_Behavior {
  public static void init(SNode thisNode) {
  }

  public static Scope virtual_getScope_3734116213129936182(SNode thisNode, SNode kind, SNode child) {
    if (kind == SConceptOperations.findConceptDeclaration("jetbrains.mps.transformation.test.inputLang.structure.RefTestMethod")) {
      return CompositeScope.createComposite(new SimpleRoleScope(thisNode, SLinkOperations.findLinkDeclaration("jetbrains.mps.transformation.test.inputLang.structure.RefTestClass", "methods")) {
        public String getName(SNode child) {
          return SPropertyOperations.getString(SNodeOperations.cast(child, "jetbrains.mps.transformation.test.inputLang.structure.RefTestMethod"), "name");
        }
      }, (SLinkOperations.getTarget(thisNode, "extends", false) != null ?
        ScopeProvider_Behavior.call_getScope_3734116213129936182(SLinkOperations.getTarget(thisNode, "extends", false), kind, thisNode) :
        null
      ));
    }
    return null;
  }
}
