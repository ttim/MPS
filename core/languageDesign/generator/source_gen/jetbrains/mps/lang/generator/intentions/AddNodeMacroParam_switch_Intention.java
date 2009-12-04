package jetbrains.mps.lang.generator.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.BaseIntention;
import jetbrains.mps.intentions.Intention;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.lang.core.behavior.BaseConcept_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.Generator;
import jetbrains.mps.lang.generator.editor.QueriesUtil;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import java.util.List;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;

public class AddNodeMacroParam_switch_Intention extends BaseIntention implements Intention {
  private SNode myParameter;

  public AddNodeMacroParam_switch_Intention() {
  }

  public String getConcept() {
    return "jetbrains.mps.lang.core.structure.BaseConcept";
  }

  public boolean isParameterized() {
    return true;
  }

  public boolean isErrorIntention() {
    return false;
  }

  public boolean isAvailableInChildNodes() {
    return false;
  }

  public String getDescription(final SNode node, final EditorContext editorContext) {
    return "Add Node Macro Switch: " + BaseConcept_Behavior.call_getPresentation_1213877396640(this.myParameter);
  }

  public boolean isApplicable(final SNode node, final EditorContext editorContext) {
    if (!(this.isApplicableToNode(node, editorContext))) {
      return false;
    }
    return true;
  }

  public boolean isApplicableToNode(final SNode node, final EditorContext editorContext) {
    if (!(SNodeOperations.getModel(node).getModelDescriptor().getModule() instanceof Generator)) {
      return false;
    }
    return QueriesUtil.isNodeMacroApplicable(node);
  }

  public void execute(final SNode node, final EditorContext editorContext) {
    SNode nodeMacro = QueriesUtil.addNodeMacro(node);
    SNode switchMacro = SConceptOperations.createNewNode("jetbrains.mps.lang.generator.structure.SwitchMacro", null);
    SNodeOperations.replaceWithAnother(nodeMacro, switchMacro);
    SLinkOperations.setTarget(switchMacro, "templateSwitch", this.myParameter, false);
    // set caret 
    editorContext.selectAndSetCaret(switchMacro, 1);
  }

  public String getLocationString() {
    return "jetbrains.mps.lang.generator.intentions";
  }

  private static List<SNode> parameter(final SNode node, final EditorContext editorContext) {
    return SModelOperations.getRoots(SNodeOperations.getModel(node), "jetbrains.mps.lang.generator.structure.TemplateSwitch");
  }

  public static List<Intention> instances(final SNode node, final EditorContext editorContext) {
    List<Intention> list = ListSequence.fromList(new ArrayList<Intention>());
    List<SNode> paramList = parameter(node, editorContext);
    if (paramList != null) {
      for (SNode param : paramList) {
        AddNodeMacroParam_switch_Intention intention = new AddNodeMacroParam_switch_Intention();
        intention.myParameter = param;
        ListSequence.fromList(list).addElement(intention);
      }
    }
    return list;
  }
}
