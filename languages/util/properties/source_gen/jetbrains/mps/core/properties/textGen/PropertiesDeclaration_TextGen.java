package jetbrains.mps.core.properties.textGen;

/*Generated by MPS */

import jetbrains.mps.textGen.SNodeTextGen;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.core.properties.constraints.PropEscapeUtil;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;

public class PropertiesDeclaration_TextGen extends SNodeTextGen {
  public void doGenerateText(SNode node) {
    this.append(PropEscapeUtil.escapeKey(SPropertyOperations.getString(node, "name")));
    this.append("=");
    this.append(PropEscapeUtil.escapeValue(SPropertyOperations.getString(node, "value")));
    this.appendNewLine();
  }
}
