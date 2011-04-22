package jetbrains.mps.build.packaging.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.util.MacrosFactory;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.ISelector;
import java.io.File;
import jetbrains.mps.build.packaging.generator.buildlanguage.template.util.Util;
import jetbrains.mps.project.StubPath;
import jetbrains.mps.project.AbstractModule;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.project.SModelRoot;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.smodel.Generator;
import jetbrains.mps.internal.collections.runtime.ITranslator2;
import jetbrains.mps.project.IModule;
import jetbrains.mps.project.structure.modules.Dependency;
import jetbrains.mps.smodel.MPSModuleRepository;
import jetbrains.mps.project.Solution;
import jetbrains.mps.project.MPSExtentions;
import jetbrains.mps.project.ModuleId;
import jetbrains.mps.vfs.IFile;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.util.Macros;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.project.DevKit;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;

public class Module_Behavior {
  public static void init(SNode thisNode) {

  }

  public static String call_getTemporalDir_1213877514765(SNode thisNode) {
    return SPropertyOperations.getString(thisNode, "name") + ".tmp";
  }

  public static boolean call_isCompiledInMPS_1213877514774(SNode thisNode) {
    return Module_Behavior.call_getModule_1213877515148(thisNode).isCompileInMPS();
  }

  public static SNode call_getModuleBaseDirectory_6863060912307757632(SNode thisNode) {
    String descriptor = Module_Behavior.call_getMacros_1213877515158(thisNode).expandPath(MacrosFactory.getMacroString(Module_Behavior.call_getModule_1213877515148(thisNode)), Module_Behavior.call_getModule_1213877515148(thisNode).getDescriptorFile());
    return Module_Behavior.call_getPathHolder_1239195000114(thisNode, ModuleUtil.getRelativePath(descriptor, AbstractProjectComponent_Behavior.call_getHomeFile_1213877333764(thisNode)));
  }

  public static SNode call_getModuleDescriptorFile_6863060912307764362(SNode thisNode) {
    return Module_Behavior.call_getPathHolder_1239195000114(thisNode, Module_Behavior.call_getModule_1213877515148(thisNode).getDescriptorFile().getPath());
  }

  public static List<SNode> call_getSourcesDirectories_1775602641704992067(SNode thisNode) {
    return Module_Behavior.call_getPathHolders_1213877515000(thisNode, ListSequence.fromList(ListSequence.fromListWithValues(new ArrayList<String>(), Module_Behavior.call_getModule_1213877515148(thisNode).getSourcePaths())).<String>select(new ISelector<String, String>() {
      public String select(String it) {
        return it.replace(File.separator, Util.SEPARATOR);
      }
    }).toListSequence(), false);
  }

  public static List<SNode> call_getClassPathDirectories_1213877515083(SNode thisNode) {
    List<StubPath> paths = ((AbstractModule) Module_Behavior.call_getModule_1213877515148(thisNode)).getAllStubPaths();
    return Module_Behavior.call_getPathHolders_1213877515000(thisNode, Sequence.fromIterable(Module_Behavior.call_convertSeparators_4777659345279794559(thisNode, paths)).distinct().toListSequence(), true);
  }

  public static List<SNode> call_getModelRootPaths_2739262311775052381(SNode thisNode) {
    List<SModelRoot> paths = ((AbstractModule) Module_Behavior.call_getModule_1213877515148(thisNode)).getSModelRoots();
    if (Module_Behavior.call_getModule_1213877515148(thisNode) instanceof Language) {
      paths = ListSequence.fromListWithValues(new ArrayList<SModelRoot>(), paths);
      ListSequence.fromList(paths).addSequence(Sequence.fromIterable(((Iterable<Generator>) ((Language) Module_Behavior.call_getModule_1213877515148(thisNode)).getGenerators())).<SModelRoot>translate(new ITranslator2<Generator, SModelRoot>() {
        public Iterable<SModelRoot> translate(Generator it) {
          return it.getSModelRoots();
        }
      }));
    }
    return Module_Behavior.call_getPathHolders_1213877515000(thisNode, ListSequence.fromList(paths).<String>select(new ISelector<SModelRoot, String>() {
      public String select(SModelRoot it) {
        return it.getPath();
      }
    }).distinct().toListSequence(), true);
  }

