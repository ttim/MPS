package jetbrains.mps.ide.refactoring;

/*Generated by MPS */

import jetbrains.mps.ide.dialogs.BaseDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import jetbrains.mps.smodel.Language;
import com.intellij.openapi.project.Project;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.util.Computable;
import javax.swing.JComponent;
import jetbrains.mps.ide.dialogs.DialogDimensionsSettings;
import jetbrains.mps.smodel.MPSModuleRepository;
import javax.lang.model.SourceVersion;
import jetbrains.mps.refactoring.renameLanguage.LanguageRenamer;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.progress.Task;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.progress.ProgressIndicator;
import java.util.Set;
import java.util.LinkedHashSet;
import jetbrains.mps.generator.GenParameters;
import jetbrains.mps.project.structure.project.testconfigurations.ModuleTestConfiguration;
import jetbrains.mps.project.MPSProject;
import jetbrains.mps.project.structure.project.testconfigurations.IllegalGeneratorConfigurationException;
import jetbrains.mps.project.ModuleContext;
import jetbrains.mps.ide.project.ProjectHelper;
import jetbrains.mps.make.MakeSession;
import jetbrains.mps.make.IMakeService;
import jetbrains.mps.smodel.resources.ModelsToResources;

public class RenameLanguageDialog extends BaseDialog {
  private JPanel myMainPanel;
  private JTextField myLanguageNameField;
  private JCheckBox myRegenerateLanguage;
  private Language myLanguage;
  private Project myProject;

  public RenameLanguageDialog(Frame frame, Project project, Language language) throws HeadlessException {
    super(frame);
    myLanguage = language;
    myProject = project;
    setTitle("Rename Language");
    myMainPanel = new JPanel(new GridBagLayout());
    GridBagConstraints cLabel = new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
    myMainPanel.add(new JLabel("Language name"), cLabel);
    GridBagConstraints cNameField = new GridBagConstraints(1, 0, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0);
    myLanguageNameField = new JTextField(myLanguage.getModuleFqName(), 30);
    myMainPanel.add(myLanguageNameField, cNameField);
    GridBagConstraints cCheckbox = new GridBagConstraints(0, 1, 2, 1, 1, 1, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
    myRegenerateLanguage = new JCheckBox("Rebuild Language");
    myRegenerateLanguage.getModel().setSelected(ModelAccess.instance().runReadAction(new Computable<Boolean>() {
      public Boolean compute() {
        return !(myLanguage.isBootstrap());
      }
    }));
    myMainPanel.add(myRegenerateLanguage, cCheckbox);
  }

  protected JComponent getMainComponent() {
    return myMainPanel;
  }

  public DialogDimensionsSettings.DialogDimensions getDefaultDimensionSettings() {
    return new DialogDimensionsSettings.DialogDimensions(300, 300, 400, 200);
  }

  @BaseDialog.Button(position = 0, name = "OK", mnemonic = 'O', defaultButton = true)
  public void buttonOk() {
    final boolean needToRegenerate = myRegenerateLanguage.getModel().isSelected();
    final String fqName = myLanguageNameField.getText();
    if (MPSModuleRepository.getInstance().getModuleByFqName(fqName) != null) {
      setErrorText("Duplicate language name");
      return;
    }
    if (!((SourceVersion.isName(fqName)))) {
      setErrorText("Language namespace should be valid Java package");
      return;
    }
    final LanguageRenamer renamer = new LanguageRenamer(myProject, myLanguage, fqName);
    ModelAccess.instance().runWriteActionInCommand(new Runnable() {
      public void run() {
        renamer.rename(needToRegenerate);
      }
    });
    ProgressManager.getInstance().run(new Task.Modal(myProject, "Updating language references...", false) {
      @Override
      public void run(@NotNull ProgressIndicator indicator) {
        indicator.pushState();
        try {
          indicator.setIndeterminate(true);
          ModelAccess.instance().runWriteInEDT(new Runnable() {
            public void run() {
              renamer.update();
            }
          });
        } finally {
          indicator.popState();
        }
      }
    });
    if (needToRegenerate) {
      final Set<Language> langs = new LinkedHashSet<Language>();
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          langs.add(myLanguage);
          langs.addAll(MPSModuleRepository.getInstance().getAllExtendingLanguages(myLanguage));
        }
      });
      for (final Language l : langs) {
        GenParameters params = ModelAccess.instance().runReadAction(new Computable<GenParameters>() {
          public GenParameters compute() {
            ModuleTestConfiguration languageConfig = new ModuleTestConfiguration();
            languageConfig.setModuleRef(l.getModuleReference());
            languageConfig.setName("tmp");
            try {
              return languageConfig.getGenParams(myProject.getComponent(MPSProject.class), true);
            } catch (IllegalGeneratorConfigurationException e) {
              return null;
            }
          }
        });
        if (params == null) {
          setErrorText("Rebuild configuration is invalid");
          return;
        }
        ModuleContext context = new ModuleContext(myLanguage, ProjectHelper.toMPSProject(myProject));
        MakeSession sess = new MakeSession(context);
        if (IMakeService.INSTANCE.get().openNewSession(sess)) {
          IMakeService.INSTANCE.get().make(sess, new ModelsToResources(context, params.getModelDescriptors()).resources(false));
        }
        //         GeneratorUIFacade.getInstance().generateModels(new ModuleContext(myLanguage, myProject), params.getModelDescriptors(), GeneratorUIFacade.getInstance().getDefaultGenerationHandler(), true, false); 
      }
    }
    dispose();
  }

  @BaseDialog.Button(position = 1, name = "Cancel", mnemonic = 'C')
  public void buttonCancel() {
    dispose();
  }
}
