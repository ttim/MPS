package jetbrains.mps.lang.editor.table.genericTable.test;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.util.plugin.run.MPSLaunch;
import jetbrains.mps.lang.test.runtime.BaseTransformationTest;
import org.junit.Test;
import jetbrains.mps.lang.test.runtime.BaseEditorTestBody;
import jetbrains.mps.openapi.editor.Editor;
import jetbrains.mps.nodeEditor.EditorComponent;

@MPSLaunch
public class InsertRowBefore_FromLastCell_ByIns_Test extends BaseTransformationTest {
  public InsertRowBefore_FromLastCell_ByIns_Test() {
  }

  @Test
  public void test_InsertRowBefore_FromLastCell_ByIns() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:e02ee75b-0624-4ff2-b4d9-d2277a157ff4(jetbrains.mps.lang.editor.table.genericTable.test)");
    this.runTest("jetbrains.mps.lang.editor.table.genericTable.test.InsertRowBefore_FromLastCell_ByIns_Test$TestBody", "testMethod", false);
  }

  @MPSLaunch
  public static class TestBody extends BaseEditorTestBody {
    public TestBody() {
    }

    @Override
    public void testMethodImpl() throws Exception {
      final Editor editor = TestBody.this.initEditor("5481602834662808047", "5481602834662808069");
      EditorComponent editorComponent = (EditorComponent) editor.getCurrentEditorComponent();
      BaseEditorTestBody.invokeAction(editorComponent, "jetbrains.mps.ide.editor.actions.InsertBefore_Action");
    }
  }
}
