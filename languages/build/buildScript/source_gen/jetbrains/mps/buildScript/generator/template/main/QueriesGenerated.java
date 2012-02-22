package jetbrains.mps.buildScript.generator.template.main;

/*Generated by MPS */

import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.generator.template.BaseMappingRuleContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.generator.template.PropertyMacroContext;
import jetbrains.mps.buildScript.behavior.BuildLayout_AbstractContainer_Behavior;
import jetbrains.mps.buildScript.util.Context;
import jetbrains.mps.buildScript.behavior.BuildLayout_NamedContainer_Behavior;
import jetbrains.mps.buildScript.behavior.BuildSourcePath_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.internal.collections.runtime.ILeftCombinator;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.buildScript.behavior.BuildSource_JavaModule_Behavior;
import jetbrains.mps.buildScript.behavior.BuildProject_Behavior;
import jetbrains.mps.util.FileUtil;
import jetbrains.mps.generator.template.ReferenceMacroContext;
import jetbrains.mps.generator.template.IfMacroContext;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.generator.template.SourceSubstituteMacroNodeContext;
import jetbrains.mps.generator.template.SourceSubstituteMacroNodesContext;
import jetbrains.mps.generator.template.MappingScriptContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.buildScript.util.GenerationUtil;

public class QueriesGenerated {
  public static boolean baseMappingRule_Condition_5248329904288166450(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return !(SNodeOperations.isInstanceOf(SNodeOperations.getParent(_context.getNode()), "jetbrains.mps.buildScript.structure.BuildLayout_ContainerAcceptingFileSet"));
  }

  public static Object propertyMacro_GetPropertyValue_1117643560963267883(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return BuildLayout_AbstractContainer_Behavior.call_getChildrenOutputDir_WithMacro_7389400916848004880(_context.getNode(), Context.defaulContext(_context));
  }

