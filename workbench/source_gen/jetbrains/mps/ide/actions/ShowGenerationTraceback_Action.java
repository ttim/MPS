package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.IOperationContext;
import java.util.List;
import java.awt.Frame;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.generator.plugin.debug.GenerationTracer;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.workbench.MPSDataKeys;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ShowGenerationTraceback_Action extends GeneratedAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(ShowGenerationTraceback_Action.class);

  private SNode node;
  public IOperationContext context;
  private List<SNode> nodes;
  public Frame frame;

  public ShowGenerationTraceback_Action() {
    super("Show Generation Traceback", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(false);
  }

  @NotNull()
  public String getKeyStroke() {
    return "";
  }

  public void doUpdate(@NotNull() AnActionEvent event) {
    try {
      {
        if (ListSequence.fromList(ShowGenerationTraceback_Action.this.nodes).count() != 1) {
          ShowGenerationTraceback_Action.this.disable(event.getPresentation());
        }
        GenerationTracer tracer = ShowGenerationTraceback_Action.this.context.getComponent(GenerationTracer.class);
        event.getPresentation().setVisible(tracer.hasTracingData());
        event.getPresentation().setEnabled(tracer.hasTracebackData(SNodeOperations.getModel(ShowGenerationTraceback_Action.this.node).getSModelReference()));
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "ShowGenerationTraceback", t);
      }
      this.disable(event.getPresentation());
    }
  }

  @Override()
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
    {
      List<SNode> nodes = event.getData(MPSDataKeys.NODES);
      boolean error = false;
      if (nodes != null) {
      }
      if (error || nodes == null) {
        this.nodes = null;
      } else
      {
        this.nodes = ListSequence.fromListWithValues(new ArrayList<SNode>(), nodes);
      }
    }
    if (this.nodes == null) {
      return false;
    }
    this.context = event.getData(MPSDataKeys.OPERATION_CONTEXT);
    if (this.context == null) {
      return false;
    }
    this.frame = event.getData(MPSDataKeys.FRAME);
    if (this.frame == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull() final AnActionEvent event) {
    try {
      GenerationTracer tracer = ShowGenerationTraceback_Action.this.context.getComponent(GenerationTracer.class);
      if (!(tracer.showTracebackData(ShowGenerationTraceback_Action.this.node))) {
        JOptionPane.showMessageDialog(ShowGenerationTraceback_Action.this.frame, "No tracing data available");
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "ShowGenerationTraceback", t);
      }
    }
  }

}
