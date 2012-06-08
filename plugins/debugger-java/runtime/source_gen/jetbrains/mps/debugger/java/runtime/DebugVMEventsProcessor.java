package jetbrains.mps.debugger.java.runtime;

/*Generated by MPS */

import jetbrains.mps.logging.Logger;
import jetbrains.mps.debug.api.BreakpointManagerComponent;
import com.sun.jdi.VirtualMachine;
import jetbrains.mps.debugger.java.runtime.execution.SystemMessagesReporter;
import java.util.concurrent.atomic.AtomicInteger;
import jetbrains.mps.debug.api.IDebuggableFramesSelector;
import jetbrains.mps.debugger.java.runtime.execution.IDebuggerManagerThread;
import com.sun.jdi.event.LocatableEvent;
import com.sun.jdi.ThreadReference;
import jetbrains.mps.debugger.java.runtime.requests.LocatableEventRequestor;
import com.sun.jdi.request.EventRequest;
import jetbrains.mps.debugger.java.runtime.breakpoints.JavaBreakpoint;
import jetbrains.mps.debug.api.breakpoints.IBreakpoint;
import com.sun.jdi.event.ClassPrepareEvent;
import com.sun.jdi.event.Event;
import com.sun.jdi.event.StepEvent;
import com.sun.jdi.request.StepRequest;
import jetbrains.mps.debugger.java.runtime.execution.DebuggerManagerThread;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import jetbrains.mps.debugger.java.runtime.execution.DebuggerCommand;
import com.sun.jdi.event.EventQueue;
import com.sun.jdi.event.EventSet;
import com.sun.jdi.event.VMDeathEvent;
import com.sun.jdi.event.VMDisconnectEvent;
import com.sun.jdi.VMDisconnectedException;
import com.sun.jdi.InternalException;
import jetbrains.mps.debugger.java.runtime.execution.IDebuggerCommand;

public class DebugVMEventsProcessor {
  private static final Logger LOG = Logger.getLogger(DebugVMEventsProcessor.class);
  protected static final int STATE_INITIAL = 0;
  protected static final int STATE_ATTACHED = 1;
  protected static final int STATE_DETACHING = 2;
  protected static final int STATE_DETACHED = 3;

  private final BreakpointManagerComponent myBreakpointManager;
  private final RequestManager myRequestManager;
  private final SuspendManager mySuspendManager;
  private VirtualMachine myVirtualMachine;
  private DebugVMEventsProcessor.DebuggerEventThread myEventThread;
  private final DebugProcessMulticaster myMulticaster = new DebugProcessMulticaster();
  private final SystemMessagesReporter myReporter = new SystemMessagesReporter(myMulticaster);
  protected final AtomicInteger myState = new AtomicInteger(STATE_INITIAL);
  private IDebuggableFramesSelector myFramesSelector;
  private final IDebuggerManagerThread myManagerThread;

  public DebugVMEventsProcessor(BreakpointManagerComponent breakpointsManager, IDebuggerManagerThread managerThread) {
    myManagerThread = managerThread;
    myBreakpointManager = breakpointsManager;
    myRequestManager = new RequestManager(this);
    mySuspendManager = new SuspendManager(this);
  }

  public void commitVM(VirtualMachine vm) {
    if (vm != null) {
      myVirtualMachine = vm;
      vmAttached();
      myEventThread = new DebugVMEventsProcessor.DebuggerEventThread();
      new Thread(myEventThread, "Debug Events Processor Thread").start();
    }
  }

  public DebugProcessMulticaster getMulticaster() {
    //  package  
    return myMulticaster;
  }

  public VirtualMachine getVirtualMachine() {
    return myVirtualMachine;
  }

  public RequestManager getRequestManager() {
    return myRequestManager;
  }

  public SuspendManager getSuspendManager() {
    return mySuspendManager;
  }

  public BreakpointManagerComponent getBreakpointManager() {
    return myBreakpointManager;
  }

  public SystemMessagesReporter getSystemMessagesReporter() {
    return myReporter;
  }

  public void setDebuggableFramesSelector(IDebuggableFramesSelector framesSelector) {
    myFramesSelector = framesSelector;
  }

  public IDebuggerManagerThread getManagerThread() {
    return myManagerThread;
  }

  public void addDebugProcessListener(DebugProcessListener listener) {
    myMulticaster.addListener(listener);
  }

  public void removeDebugProcessListener(DebugProcessListener listener) {
    myMulticaster.removeListener(listener);
  }

  public boolean isAttached() {
    return myState.get() == STATE_ATTACHED;
  }

