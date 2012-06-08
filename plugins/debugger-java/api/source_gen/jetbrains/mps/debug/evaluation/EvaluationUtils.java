package jetbrains.mps.debug.evaluation;

/*Generated by MPS */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.sun.jdi.Value;
import com.sun.jdi.ArrayReference;
import org.jetbrains.annotations.NotNull;
import com.sun.jdi.Field;
import com.sun.jdi.ClassType;
import java.util.List;
import com.sun.jdi.Method;
import com.sun.jdi.ReferenceType;
import com.sun.jdi.VirtualMachine;
import org.jetbrains.annotations.Nullable;
import com.sun.jdi.Type;
import jetbrains.mps.debug.evaluation.proxies.IValueProxy;
import com.sun.jdi.StackFrame;
import jetbrains.mps.debug.evaluation.proxies.IObjectValueProxy;
import com.sun.jdi.ThreadReference;
import jetbrains.mps.debug.evaluation.proxies.IArrayValueProxy;
import jetbrains.mps.debug.evaluation.proxies.PrimitiveValueProxy;
import jetbrains.mps.util.annotation.ToRemove;
import com.sun.jdi.InvocationException;
import com.sun.jdi.InvalidTypeException;
import com.sun.jdi.ClassNotLoadedException;
import com.sun.jdi.IncompatibleThreadStateException;

public abstract class EvaluationUtils {
  protected static EvaluationUtils INSTANCE;
  protected static final Object LOCK = new Object();
  protected static Log log = LogFactory.getLog(EvaluationUtils.class);

  public EvaluationUtils() {
  }

  public abstract void init();

  public abstract void dispose();

  public abstract Value getArrayElementAt(ArrayReference array, int index);

  @NotNull
  public abstract Field findField(ClassType referenceType, String fieldName) throws InvalidEvaluatedExpressionException;

  public abstract List<Field> findFields(ClassType referenceType);

  @NotNull
  public abstract Method findConstructor(ClassType referenceType, String jniSignature) throws InvalidEvaluatedExpressionException;

  @NotNull
  public abstract Method findMethod(ClassType referenceType, String methodsName, String jniSignature) throws InvalidEvaluatedExpressionException;

  @NotNull
  public abstract ReferenceType findClassType(String className, VirtualMachine virtualMachine) throws InvalidEvaluatedExpressionException;

  @Nullable
  public abstract ReferenceType findClassTypeSilently(String className, VirtualMachine virtualMachine) throws InvalidEvaluatedExpressionException;

  public abstract boolean instanceOf(final Type what, final String jniSignature, final VirtualMachine machine) throws EvaluationException;

  @NotNull
  public abstract IValueProxy getVariableValue(String varName, StackFrame stackFrame) throws EvaluationException;

  @NotNull
  public abstract <T extends IValueProxy> Iterable<T> toIterableProxy(IObjectValueProxy valueProxy, ThreadReference threadReference);

  @NotNull
  public abstract <T extends IValueProxy> Iterable<T> toIterableProxyFromArray(IArrayValueProxy valueProxy);

  @NotNull
  public abstract IValueProxy invokeStaticMethod(String className, String name, String jniSignature, ThreadReference threadReference, Object... args) throws EvaluationException;

  @NotNull
  public abstract IValueProxy getStaticField(String className, String fieldName, VirtualMachine machine) throws InvalidEvaluatedExpressionException;

  @NotNull
  public abstract IObjectValueProxy invokeConstructorProxy(String className, String jniSignature, ThreadReference threadReference, Object... args) throws EvaluationException;

  public abstract IArrayValueProxy createArrayProxy(String className, VirtualMachine machine, int size) throws EvaluationException;

  public abstract IArrayValueProxy createArrayProxyFromValues(String className, VirtualMachine machine, Object... args) throws EvaluationException;

  @NotNull
  public abstract IValueProxy getClass(String className, VirtualMachine machine) throws InvalidEvaluatedExpressionException;

  @NotNull
  public abstract IObjectValueProxy boxValue(PrimitiveValueProxy primitiveValueProxy, ThreadReference threadReference) throws EvaluationException;

  public abstract PrimitiveValueProxy unboxValue(IObjectValueProxy valueProxy, ThreadReference threadReference) throws EvaluationException;

  public abstract String getStringPresentation(@NotNull Value value, ThreadReference reference);

  public static EvaluationUtils getInstance() {
    synchronized (LOCK) {
      return INSTANCE;
    }
  }

  @Deprecated
  @ToRemove(version = 2.1)
  public static Value getElementAt(ArrayReference array, int index) {
    return EvaluationUtils.getInstance().getArrayElementAt(array, index);
  }

  @Deprecated
  @ToRemove(version = 2.1)
  public static boolean isInstanceOf(final Type what, final String jniSignature, final VirtualMachine machine) throws EvaluationException {
    return EvaluationUtils.getInstance().instanceOf(what, jniSignature, machine);
  }

  @NotNull
  @Deprecated
  @ToRemove(version = 2.1)
  public static IValueProxy getValue(String varName, StackFrame stackFrame, ThreadReference reference) throws EvaluationException {
    return EvaluationUtils.getInstance().getVariableValue(varName, stackFrame);
  }

  @NotNull
  @Deprecated
  @ToRemove(version = 2.1)
  public static <T extends IValueProxy> Iterable<T> toIterable(IObjectValueProxy valueProxy) {
    // well, at least we compile 
    return EvaluationUtils.getInstance().toIterableProxy(valueProxy, null);
  }

  @NotNull
  @Deprecated
  @ToRemove(version = 2.1)
  public static <T extends IValueProxy> Iterable<T> toIterableFromArray(IArrayValueProxy valueProxy) {
    return EvaluationUtils.getInstance().toIterableProxyFromArray(valueProxy);
  }

