package jetbrains.mps.buildScript.util;

/*Generated by MPS */

import java.util.Map;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.HashMap;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.SNodePointer;
import jetbrains.mps.buildScript.behavior.Environment_Behavior;

public abstract class Context {
  private Map<String, Object> myProperties = MapSequence.fromMap(new HashMap<String, Object>());

  public Context() {
  }

  @Nullable
  public Object put(String key, Object value) {
    Object previousValue = MapSequence.fromMap(myProperties).get(key);
    MapSequence.fromMap(myProperties).put(key, value);
    return previousValue;
  }

  @Nullable
  public <T> T get(String key) {
    return ((T) MapSequence.fromMap(myProperties).get(key));
  }

  public abstract String getBasePath_Local();

  public String getTmpPath_WithMacro() {
    return "${tmp}";
  }

  public String getArtifactsPath_WithMacro() {
    return "${deploy.dir}";
  }

  @Nullable
  public static Context defaultContext(SNode node) {
    SNode ancestor = SNodeOperations.getAncestor(node, "jetbrains.mps.buildScript.structure.Environment", true, false);
    if (ancestor == null) {
      return null;
    }
    return new Context.DefaultContext(node);
  }

  public static class DefaultContext extends Context {
    private final SNodePointer myNode;

    public DefaultContext(SNode node) {
      myNode = new SNodePointer(node);
    }

    public SNode getEnvironment() {
      return SNodeOperations.getAncestor(((SNode) myNode.getNode()), "jetbrains.mps.buildScript.structure.Environment", true, false);
    }

    public String getBasePath_Local() {
      return Environment_Behavior.call_getBasePath_4959435991187108495(getEnvironment());
    }
  }
}
