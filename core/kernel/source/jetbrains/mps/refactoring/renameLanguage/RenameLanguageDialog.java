package jetbrains.mps.refactoring.renameLanguage;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Computable;
import jetbrains.mps.MPSProjectHolder;
import jetbrains.mps.generator.GeneratorManager;
import jetbrains.mps.generator.IGenerationType;
import jetbrains.mps.ide.dialogs.BaseDialog;
import jetbrains.mps.ide.dialogs.DialogDimensionsSettings.DialogDimensions;
import jetbrains.mps.ide.genconf.GenParameters;
import jetbrains.mps.project.AuxilaryRuntimeModel;
import jetbrains.mps.project.MPSProject;
import jetbrains.mps.project.ModuleContext;
import jetbrains.mps.project.structure.testconfigurations.ModuleTestConfiguration;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.smodel.MPSModuleRepository;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.smodel.SModel;

import javax.swing.*;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;

public class RenameLanguageDialog extends BaseDialog {
  private JPanel myMainPanel;
  private JTextField myLanguageNameField;
  private JCheckBox myRegenerateLanguage;

  private Language myLanguage;
  private Project myProject;

  public RenameLanguageDialog(Frame frame, Project project, Language language) throws HeadlessException {
    super(frame);

    setTitle("Rename Language");

    myLanguage = language;
    myProject = project;

    myMainPanel = new JPanel(new GridBagLayout());

    GridBagConstraints c;

    c = new GridBagConstraints();
    c.gridx = 0;
    c.gridy = 0;
    c.anchor = GridBagConstraints.FIRST_LINE_START;
    myMainPanel.add(new JLabel("Language name:"), c);


    c = new GridBagConstraints();
    c.gridx = 0;
    c.gridy = 1;
    c.anchor = GridBagConstraints.FIRST_LINE_START;
    myLanguageNameField = new JTextField(myLanguage.getModuleFqName(), 30);
    myMainPanel.add(myLanguageNameField, c);


    c = new GridBagConstraints();
    c.gridx = 0;
    c.gridy = 2;
    c.anchor = GridBagConstraints.FIRST_LINE_START;
    myRegenerateLanguage = new JCheckBox("Regenerate Language");
    myRegenerateLanguage.getModel().setSelected(!myLanguage.isBootstrap());
    myMainPanel.add(myRegenerateLanguage, c);


    c = new GridBagConstraints();
    c.gridx = 0;
    c.gridy = 3;
    c.weighty = 1.0;
    c.weightx = 1.0;
    myMainPanel.add(new JPanel(), c);
  }

  protected JComponent getMainComponent() {
    return myMainPanel;
  }

  public DialogDimensions getDefaultDimensionSettings() {
    return new DialogDimensions(300, 300, 300, 200);
  }

  @BaseDialog.Button(position = 0, name = "OK", defaultButton = true)
  public void buttonOk() {
    final boolean needToRegenerate = myRegenerateLanguage.getModel().isSelected();

    boolean renamed = ModelAccess.instance().runWriteActionInCommand(new Computable<Boolean>() {
      public Boolean compute() {
        final String fqName = myLanguageNameField.getText();

        if (MPSModuleRepository.getInstance().getModuleByUID(fqName) != null) {
          setErrorText("Duplicate language name");
          return false;
        }

        new LanguageRenamer(myProject, myLanguage, fqName).rename(needToRegenerate);
        return true;
      }
    });

    if (!renamed) {
      return;
    }

    if (needToRegenerate) {
      final MPSProject mpsProject = myProject.getComponent(MPSProjectHolder.class).getMPSProject();
      GenParameters params = ModelAccess.instance().runReadAction(new Computable<GenParameters>() {
        public GenParameters compute() {
          SModel model = AuxilaryRuntimeModel.getDescriptor().getSModel();

          ModuleTestConfiguration languageConfig = new ModuleTestConfiguration();
          languageConfig.setModuleRef(myLanguage.getModuleReference());
          languageConfig.setName("tmp");

          return languageConfig.getGenParams(mpsProject, true);
        }
      });


      myProject.getComponent(GeneratorManager.class)
        .generateModelsFromDifferentModules(
          new ModuleContext(myLanguage, mpsProject),
          params.getModels(),
          IGenerationType.FILES);
    }

    dispose();
  }



  @BaseDialog.Button(position = 1, name = "Cancel")
  public void buttonCancel() {
    dispose();
  }
}
