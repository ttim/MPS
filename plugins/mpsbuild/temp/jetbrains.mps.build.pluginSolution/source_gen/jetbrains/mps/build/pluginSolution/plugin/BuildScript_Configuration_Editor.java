package jetbrains.mps.build.pluginSolution.plugin;

/*Generated by MPS */

import jetbrains.mps.execution.api.settings.SettingsEditorEx;
import jetbrains.mps.execution.lib.ui.MainNodeChooser;
import jetbrains.mps.execution.lib.Node_Configuration_Editor;
import jetbrains.mps.ant.execution.AntSettings_Configuration_Editor;
import com.intellij.openapi.util.Disposer;
import org.jetbrains.annotations.NotNull;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import jetbrains.mps.ide.common.LayoutUtil;
import com.intellij.openapi.options.ConfigurationException;

public class BuildScript_Configuration_Editor extends SettingsEditorEx<BuildScript_Configuration> {
  private MainNodeChooser myChooser;
  private Node_Configuration_Editor myNode;
  private AntSettings_Configuration_Editor mySettings;

  public BuildScript_Configuration_Editor(Node_Configuration_Editor node, AntSettings_Configuration_Editor settings) {
    myNode = node;
    mySettings = settings;
  }

  public void disposeEditor() {
    myChooser.dispose();
    Disposer.dispose(myNode);
    Disposer.dispose(mySettings);
  }

  @NotNull
  public JPanel createEditor() {
    JPanel panel = new JPanel(new GridBagLayout());

    myChooser = myNode.createEditor();
    panel.add(new JLabel("Build Project:"), LayoutUtil.createLabelConstraints(0));
    panel.add(myChooser, LayoutUtil.createFieldConstraints(1));

    JPanel settings = mySettings.createEditor();
    panel.add(settings, LayoutUtil.createPanelConstraints(2));

    return panel;
  }

  public void applyEditorTo(final BuildScript_Configuration configuration) throws ConfigurationException {
    myNode.applyEditorTo(configuration.getNode());
    mySettings.applyEditorTo(configuration.getSettings());
  }

  public void resetEditorFrom(final BuildScript_Configuration configuration) {
    myNode.resetEditorFrom(configuration.getNode());
    mySettings.resetEditorFrom(configuration.getSettings());
  }
}
