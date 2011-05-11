package jetbrains.mps.debugger.java.remote;

/*Generated by MPS */

import jetbrains.mps.execution.api.configurations.BaseMpsRunConfiguration;
import jetbrains.mps.execution.api.settings.SettingsEditorEx;
import jetbrains.mps.execution.api.settings.IPersistentConfiguration;
import jetbrains.mps.logging.Logger;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.project.Project;
import com.intellij.execution.configurations.RuntimeConfigurationException;
import org.jdom.Element;
import com.intellij.openapi.util.WriteExternalException;
import com.intellij.util.xmlb.XmlSerializer;
import com.intellij.openapi.util.InvalidDataException;
import jetbrains.mps.debug.runtime.settings.RemoteConnectionSettings;
import org.jetbrains.annotations.Nullable;
import com.intellij.execution.configurations.RunProfileState;
import com.intellij.execution.Executor;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.execution.ExecutionException;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.util.JDOMExternalizable;
import com.intellij.execution.runners.ProgramRunner;
import com.intellij.execution.configurations.ConfigurationInfoProvider;

public class Remote_Configuration extends BaseMpsRunConfiguration implements IPersistentConfiguration {
  private static final Logger LOG = Logger.getLogger(Remote_Configuration.class);

  @NotNull
  private Remote_Configuration.MyState myState = new Remote_Configuration.MyState();

  public Remote_Configuration(Project project, Remote_Configuration_Factory factory, String name) {
    super(project, factory, name);
  }

  public void checkConfiguration() throws RuntimeConfigurationException {
  }

  @Override
  public void writeExternal(Element element) throws WriteExternalException {
    element.addContent(XmlSerializer.serialize(myState));
  }

  @Override
  public void readExternal(Element element) throws InvalidDataException {
    XmlSerializer.deserializeInto(myState, (Element) element.getChildren().get(0));
  }

  public RemoteConnectionSettings getSettings() {
    return myState.mySettings;
  }

  public void setSettings(RemoteConnectionSettings value) {
    myState.mySettings = value;
  }

  @Override
  public Remote_Configuration clone() {
    Remote_Configuration clone = null;
    try {
      clone = createCloneTemplate();
      clone.myState = (Remote_Configuration.MyState) myState.clone();
      return clone;
    } catch (CloneNotSupportedException ex) {
      Remote_Configuration.LOG.error(ex);
    }
    return clone;
  }

  @Nullable
  public RunProfileState getState(@NotNull Executor executor, @NotNull ExecutionEnvironment environment) throws ExecutionException {
    return new Remote_Configuration_RunProfileState(this, executor, environment);
  }

  @Nullable
  public SettingsEditor<JDOMExternalizable> getRunnerSettingsEditor(ProgramRunner runner) {
    return null;
  }

  public JDOMExternalizable createRunnerSettings(ConfigurationInfoProvider provider) {
    return null;
  }

  public SettingsEditorEx<Remote_Configuration> getConfigurationEditor() {
    return (SettingsEditorEx<Remote_Configuration>) getEditor();
  }

  public Remote_Configuration createCloneTemplate() {
    return (Remote_Configuration) super.clone();
  }

  public SettingsEditorEx<? extends IPersistentConfiguration> getEditor() {
    return new Remote_Configuration_Editor();
  }

  @Override
  public boolean canExecute(String executorId) {
    return Remote_Configuration_RunProfileState.canExecute(executorId);
  }

  public class MyState {
    public RemoteConnectionSettings mySettings = new RemoteConnectionSettings("localhost", 5005);

    public MyState() {
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
      Remote_Configuration.MyState state = new Remote_Configuration.MyState();
      state.mySettings = mySettings;
      return state;
    }
  }
}
