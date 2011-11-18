package jetbrains.mps.baseLanguage.unitTest.execution.plugin;

/*Generated by MPS */

import com.intellij.openapi.components.ApplicationComponent;
import jetbrains.mps.plugins.PluginUtil;
import jetbrains.mps.plugins.PluginContributor;
import jetbrains.mps.plugins.applicationplugins.BaseApplicationPlugin;
import jetbrains.mps.plugins.projectplugins.BaseProjectPlugin;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class Execution_PluginInitializer implements ApplicationComponent {
  public Execution_PluginInitializer() {
    PluginUtil.addPluginContributor(new PluginContributor() {
      public BaseApplicationPlugin createApplicationPlugin() {
        return new Execution_ApplicationPlugin();
      }

      public BaseProjectPlugin createProjectPlugin() {
        return new Execution_ProjectPlugin();
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
  }

  public void disposeComponent() {
  }
}
