package jetbrains.mps.debugger.java.runtime.requests;

/*Generated by MPS */

import jetbrains.mps.debugger.java.runtime.DebugVMEventsProcessor;
import com.sun.jdi.ReferenceType;

public interface ClassPrepareRequestor extends Requestor {
  public void processClassPrepare(final DebugVMEventsProcessor debugProcess, final ReferenceType classType);
}
