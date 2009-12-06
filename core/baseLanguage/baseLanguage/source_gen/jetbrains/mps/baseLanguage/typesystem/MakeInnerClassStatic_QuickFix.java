package jetbrains.mps.baseLanguage.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.quickfix.QuickFix_Runtime;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.smodel.SNode;

public class MakeInnerClassStatic_QuickFix extends QuickFix_Runtime {
  public MakeInnerClassStatic_QuickFix() {
  }

  public String getDescription() {
    return "Make '" + SPropertyOperations.getString(((SNode)MakeInnerClassStatic_QuickFix.this.getField("innerClass")[0]), "name") + "' static";
  }

  public void execute(SNode node) {
    SPropertyOperations.set(((SNode)MakeInnerClassStatic_QuickFix.this.getField("innerClass")[0]), "nonStatic", "" + false);
  }
}
