package jetbrains.mps.lang.generator.generationContext.structure;

/*Generated by MPS */

import jetbrains.mps.lang.generator.generationContext.structure.GenerationContextOp_ShowMessageBase;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class GenerationContextOp_ShowWarningMessage extends GenerationContextOp_ShowMessageBase {
  public static final String concept = "jetbrains.mps.lang.generator.generationContext.structure.GenerationContextOp_ShowWarningMessage";

  public GenerationContextOp_ShowWarningMessage(SNode node) {
    super(node);
  }

  public static GenerationContextOp_ShowWarningMessage newInstance(SModel sm, boolean init) {
    return (GenerationContextOp_ShowWarningMessage)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.generator.generationContext.structure.GenerationContextOp_ShowWarningMessage", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static GenerationContextOp_ShowWarningMessage newInstance(SModel sm) {
    return GenerationContextOp_ShowWarningMessage.newInstance(sm, false);
  }

}
