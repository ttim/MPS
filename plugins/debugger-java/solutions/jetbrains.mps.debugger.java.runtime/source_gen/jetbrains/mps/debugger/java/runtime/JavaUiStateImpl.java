package jetbrains.mps.debugger.java.runtime;

/*Generated by MPS */

import jetbrains.mps.debug.runtime.JavaUiState;
import jetbrains.mps.logging.Logger;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.debug.api.programState.IThread;
import jetbrains.mps.debug.api.AbstractUiState;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.debug.runtime.java.programState.proxies.JavaThread;
import com.sun.jdi.ThreadReference;
import java.util.List;
import com.sun.jdi.ObjectReference;
import jetbrains.mps.debug.runtime.java.programState.proxies.JavaStackFrame;
import jetbrains.mps.util.CollectionUtil;
import java.util.Collections;
import jetbrains.mps.debug.api.AbstractDebugSession;
import java.util.ArrayList;
import jetbrains.mps.debug.api.programState.IStackFrame;
import com.sun.jdi.Value;
import com.sun.jdi.LocalVariable;
import jetbrains.mps.debug.api.programState.IWatchable;
import com.sun.jdi.event.EventSet;
import jetbrains.mps.debugger.java.runtime.watchables.EventWatchablesCreator;
import com.sun.jdi.event.Event;

public class JavaUiStateImpl extends JavaUiState {
  private static Logger LOG = Logger.getLogger(JavaUiStateImpl.class);

  @Nullable
  private final SuspendContext myContext;
  @Nullable
  protected final IThread myThread;
  protected final int myStackFrameIndex;
  private final DebugSession myDebugSession;

  /*package*/ JavaUiStateImpl(@Nullable SuspendContext context, DebugSession debugSession) {
    super(debugSession);
    myDebugSession = debugSession;
    myContext = context;
    if (context == null) {
      myThread = null;
      myStackFrameIndex = AbstractUiState.NO_FRAME;
    } else {
      myThread = findThread();
      LOG.assertLog(myThread != null);
      myStackFrameIndex = findStackFrameIndex();
    }
  }

  /**
   * This constructor is called when user selects some thread from ui
   */
  /*package*/ JavaUiStateImpl(@NotNull JavaUiStateImpl previousState, @Nullable JavaThread thread, DebugSession debugSession) {
    super(debugSession);
    myDebugSession = debugSession;
    if (thread == null) {
      myContext = null;
      myThread = null;
      myStackFrameIndex = AbstractUiState.NO_FRAME;
    } else {
      myThread = thread;
      myContext = findContext(previousState);
      LOG.assertLog(myContext != null);
      //  in case some botva is going on 
      myStackFrameIndex = findStackFrameIndex();
    }
  }

  /**
   * This constructor is called when user selects some frame from ui
   */
  /*package*/ JavaUiStateImpl(@NotNull JavaUiStateImpl previousState, int frameIndex, DebugSession debugSession) {
    super(debugSession);
    myDebugSession = debugSession;
    LOG.assertLog(frameIndex == AbstractUiState.NO_FRAME || (frameIndex >= 0 && frameIndex < previousState.myThread.getFramesCount()));
    myContext = previousState.myContext;
    myThread = previousState.myThread;
    myStackFrameIndex = frameIndex;
  }

  private SuspendContext findContext(@NotNull JavaUiStateImpl previousState) {
    SuspendContext newContext = previousState.myContext;
    if (newContext == null) {
      LOG.errorAssertionFailed();
      return null;
    }
    if (!(newContext.suspends(getThread().getThread()))) {
      newContext = null;
      for (SuspendContext context : getAllPausedContexts()) {
        if (context.suspends(getThread().getThread())) {
          newContext = context;
          break;
        }
      }
    }
    return newContext;
  }

  protected JavaThread findThread() {
    if (myContext == null) {
      return null;
    }
    ThreadReference thread = myContext.getThread();
    if (thread == null) {
      List<ThreadReference> threads = getEventsProcessor().getVirtualMachine().allThreads();
      thread = threads.get(0);
      for (ThreadReference t : threads) {
        //  TODO this is a hack to filter out system threads 
        if (!(t.threadGroup().name().equals("system"))) {
          thread = t;
          break;
        }
      }
    }
    return new JavaThread(thread);
  }

  protected int findStackFrameIndex() {
    if (myThread == null) {
      return AbstractUiState.NO_FRAME;
    }
    return super.findStackFrameIndex();
  }

