package jetbrains.mps.build.packaging.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.runconfigs.BaseRunConfig;
import com.intellij.util.xmlb.annotations.Tag;
import com.intellij.openapi.project.Project;
import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.execution.configurations.RuntimeConfigurationException;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.tuples.runtime.Tuples;
import jetbrains.mps.smodel.ModelAccess;
import org.apache.commons.lang.StringUtils;
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
import jetbrains.mps.workbench.MPSDataKeys;
import javax.swing.JComponent;
import java.util.List;
import com.intellij.openapi.actionSystem.AnAction;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import com.intellij.execution.process.ProcessHandler;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.baseLanguage.util.plugin.run.ConfigRunParameters;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import com.intellij.openapi.util.Disposer;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.lang.plugin.run.DefaultProcessHandler;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import java.io.File;
import jetbrains.mps.buildlanguage.plugin.AntScriptRunner;
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
import jetbrains.mps.smodel.SNodePointer;
import com.intellij.openapi.util.Computable;
import jetbrains.mps.baseLanguage.tuples.runtime.MultiTuple;

public class DefaultPackagingLanguageApplication_Configuration extends BaseRunConfig {
  @Tag(value = "state")
  private DefaultPackagingLanguageApplication_Configuration.MyState myState = new DefaultPackagingLanguageApplication_Configuration.MyState();

  public DefaultPackagingLanguageApplication_Configuration(Project p, ConfigurationFactory f, String name) {
    super(p, f, name);
  }

  public RunConfiguration clone() {
    try {
      DefaultPackagingLanguageApplication_Configuration result = ((DefaultPackagingLanguageApplication_Configuration) super.clone());
      result.myState = ((DefaultPackagingLanguageApplication_Configuration.MyState) this.myState.clone());
      return result;
    } catch (CloneNotSupportedException e) {
      return null;
    }
  }

