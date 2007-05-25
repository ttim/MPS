package jetbrains.mps.bootstrap.actionsLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.core.structure.BaseConcept;
import jetbrains.mps.core.structure.INamedConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.bootstrap.actionsLanguage.structure.NodeFactory;

public class NodeFactories extends BaseConcept implements INamedConcept {
  public static String NAME = "name";
  public static String NODE_FACTORY = "nodeFactory";

  public  NodeFactories(SNode node) {
    super(node);
  }

  public static NodeFactories newInstance(SModel sm, boolean init) {
    return (NodeFactories)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.bootstrap.actionsLanguage.NodeFactories", sm, GlobalScope.getInstance(), init).getAdapter();
  }
  public static NodeFactories newInstance(SModel sm) {
    return NodeFactories.newInstance(sm, false);
  }

  public String getName() {
    return this.getProperty(NodeFactories.NAME);
  }
  public void setName(String value) {
    this.setProperty(NodeFactories.NAME, value);
  }
  public NodeFactory getNodeFactory() {
    return (NodeFactory)this.getChild(NodeFactories.NODE_FACTORY);
  }
  public void setNodeFactory(NodeFactory node) {
    super.setChild(NodeFactories.NODE_FACTORY, node);
  }
}
