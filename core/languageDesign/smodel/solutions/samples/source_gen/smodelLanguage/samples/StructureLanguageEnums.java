package smodelLanguage.samples;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SEnumOperations;

public class StructureLanguageEnums {
  public void iteration() {
    for (SNode member : ListSequence.<SNode>fromList(SEnumOperations.getEnumMembers(SEnumOperations.getEnum("r:00000000-0000-4000-0000-011c89590292(jetbrains.mps.lang.structure.structure)", "Cardinality")))) {
      String value = SEnumOperations.getEnumMemberValue(member);
      String name = SEnumOperations.getEnumMemberName(member);
      SNode cardinality = SEnumOperations.enumMemberForName(SEnumOperations.getEnum("r:00000000-0000-4000-0000-011c89590292(jetbrains.mps.lang.structure.structure)", "Cardinality"), name);
      SNode cardinality2 = SEnumOperations.enumMemberForValue(SEnumOperations.getEnum("r:00000000-0000-4000-0000-011c89590292(jetbrains.mps.lang.structure.structure)", "Cardinality"), value);
    }
  }
}