  public static List<SNode> call_getRuntimeClassPath_1213877515098(SNode thisNode, boolean includeRuntimeSolutions) {
    IModule module = Module_Behavior.call_getModule_1213877515148(thisNode);
    if (module instanceof Language) {
      List<StubPath> paths = ((Language) module).getRuntimeStubPaths();
      List<SNode> result = ListSequence.fromList(Module_Behavior.call_getPathHolders_1213877515000(thisNode, Sequence.fromIterable(Module_Behavior.call_convertSeparators_4777659345279794559(thisNode, paths)).distinct().toListSequence(), true)).subtract(ListSequence.fromList(Module_Behavior.call_getClassPathDirectories_1213877515083(thisNode))).toListSequence();
      if (includeRuntimeSolutions) {
        for (Dependency rdep : ListSequence.fromList(((Language) module).getRuntimeDependOn())) {
          IModule rs = MPSModuleRepository.getInstance().getModule(rdep.getModuleRef());
          if (rs instanceof Solution) {
            Solution sol = (Solution) rs;
            paths = sol.getAllStubPaths();
            // TODO proper module in holder? 
            ListSequence.fromList(result).addSequence(ListSequence.fromList(Module_Behavior.call_getPathHolders_1213877515000(thisNode, Sequence.fromIterable(Module_Behavior.call_convertSeparators_4777659345279794559(thisNode, paths)).toListSequence(), true)));
          }
        }
      }
      return result;
    }
    return new ArrayList<SNode>();
  }

  public static SNode call_getClassesGen_3315989002810564857(SNode thisNode) {
    return Module_Behavior.call_getPathHolder_1239195000114(thisNode, Module_Behavior.call_getModule_1213877515148(thisNode).getClassesGen().getPath());
  }

  public static String call_getRuntimeJarPath_1213877515126(SNode thisNode) {
    return ModuleUtil.getRelativePath(AbstractProjectComponent_Behavior.call_getPath_1213877333777(thisNode).getPath(), AbstractProjectComponent_Behavior.call_getHomeFile_1213877333764(thisNode)) + "." + MPSExtentions.RUNTIME_ARCH;
  }

  public static String call_getModuleJarPath_1213877515137(SNode thisNode) {
    return ModuleUtil.getRelativePath(AbstractProjectComponent_Behavior.call_getPath_1213877333777(thisNode).getPath(), AbstractProjectComponent_Behavior.call_getHomeFile_1213877333764(thisNode)) + "." + MPSExtentions.MPS_ARCH;
  }

  public static IModule call_getModule_1213877515148(SNode thisNode) {
    return MPSModuleRepository.getInstance().getModuleById(ModuleId.fromString(SPropertyOperations.getString(thisNode, "id")));
  }

  public static IFile call_findMPSProjectFile_1213877514840(SNode thisNode, IFile file) {
    if (AbstractProjectComponent_Behavior.call_getHomeFile_1213877333764(thisNode).getAbsolutePath().startsWith(file.getPath()) && !(AbstractProjectComponent_Behavior.call_getHomeFile_1213877333764(thisNode).getAbsolutePath().equals(file.getPath()))) {
      return null;
    }
    List<IFile> children = file.getChildren();
    for (IFile child : children) {
      if (!(child.isDirectory()) && (child.getName().endsWith(MPSExtentions.DOT_MPS_PROJECT))) {
        return child.getParent();
      }
    }
    return Module_Behavior.call_findMPSProjectFile_1213877514840(thisNode, file.getParent());
  }

  public static String call_getProjectBasedir_1213877514893(SNode thisNode) {
    IFile file = Module_Behavior.call_findMPSProjectFile_1213877514840(thisNode, Module_Behavior.call_getModule_1213877515148(thisNode).getDescriptorFile().getParent());
    if (file == null) {
      return null;
    }
    return file.getPath().replace(File.separator, Util.SEPARATOR);
  }

  public static String call_getChildrenTargetDir_1213877514970(SNode thisNode) {
    if (SNodeOperations.isInstanceOf(SNodeOperations.getParent(thisNode), "jetbrains.mps.build.packaging.structure.IAbstractCompositeComponent")) {
      return IAbstractCompositeComponent_Behavior.call_getChildrenTargetDir_1237389224202(SNodeOperations.cast(SNodeOperations.getParent(thisNode), "jetbrains.mps.build.packaging.structure.IAbstractCompositeComponent")) + File.separator + Module_Behavior.call_getTemporalDir_1213877514765(thisNode);
    }
    return Module_Behavior.call_getTemporalDir_1213877514765(thisNode);
  }

