package jetbrains.mps.debug.evaluation.proxies;

/*Generated by MPS */

import org.jetbrains.annotations.NotNull;
import com.sun.jdi.Value;

public class VoidValueProxy extends ValueProxy implements IValueProxy {
  public VoidValueProxy(@NotNull Value v) {
    super(v);
  }

  @Override
  public boolean javaEquals(IValueProxy proxy) {
    return false;
  }
}
