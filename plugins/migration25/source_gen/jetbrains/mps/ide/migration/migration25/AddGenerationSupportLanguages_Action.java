package jetbrains.mps.ide.migration.migration25;

/*Generated by MPS */

import jetbrains.mps.workbench.action.BaseAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.ide.actions.MPSCommonDataKeys;
import jetbrains.mps.project.structure.modules.ModuleReference;
import jetbrains.mps.smodel.MPSModuleRepository;
import jetbrains.mps.project.ModuleId;
import java.util.List;
import jetbrains.mps.project.IModule;
import jetbrains.mps.project.MPSProject;
import jetbrains.mps.smodel.Generator;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.IVisitor;
import jetbrains.mps.internal.collections.runtime.ITranslator2;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.SModelRepository;

public class AddGenerationSupportLanguages_Action extends BaseAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(AddGenerationSupportLanguages_Action.class);

  public AddGenerationSupportLanguages_Action() {
    super("Add Generation Languages to Generators", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(false);
  }

  @Override
  public boolean isDumbAware() {
    return true;
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      this.enable(event.getPresentation());
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "AddGenerationSupportLanguages", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.fromMap(_params).put("project", event.getData(MPSCommonDataKeys.MPS_PROJECT));
    if (MapSequence.fromMap(_params).get("project") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      final ModuleReference genPurpose = MPSModuleRepository.getInstance().getModuleById(ModuleId.fromString("fbc25dd2-5da4-483a-8b19-70928e1b62d7")).getModuleReference();
      final ModuleReference generator = MPSModuleRepository.getInstance().getModuleById(ModuleId.fromString("b401a680-8325-4110-8fd3-84331ff25bef")).getModuleReference();
      final ModuleReference genContext = MPSModuleRepository.getInstance().getModuleById(ModuleId.fromString("d7706f63-9be2-479c-a3da-ae92af1e64d5")).getModuleReference();

      List<IModule> modules = ((MPSProject) MapSequence.fromMap(_params).get("project")).getModulesWithGenerators();
      Iterable<Generator> generators = ListSequence.fromList(modules).where(new IWhereFilter<IModule>() {
        public boolean accept(IModule it) {
          return it instanceof Generator;
        }
      }).select(new ISelector<IModule, Generator>() {
        public Generator select(IModule it) {
          return ((Generator) it);
        }
      });

      Sequence.fromIterable(generators).visitAll(new IVisitor<Generator>() {
        public void visit(Generator it) {
          it.addUsedDevkit(genPurpose);
          it.addUsedLanguage(generator);
          it.addUsedLanguage(genContext);
          it.invalidateCaches();
          it.invalidateDependencies();
          it.save();
        }
      });
      Sequence.fromIterable(generators).translate(new ITranslator2<Generator, SModelDescriptor>() {
        public Iterable<SModelDescriptor> translate(Generator it) {
          return it.getOwnTemplateModels();
        }
      }).visitAll(new IVisitor<SModelDescriptor>() {
        public void visit(SModelDescriptor it) {
          it.getSModel().addDevKit(genPurpose);
          it.getSModel().addLanguage(generator);
          it.getSModel().addLanguage(genContext);
        }
      });

      SModelRepository.getInstance().saveAll();
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "AddGenerationSupportLanguages", t);
      }
    }
  }
}
