package jetbrains.mps.ide.typesystem.trace;

/*Generated by MPS */

import jetbrains.mps.ide.ui.MPSTree;
import com.intellij.openapi.actionSystem.DataProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.newTypesystem.operation.AbstractOperation;
import jetbrains.mps.newTypesystem.TypeCheckingContextNew;
import jetbrains.mps.smodel.SNode;
import java.util.Set;
import jetbrains.mps.newTypesystem.state.State;
import jetbrains.mps.nodeEditor.EditorComponent;
import java.util.List;
import java.util.LinkedList;
import java.util.HashSet;
import jetbrains.mps.typesystem.inference.TypeContextManager;
import jetbrains.mps.ide.ui.MPSTreeNode;
import jetbrains.mps.newTypesystem.operation.AddErrorOperation;
import jetbrains.mps.newTypesystem.operation.equation.AddEquationOperation;
import jetbrains.mps.newTypesystem.operation.block.AbstractBlockOperation;
import jetbrains.mps.newTypesystem.state.blocks.Block;
import jetbrains.mps.newTypesystem.operation.ExpandTypeOperation;
import jetbrains.mps.newTypesystem.operation.ApplyRuleOperation;
import jetbrains.mps.newTypesystem.operation.block.AddDependencyOperation;
import jetbrains.mps.newTypesystem.operation.block.RemoveDependencyOperation;
import javax.swing.tree.TreePath;
import jetbrains.mps.newTypesystem.TypesUtil;
import jetbrains.mps.newTypesystem.operation.AssignTypeOperation;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NonNls;
import jetbrains.mps.util.Pair;
import jetbrains.mps.workbench.MPSDataKeys;
import javax.swing.JPopupMenu;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import jetbrains.mps.workbench.action.ActionUtils;
import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.ActionPlaces;
import jetbrains.mps.smodel.ModelAccess;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;

public class TypeSystemTraceTree extends MPSTree implements DataProvider {
  private final IOperationContext myOperationContext;
  private AbstractOperation myOperation;
  private final TypeCheckingContextNew myTypeCheckingContextNew;
  private TypeCheckingContextNew myCurrentContext;
  private final SNode mySelectedNode;
  private final Set<SNode> myNodes;
  private boolean generationMode = false;
  private TypeSystemTracePanel myParent;
  private State myStateCopy;
  private State myCurrentState;
  private AbstractOperation myOldOperation;
  private EditorComponent myEditorComponent;
  private List<TypeSystemTraceTreeNode> myErrorNodes;

  public TypeSystemTraceTree(IOperationContext operationContext, TypeCheckingContextNew tcc, SNode node, TypeSystemTracePanel parent, EditorComponent editorComponent) {
    myOperationContext = operationContext;
    myTypeCheckingContextNew = tcc;
    myOperation = tcc.getOperation();
    myErrorNodes = new LinkedList<TypeSystemTraceTreeNode>();
    mySelectedNode = node;
    myNodes = new HashSet<SNode>();
    myNodes.addAll(node.getDescendants());
    myNodes.add(node);
    myCurrentContext = tcc;
    myParent = parent;
    myStateCopy = new State(tcc, tcc.getState().getOperation());
    setGenerationMode(TraceSettings.isGenerationMode());
    myEditorComponent = editorComponent;
    this.rebuildNow();
    expandAll();
    addTreeSelectionListener(new TypeSystemTraceTree.MyTreeSelectionListener());
  }

  public void rebuildTrace() {
    myTypeCheckingContextNew.checkRootInTraceMode(true);
    this.rebuildNow();
    this.expandAll();
  }

  public void setGenerationMode(boolean generationMode) {
    this.generationMode = generationMode;
    myOldOperation = null;
    if (this.generationMode) {
      TypeCheckingContextNew context = (TypeCheckingContextNew) TypeContextManager.getInstance().createTypeCheckingContext(mySelectedNode);
      context.getTypeInGenerationMode(mySelectedNode);
      myOperation = context.getOperation();
      myCurrentContext = context;
      myCurrentState = context.getState();
    } else {
      myOperation = myTypeCheckingContextNew.getOperation();
      myCurrentContext = myTypeCheckingContextNew;
      myCurrentState = myStateCopy;
    }
  }

  public State getState() {
    return myStateCopy;
  }

  @Override
  protected MPSTreeNode rebuild() {
    setRootVisible(false);
    setGenerationMode(TraceSettings.isGenerationMode());
    if (TraceSettings.isTraceForSelectedNode() && mySelectedNode != null) {
      getSliceVars(myOperation);
    }
    TypeSystemTraceTreeNode result = new TypeSystemTraceTreeNode(myStateCopy.getOperation(), myOperationContext);
    create(myOperation, result);
    setRootVisible(true);
    return result;
  }

  private void create(AbstractOperation operation, TypeSystemTraceTreeNode result) {
    for (AbstractOperation child : operation.getConsequences()) {
      if (filterNodeType(child) && (!(TraceSettings.isTraceForSelectedNode()) || showNode(child))) {
        TypeSystemTraceTreeNode node = new TypeSystemTraceTreeNode(child, myOperationContext, myCurrentContext.getState(), myEditorComponent);
        create(child, node);
        result.add(node);
        if (child instanceof AddErrorOperation) {
          myErrorNodes.add(node);
        }
      } else {
        create(child, result);
      }
    }
  }

