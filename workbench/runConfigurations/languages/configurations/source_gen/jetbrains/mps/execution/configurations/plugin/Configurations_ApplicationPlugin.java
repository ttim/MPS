package jetbrains.mps.execution.configurations.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.applicationplugins.BaseApplicationPlugin;
import com.intellij.openapi.extensions.PluginId;

public class Configurations_ApplicationPlugin extends BaseApplicationPlugin {
  private PluginId myId = PluginId.getId("jetbrains.mps.execution.configurations");

  public Configurations_ApplicationPlugin() {
  }

  public PluginId getId() {
    return myId;
  }
}
