package jetbrains.mps.ide.typesystem.trace;

/*Generated by MPS */

import jetbrains.mps.ide.ui.MPSTree;
import com.intellij.openapi.actionSystem.DataProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.newTypesystem.state.State;
import jetbrains.mps.nodeEditor.EditorComponent;
import jetbrains.mps.ide.ui.MPSTreeNode;
import jetbrains.mps.newTypesystem.state.blocks.BlockKind;
import java.awt.Color;
import java.util.List;
import java.util.Set;
import jetbrains.mps.newTypesystem.state.blocks.Block;
import java.util.HashSet;
import java.util.Map;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.newTypesystem.state.blocks.InequalityBlock;
import java.util.ArrayList;
import jetbrains.mps.newTypesystem.state.NodeMaps;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JPopupMenu;
import jetbrains.mps.workbench.action.BaseAction;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import jetbrains.mps.workbench.action.ActionUtils;
import com.intellij.openapi.actionSystem.ActionManager;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.smodel.SNodePointer;
import com.intellij.openapi.actionSystem.AnActionEvent;
import jetbrains.mps.openapi.navigation.NavigationSupport;
import com.intellij.openapi.actionSystem.ActionPlaces;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NonNls;
import jetbrains.mps.ide.actions.MPSCommonDataKeys;
import jetbrains.mps.workbench.MPSDataKeys;
import jetbrains.mps.util.Pair;

public class TypeSystemStateTree extends MPSTree implements DataProvider {
  private IOperationContext myOperationContext;
  private State myState;
  private EditorComponent myEditorComponent;

  public TypeSystemStateTree(IOperationContext operationContext, State state, EditorComponent editorComponent) {
    myOperationContext = operationContext;
    myState = state;
    myEditorComponent = editorComponent;
    this.rebuildNow();
    expandAll();
  }

  public void resetState(State state) {
    myState = state;
    rebuildNow();
    expandAll();
  }

  @Override
  protected MPSTreeNode rebuild() {
    return createNode();
  }

  private TypeSystemStateTreeNode createNode() {
    TypeSystemStateTreeNode result = new TypeSystemStateTreeNode("Type system state", myOperationContext);
    result.add(new TypeSystemStateTreeNode("Solving inequalities in process: " + myState.getInequalities().isSolvingInProcess(), myOperationContext));
    /*
      result.add(createNode("Check-only inequalities", myState.getCheckingInequalities(), null));
    */
    TypeSystemStateTreeNode[] nodes = {createInequalitiesNode(), createNode("Comparable", myState.getBlocks(BlockKind.COMPARABLE), null), createNode("When concrete", myState.getBlocks(BlockKind.WHEN_CONCRETE), null), createNode("Errors", myState.getNodeMaps().getErrorListPresentation(), Color.RED), createNode("Check-only equations", myState.getBlocks(BlockKind.CHECK_EQUATION), null), createEquationsNode()};
    for (TypeSystemStateTreeNode node : nodes) {
      if (node.children().hasMoreElements()) {
        result.add(node);
      }
    }
    /*
      result.add(createTypesNode());
    */
    return result;
  }

  private TypeSystemStateTreeNode createNode(String category, List<String> entries, Color color) {
    TypeSystemStateTreeNode result = new TypeSystemStateTreeNode(category, myOperationContext);
    if (color != null) {
      result.setColor(color);
    }
    for (String string : entries) {
      result.add(new TypeSystemStateTreeNode(string, myOperationContext));
    }
    return result;
  }

  private TypeSystemStateTreeNode createNode(String category, Set<Block> entries, Color color) {
    TypeSystemStateTreeNode result = new TypeSystemStateTreeNode(category + " (" + entries.size() + ")", myOperationContext);
    if (color != null) {
      result.setColor(color);
    }
    for (Block block : entries) {
      result.add(new BlockTreeNode(block, myOperationContext, myState, myEditorComponent));
    }
    return result;
  }

