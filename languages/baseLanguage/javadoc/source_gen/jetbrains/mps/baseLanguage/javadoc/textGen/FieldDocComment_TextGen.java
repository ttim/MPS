package jetbrains.mps.baseLanguage.javadoc.textGen;

/*Generated by MPS */

import jetbrains.mps.textGen.SNodeTextGen;
import jetbrains.mps.smodel.SNode;

public class FieldDocComment_TextGen extends SNodeTextGen {
  public void doGenerateText(SNode node) {
    DocCommentTextGen.docCommentStart(node, this);

    DocCommentTextGen.docCommentEnd(node, this);
  }
}
