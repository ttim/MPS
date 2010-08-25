package jetbrains.mps.debug.evaluation.proxies;

import com.sun.jdi.PrimitiveValue;
import com.sun.jdi.ThreadReference;

public class PrimitiveValueProxy extends ValueProxy implements IValueProxy {
  public PrimitiveValueProxy(PrimitiveValue v, ThreadReference threadReference) {
    super(v, threadReference);
  }

  public PrimitiveValue getPrimitiveValue() {
    return (PrimitiveValue) myValue;
  }

  @Override
  public boolean javaEquals(IValueProxy valueProxy) {
    if (valueProxy == null || valueProxy instanceof INullValueProxy) return false;
    return myValue.equals(valueProxy.getJDIValue());
  }
}
