package jetbrains.mps.debug.runtime.java.programState.watchables;

/*Generated by MPS */

import jetbrains.mps.debug.api.programState.IWatchable;
import com.sun.jdi.LocalVariable;
import jetbrains.mps.debug.runtime.java.programState.proxies.JavaStackFrame;
import jetbrains.mps.debug.runtime.java.programState.proxies.JavaValue;
import com.sun.jdi.ThreadReference;
import com.sun.jdi.StackFrame;
import jetbrains.mps.debug.runtime.java.programState.proxies.ValueUtil;
import jetbrains.mps.debug.api.programState.IValue;
import javax.swing.Icon;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.debug.runtime.java.programState.proxies.JavaLocation;
import jetbrains.mps.generator.traceInfo.TraceInfoUtil;
import jetbrains.mps.debug.api.programState.WatchablesCategory;
import jetbrains.mps.debug.runtime.java.programState.JavaWatchablesCategory;

public class JavaLocalVariable extends JavaWatchable implements IWatchable {
  private final LocalVariable myLocalVariable;
  private final JavaStackFrame myStackFrame;
  private JavaValue myCachedValue;

  public JavaLocalVariable(LocalVariable variable, JavaStackFrame stackFrame, String classFqName, ThreadReference threadReference) {
    super(classFqName, threadReference);
    myLocalVariable = variable;
    myStackFrame = stackFrame;
    StackFrame javaStackFrame = myStackFrame.getStackFrame();
    if (javaStackFrame != null) {
      myCachedValue = ValueUtil.getInstance().fromJDI(javaStackFrame.getValue(myLocalVariable), classFqName, threadReference);
    }
  }

  public LocalVariable getLocalVariable() {
    return myLocalVariable;
  }

  @Override
  public String getName() {
    return myLocalVariable.name();
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
    JavaLocation location = myStackFrame.getLocation();
    if (location == null) {
      return null;
    }
    return TraceInfoUtil.getVar(location.getUnitName(), location.getFileName(), location.getLineNumber(), myLocalVariable.name());
  }

  @Override
  public WatchablesCategory getCategory() {
    return JavaWatchablesCategory.LOCAL_VARIABLE;
  }
}
