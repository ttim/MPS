package jetbrains.mps.kernel.model;

/*Generated by MPS */

import jetbrains.mps.project.AbstractModule;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.project.IModule;
import jetbrains.mps.project.structure.modules.Dependency;
import jetbrains.mps.project.structure.modules.ModuleDescriptor;
import jetbrains.mps.project.structure.modules.ModuleReference;
import jetbrains.mps.smodel.*;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class TemporaryModelOwner extends AbstractModule {

  private final MPSModuleOwner myOwner = new MPSModuleOwner() {
  };

  public TemporaryModelOwner() {
    setModuleReference(ModuleReference.fromString("TemporaryModelOwner #" + System.identityHashCode(this)));
    ModelAccess.instance().runWriteAction(new Runnable() {
      public void run() {
        MPSModuleRepository.getInstance().registerModule(TemporaryModelOwner.this, myOwner);
      }
    });
  }

  public void unregisterModelOwner() {
    ModelAccess.instance().runWriteAction(new Runnable() {
      public void run() {
        MPSModuleRepository.getInstance().unregisterModule(TemporaryModelOwner.this, myOwner);
      }
    });
  }

  public void save() {
  }

  public String getTestsGeneratorOutputPath() {
    return null;
  }

  public String getGeneratorOutputPath() {
    return null;
  }

  @Override
  public Collection<ModuleReference> getUsedLanguagesReferences() {
    Set<ModuleReference> result = new LinkedHashSet<ModuleReference>();
    for (SModelDescriptor md : getOwnModelDescriptors()) {
      result.addAll(md.getSModel().importedLanguages());
    }
    return result;
  }

  @Override
  public Collection<ModuleReference> getUsedDevkitReferences() {
    Set<ModuleReference> result = new LinkedHashSet<ModuleReference>();
    for (SModelDescriptor md : getOwnModelDescriptors()) {
      result.addAll(md.getSModel().importedDevkits());
    }
    return result;
  }

  public List<Dependency> getDependencies() {
    List<Dependency> result = new ArrayList<Dependency>();
    for (SModelDescriptor md : getOwnModelDescriptors()) {
      for (SModel.ImportElement ie : md.getSModel().importedModels()) {
        SModelReference mRef = ie.getModelReference();
        SModelDescriptor model = SModelRepository.getInstance().getModelDescriptor(mRef);
        if (model == null) {
          continue;
        }
        IModule module = model.getModule();
        if (module == null) {
          continue;
        }
        Dependency dep = new Dependency();
        dep.setModuleRef(module.getModuleReference());
        result.add(dep);
      }
    }
    return result;
  }

  public void setModuleDescriptor(ModuleDescriptor descriptor, boolean b) {
    throw new UnsupportedOperationException();
  }

  public ModuleDescriptor getModuleDescriptor() {
    return null;
  }

  @NotNull
  @Override
  public IScope getScope() {
    return GlobalScope.getInstance();
  }
}
