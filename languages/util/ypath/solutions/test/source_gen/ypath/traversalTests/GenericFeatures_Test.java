package ypath.traversalTests;

/*Generated by MPS */

import junit.framework.TestCase;
import org.w3c.dom.Document;
import jetbrains.mps.ypath.runtime.ITreeTraversal;
import org.w3c.dom.Node;
import jetbrains.mps.ypath.runtime.TreeTraversalFactory;
import junit.framework.Assert;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import jetbrains.mps.internal.collections.runtime.Sequence;

public class GenericFeatures_Test extends TestCase {
  private static String INPUT = "<root><a><foo/><bar><foo/></bar><baz><foo/></baz></a></root>";

  public void test_generic() throws Exception {
    Document doc = this.parse(INPUT);
    ITreeTraversal<Node> foo = TreeTraversalFactory.Traverse(TreeTraversalFactory.Traverse(new DOMF().startTraversal(doc), TreeTraversalFactory.Axis("CHILDREN"), "elements"), TreeTraversalFactory.Axis("DESCENDANTS"), DOMF.child("foo"));
    Assert.assertEquals("foo, foo, foo", this.toString(foo));
  }

  public Document parse(String xml) throws Exception {
    InputStream is = new ByteArrayInputStream(xml.getBytes());
    Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(is);
    return doc;
  }

  public String toString(Iterable<Node> nodes) {
    StringBuilder sb = new StringBuilder();
    String sep = "";
    for (Node n : Sequence.fromIterable(nodes)) {
      sb.append(sep).append(n.getNodeName());
      sep = ", ";
    }
    return sb.toString();
  }
}
