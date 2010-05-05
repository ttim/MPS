package jetbrains.mps.baseLanguage.unitTest.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.runconfigs.BaseRunConfig;
import com.intellij.util.xmlb.annotations.Tag;
import com.intellij.openapi.project.Project;
import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.execution.configurations.RuntimeConfigurationException;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.project.MPSProject;
import jetbrains.mps.workbench.MPSDataKeys;
import com.intellij.ide.DataManager;
import com.intellij.execution.configurations.RuntimeConfigurationError;
import jetbrains.mps.logging.Logger;
import com.intellij.execution.configurations.RunProfileState;
import org.jetbrains.annotations.NotNull;
import com.intellij.execution.Executor;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.execution.ExecutionException;
import jetbrains.mps.baseLanguage.runConfigurations.runtime.JavaRunProfileState;
import org.jetbrains.annotations.Nullable;
import com.intellij.execution.ExecutionResult;
import com.intellij.execution.runners.ProgramRunner;
import com.intellij.execution.impl.ConsoleViewImpl;
import jetbrains.mps.debug.info.StacktraceUtil;
import javax.swing.JComponent;
import java.util.List;
import com.intellij.openapi.actionSystem.AnAction;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import com.intellij.execution.process.ProcessHandler;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.baseLanguage.util.plugin.run.ConfigRunParameters;
import com.intellij.execution.executors.DefaultDebugExecutor;
import jetbrains.mps.debug.DebuggerKeys;
import org.apache.commons.lang.StringUtils;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.util.plugin.run.RunUtil;
import jetbrains.mps.baseLanguage.tuples.runtime.Tuples;
import jetbrains.mps.baseLanguage.tuples.runtime.MultiTuple;
import com.intellij.execution.ui.ExecutionConsole;
import com.intellij.execution.configurations.RunnerSettings;
import com.intellij.execution.configurations.ConfigurationPerRunnerSettings;
import com.intellij.openapi.util.JDOMExternalizable;
import com.intellij.execution.configurations.ConfigurationInfoProvider;
import com.intellij.openapi.options.SettingsEditor;
import org.jdom.Element;
import com.intellij.openapi.util.WriteExternalException;
import com.intellij.util.xmlb.XmlSerializer;
import com.intellij.openapi.util.InvalidDataException;

public class DefaultJUnit_Configuration extends BaseRunConfig {
  @Tag(value = "state")
  private DefaultJUnit_Configuration.MyState myState = new DefaultJUnit_Configuration.MyState();

  public DefaultJUnit_Configuration(Project p, ConfigurationFactory f, String name) {
    super(p, f, name);
  }

  public RunConfiguration clone() {
    try {
      DefaultJUnit_Configuration result = ((DefaultJUnit_Configuration) super.clone());
      result.myState = ((DefaultJUnit_Configuration.MyState) this.myState.clone());
      return result;
    } catch (CloneNotSupportedException e) {
      return null;
    }
  }

  public void checkConfiguration() throws RuntimeConfigurationException {
    final StringBuilder error_22042010 = new StringBuilder();
    try {
      String paramsReport = DefaultJUnit_Configuration.this.getStateObject().myJavaRunParameters.getErrorReport();
      if (paramsReport != null) {
        error_22042010.append(paramsReport).append("\n");
      }
      if (DefaultJUnit_Configuration.this.getStateObject().type != null) {
        final Wrappers._T<String> errorReport = new Wrappers._T<String>();
        ModelAccess.instance().runReadAction(new Runnable() {
          public void run() {
            errorReport.value = DefaultJUnit_Configuration.this.getStateObject().type.check(DefaultJUnit_Configuration.this);
          }
        });
        MPSProject mpsProject = MPSDataKeys.MPS_PROJECT.getData(DataManager.getInstance().getDataContext());
        if (DefaultJUnit_Configuration.this.collectWhatToTest(mpsProject).isEmpty()) {
          errorReport.value = "could not find tests to run";
        }
        if (errorReport.value != null) {
          error_22042010.append(errorReport.value).append("\n");
        }
      }
    } catch (Throwable t_22042010) {
      if (t_22042010 instanceof RuntimeConfigurationException) {
        throw (RuntimeConfigurationException) t_22042010;
      }
      if (t_22042010 instanceof RuntimeConfigurationError) {
        throw (RuntimeConfigurationError) t_22042010;
      }
      Logger.getLogger(DefaultJUnit_Configuration.class).error(t_22042010);
    }
    if (error_22042010.length() != 0) {
      throw new RuntimeConfigurationException(error_22042010.toString());
    }
  }

