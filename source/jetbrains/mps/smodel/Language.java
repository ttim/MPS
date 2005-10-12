package jetbrains.mps.smodel;

import jetbrains.mps.bootstrap.structureLanguage.ConceptDeclaration;
import jetbrains.mps.findUsages.FindUsagesManager;
import jetbrains.mps.ide.IStatus;
import jetbrains.mps.ide.command.CommandEventTranslator;
import jetbrains.mps.ide.command.CommandProcessor;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.project.AbstractModule;
import jetbrains.mps.project.IModule;
import jetbrains.mps.projectLanguage.*;
import jetbrains.mps.smodel.event.*;
import jetbrains.mps.util.*;
import jetbrains.mps.annotations.Hack;

import java.io.File;
import java.util.*;


/**
 * Author: Sergey Dmitriev
 * Created Jan 30, 2004
 */
public class Language extends AbstractModule {
  private static final Logger LOG = Logger.getLogger(Language.class);

  private LanguageDescriptor myLanguageDescriptor;
  private List<Generator> myGenerators;

  private HashMap<String, ConceptDeclaration> myNameToConceptCache = new HashMap<String, ConceptDeclaration>();
  private List<LanguageCommandListener> myCommandListeners = new ArrayList<LanguageCommandListener>();
  private LanguageEventTranslator myEventTranslator = new LanguageEventTranslator();
  private SModelsListener myModelsListener = new LanguageModelsAdapter();
  private boolean myUpToDate = true;
  private boolean myUpdateLastGenerationTimeCalled = false;

