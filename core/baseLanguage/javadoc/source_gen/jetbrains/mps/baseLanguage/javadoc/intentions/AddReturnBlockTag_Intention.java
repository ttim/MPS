package jetbrains.mps.baseLanguage.javadoc.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.BaseIntention;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;

public class AddReturnBlockTag_Intention extends BaseIntention {
  public AddReturnBlockTag_Intention() {
  }

  public String getConcept() {
    return "jetbrains.mps.baseLanguage.javadoc.structure.MethodDocComment";
  }

  public boolean isParameterized() {
    return false;
  }

  public boolean isErrorIntention() {
    return false;
  }

  public boolean isAvailableInChildNodes() {
    return true;
  }

  public String getDescription(final SNode node, final EditorContext editorContext) {
    return "Add @return tag";
  }

  public boolean isApplicable(final SNode node, final EditorContext editorContext) {
    if (!(this.isApplicableToNode(node, editorContext))) {
      return false;
    }
    return true;
  }

  public boolean isApplicableToNode(final SNode node, final EditorContext editorContext) {
    SNode returnType = SLinkOperations.getTarget(SNodeOperations.getAncestor(node, "jetbrains.mps.baseLanguage.structure.BaseMethodDeclaration", false, false), "returnType", true);
    return (SLinkOperations.getTarget(node, "return", true) == null) && (returnType != null) && !(SNodeOperations.isInstanceOf(returnType, "jetbrains.mps.baseLanguage.structure.VoidType"));
  }

  public void execute(final SNode node, final EditorContext editorContext) {
    SLinkOperations.setTarget(node, "return", SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.javadoc.structure.ReturnBlockDocTag", null), true);
  }

  public String getLocationString() {
    return "jetbrains.mps.baseLanguage.javadoc.intentions";
  }
}
