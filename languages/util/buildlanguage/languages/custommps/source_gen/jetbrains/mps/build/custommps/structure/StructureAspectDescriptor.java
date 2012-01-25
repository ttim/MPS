package jetbrains.mps.build.custommps.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.runtime.ConceptDescriptor;
import java.util.Arrays;
import jetbrains.mps.smodel.runtime.impl.CompiledConceptDescriptor;
import jetbrains.mps.smodel.runtime.interpreted.StructureAspectInterpreted;

public class StructureAspectDescriptor implements jetbrains.mps.smodel.runtime.StructureAspectDescriptor {
  private static String[] stringSwitchCases_1htk8d_a0a0a = new String[]{"jetbrains.mps.build.custommps.structure.LibraryFolder", "jetbrains.mps.build.custommps.structure.MPSBuild"};

  public StructureAspectDescriptor() {
  }

  public ConceptDescriptor getDescriptor(String conceptFqName) {
    switch (Arrays.binarySearch(stringSwitchCases_1htk8d_a0a0a, conceptFqName)) {
      case 0:
        return new CompiledConceptDescriptor("jetbrains.mps.build.custommps.structure.LibraryFolder", "jetbrains.mps.build.packaging.structure.Folder", false, new String[]{"jetbrains.mps.build.packaging.structure.Folder"}, new String[]{}, new String[]{});
      case 1:
        return new CompiledConceptDescriptor("jetbrains.mps.build.custommps.structure.MPSBuild", "jetbrains.mps.build.packaging.structure.AbstractProjectComponent", false, new String[]{"jetbrains.mps.build.packaging.structure.AbstractProjectComponent", "jetbrains.mps.build.packaging.structure.ICompositeComponent", "jetbrains.mps.build.packaging.structure.INotBuildableComponent"}, new String[]{}, new String[]{});
      default:
        return StructureAspectInterpreted.getInstance().getDescriptor(conceptFqName);
    }
  }
}
