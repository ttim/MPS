package jetbrains.mps.lang.editor.table.hierarchycalTable.test;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.util.plugin.run.MPSLaunch;
import jetbrains.mps.lang.test.runtime.BaseTransformationTest;
import org.junit.Test;
import jetbrains.mps.lang.test.runtime.BaseEditorTestBody;
import jetbrains.mps.openapi.editor.Editor;
import jetbrains.mps.nodeEditor.EditorComponent;

@MPSLaunch
public class InsertRowAfterLast_Test extends BaseTransformationTest {
  public InsertRowAfterLast_Test() {
  }

  @Test
  public void test_InsertRowAfterLast() throws Throwable {
    this.initTest("${mps_home}/MPS.ipr", "r:67b81510-37ee-448c-9923-c51275863bef(jetbrains.mps.lang.editor.table.hierarchycalTable.test)");
    this.runTest("jetbrains.mps.lang.editor.table.hierarchycalTable.test.InsertRowAfterLast_Test$TestBody", "testMethod", false);
  }

  @MPSLaunch
  public static class TestBody extends BaseEditorTestBody {
    public TestBody() {
    }

    @Override
    public void testMethodImpl() throws Exception {
      final Editor editor = TestBody.this.initEditor("1211716198725196076", "1211716198725196101");
      EditorComponent editorComponent = (EditorComponent) editor.getCurrentEditorComponent();
      BaseEditorTestBody.invokeAction(editorComponent, "jetbrains.mps.ide.editor.actions.Insert_Action");
    }
  }
}
