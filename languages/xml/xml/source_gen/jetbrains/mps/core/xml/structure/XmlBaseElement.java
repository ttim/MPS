package jetbrains.mps.core.xml.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class XmlBaseElement extends XmlContent {
  public static final String concept = "jetbrains.mps.core.xml.structure.XmlBaseElement";

  public XmlBaseElement(SNode node) {
    super(node);
  }

  public static XmlBaseElement newInstance(SModel sm, boolean init) {
    return (XmlBaseElement) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.core.xml.structure.XmlBaseElement", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static XmlBaseElement newInstance(SModel sm) {
    return XmlBaseElement.newInstance(sm, false);
  }
}
