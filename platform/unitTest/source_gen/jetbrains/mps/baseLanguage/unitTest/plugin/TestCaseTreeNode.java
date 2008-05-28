package jetbrains.mps.baseLanguage.unitTest.plugin;

/*Generated by MPS */

import jetbrains.mps.ide.ui.MPSTreeNode;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.ide.icons.IconManager;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.closures.runtime.Wrappers;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.core.constraints.INamedConcept_Behavior;
import jetbrains.mps.workbench.editors.MPSEditorOpener;

public class TestCaseTreeNode extends MPSTreeNode {

  protected SNode testCase;
  private TestState state;

  public TestCaseTreeNode(IOperationContext operationContext, SNode testCase) {
    super(operationContext);
    this.testCase = testCase;
    this.updatePresentation();
  }

  public void updatePresentation() {
    this.setIcon(IconManager.getIconFor(this.testCase));
    this.setNodeIdentifier(this.testCase.getId());
    this.setText(SPropertyOperations.getString(this.testCase, "name"));
    this.setAdditionalText(SNodeOperations.getModel(this.testCase).getLongName());
  }

  public void setState(TestState state) {
    this.state = state;
  }

  public String getClassName() {
    final Wrappers._T<String> className = new Wrappers._T<String>(null);
    ModelAccess.instance().runReadAction(new Runnable() {

      public void run() {
        className.value = INamedConcept_Behavior.call_getFqName_1184686272576(TestCaseTreeNode.this.testCase);
      }

    });
    return className.value;
  }

  public void doubleClick() {
    this.getOperationContext().getComponent(MPSEditorOpener.class).openNode(this.testCase);
  }

  public int getToggleClickCount() {
    return -1;
  }

}
