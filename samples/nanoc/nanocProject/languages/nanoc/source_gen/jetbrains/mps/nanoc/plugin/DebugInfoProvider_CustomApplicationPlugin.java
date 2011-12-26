package jetbrains.mps.nanoc.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.custom.BaseCustomApplicationPlugin;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.debug.api.DebugInfoManager;
import jetbrains.mps.util.Mapper2;
import jetbrains.mps.smodel.SNode;
import com.intellij.openapi.project.Project;
import jetbrains.mps.debug.api.breakpoints.ILocationBreakpoint;
import jetbrains.mps.debug.api.Debuggers;
import jetbrains.mps.debug.api.DebuggerNotPresentException;

public class DebugInfoProvider_CustomApplicationPlugin extends BaseCustomApplicationPlugin {
  private static Logger LOG = Logger.getLogger(DebugInfoProvider_CustomApplicationPlugin.class);

  public DebugInfoProvider_CustomApplicationPlugin() {
  }

  public void doInit() {
    DebugInfoManager manager = DebugInfoManager.getInstance();
    if (manager == null) {
      return;
    }
    {
      Mapper2<SNode, Project, ILocationBreakpoint> creator = new Mapper2<SNode, Project, ILocationBreakpoint>() {
        public ILocationBreakpoint value(SNode debuggableNode, Project project) {
          try {
            return Debuggers.getInstance().getDebuggerByNameSafe("Cpp").createBreakpoint(debuggableNode, "CPP_LINE_BREAKPOINT", project);
          } catch (DebuggerNotPresentException e) {
            LOG.warning("Exception while creating breakpoint for node" + debuggableNode, e);
            return null;
          }

        }
      };
      manager.addConceptBreakpointCreator("jetbrains.mps.nanoc.structure.CStatement", creator);
    }
  }

  public void doDispose() {
    DebugInfoManager manager = DebugInfoManager.getInstance();
    if (manager == null) {
      return;
    }
    manager.removeConceptBreakpointCreator("jetbrains.mps.nanoc.structure.CStatement");
  }
}
