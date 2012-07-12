package jetbrains.mps.debugger.api.ui.breakpoints;

/*Generated by MPS */

import jetbrains.mps.debugger.core.breakpoints.BreakpointsUiComponentEx;
import jetbrains.mps.debug.api.breakpoints.IBreakpoint;
import jetbrains.mps.debug.api.breakpoints.ILocationBreakpoint;
import com.intellij.openapi.components.ProjectComponent;
import jetbrains.mps.logging.Logger;
import com.intellij.openapi.project.Project;
import jetbrains.mps.debug.api.BreakpointManagerComponent;
import jetbrains.mps.debug.api.breakpoints.BreakpointProvidersManager;
import jetbrains.mps.debug.api.DebugInfoManager;
import jetbrains.mps.debug.api.SessionChangeListener;
import jetbrains.mps.debug.api.DebugSessionManagerComponent;
import com.intellij.openapi.fileEditor.FileEditorManager;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.application.ApplicationManager;
import jetbrains.mps.project.ProjectOperationContext;
import jetbrains.mps.ide.project.ProjectHelper;
import java.util.Set;
import jetbrains.mps.nodeEditor.EditorComponent;
import jetbrains.mps.smodel.SNode;
import java.util.Collections;
import java.util.HashSet;
import jetbrains.mps.smodel.SNodePointer;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.util.Computable;
import jetbrains.mps.ide.editor.util.EditorComponentUtil;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.debug.api.breakpoints.IBreakpointKind;
import jetbrains.mps.debug.api.breakpoints.IBreakpointsProvider;
import com.intellij.openapi.ui.Messages;
import java.util.List;
import jetbrains.mps.debugger.core.breakpoints.BreakpointIconRenderrerEx;
import jetbrains.mps.debugger.core.breakpoints.BreakpointPainterEx;
import org.jdom.Element;
import org.jdom.Attribute;
import jetbrains.mps.debug.api.breakpoints.IBreakpointListener;
import jetbrains.mps.debug.api.AbstractDebugSession;
import jetbrains.mps.debug.api.SessionChangeAdapter;

public class BreakpointsUiComponent extends BreakpointsUiComponentEx<IBreakpoint, ILocationBreakpoint> implements ProjectComponent {
  private static final Logger LOG = Logger.getLogger(BreakpointsUiComponent.class);
  private static final String BREAKPOINT_ELEMENT = "breakpoint";
  private static final String KIND_TAG = "kind";

  private final Project myProject;
  private final BreakpointManagerComponent myBreakpointsManagerComponent;
  private final BreakpointProvidersManager myProvidersManager;
  private final DebugInfoManager myDebugInfoManager;
  private final BreakpointsUiComponent.MyBreakpointManagerListener myBreakpointManagerListener = new BreakpointsUiComponent.MyBreakpointManagerListener();
  private final BreakpointsUiComponent.MyBreakpointListener myBreakpointListener = new BreakpointsUiComponent.MyBreakpointListener();
  private final SessionChangeListener myChangeListener = new BreakpointsUiComponent.MySessionChangeAdapter();
  private final DebugSessionManagerComponent.DebugSessionListener myDebugSessionListener = new BreakpointsUiComponent.MyDebugSessionAdapter();

  public BreakpointsUiComponent(Project project, BreakpointManagerComponent breakpointsManagerComponent, DebugInfoManager debugInfoManager, BreakpointProvidersManager providersManager, FileEditorManager fileEditorManager) {
    super(project, fileEditorManager);
    myProject = project;
    myBreakpointsManagerComponent = breakpointsManagerComponent;
    myDebugInfoManager = debugInfoManager;
    myProvidersManager = providersManager;
  }

  @NotNull
  @Override
  public String getComponentName() {
    return "Breakpoints Ui Component";
  }

  @Override
  public void initComponent() {
    super.init();
    ApplicationManager.getApplication().executeOnPooledThread(new Runnable() {
      @Override
      public void run() {
        myBreakpointsManagerComponent.setBreakpointsIO(new BreakpointsUiComponent.MyBreakpointsIO());
      }
    });
    DebugSessionManagerComponent component = myProject.getComponent(DebugSessionManagerComponent.class);
    component.addDebugSessionListener(myDebugSessionListener);
    myBreakpointsManagerComponent.addChangeListener(myBreakpointManagerListener);
  }

  @Override
  public void disposeComponent() {
    myBreakpointsManagerComponent.removeChangeListener(myBreakpointManagerListener);
    DebugSessionManagerComponent component = myProject.getComponent(DebugSessionManagerComponent.class);
    component.removeDebugSessionListener(myDebugSessionListener);
    super.dispose();
  }

