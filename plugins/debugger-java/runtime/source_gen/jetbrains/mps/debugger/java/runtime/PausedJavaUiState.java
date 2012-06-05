package jetbrains.mps.debugger.java.runtime;

/*Generated by MPS */

import org.jetbrains.annotations.NotNull;
import java.util.List;
import jetbrains.mps.debug.runtime.java.programState.proxies.JavaThread;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.debug.api.programState.IWatchable;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.debug.api.AbstractDebugSession;
import com.sun.jdi.ThreadReference;
import org.jetbrains.annotations.Nullable;
import com.sun.jdi.ObjectReference;
import jetbrains.mps.debug.runtime.java.programState.proxies.JavaStackFrame;
import jetbrains.mps.debug.api.programState.IThread;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import jetbrains.mps.debug.api.AbstractUiState;
import jetbrains.mps.debug.api.programState.IStackFrame;
import com.sun.jdi.event.EventSet;
import jetbrains.mps.debugger.java.runtime.watchables.EventWatchablesCreator;
import com.sun.jdi.event.Event;
import com.sun.jdi.StackFrame;

public class PausedJavaUiState extends JavaUiStateImpl {
  @NotNull
  private final SuspendContext myContext;
  private final int myThreadIndex;
  private final int myStackFrameIndex;
  private final List<JavaThread> myThreads = ListSequence.fromList(new ArrayList<JavaThread>());
  private final List<IWatchable> myWatchables = ListSequence.fromList(new ArrayList<IWatchable>());

  /*package*/ PausedJavaUiState(@NotNull SuspendContext context, @NotNull DebugSession debugSession) {
    super(debugSession);
    myContext = context;

    initializeThreads();

    myThreadIndex = findThreadIndex();
    assert myThreadIndex >= 0;
    getThread().initializeFrames();

    myStackFrameIndex = findStackFrameIndex();
    check_vzg6vq_a01a0(getStackFrame(), this);
    ListSequence.fromList(myWatchables).addSequence(ListSequence.fromList(getAdditionalWatchables()));
  }

  /**
   * This constructor is called when user selects some thread from ui
   */
  private PausedJavaUiState(@NotNull PausedJavaUiState previousState, DebugSession debugSession, int currentThreadIndex) {
    super(debugSession);
    myThreadIndex = currentThreadIndex;
    assert currentThreadIndex >= 0;

    initializeThreads();

    myContext = findContext(previousState);
    assert myContext != null;

    getThread().initializeFrames();

    myStackFrameIndex = findStackFrameIndex();
    check_vzg6vq_a21a1(getStackFrame(), this);
    ListSequence.fromList(myWatchables).addSequence(ListSequence.fromList(getAdditionalWatchables()));
  }

  /**
   * This constructor is called when user selects some frame from ui
   */
  private PausedJavaUiState(@NotNull PausedJavaUiState previousState, int frameIndex, DebugSession debugSession) {
    super(debugSession);
    assert frameIndex == NO_FRAME || (frameIndex >= 0 && frameIndex < previousState.getCurrentThread().getFramesCount());
    myContext = previousState.myContext;
    myThreadIndex = previousState.myThreadIndex;
    myStackFrameIndex = frameIndex;

    initializeThreads();
    getThread().initializeFrames();
    getStackFrame().initializeWatchables();
    ListSequence.fromList(myWatchables).addSequence(ListSequence.fromList(getAdditionalWatchables()));
  }

  private synchronized void initializeThreads() {
    assert !(ModelAccess.instance().isInEDT());
    assert getExecutionState().equals(AbstractDebugSession.ExecutionState.Paused);

    for (ThreadReference threadReference : getEventsProcessor().getVirtualMachine().allThreads()) {
      if (threadReference.isSuspended()) {
        myThreads.add(new JavaThread(threadReference));
      }
    }
    assert myThreadIndex < ListSequence.fromList(myThreads).count();
  }

  @Nullable
  public JavaThread getCurrentThread() {
    return ListSequence.fromList(myThreads).getElement(myThreadIndex);
  }

  private int findThreadIndex() {
    List<ThreadReference> threads = getEventsProcessor().getVirtualMachine().allThreads();
    ThreadReference thread = myContext.getThread();

    if (thread != null) {
      return threads.indexOf(thread);
    }

    for (ThreadReference t : threads) {
      //  TODO this is a hack to filter out system threads 
      if (!(t.threadGroup().name().equals("system"))) {
        return threads.indexOf(t);
      }
    }
    return 0;
  }

