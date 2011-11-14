package jetbrains.mps.build.packaging.plugin;

/*Generated by MPS */

import com.intellij.openapi.project.Project;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.project.MPSExtentions;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.smodel.SModelDescriptor;
import com.intellij.openapi.progress.EmptyProgressIndicator;
import java.util.List;
import jetbrains.mps.project.structure.modules.ModuleReference;
import jetbrains.mps.project.Solution;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.smodel.descriptor.EditableSModelDescriptor;
import jetbrains.mps.project.MPSProject;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.progress.Task;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.progress.ProgressIndicator;
import jetbrains.mps.project.StandaloneMPSProject;
import com.intellij.openapi.application.ModalityState;
import java.util.Arrays;
import com.intellij.openapi.vfs.VirtualFile;
import java.io.File;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.util.MacrosFactory;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.build.packaging.behavior.Layout_Behavior;
import jetbrains.mps.ide.navigation.NavigationSupport;
import java.util.Map;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.HashMap;
import java.util.Set;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import java.util.LinkedHashSet;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class BuildGeneratorImpl extends AbstractBuildGenerator {
  private final Project myProject;
  private IOperationContext myOperationContext;

  public BuildGeneratorImpl(Project project, IOperationContext context) {
    this.myProject = project;
    this.myOperationContext = context;
    String projectName = this.myProject.getName();
    if (projectName.endsWith(MPSExtentions.DOT_MPS_PROJECT)) {
      projectName = projectName.substring(0, projectName.length() - MPSExtentions.DOT_MPS_PROJECT.length());
    }
    this.setProjectName(projectName);
    this.setValidDefaultSolutionName(projectName);
  }

  public void generate() {
    ModelAccess.instance().runCommandInEDT(new Runnable() {
      public void run() {
        final SModelDescriptor descriptor = BuildGeneratorImpl.this.getSModelDescriptor(new EmptyProgressIndicator());
        final String projectName = BuildGeneratorImpl.this.getProjectName();
        final String projectBasedirPath = BuildGeneratorImpl.this.myProject.getBaseDir().getPath();
        final List<NodeData> modules = BuildGeneratorImpl.this.getModules();
        final List<ModuleReference> moduleReferencesToAdd = BuildGeneratorImpl.this.getModuleReferencesToAdd();
        Runnable runnable;
        Solution solution = (Solution) descriptor.getModule();
        for (ModuleReference ref : ListSequence.fromList(moduleReferencesToAdd)) {
          (solution).getModuleDescriptor().getUsedLanguages().add(ref);
        }
        for (ModuleReference ref : ListSequence.fromList(moduleReferencesToAdd)) {
          descriptor.getSModel().addLanguage(ref);
        }
        runnable = BuildGeneratorImpl.this.generate(((EditableSModelDescriptor) descriptor), projectName, projectBasedirPath, modules);
        runnable.run();
        final MPSProject project = BuildGeneratorImpl.this.myProject.getComponent(MPSProject.class);
        project.addModule(solution.getModuleReference());
        ApplicationManager.getApplication().invokeLater(new Runnable() {
          public void run() {
            ProgressManager.getInstance().run(new Task.Modal(BuildGeneratorImpl.this.myProject, "Reloading Classes", false) {
              public void run(@NotNull ProgressIndicator progressIndicator) {
                progressIndicator.setIndeterminate(true);
                progressIndicator.setText("Reloading Classes... Please Wait");
                ModelAccess.instance().runWriteAction(new Runnable() {
                  public void run() {
                    ((StandaloneMPSProject) project).update();
                  }
                });
              }
            });
          }
        }, ModalityState.NON_MODAL);
      }
    }, myProject.getComponent(MPSProject.class));
  }

  protected List<ModuleReference> getModuleReferencesToAdd() {
    return Arrays.asList(BuildGeneratorUtil.getPackagingLanguageReference());
  }

  public SModelDescriptor getSModelDescriptor(ProgressIndicator indicator) {
    if (this.getCreateModel()) {
      Solution solution;
      if (this.getCreateSolution()) {
        VirtualFile projectBaseDir = this.myProject.getBaseDir();
        //  get solution 
        String solutionName = this.getNewSolutionName();
        String solutionBaseDir = projectBaseDir.getPath() + File.separator + "solutions" + File.separator + solutionName;
        MPSProject mpsProject = this.myProject.getComponent(MPSProject.class);
        indicator.setText("Creating Solution...");
        solution = BuildGeneratorUtil.createSolution(mpsProject, solutionName, solutionBaseDir);
      } else {
        solution = this.getSolution();
      }
      indicator.setText("Creating Model...");
      return BuildGeneratorUtil.createModel(this.getNewModelName(), solution);
    } else {
      return this.getModel();
    }
  }

  private void setValidDefaultSolutionName(String projectName) {
    String solutionNamePrefix = projectName + ".build";
    String solutionName = solutionNamePrefix;
    int count = 0;
    while (!(this.isValidSolutionName(solutionName))) {
      solutionName = solutionNamePrefix + count;
      count++;
    }
    this.setNewSolutionName(solutionName);
  }

  public Runnable generate(final EditableSModelDescriptor targetModelDescriptor, String name, String basedir, List<NodeData> selectedData) {
    final SNode mpsLayout = this.createMPSLayout(targetModelDescriptor, name, basedir, selectedData);
    return new Runnable() {
      public void run() {
        BuildGeneratorImpl.this.finishGeneration(targetModelDescriptor, mpsLayout);
      }
    };
  }

  protected SNode createMPSLayout(SModelDescriptor targetModelDescriptor, String name, String basedir, List<NodeData> selectedData) {
    // create mps layout 
    SNode mpsLayout = SConceptOperations.createNewNode("jetbrains.mps.build.packaging.structure.Layout", null);
    // add mps layout to the target model 
    SModel targetSModel = targetModelDescriptor.getSModel();
    SModelOperations.addRootNode(targetSModel, mpsLayout);
    // set properties 
    SPropertyOperations.set(mpsLayout, "name", name);
    // create basedir path 
    SNode basedirPath;
    String result = MacrosFactory.mpsHomeMacros().shrinkPath(basedir, new File("")).replace("\\", File.separator);
    int index = result.lastIndexOf("}");
    if (index > -1) {
      String macro = result.substring(result.indexOf("{") + 1, index);
      basedirPath = PackagingLanguageGenerator.createBasedirPath(macro, result.substring(index + 2));
    } else {
      basedirPath = PackagingLanguageGenerator.createBasedirPath("", basedir);
    }
    SLinkOperations.setTarget(mpsLayout, "baseDirectory", basedirPath, true);
    SLinkOperations.setTarget(mpsLayout, "scriptsDirectory", new BuildGeneratorImpl.QuotationClass_un708i_a0a0n0f().createNode(Layout_Behavior.getBasedirName_1226509010730()), true);
    SLinkOperations.setTarget(mpsLayout, "deployDirectory", new BuildGeneratorImpl.QuotationClass_un708i_a0a0o0f().createNode(Layout_Behavior.getBasedirName_1226509010730()), true);
    // 
    SPropertyOperations.set(mpsLayout, "compile", "" + (true));
    SPropertyOperations.set(ListSequence.fromList(SLinkOperations.getTargets(mpsLayout, "configuration", true)).first(), "name", "default");
    // create zip 
    SNode zip = SConceptOperations.createNewNode("jetbrains.mps.build.packaging.structure.Zip", null);
    SLinkOperations.setTarget(zip, "title", PackagingLanguageGenerator.createSimpleString(name + ".zip"), true);
    ListSequence.fromList(SLinkOperations.getTargets(mpsLayout, "component", true)).addElement(zip);
    // create folder inside zip 
    SNode folder = PackagingLanguageGenerator.createFolder(name);
    ListSequence.fromList(SLinkOperations.getTargets(zip, "entry", true)).addElement(folder);
    // add modules to folder 
    BuildGeneratorImpl.createContent(selectedData, folder, targetSModel);
    return mpsLayout;
  }

  protected void finishGeneration(final EditableSModelDescriptor targetModelDescriptor, SNode mpsLayout) {
    ModelAccess.instance().runWriteActionInCommand(new Runnable() {
      public void run() {
        targetModelDescriptor.getModule().save();
        targetModelDescriptor.save();
      }
    });
    NavigationSupport.getInstance().openNode(myOperationContext, mpsLayout, true, true);
  }

  public static SNode createComponent(NodeData data, SModel targetSModel) {
    if (data instanceof ModuleData) {
      return PackagingLanguageGenerator.createModule(((ModuleData) data).getModule());
    } else if (data instanceof NamespaceData) {
      String namespace = ((NamespaceData) data).getText();
      return PackagingLanguageGenerator.createFolder(namespace);
    }
    return null;
  }

  private static void createContent(List<NodeData> selectedData, SNode folder, SModel targetSModel) {
    Map<NodeData, SNode> createdComponent = MapSequence.fromMap(new HashMap<NodeData, SNode>());
    Set<SNode> topLevel = SetSequence.fromSet(new LinkedHashSet<SNode>());
    for (NodeData data : ListSequence.fromList(selectedData)) {
      // creating component 
      SNode component = createComponent(data, targetSModel);
      if (component == null) {
        continue;
      }
      MapSequence.fromMap(createdComponent).put(data, component);
      SetSequence.fromSet(topLevel).addElement(component);
      // dealing with children 
      if (SNodeOperations.isInstanceOf(component, "jetbrains.mps.build.packaging.structure.ICompositeComponent")) {
        List<NodeData> children = data.getChildren();
        for (NodeData child : ListSequence.fromList(children)) {
          if (MapSequence.fromMap(createdComponent).containsKey(child)) {
            SNode childComponent = MapSequence.fromMap(createdComponent).get(child);
            ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(component, "jetbrains.mps.build.packaging.structure.ICompositeComponent"), "entry", true)).addElement(childComponent);
            if (SetSequence.fromSet(topLevel).contains(childComponent)) {
              SetSequence.fromSet(topLevel).removeElement(childComponent);
            }
          }
        }
      }
      // dealing with parent 
      NodeData parent = data.getParent();
      if (parent == null) {
        break;
      }
      if (MapSequence.fromMap(createdComponent).containsKey(parent)) {
        ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(MapSequence.fromMap(createdComponent).get(parent), "jetbrains.mps.build.packaging.structure.ICompositeComponent"), "entry", true)).addElement(component);
        SetSequence.fromSet(topLevel).removeElement(component);
      }
    }
    // 
    for (SNode topLevelComponent : SetSequence.fromSet(topLevel)) {
      ListSequence.fromList(SLinkOperations.getTargets(folder, "entry", true)).addElement(topLevelComponent);
    }
  }

  public static class QuotationClass_un708i_a0a0n0f {
    public QuotationClass_un708i_a0a0n0f() {
    }

    public SNode createNode(Object parameter_9) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      SNode quotedNode_2 = null;
      SNode quotedNode_3 = null;
      SNode quotedNode_4 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.build.packaging.structure.Path", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_5 = quotedNode_1;
        {
          quotedNode_2 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.build.packaging.structure.MacroReference", null, GlobalScope.getInstance(), false);
          SNode quotedNode1_6 = quotedNode_2;
          quotedNode1_6.setProperty("name", (String) parameter_9);
          quotedNode_1.addChild("macro", quotedNode1_6);
        }
        {
          quotedNode_3 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.build.packaging.structure.CompositePathComponent", null, GlobalScope.getInstance(), false);
          SNode quotedNode1_7 = quotedNode_3;
          {
            quotedNode_4 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.build.packaging.structure.PathComponent", null, GlobalScope.getInstance(), false);
            SNode quotedNode1_8 = quotedNode_4;
            quotedNode1_8.setProperty("path", "build");
            quotedNode_3.addChild("pathComponent", quotedNode1_8);
          }
          quotedNode_1.addChild("compositePathComponent", quotedNode1_7);
        }
        result = quotedNode1_5;
      }
      return result;
    }
  }

  public static class QuotationClass_un708i_a0a0o0f {
    public QuotationClass_un708i_a0a0o0f() {
    }

    public SNode createNode(Object parameter_9) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      SNode quotedNode_2 = null;
      SNode quotedNode_3 = null;
      SNode quotedNode_4 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.build.packaging.structure.Path", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_5 = quotedNode_1;
        {
          quotedNode_2 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.build.packaging.structure.MacroReference", null, GlobalScope.getInstance(), false);
          SNode quotedNode1_6 = quotedNode_2;
          quotedNode1_6.setProperty("name", (String) parameter_9);
          quotedNode_1.addChild("macro", quotedNode1_6);
        }
        {
          quotedNode_3 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.build.packaging.structure.CompositePathComponent", null, GlobalScope.getInstance(), false);
          SNode quotedNode1_7 = quotedNode_3;
          {
            quotedNode_4 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.build.packaging.structure.PathComponent", null, GlobalScope.getInstance(), false);
            SNode quotedNode1_8 = quotedNode_4;
            quotedNode1_8.setProperty("path", "artifacts");
            quotedNode_3.addChild("pathComponent", quotedNode1_8);
          }
          quotedNode_1.addChild("compositePathComponent", quotedNode1_7);
        }
        result = quotedNode1_5;
      }
      return result;
    }
  }
}