  private void vmAttached() {
    //  DebuggerManagerThreadImpl.assertIsManagerThread(); 
    LOG.assertLog(!(isAttached()));
    if (myState.compareAndSet(STATE_INITIAL, STATE_ATTACHED)) {
      // here we change an atomic state from initial to attached 
      // DebuggerManagerEx.getInstanceEx(getProject()).getBreakpointManager().setInitialBreakpointsState(); 
      myMulticaster.processAttached(this);
      // show some info etc 
    }
  }

  private void processLocatableEvent(final SuspendContext suspendContext, final LocatableEvent event) {
    // ============================================ EVENTS PROCESSING ============================================= 
    ThreadReference thread = event.thread();
    LOG.assertLog(thread.isSuspended());
    DebugVMEventsProcessor.preprocessEvent(suspendContext, thread);
    // we use schedule to allow processing other events during processing this one 
    // this is especially nesessary if a method is breakpoint condition 
    SuspendContextCommand suspendCommand = new SuspendContextCommand(suspendContext) {
      @Override
      protected void action() throws Exception {
        final SuspendManager suspendManager = mySuspendManager;
        SuspendContext pausedContext = getSuspendManager().getPausedContext();
        if (pausedContext != null && pausedContext.isEvaluating()) {
          suspendManager.voteResume(suspendContext);
          return;
        }
        // breakpoint found 
        final LocatableEventRequestor requestor = (LocatableEventRequestor) getRequestManager().findRequestor(event.request());
        boolean resumePreferred = requestor != null && EventRequest.SUSPEND_NONE == requestor.getSuspendPolicy();
        boolean requestHit = false;
        try {
          requestHit = (requestor != null) && requestor.processLocatableEvent(this, event);
          //  } catch () { 
          //  todo: catch a special exception here, show modal window like "error evaluation breakpoint condition, do you want to 
          //  todo "stop at the breakpoint, Y/N etc. 
        } catch (Throwable t) {
          DebugVMEventsProcessor.LOG.error(t);
        }
        if (requestHit) {
          if (requestor instanceof JavaBreakpoint && ((JavaBreakpoint) requestor).isLogMessage()) {
            myReporter.reportInformation("Breakpoint hit: " + ((JavaBreakpoint) requestor).getPresentation() + " " + event.location().sourceName() + ":" + event.location().lineNumber());
          }
          if (requestor instanceof IBreakpoint) {
            //  if requestor is a breakpoint and this breakpoint was hit, no matter its suspend policy 
            myBreakpointManager.processBreakpointHit((IBreakpoint) requestor);
          }
        }
        if (!(requestHit) || resumePreferred) {
          suspendManager.voteResume(suspendContext);
        } else {
          suspendManager.voteSuspend(suspendContext);
        }
      }
    };
    getManagerThread().schedule(suspendCommand);
  }

  private void processClassPrepareEvent(SuspendContext suspendContext, ClassPrepareEvent event) {
    //  a class is prepared: let's set breakpoint requests from breakpoints 
    DebugVMEventsProcessor.preprocessEvent(suspendContext, event.thread());
    myRequestManager.processClassPrepared(event);
    mySuspendManager.voteResume(suspendContext);
  }

  private void processVMDeathEvent(SuspendContext suspendContext, Event event) {
    //  a VM is dead 
    try {
      DebugVMEventsProcessor.preprocessEvent(suspendContext, null);
      //   cancelRunToCursorBreakpoint(); 
    } finally {
      if (myEventThread != null) {
        myEventThread.stopListening();
        myEventThread = null;
      }
      closeProcess(false);
    }
  }

  private void processStepEvent(SuspendContext suspendContext, StepEvent event) {
    DebugVMEventsProcessor.preprocessEvent(suspendContext, event.thread());
    myRequestManager.deleteStepRequests();
    boolean shouldResume = false;
    EventRequest request = event.request();
    if (request instanceof StepRequest) {
      StepRequest stepRequest = (StepRequest) request;
      //  calculate if we should really stop here 
      //  see idea's RequestHint.getNextStepDepth 
      StepRequestor requestor = (StepRequestor) myRequestManager.findRequestor(stepRequest);
      assert requestor != null;
      int nextStepType = requestor.nextStep(suspendContext);
      shouldResume = nextStepType != StepRequestor.STOP;
      if (shouldResume) {
        //  do next step 
        addNewStepRequest(suspendContext, suspendContext.getThread(), requestor, nextStepType);
      }
      //  TODO restore breakpoints 
    }
    if (shouldResume) {
      getSuspendManager().voteResume(suspendContext);
    } else {
      getSuspendManager().voteSuspend(suspendContext);
    }
  }

  private void stopConnecting() {
    //  todo DebugProcessImpl.stopConnecting 
    closeProcess(true);
  }