  private TypeSystemStateTreeNode createInequalitiesNode() {
    TypeSystemStateTreeNode result = new TypeSystemStateTreeNode("Inequalities by groups", myOperationContext);
    Set<String> nodePresentations = new HashSet<String>();
    for (Map.Entry<Set<SNode>, Set<InequalityBlock>> entry : myState.getInequalities().getInequalityGroups(myState.getBlocks(BlockKind.INEQUALITY)).entrySet()) {
      Set<SNode> key = entry.getKey();
      TypeSystemStateTreeNode current;
      if (key.isEmpty() || entry.getValue().size() <= 1) {
        current = result;
      } else {
        current = new TypeSystemStateTreeNode(key.toString(), myOperationContext);
      }
      nodePresentations.clear();
      for (InequalityBlock block : entry.getValue()) {
        BlockTreeNode node = new BlockTreeNode(block, myOperationContext, myState, myEditorComponent);
        String presentation = node.toString();
        if (!(nodePresentations.contains(presentation))) {
          current.add(node);
          nodePresentations.add(presentation);
        }
      }
      if (result != current) {
        result.add(current);
      }
    }
    return result;
  }

  private TypeSystemStateTreeNode createTypesNode() {
    TypeSystemStateTreeNode result = new TypeSystemStateTreeNode("Types", myOperationContext);
    List<TypeTreeNode> list = new ArrayList<TypeTreeNode>();
    NodeMaps nodeMaps = myState.getNodeMaps();
    for (SNode node : nodeMaps.getTypeKeySet()) {
      SNode type = nodeMaps.getInitialType(node);
      list.add(new TypeTreeNode(myOperationContext, node, type, myState.expand(type), myEditorComponent));
    }
    Collections.sort(list, new Comparator<TypeTreeNode>() {
      public int compare(TypeTreeNode o1, TypeTreeNode o2) {
        return o1.toString().compareTo(o2.toString());
      }
    });
    for (TypeTreeNode node : list) {
      result.add(node);
    }
    return result;
  }

  private TypeSystemStateTreeNode createEquationsNode() {
    TypeSystemStateTreeNode result = new TypeSystemStateTreeNode("Equations", myOperationContext);
    for (Map.Entry<SNode, Set<SNode>> equationGroup : myState.getEquations().getEquationGroups()) {
      result.add(new EquationTreeNode(myOperationContext, equationGroup.getKey(), equationGroup.getValue(), myState, myEditorComponent));
    }
    return result;
  }

  @Override
  protected JPopupMenu createPopupMenu(final MPSTreeNode treeNode) {
    BaseAction goToNode = null;
    final TypeSystemStateTreeNode stateNode = (TypeSystemStateTreeNode) treeNode;
    final DefaultActionGroup group = ActionUtils.groupFromActions(((BaseAction) ActionManager.getInstance().getAction("jetbrains.mps.ide.actions.GoToRule_Action")), goToNode);
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        NodeMaps maps = myState.getNodeMaps();
        List<SNode> vars = stateNode.getVariables();
        if (null == vars) {
          return;
        }
        for (SNode var : vars) {
          SNode node = check_x8yvv7_a0a0d0a0a0a0d0i(maps, var);
          if (node != null && node.isRegistered()) {
            final SNodePointer pointer = new SNodePointer(node);
            group.add(new BaseAction("Go to node with type " + var) {
              public void doExecute(AnActionEvent e, Map<String, Object> _params) {
                ModelAccess.instance().runWriteInEDT(new Runnable() {
                  public void run() {
                    SNode node = pointer.getNode();
                    if (node == null) {
                      return;
                    }
                    NavigationSupport.getInstance().openNode(myOperationContext, node, true, true);
                  }
                });
              }
            });
          }
        }
      }
    });
    return ActionManager.getInstance().createActionPopupMenu(ActionPlaces.UNKNOWN, group).getComponent();
  }

  @Nullable
  public Object getData(@NonNls String id) {
    TypeSystemStateTreeNode currentNode = (TypeSystemStateTreeNode) this.getCurrentNode();
    if (id.equals(MPSCommonDataKeys.OPERATION_CONTEXT.getName())) {
      return myOperationContext;
    }
    if (id.equals(MPSDataKeys.RULE_MODEL_AND_ID.getName())) {
      String ruleModel = currentNode.getRuleModel();
      String ruleId = currentNode.getRuleId();
      if (ruleModel == null || ruleId == null) {
        return null;
      }
      return new Pair<String, String>(ruleModel, ruleId);
    }
    return null;
  }

  private static SNode check_x8yvv7_a0a0d0a0a0a0d0i(NodeMaps checkedDotOperand, SNode var) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getNode(var);
    }
    return null;
  }
}
