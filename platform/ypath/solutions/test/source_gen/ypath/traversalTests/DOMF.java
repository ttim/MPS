package ypath.traversalTests;

/*Generated by MPS */

import jetbrains.mps.ypath.runtime.TreePath;
import org.w3c.dom.Node;
import jetbrains.mps.ypath.runtime.IFeatureDescriptor;
import java.util.AbstractCollection;
import jetbrains.mps.baseLanguage.ext.collections.internal.SequenceWithSupplier;
import java.util.Iterator;
import jetbrains.mps.baseLanguage.ext.collections.internal.query.SequenceOperations;
import org.w3c.dom.Element;

public class DOMF extends TreePath<Node> {

  public  DOMF() {
    this.registerFeature(new DOMF.Desc_Feature_elements());
  }

  public static IFeatureDescriptor<Node> child(String param) {
    return new DOMF.Desc_Feature_child(param);
  }


  public Node parent(Node node) {
    return DOMF.Parent.parent(node);
  }

  private static class Parent {

    /* package */Object _enclosingClass;
    /* package */Object _closureContext;

    public  Parent(Object enclosingClass, Object closureContext) {
      this._enclosingClass = enclosingClass;
      this._closureContext = (Object)closureContext;
    }

    public static Node parent(Node node) {
      return node.getParentNode();
    }

}
  private static class Children {

    /* package */Object _enclosingClass;
    /* package */Object _closureContext;

    public  Children(Object enclosingClass, Object closureContext) {
      this._enclosingClass = enclosingClass;
      this._closureContext = (Object)closureContext;
    }
}
  private static class Feature_elements extends AbstractCollection<Node> {

    private Node thisNode;

    public  Feature_elements(Node thisNode) {
      this.thisNode = thisNode;
    }

    public Iterable<Node> sequence() {
      final zClosureContext1 _zClosureContext = new zClosureContext1();
      _zClosureContext.cns = this.thisNode.getChildNodes();
      return new SequenceWithSupplier<Node>(new zValueSupplier1(null, _zClosureContext));
    }

    public Iterator<Node> iterator() {
      return this.sequence().iterator();
    }

    public int size() {
      final zClosureContext _zClosureContext1 = new zClosureContext();
      _zClosureContext1.cns = this.thisNode.getChildNodes();
      Iterable<Node> seq = new SequenceWithSupplier<Node>(new zValueSupplier(null, _zClosureContext1));
      return SequenceOperations.getSize(seq);
    }

}
  private static class Feature_child extends AbstractCollection<Node> {

    private Node thisNode;
    private String param;

    public  Feature_child(Node thisNode, String param) {
      this.thisNode = thisNode;
      this.param = param;
    }

    public Iterable<Node> sequence() {
      final zClosureContext2 _zClosureContext2 = new zClosureContext2();
      _zClosureContext2.els = ((Element)this.thisNode).getElementsByTagName(this.param);
      return new SequenceWithSupplier<Node>(new zValueSupplier3(null, _zClosureContext2));
    }

    public Iterator<Node> iterator() {
      return this.sequence().iterator();
    }

    public int size() {
      return ((Element)this.thisNode).getElementsByTagName(this.param).getLength();
    }

}
  public static class Desc_Feature_elements extends IFeatureDescriptor.Stub<Node> implements IFeatureDescriptor<Node> {

    public  Desc_Feature_elements() {
    }

    public Iterable<Node> getContents(Node node) {
      return new DOMF.Feature_elements(node);
    }

    public String getOpposite() {
      return null;
    }

    public String getName() {
      return "elements";
    }

    public boolean isDefault() {
      return false;
    }

    public boolean isDirect() {
      return true;
    }

}
  public static class Desc_Feature_child extends IFeatureDescriptor.Stub<Node> implements IFeatureDescriptor<Node> {

    private String param;

    public  Desc_Feature_child(String param) {
      this.param = param;
    }

    public Iterable<Node> getContents(Node node) {
      return new DOMF.Feature_child(node, this.param);
    }

    public String getOpposite() {
      return null;
    }

    public String getName() {
      return "child";
    }

    public boolean isDefault() {
      return false;
    }

    public boolean isDirect() {
      return true;
    }

}

}
