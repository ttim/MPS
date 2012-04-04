package jetbrains.mps.lang.plugin.standalone.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.runtime.ConceptDescriptor;
import java.util.Arrays;
import jetbrains.mps.smodel.runtime.impl.CompiledConceptDescriptor;
import jetbrains.mps.smodel.runtime.interpreted.StructureAspectInterpreted;

public class StructureAspectDescriptor implements jetbrains.mps.smodel.runtime.StructureAspectDescriptor {
  private static String[] stringSwitchCases_1htk8d_a0a0a = new String[]{"jetbrains.mps.lang.plugin.standalone.structure.ApplicationPluginDeclaration", "jetbrains.mps.lang.plugin.standalone.structure.ApplicationPluginDisposeBlock", "jetbrains.mps.lang.plugin.standalone.structure.ApplicationPluginInitBlock", "jetbrains.mps.lang.plugin.standalone.structure.ApplicationPluginType", "jetbrains.mps.lang.plugin.standalone.structure.GetPreferencesComponentInProjectOperation", "jetbrains.mps.lang.plugin.standalone.structure.GetToolInProjectOperation", "jetbrains.mps.lang.plugin.standalone.structure.ProjectPluginDeclaration", "jetbrains.mps.lang.plugin.standalone.structure.ProjectPluginDisposeBlock", "jetbrains.mps.lang.plugin.standalone.structure.ProjectPluginInitBlock", "jetbrains.mps.lang.plugin.standalone.structure.ProjectPluginType"};

  public StructureAspectDescriptor() {
  }

  public ConceptDescriptor getDescriptor(String conceptFqName) {
    switch (Arrays.binarySearch(stringSwitchCases_1htk8d_a0a0a, conceptFqName)) {
      case 0:
        return new CompiledConceptDescriptor("jetbrains.mps.lang.plugin.standalone.structure.ApplicationPluginDeclaration", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept", "jetbrains.mps.baseLanguage.classifiers.structure.IClassifier"}, new String[]{}, new String[]{});
      case 1:
        return new CompiledConceptDescriptor("jetbrains.mps.lang.plugin.standalone.structure.ApplicationPluginDisposeBlock", "jetbrains.mps.baseLanguage.structure.ConceptFunction", false, new String[]{"jetbrains.mps.baseLanguage.structure.ConceptFunction"}, new String[]{}, new String[]{});
      case 2:
        return new CompiledConceptDescriptor("jetbrains.mps.lang.plugin.standalone.structure.ApplicationPluginInitBlock", "jetbrains.mps.baseLanguage.structure.ConceptFunction", false, new String[]{"jetbrains.mps.baseLanguage.structure.ConceptFunction"}, new String[]{}, new String[]{});
      case 3:
        return new CompiledConceptDescriptor("jetbrains.mps.lang.plugin.standalone.structure.ApplicationPluginType", "jetbrains.mps.baseLanguage.classifiers.structure.BaseClassifierType", false, new String[]{"jetbrains.mps.baseLanguage.classifiers.structure.BaseClassifierType"}, new String[]{}, new String[]{"plugin"});
      case 4:
        return new CompiledConceptDescriptor("jetbrains.mps.lang.plugin.standalone.structure.GetPreferencesComponentInProjectOperation", "jetbrains.mps.lang.plugin.structure.BaseProjectOperation", false, new String[]{"jetbrains.mps.lang.plugin.structure.BaseProjectOperation"}, new String[]{}, new String[]{"componentDeclaration"});
      case 5:
        return new CompiledConceptDescriptor("jetbrains.mps.lang.plugin.standalone.structure.GetToolInProjectOperation", "jetbrains.mps.lang.plugin.structure.BaseProjectOperation", false, new String[]{"jetbrains.mps.lang.plugin.structure.BaseProjectOperation"}, new String[]{}, new String[]{"tool"});
      case 6:
        return new CompiledConceptDescriptor("jetbrains.mps.lang.plugin.standalone.structure.ProjectPluginDeclaration", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept", "jetbrains.mps.baseLanguage.classifiers.structure.IClassifier"}, new String[]{}, new String[]{});
      case 7:
        return new CompiledConceptDescriptor("jetbrains.mps.lang.plugin.standalone.structure.ProjectPluginDisposeBlock", "jetbrains.mps.baseLanguage.structure.ConceptFunction", false, new String[]{"jetbrains.mps.baseLanguage.structure.ConceptFunction"}, new String[]{}, new String[]{});
      case 8:
        return new CompiledConceptDescriptor("jetbrains.mps.lang.plugin.standalone.structure.ProjectPluginInitBlock", "jetbrains.mps.baseLanguage.structure.ConceptFunction", false, new String[]{"jetbrains.mps.baseLanguage.structure.ConceptFunction"}, new String[]{}, new String[]{});
      case 9:
        return new CompiledConceptDescriptor("jetbrains.mps.lang.plugin.standalone.structure.ProjectPluginType", "jetbrains.mps.baseLanguage.classifiers.structure.BaseClassifierType", false, new String[]{"jetbrains.mps.baseLanguage.classifiers.structure.BaseClassifierType"}, new String[]{}, new String[]{"plugin"});
      default:
        return StructureAspectInterpreted.getInstance().getDescriptor(conceptFqName);
    }
  }
}
