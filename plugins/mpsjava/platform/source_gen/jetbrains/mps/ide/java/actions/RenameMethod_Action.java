package jetbrains.mps.ide.java.actions;

/*Generated by MPS */

import jetbrains.mps.workbench.action.BaseAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.refactoring.framework.RefactoringUtil;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.ide.actions.MPSCommonDataKeys;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import java.util.List;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.baseLanguage.util.plugin.refactorings.MethodRefactoringUtils;
import jetbrains.mps.baseLanguage.util.plugin.refactorings.RenameUtil;
import jetbrains.mps.progress.EmptyProgressMonitor;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.ide.platform.refactoring.RenameMethodDialog;
import jetbrains.mps.project.MPSProject;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.ide.platform.refactoring.RefactoringAccess;
import jetbrains.mps.refactoring.framework.RefactoringContext;
import java.util.Arrays;

public class RenameMethod_Action extends BaseAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(RenameMethod_Action.class);

  public RenameMethod_Action() {
    super("Rename Method", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(true);
  }

  @Override
  public boolean isDumbAware() {
    return true;
  }

  public boolean isApplicable(AnActionEvent event, final Map<String, Object> _params) {
    return RefactoringUtil.isApplicable(RefactoringUtil.getRefactoringByClassName("jetbrains.mps.baseLanguage.refactorings" + "." + "RenameMethod"), ((SNode) MapSequence.fromMap(_params).get("target")));
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      {
        boolean enabled = this.isApplicable(event, _params);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "RenameMethod", t);
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
    MapSequence.fromMap(_params).put("context", event.getData(MPSCommonDataKeys.OPERATION_CONTEXT));
    if (MapSequence.fromMap(_params).get("context") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      final Wrappers._T<List<SNode>> overridingList = new Wrappers._T<List<SNode>>();
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          overridingList.value = MethodRefactoringUtils.findOverridingMethods(RenameUtil.getMethodDeclaration(((SNode) MapSequence.fromMap(_params).get("target"))), new EmptyProgressMonitor());
        }
      });

      final Wrappers._T<String> oldName = new Wrappers._T<String>();
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          if (SNodeOperations.isInstanceOf(((SNode) MapSequence.fromMap(_params).get("target")), "jetbrains.mps.baseLanguage.structure.IMethodCall")) {
            oldName.value = SPropertyOperations.getString(SLinkOperations.getTarget(SNodeOperations.cast(((SNode) MapSequence.fromMap(_params).get("target")), "jetbrains.mps.baseLanguage.structure.IMethodCall"), "baseMethodDeclaration", false), "name");
          } else if (SNodeOperations.isInstanceOf(((SNode) MapSequence.fromMap(_params).get("target")), "jetbrains.mps.baseLanguage.structure.BaseMethodDeclaration")) {
            oldName.value = SPropertyOperations.getString(SNodeOperations.cast(((SNode) MapSequence.fromMap(_params).get("target")), "jetbrains.mps.baseLanguage.structure.BaseMethodDeclaration"), "name");
          }
        }
      });
      RenameMethodDialog d = new RenameMethodDialog(((MPSProject) MapSequence.fromMap(_params).get("project")).getProject(), oldName.value, ListSequence.fromList(overridingList.value).isNotEmpty());
      d.show();

      String newName = d.getName();
      if (newName == null) {
        return;
      }
      RefactoringAccess.getInstance().getRefactoringFacade().execute(RefactoringContext.createRefactoringContextByName("jetbrains.mps.baseLanguage.refactorings.RenameMethod", Arrays.asList("newName", "refactorOverriding"), Arrays.asList(newName, d.getOverriding()), ((SNode) MapSequence.fromMap(_params).get("target")), ((MPSProject) MapSequence.fromMap(_params).get("project"))));
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "RenameMethod", t);
      }
    }
  }
}
