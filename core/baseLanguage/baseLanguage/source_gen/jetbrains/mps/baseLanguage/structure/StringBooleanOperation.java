package jetbrains.mps.baseLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class StringBooleanOperation extends BaseStringOperation {
  public static final String concept = "jetbrains.mps.baseLanguage.structure.StringBooleanOperation";

  public StringBooleanOperation(SNode node) {
    super(node);
  }

  public static StringBooleanOperation newInstance(SModel sm, boolean init) {
    return (StringBooleanOperation)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.StringBooleanOperation", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static StringBooleanOperation newInstance(SModel sm) {
    return StringBooleanOperation.newInstance(sm, false);
  }
}
