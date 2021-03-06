package featuresDemo;

/*Generated by MPS */

import java.io.InputStream;
import java.io.ByteArrayInputStream;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Node;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.ypath.runtime.TreeTraversalFactory;
import jetbrains.mps.ypath.runtime.CompositeFilter;

public class DomDemo {
  public static void main(String[] args) {
    String INPUT = "<doc> <a><b><foobar/><findme baz=\"fooblin\"/></b><c></c></a> </doc>";
    try {
      InputStream is = new ByteArrayInputStream(INPUT.getBytes());
      Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(is);
      for (Node foo : Sequence.fromIterable(TreeTraversalFactory.Traverse(TreeTraversalFactory.Filter(TreeTraversalFactory.Traverse(new DOM_NG().startTraversal(doc), TreeTraversalFactory.Axis("DESCENDANTS"), "nodes"), new CompositeFilter<Node>(DOM_NG.ELEMENT_NodeKindTrigger.getInstance(), DOM_NG.ELEMENT_tag_Property.getMatcher("findme"))), TreeTraversalFactory.Axis("SELF_ANCESTORS"), "nodes"))) {
        System.out.println(((Object) foo).toString());
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
