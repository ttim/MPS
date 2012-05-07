package jetbrains.mps.build.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.build.util.Context;
import jetbrains.mps.build.util.RelativePathHelper;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.generator.template.TemplateQueryContext;
import jetbrains.mps.scope.Scope;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.build.workflow.behavior.FilteringScope;
import jetbrains.mps.scope.SimpleRoleScope;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.build.util.ScopeUtil;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import jetbrains.mps.lang.core.behavior.INamedConcept_Behavior;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.scope.CompositeScope;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;

public class BuildProject_Behavior {
  public static void init(SNode thisNode) {
  }

  public static boolean call_isPackaged_4129895186893455885(SNode thisNode, Context context) {
    RelativePathHelper relativePathHelper = context.getRelativePathHelper(SNodeOperations.getModel(thisNode));
    return relativePathHelper == null;
  }

  @Nullable
  public static String call_getBasePath_4959435991187146924(SNode thisNode, Context context) {
    RelativePathHelper relativePathHelper = context.getRelativePathHelper(SNodeOperations.getModel(thisNode));
    if (relativePathHelper == null) {
      // model is packaged, i.e. no base path for it 
      return null;
    }
    if ((SPropertyOperations.getString(thisNode, "internalBaseDirectory") != null && SPropertyOperations.getString(thisNode, "internalBaseDirectory").length() > 0)) {
      try {
        return relativePathHelper.makeAbsolute(SPropertyOperations.getString(thisNode, "internalBaseDirectory"));
      } catch (RelativePathHelper.PathException ex) {
        // no idea - use default path 
      }
    }
    return relativePathHelper.getBasePath();
  }

  @Nullable
  public static String call_getScriptsPath_4796668409958419284(SNode thisNode, Context context) {
    if ((SLinkOperations.getTarget(thisNode, "scriptsDir", true) != null)) {
      return BuildSourcePath_Behavior.call_getLocalPath_5481553824944787364(SLinkOperations.getTarget(thisNode, "scriptsDir", true), context);
    }
    return BuildProject_Behavior.call_getBasePath_4959435991187146924(thisNode, context);
  }

  public static String call_getBasePathRelativeToScriptsPath_5178006408628632053(SNode thisNode, Context context) {
    String scriptsPath = BuildProject_Behavior.call_getScriptsPath_4796668409958419284(thisNode, context);
    String basePath = BuildProject_Behavior.call_getBasePath_4959435991187146924(thisNode, context);
    try {
      return new RelativePathHelper(scriptsPath).makeRelative(basePath);
    } catch (RelativePathHelper.PathException ex) {
      if (context.getGenerationContext() != null) {
        TemplateQueryContext generationContext = context.getGenerationContext();
        generationContext.showErrorMessage(thisNode, "cannot calculate relative path: " + ex.getMessage());
      }
      return null;
    }
  }

  public static Scope virtual_getScope_3734116213129936182(SNode thisNode, final SNode kind, final SNode child) {
    if (SConceptOperations.isSubConceptOf(kind, "jetbrains.mps.build.structure.BuildMacro")) {
      return BuildProject_Behavior.call_getBuildMacroScope_3767587139141108514(thisNode, child);
    } else if (kind == SConceptOperations.findConceptDeclaration("jetbrains.mps.build.structure.BuildSource_JavaOptions")) {
      return new FilteringScope(new SimpleRoleScope(thisNode, SLinkOperations.findLinkDeclaration("jetbrains.mps.build.structure.BuildProject", "parts"), "jetbrains.mps.build.structure.BuildSource_JavaOptions") {
        public String getName(SNode jo) {
          String optionsName = SPropertyOperations.getString(SNodeOperations.cast(jo, "jetbrains.mps.build.structure.BuildSource_JavaOptions"), "optionsName");
          return ((optionsName == null || optionsName.length() == 0) ?
            "<default options>" :
            optionsName
          );
        }
      }) {
        @Override
        public boolean isExcluded(SNode node) {
          return (SPropertyOperations.getString(SNodeOperations.cast(node, "jetbrains.mps.build.structure.BuildSource_JavaOptions"), "optionsName") == null || SPropertyOperations.getString(SNodeOperations.cast(node, "jetbrains.mps.build.structure.BuildSource_JavaOptions"), "optionsName").length() == 0);
        }
      };
    } else if (SConceptOperations.isSubConceptOf(kind, "jetbrains.mps.build.structure.BuildProjectPart")) {
      List<Scope> scopes = ListSequence.fromList(new ArrayList<Scope>());
      ListSequence.fromList(scopes).addElement(ScopeUtil.where(ScopeUtil.simpleRoleScope(thisNode, SLinkOperations.findLinkDeclaration("jetbrains.mps.build.structure.BuildProject", "parts")), new _FunctionTypes._return_P1_E0<Boolean, SNode>() {
        public Boolean invoke(SNode node) {
          return SNodeOperations.isInstanceOf(node, INamedConcept_Behavior.call_getFqName_1213877404258(kind));
        }
      }));
      ListSequence.fromList(scopes).addSequence(Sequence.fromIterable(ScopeUtil.imported(SLinkOperations.getTargets(thisNode, "dependencies", true), kind, child)));
      return ScopeUtil.unique(new CompositeScope(ListSequence.fromList(scopes).toGenericArray(Scope.class)));
    }
    return null;
  }

