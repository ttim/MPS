package jetbrains.mps.execution.languages.plugin;

/*Generated by MPS */

import com.intellij.openapi.components.ApplicationComponent;
import jetbrains.mps.plugins.PluginUtil;
import jetbrains.mps.plugins.PluginContributor;
import jetbrains.mps.plugins.applicationplugins.BaseApplicationPlugin;
import jetbrains.mps.plugins.projectplugins.BaseProjectPlugin;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class Languages_PluginInitializer implements ApplicationComponent {
  public Languages_PluginInitializer() {
    PluginUtil.addPluginContributor(new PluginContributor() {
      public BaseApplicationPlugin createApplicationPlugin() {
        return new Languages_ApplicationPlugin();
      }

      public BaseProjectPlugin createProjectPlugin() {
        return new Languages_ProjectPlugin();
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
