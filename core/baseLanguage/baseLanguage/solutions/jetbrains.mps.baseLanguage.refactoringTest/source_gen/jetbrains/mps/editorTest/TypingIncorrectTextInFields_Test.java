package jetbrains.mps.editorTest;

/*Generated by MPS */

import jetbrains.mps.lang.test.runtime.BaseTransformationTest;
import org.junit.Test;
import jetbrains.mps.lang.test.runtime.BaseEditorTestBody;
import jetbrains.mps.ide.IEditor;
import javax.swing.SwingUtilities;
import jetbrains.mps.nodeEditor.EditorComponent;

public class TypingIncorrectTextInFields_Test extends BaseTransformationTest {
  @Test
  public void test_TypingIncorrectTextInFields() throws Throwable {
    this.initTest("${mps_home}/core/baseLanguage/baseLanguage/baseLanguage.mpr", "r:914ee49a-537d-44b2-a5fb-bac87a54743d(jetbrains.mps.editorTest)");
    this.runTest(this.getClass().getCanonicalName() + "$TestBody", "testMethod", false);
  }

  public static class TestBody extends BaseEditorTestBody {
    public void testMethod() throws Exception {
      final IEditor[] editorWrap = new IEditor[1];
      SwingUtilities.invokeAndWait(new Runnable() {
        public void run() {
          try {
            editorWrap[0] = TestBody.this.initEditor("1622243561473153891", "1622243561473155032");
          } catch (Exception e) {
            e.printStackTrace();
          }
        }
      });
      final IEditor editor = editorWrap[0];
      EditorComponent editorComponent = editor.getCurrentEditorComponent();
      BaseEditorTestBody.typeString(editorComponent, "1234");
      TestBody.this.finishTest();
    }
  }
}
