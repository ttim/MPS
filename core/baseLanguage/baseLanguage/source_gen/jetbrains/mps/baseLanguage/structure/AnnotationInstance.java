package jetbrains.mps.baseLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.core.structure.BaseConcept;
import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class AnnotationInstance extends BaseConcept {
  public static final String concept = "jetbrains.mps.baseLanguage.structure.AnnotationInstance";
  public static String ANNOTATION = "annotation";
  public static String VALUE = "value";

  public AnnotationInstance(SNode node) {
    super(node);
  }

  public Annotation getAnnotation() {
    return (Annotation)this.getReferent(AnnotationInstance.ANNOTATION);
  }

  public void setAnnotation(Annotation node) {
    super.setReferent(AnnotationInstance.ANNOTATION, node);
  }

  public int getValuesCount() {
    return this.getChildCount(AnnotationInstance.VALUE);
  }

  public Iterator<AnnotationInstanceValue> values() {
    return this.children(AnnotationInstance.VALUE);
  }

  public List<AnnotationInstanceValue> getValues() {
    return this.getChildren(AnnotationInstance.VALUE);
  }

  public void addValue(AnnotationInstanceValue node) {
    this.addChild(AnnotationInstance.VALUE, node);
  }

  public void insertValue(AnnotationInstanceValue prev, AnnotationInstanceValue node) {
    this.insertChild(prev, AnnotationInstance.VALUE, node);
  }


  public static AnnotationInstance newInstance(SModel sm, boolean init) {
    return (AnnotationInstance)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.AnnotationInstance", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static AnnotationInstance newInstance(SModel sm) {
    return AnnotationInstance.newInstance(sm, false);
  }

}
