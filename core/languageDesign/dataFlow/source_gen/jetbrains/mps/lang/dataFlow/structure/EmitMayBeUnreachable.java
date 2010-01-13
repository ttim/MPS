package jetbrains.mps.lang.dataFlow.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.Statement;
import jetbrains.mps.baseLanguage.structure.Closureoid;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class EmitMayBeUnreachable extends Statement implements Closureoid {
  public static final String concept = "jetbrains.mps.lang.dataFlow.structure.EmitMayBeUnreachable";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String EMIT_STATEMENT = "emitStatement";

  public EmitMayBeUnreachable(SNode node) {
    super(node);
  }

  public String getShortDescription() {
    return this.getProperty(EmitMayBeUnreachable.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(EmitMayBeUnreachable.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(EmitMayBeUnreachable.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(EmitMayBeUnreachable.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(EmitMayBeUnreachable.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(EmitMayBeUnreachable.VIRTUAL_PACKAGE, value);
  }

  public EmitStatement getEmitStatement() {
    return (EmitStatement) this.getChild(EmitStatement.class, EmitMayBeUnreachable.EMIT_STATEMENT);
  }

  public void setEmitStatement(EmitStatement node) {
    super.setChild(EmitMayBeUnreachable.EMIT_STATEMENT, node);
  }

  public static EmitMayBeUnreachable newInstance(SModel sm, boolean init) {
    return (EmitMayBeUnreachable) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.dataFlow.structure.EmitMayBeUnreachable", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static EmitMayBeUnreachable newInstance(SModel sm) {
    return EmitMayBeUnreachable.newInstance(sm, false);
  }
}
