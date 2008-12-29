package jetbrains.mps.editorTest;

/*Generated by MPS */

import jetbrains.mps.lang.test.runtime.BaseTransformationTest;
import org.junit.Test;
import jetbrains.mps.lang.test.runtime.BaseEditorTestBody;
import jetbrains.mps.ide.IEditor;

public class RightTransform_Test extends BaseTransformationTest {

  @Test()
  public void test_RightTransform() throws Throwable {
    this.initTest("${mps_home}/core/languageDesign/dataFlow/dataFlow.mpr", "r:914ee49a-537d-44b2-a5fb-bac87a54743d(jetbrains.mps.editorTest)");
    this.runTest(this.getClass().getCanonicalName() + "$TestBody", "testMethod", false);
  }

  public static class TestBody extends BaseEditorTestBody {

    public void testMethod() throws Exception {
      IEditor editor = this.initEditor("1230303902564", "1230306744845");
      BaseEditorTestBody.typeString(editor, " [");
      this.finishTest();
    }

}

}
