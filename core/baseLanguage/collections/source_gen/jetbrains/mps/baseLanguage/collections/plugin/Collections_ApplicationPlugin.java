package jetbrains.mps.baseLanguage.collections.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.applicationplugins.BaseApplicationPlugin;
import java.util.List;
import jetbrains.mps.plugins.pluginparts.custom.BaseCustomApplicationPlugin;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;

public class Collections_ApplicationPlugin extends BaseApplicationPlugin {
  public List<BaseCustomApplicationPlugin> initCustomParts() {
    List<BaseCustomApplicationPlugin> res = ListSequence.fromList(new ArrayList<BaseCustomApplicationPlugin>());
    this.addCustomPart(res, new Collections_CustomApplicationPlugin());
    this.addCustomPart(res, new SampleCustomContainers_CustomApplicationPlugin());
    return res;
  }

  private void addCustomPart(List<BaseCustomApplicationPlugin> plugins, BaseCustomApplicationPlugin plugin) {
    ListSequence.fromList(plugins).addElement(plugin);
    plugin.init();
  }
}
