/*
 * Copyright 2003-2008 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jetbrains.mps.ide.dialogs.project;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Computable;
import jetbrains.mps.datatransfer.CloneModelUtil;
import jetbrains.mps.ide.projectPane.ProjectPane;
import jetbrains.mps.ide.dialogs.base.BaseProjectDialog;
import jetbrains.mps.ide.dialogs.base.DialogDimensionsSettings;
import jetbrains.mps.ide.dialogs.project.properties.presenters.CloneModelProperties;
import jetbrains.mps.project.IModule;
import jetbrains.mps.project.SModelRoot;
import jetbrains.mps.project.structure.model.RootReference;
import jetbrains.mps.project.structure.modules.ModuleReference;
import jetbrains.mps.smodel.*;
import org.jdesktop.beansbinding.*;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;

import javax.swing.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class CloneModelDialog extends BaseProjectDialog {
  private CloneModelProperties myModelProperties;
  private SModel myCloningModel;
  private JPanel myContentPanel;

  public CloneModelDialog(final SModelDescriptor modelDescriptor, IOperationContext operationContext) {
    super("Clone Model " + modelDescriptor.getLongName(), operationContext);

    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        myCloningModel = modelDescriptor.getSModel();
      }
    });

    collectModelProps();
    initUI();
  }

  protected JComponent getMainComponent() {
    return myContentPanel;
  }

  public DialogDimensionsSettings.DialogDimensions getDefaultDimensionSettings() {
    return new DialogDimensionsSettings.DialogDimensions(100, 100, 400, 200);
  }

  private void initUI() {
    myContentPanel = new JPanel(new GridBagLayout());

    GridBagConstraints cPathLabel = new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
    myContentPanel.add(new JLabel("Path:"), cPathLabel);
    GridBagConstraints cPath = new GridBagConstraints(1, 0, 1, 1, 1, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0);
    JTextField tfPath = new JTextField();
    tfPath.setEditable(false);
    myContentPanel.add(tfPath, cPath);

    Property pPath = BeanProperty.create(CloneModelProperties.PROPERTY_PATH);
    Property pPathVar = BeanProperty.create("text");
    AutoBinding binding = Bindings.createAutoBinding(UpdateStrategy.READ, myModelProperties, pPath, tfPath, pPathVar);
    binding.setConverter(new Converter() {
      @Override
      public Object convertForward(Object value) {
        RootReference rr = (RootReference) value;
        return rr.getPath()+" ("+rr.getPrefix()+")"; 
      }

      @Override
      public Object convertReverse(Object value) {
        return null;
      }
    });
    addBinding(binding);

    GridBagConstraints cNameLabel = new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
    myContentPanel.add(new JLabel("Name:"), cNameLabel);
    GridBagConstraints cName = new GridBagConstraints(1, 1, 1, 1, 1, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0);
    JTextField tfName = new JTextField();
    myContentPanel.add(tfName, cName);

    Property pName = BeanProperty.create(CloneModelProperties.PROPERTY_NAME);
    Property pNameVar = BeanProperty.create("text");
    addBinding(Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, myModelProperties, pName, tfName, pNameVar));

    GridBagConstraints cStereotypeLabel = new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
    myContentPanel.add(new JLabel("Stereotype:"), cStereotypeLabel);
    GridBagConstraints cStereotype = new GridBagConstraints(1, 2, 1, 1, 1, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
    JComboBox cbStereotype = new JComboBox(SModelStereotype.values);
    myContentPanel.add(cbStereotype, cStereotype);

    Property pStereotype = BeanProperty.create(CloneModelProperties.PROPERTY_STEREOTYPE);
    Property pStereotypeVar = BeanProperty.create("selectedItem");
    addBinding(Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, myModelProperties, pStereotype, cbStereotype, pStereotypeVar));

    GridBagConstraints cLog = new GridBagConstraints(0, 3, 2, 1, 1, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
    JCheckBox cbLog = new JCheckBox("Use log");
    myContentPanel.add(cbLog, cLog);

    Property pLog = BeanProperty.create(CloneModelProperties.PROPERTY_LOG);
    Property pLogVar = BeanProperty.create("selected");
    addBinding(Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, myModelProperties, pLog, cbLog, pLogVar));

    GridBagConstraints cSpacer = new GridBagConstraints(0, 4, 2, 1, 1, 1, GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0);
    myContentPanel.add(new JPanel(), cSpacer);
  }

  private void collectModelProps() {
    myModelProperties = new CloneModelProperties();
    myModelProperties.loadFrom(myCloningModel);
    
    String newName = createNameForCopy(myCloningModel.getLongName(), myCloningModel.getStereotype());
    myModelProperties.setLongName(newName);
  }

  private String createNameForCopy(String longName, String stereotype) {
    String result = longName + "_copy";
    int i;
    for (i = 1; ; i++) {
      SModelFqName name = new SModelFqName(result + i, stereotype);
      SModelDescriptor model = getOperationContext().getScope().getModelDescriptor(name);
      if (model == null) break;
    }
    return result + i;
  }

  private String getErrorString() {
    if (myModelProperties.getRoot() == null) return "Please specify root";
    if (myModelProperties.getLongName() == null || myModelProperties.getLongName().length() == 0)
      return "Please specify name";
    if (!myModelProperties.getLongName().startsWith(myModelProperties.getRoot().getPrefix()))
      return "Incorrect namespace for specified root";
    if (myModelProperties.getLongName().equals(myModelProperties.getRoot().getPrefix()))
      return "Model fqName is the same as prefix. Can't import";
    if (myModelProperties.getImportedLanguages().size() < 1) return "Model must have at least one language";
    return null;
  }

  protected boolean saveChanges() {
    String errorString = getErrorString();
    if (errorString!=null){
      setErrorText(errorString);
      return false;
    }

    final String stereotype = myModelProperties.getStereotype();
    final String modelName = myModelProperties.getLongName();
    RootReference reference = myModelProperties.getRoot();

    IOperationContext operationContext = getOperationContext();
    final IModule module = operationContext.getModule();
    assert module != null;

    for (SModelDescriptor model : module.getOwnModelDescriptors()) {
      if (model.getLongName().equals(modelName)) {
        setErrorText("Model with the same name already exists. Please choose another name");
        return false;
      }
    }

    final SModelRoot modelRoot = module.findModelRoot(reference.getPath());
    final SModelDescriptor modelDescriptor = ModelAccess.instance().runWriteAction(new Computable<SModelDescriptor>() {
      public SModelDescriptor compute() {
        return module.createModel(new SModelFqName(modelName, stereotype), modelRoot);
      }
    });
    if (modelDescriptor == null) {
      setErrorText("You can't create a model in the model root that you specified");
      return false;
    }

    final SModel model = modelDescriptor.getSModel();
    model.runLoadingAction(new Runnable() {
      public void run() {
        for (SModelReference ref : myModelProperties.getImportedModels()) {
          model.addImportedModel(ref);
        }

        for (ModuleReference mr : myModelProperties.getImportedLanguages()) {
          model.addLanguage(mr);
        }

        for (ModuleReference mr : myModelProperties.getImportedDevkits()) {
          model.addDevKit(mr);
        }

        for (ModuleReference mr : myModelProperties.getLanguagesInGeneration()) {
          model.addEngagedOnGenerationLanguage(mr);
        }
      }
    });

    ModelAccess.instance().runWriteAction(new Runnable() {
      public void run() {
        SModel smodel = modelDescriptor.getSModel();
        IScope scope = getOperationContext().getScope();
        CloneModelUtil.cloneModel(myCloningModel, smodel, scope);
      }
    });

    Project project = getOperationContext().getProject();
    assert project != null;
    final ProjectPane pane = project.getComponent(ProjectPane.class);
    assert pane != null;
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        pane.rebuildTree();
        pane.selectModel(modelDescriptor);
      }
    });
    return true;
  }
}
