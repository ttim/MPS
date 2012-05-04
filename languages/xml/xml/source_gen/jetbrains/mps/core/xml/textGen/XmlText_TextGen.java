package jetbrains.mps.core.xml.textGen;

/*Generated by MPS */

import jetbrains.mps.textGen.SNodeTextGen;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.core.xml.behavior.XmlPart_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;

public class XmlText_TextGen extends SNodeTextGen {
  public void doGenerateText(SNode node) {
    boolean needNewLine = XmlPart_Behavior.call_onNewLine_2133624044437631588(node);
    if (!(needNewLine)) {
      SNode left = SNodeOperations.getPrevSibling(node);
      if (SNodeOperations.isInstanceOf(left, "jetbrains.mps.core.xml.structure.XmlContent")) {
        needNewLine = XmlPart_Behavior.call_hasNewLineAfter_2133624044437631594(SNodeOperations.cast(left, "jetbrains.mps.core.xml.structure.XmlContent"));
      }
    }
    if (needNewLine) {
      this.appendNewLine();
      this.indentBuffer();
    }
    this.append(SPropertyOperations.getString(node, "value"));
  }
}