  public static Object propertyMacro_GetPropertyValue_1117643560963268263(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return BuildLayout_AbstractContainer_Behavior.call_getPrepareSubTaskId_1117643560963359337(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_1117643560963364006(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return BuildLayout_AbstractContainer_Behavior.call_getAssembleSubTaskId_1117643560963359375(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_1117643560963358439(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return BuildLayout_AbstractContainer_Behavior.call_getChildrenOutputDir_WithMacro_7389400916848004880(_context.getNode(), Context.defaulContext(_context));
  }

  public static Object propertyMacro_GetPropertyValue_1117643560963358405(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return BuildLayout_AbstractContainer_Behavior.call_getPrepareSubTaskId_1117643560963359337(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_1117643560963268231(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return BuildLayout_NamedContainer_Behavior.call_getOutputPath_WithMacro_280273048052535414(_context.getNode(), Context.defaulContext(_context));
  }

  public static Object propertyMacro_GetPropertyValue_1117643560963351294(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return BuildLayout_AbstractContainer_Behavior.call_getChildrenOutputDir_WithMacro_7389400916848004880(_context.getNode(), Context.defaulContext(_context));
  }

  public static Object propertyMacro_GetPropertyValue_1117643560963268242(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return BuildLayout_AbstractContainer_Behavior.call_getAssembleSubTaskId_1117643560963359375(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_1117643560963358510(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return BuildLayout_AbstractContainer_Behavior.call_getChildrenOutputDir_WithMacro_7389400916848004880(_context.getNode(), Context.defaulContext(_context));
  }

  public static Object propertyMacro_GetPropertyValue_1117643560963358520(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return BuildLayout_AbstractContainer_Behavior.call_getPrepareSubTaskId_1117643560963359337(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_1117643560963358535(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return BuildLayout_NamedContainer_Behavior.call_getOutputPath_WithMacro_280273048052535414(_context.getNode(), Context.defaulContext(_context));
  }

  public static Object propertyMacro_GetPropertyValue_1117643560963358569(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return BuildLayout_AbstractContainer_Behavior.call_getChildrenOutputDir_WithMacro_7389400916848004880(_context.getNode(), Context.defaulContext(_context));
  }

  public static Object propertyMacro_GetPropertyValue_1117643560963358598(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return BuildLayout_AbstractContainer_Behavior.call_getAssembleSubTaskId_1117643560963359375(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_5248329904288079307(final IOperationContext operationContext, final PropertyMacroContext _context) {
    if (!(SNodeOperations.isInstanceOf(SNodeOperations.getParent(_context.getNode()), "jetbrains.mps.buildScript.structure.BuildLayout_AbstractContainer"))) {
      _context.showErrorMessage(_context.getNode(), "parent should be abstract layout container");
      return "???";
    }
    return BuildLayout_AbstractContainer_Behavior.call_getChildrenOutputDir_WithMacro_7389400916848004880(SNodeOperations.cast(SNodeOperations.getParent(_context.getNode()), "jetbrains.mps.buildScript.structure.BuildLayout_AbstractContainer"), Context.defaulContext(_context));
  }

  public static Object propertyMacro_GetPropertyValue_5248329904288131577(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return "copy." + _context.getNode().getId();
  }

  public static Object propertyMacro_GetPropertyValue_1117643560963307392(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return BuildSourcePath_Behavior.call_getRelativePath_5481553824944787371(SLinkOperations.getTarget(_context.getNode(), "defaultPath", true));
  }

  public static Object propertyMacro_GetPropertyValue_1117643560963307395(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name");
  }

  public static Object propertyMacro_GetPropertyValue_8237269006869516510(final IOperationContext operationContext, final PropertyMacroContext _context) {
    if (ListSequence.fromList(SLinkOperations.getTargets(_context.getNode(), "value", true)).isNotEmpty()) {
      return ListSequence.fromList(SLinkOperations.getTargets(_context.getNode(), "value", true)).foldLeft("", new ILeftCombinator<SNode, String>() {
        public String combine(String s, SNode it) {
          return s + check_x583g4_a0a0a0a0a0a81(it);
        }
      });
    }
    return SPropertyOperations.getString(_context.getNode(), "name").toUpperCase();
  }

  public static Object propertyMacro_GetPropertyValue_8237269006869516519(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name");
  }

  public static Object propertyMacro_GetPropertyValue_6420586245471622081(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return ListSequence.fromList(SLinkOperations.getTargets(_context.getNode(), "value", true)).isEmpty();
  }

  public static Object propertyMacro_GetPropertyValue_8237269006869525279(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "defaultPath");
  }

  public static Object propertyMacro_GetPropertyValue_8237269006869525288(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name");
  }

  public static Object propertyMacro_GetPropertyValue_1117643560963346388(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name");
  }

  public static Object propertyMacro_GetPropertyValue_1117643560963346427(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return BuildSource_JavaModule_Behavior.call_getOutputFolder_1117643560963346267(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_7926701909975671869(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return BuildSourcePath_Behavior.call_getRelativePath_5481553824944787371(SLinkOperations.getTarget(SNodeOperations.cast(SNodeOperations.getParent(_context.getNode()), "jetbrains.mps.buildScript.structure.BuildSource_JavaContentRoot"), "basePath", true)) + "/" + SPropertyOperations.getString(_context.getNode(), "relativePath");
  }

  public static Object propertyMacro_GetPropertyValue_6647099934207255538(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return "java.library." + SPropertyOperations.getString(_context.getNode(), "name");
  }

  public static Object propertyMacro_GetPropertyValue_5248329904288079406(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return BuildSourcePath_Behavior.call_getRelativePath_5481553824944787371(SLinkOperations.getTarget(_context.getNode(), "dir", true));
  }

  public static Object propertyMacro_GetPropertyValue_5248329904288079452(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return BuildSourcePath_Behavior.call_getRelativePath_5481553824944787371(SLinkOperations.getTarget(_context.getNode(), "path", true));
  }

  public static Object propertyMacro_GetPropertyValue_5248329904288082868(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "pattern");
  }

  public static Object propertyMacro_GetPropertyValue_5248329904288082882(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "pattern");
  }

  public static Object propertyMacro_GetPropertyValue_8292198017262947209(final IOperationContext operationContext, final PropertyMacroContext _context) {
    String basePath = BuildProject_Behavior.call_getScriptsPath_4796668409958419284(SNodeOperations.getAncestor(_context.getNode(), "jetbrains.mps.buildScript.structure.BuildProject", false, false), Context.defaulContext(_context));
    SNode script = SLinkOperations.getTarget(SNodeOperations.cast(_context.getNode(), "jetbrains.mps.buildScript.structure.BuildProjectDependency"), "script", false);
    String filePath = BuildProject_Behavior.call_getBasePath_4959435991187146924(script, Context.defaulContext(_context)) + "/build/artifacts/" + SPropertyOperations.getString(script, "name") + ".artifacts/" + SPropertyOperations.getString(script, "name") + ".variables.properties";
    return FileUtil.getRelativePath(filePath, basePath, "/");
  }

  public static Object propertyMacro_GetPropertyValue_5662391463398094397(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return Context.defaulContext(_context).getVariablesDeployPath(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_5662391463398078669(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return Context.defaulContext(_context).getBuildProjectName(_context.getNode()) + "." + SPropertyOperations.getString(_context.getNode(), "name") + "=${" + SPropertyOperations.getString(_context.getNode(), "name") + "}";
  }

  public static Object propertyMacro_GetPropertyValue_3595702787188242919(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name");
  }

  public static Object propertyMacro_GetPropertyValue_5096397858823409284(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return Context.defaulContext(_context).getTmpPath_WithMacro(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_5178006408628664059(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return BuildProject_Behavior.call_getBasePathRelativeToScriptsPath_5178006408628632053(_context.getNode(), Context.defaulContext(_context));
  }

  public static Object propertyMacro_GetPropertyValue_1117643560963351184(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return BuildSource_JavaModule_Behavior.call_getOutputFolder_1117643560963346267(SLinkOperations.getTarget(_context.getNode(), "module", false));
  }

  public static Object referenceMacro_GetReferent_1117643560963363815(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return BuildLayout_AbstractContainer_Behavior.call_getPrepareSubTaskId_1117643560963359337(SNodeOperations.cast(SNodeOperations.getParent(_context.getNode()), "jetbrains.mps.buildScript.structure.BuildLayout_AbstractContainer"));
  }

  public static Object referenceMacro_GetReferent_1117643560963363967(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return BuildLayout_AbstractContainer_Behavior.call_getAssembleSubTaskId_1117643560963359375(SNodeOperations.cast(SNodeOperations.getParent(_context.getNode()), "jetbrains.mps.buildScript.structure.BuildLayout_AbstractContainer"));
  }

  public static Object referenceMacro_GetReferent_1117643560963360514(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return BuildLayout_AbstractContainer_Behavior.call_getPrepareSubTaskId_1117643560963359337(SNodeOperations.cast(SNodeOperations.getParent(_context.getNode()), "jetbrains.mps.buildScript.structure.BuildLayout_AbstractContainer"));
  }

  public static Object referenceMacro_GetReferent_1117643560963363928(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return BuildLayout_AbstractContainer_Behavior.call_getAssembleSubTaskId_1117643560963359375(SNodeOperations.cast(SNodeOperations.getParent(_context.getNode()), "jetbrains.mps.buildScript.structure.BuildLayout_AbstractContainer"));
  }

  public static Object referenceMacro_GetReferent_1117643560963363847(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return BuildLayout_AbstractContainer_Behavior.call_getPrepareSubTaskId_1117643560963359337(SNodeOperations.cast(SNodeOperations.getParent(_context.getNode()), "jetbrains.mps.buildScript.structure.BuildLayout_AbstractContainer"));
  }

  public static Object referenceMacro_GetReferent_1117643560963363898(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return BuildLayout_AbstractContainer_Behavior.call_getAssembleSubTaskId_1117643560963359375(SNodeOperations.cast(SNodeOperations.getParent(_context.getNode()), "jetbrains.mps.buildScript.structure.BuildLayout_AbstractContainer"));
  }

  public static Object referenceMacro_GetReferent_5248329904288129346(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return BuildLayout_AbstractContainer_Behavior.call_getPrepareSubTaskId_1117643560963359337(SNodeOperations.cast(SNodeOperations.getParent(_context.getNode()), "jetbrains.mps.buildScript.structure.BuildLayout_AbstractContainer"));
  }

  public static Object referenceMacro_GetReferent_5248329904288129316(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return BuildLayout_AbstractContainer_Behavior.call_getAssembleSubTaskId_1117643560963359375(SNodeOperations.cast(SNodeOperations.getParent(_context.getNode()), "jetbrains.mps.buildScript.structure.BuildLayout_AbstractContainer"));
  }

  public static Object referenceMacro_GetReferent_7926701909975926443(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return _context.getOutputNodeByInputNodeAndMappingLabel(SLinkOperations.getTarget(_context.getNode(), "library", false), "javalibrary");
  }

  public static Object referenceMacro_GetReferent_6647099934207033995(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return _context.getOutputNodeByInputNodeAndMappingLabel(SLinkOperations.getTarget(_context.getNode(), "module", false), "javamodule");
  }

  public static boolean ifMacro_Condition_1117643560963363812(final IOperationContext operationContext, final IfMacroContext _context) {
    return SNodeOperations.isInstanceOf(SNodeOperations.getParent(_context.getNode()), "jetbrains.mps.buildScript.structure.BuildLayout_AbstractContainer") && BuildLayout_AbstractContainer_Behavior.call_getPrepareSubTaskId_1117643560963359337(SNodeOperations.cast(SNodeOperations.getParent(_context.getNode()), "jetbrains.mps.buildScript.structure.BuildLayout_AbstractContainer")) != null;
  }

  public static boolean ifMacro_Condition_1117643560963363971(final IOperationContext operationContext, final IfMacroContext _context) {
    return SNodeOperations.isInstanceOf(SNodeOperations.getParent(_context.getNode()), "jetbrains.mps.buildScript.structure.BuildLayout_AbstractContainer") && BuildLayout_AbstractContainer_Behavior.call_getAssembleSubTaskId_1117643560963359375(SNodeOperations.cast(SNodeOperations.getParent(_context.getNode()), "jetbrains.mps.buildScript.structure.BuildLayout_AbstractContainer")) != null;
  }

  public static boolean ifMacro_Condition_1117643560963369195(final IOperationContext operationContext, final IfMacroContext _context) {
    return ListSequence.fromList(SLinkOperations.getTargets(_context.getNode(), "children", true)).any(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return !(SNodeOperations.isInstanceOf(it, "jetbrains.mps.buildScript.structure.BuildLayout_FileSet"));
      }
    });
  }

  public static boolean ifMacro_Condition_1117643560963359504(final IOperationContext operationContext, final IfMacroContext _context) {
    return SNodeOperations.isInstanceOf(SNodeOperations.getParent(_context.getNode()), "jetbrains.mps.buildScript.structure.BuildLayout_AbstractContainer") && BuildLayout_AbstractContainer_Behavior.call_getPrepareSubTaskId_1117643560963359337(SNodeOperations.cast(SNodeOperations.getParent(_context.getNode()), "jetbrains.mps.buildScript.structure.BuildLayout_AbstractContainer")) != null;
  }

  public static boolean ifMacro_Condition_1117643560963351259(final IOperationContext operationContext, final IfMacroContext _context) {
    return ListSequence.fromList(SLinkOperations.getTargets(_context.getNode(), "children", true)).any(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return !(SNodeOperations.isInstanceOf(it, "jetbrains.mps.buildScript.structure.BuildLayout_FileSet"));
      }
    });
  }

  public static boolean ifMacro_Condition_1117643560963363924(final IOperationContext operationContext, final IfMacroContext _context) {
    return SNodeOperations.isInstanceOf(SNodeOperations.getParent(_context.getNode()), "jetbrains.mps.buildScript.structure.BuildLayout_AbstractContainer") && BuildLayout_AbstractContainer_Behavior.call_getAssembleSubTaskId_1117643560963359375(SNodeOperations.cast(SNodeOperations.getParent(_context.getNode()), "jetbrains.mps.buildScript.structure.BuildLayout_AbstractContainer")) != null;
  }

  public static boolean ifMacro_Condition_1117643560963369175(final IOperationContext operationContext, final IfMacroContext _context) {
    return ListSequence.fromList(SLinkOperations.getTargets(_context.getNode(), "children", true)).any(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return !(SNodeOperations.isInstanceOf(it, "jetbrains.mps.buildScript.structure.BuildLayout_FileSet"));
      }
    });
  }

  public static boolean ifMacro_Condition_1117643560963363844(final IOperationContext operationContext, final IfMacroContext _context) {
    return SNodeOperations.isInstanceOf(SNodeOperations.getParent(_context.getNode()), "jetbrains.mps.buildScript.structure.BuildLayout_AbstractContainer") && BuildLayout_AbstractContainer_Behavior.call_getPrepareSubTaskId_1117643560963359337(SNodeOperations.cast(SNodeOperations.getParent(_context.getNode()), "jetbrains.mps.buildScript.structure.BuildLayout_AbstractContainer")) != null;
  }

  public static boolean ifMacro_Condition_1117643560963358578(final IOperationContext operationContext, final IfMacroContext _context) {
    return ListSequence.fromList(SLinkOperations.getTargets(_context.getNode(), "children", true)).any(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return !(SNodeOperations.isInstanceOf(it, "jetbrains.mps.buildScript.structure.BuildLayout_FileSet"));
      }
    });
  }

  public static boolean ifMacro_Condition_1117643560963363876(final IOperationContext operationContext, final IfMacroContext _context) {
    return SNodeOperations.isInstanceOf(SNodeOperations.getParent(_context.getNode()), "jetbrains.mps.buildScript.structure.BuildLayout_AbstractContainer") && BuildLayout_AbstractContainer_Behavior.call_getAssembleSubTaskId_1117643560963359375(SNodeOperations.cast(SNodeOperations.getParent(_context.getNode()), "jetbrains.mps.buildScript.structure.BuildLayout_AbstractContainer")) != null;
  }

  public static boolean ifMacro_Condition_5248329904288129327(final IOperationContext operationContext, final IfMacroContext _context) {
    return SNodeOperations.isInstanceOf(SNodeOperations.getParent(_context.getNode()), "jetbrains.mps.buildScript.structure.BuildLayout_AbstractContainer") && BuildLayout_AbstractContainer_Behavior.call_getPrepareSubTaskId_1117643560963359337(SNodeOperations.cast(SNodeOperations.getParent(_context.getNode()), "jetbrains.mps.buildScript.structure.BuildLayout_AbstractContainer")) != null;
  }

  public static boolean ifMacro_Condition_5248329904288129297(final IOperationContext operationContext, final IfMacroContext _context) {
    return SNodeOperations.isInstanceOf(SNodeOperations.getParent(_context.getNode()), "jetbrains.mps.buildScript.structure.BuildLayout_AbstractContainer") && BuildLayout_AbstractContainer_Behavior.call_getAssembleSubTaskId_1117643560963359375(SNodeOperations.cast(SNodeOperations.getParent(_context.getNode()), "jetbrains.mps.buildScript.structure.BuildLayout_AbstractContainer")) != null;
  }

  public static SNode sourceNodeQuery_5248329904288175557(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "fileset", true);
  }

  public static SNode sourceNodeQuery_5248329904288198651(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "resset", true);
  }

  public static SNode sourceNodeQuery_5248329904288140540(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "fileset", true);
  }

  public static Iterable sourceNodesQuery_1117643560963351248(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return ListSequence.fromList(SLinkOperations.getTargets(_context.getNode(), "children", true)).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return SNodeOperations.isInstanceOf(it, "jetbrains.mps.buildScript.structure.BuildLayout_FileSet");
      }
    });
  }

  public static Iterable sourceNodesQuery_1117643560963358547(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return ListSequence.fromList(SLinkOperations.getTargets(_context.getNode(), "children", true)).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return SNodeOperations.isInstanceOf(it, "jetbrains.mps.buildScript.structure.BuildLayout_FileSet");
      }
    });
  }

  public static Iterable sourceNodesQuery_7926701909975671841(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "sources", true);
  }

  public static Iterable sourceNodesQuery_6647099934207033969(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "dependencies", true);
  }

  public static Iterable sourceNodesQuery_7926701909975671863(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return ListSequence.fromList(SLinkOperations.getTargets(_context.getNode(), "folders", true)).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return SPropertyOperations.hasValue(it, "kind", "source", null);
      }
    });
  }

  public static Iterable sourceNodesQuery_6647099934207253927(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "elements", true);
  }

  public static Iterable sourceNodesQuery_5248329904288079434(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "selectors", true);
  }

  public static Iterable sourceNodesQuery_8292198017262947202(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return ListSequence.fromList(SLinkOperations.getTargets(_context.getNode(), "dependencies", true)).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return SNodeOperations.isInstanceOf(it, "jetbrains.mps.buildScript.structure.BuildProjectDependency");
      }
    });
  }

  public static Iterable sourceNodesQuery_1117643560963307378(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "macros", true);
  }

  public static Iterable sourceNodesQuery_6420586245471523378(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return Context.defaulContext(_context).getExportedMacro(_context.getNode());
  }

  public static Iterable sourceNodesQuery_6647099934206970618(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "plugins", true);
  }

  public static Iterable sourceNodesQuery_1117643560963346309(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "parts", true);
  }

  public static Iterable sourceNodesQuery_1117643560963267906(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SNodeOperations.getDescendants(SLinkOperations.getTarget(_context.getNode(), "layout", true), "jetbrains.mps.buildScript.structure.BuildLayout_Node", false, new String[]{});
  }

  public static Iterable sourceNodesQuery_5662391463398047139(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return ListSequence.fromList(SLinkOperations.getTargets(_context.getNode(), "macros", true)).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return SNodeOperations.isInstanceOf(it, "jetbrains.mps.buildScript.structure.BuildVariableMacro");
      }
    });
  }

  public static Iterable sourceNodesQuery_6647099934206970591(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "plugins", true);
  }

  public static void mappingScript_CodeBlock_809559803149973643(final IOperationContext operationContext, final MappingScriptContext _context) {
    for (SNode buildProject : ListSequence.fromList(SModelOperations.getRoots(_context.getModel(), "jetbrains.mps.buildScript.structure.BuildProject"))) {
      buildProject.putUserObject(GenerationUtil.SCRIPTS_DIR_PROPERTY, BuildProject_Behavior.call_getScriptsPath_4796668409958419284(buildProject, Context.defaulContext(_context)));
    }
  }

  private static String check_x583g4_a0a0a0a0a0a81(SNode checkedDotOperand) {
    if (null != checkedDotOperand) {
      return SPropertyOperations.getString(checkedDotOperand, "name");
    }
    return null;
  }
}
