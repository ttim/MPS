package jetbrains.mps.ide;

import jetbrains.mps.datatransfer.CloneModelUtil;
import jetbrains.mps.ide.projectPane.ProjectPane;
import jetbrains.mps.projectLanguage.CloneModelProperties;
import jetbrains.mps.projectLanguage.Model;
import jetbrains.mps.projectLanguage.RootReference;
import jetbrains.mps.smodel.*;
import jetbrains.mps.util.CollectionUtil;
import jetbrains.mps.util.CommandRunnable;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Cyril.Konopko
 * Date: 15.08.2005
 * Time: 17:04:42
 * To change this template use File | Settings | File Templates.
 */
public class CloneModelDialog extends BaseNodeDialog {

  private static final DialogDimensions ourDefaultDialogSettings = new DialogDimensions(100, 100, 500, 400);
  private CloneModelProperties myCloneModelProperties;

  private SModelDescriptor myWorkingModel;
  private SModel myProjectModel;
  private IdeMain myIde;
  private SModel mySModel;

  protected SNode getNode() {
    return myCloneModelProperties;
  }

  public DialogDimensions getDefaultDimensionSettings() {
    return ourDefaultDialogSettings;
  }


  public CloneModelDialog(IdeMain ide, SModelDescriptor modelDescriptor, IOperationContext operationContext) {
    super(ide, "Clone Model", operationContext);
    myIde = ide;
    myWorkingModel = ProjectModelDescriptor.createDescriptorFor(operationContext.getModule());
    myProjectModel = myWorkingModel.getSModel();
    mySModel = modelDescriptor.getSModel();

    initNode();

  }

  private String createNameForCopy(String longName, String stereotype) {
    String result = longName + "_copy";
    int i;
    for (i = 1; ; i++) {
      if (getOperationContext().getScope().getModelDescriptor(new SModelUID(result + i, stereotype)) == null) break;
    }
    return result + i;
  }

  private void initNode() {
    new CommandRunnable(myProjectModel) {
      public Object onRun() {

        myProjectModel.addLanguage(getOperationContext().getScope().getLanguage("jetbrains.mps.projectLanguage"));
        myCloneModelProperties = CloneModelProperties.newInstance(myProjectModel);
        myProjectModel.addRoot(myCloneModelProperties);

        String longName = mySModel.getLongName();
        myCloneModelProperties.setLongName(createNameForCopy(longName, mySModel.getStereotype()));
        myCloneModelProperties.setStereotype(mySModel.getStereotype());

        for (String language : mySModel.getLanguageNamespaces()) {
          jetbrains.mps.projectLanguage.Language lang = jetbrains.mps.projectLanguage.Language.newInstance(myProjectModel);
          lang.setName(language);
          myCloneModelProperties.addLanguage(lang);
        }

        for (SModelUID importedModelUID : mySModel.getImportedModelUIDs()) {
          Model m = Model.newInstance(myProjectModel);
          m.setName(importedModelUID.toString());
          myCloneModelProperties.addImportedModel(m);
        }
        return null;
      }
    }.run();
  }

  protected String getErrorString() {
    if (myCloneModelProperties.getRoot() == null) return "Please specify root";
    if (myCloneModelProperties.getLongName() == null || myCloneModelProperties.getLongName().length() == 0) return "Please specify name";
    if (!myCloneModelProperties.getLongName().startsWith(myCloneModelProperties.getRoot().getPrefix())) return "Incorrect namespace for specified root";
    if (myCloneModelProperties.getLongName().equals(myCloneModelProperties.getRoot().getPrefix())) return "Model fqName is the same as prefix. Can't import";
    if (myCloneModelProperties.getLanguagesCount() < 1) return "Model must have at least one language";
    return null;
  }

  protected void saveChanges() {
    String stereotype = myCloneModelProperties.getStereotype();
    String modelName = myCloneModelProperties.getLongName();
    RootReference reference = myCloneModelProperties.getRoot();

    IOperationContext operationContext = getOperationContext();
    SModelDescriptor modelDescriptor = operationContext.getModule().createModel(new SModelUID(modelName, stereotype), reference.getPath(), reference.getPrefix());

    SModel SModel = modelDescriptor.getSModel();
    Set<String> modelsInProps = getModelsInProperties();
    for (String modelUID : modelsInProps) {
      SModel.addImportedModel(SModelUID.fromString(modelUID));
    }

    for (jetbrains.mps.projectLanguage.Language l : CollectionUtil.iteratorAsIterable(myCloneModelProperties.languages())) {
      SModel.addLanguage(getOperationContext().getScope().getLanguage(l.getName()));
    }

    CloneModelUtil.cloneModel(mySModel, modelDescriptor.getSModel());

    myIde.getProject().getComponent(ProjectPane.class).selectModel(modelDescriptor);
  }

  private Set<String> getModelsInProperties() {
    Set<String> result = new HashSet<String>();
    Iterator<Model> models = myCloneModelProperties.importedModels();
    while (models.hasNext()) {
      result.add(models.next().getName());
    }
    return result;
  }
}
