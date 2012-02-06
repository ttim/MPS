package jetbrains.mps.lang.extension.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.runtime.ConceptDescriptor;
import java.util.Arrays;
import jetbrains.mps.smodel.runtime.impl.CompiledConceptDescriptor;
import jetbrains.mps.smodel.runtime.interpreted.StructureAspectInterpreted;

public class StructureAspectDescriptor implements jetbrains.mps.smodel.runtime.StructureAspectDescriptor {
  private static String[] stringSwitchCases_1htk8d_a0a0a = new String[]{"jetbrains.mps.lang.extension.structure.ExtensionDeclaration", "jetbrains.mps.lang.extension.structure.ExtensionFieldDeclaration", "jetbrains.mps.lang.extension.structure.ExtensionFieldReference", "jetbrains.mps.lang.extension.structure.ExtensionFunction", "jetbrains.mps.lang.extension.structure.ExtensionObjectGetter", "jetbrains.mps.lang.extension.structure.ExtensionPointDeclaration", "jetbrains.mps.lang.extension.structure.ExtensionPointExpression", "jetbrains.mps.lang.extension.structure.ExtensionPointType", "jetbrains.mps.lang.extension.structure.GetExtensionObjectsOperation"};

  public StructureAspectDescriptor() {
  }

  public ConceptDescriptor getDescriptor(String conceptFqName) {
    switch (Arrays.binarySearch(stringSwitchCases_1htk8d_a0a0a, conceptFqName)) {
      case 0:
        return new CompiledConceptDescriptor("jetbrains.mps.lang.extension.structure.ExtensionDeclaration", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept", "jetbrains.mps.lang.core.structure.INamedConcept"}, new String[]{}, new String[]{"extensionPoint"});
      case 1:
        return new CompiledConceptDescriptor("jetbrains.mps.lang.extension.structure.ExtensionFieldDeclaration", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept", "jetbrains.mps.lang.core.structure.INamedConcept"}, new String[]{}, new String[]{});
      case 2:
        return new CompiledConceptDescriptor("jetbrains.mps.lang.extension.structure.ExtensionFieldReference", "jetbrains.mps.baseLanguage.structure.Expression", false, new String[]{"jetbrains.mps.baseLanguage.structure.Expression"}, new String[]{}, new String[]{"declaration"});
      case 3:
        return new CompiledConceptDescriptor("jetbrains.mps.lang.extension.structure.ExtensionFunction", "jetbrains.mps.baseLanguage.structure.ConceptFunction", false, new String[]{"jetbrains.mps.baseLanguage.structure.ConceptFunction"}, new String[]{}, new String[]{});
      case 4:
        return new CompiledConceptDescriptor("jetbrains.mps.lang.extension.structure.ExtensionObjectGetter", "jetbrains.mps.baseLanguage.structure.ConceptFunction", false, new String[]{"jetbrains.mps.baseLanguage.structure.ConceptFunction"}, new String[]{}, new String[]{});
      case 5:
        return new CompiledConceptDescriptor("jetbrains.mps.lang.extension.structure.ExtensionPointDeclaration", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept", "jetbrains.mps.lang.core.structure.INamedConcept"}, new String[]{"extensionName"}, new String[]{});
      case 6:
        return new CompiledConceptDescriptor("jetbrains.mps.lang.extension.structure.ExtensionPointExpression", "jetbrains.mps.baseLanguage.structure.Expression", false, new String[]{"jetbrains.mps.baseLanguage.structure.Expression"}, new String[]{}, new String[]{"extensionPoint"});
      case 7:
        return new CompiledConceptDescriptor("jetbrains.mps.lang.extension.structure.ExtensionPointType", "jetbrains.mps.baseLanguage.structure.Type", false, new String[]{"jetbrains.mps.baseLanguage.structure.Type"}, new String[]{}, new String[]{"extensionPoint"});
      case 8:
        return new CompiledConceptDescriptor("jetbrains.mps.lang.extension.structure.GetExtensionObjectsOperation", "jetbrains.mps.baseLanguage.structure.AbstractOperation", false, new String[]{"jetbrains.mps.baseLanguage.structure.AbstractOperation"}, new String[]{}, new String[]{});
      default:
        return StructureAspectInterpreted.getInstance().getDescriptor(conceptFqName);
    }
  }
}
