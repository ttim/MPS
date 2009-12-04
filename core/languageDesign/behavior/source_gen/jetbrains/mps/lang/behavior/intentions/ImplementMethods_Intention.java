package jetbrains.mps.lang.behavior.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.BaseIntention;
import jetbrains.mps.intentions.Intention;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.structure.behavior.AbstractConceptDeclaration_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.project.GlobalScope;
import javax.swing.SwingUtilities;
import jetbrains.mps.baseLanguage.plugin.uiActions.StratergyAddMethodDialog;
import jetbrains.mps.baseLanguage.plugin.uiActions.strategies.AddConceptMethodStrategy;
import jetbrains.mps.ide.actions.MethodsToImplementStrategy;
import jetbrains.mps.ide.actions.ImplementMethodStrategy;

public class ImplementMethods_Intention extends BaseIntention implements Intention {
  public ImplementMethods_Intention() {
  }

  public String getConcept() {
    return "jetbrains.mps.lang.behavior.structure.ConceptBehavior";
  }

  public boolean isParameterized() {
    return false;
  }

  public boolean isErrorIntention() {
    return false;
  }

  public boolean isAvailableInChildNodes() {
    return false;
  }

  public String getDescription(final SNode node, final EditorContext editorContext) {
    return "Implement Methods";
  }

  public boolean isApplicable(final SNode node, final EditorContext editorContext) {
    if (!(this.isApplicableToNode(node, editorContext))) {
      return false;
    }
    return true;
  }

  public boolean isApplicableToNode(final SNode node, final EditorContext editorContext) {
    return ListSequence.fromList(AbstractConceptDeclaration_Behavior.call_getNotImplementedConceptMethods_1213877394339(SLinkOperations.getTarget(node, "concept", false), GlobalScope.getInstance())).isNotEmpty();
  }

  public void execute(final SNode node, final EditorContext editorContext) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new StratergyAddMethodDialog(editorContext, editorContext.getOperationContext().getMainFrame(), new AddConceptMethodStrategy(node), new MethodsToImplementStrategy(), new ImplementMethodStrategy()).showDialog();
      }
    });
  }

  public String getLocationString() {
    return "jetbrains.mps.lang.behavior.intentions";
  }
}
