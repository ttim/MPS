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
import jetbrains.mps.ide.actions.MPSCommonDataKeys;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.workbench.MPSDataKeys;
import jetbrains.mps.refactoring.framework.RefactoringContext;
import java.util.Arrays;
import jetbrains.mps.project.MPSProject;
import jetbrains.mps.ide.refactoring.RefactoringFacade;
import jetbrains.mps.ide.refactoring.RenameDialog;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;

public class RenameConcept_Action extends GeneratedAction {
  private static final Icon ICON = null;
  private static Logger LOG = Logger.getLogger(RenameConcept_Action.class);

  public RenameConcept_Action() {
    super("Rename Concept", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(false);
  }

  public boolean isApplicable(AnActionEvent event, final Map<String, Object> _params) {
    return RefactoringUtil.isApplicable(RefactoringUtil.getRefactoringByClassName("jetbrains.mps.lang.structure.refactorings" + "." + "RenameConcept"), ((SNode) MapSequence.fromMap(_params).get("target")));
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      {
        boolean enabled = this.isApplicable(event, _params);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      LOG.error("User's action doUpdate method failed. Action:" + "RenameConcept", t);
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
        if (!(SNodeOperations.isInstanceOf(node, "jetbrains.mps.lang.structure.structure.AbstractConceptDeclaration"))) {
          node = null;
        }
      }
      MapSequence.fromMap(_params).put("target", node);
    }
    if (MapSequence.fromMap(_params).get("target") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("project", event.getData(MPSDataKeys.MPS_PROJECT));
    if (MapSequence.fromMap(_params).get("project") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      String newName = RenameConcept_Action.this.init(_params);
      if (newName == null) {
        return;
      }
      RefactoringContext c = RefactoringContext.createRefactoringContextByName("jetbrains.mps.lang.structure.refactorings.RenameConcept", Arrays.asList("newName"), Arrays.asList(newName), ((SNode) MapSequence.fromMap(_params).get("target")), ((MPSProject) MapSequence.fromMap(_params).get("project")));
      new RefactoringFacade().execute(c);
    } catch (Throwable t) {
      LOG.error("User's action execute method failed. Action:" + "RenameConcept", t);
    }
  }

  private String init(final Map<String, Object> _params) {
    return RenameDialog.getNewName(((MPSProject) MapSequence.fromMap(_params).get("project")).getProject(), SPropertyOperations.getString(((SNode) MapSequence.fromMap(_params).get("target")), "name"), "concept");
  }
}
