package jetbrains.mps.execution.configurations.implementation.plugin.plugin;

/*Generated by MPS */

import jetbrains.mps.execution.api.configurations.BaseMpsRunConfiguration;
import jetbrains.mps.execution.api.settings.IPersistentConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.execution.lib.Node_Configuration;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.util.Computable;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.ant.execution.AntSettings_Configuration;
import com.intellij.openapi.project.Project;
import com.intellij.execution.configurations.RuntimeConfigurationException;
import org.apache.commons.lang.StringUtils;
import org.jdom.Element;
import com.intellij.openapi.util.WriteExternalException;
import com.intellij.util.xmlb.XmlSerializer;
import com.intellij.openapi.util.InvalidDataException;
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

public class CustomMPSApplication_Configuration extends BaseMpsRunConfiguration implements IPersistentConfiguration {
  protected static Log log = LogFactory.getLog(CustomMPSApplication_Configuration.class);

  @NotNull
  private CustomMPSApplication_Configuration.MyState myState = new CustomMPSApplication_Configuration.MyState();
  private Node_Configuration myNode = new Node_Configuration(ModelAccess.instance().runReadAction(new Computable<SNode>() {
    public SNode compute() {
      return SConceptOperations.findConceptDeclaration("jetbrains.mps.build.packaging.structure.Layout");
    }
  }), new _FunctionTypes._return_P1_E0<Boolean, SNode>() {
    public Boolean invoke(final SNode node) {
      final Wrappers._boolean isApplicable = new Wrappers._boolean();
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          isApplicable.value = ListSequence.fromList(SNodeOperations.getDescendants(node, "jetbrains.mps.build.custommps.structure.MPSBuild", false, new String[]{})).isNotEmpty();
        }
      });
      return isApplicable.value;
    }
  });
  private AntSettings_Configuration mySettings = new AntSettings_Configuration();

  public CustomMPSApplication_Configuration(Project project, CustomMPSApplication_Configuration_Factory factory, String name) {
    super(project, factory, name);
  }

  public void checkConfiguration() throws RuntimeConfigurationException {
    if (StringUtils.isEmpty(this.getConfigurationId())) {
      throw new RuntimeConfigurationException("Configuration to run is not selected.");
    } else if ((getConfiguration() == null)) {
      throw new RuntimeConfigurationException("Could not find configuration with id " + this.getConfigurationId() + ".");
    }
  }

  @Override
  public void writeExternal(Element element) throws WriteExternalException {
    element.addContent(XmlSerializer.serialize(myState));
    {
      Element fieldElement = new Element("myNode");
      myNode.writeExternal(fieldElement);
      element.addContent(fieldElement);
    }
    {
      Element fieldElement = new Element("mySettings");
      mySettings.writeExternal(fieldElement);
      element.addContent(fieldElement);
    }
  }

  @Override
  public void readExternal(Element element) throws InvalidDataException {
    if (element == null) {
      throw new InvalidDataException("Cant read " + this + ": element is null.");
    }
    XmlSerializer.deserializeInto(myState, (Element) element.getChildren().get(0));
    {
      Element fieldElement = element.getChild("myNode");
      if (fieldElement != null) {
        myNode.readExternal(fieldElement);
      } else {
        if (log.isDebugEnabled()) {
          log.debug("Element " + "myNode" + " in " + this.getClass().getName() + " was null.");
        }
      }
    }
    {
      Element fieldElement = element.getChild("mySettings");
      if (fieldElement != null) {
        mySettings.readExternal(fieldElement);
      } else {
        if (log.isDebugEnabled()) {
          log.debug("Element " + "mySettings" + " in " + this.getClass().getName() + " was null.");
        }
      }
    }
  }

  public Node_Configuration getNode() {
    return myNode;
  }

  public String getConfigurationId() {
    return myState.myConfigurationId;
  }

  public AntSettings_Configuration getSettings() {
    return mySettings;
  }

  public void setConfigurationId(String value) {
    myState.myConfigurationId = value;
  }

  public SNode getConfiguration() {
    final Wrappers._T<SNode> configuration = new Wrappers._T<SNode>();
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        configuration.value = SNodeOperations.cast(SNodeOperations.getModel(CustomMPSApplication_Configuration.this.getNode().getNode()).getNodeById(CustomMPSApplication_Configuration.this.getConfigurationId()), "jetbrains.mps.build.packaging.structure.Configuration");
      }
    });
    return configuration.value;
  }

  @Override
  public CustomMPSApplication_Configuration clone() {
    CustomMPSApplication_Configuration clone = null;
    try {
      clone = createCloneTemplate();
      clone.myState = (CustomMPSApplication_Configuration.MyState) myState.clone();
      clone.myNode = (Node_Configuration) myNode.clone();
      clone.mySettings = (AntSettings_Configuration) mySettings.clone();
      return clone;
    } catch (CloneNotSupportedException ex) {
      if (log.isErrorEnabled()) {
        log.error("", ex);
      }
    }
    return clone;
  }

  @Nullable
  public RunProfileState getState(@NotNull Executor executor, @NotNull ExecutionEnvironment environment) throws ExecutionException {
    return new CustomMPSApplication_Configuration_RunProfileState(this, executor, environment);
  }

  @Nullable
  public SettingsEditor<JDOMExternalizable> getRunnerSettingsEditor(ProgramRunner runner) {
    return null;
  }

  public JDOMExternalizable createRunnerSettings(ConfigurationInfoProvider provider) {
    return null;
  }

  public SettingsEditorEx<CustomMPSApplication_Configuration> getConfigurationEditor() {
    return (SettingsEditorEx<CustomMPSApplication_Configuration>) getEditor();
  }

  public CustomMPSApplication_Configuration createCloneTemplate() {
    return (CustomMPSApplication_Configuration) super.clone();
  }

  public SettingsEditorEx<? extends IPersistentConfiguration> getEditor() {
    return new CustomMPSApplication_Configuration_Editor(myNode.getEditor(), mySettings.getEditor());
  }

  @Override
  public boolean canExecute(String executorId) {
    return CustomMPSApplication_Configuration_RunProfileState.canExecute(executorId);
  }

  public Object[] createGenerateBuildTask() {
    return new Object[]{SNodeOperations.cast(this.getNode().getNode(), "jetbrains.mps.build.packaging.structure.Layout")};
  }

  public class MyState {
    public String myConfigurationId;

    public MyState() {
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
      CustomMPSApplication_Configuration.MyState state = new CustomMPSApplication_Configuration.MyState();
      state.myConfigurationId = myConfigurationId;
      return state;
    }
  }
}
