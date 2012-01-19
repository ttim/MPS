package jetbrains.mps.core.xml.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.runtime.ConceptDescriptor;
import java.util.Arrays;
import jetbrains.mps.smodel.runtime.impl.CompiledConceptDescriptor;
import jetbrains.mps.smodel.runtime.interpreted.StructureAspectInterpreted;

public class StructureAspectDescriptor implements jetbrains.mps.smodel.runtime.StructureAspectDescriptor {
  private static String[] stringSwitchCases_1htk8d_a0a0a = new String[]{"jetbrains.mps.core.xml.structure.XmlAttribute", "jetbrains.mps.core.xml.structure.XmlBaseAttribute", "jetbrains.mps.core.xml.structure.XmlBaseElement", "jetbrains.mps.core.xml.structure.XmlCDATA", "jetbrains.mps.core.xml.structure.XmlComment", "jetbrains.mps.core.xml.structure.XmlCommentLine", "jetbrains.mps.core.xml.structure.XmlContent", "jetbrains.mps.core.xml.structure.XmlDocument", "jetbrains.mps.core.xml.structure.XmlElement", "jetbrains.mps.core.xml.structure.XmlEntityRef", "jetbrains.mps.core.xml.structure.XmlEntityRefValue", "jetbrains.mps.core.xml.structure.XmlFile", "jetbrains.mps.core.xml.structure.XmlProcessingInstruction", "jetbrains.mps.core.xml.structure.XmlProlog", "jetbrains.mps.core.xml.structure.XmlText", "jetbrains.mps.core.xml.structure.XmlTextValue", "jetbrains.mps.core.xml.structure.XmlValuePart"};

  public StructureAspectDescriptor() {
  }

  public ConceptDescriptor getDescriptor(String conceptFqName) {
    switch (Arrays.binarySearch(stringSwitchCases_1htk8d_a0a0a, conceptFqName)) {
      case 0:
        return new CompiledConceptDescriptor("jetbrains.mps.core.xml.structure.XmlAttribute", "jetbrains.mps.core.xml.structure.XmlBaseAttribute", false, new String[]{"jetbrains.mps.core.xml.structure.XmlBaseAttribute"}, new String[]{"attrName"}, new String[]{});
      case 1:
        return new CompiledConceptDescriptor("jetbrains.mps.core.xml.structure.XmlBaseAttribute", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept"}, new String[]{}, new String[]{});
      case 2:
        return new CompiledConceptDescriptor("jetbrains.mps.core.xml.structure.XmlBaseElement", "jetbrains.mps.core.xml.structure.XmlContent", false, new String[]{"jetbrains.mps.core.xml.structure.XmlContent"}, new String[]{}, new String[]{});
      case 3:
        return new CompiledConceptDescriptor("jetbrains.mps.core.xml.structure.XmlCDATA", "jetbrains.mps.core.xml.structure.XmlContent", false, new String[]{"jetbrains.mps.core.xml.structure.XmlContent"}, new String[]{"content"}, new String[]{});
      case 4:
        return new CompiledConceptDescriptor("jetbrains.mps.core.xml.structure.XmlComment", "jetbrains.mps.core.xml.structure.XmlContent", false, new String[]{"jetbrains.mps.core.xml.structure.XmlContent"}, new String[]{}, new String[]{});
      case 5:
        return new CompiledConceptDescriptor("jetbrains.mps.core.xml.structure.XmlCommentLine", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept"}, new String[]{"text"}, new String[]{});
      case 6:
        return new CompiledConceptDescriptor("jetbrains.mps.core.xml.structure.XmlContent", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept"}, new String[]{}, new String[]{});
      case 7:
        return new CompiledConceptDescriptor("jetbrains.mps.core.xml.structure.XmlDocument", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept"}, new String[]{}, new String[]{});
      case 8:
        return new CompiledConceptDescriptor("jetbrains.mps.core.xml.structure.XmlElement", "jetbrains.mps.core.xml.structure.XmlBaseElement", false, new String[]{"jetbrains.mps.core.xml.structure.XmlBaseElement"}, new String[]{"tagName"}, new String[]{});
      case 9:
        return new CompiledConceptDescriptor("jetbrains.mps.core.xml.structure.XmlEntityRef", "jetbrains.mps.core.xml.structure.XmlContent", false, new String[]{"jetbrains.mps.core.xml.structure.XmlContent"}, new String[]{"entityName"}, new String[]{});
      case 10:
        return new CompiledConceptDescriptor("jetbrains.mps.core.xml.structure.XmlEntityRefValue", "jetbrains.mps.core.xml.structure.XmlValuePart", false, new String[]{"jetbrains.mps.core.xml.structure.XmlValuePart"}, new String[]{"entityName"}, new String[]{});
      case 11:
        return new CompiledConceptDescriptor("jetbrains.mps.core.xml.structure.XmlFile", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept", "jetbrains.mps.lang.core.structure.INamedConcept"}, new String[]{}, new String[]{});
      case 12:
        return new CompiledConceptDescriptor("jetbrains.mps.core.xml.structure.XmlProcessingInstruction", "jetbrains.mps.core.xml.structure.XmlContent", false, new String[]{"jetbrains.mps.core.xml.structure.XmlContent"}, new String[]{"target", "rawData"}, new String[]{});
      case 13:
        return new CompiledConceptDescriptor("jetbrains.mps.core.xml.structure.XmlProlog", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept"}, new String[]{"xmlVersion"}, new String[]{});
      case 14:
        return new CompiledConceptDescriptor("jetbrains.mps.core.xml.structure.XmlText", "jetbrains.mps.core.xml.structure.XmlContent", false, new String[]{"jetbrains.mps.core.xml.structure.XmlContent"}, new String[]{"value"}, new String[]{});
      case 15:
        return new CompiledConceptDescriptor("jetbrains.mps.core.xml.structure.XmlTextValue", "jetbrains.mps.core.xml.structure.XmlValuePart", false, new String[]{"jetbrains.mps.core.xml.structure.XmlValuePart"}, new String[]{"text"}, new String[]{});
      case 16:
        return new CompiledConceptDescriptor("jetbrains.mps.core.xml.structure.XmlValuePart", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept"}, new String[]{}, new String[]{});
      default:
        return StructureAspectInterpreted.getInstance().getDescriptor(conceptFqName);
    }
  }
}
