package jetbrains.mps.lang.editor.table.matrix.test;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.util.plugin.run.MPSLaunch;
import jetbrains.mps.lang.test.runtime.BaseTransformationTest;
import org.junit.Test;
import jetbrains.mps.lang.test.runtime.BaseEditorTestBody;
import jetbrains.mps.openapi.editor.Editor;
import jetbrains.mps.nodeEditor.EditorComponent;

@MPSLaunch
public class Create_Test extends BaseTransformationTest {
  public Create_Test() {
  }

  @Test
  public void test_Create() throws Throwable {
    this.initTest("${mps_home}/MPS.ipr", "r:8bac3b50-f9ad-4677-8274-76544dbc0da8(jetbrains.mps.lang.editor.table.matrix.test)");
    this.runTest("jetbrains.mps.lang.editor.table.matrix.test.Create_Test$TestBody", "testMethod", false);
  }

  @MPSLaunch
  public static class TestBody extends BaseEditorTestBody {
    public TestBody() {
    }

    @Override
    public void testMethodImpl() throws Exception {
      final Editor editor = TestBody.this.initEditor("4379396156287837029", "4379396156287837033");
      EditorComponent editorComponent = (EditorComponent) editor.getCurrentEditorComponent();
      BaseEditorTestBody.invokeAction(editorComponent, "jetbrains.mps.ide.editor.actions.Insert_Action");
    }
  }
}
