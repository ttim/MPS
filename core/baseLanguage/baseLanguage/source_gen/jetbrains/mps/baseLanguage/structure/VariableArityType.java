package jetbrains.mps.baseLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class VariableArityType extends Type {
  public static final String concept = "jetbrains.mps.baseLanguage.structure.VariableArityType";
  public static String COMPONENT_TYPE = "componentType";

  public VariableArityType(SNode node) {
    super(node);
  }

  public Type getComponentType() {
    return (Type)this.getChild(VariableArityType.COMPONENT_TYPE);
  }

  public void setComponentType(Type node) {
    super.setChild(VariableArityType.COMPONENT_TYPE, node);
  }


  public static VariableArityType newInstance(SModel sm, boolean init) {
    return (VariableArityType)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.VariableArityType", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static VariableArityType newInstance(SModel sm) {
    return VariableArityType.newInstance(sm, false);
  }

}