  @NotNull
  @Deprecated
  @ToRemove(version = 2.1)
  public static IValueProxy invokeStatic(String className, String name, String jniSignature, ThreadReference threadReference, Object... args) throws EvaluationException {
    return EvaluationUtils.getInstance().invokeStaticMethod(className, name, jniSignature, threadReference, args);
  }

  @NotNull
  @Deprecated
  @ToRemove(version = 2.1)
  public static IValueProxy getStaticFieldValue(String className, String fieldName, ThreadReference threadReference) throws InvalidEvaluatedExpressionException {
    return EvaluationUtils.getInstance().getStaticField(className, fieldName, threadReference.virtualMachine());
  }

  @NotNull
  @Deprecated
  @ToRemove(version = 2.1)
  public static IObjectValueProxy invokeConstructor(String className, String jniSignature, ThreadReference threadReference, Object... args) throws EvaluationException {
    return EvaluationUtils.getInstance().invokeConstructorProxy(className, jniSignature, threadReference, args);
  }

  @Deprecated
  @ToRemove(version = 2.1)
  public static IArrayValueProxy createArray(String className, ThreadReference threadReference, int size) throws EvaluationException {
    return EvaluationUtils.getInstance().createArrayProxy(className, threadReference.virtualMachine(), size);
  }

  @Deprecated
  @ToRemove(version = 2.1)
  public static IArrayValueProxy createArrayFromValues(String className, ThreadReference threadReference, Object... args) throws EvaluationException {
    return EvaluationUtils.getInstance().createArrayProxyFromValues(className, threadReference.virtualMachine(), args);
  }

  @NotNull
  @Deprecated
  @ToRemove(version = 2.1)
  public static IValueProxy getClassValue(String className, ThreadReference threadReference) throws InvalidEvaluatedExpressionException {
    return EvaluationUtils.getInstance().getClass(className, threadReference.virtualMachine());
  }

  @NotNull
  @Deprecated
  @ToRemove(version = 2.1)
  public static IObjectValueProxy box(PrimitiveValueProxy primitiveValueProxy, ThreadReference threadReference) throws EvaluationException {
    return EvaluationUtils.getInstance().boxValue(primitiveValueProxy, threadReference);
  }

  @Deprecated
  @ToRemove(version = 2.1)
  public static PrimitiveValueProxy unbox(IObjectValueProxy valueProxy) throws EvaluationException {
    // all we want from this code is to be compilable 
    return EvaluationUtils.getInstance().unboxValue(valueProxy, null);
  }

  /**
   * Do something and convert jdi exceptions to evaluation exception
   * 
   * @param invocatable what to invoke
   * @param T result
   * @throws EvaluationException wrapper of the original exception
   * @return result
   */
  public static <T> T handleInvocationExceptions(EvaluationUtils.Invocatable<T> invocatable) throws EvaluationException {
    try {
      return invocatable.invoke();
    } catch (InvocationException e) {
      if (invocatable instanceof EvaluationUtils.ThreadInvocatable) {
        throw new TargetVMEvaluationException(e, ((EvaluationUtils.ThreadInvocatable) invocatable).getCurrentThreadReference());
      } else {
        throw new TargetVMEvaluationException(e);
      }
    } catch (IllegalArgumentException e) {
      throw new InvalidEvaluatedExpressionException(e);
    } catch (InvalidTypeException e) {
      throw new InvalidEvaluatedExpressionException(e);
    } catch (RuntimeException e) {
      if (e.getClass().getName().startsWith("com.sun.jdi")) {
        throw new JdiRuntimeExceptionEvaluationException(e);
      }
      throw new EvaluationRuntimeException(e);
    } catch (Throwable t) {
      throw new EvaluationException(t);
    }
  }

  /**
   * When we need to call something from ui which throws evaluation exception.
   * For example when we update the tree.
   * 
   * @param invocatable the action to invoke
   * @param failure value to return in case of failure
   * @param T result
   * @return result
   */
  public static <T> T consumeEvaluationException(EvaluationUtils.EvaluationInvocatable<T> invocatable, T failure) {
    try {
      return invocatable.invoke();
    } catch (InvalidEvaluatedExpressionException e) {
      if (log.isWarnEnabled()) {
        log.warn("", e);
      }
    } catch (InvocationTargetEvaluationException e) {
      if (log.isWarnEnabled()) {
        log.warn("", e);
      }
    } catch (TargetVMEvaluationException e) {
      if (log.isWarnEnabled()) {
        log.warn("", e);
      }
    } catch (JdiRuntimeExceptionEvaluationException e) {
      if (log.isInfoEnabled()) {
        log.info("", e);
      }
    } catch (EvaluationException e) {
      if (log.isDebugEnabled()) {
        log.debug("", e);
      }
    }
    return failure;
  }

  public 
  /**
   * Something that can throw one of jdi exceptions or EvaluationException
   * 
   * @param T result
   */
static interface Invocatable<T> {
    public T invoke() throws InvocationException, InvalidTypeException, ClassNotLoadedException, IncompatibleThreadStateException, EvaluationException;
  }

  public 
  /**
   * Something that can throw EvaluationException
   * 
   * @param T result
   */
static interface EvaluationInvocatable<T> {
    public T invoke() throws EvaluationException;
  }


  /**
   * Some action which also has information about thread reference where it happenes.
   * 
   * @param T result
   */
  public static abstract class ThreadInvocatable<T> implements EvaluationUtils.Invocatable<T> {
    private final ThreadReference myThreadReference;

    public ThreadInvocatable(ThreadReference threadReference) {
      myThreadReference = threadReference;
    }

    public ThreadReference getCurrentThreadReference() {
      return myThreadReference;
    }
  }
}
