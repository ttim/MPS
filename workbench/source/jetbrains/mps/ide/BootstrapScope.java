package jetbrains.mps.ide;

import jetbrains.mps.project.DevKit;
import jetbrains.mps.project.IModule;
import jetbrains.mps.project.ModuleReference;
import jetbrains.mps.smodel.*;
import jetbrains.mps.library.LibraryManager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BootstrapScope extends BaseScope {
  private static BootstrapScope myInstance;

  public static BootstrapScope getInstance() {
    if (myInstance == null) {
      myInstance = new BootstrapScope();
    }
    return myInstance;
  }

  private BootstrapScope() {
  }

  public String toString() {
    return "bootstrap scope";
  }

  public <T extends IModule> List<T> getModules(Class<T> cls) {
    return new ArrayList<T>(LibraryManager.getInstance().getBootstrapModules(cls));
  }

  public List<Language> getVisibleLanguages() {
    return getModules(Language.class);
  }

  public List<DevKit> getVisibleDevkits() {
    return getModules(DevKit.class);
  }

  public Set<IModule> getVisibleModules() {
    return new HashSet(getModules(null));
  }

  public Language getLanguage(ModuleReference moduleReference) {
    for (Language l : getModules(Language.class)) {
      if (moduleReference.getModuleId() != null) {
        if (l.getModuleId().equals(moduleReference.getModuleId())) {
          return l;
        }
      } else {
        if (l.getModuleFqName().equals(moduleReference.getModuleFqName())) {
          return l;
        }
      }
    }
    return null;
  }

  public DevKit getDevKit(ModuleReference moduleReference) {
    for (DevKit d : getModules(DevKit.class)) {
      if (moduleReference.getModuleId() != null) {
        if (d.getModuleId().equals(moduleReference.getModuleId())) {
          return d;
        }
      } else {
        if (d.getModuleFqName().equals(moduleReference.getModuleFqName())) {
          return d;
        }
      }
    }
    return null;
  }

  public SModelDescriptor getModelDescriptor(SModelReference modelReference) {
    for (IModule module : getVisibleModules()) {
      for (SModelDescriptor modelDescriptor : module.getOwnModelDescriptors()) {
        if (modelDescriptor.getSModelReference().equals(modelReference)) {
          return modelDescriptor;
        }
      }
    }
    return null;
  }

  public List<SModelDescriptor> getModelDescriptors(String modelName) {
    List<SModelDescriptor> models = new ArrayList<SModelDescriptor>();
    for (IModule module : getVisibleModules()) {
      for (SModelDescriptor modelDescriptor : module.getOwnModelDescriptors()) {
        if (modelDescriptor.getLongName().equals(modelName)) {
          models.add(modelDescriptor);
        }
      }
    }
    return models;
  }

  public List<SModelDescriptor> getModelDescriptors() {
    List<SModelDescriptor> models = new ArrayList<SModelDescriptor>();
    for (IModule module : getVisibleModules()) {
      models.addAll(module.getOwnModelDescriptors());
    }
    return models;
  }

}
