package jetbrains.mps.baseLanguage.javadoc.textGen;

/*Generated by MPS */

import jetbrains.mps.textGen.SNodeTextGen;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.textGen.TextGenManager;
import jetbrains.mps.baseLanguage.javadoc.behavior.BaseDocComment_Behavior;

public class FieldDocComment_TextGen extends SNodeTextGen {
  public void doGenerateText(SNode node) {
    this.appendNewLine();
    this.indentBuffer();
    this.append("/**");
    this.increaseDepth();
    this.appendNewLine();
    this.indentBuffer();
    if (ListSequence.fromList(SLinkOperations.getTargets(node, "body", true)).isNotEmpty()) {
      for (SNode item : SLinkOperations.getTargets(node, "body", true)) {
        TextGenManager.instance().appendNodeText(this.getContext(), this.getBuffer(), item, this.getSNode());
      }
    }

    if (!(BaseDocComment_Behavior.call_isTagSectionEmpty_8465538089690623795(node))) {
      this.appendNewLine();
    }

    if (ListSequence.fromList(SLinkOperations.getTargets(node, "author", true)).isNotEmpty()) {
      for (SNode item : SLinkOperations.getTargets(node, "author", true)) {
        TextGenManager.instance().appendNodeText(this.getContext(), this.getBuffer(), item, this.getSNode());
      }
    }
    if (ListSequence.fromList(SLinkOperations.getTargets(node, "since", true)).isNotEmpty()) {
      for (SNode item : SLinkOperations.getTargets(node, "since", true)) {
        TextGenManager.instance().appendNodeText(this.getContext(), this.getBuffer(), item, this.getSNode());
      }
    }
    if (ListSequence.fromList(SLinkOperations.getTargets(node, "version", true)).isNotEmpty()) {
      for (SNode item : SLinkOperations.getTargets(node, "version", true)) {
        TextGenManager.instance().appendNodeText(this.getContext(), this.getBuffer(), item, this.getSNode());
      }
    }
    if (ListSequence.fromList(SLinkOperations.getTargets(node, "see", true)).isNotEmpty()) {
      for (SNode item : SLinkOperations.getTargets(node, "see", true)) {
        TextGenManager.instance().appendNodeText(this.getContext(), this.getBuffer(), item, this.getSNode());
      }
    }
    this.decreaseDepth();
    this.appendNewLine();
    this.indentBuffer();
    this.append(" */");
  }
}
