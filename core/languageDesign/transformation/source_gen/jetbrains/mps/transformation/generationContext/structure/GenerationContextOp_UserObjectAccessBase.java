package jetbrains.mps.transformation.generationContext.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.structure.Expression;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class GenerationContextOp_UserObjectAccessBase extends GenerationContextOp_Base {
  public static final String concept = "jetbrains.mps.transformation.generationContext.structure.GenerationContextOp_UserObjectAccessBase";
  public static String USER_KEY = "userKey";

  public GenerationContextOp_UserObjectAccessBase(SNode node) {
    super(node);
  }

  public Expression getUserKey() {
    return (Expression)this.getChild(GenerationContextOp_UserObjectAccessBase.USER_KEY);
  }

  public void setUserKey(Expression node) {
    super.setChild(GenerationContextOp_UserObjectAccessBase.USER_KEY, node);
  }


  public static GenerationContextOp_UserObjectAccessBase newInstance(SModel sm, boolean init) {
    return (GenerationContextOp_UserObjectAccessBase)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.transformation.generationContext.structure.GenerationContextOp_UserObjectAccessBase", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static GenerationContextOp_UserObjectAccessBase newInstance(SModel sm) {
    return GenerationContextOp_UserObjectAccessBase.newInstance(sm, false);
  }

}
