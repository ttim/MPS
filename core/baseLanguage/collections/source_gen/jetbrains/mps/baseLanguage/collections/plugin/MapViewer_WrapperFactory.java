package jetbrains.mps.baseLanguage.collections.plugin;

/*Generated by MPS */

import jetbrains.mps.debug.runtime.java.programState.proxies.ValueWrapperFactory;
import jetbrains.mps.debug.runtime.java.programState.proxies.ValueWrapper;
import jetbrains.mps.debug.runtime.java.programState.proxies.JavaValue;
import jetbrains.mps.debug.evaluation.EvaluationUtils;
import jetbrains.mps.debug.evaluation.EvaluationException;
import java.util.List;
import jetbrains.mps.debug.runtime.java.programState.watchables.CustomJavaWatchable;
import jetbrains.mps.debug.evaluation.proxies.IObjectValueProxy;
import java.util.ArrayList;
import jetbrains.mps.debug.evaluation.proxies.PrimitiveValueProxy;
import jetbrains.mps.debug.runtime.java.programState.proxies.JavaObjectValue;

public class MapViewer_WrapperFactory extends ValueWrapperFactory {
  public MapViewer_WrapperFactory() {
  }

  public ValueWrapper createValueWrapper(JavaValue value) {
    return new MapViewer_WrapperFactory.MapViewerWrapper(value);
  }

  @Override
  public boolean canWrapValue(JavaValue value) {
    try {
      if (!(EvaluationUtils.isInstanceOf(value.getValue().type(), "Ljava/util/Map;", value.getValue().virtualMachine()))) {
        return false;
      }
      return true;
    } catch (EvaluationException e) {
      throw new RuntimeException(e);
    }
  }

  public static class MapViewerWrapper extends ValueWrapper {
    public MapViewerWrapper(JavaValue value) {
      super(value);
    }

    protected List<CustomJavaWatchable> getSubvaluesImpl() {
      try {
        return getSubvaluesImpl((IObjectValueProxy) myValueProxy);
      } catch (EvaluationException e) {
        throw new RuntimeException(e);
        // todo throw something normal 
      }
    }

    protected List<CustomJavaWatchable> getSubvaluesImpl(IObjectValueProxy value) throws EvaluationException {
      List<CustomJavaWatchable> result = new ArrayList<CustomJavaWatchable>();

      PrimitiveValueProxy size = ((PrimitiveValueProxy) value.invokeMethod("size", "()I"));
      result.add(new CollectionsWatchables.MyWatchable_size(JavaObjectValue.fromJDIValue(size.getJDIValue(), getThreadReference()), "size"));

      IObjectValueProxy entries = ((IObjectValueProxy) value.invokeMethod("entrySet", "()Ljava/util/Set;"));
      for (IObjectValueProxy entry : EvaluationUtils.<IObjectValueProxy>toIterable(entries)) {
        result.add(new CollectionsWatchables.MyWatchable_entry(JavaObjectValue.fromJDIValue(entry.getJDIValue(), getThreadReference()), "entry"));
      }

      return result;
    }
  }
}
