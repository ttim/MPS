package jetbrains.mps.lang.pattern.testLang.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class VariableValue extends BaseConcept {
  public static final String concept = "jetbrains.mps.lang.pattern.testLang.structure.VariableValue";
  public static final String VALUE = "value";
  public static final String VARIABLE = "variable";

  public VariableValue(SNode node) {
    super(node);
  }

  public BaseConcept getValue() {
    return (BaseConcept) this.getChild(BaseConcept.class, VariableValue.VALUE);
  }

  public void setValue(BaseConcept node) {
    super.setChild(VariableValue.VALUE, node);
  }

  public TestVariableReference getVariable() {
    return (TestVariableReference) this.getChild(TestVariableReference.class, VariableValue.VARIABLE);
  }

  public void setVariable(TestVariableReference node) {
    super.setChild(VariableValue.VARIABLE, node);
  }

  public static VariableValue newInstance(SModel sm, boolean init) {
    return (VariableValue) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.pattern.testLang.structure.VariableValue", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static VariableValue newInstance(SModel sm) {
    return VariableValue.newInstance(sm, false);
  }
}
