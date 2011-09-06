package jetbrains.mps.execution.demo.plugin;

/*Generated by MPS */

import jetbrains.mps.execution.api.configurations.BaseMpsRunConfiguration;
import jetbrains.mps.execution.api.settings.IPersistentConfiguration;
import jetbrains.mps.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.execution.configurations.lib.Node_Configuration;
import jetbrains.mps.smodel.ModelAccess;
import com.intellij.openapi.util.Computable;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import com.intellij.openapi.project.Project;
import com.intellij.execution.configurations.RuntimeConfigurationException;
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
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;

public class DemoApplication_Configuration extends BaseMpsRunConfiguration implements IPersistentConfiguration {
  private static final Logger LOG = Logger.getLogger(DemoApplication_Configuration.class);
  private static final Icon ICON = new ImageIcon(Demo_Kind.class.getResource("run.png"));

  @NotNull
  private DemoApplication_Configuration.MyState myState = new DemoApplication_Configuration.MyState();
  private Node_Configuration myNode = new Node_Configuration(ModelAccess.instance().runReadAction(new Computable<SNode>() {
    public SNode compute() {
      return SConceptOperations.findConceptDeclaration("jetbrains.mps.execution.demo.structure.SomeConcept");
    }
  }), new _FunctionTypes._return_P1_E0<Boolean, SNode>() {
    public Boolean invoke(SNode node) {
      return SPropertyOperations.getBoolean(SNodeOperations.cast(node, "jetbrains.mps.execution.demo.structure.SomeConcept"), "valid");
    }
  });

  public DemoApplication_Configuration(Project project, DemoApplication_Configuration_Factory factory, String name) {
    super(project, factory, name);
  }

  public void checkConfiguration() throws RuntimeConfigurationException {
    this.getNode().checkConfiguration();
  }

  @Override
  public void writeExternal(Element element) throws WriteExternalException {
    element.addContent(XmlSerializer.serialize(myState));
    {
      Element fieldElement = new Element("myNode");
      myNode.writeExternal(fieldElement);
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
  }

  public Node_Configuration getNode() {
    return myNode;
  }

  @Override
  public DemoApplication_Configuration clone() {
    DemoApplication_Configuration clone = null;
    try {
      clone = createCloneTemplate();
      clone.myState = (DemoApplication_Configuration.MyState) myState.clone();
      clone.myNode = (Node_Configuration) myNode.clone();
      return clone;
    } catch (CloneNotSupportedException ex) {
      DemoApplication_Configuration.LOG.error(ex);
    }
    return clone;
  }

  @Nullable
  public RunProfileState getState(@NotNull Executor executor, @NotNull ExecutionEnvironment environment) throws ExecutionException {
    return new DemoApplication_Configuration_RunProfileState(this, executor, environment);
  }

  @Nullable
  public SettingsEditor<JDOMExternalizable> getRunnerSettingsEditor(ProgramRunner runner) {
    return null;
  }

  public JDOMExternalizable createRunnerSettings(ConfigurationInfoProvider provider) {
    return null;
  }

  public SettingsEditorEx<DemoApplication_Configuration> getConfigurationEditor() {
    return (SettingsEditorEx<DemoApplication_Configuration>) getEditor();
  }

  public DemoApplication_Configuration createCloneTemplate() {
    return (DemoApplication_Configuration) super.clone();
  }

  public SettingsEditorEx<? extends IPersistentConfiguration> getEditor() {
    return new DemoApplication_Configuration_Editor(myNode.getEditor());
  }

  public Icon getIcon() {
    return ICON;
  }

  @Override
  public boolean canExecute(String executorId) {
    return DemoApplication_Configuration_RunProfileState.canExecute(executorId);
  }

  public Object[] createMakeTask() {
    return new Object[]{ListSequence.fromListAndArray(new ArrayList<SNode>(), this.getNode().getNode())};
  }

  public class MyState {
    public MyState() {
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
      DemoApplication_Configuration.MyState state = new DemoApplication_Configuration.MyState();
      return state;
    }
  }
}
