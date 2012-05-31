package jetbrains.mps.lang.descriptor.generator.template.main;

/*Generated by MPS */

import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.generator.template.CreateRootRuleContext;
import jetbrains.mps.generator.template.BaseMappingRuleContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.generator.template.PropertyMacroContext;
import jetbrains.mps.lang.project.behavior.Module_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.project.structure.modules.ModuleReference;
import jetbrains.mps.project.IModule;
import jetbrains.mps.smodel.MPSModuleRepository;
import jetbrains.mps.lang.project.behavior.ModuleReference_Behavior;
import jetbrains.mps.smodel.Generator;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.generator.template.ReferenceMacroContext;
import jetbrains.mps.generator.template.IfMacroContext;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.smodel.ModuleRepositoryFacade;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.LanguageAspect;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.generator.template.SourceSubstituteMacroNodeContext;
import jetbrains.mps.generator.template.SourceSubstituteMacroNodesContext;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.smodel.SModelStereotype;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.lang.project.behavior.ModelReference_Behavior;
import jetbrains.mps.smodel.SModelRepository;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.internal.collections.runtime.ITranslator2;
import java.util.Collections;
import jetbrains.mps.generator.impl.plan.ModelContentUtil;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.generator.template.TemplateQueryContextWithMacro;
import jetbrains.mps.generator.runtime.TemplateModel;
import jetbrains.mps.generator.runtime.TemplateModule;

public class QueriesGenerated {
  public static boolean createRootRule_Condition_8780540425167326385(final IOperationContext operationContext, final CreateRootRuleContext _context) {
    return _context.getOriginalInputModel().getStereotype().equals("descriptor");
  }

  public static boolean baseMappingRule_Condition_1820665478710839841(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return SPropertyOperations.hasValue(_context.getNode(), "type", "strictly_before", "strictly_before");
  }

  public static boolean baseMappingRule_Condition_1820665478710839910(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return SPropertyOperations.hasValue(_context.getNode(), "type", "before_or_together", "strictly_before");
  }

  public static boolean baseMappingRule_Condition_2643213347103793267(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return SPropertyOperations.hasValue(_context.getNode(), "type", "strictly_after", "strictly_before");
  }

  public static boolean baseMappingRule_Condition_2643213347103793295(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return SPropertyOperations.hasValue(_context.getNode(), "type", "after_or_together", "strictly_before");
  }

  public static boolean baseMappingRule_Condition_6655394244919371015(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return SPropertyOperations.getBoolean(_context.getNode(), "generateTemplates");
  }

  public static Object propertyMacro_GetPropertyValue_9020561928507315549(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return Module_Behavior.call_getModuleReference_9020561928507315628(SLinkOperations.getTarget(_context.getNode(), "language", true));
  }

  public static Object propertyMacro_GetPropertyValue_5102832340571708655(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(SLinkOperations.getTarget(_context.getNode(), "language", true), "namespace");
  }

  public static Object propertyMacro_GetPropertyValue_5828571963818937562(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(SLinkOperations.getTarget(_context.getNode(), "language", true), "namespace") + ".typesystem.TypesystemDescriptor";
  }

  public static Object propertyMacro_GetPropertyValue_2838795720286867776(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(SLinkOperations.getTarget(_context.getNode(), "language", true), "namespace") + ".findUsages.FindUsagesDescriptor";
  }

  public static Object propertyMacro_GetPropertyValue_5554116809065233243(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return Module_Behavior.call_getModuleReference_9020561928507315628(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_1820665478710840122(final IOperationContext operationContext, final PropertyMacroContext _context) {
    // TODO 
    return new ModuleReference(SPropertyOperations.getString(SLinkOperations.getTarget(_context.getNode(), "generator", true), "qualifiedName"), SPropertyOperations.getString(SLinkOperations.getTarget(_context.getNode(), "generator", true), "uuid")).toString();
  }

  public static Object propertyMacro_GetPropertyValue_1820665478710840070(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "modelUID");
  }

  public static Object propertyMacro_GetPropertyValue_1820665478710840073(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "nodeID");
  }

