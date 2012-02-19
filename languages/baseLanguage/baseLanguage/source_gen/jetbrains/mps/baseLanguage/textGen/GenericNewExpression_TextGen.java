package jetbrains.mps.baseLanguage.textGen;

/*Generated by MPS */

import jetbrains.mps.textGen.SNodeTextGen;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.textGen.TextGenManager;

public class GenericNewExpression_TextGen extends SNodeTextGen {
  public void doGenerateText(SNode node) {
    this.append("new ");
    if ((SLinkOperations.getTarget(node, "creator", true) == null)) {
      this.foundError("incomplete new expression");
      this.append("???");
    } else {
      TextGenManager.instance().appendNodeText(this.getContext(), this.getBuffer(), SLinkOperations.getTarget(node, "creator", true), this.getSNode());
    }
  }
}
