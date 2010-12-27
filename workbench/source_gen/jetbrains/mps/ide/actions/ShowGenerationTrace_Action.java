package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.lang.generator.plugin.debug.GenerationTracer;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.List;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.workbench.MPSDataKeys;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.awt.Frame;
import com.intellij.openapi.project.Project;

public class ShowGenerationTrace_Action extends GeneratedAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(ShowGenerationTrace_Action.class);

  public ShowGenerationTrace_Action() {
    super("Show Generation Trace", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(false);
  }

  @NotNull
  public String getKeyStroke() {
    return "";
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      {
        GenerationTracer tracer = ShowGenerationTrace_Action.this.getGenTracer(_params);
        event.getPresentation().setVisible(tracer.hasTracingData());
        if (ListSequence.fromList(((List<SNode>) MapSequence.fromMap(_params).get("nodes"))).isEmpty()) {
          event.getPresentation().setEnabled(false);
        } else {
          boolean hasTraceInputData = tracer.hasTraceInputData(SNodeOperations.getModel(ListSequence.fromList(((List<SNode>) MapSequence.fromMap(_params).get("nodes"))).first()).getSModelReference());
          event.getPresentation().setEnabled(hasTraceInputData);
        }
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "ShowGenerationTrace", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    {
      List<SNode> nodes = event.getData(MPSDataKeys.NODES);
      boolean error = false;
      if (nodes != null) {
      }
      if (error || nodes == null) {
        MapSequence.fromMap(_params).put("nodes", null);
      } else {
        MapSequence.fromMap(_params).put("nodes", ListSequence.fromListWithValues(new ArrayList<SNode>(), nodes));
      }
    }
    if (MapSequence.fromMap(_params).get("nodes") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("project", event.getData(MPSDataKeys.PROJECT));
    if (MapSequence.fromMap(_params).get("project") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("frame", event.getData(MPSDataKeys.FRAME));
    if (MapSequence.fromMap(_params).get("frame") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      GenerationTracer tracer = ShowGenerationTrace_Action.this.getGenTracer(_params);
      if (!(tracer.showTraceInputData(ListSequence.fromList(((List<SNode>) MapSequence.fromMap(_params).get("nodes"))).first()))) {
        JOptionPane.showMessageDialog(((Frame) MapSequence.fromMap(_params).get("frame")), "No tracing data available");
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "ShowGenerationTrace", t);
      }
    }
  }

  private GenerationTracer getGenTracer(final Map<String, Object> _params) {
    return ((Project) MapSequence.fromMap(_params).get("project")).getComponent(GenerationTracer.class);
  }
}
