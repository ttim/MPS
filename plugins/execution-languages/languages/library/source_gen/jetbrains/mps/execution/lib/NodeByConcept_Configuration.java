package jetbrains.mps.execution.lib;

/*Generated by MPS */

import jetbrains.mps.execution.api.settings.IPersistentConfiguration;
import jetbrains.mps.execution.api.settings.ITemplatePersistentConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.execution.api.settings.SettingsEditorEx;
import com.intellij.execution.configurations.RuntimeConfigurationException;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.smodel.ModelAccess;
import org.jdom.Element;
import com.intellij.openapi.util.WriteExternalException;
import com.intellij.util.xmlb.XmlSerializer;
import com.intellij.openapi.util.InvalidDataException;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.smodel.SNodePointer;

public class NodeByConcept_Configuration implements IPersistentConfiguration, ITemplatePersistentConfiguration {
  protected static Log log = LogFactory.getLog(NodeByConcept_Configuration.class);

  @NotNull
  private NodeByConcept_Configuration.MyState myState = new NodeByConcept_Configuration.MyState();
  private final String myConcept;
  private final _FunctionTypes._return_P1_E0<? extends Boolean, ? super SNode> myIsValid;
  private SettingsEditorEx<NodeByConcept_Configuration> myEditorEx;

  public NodeByConcept_Configuration(String concept, _FunctionTypes._return_P1_E0<? extends Boolean, ? super SNode> isValid) {
    myConcept = concept;
    myIsValid = isValid;
  }

  public void checkConfiguration() throws RuntimeConfigurationException {
    {
      final SNode node = getNode();
      if (node == null) {
        throw new RuntimeConfigurationException("Node is not specified.");
      }
      final Wrappers._boolean accept = new Wrappers._boolean();
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          accept.value = myIsValid.invoke(node);
        }
      });
      if (!(accept.value)) {
        throw new RuntimeConfigurationException("Node is not valid.");
      }
    }
  }

  @Override
  public void writeExternal(Element element) throws WriteExternalException {
    element.addContent(XmlSerializer.serialize(myState));
  }

  @Override
  public void readExternal(Element element) throws InvalidDataException {
    if (element == null) {
      throw new InvalidDataException("Cant read " + this + ": element is null.");
    }
    XmlSerializer.deserializeInto(myState, (Element) element.getChildren().get(0));
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
    final Wrappers._T<SNode> node = new Wrappers._T<SNode>();
    ModelAccess.instance().runReadAction(new _Adapters._return_P0_E0_to_Runnable_adapter(new _FunctionTypes._return_P0_E0<SNode>() {
      public SNode invoke() {
        return node.value = check_h3hwcn_a0a0a1a0(getNodePointer());
      }
    }));
    return node.value;
  }

  public SNodePointer getNodePointer() {
    if (this.getModelId() == null || this.getNodeId() == null) {
      return null;
    }
    return new SNodePointer(this.getModelId(), this.getNodeId());
  }

  public void setNode(@Nullable final SNode node) {
    if (node == null) {
      this.setModelId(null);
      this.setNodeId(null);
    } else {
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          NodeByConcept_Configuration.this.setModelId(node.getModel().getModelDescriptor().getSModelReference().toString());
          NodeByConcept_Configuration.this.setNodeId(node.getId());
        }
      });
    }
  }

  @Override
  public NodeByConcept_Configuration clone() {
    NodeByConcept_Configuration clone = null;
    try {
      clone = createCloneTemplate();
      clone.myState = (NodeByConcept_Configuration.MyState) myState.clone();
      return clone;
    } catch (CloneNotSupportedException ex) {
      if (log.isErrorEnabled()) {
        log.error("", ex);
      }
    }
    return clone;
  }

  public NodeByConcept_Configuration createCloneTemplate() {
    return new NodeByConcept_Configuration(myConcept, myIsValid);
  }

  public NodeByConcept_Configuration_Editor getEditor() {
    return new NodeByConcept_Configuration_Editor(myConcept, myIsValid);
  }

  public SettingsEditorEx<NodeByConcept_Configuration> getEditorEx() {
    if (myEditorEx == null) {
      myEditorEx = getEditor();
    }
    return myEditorEx;
  }

  private static SNode check_h3hwcn_a0a0a1a0(SNodePointer checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getNode();
    }
    return null;
  }

  public class MyState {
    public String myNodeId;
    public String myModelId;

    public MyState() {
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
      NodeByConcept_Configuration.MyState state = new NodeByConcept_Configuration.MyState();
      state.myNodeId = myNodeId;
      state.myModelId = myModelId;
      return state;
    }
  }
}
