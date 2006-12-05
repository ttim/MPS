package jetbrains.mps.ide.ui.smodel;

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.ide.action.ActionManager;
import jetbrains.mps.ide.action.ActionContext;
import jetbrains.mps.ide.icons.IconManager;
import jetbrains.mps.ide.IDEProjectFrame;
import jetbrains.mps.ide.AbstractProjectFrame;
import jetbrains.mps.ide.projectPane.ProjectPane;
import jetbrains.mps.ide.ui.MPSTreeNodeEx;
import jetbrains.mps.ide.ui.TextTreeNode;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.helgins.lambdaTypes.PresentationUtil;
import jetbrains.mps.helgins.evaluator.uiActions.PresentationManager;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Igoor
 * Date: Aug 25, 2005
 * Time: 5:20:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class SNodeTreeNode extends MPSTreeNodeEx {
  protected boolean myInitialized = false;
  private SNode myNode;
  private String myRole;

  public SNodeTreeNode(SNode node, IOperationContext operationContext) {
    this(node, null, operationContext);
  }

  public SNodeTreeNode(SNode node, String role, IOperationContext operationContext) {
    super(operationContext);
    myNode = node;
    myRole = role;
  }

  public JPopupMenu getPopupMenu() {
    JPopupMenu result = new JPopupMenu();
    ProjectPane pane = getOperationContext().getComponent(ProjectPane.class);
    if (pane == null) return null;
    List<SNode> selection = pane.getNormalizedSelectedNodes();
    ActionManager.instance().getGroup(ProjectPane.PROJECT_PANE_NODE_ACTIONS).add(result, new ActionContext(getOperationContext(), getSNode(), selection));
    return result;
  }

  public Object getUserObject() {
    return myNode;
  }

  public int getToggleClickCount() {
    return -1;
  }

  public SNode getSNode() {
    return myNode;
  }

  public String getNodeIdentifier() {
    if (getSNode() == null) return "null";
    return getSNode().getId();
  }

  public void update() {
    this.removeAllChildren();
    myInitialized = false;
  }

  public boolean isInitialized() {
    return myInitialized;
  }

  public void init() {
    this.removeAllChildren();
    SNode n = getSNode();
    if (n == null) return;

    if (showPropertiesAndReferences()) {
      add(new PropertiesTreeNode(getOperationContext(), n));
      add(new ReferencesTreeNode(getOperationContext(), n));
    }
    
    for (SNode childNode : n.getChildren()) {
      add(new SNodeTreeNode(childNode, childNode.getRole_(), getOperationContext()));
    }

    IDEProjectFrame projectFrame = (IDEProjectFrame) getOperationContext().getComponent(AbstractProjectFrame.class);
    DefaultTreeModel treeModel = (DefaultTreeModel)projectFrame.getProjectPane().getTree().getModel();
    treeModel.nodeStructureChanged(this);
    myInitialized = true;
  }

  private boolean showPropertiesAndReferences() {
    return getOperationContext().getComponent(ProjectPane.class).isShowPropertiesAndReferences();
  }

  public void doubleClick() {
    IDEProjectFrame projectFrame = (IDEProjectFrame) getOperationContext().getComponent(AbstractProjectFrame.class);
    projectFrame.openNode(myNode, getOperationContext());
  }

  public Icon getIcon(boolean expanded) {
    if (myNode != null) {
      return IconManager.getIconFor(myNode);
    } else {
      return super.getIcon(expanded);
    }
  }

  public String toString() {
    StringBuffer output = new StringBuffer();

    if (myRole != null) {
      output.append(myRole).append(" : ");
    }

    if (getSNode() != null) {
      output.append(getSNode().toString());
    }

    return output.toString();
  }
}
