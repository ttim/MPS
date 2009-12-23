package jetbrains.mps.lang.typesystem.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class NodeInfo extends BaseConcept {
  public static final String concept = "jetbrains.mps.lang.typesystem.structure.NodeInfo";
  public static final String MODEL_ID = "modelId";
  public static final String NODE_ID = "nodeId";

  public NodeInfo(SNode node) {
    super(node);
  }

  public String getModelId() {
    return this.getProperty(NodeInfo.MODEL_ID);
  }

  public void setModelId(String value) {
    this.setProperty(NodeInfo.MODEL_ID, value);
  }

  public String getNodeId() {
    return this.getProperty(NodeInfo.NODE_ID);
  }

  public void setNodeId(String value) {
    this.setProperty(NodeInfo.NODE_ID, value);
  }

  public static NodeInfo newInstance(SModel sm, boolean init) {
    return (NodeInfo) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.typesystem.structure.NodeInfo", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static NodeInfo newInstance(SModel sm) {
    return NodeInfo.newInstance(sm, false);
  }
}
