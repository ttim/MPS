package jetbrains.mps.baseLanguage.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.runconfigs.BaseRunConfig;
import com.intellij.util.xmlb.annotations.Tag;
import com.intellij.openapi.project.Project;
import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.execution.configurations.RuntimeConfigurationException;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SNodePointer;
import jetbrains.mps.baseLanguage.behavior.ClassConcept_Behavior;
import jetbrains.mps.baseLanguage.util.plugin.run.ConfigRunParameters;
import com.intellij.execution.configurations.RunProfileState;
import org.jetbrains.annotations.NotNull;
import com.intellij.execution.Executor;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.execution.ExecutionException;
import jetbrains.mps.plugins.pluginparts.runconfigs.BaseRunProfileState;
import org.jetbrains.annotations.Nullable;
import com.intellij.execution.ExecutionResult;
import com.intellij.execution.runners.ProgramRunner;
import com.intellij.execution.impl.ConsoleViewImpl;
import jetbrains.mps.debug.info.StacktraceUtil;
import jetbrains.mps.workbench.MPSDataKeys;
import javax.swing.JComponent;
import java.util.List;
import com.intellij.openapi.actionSystem.AnAction;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import com.intellij.execution.process.ProcessHandler;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.baseLanguage.util.plugin.run.RunUtil;
import java.util.Collections;
import jetbrains.mps.baseLanguage.util.plugin.run.ClassRunner;
import com.intellij.openapi.util.Disposer;
import com.intellij.execution.process.ProcessNotCreatedException;
import jetbrains.mps.ide.actions.DefaultProcessHandler;
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

public class DefaultJavaApplication_Configuration extends BaseRunConfig {
  @Tag(value = "state")
  private DefaultJavaApplication_Configuration.MyState myState = new DefaultJavaApplication_Configuration.MyState();

  public DefaultJavaApplication_Configuration(Project p, ConfigurationFactory f, String name) {
    super(p, f, name);
  }

  public RunConfiguration clone() {
    try {
      DefaultJavaApplication_Configuration result = ((DefaultJavaApplication_Configuration) super.clone());
      result.myState = ((DefaultJavaApplication_Configuration.MyState) this.myState.clone());
      return result;
    } catch (CloneNotSupportedException e) {
      return null;
    }
  }

  public void checkConfiguration() throws RuntimeConfigurationException {
    final StringBuilder error = new StringBuilder();
    {
      if (DefaultJavaApplication_Configuration.this.getStateObject().modelId != null && DefaultJavaApplication_Configuration.this.getStateObject().nodeId != null) {
        ModelAccess.instance().runReadAction(new Runnable() {
          public void run() {
            SNode node = null;
            node = new SNodePointer(DefaultJavaApplication_Configuration.this.getStateObject().modelId, DefaultJavaApplication_Configuration.this.getStateObject().nodeId).getNode();
            if ((node == null)) {
              error.append("node is not selected or does not exist").append("\n");
            }
            if ((ClassConcept_Behavior.call_getMainMethod_1213877355884(node) == null)) {
              error.append("node is not valid").append("\n");
            }
          }
        });
      } else {
        error.append("node is not selected").append("\n");
      }

      if (DefaultJavaApplication_Configuration.this.getStateObject().parameters == null) {
        DefaultJavaApplication_Configuration.this.getStateObject().parameters = new ConfigRunParameters();
      }
      String paramsReport = DefaultJavaApplication_Configuration.this.getStateObject().parameters.getErrorReport();
      if (paramsReport != null) {
        error.append(paramsReport).append("\n");
      }
      if (!(DefaultJavaApplication_Configuration.this.getStateObject().compileInMPS) && DefaultJavaApplication_Configuration.this.getStateObject().parameters != null && DefaultJavaApplication_Configuration.this.getStateObject().parameters.getMake()) {
        error.append("can't make").append("\n");
      }
    }
    if (error.length() != 0) {
      throw new RuntimeConfigurationException(error.toString());
    }
  }

