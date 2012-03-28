package jetbrains.mps.lang.editor.selection.test;

/*Generated by MPS */

import jetbrains.mps.MPSLaunch;
import jetbrains.mps.lang.test.runtime.BaseTransformationTest4;
import org.junit.Test;
import jetbrains.mps.lang.test.runtime.BaseEditorTestBody;
import jetbrains.mps.openapi.editor.Editor;
import jetbrains.mps.nodeEditor.EditorComponent;

@MPSLaunch
public class EndWithLineSelection_fromFirstCell_Test extends BaseTransformationTest4 {
  public EndWithLineSelection_fromFirstCell_Test() {
  }

  @Test
  public void test_EndWithLineSelection_fromFirstCell() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:f429894b-858b-4e34-87ae-2cfe2a061928(jetbrains.mps.lang.editor.selection.test)");
    this.runTest("jetbrains.mps.lang.editor.selection.test.EndWithLineSelection_fromFirstCell_Test$TestBody", "testMethod", false);
  }

  @MPSLaunch
  public static class TestBody extends BaseEditorTestBody {
    public TestBody() {
    }

    @Override
    public void testMethodImpl() throws Exception {
      final Editor editor = TestBody.this.initEditor("9080919888312410799", "9080919888312410806");
      EditorComponent editorComponent = (EditorComponent) editor.getCurrentEditorComponent();
      BaseEditorTestBody.invokeAction(editorComponent, "jetbrains.mps.ide.editor.actions.SelectNext_Action");
      BaseEditorTestBody.invokeAction(editorComponent, "jetbrains.mps.ide.editor.actions.End_Action");
    }
  }
}
