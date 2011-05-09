package jetbrains.mps.editorTest;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.util.plugin.run.MPSLaunch;
import jetbrains.mps.lang.test.runtime.BaseTransformationTest;
import org.junit.Test;
import jetbrains.mps.lang.test.runtime.BaseEditorTestBody;
import jetbrains.mps.ide.IEditor;
import jetbrains.mps.nodeEditor.EditorComponent;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;

@MPSLaunch
public class LT_PlusExpression_with_Cast_Test extends BaseTransformationTest {
  @Test
  public void test_LT_PlusExpression_with_Cast() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:914ee49a-537d-44b2-a5fb-bac87a54743d(jetbrains.mps.editorTest)");
    this.runTest("jetbrains.mps.editorTest.LT_PlusExpression_with_Cast_Test$TestBody", "testMethod", false);
  }

  @MPSLaunch
  public static class TestBody extends BaseEditorTestBody {
    @Override
    public void testMethodImpl() throws Exception {
      final IEditor editor = TestBody.this.initEditor("3956753173913342772", "3956753173913342774");
      EditorComponent editorComponent = editor.getCurrentEditorComponent();
      BaseEditorTestBody.typeString(editorComponent, "(type");
      BaseEditorTestBody.pressKeys(editorComponent, ListSequence.fromListAndArray(new ArrayList<String>(), "ctrl SPACE"));
    }
  }
}
