package org.jetbrains.mps.samples.ParallelFor.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.Expression;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ThreadPool extends Expression {
  public static final String concept = "org.jetbrains.mps.samples.ParallelFor.structure.ThreadPool";
  public static final String NUMBER_OF_THREADS = "numberOfThreads";

  public ThreadPool(SNode node) {
    super(node);
  }

  public int getNumberOfThreads() {
    return this.getIntegerProperty(ThreadPool.NUMBER_OF_THREADS);
  }

  public void setNumberOfThreads(int value) {
    this.setIntegerProperty(ThreadPool.NUMBER_OF_THREADS, value);
  }

  public static ThreadPool newInstance(SModel sm, boolean init) {
    return (ThreadPool) SModelUtil_new.instantiateConceptDeclaration("org.jetbrains.mps.samples.ParallelFor.structure.ThreadPool", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ThreadPool newInstance(SModel sm) {
    return ThreadPool.newInstance(sm, false);
  }
}