  public RunProfileState getState(@NotNull final Executor executor, @NotNull final ExecutionEnvironment environment) throws ExecutionException {
    return new JavaRunProfileState() {
      @Nullable
      public ExecutionResult execute(Executor executor, @NotNull ProgramRunner runner) throws ExecutionException {
        final ConsoleViewImpl consoleView_22042010 = StacktraceUtil.createConsoleView(MPSDataKeys.PROJECT.getData(environment.getDataContext()));
        JComponent consoleComponent_22042010 = null;
        Runnable consoleDispose_22042010 = null;
        final List<AnAction> actions_22042010 = ListSequence.fromList(new ArrayList<AnAction>());
        ProcessHandler handler_22042010 = null;
        final Project project = MPSDataKeys.PROJECT.getData(environment.getDataContext());
        final MPSProject mpsProject = MPSDataKeys.MPS_PROJECT.getData(environment.getDataContext());
        final IOperationContext operationContext = MPSDataKeys.OPERATION_CONTEXT.getData(environment.getDataContext());

        // user's execute code 
        try {
          final ConfigRunParameters javaRunParameters = DefaultJUnit_Configuration.this.getStateObject().myJavaRunParameters.copy();
          // add debug arguments if runned under debug 
          if (executor.getId().equals(DefaultDebugExecutor.EXECUTOR_ID)) {
            String args = this.getUserData(DebuggerKeys.CONNECTION_SETTINGS);
            String oldVmParams = javaRunParameters.getVMParameters();
            if (StringUtils.isNotEmpty(oldVmParams)) {
              oldVmParams += " ";
            } else {
              oldVmParams = "";
            }
            javaRunParameters.setVMParameters(oldVmParams + args);
          }
          {
            // calculate parameter 
            final UnitTestExecutionController parameter = new _FunctionTypes._return_P0_E0<UnitTestExecutionController>() {
              public UnitTestExecutionController invoke() {
                List<SNode> stuffToTest = DefaultJUnit_Configuration.this.collectWhatToTest(mpsProject);

                if (javaRunParameters.getMake()) {
                  RunUtil.makeBeforeRun(project, stuffToTest);
                }

                return new UnitTestExecutionController(stuffToTest, javaRunParameters);
              }
            }.invoke();

            ListSequence.fromList(actions_22042010).addSequence(ListSequence.fromList(new _FunctionTypes._return_P0_E0<List<AnAction>>() {
              public List<AnAction> invoke() {
                {
                  final List<AnAction> actionsList = ListSequence.fromListAndArray(new ArrayList<AnAction>(), consoleView_22042010.createConsoleActions());
                  // we are not interested in default actions 
                  ListSequence.fromList(actionsList).clear();
                  return actionsList;
                }
              }
            }.invoke()));

            // create console component 
            final Tuples._2<JComponent, _FunctionTypes._void_P0_E0> component = (Tuples._2<JComponent, _FunctionTypes._void_P0_E0>) (new _FunctionTypes._return_P0_E0<Tuples._2<JComponent, _FunctionTypes._void_P0_E0>>() {
              public Tuples._2<JComponent, _FunctionTypes._void_P0_E0> invoke() {
                final UnitTestViewComponent runComponent = new UnitTestViewComponent(project, operationContext, consoleView_22042010, parameter);
                return MultiTuple.<JComponent,_FunctionTypes._void_P0_E0>from((JComponent) runComponent, new _FunctionTypes._void_P0_E0() {
                  public void invoke() {
                    runComponent.dispose();
                  }
                });
              }
            }.invoke());
            consoleComponent_22042010 = component._0();
            consoleDispose_22042010 = new Runnable() {
              public void run() {
                component._1().invoke();
              }
            };

            final Wrappers._T<ExecutionException> ex = new Wrappers._T<ExecutionException>(null);
            // create process handler 
            handler_22042010 = (ProcessHandler) new _FunctionTypes._return_P0_E0<ProcessHandler>() {
              public ProcessHandler invoke() {
                try {
                  return parameter.execute();
                } catch (ExecutionException e) {
                  ex.value = e;
                  return null;
                }
              }
            }.invoke();
            if (ex.value != null) {
              throw ex.value;
            }
          }
        } catch (Throwable t) {
          if (t instanceof ExecutionException) {
            throw (ExecutionException) t;
          } else {
            Logger.getLogger(DefaultJUnit_Configuration.class).error(t);
            throw new ExecutionException("Execution code threw an exception: " + t.getMessage(), t);
          }
        }

        final JComponent finalConsoleComponent = consoleComponent_22042010;
        final Runnable finalConsoleDispose = consoleDispose_22042010;
        final ProcessHandler finalHandler = handler_22042010;
        if (finalHandler == null) {
          return null;
        }
        return new ExecutionResult() {
          public ExecutionConsole getExecutionConsole() {
            return new ExecutionConsole() {
              public void dispose() {
                if (finalConsoleDispose == null) {
                  return;
                }
                finalConsoleDispose.run();
              }

              public JComponent getComponent() {
                return finalConsoleComponent;
              }

              public JComponent getPreferredFocusableComponent() {
                return finalConsoleComponent;
              }
            };
          }

          public AnAction[] getActions() {
            return ListSequence.fromList(actions_22042010).toGenericArray(AnAction.class);
          }

          public ProcessHandler getProcessHandler() {
            return finalHandler;
          }
        };
      }

      public RunnerSettings getRunnerSettings() {
        return null;
      }

      public ConfigurationPerRunnerSettings getConfigurationSettings() {
        return null;
      }
    };
  }

