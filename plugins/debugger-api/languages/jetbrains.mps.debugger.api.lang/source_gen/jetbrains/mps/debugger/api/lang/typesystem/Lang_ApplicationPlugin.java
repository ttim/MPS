package jetbrains.mps.debugger.api.lang.typesystem;

/*Generated by MPS */

import jetbrains.mps.plugins.applicationplugins.BaseApplicationPlugin;
import com.intellij.openapi.extensions.PluginId;

public class Lang_ApplicationPlugin extends BaseApplicationPlugin {
  private PluginId myId = PluginId.getId("jetbrains.mps.debugger.api.lang");

  public Lang_ApplicationPlugin() {
  }

  public PluginId getId() {
    return myId;
  }
}
