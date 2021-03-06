package jetbrains.mps.core.xml.textGen;

/*Generated by MPS */

import jetbrains.mps.textGen.SNodeTextGen;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.core.xml.behavior.XmlPart_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;

public class XmlEntityRef_TextGen extends SNodeTextGen {
  public void doGenerateText(SNode node) {
    SNode left = SNodeOperations.getPrevSibling(node);
    if (SNodeOperations.isInstanceOf(left, "jetbrains.mps.core.xml.structure.XmlContent") && XmlPart_Behavior.call_hasNewLineAfter_2133624044437631594(SNodeOperations.cast(left, "jetbrains.mps.core.xml.structure.XmlContent"))) {
      this.appendNewLine();
      this.indentBuffer();
    }
    this.append("&");
    this.append(SPropertyOperations.getString(node, "entityName"));
    this.append(";");
  }
}
