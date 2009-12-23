package jetbrains.mps.lang.textGen.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class IndentBufferOperation extends SimpleTextGenOperation {
  public static final String concept = "jetbrains.mps.lang.textGen.structure.IndentBufferOperation";

  public IndentBufferOperation(SNode node) {
    super(node);
  }

  public static IndentBufferOperation newInstance(SModel sm, boolean init) {
    return (IndentBufferOperation) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.textGen.structure.IndentBufferOperation", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static IndentBufferOperation newInstance(SModel sm) {
    return IndentBufferOperation.newInstance(sm, false);
  }
}
