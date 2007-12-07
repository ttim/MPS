package jetbrains.mps.smodel;

import jetbrains.mps.bootstrap.structureLanguage.structure.AbstractConceptDeclaration;
import jetbrains.mps.bootstrap.structureLanguage.structure.ConceptDeclaration;
import jetbrains.mps.bootstrap.structureLanguage.structure.InterfaceConceptDeclaration;
import jetbrains.mps.bootstrap.structureLanguage.structure.InterfaceConceptReference;
import jetbrains.mps.findUsages.FindUsagesManager;
import jetbrains.mps.ide.BootstrapLanguages;
import jetbrains.mps.ide.IStatus;
import jetbrains.mps.ide.command.CommandEventTranslator;
import jetbrains.mps.ide.command.CommandProcessor;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.logging.refactoring.structure.Refactoring;
import jetbrains.mps.plugin.IProjectHandler;
import jetbrains.mps.project.AbstractModule;
import jetbrains.mps.project.ConversionUtil;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.projectLanguage.DescriptorsPersistence;
import jetbrains.mps.projectLanguage.structure.*;
import jetbrains.mps.refactoring.framework.ILoggableRefactoring;
import jetbrains.mps.refactoring.languages.RenameModelRefactoring;
import jetbrains.mps.refactoring.logging.Marshallable;
import jetbrains.mps.reloading.ReloadUtils;
import jetbrains.mps.smodel.event.*;
import jetbrains.mps.smodel.persistence.DefaultModelRootManager;
import jetbrains.mps.smodel.persistence.IModelRootManager;
import jetbrains.mps.smodel.persistence.ModelRootsUtil;
import jetbrains.mps.util.*;
import jetbrains.mps.util.annotation.Hack;
import jetbrains.mps.util.annotation.UseCarefully;
import jetbrains.mps.vfs.FileSystem;
import jetbrains.mps.vfs.IFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.rmi.RemoteException;
import java.util.*;


/**
 * Author: Sergey Dmitriev
 * Created Jan 30, 2004
 */
public class Language extends AbstractModule implements Marshallable<Language> {
  private static final Logger LOG = Logger.getLogger(Language.class);

  private static final String LANGUAGE_ACCESSORIES = "languageAccessories";
  private static final String LANGUAGE_MODELS = "languageModels";

  private LanguageDescriptor myLanguageDescriptor;
  private List<Generator> myGenerators;
  private HashMap<String, AbstractConceptDeclaration> myNameToConceptCache = new HashMap<String, AbstractConceptDeclaration>();
  private List<LanguageCommandListener> myCommandListeners = new ArrayList<LanguageCommandListener>();
  private LanguageEventTranslator myEventTranslator = new LanguageEventTranslator();
  private SModelsListener myModelsListener = new LanguageModelsAdapter();
  private boolean myUpToDate = true;

  private boolean myUpdateLastGenerationTimeCalled = false;

  private Map<String, Set<String>> myParentsNamesMap = new HashMap<String, Set<String>>();
  private SModelCommandListener myAspectModelsListener = new SModelCommandListener() {
    public void modelChangedInCommand(List<SModelEvent> events) {
      if (myUpToDate) {
        myUpToDate = false;
        CommandProcessor.instance().executeCommand(new Runnable() {
          public void run() {
            myEventTranslator.languageChanged();
          }
        });
      }
    }
  };
  private boolean myRegisteredInFindUsagesManager;


  public void rename(String newNamespace, IOperationContext operationContext) {
    String oldNamespace = getNamespace();

    // update repository
    MPSModuleRepository.getInstance().renameUID(this, newNamespace);

    // set new namespace
    myLanguageDescriptor.setNamespace(newNamespace);

    // rename model roots
    String oldLanguageModelsRoot = myDescriptorFile.getParent().child(LANGUAGE_MODELS).getAbsolutePath();
    String oldLanguageAccesoriesRoot = myDescriptorFile.getParent().child(LANGUAGE_ACCESSORIES).getAbsolutePath();
    for (ModelRoot modelRoot : myLanguageDescriptor.getModelRoots()) {
      if (modelRoot.getPath().equals(oldLanguageModelsRoot)) {
        modelRoot.delete();
      }
      if (modelRoot.getPath().equals(oldLanguageAccesoriesRoot)) {
        modelRoot.delete();
      }
    }


    IProjectHandler projectHandler = operationContext.getProject().getProjectHandler();
    if (projectHandler != null) {
      try {
        projectHandler.deleteFilesAndRemoveFromVCS(CollectionUtil.asList(myDescriptorFile.toFile()));
      } catch (RemoteException e) {
        LOG.error(e);
      }
    } else {
      myDescriptorFile.delete();
    }

    File descriptorFile = newDescriptorFileByNewName(newNamespace).toFile();

    SModel descriptorModel = myLanguageDescriptor.getModel();
    ModelRoot languageModelRoot = ModelRoot.newInstance(descriptorModel);
    languageModelRoot.setPath(new File(descriptorFile.getParentFile(), LANGUAGE_MODELS).getAbsolutePath());
    languageModelRoot.setPrefix(newNamespace);
    myLanguageDescriptor.addModelRoot(languageModelRoot);
    ModelRoot accessoryModelRoot = ModelRoot.newInstance(descriptorModel);
    accessoryModelRoot.setPath(new File(descriptorFile.getParentFile(), LANGUAGE_ACCESSORIES).getAbsolutePath());
    accessoryModelRoot.setPrefix(newNamespace);
    myLanguageDescriptor.addModelRoot(accessoryModelRoot);

    // rename language models
    renameLanguageModel(oldNamespace, newNamespace, myLanguageDescriptor.getStructureModel(), languageModelRoot, operationContext);
    Model editorModel = null;
    for (Editor editor : myLanguageDescriptor.getEditors()) {
      if (editor.getStereotype() == null || editor.getStereotype().equals(SModelStereotype.NONE)) {
        editorModel = editor.getEditorModel();
        break;
      }
    }
    renameLanguageModel(oldNamespace, newNamespace, editorModel, languageModelRoot, operationContext);
    renameLanguageModel(oldNamespace, newNamespace, myLanguageDescriptor.getActionsModel(), languageModelRoot, operationContext);
    renameLanguageModel(oldNamespace, newNamespace, myLanguageDescriptor.getConstraintsModel(), languageModelRoot, operationContext);
    renameLanguageModel(oldNamespace, newNamespace, myLanguageDescriptor.getHelginsTypesystemModel(), languageModelRoot, operationContext);
    renameLanguageModel(oldNamespace, newNamespace, myLanguageDescriptor.getScriptsModel(), languageModelRoot, operationContext);

    for (Model m : myLanguageDescriptor.getAccessoryModels()) {
      renameLanguageModel(oldNamespace, newNamespace, m, languageModelRoot, operationContext);
    }

    SModelRepository.getInstance().saveAll();

    // save descriptor
    myDescriptorFile = FileSystem.getFile(descriptorFile);
    setLanguageDescriptor(myLanguageDescriptor);
    save();
  }

