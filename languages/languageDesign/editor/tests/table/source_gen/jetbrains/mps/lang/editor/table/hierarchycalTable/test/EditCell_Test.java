package jetbrains.mps.lang.editor.table.hierarchycalTable.test;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.util.plugin.run.MPSLaunch;
import jetbrains.mps.lang.test.runtime.BaseTransformationTest;
import org.junit.Test;
import jetbrains.mps.lang.test.runtime.BaseEditorTestBody;
import jetbrains.mps.openapi.editor.Editor;
import jetbrains.mps.nodeEditor.EditorComponent;

@MPSLaunch
public class EditCell_Test extends BaseTransformationTest {
  public EditCell_Test() {
  }

  @Test
  public void test_EditCell() throws Throwable {
    this.initTest("${mps_home}/MPS.ipr", "r:67b81510-37ee-448c-9923-c51275863bef(jetbrains.mps.lang.editor.table.hierarchycalTable.test)");
    this.runTest("jetbrains.mps.lang.editor.table.hierarchycalTable.test.EditCell_Test$TestBody", "testMethod", false);
  }

  @MPSLaunch
  public static class TestBody extends BaseEditorTestBody {
    public TestBody() {
    }

    @Override
    public void testMethodImpl() throws Exception {
      final Editor editor = TestBody.this.initEditor("6170050146384276215", "6170050146384276240");
      EditorComponent editorComponent = (EditorComponent) editor.getCurrentEditorComponent();
      BaseEditorTestBody.typeString(editorComponent, "newCellContent");
    }
  }
}