  private void closeProcess(boolean closedByUser) {
    DebuggerManagerThread.assertIsManagerThread();
    if (myState.compareAndSet(STATE_INITIAL, STATE_DETACHING) || myState.compareAndSet(STATE_ATTACHED, STATE_DETACHING)) {
      myVirtualMachine = null;
      try {
        getManagerThread().close();
      } finally {
        myState.set(STATE_DETACHED);
        getMulticaster().processDetached(this, closedByUser);
      }
    }
  }

  public void resume(@NotNull SuspendContext suspendContext) {
    // ============================================ COMMANDS ============================================= 
    getManagerThread().schedule(new DebugVMEventsProcessor.ResumeCommand(suspendContext));
  }

  public void pause() {
    getManagerThread().schedule(new DebugVMEventsProcessor.PauseCommand());
  }

  public void stop(boolean terminate) {
    getManagerThread().invokeTerminalCommand(new DebugVMEventsProcessor.StopCommand(terminate));
  }

  public void step(DebugVMEventsProcessor.StepType type, @NotNull SuspendContext suspendContext) {
    //  in idea we also remember that we are step and add thread reference to a special list 
    //  it is only used for updating local variables (namely for highlighting new vars) 
    //  (but I may be wrong) 
    //  see DebuggerSession.mySteppingThroughThreads in idea 
    getManagerThread().schedule(new DebugVMEventsProcessor.StepCommand(suspendContext, type));
  }

  private void addNewStepRequest(SuspendContext suspendContext, ThreadReference stepThread, StepRequestor stepRequestor, int stepType) {
    if (stepThread == null) {
      return;
    }
    StepRequest stepRequest = myRequestManager.createStepRequest(stepRequestor, stepType, stepThread, suspendContext.getSuspendPolicy());
    //  TODO request filters should be configured by user 
    //  this particular list was taken from idea debugger settings in order to fix MPS-8725 
    stepRequest.addClassExclusionFilter("java.*");
    stepRequest.addClassExclusionFilter("javax.*");
    stepRequest.addClassExclusionFilter("org.omg.*");
    stepRequest.addClassExclusionFilter("sun.*");
    stepRequest.addClassExclusionFilter("junit.*");
    stepRequest.addClassExclusionFilter("com.sun.*");
    // TODO also might wanna let user to exclude constructors, classloaders, getters, 
    // synthetic methods (whatever synthetic methods are). 
    // see idea debugger settings for the full list 
    myRequestManager.enableRequest(stepRequest);
  }

  public void invokeInManagerThread(final _FunctionTypes._void_P0_E0 command) {
    getManagerThread().schedule(new DebuggerCommand() {
      protected void action() throws Exception {
        command.invoke();
      }
    });
  }

  private static void preprocessEvent(SuspendContext suspendContext, ThreadReference thread) {
    // todo here a thread will be set to suspend context, dont know why 
    ThreadReference oldThread = suspendContext.getThread();
    suspendContext.setThread(thread);
    if (oldThread == null) {
      // this is the first event in the eventSet that we process 
      //  fire some events 
      //     suspendContext.getDebugProcess().beforeSuspend(suspendContext); 
    }
  }

  private class DebuggerEventThread implements Runnable {
    private boolean myIsStopped = false;

    /*package*/ DebuggerEventThread() {
    }

    public synchronized void stopListening() {
      myIsStopped = true;
    }

    private synchronized boolean isStopped() {
      return myIsStopped;
    }

    public void run() {
      try {
        EventQueue eventQueue = myVirtualMachine.eventQueue();
        while (!(isStopped())) {
          try {
            final EventSet eventSet = eventQueue.remove();
            getManagerThread().invokeAndWait(new DebuggerCommand() {
              protected void action() throws Exception {
                final SuspendContext suspendContext = mySuspendManager.pushSuspendContextFromEventSet(eventSet);
                for (Event event : eventSet) {
                  try {
                    // todo processing different event kinds here 
                    //    if (event instanceof VMStartEvent) { 
                    //   //Sun WTK fails when J2ME when event set is resumed on VMStartEvent 
                    //   processVMStartEvent(suspendContext, (VMStartEvent)event); 
                    // } 
                    // else  
                    // AccessWatchpointEvent, BreakpointEvent, ExceptionEvent, MethodEntryEvent, MethodExitEvent, 
                    // ModificationWatchpointEvent, StepEvent, WatchpointEvent 
                    if (event instanceof VMDeathEvent) {
                      processVMDeathEvent(suspendContext, event);
                    } else
                    if (event instanceof VMDisconnectEvent) {
                      processVMDeathEvent(suspendContext, event);
                    } else
                    if (event instanceof ClassPrepareEvent) {
                      processClassPrepareEvent(suspendContext, (ClassPrepareEvent) event);
                    } else
                    if (event instanceof StepEvent) {
                      processStepEvent(suspendContext, (StepEvent) event);
                    } else
                    if (event instanceof LocatableEvent) {
                      processLocatableEvent(suspendContext, (LocatableEvent) event);
                    } else {
                      mySuspendManager.voteResume(suspendContext);
                    }
                    //   else if (event instanceof ClassUnloadEvent){ 
                    //   processDefaultEvent(suspendContext); 
                    // } 
                  } catch (VMDisconnectedException e) {
                    // LOG.debug(e); 
                  } catch (InternalException e) {
                    // LOG.info(e); 
                  } catch (Throwable e) {
                    DebugVMEventsProcessor.LOG.error(e);
                  }
                }
              }
            });
          } catch (InternalException e) {
            //  LOG.debug(e); 
          } catch (InterruptedException e) {
            throw e;
          } catch (VMDisconnectedException e) {
            throw e;
          } catch (Throwable e) {
            //  LOG.debug(e); 
          }
        }
      } catch (InterruptedException e) {
        invokeVMDeathEventInManagerThread();
      } catch (VMDisconnectedException e) {
        invokeVMDeathEventInManagerThread();
      } finally {
        Thread.interrupted();
        //  reset interrupted status 
      }
    }

