package jetbrains.mps.editorTest;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.util.plugin.run.MPSLaunch;
import jetbrains.mps.lang.test.runtime.BaseTransformationTest;
import org.junit.Test;
import jetbrains.mps.lang.test.runtime.BaseEditorTestBody;
import jetbrains.mps.ide.IEditor;
import jetbrains.mps.nodeEditor.EditorComponent;

@MPSLaunch
public class RT_ClassTypeVarialeDeclaration_with_AngleBracker_Test extends BaseTransformationTest {
  @Test
  public void test_RT_ClassTypeVarialeDeclaration_with_AngleBracker() throws Throwable {
    this.initTest("${mps_home}/core/baseLanguage/baseLanguage/baseLanguage.mpr", "r:914ee49a-537d-44b2-a5fb-bac87a54743d(jetbrains.mps.editorTest)");
    this.runTest("jetbrains.mps.editorTest.RT_ClassTypeVarialeDeclaration_with_AngleBracker_Test$TestBody", "testMethod", false);
  }

  @MPSLaunch
  public static class TestBody extends BaseEditorTestBody {
    @Override
    public void testMethodImpl() throws Exception {
      final IEditor editor = TestBody.this.initEditor("1528454294471609027", "1528454294471625075");
      EditorComponent editorComponent = editor.getCurrentEditorComponent();
      BaseEditorTestBody.typeString(editorComponent, "<");
    }
  }
}
