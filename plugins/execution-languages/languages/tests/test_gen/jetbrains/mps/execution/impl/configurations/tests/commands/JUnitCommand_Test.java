package jetbrains.mps.execution.impl.configurations.tests.commands;

/*Generated by MPS */

import jetbrains.mps.MPSLaunch;
import jetbrains.mps.lang.test.runtime.BaseTransformationTest4;
import org.junit.Test;
import jetbrains.mps.lang.test.runtime.BaseTestBody;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.execution.impl.configurations.tests.commands.sandbox.SimpleBTestCase_Test;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.baseLanguage.unitTest.execution.client.ITestNodeWrapper;
import jetbrains.mps.execution.impl.configurations.tests.commands.sandbox.FailedBTestCase_Test;
import java.util.List;
import com.intellij.execution.process.ProcessHandler;
import jetbrains.mps.baseLanguage.unitTest.execution.client.Junit_Command;
import jetbrains.mps.baseLanguage.unitTest.execution.client.TestRunState;
import jetbrains.mps.baseLanguage.unitTest.execution.client.TestEventsDispatcher;
import jetbrains.mps.execution.api.commands.OutputRedirector;
import jetbrains.mps.baseLanguage.unitTest.execution.client.UnitTestProcessListener;
import jetbrains.mps.execution.api.commands.ProcessHandlerBuilder;
import junit.framework.Assert;
import org.apache.commons.lang.StringUtils;
import com.intellij.execution.ExecutionException;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelRepository;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.baseLanguage.unitTest.execution.client.TestNodeWrapperFactory;

@MPSLaunch
public class JUnitCommand_Test extends BaseTransformationTest4 {
  @Test
  public void test_startSimpleBTestCase() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:e2bad6d6-3029-4bc3-b44d-49863f32d863(jetbrains.mps.execution.impl.configurations.tests.commands@tests)");
    this.runTest("jetbrains.mps.execution.impl.configurations.tests.commands.JUnitCommand_Test$TestBody", "test_startSimpleBTestCase", true);
  }

  @Test
  public void test_startFailedBTestCase() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:e2bad6d6-3029-4bc3-b44d-49863f32d863(jetbrains.mps.execution.impl.configurations.tests.commands@tests)");
    this.runTest("jetbrains.mps.execution.impl.configurations.tests.commands.JUnitCommand_Test$TestBody", "test_startFailedBTestCase", true);
  }

  @MPSLaunch
  public static class TestBody extends BaseTestBody {
    public void test_startSimpleBTestCase() throws Exception {
      this.checkTests(this.wrapTests(Sequence.<String>singleton(SimpleBTestCase_Test.class.getSimpleName())), ListSequence.fromList(new ArrayList<ITestNodeWrapper>()));
    }

    public void test_startFailedBTestCase() throws Exception {
      this.checkTests(ListSequence.fromList(new ArrayList<ITestNodeWrapper>()), this.wrapTests(Sequence.<String>singleton(FailedBTestCase_Test.class.getSimpleName())));
    }

    public void checkTests(List<ITestNodeWrapper> success, List<ITestNodeWrapper> failure) {
      try {
        List<ITestNodeWrapper> allTests = ListSequence.fromList(success).union(ListSequence.fromList(failure)).toListSequence();
        ProcessHandler process = new Junit_Command().createProcess(allTests);
        TestRunState runState = new TestRunState(allTests);
        CheckTestStateListener checkListener = new CheckTestStateListener(success, failure);
        runState.addListener(checkListener);
        TestEventsDispatcher eventsDispatcher = new TestEventsDispatcher(runState);
        OutputRedirector.redirect(process, new UnitTestProcessListener(eventsDispatcher));
        // 5 minutes 
        int exitcode = ProcessHandlerBuilder.startAndWait(process, 5 * 60 * 1000);
        if (exitcode > 0) {
          Assert.fail("Exit code is not 0 but " + exitcode);
        } else if (exitcode < 0) {
          Assert.fail("Process running too long.");
        }
        if (StringUtils.isNotEmpty(checkListener.getMessages())) {
          Assert.fail(checkListener.getMessages());
        }
      } catch (ExecutionException e) {
        Assert.fail(e.getMessage());
      }
    }

    public List<ITestNodeWrapper> wrapTests(final Iterable<String> names) {
      final List<ITestNodeWrapper> result = ListSequence.fromList(new ArrayList<ITestNodeWrapper>());
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          SModel model = SModelRepository.getInstance().getModelDescriptor(new SModelReference("jetbrains.mps.execution.impl.configurations.tests.commands.sandbox", "tests")).getSModel();
          for (final String name : Sequence.fromIterable(names)) {
            SNode mainNode = ListSequence.fromList(SModelOperations.getRoots(model, "jetbrains.mps.lang.core.structure.INamedConcept")).findFirst(new IWhereFilter<SNode>() {
              public boolean accept(SNode it) {
                return eq_16es9m_a0a0a0a0a0a0a1a0a0a0a1a3a(SPropertyOperations.getString(it, "name"), name);
              }
            });
            ListSequence.fromList(result).addElement(TestNodeWrapperFactory.tryToWrap(mainNode));
          }
        }
      });
      return result;
    }

    private static boolean eq_16es9m_a0a0a0a0a0a0a1a0a0a0a1a3a(Object a, Object b) {
      return (a != null ?
        a.equals(b) :
        a == b
      );
    }
  }
}