  public void checkConfiguration() throws RuntimeConfigurationException {
    final StringBuilder error_22042010 = new StringBuilder();
    try {
      String paramsReport = DefaultPackagingLanguageApplication_Configuration.this.getStateObject().myJavaRunParameters.getErrorReport();
      if (paramsReport != null) {
        error_22042010.append(paramsReport).append("\n");
      }
      final SNode node;
      String errorReport;
      {
        Tuples._2<SNode, String> _tmp_xsfjxy_e0a0b0b = DefaultPackagingLanguageApplication_Configuration.this.checkNode();
        node = _tmp_xsfjxy_e0a0b0b._0();
        errorReport = _tmp_xsfjxy_e0a0b0b._1();
      }
      if (node == null) {
        throw new RuntimeConfigurationException(errorReport);
      }
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          if (StringUtils.isEmpty(DefaultPackagingLanguageApplication_Configuration.this.getStateObject().configurationId)) {
            error_22042010.append("configuration to run is not selected").append("\n");
          } else if (DefaultPackagingLanguageApplication_Configuration.this.getConfiguration(node) == null) {
            error_22042010.append("can not find configuration with id " + DefaultPackagingLanguageApplication_Configuration.this.getStateObject().configurationId).append("\n");
          }
        }
      });
    } catch (Throwable t_22042010) {
      if (t_22042010 instanceof RuntimeConfigurationException) {
        throw (RuntimeConfigurationException) t_22042010;
      }
      if (t_22042010 instanceof RuntimeConfigurationError) {
        throw (RuntimeConfigurationError) t_22042010;
      }
      Logger.getLogger(DefaultPackagingLanguageApplication_Configuration.class).error(t_22042010);
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
        final IOperationContext context = MPSDataKeys.OPERATION_CONTEXT.getData(environment.getDataContext());
        final Project project = MPSDataKeys.PROJECT.getData(environment.getDataContext());

        // user's execute code 
        try {
          final ConfigRunParameters javaRunParameters = DefaultPackagingLanguageApplication_Configuration.this.getStateObject().myJavaRunParameters.copy();
          final SNode node = DefaultPackagingLanguageApplication_Configuration.this.getNodeForExecution(environment.getProject(), (javaRunParameters).getMake());
          {
            // calculate parameter 

            ListSequence.fromList(actions_22042010).addSequence(ListSequence.fromList(new _FunctionTypes._return_P0_E0<List<AnAction>>() {
              public List<AnAction> invoke() {
                {
                  final List<AnAction> actionsList = ListSequence.fromListAndArray(new ArrayList<AnAction>(), consoleView_22042010.createConsoleActions());
                  return actionsList;
                }
              }
            }.invoke()));

            // create console component 
            consoleComponent_22042010 = consoleView_22042010.getComponent();
            consoleDispose_22042010 = new Runnable() {
              public void run() {
                Disposer.dispose(consoleView_22042010);
              }
            };

            final Wrappers._T<ExecutionException> ex = new Wrappers._T<ExecutionException>(null);
            // create process handler 
            handler_22042010 = (ProcessHandler) new _FunctionTypes._return_P0_E2<DefaultProcessHandler, ExecutionException, ExecutionException>() {
              public DefaultProcessHandler invoke() throws ExecutionException, ExecutionException {
                try {
                  SNode configuration = DefaultPackagingLanguageApplication_Configuration.this.getConfiguration(node);

                  if (configuration == null) {
                    throw new ExecutionException("Configuration is not selected.");
                  }

                  final Wrappers._T<SModelDescriptor> model = new Wrappers._T<SModelDescriptor>();
                  ModelAccess.instance().runReadAction(new Runnable() {
                    public void run() {
                      model.value = SNodeOperations.getModel(node).getModelDescriptor();
                    }
                  });
                  File file = GenerateTextFromBuild.generate(configuration, model.value, context, project, true);

                  if (file == null) {
                    throw new ExecutionException("No executable file were generated.");
                  }

                  AntScriptRunner runner = new AntScriptRunner(javaRunParameters);
                  Process process = runner.run(file);
                  return new DefaultProcessHandler(consoleView_22042010, process, runner.getCommandString());
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
            Logger.getLogger(DefaultPackagingLanguageApplication_Configuration.class).error(t);
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
    return new DefaultPackagingLanguageApplication_Configuration.MySettingsEditor();
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

  public DefaultPackagingLanguageApplication_Configuration.MyState getStateObject() {
    return this.myState;
  }

  private SNode getConfiguration(final SNode node) {
    final Wrappers._T<SNode> configuration = new Wrappers._T<SNode>();
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        configuration.value = SNodeOperations.cast(SNodeOperations.getModel(node).getNodeById(DefaultPackagingLanguageApplication_Configuration.this.getStateObject().configurationId), "jetbrains.mps.build.packaging.structure.Configuration");
      }
    });
    return configuration.value;
  }

  public SNode getNode() {
    if (DefaultPackagingLanguageApplication_Configuration.this.getStateObject().modelId == null || DefaultPackagingLanguageApplication_Configuration.this.getStateObject().nodeId == null) {
      return null;
    }
    final Wrappers._T<SNode> node = new Wrappers._T<SNode>();
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        node.value = new SNodePointer(DefaultPackagingLanguageApplication_Configuration.this.getStateObject().modelId, DefaultPackagingLanguageApplication_Configuration.this.getStateObject().nodeId).getNode();
      }
    });
    return node.value;
  }

  public void setNode(final SNode node) {
    if (node == null) {
      DefaultPackagingLanguageApplication_Configuration.this.getStateObject().modelId = null;
      DefaultPackagingLanguageApplication_Configuration.this.getStateObject().nodeId = null;
      return;
    }
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        DefaultPackagingLanguageApplication_Configuration.this.getStateObject().modelId = node.getModel().getModelDescriptor().getSModelReference().toString();
        DefaultPackagingLanguageApplication_Configuration.this.getStateObject().nodeId = node.getId();
      }
    });
  }

  private SNode getNodeForExecution(Project project, boolean make) {
    SNode node = DefaultPackagingLanguageApplication_Configuration.this.getNode();
    return node;
  }

  private Tuples._2<SNode, String> checkNode() {
    if (DefaultPackagingLanguageApplication_Configuration.this.getStateObject().modelId != null && DefaultPackagingLanguageApplication_Configuration.this.getStateObject().nodeId != null) {
      final SNode node = ModelAccess.instance().runReadAction(new Computable<SNode>() {
        public SNode compute() {
          return DefaultPackagingLanguageApplication_Configuration.this.getNode();
        }
      });
      if ((node == null)) {
        return MultiTuple.<SNode,String>from((SNode) null, "node is not selected or does not exist");
      }
      {
        boolean isApplicable = new _FunctionTypes._return_P0_E0<Boolean>() {
          public Boolean invoke() {
            final Wrappers._boolean isApplicable = new Wrappers._boolean();
            ModelAccess.instance().runReadAction(new Runnable() {
              public void run() {
                isApplicable.value = ListSequence.fromList(SNodeOperations.getDescendants(node, "jetbrains.mps.build.packaging.structure.INotBuildableComponent", false, new String[]{})).isEmpty();
              }
            });
            return isApplicable.value;
          }
        }.invoke();
        if (!(isApplicable)) {
          return MultiTuple.<SNode,String>from((SNode) null, "can't run selected node");
        }
      }
      return MultiTuple.<SNode,String>from(node, (String) null);
    } else {
      return MultiTuple.<SNode,String>from((SNode) null, "node is not selected");
    }
  }

  private static class MySettingsEditor extends SettingsEditor<DefaultPackagingLanguageApplication_Configuration> {
    private DefaultPackagingLanguageApplication_Editor myComponent = null;

    public MySettingsEditor() {
    }

    protected void resetEditorFrom(DefaultPackagingLanguageApplication_Configuration c) {
      MySettingsEditor.this.myComponent.reset(c);
      final ConfigRunParameters javaRunParameters = c.getStateObject().myJavaRunParameters;
      MySettingsEditor.this.myComponent.getUsersComponent().reset(c.getNode(), c.getStateObject().configurationId);
    }

    protected void applyEditorTo(DefaultPackagingLanguageApplication_Configuration c) {
      MySettingsEditor.this.myComponent.apply(c);
      final ConfigRunParameters javaRunParameters = c.getStateObject().myJavaRunParameters;
      c.getStateObject().configurationId = MySettingsEditor.this.myComponent.getUsersComponent().getConfigurationId();
    }

    @NotNull
    protected JComponent createEditor() {
      this.myComponent = new DefaultPackagingLanguageApplication_Editor();
      return this.myComponent;
    }

    protected void disposeEditor() {
      MySettingsEditor.this.myComponent.dispose();
    }
  }

  public static class MyState implements Cloneable {
    public ConfigRunParameters myJavaRunParameters = new ConfigRunParameters();
    public String configurationId;
    public String nodeId;
    public String modelId;

    public MyState() {
    }

    public Object clone() throws CloneNotSupportedException {
      DefaultPackagingLanguageApplication_Configuration.MyState object = (DefaultPackagingLanguageApplication_Configuration.MyState) super.clone();
      if (this.myJavaRunParameters != null) {
        object.myJavaRunParameters = (ConfigRunParameters) this.myJavaRunParameters.clone();
      }
      return object;
    }
  }
}
