package jetbrains.mps.ide.typesystem.trace;

/*Generated by MPS */

import jetbrains.mps.ide.ui.MPSTreeNode;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.newTypesystem.state.State;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.ide.icons.IdeIcons;
import jetbrains.mps.nodeEditor.GoToTypeErrorRuleUtil;
import jetbrains.mps.util.Pair;
import jetbrains.mps.openapi.navigation.NavigationSupport;
import java.util.List;

public class TypeSystemStateTreeNode extends MPSTreeNode {
  protected SNode myNode;
  protected String myRuleModel;
  protected String myRuleId;
  protected State myState;

  public TypeSystemStateTreeNode(IOperationContext operationContext) {
    super(operationContext);
  }

  public TypeSystemStateTreeNode(String presentation, IOperationContext operationContext) {
    super(presentation, operationContext);
    setNodeIdentifier(userObject.toString());
    setIcon(IdeIcons.DEFAULT_ICON);
    this.setAutoExpandable(true);
  }

  public void goToRule() {
    if (myRuleId != null && myRuleModel != null) {
      GoToTypeErrorRuleUtil.goToRuleById(getOperationContext(), new Pair<String, String>(myRuleModel, myRuleId));
    }
  }

  public void goToNode() {
    if (myNode != null && myNode.isRegistered()) {
      NavigationSupport.getInstance().openNode(getOperationContext(), myNode, true, true);
    }
  }

  public List<SNode> getVariables() {
    return null;
  }

  public String getRuleModel() {
    return myRuleModel;
  }

  public String getRuleId() {
    return myRuleId;
  }

  public SNode getSource() {
    return myNode;
  }
}
