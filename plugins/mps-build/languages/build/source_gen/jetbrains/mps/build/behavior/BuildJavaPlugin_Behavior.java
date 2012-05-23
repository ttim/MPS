package jetbrains.mps.build.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.scope.Scope;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.build.util.ScopeUtil;
import jetbrains.mps.scope.SimpleRoleScope;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import jetbrains.mps.scope.CompositeScope;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.build.util.DescendantsScope;

public class BuildJavaPlugin_Behavior {
  public static void init(SNode thisNode) {
  }

  public static Scope virtual_getProjectStructureScope_3734116213129936182(SNode thisNode, final SNode kind) {
    if (kind == SConceptOperations.findConceptDeclaration("jetbrains.mps.build.structure.BuildSource_JavaOptions")) {
      return ScopeUtil.where(new SimpleRoleScope(SNodeOperations.getParent(thisNode), SLinkOperations.findLinkDeclaration("jetbrains.mps.build.structure.BuildProject", "parts"), "jetbrains.mps.build.structure.BuildSource_JavaOptions") {
        public String getName(SNode jo) {
          String optionsName = SPropertyOperations.getString(SNodeOperations.cast(jo, "jetbrains.mps.build.structure.BuildSource_JavaOptions"), "optionsName");
          return ((optionsName == null || optionsName.length() == 0) ?
            "<default options>" :
            optionsName
          );
        }
      }, new _FunctionTypes._return_P1_E0<Boolean, SNode>() {
        public Boolean invoke(SNode node) {
          return (SPropertyOperations.getString(SNodeOperations.cast(node, "jetbrains.mps.build.structure.BuildSource_JavaOptions"), "optionsName") != null && SPropertyOperations.getString(SNodeOperations.cast(node, "jetbrains.mps.build.structure.BuildSource_JavaOptions"), "optionsName").length() > 0);
        }
      });
    }

    if (SConceptOperations.isSubConceptOf(kind, "jetbrains.mps.build.structure.BuildSource_JavaModule") || SConceptOperations.isSubConceptOf(kind, "jetbrains.mps.build.structure.BuildSource_JavaLibrary")) {
      return new CompositeScope(Sequence.fromIterable(BuildProject_Behavior.call_getVisibleProjects_1224588814561807665(BuildPlugin_Behavior.call_getProject_1224588814561866657(thisNode), false)).select(new ISelector<SNode, DescendantsScope>() {
        public DescendantsScope select(SNode it) {
          return DescendantsScope.forNamedElements(it, SLinkOperations.findLinkDeclaration("jetbrains.mps.build.structure.BuildProject", "parts"), kind);
        }
      }).concat(Sequence.fromIterable(Sequence.<DescendantsScope>singleton(DescendantsScope.forNamedElements(BuildPlugin_Behavior.call_getProject_1224588814561866657(thisNode), SLinkOperations.findLinkDeclaration("jetbrains.mps.build.structure.BuildProject", "parts"), kind)))).toGenericArray(DescendantsScope.class));
    }

    return null;
  }

  public static Scope virtual_getLayoutScope_1224588814561807654(SNode thisNode, SNode kind) {
    if (SConceptOperations.isSubConceptOf(kind, "jetbrains.mps.build.structure.BuildSource_CompilablePart")) {
      return DescendantsScope.forNamedElements(BuildPlugin_Behavior.call_getProject_1224588814561866657(thisNode), SLinkOperations.findLinkDeclaration("jetbrains.mps.build.structure.BuildProject", "parts"), kind);
    }

    return null;
  }
}
