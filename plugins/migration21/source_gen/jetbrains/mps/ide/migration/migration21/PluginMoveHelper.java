package jetbrains.mps.ide.migration.migration21;

/*Generated by MPS */

import jetbrains.mps.project.MPSProject;
import java.util.List;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.smodel.LanguageAspect;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.smodel.ModuleRepositoryFacade;
import jetbrains.mps.project.Solution;
import jetbrains.mps.internal.collections.runtime.IVisitor;
import com.intellij.openapi.ui.Messages;
import jetbrains.mps.reloading.ClassLoaderManager;
import jetbrains.mps.progress.EmptyProgressMonitor;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.smodel.SNode;
import org.apache.commons.lang.StringUtils;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.util.MacrosFactory;
import jetbrains.mps.vfs.IFile;
import jetbrains.mps.vfs.FileSystem;
import jetbrains.mps.project.IModule;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.util.MacrosUtil;
import javax.swing.ImageIcon;
import jetbrains.mps.ide.newSolutionDialog.NewModuleUtil;
import jetbrains.mps.project.StandaloneMPSProject;
import jetbrains.mps.project.structure.modules.SolutionKind;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.smodel.SModelFqName;
import jetbrains.mps.util.IterableUtil;
import jetbrains.mps.refactoring.framework.RefactoringContext;
import java.util.Arrays;
import jetbrains.mps.ide.platform.refactoring.RefactoringAccess;
import jetbrains.mps.smodel.SModelRepository;
import jetbrains.mps.project.structure.modules.ModuleReference;
import jetbrains.mps.smodel.MPSModuleRepository;
import jetbrains.mps.project.ModuleId;

public class PluginMoveHelper {
  private static final String SOLUTION_NAME = "pluginSolution";

  private MPSProject myProject;

  public PluginMoveHelper(MPSProject p) {
    myProject = p;
  }

  public void move() {
    List<Language> langs = myProject.getProjectModules(Language.class);
    Iterable<Language> refLangs = ListSequence.fromList(langs).where(new IWhereFilter<Language>() {
      public boolean accept(Language it) {
        return !(it.isPackaged()) && LanguageAspect.PLUGIN.get(it) != null;
      }
    });
    Iterable<Language> problems = Sequence.fromIterable(refLangs).where(new IWhereFilter<Language>() {
      public boolean accept(Language it) {
        return ModuleRepositoryFacade.getInstance().getModule(makePluginSolutionName(it, SOLUTION_NAME), Solution.class) != null;
      }
    });

    if (Sequence.fromIterable(problems).isNotEmpty()) {
      final StringBuilder sb = new StringBuilder();
      Sequence.fromIterable(problems).visitAll(new IVisitor<Language>() {
        public void visit(Language it) {
          sb.append(makePluginSolutionName(it, SOLUTION_NAME)).append(",\n");
        }
      });
      if (sb.length() > 0) {
        sb.delete(sb.length() - 2, sb.length() - 1);
      }
      int result = Messages.showYesNoDialog("Solutions\n" + sb.toString() + " already exist. Nodes will be moved to existing solutions", "Solution Exists", "Continue", "Cancel", null);
      if (result == 1) {
        return;
      }
    }

    for (Language lang : Sequence.fromIterable(refLangs)) {
      movePluginOut(lang);
    }

    myProject.getProject().save();
    ClassLoaderManager.getInstance().reloadAll(new EmptyProgressMonitor());
  }

