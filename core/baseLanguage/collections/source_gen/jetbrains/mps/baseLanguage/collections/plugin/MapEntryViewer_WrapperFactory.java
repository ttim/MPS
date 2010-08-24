package jetbrains.mps.baseLanguage.collections.plugin;

/*Generated by MPS */

import jetbrains.mps.debug.runtime.java.programState.proxies.ValueWrapperFactory;
import jetbrains.mps.debug.runtime.java.programState.proxies.ValueWrapper;
import jetbrains.mps.debug.runtime.java.programState.proxies.JavaValue;
import org.jetbrains.annotations.NotNull;
import com.sun.jdi.Value;
import jetbrains.mps.debug.evaluation.EvaluationUtils;
import jetbrains.mps.debug.evaluation.EvaluationException;
import jetbrains.mps.debug.evaluation.EvaluationRuntimeException;
import java.util.List;
import jetbrains.mps.debug.runtime.java.programState.watchables.CustomJavaWatchable;
import jetbrains.mps.debug.evaluation.proxies.IObjectValueProxy;
import java.util.ArrayList;
import jetbrains.mps.debug.runtime.java.programState.proxies.JavaObjectValue;

public class MapEntryViewer_WrapperFactory extends ValueWrapperFactory {
  public MapEntryViewer_WrapperFactory() {
  }

  public ValueWrapper createValueWrapper(JavaValue value) {
    return new MapEntryViewer_WrapperFactory.MapEntryViewerWrapper(value);
  }

  @Override
  public boolean canWrapValue(@NotNull JavaValue javaValue) {
    try {
      Value value = javaValue.getValue();
      if (value == null) {
        return false;
      }
      if (!(EvaluationUtils.isInstanceOf(value.type(), "Ljava.util.Map$Entry;", value.virtualMachine()))) {
        return false;
      }
      return true;
    } catch (EvaluationException e) {
      throw new EvaluationRuntimeException(e);
    }
  }

  public static class MapEntryViewerWrapper extends ValueWrapper {
    public MapEntryViewerWrapper(JavaValue value) {
      super(value);
    }

    protected List<CustomJavaWatchable> getSubvaluesImpl() {
      try {
        return getSubvaluesImpl((IObjectValueProxy) myValueProxy);
      } catch (EvaluationException e) {
        throw new EvaluationRuntimeException(e);
      }
    }

    protected List<CustomJavaWatchable> getSubvaluesImpl(IObjectValueProxy value) throws EvaluationException {
      List<CustomJavaWatchable> result = new ArrayList<CustomJavaWatchable>();
      IObjectValueProxy key = ((IObjectValueProxy) value.invokeMethod("getKey", "()Ljava/lang/Object;"));
      IObjectValueProxy entryValue = ((IObjectValueProxy) value.invokeMethod("getValue", "()Ljava/lang/Object;"));
      result.add(new CollectionsWatchables.MyWatchable_key(JavaObjectValue.fromJDIValue(key.getJDIValue(), getThreadReference()), "key"));
      result.add(new CollectionsWatchables.MyWatchable_value(JavaObjectValue.fromJDIValue(entryValue.getJDIValue(), getThreadReference()), "value"));
      return result;
    }

    public String getValuePresentation() {
      try {
        return getValuePresentation((IObjectValueProxy) myValueProxy);
      } catch (EvaluationException e) {
        throw new EvaluationRuntimeException(e);
      }
    }

    protected String getValuePresentation(IObjectValueProxy value) throws EvaluationException {
      IObjectValueProxy key = ((IObjectValueProxy) value.invokeMethod("getKey", "()Ljava/lang/Object;"));
      IObjectValueProxy entryValue = ((IObjectValueProxy) value.invokeMethod("getValue", "()Ljava/lang/Object;"));
      return "[" + (String) (key).invokeMethod("toString", "()Ljava/lang/String;").getJavaValue() + "] = " + (String) (entryValue).invokeMethod("toString", "()Ljava/lang/String;").getJavaValue();
    }
  }
}
