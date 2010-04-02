package jetbrains.mps.baseLanguage.textGen;

/*Generated by MPS */

import jetbrains.mps.textGen.SNodeTextGen;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.textGen.TextGenManager;

public class DoWhileStatement_TextGen extends SNodeTextGen {
  public void doGenerateText(SNode node) {
    if (SLinkOperations.getTarget(node, "loopLabel", true) != null) {
      this.appendNewLine();
      this.append(SPropertyOperations.getString(SLinkOperations.getTarget(node, "loopLabel", true), "name"));
      this.append(":");
    } else if (SPropertyOperations.getString(node, "label") != null) {
      this.appendNewLine();
      this.append(SPropertyOperations.getString(node, "label"));
      this.append(":");
    }
    this.appendNewLine();
    this.indentBuffer();
    this.append("do {");
    this.increaseDepth();
    TextGenManager.instance().appendNodeText(this.getContext(), this.getBuffer(), SLinkOperations.getTarget(node, "body", true), this.getSNode());
    this.decreaseDepth();
    this.appendNewLine();
    this.appendWithIndent("} while (");
    TextGenManager.instance().appendNodeText(this.getContext(), this.getBuffer(), SLinkOperations.getTarget(node, "condition", true), this.getSNode());
    this.append(");");
  }
}
