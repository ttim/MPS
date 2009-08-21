package jetbrains.mps.xml.deprecated.textGen;

/*Generated by MPS */

import jetbrains.mps.textGen.SNodeTextGen;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.textGen.TextGenManager;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;

public class Document_TextGen extends SNodeTextGen {
  public void doGenerateText(SNode node) {
    if ((SLinkOperations.getTarget(node, "doctype", true) != null)) {
      TextGenManager.instance().appendNodeText(this.getContext(), this.getBuffer(), SLinkOperations.getTarget(node, "doctype", true), this.getSNode());
      this.appendNewLine();
    }
    TextGenManager.instance().appendNodeText(this.getContext(), this.getBuffer(), SLinkOperations.getTarget(node, "rootElement", true), this.getSNode());
  }

  public String getExtension(SNode node) {
    return (SPropertyOperations.getString(node, "extension") == null ?
      "xml" :
      SPropertyOperations.getString(node, "extension")
    );
  }
}
