package jetbrains.mps.build.workflow.generator.template.main;

/*Generated by MPS */

import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.generator.template.BaseMappingRuleContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.generator.template.PropertyMacroContext;
import jetbrains.mps.build.workflow.behavior.BwfPathDeclaration_Behavior;
import jetbrains.mps.build.workflow.behavior.BwfJavaModule_Behavior;
import jetbrains.mps.generator.template.ReferenceMacroContext;
import jetbrains.mps.generator.template.IfMacroContext;
import org.apache.commons.lang.StringUtils;
import jetbrains.mps.generator.template.SourceSubstituteMacroNodeContext;
import jetbrains.mps.generator.template.SourceSubstituteMacroNodesContext;
import java.util.List;
import java.util.ArrayList;
import jetbrains.mps.build.workflow.generator.util.SubTaskOrderHelper;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.generator.template.MapSrcMacroPostProcContext;
import jetbrains.mps.generator.template.MappingScriptContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.build.workflow.generator.util.CycleHelper;
import jetbrains.mps.build.workflow.constraints.TaskLibrariesHelper;
import jetbrains.mps.generator.template.TemplateQueryContext;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.internal.collections.runtime.Sequence;

public class QueriesGenerated {
  public static boolean baseMappingRule_Condition_6896005762093594382(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return SPropertyOperations.getBoolean(_context.getNode(), "isLocation");
  }

  public static boolean baseMappingRule_Condition_6896005762093594466(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return !(SPropertyOperations.getBoolean(_context.getNode(), "exportToProperiesFile"));
  }

