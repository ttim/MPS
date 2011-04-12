package jetbrains.mps.debug.evaluation;

import com.sun.jdi.InvocationException;
import com.sun.jdi.ThreadReference;
import jetbrains.mps.debug.evaluation.proxies.IArrayValueProxy;
import jetbrains.mps.debug.evaluation.proxies.IObjectValueProxy;
import jetbrains.mps.debug.evaluation.proxies.MirrorUtil;
import jetbrains.mps.logging.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Wraps com.sun.jdi.InvocationException.
 * Thrown to indicate an exception occurred in an invoked method within the target VM.
 */
public class TargetVMEvaluationException extends EvaluationException {
  private static final Logger LOG = Logger.getLogger(TargetVMEvaluationException.class);

  public TargetVMEvaluationException(@NotNull InvocationException e) {
    this(e, null);
  }

  public TargetVMEvaluationException(@NotNull InvocationException e, @Nullable ThreadReference threadReference) {
    super(e.exception().referenceType().name());

    if (threadReference == null) return;

    try {
      IObjectValueProxy exceptionProxy = (IObjectValueProxy) MirrorUtil.getValueProxy(e.exception(), threadReference);
      IArrayValueProxy stackTrace = (IArrayValueProxy) exceptionProxy.invokeMethod("getStackTrace", "()[Ljava/lang/StackTraceElement;");
      int length = stackTrace.getLength();
      StackTraceElement[] newStackTrace = new StackTraceElement[length];
      for (int i = 0; i < length; i++) {
        IObjectValueProxy stackTraceElement = (IObjectValueProxy) stackTrace.getElementAt(i);
        newStackTrace[i] = new StackTraceElement((String)stackTraceElement.getFieldValue("declaringClass").getJavaValue(),
          (String)stackTraceElement.getFieldValue("methodName").getJavaValue(),
          (String)stackTraceElement.getFieldValue("fileName").getJavaValue(),
          (Integer)stackTraceElement.getFieldValue("lineNumber").getJavaValue());
      }
      setStackTrace(newStackTrace);
    } catch (ClassCastException exception) {
      LOG.warning("Cant create TargetVMEvaluationException for " + e, exception);
    } catch (EvaluationException exception) {
      LOG.warning("Cant create TargetVMEvaluationException for " + e, exception);
    }
  }

}
