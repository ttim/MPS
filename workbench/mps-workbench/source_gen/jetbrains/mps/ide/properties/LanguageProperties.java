package jetbrains.mps.ide.properties;

/*Generated by MPS */

import java.util.List;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.project.structure.modules.ModuleReference;
import jetbrains.mps.project.structure.modules.ClassPathEntry;
import jetbrains.mps.project.structure.model.ModelRoot;
import jetbrains.mps.project.structure.modules.StubSolution;
import jetbrains.mps.workbench.dialogs.project.components.parts.lists.ListsFactory;
import jetbrains.mps.project.structure.modules.ModuleDescriptor;
import jetbrains.mps.project.structure.modules.LanguageDescriptor;

public class LanguageProperties extends ModuleProperties {
  public static final String OUTPUT_PATH = "genPath";
  public static final String GENERATE_ADAPTERS = "generateAdapters";

  private String myGenPath;
  private List<SModelReference> myAccessoryModels;
  private List<ModuleReference> myExtendedLanguages;
  private List<ModuleReference> myRuntimeModules;
  private List<ClassPathEntry> myRuntimeClassPaths;
  private List<ModelRoot> myRuntimeStubModels;
  private boolean myGenerateAdapters = false;
  private List<StubSolution> myStubSolutions;

  public LanguageProperties() {
    myAccessoryModels = ListsFactory.create(ListsFactory.MODEL_REF_COMPARATOR);
    myExtendedLanguages = ListsFactory.create(ListsFactory.MODULE_VALID_REF_COMPARATOR);
    myRuntimeModules = ListsFactory.create(ListsFactory.MODULE_REF_COMPARATOR);
    myRuntimeClassPaths = ListsFactory.create(ListsFactory.CLASSPATH_ENTRY_COMPARATOR);
    myStubSolutions = ListsFactory.create(ListsFactory.STUB_SOLUTIONS_ENTRY_COMPARATOR);
    myRuntimeStubModels = ListsFactory.create(ListsFactory.MODEL_ROOT_COMPARATOR);
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

  public List<ModuleReference> getRuntimeModules() {
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

  public boolean isGenerateAdapters() {
    return myGenerateAdapters;
  }

  public void setGenerateAdapters(boolean doNotGenerateAdapters) {
    myGenerateAdapters = doNotGenerateAdapters;
  }

  @Override
  public void loadFrom(ModuleDescriptor descriptor) {
    assert descriptor instanceof LanguageDescriptor;
    super.loadFrom(descriptor);
    LanguageDescriptor d = (LanguageDescriptor) descriptor;
    myGenPath = d.getGenPath();
    myGenerateAdapters = !(d.isDoNotGenerateAdapters());
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
    d.setDoNotGenerateAdapters(!(myGenerateAdapters));
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
