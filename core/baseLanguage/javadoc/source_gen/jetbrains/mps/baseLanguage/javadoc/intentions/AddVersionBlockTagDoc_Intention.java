package jetbrains.mps.baseLanguage.javadoc.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.BaseIntention;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;

public class AddVersionBlockTagDoc_Intention extends BaseIntention {
  public AddVersionBlockTagDoc_Intention() {
  }

  public String getConcept() {
    return "jetbrains.mps.baseLanguage.javadoc.structure.BaseDocComment";
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
    return "Add @version tag";
  }

  public boolean isApplicable(final SNode node, final EditorContext editorContext) {
    if (!(this.isApplicableToNode(node, editorContext))) {
      return false;
    }
    return true;
  }

  public boolean isApplicableToNode(final SNode node, final EditorContext editorContext) {
    return ListSequence.fromList(SLinkOperations.getTargets(node, "version", true)).isEmpty();
  }

  public void execute(final SNode node, final EditorContext editorContext) {
    SLinkOperations.addNewChild(node, "version", "jetbrains.mps.baseLanguage.javadoc.structure.VersionBlockDocTag");
  }

  public String getLocationString() {
    return "jetbrains.mps.baseLanguage.javadoc.intentions";
  }
}
