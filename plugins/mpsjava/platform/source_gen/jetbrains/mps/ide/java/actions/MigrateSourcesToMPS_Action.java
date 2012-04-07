package jetbrains.mps.ide.java.actions;

/*Generated by MPS */

import jetbrains.mps.workbench.action.BaseAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.project.structure.modules.ModuleDescriptor;
import jetbrains.mps.project.IModule;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.ide.actions.MPSCommonDataKeys;
import java.util.List;
import java.io.File;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.CollectionSequence;
import jetbrains.mps.ide.java.parser.JavaCompiler;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.project.MPSProject;
import jetbrains.mps.ide.java.util.StubResolver;
import jetbrains.mps.reloading.ClassLoaderManager;
import jetbrains.mps.progress.EmptyProgressMonitor;

public class MigrateSourcesToMPS_Action extends BaseAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(MigrateSourcesToMPS_Action.class);

  public MigrateSourcesToMPS_Action() {
    super("Migrate Sources to MPS", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(false);
  }

  public boolean isApplicable(AnActionEvent event, final Map<String, Object> _params) {
    ModuleDescriptor moduleDescr = ((IModule) MapSequence.fromMap(_params).get("module")).getModuleDescriptor();
    return moduleDescr != null && !(moduleDescr.getSourcePaths().isEmpty());
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      {
        boolean enabled = this.isApplicable(event, _params);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "MigrateSourcesToMPS", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.fromMap(_params).put("context", event.getData(MPSCommonDataKeys.OPERATION_CONTEXT));
    if (MapSequence.fromMap(_params).get("context") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("module", event.getData(MPSCommonDataKeys.MODULE));
    if (MapSequence.fromMap(_params).get("module") == null) {
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
      ModuleDescriptor moduleDescr = ((IModule) MapSequence.fromMap(_params).get("module")).getModuleDescriptor();
      if (moduleDescr == null || moduleDescr.getSourcePaths().isEmpty()) {
        return;
      }

      List<File> sourcePaths = ListSequence.fromList(new ArrayList<File>());
      for (String path : CollectionSequence.fromCollection(moduleDescr.getSourcePaths())) {
        ListSequence.fromList(sourcePaths).addElement(new File(path));
      }
      JavaCompiler javaCompiler = new JavaCompiler(((IOperationContext) MapSequence.fromMap(_params).get("context")), ((IModule) MapSequence.fromMap(_params).get("module")), sourcePaths, false, ((MPSProject) MapSequence.fromMap(_params).get("project")).getProject());
      javaCompiler.compile();
      // re-resolve references to just imported models 
      new StubResolver(javaCompiler.getAffectedModels()).resolveInProject(((MPSProject) MapSequence.fromMap(_params).get("project")), ((IOperationContext) MapSequence.fromMap(_params).get("context")));

      moduleDescr.getSourcePaths().clear();

      ClassLoaderManager.getInstance().reloadAll(new EmptyProgressMonitor());
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "MigrateSourcesToMPS", t);
      }
    }
  }
}
