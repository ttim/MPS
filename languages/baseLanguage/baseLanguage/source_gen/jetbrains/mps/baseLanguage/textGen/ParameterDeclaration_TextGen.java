package jetbrains.mps.baseLanguage.textGen;

/*Generated by MPS */

import jetbrains.mps.textGen.SNodeTextGen;
import jetbrains.mps.smodel.SNode;

public class ParameterDeclaration_TextGen extends SNodeTextGen {
  public void doGenerateText(SNode node) {
    BaseLanguageTextGen.annotations(node, this);
    BaseLanguageTextGen.variableDeclaration(node, this);
  }
}
