package jetbrains.mps.build.deprecated.execution;

/*Generated by MPS */

import jetbrains.mps.execution.api.settings.SettingsEditorEx;
import jetbrains.mps.execution.lib.ui.NodeByConceptChooser;
import jetbrains.mps.execution.lib.NodeByConcept_Configuration_Editor;
import jetbrains.mps.ant.execution.AntSettings_Configuration_Editor;
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

public class PackagingBuildScript_Configuration_Editor extends SettingsEditorEx<PackagingBuildScript_Configuration> {
  private ConfigurationChoosePanel myConfigurationChoosePanel = new ConfigurationChoosePanel();
  private NodeByConceptChooser myChooser;
  private NodeByConcept_Configuration_Editor myNode;
  private AntSettings_Configuration_Editor mySettings;

  public PackagingBuildScript_Configuration_Editor(NodeByConcept_Configuration_Editor node, AntSettings_Configuration_Editor settings) {
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

    panel.add(new JLabel("Packaging build script:"), LayoutUtil.createLabelConstraints(0));
    myChooser = myNode.createEditor();
    panel.add(myChooser, LayoutUtil.createPanelConstraints(1));

    panel.add(myConfigurationChoosePanel, LayoutUtil.createPanelConstraints(2));
    panel.add(mySettings.createEditor(), LayoutUtil.createPanelConstraints(3));

    myChooser.addNodeChangeListener(new _FunctionTypes._void_P1_E0<SNode>() {
      public void invoke(SNode node) {
        myConfigurationChoosePanel.nodeChanged(SNodeOperations.cast(node, "jetbrains.mps.build.packaging.structure.Layout"));
      }
    });

    return panel;
  }

  public void applyEditorTo(final PackagingBuildScript_Configuration configuration) throws ConfigurationException {
    myNode.applyEditorTo(configuration.getNode());
    mySettings.applyEditorTo(configuration.getSettings());
    configuration.setConfigurationId(myConfigurationChoosePanel.getChildId());
  }

  public void resetEditorFrom(final PackagingBuildScript_Configuration configuration) {
    myNode.resetEditorFrom(configuration.getNode());
    mySettings.resetEditorFrom(configuration.getSettings());
    myConfigurationChoosePanel.reset(SNodeOperations.cast(configuration.getNode().getNode(), "jetbrains.mps.build.packaging.structure.Layout"), configuration.getConfigurationId());
  }
}
