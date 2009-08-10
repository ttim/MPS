package jetbrains.mps.baseLanguage.textGen;

/*Generated by MPS */

import jetbrains.mps.textGen.SNodeTextGen;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.generator.JavaNameUtil;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.textGen.TextGenManager;

public class Annotation_TextGen extends SNodeTextGen {

  public void doGenerateText(SNode node) {
    BaseLanguageTextGen.fileHeader(node, this);
    BaseLanguageTextGen.visibility(SLinkOperations.getTarget(node, "visibility", true), this);
    if (!(node.isRoot())) {
      this.append("static ");
    }
    this.appendWithIndent("@interface ");
    this.append(JavaNameUtil.shortName(SPropertyOperations.getString(node, "name")));
    this.append(" {");
    this.increaseDepth();
    if (ListSequence.fromList(SLinkOperations.getTargets(node, "method", true)).isNotEmpty()) {
      this.appendNewLine();
      if (ListSequence.fromList(SLinkOperations.getTargets(node, "method", true)).isNotEmpty()) {
        for(SNode item : SLinkOperations.getTargets(node, "method", true)) {
          TextGenManager.instance().appendNodeText(this.getContext(), this.getBuffer(), item, this.getSNode());
        }
      }
    }
    this.decreaseDepth();
    this.decreaseDepth();
    this.appendNewLine();
    this.append("}");
    this.appendNewLine();
  }

}