  /*package*/ IFile newDescriptorFileByNewName(String newNamespace) {
    IFile dir = myDescriptorFile.getParent();
    String oldShortFileName = NameUtil.shortNameFromLongName(myDescriptorFile.getAbsolutePath());
    String newPathSuffix = NameUtil.shortNameFromLongName(newNamespace);
    if ((dir.getAbsolutePath() + MPSModuleRepository.LANGUAGE_EXT).endsWith(oldShortFileName)) {
      dir = dir.getParent();
      newPathSuffix = newPathSuffix + File.separatorChar + newPathSuffix;
    }
    return dir.child(newPathSuffix + MPSModuleRepository.LANGUAGE_EXT);
  }

  private void renameLanguageModel(String oldNamespace, String newNamespace, Model model, ModelRoot newRoot, IOperationContext operationContext) {
    if (model == null) return;
    String name = model.getName();
    if (name.startsWith(oldNamespace)) {
      String newName = newNamespace + name.substring(oldNamespace.length(), name.length());
      model.setName(newName);
      SModelUID modelUID = SModelUID.fromString(name);
      SModelDescriptor modelDescriptor = SModelRepository.getInstance().getModelDescriptor(modelUID, this);
      if (modelDescriptor == null) {
        LOG.error("Couldn't get model \"" + modelUID + "\"");
      }
      new RenameModelRefactoring(modelDescriptor, operationContext, newName, newRoot).run();
    }
  }

  public String marshall() {
    return getNamespace();
  }

  public Language unmarshall(String s, IOperationContext operationContext) {
    return MPSModuleRepository.getInstance().getLanguage(s);
  }

  @NotNull
  public static Language newInstance(@NotNull IFile descriptorFile,
                                     @NotNull MPSModuleOwner moduleOwner) {
    Language language = new Language();
    SModel model = ProjectModels.createDescriptorFor(language).getSModel();
    model.setLoading(true);
    LanguageDescriptor languageDescriptor = DescriptorsPersistence.loadLanguageDescriptor(descriptorFile, model);
    language.myDescriptorFile = descriptorFile;
    language.myLanguageDescriptor = languageDescriptor;

    language.updateRuntimeClassPath();
    language.reloadStubs();

    MPSModuleRepository.getInstance().addModule(language, moduleOwner);

    language.updateDependenciesAndGenerators();

    return language;
  }

  @NotNull
  public static Language createLanguage(@NotNull String languageNamespace,
                                        @NotNull File descriptorFile,
                                        @NotNull MPSModuleOwner moduleOwner) {
    Language language = new Language();
    SModel descriptorModel = ProjectModels.createDescriptorFor(language).getSModel();
    descriptorModel.setLoading(true);
    LanguageDescriptor languageDescriptor = LanguageDescriptor.newInstance(descriptorModel);
    descriptorModel.addRoot(languageDescriptor);
    languageDescriptor.setNamespace(languageNamespace);

    // default descriptorModel roots
    ModelRoot modelRoot = ModelRoot.newInstance(descriptorModel);
    modelRoot.setPath(new File(descriptorFile.getParentFile(), LANGUAGE_MODELS).getAbsolutePath());
    modelRoot.setPrefix(languageNamespace);
    languageDescriptor.addModelRoot(modelRoot);
    modelRoot = ModelRoot.newInstance(descriptorModel);
    modelRoot.setPath(new File(descriptorFile.getParentFile(), LANGUAGE_ACCESSORIES).getAbsolutePath());
    modelRoot.setPrefix(languageNamespace);
    languageDescriptor.addModelRoot(modelRoot);

    language.myDescriptorFile = FileSystem.getFile(descriptorFile);
    language.myLanguageDescriptor = languageDescriptor;

    language.updateRuntimeClassPath();
    language.reloadStubs();

    MPSModuleRepository.getInstance().addModule(language, moduleOwner);

    language.updateDependenciesAndGenerators();
    return language;
  }

  // made public for unmarshalling purposes, invoked via reflection
  // do not use directly.
  @UseCarefully
  public Language() {
  }

  public void convert() {
    ConversionUtil.convert(this, myLanguageDescriptor.getModuleRoots());

    for (Generator g : getGenerators()) {
      g.convert();
    }
  }

