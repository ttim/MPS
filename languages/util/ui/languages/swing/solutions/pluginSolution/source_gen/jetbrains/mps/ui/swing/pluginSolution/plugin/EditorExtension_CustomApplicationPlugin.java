package jetbrains.mps.ui.swing.pluginSolution.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.custom.BaseCustomApplicationPlugin;
import jetbrains.mps.ui.modeling.pluginSolution.plugin.EditorExtensionHelper;

public class EditorExtension_CustomApplicationPlugin extends BaseCustomApplicationPlugin {
  private EditorExtensionHelper helper;

  public EditorExtension_CustomApplicationPlugin() {
  }

  public void doInit() {
    EditorExtension_CustomApplicationPlugin.this.helper = new EditorExtensionHelper("jetbrains.mps.ui.swing");
    EditorExtension_CustomApplicationPlugin.this.helper.init();
  }

  public void doDispose() {
    EditorExtension_CustomApplicationPlugin.this.helper.dispose();
    EditorExtension_CustomApplicationPlugin.this.helper = null;
  }
}
