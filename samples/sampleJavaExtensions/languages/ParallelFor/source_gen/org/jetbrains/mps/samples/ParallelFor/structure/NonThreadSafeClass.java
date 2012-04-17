package org.jetbrains.mps.samples.ParallelFor.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.NodeAttribute;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class NonThreadSafeClass extends NodeAttribute {
  public static final String concept = "org.jetbrains.mps.samples.ParallelFor.structure.NonThreadSafeClass";

  public NonThreadSafeClass(SNode node) {
    super(node);
  }

  public static NonThreadSafeClass newInstance(SModel sm, boolean init) {
    return (NonThreadSafeClass) SModelUtil_new.instantiateConceptDeclaration("org.jetbrains.mps.samples.ParallelFor.structure.NonThreadSafeClass", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static NonThreadSafeClass newInstance(SModel sm) {
    return NonThreadSafeClass.newInstance(sm, false);
  }
}
