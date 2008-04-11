package jetbrains.mps.ide;

import jetbrains.mps.datatransfer.CloneModelUtil;
import jetbrains.mps.ide.projectPane.ProjectPane;
import jetbrains.mps.ide.command.CommandRunnable;
import jetbrains.mps.project.IModule;
import jetbrains.mps.project.MPSProject;
import jetbrains.mps.projectLanguage.structure.*;
import jetbrains.mps.smodel.*;
import jetbrains.mps.smodel.Language;

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

  private static final DialogDimensionsSettings.DialogDimensions ourDefaultDialogSettings = new DialogDimensionsSettings.DialogDimensions(100, 100, 500, 400);
  private CloneModelProperties myCloneModelProperties;

  private SModel myProjectModel;
  private AbstractProjectFrame myIde;
  private SModel mySModel;

  protected SNode getNode() {
    return BaseAdapter.fromAdapter(myCloneModelProperties);
  }

  public DialogDimensionsSettings.DialogDimensions getDefaultDimensionSettings() {
    return ourDefaultDialogSettings;
  }


  public CloneModelDialog(AbstractProjectFrame ide, SModelDescriptor modelDescriptor, IOperationContext operationContext) {
    super(ide, "Clone Model", operationContext);
    myIde = ide;
    IModule module = operationContext.getModule();
    assert module != null;
    SModelDescriptor workingModel = ProjectModels.createDescriptorFor(module);
    myProjectModel = workingModel.getSModel();
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
    new CommandRunnable() {
      public Object onRun() {
        Language l = getOperationContext().getScope().getLanguage("jetbrains.mps.projectLanguage");
        assert l != null;
        myProjectModel.addLanguage(l);
        myCloneModelProperties = CloneModelProperties.newInstance(myProjectModel);
        myProjectModel.addRoot(myCloneModelProperties);

        String longName = mySModel.getLongName();
        myCloneModelProperties.setLongName(createNameForCopy(longName, mySModel.getStereotype()));
        myCloneModelProperties.setStereotype(mySModel.getStereotype());
        Set<ModelRoot> modelRoots = mySModel.getModelDescriptor().collectModelRoots();
        if (!modelRoots.isEmpty()) {
          ModelRoot root = modelRoots.iterator().next();
          RootReference rootReference = RootReference.newInstance(myProjectModel);
          rootReference.setPath(root.getPath());
          rootReference.setPrefix(root.getPrefix());
          myCloneModelProperties.setRoot(rootReference);
        }

        for (String language : mySModel.getExplicitlyImportedLanguages()) {
          jetbrains.mps.projectLanguage.structure.Language lang = jetbrains.mps.projectLanguage.structure.Language.newInstance(myProjectModel);
          lang.setName(language);
          myCloneModelProperties.addLanguage(lang);
        }

        for (SModelUID importedModelUID : mySModel.getImportedModelUIDs()) {
          Model m = Model.newInstance(myProjectModel);
          m.setName(importedModelUID.toString());
          myCloneModelProperties.addImportedModel(m);
        }

        for (String devKit : mySModel.getDevKitNamespaces()) {
          jetbrains.mps.projectLanguage.structure.DevKit dk = DevKit.newInstance(myProjectModel);
          dk.setName(devKit);
          myCloneModelProperties.addDevKit(dk);
        }

        for (String language : mySModel.getEngagedOnGenerationLanguages()) {
          jetbrains.mps.projectLanguage.structure.Language lang = jetbrains.mps.projectLanguage.structure.Language.newInstance(myProjectModel);
          lang.setName(language);
          myCloneModelProperties.addEngagedOnGenerationLanguage(lang);
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

    ModelRoot modelRoot = ModelRoot.newInstance(myProjectModel);
    modelRoot.setPrefix(reference.getPrefix());
    modelRoot.setPath(reference.getPath());

    IOperationContext operationContext = getOperationContext();
    IModule module = operationContext.getModule();
    assert module != null;
    SModelDescriptor modelDescriptor = module.createModel(new SModelUID(modelName, stereotype), modelRoot);

    SModel model = modelDescriptor.getSModel();
    Set<String> modelsInProps = getModelsInProperties();
    for (String modelUID : modelsInProps) {
      model.addImportedModel(SModelUID.fromString(modelUID));
    }

    for (jetbrains.mps.projectLanguage.structure.Language l : myCloneModelProperties.getLanguages()) {
      String name = l.getName();
      assert name != null;
      Language language = getOperationContext().getScope().getLanguage(name);
      assert language != null;
      model.addLanguage(language);
    }
    
    CloneModelUtil.cloneModel(mySModel, modelDescriptor.getSModel(), getScope());

    MPSProject project = myIde.getProject();
    assert project != null;
    ProjectPane pane = project.getComponent(ProjectPane.class);
    assert pane != null;
    pane.selectModel(modelDescriptor);
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
