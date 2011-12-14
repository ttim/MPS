package jetbrains.mps.baseLanguage.unitTest.execution.tool;

/*Generated by MPS */

import org.jetbrains.annotations.NotNull;
import jetbrains.mps.baseLanguage.unitTest.execution.client.ITestNodeWrapper;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.smodel.ModelAccess;
import com.intellij.openapi.actionSystem.ActionGroup;
import jetbrains.mps.workbench.action.ActionUtils;
import jetbrains.mps.ide.navigation.NavigationSupport;

public class TestCaseTreeNode extends BaseTestTreeNode {
  @NotNull
  protected final ITestNodeWrapper myTestCase;

  public TestCaseTreeNode(@NotNull IOperationContext operationContext, @NotNull ITestNodeWrapper testCase) {
    super(operationContext);
    myTestCase = testCase;
    setNodeIdentifier(myTestCase.getNodePointer().getNodeId().toString());
    setText(SPropertyOperations.getString(SNodeOperations.cast(myTestCase.getNode(), "jetbrains.mps.lang.core.structure.INamedConcept"), "name"));
    setAdditionalText(myTestCase.getNodePointer().getModelReference().getLongName());
  }

  public String getClassName() {
    final Wrappers._T<String> className = new Wrappers._T<String>(null);
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        className.value = myTestCase.getFqName();
      }
    });
    return className.value;
  }

  @Override
  public ActionGroup getActionGroup() {
    return ActionUtils.getGroup("jetbrains.mps.ide.actions.JUnitTestCaseActions_ActionGroup");
  }

  public void doubleClick() {
    NavigationSupport.getInstance().openNode(getOperationContext(), myTestCase.getNode(), true, false);
  }

  public int getToggleClickCount() {
    return -1;
  }

  @Override
  public Object getUserObject() {
    return myTestCase;
  }
}
