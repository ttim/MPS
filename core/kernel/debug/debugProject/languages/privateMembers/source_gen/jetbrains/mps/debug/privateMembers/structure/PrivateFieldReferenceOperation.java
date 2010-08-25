package jetbrains.mps.debug.privateMembers.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.FieldReferenceOperation;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class PrivateFieldReferenceOperation extends FieldReferenceOperation {
  public static final String concept = "jetbrains.mps.debug.privateMembers.structure.PrivateFieldReferenceOperation";

  public PrivateFieldReferenceOperation(SNode node) {
    super(node);
  }

  public static PrivateFieldReferenceOperation newInstance(SModel sm, boolean init) {
    return (PrivateFieldReferenceOperation) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.debug.privateMembers.structure.PrivateFieldReferenceOperation", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static PrivateFieldReferenceOperation newInstance(SModel sm) {
    return PrivateFieldReferenceOperation.newInstance(sm, false);
  }
}