  private void updateDependenciesAndGenerators() {
    // read modules and models
    readDependOnModules();
    revalidateGenerators();
  }

  public void readModels() {
    if (!isInitialized()) {
      super.readModels();

      if (isInitialized()) {
        List<SModelDescriptor> accessoryModels = getAccessoryModels();
        for (SModelDescriptor accessoryModel : accessoryModels) {
          SModelRepository.getInstance().addOwnerForDescriptor(accessoryModel, this);
        }

        CommandProcessor.instance().addCommandListener(myEventTranslator);
        SModelsMulticaster.getInstance().addSModelsListener(myModelsListener);
        registerAspectListener();

        fireModuleInitialized();
      }
    }
  }

  private void revalidateGenerators() {
    myGenerators = new LinkedList<Generator>();
    Iterator<GeneratorDescriptor> generators = getLanguageDescriptor().generators();
    while (generators.hasNext()) {
      GeneratorDescriptor generatorDescriptor = generators.next();
      Generator generator = new Generator(this, generatorDescriptor);
      generator.createManifest();
      generator.updateRuntimeClassPath();
      generator.reloadStubs();
      MPSModuleRepository.getInstance().addModule(generator, this);
      myGenerators.add(generator);
    }
  }

  public void dispose() {
    //Call this method before you remove it and its models from repositories
    //To unregister it correctly from different services we need it and its models    
    CommandProcessor.instance().removeCommandListener(myEventTranslator);
    SModelsMulticaster.getInstance().removeSModelsListener(myModelsListener);
    unRegisterAspectListener();
    SModelRepository.getInstance().unRegisterModelDescriptors(this);
    MPSModuleRepository.getInstance().unRegisterModules(this);
    if (myGenerators != null) {
      for (Generator generator : myGenerators) {
        generator.dispose();
      }
      myGenerators.clear();
    }

  }

  public void setLanguageDescriptor(final @NotNull LanguageDescriptor newDescriptor) {
    // release modules and models (except descriptor model)
    unRegisterAspectListener();
    SModelDescriptor modelDescriptor = SModelRepository.getInstance().getModelDescriptor(newDescriptor.getModel().getUID(), Language.this);

    assert modelDescriptor != null;

    MPSModuleRepository.getInstance().unRegisterModules(Language.this);
    SModelRepository.getInstance().unRegisterModelDescriptors(Language.this);
    SModelRepository.getInstance().registerModelDescriptor(modelDescriptor, Language.this);

    for (Generator generator : getGenerators()) {
      generator.dispose();
    }

    myLanguageDescriptor = newDescriptor;

    createManifest();

    //read modules and models
    readDependOnModules();
    revalidateGenerators();


    rereadModels();

    updateRuntimeClassPath();
    reloadStubs();

    ReloadUtils.reloadAll(true, true, false);

    registerAspectListener();
    updateLastGenerationTime();

    ReloadUtils.rebuildAllEditors();
    ReloadUtils.rebuildProjectPanes();

    MPSModuleRepository.getInstance().invalidateCaches();

    myEventTranslator.languageChanged();
  }

  public boolean structureHaveToBeLoadedFromApplicationClassLoader() {
    return BootstrapLanguages.getInstance().getLanguagesUsedInCore().contains(this);
  }

  protected List<String> getExportedPackages() {
    List<String> result = new ArrayList<String>(super.getExportedPackages());
    List<String> aspects = new ArrayList<String>();
    if (!BootstrapLanguages.getInstance().getLanguagesUsedInCore().contains(this)) {
      aspects.add(".structure");
    }

    aspects.addAll(CollectionUtil.asList(
            ".editor", ".actions", ".constraints",
            ".intentions", ".findUsages", ".builder", ".scripts",
            ".helgins", ".plugin", ".textGen",
            ".textPresentation", ".design", ".util", ".runtime", ".cfa"
    ));
    result.add(getModuleUID());
    for (String aspect : aspects) {
      result.add(getModuleUID() + aspect);
    }

    for (Model m : getLanguageDescriptor().getAccessoryModels()) {
      result.add(m.getName());
    }

    //todo tmp fix
    result.add(getModuleUID() + ".generator.baseLanguage.template.main");

    result.addAll(getGeneratorsPacks());

    return result;
  }

  private List<String> getGeneratorsPacks() {
    List<String> result = new ArrayList<String>();

    collectPackages(result, getModuleUID() + ".generator");
    collectPackages(result, getModuleUID() + ".generator_new");
    return result;
  }

  private void registerAspectListener() {
    for (SModelDescriptor aspectModel : getAspectModelDescriptors()) {
      if (aspectModel != null) aspectModel.addModelCommandListener(myAspectModelsListener);
    }
  }

  private void unRegisterAspectListener() {
    for (SModelDescriptor aspectModel : getAspectModelDescriptors()) {
      if (aspectModel != null) {
        aspectModel.removeModelCommandListener(myAspectModelsListener);
      }
    }
  }

  public int getVersion() {
    return getStructureModelDescriptor().getVersion();
  }

  @NotNull
  public ModuleDescriptor getModuleDescriptor() {
    return myLanguageDescriptor;
  }


  public void setModuleDescriptor(@NotNull ModuleDescriptor moduleDescriptor) {
    if (moduleDescriptor instanceof LanguageDescriptor) {
      setLanguageDescriptor((LanguageDescriptor) moduleDescriptor);
    } else {
      LOG.error("not a language descriptor", new Throwable());
    }
  }

  @NotNull
  public LanguageDescriptor getLanguageDescriptor() {
    return myLanguageDescriptor;
  }

