package jetbrains.mps.lang.editor.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class SetBoldOperation extends AbstractStyledTextOperation {
  public static final String concept = "jetbrains.mps.lang.editor.structure.SetBoldOperation";

  public SetBoldOperation(SNode node) {
    super(node);
  }

  public static SetBoldOperation newInstance(SModel sm, boolean init) {
    return (SetBoldOperation)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.editor.structure.SetBoldOperation", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static SetBoldOperation newInstance(SModel sm) {
    return SetBoldOperation.newInstance(sm, false);
  }
}