  private SModelCommandListener myAspectModelsListener = new SModelCommandListener() {
    public void modelChangedInCommand(List<SModelEvent> events, EditorContext editorContext) {
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

  private long myLastGenerationTime = 0;
  private boolean myRegisteredInFindUsagesManager;

  public ModuleDescriptor getModuleDescriptor() {
    return myLanguageDescriptor;
  }

  public static Language newInstance(File descriptorFile, LanguageOwner languageOwner) {
    Language language = new Language();
    SModel model = ProjectModelDescriptor.createDescriptorFor(language).getSModel();
    LanguageDescriptor languageDescriptor = PersistenceUtil.loadLanguageDescriptor(descriptorFile, model);
    language.myDescriptorFile = descriptorFile;
    language.myLanguageDescriptor = languageDescriptor;
    LanguageRepository.getInstance().addLanguage(language, languageOwner);
    language.init();
    return language;
  }

  public static Language createLanguage(String languageNamespace, File descriptorFile, LanguageOwner languageOwner) {
    Language language = new Language();
    SModel descriptorModel = ProjectModelDescriptor.createDescriptorFor(language).getSModel();
    descriptorModel.setLoading(true);
    LanguageDescriptor languageDescriptor = new LanguageDescriptor(descriptorModel);
    descriptorModel.addRoot(languageDescriptor);
    languageDescriptor.setNamespace(languageNamespace);

    // default descriptorModel roots
    ModelRoot modelRoot = new ModelRoot(descriptorModel);
    modelRoot.setPath(new File(descriptorFile.getParentFile(), "languageModels").getAbsolutePath());
    modelRoot.setPrefix(languageNamespace);
    languageDescriptor.addModelRoot(modelRoot);
    modelRoot = new ModelRoot(descriptorModel);
    modelRoot.setPath(new File(descriptorFile.getParentFile(), "languageAccessories").getAbsolutePath());
    modelRoot.setPrefix(languageNamespace);
    languageDescriptor.addModelRoot(modelRoot);

    language.myDescriptorFile = descriptorFile;
    language.myLanguageDescriptor = languageDescriptor;
    LanguageRepository.getInstance().addLanguage(language, languageOwner);
    language.init();
    return language;
  }

  private Language() {
  }

  private void init() {
    // read models
    SModelRepository.getInstance().readModelDescriptors(getModelRoots(), this);
    revalidateGenerators();


    CommandProcessor.instance().addCommandListener(myEventTranslator);
    SModelsMulticaster.getInstance().addSModelsListener(myModelsListener);
    registerAspectListener();
  }

  private void revalidateGenerators() {
    myGenerators = new LinkedList<Generator>();
    Iterator<GeneratorDescriptor> generators = getLanguageDescriptor().generators();
    while (generators.hasNext()) {
      GeneratorDescriptor generatorDescriptor = generators.next();
      myGenerators.add(new Generator(this, generatorDescriptor));
    }
  }

  public void dispose() {
    LOG.assertLog(!LanguageRepository.getInstance().hasOwners(this));

    CommandProcessor.instance().removeCommandListener(myEventTranslator);
    SModelsMulticaster.getInstance().removeSModelsListener(myModelsListener);
    SModelRepository.getInstance().unRegisterModelDescriptors(this);
    if (myGenerators != null) {
      for (Generator generator : myGenerators) {
        generator.dispose();
      }
    }
  }

  public File getDescriptorFile() {
    return myDescriptorFile;
  }

  public void setLanguageDescriptor(final LanguageDescriptor newDescriptor) {
    // release languages and models (except descriptor model)
    unregisterAspectListener();
    SModelDescriptor modelDescriptor = SModelRepository.getInstance().getModelDescriptor(newDescriptor.getModel().getUID(), Language.this);
    LanguageRepository.getInstance().unRegisterLanguages(Language.this);
    SModelRepository.getInstance().unRegisterModelDescriptors(Language.this);
    SModelRepository.getInstance().registerModelDescriptor(modelDescriptor, Language.this);
    for (Generator generator : getGenerators()) {
      generator.dispose();
    }

    myLanguageDescriptor = newDescriptor;
    SModelRepository.getInstance().readModelDescriptors(getModelRoots(), Language.this);
    revalidateGenerators();

    registerAspectListener();
    updateLastGenerationTime();
    myEventTranslator.languageChanged();
  }

  private void registerAspectListener() {
    for (SModelDescriptor aspectModel : getAspectModelDescriptors()) {
      if (aspectModel != null) aspectModel.addSModelCommandListener(myAspectModelsListener);
    }
  }

  private void unregisterAspectListener() {
    for (SModelDescriptor aspectModel : getAspectModelDescriptors()) {
      if (aspectModel != null) aspectModel.removeSModelCommandListener(myAspectModelsListener);
    }
  }

  public LanguageDescriptor getLanguageDescriptor() {
    return myLanguageDescriptor;
  }

  public void updateLastGenerationTime() {
    myLastGenerationTime = FileUtil.getNewestFileTime(getSourceDir());
    long lastChangeTime = getLastChangeTime();
    myUpToDate = myLastGenerationTime >= lastChangeTime;
    myUpdateLastGenerationTimeCalled = true;
  }

  public List<Generator> getGenerators() {
    return myGenerators;
  }

  public String getNamespace() {
    return getLanguageDescriptor().getNamespace();
  }

  public File getSourceDir() {
    File sourceDir = new File(myDescriptorFile.getParent(), "source_gen");
    if (getLanguageDescriptor().getLanguageGenPath() != null) {
      sourceDir = new File(getLanguageDescriptor().getLanguageGenPath());
    }
    if (!sourceDir.exists()) {
      sourceDir.mkdirs();
    }
    return sourceDir;
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
    result = Math.max(result, repository.getLastChangeTime(getEditorModelDescriptor()));
    result = Math.max(result, repository.getLastChangeTime(getActionsModelDescriptor()));
    result = Math.max(result, repository.getLastChangeTime(getTypesystemModelDescriptor()));
    return result;
  }

  public List<ConceptDeclaration> getConceptDeclarations() {
    return SModelUtil.allNodes(getStructureModelDescriptor().getSModel(), new Condition<SNode>() {
      public boolean met(SNode object) {
        return object instanceof ConceptDeclaration;
      }
    });
  }

  public SModelDescriptor getStructureModelDescriptor() {
    if (getLanguageDescriptor().getStructureModel() != null) {
      SModelUID modelUID = SModelUID.fromString(getLanguageDescriptor().getStructureModel().getName());
      SModelDescriptor structureModelDescriptor = SModelRepository.getInstance().getModelDescriptor(modelUID, this);
      if (structureModelDescriptor == null) {
        LOG.errorWithTrace("Couldn't get structure model \"" + modelUID + "\"");
      } else if (!myRegisteredInFindUsagesManager) {
        myRegisteredInFindUsagesManager = true;
        //register cache invalidation
        FindUsagesManager.registerStructureModel(structureModelDescriptor);
      }
      return structureModelDescriptor;
    }
    return null;
  }

  public SModelDescriptor getTypesystemModelDescriptor() {
    if (getLanguageDescriptor().getTypeSystem() != null) {
      SModelUID modelUID = SModelUID.fromString(getLanguageDescriptor().getTypeSystem().getName());
      return SModelRepository.getInstance().getModelDescriptor(modelUID, this);
    }
    return null;
  }

  public SModelDescriptor getActionsModelDescriptor() {
    if (getLanguageDescriptor().getActionsModel() != null) {
      SModelUID modelUID = SModelUID.fromString(getLanguageDescriptor().getActionsModel().getName());
      return SModelRepository.getInstance().getModelDescriptor(modelUID, this);
    }
    return null;
  }

  public SModelDescriptor getEditorModelDescriptor() {
    return getEditorModelDescriptor(null);
  }

  public String getEditorUID() {
    return getEditorUID(null);
  }

  public SModelDescriptor getEditorModelDescriptor(String stereotype) {
    if (stereotype == null) stereotype = SModelStereotype.NONE;
    String editorUID = getEditorUID(stereotype);
    if (editorUID == null) {
      return null;
    }
    return SModelRepository.getInstance().getModelDescriptor(SModelUID.fromString(editorUID), this);
  }

  public Set<SModelDescriptor> getEditorDescriptors() {
    Set<SModelDescriptor> result = new HashSet<SModelDescriptor>();
    Iterator<Editor> editors = getLanguageDescriptor().editors();
    while (editors.hasNext()) {
      Editor editor = editors.next();
      result.add(getEditorModelDescriptor(editor.getStereotype()));
    }
    return result;
  }

  public Set<SModelDescriptor> getAspectModelDescriptors() {
    Set<SModelDescriptor> result = new HashSet<SModelDescriptor>();
    SModelDescriptor structureModelDescriptor = getStructureModelDescriptor();
    if (structureModelDescriptor != null) result.add(structureModelDescriptor);
    result.addAll(getEditorDescriptors());
    SModelDescriptor typesystemModelDescriptor = getTypesystemModelDescriptor();
    if (typesystemModelDescriptor != null) result.add(typesystemModelDescriptor);
    SModelDescriptor actionsModelDescriptor = getActionsModelDescriptor();
    if (actionsModelDescriptor != null) result.add(actionsModelDescriptor);
    return result;
  }

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

  public String getEditorStereotype(SModelDescriptor modelDescriptor) {
    String anUID = modelDescriptor.getModelUID().toString();
    for (Editor editor : CollectionUtil.iteratorAsIterable(getLanguageDescriptor().editors())) {
      if (anUID.equals(editor.getEditorModel().getName())) return editor.getStereotype();
    }
    return null;
  }

  public void invalidateCaches() {
    myNameToConceptCache.clear();
  }

  public ConceptDeclaration findConceptDeclaration(String conceptName) {
    if (myNameToConceptCache.isEmpty()) {
      SModel structureModel = getStructureModelDescriptor().getSModel();
      SModelUtil.allNodes(structureModel, new Condition<SNode>() {
        public boolean met(SNode node) {
          if (node instanceof ConceptDeclaration) {
            myNameToConceptCache.put(node.getName(), (ConceptDeclaration) node);
          }
          return false;
        }
      });
    }
    return myNameToConceptCache.get(conceptName);
  }

  public void save() {
    PersistenceUtil.saveLanguageDescriptor(myDescriptorFile, getLanguageDescriptor());
  }

  public List<SModelDescriptor> getAccessoryModels() {
    List<SModelDescriptor> result = new LinkedList<SModelDescriptor>();
    Iterator<Model> accessoryModels = getLanguageDescriptor().accessoryModels();
    while (accessoryModels.hasNext()) {
      Model model = accessoryModels.next();
      SModelDescriptor modelDescriptor = getModelDescriptor(SModelUID.fromString(model.getName()));
      if (modelDescriptor != null) {
        result.add(modelDescriptor);
      }
    }
    return result;
  }

  public boolean isAccessoryModel(SModelUID modelUID) {
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

  public void addLanguageCommandListener(LanguageCommandListener listener) {
    myCommandListeners.add(listener);
  }

  public void removeLanguageCommandListener(LanguageCommandListener listener) {
    myCommandListeners.remove(listener);
  }

  @Hack("Created to simplify New Language Dialog")
  public String getLanguageModelsDir() {
    return getLanguageDescriptor().modelRoots().next().getPath();
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

  protected List<ModelRoot> getModelRootsImpl() {
    return CollectionUtil.iteratorAsList(myLanguageDescriptor.modelRoots());
  }

  public List<IModule> getChildModules() {
    return (List<IModule>) ((List) getGenerators());
  }

  public List<Language> getLanguages() {
    List<Language> languages = super.getLanguages();
    if (!languages.contains(this)) {
      languages.add(this);
    }
    return languages;
  }

  public Language getLanguage(String languageNamespace) {
    if (getNamespace().equals(languageNamespace)) {
      return this;
    }
    return super.getLanguage(languageNamespace);
  }
  // ----------------------------
  // language - related utilities
  // ----------------------------

  public static LanguageAspectStatus getLanguageAspectStatus(SModelDescriptor modelDescriptor) {
    Set<ModelOwner> owners = SModelRepository.getInstance().getOwners(modelDescriptor);
    LanguageAspectStatus accessoryStatus = null;
    try {

      for (ModelOwner modelOwner : owners) {
        if (modelOwner instanceof Language) {
          LanguageAspectStatus languageAspectStatus = getLanguageAspectStatus((Language) modelOwner, modelDescriptor);
          if (languageAspectStatus.isLanguageAspect()) return languageAspectStatus;
          if (languageAspectStatus.isAccessoryModel()) accessoryStatus = languageAspectStatus;
        }
      }
    } catch (ConcurrentModificationException e) {
      e.printStackTrace();
    }
    if (accessoryStatus != null) return accessoryStatus;
    return new LanguageAspectStatus(null, LanguageAspectStatus.AspectKind.NONE);
  }

  public static LanguageAspectStatus getLanguageAspectStatus(Language language, SModelDescriptor modelDescriptor) {
    if (modelDescriptor == language.getStructureModelDescriptor()) {
      return new LanguageAspectStatus(language, LanguageAspectStatus.AspectKind.STRUCTURE);
    }
    if (modelDescriptor == language.getTypesystemModelDescriptor()) {
      return new LanguageAspectStatus(language, LanguageAspectStatus.AspectKind.TYPESYSTEM);
    }
    if (modelDescriptor == language.getActionsModelDescriptor()) {
      return new LanguageAspectStatus(language, LanguageAspectStatus.AspectKind.ACTIONS);
    }
    List<SModelDescriptor> acccessoryModels = language.getAccessoryModels();
    if (acccessoryModels.contains(modelDescriptor)) {
      return new LanguageAspectStatus(language, LanguageAspectStatus.AspectKind.ACCESSORY);
    }
    Set<SModelDescriptor> editorDescriptors = language.getEditorDescriptors();
    if (editorDescriptors.contains(modelDescriptor)) {
      return new LanguageAspectStatus(language, LanguageAspectStatus.AspectKind.EDITOR);
    }

    List<Generator> generators = language.getGenerators();
    for (Generator generator : generators) {
      SModelUID templatesModelUID = generator.getTemplatesModelUID();
      if (modelDescriptor.getModelUID().equals(templatesModelUID)) {
        return new LanguageAspectStatus(language, LanguageAspectStatus.AspectKind.GENERATOR_TEMPLATES);
      }
    }
    return new LanguageAspectStatus(null, LanguageAspectStatus.AspectKind.NONE);
  }

  public static class LanguageAspectStatus implements IStatus {
    public static enum AspectKind {
      STRUCTURE,EDITOR,ACTIONS,TYPESYSTEM,GENERATOR_TEMPLATES,ACCESSORY,NONE
    }

    private Language myLanguage;
    private AspectKind myAspectKind;

    public LanguageAspectStatus(Language language, AspectKind aspectKind) {
      myLanguage = language;
      myAspectKind = aspectKind;
    }

    public boolean isOk() {
      return true;
    }

    public boolean isError() {
      return false;
    }

    public Code getCode() {
      return Code.OK;
    }

    public String getMessage() {
      return "";
    }

    public Object getUserObject() {
      return null;
    }

    public Language getLanguage() {
      return myLanguage;
    }

    public boolean isLanguageAspect() {
      return myAspectKind != LanguageAspectStatus.AspectKind.NONE && myAspectKind != LanguageAspectStatus.AspectKind.ACCESSORY;
    }

    public boolean isStructure() {
      return myAspectKind == LanguageAspectStatus.AspectKind.STRUCTURE;
    }

    public boolean isEditor() {
      return myAspectKind == LanguageAspectStatus.AspectKind.EDITOR;
    }

    public boolean isTypesystem() {
      return myAspectKind == LanguageAspectStatus.AspectKind.TYPESYSTEM;
    }

    public boolean isActions() {
      return myAspectKind == LanguageAspectStatus.AspectKind.ACTIONS;
    }

    public boolean isGeneratorTemplates() {
      return myAspectKind == LanguageAspectStatus.AspectKind.GENERATOR_TEMPLATES;
    }

    public boolean isAccessoryModel() {
      return myAspectKind == LanguageAspectStatus.AspectKind.ACCESSORY;
    }
  }


  private class LanguageModelsAdapter extends SModelsAdapter {
    public void modelWillBeDeleted(SModelDescriptor modelDescriptor) {
      LanguageAspectStatus status = getLanguageAspectStatus(Language.this, modelDescriptor);
      if (status.isLanguageAspect()) {
        LanguageDescriptor languageDescriptor = getLanguageDescriptor();
        if (status.isStructure()) {
          languageDescriptor.removeChild(languageDescriptor.getStructureModel());
        } else if (status.isEditor()) {
          Iterator<Editor> iterator = languageDescriptor.editors();
          while (iterator.hasNext()) {
            Editor editor = iterator.next();
            String name = editor.getEditorModel().getName();
            if (EqualUtil.equals(name, modelDescriptor.getModelUID().toString())) {
              languageDescriptor.removeChild(editor);
              break;
            }
          }
        } else if (status.isTypesystem()) {
          languageDescriptor.removeChild(languageDescriptor.getTypeSystem());
        } else if (status.isActions()) {
          languageDescriptor.removeChild(languageDescriptor.getActionsModel());
        } else if (status.isGeneratorTemplates()) {
          Iterator<jetbrains.mps.projectLanguage.GeneratorDescriptor> iterator = languageDescriptor.generators();
          while (iterator.hasNext()) {
            jetbrains.mps.projectLanguage.GeneratorDescriptor generatorDescriptor = iterator.next();
            if (generatorDescriptor.getTemplatesModel().getName().equals(modelDescriptor.getModelUID().toString())) {
              languageDescriptor.removeChild(generatorDescriptor);
              break;
            }
          }
        }
      }
    }
  } // private class LanguageModelsAdapter
}
