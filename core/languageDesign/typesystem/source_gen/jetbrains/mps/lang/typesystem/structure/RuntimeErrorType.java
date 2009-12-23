package jetbrains.mps.lang.typesystem.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class RuntimeErrorType extends RuntimeTypeVariable {
  public static final String concept = "jetbrains.mps.lang.typesystem.structure.RuntimeErrorType";
  public static final String ERROR_TEXT = "errorText";
  public static final String NODE_ID = "nodeId";
  public static final String NODE_MODEL = "nodeModel";

  public RuntimeErrorType(SNode node) {
    super(node);
  }

  public String getErrorText() {
    return this.getProperty(RuntimeErrorType.ERROR_TEXT);
  }

  public void setErrorText(String value) {
    this.setProperty(RuntimeErrorType.ERROR_TEXT, value);
  }

  public String getNodeId() {
    return this.getProperty(RuntimeErrorType.NODE_ID);
  }

  public void setNodeId(String value) {
    this.setProperty(RuntimeErrorType.NODE_ID, value);
  }

  public String getNodeModel() {
    return this.getProperty(RuntimeErrorType.NODE_MODEL);
  }

  public void setNodeModel(String value) {
    this.setProperty(RuntimeErrorType.NODE_MODEL, value);
  }

  public static RuntimeErrorType newInstance(SModel sm, boolean init) {
    return (RuntimeErrorType) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.typesystem.structure.RuntimeErrorType", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static RuntimeErrorType newInstance(SModel sm) {
    return RuntimeErrorType.newInstance(sm, false);
  }
}
