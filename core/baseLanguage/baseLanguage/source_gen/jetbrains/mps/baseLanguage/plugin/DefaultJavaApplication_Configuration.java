package jetbrains.mps.baseLanguage.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.runconfigs.BaseRunConfig;
import com.intellij.util.xmlb.annotations.Tag;
import com.intellij.openapi.project.Project;
import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.execution.configurations.RuntimeConfigurationException;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.smodel.SNodePointer;
import com.intellij.execution.configurations.RunProfileState;
import org.jetbrains.annotations.NotNull;
import com.intellij.execution.Executor;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.execution.ExecutionException;
import org.jetbrains.annotations.Nullable;
import com.intellij.execution.ExecutionResult;
import com.intellij.execution.runners.ProgramRunner;
import javax.swing.JComponent;
import java.util.List;
import com.intellij.openapi.actionSystem.AnAction;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import com.intellij.execution.process.ProcessHandler;
import jetbrains.mps.workbench.MPSDataKeys;
import jetbrains.mps.project.MPSProject;
import jetbrains.mps.MPSProjectHolder;
import jetbrains.mps.generator.GeneratorManager;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.generator.ModelGenerationStatusManager;
import jetbrains.mps.generator.IGenerationType;
import java.nio.charset.Charset;
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
      DefaultJavaApplication_Configuration result = ((DefaultJavaApplication_Configuration)super.clone());
      result.myState = ((DefaultJavaApplication_Configuration.MyState)this.myState.clone());
      return result;
    } catch (CloneNotSupportedException e) {
      return null;
    }
  }

  public void checkConfiguration() throws RuntimeConfigurationException {
    StringBuilder error = new StringBuilder();
    {
      final Wrappers._T<SNode> node = new Wrappers._T<SNode>(null);
      if (DefaultJavaApplication_Configuration.this.getStateObject().modelId != null && DefaultJavaApplication_Configuration.this.getStateObject().nodeId != null) {
        ModelAccess.instance().runReadAction(new Runnable() {
          public void run() {
            node.value = new SNodePointer(DefaultJavaApplication_Configuration.this.getStateObject().modelId, DefaultJavaApplication_Configuration.this.getStateObject().nodeId).getNode();
          }
        });
      }
      if (node.value == null) {
        error.append("node is not selected or does not exist").append("\n");
      }

      if (DefaultJavaApplication_Configuration.this.getStateObject().parameters == null) {
        DefaultJavaApplication_Configuration.this.getStateObject().parameters = new RunParameters();
      }
      String paramsReport = DefaultJavaApplication_Configuration.this.getStateObject().parameters.getErrorReport();
      if (paramsReport != null) {
        error.append(paramsReport).append("\n");
      }
    }
    if (error.length() != 0) {
      throw new RuntimeConfigurationException(error.toString());
    }
  }

  public RunProfileState getState(@NotNull final Executor executor, @NotNull final ExecutionEnvironment environment) throws ExecutionException {
    return new RunProfileState() {
      @Nullable
      public ExecutionResult execute(Executor executor, @NotNull ProgramRunner runner) throws ExecutionException {
        JComponent consoleComponent;
        Runnable consoleDispose = null;
        final List<AnAction> actions = ListSequence.fromList(new ArrayList<AnAction>());
        ProcessHandler handler = null;
        {
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

          Project project = MPSDataKeys.PROJECT.getData(environment.getDataContext());
          MPSProject mpsProject = project.getComponent(MPSProjectHolder.class).getMPSProject();

          if (DefaultJavaApplication_Configuration.this.getStateObject().parameters == null) {
            DefaultJavaApplication_Configuration.this.getStateObject().parameters = new RunParameters();
          }

          if (DefaultJavaApplication_Configuration.this.getStateObject().parameters.getMake()) {
            GeneratorManager genManager = mpsProject.getComponent(GeneratorManager.class);
            final Wrappers._T<SModelDescriptor> md = new Wrappers._T<SModelDescriptor>();
            ModelAccess.instance().runReadAction(new Runnable() {
              public void run() {
                md.value = SNodeOperations.getModel(node.value).getModelDescriptor();
              }
            });
            if (ModelGenerationStatusManager.getInstance().generationRequired(md.value)) {
              genManager.generateModelsFromDifferentModules(mpsProject.createOperationContext(), ListSequence.fromListAndArray(new ArrayList<SModelDescriptor>(), md.value), IGenerationType.FILES);
            }
          }

          final RunComponent runComponent = new RunComponent(project);
          final ClassRunner classRunner = new ClassRunner(runComponent);

          ListSequence.fromList(actions).addSequence(ListSequence.fromList(ListSequence.fromListAndArray(new ArrayList<AnAction>(), runComponent.getConsoleView().createConsoleActions())));
          consoleComponent = runComponent;
          consoleDispose = new Runnable() {
            public void run() {
              runComponent.dispose();
            }
          };

          final Wrappers._T<Process> process = new Wrappers._T<Process>();
          ModelAccess.instance().runReadAction(new Runnable() {
            public void run() {
              if (DefaultJavaApplication_Configuration.this.getStateObject().parameters.getUseAlternativeJRE()) {
                classRunner.setJavaHomePath(DefaultJavaApplication_Configuration.this.getStateObject().parameters.getAlternativeJRE());
              }
              process.value = classRunner.run(node.value, DefaultJavaApplication_Configuration.this.getStateObject().parameters.getProgramParameters(), DefaultJavaApplication_Configuration.this.getStateObject().parameters.getVMParameters(), DefaultJavaApplication_Configuration.this.getStateObject().parameters.getWorkingDirectory());
            }
          });

          handler = new BLProcessHandler(runComponent, process.value, "", Charset.defaultCharset());
        }
        final JComponent finalConsoleComponent = consoleComponent;
        final Runnable finalConsoleDispose = consoleDispose;
        final ProcessHandler finalHandler = handler;
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
    XmlSerializer.deserializeInto(this.myState, ((Element)e.getChildren().get(0)));
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
    }
  }

  public static class MyState implements Cloneable {
    public String nodeId;
    public String modelId;
    public RunParameters parameters;

    public MyState() {
    }

    public Object clone() throws CloneNotSupportedException {
      DefaultJavaApplication_Configuration.MyState object = (DefaultJavaApplication_Configuration.MyState)super.clone();
      if (parameters != null) {
        object.parameters = (RunParameters)this.parameters.clone();
      }
      return object;
    }
  }
}
