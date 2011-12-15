package jetbrains.mps.ide.migration.actions;

/*Generated by MPS */

import com.intellij.openapi.components.ApplicationComponent;
import jetbrains.mps.plugins.PluginLibrariesContributor;
import jetbrains.mps.plugins.PluginFactoriesRegistry;
import jetbrains.mps.plugins.AbstractPluginFactory;
import jetbrains.mps.plugins.applicationplugins.BaseApplicationPlugin;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class Migration_PluginInitializer implements ApplicationComponent {
  private final PluginLibrariesContributor myContributor = new PluginLibrariesContributor("jetbrains.mps.ide.migration.actions.Migration_PluginInitializer", "libraries");

  public Migration_PluginInitializer() {
    PluginFactoriesRegistry.registerPluginFactory(new AbstractPluginFactory() {
      @SuppressWarnings("unchecked")
      public <T> T create(Class<T> klass) {
        if (BaseApplicationPlugin.class == klass) {
          return (T) new Migration_ApplicationPlugin();
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
    myContributor.init();
  }

  public void disposeComponent() {
    myContributor.dispose();
  }
}
