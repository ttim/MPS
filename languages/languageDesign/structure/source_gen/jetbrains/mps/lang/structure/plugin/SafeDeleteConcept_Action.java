package jetbrains.mps.lang.structure.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import javax.swing.Icon;
import jetbrains.mps.logging.Logger;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.refactoring.framework.RefactoringUtil;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.workbench.MPSDataKeys;
import jetbrains.mps.ide.actions.MPSCommonDataKeys;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.ide.refactoring.RefactoringFacade;
import jetbrains.mps.refactoring.framework.RefactoringContext;
import java.util.Arrays;
import jetbrains.mps.project.MPSProject;

public class SafeDeleteConcept_Action extends GeneratedAction {
  private static final Icon ICON = null;
  private static Logger LOG = Logger.getLogger(SafeDeleteConcept_Action.class);

  public SafeDeleteConcept_Action() {
    super("Safe Delete Concept", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(true);
  }

  public boolean isApplicable(AnActionEvent event, final Map<String, Object> _params) {
    return RefactoringUtil.isApplicable(RefactoringUtil.getRefactoringByClassName("jetbrains.mps.lang.structure.refactorings" + "." + "SafeDeleteConcept"), ((SNode) MapSequence.fromMap(_params).get("node")));
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      {
        boolean enabled = this.isApplicable(event, _params);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      LOG.error("User's action doUpdate method failed. Action:" + "SafeDeleteConcept", t);
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.fromMap(_params).put("mpsproject", event.getData(MPSDataKeys.MPS_PROJECT));
    if (MapSequence.fromMap(_params).get("mpsproject") == null) {
      return false;
    }
    {
      SNode node = event.getData(MPSCommonDataKeys.NODE);
      if (node != null) {
        if (!(SNodeOperations.isInstanceOf(node, "jetbrains.mps.lang.structure.structure.AbstractConceptDeclaration"))) {
          node = null;
        }
      }
      MapSequence.fromMap(_params).put("node", node);
    }
    if (MapSequence.fromMap(_params).get("node") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      new RefactoringFacade().execute(RefactoringContext.createRefactoringContextByName("jetbrains.mps.lang.structure.refactorings.SafeDeleteConcept", Arrays.asList(), Arrays.asList(), ((SNode) MapSequence.fromMap(_params).get("node")), ((MPSProject) MapSequence.fromMap(_params).get("mpsproject"))));
    } catch (Throwable t) {
      LOG.error("User's action execute method failed. Action:" + "SafeDeleteConcept", t);
    }
  }
}
