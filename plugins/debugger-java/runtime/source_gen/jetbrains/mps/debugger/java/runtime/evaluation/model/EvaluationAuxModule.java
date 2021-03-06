package jetbrains.mps.debugger.java.runtime.evaluation.model;

/*Generated by MPS */

import jetbrains.mps.project.AbstractModule;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.intellij.openapi.project.Project;
import java.util.Set;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import java.util.HashSet;
import jetbrains.mps.project.structure.modules.ModuleReference;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.project.IModule;
import jetbrains.mps.project.ModuleId;
import jetbrains.mps.project.MPSProject;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.project.structure.modules.ModuleDescriptor;
import jetbrains.mps.smodel.MPSModuleRepository;
import jetbrains.mps.project.SModelRoot;
import jetbrains.mps.smodel.SModelRepository;
import jetbrains.mps.project.structure.model.ModelRoot;
import jetbrains.mps.smodel.LanguageID;
import java.util.Collection;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.internal.collections.runtime.CollectionSequence;

public class EvaluationAuxModule extends AbstractModule {
  protected static Log log = LogFactory.getLog(EvaluationAuxModule.class);

  private Project myProject;
  private final Set<String> myStubPaths = SetSequence.fromSet(new HashSet<String>());
  private final Set<ModuleReference> myUsedLanguages = SetSequence.fromSet(new HashSet<ModuleReference>());
  @Nullable
  private IModule myContextModule;

  public EvaluationAuxModule(Project project) {
    this.myProject = project;
    ModuleReference reference = new ModuleReference("Debug Evaluation Aux Module", ModuleId.regular());
    this.setModuleReference(reference);
  }

  public MPSProject getMPSProject() {
    return this.myProject.getComponent(MPSProject.class);
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
  public void addUsedLanguage(ModuleReference reference) {
    SetSequence.fromSet(myUsedLanguages).addElement(reference);
  }

  @Override
  public Set<ModuleReference> getUsedLanguagesReferences() {
    return myUsedLanguages;
  }

  @Override
  public Set<String> getStubPaths() {
    return myStubPaths;
  }

  public String addStubPath(String path) {
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
  public Set<SModelRoot> doUpdateModelsSet() {
    HashSet<SModelRoot> result = new HashSet<SModelRoot>();
    SModelRepository repo = SModelRepository.getInstance();
    for (String stub : SetSequence.fromSet(myStubPaths)) {
      ModelRoot root = new ModelRoot();
      root.setPath(stub);
      root.setManager(LanguageID.JAVA_MANAGER);
      try {
        SModelRoot smodelRoot = new SModelRoot(root);
        Collection<SModelDescriptor> loaded = smodelRoot.getManager().load(root, this);
        for (SModelDescriptor descriptor : CollectionSequence.fromCollection(loaded)) {
          if (repo.getModelDescriptor(descriptor.getSModelReference()) == null) {
            repo.registerModelDescriptor(descriptor, this);
          }
        }
        result.add(smodelRoot);
      } catch (Exception e) {
        if (log.isErrorEnabled()) {
          log.error("", e);
        }
      }
    }
    return result;
  }

  @NotNull
  public String toString() {
    return "Debug Evaluation Aux Module";
  }

  @Nullable
  public IModule getContextModule() {
    return myContextModule;
  }

  public void setContextModule(IModule contextModule) {
    myContextModule = contextModule;
  }
}
