package jetbrains.mps.editorTest;

/*Generated by MPS */

import jetbrains.mps.MPSLaunch;
import jetbrains.mps.lang.test.runtime.BaseTransformationTest4;
import org.junit.Test;
import jetbrains.mps.lang.test.runtime.BaseEditorTestBody;
import jetbrains.mps.openapi.editor.Editor;
import jetbrains.mps.nodeEditor.EditorComponent;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import junit.framework.Assert;
import jetbrains.mps.nodeEditor.cells.EditorCell_Label;

@MPSLaunch
public class SmartReferenseUpdateOnChange_Test extends BaseTransformationTest4 {
  public SmartReferenseUpdateOnChange_Test() {
  }

  @Test
  public void test_SmartReferenseUpdateOnChange() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:914ee49a-537d-44b2-a5fb-bac87a54743d(jetbrains.mps.editorTest)");
    this.runTest("jetbrains.mps.editorTest.SmartReferenseUpdateOnChange_Test$TestBody", "testMethod", false);
  }

  @MPSLaunch
  public static class TestBody extends BaseEditorTestBody {
    public TestBody() {
    }

    @Override
    public void testMethodImpl() throws Exception {
      final Editor editor = TestBody.this.initEditor("2345623147105495371", "2345623147105495377");
      final EditorComponent editorComponent = (EditorComponent) editor.getCurrentEditorComponent();
      BaseEditorTestBody.invokeAction(editorComponent, "jetbrains.mps.ide.editor.actions.Backspace_Action");
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          SNode testNode = SNodeOperations.cast(TestBody.this.getNodeById("2345623147105496859"), "jetbrains.mps.baseLanguage.structure.ClassifierType");
          EditorCell editorCell = editorComponent.findCellWithId(testNode, "ReferencePresentation_91bvrs_a0a0");
          Assert.assertEquals("SmartReferenseUpdat", ((EditorCell_Label) editorCell).getText());
        }
      });
    }
  }
}