  public void moveIconsInAction() {
    for (final Solution solution : ListSequence.fromList(myProject.getProjectModules(Solution.class))) {
      if (solution.getModuleFqName().endsWith(SOLUTION_NAME)) {
        List<SModelDescriptor> models = solution.getOwnModelDescriptors();
        SModel m = ListSequence.fromList(models).first().getSModel();
        ListSequence.fromList(SModelOperations.getNodes(m, "jetbrains.mps.lang.plugin.structure.IconResource")).where(new IWhereFilter<SNode>() {
          public boolean accept(SNode it) {
            return (it != null) && StringUtils.isNotEmpty(SPropertyOperations.getString(it, "path")) && !(isValid(it));
          }
        }).visitAll(new IVisitor<SNode>() {
          public void visit(SNode it) {
            String langName = NameUtil.namespaceFromLongName(solution.getModuleFqName());
            Language lang = ModuleRepositoryFacade.getInstance().getModule(langName, Language.class);
            if (lang == null) {
              return;
            }

            String iconPath = MacrosFactory.moduleDescriptor(lang).expandPath(SPropertyOperations.getString(it, "path"), lang.getDescriptorFile());

            String newIconMacro = SPropertyOperations.getString(it, "path").replace(MacrosFactory.LANGUAGE_DESCRIPTOR, MacrosFactory.SOLUTION_DESCRIPTOR);
            String newIconPath = MacrosFactory.moduleDescriptor(solution).expandPath(newIconMacro, solution.getDescriptorFile());

            IFile file = FileSystem.getInstance().getFile(iconPath);
            if (!(file.exists())) {
              return;
            }

            file.move(FileSystem.getInstance().getFile(newIconPath).getParent());

            SPropertyOperations.set(it, "path", newIconMacro);
          }
        });
      }
    }
  }

  private boolean isValid(SNode icon) {
    IModule module = SNodeOperations.getModel(icon).getModelDescriptor().getModule();
    if (module == null) {
      return false;
    }
    String path = MacrosUtil.expandPath(SPropertyOperations.getString(icon, "path"), module.getModuleFqName());
    if (path == null) {
      return false;
    }
    IFile file = FileSystem.getInstance().getFileByPath(path);
    if (!(file.exists())) {
      return false;
    }
    try {
      new ImageIcon(path);
      return true;
    } catch (Throwable t) {
      return false;
    }
  }

  private void movePluginOut(Language l) {
    String solutionName = makePluginSolutionName(l, SOLUTION_NAME);
    Solution s = ModuleRepositoryFacade.getInstance().getModule(solutionName, Solution.class);
    if (s == null) {
      s = NewModuleUtil.createSolution(solutionName, l.getBundleHome().getDescendant("solutions").getDescendant(SOLUTION_NAME).getPath(), myProject, false);

      StandaloneMPSProject project = (StandaloneMPSProject) myProject;
      project.setFolderFor(s, project.getFolderFor(l));
    }
    s.getModuleDescriptor().setKind(SolutionKind.PLUGIN_OTHER);
    s.save();

    final String modelName = s.getModuleFqName() + ".plugin";
    List<SModelDescriptor> solModels = s.getOwnModelDescriptors();
    final Wrappers._T<SModelDescriptor> pluginModel = new Wrappers._T<SModelDescriptor>(ListSequence.fromList(solModels).where(new IWhereFilter<SModelDescriptor>() {
      public boolean accept(SModelDescriptor it) {
        return it.getLongName().equals(modelName);
      }
    }).first());
    if (pluginModel.value == null) {
      pluginModel.value = s.createModel(new SModelFqName(modelName, ""), s.getSModelRoots().iterator().next(), null);
    }

    List<SNode> nodes = IterableUtil.asList(LanguageAspect.PLUGIN.get(l).getSModel().roots());

    Iterable<SNode> nodes2Refactor = ListSequence.fromList(nodes).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return !(isFromFacetLang(it));
      }
    });
    RefactoringContext context = RefactoringContext.createRefactoringContextByName("jetbrains.mps.lang.core.refactorings.MoveNodes", Arrays.asList("target"), Arrays.asList(pluginModel.value), Sequence.fromIterable(nodes2Refactor).toListSequence(), myProject);
    RefactoringContext rc = (RefactoringContext) context;
    rc.setLocal(true);
    rc.setDoesGenerateModels(false);

    RefactoringAccess.getInstance().getRefactoringFacade().executeSimple(context);

    // <node> 

    jetbrains.mps.smodel.SModelOperations.validateLanguagesAndImports(pluginModel.value.getSModel(), false, true);

    SModelRepository.getInstance().saveAll();
  }

  private boolean isFromFacetLang(SNode node) {
    ModuleReference ref = SNodeOperations.getModel(SNodeOperations.getConceptDeclaration(node)).getModelDescriptor().getModule().getModuleReference();
    ModuleReference plugin = MPSModuleRepository.getInstance().getModuleById(ModuleId.fromString("696c1165-4a59-463b-bc5d-902caab85dd0")).getModuleReference();
    return ref.equals(plugin);
  }

  private String makePluginSolutionName(Language l, String name) {
    return l.getModuleFqName() + "." + name;
  }
}
