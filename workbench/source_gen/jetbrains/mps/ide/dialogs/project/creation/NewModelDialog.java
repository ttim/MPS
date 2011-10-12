package jetbrains.mps.ide.dialogs.project.creation;

/*Generated by MPS */

import jetbrains.mps.ide.dialogs.BaseDialog;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.project.IModule;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import jetbrains.mps.smodel.SModelDescriptor;
import java.awt.HeadlessException;
import jetbrains.mps.ide.project.ProjectHelper;
import jetbrains.mps.ide.dialogs.DialogDimensionsSettings;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import jetbrains.mps.smodel.SModelStereotype;
import jetbrains.mps.project.SModelRoot;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.util.Computable;
import javax.lang.model.SourceVersion;
import jetbrains.mps.smodel.SModelFqName;
import jetbrains.mps.smodel.SModelRepository;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.smodel.LanguageAspect;
import jetbrains.mps.ide.properties.StandardDialogs;
import javax.swing.JComponent;

public class NewModelDialog extends BaseDialog {
  private IOperationContext myContext;
  private IModule myModule;
  private JPanel myContentPane = new JPanel(new BorderLayout());
  private JTextField myModelName = new JTextField();
  private JComboBox myModelStereotype = new JComboBox();
  private JComboBox myModelRoots = new JComboBox();
  private SModelDescriptor myResult;
  private String myNamespace;

  public NewModelDialog(IModule module, String namespace, IOperationContext context, String stereotype, boolean strict) throws HeadlessException {
    super(ProjectHelper.toMainFrame(context.getProject()), "New Model");
    myContext = context;
    myModule = module;
    myNamespace = namespace;
    assert myModule.getSModelRoots().size() > 0 : "Can't create a model in solution with no model roots";
    initContentPane();
    if (stereotype != null) {
      myModelStereotype.setSelectedItem(stereotype);
      myModelStereotype.setEnabled(!(strict));
    }
  }

  public DialogDimensionsSettings.DialogDimensions getDefaultDimensionSettings() {
    return new DialogDimensionsSettings.DialogDimensions(100, 100, 400, 300);
  }

  public SModelDescriptor getResult() {
    return myResult;
  }

  private void initContentPane() {
    JPanel mainPanel = new JPanel(new GridLayout(0, 1));
    mainPanel.add(new JLabel("Model name:"));
    mainPanel.add(myModelName);
    mainPanel.add(new JLabel("Stereotype:"));
    myModelStereotype.setEditable(true);
    myModelStereotype.setModel(new DefaultComboBoxModel(SModelStereotype.values));
    mainPanel.add(myModelStereotype);
    mainPanel.add(new JLabel("Model root:"));
    mainPanel.add(myModelRoots);
    DefaultComboBoxModel model = new DefaultComboBoxModel();
    for (SModelRoot root : myModule.getSModelRoots()) {
      if (myNamespace == null || myNamespace.startsWith(root.getPrefix())) {
        model.addElement(new NewModelDialog.ModelRootWrapper(root));
      }
    }
    if (model.getSize() == 0) {
      model.addElement("<NO MODEL ROOTS FOR SELECTED NAMESPACE>");
    }
    myModelRoots.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        completePrefix();
      }
    });
    myModelRoots.setModel(model);
    completePrefix();
    myContentPane.add(mainPanel, BorderLayout.NORTH);
    myContentPane.add(new JPanel(), BorderLayout.CENTER);
  }

  private void completePrefix() {
    Object selected = myModelRoots.getSelectedItem();
    if (!((selected instanceof NewModelDialog.ModelRootWrapper))) {
      return;
    }
    NewModelDialog.ModelRootWrapper wrapper = (NewModelDialog.ModelRootWrapper) selected;
    myModelName.setText((myNamespace == null ?
      wrapper.getNamespace() :
      myNamespace
    ));
  }

  @BaseDialog.Button(position = 0, name = "OK", mnemonic = 'O', defaultButton = true)
  public void buttonOk() {
    if (!((myModelRoots.getSelectedItem() instanceof NewModelDialog.ModelRootWrapper))) {
      String message;
      if (myNamespace == null) {
        message = "At least one module root should be added to module to create models in this module";
      } else {
        message = "At least one module root with prefix " + myNamespace + " should be added to module to create models with this namespace";
      }
      setErrorText(message);
      return;
    }
    myResult = ModelAccess.instance().runWriteActionInCommand(new Computable<SModelDescriptor>() {
      public SModelDescriptor compute() {
        String modelName = myModelName.getText();
        if (modelName.length() == 0) {
          setErrorText("Empty model name isn't allowed");
          return null;
        }
        if (!(SourceVersion.isName(modelName))) {
          setErrorText("Model name should be valid Java package");
          return null;
        }
        SModelFqName modelUID = new SModelFqName(modelName, myModelStereotype.getSelectedItem().toString());
        if (SModelRepository.getInstance().getModelDescriptor(modelUID) != null) {
          setErrorText("Model with an uid " + modelName + " already exists");
          return null;
        }
        NewModelDialog.ModelRootWrapper wrapper = (NewModelDialog.ModelRootWrapper) myModelRoots.getSelectedItem();
        String modelPrefix = (wrapper.getNamespace().length() > 0 ?
          wrapper.getNamespace() + '.' :
          ""
        );
        if (!((modelName.startsWith(modelPrefix)))) {
          setErrorText("Model name should have a prefix " + wrapper.getNamespace());
          return null;
        }
        if (modelName.length() - modelPrefix.length() == 0) {
          setErrorText("Empty model short name isn't allowed");
          return null;
        }
        if (myModule instanceof Language) {
          for (LanguageAspect aspect : LanguageAspect.values()) {
            String shortName = modelName.substring(modelPrefix.length());
            if (shortName.equals(aspect.getName())) {
              setErrorText("This name isn't allowed because '" + shortName + "' is language aspect name");
              return null;
            }
          }
        }
        return myModule.createModel(modelUID, wrapper.getModelRoot(), null);
      }
    }, myContext.getProject());
    if (myResult == null) {
      return;
    }
    StandardDialogs.createModelPropertiesDialog(myResult, myContext).showDialog();
    dispose();
  }

  @BaseDialog.Button(position = 1, name = "Cancel", mnemonic = 'C')
  public void buttonCancel() {
    dispose();
  }

  protected JComponent getMainComponent() {
    return myContentPane;
  }

  private static class ModelRootWrapper {
    private SModelRoot myModelRoot;
    private String myNamespace;
    private String myText;

    private ModelRootWrapper(SModelRoot modelRoot) {
      myModelRoot = modelRoot;
      myNamespace = myModelRoot.getPrefix();
      if (myNamespace == null) {
        myNamespace = "";
      }
      boolean needsNamespace = !(myNamespace.equals(""));
      myText = myModelRoot.getPath() + ((needsNamespace ?
        " (" + myNamespace + ")" :
        ""
      ));
    }

    public String toString() {
      return myText;
    }

    public String getNamespace() {
      return myNamespace;
    }

    public SModelRoot getModelRoot() {
      return myModelRoot;
    }
  }
}
