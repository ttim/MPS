package jetbrains.mps.baseLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.core.structure.BaseConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class InstanceInitializer extends BaseConcept {
  public static final String concept = "jetbrains.mps.baseLanguage.structure.InstanceInitializer";
  public static String STATEMENT_LIST = "statementList";

  public InstanceInitializer(SNode node) {
    super(node);
  }

  public StatementList getStatementList() {
    return (StatementList)this.getChild(InstanceInitializer.STATEMENT_LIST);
  }

  public void setStatementList(StatementList node) {
    super.setChild(InstanceInitializer.STATEMENT_LIST, node);
  }


  public static InstanceInitializer newInstance(SModel sm, boolean init) {
    return (InstanceInitializer)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.InstanceInitializer", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static InstanceInitializer newInstance(SModel sm) {
    return InstanceInitializer.newInstance(sm, false);
  }

}
