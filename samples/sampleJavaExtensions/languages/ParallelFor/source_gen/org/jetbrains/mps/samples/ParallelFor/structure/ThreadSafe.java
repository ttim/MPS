package org.jetbrains.mps.samples.ParallelFor.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.NodeAttribute;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ThreadSafe extends NodeAttribute {
  public static final String concept = "org.jetbrains.mps.samples.ParallelFor.structure.ThreadSafe";

  public ThreadSafe(SNode node) {
    super(node);
  }

  public static ThreadSafe newInstance(SModel sm, boolean init) {
    return (ThreadSafe) SModelUtil_new.instantiateConceptDeclaration("org.jetbrains.mps.samples.ParallelFor.structure.ThreadSafe", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ThreadSafe newInstance(SModel sm) {
    return ThreadSafe.newInstance(sm, false);
  }
}