  @Nullable
  public String getLanguagePluginClass() {
    return getLanguageDescriptor().getLanguagePluginClass();
  }

  public void updateLastGenerationTime() {
//    long lastGenerationTime = FileUtil.getNewestFileTime(
//            new File(getSourceDir().getAbsolutePath() + File.separator + getNamespace().replace('.', File.separatorChar)));
//    long lastChangeTime = getLastChangeTime();
//    myUpToDate = lastGenerationTime >= lastChangeTime;
//    myUpdateLastGenerationTimeCalled = true;
  }

  @NotNull
  public List<Generator> getGenerators() {
    return new ArrayList<Generator>(myGenerators);
  }

  public Generator getGeneratorTo(@NotNull String targetLanguageName) {
    for (Generator generator : myGenerators) {
      if (targetLanguageName.equals(generator.getTargetLanguageName())) {
        return generator;
      }
    }
    return null;
  }

  @NotNull
  public String getModuleUID() {
    return getNamespace();
  }

  @NotNull
  public String getNamespace() {
    String result = getLanguageDescriptor().getNamespace();
    assert result != null;
    return result;
  }

  @NotNull
  public File getSourceDir() {
    File sourceDir = new File(myDescriptorFile.getParent().toFile(), "source_gen");
    if (getLanguageDescriptor().getLanguageGenPath() != null) {
      sourceDir = new File(getLanguageDescriptor().getLanguageGenPath());
    }
    if (!sourceDir.exists()) {
      sourceDir.mkdirs();
    }
    return sourceDir;
  }

  @Nullable
  public String getGeneratorOutputPath() {
    String generatorOutputPath = myLanguageDescriptor.getLanguageGenPath();
    if (generatorOutputPath == null) {
      generatorOutputPath = myDescriptorFile.getParent().getCanonicalPath() + File.separatorChar + "source_gen";
    }
    return generatorOutputPath;
  }


  public boolean isUpToDate() {
    if (!myUpdateLastGenerationTimeCalled) {
      updateLastGenerationTime();
    }
    return myUpToDate;
  }


  private long getLastChangeTime() {
    long result = 0;
    SModelRepository repository = SModelRepository.getInstance();
    result = Math.max(result, repository.getLastChangeTime(getStructureModelDescriptor()));


    SModelDescriptor editorModel = getEditorModelDescriptor();
    if (editorModel != null) {
      result = Math.max(result, repository.getLastChangeTime(editorModel));
    }

    SModelDescriptor actionsModel = getActionsModelDescriptor();
    if (actionsModel != null) {
      result = Math.max(result, repository.getLastChangeTime(actionsModel));
    }

    SModelDescriptor constraintsModel = getConstraintsModelDescriptor();
    if (constraintsModel != null) {
      result = Math.max(result, repository.getLastChangeTime(constraintsModel));
    }

    SModelDescriptor typesystemModel = getHelginsTypesystemModelDescriptor();
    if (typesystemModel != null) {
      result = Math.max(result, repository.getLastChangeTime(typesystemModel));
    }

    return result;
  }

  @NotNull
  public List<ConceptDeclaration> getConceptDeclarations() {
    return getStructureModelDescriptor().getSModel().allAdapters(ConceptDeclaration.class);
  }

  @NotNull
  public SModelDescriptor getStructureModelDescriptor() {
    Model structureModel = getLanguageDescriptor().getStructureModel();

    assert structureModel != null;

    SModelUID modelUID = SModelUID.fromString(structureModel.getName());
    SModelDescriptor structureModelDescriptor = SModelRepository.getInstance().getModelDescriptor(modelUID, this);
    if (structureModelDescriptor == null) {
      LOG.error("Couldn't get structure model \"" + modelUID + "\"");
    } else if (!myRegisteredInFindUsagesManager) {
      myRegisteredInFindUsagesManager = true;
      //register cache invalidation
      FindUsagesManager.registerStructureModel(structureModelDescriptor);
    }
    assert structureModelDescriptor != null;
    return structureModelDescriptor;
  }

  @Nullable
  public SModelDescriptor getHelginsTypesystemModelDescriptor() {
    if (getLanguageDescriptor().getHelginsTypesystemModel() != null) {
      SModelUID modelUID = SModelUID.fromString(getLanguageDescriptor().getHelginsTypesystemModel().getName());
      SModelDescriptor modelDescriptor = SModelRepository.getInstance().getModelDescriptor(modelUID, this);
      if (modelDescriptor == null) {
        LOG.error("Couldn't get helgins-typesystem model \"" + modelUID + "\"");
      }
      return modelDescriptor;
    }
    return null;
  }

  @Nullable
  public SModelDescriptor getCFAModelDescriptor() {
    if (getLanguageDescriptor().getCfaModel() != null) {
      SModelUID modelUID = SModelUID.fromString(getLanguageDescriptor().getCfaModel().getName());
      SModelDescriptor modelDescriptor = SModelRepository.getInstance().getModelDescriptor(modelUID, this);
      if (modelDescriptor == null) {
        LOG.error("Couldn't get cfa model \"" + modelUID + "\"");
      }
      return modelDescriptor;
    }
    return null;
  }

  @Nullable
  public SModelDescriptor getActionsModelDescriptor() {
    if (getLanguageDescriptor().getActionsModel() != null) {
      SModelUID modelUID = SModelUID.fromString(getLanguageDescriptor().getActionsModel().getName());
      SModelDescriptor modelDescriptor = SModelRepository.getInstance().getModelDescriptor(modelUID, this);
      if (modelDescriptor == null) {
        LOG.error("Couldn't get actions model \"" + modelUID + "\"");
      }
      return modelDescriptor;
    }
    return null;
  }

