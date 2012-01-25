package jetbrains.mps.execution.configurations.implementation.plugin.plugin;

/*Generated by MPS */

import jetbrains.mps.execution.api.settings.SettingsEditorEx;
import jetbrains.mps.execution.lib.ui.MainNodeChooser;
import jetbrains.mps.execution.lib.Node_Configuration_Editor;
import com.intellij.openapi.util.Disposer;
import org.jetbrains.annotations.NotNull;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import jetbrains.mps.ide.common.LayoutUtil;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import com.intellij.openapi.options.ConfigurationException;

public class BuildLanguageProject_Configuration_Editor extends SettingsEditorEx<BuildLanguageProject_Configuration> {
  private MainNodeChooser myChooser;
  private TargetChoosePanel myTargetChooser;
  private Node_Configuration_Editor myNode;
  private AntSettings_Configuration_Editor mySettings;

  public BuildLanguageProject_Configuration_Editor(Node_Configuration_Editor node, AntSettings_Configuration_Editor settings) {
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
    panel.add(new JLabel("Project:"), LayoutUtil.createLabelConstraints(0));
    panel.add(myChooser, LayoutUtil.createFieldConstraints(1));
    myTargetChooser = new TargetChoosePanel();
    myChooser.addNodeChangeListener(new _FunctionTypes._void_P1_E0<SNode>() {
      public void invoke(SNode project) {
        myTargetChooser.nodeChanged(SNodeOperations.cast(project, "jetbrains.mps.buildlanguage.structure.Project"));
      }
    });
    panel.add(myTargetChooser, LayoutUtil.createPanelConstraints(2));
    panel.add(mySettings.createEditor(), LayoutUtil.createPanelConstraints(3));

    return panel;
  }

  public void applyEditorTo(final BuildLanguageProject_Configuration configuration) throws ConfigurationException {
    myNode.applyEditorTo(configuration.getNode());
    mySettings.applyEditorTo(configuration.getSettings());
    configuration.setTargetId(myTargetChooser.getChildId());
  }

  public void resetEditorFrom(final BuildLanguageProject_Configuration configuration) {
    myNode.resetEditorFrom(configuration.getNode());
    mySettings.resetEditorFrom(configuration.getSettings());
    myTargetChooser.reset(SNodeOperations.cast(configuration.getNode().getNode(), "jetbrains.mps.buildlanguage.structure.Project"), configuration.getTargetId());
  }
}
