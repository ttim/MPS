package treepathFeatures;

/*Generated by MPS */

import ypath.util.TreePath;
import org.w3c.dom.Node;
import java.util.AbstractList;
import java.util.AbstractCollection;
import jetbrains.mps.baseLanguage.ext.collections.internal.SequenceWithSupplier;
import java.util.Iterator;
import ypath.util.IFeatureDescriptor;
import java.util.Collection;

public class TryFeatures extends TreePath<Node> {

  public  TryFeatures() {
    this.registerFeature(new TryFeatures.Desc_Feature_nodes());
    this.registerFeature(new TryFeatures.Desc_Feature_attributes());
  }

  public Node parent(Node node) {
    return TryFeatures.Parent.parent(node);
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
  private static class Feature_nodes extends AbstractList<Node> {

    private Node thisNode;

    public  Feature_nodes(Node thisNode) {
      this.thisNode = thisNode;
    }

    public Node get(int idx) {
      if(idx < 0 || idx >= this.size()) {
        throw new IndexOutOfBoundsException();
      }
      return this.thisNode.getChildNodes().item(idx);
    }
    public int size() {
      return this.thisNode.getChildNodes().getLength();
    }
    public Node set(int idx, Node value) {
      if(idx < 0 || idx >= this.size()) {
        throw new IndexOutOfBoundsException();
      }
      Node __oldValue__ = this.get(idx);
      this.thisNode.replaceChild(this.thisNode.getChildNodes().item(idx), value);
      return __oldValue__;
    }
    public void add(int idx, Node value) {
      if(idx < 0 || idx > this.size()) {
        throw new IndexOutOfBoundsException();
      }
      if(idx < this.thisNode.getChildNodes().getLength()) {
        this.thisNode.insertBefore(this.thisNode.getChildNodes().item(idx), value);
      } else
      {
        this.thisNode.appendChild(value);
      }
    }
    public Node remove(int idx) {
      if(idx < 0 || idx >= this.size()) {
        throw new IndexOutOfBoundsException();
      }
      Node __oldValue__ = this.get(idx);
      this.thisNode.removeChild(this.thisNode.getChildNodes().item(idx));
      return __oldValue__;
    }
}
  private static class Feature_attributes extends AbstractCollection<Node> {

    private Node thisNode;

    public  Feature_attributes(Node thisNode) {
      this.thisNode = thisNode;
    }

    public Iterable<Node> sequence() {
      final zClosureContext _zClosureContext = new zClosureContext();
      _zClosureContext._node = this.thisNode;
      return new SequenceWithSupplier<Node>(new zValueSupplier(null, _zClosureContext));
    }
    public Iterator<Node> iterator() {
      return this.sequence().iterator();
    }
    public int size() {
      return this.thisNode.getAttributes().getLength();
    }
    public boolean add(Node value) {
      boolean __alreadyContains__ = this.contains(value);
      this.thisNode.getAttributes().setNamedItem(value);
      return __alreadyContains__;
    }
}
  public static class Desc_Feature_nodes implements IFeatureDescriptor<Node> {

    public  Desc_Feature_nodes() {
    }

    public Collection<Node> getFeature(Node node) {
      return new TryFeatures.Feature_nodes(node);
    }
    public String getName() {
      return "nodes";
    }
    public IFeatureDescriptor.Type getType() {
      return IFeatureDescriptor.Type.LIST;
    }
    public boolean isDefault() {
      return false;
    }
}
  public static class Desc_Feature_attributes implements IFeatureDescriptor<Node> {

    public  Desc_Feature_attributes() {
    }

    public Collection<Node> getFeature(Node node) {
      return new TryFeatures.Feature_attributes(node);
    }
    public String getName() {
      return "attributes";
    }
    public IFeatureDescriptor.Type getType() {
      return IFeatureDescriptor.Type.SEQUENCE;
    }
    public boolean isDefault() {
      return false;
    }
}

}
