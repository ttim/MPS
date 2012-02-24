package jetbrains.mps.debugger.java.runtime.evaluation.model;

/*Generated by MPS */

import jetbrains.mps.project.AbstractModule;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.project.structure.model.ModelRootManager;
import jetbrains.mps.smodel.MPSModuleRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.intellij.openapi.project.Project;
import jetbrains.mps.project.IModule;
import java.util.Set;
import jetbrains.mps.project.StubPath;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import java.util.HashSet;
import jetbrains.mps.project.SModelRoot;
import jetbrains.mps.project.structure.modules.ModuleReference;
import jetbrains.mps.smodel.IScope;
import java.util.UUID;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.smodel.SModelRepository;
import jetbrains.mps.cleanup.CleanupManager;
import jetbrains.mps.project.MPSProject;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.project.structure.modules.ModuleDescriptor;
import jetbrains.mps.project.structure.model.ModelRoot;
import java.util.Collection;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.internal.collections.runtime.CollectionSequence;

public class EvaluationAuxModule extends AbstractModule {
  public static boolean JAVA_STUBS = true;
  @NotNull
  private static final ModelRootManager STUBS_MANAGER = (JAVA_STUBS ?
    new ModelRootManager(MPSModuleRepository.getInstance().getLanguage("jetbrains.mps.baseLanguage").getModuleReference().getModuleId().toString(), "jetbrains.mps.baseLanguage.stubs.JavaStubs") :
    new ModelRootManager(MPSModuleRepository.getInstance().getLanguage("jetbrains.mps.baseLanguage").getModuleReference().getModuleId().toString(), "jetbrains.mps.baseLanguage.stubs.AllMembersJavaStubs")
  );
  public static final String DEBUGGER_JAVA_ID = "debugger_java";
  protected static Log log = LogFactory.getLog(EvaluationAuxModule.class);

  private Project myProject;
  private IModule myInvocationContext;
  private final Set<StubPath> myStubPaths = SetSequence.fromSet(new HashSet<StubPath>());
  private final Set<SModelRoot> myModelRoots = SetSequence.fromSet(new HashSet<SModelRoot>());
  private final Set<ModuleReference> myUsedLanguages = SetSequence.fromSet(new HashSet<ModuleReference>());
  private volatile IScope myScope;

  public EvaluationAuxModule(Project project) {
    this.myProject = project;
    ModuleReference reference = ModuleReference.fromString(UUID.randomUUID() + "(Debug Evaluation Aux Module)");
    this.setModuleReference(reference);
    this.init();
  }

  public void init() {
    MPSModuleRepository.getInstance().addModule(EvaluationAuxModule.this, this.getMPSProject());
  }

  public void dispose() {
    super.dispose();
    ModelAccess.instance().runWriteAction(new Runnable() {
      public void run() {
        EvaluationAuxModule.this.clearAll();
        MPSModuleRepository.getInstance().removeModule(EvaluationAuxModule.this);
        SModelRepository.getInstance().unRegisterModelDescriptors(EvaluationAuxModule.this);
        SetSequence.fromSet(myStubPaths).clear();
        SetSequence.fromSet(myModelRoots).clear();
        CleanupManager.getInstance().cleanup();
        // loaded stubs are removed from model repository 
      }
    });
  }

  public MPSProject getMPSProject() {
    return this.myProject.getComponent(MPSProject.class);
  }

  public void setInvocationContext(IModule invocationContext) {
    this.myInvocationContext = invocationContext;
  }

  @Nullable
  public Class getClass(String fqName) {
    if (this.myInvocationContext == null) {
      return null;
    }
    return this.myInvocationContext.getClass(fqName);
  }

  @NotNull
  public IScope getScope() {
    if (myScope == null) {
      myScope = new EvaluationAuxScope(this);
    }
    return myScope;
  }

  public ModuleDescriptor getModuleDescriptor() {
    return null;
  }

  public void setModuleDescriptor(ModuleDescriptor moduleDescriptor, boolean reloadClasses) {
    throw new UnsupportedOperationException();
  }

  public String getGeneratorOutputPath() {
    return null;
  }

  public String getTestsGeneratorOutputPath() {
    return null;
  }

  public void save() {
  }

  @Override
  public void addUsedLanguage(ModuleReference reference) {
    SetSequence.fromSet(myUsedLanguages).addElement(reference);
  }

  @Override
  public Set<ModuleReference> getUsedLanguagesReferences() {
    return myUsedLanguages;
  }

  @Override
  public Set<StubPath> getStubPaths() {
    return myStubPaths;
  }

  public StubPath addStubPath(String stubPath) {
    StubPath path = new StubPath(stubPath, STUBS_MANAGER);
    if (SetSequence.fromSet(myStubPaths).contains(path)) {
      path = null;
    } else {
      SetSequence.fromSet(myStubPaths).addElement(path);
    }
    invalidateClassPath();
    MPSModuleRepository.getInstance().fireModuleChanged(this);
    return path;
  }

  @Override
  public Set<SModelRoot> getSModelRoots() {
    return myModelRoots;
  }

  @Override
  public void loadNewModels() {
    SetSequence.fromSet(myModelRoots).clear();

    for (StubPath stub : SetSequence.fromSet(myStubPaths)) {
      ModelRoot root = new ModelRoot();
      root.setPath(stub.getPath());
      root.setManager(stub.getManager());
      try {
        SModelRoot smodelRoot = new SModelRoot(root);
        Collection<SModelDescriptor> loaded = smodelRoot.getManager().load(root, this);
        for (SModelDescriptor descriptor : CollectionSequence.fromCollection(loaded)) {
          if (SModelRepository.getInstance().getModelDescriptor(descriptor.getSModelReference()) == null) {
            SModelRepository.getInstance().registerModelDescriptor(descriptor, this);
          }
        }
        SetSequence.fromSet(myModelRoots).addElement(smodelRoot);
      } catch (Exception e) {
        if (log.isErrorEnabled()) {
          log.error("", e);
        }
      }
    }

    fireModuleInitialized();
  }

  public void clearAll() {
    // model is already disposed by EmbeddableEditor 
    this.invalidateCaches();
    this.setInvocationContext(null);
  }

  @NotNull
  public String toString() {
    return "Debug Evaluation Aux Module";
  }
}
