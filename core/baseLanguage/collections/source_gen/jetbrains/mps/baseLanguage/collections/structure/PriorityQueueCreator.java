package jetbrains.mps.baseLanguage.collections.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class PriorityQueueCreator extends AbstractContainerCreator {
  public static final String concept = "jetbrains.mps.baseLanguage.collections.structure.PriorityQueueCreator";

  public PriorityQueueCreator(SNode node) {
    super(node);
  }

  public static PriorityQueueCreator newInstance(SModel sm, boolean init) {
    return (PriorityQueueCreator)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.PriorityQueueCreator", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static PriorityQueueCreator newInstance(SModel sm) {
    return PriorityQueueCreator.newInstance(sm, false);
  }
}
