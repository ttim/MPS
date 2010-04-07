package jetbrains.mps.baseLanguage.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.runconfigs.BaseRunConfig;
import com.intellij.util.xmlb.annotations.Tag;
import com.intellij.openapi.project.Project;
import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.execution.configurations.RuntimeConfigurationException;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import jetbrains.mps.baseLanguage.tuples.runtime.Tuples;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.baseLanguage.behavior.ClassConcept_Behavior;
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
import jetbrains.mps.baseLanguage.util.plugin.run.ConfigRunParameters;
import com.intellij.execution.executors.DefaultDebugExecutor;
import jetbrains.mps.debug.DebuggerKeys;
import org.apache.commons.lang.StringUtils;
import com.intellij.openapi.util.Disposer;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.baseLanguage.util.plugin.run.ClassRunner;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
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
import jetbrains.mps.smodel.SNodePointer;
import jetbrains.mps.baseLanguage.util.plugin.run.RunUtil;
import java.util.Collections;
import jetbrains.mps.baseLanguage.tuples.runtime.MultiTuple;

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
      String paramsReport = DefaultJavaApplication_Configuration.this.getStateObject().myJavaRunParameters.getErrorReport();
      if (paramsReport != null) {
        error.append(paramsReport).append("\n");
      }
      final SNode node = new _FunctionTypes._return_P0_E0<SNode>() {
        public SNode invoke() {
          SNode snode;
          String errorReport;
          {
            Tuples._2<SNode, String> _tmp_vpmxmq_c0a0a2a1a1 = DefaultJavaApplication_Configuration.this.checkNode();
            snode = _tmp_vpmxmq_c0a0a2a1a1._0();
            errorReport = _tmp_vpmxmq_c0a0a2a1a1._1();
          }
          if (snode == null) {
            error.append(errorReport).append("\n");
          }
          return snode;
        }
      }.invoke();
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          if (ClassConcept_Behavior.call_getMainMethod_1213877355884(node) == null) {
            error.append("selected node does not have main method").append("\n");
          }
        }
      });
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

        // user's execute code 
        final ConfigRunParameters javaRunParameters = DefaultJavaApplication_Configuration.this.getStateObject().myJavaRunParameters.copy();
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
        final SNode node = DefaultJavaApplication_Configuration.this.getNodeForExecution(environment.getProject(), (javaRunParameters).getMake());
        {
          // calculate parameter 

          ListSequence.fromList(actions).addSequence(ListSequence.fromList(new _FunctionTypes._return_P0_E0<List<AnAction>>() {
            public List<AnAction> invoke() {
              {
                final List<AnAction> actionsList = ListSequence.fromListAndArray(new ArrayList<AnAction>(), consoleView.createConsoleActions());
                return actionsList;
              }
            }
          }.invoke()));

          // create console component 
          consoleComponent = consoleView.getComponent();
          consoleDispose = new Runnable() {
            public void run() {
              Disposer.dispose(consoleView);
            }
          };

          final Wrappers._T<ExecutionException> ex = new Wrappers._T<ExecutionException>(null);
          // create process handler 
          handler = (ProcessHandler) new _FunctionTypes._return_P0_E0<Object>() {
            public Object invoke() {
              try {
                ClassRunner classRunner = new ClassRunner();
                Process process = classRunner.run(SNodeOperations.cast(node, "jetbrains.mps.baseLanguage.structure.ClassConcept"), javaRunParameters.getProgramParameters(), javaRunParameters.getVMParameters(), javaRunParameters.getWorkingDirectory());
                return new DefaultProcessHandler(consoleView, process, classRunner.getCommandString());
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

  public boolean isDebuggable() {
    return true;
  }

  public SNode getNode() {
    if (DefaultJavaApplication_Configuration.this.getStateObject().modelId == null || DefaultJavaApplication_Configuration.this.getStateObject().nodeId == null) {
      return null;
    }
    final Wrappers._T<SNode> node = new Wrappers._T<SNode>();
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        node.value = new SNodePointer(DefaultJavaApplication_Configuration.this.getStateObject().modelId, DefaultJavaApplication_Configuration.this.getStateObject().nodeId).getNode();
      }
    });
    return node.value;
  }

  public void setNode(final SNode node) {
    if (node == null) {
      DefaultJavaApplication_Configuration.this.getStateObject().modelId = null;
      DefaultJavaApplication_Configuration.this.getStateObject().nodeId = null;
      return;
    }
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        DefaultJavaApplication_Configuration.this.getStateObject().modelId = node.getModel().getModelDescriptor().getSModelReference().toString();
        DefaultJavaApplication_Configuration.this.getStateObject().nodeId = node.getId();
      }
    });
  }

  private SNode getNodeForExecution(Project project, boolean make) {
    SNode node = DefaultJavaApplication_Configuration.this.getNode();
    if (make) {
      RunUtil.makeBeforeRun(project, Collections.singletonList(node));
    }
    return node;
  }

  private Tuples._2<SNode, String> checkNode() {
    if (DefaultJavaApplication_Configuration.this.getStateObject().modelId != null && DefaultJavaApplication_Configuration.this.getStateObject().nodeId != null) {
      final Wrappers._T<SNode> node = new Wrappers._T<SNode>();
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          node.value = DefaultJavaApplication_Configuration.this.getNode();
        }
      });
      if ((node.value == null)) {
        return MultiTuple.<SNode,String>from((SNode) null, "node is not selected or does not exist");
      }
      return MultiTuple.<SNode,String>from(node.value, (String) null);
    } else {
      return MultiTuple.<SNode,String>from((SNode) null, "node is not selected");
    }
  }

  private static class MySettingsEditor extends SettingsEditor<DefaultJavaApplication_Configuration> {
    private DefaultJavaApplication_Editor myComponent = null;

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
      this.myComponent = new DefaultJavaApplication_Editor();
      return this.myComponent;
    }

    protected void disposeEditor() {
      MySettingsEditor.this.myComponent.dispose();
    }
  }

  public static class MyState implements Cloneable {
    public ConfigRunParameters myJavaRunParameters = new ConfigRunParameters();
    public String nodeId;
    public String modelId;

    public MyState() {
    }

    public Object clone() throws CloneNotSupportedException {
      DefaultJavaApplication_Configuration.MyState object = (DefaultJavaApplication_Configuration.MyState) super.clone();
      if (this.myJavaRunParameters != null) {
        object.myJavaRunParameters = (ConfigRunParameters) this.myJavaRunParameters.clone();
      }
      return object;
    }
  }
}
