package jetbrains.mps.baseLanguage.pluginSolution.plugin;

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
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.ide.platform.refactoring.MoveNodeDialog;
import jetbrains.mps.project.MPSProject;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.ide.platform.refactoring.RefactoringAccess;
import jetbrains.mps.refactoring.framework.RefactoringContext;
import java.util.Arrays;

public class MoveStaticMethod_Action extends BaseAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(MoveStaticMethod_Action.class);

  public MoveStaticMethod_Action() {
    super("Move Static Method", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(true);
  }

  public boolean isApplicable(AnActionEvent event, final Map<String, Object> _params) {
    return RefactoringUtil.isApplicable(RefactoringUtil.getRefactoringByClassName("jetbrains.mps.baseLanguage.refactorings" + "." + "MoveStaticMethod"), ((SNode) MapSequence.fromMap(_params).get("target")));
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      {
        boolean enabled = this.isApplicable(event, _params);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "MoveStaticMethod", t);
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
        if (!(SNodeOperations.isInstanceOf(node, "jetbrains.mps.baseLanguage.structure.StaticMethodDeclaration"))) {
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
      final Wrappers._T<SNode> whereToMove = new Wrappers._T<SNode>();

      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          whereToMove.value = MoveNodeDialog.getSelectedObject(((MPSProject) MapSequence.fromMap(_params).get("project")).getProject(), ((SNode) MapSequence.fromMap(_params).get("target")), new MoveNodeDialog.NodeFilter("Select class to move: refactoring can't be applied to selected node") {
            public boolean check(SNode selectedObject, SNode nodeToMove, SModelDescriptor modelOfSelectedNode) {
              return SNodeOperations.isInstanceOf(selectedObject, "jetbrains.mps.baseLanguage.structure.ClassConcept") && !(ListSequence.fromList(SNodeOperations.getAncestors(nodeToMove, null, false)).contains(selectedObject));
            }
          });
        }
      });
      if (whereToMove.value == null) {
        return;
      }
      RefactoringAccess.getInstance().getRefactoringFacade().execute(RefactoringContext.createRefactoringContextByName("jetbrains.mps.baseLanguage.refactorings.MoveStaticMethod", Arrays.asList("destination"), Arrays.asList(whereToMove.value), ((SNode) MapSequence.fromMap(_params).get("target")), ((MPSProject) MapSequence.fromMap(_params).get("project"))));
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "MoveStaticMethod", t);
      }
    }
  }
}
