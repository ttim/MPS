package jetbrains.mps.core.xml.textGen;

/*Generated by MPS */

import jetbrains.mps.textGen.SNodeTextGen;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.core.xml.behavior.XmlPart_Behavior;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.textGen.TextGenManager;

public class XmlComment_TextGen extends SNodeTextGen {
  public void doGenerateText(SNode node) {
    SNode left = SNodeOperations.getPrevSibling(node);
    if (SNodeOperations.isInstanceOf(left, "jetbrains.mps.core.xml.structure.XmlPart") && XmlPart_Behavior.call_hasNewLineAfter_2133624044437631594(SNodeOperations.cast(left, "jetbrains.mps.core.xml.structure.XmlPart"))) {
      this.appendNewLine();
      this.indentBuffer();
    }
    this.append("<!--");
    if (ListSequence.fromList(SLinkOperations.getTargets(node, "lines", true)).isNotEmpty()) {
      for (SNode item : SLinkOperations.getTargets(node, "lines", true)) {
        TextGenManager.instance().appendNodeText(this.getContext(), this.getBuffer(), item, this.getSNode());
      }
    }
    this.append("-->");
  }
}
