package jetbrains.mps.debugger.api.ui.breakpoints;

/*Generated by MPS */

import jetbrains.mps.debugger.core.CurrentLinePositionComponentEx;
import jetbrains.mps.debug.api.AbstractDebugSession;
import com.intellij.openapi.components.ProjectComponent;
import jetbrains.mps.debug.api.SessionChangeListener;
import jetbrains.mps.debug.api.DebugSessionManagerComponent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.fileEditor.FileEditorManager;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.debug.api.programState.IStackFrame;
import jetbrains.mps.debug.api.programState.ILocation;
import jetbrains.mps.debug.api.SessionChangeAdapter;

public class CurrentLinePositionComponent extends CurrentLinePositionComponentEx<AbstractDebugSession> implements ProjectComponent {
  private final SessionChangeListener myChangeListener = new CurrentLinePositionComponent.MySessionChangeListener();
  private final DebugSessionManagerComponent.DebugSessionListener myCurrentDebugSessionListener = new CurrentLinePositionComponent.MyCurrentDebugSessionListener();

  public CurrentLinePositionComponent(Project project, FileEditorManager fileEditorManager) {
    super(project, fileEditorManager);
  }

  @Override
  public void projectOpened() {
  }

  @Override
  public void projectClosed() {
  }

  @NotNull
  @Override
  public String getComponentName() {
    return "Current Line Position Project Component";
  }

  @Override
  public void initComponent() {
    super.init();
    DebugSessionManagerComponent component = myProject.getComponent(DebugSessionManagerComponent.class);
    component.addDebugSessionListener(myCurrentDebugSessionListener);
  }

  @Override
  public void disposeComponent() {
    DebugSessionManagerComponent component = myProject.getComponent(DebugSessionManagerComponent.class);
    component.removeDebugSessionListener(myCurrentDebugSessionListener);
    super.dispose();
  }

  protected AbstractDebugSession getCurrentSession() {
    return myProject.getComponent(DebugSessionManagerComponent.class).getDebugSessionByCurrentTab();
  }

  public SNode getNode(AbstractDebugSession session) {
    IStackFrame stackFrame = session.getUiState().getStackFrame();
    if (stackFrame != null) {
      ILocation location = stackFrame.getLocation();
      return session.getDebuggableFramesSelector().getPositionProvider().getNode(location);
    }
    return null;
  }

  private class MyCurrentDebugSessionListener implements DebugSessionManagerComponent.DebugSessionListener {
    private MyCurrentDebugSessionListener() {
    }

    @Override
    public void registered(AbstractDebugSession session) {
      session.addChangeListener(myChangeListener);
    }

    @Override
    public void currentSessionChanged(AbstractDebugSession newDebugSession) {
      CurrentLinePositionComponent.this.currentSessionChanged(newDebugSession);
    }

    @Override
    public void detached(AbstractDebugSession newDebugSession) {
      detachPainter(newDebugSession);
      newDebugSession.removeChangeListener(myChangeListener);
    }
  }

  private class MySessionChangeListener extends SessionChangeAdapter {
    private MySessionChangeListener() {
    }

    @Override
    public void stateChanged(AbstractDebugSession session) {
      reAttachPainter(session);
    }

    @Override
    public void paused(AbstractDebugSession debugSession) {
      reAttachPainter(debugSession);
    }

    @Override
    public void resumed(AbstractDebugSession debugSession) {
      detachPainter(debugSession);
    }
  }
}
