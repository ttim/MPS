package jetbrains.mps.bootstrap.actionsLanguage.structure;

/*Generated by MPS  */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class AddSubstitutePart extends ConceptSubstitutePart {

  public  AddSubstitutePart(SNode node) {
    super(node);
  }

  public static AddSubstitutePart newInstance(SModel sm, boolean init) {
    return (AddSubstitutePart)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.bootstrap.actionsLanguage.AddSubstitutePart", sm, GlobalScope.getInstance(), init).getAdapter();
  }
  public static AddSubstitutePart newInstance(SModel sm) {
    return AddSubstitutePart.newInstance(sm, false);
  }
}
