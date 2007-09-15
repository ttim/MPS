package jetbrains.mps.baseLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.core.structure.BaseConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class SwitchCase extends BaseConcept {
  public static final String concept = "jetbrains.mps.baseLanguage.structure.SwitchCase";
  public static String EXPRESSION = "expression";
  public static String BODY = "body";

  public  SwitchCase(SNode node) {
    super(node);
  }

  public static SwitchCase newInstance(SModel sm, boolean init) {
    return (SwitchCase)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.SwitchCase", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static SwitchCase newInstance(SModel sm) {
    return SwitchCase.newInstance(sm, false);
  }


  public Expression getExpression() {
    return (Expression)this.getChild(SwitchCase.EXPRESSION);
  }

  public void setExpression(Expression node) {
    super.setChild(SwitchCase.EXPRESSION, node);
  }

  public StatementList getBody() {
    return (StatementList)this.getChild(SwitchCase.BODY);
  }

  public void setBody(StatementList node) {
    super.setChild(SwitchCase.BODY, node);
  }

}
