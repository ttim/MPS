package jetbrains.mps.build.packaging.plugin;

/*Generated by MPS */

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
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import java.io.File;
import jetbrains.mps.execution.lib.Java_Command;
import org.apache.commons.lang.StringUtils;
import jetbrains.mps.reloading.CommonPaths;
import com.intellij.execution.process.ProcessHandler;
import jetbrains.mps.buildlanguage.plugin.Ant_Command;
import com.intellij.execution.ui.ConsoleView;
import jetbrains.mps.execution.api.configurations.ConsoleCreator;
import jetbrains.mps.execution.api.configurations.ConsoleProcessListener;
import jetbrains.mps.execution.api.configurations.DefaultExecutionResult;
import jetbrains.mps.execution.api.configurations.DefaultExecutionConsole;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import com.intellij.execution.executors.DefaultRunExecutor;

public class PackagingBuildScript_Configuration_RunProfileState implements RunProfileState {
  @NotNull
  private final PackagingBuildScript_Configuration myRunConfiguration;
  @NotNull
  private final ExecutionEnvironment myEnvironment;

  public PackagingBuildScript_Configuration_RunProfileState(@NotNull PackagingBuildScript_Configuration configuration, @NotNull Executor executor, @NotNull ExecutionEnvironment environment) {
    myRunConfiguration = configuration;
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
    String options = myRunConfiguration.getSettings().getAntOptions();
    final Wrappers._boolean compile = new Wrappers._boolean();
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        compile.value = SPropertyOperations.getBoolean(SNodeOperations.cast(myRunConfiguration.getNode().getNode(), "jetbrains.mps.build.packaging.structure.Layout"), "compile");
      }
    });
    if (compile.value) {
      // we need to add tools jar 
      if (!(new File(Java_Command.getJdkHome() + File.separator + "lib" + File.separator + "tools.jar").exists())) {
        options = ((StringUtils.isEmpty(options) ?
          "" :
          options + " "
        )) + "-lib " + CommonPaths.getToolsJar();
      }
    }

    {
      ProcessHandler _processHandler = new Ant_Command().setAntLocation((myRunConfiguration.getSettings().getUseOtherAntLocation() ?
        myRunConfiguration.getSettings().getOtherAntLocation() :
        null
      )).setOptions(options).createProcess(GenerateBuildUtil.getGeneratedFilePath(myRunConfiguration.getConfiguration()));
      final ConsoleView _consoleView = ConsoleCreator.createConsoleView(project, false);
      _processHandler.addProcessListener(new ConsoleProcessListener(_consoleView));
      return new DefaultExecutionResult(_processHandler, new DefaultExecutionConsole(_consoleView.getComponent(), new _FunctionTypes._void_P0_E0() {
        public void invoke() {
          _consoleView.dispose();
        }
      }));
    }
  }

  public static boolean canExecute(String executorId) {
    if (DefaultRunExecutor.EXECUTOR_ID.equals(executorId)) {
      return true;
    }
    return false;
  }
}
