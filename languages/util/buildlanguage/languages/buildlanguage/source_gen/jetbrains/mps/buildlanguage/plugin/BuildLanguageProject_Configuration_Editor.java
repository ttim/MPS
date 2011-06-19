package jetbrains.mps.buildlanguage.plugin;

/*Generated by MPS */

import jetbrains.mps.execution.api.settings.SettingsEditorEx;
import javax.swing.JCheckBox;
import jetbrains.mps.baseLanguage.runConfigurations.runtime.FieldWithPathChooseDialog;
import jetbrains.mps.baseLanguage.runConfigurations.runtime.MainNodeChooser;
import jetbrains.mps.execution.configurations.lib.Node_Configuration_Editor;
import com.intellij.openapi.util.Disposer;
import org.jetbrains.annotations.NotNull;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import jetbrains.mps.ide.common.LayoutUtil;
import com.intellij.openapi.options.ConfigurationException;

public class BuildLanguageProject_Configuration_Editor extends SettingsEditorEx<BuildLanguageProject_Configuration> {
  private JCheckBox myUseAlternativeAnt;
  private FieldWithPathChooseDialog myAlternativeAnt;
  private MainNodeChooser myChooser;
  private Node_Configuration_Editor myNode;

  public BuildLanguageProject_Configuration_Editor(Node_Configuration_Editor node) {
    myNode = node;
  }

  public void disposeEditor() {
    myChooser.dispose();
    Disposer.dispose(myNode);
  }

  @NotNull
  public JPanel createEditor() {
    JPanel panel = new JPanel(new GridBagLayout());

    myChooser = myNode.createEditor();

    panel.add(new JLabel("Project:"), LayoutUtil.createLabelConstraints(0));
    panel.add(myChooser, LayoutUtil.createFieldConstraints(1));

    myUseAlternativeAnt = new JCheckBox("Use alternative Ant location");
    panel.add(myUseAlternativeAnt, LayoutUtil.createLabelConstraints(2));
    myAlternativeAnt = new FieldWithPathChooseDialog();
    panel.add(myAlternativeAnt, LayoutUtil.createFieldConstraints(3));

    return panel;
  }

  public void applyEditorTo(final BuildLanguageProject_Configuration configuration) throws ConfigurationException {
    myNode.applyEditorTo(configuration.getNode());
    configuration.setUseOtherAntLocation(myUseAlternativeAnt.isSelected());
    configuration.setOtherAntLocation(myAlternativeAnt.getText());
  }

  public void resetEditorFrom(final BuildLanguageProject_Configuration configuration) {
    myNode.resetEditorFrom(configuration.getNode());
    myUseAlternativeAnt.setSelected(configuration.getUseOtherAntLocation());
    myAlternativeAnt.setText(configuration.getOtherAntLocation());
  }
}
