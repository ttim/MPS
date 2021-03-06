package jetbrains.mps.lang.generator.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class WeaveEach_RuleConsequence extends RuleConsequence {
  public static final String concept = "jetbrains.mps.lang.generator.structure.WeaveEach_RuleConsequence";
  public static final String TEMPLATE = "template";
  public static final String SOURCE_NODES_QUERY = "sourceNodesQuery";

  public WeaveEach_RuleConsequence(SNode node) {
    super(node);
  }

  public TemplateDeclaration getTemplate() {
    return (TemplateDeclaration) this.getReferent(TemplateDeclaration.class, WeaveEach_RuleConsequence.TEMPLATE);
  }

  public void setTemplate(TemplateDeclaration node) {
    super.setReferent(WeaveEach_RuleConsequence.TEMPLATE, node);
  }

  public SourceSubstituteMacro_SourceNodesQuery getSourceNodesQuery() {
    return (SourceSubstituteMacro_SourceNodesQuery) this.getChild(SourceSubstituteMacro_SourceNodesQuery.class, WeaveEach_RuleConsequence.SOURCE_NODES_QUERY);
  }

  public void setSourceNodesQuery(SourceSubstituteMacro_SourceNodesQuery node) {
    super.setChild(WeaveEach_RuleConsequence.SOURCE_NODES_QUERY, node);
  }

  public static WeaveEach_RuleConsequence newInstance(SModel sm, boolean init) {
    return (WeaveEach_RuleConsequence) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.generator.structure.WeaveEach_RuleConsequence", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static WeaveEach_RuleConsequence newInstance(SModel sm) {
    return WeaveEach_RuleConsequence.newInstance(sm, false);
  }
}
