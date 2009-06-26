package jetbrains.mps.lang.test.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import javax.swing.Icon;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.project.MPSProject;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.workbench.MPSDataKeys;
import java.util.Set;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import java.util.HashSet;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.baseLanguage.unitTest.behavior.ITestCase_Behavior;
import jetbrains.mps.baseLanguage.unitTest.behavior.ITestMethod_Behavior;
import jetbrains.mps.lang.test.runtime.BaseTransformationTest;
import jetbrains.mps.lang.test.behavior.NodesTestCase_Behavior;

public class RunTestInMPS_Action extends GeneratedAction {
  private static final Icon ICON = null;
  private static Logger LOG = Logger.getLogger(RunTestInMPS_Action.class);

  private SModel model;
  private SNode node;
  public MPSProject project;

  public RunTestInMPS_Action() {
    super("Run Test in MPS Process", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(false);
  }

  @NotNull()
  public String getKeyStroke() {
    return "";
  }

  public boolean isApplicable(AnActionEvent event) {
    return SNodeOperations.isInstanceOf(RunTestInMPS_Action.this.node, "jetbrains.mps.lang.test.structure.NodesTestCase");
  }

  public void doUpdate(@NotNull() AnActionEvent event) {
    try {
      {
        boolean enabled = this.isApplicable(event);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      LOG.error("User's action doUpdate method failed. Action:" + "RunTestInMPS", t);
      this.disable(event.getPresentation());
    }
  }

  @Override()
  protected boolean collectActionData(AnActionEvent event) {
    if (!(super.collectActionData(event))) {
      return false;
    }
    if (event.getData(MPSDataKeys.MODEL) == null) {
      return false;
    }
    this.model = event.getData(MPSDataKeys.MODEL).getSModel();
    if (this.model == null) {
      return false;
    }
    {
      SNode node = event.getData(MPSDataKeys.NODE);
      if (node != null) {
      }
      this.node = node;
    }
    if (this.node == null) {
      return false;
    }
    this.project = event.getData(MPSDataKeys.MPS_PROJECT);
    if (this.project == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull() final AnActionEvent event) {
    try {
      final Set<SNode> tests = SetSequence.fromSet(new HashSet<SNode>());
      SetSequence.fromSet(tests).addSequence(ListSequence.fromList(ITestCase_Behavior.call_getTestSet_1216130724401(SNodeOperations.cast(RunTestInMPS_Action.this.node, "jetbrains.mps.lang.test.structure.NodesTestCase"))).toListSequence());
      for(SNode test : SetSequence.fromSet(tests)) {
        RunTestInMPS_Action.this.runTest(test);
      }
    } catch (Throwable t) {
      LOG.error("User's action execute method failed. Action:" + "RunTestInMPS", t);
    }
  }

  /* package */void runTest(final SNode test) {
    try {
      final String className = ITestCase_Behavior.call_getClassName_1216136193905(ITestMethod_Behavior.call_getTestCase_1216134500045(test));
      final String testName = ITestMethod_Behavior.call_getTestName_1216136419751(test);
      System.out.println("Test " + className + "." + testName);
      final Class c = RunTestInMPS_Action.this.model.getModelDescriptor().getModule().getClass(ITestCase_Behavior.call_getClassName_1216136193905(ITestMethod_Behavior.call_getTestCase_1216134500045(test)));
      final BaseTransformationTest testClass = (BaseTransformationTest)c.newInstance();
      testClass.setProject(RunTestInMPS_Action.this.project);
      testClass.setModelDescriptor(RunTestInMPS_Action.this.model.getModelDescriptor());
      Thread thread = new Thread(new Runnable() {

        public void run() {
          try {
            testClass.runTest(className + "$" + NodesTestCase_Behavior.getTestBodyName_1224602741295(), testName, true);
          } catch (Throwable e) {
            e.printStackTrace();
          }
        }
      });
      thread.start();
    } catch (Throwable e) {
      e.printStackTrace();
    }
  }

}
