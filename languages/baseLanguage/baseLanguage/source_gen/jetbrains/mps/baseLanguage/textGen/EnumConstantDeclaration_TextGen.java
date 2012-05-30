package jetbrains.mps.baseLanguage.textGen;

/*Generated by MPS */

import jetbrains.mps.textGen.SNodeTextGen;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.textGen.TextGenManager;

public class EnumConstantDeclaration_TextGen extends SNodeTextGen {
  public void doGenerateText(SNode node) {
    this.appendNewLine();
    if (StringUtils.isEmpty(SPropertyOperations.getString(node, "name"))) {
      this.foundError("enum constant without name");
      this.appendWithIndent("???");
    } else {
      this.appendWithIndent(SPropertyOperations.getString(node, "name"));
    }
    this.append("(");
    if (ListSequence.fromList(SLinkOperations.getTargets(node, "actualArgument", true)).isNotEmpty()) {
      for (SNode item : SLinkOperations.getTargets(node, "actualArgument", true)) {
        TextGenManager.instance().appendNodeText(this.getContext(), this.getBuffer(), item, this.getSNode());
        if (item != ListSequence.fromList(SLinkOperations.getTargets(node, "actualArgument", true)).last()) {
          this.append(", ");
        }
      }
    }
    this.append(")");
    if (ListSequence.fromList(SLinkOperations.getTargets(node, "method", true)).isNotEmpty()) {
      this.append(" {");
      this.appendNewLine();
      this.increaseDepth();
      for (SNode imd : SLinkOperations.getTargets(node, "method", true)) {
        TextGenManager.instance().appendNodeText(this.getContext(), this.getBuffer(), imd, this.getSNode());
      }
      this.decreaseDepth();
      this.appendNewLine();
      this.appendWithIndent("}");
    }
  }
}
