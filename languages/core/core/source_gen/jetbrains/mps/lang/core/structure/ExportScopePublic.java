package jetbrains.mps.lang.core.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ExportScopePublic extends ExportScope {
  public static final String concept = "jetbrains.mps.lang.core.structure.ExportScopePublic";

  public ExportScopePublic(SNode node) {
    super(node);
  }

  public static ExportScopePublic newInstance(SModel sm, boolean init) {
    return (ExportScopePublic) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.core.structure.ExportScopePublic", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ExportScopePublic newInstance(SModel sm) {
    return ExportScopePublic.newInstance(sm, false);
  }
}
