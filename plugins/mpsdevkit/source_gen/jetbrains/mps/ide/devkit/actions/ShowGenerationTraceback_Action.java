package jetbrains.mps.ide.devkit.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.smodel.SNode;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.ide.devkit.generator.GenerationTracer;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.generator.IGenerationTracer;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.workbench.MPSDataKeys;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.awt.Frame;

public class ShowGenerationTraceback_Action extends GeneratedAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(ShowGenerationTraceback_Action.class);

  public ShowGenerationTraceback_Action() {
    super("Show Generation Traceback", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(false);
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      {
        if (ListSequence.<SNode>fromList(((List<SNode>) MapSequence.<String,Object>fromMap(_params).get("nodes"))).count() != 1) {
          ShowGenerationTraceback_Action.this.disable(event.getPresentation());
        }
        GenerationTracer tracer = (GenerationTracer) ((IOperationContext) MapSequence.<String,Object>fromMap(_params).get("context")).getComponent(IGenerationTracer.class);
        event.getPresentation().setVisible(tracer.hasTracingData());
        event.getPresentation().setEnabled(tracer.hasTracebackData(SNodeOperations.getModel(((SNode) MapSequence.<String,Object>fromMap(_params).get("node"))).getSModelReference()));
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "ShowGenerationTraceback", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    {
      SNode node = event.getData(MPSDataKeys.NODE);
      if (node != null) {
      }
      MapSequence.<String,Object>fromMap(_params).put("node", node);
    }
    if (MapSequence.<String,Object>fromMap(_params).get("node") == null) {
      return false;
    }
    {
      List<SNode> nodes = event.getData(MPSDataKeys.NODES);
      boolean error = false;
      if (nodes != null) {
      }
      if (error || nodes == null) {
        MapSequence.<String,Object>fromMap(_params).put("nodes", null);
      } else {
        MapSequence.<String,Object>fromMap(_params).put("nodes", ListSequence.<SNode>fromListWithValues(new ArrayList<SNode>(), nodes));
      }
    }
    if (MapSequence.<String,Object>fromMap(_params).get("nodes") == null) {
      return false;
    }
    MapSequence.<String,Object>fromMap(_params).put("context", event.getData(MPSDataKeys.OPERATION_CONTEXT));
    if (MapSequence.<String,Object>fromMap(_params).get("context") == null) {
      return false;
    }
    MapSequence.<String,Object>fromMap(_params).put("frame", event.getData(MPSDataKeys.FRAME));
    if (MapSequence.<String,Object>fromMap(_params).get("frame") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      GenerationTracer tracer = (GenerationTracer) ((IOperationContext) MapSequence.<String,Object>fromMap(_params).get("context")).getComponent(IGenerationTracer.class);
      if (!(tracer.showTracebackData(((SNode) MapSequence.<String,Object>fromMap(_params).get("node"))))) {
        JOptionPane.showMessageDialog(((Frame) MapSequence.<String,Object>fromMap(_params).get("frame")), "No tracing data available");
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "ShowGenerationTraceback", t);
      }
    }
  }
}
