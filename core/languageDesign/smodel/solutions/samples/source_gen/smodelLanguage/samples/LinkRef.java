package smodelLanguage.samples;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.structure.behavior.LinkDeclaration_Behavior;

public class LinkRef {

  public void test1() {
    SNode link = SLinkOperations.findLinkDeclaration("jetbrains.mps.baseLanguage.structure.DotExpression", "operation");
    boolean singular = LinkDeclaration_Behavior.call_isSingular_1213877254557(link);
  }

}
