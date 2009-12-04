package jetbrains.mps.baseLanguage.textGen;

/*Generated by MPS */

import jetbrains.mps.textGen.SNodeTextGen;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.textGen.TextGenManager;

public class AnnotationInstance_TextGen extends SNodeTextGen {
  public void doGenerateText(SNode node) {
    boolean oneLine = SNodeOperations.isInstanceOf(SNodeOperations.getParent(node), "jetbrains.mps.baseLanguage.structure.ParameterDeclaration") || SNodeOperations.isInstanceOf(SNodeOperations.getParent(node), "jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration");
    if (oneLine) {
      this.append("@");
    } else {
      this.appendWithIndent("@");
    }
    BaseLanguageTextGen.importPart(SLinkOperations.getTarget(node, "annotation", false), this);
    this.append(this.getReferentPresentation(SNodeOperations.getReference(node, SLinkOperations.findLinkDeclaration("jetbrains.mps.baseLanguage.structure.AnnotationInstance", "annotation"))));
    if (ListSequence.fromList(SLinkOperations.getTargets(node, "value", true)).isNotEmpty()) {
      this.append("(");
      if (ListSequence.fromList(SLinkOperations.getTargets(node, "value", true)).isNotEmpty()) {
        for (SNode item : SLinkOperations.getTargets(node, "value", true)) {
          TextGenManager.instance().appendNodeText(this.getContext(), this.getBuffer(), item, this.getSNode());
          if (item != ListSequence.fromList(SLinkOperations.getTargets(node, "value", true)).last()) {
            this.append(", ");
          }
        }
      }
      this.append(")");
    }
    if (oneLine) {
      this.append(" ");
    } else {
      this.appendNewLine();
    }
  }
}
