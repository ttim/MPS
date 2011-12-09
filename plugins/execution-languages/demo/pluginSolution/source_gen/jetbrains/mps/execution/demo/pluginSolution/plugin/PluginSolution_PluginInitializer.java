package jetbrains.mps.execution.demo.pluginSolution.plugin;

/*Generated by MPS */

import com.intellij.openapi.components.ApplicationComponent;
import jetbrains.mps.plugins.PluginLibrariesContributor;
import jetbrains.mps.plugins.PluginFactoriesRegistry;
import jetbrains.mps.plugins.PluginContributor;
import jetbrains.mps.plugins.applicationplugins.BaseApplicationPlugin;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class PluginSolution_PluginInitializer implements ApplicationComponent {
  private final PluginLibrariesContributor myContributor = new PluginLibrariesContributor("jetbrains.mps.execution.demo.pluginSolution.plugin.PluginSolution_PluginInitializer", "libraries");

  public PluginSolution_PluginInitializer() {
    PluginFactoriesRegistry.registerPluginFactory(new PluginContributor() {
      public BaseApplicationPlugin createApplicationPlugin() {
        return new PluginSolution_ApplicationPlugin();
      }
    });
  }

  @NonNls
  @NotNull
  public String getComponentName() {
    // module short names could be the same for different modules => use full name 
    return this.getClass().getName();
  }

  public void initComponent() {
    myContributor.init();
  }

  public void disposeComponent() {
    myContributor.dispose();
  }
}
