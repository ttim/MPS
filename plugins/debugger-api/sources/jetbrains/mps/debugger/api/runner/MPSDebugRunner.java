package jetbrains.mps.debugger.api.runner;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.ExecutionResult;
import com.intellij.execution.Executor;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.execution.configurations.RunProfile;
import com.intellij.execution.configurations.RunProfileState;
import com.intellij.execution.executors.DefaultDebugExecutor;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.execution.runners.GenericProgramRunner;
import com.intellij.execution.ui.RunContentDescriptor;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.project.Project;
import jetbrains.mps.debug.api.*;
import jetbrains.mps.debug.api.run.DebuggerRunProfileState;
import jetbrains.mps.debugger.api.ui.tool.DebuggerToolContentBuilder;
import jetbrains.mps.execution.runtime.BaseMpsRunConfiguration;
import jetbrains.mps.plugins.pluginparts.runconfigs.BaseRunConfig;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MPSDebugRunner extends GenericProgramRunner {

  public boolean canRun(@NotNull final String executorId, @NotNull final RunProfile profile) {
    return executorId.equals(DefaultDebugExecutor.EXECUTOR_ID) &&
      (isOldRunConfiguration(profile) || isNewRunConfiguration(profile));
  }

  private boolean isOldRunConfiguration(RunProfile profile) {
    return (profile instanceof BaseRunConfig) && (((BaseRunConfig) profile).isDebuggable());
  }

  private boolean isNewRunConfiguration(RunProfile profile) {
    return (profile instanceof BaseMpsRunConfiguration) && (((BaseMpsRunConfiguration) profile).canExecute(DefaultDebugExecutor.EXECUTOR_ID));
  }

  @NotNull
  public String getRunnerId() {
    return "Default Debug Runner";
  }

  protected RunContentDescriptor doExecute(final Project project, final Executor executor, final RunProfileState state, final RunContentDescriptor contentToReuse,
                                           final ExecutionEnvironment env) throws ExecutionException {
    // FileDocumentManager.getInstance().saveAllDocuments();
    return createContentDescriptor(project, executor, state, contentToReuse, env);
  }

  @Nullable
  protected RunContentDescriptor createContentDescriptor(Project project, Executor executor, RunProfileState state,
                                                         RunContentDescriptor contentToReuse,
                                                         ExecutionEnvironment env) throws ExecutionException {
    IDebugger debugger;
    //todo get connection settings
    if (state instanceof DebuggerRunProfileState) {
      debugger = ((DebuggerRunProfileState) state).getDebugger();
    } else {
      throw new ExecutionException("Unknown Run Profile State");
    }
    if (debugger == null) {
      throw new ExecutionException("Can't Start Debugger");
    }
    AbstractDebugSessionCreator debugSessionCreator = debugger.createDebugSessionCreator(project);
    ExecutionResult executionResult = debugSessionCreator.startSession(executor, this, state, project);
    AbstractDebugSession debugSession = debugSessionCreator.getDebugSession();
    DebugSessionManagerComponent.getInstance(project).addDebugSession(debugSession);
    DebuggerToolContentBuilder contentBuilder = new DebuggerToolContentBuilder(project, this, executor, executionResult, env);
    return contentBuilder.showRunContent(contentToReuse);
  }


  public SettingsEditor getSettingsEditor(final Executor executor, RunConfiguration configuration) {
    return null;
  }
}
