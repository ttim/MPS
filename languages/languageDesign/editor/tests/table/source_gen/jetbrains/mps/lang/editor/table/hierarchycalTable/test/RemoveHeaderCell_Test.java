package jetbrains.mps.lang.editor.table.hierarchycalTable.test;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.util.plugin.run.MPSLaunch;
import jetbrains.mps.lang.test.runtime.BaseTransformationTest;
import org.junit.Test;
import jetbrains.mps.lang.test.runtime.BaseEditorTestBody;
import jetbrains.mps.openapi.editor.Editor;
import jetbrains.mps.nodeEditor.EditorComponent;

@MPSLaunch
public class RemoveHeaderCell_Test extends BaseTransformationTest {
  public RemoveHeaderCell_Test() {
  }

  @Test
  public void test_RemoveHeaderCell() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:67b81510-37ee-448c-9923-c51275863bef(jetbrains.mps.lang.editor.table.hierarchycalTable.test)");
    this.runTest("jetbrains.mps.lang.editor.table.hierarchycalTable.test.RemoveHeaderCell_Test$TestBody", "testMethod", false);
  }

  @MPSLaunch
  public static class TestBody extends BaseEditorTestBody {
    public TestBody() {
    }

    @Override
    public void testMethodImpl() throws Exception {
      final Editor editor = TestBody.this.initEditor("6170050146384276112", "2361546520930481279");
      EditorComponent editorComponent = (EditorComponent) editor.getCurrentEditorComponent();
      BaseEditorTestBody.invokeAction(editorComponent, "jetbrains.mps.ide.editor.actions.Backspace_Action");
      BaseEditorTestBody.invokeAction(editorComponent, "jetbrains.mps.ide.editor.actions.Backspace_Action");
    }
  }
}
