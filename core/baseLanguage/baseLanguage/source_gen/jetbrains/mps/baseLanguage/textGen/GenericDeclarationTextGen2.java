package jetbrains.mps.baseLanguage.textGen;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.textGen.SNodeTextGen;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.textGen.TextGenManager;

public abstract class GenericDeclarationTextGen2 extends BaseLanguageTextGen {
  public static void typeDeclarations(SNode generic, final SNodeTextGen textGen) {
    if (ListSequence.fromList(SLinkOperations.getTargets(generic, "typeVariableDeclaration", true)).isNotEmpty()) {
      textGen.append("<");
      if (ListSequence.fromList(SLinkOperations.getTargets(generic, "typeVariableDeclaration", true)).isNotEmpty()) {
        for (SNode item : SLinkOperations.getTargets(generic, "typeVariableDeclaration", true)) {
          TextGenManager.instance().appendNodeText(textGen.getContext(), textGen.getBuffer(), item, textGen.getSNode());
          if (item != ListSequence.fromList(SLinkOperations.getTargets(generic, "typeVariableDeclaration", true)).last()) {
            textGen.append(", ");
          }
        }
      }
      textGen.append(">");
    }
  }
}
