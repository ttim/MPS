package smodelLanguage.samples;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;

public class ConceptProperties {

  public void stringConceptProperty(SNode node) {
    boolean hasAlias = SConceptPropertyOperations.getString(node, "alias") != null;
    String alias = SConceptPropertyOperations.getString(node, "alias");
    String text = "alias is " + SConceptPropertyOperations.getString(node, "alias");
    int length = SConceptPropertyOperations.getString(node, "alias").length();
    SConceptPropertyOperations.setString(node, "alias", "foo");
  }

  public void booleanConceptProperty(SNode node) {
    boolean isAbstract = false;
    if (SConceptPropertyOperations.getBoolean(node, "abstract")) {
      isAbstract = true;
    }
    boolean isAbstract2 = SConceptPropertyOperations.getBoolean(node, "abstract");
    SConceptPropertyOperations.setBoolean(node, "abstract", true);
  }

  public void m1(SNode node) {
    SConceptPropertyOperations.getString(SLinkOperations.getTarget(node, "baseMethodDeclaration", false), "alias");
  }

}