  private boolean showNode(AbstractOperation diff) {
    if (mySelectedNode == null && TraceSettings.isTraceForSelectedNode()) {
      return true;
    }
    if (myNodes.contains(diff.getSource())) {
      return true;
    }
    if (diff instanceof AddEquationOperation) {
      AddEquationOperation eq = (AddEquationOperation) diff;
      if (myNodes.contains(eq.getChild()) || myNodes.contains(eq.getParent())) {
        return true;
      }
    }
    if (diff instanceof AbstractBlockOperation) {
      Block block = ((AbstractBlockOperation) diff).getBlock();
      for (SNode node : block.getInputs()) {
        if (myNodes.contains(node)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean filterNodeType(AbstractOperation operation) {
    if (!(TraceSettings.isShowTypesExpansion()) && operation instanceof ExpandTypeOperation) {
      return false;
    }
    if (!(TraceSettings.isShowApplyRuleOperations()) && operation instanceof ApplyRuleOperation) {
      return false;
    }
    if (!(TraceSettings.isShowBlockDependencies()) && (operation instanceof AddDependencyOperation || operation instanceof RemoveDependencyOperation)) {
      return false;
    }
    return true;
  }

  public void goToNextError() {
    int currentRow = -1;
    MPSTreeNode currentNode = this.getCurrentNode();
    if (null != currentNode) {
      currentRow = this.getRowForPath(new TreePath(currentNode.getPath()));
    }
    MPSTreeNode errorNode = getNextErrorNode(currentRow);
    if (null != errorNode) {
      this.scrollPathToVisible(new TreePath(errorNode.getPath()));
      this.selectNode(errorNode);
    }
  }

  private MPSTreeNode getNextErrorNode(int row) {
    TreePath errorPath;
    int errorRow;
    for (TypeSystemTraceTreeNode errorNode : myErrorNodes) {
      errorPath = new TreePath(errorNode.getPath());
      errorRow = this.getRowForPath(errorPath);
      if (errorRow > row) {
        return errorNode;
      }
    }
    if (!(myErrorNodes.isEmpty())) {
      return myErrorNodes.get(0);
    }
    return null;
  }

  private void getSliceVars(AbstractOperation diff) {
    if (diff == null) {
      return;
    }
    if (diff instanceof AddEquationOperation) {
      AddEquationOperation eq = (AddEquationOperation) diff;
      SNode child = eq.getChild();
      SNode parent = eq.getParent();
      if (myNodes.contains(child)) {
        myNodes.addAll(TypesUtil.getVariables(parent));
      }
      if (myNodes.contains(parent)) {
        myNodes.addAll(TypesUtil.getVariables(child));
      }
    }
    if (diff instanceof AssignTypeOperation) {
      AssignTypeOperation typeDifference = (AssignTypeOperation) diff;
      if (myNodes.contains(typeDifference.getNode()) && TypesUtil.isVariable(typeDifference.getType())) {
        myNodes.add(typeDifference.getType());
      }
    }
    for (AbstractOperation childDiff : diff.getConsequences()) {
      getSliceVars(childDiff);
    }
  }

  @Nullable
  public Object getData(@NonNls String id) {
    MPSTreeNode currentNode = this.getCurrentNode();
    AbstractOperation operation = (AbstractOperation) check_kyyn1p_a0a1a01(currentNode);
    if (operation == null) {
      return null;
    }
    final Pair<String, String> rule = operation.getRule();
    final SNode source = operation.getSource();
    if (id.equals(MPSDataKeys.OPERATION_CONTEXT.getName())) {
      return myOperationContext;
    }
    if (id.equals(MPSDataKeys.RULE_MODEL_AND_ID.getName())) {
      return rule;
    }
    if (source != null && source.isRegistered()) {
      if (id.equals(MPSDataKeys.SOURCE_NODE.getName())) {
        return source;
      }
    }
    return null;
  }

  @Override
  protected JPopupMenu createPopupMenu(final MPSTreeNode treeNode) {
    DefaultActionGroup group = ActionUtils.groupFromActions(ActionManager.getInstance().getAction("jetbrains.mps.ide.devkit.actions.GoToNode_Action"), ActionManager.getInstance().getAction("jetbrains.mps.ide.devkit.actions.GoToRule_Action"));
    return ActionManager.getInstance().createActionPopupMenu(ActionPlaces.UNKNOWN, group).getComponent();
  }

  private void showState(final MPSTreeNode newNode) {
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        AbstractOperation rootDifference = myCurrentContext.getOperation();
        Object difference = newNode.getUserObject();
        if (myOldOperation == null) {
          myCurrentState.clear(false);
          myCurrentState.executeOperationsBeforeAnchor(rootDifference, difference);
        } else {
          myCurrentState.updateState(myOldOperation, (AbstractOperation) difference);
        }
        myParent.resetState(myCurrentState);
        myOldOperation = (AbstractOperation) difference;
      }
    });
  }

  private static Object check_kyyn1p_a0a1a01(MPSTreeNode checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getUserObject();
    }
    return null;
  }

  private class MyTreeSelectionListener implements TreeSelectionListener {
    private MyTreeSelectionListener() {
    }

    @Override
    public void valueChanged(TreeSelectionEvent e) {
      TreePath path = e.getNewLeadSelectionPath();
      if (path == null) {
        return;
      }
      Object treeNode = path.getLastPathComponent();
      showState((MPSTreeNode) treeNode);
    }
  }
}
