package jetbrains.mps.lang.editor.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class CellMenuComponentFeature extends BaseConcept {
  public static final String concept = "jetbrains.mps.lang.editor.structure.CellMenuComponentFeature";
  public static String RELATION_DECLARATION = "relationDeclaration";

  public CellMenuComponentFeature(SNode node) {
    super(node);
  }

  public BaseConcept getRelationDeclaration() {
    return (BaseConcept)this.getReferent(CellMenuComponentFeature.RELATION_DECLARATION);
  }

  public void setRelationDeclaration(BaseConcept node) {
    super.setReferent(CellMenuComponentFeature.RELATION_DECLARATION, node);
  }


  public static CellMenuComponentFeature newInstance(SModel sm, boolean init) {
    return (CellMenuComponentFeature)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.editor.structure.CellMenuComponentFeature", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static CellMenuComponentFeature newInstance(SModel sm) {
    return CellMenuComponentFeature.newInstance(sm, false);
  }

}