  public static Object propertyMacro_GetPropertyValue_7633657384060768610(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return Module_Behavior.call_getModuleReference_9020561928507315628(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_6655394244919455793(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "qualifiedName") + ".TemplateModelImpl";
  }

  public static Object propertyMacro_GetPropertyValue_1250389701475344482(final IOperationContext operationContext, final PropertyMacroContext _context) {
    IModule m = MPSModuleRepository.getInstance().getModule(ModuleReference.fromString(ModuleReference_Behavior.call_getModuleReference_1250389701475344624(_context.getNode())));
    if (m instanceof Generator) {
      Generator g = (Generator) m;
      return g.getSourceLanguage().getModuleFqName() + "/" + g.getModuleFqName();
    } else {
      _context.showErrorMessage(_context.getNode(), "referenced generator is not available: " + _context.getNode());
      return "????";
    }
  }

  public static Object propertyMacro_GetPropertyValue_1250389701475432571(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return _context.getNode().getProperty("aa");
  }

  public static Object propertyMacro_GetPropertyValue_1698302279987411159(final IOperationContext operationContext, final PropertyMacroContext _context) {
    SNode l = SNodeOperations.cast(SNodeOperations.getParent(_context.getNode()), "jetbrains.mps.lang.project.structure.Language");
    return ((int) ListSequence.fromList(SLinkOperations.getTargets(l, "generator", true)).count() == 1 ?
      "Generator" :
      "Generator" + ListSequence.fromList(SLinkOperations.getTargets(l, "generator", true)).indexOf(_context.getNode())
    );
  }

  public static Object propertyMacro_GetPropertyValue_5102832340571646536(final IOperationContext operationContext, final PropertyMacroContext _context) {
    SNode l = SNodeOperations.cast(SNodeOperations.getParent(_context.getNode()), "jetbrains.mps.lang.project.structure.Language");
    return SPropertyOperations.getString(l, "namespace") + "/" + ((isEmpty_x583g4_a0a0a1a91(SPropertyOperations.getString(_context.getNode(), "name")) ?
      "<no name>" :
      SPropertyOperations.getString(_context.getNode(), "name")
    ));
  }

  public static Object referenceMacro_GetReferent_5554116809065233210(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return ListSequence.fromList(SLinkOperations.getTargets(_context.getOutputNodeByInputNodeAndMappingLabel(_context.getNode(), "generator.descriptor"), "constructor", true)).first();
  }

  public static boolean ifMacro_Condition_5828571963818937566(final IOperationContext operationContext, final IfMacroContext _context) {
    ModuleReference ref = ModuleReference.fromString(Module_Behavior.call_getModuleReference_9020561928507315628(SLinkOperations.getTarget(_context.getNode(), "language", true)));
    Language l = ModuleRepositoryFacade.getInstance().getModule(ref, Language.class);
    if (l == null) {
      _context.showErrorMessage(SLinkOperations.getTarget(_context.getNode(), "language", true), "No language in repository: " + SPropertyOperations.getString(SLinkOperations.getTarget(_context.getNode(), "language", true), "namespace"));
      return false;
    }
    SModelDescriptor ts = LanguageAspect.TYPESYSTEM.get(l);
    if (ts == null) {
      return false;
    }
    SModel m = ts.getSModel();
    if (m == null) {
      _context.showErrorMessage(SLinkOperations.getTarget(_context.getNode(), "language", true), "Cannot load model: " + ts.getLongName());
      return false;
    }
    return ListSequence.fromList(SModelOperations.getRoots(m, null)).isNotEmpty();
  }

  public static boolean ifMacro_Condition_2838795720286867781(final IOperationContext operationContext, final IfMacroContext _context) {
    ModuleReference ref = ModuleReference.fromString(Module_Behavior.call_getModuleReference_9020561928507315628(SLinkOperations.getTarget(_context.getNode(), "language", true)));
    Language l = ModuleRepositoryFacade.getInstance().getModule(ref, Language.class);
    if (l == null) {
      _context.showErrorMessage(SLinkOperations.getTarget(_context.getNode(), "language", true), "No language in repository: " + SPropertyOperations.getString(SLinkOperations.getTarget(_context.getNode(), "language", true), "namespace"));
      return false;
    }
    SModelDescriptor ts = LanguageAspect.FIND_USAGES.get(l);
    if (ts == null) {
      return false;
    }
    SModel m = ts.getSModel();
    if (m == null) {
      _context.showErrorMessage(SLinkOperations.getTarget(_context.getNode(), "language", true), "Cannot load model: " + ts.getLongName());
      return false;
    }
    return ListSequence.fromList(SModelOperations.getRoots(m, "jetbrains.mps.lang.findUsages.structure.FinderDeclaration")).isNotEmpty();
  }

  public static boolean ifMacro_Condition_5554116809065233232(final IOperationContext operationContext, final IfMacroContext _context) {
    return SPropertyOperations.getBoolean(_context.getNode(), "generateTemplates");
  }

  public static boolean ifMacro_Condition_5554116809065233262(final IOperationContext operationContext, final IfMacroContext _context) {
    return ListSequence.fromList(SLinkOperations.getTargets(SLinkOperations.getTarget(_context.getNode(), "language", true), "generator", true)).isNotEmpty();
  }

  public static boolean ifMacro_Condition_1820665478710807083(final IOperationContext operationContext, final IfMacroContext _context) {
    return ListSequence.fromList(SLinkOperations.getTargets(_context.getNode(), "priorityRules", true)).isNotEmpty();
  }

  public static boolean ifMacro_Condition_6655394244919403419(final IOperationContext operationContext, final IfMacroContext _context) {
    return ListSequence.fromList(SLinkOperations.getTargets(_context.getNode(), "model", true)).isNotEmpty();
  }

  public static boolean ifMacro_Condition_1250389701475281189(final IOperationContext operationContext, final IfMacroContext _context) {
    return ListSequence.fromList(SLinkOperations.getTargets(_context.getNode(), "depGenerators", true)).isNotEmpty();
  }

  public static boolean ifMacro_Condition_1820665478710839778(final IOperationContext operationContext, final IfMacroContext _context) {
    return ListSequence.fromList(SLinkOperations.getTargets(_context.getNode(), "priorityRules", true)).isNotEmpty();
  }

  public static boolean ifMacro_Condition_6655394244919461188(final IOperationContext operationContext, final IfMacroContext _context) {
    return ListSequence.fromList(SLinkOperations.getTargets(_context.getNode(), "model", true)).isNotEmpty();
  }

  public static boolean ifMacro_Condition_1250389701475344465(final IOperationContext operationContext, final IfMacroContext _context) {
    return ListSequence.fromList(SLinkOperations.getTargets(_context.getNode(), "depGenerators", true)).isNotEmpty();
  }

  public static boolean ifMacro_Condition_6655394244919461209(final IOperationContext operationContext, final IfMacroContext _context) {
    return ListSequence.fromList(SLinkOperations.getTargets(_context.getNode(), "model", true)).isNotEmpty();
  }

  public static boolean ifMacro_Condition_1820665478710839798(final IOperationContext operationContext, final IfMacroContext _context) {
    return ListSequence.fromList(SLinkOperations.getTargets(_context.getNode(), "priorityRules", true)).isNotEmpty();
  }

  public static boolean ifMacro_Condition_1250389701475344489(final IOperationContext operationContext, final IfMacroContext _context) {
    return ListSequence.fromList(SLinkOperations.getTargets(_context.getNode(), "depGenerators", true)).isNotEmpty();
  }

  public static SNode sourceNodeQuery_1820665478710839875(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "left", true);
  }