    private void invokeVMDeathEventInManagerThread() {
      getManagerThread().invokeAndWait(new DebuggerCommand() {
        protected void action() throws Exception {
          //  SuspendContext suspendContext = getSuspendManager().pushSuspendContext(EventRequest.SUSPEND_NONE, 1); 
          //  TODO why do we need to create empty context? VM is dead! 
          SuspendContext suspendContext = getSuspendManager().pushSuspendContextFromEventSet(null);
          processVMDeathEvent(suspendContext, null);
        }
      });
    }
  }

  private class ResumeCommand extends SuspendContextCommand {
    public ResumeCommand(@NotNull SuspendContext suspendContext) {
      super(suspendContext);
    }

    @Override
    public IDebuggerCommand.CommandPriority getPriority() {
      return IDebuggerCommand.CommandPriority.HIGH;
    }

    @Override
    protected void action() throws Exception {
      //  see DebugProcessImpl.ResumeCommand in idea 
      SuspendManager suspendManager = getSuspendManager();
      suspendManager.resume(getSuspendContext());
      getMulticaster().resumed(getSuspendContext());
    }
  }

  private class PauseCommand extends DebuggerCommand {
    private PauseCommand() {
    }

    @Override
    protected void action() throws Exception {
      //  see DebugProcessImpl.PauseCommand in idea 
      getVirtualMachine().suspend();
      SuspendManager suspendManager = getSuspendManager();
      SuspendContext suspendContext = suspendManager.pushSuspendContextWithVotesNumber(EventRequest.SUSPEND_ALL, 0);
      suspendManager.setPausedByUser(suspendContext);
      getMulticaster().paused(suspendContext);
    }
  }

  private class StopCommand extends DebuggerCommand {
    private final boolean myIsTerminateTargetVM;

    public StopCommand(boolean isTerminateTargetVM) {
      myIsTerminateTargetVM = isTerminateTargetVM;
    }

    public IDebuggerCommand.CommandPriority getPriority() {
      return IDebuggerCommand.CommandPriority.HIGH;
    }

    protected void action() throws Exception {
      if (isAttached()) {
        VirtualMachine virtualMachine = getVirtualMachine();
        if (myIsTerminateTargetVM) {
          virtualMachine.exit(-1);
        } else {
          //  some VM's (like IBM VM 1.4.2 bundled with WebSpere) does not 
          //  resume threads on dispose() like it should 
          virtualMachine.resume();
          virtualMachine.dispose();
        }
      } else {
        stopConnecting();
      }
    }
  }

  private class StepCommand extends DebugVMEventsProcessor.ResumeCommand {
    private final DebugVMEventsProcessor.StepType myStepType;

    public StepCommand(@NotNull SuspendContext suspendContext, @NotNull DebugVMEventsProcessor.StepType type) {
      super(suspendContext);
      myStepType = type;
    }

    @Override
    protected void action() throws Exception {
      SuspendContext suspendContext = getSuspendContext();
      addNewStepRequest(suspendContext, suspendContext.getThread(), new StepRequestor(suspendContext, getStepType(), myFramesSelector), getStepType());
      super.action();
    }

    private int getStepType() {
      return myStepType.getJdiType();
    }
  }

  public static   enum StepType {
    Over(StepRequest.STEP_OVER),
    Into(StepRequest.STEP_INTO),
    Out(StepRequest.STEP_OUT);

    private final int myJdiType;

    StepType(int jdiType) {
      myJdiType = jdiType;
    }

    public int getJdiType() {
      return myJdiType;
    }
  }
}
