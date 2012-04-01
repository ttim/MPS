package jetbrains.mps.baseLanguage.pluginSolution.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.projectplugins.BaseProjectPlugin;
import java.util.List;
import jetbrains.mps.plugins.custom.BaseCustomProjectPlugin;
import com.intellij.openapi.project.Project;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.project.MPSProject;

public class PluginSolution_ProjectPlugin extends BaseProjectPlugin {
  public PluginSolution_ProjectPlugin() {
  }

  public List<BaseCustomProjectPlugin> initCustomParts(Project project) {
    List<BaseCustomProjectPlugin> res = ListSequence.fromList(new ArrayList<BaseCustomProjectPlugin>());
    MPSProject mpsProject = project.getComponent(MPSProject.class);
    {
      BaseCustomProjectPlugin plugin = new BaseLanguageCustomPlugin_CustomProjectPlugin();
      ListSequence.fromList(res).addElement(plugin);
      plugin.init(mpsProject);
    }
    return res;
  }
}
