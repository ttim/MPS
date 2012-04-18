package jetbrains.mps.execution.impl.configurations.tests.commands;

/*Generated by MPS */

import jetbrains.mps.MPSLaunch;
import jetbrains.mps.lang.test.runtime.BaseTransformationTest4;
import org.junit.Test;
import jetbrains.mps.lang.test.runtime.BaseTestBody;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.smodel.SNodePointer;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelRepository;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.execution.impl.configurations.tests.commands.sandbox.Main;
import jetbrains.mps.baseLanguage.execution.api.Java_Command;
import com.intellij.execution.process.ProcessHandler;
import com.intellij.execution.process.ProcessEvent;
import jetbrains.mps.execution.api.commands.OutputRedirector;
import com.intellij.execution.process.ProcessAdapter;
import com.intellij.openapi.util.Key;
import com.intellij.execution.process.ProcessOutputTypes;
import jetbrains.mps.execution.api.commands.ProcessHandlerBuilder;
import junit.framework.Assert;


@MPSLaunch
public class JavaCommand_Test extends BaseTransformationTest4 {
  @Test
  public void test_startJavaByNode() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:e2bad6d6-3029-4bc3-b44d-49863f32d863(jetbrains.mps.execution.impl.configurations.tests.commands@tests)");
    this.runTest("jetbrains.mps.execution.impl.configurations.tests.commands.JavaCommand_Test$TestBody", "test_startJavaByNode", true);
  }

  @MPSLaunch
  public static class TestBody extends BaseTestBody {
    public void test_startJavaByNode() throws Exception {
      final Wrappers._T<SNodePointer> pointer = new Wrappers._T<SNodePointer>();
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          SModel model = SModelRepository.getInstance().getModelDescriptor(new SModelReference("jetbrains.mps.execution.impl.configurations.tests.commands.sandbox", "tests")).getSModel();
          SNode mainNode = ListSequence.fromList(SModelOperations.getRoots(model, "jetbrains.mps.lang.core.structure.INamedConcept")).findFirst(new IWhereFilter<SNode>() {
            public boolean accept(SNode it) {
              return eq_849b2c_a0a0a0a0a0a1a0a0a0a1a0a(SPropertyOperations.getString(it, "name"), Main.class.getSimpleName());
            }
          });
          pointer.value = new SNodePointer(mainNode);
        }
      });
      this.checkProcess(new Java_Command().createProcess(pointer.value), Main.MESSAGE + "\n");
    }

    public void checkProcess(ProcessHandler process, final String expectedSysErr) {
      final ProcessEvent[] failed = new ProcessEvent[1];
      final boolean[] printed = new boolean[1];
      // todo show progress window 
      OutputRedirector.redirect(process, new ProcessAdapter() {
        @Override
        public void onTextAvailable(ProcessEvent event, Key key) {
          if (ProcessOutputTypes.STDERR.equals(key)) {
            if (neq_849b2c_a0a0a0a0a1a3a1a(event.getText(), expectedSysErr)) {
              failed[0] = event;
              System.err.print(event.getText());
            } else {
              printed[0] = true;
            }
          } else if (!(ProcessOutputTypes.SYSTEM.equals(key))) {
            failed[0] = event;
            System.err.println("Unknown event " + event.getText());
          }
        }
      });
      int exitCode = ProcessHandlerBuilder.startAndWait(process);
      if (failed[0] != null) {
        Assert.fail(failed[0].getText());
      }
      if (!(printed[0])) {
        Assert.fail("Did not print required message!");
      }
      if (exitCode != 0) {
        Assert.fail("Exit with code " + exitCode);
      }
    }

    private static boolean eq_849b2c_a0a0a0a0a0a1a0a0a0a1a0a(Object a, Object b) {
      return (a != null ?
        a.equals(b) :
        a == b
      );
    }

    private static boolean neq_849b2c_a0a0a0a0a1a3a1a(Object a, Object b) {
      return !((a != null ?
        a.equals(b) :
        a == b
      ));
    }
  }
}