  @Nullable
  public SModelDescriptor getConstraintsModelDescriptor() {
    if (getLanguageDescriptor().getConstraintsModel() != null) {
      SModelUID modelUID = SModelUID.fromString(getLanguageDescriptor().getConstraintsModel().getName());
      SModelDescriptor modelDescriptor = SModelRepository.getInstance().getModelDescriptor(modelUID, this);
      if (modelDescriptor == null) {
        LOG.error("Couldn't get constraints model \"" + modelUID + "\"");
      }
      return modelDescriptor;
    }
    return null;
  }

  @Nullable
  public SModelDescriptor getIntentionsModelDescriptor() {
    if (getLanguageDescriptor().getIntentionsModel() != null) {
      SModelUID modelUID = SModelUID.fromString(getLanguageDescriptor().getIntentionsModel().getName());
      SModelDescriptor modelDescriptor = SModelRepository.getInstance().getModelDescriptor(modelUID, this);
      if (modelDescriptor == null) {
        LOG.error("Couldn't get intentions model \"" + modelUID + "\"");
      }
      return modelDescriptor;
    }
    return null;
  }

  @Nullable
  public SModelDescriptor getFindUsagesModelDescriptor() {
    if (getLanguageDescriptor().getFindUsagesModel() != null) {
      SModelUID modelUID = SModelUID.fromString(getLanguageDescriptor().getFindUsagesModel().getName());
      SModelDescriptor modelDescriptor = SModelRepository.getInstance().getModelDescriptor(modelUID, this);
      if (modelDescriptor == null) {
        LOG.error("Couldn't get find usages model \"" + modelUID + "\"");
      }
      return modelDescriptor;
    }
    return null;
  }

  @Nullable
  public SModelDescriptor getScriptsModelDescriptor() {
    if (getLanguageDescriptor().getScriptsModel() != null) {
      SModelUID modelUID = SModelUID.fromString(getLanguageDescriptor().getScriptsModel().getName());
      SModelDescriptor modelDescriptor = SModelRepository.getInstance().getModelDescriptor(modelUID, this);
      if (modelDescriptor == null) {
        LOG.error("Couldn't get scripts model \"" + modelUID + "\"");
      }
      return modelDescriptor;
    }
    return null;
  }

  @Nullable
  public SModelDescriptor getDocumentationModelDescriptor() {
    if (getLanguageDescriptor().getDocumentationModel() != null) {
      SModelUID modelUID = SModelUID.fromString(getLanguageDescriptor().getDocumentationModel().getName());
      SModelDescriptor modelDescriptor = SModelRepository.getInstance().getModelDescriptor(modelUID, this);
      if (modelDescriptor == null) {
        LOG.error("Couldn't get scripts model \"" + modelUID + "\"");
      }
      return modelDescriptor;
    }
    return null;
  }

  @Nullable
  public SModelDescriptor getEditorModelDescriptor() {
    return getEditorModelDescriptor(null);
  }

  @Nullable
  public String getEditorUID() {
    return getEditorUID(null);
  }

  @Nullable
  public SModelDescriptor getEditorModelDescriptor(String stereotype) {
    if (stereotype == null) stereotype = SModelStereotype.NONE;
    String editorUID = getEditorUID(stereotype);
    if (editorUID == null) {
      return null;
    }
    SModelDescriptor modelDescriptor = SModelRepository.getInstance().getModelDescriptor(SModelUID.fromString(editorUID), this);
    if (modelDescriptor == null) {
      LOG.error("Couldn't get editor model \"" + editorUID + "\"");
      SModelRepository.getInstance().getModelDescriptor(SModelUID.fromString(editorUID), this);
    }
    return modelDescriptor;
  }

  @NotNull
  public Set<SModelDescriptor> getEditorDescriptors() {
    Set<SModelDescriptor> result = new HashSet<SModelDescriptor>();
    Iterator<Editor> editors = getLanguageDescriptor().editors();
    while (editors.hasNext()) {
      Editor editor = editors.next();
      result.add(getEditorModelDescriptor(editor.getStereotype()));
    }
    return result;
  }

  @NotNull
  public Set<SModelDescriptor> getAspectModelDescriptors() {
    Set<SModelDescriptor> result = new HashSet<SModelDescriptor>();
    SModelDescriptor structureModelDescriptor = getStructureModelDescriptor();
    result.add(structureModelDescriptor);
    result.addAll(getEditorDescriptors());
    SModelDescriptor actionsModelDescriptor = getActionsModelDescriptor();
    if (actionsModelDescriptor != null) result.add(actionsModelDescriptor);
    SModelDescriptor constraintsModelDescriptor = getConstraintsModelDescriptor();
    if (constraintsModelDescriptor != null) result.add(constraintsModelDescriptor);
    SModelDescriptor helginsModelDescriptor = getHelginsTypesystemModelDescriptor();
    if (helginsModelDescriptor != null) result.add(helginsModelDescriptor);
    SModelDescriptor scriptsModelDescriptor = getScriptsModelDescriptor();
    if (scriptsModelDescriptor != null) result.add(scriptsModelDescriptor);
    SModelDescriptor documentationModelDescriptor = getDocumentationModelDescriptor();
    if (documentationModelDescriptor != null) result.add(documentationModelDescriptor);
    SModelDescriptor intentionsModelDescriptor = getIntentionsModelDescriptor();
    if (intentionsModelDescriptor != null) result.add(intentionsModelDescriptor);
    SModelDescriptor findUsagesModelDescriptor = getFindUsagesModelDescriptor();
    if (findUsagesModelDescriptor != null) result.add(findUsagesModelDescriptor);
    return result;
  }

