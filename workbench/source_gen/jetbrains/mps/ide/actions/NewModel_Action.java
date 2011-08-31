package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.smodel.SModelStereotype;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.workbench.MPSDataKeys;
import jetbrains.mps.project.IModule;
import javax.swing.JOptionPane;
import java.awt.Frame;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.ide.dialogs.project.creation.NewModelDialog;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.ide.projectPane.ProjectPane;
import com.intellij.openapi.project.Project;
import jetbrains.mps.ide.StereotypeProvider;
import javax.swing.tree.TreeNode;
import jetbrains.mps.ide.projectPane.NamespaceTextNode;

public class NewModel_Action extends GeneratedAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(NewModel_Action.class);

  public NewModel_Action() {
    super("Model", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(true);
  }

  public boolean isApplicable(AnActionEvent event, final Map<String, Object> _params) {
    String stereotype = NewModel_Action.this.getStereotype(_params);
    if (stereotype == null) {
      return true;
    }
    for (String availableStereotype : SModelStereotype.values) {
      if (stereotype.equals(availableStereotype)) {
        return true;
      }
    }
    return false;
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      {
        boolean enabled = this.isApplicable(event, _params);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "NewModel", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.<String,Object>fromMap(_params).put("frame", event.getData(MPSDataKeys.FRAME));
    if (MapSequence.<String,Object>fromMap(_params).get("frame") == null) {
      return false;
    }
    MapSequence.<String,Object>fromMap(_params).put("project", event.getData(MPSDataKeys.PROJECT));
    if (MapSequence.<String,Object>fromMap(_params).get("project") == null) {
      return false;
    }
    MapSequence.<String,Object>fromMap(_params).put("context", event.getData(MPSDataKeys.OPERATION_CONTEXT));
    if (MapSequence.<String,Object>fromMap(_params).get("context") == null) {
      return false;
    }
    MapSequence.<String,Object>fromMap(_params).put("module", event.getData(MPSDataKeys.CONTEXT_MODULE));
    if (MapSequence.<String,Object>fromMap(_params).get("module") == null) {
      return false;
    }
    MapSequence.<String,Object>fromMap(_params).put("treeNode", event.getData(MPSDataKeys.LOGICAL_VIEW_NODE));
    if (MapSequence.<String,Object>fromMap(_params).get("treeNode") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      if (((IModule) MapSequence.<String,Object>fromMap(_params).get("module")).getSModelRoots().size() == 0) {
        int code = JOptionPane.showConfirmDialog(((Frame) MapSequence.<String,Object>fromMap(_params).get("frame")), "There are no model roots. Do you want to create one?", "", JOptionPane.YES_NO_OPTION);
        if (code != JOptionPane.YES_OPTION) {
          return;
        } else {
          NewModelUtil.ShowModulePropertiesDialog(((IModule) MapSequence.<String,Object>fromMap(_params).get("module")), ((IOperationContext) MapSequence.<String,Object>fromMap(_params).get("context")));
        }
      }
      if (((IModule) MapSequence.<String,Object>fromMap(_params).get("module")).getSModelRoots().size() == 0) {
        JOptionPane.showMessageDialog(((Frame) MapSequence.<String,Object>fromMap(_params).get("frame")), "Can't create a model in solution with no model roots", "Can't create model", JOptionPane.ERROR_MESSAGE);
        return;
      }
      final Wrappers._T<NewModelDialog> dialog = new Wrappers._T<NewModelDialog>();
      final IOperationContext localContext = ((IOperationContext) MapSequence.<String,Object>fromMap(_params).get("context"));
      final IModule localModule = (localContext.getModule() != null ?
        localContext.getModule() :
        ((IModule) MapSequence.<String,Object>fromMap(_params).get("module"))
      );
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          String stereotype = NewModel_Action.this.getStereotype(_params);
          dialog.value = new NewModelDialog(localModule, NewModel_Action.this.getNamespace(_params), localContext, stereotype, NewModel_Action.this.isStrict(_params));
        }
      });
      dialog.value.showDialog();
      SModelDescriptor result = dialog.value.getResult();
      if (result != null) {
        SModelDescriptor modelDescriptor = result;
        ProjectPane.getInstance(((Project) MapSequence.<String,Object>fromMap(_params).get("project"))).selectModel(modelDescriptor, false);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "NewModel", t);
      }
    }
  }

  private StereotypeProvider getStereotypeProvider(final Map<String, Object> _params) {
    TreeNode parent = ((TreeNode) MapSequence.<String,Object>fromMap(_params).get("treeNode")).getParent();
    while (parent != null) {
      if (parent instanceof StereotypeProvider) {
        return ((StereotypeProvider) parent);
      }
      parent = parent.getParent();
    }
    return null;
  }

  protected String getStereotype(final Map<String, Object> _params) {
    if (((TreeNode) MapSequence.<String,Object>fromMap(_params).get("treeNode")) instanceof StereotypeProvider) {
      return ((StereotypeProvider) ((TreeNode) MapSequence.<String,Object>fromMap(_params).get("treeNode"))).getStereotype();
    } else if (((TreeNode) MapSequence.<String,Object>fromMap(_params).get("treeNode")) instanceof NamespaceTextNode) {
      StereotypeProvider parent = NewModel_Action.this.getStereotypeProvider(_params);
      if (parent != null) {
        return parent.getStereotype();
      }
    }
    return null;
  }

  protected boolean isStrict(final Map<String, Object> _params) {
    if (((TreeNode) MapSequence.<String,Object>fromMap(_params).get("treeNode")) instanceof StereotypeProvider) {
      return ((StereotypeProvider) ((TreeNode) MapSequence.<String,Object>fromMap(_params).get("treeNode"))).isStrict();
    } else if (((TreeNode) MapSequence.<String,Object>fromMap(_params).get("treeNode")) instanceof NamespaceTextNode) {
      StereotypeProvider parent = NewModel_Action.this.getStereotypeProvider(_params);
      if (parent != null) {
        return parent.isStrict();
      }
    }
    return false;
  }

  protected String getNamespace(final Map<String, Object> _params) {
    return null;
  }
}
