package jetbrains.mps.lang.quotation.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.runtime.ConceptDescriptor;
import java.util.Arrays;
import jetbrains.mps.smodel.runtime.impl.CompiledConceptDescriptor;
import jetbrains.mps.smodel.runtime.interpreted.StructureAspectInterpreted;

public class StructureAspectDescriptor implements jetbrains.mps.smodel.runtime.StructureAspectDescriptor {
  private static String[] stringSwitchCases_1htk8d_a0a0a = new String[]{"jetbrains.mps.lang.quotation.structure.AbstractAntiquotation", "jetbrains.mps.lang.quotation.structure.Antiquotation", "jetbrains.mps.lang.quotation.structure.ListAntiquotation", "jetbrains.mps.lang.quotation.structure.PropertyAntiquotation", "jetbrains.mps.lang.quotation.structure.Quotation", "jetbrains.mps.lang.quotation.structure.ReferenceAntiquotation"};

  public StructureAspectDescriptor() {
  }

  public ConceptDescriptor getDescriptor(String conceptFqName) {
    switch (Arrays.binarySearch(stringSwitchCases_1htk8d_a0a0a, conceptFqName)) {
      case 0:
        return new CompiledConceptDescriptor("jetbrains.mps.lang.quotation.structure.AbstractAntiquotation", null, true, new String[]{"jetbrains.mps.lang.core.structure.IMetaLevelChanger", "jetbrains.mps.lang.core.structure.IAntisuppressErrors", "jetbrains.mps.lang.core.structure.ScopeProvider"}, new String[]{"label"}, new String[]{});
      case 1:
        return new CompiledConceptDescriptor("jetbrains.mps.lang.quotation.structure.Antiquotation", "jetbrains.mps.lang.core.structure.NodeAttribute", false, new String[]{"jetbrains.mps.lang.core.structure.NodeAttribute", "jetbrains.mps.lang.quotation.structure.AbstractAntiquotation"}, new String[]{}, new String[]{});
      case 2:
        return new CompiledConceptDescriptor("jetbrains.mps.lang.quotation.structure.ListAntiquotation", "jetbrains.mps.lang.core.structure.NodeAttribute", false, new String[]{"jetbrains.mps.lang.core.structure.NodeAttribute", "jetbrains.mps.lang.quotation.structure.AbstractAntiquotation"}, new String[]{}, new String[]{});
      case 3:
        return new CompiledConceptDescriptor("jetbrains.mps.lang.quotation.structure.PropertyAntiquotation", "jetbrains.mps.lang.core.structure.PropertyAttribute", false, new String[]{"jetbrains.mps.lang.core.structure.PropertyAttribute", "jetbrains.mps.lang.quotation.structure.AbstractAntiquotation"}, new String[]{}, new String[]{});
      case 4:
        return new CompiledConceptDescriptor("jetbrains.mps.lang.quotation.structure.Quotation", "jetbrains.mps.baseLanguage.structure.Expression", false, new String[]{"jetbrains.mps.baseLanguage.structure.Expression", "jetbrains.mps.lang.core.structure.IMetaLevelChanger", "jetbrains.mps.lang.core.structure.ISuppressErrors"}, new String[]{}, new String[]{});
      case 5:
        return new CompiledConceptDescriptor("jetbrains.mps.lang.quotation.structure.ReferenceAntiquotation", "jetbrains.mps.lang.core.structure.LinkAttribute", false, new String[]{"jetbrains.mps.lang.core.structure.LinkAttribute", "jetbrains.mps.lang.quotation.structure.AbstractAntiquotation"}, new String[]{}, new String[]{});
      default:
        return StructureAspectInterpreted.getInstance().getDescriptor(conceptFqName);
    }
  }
}
