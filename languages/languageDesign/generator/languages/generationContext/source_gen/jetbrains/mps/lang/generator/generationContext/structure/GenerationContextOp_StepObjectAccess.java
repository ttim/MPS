package jetbrains.mps.lang.generator.generationContext.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class GenerationContextOp_StepObjectAccess extends GenerationContextOp_UserObjectAccessBase {
  public static final String concept = "jetbrains.mps.lang.generator.generationContext.structure.GenerationContextOp_StepObjectAccess";

  public GenerationContextOp_StepObjectAccess(SNode node) {
    super(node);
  }

  public static GenerationContextOp_StepObjectAccess newInstance(SModel sm, boolean init) {
    return (GenerationContextOp_StepObjectAccess) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.generator.generationContext.structure.GenerationContextOp_StepObjectAccess", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static GenerationContextOp_StepObjectAccess newInstance(SModel sm) {
    return GenerationContextOp_StepObjectAccess.newInstance(sm, false);
  }
}
