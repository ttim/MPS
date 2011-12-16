package jetbrains.mps.execution.configurations.implementation.plugin.plugin;

/*Generated by MPS */

import com.intellij.openapi.components.ApplicationComponent;
import jetbrains.mps.plugins.PluginFactoriesRegistry;
import jetbrains.mps.plugins.AbstractPluginFactory;
import jetbrains.mps.plugins.applicationplugins.BaseApplicationPlugin;
import jetbrains.mps.plugins.projectplugins.BaseProjectPlugin;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class Plugin_PluginInitializer implements ApplicationComponent {
  public Plugin_PluginInitializer() {
    PluginFactoriesRegistry.registerPluginFactory(new AbstractPluginFactory() {
      @SuppressWarnings("unchecked")
      public <T> T create(Class<T> klass) {
        if (BaseApplicationPlugin.class == klass) {
          return (T) new Plugin_ApplicationPlugin();
        }
        if (BaseProjectPlugin.class == klass) {
          return (T) new Plugin_ProjectPlugin();
        }
        return null;
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
