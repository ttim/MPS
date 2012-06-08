package jetbrains.mps.ide.platform.actions.core;

/*Generated by MPS */

import jetbrains.mps.workbench.action.BaseAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.refactoring.framework.RefactoringUtil;
import java.util.List;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.ide.actions.MPSCommonDataKeys;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.ide.platform.refactoring.MoveNodesDialog;
import jetbrains.mps.project.MPSProject;
import jetbrains.mps.ide.platform.refactoring.RefactoringAccess;
import jetbrains.mps.refactoring.framework.RefactoringContext;
import java.util.Arrays;

public class MoveNodes_Action extends BaseAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(MoveNodes_Action.class);

  public MoveNodes_Action() {
    super("Move Nodes", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(true);
  }

  @Override
  public boolean isDumbAware() {
    return true;
  }

  public boolean isApplicable(AnActionEvent event, final Map<String, Object> _params) {
    return RefactoringUtil.isApplicable(RefactoringUtil.getRefactoringByClassName("jetbrains.mps.lang.core.refactorings" + "." + "MoveNodes"), ((List<SNode>) MapSequence.fromMap(_params).get("target")));
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      {
        boolean enabled = this.isApplicable(event, _params);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "MoveNodes", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    {
      List<SNode> nodes = event.getData(MPSCommonDataKeys.NODES);
      boolean error = false;
      if (nodes != null) {
      }
      if (error || nodes == null) {
        MapSequence.fromMap(_params).put("target", null);
      } else {
        MapSequence.fromMap(_params).put("target", ListSequence.fromListWithValues(new ArrayList<SNode>(), nodes));
      }
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
      final Wrappers._T<SModelDescriptor> targetModelDescriptor = new Wrappers._T<SModelDescriptor>();

      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          targetModelDescriptor.value = ((SModel) SNodeOperations.getModel(ListSequence.fromList(((List<SNode>) MapSequence.fromMap(_params).get("target"))).first())).getModelDescriptor();
        }
      });
      final Object newNode = MoveNodesDialog.getSelectedObject(((MPSProject) MapSequence.fromMap(_params).get("project")).getProject(), targetModelDescriptor.value, new MoveNodesDialog.ModelFilter("Choose Node or Model") {
        public boolean check(Object selectedObject, SModelDescriptor model) {
          return selectedObject instanceof SNode || selectedObject instanceof SModelDescriptor;
        }
      });
      if (newNode == null) {
        return;
      }
      ModelAccess.instance().runReadInEDT(new Runnable() {
        public void run() {
          for (SNode node : ListSequence.fromList(((List<SNode>) MapSequence.fromMap(_params).get("target")))) {
            if (!(((SNode) node).isRegistered()) || ((SNode) node).isDisposed()) {
              return;
            }
          }
          if (newNode instanceof SNode && (!(((SNode) newNode).isRegistered()) || ((SNode) newNode).isDisposed())) {
            return;
          }
          if (newNode instanceof SModelDescriptor && (!(((SModelDescriptor) newNode).isRegistered()))) {
            return;
          }

          RefactoringAccess.getInstance().getRefactoringFacade().execute(RefactoringContext.createRefactoringContextByName("jetbrains.mps.lang.core.refactorings.MoveNodes", Arrays.asList("target"), Arrays.asList(newNode), ((List<SNode>) MapSequence.fromMap(_params).get("target")), ((MPSProject) MapSequence.fromMap(_params).get("project"))));
        }
      });
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "MoveNodes", t);
      }
    }
  }
}