  @Nullable
  public String getEditorUID(String stereotype) {
    if (stereotype == null) stereotype = SModelStereotype.NONE;
    Iterator<Editor> editors = getLanguageDescriptor().editors();
    while (editors.hasNext()) {
      Editor currentEditor = editors.next();
      String currentStereotype = currentEditor.getStereotype();
      if (currentStereotype == null) currentStereotype = SModelStereotype.NONE;
      if (currentStereotype.equals(stereotype)) return currentEditor.getEditorModel().getName();
    }
    return null;
  }

  @Nullable
  public String getEditorStereotype(SModelDescriptor modelDescriptor) {
    String anUID = modelDescriptor.getModelUID().toString();
    for (Editor editor : CollectionUtil.iteratorAsIterable(getLanguageDescriptor().editors())) {
      if (anUID.equals(editor.getEditorModel().getName())) return editor.getStereotype();
    }
    return null;
  }

  public void invalidateCaches() {
    super.invalidateCaches();
    myNameToConceptCache.clear();
    myParentsNamesMap.clear();
  }

  @Nullable
  public AbstractConceptDeclaration findConceptDeclaration(@NotNull String conceptName) {
    if (myNameToConceptCache.isEmpty()) {
      SModelDescriptor structureModelDescriptor = getStructureModelDescriptor();
      SModel structureModel = structureModelDescriptor.getSModel();
      structureModel.allAdapters(INodeAdapter.class, new Condition<INodeAdapter>() {
        public boolean met(INodeAdapter node) {
          if (node instanceof AbstractConceptDeclaration) {
            myNameToConceptCache.put(node.getName(), (AbstractConceptDeclaration) node);
          }
          return false;
        }
      });
    }
    return myNameToConceptCache.get(conceptName);
  }

  @NotNull
  public Set<String> getParentNames(String conceptFqName) {
    if (myParentsNamesMap.containsKey(conceptFqName)) {
      //return new HashSet<String>(myParentsNamesMap.get(conceptFqName));
      return myParentsNamesMap.get(conceptFqName);
    } else {
      Set<String> result = new HashSet<String>();
      AbstractConceptDeclaration declaration = findConceptDeclaration(NameUtil.shortNameFromLongName(conceptFqName));
      if (declaration == null) {
        return result;
      }

      result.add(conceptFqName);

      if (declaration instanceof ConceptDeclaration) {
        ConceptDeclaration cd = (ConceptDeclaration) declaration;
        if (cd.getExtends() != null) {
          result.addAll(SModelUtil_new.getDeclaringLanguage(
                  cd.getExtends(), GlobalScope.getInstance()).getParentNames(
                  NameUtil.nodeFQName(cd.getExtends())));
        }

        for (InterfaceConceptReference icr : cd.getImplementses()) {
          result.addAll(SModelUtil_new.getDeclaringLanguage(
                  icr.getIntfc(), GlobalScope.getInstance()).getParentNames(
                  NameUtil.nodeFQName(icr.getIntfc())));
        }
      }

      if (declaration instanceof InterfaceConceptDeclaration) {
        InterfaceConceptDeclaration icd = (InterfaceConceptDeclaration) declaration;
        for (InterfaceConceptReference icr : icd.getExtendses()) {
          result.addAll(SModelUtil_new.getDeclaringLanguage(
                  icr.getIntfc(), GlobalScope.getInstance()).getParentNames(
                  NameUtil.nodeFQName(icr.getIntfc())));
        }
      }

      myParentsNamesMap.put(conceptFqName, result);
      //return new HashSet<String>(result);
      return result;
    }
  }

  public void save() {
    DescriptorsPersistence.saveLanguageDescriptor(myDescriptorFile, getLanguageDescriptor());
  }

  @NotNull
  public List<SModelDescriptor> getAccessoryModels() {
    List<SModelDescriptor> result = new LinkedList<SModelDescriptor>();
    Iterator<Model> accessoryModels = getLanguageDescriptor().accessoryModels();
    while (accessoryModels.hasNext()) {
      Model model = accessoryModels.next();
      SModelDescriptor modelDescriptor = getScope().getModelDescriptor(SModelUID.fromString(model.getName()));
      if (modelDescriptor != null) {
        result.add(modelDescriptor);
      }
    }
    return result;
  }

  public boolean isAccessoryModel(@NotNull SModelUID modelUID) {
    Iterator<Model> accessoryModels = getLanguageDescriptor().accessoryModels();
    while (accessoryModels.hasNext()) {
      Model model = accessoryModels.next();
      SModelUID accessoryUID = SModelUID.fromString(model.getName());
      if (accessoryUID.equals(modelUID)) {
        return true;
      }
    }
    return false;
  }

  public String toString() {
    return getLanguageDescriptor().getNamespace();
  }

  public void addLanguageCommandListener(@NotNull LanguageCommandListener listener) {
    myCommandListeners.add(listener);
  }

  public void removeLanguageCommandListener(@NotNull LanguageCommandListener listener) {
    myCommandListeners.remove(listener);
  }

  @Hack("Created to simplify New Language Dialog")
  public ModelRoot getDefaultModelRoot() {
    return getLanguageDescriptor().modelRoots().next();
  }

