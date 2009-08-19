package jetbrains.mps.lang.typesystem.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class Processed extends BaseConcept {
  public static final String concept = "jetbrains.mps.lang.typesystem.structure.Processed";

  public Processed(SNode node) {
    super(node);
  }

  public static Processed newInstance(SModel sm, boolean init) {
    return (Processed)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.typesystem.structure.Processed", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static Processed newInstance(SModel sm) {
    return Processed.newInstance(sm, false);
  }
}
