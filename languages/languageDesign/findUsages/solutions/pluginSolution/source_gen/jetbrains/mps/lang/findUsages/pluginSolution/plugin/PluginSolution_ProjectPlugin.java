package jetbrains.mps.lang.findUsages.pluginSolution.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.projectplugins.BaseProjectPlugin;
import java.util.List;
import jetbrains.mps.ide.editorTabs.EditorTabDescriptor;
import com.intellij.openapi.project.Project;
import java.util.ArrayList;

public class PluginSolution_ProjectPlugin extends BaseProjectPlugin {
  public PluginSolution_ProjectPlugin() {
  }

  public List<EditorTabDescriptor> initTabbedEditors(Project project) {
    List<EditorTabDescriptor> result = new ArrayList();
    result.add(new Find_Usages_TabDescriptor());
    return result;
  }
}