  public SModelDescriptor createLanguageEditorModel() {
    ModelRoot modelRoot = null;
    List<ModelRoot> modelRoots = this.getModelRoots();
    for (ModelRoot mRoot : modelRoots) {
      IModelRootManager rootManager = ModelRootsUtil.getManagerFor(mRoot);
      if (rootManager instanceof DefaultModelRootManager) {
        modelRoot = mRoot;
        break;
      }
    }

    assert modelRoot != null;

    SModelDescriptor editorModelDescriptor = this.createModel(new SModelUID(this.getModuleUID(), "editor", ""), modelRoot);
    SModel editorModel = editorModelDescriptor.getSModel();
    editorModel.addNewlyImportedLanguage(BootstrapLanguages.getInstance().getEditorLanguage());
    editorModelDescriptor.save();

    // updateTypesystem language
    LanguageDescriptor languageDescriptor = this.getLanguageDescriptor();
    Model _model = Model.newInstance(languageDescriptor.getModel());
    _model.setName(editorModel.getUID().toString());
    Editor _editor = Editor.newInstance(languageDescriptor.getModel());
    _editor.setEditorModel(_model);
    _editor.setStereotype("");
    languageDescriptor.addEditor(_editor);
    this.setLanguageDescriptor(languageDescriptor);
    this.save();

    return editorModelDescriptor;
  }

  public SModelDescriptor createLanguageBehaviorModel() {
    ModelRoot modelRoot = null;
    List<ModelRoot> modelRoots = this.getModelRoots();
    for (ModelRoot mRoot : modelRoots) {
      IModelRootManager rootManager = ModelRootsUtil.getManagerFor(mRoot);
      if (rootManager instanceof DefaultModelRootManager) {
        modelRoot = mRoot;
        break;
      }
    }

    assert modelRoot != null;

    SModelDescriptor behaviorModelDescriptor = this.createModel(new SModelUID(this.getModuleUID(), "constraints", ""), modelRoot);
    SModel behaviorModel = behaviorModelDescriptor.getSModel();
    behaviorModel.addNewlyImportedLanguage(BootstrapLanguages.getInstance().getBaseLanguage());
    behaviorModel.addNewlyImportedLanguage(BootstrapLanguages.getInstance().getSModelLanguage());
    behaviorModel.addNewlyImportedLanguage(BootstrapLanguages.getInstance().getConstraintsLanguage());
    behaviorModelDescriptor.save();

    // updateTypesystem language
    LanguageDescriptor languageDescriptor = this.getLanguageDescriptor();
    Model _model = Model.newInstance(languageDescriptor.getModel());
    _model.setName(behaviorModel.getUID().toString());
    languageDescriptor.setConstraintsModel(_model);
    this.setLanguageDescriptor(languageDescriptor);
    this.save();

    return behaviorModelDescriptor;
  }

  public SModelDescriptor createHelginsModel() {
    ModelRoot modelRoot = null;
    List<ModelRoot> modelRoots = this.getModelRoots();
    for (ModelRoot mRoot : modelRoots) {
      IModelRootManager rootManager = ModelRootsUtil.getManagerFor(mRoot);
      if (rootManager instanceof DefaultModelRootManager) {
        modelRoot = mRoot;
        break;
      }
    }

    assert modelRoot != null;

    SModelDescriptor helginsModelDescriptor = this.createModel(new SModelUID(this.getModuleUID(), "helgins", ""), modelRoot);
    SModel helginsModel = helginsModelDescriptor.getSModel();
    helginsModel.addNewlyImportedLanguage(BootstrapLanguages.getInstance().getBaseLanguage());
    helginsModel.addNewlyImportedLanguage(BootstrapLanguages.getInstance().getSModelLanguage());
    helginsModel.addNewlyImportedLanguage(BootstrapLanguages.getInstance().getConstraintsLanguage());
    helginsModel.addNewlyImportedLanguage(BootstrapLanguages.getInstance().getHelginsLanguage());
    helginsModelDescriptor.save();

    // updateTypesystem language
    LanguageDescriptor languageDescriptor = this.getLanguageDescriptor();
    Model _model = Model.newInstance(languageDescriptor.getModel());
    _model.setName(helginsModel.getUID().toString());
    languageDescriptor.setHelginsTypesystemModel(_model);
    this.setLanguageDescriptor(languageDescriptor);
    this.save();

    return helginsModelDescriptor;
  }

  public SModelDescriptor createIntentionsModel() {
    ModelRoot modelRoot = null;
    List<ModelRoot> modelRoots = this.getModelRoots();
    for (ModelRoot mRoot : modelRoots) {
      IModelRootManager rootManager = ModelRootsUtil.getManagerFor(mRoot);
      if (rootManager instanceof DefaultModelRootManager) {
        modelRoot = mRoot;
        break;
      }
    }

    assert modelRoot != null;

    SModelDescriptor intentionsModelDescriptor = this.createModel(new SModelUID(this.getModuleUID(), "intentions", ""), modelRoot);
    SModel intentionsModel = intentionsModelDescriptor.getSModel();
    intentionsModel.addNewlyImportedLanguage(BootstrapLanguages.getInstance().getBaseLanguage());
    intentionsModel.addNewlyImportedLanguage(BootstrapLanguages.getInstance().getSModelLanguage());
    intentionsModel.addNewlyImportedLanguage(BootstrapLanguages.getInstance().getIntentionsLanguage());
    intentionsModelDescriptor.save();

    LanguageDescriptor languageDescriptor = this.getLanguageDescriptor();
    Model _model = Model.newInstance(languageDescriptor.getModel());
    _model.setName(intentionsModel.getUID().toString());
    languageDescriptor.setIntentionsModel(_model);
    this.setLanguageDescriptor(languageDescriptor);
    this.save();

    return intentionsModelDescriptor;
  }

