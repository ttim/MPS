package jetbrains.mps.lang.refactoring.editor;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.editor.runtime.StyledTextPrinter;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.core.behavior.BaseConcept_Behavior;

public class RefExpressionParamUtil {
  public RefExpressionParamUtil() {
  }

  public static void xxx(SNode node, SNode ref, StyledTextPrinter styledText, boolean showParameters) {
    styledText.append(SConceptPropertyOperations.getString(node, "alias")).append("<").append(SPropertyOperations.getString(ref, "name")).append(">(");
    String target = "no_target";
    boolean isList = SPropertyOperations.getBoolean(SLinkOperations.getTarget(ref, "target", true), "allowMultiple");
    if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(ref, "target", true), "jetbrains.mps.lang.refactoring.structure.NodeTarget")) {
      target = ((isList ?
        "nlist" :
        "node"
      )) + "<" + SPropertyOperations.getString(SLinkOperations.getTarget(SNodeOperations.cast(SLinkOperations.getTarget(ref, "target", true), "jetbrains.mps.lang.refactoring.structure.NodeTarget"), "concept", false), "name") + ">";
    } else if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(ref, "target", true), "jetbrains.mps.lang.refactoring.structure.ModelTarget")) {
      target = (isList ?
        "list<model>" :
        "model"
      );
    } else if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(ref, "target", true), "jetbrains.mps.lang.refactoring.structure.ModuleTarget")) {
      target = (isList ?
        "list<IModule>" :
        "IModule"
      );
    }
    styledText.append(target).append(" target");
    if (showParameters) {
      styledText.append(" : MPSProject project");
      for (SNode param : ListSequence.fromList(SLinkOperations.getTargets(ref, "parameter", true))) {
        styledText.append(", ").append(BaseConcept_Behavior.call_getPresentation_1213877396640(SLinkOperations.getTarget(param, "type", true))).append(" ").append(SPropertyOperations.getString(param, "name"));
      }
    }
    styledText.append(")");
  }
}
