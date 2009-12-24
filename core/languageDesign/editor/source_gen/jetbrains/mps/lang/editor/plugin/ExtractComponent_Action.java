package jetbrains.mps.lang.editor.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import javax.swing.Icon;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import jetbrains.mps.workbench.MPSDataKeys;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import javax.swing.JOptionPane;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.editor.behavior.AbstractComponent_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;

public class ExtractComponent_Action extends GeneratedAction {
  private static final Icon ICON = null;
  private static Logger LOG = Logger.getLogger(ExtractComponent_Action.class);

  private SNode node;
  private EditorContext editorContext;

  public ExtractComponent_Action() {
    super("Extract Component", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(true);
  }

  @NotNull
  public String getKeyStroke() {
    return "ctrl alt C";
  }

  public void doUpdate(@NotNull AnActionEvent event) {
    try {
      this.enable(event.getPresentation());
    } catch (Throwable t) {
      LOG.error("User's action doUpdate method failed. Action:" + "ExtractComponent", t);
      this.disable(event.getPresentation());
    }
  }

  @Override
  protected boolean collectActionData(AnActionEvent event) {
    if (!(super.collectActionData(event))) {
      return false;
    }
    {
      SNode node = event.getData(MPSDataKeys.NODE);
      if (node != null) {
        if (!(SNodeOperations.isInstanceOf(node, "jetbrains.mps.lang.editor.structure.EditorCellModel"))) {
          node = null;
        }
      }
      this.node = node;
    }
    if (this.node == null) {
      return false;
    }
    this.editorContext = event.getData(MPSDataKeys.EDITOR_CONTEXT);
    if (this.editorContext == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event) {
    try {
      final SNode container = SNodeOperations.getAncestor(ExtractComponent_Action.this.node, "jetbrains.mps.lang.editor.structure.BaseEditorComponent", false, false);
      final String componentName = JOptionPane.showInputDialog(ExtractComponent_Action.this.editorContext.getNodeEditorComponent(), "Enter a component name:", "");
      if (componentName == null) {
        return;
      }
      ModelAccess.instance().runWriteActionInCommand(new Runnable() {
        public void run() {
          SModel model = SNodeOperations.getModel(ExtractComponent_Action.this.node);
          SNode component = SModelOperations.createNewRootNode(model, "jetbrains.mps.lang.editor.structure.EditorComponentDeclaration", null);
          SPropertyOperations.set(component, "name", componentName);
          SLinkOperations.setTarget(component, "conceptDeclaration", AbstractComponent_Behavior.call_getConceptDeclaration_7055725856388417603(container), false);
          SLinkOperations.setTarget(component, "cellModel", SNodeOperations.copyNode(ExtractComponent_Action.this.node), true);
          SNode toReplace = SConceptOperations.createNewNode("jetbrains.mps.lang.editor.structure.CellModel_Component", null);
          SLinkOperations.setTarget(toReplace, "editorComponent", component, false);
          SNodeOperations.replaceWithAnother(ExtractComponent_Action.this.node, toReplace);
        }
      });
    } catch (Throwable t) {
      LOG.error("User's action execute method failed. Action:" + "ExtractComponent", t);
    }
  }
}