  public static SNode call_getPathHolder_1239195000114(SNode thisNode, String path) {
    path = path.replace(File.separator, Util.SEPARATOR);
    SNode pathHolder = new Module_Behavior.QuotationClass_835h7m_a0a1a61().createNode(ModuleUtil.getRelativePath(path, AbstractProjectComponent_Behavior.call_getHomeFile_1213877333764(thisNode).getPath()), thisNode, ModuleUtil.getRelativePath(path, Module_Behavior.call_getModuleDescriptorPath_4777659345280330855(thisNode)));
    if (SPropertyOperations.getString(pathHolder, "fullPath").equals(path)) {
      ModuleUtil.findMacro(pathHolder, SLinkOperations.getTargets(SNodeOperations.getAncestor(thisNode, "jetbrains.mps.build.packaging.structure.Layout", true, true), "macro", true));
    }
    if (SPropertyOperations.getString(pathHolder, "moduleRelativePath").equals(path)) {
      if (path.equals(Module_Behavior.call_getModuleDescriptorPath_4777659345280330855(thisNode))) {
        SPropertyOperations.set(pathHolder, "moduleRelativePath", "");
      } else {
        SPropertyOperations.set(pathHolder, "moduleRelativePath", null);
      }
    }
    return pathHolder;
  }

  public static List<SNode> call_getPathHolders_1213877515000(SNode thisNode, List<String> stubpath, boolean onlyUnderProjectBasedir) {
    List<SNode> result = new ArrayList<SNode>();
    String projectBasedir = "";
    // search for project if needed 
    if (onlyUnderProjectBasedir) {
      projectBasedir = Module_Behavior.call_getProjectBasedir_1213877514893(thisNode);
      if (projectBasedir == null) {
        projectBasedir = Module_Behavior.call_getModule_1213877515148(thisNode).getDescriptorFile().getParent().getPath().replace(File.separator, Util.SEPARATOR);
      }
    }
    // process classpath 
    for (String cp : ListSequence.fromList(stubpath)) {
      if (!(onlyUnderProjectBasedir) || cp.startsWith(projectBasedir)) {
        ListSequence.fromList(result).addElement(Module_Behavior.call_getPathHolder_1239195000114(thisNode, cp));
      }
    }
    return result;
  }

  public static Macros call_getMacros_1213877515158(SNode thisNode) {
    return MacrosFactory.moduleDescriptor(Module_Behavior.call_getModule_1213877515148(thisNode));
  }

  public static Iterable<String> call_convertSeparators_4777659345279794559(SNode thisNode, List<StubPath> paths) {
    return ListSequence.fromList(paths).<String>select(new ISelector<StubPath, String>() {
      public String select(StubPath it) {
        return it.getPath().replace(File.separator, Util.SEPARATOR);
      }
    });
  }

  public static String call_getModuleDescriptorPath_4777659345280330855(SNode thisNode) {
    return check_835h7m_a0a91(Module_Behavior.call_getModule_1213877515148(thisNode).getDescriptorFile().getParent().getPath(), File.separator, Util.SEPARATOR);
  }

  public static List<IModule> getAllAvailableModules_1222444746697() {
    List<IModule> list = ListSequence.fromList(new ArrayList<IModule>());
    for (Language language : ListSequence.fromList(GlobalScope.getInstance().getVisibleLanguages())) {
      ListSequence.fromList(list).addElement(language);
    }
    for (DevKit devKit : ListSequence.fromList(GlobalScope.getInstance().getVisibleDevkits())) {
      ListSequence.fromList(list).addElement(devKit);
    }
    for (Solution solution : ListSequence.fromList(GlobalScope.getInstance().getVisibleSolutions())) {
      ListSequence.fromList(list).addElement(solution);
    }
    return list;
  }

  public static String extractModuleProperName_1235487584035(IModule module) {
    return Module_Behavior.replaceBadCharacters_1235487831795(module.getModuleFqName());
  }

  public static String replaceBadCharacters_1235487831795(String name) {
    return name.replace("/", "_").replace("\\", "_");
  }

  private static String check_835h7m_a0a91(String checkedDotOperand, String separator, String SEPARATOR) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.replace(File.separator, Util.SEPARATOR);
    }
    return null;
  }

  public static class QuotationClass_835h7m_a0a1a61 {
    public QuotationClass_835h7m_a0a1a61() {
    }

    public SNode createNode(Object parameter_3, Object parameter_4, Object parameter_5) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.build.packaging.structure.PathHolder", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.setProperty("fullPath", (String) parameter_3);
        quotedNode1_2.setProperty("moduleRelativePath", (String) parameter_5);
        quotedNode1_2.setReferent("module", (SNode) parameter_4);
        result = quotedNode1_2;
      }
      return result;
    }
  }
}
