package jetbrains.mps.baseLanguage.unitTest.execution.tool;

/*Generated by MPS */

import jetbrains.mps.util.annotation.ToRemove;
import jetbrains.mps.baseLanguage.unitTest.execution.client.TestRunState;
import jetbrains.mps.baseLanguage.unitTest.execution.client.TestEventsDispatcher;
import jetbrains.mps.execution.configurations.deprecated.runtime.ConfigRunParameters;
import java.util.List;
import jetbrains.mps.baseLanguage.unitTest.execution.client.ITestNodeWrapper;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import com.intellij.execution.process.ProcessHandler;
import jetbrains.mps.smodel.ModelAccess;
import com.intellij.execution.ExecutionException;
import jetbrains.mps.execution.api.commands.OutputRedirector;
import jetbrains.mps.baseLanguage.unitTest.execution.client.Junit_Command;
import java.io.File;
import jetbrains.mps.baseLanguage.unitTest.execution.client.UnitTestProcessListener;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;


/**
 * Use junit command to start tests
 */
@Deprecated
@ToRemove(version = 2.1)
public class UnitTestExecutionController {
  private final TestRunState myState;
  private final TestEventsDispatcher myDispatcher;
  private final ConfigRunParameters myConfigurationRunParameters;
  private final List<ITestNodeWrapper> myWhatToTest = ListSequence.fromList(new ArrayList<ITestNodeWrapper>());
  private ProcessHandler myCurrentProcess;

  @Deprecated
  public UnitTestExecutionController(final List<ITestNodeWrapper> whatToTest, ConfigRunParameters configurationRunParameters) {
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        ListSequence.fromList(myWhatToTest).addSequence(ListSequence.fromList(whatToTest));
      }
    });
    myState = new TestRunState(myWhatToTest);
    myDispatcher = new TestEventsDispatcher(myState);
    myConfigurationRunParameters = configurationRunParameters;
  }

  public TestRunState getState() {
    return myState;
  }

  public ProcessHandler execute() throws ExecutionException {
    if (ListSequence.fromList(myWhatToTest).isEmpty()) {
      throw new ExecutionException("Nothing to test.");
    }

    String workingDir = myConfigurationRunParameters.getWorkingDirectory();
    myCurrentProcess = OutputRedirector.redirect(new Junit_Command().setJrePath_String(myConfigurationRunParameters.getAlternativeJRE()).setVirtualMachineParameter_String(myConfigurationRunParameters.getVMParameters()).setWorkingDirectory_File(((workingDir != null && workingDir.length() > 0) ?
      new File(workingDir) :
      null
    )).createProcess(myWhatToTest), new UnitTestProcessListener(myDispatcher));

    if (myCurrentProcess == null) {
      myState.terminate();
      return null;
    }

    return myCurrentProcess;
  }

  public _FunctionTypes._void_P0_E0 getCloseListener() {
    final ProcessHandler process = myCurrentProcess;
    return new _FunctionTypes._void_P0_E0() {
      public void invoke() {
        if (process != null) {
          process.destroyProcess();
        }
      }
    };
  }
}
