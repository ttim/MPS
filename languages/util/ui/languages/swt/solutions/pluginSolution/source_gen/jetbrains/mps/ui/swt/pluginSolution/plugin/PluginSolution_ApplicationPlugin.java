package jetbrains.mps.ui.swt.pluginSolution.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.applicationplugins.BaseApplicationPlugin;
import com.intellij.openapi.extensions.PluginId;
import java.util.List;
import jetbrains.mps.plugins.custom.BaseCustomApplicationPlugin;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;

public class PluginSolution_ApplicationPlugin extends BaseApplicationPlugin {
  private PluginId myId = PluginId.getId("jetbrains.mps.ui.swt.pluginSolution");

  public PluginSolution_ApplicationPlugin() {
  }

  public PluginId getId() {
    return myId;
  }

  public List<BaseCustomApplicationPlugin> initCustomParts() {
    List<BaseCustomApplicationPlugin> res = ListSequence.fromList(new ArrayList<BaseCustomApplicationPlugin>());
    {
      BaseCustomApplicationPlugin plugin = new EditorExtension_CustomApplicationPlugin();
      ListSequence.fromList(res).addElement(plugin);
      plugin.init();
    }
    {
      BaseCustomApplicationPlugin plugin = new Variant_CustomApplicationPlugin();
      ListSequence.fromList(res).addElement(plugin);
      plugin.init();
    }
    return res;
  }
}
