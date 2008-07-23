package webr.xml.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;
import java.util.Iterator;
import java.util.List;

public class ComplexText extends BaseText {
  public static final String concept = "webr.xml.structure.ComplexText";
  public static String TEXT = "text";

  public ComplexText(SNode node) {
    super(node);
  }

  public static ComplexText newInstance(SModel sm, boolean init) {
    return (ComplexText)SModelUtil_new.instantiateConceptDeclaration("webr.xml.structure.ComplexText", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ComplexText newInstance(SModel sm) {
    return ComplexText.newInstance(sm, false);
  }


  public int getTextsCount() {
    return this.getChildCount(ComplexText.TEXT);
  }

  public Iterator<BaseText> texts() {
    return this.children(ComplexText.TEXT);
  }

  public List<BaseText> getTexts() {
    return this.getChildren(ComplexText.TEXT);
  }

  public void addText(BaseText node) {
    this.addChild(ComplexText.TEXT, node);
  }

  public void insertText(BaseText prev, BaseText node) {
    this.insertChild(prev, ComplexText.TEXT, node);
  }

}
