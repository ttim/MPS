package jetbrains.mps.lang.editor.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class AppendTextOperation extends AbstractStyledTextOperation {
  public static final String concept = "jetbrains.mps.lang.editor.structure.AppendTextOperation";

  public AppendTextOperation(SNode node) {
    super(node);
  }

  public static AppendTextOperation newInstance(SModel sm, boolean init) {
    return (AppendTextOperation) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.editor.structure.AppendTextOperation", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static AppendTextOperation newInstance(SModel sm) {
    return AppendTextOperation.newInstance(sm, false);
  }
}
