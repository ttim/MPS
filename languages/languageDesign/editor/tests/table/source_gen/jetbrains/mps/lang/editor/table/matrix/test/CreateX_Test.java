package jetbrains.mps.lang.editor.table.matrix.test;

/*Generated by MPS */

import jetbrains.mps.MPSLaunch;
import jetbrains.mps.lang.test.runtime.BaseTransformationTest4;
import org.junit.Test;
import jetbrains.mps.lang.test.runtime.BaseEditorTestBody;
import jetbrains.mps.openapi.editor.Editor;
import jetbrains.mps.nodeEditor.EditorComponent;

@MPSLaunch
public class CreateX_Test extends BaseTransformationTest4 {
  public CreateX_Test() {
  }

  @Test
  public void test_CreateX() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:8bac3b50-f9ad-4677-8274-76544dbc0da8(jetbrains.mps.lang.editor.table.matrix.test)");
    this.runTest("jetbrains.mps.lang.editor.table.matrix.test.CreateX_Test$TestBody", "testMethod", false);
  }

  @MPSLaunch
  public static class TestBody extends BaseEditorTestBody {
    public TestBody() {
    }

    @Override
    public void testMethodImpl() throws Exception {
      final Editor editor = TestBody.this.initEditor("1310272842909656053", "1310272842909656061");
      EditorComponent editorComponent = (EditorComponent) editor.getCurrentEditorComponent();
      BaseEditorTestBody.invokeAction(editorComponent, "jetbrains.mps.ide.editor.actions.Insert_Action");
    }
  }
}
