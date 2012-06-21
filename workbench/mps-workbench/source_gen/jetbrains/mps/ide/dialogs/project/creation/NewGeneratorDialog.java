package jetbrains.mps.ide.dialogs.project.creation;

/*Generated by MPS */

import jetbrains.mps.ide.dialogs.BaseDialog;
import jetbrains.mps.ide.dialogs.DialogDimensionsSettings;
import javax.swing.JPanel;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import javax.swing.JTextField;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.smodel.Generator;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.GridBagLayout;
import javax.swing.JComponent;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import jetbrains.mps.ide.ui.filechoosers.treefilechooser.TreeFileChooser;
import jetbrains.mps.vfs.FileSystem;
import jetbrains.mps.vfs.IFile;
import java.io.File;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.ide.DataManager;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.ide.newSolutionDialog.NewModuleUtil;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import com.intellij.openapi.util.Disposer;
import jetbrains.mps.project.structure.modules.LanguageDescriptor;
import jetbrains.mps.project.structure.modules.GeneratorDescriptor;
import jetbrains.mps.project.structure.model.ModelRoot;
import jetbrains.mps.smodel.MPSModuleRepository;
import jetbrains.mps.project.ModuleId;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.SModelStereotype;
import jetbrains.mps.smodel.descriptor.EditableSModelDescriptor;
import jetbrains.mps.smodel.SModelFqName;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;

public class NewGeneratorDialog extends BaseDialog {
  private static final DialogDimensionsSettings.DialogDimensions ourDefaultDimensionSettings = new DialogDimensionsSettings.DialogDimensions(200, 200, 400, 200);

  private JPanel myContenetPane;
  private TextFieldWithBrowseButton myTemplateModelsDir;
  private JTextField myGeneratorName;
  private Language mySourceLanguage;
  private Generator myResult;

  public NewGeneratorDialog(Frame mainFrame, Language sourceLanguage) throws HeadlessException {
    super(mainFrame, "New Generator");
    mySourceLanguage = sourceLanguage;
    myContenetPane = new JPanel(new GridBagLayout());
    initContentPane();
  }

  public void setVisible(boolean b) {
    if (b) {
      pack();
    }
    super.setVisible(b);
  }

  public DialogDimensionsSettings.DialogDimensions getDefaultDimensionSettings() {
    return ourDefaultDimensionSettings;
  }

  protected JComponent getMainComponent() {
    return myContenetPane;
  }

