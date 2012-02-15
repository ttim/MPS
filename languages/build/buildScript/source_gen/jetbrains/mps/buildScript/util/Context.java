package jetbrains.mps.buildScript.util;

/*Generated by MPS */

import java.util.Map;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.HashMap;
import jetbrains.mps.smodel.SNodeId;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.project.IModule;
import jetbrains.mps.buildScript.behavior.BuildProject_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import java.util.List;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.vfs.IFile;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.util.MacrosFactory;
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

  @NotNull
  public IModule getModule(SNode node) {
    return node.getModel().getModelDescriptor().getModule();
  }

  public String getBasePath_Local(SNode node) {
    return BuildProject_Behavior.call_getBasePath_4959435991187146924(this.getBuildProject(node), this);
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
    ListSequence.fromList(exportedMacro).addElement(new Context.QuotationClass_lmsybr_a0a0b0j().createNode(getTmpPath_WithMacro(node), getTmpDirMacroName(node)));
    ListSequence.fromList(exportedMacro).addElement(new Context.QuotationClass_lmsybr_a0a0c0j().createNode(getDeployPath_WithMacro(node), getDeployDirMacroName(node)));
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

  public SNode getDefaultScriptsPath() {
    return new Context.QuotationClass_lmsybr_a0a0l().createNode();
  }

  public String getDefaultBasePath(SNode node) {
    IFile descriptorFile = this.getModule(node).getDescriptorFile();
    assert descriptorFile != null : "Context " + this + " returned module " + this.getModule(node) + " for node " + node + " with null descriptor.";
    return descriptorFile.getParent().getPath();
  }

  public _FunctionTypes._return_P1_E0<? extends String, ? super String> shrinkPath(final SNode node) {
    return new _FunctionTypes._return_P1_E0<String, String>() {
      public String invoke(String fullPath) {
        final Wrappers._T<IModule> module = new Wrappers._T<IModule>();
        ModelAccess.instance().runReadAction(new Runnable() {
          public void run() {
            module.value = getModule(node);
          }
        });
        return MacrosFactory.moduleDescriptor(module.value).shrinkPath(fullPath, module.value.getDescriptorFile());
      }
    };
  }

  public _FunctionTypes._return_P1_E0<? extends String, ? super String> expandPath(final SNode node) {
    return new _FunctionTypes._return_P1_E0<String, String>() {
      public String invoke(String shortPath) {
        final Wrappers._T<IModule> module = new Wrappers._T<IModule>();
        ModelAccess.instance().runReadAction(new Runnable() {
          public void run() {
            module.value = getModule(node);
          }
        });
        return MacrosFactory.moduleDescriptor(module.value).expandPath(shortPath, module.value.getDescriptorFile());
      }
    };
  }

  @NotNull
  public static Context defaultContext() {
    return new Context();
  }

  @NotNull
  public static Context defaulContext(final TemplateQueryContext gencontext) {
    Context context = ((Context) gencontext.getSessionObject(Context.class));
    if (context == null) {
      context = new Context() {
        @Override
        public IModule getModule(SNode node) {
          return gencontext.getOriginalInputModel().getModelDescriptor().getModule();
        }
      };
      gencontext.putSessionObject(Context.class, context);
    }
    return context;
  }

  public static class QuotationClass_lmsybr_a0a0b0j {
    public QuotationClass_lmsybr_a0a0b0j() {
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

  public static class QuotationClass_lmsybr_a0a0c0j {
    public QuotationClass_lmsybr_a0a0c0j() {
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

  public static class QuotationClass_lmsybr_a0a0l {
    public QuotationClass_lmsybr_a0a0l() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      SNode quotedNode_2 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.buildScript.structure.BuildSourceProjectRelativePath", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_3 = quotedNode_1;
        {
          quotedNode_2 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.buildScript.structure.CompositePath", null, GlobalScope.getInstance(), false);
          SNode quotedNode1_4 = quotedNode_2;
          quotedNode1_4.setProperty("head", "build");
          quotedNode_1.addChild("compositePart", quotedNode1_4);
        }
        result = quotedNode1_3;
      }
      return result;
    }
  }
}
