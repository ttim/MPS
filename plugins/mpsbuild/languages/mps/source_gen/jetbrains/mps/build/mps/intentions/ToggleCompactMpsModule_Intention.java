package jetbrains.mps.build.mps.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.BaseIntention;
import jetbrains.mps.intentions.Intention;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;

public class ToggleCompactMpsModule_Intention extends BaseIntention implements Intention {
  public ToggleCompactMpsModule_Intention() {
  }

  public String getConcept() {
    return "jetbrains.mps.build.mps.structure.BuildMps_AbstractModule";
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
    return (SPropertyOperations.getBoolean(node, "compact") ?
      "Unfold " + SPropertyOperations.getString(node, "name") :
      "Fold " + SPropertyOperations.getString(node, "name")
    );
  }

  public void execute(final SNode node, final EditorContext editorContext) {
    SPropertyOperations.set(node, "compact", "" + !(SPropertyOperations.getBoolean(node, "compact")));
  }

  public String getLocationString() {
    return "jetbrains.mps.build.mps.intentions";
  }
}
