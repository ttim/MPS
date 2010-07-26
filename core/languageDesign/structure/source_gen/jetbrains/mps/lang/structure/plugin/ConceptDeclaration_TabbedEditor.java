package jetbrains.mps.lang.structure.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.tabbedEditor.BaseTabbedEditor;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.plugins.pluginparts.tabbedEditor.BaseSingleTab;
import jetbrains.mps.ide.tabbedEditor.TabbedEditor;
import jetbrains.mps.smodel.LanguageAspect;
import jetbrains.mps.plugins.pluginparts.tabbedEditor.BaseMultiTab;
import java.util.List;
import java.util.ArrayList;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.structure.behavior.AbstractConceptDeclaration_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import java.util.Comparator;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.plugins.pluginparts.tabbedEditor.TabHelper;
import java.util.Set;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import java.util.HashSet;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.smodel.AttributesRolesUtil;
import jetbrains.mps.project.structure.modules.ModuleReference;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.smodel.MPSModuleRepository;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import com.intellij.openapi.project.Project;
import jetbrains.mps.workbench.MPSDataKeys;
import com.intellij.ide.DataManager;
import javax.swing.JFrame;
import com.intellij.openapi.wm.WindowManager;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.kernel.model.SModelUtil;
import jetbrains.mps.smodel.Generator;
import jetbrains.mps.workbench.dialogs.project.creation.NewGeneratorDialog;
import jetbrains.mps.smodel.BaseAdapter;
import javax.swing.JOptionPane;
import jetbrains.mps.ide.actions.MappingDialog;
import jetbrains.mps.lang.generator.behavior.MappingConfiguration_Behavior;

public class ConceptDeclaration_TabbedEditor extends BaseTabbedEditor {
  public ConceptDeclaration_TabbedEditor(IOperationContext operationContext, SNode node) {
    super(operationContext, node);
    this.addTab(new ConceptDeclaration_TabbedEditor.Structure_Tab(this, node), 'S');
    this.addTab(new ConceptDeclaration_TabbedEditor.Editor_Tab(this, node), 'E');
    this.addTab(new ConceptDeclaration_TabbedEditor.Constraints_Tab(this, node), 'C');
    this.addTab(new ConceptDeclaration_TabbedEditor.Behavior_Tab(this, node), 'B');
    this.addTab(new ConceptDeclaration_TabbedEditor.Typesystem_Tab(this, node), 'T');
    this.addTab(new ConceptDeclaration_TabbedEditor.Actions_Tab(this, node), 'A');
    this.addTab(new ConceptDeclaration_TabbedEditor.Refactorings_Tab(this, node), 'R');
    this.addTab(new ConceptDeclaration_TabbedEditor.Intentions_Tab(this, node), 'I');
    this.addTab(new ConceptDeclaration_TabbedEditor.Find_Usages_Tab(this, node), 'F');
    this.addTab(new ConceptDeclaration_TabbedEditor.Data_Flow_Tab(this, node), 'D');
    this.addTab(new ConceptDeclaration_TabbedEditor.Generator_Tab(this, node), 'G');
    this.addTab(new ConceptDeclaration_TabbedEditor.Textgen_Tab(this, node), null);
  }

  public static class Structure_Tab extends BaseSingleTab {
    public Structure_Tab(TabbedEditor tabbedEditor, SNode baseNode) {
      super(tabbedEditor, baseNode);
      this.init();
    }

    public void init() {
      ConceptEditorHelper.addSingletabbedListener(Structure_Tab.this, LanguageAspect.STRUCTURE, false);
    }

    public String getTitle() {
      return "Structure";
    }

    public String getNullText() {
      return "";
    }

    public SNode getNode(SNode node) {
      return node;
    }

    public boolean canCreate() {
      return false;
    }

    public SNode createNode(final SNode node) {
      throw new IllegalArgumentException();
    }
  }

  public static class Editor_Tab extends BaseMultiTab {
    public Editor_Tab(TabbedEditor tabbedEditor, SNode baseNode) {
      super(tabbedEditor, baseNode);
      this.init();
    }

