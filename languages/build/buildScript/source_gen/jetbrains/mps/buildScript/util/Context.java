package jetbrains.mps.buildScript.util;

/*Generated by MPS */

import java.util.Map;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.HashMap;
import jetbrains.mps.smodel.SNodeId;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.buildScript.behavior.BuildProject_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import java.util.List;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.generator.template.TemplateQueryContext;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class Context {
  private Map<String, Object> myProperties = MapSequence.fromMap(new HashMap<String, Object>());
  private Map<String, Map<SNodeId, Integer>> myNamesIndex = MapSequence.fromMap(new HashMap<String, Map<SNodeId, Integer>>());

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

  private SNode getBuildProject(SNode node) {
    return SNodeOperations.getAncestor(node, "jetbrains.mps.buildScript.structure.BuildProject", true, false);
  }

  public String getBasePath_Local(SNode node) {
    return BuildProject_Behavior.call_getBasePath_4959435991187146924(this.getBuildProject(node));
  }

  public String getTmpDirMacroName(SNode node) {
    return SPropertyOperations.getString(this.getBuildProject(node), "name") + ".tmp";
  }

  public String getTmpPath_WithMacro(SNode node) {
    return "${build.dir}/tmp/" + SPropertyOperations.getString(getBuildProject(node), "name") + ".tmp";
  }

  public String getDeployDirMacroName(SNode node) {
    return SPropertyOperations.getString(this.getBuildProject(node), "name") + ".deploy.dir";
  }

  public String getDeployPath_WithMacro(SNode node) {
    return "${build.dir}/artifacts/" + SPropertyOperations.getString(getBuildProject(node), "name") + ".artifacts";
  }

  public List<SNode> getExportedMacro(SNode node) {
    List<SNode> exportedMacro = new ArrayList<SNode>();
    ListSequence.fromList(exportedMacro).addElement(new Context.QuotationClass_lmsybr_a0a0b0i().createNode(getTmpPath_WithMacro(node), getTmpDirMacroName(node)));
    ListSequence.fromList(exportedMacro).addElement(new Context.QuotationClass_lmsybr_a0a0c0i().createNode(getDeployPath_WithMacro(node), getDeployDirMacroName(node)));
    return exportedMacro;
  }

  public String getUniqueName(SNode node, String name) {
    Map<SNodeId, Integer> map = MapSequence.fromMap(myNamesIndex).get(name);
    if (map == null) {
      map = MapSequence.fromMap(new HashMap<SNodeId, Integer>());
      MapSequence.fromMap(myNamesIndex).put(name, map);
    }
    Integer integer = MapSequence.fromMap(map).get(node.getSNodeId());
    if (integer == null) {
      integer = MapSequence.fromMap(map).count();
      MapSequence.fromMap(map).put(node.getSNodeId(), integer);
    }
    return name + (((integer == 0) ?
      "" :
      "_" + integer
    ));
  }

  @Nullable
  public static Context defaultContext() {
    return new Context();
  }

  public static Context defaulContext(TemplateQueryContext gencontext) {
    Context context = ((Context) gencontext.getSessionObject(Context.class));
    if (context == null) {
      context = defaultContext();
      gencontext.putSessionObject(Context.class, context);
    }
    return context;
  }

  public static class QuotationClass_lmsybr_a0a0b0i {
    public QuotationClass_lmsybr_a0a0b0i() {
    }

    public SNode createNode(Object parameter_3, Object parameter_4) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.buildScript.structure.ExportedMacroInternal", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.setProperty("defaultPath", (String) parameter_3);
        quotedNode1_2.setProperty("name", (String) parameter_4);
        result = quotedNode1_2;
      }
      return result;
    }
  }

  public static class QuotationClass_lmsybr_a0a0c0i {
    public QuotationClass_lmsybr_a0a0c0i() {
    }

    public SNode createNode(Object parameter_3, Object parameter_4) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.buildScript.structure.ExportedMacroInternal", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.setProperty("defaultPath", (String) parameter_3);
        quotedNode1_2.setProperty("name", (String) parameter_4);
        result = quotedNode1_2;
      }
      return result;
    }
  }
}
