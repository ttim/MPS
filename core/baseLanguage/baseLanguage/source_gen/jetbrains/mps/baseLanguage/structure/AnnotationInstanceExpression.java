package jetbrains.mps.baseLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class AnnotationInstanceExpression extends Expression {
  public static final String concept = "jetbrains.mps.baseLanguage.structure.AnnotationInstanceExpression";
  public static final String ANNOTATION_INSTANCE = "annotationInstance";

  public AnnotationInstanceExpression(SNode node) {
    super(node);
  }

  public AnnotationInstance getAnnotationInstance() {
    return (AnnotationInstance)this.getChild(AnnotationInstance.class, AnnotationInstanceExpression.ANNOTATION_INSTANCE);
  }

  public void setAnnotationInstance(AnnotationInstance node) {
    super.setChild(AnnotationInstanceExpression.ANNOTATION_INSTANCE, node);
  }

  public static AnnotationInstanceExpression newInstance(SModel sm, boolean init) {
    return (AnnotationInstanceExpression)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.AnnotationInstanceExpression", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static AnnotationInstanceExpression newInstance(SModel sm) {
    return AnnotationInstanceExpression.newInstance(sm, false);
  }
}
