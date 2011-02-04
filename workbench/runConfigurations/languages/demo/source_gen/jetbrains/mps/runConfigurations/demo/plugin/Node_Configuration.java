package jetbrains.mps.runConfigurations.demo.plugin;

/*Generated by MPS */

import jetbrains.mps.runConfigurations.runtime.IPersistentConfiguration;
import org.jetbrains.annotations.NotNull;
import com.intellij.execution.configurations.RuntimeConfigurationException;
import org.jdom.Element;
import com.intellij.openapi.util.WriteExternalException;
import com.intellij.util.xmlb.XmlSerializer;
import com.intellij.openapi.util.InvalidDataException;
import com.intellij.openapi.options.SettingsEditor;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.smodel.SNodePointer;

public class Node_Configuration implements IPersistentConfiguration {
  private Node_Configuration_Editor myPersistentEditor = new Node_Configuration_Editor();
  @NotNull
  private Node_Configuration.MyState myState = new Node_Configuration.MyState();

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

  public SettingsEditor<? extends IPersistentConfiguration> getEditor() {
    return myPersistentEditor;
  }

  public String getNodeId() {
    return myState.myNodeId;
  }

  public String getModelId() {
    return myState.myModelId;
  }

  public void setNodeId(String value) {
    myState.myNodeId = value;
  }

  public void setModelId(String value) {
    myState.myModelId = value;
  }

  @Nullable
  public SNode getNode() {
    if (this.getModelId() == null || this.getNodeId() == null) {
      return null;
    }
    final Wrappers._T<SNode> node = new Wrappers._T<SNode>();
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        node.value = new SNodePointer(Node_Configuration.this.getModelId(), Node_Configuration.this.getNodeId()).getNode();
      }
    });
    return node.value;
  }

  public void setNode(@Nullable final SNode node) {
    if (node == null) {
      this.setModelId(null);
      this.setNodeId(null);
    } else {
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          Node_Configuration.this.setModelId(node.getModel().getModelDescriptor().getSModelReference().toString());
          Node_Configuration.this.setNodeId(node.getId());
        }
      });
    }
  }

  public class MyState {
    /*package*/ String myNodeId;
    /*package*/ String myModelId;

    public MyState() {
    }
  }
}
