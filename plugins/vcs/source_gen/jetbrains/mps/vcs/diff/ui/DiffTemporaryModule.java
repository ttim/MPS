package jetbrains.mps.vcs.diff.ui;

/*Generated by MPS */

import jetbrains.mps.project.AbstractModule;
import jetbrains.mps.smodel.SModel;
import com.intellij.openapi.project.Project;
import jetbrains.mps.project.structure.modules.ModuleReference;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.project.structure.modules.ModuleDescriptor;
import java.util.List;
import jetbrains.mps.smodel.SModelDescriptor;
import java.util.Arrays;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.project.ProjectScope;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.project.IModule;
import jetbrains.mps.project.ModuleContext;
import java.util.Set;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import java.util.HashSet;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.smodel.BaseSModelDescriptor;
import jetbrains.mps.smodel.persistence.IModelRootManager;
import jetbrains.mps.smodel.ModelLoadingState;

public class DiffTemporaryModule extends AbstractModule {
  private SModel myModel;
  private Project myProject;
  private boolean myEditable;

  private DiffTemporaryModule(SModel model, String version, Project project, boolean editable) {
    setModuleReference(ModuleReference.fromString(SModelOperations.getModelName(model) + "@" + version));
    myModel = model;
    myProject = project;
    myEditable = editable;
  }

  public Class getClass(String fqName) {
    return null;
  }

  public ModuleDescriptor getModuleDescriptor() {
    return null;
  }

  public void setModuleDescriptor(ModuleDescriptor moduleDescriptor, boolean reloadClasses) {
    throw new UnsupportedOperationException();
  }

  public void save() {
    throw new UnsupportedOperationException();
  }

  public String toString() {
    return getModuleFqName();
  }

  public List<SModelDescriptor> getOwnModelDescriptors() {
    return Arrays.asList(myModel.getModelDescriptor());
  }

  protected AbstractModule.ModuleScope createScope() {
    return new DiffTemporaryModule.DiffModuleScope();
  }

  private DiffTemporaryModule.DiffSModelDescriptor createModelDescriptor() {
    return new DiffTemporaryModule.DiffSModelDescriptor();
  }

  private DiffTemporaryModule.DiffModuleContext createContext() {
    return new DiffTemporaryModule.DiffModuleContext();
  }

  private SModelDescriptor findModel(SModelReference reference) {
    if (reference.equals(myModel.getSModelReference())) {
      return myModel.getModelDescriptor();
    }
    List<IScope> scopes = ListSequence.fromList(new ArrayList<IScope>());
    ProjectScope ps = myProject.getComponent(ProjectScope.class);
    if (ps != null) {
      ListSequence.fromList(scopes).addElement(ps);
    }
    ListSequence.fromList(scopes).addElement(GlobalScope.getInstance());
    for (IScope scope : ListSequence.fromList(scopes)) {
      SModelDescriptor md = scope.getModelDescriptor(reference);
      if (md != null) {
        return md;
      }
    }
    // if we can't find model using full reference, try to find by fq-name 
    // this is needed for viewing diff on models saved before MPS 2.0 M5 
    for (IScope scope : ListSequence.fromList(scopes)) {
      SModelDescriptor md = scope.getModelDescriptor(reference.getSModelFqName());
      if (md != null) {
        return md;
      }
    }
    return null;
  }

  public boolean isEditable() {
    return myEditable;
  }

  public static void createModuleForModel(SModel model, String version, Project project) {
    createModuleForModel(model, version, project, false);
  }

  public static void createModuleForModel(SModel model, String version, Project project, boolean editable) {
    if (model.getModelDescriptor() != null) {
      return;
    }
    DiffTemporaryModule module = new DiffTemporaryModule(model, version, project, editable);
    model.setModelDescriptor(module.createModelDescriptor());
  }

  public static IOperationContext getOperationContext(Project project, SModel model) {
    SModelDescriptor md = model.getModelDescriptor();
    assert md != null;
    IModule module = md.getModule();
    if (module instanceof DiffTemporaryModule) {
      return ((DiffTemporaryModule) module).createContext();
    } else {
      return new ModuleContext(module, project);
    }
  }

  private class DiffModuleScope extends AbstractModule.ModuleScope {
    private DiffModuleScope() {
    }

    protected Set<IModule> getInitialModules() {
      Set<IModule> result = SetSequence.fromSet(new HashSet<IModule>());
      SetSequence.fromSet(result).addElement(DiffTemporaryModule.this);
      SetSequence.fromSet(result).addSequence(Sequence.fromIterable(GlobalScope.getInstance().getVisibleModules()));
      return result;
    }

    protected Set<Language> getInitialUsedLanguages() {
      return SetSequence.fromSetWithValues(new HashSet<Language>(), GlobalScope.getInstance().getVisibleLanguages());
    }

    @Override
    public SModelDescriptor getModelDescriptor(SModelReference reference) {
      return findModel(reference);
    }
  }

  private class DiffSModelDescriptor extends BaseSModelDescriptor {
    private DiffSModelDescriptor() {
      super(IModelRootManager.NULL_MANAGER, myModel.getSModelReference(), false);
      mySModel = myModel;
      setLoadingState(ModelLoadingState.FULLY_LOADED);
    }

    protected BaseSModelDescriptor.ModelLoadResult initialLoad() {
      throw new UnsupportedOperationException();
    }

    @Override
    public IModule getModule() {
      return DiffTemporaryModule.this;
    }

    @Override
    public SModelDescriptor resolveModel(SModelReference reference) {
      return findModel(reference);
    }
  }

  private class DiffModuleContext extends ModuleContext {
    private DiffModuleContext() {
      super(DiffTemporaryModule.this, myProject);
    }

    @Override
    public IModule getModule() {
      return DiffTemporaryModule.this;
    }
  }
}