  @Nullable
  public ObjectReference getThisObject() {
    JavaStackFrame javaStackFrame = getStackFrame();
    if (javaStackFrame != null) {
      return check_vzg6vq_a0a1a3(javaStackFrame.getStackFrame());
    }
    return null;
  }

  protected PausedJavaUiState selectThreadInternal(@Nullable IThread thread) {
    int index = ListSequence.fromList(myThreads).indexOf(thread);
    //  changes state on user selection 
    return new PausedJavaUiState(this, myDebugSession, index);
  }

  protected PausedJavaUiState selectFrameInternal(int frame) {
    if (myStackFrameIndex != frame) {
      return new PausedJavaUiState(this, frame, myDebugSession);
    }
    return this;
  }

  @Override
  public void selectThread(@Nullable final IThread thread) {
    myDebugSession.getEventsProcessor().invokeInManagerThread(new _FunctionTypes._void_P0_E0() {
      public void invoke() {
        AbstractUiState newState = selectThreadInternal(thread);
        if (newState != PausedJavaUiState.this) {
          myAbstractDebugSession.trySetState(PausedJavaUiState.this, newState);
        }
      }
    });
  }

  @Override
  public void selectFrame(final int frame) {
    myDebugSession.getEventsProcessor().invokeInManagerThread(new _FunctionTypes._void_P0_E0() {
      public void invoke() {
        PausedJavaUiState newState = selectFrameInternal(frame);
        if (newState != PausedJavaUiState.this) {
          myAbstractDebugSession.trySetState(PausedJavaUiState.this, newState);
        }
      }
    });
  }

  @NotNull
  public SuspendContext getContext() {
    return myContext;
  }

  @NotNull
  public List<? extends IThread> getThreads() {
    return myThreads;
  }

  public boolean isPausedOnBreakpoint() {
    return getEventsProcessor().getSuspendManager().getPausedContexts().contains(myContext);
  }

  public JavaThread getThread() {
    return (JavaThread) ListSequence.fromList(myThreads).getElement(myThreadIndex);
  }

  @Nullable
  public JavaStackFrame getStackFrame() {
    if (myStackFrameIndex == AbstractUiState.NO_FRAME) {
      return null;
    }
    assert myThreadIndex >= 0;
    //  if we have a frame then we have a thread 
    return (JavaStackFrame) ListSequence.fromList(myThreads).getElement(myThreadIndex).getFrames().get(myStackFrameIndex);
  }

  @Override
  public IStackFrame getStackFrame(int index) {
    JavaThread thread = getThread();
    if (thread == null) {
      return null;
    }
    return thread.getFrame(index);
  }

  private AbstractDebugSession.ExecutionState getExecutionState() {
    return myDebugSession.getExecutionState();
  }

  @NotNull
  private List<IWatchable> getAdditionalWatchables() {
    List<IWatchable> watchables = new ArrayList<IWatchable>();
    if (myContext != null) {
      EventSet eventSet = myContext.getEventSet();
      if (eventSet != null) {
        String classFqName = check_vzg6vq_a0a0b0b0p(getStackFrame(), this);
        ThreadReference threadReference = check_vzg6vq_a0b0b0b0p(getThread(), this);
        if (classFqName == null || threadReference == null) {
          return watchables;
        }
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
    watchables.addAll(myWatchables);
    return watchables;
  }

  private static void check_vzg6vq_a01a0(JavaStackFrame checkedDotOperand, PausedJavaUiState checkedDotThisExpression) {
    if (null != checkedDotOperand) {
      checkedDotOperand.initializeWatchables();
    }

  }

  private static void check_vzg6vq_a21a1(JavaStackFrame checkedDotOperand, PausedJavaUiState checkedDotThisExpression) {
    if (null != checkedDotOperand) {
      checkedDotOperand.initializeWatchables();
    }

  }

  private static ObjectReference check_vzg6vq_a0a1a3(StackFrame checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.thisObject();
    }
    return null;
  }

  private static String check_vzg6vq_a0a0b0b0p(JavaStackFrame checkedDotOperand, PausedJavaUiState checkedDotThisExpression) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getClassFqName();
    }
    return null;
  }

  private static ThreadReference check_vzg6vq_a0b0b0b0p(JavaThread checkedDotOperand, PausedJavaUiState checkedDotThisExpression) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getThread();
    }
    return null;
  }
}