  public RunProfileState getState(@NotNull final Executor executor, @NotNull final ExecutionEnvironment environment) throws ExecutionException {
    return new BaseRunProfileState() {
      @Nullable
      public ExecutionResult execute(Executor executor, @NotNull ProgramRunner runner) throws ExecutionException {
        final ConsoleViewImpl consoleView = StacktraceUtil.createConsoleView(MPSDataKeys.PROJECT.getData(environment.getDataContext()));
        JComponent consoleComponent = null;
        Runnable consoleDispose = null;
        final List<AnAction> actions = ListSequence.fromList(new ArrayList<AnAction>());
        ProcessHandler handler = null;
        Project project = MPSDataKeys.PROJECT.getData(environment.getDataContext());

        // user's execute code 
        if (DefaultJavaApplication_Configuration.this.getStateObject().modelId == null || DefaultJavaApplication_Configuration.this.getStateObject().nodeId == null) {
          throw new ExecutionException("Class node is not defined");
        }
        final Wrappers._T<SNode> node = new Wrappers._T<SNode>();
        ModelAccess.instance().runReadAction(new Runnable() {
          public void run() {
            node.value = new SNodePointer(DefaultJavaApplication_Configuration.this.getStateObject().modelId, DefaultJavaApplication_Configuration.this.getStateObject().nodeId).getNode();
          }
        });
        if (node.value == null) {
          throw new ExecutionException("Class node does not exist");
        }

        if (DefaultJavaApplication_Configuration.this.getStateObject().parameters == null) {
          DefaultJavaApplication_Configuration.this.getStateObject().parameters = new ConfigRunParameters();
        }

        if (DefaultJavaApplication_Configuration.this.getStateObject().parameters.getMake()) {
          RunUtil.makeBeforeRun(project, Collections.singletonList(node.value));
        }

        final ClassRunner classRunner = new ClassRunner();
        ListSequence.fromList(actions).addSequence(ListSequence.fromList(ListSequence.fromListAndArray(new ArrayList<AnAction>(), consoleView.createConsoleActions())));
        consoleComponent = consoleView.getComponent();
        consoleDispose = new Runnable() {
          public void run() {
            Disposer.dispose(consoleView);
          }
        };

        final Wrappers._T<Process> process = new Wrappers._T<Process>();
        final Wrappers._T<ProcessNotCreatedException> ex = new Wrappers._T<ProcessNotCreatedException>(null);
        ModelAccess.instance().runReadAction(new Runnable() {
          public void run() {
            if (DefaultJavaApplication_Configuration.this.getStateObject().parameters.getUseAlternativeJRE()) {
              classRunner.setJavaHomePath(DefaultJavaApplication_Configuration.this.getStateObject().parameters.getAlternativeJRE());
            }
            try {
              process.value = classRunner.run(node.value, DefaultJavaApplication_Configuration.this.getStateObject().parameters.getProgramParameters(), DefaultJavaApplication_Configuration.this.getStateObject().parameters.getVMParameters(), DefaultJavaApplication_Configuration.this.getStateObject().parameters.getWorkingDirectory());
            } catch (ProcessNotCreatedException e) {
              ex.value = e;
            }
          }
        });
        if (ex.value != null) {
          throw ex.value;
        }

        handler = new DefaultProcessHandler(consoleView, process.value, classRunner.getCommandString());

        final JComponent finalConsoleComponent = consoleComponent;
        final Runnable finalConsoleDispose = consoleDispose;
        final ProcessHandler finalHandler = handler;
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
            return ListSequence.fromList(actions).toGenericArray(AnAction.class);
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
    return new DefaultJavaApplication_Configuration.MySettingsEditor();
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

  public DefaultJavaApplication_Configuration.MyState getStateObject() {
    return this.myState;
  }

  private static class MySettingsEditor extends SettingsEditor<DefaultJavaApplication_Configuration> {
    private JavaAppConfigEditor myComponent = null;

    public MySettingsEditor() {
    }

    protected void resetEditorFrom(DefaultJavaApplication_Configuration c) {
      MySettingsEditor.this.myComponent.reset(c);
    }

    protected void applyEditorTo(DefaultJavaApplication_Configuration c) {
      MySettingsEditor.this.myComponent.apply(c);
    }

    @NotNull
    protected JComponent createEditor() {
      this.myComponent = new JavaAppConfigEditor();
      return this.myComponent;
    }

    protected void disposeEditor() {
      MySettingsEditor.this.myComponent.dispose();
    }
  }

  public static class MyState implements Cloneable {
    public String nodeId;
    public String modelId;
    public boolean compileInMPS;
    public ConfigRunParameters parameters;

    public MyState() {
    }

    public Object clone() throws CloneNotSupportedException {
      DefaultJavaApplication_Configuration.MyState object = (DefaultJavaApplication_Configuration.MyState) super.clone();
      if (this.parameters != null) {
        object.parameters = (ConfigRunParameters) this.parameters.clone();
      }
      return object;
    }
  }
}