  public void editBreakpointProperties(final ILocationBreakpoint breakpoint) {
    final BreakpointsBrowserDialog breakpointsBrowserDialog = new BreakpointsBrowserDialog(new ProjectOperationContext(ProjectHelper.toMPSProject(myProject)));
    breakpointsBrowserDialog.showDialog();
    ApplicationManager.getApplication().invokeLater(new Runnable() {
      @Override
      public void run() {
        breakpointsBrowserDialog.selectBreakpoint(breakpoint);
      }
    });
  }

  @NotNull
  protected Set<ILocationBreakpoint> getBreakpointsForComponent(@NotNull final EditorComponent editorComponent) {
    final SNode editedNode = editorComponent.getEditedNode();
    if (editedNode == null) {
      return Collections.emptySet();
    }
    if (editedNode.isDisposed()) {
      Set<IBreakpoint> allBreakpoints = myBreakpointsManagerComponent.getAllIBreakpoints();
      Set<ILocationBreakpoint> locationBreakpoints = new HashSet<ILocationBreakpoint>();
      for (IBreakpoint breakpoint : allBreakpoints) {
        if (breakpoint instanceof ILocationBreakpoint) {
          locationBreakpoints.add((ILocationBreakpoint) breakpoint);
        }
      }
      return locationBreakpoints;
    }
    SNodePointer rootPointer = ModelAccess.instance().runReadAction(new Computable<SNodePointer>() {
      @Override
      public SNodePointer compute() {
        final SNode rootNode = editedNode.getContainingRoot();
        if (rootNode == null) {
          return null;
        }
        return new SNodePointer(rootNode);
      }
    });
    if (rootPointer == null) {
      return Collections.emptySet();
    }
    final Set<ILocationBreakpoint> breakpointsForRoot = myBreakpointsManagerComponent.getBreakpoints(rootPointer);
    if (breakpointsForRoot == null) {
      return Collections.emptySet();
    }
    final Set<ILocationBreakpoint> result = new HashSet<ILocationBreakpoint>();
    ModelAccess.instance().runReadAction(new Runnable() {
      @Override
      public void run() {
        for (ILocationBreakpoint locationBreakpoint : breakpointsForRoot) {
          SNode node = locationBreakpoint.getLocation().getSNode();
          if (node != null && EditorComponentUtil.isNodeShownInTheComponent(editorComponent, node)) {
            result.add(locationBreakpoint);
          }
        }
      }
    });
    return result;
  }

  protected EditorCell findDebuggableOrTraceableCell(EditorCell foundCell) {
    EditorCell cell = findDebuggableCell(foundCell);
    if (cell == null) {
      cell = findTraceableCell(foundCell);
    }
    if (cell == null) {
      return null;
    }
    return cell;
  }

  private EditorCell findDebuggableCell(EditorCell foundCell) {
    EditorCell cell = foundCell;
    while (cell != null) {
      SNode node = cell.getSNode();
      if (myDebugInfoManager.isDebuggableNode(node)) {
        return cell;
      }
      cell = cell.getParent();
    }
    return null;
  }

  protected void toggleBreakpoint(@NotNull SNode node) {
    SNode root = node.getContainingRoot();
    if (root == null) {
      return;
    }
    IBreakpoint breakpoint = null;
    Set<ILocationBreakpoint> mpsBreakpointSet = myBreakpointsManagerComponent.getBreakpoints(new SNodePointer(root));
    if (mpsBreakpointSet != null) {
      for (ILocationBreakpoint mpsBreakpoint : mpsBreakpointSet) {
        if (mpsBreakpoint.getLocation().getNodePointer().equals(new SNodePointer(node))) {
          breakpoint = mpsBreakpoint;
          break;
        }
      }
    }
    if (breakpoint != null) {
      myBreakpointsManagerComponent.removeBreakpoint(breakpoint);
    } else {
      ILocationBreakpoint newBreakpoint = myDebugInfoManager.createBreakpoint(node, myProject);
      if (newBreakpoint != null) {
        myBreakpointsManagerComponent.addBreakpoint(newBreakpoint);
      } else
      if (myDebugInfoManager.isDebuggableNode(node)) {
        LOG.error("Node is debuggable but created breakpoint is null.", node);
      } else {
        LOG.error("Trying to create breakpoint on non-debuggable node.", node);
      }
    }
  }

  public void createFromUi(IBreakpointKind kind) {
    IBreakpointsProvider provider = myProvidersManager.getProvider(kind);
    if (provider == null) {
      Messages.showErrorDialog(myProject, "Can not create " + kind.getPresentation() + ". Provider was not found.", "Error Creating" + kind.getPresentation());
    } else {
      IBreakpoint breakpoint = provider.createFromUi(kind, myProject);
      if (breakpoint != null) {
        myBreakpointsManagerComponent.addBreakpoint(breakpoint);
      }
    }
  }

  @NotNull
  private List<EditorComponent> findComponentForLocationBreakpoint(@NotNull ILocationBreakpoint breakpoint) {
    SNode node = breakpoint.getLocation().getSNode();
    if (node != null) {
      return EditorComponentUtil.findComponentForNode(node, myFileEditorManager);
    }
    return Collections.emptyList();
  }