  public SModelDescriptor createFindUsagesModel() {
    ModelRoot modelRoot = null;
    List<ModelRoot> modelRoots = this.getModelRoots();
    for (ModelRoot mRoot : modelRoots) {
      IModelRootManager rootManager = ModelRootsUtil.getManagerFor(mRoot);
      if (rootManager instanceof DefaultModelRootManager) {
        modelRoot = mRoot;
        break;
      }
    }

    assert modelRoot != null;

    SModelDescriptor findUsagesModelDescriptor = this.createModel(new SModelUID(this.getModuleUID(), "findUsages", ""), modelRoot);
    SModel findUsagesModel = findUsagesModelDescriptor.getSModel();
    findUsagesModel.addNewlyImportedLanguage(BootstrapLanguages.getInstance().getBaseLanguage());
    findUsagesModel.addNewlyImportedLanguage(BootstrapLanguages.getInstance().getSModelLanguage());
    findUsagesModel.addNewlyImportedLanguage(BootstrapLanguages.getInstance().getFindUsagesLanguage());
    findUsagesModelDescriptor.save();

    LanguageDescriptor languageDescriptor = this.getLanguageDescriptor();
    Model _model = Model.newInstance(languageDescriptor.getModel());
    _model.setName(findUsagesModel.getUID().toString());
    languageDescriptor.setFindUsagesModel(_model);
    this.setLanguageDescriptor(languageDescriptor);
    this.save();

    return findUsagesModelDescriptor;
  }

  private class LanguageEventTranslator extends CommandEventTranslator {
    public void languageChanged() {
      markCurrentCommandsDirty();
    }

    protected void fireCommandEvent() {
      for (LanguageCommandListener l : myCommandListeners) {
        l.languageChangedInCommand(Language.this);
      }
    }
  }

  @NotNull
  public List<Language> getOwnLanguages() {
    List<Language> languages = super.getOwnLanguages();
    if (!languages.contains(this)) {
      languages.add(this);
    }
    return languages;
  }


  public Set<ILoggableRefactoring> getRefactorings() {
    Set<ILoggableRefactoring> result = new HashSet<ILoggableRefactoring>();
    SModelDescriptor scriptsModelDescriptor = getScriptsModelDescriptor();
    if (scriptsModelDescriptor == null) {
      return result;
    }
    SModel scriptsModel = scriptsModelDescriptor.getSModel();
    String packageName = scriptsModel.getLongName();
    for (Refactoring refactoring : scriptsModel.allAdapters(Refactoring.class)) {
      try {
        String fqName = packageName + "." + refactoring.getName();
        Class<ILoggableRefactoring> cls = getClass(fqName);
        if (cls == null) {
          LOG.error("Can't find " + fqName);
          continue;
        }
        result.add(cls.getConstructor().newInstance());
      } catch (Throwable t) {
        LOG.error(t);
      }
    }
    return result;
  }

  public static Language getLanguageForLanguageAspect(SModelDescriptor modelDescriptor) {
    return getLanguageFor(modelDescriptor);
  }

  public LanguageAspect getAspectForModel(SModelDescriptor sm) {
    for (LanguageAspect la : LanguageAspect.values()) {
      if (la.get(this) == sm) {
        return la;
      }
    }
    return null;
  }


  public static LanguageAspect getModelAspect(SModelDescriptor sm) {
    Set<ModelOwner> owners = SModelRepository.getInstance().getOwners(sm);
    for (ModelOwner modelOwner : owners) {
      if (modelOwner instanceof Language) {
        Language l = (Language) modelOwner;
        if (l.getAspectForModel(sm) != null) {
          return l.getAspectForModel(sm);
        }
      }
    }
    return null;
  }

  public static boolean isAccessoryModel(SModelDescriptor sm) {
    Set<ModelOwner> owners = SModelRepository.getInstance().getOwners(sm);
    for (ModelOwner modelOwner : owners) {
      if (modelOwner instanceof Language) {
        Language l = (Language) modelOwner;
        if (l.isAccessoryModel(sm.getModelUID())) {
          return true;
        }
      }
    }
    return false;
  }

  public static Language getLanguageFor(SModelDescriptor sm) {
    Set<ModelOwner> owners = SModelRepository.getInstance().getOwners(sm);
    for (ModelOwner modelOwner : owners) {
      if (modelOwner instanceof Language) {
        return (Language) modelOwner;
      }
    }
    return null;
  }

  private class LanguageModelsAdapter extends SModelsAdapter {
    public void modelWillBeDeleted(SModelDescriptor modelDescriptor) {

      LanguageAspect aspect = getModelAspect(modelDescriptor);
      Language language = getLanguageFor(modelDescriptor);

      if (aspect != null && language != null) {
        LanguageDescriptor languageDescriptor = getLanguageDescriptor();
        if (aspect == LanguageAspect.STRUCTURE) {
          languageDescriptor.removeChild(languageDescriptor.getStructureModel());
        } else if (aspect == LanguageAspect.EDITOR) {
          Iterator<Editor> iterator = languageDescriptor.editors();
          while (iterator.hasNext()) {
            Editor editor = iterator.next();
            String name = editor.getEditorModel().getName();
            if (EqualUtil.equals(name, modelDescriptor.getModelUID().toString())) {
              languageDescriptor.removeChild(editor);
              break;
            }
          }
        } else if (aspect == LanguageAspect.HELGINS_TYPESYSTEM) {
          languageDescriptor.removeChild(languageDescriptor.getHelginsTypesystemModel());
        } else if (aspect == LanguageAspect.ACTIONS) {
          languageDescriptor.removeChild(languageDescriptor.getActionsModel());
        } else if (aspect == LanguageAspect.CONSTRAINTS) {
          languageDescriptor.removeChild(languageDescriptor.getConstraintsModel());
        }
      }
    }
  } // private class LanguageModelsAdapter
}
