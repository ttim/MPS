package jetbrains.mps.debugger.java.runtime.watchables;

/*Generated by MPS */

import jetbrains.mps.debug.runtime.java.programState.watchables.JavaWatchable;
import jetbrains.mps.debug.api.programState.IWatchable;
import jetbrains.mps.debug.runtime.java.programState.proxies.JavaValue;
import com.sun.jdi.ThreadReference;
import jetbrains.mps.debug.api.programState.WatchablesCategory;
import jetbrains.mps.debug.api.programState.IValue;
import javax.swing.Icon;
import jetbrains.mps.smodel.SNode;

public class JavaWatchpointValueWatchable extends JavaWatchable implements IWatchable {
  private final JavaValue myCachedValue;
  private final boolean myIsOld;

  public JavaWatchpointValueWatchable(JavaValue value, boolean old, String classFqName, ThreadReference threadReference) {
    super(classFqName, threadReference);
    myCachedValue = value;
    myIsOld = old;
  }

  @Override
  public String getName() {
    return (myIsOld ?
      "current value" :
      "new value"
    );
  }

  @Override
  public WatchablesCategory getCategory() {
    return WatchablesCategory.NONE;
  }

  @Override
  public IValue getValue() {
    return myCachedValue;
  }

  @Override
  public Icon getPresentationIcon() {
    return getValue().getPresentationIcon();
  }

  @Override
  public SNode getNode() {
    return null;
  }
}
