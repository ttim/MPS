package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.projectplugins.BaseProjectPlugin;
import java.util.List;
import jetbrains.mps.plugins.pluginparts.tool.BaseGeneratedTool;
import com.intellij.openapi.project.Project;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.plugins.pluginparts.prefs.BaseProjectPrefsComponent;

public class Ide_ProjectPlugin extends BaseProjectPlugin {
  public Ide_ProjectPlugin() {
  }

  public List<BaseGeneratedTool> initAllTools(Project project) {
    List<BaseGeneratedTool> tools = ListSequence.fromList(new ArrayList<BaseGeneratedTool>());
    ListSequence.fromList(tools).addElement(new AnalyzeDependencies_Tool(project));
    ListSequence.fromList(tools).addElement(new AnalyzeStacktrace_Tool(project));
    return tools;
  }

  public List<BaseProjectPrefsComponent> createPreferencesComponents(Project project) {
    List<BaseProjectPrefsComponent> components = ListSequence.fromList(new ArrayList<BaseProjectPrefsComponent>());
    ListSequence.fromList(components).addElement(new PersistentOptions_PreferencesComponent(project));
    return components;
  }
}
