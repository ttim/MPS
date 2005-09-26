package jetbrains.mps.project;

import jetbrains.mps.ide.BootstrapLanguages;
import jetbrains.mps.ide.FileUtil;
import jetbrains.mps.ide.IdeMain;
import jetbrains.mps.ide.command.CommandEventTranslator;
import jetbrains.mps.ide.command.CommandProcessor;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.projectLanguage.*;
import jetbrains.mps.reloading.ClassLoaderManager;
import jetbrains.mps.smodel.*;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.util.CollectionUtil;
import jetbrains.mps.util.JDOMUtil;
import jetbrains.mps.vcs.VersionControlManager;
import jetbrains.mps.vcs.model.IVersionControl;
import jetbrains.mps.components.IExternalizableComponent;
import jetbrains.mps.components.IContainer;
import org.jdom.Document;
import org.jdom.Element;

import java.io.File;
import java.util.*;

/**
 * Author: Sergey Dmitriev
 * Created Apr 29, 2004
 */

public class MPSProject implements ModelOwner, LanguageOwner, IScope, IContainer {
  private static final Logger LOG = Logger.getLogger(MPSProject.class);

  private File myProjectFile;
  private ProjectDescriptor myProjectDescriptor;

  private List<Solution> mySolutions = new LinkedList<Solution>();
  private List<Language> myLanguages;

  private File myWorkspaceFile;

  public static final String COMPONENTS = "components";
  public static final String COMPONENT = "component";
  public static final String CLASS = "class";

  private Map<Class, Object> myComponents = new HashMap<Class, Object>();
  private List<IMPSProjectCommandListener> myProjectCommandListeners = new ArrayList<IMPSProjectCommandListener>();
  private ProjectEventTranslator myEventTranslator;

  public MPSProject(final File projectFile) {
    CommandProcessor.instance().executeCommand(new Runnable() {
      public void run() {
        myProjectFile = projectFile;
        SModel model = ProjectModelDescriptor.createDescriptorFor(MPSProject.this).getSModel();
        myProjectDescriptor = PersistenceUtil.loadProjectDescriptor(projectFile, model);

        ClassLoaderManager.getInstance().setClassesDir(getClassPath());

        LOG.assertLog(myProjectDescriptor.isRoot(), "Project descriptor has to be root");
        revalidateContent(projectFile, model);

        MPSProjects projects = ApplicationComponents.getInstance().getComponent(MPSProjects.class);
        projects.addProject(MPSProject.this);

      }
    }, "MPS Project init");

    myEventTranslator = new ProjectEventTranslator();
    CommandProcessor.instance().addCommandListener(myEventTranslator);
  }


  public List<SModelDescriptor> getModelDescriptors() {
    return SModelRepository.getInstance().getAllModelDescriptors();
  }

  private void revalidateContent(File projectFile, final SModel projectModel) {
    // load solutions
    List<Solution> newSolutions = new LinkedList<Solution>();
    for (SolutionPath solutionPath : CollectionUtil.iteratorAsIterable(myProjectDescriptor.projectSolutions())) {
      File descriptorFile = new File(solutionPath.getPath());
      if (!descriptorFile.exists()) {
        LOG.error("Couldn't load solution from: " + descriptorFile.getAbsolutePath() + " : file doesn't exist");
        continue;
      }

      Solution loadedSolution = null;
      for (Solution solution : mySolutions) {
        if (solution.getDescriptorFile().equals(descriptorFile)) {
          loadedSolution = solution;
          break;
        }
      }

      if (loadedSolution != null) {
        // update solution
        SolutionDescriptor solutionDescriptor = PersistenceUtil.loadSolutionDescriptor(descriptorFile,
                ProjectModelDescriptor.createDescriptorFor(loadedSolution).getSModel());
        loadedSolution.setSolutionDescriptor(solutionDescriptor);
        newSolutions.add(loadedSolution);
        mySolutions.remove(loadedSolution);
      } else {
        newSolutions.add(new Solution(descriptorFile));
      }
    }

    // dispose other solutions
    for (Solution solution : mySolutions) {
      solution.dispose();
    }
    mySolutions.clear();
    mySolutions = newSolutions;

    // convert legacy project to new solution
    final Solution solution = Solution.createFromLegacyProjectFile(projectFile);
    if (solution != null) {
      projectModel.runLoadingAction(new Runnable() {
        public void run() {
          SolutionPath solutionPath = SolutionPath.newInstance(projectModel);
          solutionPath.setPath(solution.getDescriptorFile().getAbsolutePath());
          myProjectDescriptor.addProjectSolution(solutionPath);
        }
      });
      mySolutions.add(solution);
    }

    // load languages
    myLanguages = new LinkedList<Language>();
    for (LanguagePath languagePath : CollectionUtil.iteratorAsIterable(myProjectDescriptor.projectLanguages())) {
      File descriptorFile = new File(languagePath.getPath());
      if (descriptorFile.exists()) {
        myLanguages.add(LanguageRepository.getInstance().registerLanguage(descriptorFile, this));
      } else {
        LOG.error("Couldn't load language from: " + descriptorFile.getAbsolutePath() + " : file doesn't exist");
      }
    }
  }

