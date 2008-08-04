package jetbrains.mps.transformation.generationContext.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class GenerationContextOp_SessionObjectAccess extends GenerationContextOp_UserObjectAccessBase {
  public static final String concept = "jetbrains.mps.transformation.generationContext.structure.GenerationContextOp_SessionObjectAccess";

  public GenerationContextOp_SessionObjectAccess(SNode node) {
    super(node);
  }

  public static GenerationContextOp_SessionObjectAccess newInstance(SModel sm, boolean init) {
    return (GenerationContextOp_SessionObjectAccess)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.transformation.generationContext.structure.GenerationContextOp_SessionObjectAccess", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static GenerationContextOp_SessionObjectAccess newInstance(SModel sm) {
    return GenerationContextOp_SessionObjectAccess.newInstance(sm, false);
  }

}
