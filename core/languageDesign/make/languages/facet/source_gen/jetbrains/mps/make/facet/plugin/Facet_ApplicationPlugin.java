package jetbrains.mps.make.facet.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.applicationplugins.BaseApplicationPlugin;
import com.intellij.openapi.extensions.PluginId;
import java.util.List;
import jetbrains.mps.plugins.pluginparts.custom.BaseCustomApplicationPlugin;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;

public class Facet_ApplicationPlugin extends BaseApplicationPlugin {
  private PluginId myId = PluginId.getId("jetbrains.mps.make.facet");

  public Facet_ApplicationPlugin() {
  }

  public PluginId getId() {
    return myId;
  }

  public List<BaseCustomApplicationPlugin> initCustomParts() {
    List<BaseCustomApplicationPlugin> res = ListSequence.fromList(new ArrayList<BaseCustomApplicationPlugin>());
    addCustomPart(res, new Facets_CustomApplicationPlugin());
    return res;
  }

  private void addCustomPart(List<BaseCustomApplicationPlugin> plugins, BaseCustomApplicationPlugin plugin) {
    ListSequence.fromList(plugins).addElement(plugin);
    plugin.init();
  }
}
