package jetbrains.mps.editorTest;

/*Generated by MPS */

import jetbrains.mps.lang.test.runtime.BaseTransformationTest;
import org.junit.Test;
import jetbrains.mps.lang.test.runtime.BaseEditorTestBody;
import jetbrains.mps.ide.IEditor;
import junit.framework.Assert;

public class ForTest_Test extends BaseTransformationTest {

  @Test()
  public void test_ForTest() throws Throwable {
    this.initTest("${mps_home}/core/languageDesign/mps-lite/mps-lite.mpr", "r:914ee49a-537d-44b2-a5fb-bac87a54743d(jetbrains.mps.editorTest)");
    this.runTest(this.getClass().getCanonicalName() + "$TestBody", "testMethod", false);
  }

  public static class TestBody extends BaseEditorTestBody {

    public void testMethod() throws Exception {
      IEditor editor = this.initEditor("1230058635796", "");
      BaseEditorTestBody.typeString(editor, "for ");
      Assert.assertTrue(editor.getCurrentEditorComponent().getNodeSubstituteChooser().isVisible());
      this.finishTest();
    }

}

}