  public IVersionControl getVCSFor(SModelDescriptor model) {
    return getComponent(VersionControlManager.class).createVCSFor(model);
  }

  public void setProjectDescriptor(final ProjectDescriptor newDescriptor) {
    // release languages and models (except descriptor model)
    SModelDescriptor modelDescriptor = SModelRepository.getInstance().getModelDescriptor(newDescriptor.getModel().getUID(), (ModelOwner) MPSProject.this);
    LanguageRepository.getInstance().unRegisterLanguages(MPSProject.this);
    SModelRepository.getInstance().unRegisterModelDescriptors(MPSProject.this);
    SModelRepository.getInstance().registerModelDescriptor(modelDescriptor, MPSProject.this);

    myProjectDescriptor = newDescriptor;
    LOG.assertLog(myProjectDescriptor.isRoot(), "Project descriptor has to be root");
    revalidateContent(myProjectFile, newDescriptor.getModel());
    myEventTranslator.projectChanged();
  }

  public void addProjectLanguage(Language language) {
    ProjectDescriptor projectDescriptor = getProjectDescriptor();
    SModel model = projectDescriptor.getModel();
    model.setLoading(true);
    LanguagePath languagePath = new LanguagePath(model);
    languagePath.setPath(language.getDescriptorFile().getAbsolutePath());
    projectDescriptor.addProjectLanguage(languagePath);
    setProjectDescriptor(projectDescriptor);
    myEventTranslator.projectChanged();
  }

  public void addSolution(File solutionDescriptionFile) {
    ProjectDescriptor projectDescriptor = getProjectDescriptor();
    SModel model = projectDescriptor.getModel();
    model.setLoading(true);
    SolutionPath solutionPath = new SolutionPath(model);
    solutionPath.setPath(solutionDescriptionFile.getAbsolutePath());
    projectDescriptor.addProjectSolution(solutionPath);
    setProjectDescriptor(projectDescriptor);
    myEventTranslator.projectChanged();
  }

  public String toString() {
    return "MPSProject file: " + (myProjectFile == null ? "<none>" : myProjectFile.toString());
  }

  public File getProjectFile() {
    return myProjectFile;
  }

  public ProjectDescriptor getProjectDescriptor() {
    return myProjectDescriptor;
  }

  public List<Language> getProjectLanguages() {
    return Collections.unmodifiableList(myLanguages);
  }

  public List<Solution> getProjectSolutions() {
    return Collections.unmodifiableList(mySolutions);
  }

  public boolean isProjectModule(IModule module) {
    if (module.getParentModule() != null) {
      return isProjectModule(module.getParentModule());
    }
    if (myLanguages.contains(module) || mySolutions.contains(module)) return true;
    return false;
  }

  public List<Object> getComponents() {
    return new ArrayList<Object>(myComponents.values());
  }

  public <T> T getComponent(Class<T> clazz) {
    T result = (T) myComponents.get(clazz);
    return result;
  }

  public void addComponent(Class interfaceClass, Object instance) {
    myComponents.put(interfaceClass, instance);
  }

  public List<String> getClassPath() {
    List<String> classpath = new LinkedList<String>();
    String clspath = myProjectDescriptor.getProjectClassesPath();
    if (clspath == null) {
      File file = new File(myProjectFile.getParent(), "classes");
      classpath.add(FileUtil.getCanonicalPath(file));
    } else {
      classpath.add(clspath);
    }

    for (ClassPathEntry entry : CollectionUtil.iteratorAsIterable(myProjectDescriptor.classPathEntriess())) {
      classpath.add(entry.getPath());
    }

    return classpath;
  }

  public void readWorkspaceSettings() {
    String projectFileName = myProjectFile.getName();
    int dotIndex = projectFileName.lastIndexOf('.');
    String mwsFileName = projectFileName.substring(0, dotIndex) + ".mws";
    myWorkspaceFile = new File(myProjectFile.getParent(), mwsFileName);

    if (IdeMain.isTestMode()) return;
    try {
      if (myWorkspaceFile.exists()) {
        Document document = JDOMUtil.loadDocument(myWorkspaceFile);
        Element rootElement = document.getRootElement();
        List<Element> components = rootElement.getChildren(COMPONENT);
        for (Element component : components) {
          try {
            String className = component.getAttributeValue(CLASS);
            Class cls = Class.forName(className);
            if (getComponent(cls) != null && getComponent(cls) instanceof IExternalizableComponent) {
              ((IExternalizableComponent) getComponent(cls)).read(component, this);
            }
          } catch (ClassNotFoundException e) {
          }
        }
      }
    } catch (Exception e) {
      LOG.error(e);
    }
  }

  public void saveModels() {
    ApplicationComponents.getInstance().getComponent(SModelRepository.class).saveAll();
  }

