package jetbrains.mps.debugger.java.runtime;

/*Generated by MPS */

import jetbrains.mps.debug.api.AbstractDebugSession;
import jetbrains.mps.debug.api.evaluation.IEvaluationProvider;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.debug.api.DebugSessionManagerComponent;
import jetbrains.mps.debugger.java.runtime.execution.DebuggerCommand;
import java.util.Set;
import jetbrains.mps.debug.api.breakpoints.IBreakpoint;
import jetbrains.mps.debugger.java.runtime.breakpoints.JavaBreakpoint;

public class DebugSession extends AbstractDebugSession<JavaUiStateImpl> {
  private final DebugVMEventsProcessor myEventsProcessor;
  private volatile boolean myIsMute = false;
  private IEvaluationProvider myEvaluationProvider;

  public DebugSession(DebugVMEventsProcessor eventsProcessor, final Project p) {
    super(p);
    myEventsProcessor = eventsProcessor;
    myEventsProcessor.setDebuggableFramesSelector(getDebuggableFramesSelector());
    eventsProcessor.getMulticaster().addListener(new DebugSession.MyDebugProcessAdapter());
  }

  protected JavaUiStateImpl createUiState() {
    return new RunningJavaUiState(this);
  }

  public void resume() {
    SuspendContext context = getUiState().getContext();
    if (context == null) {
      return;
    }
    //  context is null => already resumed 
    myEventsProcessor.resume(context);
  }

  public void pause() {
    myEventsProcessor.pause();
  }

  public void stop(boolean terminateTargetVM) {
    myEventsProcessor.stop(terminateTargetVM);
  }

  public void stepOver() {
    step(DebugVMEventsProcessor.StepType.Over);
  }

  public void stepInto() {
    step(DebugVMEventsProcessor.StepType.Into);
  }

  public void stepOut() {
    step(DebugVMEventsProcessor.StepType.Out);
  }

  public boolean canShowEvaluationDialog() {
    return true;
  }

  private void step(DebugVMEventsProcessor.StepType type) {
    JavaUiStateImpl state = getUiState();
    SuspendContext context = state.getContext();
    assert context != null : "Context is null while debug session state is " + myExecutionState;
    assert state.isPausedOnBreakpoint() : "State is not paused on breakpoint.";
    myEventsProcessor.step(type, context);
  }

  public DebugVMEventsProcessor getEventsProcessor() {
    return myEventsProcessor;
  }

  private void pause(@NotNull SuspendContext suspendContext) {
    JavaUiStateImpl state = getUiState();
    setState(state, state.paused(suspendContext), false);
  }

  public JavaUiStateImpl refresh() {
    JavaUiStateImpl state = getUiState();
    JavaUiStateImpl newState = state.paused(state.getContext());
    setState(state, newState);
    return newState;
  }

  private void resume(SuspendContext suspendContext) {
    JavaUiStateImpl state = getUiState();
    setState(state, state.resumed(suspendContext), false);
  }

  @Override
  public void sessionRegistered(DebugSessionManagerComponent manager) {
    VMEventsProcessorManagerComponent vmManager = manager.getProject().getComponent(VMEventsProcessorManagerComponent.class);
    vmManager.addDebugSession(this);
  }

  @Override
  public void sessionUnregistered(DebugSessionManagerComponent manager) {
  }

  @Override
  public boolean isMute() {
    return myIsMute;
  }

  @Override
  public void muteBreakpoints(final boolean mute) {
    if (myEventsProcessor.isAttached()) {
      myEventsProcessor.getManagerThread().schedule(new DebuggerCommand() {
        @Override
        protected void action() throws Exception {
          if (myIsMute != mute) {
            Set<IBreakpoint> breakpoints = myEventsProcessor.getBreakpointManager().getAllIBreakpoints();
            RequestManager requestManager = myEventsProcessor.getRequestManager();
            for (IBreakpoint bp : breakpoints) {
              if (bp instanceof JavaBreakpoint) {
                JavaBreakpoint breakpoint = (JavaBreakpoint) bp;
                if (mute) {
                  requestManager.deleteRequests(breakpoint);
                  //  todo enabling and disabling breakpoints should be symmetrical 
                } else {
                  breakpoint.createOrWaitPrepare(getEventsProcessor());
                }
              }
            }
            myIsMute = mute;
            fireSessionMuted(DebugSession.this);
          }
        }
      });
    } else {
      myIsMute = mute;
      fireSessionMuted(DebugSession.this);
    }
  }

  @Override
  public IEvaluationProvider getEvaluationProvider() {
    return myEvaluationProvider;
  }

  public void setEvaluationProvider(IEvaluationProvider evaluationProvider) {
    myEvaluationProvider = evaluationProvider;
  }

  private class MyDebugProcessAdapter extends DebugProcessAdapter {
    private MyDebugProcessAdapter() {
    }

    @Override
    public void paused(@NotNull SuspendContext suspendContext) {
      myExecutionState = AbstractDebugSession.ExecutionState.Paused;
      pause(suspendContext);
      fireSessionPaused(DebugSession.this);
    }

    @Override
    public void resumed(@NotNull SuspendContext suspendContext) {
      myExecutionState = AbstractDebugSession.ExecutionState.Running;
      resume(suspendContext);
      fireSessionResumed(DebugSession.this);
    }

    @Override
    public void processAttached(@NotNull DebugVMEventsProcessor process) {
      myExecutionState = AbstractDebugSession.ExecutionState.Running;
    }

    @Override
    public void processDetached(@NotNull DebugVMEventsProcessor process, boolean closedByUser) {
      myExecutionState = AbstractDebugSession.ExecutionState.Stopped;
      setState(getUiState(), new RunningJavaUiState(DebugSession.this), false);
      fireSessionResumed(DebugSession.this);
      //  TODO hack 
    }
  }
}
