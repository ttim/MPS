package jetbrains.mps.core.xml.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class XmlTextValue extends XmlValuePart {
  public static final String concept = "jetbrains.mps.core.xml.structure.XmlTextValue";
  public static final String TEXT = "text";

  public XmlTextValue(SNode node) {
    super(node);
  }

  public String getText() {
    return this.getProperty(XmlTextValue.TEXT);
  }

  public void setText(String value) {
    this.setProperty(XmlTextValue.TEXT, value);
  }

  public static XmlTextValue newInstance(SModel sm, boolean init) {
    return (XmlTextValue) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.core.xml.structure.XmlTextValue", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static XmlTextValue newInstance(SModel sm) {
    return XmlTextValue.newInstance(sm, false);
  }
}
