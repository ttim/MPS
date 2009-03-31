package jetbrains.mps.lang.constraints.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.structure.structure.LinkDeclaration;
import jetbrains.mps.lang.constraints.structure.ConstraintFunction_ReferentSearchScope_Factory;
import jetbrains.mps.lang.constraints.structure.ConstraintFunction_ReferentSetHandler;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class NodeReferentConstraint extends BaseConcept {
  public static final String concept = "jetbrains.mps.lang.constraints.structure.NodeReferentConstraint";
  public static final String APPLICABLE_LINK = "applicableLink";
  public static final String SEARCH_SCOPE_FACTORY = "searchScopeFactory";
  public static final String REFERENT_SET_HANDLER = "referentSetHandler";

  public NodeReferentConstraint(SNode node) {
    super(node);
  }

  public LinkDeclaration getApplicableLink() {
    return (LinkDeclaration)this.getReferent(LinkDeclaration.class, NodeReferentConstraint.APPLICABLE_LINK);
  }

  public void setApplicableLink(LinkDeclaration node) {
    super.setReferent(NodeReferentConstraint.APPLICABLE_LINK, node);
  }

  public ConstraintFunction_ReferentSearchScope_Factory getSearchScopeFactory() {
    return (ConstraintFunction_ReferentSearchScope_Factory)this.getChild(ConstraintFunction_ReferentSearchScope_Factory.class, NodeReferentConstraint.SEARCH_SCOPE_FACTORY);
  }

  public void setSearchScopeFactory(ConstraintFunction_ReferentSearchScope_Factory node) {
    super.setChild(NodeReferentConstraint.SEARCH_SCOPE_FACTORY, node);
  }

  public ConstraintFunction_ReferentSetHandler getReferentSetHandler() {
    return (ConstraintFunction_ReferentSetHandler)this.getChild(ConstraintFunction_ReferentSetHandler.class, NodeReferentConstraint.REFERENT_SET_HANDLER);
  }

  public void setReferentSetHandler(ConstraintFunction_ReferentSetHandler node) {
    super.setChild(NodeReferentConstraint.REFERENT_SET_HANDLER, node);
  }


  public static NodeReferentConstraint newInstance(SModel sm, boolean init) {
    return (NodeReferentConstraint)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.constraints.structure.NodeReferentConstraint", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static NodeReferentConstraint newInstance(SModel sm) {
    return NodeReferentConstraint.newInstance(sm, false);
  }

}
