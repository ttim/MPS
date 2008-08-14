package jetbrains.mps.ide.actions;

/*Generated by MPS */

import com.intellij.openapi.actionSystem.AnActionEvent;
import jetbrains.mps.baseLanguage.structure.ClassConcept;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.ide.hierarchy.BaseLanguageHierarchyViewTool;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.workbench.MPSDataKeys;
import org.jetbrains.annotations.NotNull;

import javax.swing.Icon;

public class ShowClassInHierarchy_Action extends GeneratedAction {
  public static final Logger LOG = Logger.getLogger(ShowClassInHierarchy_Action.class);
  public static final Icon ICON = null;

  private SNode node;
  public IOperationContext context;

  public ShowClassInHierarchy_Action() {
    super("Show Class In Hierarchy", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(false);
  }

  @NotNull()
  public String getKeyStroke() {
    return "ctrl H";
  }

  public boolean isApplicable(AnActionEvent event) {
    return SNodeOperations.getAncestor(ShowClassInHierarchy_Action.this.node, "jetbrains.mps.baseLanguage.structure.ClassConcept", true, false) != null;
  }

  public void doUpdate(@NotNull()AnActionEvent event) {
    try {
      {
        boolean enabled = this.isApplicable(event);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      LOG.error("User's action doUpdate method failed. Action:" + "ShowClassInHierarchy", t);
      this.disable(event.getPresentation());
    }
  }

  @Override()
  protected boolean collectActionData(AnActionEvent event) {
    try {
      if (!(super.collectActionData(event))) {
        return false;
      }
      {
        SNode node = event.getData(MPSDataKeys.SNODE);
        if (node != null) {
        }
        this.node = node;
        /*
          if (!(<!IsSubtypeExpression TextGen not found!>)) {
            return false;
          }
        */
      }
      if (this.node == null) {
        return false;
      }
      this.context = event.getData(MPSDataKeys.OPERATION_CONTEXT);
      if (this.context == null) {
        return false;
      }
    } catch (Throwable t) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull() final AnActionEvent event) {
    try {
      SNode classNode = SNodeOperations.getAncestor(ShowClassInHierarchy_Action.this.node, "jetbrains.mps.baseLanguage.structure.ClassConcept", false, false);
      BaseLanguageHierarchyViewTool tool = ShowClassInHierarchy_Action.this.context.getComponent(BaseLanguageHierarchyViewTool.class);
      tool.showConceptInHierarchy(((ClassConcept) SNodeOperations.getAdapter(classNode)), ShowClassInHierarchy_Action.this.context);
      tool.openToolLater(true);
    } catch (Throwable t) {
      LOG.error("User's action execute method failed. Action:" + "ShowClassInHierarchy", t);
    }
  }

}
