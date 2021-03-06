package jetbrains.mps.ide.properties;

/*Generated by MPS */

import java.util.List;
import jetbrains.mps.project.structure.modules.ModuleReference;
import jetbrains.mps.project.structure.modules.mappingpriorities.MappingPriorityRule;
import jetbrains.mps.workbench.dialogs.project.components.parts.lists.ListsFactory;
import jetbrains.mps.project.structure.modules.ModuleDescriptor;
import jetbrains.mps.project.structure.modules.GeneratorDescriptor;

public class GeneratorProperties extends ModuleProperties {
  public static final String GENERATE_TEMPLATES = "generateTemplates";

  private List<ModuleReference> myDepGenerators;
  private List<MappingPriorityRule> myPriorityRules;
  private boolean myGenerateTemplates;

  public GeneratorProperties() {
    myDepGenerators = ListsFactory.create(ListsFactory.MODULE_VALID_REF_COMPARATOR);
    myPriorityRules = (List) ListsFactory.create(ListsFactory.IGNORING_COMPARATOR);
  }

  public List<ModuleReference> getDepGenerators() {
    return myDepGenerators;
  }

  public List<MappingPriorityRule> getPriorityRules() {
    return myPriorityRules;
  }

  public boolean isGenerateTemplates() {
    return myGenerateTemplates;
  }

  public void setGenerateTemplates(boolean value) {
    myGenerateTemplates = value;
  }

  @Override
  public void loadFrom(ModuleDescriptor descriptor) {
    assert descriptor instanceof GeneratorDescriptor;
    super.loadFrom(descriptor);
    GeneratorDescriptor d = (GeneratorDescriptor) descriptor;
    myGenerateTemplates = d.isGenerateTemplates();
    for (ModuleReference ref : d.getDepGenerators()) {
      myDepGenerators.add(ref);
    }
    for (MappingPriorityRule rule : d.getPriorityRules()) {
      myPriorityRules.add((rule != null ?
        rule.getCopy() :
        null
      ));
    }
  }

  @Override
  public void saveTo(ModuleDescriptor descriptor) {
    assert descriptor instanceof GeneratorDescriptor;
    super.saveTo(descriptor);
    GeneratorDescriptor d = (GeneratorDescriptor) descriptor;
    d.getDepGenerators().clear();
    d.getDepGenerators().addAll(myDepGenerators);
    d.getPriorityRules().clear();
    d.getPriorityRules().addAll(myPriorityRules);
    d.setGenerateTemplates(myGenerateTemplates);
  }
}
