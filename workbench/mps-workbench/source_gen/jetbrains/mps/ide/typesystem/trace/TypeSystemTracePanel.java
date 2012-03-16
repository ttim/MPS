package jetbrains.mps.ide.typesystem.trace;

/*Generated by MPS */

import javax.swing.JPanel;
import jetbrains.mps.nodeEditor.EditorComponent;
import jetbrains.mps.ide.tools.BaseTool;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.SwingUtilities;
import javax.swing.JComponent;
import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.ActionPlaces;
import java.awt.Color;
import jetbrains.mps.newTypesystem.TypeCheckingContextNew;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.SNode;
import javax.swing.JSplitPane;
import com.intellij.ui.components.JBScrollPane;
import jetbrains.mps.newTypesystem.state.State;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.actionSystem.ToggleAction;
import jetbrains.mps.ide.typesystem.trace.icons.Icons;
import com.intellij.openapi.actionSystem.AnActionEvent;
import jetbrains.mps.ide.icons.IdeIcons;
import jetbrains.mps.workbench.action.BaseAction;
import java.util.Map;
import jetbrains.mps.workbench.action.ActionUtils;
import jetbrains.mps.smodel.ModelAccess;

public class TypeSystemTracePanel extends JPanel {
  private TypeSystemTraceTree myTraceTree;
  private TypeSystemStateTree myStateTree;
  private JPanel myButtons;
  private EditorComponent myEditorComponent;
  private BaseTool myTool;

  public TypeSystemTracePanel(BaseTool tool) {
    this.setLayout(new BorderLayout());
    myButtons = new JPanel(new BorderLayout());
    this.setMinimumSize(new Dimension(700, 700));
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        JComponent buttonsPanel = ActionManager.getInstance().createActionToolbar(ActionPlaces.TYPE_HIERARCHY_VIEW_TOOLBAR, createButtonsGroup(), true).getComponent();
        myButtons.add(buttonsPanel, BorderLayout.WEST);
      }
    });
    myTool = tool;
  }

  public Color getBackground() {
    return Color.WHITE;
  }

  public void showTraceForNode(TypeCheckingContextNew t, final IOperationContext operationContext, SNode node, EditorComponent editorComponent, boolean rebuild) {
    if (rebuild) {
      t.checkRootInTraceMode(true);
    }
    myEditorComponent = editorComponent;
    myTraceTree = new TypeSystemTraceTree(operationContext, t, node, this, editorComponent);
    myStateTree = new TypeSystemStateTree(operationContext, myTraceTree.getState(), editorComponent);
    JSplitPane splitPane = new JSplitPane();
    JBScrollPane traceScrollPane = new JBScrollPane(myTraceTree);
    traceScrollPane.setPreferredSize(new Dimension(400, 900));
    JBScrollPane stateScrollPane = new JBScrollPane(myStateTree);
    stateScrollPane.setPreferredSize(new Dimension(400, 900));
    splitPane.setDividerLocation(0.65);
    splitPane.setResizeWeight(0.65);
    splitPane.setLeftComponent(traceScrollPane);
    splitPane.setRightComponent(stateScrollPane);
    this.removeAll();
    this.add(splitPane);
    this.add(myButtons, BorderLayout.NORTH);
    this.setVisible(true);
  }

  public void resetState(State state) {
    myStateTree.resetState(state);
  }

  protected DefaultActionGroup createButtonsGroup() {
    ToggleAction showApplyRuleAction = new ToggleAction("Show Apply Rule", "Show apply rule operations in trace", Icons.RULE) {
      private boolean mySelected = TraceSettings.isShowApplyRuleOperations();

      public boolean isSelected(AnActionEvent e) {
        return mySelected;
      }

      public void setSelected(AnActionEvent e, boolean state) {
        mySelected = state;
        TraceSettings.setShowApplyRuleOperations(state);
        myTraceTree.rebuildNow();
        myTraceTree.expandAll();
      }
    };
    ToggleAction showGenerationModeAction = new ToggleAction("Generation Mode", "Show trace in generation mode", Icons.GENERATOR) {
      private boolean mySelected = TraceSettings.isGenerationMode();

      public boolean isSelected(AnActionEvent e) {
        return mySelected;
      }

      public void setSelected(AnActionEvent e, boolean state) {
        mySelected = state;
        TraceSettings.setGenerationMode(state);
        myTraceTree.rebuildNow();
        myTraceTree.expandAll();
      }
    };
    ToggleAction showTypesExpansion = new ToggleAction("Show types expansion", "Show types expansion", IdeIcons.OPENED_FOLDER) {
      private boolean mySelected = TraceSettings.isShowTypesExpansion();

      public boolean isSelected(AnActionEvent e) {
        return mySelected;
      }

      public void setSelected(AnActionEvent e, boolean state) {
        mySelected = state;
        TraceSettings.setShowTypesExpansion(state);
        myTraceTree.rebuildNow();
        myTraceTree.expandAll();
      }
    };
    ToggleAction showTraceForSelectedNode = new ToggleAction("Trace for Selected Node", "Show trace for selected node", Icons.NODE) {
      private boolean mySelected = TraceSettings.isTraceForSelectedNode();

      public boolean isSelected(AnActionEvent e) {
        return mySelected;
      }

      public void setSelected(AnActionEvent e, boolean state) {
        mySelected = state;
        TraceSettings.setTraceForSelectedNode(state);
        refresh(false);
      }
    };
    ToggleAction showBlockDependencies = new ToggleAction("Show block dependencies", "Show block dependencies in trace", Icons.BLOCK) {
      private boolean mySelected = TraceSettings.isShowBlockDependencies();

      public boolean isSelected(AnActionEvent e) {
        return mySelected;
      }

      public void setSelected(AnActionEvent e, boolean state) {
        mySelected = state;
        TraceSettings.setShowBlockDependencies(state);
        myTraceTree.rebuildNow();
        myTraceTree.expandAll();
      }
    };

    BaseAction refreshAction = new BaseAction("Refresh", "Refresh", Icons.REFRESH) {
      protected void doExecute(AnActionEvent e, Map<String, Object> _params) {
        refresh(true);
      }
    };
    BaseAction nextErrorAction = new BaseAction("Next error", "Navigate to next error in trace", Icons.ERROR) {
      protected void doExecute(AnActionEvent e, Map<String, Object> _params) {
        myTraceTree.goToNextError();
      }
    };
    BaseAction closeAction = new BaseAction("Close", "Close type system trace tool", Icons.CLOSE) {
      protected void doExecute(AnActionEvent e, Map<String, Object> _params) {
        myTool.setAvailable(false);
      }
    };

    return ActionUtils.groupFromActions(closeAction, showApplyRuleAction, showGenerationModeAction, showTraceForSelectedNode, showTypesExpansion, showBlockDependencies, refreshAction, nextErrorAction);
  }

  public void refresh(final boolean checkRoot) {
    if (myEditorComponent == null) {
      return;
    }
    final SNode selectedNode = myEditorComponent.getSelectedNode();
    if (selectedNode == null) {
      return;
    }
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        showTraceForNode((TypeCheckingContextNew) myEditorComponent.getTypeCheckingContext(), myEditorComponent.getOperationContext(), selectedNode, myEditorComponent, checkRoot);
      }
    });
    this.validate();
  }
}
