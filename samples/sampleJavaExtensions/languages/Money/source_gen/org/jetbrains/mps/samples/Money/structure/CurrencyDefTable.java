package org.jetbrains.mps.samples.Money.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class CurrencyDefTable extends BaseConcept {
  public static final String concept = "org.jetbrains.mps.samples.Money.structure.CurrencyDefTable";
  public static final String UNITS = "units";

  public CurrencyDefTable(SNode node) {
    super(node);
  }

  public int getUnitsesCount() {
    return this.getChildCount(CurrencyDefTable.UNITS);
  }

  public Iterator<CurrencyUnit> unitses() {
    return this.children(CurrencyUnit.class, CurrencyDefTable.UNITS);
  }

  public List<CurrencyUnit> getUnitses() {
    return this.getChildren(CurrencyUnit.class, CurrencyDefTable.UNITS);
  }

  public void addUnits(CurrencyUnit node) {
    this.addChild(CurrencyDefTable.UNITS, node);
  }

  public void insertUnits(CurrencyUnit prev, CurrencyUnit node) {
    this.insertChild(prev, CurrencyDefTable.UNITS, node);
  }

  public static CurrencyDefTable newInstance(SModel sm, boolean init) {
    return (CurrencyDefTable) SModelUtil_new.instantiateConceptDeclaration("org.jetbrains.mps.samples.Money.structure.CurrencyDefTable", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static CurrencyDefTable newInstance(SModel sm) {
    return CurrencyDefTable.newInstance(sm, false);
  }
}