  public static SNode sourceNodeQuery_1820665478710839879(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "right", true);
  }

  public static SNode sourceNodeQuery_1820665478710839959(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "left", true);
  }

  public static SNode sourceNodeQuery_1820665478710839967(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "right", true);
  }

  public static SNode sourceNodeQuery_2643213347103793325(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "left", true);
  }

  public static SNode sourceNodeQuery_2643213347103793333(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "right", true);
  }

  public static SNode sourceNodeQuery_2643213347103793342(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "left", true);
  }

  public static SNode sourceNodeQuery_2643213347103793350(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "right", true);
  }

  public static SNode sourceNodeQuery_1820665478710839976(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "left", true);
  }

  public static SNode sourceNodeQuery_1820665478710839984(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "right", true);
  }

  public static SNode sourceNodeQuery_1820665478710840112(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "innerRef", true);
  }

  public static SNode sourceNodeQuery_1820665478710840051(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return _context.getNode();
  }

  public static SNode sourceNodeQuery_1820665478710839754(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return _context.getNode();
  }

  public static Iterable sourceNodesQuery_5554116809065233223(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(SLinkOperations.getTarget(_context.getNode(), "language", true), "generator", true);
  }

  public static Iterable sourceNodesQuery_1820665478710840047(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "refs", true);
  }

  public static Iterable sourceNodesQuery_1820665478710839750(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "priorityRules", true);
  }

  public static Iterable sourceNodesQuery_6655394244919455802(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return ListSequence.fromList(SLinkOperations.getTargets(_context.getNode(), "model", true)).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return eq_x583g4_a0a0a0a0a0a0a0yb(SPropertyOperations.getString(it, "stereotype"), SModelStereotype.GENERATOR);
      }
    }).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        SModelReference ref = SModelReference.fromString(ModelReference_Behavior.call_getModelReference_6236774123822284799(it));
        SModelDescriptor descriptor = SModelRepository.getInstance().getModelDescriptor(ref);
        if (descriptor == null) {
          return false;
        }
        SModel m = descriptor.getSModel();
        if (m == null) {
          return false;
        }
        return ListSequence.fromList(SModelOperations.getRoots(m, "jetbrains.mps.lang.generator.structure.TemplateSwitch")).isNotEmpty() || ListSequence.fromList(SModelOperations.getRoots(m, "jetbrains.mps.lang.generator.structure.MappingConfiguration")).isNotEmpty();
      }
    }).sort(new ISelector<SNode, Comparable<?>>() {
      public Comparable<?> select(SNode it) {
        return SPropertyOperations.getString(it, "qualifiedName");
      }
    }, true);
  }

  public static Iterable sourceNodesQuery_1250389701475344450(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "depGenerators", true);
  }

  public static Iterable sourceNodesQuery_1250389701475431822(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return ListSequence.fromList(SLinkOperations.getTargets(_context.getNode(), "model", true)).translate(new ITranslator2<SNode, String>() {
      public Iterable<String> translate(SNode it) {
        SModelDescriptor m = SModelRepository.getInstance().getModelDescriptor(SModelReference.fromString(ModelReference_Behavior.call_getModelReference_6236774123822284799(it)));
        return (m == null ?
          Collections.<String>emptyList() :
          ModelContentUtil.getUsedLanguageNamespaces(m.getSModel(), true)
        );
      }
    }).distinct().sort(new ISelector<String, Comparable<?>>() {
      public Comparable<?> select(String it) {
        return it;
      }
    }, true).select(new ISelector<String, SNode>() {
      public SNode select(String it) {
        SNode n = SConceptOperations.createNewNode("jetbrains.mps.lang.core.structure.BaseConcept", null);
        n.setProperty("aa", it);
        return n;
      }
    });
  }

  public static SNode insertMacro_Query_1509962061695074412(final IOperationContext operationContext, final TemplateQueryContextWithMacro _context) {
    return SNodeOperations.cast(SModelOperations.getModuleStub(_context.getOriginalInputModel()), "jetbrains.mps.lang.project.structure.Language");
  }

  public static TemplateModel getDescriptor(TemplateModule module) {
    return new TemplateModelImpl(module);
  }

  public static boolean isEmpty_x583g4_a0a0a1a91(String str) {
    return str == null || str.length() == 0;
  }

  private static boolean eq_x583g4_a0a0a0a0a0a0a0yb(Object a, Object b) {
    return (a != null ?
      a.equals(b) :
      a == b
    );
  }
}