    public void init() {
      ConceptEditorHelper.addMultitabbedListener(Editor_Tab.this, LanguageAspect.EDITOR, false);
    }

    public String getTitle() {
      return "Editor";
    }

    public String getNullText() {
      return "No Editor";
    }

    public List<SNode> getNodes(SNode node) {
      List<SNode> nodes = new ArrayList<SNode>();
      IScope scope = ConceptEditorHelper.getScope(Editor_Tab.this);
      ListSequence.fromList(nodes).addSequence(ListSequence.fromList(AbstractConceptDeclaration_Behavior.call_findConceptAspectCollection_1567570417158062208(node, scope, LanguageAspect.EDITOR)));
      return ConceptEditorHelper.sortRootsByConcept(nodes, new SNode[]{SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.editor.structure.ConceptEditorDeclaration"), SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.editor.structure.EditorComponentDeclaration"), SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.editor.structure.CellKeyMapDeclaration"), SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.editor.structure.CellActionMapDeclaration"), SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.editor.structure.CellMenuComponent"), SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.editor.structure.StyleSheet")});
    }

    public String getTabTextForNode(SNode node) {
      if (node.getName() != null) {
        return node.getName();
      } else {
        return node.toString();
      }
    }

    public boolean canCreate() {
      return true;
    }

    public List<SNode> getAvailableConcepts(final SNode node) {
      return ConceptEditorHelper.getAvailableConceptAspects(LanguageAspect.EDITOR, node);
    }

    public SNode createNode(final SNode node, final boolean ask, final SNode concept) {
      return ConceptEditorHelper.createNewConceptAspectInstance(LanguageAspect.EDITOR, node, concept, Editor_Tab.this);
    }
  }

  public static class Constraints_Tab extends BaseSingleTab {
    public Constraints_Tab(TabbedEditor tabbedEditor, SNode baseNode) {
      super(tabbedEditor, baseNode);
      this.init();
    }

    public void init() {
      ConceptEditorHelper.addSingletabbedListener(Constraints_Tab.this, LanguageAspect.CONSTRAINTS, false);
    }

    public String getTitle() {
      return "Constraints";
    }

    public String getNullText() {
      return "No Constraints.";
    }

    public SNode getNode(SNode node) {
      List<SNode> nodes = AbstractConceptDeclaration_Behavior.call_findConceptAspectCollection_1567570417158062208(node, ConceptEditorHelper.getScope(Constraints_Tab.this), LanguageAspect.CONSTRAINTS);
      return (ListSequence.fromList(nodes).isEmpty() ?
        null :
        ListSequence.fromList(nodes).first()
      );
    }

    public boolean canCreate() {
      return true;
    }

    public SNode createNode(final SNode node) {
      return ConceptEditorHelper.createNewConceptAspectInstance(LanguageAspect.CONSTRAINTS, node, SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.constraints.structure.ConceptConstraints"), Constraints_Tab.this);
    }
  }

  public static class Behavior_Tab extends BaseSingleTab {
    public Behavior_Tab(TabbedEditor tabbedEditor, SNode baseNode) {
      super(tabbedEditor, baseNode);
      this.init();
    }

    public void init() {
      ConceptEditorHelper.addSingletabbedListener(Behavior_Tab.this, LanguageAspect.BEHAVIOR, false);
    }

    public String getTitle() {
      return "Behavior";
    }

    public String getNullText() {
      return "No Behavior.";
    }

    public SNode getNode(SNode node) {
      List<SNode> nodes = AbstractConceptDeclaration_Behavior.call_findConceptAspectCollection_1567570417158062208(node, ConceptEditorHelper.getScope(Behavior_Tab.this), LanguageAspect.BEHAVIOR);
      return (ListSequence.fromList(nodes).isEmpty() ?
        null :
        ListSequence.fromList(nodes).first()
      );
    }

    public boolean canCreate() {
      return true;
    }

    public SNode createNode(final SNode node) {
      return ConceptEditorHelper.createNewConceptAspectInstance(LanguageAspect.BEHAVIOR, node, SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.behavior.structure.ConceptBehavior"), Behavior_Tab.this);
    }
  }

  public static class Typesystem_Tab extends BaseMultiTab {
    public Typesystem_Tab(TabbedEditor tabbedEditor, SNode baseNode) {
      super(tabbedEditor, baseNode);
      this.init();
    }

    public void init() {
      ConceptEditorHelper.addMultitabbedListener(Typesystem_Tab.this, LanguageAspect.TYPESYSTEM, false);
    }

    public String getTitle() {
      return "Typesystem";
    }

    public String getNullText() {
      return "No Inference Rules.";
    }

    public List<SNode> getNodes(SNode node) {
      List<SNode> rules = AbstractConceptDeclaration_Behavior.call_findApplicableTypesystemRules_6409339300305625028(node, ConceptEditorHelper.getScope(Typesystem_Tab.this));
      return ListSequence.fromList(rules).sort(new Comparator<SNode>() {
        public int compare(SNode a, SNode b) {
          boolean aConceptRef = SNodeOperations.isInstanceOf(SLinkOperations.getTarget(a, "applicableNode", true), "jetbrains.mps.lang.typesystem.structure.ConceptReference");
          boolean bConceptRef = SNodeOperations.isInstanceOf(SLinkOperations.getTarget(b, "applicableNode", true), "jetbrains.mps.lang.typesystem.structure.ConceptReference");

          // rules with concept references go first 
          if (aConceptRef && !(bConceptRef)) {
            return 1;
          }
          if (!(aConceptRef) && bConceptRef) {
            return -1;
          }

          // rules with concept references - more specific goes first 
          if (aConceptRef && bConceptRef) {
            SNode aConcept = SLinkOperations.getTarget(SNodeOperations.cast(SLinkOperations.getTarget(a, "applicableNode", true), "jetbrains.mps.lang.typesystem.structure.ConceptReference"), "concept", false);
            SNode bConcept = SLinkOperations.getTarget(SNodeOperations.cast(SLinkOperations.getTarget(b, "applicableNode", true), "jetbrains.mps.lang.typesystem.structure.ConceptReference"), "concept", false);
            if (SConceptOperations.isSubConceptOf(aConcept, NameUtil.nodeFQName(bConcept))) {
              return 1;
            }
            if (SConceptOperations.isSubConceptOf(bConcept, NameUtil.nodeFQName(aConcept))) {
              return -1;
            }
          }

          return 0;
        }
      }, false).toListSequence();
    }

    public String getTabTextForNode(SNode node) {
      if (node.getName() != null) {
        return node.getName();
      } else {
        return node.toString();
      }
    }

    public boolean canCreate() {
      return true;
    }

    public List<SNode> getAvailableConcepts(final SNode node) {
      return ConceptEditorHelper.getAvailableConceptAspects(LanguageAspect.TYPESYSTEM, node);
    }

    public SNode createNode(final SNode node, final boolean ask, final SNode concept) {
      return ConceptEditorHelper.createNewConceptAspectInstance(LanguageAspect.TYPESYSTEM, node, concept, Typesystem_Tab.this);
    }
  }

  public static class Actions_Tab extends BaseMultiTab {
    public Actions_Tab(TabbedEditor tabbedEditor, SNode baseNode) {
      super(tabbedEditor, baseNode);
      this.init();
    }

    public void init() {
      ConceptEditorHelper.addMultitabbedListener(Actions_Tab.this, LanguageAspect.ACTIONS, true);
    }

    public String getTitle() {
      return "Actions";
    }

    public String getNullText() {
      return "No Actions";
    }

    public List<SNode> getNodes(SNode node) {
      return AbstractConceptDeclaration_Behavior.call_findConceptAspectCollection_1567570417158062208(node, ConceptEditorHelper.getScope(Actions_Tab.this), LanguageAspect.ACTIONS);
    }

    public String getTabTextForNode(SNode node) {
      if (node.getName() != null) {
        return node.getName();
      } else {
        return node.toString();
      }
    }

    public boolean canCreate() {
      return true;
    }

    public List<SNode> getAvailableConcepts(final SNode node) {
      return ConceptEditorHelper.getAvailableConceptAspects(LanguageAspect.ACTIONS, node);
    }

    public SNode createNode(final SNode node, final boolean ask, final SNode concept) {
      return ConceptEditorHelper.createNewConceptAspectInstance(LanguageAspect.ACTIONS, node, concept, Actions_Tab.this);
    }
  }

  public static class Refactorings_Tab extends BaseMultiTab {
    public Refactorings_Tab(TabbedEditor tabbedEditor, SNode baseNode) {
      super(tabbedEditor, baseNode);
      this.init();
    }

    public void init() {
      ConceptEditorHelper.addMultitabbedListener(Refactorings_Tab.this, LanguageAspect.REFACTORINGS, false);
    }

    public String getTitle() {
      return "Refactorings";
    }

    public String getNullText() {
      return "No Refactorings.";
    }

    public List<SNode> getNodes(SNode node) {
      return AbstractConceptDeclaration_Behavior.call_findConceptAspectCollection_1567570417158062208(node, ConceptEditorHelper.getScope(Refactorings_Tab.this), LanguageAspect.REFACTORINGS);
    }

    public String getTabTextForNode(SNode node) {
      if (node.getName() != null) {
        return node.getName();
      } else {
        return node.toString();
      }
    }

    public boolean canCreate() {
      return true;
    }

    public List<SNode> getAvailableConcepts(final SNode node) {
      return ConceptEditorHelper.getAvailableConceptAspects(LanguageAspect.REFACTORINGS, node);
    }

    public SNode createNode(final SNode node, final boolean ask, final SNode concept) {
      return ConceptEditorHelper.createNewConceptAspectInstance(LanguageAspect.REFACTORINGS, node, concept, Refactorings_Tab.this);
    }
  }

  public static class Intentions_Tab extends BaseMultiTab {
    public Intentions_Tab(TabbedEditor tabbedEditor, SNode baseNode) {
      super(tabbedEditor, baseNode);
      this.init();
    }

    public void init() {
      ConceptEditorHelper.addMultitabbedListener(Intentions_Tab.this, LanguageAspect.INTENTIONS, false);
    }

    public String getTitle() {
      return "Intentions";
    }

    public String getNullText() {
      return "No Intentions.";
    }

    public List<SNode> getNodes(SNode node) {
      return AbstractConceptDeclaration_Behavior.call_findConceptAspectCollection_1567570417158062208(node, ConceptEditorHelper.getScope(Intentions_Tab.this), LanguageAspect.INTENTIONS);
    }

    public String getTabTextForNode(SNode node) {
      if (node.getName() != null) {
        return node.getName();
      } else {
        return node.toString();
      }
    }

    public boolean canCreate() {
      return true;
    }

    public List<SNode> getAvailableConcepts(final SNode node) {
      return ConceptEditorHelper.getAvailableConceptAspects(LanguageAspect.INTENTIONS, node);
    }

    public SNode createNode(final SNode node, final boolean ask, final SNode concept) {
      return ConceptEditorHelper.createNewConceptAspectInstance(LanguageAspect.INTENTIONS, node, concept, Intentions_Tab.this);
    }
  }

  public static class Find_Usages_Tab extends BaseMultiTab {
    public Find_Usages_Tab(TabbedEditor tabbedEditor, SNode baseNode) {
      super(tabbedEditor, baseNode);
      this.init();
    }

    public void init() {
      ConceptEditorHelper.addMultitabbedListener(Find_Usages_Tab.this, LanguageAspect.FIND_USAGES, false);
    }

    public String getTitle() {
      return "Find Usages";
    }

    public String getNullText() {
      return "No Finders.";
    }

    public List<SNode> getNodes(SNode node) {
      return AbstractConceptDeclaration_Behavior.call_findConceptAspectCollection_1567570417158062208(node, ConceptEditorHelper.getScope(Find_Usages_Tab.this), LanguageAspect.FIND_USAGES);
    }

    public String getTabTextForNode(SNode node) {
      if (node.getName() != null) {
        return node.getName();
      } else {
        return node.toString();
      }
    }

    public boolean canCreate() {
      return true;
    }

    public boolean askCreate(SNode node) {
      return TabHelper.ask("Do you want to create new finder?", "Create New Finder");
    }

    public List<SNode> getAvailableConcepts(final SNode node) {
      return ConceptEditorHelper.getAvailableConceptAspects(LanguageAspect.FIND_USAGES, node);
    }

    public SNode createNode(final SNode node, final boolean ask, final SNode concept) {
      return ConceptEditorHelper.createNewConceptAspectInstance(LanguageAspect.FIND_USAGES, node, concept, Find_Usages_Tab.this);
    }
  }

  public static class Data_Flow_Tab extends BaseSingleTab {
    public Data_Flow_Tab(TabbedEditor tabbedEditor, SNode baseNode) {
      super(tabbedEditor, baseNode);
      this.init();
    }

    public void init() {
      ConceptEditorHelper.addSingletabbedListener(Data_Flow_Tab.this, LanguageAspect.DATA_FLOW, false);
    }

    public String getTitle() {
      return "Data Flow";
    }

    public String getNullText() {
      return "No Data Flow.";
    }

    public SNode getNode(SNode node) {
      List<SNode> nodes = AbstractConceptDeclaration_Behavior.call_findConceptAspectCollection_1567570417158062208(node, ConceptEditorHelper.getScope(Data_Flow_Tab.this), LanguageAspect.DATA_FLOW);
      return (ListSequence.fromList(nodes).isEmpty() ?
        null :
        ListSequence.fromList(nodes).first()
      );
    }

    public boolean canCreate() {
      return true;
    }

    public SNode createNode(final SNode node) {
      return ConceptEditorHelper.createNewConceptAspectInstance(LanguageAspect.DATA_FLOW, node, SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.dataFlow.structure.DataFlowBuilderDeclaration"), Data_Flow_Tab.this);
    }
  }

  public static class Generator_Tab extends BaseMultiTab {
    public Generator_Tab(TabbedEditor tabbedEditor, SNode baseNode) {
      super(tabbedEditor, baseNode);
      this.init();
    }

    public void init() {
      ConceptEditorHelper.addGeneratorListener(Generator_Tab.this);
    }

    public String getTitle() {
      return "Generator";
    }

    public String getNullText() {
      return "No Generator Fragment";
    }

    public List<SNode> getNodes(SNode node) {
      IScope scope = ConceptEditorHelper.getScope(Generator_Tab.this);
      Set<SNode> nodes = SetSequence.fromSet(new HashSet<SNode>());
      SetSequence.fromSet(nodes).addSequence(ListSequence.fromList(AbstractConceptDeclaration_Behavior.call_findGeneratorFragments_6409339300305625383(node, scope)).select(new ISelector<SNode, SNode>() {
        public SNode select(SNode it) {
          return SNodeOperations.getContainingRoot(it);
        }
      }));
      return SetSequence.fromSet(nodes).toListSequence();
    }

    public String getTabTextForNode(SNode node) {
      if (node.getName() != null) {
        return node.getName();
      } else {
        return node.toString();
      }
    }

    public boolean canCreate() {
      return true;
    }

    public List<SNode> getAvailableConcepts(final SNode node) {
      List<SNode> result = ConceptEditorHelper.getAvailableConceptAspects(SNodeOperations.getModel(SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.generator.structure.TemplateSwitch")), node);
      ListSequence.fromList(result).addElement(SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.generator.structure.InlineTemplate_RuleConsequence"));
      ListSequence.fromList(result).addElement(SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.generator.structure.InlineTemplateWithContext_RuleConsequence"));
      boolean rootable = SNodeOperations.isInstanceOf(node, "jetbrains.mps.lang.structure.structure.ConceptDeclaration") && SPropertyOperations.getBoolean(SNodeOperations.cast(node, "jetbrains.mps.lang.structure.structure.ConceptDeclaration"), "rootable");
      boolean isInterface = SNodeOperations.isInstanceOf(node, "jetbrains.mps.lang.structure.structure.InterfaceConceptDeclaration");
      if (rootable || isInterface) {
        boolean isNeedRootTemplate = true;
        for (SNode genFragment : AbstractConceptDeclaration_Behavior.call_findGeneratorFragments_6409339300305625383(node, ConceptEditorHelper.getScope(Generator_Tab.this))) {
          if ((SLinkOperations.getTarget(genFragment, AttributesRolesUtil.childRoleFromAttributeRole("rootTemplateAnnotation"), true) != null)) {
            isNeedRootTemplate = false;
            break;
          }
        }
        if (isNeedRootTemplate) {
          for (ModuleReference moduleRef : SNodeOperations.getModel(node).getExplicitlyImportedLanguages()) {
            Language language = MPSModuleRepository.getInstance().getLanguage(moduleRef);
            if (language == null) {
              continue;
            }
            SModel structureModel = language.getStructureModelDescriptor().getSModel();
            for (SNode nodeToAdd : SModelOperations.getRoots(structureModel, "jetbrains.mps.lang.structure.structure.ConceptDeclaration")) {
              SNode conceptToAdd = (SNode) nodeToAdd;
              if (SPropertyOperations.getBoolean(nodeToAdd, "rootable")) {
                ListSequence.fromList(result).addElement(conceptToAdd);
              }
            }
          }
        }
      }
      return result;
    }

    public SNode createNode(final SNode node, final boolean ask, final SNode concept) {
      Project project = MPSDataKeys.PROJECT.getData(DataManager.getInstance().getDataContext());
      final JFrame frame = WindowManager.getInstance().getFrame(project);

      final Wrappers._T<Language> language = new Wrappers._T<Language>();
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          language.value = SModelUtil.getDeclaringLanguage(node, ConceptEditorHelper.getScope(Generator_Tab.this));
          assert language.value != null : "Language shouldn't be null for " + node;
        }
      });

      final List<Generator> genList = language.value.getGenerators();
      if (ListSequence.fromList(genList).isEmpty()) {
        NewGeneratorDialog dialog = new NewGeneratorDialog(frame, language.value);
        dialog.showDialog();
        final Generator createdGenerator = dialog.getResult();
        if (createdGenerator == null) {
          return null;
        }
        ModelAccess.instance().runWriteActionInCommand(new Runnable() {
          public void run() {
            SModel createdModel = createdGenerator.getOwnTemplateModels().get(0).getSModel();
            SModelOperations.addRootNode(createdModel, SConceptOperations.createNewNode("jetbrains.mps.lang.generator.structure.MappingConfiguration", null));
          }
        });
      }

      final List<SNode> mappings = new ArrayList<SNode>();
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          for (Generator generator : genList) {
            for (BaseAdapter confAdapter : generator.getOwnMappings()) {
              ListSequence.fromList(mappings).addElement((SNode) confAdapter.getNode());
            }
          }
        }
      });

      if (ListSequence.fromList(mappings).isEmpty()) {
        // generator is present - this means we don't have template models or mappings 
        ModelAccess.instance().runWriteActionInCommand(new Runnable() {
          public void run() {
            SModel model = null;
            for (Generator generator : genList) {
              if (generator.getOwnTemplateModels().isEmpty()) {
                continue;
              }
              model = generator.getOwnTemplateModels().get(0).getSModel();
            }

            if (model == null) {
              JOptionPane.showMessageDialog(frame, "create template model first");
            }

            SNode node = SConceptOperations.createNewNode("jetbrains.mps.lang.generator.structure.MappingConfiguration", null);
            SModelOperations.addRootNode(model, node);
            ListSequence.fromList(mappings).addElement(node);
          }
        });
      }

      final Wrappers._T<SNode> mapping = new Wrappers._T<SNode>();
      if (ListSequence.fromList(mappings).count() > 1) {
        MappingDialog configurationDialog = new MappingDialog(project, language.value);
        configurationDialog.showDialog();
        mapping.value = configurationDialog.getResult();
      } else {
        mapping.value = ListSequence.fromList(mappings).first();
      }
      final Wrappers._T<SNode> result = new Wrappers._T<SNode>();
      ModelAccess.instance().runWriteActionInCommand(new Runnable() {
        public void run() {
          SModel model = SNodeOperations.getModel(mapping.value);
          result.value = SConceptOperations.createNewNode(NameUtil.nodeFQName(concept), null);
          if (SNodeOperations.isInstanceOf(result.value, "jetbrains.mps.lang.structure.structure.IConceptAspect")) {
            result.value = ConceptEditorHelper.createNewConceptAspectInstance(node, concept, model);
            MappingConfiguration_Behavior.call_addMember_3166264919334415805(mapping.value, result.value);
          } else if (SNodeOperations.isInstanceOf(result.value, "jetbrains.mps.lang.generator.structure.InlineTemplate_RuleConsequence") || SNodeOperations.isInstanceOf(result.value, "jetbrains.mps.lang.generator.structure.InlineTemplateWithContext_RuleConsequence")) {
            SNode mappingRule = SLinkOperations.addNewChild(mapping.value, "reductionMappingRule", "jetbrains.mps.lang.generator.structure.Reduction_MappingRule");
            SLinkOperations.setTarget(mappingRule, "applicableConcept", node, false);
            SLinkOperations.setTarget(mappingRule, "ruleConsequence", SNodeOperations.cast(result.value, "jetbrains.mps.lang.generator.structure.RuleConsequence"), true);
          } else {
            SNode rootTemplateNode = SModelOperations.createNewNode(model, "jetbrains.mps.lang.generator.structure.RootTemplateAnnotation", null);
            SLinkOperations.setTarget(rootTemplateNode, "applicableConcept", node, false);
            SLinkOperations.setTarget(result.value, AttributesRolesUtil.childRoleFromAttributeRole("rootTemplateAnnotation"), rootTemplateNode, true);
            SPropertyOperations.set(SNodeOperations.cast(result.value, "jetbrains.mps.lang.core.structure.INamedConcept"), "name", SPropertyOperations.getString(node, "name"));
            SModelOperations.addRootNode(model, result.value);
            MappingConfiguration_Behavior.call_addMember_3166264919334415805(mapping.value, result.value);
          }
        }
      });
      return result.value;
    }

    public boolean isOutsideCommandExecution() {
      return true;
    }
  }

  public static class Textgen_Tab extends BaseSingleTab {
    public Textgen_Tab(TabbedEditor tabbedEditor, SNode baseNode) {
      super(tabbedEditor, baseNode);
      this.init();
    }

    public void init() {
      ConceptEditorHelper.addSingletabbedListener(Textgen_Tab.this, LanguageAspect.TEXT_GEN, false);
    }

    public String getTitle() {
      return "Textgen";
    }

    public String getNullText() {
      return "No Text Gen.";
    }

    public SNode getNode(SNode node) {
      List<SNode> nodes = AbstractConceptDeclaration_Behavior.call_findConceptAspectCollection_1567570417158062208(node, ConceptEditorHelper.getScope(Textgen_Tab.this), LanguageAspect.TEXT_GEN);
      return (ListSequence.fromList(nodes).isEmpty() ?
        null :
        ListSequence.fromList(nodes).first()
      );
    }

    public boolean canCreate() {
      return true;
    }

    public SNode createNode(final SNode node) {
      return ConceptEditorHelper.createNewConceptAspectInstance(LanguageAspect.TEXT_GEN, node, SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.textGen.structure.ConceptTextGenDeclaration"), Textgen_Tab.this);
    }
  }
}
