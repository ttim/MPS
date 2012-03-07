package jetbrains.mps.transformation.test.inputModels.test_refScopeEditorTests;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.util.plugin.run.MPSLaunch;
import jetbrains.mps.lang.test.runtime.BaseTransformationTest;
import org.junit.Test;
import jetbrains.mps.lang.test.runtime.BaseEditorTestBody;
import jetbrains.mps.openapi.editor.Editor;
import jetbrains.mps.nodeEditor.EditorComponent;

@MPSLaunch
public class refScopeInInputLang_paramConflict_Test extends BaseTransformationTest {
  public refScopeInInputLang_paramConflict_Test() {
  }

  @Test
  public void test_refScopeInInputLang_paramConflict() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:2ab484bd-6d9e-44f0-999f-0e78b0351ba4(jetbrains.mps.transformation.test.inputModels.test_refScopeEditorTests)");
    this.runTest("jetbrains.mps.transformation.test.inputModels.test_refScopeEditorTests.refScopeInInputLang_paramConflict_Test$TestBody", "testMethod", false);
  }

  @MPSLaunch
  public static class TestBody extends BaseEditorTestBody {
    public TestBody() {
    }

    @Override
    public void testMethodImpl() throws Exception {
      final Editor editor = TestBody.this.initEditor("3715568794894753650", "3715568794894753665");
      EditorComponent editorComponent = (EditorComponent) editor.getCurrentEditorComponent();
      BaseEditorTestBody.typeString(editorComponent, "c");
    }
  }
}