  public JDOMExternalizable createRunnerSettings(ConfigurationInfoProvider p0) {
    return null;
  }

  public SettingsEditor<? extends RunConfiguration> getConfigurationEditor() {
    return new DefaultJUnit_Configuration.MySettingsEditor();
  }

  @Nullable
  public SettingsEditor<JDOMExternalizable> getRunnerSettingsEditor(ProgramRunner p0) {
    return null;
  }

  public void writeExternal(Element e) throws WriteExternalException {
    e.addContent(XmlSerializer.serialize(this.myState));
  }

  public void readExternal(Element e) throws InvalidDataException {
    XmlSerializer.deserializeInto(this.myState, ((Element) e.getChildren().get(0)));
  }

  public DefaultJUnit_Configuration.MyState getStateObject() {
    return this.myState;
  }

  public boolean isDebuggable() {
    return true;
  }

  private List<SNode> collectWhatToTest(final MPSProject mpsProject) {
    final List<SNode> all = new ArrayList<SNode>();
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        if (DefaultJUnit_Configuration.this.getStateObject().type != null) {
          ListSequence.fromList(all).addSequence(ListSequence.fromList(DefaultJUnit_Configuration.this.getStateObject().type.collect(DefaultJUnit_Configuration.this, mpsProject)));
        }
      }
    });
    return all;
  }

  private static class MySettingsEditor extends SettingsEditor<DefaultJUnit_Configuration> {
    private DefaultJUnit_Editor myComponent = null;

    public MySettingsEditor() {
    }

    protected void resetEditorFrom(DefaultJUnit_Configuration c) {
      MySettingsEditor.this.myComponent.reset(c);
      final ConfigRunParameters javaRunParameters = c.getStateObject().myJavaRunParameters;
      MySettingsEditor.this.myComponent.getUsersComponent().reset(c);
    }

    protected void applyEditorTo(DefaultJUnit_Configuration c) {
      MySettingsEditor.this.myComponent.apply(c);
      final ConfigRunParameters javaRunParameters = c.getStateObject().myJavaRunParameters;
      MySettingsEditor.this.myComponent.getUsersComponent().apply(c);
    }

    @NotNull
    protected JComponent createEditor() {
      this.myComponent = new DefaultJUnit_Editor();
      return this.myComponent;
    }

    protected void disposeEditor() {
      MySettingsEditor.this.myComponent.dispose();
      MySettingsEditor.this.myComponent.dispose();
    }
  }

  public static class MyState implements Cloneable {
    public ConfigRunParameters myJavaRunParameters = new ConfigRunParameters();
    public String node;
    public ClonableList<String> nodes = new ClonableList<String>();
    public String model;
    public String module;
    public String method;
    public ClonableList<String> methods = new ClonableList<String>();
    public JUnitRunTypes type;

    public MyState() {
    }

    public Object clone() throws CloneNotSupportedException {
      DefaultJUnit_Configuration.MyState object = (DefaultJUnit_Configuration.MyState) super.clone();
      if (this.myJavaRunParameters != null) {
        object.myJavaRunParameters = (ConfigRunParameters) this.myJavaRunParameters.clone();
      }
      if (this.nodes != null) {
        object.nodes = (ClonableList) this.nodes.clone();
      }
      if (this.methods != null) {
        object.methods = (ClonableList) this.methods.clone();
      }
      return object;
    }
  }
}
