package jetbrains.mps.baseLanguage.javadoc.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ClassifierDocComment extends BaseDocComment {
  public static final String concept = "jetbrains.mps.baseLanguage.javadoc.structure.ClassifierDocComment";
  public static final String PARAM = "param";

  public ClassifierDocComment(SNode node) {
    super(node);
  }

  public int getParamsCount() {
    return this.getChildCount(ClassifierDocComment.PARAM);
  }

  public Iterator<ParameterBlockDocTag> params() {
    return this.children(ParameterBlockDocTag.class, ClassifierDocComment.PARAM);
  }

  public List<ParameterBlockDocTag> getParams() {
    return this.getChildren(ParameterBlockDocTag.class, ClassifierDocComment.PARAM);
  }

  public void addParam(ParameterBlockDocTag node) {
    this.addChild(ClassifierDocComment.PARAM, node);
  }

  public void insertParam(ParameterBlockDocTag prev, ParameterBlockDocTag node) {
    this.insertChild(prev, ClassifierDocComment.PARAM, node);
  }

  public static ClassifierDocComment newInstance(SModel sm, boolean init) {
    return (ClassifierDocComment)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.javadoc.structure.ClassifierDocComment", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ClassifierDocComment newInstance(SModel sm) {
    return ClassifierDocComment.newInstance(sm, false);
  }
}
