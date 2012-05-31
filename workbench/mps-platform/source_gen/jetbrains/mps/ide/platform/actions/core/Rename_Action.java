package jetbrains.mps.ide.platform.actions.core;

/*Generated by MPS */

import com.intellij.openapi.actionSystem.AnActionEvent;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.ide.actions.MPSCommonDataKeys;
import jetbrains.mps.ide.platform.refactoring.RefactoringAccess;
import jetbrains.mps.ide.platform.refactoring.RenameDialog;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.project.MPSProject;
import jetbrains.mps.refactoring.framework.RefactoringContext;
import jetbrains.mps.refactoring.framework.RefactoringUtil;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.workbench.action.BaseAction;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jetbrains.annotations.NotNull;

import javax.swing.Icon;
import javax.swing.JOptionPane;
import java.awt.Frame;
import java.util.Arrays;
import java.util.Map;

public class Rename_Action extends BaseAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(Rename_Action.class);

  public Rename_Action() {
    super("Rename", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(true);
  }

  @Override
  public boolean isDumbAware() {
    return true;
  }

  public boolean isApplicable(AnActionEvent event, final Map<String, Object> _params) {
    return RefactoringUtil.isApplicable(RefactoringUtil.getRefactoringByClassName("jetbrains.mps.lang.core.refactorings" + "." + "Rename"), ((SNode) MapSequence.fromMap(_params).get("target")));
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      {
        boolean enabled = this.isApplicable(event, _params);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "Rename", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    {
      SNode node = event.getData(MPSCommonDataKeys.NODE);
      if (node != null) {
        if (!(SNodeOperations.isInstanceOf(node, "jetbrains.mps.lang.core.structure.INamedConcept"))) {
          node = null;
        }
      }
      MapSequence.fromMap(_params).put("target", node);
    }
    if (MapSequence.fromMap(_params).get("target") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("project", event.getData(MPSCommonDataKeys.MPS_PROJECT));
    if (MapSequence.fromMap(_params).get("project") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("frame", event.getData(MPSCommonDataKeys.FRAME));
    if (MapSequence.fromMap(_params).get("frame") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      final String newName;
      final Wrappers._T<String> oldName = new Wrappers._T<String>();
      final Wrappers._boolean canBeRenamed = new Wrappers._boolean();
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          canBeRenamed.value = RenameUtil.canBeRenamed(((SNode) MapSequence.fromMap(_params).get("target")));
          oldName.value = SPropertyOperations.getString(((SNode) MapSequence.fromMap(_params).get("target")), "name");
        }
      });
      if (!(canBeRenamed.value)) {
        JOptionPane.showMessageDialog(((Frame) MapSequence.fromMap(_params).get("frame")), "Nodes with getter for the \"name\" property can't be renamed", "Node can't be renamed", JOptionPane.INFORMATION_MESSAGE);
        return;
      }
      newName = RenameDialog.getNewName(((MPSProject) MapSequence.fromMap(_params).get("project")).getProject(), oldName.value, "node");
      if (newName == null) {
        return;
      }
      ModelAccess.instance().runReadInEDT(new Runnable() {
        public void run() {
          if (!(((SNode) ((SNode) MapSequence.fromMap(_params).get("target"))).isRegistered()) || ((SNode) ((SNode) MapSequence.fromMap(_params).get("target"))).isDisposed()) {
            return;
          }
          RefactoringAccess.getInstance().getRefactoringFacade().execute(RefactoringContext.createRefactoringContextByName("jetbrains.mps.lang.core.refactorings.Rename", Arrays.asList("newName"), Arrays.asList(newName), ((SNode) MapSequence.fromMap(_params).get("target")), ((MPSProject) MapSequence.fromMap(_params).get("project"))));
        }
      });
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "Rename", t);
      }
    }
  }
}
