package jetbrains.mps.build.generictasks.pluginSolution.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.actions.GeneratedAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.project.IModule;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.smodel.Language;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.ide.actions.MPSCommonDataKeys;
import jetbrains.mps.build.generictasks.taskfromjar.Generator;
import jetbrains.mps.smodel.SModelDescriptor;

public class ImportAntStuff_Action extends GeneratedAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(ImportAntStuff_Action.class);

  public ImportAntStuff_Action() {
    super("Import Ant Stuff", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(false);
  }

  public boolean isApplicable(AnActionEvent event, final Map<String, Object> _params) {
    return (((IModule) MapSequence.fromMap(_params).get("module")) instanceof Language) && (((IModule) MapSequence.fromMap(_params).get("module")).getModuleFqName().contains("jetbrains.mps.build.generictasks"));
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      {
        boolean enabled = this.isApplicable(event, _params);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "ImportAntStuff", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.fromMap(_params).put("module", event.getData(MPSCommonDataKeys.MODULE));
    if (MapSequence.fromMap(_params).get("module") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      Language language = ((Language) ((IModule) MapSequence.fromMap(_params).get("module")));
      ImportAntStuff_Action.this.importTasks(language, ImportAntStuffUtil.getGenerated(language), Generator.Modes.CORE, _params);
      ImportAntStuff_Action.this.importTasks(language, ImportAntStuffUtil.getOptional(language), Generator.Modes.JUNIT, _params);
      if (log.isInfoEnabled()) {
        log.info("Import completed.");
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "ImportAntStuff", t);
      }
    }
  }

  private void importTasks(Language l, SModelDescriptor model, Generator.Modes m, final Map<String, Object> _params) {
    assert model != null;
    new Generator().generateTasks(model.getSModel(), m, ImportAntStuffUtil.getAllModels(l));
  }
}
