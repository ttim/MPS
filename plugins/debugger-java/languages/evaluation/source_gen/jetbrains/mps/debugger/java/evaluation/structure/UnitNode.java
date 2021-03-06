package jetbrains.mps.debugger.java.evaluation.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class UnitNode extends BaseConcept {
  public static final String concept = "jetbrains.mps.debugger.java.evaluation.structure.UnitNode";
  public static final String HIGH_LEVEL_NODE_ID = "highLevelNodeId";
  public static final String DEBUGGED_TYPE = "debuggedType";

  public UnitNode(SNode node) {
    super(node);
  }

  public String getHighLevelNodeId() {
    return this.getProperty(UnitNode.HIGH_LEVEL_NODE_ID);
  }

  public void setHighLevelNodeId(String value) {
    this.setProperty(UnitNode.HIGH_LEVEL_NODE_ID, value);
  }

  public DebuggedType getDebuggedType() {
    return (DebuggedType) this.getChild(DebuggedType.class, UnitNode.DEBUGGED_TYPE);
  }

  public void setDebuggedType(DebuggedType node) {
    super.setChild(UnitNode.DEBUGGED_TYPE, node);
  }

  public static UnitNode newInstance(SModel sm, boolean init) {
    return (UnitNode) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.debugger.java.evaluation.structure.UnitNode", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static UnitNode newInstance(SModel sm) {
    return UnitNode.newInstance(sm, false);
  }
}
