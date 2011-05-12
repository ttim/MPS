package jetbrains.mps.debugger.java.mps;

/*Generated by MPS */

import jetbrains.mps.execution.api.configurations.BaseMpsRunConfiguration;
import jetbrains.mps.execution.api.settings.IPersistentConfiguration;
import jetbrains.mps.logging.Logger;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.project.Project;
import com.intellij.execution.configurations.RuntimeConfigurationException;
import org.apache.commons.lang.StringUtils;
import org.jdom.Element;
import com.intellij.openapi.util.WriteExternalException;
import com.intellij.util.xmlb.XmlSerializer;
import com.intellij.openapi.util.InvalidDataException;
import jetbrains.mps.util.MacrosFactory;
import java.io.File;
import org.jetbrains.annotations.Nullable;
import com.intellij.execution.configurations.RunProfileState;
import com.intellij.execution.Executor;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.execution.ExecutionException;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.util.JDOMExternalizable;
import com.intellij.execution.runners.ProgramRunner;
import com.intellij.execution.configurations.ConfigurationInfoProvider;
import jetbrains.mps.execution.api.settings.SettingsEditorEx;

public class MPSInstance_Configuration extends BaseMpsRunConfiguration implements IPersistentConfiguration {
  private static final Logger LOG = Logger.getLogger(MPSInstance_Configuration.class);

  @NotNull
  private MPSInstance_Configuration.MyState myState = new MPSInstance_Configuration.MyState();

  public MPSInstance_Configuration(Project project, MPSInstance_Configuration_Factory factory, String name) {
    super(project, factory, name);
  }

  public void checkConfiguration() throws RuntimeConfigurationException {
    if (StringUtils.isEmpty(this.getConfigurationPath())) {
      throw new RuntimeConfigurationException("Configuration path is empty.");
    }
    if (StringUtils.isEmpty(this.getSystemPath())) {
      throw new RuntimeConfigurationException("System path is empty.");
    }
  }

  @Override
  public void writeExternal(Element element) throws WriteExternalException {
    element.addContent(XmlSerializer.serialize(myState));
  }

  @Override
  public void readExternal(Element element) throws InvalidDataException {
    XmlSerializer.deserializeInto(myState, (Element) element.getChildren().get(0));
  }

  public String getVmOptions() {
    return myState.myVmOptions;
  }

  public String getJrePath() {
    return myState.myJrePath;
  }

  public String getSystemPath() {
    return myState.mySystemPath;
  }

  public String getConfigurationPath() {
    return myState.myConfigurationPath;
  }

  public void setVmOptions(String value) {
    myState.myVmOptions = value;
  }

  public void setJrePath(String value) {
    myState.myJrePath = value;
  }

  public void setSystemPath(String value) {
    myState.mySystemPath = value;
  }

  public void setConfigurationPath(String value) {
    myState.myConfigurationPath = value;
  }

  public String expandPath(String path) {
    return MacrosFactory.mpsHomeMacros().expandPath(path, new File(System.getProperty("user.home"))).replace(File.separator, "/");
  }

  public String shinkPath(String path) {
    if (StringUtils.isEmpty(path)) {
      return path;
    }
    return MacrosFactory.mpsHomeMacros().shrinkPath(path, new File(System.getProperty("user.home"))).replace(File.separator, "/");
  }

  @Override
  public MPSInstance_Configuration clone() {
    MPSInstance_Configuration clone = null;
    try {
      clone = createCloneTemplate();
      clone.myState = (MPSInstance_Configuration.MyState) myState.clone();
      return clone;
    } catch (CloneNotSupportedException ex) {
      MPSInstance_Configuration.LOG.error(ex);
    }
    return clone;
  }

  @Nullable
  public RunProfileState getState(@NotNull Executor executor, @NotNull ExecutionEnvironment environment) throws ExecutionException {
    return new MPSInstance_Configuration_RunProfileState(this, executor, environment);
  }

  @Nullable
  public SettingsEditor<JDOMExternalizable> getRunnerSettingsEditor(ProgramRunner runner) {
    return null;
  }

  public JDOMExternalizable createRunnerSettings(ConfigurationInfoProvider provider) {
    return null;
  }

  public SettingsEditorEx<MPSInstance_Configuration> getConfigurationEditor() {
    return (SettingsEditorEx<MPSInstance_Configuration>) getEditor();
  }

  public MPSInstance_Configuration createCloneTemplate() {
    return (MPSInstance_Configuration) super.clone();
  }

  public SettingsEditorEx<? extends IPersistentConfiguration> getEditor() {
    return new MPSInstance_Configuration_Editor();
  }

  @Override
  public boolean canExecute(String executorId) {
    return MPSInstance_Configuration_RunProfileState.canExecute(executorId);
  }

  public class MyState {
    public String myVmOptions;
    public String myJrePath;
    public String mySystemPath = shinkPath(Mps_Command.getDefaultSystemPath());
    public String myConfigurationPath = shinkPath(Mps_Command.getDefaultConfigurationPath());

    public MyState() {
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
      MPSInstance_Configuration.MyState state = new MPSInstance_Configuration.MyState();
      state.myVmOptions = myVmOptions;
      state.myJrePath = myJrePath;
      state.mySystemPath = mySystemPath;
      state.myConfigurationPath = myConfigurationPath;
      return state;
    }
  }
}