  @Nullable
  public ObjectReference getThisObject() {
    JavaStackFrame javaStackFrame = getStackFrame();
    if (javaStackFrame != null) {
      return javaStackFrame.getStackFrame().thisObject();
    }
    return null;
  }

  @NotNull
  /*package*/ JavaUiStateImpl paused(SuspendContext context) {
    //  changes state on pause/resume 
    //  we select new context even if we are already on some other context 
    //  user probably wants to know about new paused contexts 
    return new JavaUiStateImpl(context, myDebugSession);
  }

  @NotNull
  /*package*/ JavaUiStateImpl resumed(SuspendContext context) {
    // TODO if some other context is resumed it does not mean that those changes do not concern us. We still want to display correct threads state. 
    if (context != myContext) {
      return this;
    }
    SuspendContext newContext = null;
    List<SuspendContext> allPausedContexts = getAllPausedContexts();
    if (!(allPausedContexts.isEmpty())) {
      newContext = allPausedContexts.get(0);
    }
    return new JavaUiStateImpl(newContext, myDebugSession);
  }

  private List<SuspendContext> getAllPausedContexts() {
    SuspendManager suspendManager = getEventsProcessor().getSuspendManager();
    SuspendContext context = suspendManager.getPausedByUserContext();
    if (context != null) {
      return suspendManager.getPausedContexts();
    }
    return CollectionUtil.union(suspendManager.getPausedContexts(), Collections.singletonList(context));
  }

  protected JavaUiStateImpl selectThreadInternal(@Nullable IThread thread) {
    //  changes state on user selection 
    return new JavaUiStateImpl(this, (JavaThread) thread, myDebugSession);
  }

  protected JavaUiStateImpl selectFrameInternal(int frame) {
    if (myStackFrameIndex != frame) {
      return new JavaUiStateImpl(this, frame, myDebugSession);
    }
    return this;
  }

  @Nullable
  public SuspendContext getContext() {
    return myContext;
  }

  @NotNull
  public List<IThread> getThreads() {
    if (getExecutionState().equals(AbstractDebugSession.ExecutionState.Paused)) {
      List<IThread> result = new ArrayList<IThread>();
      for (ThreadReference threadReference : getEventsProcessor().getVirtualMachine().allThreads()) {
        if (threadReference.isSuspended()) {
          result.add(new JavaThread(threadReference));
        }
      }
      return result;
    }
    return Collections.emptyList();
  }

  public boolean isPausedOnBreakpoint() {
    return myContext != null && getEventsProcessor().getSuspendManager().getPausedContexts().contains(myContext);
  }

  @Nullable
  public JavaThread getThread() {
    return (JavaThread) myThread;
  }

  @Nullable
  public JavaStackFrame getStackFrame() {
    if (myStackFrameIndex == AbstractUiState.NO_FRAME) {
      return null;
    }
    assert myThread != null;
    //  if we have a frame then we have a thread 
    return (JavaStackFrame) myThread.getFrames().get(myStackFrameIndex);
  }

  @Override
  public IStackFrame getStackFrame(int index) {
    JavaThread thread = getThread();
    if (thread == null) {
      return null;
    }
    return thread.getFrame(index);
  }

  private DebugVMEventsProcessor getEventsProcessor() {
    return myDebugSession.getEventsProcessor();
  }

  private AbstractDebugSession.ExecutionState getExecutionState() {
    return myDebugSession.getExecutionState();
  }

  @Deprecated
  public Value getVariableValue(LocalVariable variable) {
    JavaStackFrame stackFrame = getStackFrame();
    if (stackFrame != null) {
      return stackFrame.getStackFrame().getValue(variable);
    }
    return null;
  }

  @NotNull
  private List<IWatchable> getAdditionalWatchables() {
    List<IWatchable> watchables = new ArrayList<IWatchable>();
    if (myContext != null) {
      EventSet eventSet = myContext.getEventSet();
      if (eventSet != null) {
        String classFqName = getStackFrame().getClassFqName();
        ThreadReference threadReference = getThread().getThread();
        EventWatchablesCreator watchablesCreator = new EventWatchablesCreator();
        for (Event event : eventSet) {
          watchablesCreator.addWatchablesFromEvent(event, watchables, classFqName, threadReference);
        }
      }
    }
    return watchables;
  }

  @NotNull
  public List<IWatchable> getWatchables() {
    List<IWatchable> watchables = new ArrayList<IWatchable>();
    watchables.addAll(super.getWatchables());
    watchables.addAll(getAdditionalWatchables());
    return watchables;
  }
}
