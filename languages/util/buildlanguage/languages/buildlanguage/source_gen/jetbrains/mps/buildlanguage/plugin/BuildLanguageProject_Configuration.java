package jetbrains.mps.buildlanguage.plugin;

/*Generated by MPS */

import jetbrains.mps.execution.api.configurations.BaseMpsRunConfiguration;
import jetbrains.mps.execution.api.settings.IPersistentConfiguration;
import jetbrains.mps.logging.Logger;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.execution.configurations.lib.Node_Configuration;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.util.Computable;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import com.intellij.openapi.project.Project;
import com.intellij.execution.configurations.RuntimeConfigurationException;
import org.jdom.Element;
import com.intellij.openapi.util.WriteExternalException;
import com.intellij.util.xmlb.XmlSerializer;
import com.intellij.openapi.util.InvalidDataException;
import org.jetbrains.annotations.Nullable;
import org.apache.commons.lang.StringUtils;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import com.intellij.execution.configurations.RunProfileState;
import com.intellij.execution.Executor;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.execution.ExecutionException;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.util.JDOMExternalizable;
import com.intellij.execution.runners.ProgramRunner;
import com.intellij.execution.configurations.ConfigurationInfoProvider;
import jetbrains.mps.execution.api.settings.SettingsEditorEx;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.smodel.SNodePointer;

public class BuildLanguageProject_Configuration extends BaseMpsRunConfiguration implements IPersistentConfiguration {
  private static final Logger LOG = Logger.getLogger(BuildLanguageProject_Configuration.class);

  @NotNull
  private BuildLanguageProject_Configuration.MyState myState = new BuildLanguageProject_Configuration.MyState();
  private Node_Configuration myNode = new Node_Configuration(ModelAccess.instance().runReadAction(new Computable<SNode>() {
    public SNode compute() {
      return SConceptOperations.findConceptDeclaration("jetbrains.mps.buildlanguage.structure.Project");
    }
  }), null);
  private AntSettings_Configuration mySettings = new AntSettings_Configuration();

  public BuildLanguageProject_Configuration(Project project, BuildLanguageProject_Configuration_Factory factory, String name) {
    super(project, factory, name);
  }

  public void checkConfiguration() throws RuntimeConfigurationException {
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
      myNode.readExternal(fieldElement);
    }
    {
      Element fieldElement = element.getChild("mySettings");
      mySettings.readExternal(fieldElement);
    }
  }

  public Node_Configuration getNode() {
    return myNode;
  }

  public AntSettings_Configuration getSettings() {
    return mySettings;
  }

  public String getTargetId() {
    return myState.myTargetId;
  }

  public void setTargetId(String value) {
    myState.myTargetId = value;
  }

  @Nullable
  public SNode getTarget() {
    if (StringUtils.isEmpty(this.getTargetId())) {
      return null;
    }
    final Wrappers._T<SNode> target = new Wrappers._T<SNode>();
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        SNode node = BuildLanguageProject_Configuration.this.getNode().getNode();
        if (node != null) {
          target.value = SNodeOperations.cast(SNodeOperations.getModel(node).getNodeById(BuildLanguageProject_Configuration.this.getTargetId()), "jetbrains.mps.buildlanguage.structure.TargetDeclaration");
        } else {
          target.value = null;
        }
      }
    });
    return target.value;
  }

  @Override
  public BuildLanguageProject_Configuration clone() {
    BuildLanguageProject_Configuration clone = null;
    try {
      clone = createCloneTemplate();
      clone.myState = (BuildLanguageProject_Configuration.MyState) myState.clone();
      clone.myNode = (Node_Configuration) myNode.clone();
      clone.mySettings = (AntSettings_Configuration) mySettings.clone();
      return clone;
    } catch (CloneNotSupportedException ex) {
      BuildLanguageProject_Configuration.LOG.error(ex);
    }
    return clone;
  }

  @Nullable
  public RunProfileState getState(@NotNull Executor executor, @NotNull ExecutionEnvironment environment) throws ExecutionException {
    return new BuildLanguageProject_Configuration_RunProfileState(this, executor, environment);
  }

  @Nullable
  public SettingsEditor<JDOMExternalizable> getRunnerSettingsEditor(ProgramRunner runner) {
    return null;
  }

  public JDOMExternalizable createRunnerSettings(ConfigurationInfoProvider provider) {
    return null;
  }

  public SettingsEditorEx<BuildLanguageProject_Configuration> getConfigurationEditor() {
    return (SettingsEditorEx<BuildLanguageProject_Configuration>) getEditor();
  }

  public BuildLanguageProject_Configuration createCloneTemplate() {
    return (BuildLanguageProject_Configuration) super.clone();
  }

  public SettingsEditorEx<? extends IPersistentConfiguration> getEditor() {
    return new BuildLanguageProject_Configuration_Editor(myNode.getEditor(), mySettings.getEditor());
  }

  @Override
  public boolean canExecute(String executorId) {
    return BuildLanguageProject_Configuration_RunProfileState.canExecute(executorId);
  }

  public Object[] createMakeNodePointersTask() {
    return new Object[]{ListSequence.fromListAndArray(new ArrayList<SNodePointer>(), this.getNode().getNodePointer())};
  }

  public class MyState {
    public String myTargetId;

    public MyState() {
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
      BuildLanguageProject_Configuration.MyState state = new BuildLanguageProject_Configuration.MyState();
      state.myTargetId = myTargetId;
      return state;
    }
  }
}
