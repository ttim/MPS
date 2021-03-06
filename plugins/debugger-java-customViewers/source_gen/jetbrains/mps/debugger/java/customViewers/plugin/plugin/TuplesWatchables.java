package jetbrains.mps.debugger.java.customViewers.plugin.plugin;

/*Generated by MPS */

import jetbrains.mps.debug.runtime.java.programState.watchables.CustomJavaWatchable;
import jetbrains.mps.debug.api.programState.WatchablesCategory;
import jetbrains.mps.debug.runtime.java.programState.proxies.JavaValue;

public class TuplesWatchables {
  public TuplesWatchables() {
  }

  public static class MyWatchable_element extends CustomJavaWatchable {
    private static WatchablesCategory ourCategory = new WatchablesCategory("element");

    public MyWatchable_element(JavaValue value, String name) {
      super(value, name);
    }

    public WatchablesCategory getCategory() {
      return ourCategory;
    }
  }
}
