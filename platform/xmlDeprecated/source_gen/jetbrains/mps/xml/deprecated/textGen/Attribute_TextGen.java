package jetbrains.mps.xml.deprecated.textGen;

/*Generated by MPS */

import jetbrains.mps.textGen.SNodeTextGen;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.util.JDOMUtil;

public class Attribute_TextGen extends SNodeTextGen {
  public void doGenerateText(SNode node) {
    String value = (SPropertyOperations.getString(node, "value") == null ?
      "" :
      JDOMUtil.createOutputter().escapeElementEntities(SPropertyOperations.getString(node, "value"))
    );
    this.append(SPropertyOperations.getString(node, "name"));
    this.append("=\"");
    this.append(value);
    this.append("\"");
  }
}
