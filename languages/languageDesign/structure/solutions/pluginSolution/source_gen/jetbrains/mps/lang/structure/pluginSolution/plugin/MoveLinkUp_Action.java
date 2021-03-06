package jetbrains.mps.lang.structure.pluginSolution.plugin;

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
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.ide.refactoring.MoveUpDialog;
import jetbrains.mps.project.MPSProject;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.lang.structure.scripts.RefUtil;
import jetbrains.mps.ide.refactoring.OptionDialog;
import jetbrains.mps.ide.platform.refactoring.RefactoringAccess;
import jetbrains.mps.refactoring.framework.RefactoringContext;
import java.util.Arrays;

public class MoveLinkUp_Action extends BaseAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(MoveLinkUp_Action.class);

  public MoveLinkUp_Action() {
    super("Move Link Up", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(true);
  }

  @Override
  public boolean isDumbAware() {
    return true;
  }

  public boolean isApplicable(AnActionEvent event, final Map<String, Object> _params) {
    return RefactoringUtil.isApplicable(RefactoringUtil.getRefactoringByClassName("jetbrains.mps.lang.structure.refactorings" + "." + "MoveLinkUp"), ((SNode) MapSequence.fromMap(_params).get("target")));
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      {
        boolean enabled = this.isApplicable(event, _params);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "MoveLinkUp", t);
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
        if (!(SNodeOperations.isInstanceOf(node, "jetbrains.mps.lang.structure.structure.LinkDeclaration"))) {
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
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      final SNode targetConcept = MoveUpDialog.getConcept(((MPSProject) MapSequence.fromMap(_params).get("project")).getProject(), ((SNode) MapSequence.fromMap(_params).get("target")), "link");
      if (targetConcept == null) {
        return;
      }
      final Wrappers._T<SNode> linkToReplace = new Wrappers._T<SNode>();
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          linkToReplace.value = RefUtil.findLinkToMerge(targetConcept, ((SNode) MapSequence.fromMap(_params).get("target")));

        }
      });
      Boolean mergeLinks = false;
      if ((linkToReplace.value != null)) {
        String title = "Merge to link with the same name";
        switch (OptionDialog.showDialog(((MPSProject) MapSequence.fromMap(_params).get("project")), title, title + "?", true)) {
          case 0:
            mergeLinks = true;
            break;
          case 1:
            mergeLinks = false;
            break;
          case 2:
            return;
          default:
        }
      }
      final Boolean merge = mergeLinks;
      ModelAccess.instance().runReadInEDT(new Runnable() {
        public void run() {
          if (!(((SNode) ((SNode) MapSequence.fromMap(_params).get("target"))).isRegistered()) || ((SNode) ((SNode) MapSequence.fromMap(_params).get("target"))).isDisposed()) {
            return;
          }
          if (!(((SNode) targetConcept).isRegistered()) || ((SNode) targetConcept).isDisposed()) {
            return;
          }
          RefactoringAccess.getInstance().getRefactoringFacade().execute(RefactoringContext.createRefactoringContextByName("jetbrains.mps.lang.structure.refactorings.MoveLinkUp", Arrays.asList("targetConcept", "mergeLinks"), Arrays.asList(targetConcept, merge), ((SNode) MapSequence.fromMap(_params).get("target")), ((MPSProject) MapSequence.fromMap(_params).get("project"))));
        }
      });



    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "MoveLinkUp", t);
      }
    }
  }
}
