package jetbrains.mps.lang.plugin.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.ConceptFunction;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class UpdateBlock extends ConceptFunction {
  public static final String concept = "jetbrains.mps.lang.plugin.structure.UpdateBlock";

  public UpdateBlock(SNode node) {
    super(node);
  }

  public static UpdateBlock newInstance(SModel sm, boolean init) {
    return (UpdateBlock)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.plugin.structure.UpdateBlock", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static UpdateBlock newInstance(SModel sm) {
    return UpdateBlock.newInstance(sm, false);
  }
}
