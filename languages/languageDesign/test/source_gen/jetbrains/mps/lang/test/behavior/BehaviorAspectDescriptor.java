package jetbrains.mps.lang.test.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import java.util.Arrays;
import jetbrains.mps.smodel.runtime.interpreted.BehaviorAspectInterpreted;

public class BehaviorAspectDescriptor implements jetbrains.mps.smodel.runtime.BehaviorAspectDescriptor {
  private static String[] stringSwitchCases_846f5o_a0a0a = new String[]{"jetbrains.mps.lang.test.structure.AnonymousCellAnnotation", "jetbrains.mps.lang.test.structure.AssertMatch", "jetbrains.mps.lang.test.structure.BootstrapActionReference", "jetbrains.mps.lang.test.structure.CheckDataFlowOperation", "jetbrains.mps.lang.test.structure.CheckNodeDataflow", "jetbrains.mps.lang.test.structure.CheckNodeForErrors", "jetbrains.mps.lang.test.structure.EditorComponentExpression", "jetbrains.mps.lang.test.structure.EditorExpression", "jetbrains.mps.lang.test.structure.EditorOperation", "jetbrains.mps.lang.test.structure.EditorTestCase", "jetbrains.mps.lang.test.structure.ExpressionContainer", "jetbrains.mps.lang.test.structure.INodeAnnotattion", "jetbrains.mps.lang.test.structure.InvokeActionStatement", "jetbrains.mps.lang.test.structure.InvokeIntentionStatement", "jetbrains.mps.lang.test.structure.MPSActionReference", "jetbrains.mps.lang.test.structure.MockAnnotation", "jetbrains.mps.lang.test.structure.ModelExpression", "jetbrains.mps.lang.test.structure.NodeErrorPropety", "jetbrains.mps.lang.test.structure.NodeExpectedTypeProperty", "jetbrains.mps.lang.test.structure.NodeOperationsContainer", "jetbrains.mps.lang.test.structure.NodePropertiesContainer", "jetbrains.mps.lang.test.structure.NodeReachable", "jetbrains.mps.lang.test.structure.NodeTypeProperty", "jetbrains.mps.lang.test.structure.NodeTypeSetProperty", "jetbrains.mps.lang.test.structure.NodeUnreachable", "jetbrains.mps.lang.test.structure.NodeWarningProperty", "jetbrains.mps.lang.test.structure.NodesTestCase", "jetbrains.mps.lang.test.structure.PressKeyStatement", "jetbrains.mps.lang.test.structure.ProjectExpression", "jetbrains.mps.lang.test.structure.SimpleNodeTest", "jetbrains.mps.lang.test.structure.SwitchToInspector", "jetbrains.mps.lang.test.structure.TestInfo", "jetbrains.mps.lang.test.structure.TestNode", "jetbrains.mps.lang.test.structure.TestNodeAnnotation", "jetbrains.mps.lang.test.structure.TestNodeReference", "jetbrains.mps.lang.test.structure.TypeKeyStatement", "jetbrains.mps.lang.test.structure.TypesCheckOperation", "jetbrains.mps.lang.test.structure.VariableInialized", "jetbrains.mps.lang.test.structure.VariableLive"};

  public BehaviorAspectDescriptor() {
  }

  public BehaviorDescriptor getDescriptor(String fqName) {
    switch (Arrays.binarySearch(stringSwitchCases_846f5o_a0a0a, fqName)) {
      case 33:
        return new TestNodeAnnotation_BehaviorDescriptor();
      case 34:
        return new TestNodeReference_BehaviorDescriptor();
      case 1:
        return new AssertMatch_BehaviorDescriptor();
      case 5:
        return new CheckNodeForErrors_BehaviorDescriptor();
      case 20:
        return new NodePropertiesContainer_BehaviorDescriptor();
      case 17:
        return new NodeErrorPropety_BehaviorDescriptor();
      case 25:
        return new NodeWarningProperty_BehaviorDescriptor();
      case 21:
        return new NodeReachable_BehaviorDescriptor();
      case 22:
        return new NodeTypeProperty_BehaviorDescriptor();
      case 19:
        return new NodeOperationsContainer_BehaviorDescriptor();
      case 36:
        return new TypesCheckOperation_BehaviorDescriptor();
      case 3:
        return new CheckDataFlowOperation_BehaviorDescriptor();
      case 24:
        return new NodeUnreachable_BehaviorDescriptor();
      case 37:
        return new VariableInialized_BehaviorDescriptor();
      case 38:
        return new VariableLive_BehaviorDescriptor();
      case 26:
        return new NodesTestCase_BehaviorDescriptor();
      case 32:
        return new TestNode_BehaviorDescriptor();
      case 4:
        return new CheckNodeDataflow_BehaviorDescriptor();
      case 28:
        return new ProjectExpression_BehaviorDescriptor();
      case 16:
        return new ModelExpression_BehaviorDescriptor();
      case 29:
        return new SimpleNodeTest_BehaviorDescriptor();
      case 7:
        return new EditorExpression_BehaviorDescriptor();
      case 13:
        return new InvokeIntentionStatement_BehaviorDescriptor();
      case 8:
        return new EditorOperation_BehaviorDescriptor();
      case 11:
        return new INodeAnnotattion_BehaviorDescriptor();
      case 35:
        return new TypeKeyStatement_BehaviorDescriptor();
      case 27:
        return new PressKeyStatement_BehaviorDescriptor();
      case 9:
        return new EditorTestCase_BehaviorDescriptor();
      case 0:
        return new AnonymousCellAnnotation_BehaviorDescriptor();
      case 15:
        return new MockAnnotation_BehaviorDescriptor();
      case 23:
        return new NodeTypeSetProperty_BehaviorDescriptor();
      case 10:
        return new ExpressionContainer_BehaviorDescriptor();
      case 30:
        return new SwitchToInspector_BehaviorDescriptor();
      case 6:
        return new EditorComponentExpression_BehaviorDescriptor();
      case 31:
        return new TestInfo_BehaviorDescriptor();
      case 12:
        return new InvokeActionStatement_BehaviorDescriptor();
      case 2:
        return new BootstrapActionReference_BehaviorDescriptor();
      case 14:
        return new MPSActionReference_BehaviorDescriptor();
      case 18:
        return new NodeExpectedTypeProperty_BehaviorDescriptor();
      default:
        return BehaviorAspectInterpreted.getInstance().getDescriptor(fqName);
    }
  }
}
