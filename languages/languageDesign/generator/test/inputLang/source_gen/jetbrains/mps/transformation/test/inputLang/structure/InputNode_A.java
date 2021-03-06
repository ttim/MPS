package jetbrains.mps.transformation.test.inputLang.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class InputNode_A extends InputNode {
  public static final String concept = "jetbrains.mps.transformation.test.inputLang.structure.InputNode_A";
  public static final String OPTION = "option";

  public InputNode_A(SNode node) {
    super(node);
  }

  public Option getOption() {
    String value = super.getProperty(InputNode_A.OPTION);
    return Option.parseValue(value);
  }

  public void setOption(Option value) {
    super.setProperty(InputNode_A.OPTION, value.getValueAsString());
  }

  public static InputNode_A newInstance(SModel sm, boolean init) {
    return (InputNode_A) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.transformation.test.inputLang.structure.InputNode_A", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static InputNode_A newInstance(SModel sm) {
    return InputNode_A.newInstance(sm, false);
  }
}
