package webr.xml.structure;

/*Generated by MPS */

import webr.xml.structure.Content;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;
import webr.xmlSchema.structure.ElementDeclaration;
import webr.xml.structure.ContentList;
import java.util.Iterator;
import webr.xml.structure.BaseAttribute;
import java.util.List;

public class Element extends Content {
  public static String ELEMENT_DECLARATION = "elementDeclaration";
  public static String CONTENT_LIST = "contentList";
  public static String ATTRIBUTE = "attribute";
  public static String IS_EMPTY = "isEmpty";

  public  Element(SNode node) {
    super(node);
  }

  public static Element newInstance(SModel sm, boolean init) {
    return (Element)SModelUtil_new.instantiateConceptDeclaration("webr.xml.Element", sm, GlobalScope.getInstance(), init).getAdapter();
  }
  public static Element newInstance(SModel sm) {
    return Element.newInstance(sm, false);
  }

  public ElementDeclaration getElementDeclaration() {
    return (ElementDeclaration)this.getReferent(Element.ELEMENT_DECLARATION);
  }
  public void setElementDeclaration(ElementDeclaration node) {
    super.setReferent(Element.ELEMENT_DECLARATION, node);
  }
  public ContentList getContentList() {
    return (ContentList)this.getChild(Element.CONTENT_LIST);
  }
  public void setContentList(ContentList node) {
    super.setChild(Element.CONTENT_LIST, node);
  }
  public int getAttributesCount() {
    return this.getChildCount(Element.ATTRIBUTE);
  }
  public Iterator<BaseAttribute> attributes() {
    return this.children(Element.ATTRIBUTE);
  }
  public List<BaseAttribute> getAttributes() {
    return this.getChildren(Element.ATTRIBUTE);
  }
  public void addAttribute(BaseAttribute node) {
    this.addChild(Element.ATTRIBUTE, node);
  }
  public void insertAttribute(BaseAttribute prev, BaseAttribute node) {
    this.insertChild(prev, Element.ATTRIBUTE, node);
  }
  public boolean getIsEmpty() {
    return this.getBooleanProperty(Element.IS_EMPTY);
  }
  public void setIsEmpty(boolean value) {
    this.setBooleanProperty(Element.IS_EMPTY, value);
  }
}
