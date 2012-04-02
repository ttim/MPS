package jetbrains.mps.build.mps.generator.template.main;

/*Generated by MPS */

import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.generator.template.BaseMappingRuleContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.generator.template.PropertyMacroContext;
import jetbrains.mps.build.util.RelativePathHelper;
import jetbrains.mps.build.behavior.BuildSourcePath_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.build.util.Context;
import jetbrains.mps.generator.template.ReferenceMacroContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.generator.template.IfMacroContext;
import jetbrains.mps.generator.template.SourceSubstituteMacroNodeContext;
import jetbrains.mps.generator.template.SourceSubstituteMacroNodesContext;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.ISelector;
import java.util.List;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.baseLanguage.tuples.runtime.Tuples;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.internal.collections.runtime.ITranslator2;
import java.util.Set;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import java.util.HashSet;
import jetbrains.mps.generator.template.MappingScriptContext;
import jetbrains.mps.build.mps.util.PathConverter;
import jetbrains.mps.build.mps.util.VisibleModules;
import jetbrains.mps.build.mps.util.ModuleLoader;
import jetbrains.mps.generator.template.TemplateQueryContext;
import java.util.LinkedHashSet;
import jetbrains.mps.build.mps.util.BuildModuleUtil;
import jetbrains.mps.baseLanguage.tuples.runtime.MultiTuple;

public class QueriesGenerated {
  public static boolean baseMappingRule_Condition_1500819558096430320(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return SPropertyOperations.getBoolean(_context.getNode(), "doNotCompile") == false;
  }

  public static Object propertyMacro_GetPropertyValue_1500819558096225938(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name");
  }

  public static Object propertyMacro_GetPropertyValue_7259033139236585058(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return _context.getNode().getBooleanProperty("targetReexport");
  }

  public static Object propertyMacro_GetPropertyValue_8654221991637263445(final IOperationContext operationContext, final PropertyMacroContext _context) {
    try {
      String relative = ((RelativePathHelper) _context.getVariable("var:modulePath")).makeRelative(BuildSourcePath_Behavior.call_getLocalPath_5481553824944787364(SLinkOperations.getTarget(_context.getNode(), "folder", true), Context.defaultContext(_context)));
      if (relative == null) {
        _context.showErrorMessage(SLinkOperations.getTarget(_context.getNode(), "folder", true), "model root folder should be placed under module: " + BuildSourcePath_Behavior.call_getRelativePath_5481553824944787371(SLinkOperations.getTarget(_context.getNode(), "folder", true)));
      }
      return relative;
    } catch (RelativePathHelper.PathException ex) {
      _context.showErrorMessage(SLinkOperations.getTarget(_context.getNode(), "folder", true), "cannot build relative path: " + ex.getMessage());
      return "???";
    }
  }

  public static Object referenceMacro_GetReferent_4267986820121149131(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    SNode targetModule = (SNode) _context.getNode().getReferent("targetModule");
    return _context.getOutputNodeByInputNodeAndMappingLabel(targetModule, "javaModule");
  }

  public static Object referenceMacro_GetReferent_7259033139236507287(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    SNode targetModule = (SNode) _context.getNode().getReferent("targetModule");
    return _context.getCopiedOutputNodeForInputNode(targetModule);
  }

  public static Object referenceMacro_GetReferent_1692280246134778952(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return _context.getOutputNodeByInputNodeAndMappingLabel(SLinkOperations.getTarget(_context.getNode(), "module", false), "javaModule");
  }

