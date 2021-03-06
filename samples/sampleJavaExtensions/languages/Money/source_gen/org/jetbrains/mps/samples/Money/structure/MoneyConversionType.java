package org.jetbrains.mps.samples.Money.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.Type;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class MoneyConversionType extends Type {
  public static final String concept = "org.jetbrains.mps.samples.Money.structure.MoneyConversionType";

  public MoneyConversionType(SNode node) {
    super(node);
  }

  public static MoneyConversionType newInstance(SModel sm, boolean init) {
    return (MoneyConversionType) SModelUtil_new.instantiateConceptDeclaration("org.jetbrains.mps.samples.Money.structure.MoneyConversionType", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static MoneyConversionType newInstance(SModel sm) {
    return MoneyConversionType.newInstance(sm, false);
  }
}