  public static Scope call_getBuildMacroScope_3767587139141108514(SNode thisNode, final SNode child) {
    Scope rootScope = ScopeUtil.simpleRoleScope(thisNode, SLinkOperations.findLinkDeclaration("jetbrains.mps.build.structure.BuildProject", "macros"));
    SNode containingProject = SNodeOperations.getAncestor(child, "jetbrains.mps.build.structure.BuildProject", false, false);
    if (neq_save77_a0c0g(containingProject, thisNode)) {
      // we are imported => give away only public macro 
      rootScope = ScopeUtil.where(rootScope, new _FunctionTypes._return_P1_E0<Boolean, SNode>() {
        public Boolean invoke(SNode node) {
          return BuildMacro_Behavior.call_isPublic_6547494638219688113(SNodeOperations.cast(node, "jetbrains.mps.build.structure.BuildMacro"));
        }
      });
    }
    if ((containingProject != null)) {
      final Wrappers._T<SNode> definedMacro = new Wrappers._T<SNode>();
      if (ListSequence.fromList(SLinkOperations.getTargets(containingProject, "macros", true)).contains(child)) {
        definedMacro.value = SNodeOperations.cast(child, "jetbrains.mps.build.structure.BuildMacro");
      } else {
        definedMacro.value = ListSequence.fromList(SLinkOperations.getTargets(containingProject, "macros", true)).findFirst(new IWhereFilter<SNode>() {
          public boolean accept(SNode it) {
            return ListSequence.fromList(SNodeOperations.getDescendants(it, null, false, new String[]{})).contains(child);
          }
        });
      }
      if ((definedMacro.value != null)) {
        // we can only see what was strictly before us 
        rootScope = ScopeUtil.where(rootScope, new _FunctionTypes._return_P1_E0<Boolean, SNode>() {
          public Boolean invoke(SNode visibleNode) {
            return !(ListSequence.fromList(SNodeOperations.getNextSiblings(definedMacro.value, false)).contains(visibleNode)) && !(eq_save77_a0a0a0a0a1a0b0c0d0g(definedMacro.value, visibleNode));
          }
        });
      }
    }

    List<Scope> scopes = ListSequence.fromList(new ArrayList<Scope>());
    ListSequence.fromList(scopes).addElement(rootScope);
    ListSequence.fromList(scopes).addSequence(Sequence.fromIterable(ScopeUtil.imported(SLinkOperations.getTargets(thisNode, "dependencies", true), SConceptOperations.findConceptDeclaration("jetbrains.mps.build.structure.BuildMacro"), child)));

    return new CompositeScope(ListSequence.fromList(scopes).toGenericArray(Scope.class));
  }

  public static boolean call_canEditBaseDir_631271972590018330(SNode thisNode) {
    return true;
  }

  private static boolean neq_save77_a0c0g(Object a, Object b) {
    return !((a != null ?
      a.equals(b) :
      a == b
    ));
  }

  private static boolean eq_save77_a0a0a0a0a1a0b0c0d0g(Object a, Object b) {
    return (a != null ?
      a.equals(b) :
      a == b
    );
  }
}
