package jetbrains.mps.debug.api;

import com.intellij.execution.process.ProcessHandler;
import com.intellij.openapi.project.Project;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.util.annotation.UseCarefully;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by IntelliJ IDEA.
 * User: Cyril.Konopko
 * Date: 09.04.2010
 * Time: 15:41:46
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractDebugSession<State extends AbstractUiState> {

  protected ProcessHandler myProcessHandler;
  private final List<SessionChangeListener> myListeners = new ArrayList<SessionChangeListener>();
  protected ExecutionState myExecutionState = ExecutionState.WaitingAttach;
  protected final AtomicReference<State> myUiState = new AtomicReference<State>(createUiState());
  protected IDebuggableFramesSelector myDebuggableFramesSelector = new DebuggableFramesSelector();
  protected Project myProject;

  public AbstractDebugSession(Project p) {
    myProject = p;
  }

  protected abstract State createUiState();

  public abstract void resume();

  public abstract void pause();

  public abstract void stop(boolean terminateTargetProcess);

  public abstract void stepOver();

  public abstract void stepInto();

  public abstract void stepOut();

  protected void setState(State oldState, @NotNull State newState) {
    setState(oldState, newState, true);
  }

  protected void setState(State oldState, @NotNull State newState, boolean fireEvents) {
    while (!myUiState.compareAndSet(oldState, newState)) {
      // TODO we do not care here if user selected something, we just replace old state. But we might do something more clever, like remember what user selected.
      oldState = getUiState();
    }
    if (fireEvents) {
      fireStateChanged();
    }
  }

  public boolean isPaused() {
    return myExecutionState.equals(ExecutionState.Paused);
  }

  public boolean isRunning() {
    return myExecutionState.equals(ExecutionState.Running);
  }

  public boolean isStopped() {
    return myExecutionState.equals(ExecutionState.Stopped);
  }

  public boolean isStepEnabled() {
    return isPaused() && getUiState().isPausedOnBreakpoint();
  }

  public void setProcessHandler(ProcessHandler processHandler) {
    myProcessHandler = processHandler;
  }

  public ProcessHandler getProcessHandler() {
    return myProcessHandler;
  }

  public IDebuggableFramesSelector getDebuggableFramesSelector() {
    return myDebuggableFramesSelector;
  }

  protected void fireStateChanged() {
    for (SessionChangeListener listener : myListeners) {
      listener.stateChanged(this);
    }
  }

  protected void fireSessionPaused(AbstractDebugSession debugSession) {
    for (SessionChangeListener listener : myListeners) {
      listener.paused(debugSession);
    }
  }

  protected void fireSessionResumed(AbstractDebugSession debugSession) {
    for (SessionChangeListener listener : myListeners) {
      listener.resumed(debugSession);
    }
  }

  public void addChangeListener(@NotNull SessionChangeListener listener) {
    myListeners.add(listener);
  }

  public void removeChangeListener(@NotNull SessionChangeListener listener) {
    myListeners.remove(listener);
  }

  //use from AbstractUiState only

  @UseCarefully
  public void trySetState(State oldState, State newState) {
    if (myUiState.compareAndSet(oldState, newState)) {
      fireStateChanged();
    }
  }

  public State getUiState() {
    return myUiState.get();
  }

  public boolean canShowEvaluationDialog() {
    return false;
  }

  public ExecutionState getExecutionState() {
    return myExecutionState;
  }

  public abstract void showEvaluationDialog(IOperationContext operationContext);

  public void sessionRegistered(DebugSessionManagerComponent manager) {

  }

  public void sessionUnregistered(DebugSessionManagerComponent manager) {

  }

  public Project getProject() {
    return myProject;
  }

  public enum ExecutionState {
    Stopped,
    Running,
    Paused,
    WaitingAttach;
  }

}
