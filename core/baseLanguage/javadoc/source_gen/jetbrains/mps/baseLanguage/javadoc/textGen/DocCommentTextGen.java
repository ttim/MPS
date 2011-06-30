package jetbrains.mps.baseLanguage.javadoc.textGen;

/*Generated by MPS */

import jetbrains.mps.textGen.SNodeTextGen;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.textGen.TextGenManager;
import jetbrains.mps.baseLanguage.javadoc.behavior.BaseDocComment_Behavior;

public abstract class DocCommentTextGen {
  public static void javadocIndent(final SNodeTextGen textGen) {
    textGen.indentBuffer();
    textGen.append(" * ");
  }

  public static void docCommentStart(SNode node, final SNodeTextGen textGen) {
    textGen.appendNewLine();
    textGen.indentBuffer();
    textGen.append("/**");

    textGen.appendNewLine();
    DocCommentTextGen.javadocIndent(textGen);
    if (ListSequence.fromList(SLinkOperations.getTargets(node, "body", true)).isNotEmpty()) {
      for (SNode item : SLinkOperations.getTargets(node, "body", true)) {
        TextGenManager.instance().appendNodeText(textGen.getContext(), textGen.getBuffer(), item, textGen.getSNode());
      }
    }

    if (!(BaseDocComment_Behavior.call_isTagSectionEmpty_8465538089690623795(node))) {
      textGen.appendNewLine();
      DocCommentTextGen.javadocIndent(textGen);
    }

    if (ListSequence.fromList(SLinkOperations.getTargets(node, "author", true)).isNotEmpty()) {
      for (SNode item : SLinkOperations.getTargets(node, "author", true)) {
        TextGenManager.instance().appendNodeText(textGen.getContext(), textGen.getBuffer(), item, textGen.getSNode());
      }
    }
    if (ListSequence.fromList(SLinkOperations.getTargets(node, "since", true)).isNotEmpty()) {
      for (SNode item : SLinkOperations.getTargets(node, "since", true)) {
        TextGenManager.instance().appendNodeText(textGen.getContext(), textGen.getBuffer(), item, textGen.getSNode());
      }
    }
    if (ListSequence.fromList(SLinkOperations.getTargets(node, "version", true)).isNotEmpty()) {
      for (SNode item : SLinkOperations.getTargets(node, "version", true)) {
        TextGenManager.instance().appendNodeText(textGen.getContext(), textGen.getBuffer(), item, textGen.getSNode());
      }
    }
    if (ListSequence.fromList(SLinkOperations.getTargets(node, "see", true)).isNotEmpty()) {
      for (SNode item : SLinkOperations.getTargets(node, "see", true)) {
        TextGenManager.instance().appendNodeText(textGen.getContext(), textGen.getBuffer(), item, textGen.getSNode());
      }
    }
  }

  public static void docCommentEnd(SNode node, final SNodeTextGen textGen) {
    textGen.appendNewLine();
    textGen.indentBuffer();
    textGen.append(" */");
  }
}