  public static boolean baseMappingRule_Condition_6896005762093594481(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return ListSequence.fromList(SLinkOperations.getTargets(_context.getNode(), "parts", true)).any(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return SNodeOperations.isInstanceOf(it, "jetbrains.mps.build.workflow.structure.BwfMacro") && SPropertyOperations.getBoolean(SNodeOperations.cast(it, "jetbrains.mps.build.workflow.structure.BwfMacro"), "exportToProperiesFile");
      }
    });
  }

  public static Object propertyMacro_GetPropertyValue_7385586609667799735(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name");
  }

  public static Object propertyMacro_GetPropertyValue_7385586609667799764(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return ((String) _context.getVariable("var:deps"));
  }

  public static Object propertyMacro_GetPropertyValue_6896005762093594424(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name");
  }

  public static Object propertyMacro_GetPropertyValue_6896005762093594421(final IOperationContext operationContext, final PropertyMacroContext _context) {
    if (SPropertyOperations.getBoolean(_context.getNode(), "exportToProperiesFile")) {
      return "${" + SPropertyOperations.getString(_context.getNode(), "name") + ".relative}";
    }
    return SPropertyOperations.getString(_context.getNode(), "defaultValue");
  }

  public static Object propertyMacro_GetPropertyValue_6896005762093594571(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name");
  }

  public static Object propertyMacro_GetPropertyValue_6896005762093594580(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "defaultValue");
  }

  public static Object propertyMacro_GetPropertyValue_6647099934207210759(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return BwfPathDeclaration_Behavior.call_getPathId_6647099934207210775(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_6647099934207210826(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return BwfPathDeclaration_Behavior.call_getPathId_6647099934207210775(SLinkOperations.getTarget(_context.getNode(), "target", false));
  }

  public static Object propertyMacro_GetPropertyValue_6896005762093597646(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name") + ".properties";
  }

  public static Object propertyMacro_GetPropertyValue_2769948622284790870(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name");
  }

  public static Object propertyMacro_GetPropertyValue_2769948622284790884(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name");
  }

  public static Object propertyMacro_GetPropertyValue_6647099934207240034(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "path");
  }

  public static Object propertyMacro_GetPropertyValue_6647099934207240060(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "outputFolder");
  }

  public static Object propertyMacro_GetPropertyValue_6647099934207240067(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return BwfJavaModule_Behavior.call_getAntTargetName_7385586609667776611(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_6647099934206976156(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "path");
  }

  public static Object propertyMacro_GetPropertyValue_6647099934206976176(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(SLinkOperations.getTarget(_context.getNode(), "target", false), "outputFolder");
  }

  public static Object propertyMacro_GetPropertyValue_6896005762093592339(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return (SPropertyOperations.getBoolean(_context.getNode(), "isLocation") ?
      SPropertyOperations.getString(_context.getNode(), "name") + ".relative" :
      SPropertyOperations.getString(_context.getNode(), "name")
    );
  }

  public static Object propertyMacro_GetPropertyValue_6896005762093592358(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "defaultValue");
  }

  public static Object propertyMacro_GetPropertyValue_6896005762093592229(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name");
  }

  public static Object referenceMacro_GetReferent_6647099934207245024(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return _context.getOutputNodeByInputNodeAndMappingLabel(_context.getNode(), "java2task");
  }

  public static Object referenceMacro_GetReferent_7385586609667819796(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return _context.getOutputNodeByInputNodeAndMappingLabel(SLinkOperations.getTarget(_context.getNode(), "target", false), "java2task");
  }

  public static boolean ifMacro_Condition_7385586609667799754(final IOperationContext operationContext, final IfMacroContext _context) {
    return StringUtils.isNotEmpty(((String) _context.getVariable("var:deps")));
  }

  public static boolean ifMacro_Condition_6896005762093597671(final IOperationContext operationContext, final IfMacroContext _context) {
    return ListSequence.fromList(SLinkOperations.getTargets(_context.getNode(), "parts", true)).any(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return SNodeOperations.isInstanceOf(it, "jetbrains.mps.build.workflow.structure.BwfMacro") && SPropertyOperations.getBoolean(SNodeOperations.cast(it, "jetbrains.mps.build.workflow.structure.BwfMacro"), "exportToProperiesFile");
      }
    });
  }

  public static SNode sourceNodeQuery_5369202620937104487(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "element", true);
  }

  public static Iterable sourceNodesQuery_7385586609667799717(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    List<SNode> subTasks = new ArrayList<SNode>();
    ListSequence.fromList(subTasks).addSequence(ListSequence.fromList(SLinkOperations.getTargets(_context.getNode(), "subTasks", true)));
    for (SNode part : ((List<SNode>) _context.getVariable("var:taskParts"))) {
      ListSequence.fromList(subTasks).addSequence(ListSequence.fromList(SLinkOperations.getTargets(part, "subTasks", true)));
    }
    new SubTaskOrderHelper(subTasks, _context).sort();
    return subTasks;
  }

  public static Iterable sourceNodesQuery_2769948622284791216(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "statements", true);
  }

  public static Iterable sourceNodesQuery_6647099934207210805(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "content", true);
  }

  public static Iterable sourceNodesQuery_7385586609667649350(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return ListSequence.fromList(SLinkOperations.getTargets(_context.getNode(), "parts", true)).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return !(SNodeOperations.isInstanceOf(it, "jetbrains.mps.build.workflow.structure.BwfTask")) && !(SNodeOperations.isInstanceOf(it, "jetbrains.mps.build.workflow.structure.BwfPathDeclaration"));
      }
    });
  }

  public static Iterable sourceNodesQuery_6647099934207216814(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return ListSequence.fromList(SLinkOperations.getTargets(_context.getNode(), "parts", true)).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return SNodeOperations.isInstanceOf(it, "jetbrains.mps.build.workflow.structure.BwfPathDeclaration");
      }
    });
  }

  public static Iterable sourceNodesQuery_6896005762093596094(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return ListSequence.fromList(SLinkOperations.getTargets(_context.getNode(), "parts", true)).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return SNodeOperations.isInstanceOf(it, "jetbrains.mps.build.workflow.structure.BwfTask");
      }
    });
  }

  public static Iterable sourceNodesQuery_6647099934207240041(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "sources", true);
  }

  public static Iterable sourceNodesQuery_6647099934207240051(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "dependencies", true);
  }

  public static Iterable sourceNodesQuery_6647099934207240075(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "dependencies", true);
  }

  public static Iterable sourceNodesQuery_6647099934207244997(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return ListSequence.fromList(SNodeOperations.getAllSiblings(_context.getNode(), false)).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return SNodeOperations.isInstanceOf(it, "jetbrains.mps.build.workflow.structure.BwfJavaModule");
      }
    }).select(new ISelector<SNode, SNode>() {
      public SNode select(SNode it) {
        return SNodeOperations.cast(it, "jetbrains.mps.build.workflow.structure.BwfJavaModule");
      }
    });
  }

  public static Iterable sourceNodesQuery_6896005762093592258(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return ListSequence.fromList(SLinkOperations.getTargets(_context.getNode(), "parts", true)).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return SNodeOperations.isInstanceOf(it, "jetbrains.mps.build.workflow.structure.BwfMacro") && SPropertyOperations.getBoolean(SNodeOperations.cast(it, "jetbrains.mps.build.workflow.structure.BwfMacro"), "exportToProperiesFile");
      }
    }).select(new ISelector<SNode, SNode>() {
      public SNode select(SNode it) {
        return SNodeOperations.cast(it, "jetbrains.mps.build.workflow.structure.BwfMacro");
      }
    });
  }

  public static void mapSrcMacro_post_mapper_6647099934207045025(final IOperationContext operationContext, final MapSrcMacroPostProcContext _context) {
    if (ListSequence.fromList(SLinkOperations.getTargets(_context.getOutputNode(), "content", true)).isEmpty()) {
      SPropertyOperations.set(_context.getOutputNode(), "shortEmptyNotation", "" + true);
    }
  }

  public static void mappingScript_CodeBlock_4755209551904406821(final IOperationContext operationContext, final MappingScriptContext _context) {
    for (SNode project : SModelOperations.getRoots(_context.getModel(), "jetbrains.mps.build.workflow.structure.BwfProject")) {
      new CycleHelper(project, _context).processCycles();
    }
  }

  public static void mappingScript_CodeBlock_1117643560963147796(final IOperationContext operationContext, final MappingScriptContext _context) {
    for (SNode n : SModelOperations.getRoots(_context.getModel(), "jetbrains.mps.build.workflow.structure.BwfProject")) {
      new TaskLibrariesHelper(n, _context).importLibs();
    }
  }

  public static Object insertMacro_varValue_3961775458390375615(final IOperationContext operationContext, final TemplateQueryContext _context) {
    StringBuilder res = new StringBuilder();
    Set<String> used = new HashSet<String>();
    Iterable<SNode> dependencies = SLinkOperations.getTargets(_context.getNode(), "dependencies", true);
    for (SNode part : ((List<SNode>) _context.getVariable("var:taskParts"))) {
      dependencies = Sequence.fromIterable(dependencies).concat(ListSequence.fromList(SLinkOperations.getTargets(part, "additionalDependencies", true)));
    }
    for (SNode dep : dependencies) {
      String d = SPropertyOperations.getString(SLinkOperations.getTarget(dep, "target", false), "name");
      if (used.add(d)) {
        if (res.length() > 0) {
          res.append(", ");
        }
        res.append(d);
      }
    }
    return res.toString();
  }

  public static Object insertMacro_varValue_3961775458390373890(final IOperationContext operationContext, final TemplateQueryContext _context) {
    List<SNode> parts = new ArrayList<SNode>();
    for (SNode sibl : SNodeOperations.getAllSiblings(_context.getNode(), false)) {
      if (SNodeOperations.isInstanceOf(sibl, "jetbrains.mps.build.workflow.structure.BwfTaskPart") && _context.getNode() == SLinkOperations.getTarget(SNodeOperations.cast(sibl, "jetbrains.mps.build.workflow.structure.BwfTaskPart"), "task", false)) {
        ListSequence.fromList(parts).addElement(SNodeOperations.cast(sibl, "jetbrains.mps.build.workflow.structure.BwfTaskPart"));
      }
    }
    return parts;
  }
}
