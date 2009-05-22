package treepath_dom;

/*Generated by MPS */

import jetbrains.mps.ypath.runtime.TreePath;
import org.w3c.dom.Node;
import jetbrains.mps.ypath.runtime.dom.NodeListIterableAdapter;
import org.w3c.dom.Element;
import jetbrains.mps.ypath.runtime.dom.ChainedIterable;
import jetbrains.mps.ypath.runtime.dom.NamedNodeMapIterableAdapter;
import jetbrains.mps.ypath.runtime.IFilter;
import org.w3c.dom.Attr;

public class DOM extends TreePath<Node> {

  public DOM() {
  }

  public Node parent(Node node) {
    return DOM.Parent.parent(node);
  }

  public Iterable<Node> children(Node n) {
    return DOM.Children.children(n);
  }

  private static class Parent {

    public static Node parent(Node node) {
      return node.getParentNode();
    }

}
  private static class Children {

    public static Iterable<Node> children(Node node) {
      Iterable<Node> children = new NodeListIterableAdapter(node.getChildNodes());
      if (node instanceof Element) {
        return (Iterable<Node>)new ChainedIterable(new NamedNodeMapIterableAdapter(node.getAttributes()), children);
      }
      return (Iterable<Node>)children;
    }

}
  public static class ELEMENT_NodeKindTrigger implements IFilter<Node> {
    private static DOM.ELEMENT_NodeKindTrigger instance;

    private ELEMENT_NodeKindTrigger() {
    }

    public boolean accept(Node e) {
      return e instanceof Element;
    }


    public static IFilter<Node> getInstance() {
      if (instance == null) {
        instance = new DOM.ELEMENT_NodeKindTrigger();
      }
      return instance;
    }

}
  public static class ATTR_NodeKindTrigger implements IFilter<Node> {
    private static DOM.ATTR_NodeKindTrigger instance;

    private ATTR_NodeKindTrigger() {
    }

    public boolean accept(Node a) {
      return a instanceof Attr;
    }


    public static IFilter<Node> getInstance() {
      if (instance == null) {
        instance = new DOM.ATTR_NodeKindTrigger();
      }
      return instance;
    }

}
  public static class ELEMENT_tag_Property {

    public static IFilter<Node> getMatcher(final String matchValue) {
      IFilter filter;
      if (matchValue != null) {
        filter = new IFilter() {

          public boolean accept(Object n) {
            Node node = (Node)n;
            String actualValue = DOM.ELEMENT_tag_Property.Getter.getValue(node);
            return matchValue.equals(actualValue);
          }
        };
      } else
      {
        filter = new IFilter() {

          public boolean accept(Object n) {
            Node node = (Node)n;
            String actualValue = DOM.ELEMENT_tag_Property.Getter.getValue(node);
            return actualValue == null;
          }
        };
      }
      return (IFilter<Node>)filter;
    }

    private static class Getter {

      public static String getValue(Node e) {
        return ((Element)e).getTagName();
      }

}

}
  public static class ATTR_name_Property {

    public static IFilter<Node> getMatcher(final String matchValue) {
      IFilter filter;
      if (matchValue != null) {
        filter = new IFilter() {

          public boolean accept(Object n) {
            Node node = (Node)n;
            String actualValue = DOM.ATTR_name_Property.Getter.getValue(node);
            return matchValue.equals(actualValue);
          }
        };
      } else
      {
        filter = new IFilter() {

          public boolean accept(Object n) {
            Node node = (Node)n;
            String actualValue = DOM.ATTR_name_Property.Getter.getValue(node);
            return actualValue == null;
          }
        };
      }
      return (IFilter<Node>)filter;
    }

    private static class Getter {

      public static String getValue(Node a) {
        return ((Attr)a).getName();
      }

}

}
  public static class ATTR_value_Property {

    public static IFilter<Node> getMatcher(final String matchValue) {
      IFilter filter;
      if (matchValue != null) {
        filter = new IFilter() {

          public boolean accept(Object n) {
            Node node = (Node)n;
            String actualValue = DOM.ATTR_value_Property.Getter.getValue(node);
            return matchValue.equals(actualValue);
          }
        };
      } else
      {
        filter = new IFilter() {

          public boolean accept(Object n) {
            Node node = (Node)n;
            String actualValue = DOM.ATTR_value_Property.Getter.getValue(node);
            return actualValue == null;
          }
        };
      }
      return (IFilter<Node>)filter;
    }

    private static class Getter {

      public static String getValue(Node a) {
        return ((Attr)a).getValue();
      }

}

}

}
