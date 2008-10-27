package jetbrains.mps.baseLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class CustomPropertyImplementation extends PropertyImplementation {
  public static final String concept = "jetbrains.mps.baseLanguage.structure.CustomPropertyImplementation";
  public static final String GET_ACCESSOR = "getAccessor";
  public static final String SET_ACCESSOR = "setAccessor";

  public CustomPropertyImplementation(SNode node) {
    super(node);
  }

  public GetAccessor getGetAccessor() {
    return (GetAccessor)this.getChild(CustomPropertyImplementation.GET_ACCESSOR);
  }

  public void setGetAccessor(GetAccessor node) {
    super.setChild(CustomPropertyImplementation.GET_ACCESSOR, node);
  }

  public SetAccessor getSetAccessor() {
    return (SetAccessor)this.getChild(CustomPropertyImplementation.SET_ACCESSOR);
  }

  public void setSetAccessor(SetAccessor node) {
    super.setChild(CustomPropertyImplementation.SET_ACCESSOR, node);
  }


  public static CustomPropertyImplementation newInstance(SModel sm, boolean init) {
    return (CustomPropertyImplementation)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.CustomPropertyImplementation", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static CustomPropertyImplementation newInstance(SModel sm) {
    return CustomPropertyImplementation.newInstance(sm, false);
  }

}
