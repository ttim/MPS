package jetbrains.mps.baseLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class LocalVariableDeclaration extends VariableDeclaration {
  public static final String concept = "jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration";

  public  LocalVariableDeclaration(SNode node) {
    super(node);
  }

  public static LocalVariableDeclaration newInstance(SModel sm, boolean init) {
    return (LocalVariableDeclaration)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static LocalVariableDeclaration newInstance(SModel sm) {
    return LocalVariableDeclaration.newInstance(sm, false);
  }

}
