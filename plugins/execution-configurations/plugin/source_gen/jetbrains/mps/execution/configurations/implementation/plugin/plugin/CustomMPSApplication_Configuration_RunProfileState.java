package jetbrains.mps.execution.configurations.implementation.plugin.plugin;

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
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.smodel.behaviour.BehaviorManager;
import java.io.File;
import com.intellij.execution.process.ProcessHandler;
import jetbrains.mps.ant.execution.Ant_Command;
import com.intellij.execution.ui.ConsoleView;
import jetbrains.mps.execution.api.configurations.ConsoleCreator;
import jetbrains.mps.execution.api.configurations.ConsoleProcessListener;
import jetbrains.mps.execution.api.configurations.DefaultExecutionResult;
import jetbrains.mps.execution.api.configurations.DefaultExecutionConsole;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import com.intellij.execution.executors.DefaultRunExecutor;

public class CustomMPSApplication_Configuration_RunProfileState implements RunProfileState {
  @NotNull
  private final CustomMPSApplication_Configuration myRunConfiguration;
  @NotNull
  private final ExecutionEnvironment myEnvironment;

  public CustomMPSApplication_Configuration_RunProfileState(@NotNull CustomMPSApplication_Configuration configuration, @NotNull Executor executor, @NotNull ExecutionEnvironment environment) {
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
    final SNode configuration = myRunConfiguration.getConfiguration();
    final SNode layout = SNodeOperations.cast(myRunConfiguration.getNode().getNode(), "jetbrains.mps.build.packaging.structure.Layout");

    if (configuration == null) {
      throw new ExecutionException("Configuration not selected.");
    }

    final Wrappers._boolean isMPSBuildIncluded = new Wrappers._boolean();
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        SNode mpsbuild = ListSequence.fromList(SNodeOperations.getDescendants(layout, "jetbrains.mps.build.custommps.structure.MPSBuild", false, new String[]{})).first();
        isMPSBuildIncluded.value = ((Boolean) BehaviorManager.getInstance().invoke(Boolean.class, SNodeOperations.cast(mpsbuild, "jetbrains.mps.build.packaging.structure.AbstractProjectComponent"), "call_included_1213877333807", new Class[]{SNode.class, SNode.class}, configuration));
      }
    });

    File file = new File(GenerateBuildUtil.getGeneratedFilePath(configuration));
    // if MPSBuild was included into this configuration we should run different build file 

    {
      ProcessHandler _processHandler = new Ant_Command().setAntLocation_String((myRunConfiguration.getSettings().getUseOtherAntLocation() ?
        myRunConfiguration.getSettings().getOtherAntLocation() :
        null
      )).setOptions_String(myRunConfiguration.getSettings().getAntOptions()).createProcess(file.getAbsolutePath());
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
