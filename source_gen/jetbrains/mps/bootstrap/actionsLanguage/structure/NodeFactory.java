package jetbrains.mps.bootstrap.actionsLanguage.structure;

/*Generated by MPS  */

import jetbrains.mps.core.structure.BaseConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.bootstrap.structureLanguage.structure.ConceptDeclaration;

public class NodeFactory extends BaseConcept {
  public static String APPLICABLE_CONCEPT = "applicableConcept";
  public static String SETUP_FUNCTION = "setupFunction";
  public static String DESCRIPTION = "description";

  public  NodeFactory(SNode node) {
    super(node);
  }

  public static NodeFactory newInstance(SModel sm, boolean init) {
    return (NodeFactory)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.bootstrap.actionsLanguage.NodeFactory", sm, GlobalScope.getInstance(), init).getAdapter();
  }
  public static NodeFactory newInstance(SModel sm) {
    return NodeFactory.newInstance(sm, false);
  }

  public ConceptDeclaration getApplicableConcept() {
    return (ConceptDeclaration)this.getReferent(NodeFactory.APPLICABLE_CONCEPT);
  }
  public void setApplicableConcept(ConceptDeclaration node) {
    super.setReferent(NodeFactory.APPLICABLE_CONCEPT, node);
  }
  public NodeSetupFunction getSetupFunction() {
    return (NodeSetupFunction)this.getChild(NodeFactory.SETUP_FUNCTION);
  }
  public void setSetupFunction(NodeSetupFunction node) {
    super.setChild(NodeFactory.SETUP_FUNCTION, node);
  }
  public String getDescription() {
    return this.getProperty(NodeFactory.DESCRIPTION);
  }
  public void setDescription(String value) {
    this.setProperty(NodeFactory.DESCRIPTION, value);
  }
}
