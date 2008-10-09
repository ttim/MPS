package jetbrains.mps.lang.editor.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.ConceptFunction;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class TransactionalPropertyHandler extends ConceptFunction {
  public static final String concept = "jetbrains.mps.lang.editor.structure.TransactionalPropertyHandler";

  public TransactionalPropertyHandler(SNode node) {
    super(node);
  }

  public static TransactionalPropertyHandler newInstance(SModel sm, boolean init) {
    return (TransactionalPropertyHandler)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.editor.structure.TransactionalPropertyHandler", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static TransactionalPropertyHandler newInstance(SModel sm) {
    return TransactionalPropertyHandler.newInstance(sm, false);
  }

}
