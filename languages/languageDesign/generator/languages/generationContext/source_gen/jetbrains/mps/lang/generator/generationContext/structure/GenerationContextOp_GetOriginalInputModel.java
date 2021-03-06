package jetbrains.mps.lang.generator.generationContext.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class GenerationContextOp_GetOriginalInputModel extends GenerationContextOp_Base {
  public static final String concept = "jetbrains.mps.lang.generator.generationContext.structure.GenerationContextOp_GetOriginalInputModel";

  public GenerationContextOp_GetOriginalInputModel(SNode node) {
    super(node);
  }

  public static GenerationContextOp_GetOriginalInputModel newInstance(SModel sm, boolean init) {
    return (GenerationContextOp_GetOriginalInputModel) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.generator.generationContext.structure.GenerationContextOp_GetOriginalInputModel", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static GenerationContextOp_GetOriginalInputModel newInstance(SModel sm) {
    return GenerationContextOp_GetOriginalInputModel.newInstance(sm, false);
  }
}
