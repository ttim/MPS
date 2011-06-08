package jetbrains.mps.execution.demo.plugin;

/*Generated by MPS */

import jetbrains.mps.debug.api.run.DebuggerRunProfileState;
import com.intellij.execution.configurations.RunProfileState;
import org.jetbrains.annotations.NotNull;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.execution.Executor;
import com.intellij.execution.configurations.ConfigurationPerRunnerSettings;
import com.intellij.execution.configurations.RunnerSettings;
import org.jetbrains.annotations.Nullable;
import com.intellij.execution.ExecutionResult;
import com.intellij.execution.runners.ProgramRunner;
import com.intellij.execution.ExecutionException;
import com.intellij.openapi.project.Project;
import com.intellij.execution.process.ProcessHandler;
import jetbrains.mps.execution.lib.Java_Command;
import com.intellij.execution.impl.ConsoleViewImpl;
import jetbrains.mps.execution.api.configurations.ConsoleProcessListener;
import jetbrains.mps.execution.api.configurations.DefaultExecutionResult;
import jetbrains.mps.execution.api.configurations.DefaultExecutionConsole;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import jetbrains.mps.debug.api.run.IDebuggerConfiguration;
import jetbrains.mps.debug.api.IDebuggerSettings;
import jetbrains.mps.debug.runtime.settings.LocalConnectionSettings;
import jetbrains.mps.debug.api.IDebugger;
import jetbrains.mps.debug.api.Debuggers;
import com.intellij.execution.executors.DefaultRunExecutor;
import com.intellij.execution.executors.DefaultDebugExecutor;

public class DemoApplication_Configuration_RunProfileState extends DebuggerRunProfileState implements RunProfileState {
  @NotNull
  private final DemoApplication_Configuration myConfiguration;
  @NotNull
  private final ExecutionEnvironment myEnvironment;

  public DemoApplication_Configuration_RunProfileState(@NotNull DemoApplication_Configuration configuration, @NotNull Executor executor, @NotNull ExecutionEnvironment environment) {
    myConfiguration = configuration;
    myEnvironment = environment;
  }

  public ConfigurationPerRunnerSettings getConfigurationSettings() {
    return null;
  }

  public RunnerSettings getRunnerSettings() {
    return null;
  }

  @Nullable
  public ExecutionResult execute(Executor executor, @NotNull ProgramRunner runner) throws ExecutionException {
    Project project = myEnvironment.getProject();
    {
      ProcessHandler _processHandler = new Java_Command().setProgramParameter("Julia").setVirtualMachineParameter(myDebuggerSettings.getCommandLine(true)).createProcess(myConfiguration.getNode().getNode());
      final ConsoleViewImpl _consoleView = new ConsoleViewImpl(project, false);
      _processHandler.addProcessListener(new ConsoleProcessListener(_consoleView));
      return new DefaultExecutionResult(_processHandler, new DefaultExecutionConsole(_consoleView.getComponent(), new _FunctionTypes._void_P0_E0() {
        public void invoke() {
          _consoleView.dispose();
        }
      }));
    }
  }

  @NotNull
  public IDebuggerConfiguration getDebuggerConfiguration() {
    return new IDebuggerConfiguration() {
      @Nullable
      public IDebuggerSettings createDebuggerSettings() {
        return new LocalConnectionSettings(true);
      }

      public IDebugger getDebugger() {
        return Debuggers.getInstance().getDebuggerByName("Java");
      }
    };
  }

  public static boolean canExecute(String executorId) {
    if (DefaultRunExecutor.EXECUTOR_ID.equals(executorId)) {
      return true;
    }
    if (DefaultDebugExecutor.EXECUTOR_ID.equals(executorId)) {
      return true;
    }
    return false;
  }
}
