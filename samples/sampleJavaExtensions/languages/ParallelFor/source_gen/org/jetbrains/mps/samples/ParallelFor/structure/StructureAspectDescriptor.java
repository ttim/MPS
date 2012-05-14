package org.jetbrains.mps.samples.ParallelFor.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.runtime.ConceptDescriptor;
import java.util.Arrays;
import jetbrains.mps.smodel.runtime.impl.CompiledConceptDescriptor;
import jetbrains.mps.smodel.runtime.interpreted.StructureAspectInterpreted;

public class StructureAspectDescriptor implements jetbrains.mps.smodel.runtime.StructureAspectDescriptor {
  private static String[] stringSwitchCases_1htk8d_a0a0a = new String[]{"org.jetbrains.mps.samples.ParallelFor.structure.NonThreadSafeClass", "org.jetbrains.mps.samples.ParallelFor.structure.ParallelFor", "org.jetbrains.mps.samples.ParallelFor.structure.ParallelLoopVariable", "org.jetbrains.mps.samples.ParallelFor.structure.ThreadPool", "org.jetbrains.mps.samples.ParallelFor.structure.ThreadSafe"};

  public StructureAspectDescriptor() {
  }

  public ConceptDescriptor getDescriptor(String conceptFqName) {
    switch (Arrays.binarySearch(stringSwitchCases_1htk8d_a0a0a, conceptFqName)) {
      case 0:
        return new CompiledConceptDescriptor("org.jetbrains.mps.samples.ParallelFor.structure.NonThreadSafeClass", "jetbrains.mps.lang.core.structure.NodeAttribute", false, new String[]{"jetbrains.mps.lang.core.structure.NodeAttribute"}, new String[]{}, new String[]{});
      case 1:
        return new CompiledConceptDescriptor("org.jetbrains.mps.samples.ParallelFor.structure.ParallelFor", "jetbrains.mps.baseLanguage.structure.AbstractLoopStatement", false, new String[]{"jetbrains.mps.baseLanguage.structure.AbstractLoopStatement", "jetbrains.mps.baseLanguage.structure.IMethodLike"}, new String[]{"nowait"}, new String[]{});
      case 2:
        return new CompiledConceptDescriptor("org.jetbrains.mps.samples.ParallelFor.structure.ParallelLoopVariable", "jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration", false, new String[]{"jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration"}, new String[]{}, new String[]{});
      case 3:
        return new CompiledConceptDescriptor("org.jetbrains.mps.samples.ParallelFor.structure.ThreadPool", "jetbrains.mps.baseLanguage.structure.Expression", false, new String[]{"jetbrains.mps.baseLanguage.structure.Expression"}, new String[]{"numberOfThreads"}, new String[]{});
      case 4:
        return new CompiledConceptDescriptor("org.jetbrains.mps.samples.ParallelFor.structure.ThreadSafe", "jetbrains.mps.lang.core.structure.NodeAttribute", false, new String[]{"jetbrains.mps.lang.core.structure.NodeAttribute"}, new String[]{}, new String[]{});
      default:
        return StructureAspectInterpreted.getInstance().getDescriptor(conceptFqName);
    }
  }
}
