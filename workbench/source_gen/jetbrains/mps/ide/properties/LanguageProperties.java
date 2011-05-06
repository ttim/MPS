package jetbrains.mps.ide.properties;

/*Generated by MPS */

import java.util.List;

import jetbrains.mps.project.structure.model.ModelRoot;
import jetbrains.mps.project.structure.modules.*;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.workbench.dialogs.project.components.parts.lists.ListsFactory;

public class LanguageProperties extends ModuleProperties {
  public static final String OUTPUT_PATH = "genPath";
  public static final String DO_NOT_GENERATE_ADAPTERS = "doNotGenerateAdapters";

  private String myGenPath;
  private List<SModelReference> myAccessoryModels;
  private List<ModuleReference> myExtendedLanguages;
  private List<Dependency> myRuntimeModules;
  private List<ClassPathEntry> myRuntimeClassPaths;
  private List<ModelRoot> myRuntimeStubModels;
  private boolean myDoNotGenerateAdapters = false;
  private List<StubSolution> myStubSolutions;

  public LanguageProperties() {
    myAccessoryModels = ListsFactory.create(ListsFactory.MODEL_REF_COMPARATOR);
    myExtendedLanguages = ListsFactory.create(ListsFactory.MODULE_VALID_REF_COMPARATOR);
    myRuntimeModules = ListsFactory.create(ListsFactory.DEPENDENCY_COMPARATOR);
    myRuntimeClassPaths = ListsFactory.create(ListsFactory.CLASSPATH_ENTRY_COMPARATOR);
    myStubSolutions = ListsFactory.create(ListsFactory.STUB_SOLUTIONS_ENTRY_COMPARATOR);
    myRuntimeStubModels = ListsFactory.create(ListsFactory.STUB_MODEL_ENTRY_COMPARATOR);
  }

  public String getGenPath() {
    return myGenPath;
  }

  public void setGenPath(String genPath) {
    myGenPath = genPath;
  }

  public List<SModelReference> getAccessoryModels() {
    return myAccessoryModels;
  }

  public List<ModuleReference> getExtendedLanguages() {
    return myExtendedLanguages;
  }

  public List<Dependency> getRuntimeModules() {
    return myRuntimeModules;
  }

  public List<StubSolution> getStubSolutions() {
    return myStubSolutions;
  }

  public List<ClassPathEntry> getRuntimeClassPaths() {
    return myRuntimeClassPaths;
  }

  public List<ModelRoot> getRuntimeStubModels() {
    return myRuntimeStubModels;
  }

  public boolean isDoNotGenerateAdapters() {
    return myDoNotGenerateAdapters;
  }

  public void setDoNotGenerateAdapters(boolean doNotGenerateAdapters) {
    myDoNotGenerateAdapters = doNotGenerateAdapters;
  }

  @Override
  public void loadFrom(ModuleDescriptor descriptor) {
    assert descriptor instanceof LanguageDescriptor;
    super.loadFrom(descriptor);
    LanguageDescriptor d = (LanguageDescriptor) descriptor;
    myGenPath = d.getGenPath();
    myDoNotGenerateAdapters = d.isDoNotGenerateAdapters();
    myAccessoryModels.addAll(d.getAccessoryModels());
    myExtendedLanguages.addAll(d.getExtendedLanguages());
    myRuntimeModules.addAll(d.getRuntimeModules());
    for (StubSolution ss : d.getStubSolutions()) {
      myStubSolutions.add((ss != null ?
        ss.getCopy() :
        null
      ));
    }
    for (ModelRoot entry : d.getRuntimeStubModels()) {
      myRuntimeStubModels.add((entry != null ?
        entry.getCopy() :
        null
      ));
    }
  }

  @Override
  public void saveTo(ModuleDescriptor descriptor) {
    assert descriptor instanceof LanguageDescriptor;
    super.saveTo(descriptor);
    LanguageDescriptor d = (LanguageDescriptor) descriptor;
    d.setGenPath(myGenPath);
    d.setDoNotGenerateAdapters(myDoNotGenerateAdapters);
    d.getAccessoryModels().clear();
    d.getAccessoryModels().addAll(myAccessoryModels);
    d.getExtendedLanguages().clear();
    d.getExtendedLanguages().addAll(myExtendedLanguages);
    d.getRuntimeModules().clear();
    d.getRuntimeModules().addAll(myRuntimeModules);
    d.getStubSolutions().clear();
    d.getStubSolutions().addAll(myStubSolutions);
    d.getRuntimeStubModels().clear();
    d.getRuntimeStubModels().addAll(myRuntimeStubModels);
  }
}
