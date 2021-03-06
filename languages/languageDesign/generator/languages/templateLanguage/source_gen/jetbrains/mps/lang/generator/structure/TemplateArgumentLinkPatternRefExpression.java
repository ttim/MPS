package jetbrains.mps.lang.generator.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.pattern.structure.LinkPatternVariableDeclaration;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class TemplateArgumentLinkPatternRefExpression extends TemplateArgumentPatternRef {
  public static final String concept = "jetbrains.mps.lang.generator.structure.TemplateArgumentLinkPatternRefExpression";
  public static final String PATTERN_VAR = "patternVar";

  public TemplateArgumentLinkPatternRefExpression(SNode node) {
    super(node);
  }

  public LinkPatternVariableDeclaration getPatternVar() {
    return (LinkPatternVariableDeclaration) this.getReferent(LinkPatternVariableDeclaration.class, TemplateArgumentLinkPatternRefExpression.PATTERN_VAR);
  }

  public void setPatternVar(LinkPatternVariableDeclaration node) {
    super.setReferent(TemplateArgumentLinkPatternRefExpression.PATTERN_VAR, node);
  }

  public static TemplateArgumentLinkPatternRefExpression newInstance(SModel sm, boolean init) {
    return (TemplateArgumentLinkPatternRefExpression) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.generator.structure.TemplateArgumentLinkPatternRefExpression", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static TemplateArgumentLinkPatternRefExpression newInstance(SModel sm) {
    return TemplateArgumentLinkPatternRefExpression.newInstance(sm, false);
  }
}
