package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.workbench.action.BaseAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.project.IModule;
import javax.swing.tree.TreeNode;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.ide.depanalyzer.DependencyTreeNode;
import jetbrains.mps.ide.depanalyzer.DependencyUtil;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.workbench.MPSDataKeys;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import jetbrains.mps.ide.findusages.model.SearchResults;
import com.intellij.openapi.project.Project;
import jetbrains.mps.project.MPSProject;
import com.intellij.openapi.ui.Messages;
import jetbrains.mps.plugins.projectplugins.ProjectPluginManager;
import jetbrains.mps.project.structure.modules.ModuleDescriptor;
import java.util.Collection;
import jetbrains.mps.project.structure.modules.Dependency;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.CollectionSequence;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.smodel.ModelAccess;

public class SafeDeleteModuleDependency_Action extends BaseAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(SafeDeleteModuleDependency_Action.class);

  public SafeDeleteModuleDependency_Action() {
    super("Safe Delete Dependency", "Safe delete module dependency", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(true);
  }

  public boolean isApplicable(AnActionEvent event, final Map<String, Object> _params) {
    IModule from = check_bai5av_a0a0a_0(as_iuftgz_a0a0a0a(((TreeNode) MapSequence.fromMap(_params).get("node")).getParent(), DependencyTreeNode.class));
    return from != null && !(from.isPackaged()) && check_bai5av_a0a0b0a(as_iuftgz_a0a0a0b0a(((TreeNode) MapSequence.fromMap(_params).get("node")), DependencyTreeNode.class)).linktype == DependencyUtil.LinkType.Depends;
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      {
        boolean enabled = this.isApplicable(event, _params);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "SafeDeleteModuleDependency", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.fromMap(_params).put("node", event.getData(MPSDataKeys.LOGICAL_VIEW_NODE));
    if (MapSequence.fromMap(_params).get("node") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("mpsProject", event.getData(MPSCommonDataKeys.MPS_PROJECT));
    MapSequence.fromMap(_params).put("project", event.getData(PlatformDataKeys.PROJECT));
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      IModule from = check_bai5av_a0a0a(as_iuftgz_a0a0a0a0d(((TreeNode) MapSequence.fromMap(_params).get("node")).getParent(), DependencyTreeNode.class));
      IModule to = check_bai5av_a0b0a(as_iuftgz_a0a0b0a0d(((TreeNode) MapSequence.fromMap(_params).get("node")), DependencyTreeNode.class));
      SearchResults results = DependenciesUtil.analyzeDependencies(from, to, ((Project) MapSequence.fromMap(_params).get("project")), ((MPSProject) MapSequence.fromMap(_params).get("mpsProject")), false);
      if (!(results.getSearchResults().isEmpty())) {
        int res = Messages.showDialog("Can't safe delete dependency", "Safe delete impossible", new String[]{"View dependencies", "Delete anyway", "Cancel"}, 0, null);
        if (res == 0) {
          ((Project) MapSequence.fromMap(_params).get("project")).getComponent(ProjectPluginManager.class).getTool(AnalyzeDependencies_Tool.class).openToolLater(true);
        }
        if (res != 1) {
          return;
        }
      }
      SafeDeleteModuleDependency_Action.this.removeDependency(from, to, _params);
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "SafeDeleteModuleDependency", t);
      }
    }
  }

  private void removeDependency(final IModule from, final IModule to, final Map<String, Object> _params) {
    final ModuleDescriptor descriptor = from.getModuleDescriptor();
    Collection<Dependency> dependencies = descriptor.getDependencies();
    List<Dependency> badDeps = CollectionSequence.fromCollection(((Collection<Dependency>) dependencies)).where(new IWhereFilter<Dependency>() {
      public boolean accept(Dependency it) {
        return it.getModuleRef().equals(to.getModuleReference());
      }
    }).toListSequence();
    dependencies.removeAll(badDeps);
    ModelAccess.instance().runWriteAction(new Runnable() {
      public void run() {
        // <node> 
        from.save();
      }
    });
    ((Project) MapSequence.fromMap(_params).get("project")).getComponent(ProjectPluginManager.class).getTool(ModuleDependenies_Tool.class).resetAll();
  }

  private static IModule check_bai5av_a0a0a_0(DependencyTreeNode checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getModule();
    }
    return null;
  }

  private static DependencyUtil.Link check_bai5av_a0a0b0a(DependencyTreeNode checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getLink();
    }
    return null;
  }

  private static IModule check_bai5av_a0a0a(DependencyTreeNode checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getModule();
    }
    return null;
  }

  private static IModule check_bai5av_a0b0a(DependencyTreeNode checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getModule();
    }
    return null;
  }

  private static <T> T as_iuftgz_a0a0a0a(Object o, Class<T> type) {
    return (type.isInstance(o) ?
      (T) o :
      null
    );
  }

  private static <T> T as_iuftgz_a0a0a0b0a(Object o, Class<T> type) {
    return (type.isInstance(o) ?
      (T) o :
      null
    );
  }

  private static <T> T as_iuftgz_a0a0a0a0d(Object o, Class<T> type) {
    return (type.isInstance(o) ?
      (T) o :
      null
    );
  }

  private static <T> T as_iuftgz_a0a0b0a0d(Object o, Class<T> type) {
    return (type.isInstance(o) ?
      (T) o :
      null
    );
  }
}
