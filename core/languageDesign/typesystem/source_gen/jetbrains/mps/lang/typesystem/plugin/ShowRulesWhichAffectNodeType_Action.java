package jetbrains.mps.lang.typesystem.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import javax.swing.Icon;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.project.MPSProject;
import jetbrains.mps.smodel.SNode;
import java.awt.Frame;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import jetbrains.mps.workbench.MPSDataKeys;
import jetbrains.mps.typesystem.inference.NodeTypesComponent;
import jetbrains.mps.typesystem.inference.NodeTypesComponentsRepository;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import java.util.Set;
import jetbrains.mps.util.Pair;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.SModelRepository;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.workbench.editors.MPSEditorOpener;
import jetbrains.mps.typesystem.uiActions.MyMenu;

public class ShowRulesWhichAffectNodeType_Action extends GeneratedAction {
  private static final Icon ICON = null;
  private static Logger LOG = Logger.getLogger(ShowRulesWhichAffectNodeType_Action.class);

  private EditorCell cell;
  private IOperationContext operationContext;
  private MPSProject project;
  private SNode node;
  private Frame frame;

  public ShowRulesWhichAffectNodeType_Action() {
    super("Show Rules Which Affect Node's Type", "", ICON);
    this.setIsAlwaysVisible(true);
    this.setExecuteOutsideCommand(false);
  }

  @NotNull
  public String getKeyStroke() {
    return "ctrl alt shift T";
  }

  public void doUpdate(@NotNull AnActionEvent event) {
    try {
      this.enable(event.getPresentation());
    } catch (Throwable t) {
      LOG.error("User's action doUpdate method failed. Action:" + "ShowRulesWhichAffectNodeType", t);
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
      }
      this.node = node;
    }
    if (this.node == null) {
      return false;
    }
    this.cell = event.getData(MPSDataKeys.EDITOR_CELL);
    if (this.cell == null) {
      return false;
    }
    this.operationContext = event.getData(MPSDataKeys.OPERATION_CONTEXT);
    if (this.operationContext == null) {
      return false;
    }
    this.project = event.getData(MPSDataKeys.MPS_PROJECT);
    if (this.project == null) {
      return false;
    }
    this.frame = event.getData(MPSDataKeys.FRAME);
    if (this.frame == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event) {
    try {
      NodeTypesComponent component = NodeTypesComponentsRepository.getInstance().getNodeTypesComponent(SNodeOperations.getContainingRoot(ShowRulesWhichAffectNodeType_Action.this.node));
      if (component == null) {
        return;
      }
      Set<Pair<String, String>> rulesIds = component.getRulesWhichAffectNodeType(ShowRulesWhichAffectNodeType_Action.this.node);
      if (rulesIds == null) {
        return;
      }
      List<SNode> rules = ListSequence.fromList(new ArrayList<SNode>());
      for (Pair<String, String> ruleId : SetSequence.fromSet(rulesIds)) {
        SModelDescriptor modelDescriptor = SModelRepository.getInstance().getModelDescriptor(SModelReference.fromString(ruleId.o1));
        if (modelDescriptor == null) {
          continue;
        }
        SNode rule = modelDescriptor.getSModel().getNodeById(ruleId.o2);
        if (rule != null) {
          ListSequence.fromList(rules).addElement(rule);
        }
      }
      // single rule
      if (ListSequence.fromList(rules).count() == 1) {
        ShowRulesWhichAffectNodeType_Action.this.operationContext.getComponent(MPSEditorOpener.class).openNode(ListSequence.fromList(rules).getElement(0));
        return;
      }
      // multiple rules
      MyMenu m = new MyMenu(rules, ShowRulesWhichAffectNodeType_Action.this.operationContext);
      int x = 0;
      int y = 0;
      if (ShowRulesWhichAffectNodeType_Action.this.cell != null) {
        x = ShowRulesWhichAffectNodeType_Action.this.cell.getX();
        y = ShowRulesWhichAffectNodeType_Action.this.cell.getY();
      }
      m.show(ShowRulesWhichAffectNodeType_Action.this.frame, x, y);
    } catch (Throwable t) {
      LOG.error("User's action execute method failed. Action:" + "ShowRulesWhichAffectNodeType", t);
    }
  }
}
