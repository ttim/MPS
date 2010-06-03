package jetbrains.mps.debug.evaluation.proxies;

import com.sun.jdi.ThreadReference;
import com.sun.jdi.Value;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

abstract class ValueProxy implements IValueProxy {
  @NotNull
  protected final Value myValue;
  @NotNull
  protected final ThreadReference myThreadReference;

  public ValueProxy(@NotNull Value v, @NotNull ThreadReference threadReference) {
    myValue = v;
    myThreadReference = threadReference;
    //todo assert that thread is suspended on event.
  }

  @Override
  @NotNull
  public Value getJDIValue() {
    return myValue;
  }

  @Override
  @Nullable
  public Object getJavaValue() {
    return MirrorUtil.getJavaValue(myValue);
  }
}
