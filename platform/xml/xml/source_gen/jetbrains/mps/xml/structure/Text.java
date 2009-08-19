package jetbrains.mps.xml.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class Text extends BaseText {
  public static final String concept = "jetbrains.mps.xml.structure.Text";
  public static final String TEXT = "text";

  public Text(SNode node) {
    super(node);
  }

  public String getText() {
    return this.getProperty(Text.TEXT);
  }

  public void setText(String value) {
    this.setProperty(Text.TEXT, value);
  }

  public static Text newInstance(SModel sm, boolean init) {
    return (Text)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.xml.structure.Text", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static Text newInstance(SModel sm) {
    return Text.newInstance(sm, false);
  }
}
