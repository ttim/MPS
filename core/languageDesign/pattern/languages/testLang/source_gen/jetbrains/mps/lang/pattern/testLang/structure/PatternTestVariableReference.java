package jetbrains.mps.lang.pattern.testLang.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.pattern.structure.PatternVariableDeclaration;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class PatternTestVariableReference extends BaseConcept {
  public static final String concept = "jetbrains.mps.lang.pattern.testLang.structure.PatternTestVariableReference";
  public static final String DECLARATION = "declaration";

  public PatternTestVariableReference(SNode node) {
    super(node);
  }

  public PatternVariableDeclaration getDeclaration() {
    return (PatternVariableDeclaration) this.getReferent(PatternVariableDeclaration.class, PatternTestVariableReference.DECLARATION);
  }

  public void setDeclaration(PatternVariableDeclaration node) {
    super.setReferent(PatternTestVariableReference.DECLARATION, node);
  }

  public static PatternTestVariableReference newInstance(SModel sm, boolean init) {
    return (PatternTestVariableReference) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.pattern.testLang.structure.PatternTestVariableReference", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static PatternTestVariableReference newInstance(SModel sm) {
    return PatternTestVariableReference.newInstance(sm, false);
  }
}
