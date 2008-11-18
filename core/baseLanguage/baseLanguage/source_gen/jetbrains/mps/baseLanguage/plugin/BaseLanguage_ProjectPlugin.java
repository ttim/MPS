package jetbrains.mps.baseLanguage.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.projectplugins.BaseProjectPlugin;

import java.util.List;

import jetbrains.mps.plugins.pluginparts.tool.GeneratedTool;
import com.intellij.openapi.project.Project;

import java.util.ArrayList;

import jetbrains.mps.plugins.pluginparts.custom.BaseCustomProjectPlugin;
import jetbrains.mps.project.MPSProject;
import jetbrains.mps.generator.fileGenerator.IFileGenerator;

public class BaseLanguage_ProjectPlugin extends BaseProjectPlugin {

  public List<GeneratedTool> initTools(Project project) {
    List<GeneratedTool> tools = new ArrayList<GeneratedTool>();
    tools.add(new RunClass_Tool(project));
    tools.add(new TodoViewer_Tool(project));
    return tools;
  }

  public List<BaseCustomProjectPlugin> initCustomParts(MPSProject project) {
    List<BaseCustomProjectPlugin> res = new ArrayList<BaseCustomProjectPlugin>();
    {
      BaseCustomProjectPlugin plugin = new BaseLanguageCustomPlugin_CustomProjectPlugin();
      res.add(plugin);
      plugin.init(project);
    }
    return res;
  }

  public IFileGenerator initFileGenerator() {
    return new GeneratedFileGeneratorPlugin().getFileGenerator();
  }

}
