package jetbrains.mps.debug.evaluation.ui;

import jetbrains.mps.baseLanguage.stubs.JavaStubs;
import jetbrains.mps.cleanup.CleanupManager;
import jetbrains.mps.project.*;
import jetbrains.mps.project.structure.model.ModelRootManager;
import jetbrains.mps.baseLanguage.structure.BaseLanguage_Language;
import com.intellij.openapi.project.Project;

import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.project.structure.modules.ModuleReference;
import java.util.UUID;
import jetbrains.mps.smodel.MPSModuleRepository;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.smodel.SModelRepository;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.project.structure.modules.ModuleDescriptor;

public class EvaluationAuxModule extends AbstractModule {
  private static final ModelRootManager STUBS_MANAGER = new ModelRootManager(BaseLanguage_Language.MODULE_REFERENCE.getModuleId().toString(), JavaStubs.class.getName());

  private Project myProject;
  private IModule myInvocationContext;
  private final List<StubPath> myStubPaths = ListSequence.fromList(new ArrayList<StubPath>());

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
        CleanupManager.getInstance().cleanup(); //loaded stubs are removed from model repository
      }
    });
  }

  public MPSProject getMPSProject() {
    return this.myProject.getComponent(MPSProject.class);
  }

  public void setInvocationContext(IModule invocationContext) {
    this.myInvocationContext = invocationContext;
  }

  public Class getClass(String fqName) {
    if (this.myInvocationContext == null) {
      throw new IllegalStateException();
    }
    return this.myInvocationContext.getClass(fqName);
  }

  @NotNull
  public IScope getScope() {
    return GlobalScope.getInstance();
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
  public List<StubPath> getStubPaths() {
    return myStubPaths;
  }

  public StubPath addStubPath(String stubPath) {
    StubPath path = new StubPath(stubPath, STUBS_MANAGER);
    if (myStubPaths.contains(path)) {
      return null;
    } else {
      myStubPaths.add(path);
      return path;
    }
  }

  public void clearAll() {
    // model is already disposed by EmbeddableEditor 
    // <node> 
    // <node> 
    this.invalidateCaches();
    this.setInvocationContext(null);
  }

  @NotNull
  public String toString() {
    return "Debug Evaluation Aux Module";
  }
}