  public void save() {
    if (IdeMain.isTestMode()) return;

    PersistenceUtil.saveProjectDescriptor(myProjectFile, myProjectDescriptor);

    try {
      if (!myWorkspaceFile.exists()) {
        myWorkspaceFile.createNewFile();
      }
      Element root = new Element(COMPONENTS);
      for (Class cls : myComponents.keySet()) {
        Object component = myComponents.get(cls);
        if (component instanceof IExternalizableComponent) {
          Element componentElement = new Element(COMPONENT);
          componentElement.setAttribute(CLASS, cls.getName());
          ((IExternalizableComponent) component).write(componentElement, this);
          root.addContent(componentElement);
        }
      }
      Document document = new Document(root);
      JDOMUtil.writeDocument(document, myWorkspaceFile);
    } catch (Exception e) {
      LOG.error(e);
    }
  }

  public boolean isProjectChanged() {
    return ApplicationComponents.getInstance().getComponent(SModelRepository.class).wereChanges();
  }

  public void dispose() {
    CommandProcessor.instance().executeCommand(new Runnable() {
      public void run() {
        for (Solution solution : getProjectSolutions()) {
          solution.dispose();
        }
        LanguageRepository.getInstance().unRegisterLanguages(MPSProject.this);
        CommandProcessor.instance().removeCommandListener(myEventTranslator);
        SModelRepository.getInstance().unRegisterModelDescriptors(MPSProject.this);
        LanguageRepository.getInstance().unRegisterLanguages(MPSProject.this);
      }
    }, "disposing project");

  }


  public Solution getSolutionForModel(SModelDescriptor md) {
    Set<Solution> owners = SModelRepository.getInstance().getOwners(md, Solution.class);
    for (Solution s : mySolutions) {
      if (owners.contains(s)) return s;
    }
    return null;
  }

  public Language getLanguageForModel(SModelDescriptor md) {
    Set<Language> owners = SModelRepository.getInstance().getOwners(md, Language.class);
    for (Language l : myLanguages) {
      if (owners.contains(l)) return l;
    }
    return null;
  }


  public Language getLanguage(String languageNamespace) {
    Language language = LanguageRepository.getInstance().getLanguage(languageNamespace, this);
    if (language == null) {
      language = LanguageRepository.getInstance().getLanguage(languageNamespace, BootstrapLanguages.getInstance());
    }
    if (language == null) {
      LOG.error("Couldn't find language for namespace: \"" + languageNamespace + "\" in: " + this);
    }
    return language;
  }

  public List<Language> getLanguages() {
    List<Language> list = new LinkedList<Language>(LanguageRepository.getInstance().getLanguages(this));
    list.addAll(LanguageRepository.getInstance().getLanguages(BootstrapLanguages.getInstance()));
    return list;
  }

  public SModelDescriptor getModelDescriptor(SModelUID modelUID) {
    SModelDescriptor modelDescriptor = SModelRepository.getInstance().getModelDescriptor(modelUID, this);
    if (modelDescriptor != null) {
      return modelDescriptor;
    }
    for (Solution solution : mySolutions) {
      modelDescriptor = solution.getModelDescriptor(modelUID);
      if (modelDescriptor != null) {
        return modelDescriptor;
      }
    }
    for (Language language : myLanguages) {
      modelDescriptor = language.getModelDescriptor(modelUID);
      if (modelDescriptor != null) {
        return modelDescriptor;
      }
    }

    LOG.warning("Couldn't find model descriptor for uid: \"" + modelUID + "\" in: " + this);
    return null;
  }

  public List<SModelDescriptor> getModelDescriptors(String modelName) {
    HashSet<SModelDescriptor> set = new HashSet<SModelDescriptor>();
    {
      List<SModelDescriptor> list = SModelRepository.getInstance().getModelDescriptors(modelName, this);
      for (SModelDescriptor descriptor : list) {
        if (!set.contains(descriptor)) {
          set.add(descriptor);
        }
      }
    }

    for (Solution solution : mySolutions) {
      List<SModelDescriptor> list = SModelRepository.getInstance().getModelDescriptors(modelName, solution);
      for (SModelDescriptor descriptor : list) {
        if (!set.contains(descriptor)) {
          set.add(descriptor);
        }
      }
    }
    for (Language language : myLanguages) {
      List<SModelDescriptor> list = SModelRepository.getInstance().getModelDescriptors(modelName, language);
      for (SModelDescriptor descriptor : list) {
        if (!set.contains(descriptor)) {
          set.add(descriptor);
        }
      }
    }

    List<SModelDescriptor> result = CollectionUtil.iteratorAsList(set.iterator());
    set.clear();
    return result;
  }

  public void addMPSProjectCommandListener(IMPSProjectCommandListener listener) {
    myProjectCommandListeners.add(listener);
  }

  public void removeMPSProjectCommandListener(IMPSProjectCommandListener listener) {
    myProjectCommandListeners.remove(listener);
  }

  void fireMPSProjectChangedInCommand() {
    for (IMPSProjectCommandListener listener : myProjectCommandListeners) {
      listener.projectChangedInCommand(this);
    }
  }

  private class ProjectEventTranslator extends CommandEventTranslator {
    protected void fireCommandEvent() {
      fireMPSProjectChangedInCommand();
    }

    public void projectChanged() {
      markCurrentCommandsDirty();
    }
  }
}