  protected BreakpointIconRenderrerEx<ILocationBreakpoint> createRenderrer(ILocationBreakpoint breakpoint, EditorComponent component) {
    return new BreakpointIconRenderer(breakpoint, component);
  }

  protected BreakpointPainterEx<ILocationBreakpoint> createPainter(ILocationBreakpoint breakpoint) {
    return new BreakpointPainter(breakpoint);
  }

  @Override
  public void projectOpened() {
  }

  @Override
  public void projectClosed() {
  }

  public static BreakpointsUiComponent getInstance(Project project) {
    return project.getComponent(BreakpointsUiComponent.class);
  }

  private class MyBreakpointsIO implements BreakpointManagerComponent.IBreakpointsIO {
    private MyBreakpointsIO() {
    }

    @Override
    public IBreakpoint readBreakpoint(@NotNull Element element) {
      String kindName = element.getAttributeValue(BreakpointsUiComponent.KIND_TAG);
      IBreakpointKind kind = myProvidersManager.getKind(kindName);
      if (kind == null) {
        return null;
      }
      IBreakpointsProvider provider = myProvidersManager.getProvider(kind);
      if (provider == null) {
        return null;
      }
      IBreakpoint breakpoint = provider.loadFromState((Element) element.getChildren().get(0), kind, myProject);
      if (breakpoint != null) {
        breakpoint.addBreakpointListener(myBreakpointListener);
      }
      return breakpoint;
    }

    @Override
    public Element writeBreakpoint(@NotNull IBreakpoint breakpoint) {
      IBreakpointKind kind = breakpoint.getKind();
      IBreakpointsProvider provider = myProvidersManager.getProvider(kind);
      if (provider == null) {
        return null;
      }
      Element element = provider.saveToState(breakpoint);
      if (element != null) {
        Element breakpointElement = new Element(BreakpointsUiComponent.BREAKPOINT_ELEMENT);
        breakpointElement.setAttribute(new Attribute(BreakpointsUiComponent.KIND_TAG, kind.getName()));
        breakpointElement.addContent(element);
        return breakpointElement;
      }
      return null;
    }
  }

  private class MyBreakpointManagerListener implements BreakpointManagerComponent.IBreakpointManagerListener {
    private MyBreakpointManagerListener() {
    }

    @Override
    public void breakpointAdded(@NotNull final IBreakpoint breakpoint) {
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          if (breakpoint instanceof ILocationBreakpoint) {
            SNode node = ((ILocationBreakpoint) breakpoint).getLocation().getSNode();
            if (node != null) {
              addLocationBreakpoint((ILocationBreakpoint) breakpoint, node);
            }
          }
          breakpoint.addBreakpointListener(myBreakpointListener);
        }
      });
    }

    @Override
    public void breakpointRemoved(@NotNull final IBreakpoint breakpoint) {
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          if (breakpoint instanceof ILocationBreakpoint) {
            SNode node = ((ILocationBreakpoint) breakpoint).getLocation().getSNode();
            if (node != null) {
              removeLocationBreakpoint((ILocationBreakpoint) breakpoint, node);
            }
          }
          breakpoint.removeBreakpointListener(myBreakpointListener);
        }
      });

    }
  }

  private class MyBreakpointListener implements IBreakpointListener {
    private MyBreakpointListener() {
    }

    @Override
    public void breakpointEnabledStateToggled(final IBreakpoint breakpoint, boolean enabled) {
      ModelAccess.instance().runReadAction(new Runnable() {
        @Override
        public void run() {
          if (breakpoint instanceof ILocationBreakpoint) {
            List<EditorComponent> editorComponents = findComponentForLocationBreakpoint((ILocationBreakpoint) breakpoint);
            for (EditorComponent editorComponent : editorComponents) {
              editorComponent.repaint();
            }
          }
        }
      });
    }
  }

  private class MyDebugSessionAdapter extends DebugSessionManagerComponent.DebugSessionAdapter {
    private MyDebugSessionAdapter() {
    }

    @Override
    public void registered(AbstractDebugSession session) {
      session.addChangeListener(myChangeListener);
    }

    @Override
    public void detached(AbstractDebugSession session) {
      session.removeChangeListener(myChangeListener);
    }
  }

  private class MySessionChangeAdapter extends SessionChangeAdapter {
    private MySessionChangeAdapter() {
    }

    @Override
    public void muted(AbstractDebugSession session) {
      ApplicationManager.getApplication().invokeLater((new Runnable() {
        @Override
        public void run() {
          for (EditorComponent editorComponent : EditorComponentUtil.getAllEditorComponents(myFileEditorManager, true)) {
            editorComponent.repaint();
          }
        }
      }));
    }
  }
}