  private void initContentPane() {
    GridBagConstraints cGenNameLabel = new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
    myContenetPane.add(new JLabel("Generator name"), cGenNameLabel);
    GridBagConstraints cGenName = new GridBagConstraints(1, 0, 2, 1, 1, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0);
    myGeneratorName = new JTextField();
    myContenetPane.add(myGeneratorName, cGenName);
    GridBagConstraints cModelsDirLabel = new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
    myContenetPane.add(new JLabel("Templates root"), cModelsDirLabel);
    GridBagConstraints cModelsDir = new GridBagConstraints(1, 1, 2, 1, 1, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0);
    myTemplateModelsDir = new TextFieldWithBrowseButton();
    myTemplateModelsDir.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String oldPath = myTemplateModelsDir.getText();
        TreeFileChooser chooser = new TreeFileChooser();
        chooser.setMode(TreeFileChooser.MODE_DIRECTORIES);
        if (oldPath != null && oldPath.length() != 0) {
          chooser.setInitialFile(FileSystem.getInstance().getFileByPath(oldPath));
        }
        IFile result = chooser.showDialog();
        if (result != null) {
          myTemplateModelsDir.setText(result.getPath());
        }
      }
    });
    myContenetPane.add(myTemplateModelsDir, cModelsDir);
    GridBagConstraints cFiller = new GridBagConstraints(0, 2, 3, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0);
    myContenetPane.add(new JPanel(), cFiller);
    updateTemplateModelsDir();
  }

  private void updateTemplateModelsDir() {
    IFile descriptorFile = mySourceLanguage.getDescriptorFile();
    assert descriptorFile != null;
    String path = descriptorFile.getParent().getPath();
    String modelsDir = path + File.separatorChar + "generator" + File.separatorChar + "template";
    myTemplateModelsDir.setText(modelsDir);
  }

  private boolean isValidName(String name) {
    for (char c : name.toCharArray()) {
      if (!(Character.isLetterOrDigit(c)) && c != '_') {
        return false;
      }
    }
    return true;
  }

  public Generator getResult() {
    return myResult;
  }

  @BaseDialog.Button(position = 0, name = "OK", mnemonic = 'O', defaultButton = true)
  public void buttonOK() {
    String templateModelsPath = myTemplateModelsDir.getText();
    if (templateModelsPath.length() == 0) {
      setErrorText("No template models root");
      return;
    }
    final File dir = new File(templateModelsPath);
    if (!(dir.isAbsolute())) {
      setErrorText("Path should be absolute");
      return;
    }
    if (!(dir.exists())) {
      dir.mkdirs();
    }
    final String name = myGeneratorName.getText();
    if (!(isValidName(name))) {
      setErrorText("Only letters, digits and '_' can be used in generator name.");
      return;
    }
    dispose();
    Project project = PlatformDataKeys.PROJECT.getData(DataManager.getInstance().getDataContext());
    assert project != null;
    final Wrappers._T<Generator> newGenerator = new Wrappers._T<Generator>(null);
    NewModuleUtil.runModuleCreation(project, new _FunctionTypes._void_P0_E0() {
      public void invoke() {
        newGenerator.value = createNewGenerator(mySourceLanguage, dir, name);
        adjustTemplateModel(mySourceLanguage, newGenerator.value);
      }
    });

    myResult = newGenerator.value;
  }

  @BaseDialog.Button(position = 1, name = "Cancel", mnemonic = 'C')
  public void buttonCancel() {
    dispose();
  }

  public void dispose() {
    super.dispose();
    Disposer.dispose(myTemplateModelsDir);
  }

  protected Generator createNewGenerator(final Language language, File templateModelsDir, String name) {
    final LanguageDescriptor languageDescriptor = language.getModuleDescriptor();
    final GeneratorDescriptor generatorDescriptor = new GeneratorDescriptor();
    generatorDescriptor.setGeneratorUID(Generator.generateGeneratorUID(language));
    generatorDescriptor.setNamespace(name);
    ModelRoot templateModelsRoot = new ModelRoot();
    templateModelsRoot.setPath(templateModelsDir.getAbsolutePath());
    generatorDescriptor.getModelRoots().add(templateModelsRoot);
    generatorDescriptor.getUsedDevkits().add(MPSModuleRepository.getInstance().getModuleById(ModuleId.fromString("fbc25dd2-5da4-483a-8b19-70928e1b62d7")).getModuleReference());
    generatorDescriptor.getUsedLanguages().add(MPSModuleRepository.getInstance().getModuleById(ModuleId.fromString("b401a680-8325-4110-8fd3-84331ff25bef")).getModuleReference());
    generatorDescriptor.getUsedLanguages().add(MPSModuleRepository.getInstance().getModuleById(ModuleId.fromString("d7706f63-9be2-479c-a3da-ae92af1e64d5")).getModuleReference());
    languageDescriptor.getGenerators().add(generatorDescriptor);
    language.setLanguageDescriptor(languageDescriptor, false);
    language.save();

    return (Generator) MPSModuleRepository.getInstance().getModuleById(generatorDescriptor.getId());
  }

  private String getTemplateModelPrefix(Language sourceLanguage) {
    return sourceLanguage.getModuleFqName() + ".generator.template";
  }

  private void adjustTemplateModel(Language sourceLanguage, Generator newGenerator) {
    boolean alreadyOwnsTemplateModel = false;
    for (SModelDescriptor modelDescriptor : newGenerator.getOwnModelDescriptors()) {
      if (SModelStereotype.isGeneratorModel(modelDescriptor)) {
        alreadyOwnsTemplateModel = true;
        break;
      }
    }
    if (alreadyOwnsTemplateModel) {
      return;
    }
    EditableSModelDescriptor templateModelDescriptor = newGenerator.createModel(new SModelFqName(getTemplateModelPrefix(sourceLanguage) + "." + "main", SModelStereotype.GENERATOR), newGenerator.getSModelRoots().iterator().next(), null);
    SModel templateModel = templateModelDescriptor.getSModel();
    SNode mappingConfiguration = SModelOperations.createNewNode(templateModel, "jetbrains.mps.lang.generator.structure.MappingConfiguration", null);
    SPropertyOperations.set(mappingConfiguration, "name", "main");
    SModelOperations.addRootNode(templateModel, mappingConfiguration);
    templateModelDescriptor.save();
  }
}
