package jetbrains.mps.debugger.java.runtime.proxies;

/*Generated by MPS */

import jetbrains.mps.debug.runtime.java.programState.proxies.JavaValue;
import com.sun.jdi.Value;
import com.sun.jdi.ThreadReference;
import java.util.List;
import jetbrains.mps.debug.api.programState.IWatchable;
import java.util.ArrayList;
import javax.swing.Icon;
import jetbrains.mps.debug.integration.ui.icons.Icons;
import jetbrains.mps.debug.evaluation.proxies.MirrorUtil;

/*package*/ class JavaPrimitiveValue extends JavaValue {
  public JavaPrimitiveValue(Value value, String classFQname, ThreadReference threadReference) {
    super(value, classFQname, threadReference);
  }

  @Override
  public List<IWatchable> getSubvalues() {
    return new ArrayList<IWatchable>();
  }

  @Override
  public Icon getPresentationIcon() {
    return Icons.VARIABLE_PRIMITIVE;
  }

  @Override
  public boolean isStructure() {
    return false;
  }

  @Override
  public String getValuePresentation() {
    if (myValue == null) {
      return "null";
    }
    return myValue.toString();
  }

  public Object getJavaValue() {
    if (myValue == null) {
      return null;
    }
    return MirrorUtil.getInstance().getJavaValue(myValue);
  }
}
