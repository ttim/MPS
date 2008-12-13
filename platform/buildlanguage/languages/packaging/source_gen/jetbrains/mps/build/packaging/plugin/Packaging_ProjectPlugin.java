package jetbrains.mps.build.packaging.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.projectplugins.BaseProjectPlugin;
import java.util.List;
import jetbrains.mps.plugins.pluginparts.tool.GeneratedTool;
import com.intellij.openapi.project.Project;
import java.util.ArrayList;
import jetbrains.mps.plugins.pluginparts.prefs.BaseProjectPrefsComponent;

public class Packaging_ProjectPlugin extends BaseProjectPlugin {

  public List<GeneratedTool> initTools(Project project) {
    List<GeneratedTool> tools = new ArrayList<GeneratedTool>();
    tools.add(new BuildTool_Tool(project));
    return tools;
  }

  public List<BaseProjectPrefsComponent> createPreferencesComponents(Project project) {
    List<BaseProjectPrefsComponent> components = new ArrayList<BaseProjectPrefsComponent>();
    components.add(new PackagingRunnerPreferences_PreferencesComponent(project));
    return components;
  }

}
