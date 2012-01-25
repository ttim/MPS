package jetbrains.mps.lang.core.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.runtime.ConceptDescriptor;
import java.util.Arrays;
import jetbrains.mps.smodel.runtime.impl.CompiledConceptDescriptor;
import jetbrains.mps.smodel.runtime.interpreted.StructureAspectInterpreted;

public class StructureAspectDescriptor implements jetbrains.mps.smodel.runtime.StructureAspectDescriptor {
  private static String[] stringSwitchCases_1htk8d_a0a0a = new String[]{"jetbrains.mps.lang.core.structure.Attribute", "jetbrains.mps.lang.core.structure.BaseConcept", "jetbrains.mps.lang.core.structure.ExportScope", "jetbrains.mps.lang.core.structure.ExportScopeModule", "jetbrains.mps.lang.core.structure.ExportScopeNamespace", "jetbrains.mps.lang.core.structure.ExportScopePublic", "jetbrains.mps.lang.core.structure.IAntisuppressErrors", "jetbrains.mps.lang.core.structure.ICanSuppressErrors", "jetbrains.mps.lang.core.structure.IContainer", "jetbrains.mps.lang.core.structure.IDeprecatable", "jetbrains.mps.lang.core.structure.IMetaLevelChanger", "jetbrains.mps.lang.core.structure.INamedConcept", "jetbrains.mps.lang.core.structure.IResolveInfo", "jetbrains.mps.lang.core.structure.ISuppressErrors", "jetbrains.mps.lang.core.structure.IType", "jetbrains.mps.lang.core.structure.IWrapper", "jetbrains.mps.lang.core.structure.LinkAttribute", "jetbrains.mps.lang.core.structure.NodeAttribute", "jetbrains.mps.lang.core.structure.PropertyAttribute", "jetbrains.mps.lang.core.structure.ScopeProvider", "jetbrains.mps.lang.core.structure.SuppressErrorsAnnotation"};

  public StructureAspectDescriptor() {
  }

  public ConceptDescriptor getDescriptor(String conceptFqName) {
    switch (Arrays.binarySearch(stringSwitchCases_1htk8d_a0a0a, conceptFqName)) {
      case 0:
        return new CompiledConceptDescriptor("jetbrains.mps.lang.core.structure.Attribute", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept"}, new String[]{}, new String[]{});
      case 1:
        return new CompiledConceptDescriptor("jetbrains.mps.lang.core.structure.BaseConcept", null, false, new String[]{}, new String[]{"shortDescription", "alias", "virtualPackage"}, new String[]{});
      case 2:
        return new CompiledConceptDescriptor("jetbrains.mps.lang.core.structure.ExportScope", "jetbrains.mps.lang.core.structure.NodeAttribute", false, new String[]{"jetbrains.mps.lang.core.structure.NodeAttribute"}, new String[]{}, new String[]{});
      case 3:
        return new CompiledConceptDescriptor("jetbrains.mps.lang.core.structure.ExportScopeModule", "jetbrains.mps.lang.core.structure.ExportScope", false, new String[]{"jetbrains.mps.lang.core.structure.ExportScope"}, new String[]{}, new String[]{});
      case 4:
        return new CompiledConceptDescriptor("jetbrains.mps.lang.core.structure.ExportScopeNamespace", "jetbrains.mps.lang.core.structure.ExportScope", false, new String[]{"jetbrains.mps.lang.core.structure.ExportScope"}, new String[]{"namespace"}, new String[]{});
      case 5:
        return new CompiledConceptDescriptor("jetbrains.mps.lang.core.structure.ExportScopePublic", "jetbrains.mps.lang.core.structure.ExportScope", false, new String[]{"jetbrains.mps.lang.core.structure.ExportScope"}, new String[]{}, new String[]{});
      case 6:
        return new CompiledConceptDescriptor("jetbrains.mps.lang.core.structure.IAntisuppressErrors", null, true, new String[]{}, new String[]{}, new String[]{});
      case 7:
        return new CompiledConceptDescriptor("jetbrains.mps.lang.core.structure.ICanSuppressErrors", null, true, new String[]{}, new String[]{}, new String[]{});
      case 8:
        return new CompiledConceptDescriptor("jetbrains.mps.lang.core.structure.IContainer", null, true, new String[]{}, new String[]{}, new String[]{});
      case 9:
        return new CompiledConceptDescriptor("jetbrains.mps.lang.core.structure.IDeprecatable", null, true, new String[]{}, new String[]{}, new String[]{});
      case 10:
        return new CompiledConceptDescriptor("jetbrains.mps.lang.core.structure.IMetaLevelChanger", null, true, new String[]{}, new String[]{}, new String[]{});
      case 11:
        return new CompiledConceptDescriptor("jetbrains.mps.lang.core.structure.INamedConcept", null, true, new String[]{}, new String[]{"name"}, new String[]{});
      case 12:
        return new CompiledConceptDescriptor("jetbrains.mps.lang.core.structure.IResolveInfo", null, true, new String[]{}, new String[]{"resolveInfo"}, new String[]{});
      case 13:
        return new CompiledConceptDescriptor("jetbrains.mps.lang.core.structure.ISuppressErrors", null, true, new String[]{}, new String[]{}, new String[]{});
      case 14:
        return new CompiledConceptDescriptor("jetbrains.mps.lang.core.structure.IType", null, true, new String[]{}, new String[]{}, new String[]{});
      case 15:
        return new CompiledConceptDescriptor("jetbrains.mps.lang.core.structure.IWrapper", null, true, new String[]{}, new String[]{}, new String[]{});
      case 16:
        return new CompiledConceptDescriptor("jetbrains.mps.lang.core.structure.LinkAttribute", "jetbrains.mps.lang.core.structure.Attribute", false, new String[]{"jetbrains.mps.lang.core.structure.Attribute"}, new String[]{"linkRole"}, new String[]{});
      case 17:
        return new CompiledConceptDescriptor("jetbrains.mps.lang.core.structure.NodeAttribute", "jetbrains.mps.lang.core.structure.Attribute", false, new String[]{"jetbrains.mps.lang.core.structure.Attribute"}, new String[]{}, new String[]{});
      case 18:
        return new CompiledConceptDescriptor("jetbrains.mps.lang.core.structure.PropertyAttribute", "jetbrains.mps.lang.core.structure.Attribute", false, new String[]{"jetbrains.mps.lang.core.structure.Attribute"}, new String[]{"propertyName"}, new String[]{});
      case 19:
        return new CompiledConceptDescriptor("jetbrains.mps.lang.core.structure.ScopeProvider", null, true, new String[]{}, new String[]{}, new String[]{});
      case 20:
        return new CompiledConceptDescriptor("jetbrains.mps.lang.core.structure.SuppressErrorsAnnotation", "jetbrains.mps.lang.core.structure.NodeAttribute", false, new String[]{"jetbrains.mps.lang.core.structure.NodeAttribute", "jetbrains.mps.lang.core.structure.ISuppressErrors"}, new String[]{}, new String[]{});
      default:
        return StructureAspectInterpreted.getInstance().getDescriptor(conceptFqName);
    }
  }
}
