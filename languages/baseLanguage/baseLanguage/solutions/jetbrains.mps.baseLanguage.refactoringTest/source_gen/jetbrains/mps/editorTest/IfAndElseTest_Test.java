package jetbrains.mps.editorTest;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.util.plugin.run.MPSLaunch;
import jetbrains.mps.lang.test.runtime.BaseTransformationTest;
import org.junit.Test;
import jetbrains.mps.lang.test.runtime.BaseEditorTestBody;
import jetbrains.mps.openapi.editor.Editor;
import jetbrains.mps.nodeEditor.EditorComponent;

@MPSLaunch
public class IfAndElseTest_Test extends BaseTransformationTest {
  public IfAndElseTest_Test() {
  }

  @Test
  public void test_IfAndElseTest() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:914ee49a-537d-44b2-a5fb-bac87a54743d(jetbrains.mps.editorTest)");
    this.runTest("jetbrains.mps.editorTest.IfAndElseTest_Test$TestBody", "testMethod", false);
  }

  @MPSLaunch
  public static class TestBody extends BaseEditorTestBody {
    public TestBody() {
    }

    @Override
    public void testMethodImpl() throws Exception {
      final Editor editor = TestBody.this.initEditor("1230058635882", "1230058635887");
      EditorComponent editorComponent = (EditorComponent) editor.getCurrentEditorComponent();
      BaseEditorTestBody.typeString(editorComponent, "iftrue");
      BaseEditorTestBody.invokeAction(editorComponent, "jetbrains.mps.ide.editor.actions.MoveDown_Action");
      BaseEditorTestBody.invokeAction(editorComponent, "jetbrains.mps.ide.editor.actions.MoveDown_Action");
      BaseEditorTestBody.typeString(editorComponent, "else iffalse");
      BaseEditorTestBody.invokeAction(editorComponent, "jetbrains.mps.ide.editor.actions.MoveDown_Action");
      BaseEditorTestBody.invokeAction(editorComponent, "jetbrains.mps.ide.editor.actions.MoveDown_Action");
      BaseEditorTestBody.typeString(editorComponent, "else {");
    }
  }
}
