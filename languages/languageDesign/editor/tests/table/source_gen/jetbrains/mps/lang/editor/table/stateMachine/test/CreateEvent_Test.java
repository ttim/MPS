package jetbrains.mps.lang.editor.table.stateMachine.test;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.util.plugin.run.MPSLaunch;
import jetbrains.mps.lang.test.runtime.BaseTransformationTest;
import org.junit.Test;
import jetbrains.mps.lang.test.runtime.BaseEditorTestBody;
import jetbrains.mps.openapi.editor.Editor;
import jetbrains.mps.nodeEditor.EditorComponent;

@MPSLaunch
public class CreateEvent_Test extends BaseTransformationTest {
  public CreateEvent_Test() {
  }

  @Test
  public void test_CreateEvent() throws Throwable {
    this.initTest("${mps_home}/MPS.ipr", "r:dc1400b5-0aa4-448e-8f15-11fb0ccb5c23(jetbrains.mps.lang.editor.table.stateMachine.test)");
    this.runTest("jetbrains.mps.lang.editor.table.stateMachine.test.CreateEvent_Test$TestBody", "testMethod", false);
  }

  @MPSLaunch
  public static class TestBody extends BaseEditorTestBody {
    public TestBody() {
    }

    @Override
    public void testMethodImpl() throws Exception {
      final Editor editor = TestBody.this.initEditor("5877647854348551017", "5877647854348551049");
      EditorComponent editorComponent = (EditorComponent) editor.getCurrentEditorComponent();
      BaseEditorTestBody.invokeAction(editorComponent, "jetbrains.mps.ide.editor.actions.Insert_Action");
    }
  }
}
