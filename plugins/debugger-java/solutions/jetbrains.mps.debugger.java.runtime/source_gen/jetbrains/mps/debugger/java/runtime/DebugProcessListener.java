package jetbrains.mps.debugger.java.runtime;

/*Generated by MPS */

import org.jetbrains.annotations.NotNull;

public 
/**
 * * Created by IntelliJ IDEA.
 * * User: Cyril.Konopko
 * * Date: 17.12.2009
 * * Time: 17:13:01
 * * To change this template use File | Settings | File Templates.
 */
interface DebugProcessListener {
  public void connectorIsReady();
  public void paused(@NotNull SuspendContext suspendContext);
  public void resumed(@NotNull SuspendContext suspendContext);
  public void processDetached(@NotNull DebugVMEventsProcessor process, boolean closedByUser);
  public void processAttached(@NotNull DebugVMEventsProcessor process);
}