  public static boolean ifMacro_Condition_8369506495128850763(final IOperationContext operationContext, final IfMacroContext _context) {
    return (SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "module", false), "path", true) != null);
  }

  public static boolean ifMacro_Condition_8654221991637237394(final IOperationContext operationContext, final IfMacroContext _context) {
    return (SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "module", false), "path", true) != null);
  }

  public static boolean ifMacro_Condition_8654221991637263558(final IOperationContext operationContext, final IfMacroContext _context) {
    return (SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "module", false), "path", true) != null);
  }

  public static SNode sourceNodeQuery_2303926226081111358(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "folder", true);
  }

  public static SNode sourceNodeQuery_3717132724153193351(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return _context.getNode();
  }

  public static SNode sourceNodeQuery_8369506495128850710(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "module", false), "path", true);
  }

  public static SNode sourceNodeQuery_8654221991637113346(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return BuildSourcePath_Behavior.call_getParent_8654221991637145399(SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "module", false), "path", true));
  }

  public static SNode sourceNodeQuery_8654221991637263395(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "folder", true);
  }

  public static Iterable sourceNodesQuery_2303926226081111354(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return ListSequence.fromList(SLinkOperations.getTargets(_context.getNode(), "sources", true)).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return SNodeOperations.isInstanceOf(it, "jetbrains.mps.build.mps.structure.BuildMps_ModuleJavaSource");
      }
    }).select(new ISelector<SNode, SNode>() {
      public SNode select(SNode it) {
        return SNodeOperations.cast(it, "jetbrains.mps.build.mps.structure.BuildMps_ModuleJavaSource");
      }
    });
  }

  public static Iterable sourceNodesQuery_4267986820121149056(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    List<SNode> result = new ArrayList<SNode>();
    for (SNode mod : Sequence.fromIterable(((Tuples._3<SNode, Iterable<SNode>, Iterable<SNode>>) _context.getVariable("var:mdeps"))._1()).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return SPropertyOperations.getBoolean(it, "doNotCompile") == false && SNodeOperations.getContainingRoot(((Tuples._3<SNode, Iterable<SNode>, Iterable<SNode>>) _context.getVariable("var:mdeps"))._0()) == SNodeOperations.getContainingRoot(_context.getNode());
      }
    }).sort(new ISelector<SNode, Comparable<?>>() {
      public Comparable<?> select(SNode it) {
        return SPropertyOperations.getString(it, "name");
      }
    }, true)) {
      SNode loopnode = SModelOperations.createNewNode(_context.getOutputModel(), "jetbrains.mps.lang.core.structure.BaseConcept", null);
      loopnode.setReferent("targetModule", mod, false);
      ListSequence.fromList(result).addElement(loopnode);
    }
    return result;
  }

  public static Iterable sourceNodesQuery_7259033139236497711(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    Iterable<SNode> reexportedFromModuleDependencies = Sequence.fromIterable(((Tuples._3<SNode, Iterable<SNode>, Iterable<SNode>>) _context.getVariable("var:mdeps"))._1()).concat(Sequence.fromIterable(Sequence.<SNode>singleton(((Tuples._3<SNode, Iterable<SNode>, Iterable<SNode>>) _context.getVariable("var:mdeps"))._0()))).translate(new ITranslator2<SNode, SNode>() {
      public Iterable<SNode> translate(SNode mod) {
        return ListSequence.fromList(SLinkOperations.getTargets(mod, "dependencies", true)).where(new IWhereFilter<SNode>() {
          public boolean accept(SNode it) {
            return SNodeOperations.isInstanceOf(it, "jetbrains.mps.build.mps.structure.BuildMps_ModuleDependencyOnJavaModule") && SPropertyOperations.getBoolean(SNodeOperations.cast(it, "jetbrains.mps.build.mps.structure.BuildMps_ModuleDependencyOnJavaModule"), "reexport");
          }
        }).select(new ISelector<SNode, SNode>() {
          public SNode select(SNode it) {
            return SLinkOperations.getTarget(SNodeOperations.cast(it, "jetbrains.mps.build.mps.structure.BuildMps_ModuleDependencyOnJavaModule"), "module", false);
          }
        });
      }
    });
    Set<SNode> reexportMods = SetSequence.fromSet(new HashSet<SNode>());
    for (SNode mod : reexportedFromModuleDependencies) {
      SetSequence.fromSet(reexportMods).addElement(mod);
    }
    Iterable<SNode> directDeps = ListSequence.fromList(SLinkOperations.getTargets(_context.getNode(), "dependencies", true)).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return SNodeOperations.isInstanceOf(it, "jetbrains.mps.build.mps.structure.BuildMps_ModuleDependencyOnJavaModule");
      }
    }).select(new ISelector<SNode, SNode>() {
      public SNode select(SNode it) {
        return SLinkOperations.getTarget(SNodeOperations.cast(it, "jetbrains.mps.build.mps.structure.BuildMps_ModuleDependencyOnJavaModule"), "module", false);
      }
    });
    SetSequence.fromSet(reexportMods).addSequence(ListSequence.fromList(SLinkOperations.getTargets(_context.getNode(), "dependencies", true)).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return SNodeOperations.isInstanceOf(it, "jetbrains.mps.build.mps.structure.BuildMps_ModuleDependencyOnJavaModule") && SPropertyOperations.getBoolean(SNodeOperations.cast(it, "jetbrains.mps.build.mps.structure.BuildMps_ModuleDependencyOnJavaModule"), "reexport");
      }
    }).select(new ISelector<SNode, SNode>() {
      public SNode select(SNode it) {
        return SLinkOperations.getTarget(SNodeOperations.cast(it, "jetbrains.mps.build.mps.structure.BuildMps_ModuleDependencyOnJavaModule"), "module", false);
      }
    }));
    List<SNode> result = new ArrayList<SNode>();
    for (SNode mod : Sequence.fromIterable(reexportedFromModuleDependencies).concat(Sequence.fromIterable(directDeps))) {
      SNode loopnode = SModelOperations.createNewNode(_context.getOutputModel(), "jetbrains.mps.lang.core.structure.BaseConcept", null);
      loopnode.setReferent("targetModule", mod, false);
      if (SetSequence.fromSet(reexportMods).contains(mod)) {
        loopnode.setProperty("targetReexport", "true", false);
      }
      ListSequence.fromList(result).addElement(loopnode);
    }
    return result;
  }

  public static Iterable sourceNodesQuery_3717132724153192091(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    List<SNode> result = new ArrayList<SNode>();
    for (SNode lang : Sequence.fromIterable(((Tuples._3<SNode, Iterable<SNode>, Iterable<SNode>>) _context.getVariable("var:mdeps"))._2()).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return SNodeOperations.getContainingRoot(((Tuples._3<SNode, Iterable<SNode>, Iterable<SNode>>) _context.getVariable("var:mdeps"))._0()) == SNodeOperations.getContainingRoot(_context.getNode());
      }
    }).sort(new ISelector<SNode, Comparable<?>>() {
      public Comparable<?> select(SNode it) {
        return SPropertyOperations.getString(it, "name");
      }
    }, true)) {
      for (SNode runtime : SLinkOperations.getTargets(lang, "runtime", true)) {
        if (!(SNodeOperations.isInstanceOf(runtime, "jetbrains.mps.build.mps.structure.BuildMps_ModuleJarRuntime"))) {
          continue;
        }
        ListSequence.fromList(result).addElement(SNodeOperations.copyNode(SLinkOperations.getTarget(SNodeOperations.cast(runtime, "jetbrains.mps.build.mps.structure.BuildMps_ModuleJarRuntime"), "path", true)));
      }
    }
    return result;
  }

  public static Iterable sourceNodesQuery_1500819558096263527(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "modules", true);
  }

  public static Iterable sourceNodesQuery_8654221991637263183(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return ListSequence.fromList(SLinkOperations.getTargets(SLinkOperations.getTarget(_context.getNode(), "module", false), "sources", true)).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return SNodeOperations.isInstanceOf(it, "jetbrains.mps.build.mps.structure.BuildMps_ModuleModelRoot");
      }
    }).select(new ISelector<SNode, SNode>() {
      public SNode select(SNode it) {
        return SNodeOperations.cast(it, "jetbrains.mps.build.mps.structure.BuildMps_ModuleModelRoot");
      }
    });
  }

  public static void mappingScript_CodeBlock_3189788309732145595(final IOperationContext operationContext, final MappingScriptContext _context) {
    for (SNode project : SModelOperations.getRoots(_context.getModel(), "jetbrains.mps.build.structure.BuildProject")) {
      if (!(_context.isDirty(project))) {
        continue;
      }

      SNode originalProject = SNodeOperations.as(_context.getOriginalCopiedInputNode(project), "jetbrains.mps.build.structure.BuildProject");
      if ((originalProject == null)) {
        _context.showErrorMessage(project, "no original project is found for " + SPropertyOperations.getString(project, "name"));
        continue;
      }
      PathConverter pathConverter = new PathConverter(originalProject);

      VisibleModules visibleModules = new VisibleModules(project, _context);
      visibleModules.collect();

      Iterable<SNode> parts = SLinkOperations.getTargets(project, "parts", true);
      parts = Sequence.fromIterable(parts).where(new IWhereFilter<SNode>() {
        public boolean accept(SNode it) {
          return SNodeOperations.isInstanceOf(it, "jetbrains.mps.build.mps.structure.BuildMps_Group");
        }
      }).translate(new ITranslator2<SNode, SNode>() {
        public Iterable<SNode> translate(SNode it) {
          return SLinkOperations.getTargets(SNodeOperations.cast(it, "jetbrains.mps.build.mps.structure.BuildMps_Group"), "modules", true);
        }
      }).union(Sequence.fromIterable(parts));
      for (SNode part : parts) {
        if (!(SNodeOperations.isInstanceOf(part, "jetbrains.mps.build.mps.structure.BuildMps_AbstractModule"))) {
          continue;
        }
        SNode module = SNodeOperations.cast(part, "jetbrains.mps.build.mps.structure.BuildMps_AbstractModule");
        if ((SLinkOperations.getTarget(module, "path", true) == null)) {
          continue;
        }

        new ModuleLoader(module, visibleModules, pathConverter, _context).loadAndCheck();
      }
    }
  }

  public static Object insertMacro_varValue_4267986820121148965(final IOperationContext operationContext, final TemplateQueryContext _context) {
    Set<SNode> modules = new LinkedHashSet<SNode>();
    Set<SNode> usedLanguages = new LinkedHashSet<SNode>();
    BuildModuleUtil.collectAllCompileTimeDependencies(_context.getNode(), modules, usedLanguages);
    return MultiTuple.<SNode,Set<SNode>,Set<SNode>>from(_context.getNode(), modules, usedLanguages);
  }

  public static Object insertMacro_varValue_8654221991637263463(final IOperationContext operationContext, final TemplateQueryContext _context) {
    return new RelativePathHelper(BuildSourcePath_Behavior.call_getLocalPath_5481553824944787364(SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "module", false), "path", true), Context.defaultContext(_context)));
  }
}
