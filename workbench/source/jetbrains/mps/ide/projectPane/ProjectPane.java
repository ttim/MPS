/*
 * Copyright 2003-2009 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jetbrains.mps.ide.projectPane;

import com.intellij.ide.*;
import com.intellij.ide.projectView.ProjectView;
import com.intellij.ide.projectView.impl.AbstractProjectViewPane;
import com.intellij.ide.projectView.impl.ProjectViewPane;
import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.command.CommandAdapter;
import com.intellij.openapi.command.CommandEvent;
import com.intellij.openapi.command.CommandProcessor;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.fileEditor.FileEditor;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.fileEditor.FileEditorManagerAdapter;
import com.intellij.openapi.fileEditor.FileEditorManagerEvent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.startup.StartupManager;
import com.intellij.openapi.util.ActionCallback;
import com.intellij.openapi.util.Computable;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.VirtualFileManager;
import com.intellij.openapi.vfs.VirtualFileManagerListener;
import com.intellij.openapi.wm.ToolWindowId;
import com.intellij.openapi.wm.ToolWindowManager;
import com.intellij.openapi.wm.ToolWindow;
import jetbrains.mps.MPSProjectHolder;
import jetbrains.mps.generator.GenerationListener;
import jetbrains.mps.generator.GeneratorManager;
import jetbrains.mps.generator.TransientModelsModule;
import jetbrains.mps.ide.IEditor;
import jetbrains.mps.ide.IdeMain;
import jetbrains.mps.ide.IdeMain.TestMode;
import jetbrains.mps.ide.ThreadUtils;
import jetbrains.mps.ide.actions.*;
import jetbrains.mps.ide.projectPane.ProjectPane.MyState;
import jetbrains.mps.ide.ui.MPSTree;
import jetbrains.mps.ide.ui.MPSTree.TreeState;
import jetbrains.mps.ide.ui.MPSTreeNode;
import jetbrains.mps.ide.ui.MPSTreeNodeEx;
import jetbrains.mps.ide.ui.TextTreeNode;
import jetbrains.mps.ide.ui.smodel.PackageNode;
import jetbrains.mps.ide.ui.smodel.SModelTreeNode;
import jetbrains.mps.ide.ui.smodel.SNodeTreeNode;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.nodeEditor.EditorComponent;
import jetbrains.mps.project.*;
import jetbrains.mps.reloading.ClassLoaderManager;
import jetbrains.mps.reloading.ReloadAdapter;
import jetbrains.mps.reloading.ReloadListener;
import jetbrains.mps.smodel.*;
import jetbrains.mps.util.Condition;
import jetbrains.mps.util.Pair;
import jetbrains.mps.vfs.IFile;
import jetbrains.mps.vfs.VFileSystem;
import jetbrains.mps.workbench.ActionPlace;
import jetbrains.mps.workbench.MPSDataKeys;
import jetbrains.mps.workbench.action.ActionUtils;
import jetbrains.mps.workbench.editors.MPSEditorOpener;
import jetbrains.mps.workbench.editors.MPSFileNodeEditor;
import jetbrains.mps.workbench.nodesFs.MPSNodeVirtualFile;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.tree.*;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

@State(
  name = "MPSProjectPane",
  storages = {
    @Storage(
      id = "other",
      file = "$WORKSPACE_FILE$"
    )
  }
)
public class ProjectPane extends AbstractProjectViewPane implements PersistentStateComponent<MyState> {
  private static final Logger LOG = Logger.getLogger(ProjectPane.class);

  public static final String PROJECT_PANE_NODE_ACTIONS = NodeActions_ActionGroup.ID;
  public static final String PROJECT_PANE_MODEL_ACTIONS = ModelActions_ActionGroup.ID;
  public static final String PROJECT_PANE_LANGUAGE_ACTIONS = LanguageActions_ActionGroup.ID;
  public static final String PROJECT_PANE_DEVKIT_ACTIONS = DevkitActions_ActionGroup.ID;
  public static final String PROJECT_PANE_PROJECT_ACTIONS = ProjectActions_ActionGroup.ID;
  public static final String PROJECT_PANE_SOLUTION_ACTIONS = SolutionActions_ActionGroup.ID;
  public static final String PROJECT_PANE_GENERATOR_ACTIONS = GeneratorActions_ActionGroup.ID;
  public static final String PROJECT_PANE_TRANSIENT_MODULES_ACTIONS = TransientModulesActions_ActionGroup.ID;
  public static final String PROJECT_PANE_PACKAGE_ACTIONS = PackageActions_ActionGroup.ID;
  public static final String PROJECT_PANE_NAMESPACE_ACTIONS = NamespaceActions_ActionGroup.ID;

  public static final String PROJECT_NEW_ACTIONS = ProjectNewActions_ActionGroup.ID;
  public static final String SOLUTION_NEW_ACTIONS = SolutionNewActions_ActionGroup.ID;
  public static final String LANGUAGE_NEW_ACTIONS = LanguageNewActions_ActionGroup.ID;
  public static final String GENERATOR_NEW_ACTIONS = GeneratorNewActions_ActionGroup.ID;

  private SModelRepositoryListener mySModelRepositoryListener = new MyModelRepositoryAdapter();
  private MyCommandListener myCommandListener = new MyCommandListener();
  private MyModuleRepositoryListener myRepositoryListener = new MyModuleRepositoryListener();
  private boolean myNeedRebuild = false;
  private boolean myDisposed;
  private ProjectModulesPoolTreeNode myModulesPool;
  private ProjectView myProjectView;

  private MyScrollPane myScrollPane;
  private boolean myLastPropertiesState;

  private VirtualFileManagerListener myRefreshListener = new RefreshListener();

  public static final String ID = ProjectViewPane.ID;

  private ReloadListener myReloadListener = new ReloadAdapter() {
    public void onAfterReload() {
      ModelAccess.instance().runReadInEDT(new Runnable() {
        public void run() {
          rebuild();
        }
      });
    }
  };

  private GenerationListener myGenerationListener = new GenerationListener() {
    public void beforeGeneration(List<Pair<SModelDescriptor, IOperationContext>> inputModels) {

    }

    public void modelsGenerated(List<Pair<SModelDescriptor, IOperationContext>> models, boolean success) {
    }

    public void afterGeneration(List<Pair<SModelDescriptor, IOperationContext>> inputModels) {
      // rebuild tree in case of 'cancel' too (need to get 'transient models' node rebuilt)
      ModelAccess.instance().runReadInEDT(new Runnable() {
        public void run() {
          rebuild();
        }
      });
    }
  };
  private FileEditorManagerAdapter myEditorListener = new FileEditorManagerAdapter() {
    public void selectionChanged(FileEditorManagerEvent event) {
      FileEditor fileEditor = event.getNewEditor();
      if (fileEditor instanceof MPSFileNodeEditor) {
        final MPSFileNodeEditor editor = (MPSFileNodeEditor) fileEditor;
        if (myProjectView.isAutoscrollFromSource(ID)) {
          EditorComponent editorComponent = editor.getNodeEditor().getCurrentEditorComponent();
          if (editorComponent == null) return;
          final SNode sNode = editorComponent.getEditedNode();
          ModelAccess.instance().runReadInEDT(new Runnable() {
            public void run() {
              selectNode(sNode);
            }
          });
        }
      }
    }
  };

  public ProjectPane(Project project, ProjectView projectView) {
    super(project);
    myProjectView = projectView;
    myLastPropertiesState = projectView.isShowMembers(ID);

    myTree = new MyTree();

    myScrollPane = new MyScrollPane(getTree());
    getTree().addKeyListener(new KeyAdapter() {
      public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_F4 && e.getModifiers() == 0) {
          openEditor();
          e.consume();
        }
        if (e.getKeyCode() == KeyEvent.VK_ENTER && e.getModifiers() == 0) {
          openEditor();
          e.consume();
        }
      }
    });
  }

  public void initComponent() {
    addListeners();

    if (IdeMain.getTestMode() != TestMode.CORE_TEST) {
      ThreadUtils.runInUIThreadNoWait(new Runnable() {
        public void run() {
          rebuildTree();
        }
      });
    }
  }

  public void addToolbarActions(final DefaultActionGroup group) {
    ToggleAction myPAndRToggle = new ToggleAction("Show properties and references", "Show properties and references", Icons.PROP_AND_REF) {
      public boolean isSelected(@Nullable AnActionEvent e) {
        return isShowPropertiesAndReferences();
      }

      public void setSelected(@Nullable AnActionEvent e, boolean state) {
        if (state != myLastPropertiesState) {
          myLastPropertiesState = state;
          ModelAccess.instance().runReadInEDT(new Runnable() {
            public void run() {
              getTree().rebuildNow();
            }
          });
        }
      }
    };
    group.add(myPAndRToggle);
  }

  public void disposeComponent() {
    getTree().clear();
    getTree().dispose();
    removeListeners();
  }

  public MPSTree getTree() {
    return (MPSTree) myTree;
  }

  public Project getProject() {
    return myProject;
  }

  public MPSProject getMPSProject() {
    return myProject.getComponent(MPSProjectHolder.class).getMPSProject();
  }

  @NonNls
  @NotNull
  public String getComponentName() {
    return "Project Pane";
  }

  public String getTitle() {
    return "Logical View";
  }

  @NotNull
  public String getId() {
    return ID;
  }

  public int getWeight() {
    return 0;
  }

  public SelectInTarget createSelectInTarget() {
    return new SelectInTarget() {
      private SNode myNode;
      private IOperationContext myContext;

      public boolean canSelect(SelectInContext context) {
        VirtualFile virtualFile = context.getVirtualFile();
        if (!(virtualFile instanceof MPSNodeVirtualFile)) return false;

        MPSNodeVirtualFile file = (MPSNodeVirtualFile) virtualFile;
        FileEditor[] editors = FileEditorManager.getInstance(myProject).getEditors(file);
        if (editors.length != 0) {
          FileEditor editor = editors[0];
          if (!(editor instanceof MPSFileNodeEditor)) return false;
          EditorComponent editorComponent = ((MPSFileNodeEditor) editor).getNodeEditor().getCurrentEditorComponent();
          if (editorComponent == null) return false;
          myNode = editorComponent.getEditedNode();
          myContext = editorComponent.getOperationContext();
        } else {
          myNode = file.getNode();
          myContext = new ProjectOperationContext(myProject.getComponent(MPSProjectHolder.class).getMPSProject());
        }
        return true;
      }

      public void selectIn(final SelectInContext context, boolean requestFocus) {
        ModelAccess.instance().runReadAction(new Runnable() {
          public void run() {
            selectNode(myNode, myContext);
          }
        });
        activate(requestFocus);
      }

      public String getToolWindowId() {
        return ID;
      }

      public String getMinorViewId() {
        return null;
      }

      public float getWeight() {
        return 0;
      }

      public String toString() {
        return "Logical View";
      }
    };
  }

  public Icon getIcon() {
    return Icons.CLOSED_FOLDER;
  }

  public ActionCallback updateFromRoot(boolean restoreExpandedPaths) {
    getTree().rebuildLater();
    return new ActionCallback(); // todo
  }

  public void select(Object element, final VirtualFile file, final boolean requestFocus) {
  }

  public JComponent createComponent() {
    return getComponent();
  }

  public JComponent getComponent() {
    return myScrollPane;
  }

  protected void editNode(final SNode node, final IOperationContext context, final boolean focus, final boolean select) {
    ModelAccess.instance().executeCommand(new Runnable() {
      public void run() {
        MPSEditorOpener opener = getProject().getComponent(MPSEditorOpener.class);
        assert opener != null;
        opener.openNode(node, context, focus, select);
      }
    });
  }

  public void projectOpened() {
    myReloadListener.onAfterReload();
    ClassLoaderManager.getInstance().addReloadHandler(myReloadListener);
    StartupManager.getInstance(myProject).registerStartupActivity(new Runnable() {
      public void run() {
        myProjectView.addProjectPane(ProjectPane.this);
      }
    });
  }

  public void projectClosed() {
    ClassLoaderManager.getInstance().removeReloadHandler(myReloadListener);
  }

  protected void onBeforeModelWillBeDeleted(SModelDescriptor sm) {
    selectNextModel(sm);
  }

  public boolean isShowPropertiesAndReferences() {
    return myLastPropertiesState;
  }

  public void openEditor() {
    TreePath selectionPath = getTree().getSelectionPath();
    if (selectionPath == null) return;
    if (!(selectionPath.getLastPathComponent() instanceof SNodeTreeNode)) return;
    SNodeTreeNode selectedTreeNode = (SNodeTreeNode) selectionPath.getLastPathComponent();

    IEditor editor = getMPSProject().getComponentSafe(MPSEditorOpener.class).editNode(selectedTreeNode.getSNode(), selectedTreeNode.getOperationContext());
    editor.requestFocus();
  }

  @Nullable
  public Object getData(@NonNls String dataId) {
    //MPSDK
    if (dataId.equals(MPSDataKeys.NODE.getName())) return getSelectedSNode();
    if (dataId.equals(MPSDataKeys.NODES.getName())) return getSelectedSNodes();

    if (dataId.equals(MPSDataKeys.MODEL.getName())) return getSelectedModel();
    if (dataId.equals(MPSDataKeys.CONTEXT_MODEL.getName())) return getContextModel();
    if (dataId.equals(MPSDataKeys.MODELS.getName())) return getSelectedModels();

    if (dataId.equals(MPSDataKeys.MODULE.getName())) return getSelectedModule();
    if (dataId.equals(MPSDataKeys.CONTEXT_MODULE.getName())) return getContextModule();
    if (dataId.equals(MPSDataKeys.MODULES.getName())) return getSelectedModules();

    if (dataId.equals(MPSDataKeys.VIRTUAL_PACKAGE.getName())) {
      List<String> selectedPackages = getSelectedPackages();
      if (selectedPackages.size() != 1) return null;
      return selectedPackages.get(0);
    }
    if (dataId.equals(MPSDataKeys.VIRTUAL_PACKAGES.getName())) return getSelectedPackages();

    if (dataId.equals(MPSDataKeys.OPERATION_CONTEXT.getName())) return getContextForSelection();
    if (dataId.equals(MPSDataKeys.LOGICAL_VIEW_NODE.getName())) return getSelectedTreeNode(TreeNode.class);
    if (dataId.equals(MPSDataKeys.LOGICAL_VIEW_NODES.getName())) return getSelectedTreeNodes(TreeNode.class);
    if (dataId.equals(MPSDataKeys.LOGICAL_VIEW_SELECTION_SIZE.getName())) return getSelectionSize();
    if (dataId.equals(MPSDataKeys.PLACE.getName())) return getPlace();

    //PDK
    if (dataId.equals(PlatformDataKeys.COPY_PROVIDER.getName())) return new MyCopyProvider();
    if (dataId.equals(PlatformDataKeys.PASTE_PROVIDER.getName())) return new MyPasteProvider();
    if (dataId.equals(PlatformDataKeys.CUT_PROVIDER.getName())) return new MyCutProvider();
    if (dataId.equals(PlatformDataKeys.VIRTUAL_FILE_ARRAY.getName())) return getSelectedFiles();

    //not found
    return null;
  }

  public int getSelectionSize() {
    return getSelectionPaths().length;
  }

  private ActionPlace getPlace() {
    TreeNode treeNode = getSelectedTreeNode(TreeNode.class);
    if (treeNode instanceof SNodeTreeNode) {
      return ActionPlace.PROJECT_PANE_SNODE;
    } else if (treeNode instanceof SModelTreeNode) {
      return ActionPlace.PROJECT_PANE_SMODEL;
    } else if (treeNode instanceof ProjectTreeNode) {
      return ActionPlace.PROJECT_PANE_PROJECT;
    } else if (treeNode instanceof GeneratorTreeNode) {
      return ActionPlace.PROJECT_PANE_GENERATOR;
    } else if (treeNode instanceof TransientModelsTreeNode) {
      return ActionPlace.PROJECT_PANE_TRANSIENT_MODULES;
    } else if (treeNode instanceof PackageNode) {
      return ActionPlace.PROJECT_PANE_PACKAGE;
    } else if (treeNode instanceof NamespaceTextNode) {
      return ActionPlace.PROJECT_PANE_NAMESPACE;
    } else if (treeNode instanceof ProjectModuleTreeNode) {
      IModule module = getSelectedModule();
      if (module instanceof Language) {
        return ActionPlace.PROJECT_PANE_LANGUAGE;
      } else if (module instanceof DevKit) {
        return ActionPlace.PROJECT_PANE_DEVKIT;
      } else if (module instanceof Solution) {
        return ActionPlace.PROJECT_PANE_SOLUTION;
      }
    }
    return ActionPlace.PROJECT_PANE;
  }

  private IOperationContext getContextForSelection() {
    TreePath[] selection = getTree().getSelectionPaths();
    if (selection == null) return null;
    if (selection.length > 0) {
      MPSTreeNode lastPathComponent = (MPSTreeNode) selection[0].getLastPathComponent();
      return lastPathComponent.getOperationContext();
    }
    return null;
  }

  public void rebuildTree() {
    getTree().rebuildNow();
  }

  public void activate(final boolean focus) {
    myProjectView.changeView(getId());
    final ToolWindowManager manager = ToolWindowManager.getInstance(myProject);
    manager.getToolWindow(ToolWindowId.PROJECT_VIEW).activate(new Runnable() {
      public void run() {
        if (focus) {
          manager.getFocusManager().requestFocus(myTree, false);
        }
      }
    }, false);
  }

  public void doRebuildTree() {
    ModelAccess.instance().runReadInEDT(new Runnable() {
      public void run() {
        if (isDisposed()) {
          return;
        }
        rebuildTreeNow();
      }
    });
  }

  private void rebuildTreeNow() {
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        rebuildTree();
      }
    });
  }

  public boolean isDisposed() {
    return myDisposed;
  }

  public void dispose() {
    myDisposed = true;
  }

  public void rebuild() {
    doRebuildTree();
  }

  protected void removeListeners() {
    if (getMPSProject() != null) {
      SModelRepository.getInstance().removeModelRepositoryListener(mySModelRepositoryListener);
      CommandProcessor.getInstance().removeCommandListener(myCommandListener);
      MPSModuleRepository.getInstance().removeModuleRepositoryListener(myRepositoryListener);
      getMPSProject().getComponent(GeneratorManager.class).addGenerationListener(myGenerationListener);
      getProject().getComponent(FileEditorManager.class).removeFileEditorManagerListener(myEditorListener);
      VirtualFileManager.getInstance().removeVirtualFileManagerListener(myRefreshListener);
    }
  }

  protected void addListeners() {
    VirtualFileManager.getInstance().addVirtualFileManagerListener(myRefreshListener);
    SModelRepository.getInstance().addModelRepositoryListener(mySModelRepositoryListener);
    CommandProcessor.getInstance().addCommandListener(myCommandListener);
    MPSModuleRepository.getInstance().addModuleRepositoryListener(myRepositoryListener);
    getMPSProject().getComponent(GeneratorManager.class).addGenerationListener(myGenerationListener);
    getProject().getComponent(FileEditorManager.class).addFileEditorManagerListener(myEditorListener);
  }

  private AnActionEvent createEvent(DataContext context) {
    return ActionUtils.createEvent(ActionPlaces.PROJECT_VIEW_POPUP, context);
  }

  //----selection----

  public void selectModuleAndFocus(@NotNull final IModule module) {
    ToolWindowManager manager = ToolWindowManager.getInstance(getProject());
    ToolWindow toolWindow = manager.getToolWindow(ToolWindowId.PROJECT_VIEW);
    toolWindow.activate(new Runnable() {
      public void run() {
        selectModule(module);
      }
    });
  }

  public void selectModule(@NotNull final IModule module) {
    ModelAccess.instance().runReadInEDT(new Runnable() {
      public void run() {
        MPSTreeNode moduleTreeNode = findModuleTreeNode(module);

        if (moduleTreeNode == null) {
          LOG.warning("Couldn't select module \"" + module.getModuleFqName() + "\" : tree node not found.");
          return;
        }

        getTree().selectNode(moduleTreeNode);
      }
    });
  }

  public void selectModel(@NotNull final SModelDescriptor modelDescriptor) {
    LOG.checkEDT();

    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        SModelTreeNode modelTreeNode = findModelTreeNode(getTree().getRootNode(), modelDescriptor);

        if (modelTreeNode == null) {
          LOG.warning("Couldn't select model \"" + modelDescriptor.getLongName() + "\" : tree node not found.");
          return;
        }

        getTree().selectNode(modelTreeNode);
      }
    });
  }

  public void selectNextModel(SModelDescriptor modelDescriptor) {
    MPSTreeNode mpsTreeNode = findNextTreeNode(modelDescriptor);
    getTree().selectNode(mpsTreeNode);
  }

  public void selectNode(final SNode node, final IOperationContext context) {
    LOG.checkEDT();

    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        getTree().runWithoutExpansion(new Runnable() {
          public void run() {
            IModule module = context.getModule();
            if (module == null) {
              selectNode(node);
              return;
            }

            MPSTreeNode moduleTreeNode = findModuleTreeNode(module);
            if (moduleTreeNode == null) {
              LOG.error("Couldn't find tree node for module: " + module.getModuleFqName());
              selectNode(node);
              return;
            }

            // search in module sub-tree
            SModelDescriptor modelDescriptor = node.getModel().getModelDescriptor();
            SModelTreeNode modelTreeNode = findModelTreeNode(moduleTreeNode, modelDescriptor);
            if (modelTreeNode == null) {
              // no such model in the module sub-tree
              selectNode(node);
              return;
            }

            modelTreeNode.flush();

            // search in SModel sub-tree
            MPSTreeNodeEx treeNodeToSelect = findTreeNode(modelTreeNode, node);
            if (treeNodeToSelect != null) {
              TreePath treePath = new TreePath(treeNodeToSelect.getPath());
              getTree().setSelectionPath(treePath);
              getTree().scrollPathToVisible(treePath);
            } else {
              LOG.warning("Couldn't select node " + node.getDebugText() + " : tree node not found.");
            }
          }
        });
      }
    });
  }

  private void selectNode(@NotNull final SNode node) {
    LOG.checkEDT();

    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        DefaultTreeModel treeModel = (DefaultTreeModel) getTree().getModel();
        MPSTreeNode rootNode = (MPSTreeNode) treeModel.getRoot();
        SModel model = node.getModel();
        assert model != null : "trying to select node which is not registered";
        SModelDescriptor modelDescriptor = model.getModelDescriptor();
        assert modelDescriptor != null;
        SModelTreeNode modelTreeNode = findModelTreeNode(rootNode, modelDescriptor);
        if (modelTreeNode == null) {
          LOG.warning("Couldn't select node " + node.getDebugText() + " : tree node for model \"" + modelDescriptor.getSModelReference().getLongName() + "\" not found.");
          return;
        }
        modelTreeNode.flush();
        MPSTreeNodeEx treeNodeToSelect = findTreeNode(modelTreeNode, node);
        if (treeNodeToSelect != null) {
          TreePath treePath = new TreePath(treeNodeToSelect.getPath());
          getTree().setSelectionPath(treePath);
          getTree().scrollPathToVisible(treePath);
        } else {
          LOG.warning("Couldn't select node " + node.getDebugText() + " : tree node not found.");
        }
      }
    });
  }

  public void selectNextNode(SNode node) {
    MPSTreeNode mpsTreeNode = findNextTreeNode(node);
    getTree().selectNode(mpsTreeNode);
  }



  //----selection queries----

  public IModule getSelectedModule() {
    ProjectModuleTreeNode selectedTreeNode = getSelectedTreeNode(ProjectModuleTreeNode.class);
    if (selectedTreeNode == null) return null;
    return selectedTreeNode.getModule();
  }

  public IModule getContextModule() {
    MPSTreeNode treeNode = (MPSTreeNode) getSelectedTreeNode(TreeNode.class);
    while (treeNode != null && !(treeNode instanceof ProjectModuleTreeNode)) {
      treeNode = (MPSTreeNode) treeNode.getParent();
    }
    if (treeNode == null) return null;
    return ((ProjectModuleTreeNode) treeNode).getModule();
  }

  public List<IModule> getSelectedModules() {
    List<IModule> result = new ArrayList<IModule>();
    for (ProjectModuleTreeNode node : getSelectedTreeNodes(ProjectModuleTreeNode.class)) {
      result.add(node.getModule());
    }
    return result;
  }

  public SModelDescriptor getSelectedModel() {
    SModelTreeNode selectedTreeNode = getSelectedTreeNode(SModelTreeNode.class);
    if (selectedTreeNode == null) return null;
    return selectedTreeNode.getSModelDescriptor();
  }

  public SModelDescriptor getContextModel() {
    MPSTreeNode treeNode = (MPSTreeNode) getSelectedTreeNode(TreeNode.class);
    while (treeNode != null && !(treeNode instanceof SModelTreeNode)) {
      treeNode = (MPSTreeNode) treeNode.getParent();
    }
    if (treeNode == null) return null;
    return ((SModelTreeNode) treeNode).getSModelDescriptor();
  }

  public List<SModelDescriptor> getSelectedModels() {
    List<SModelDescriptor> result = new ArrayList<SModelDescriptor>();
    for (SModelTreeNode node : getSelectedTreeNodes(SModelTreeNode.class)) {
      result.add(node.getSModelDescriptor());
    }
    return result;
  }

  public SNode getSelectedSNode() {
    MPSTreeNodeEx selectedTreeNode = getSelectedTreeNode(MPSTreeNodeEx.class);
    if (selectedTreeNode == null) return null;
    return selectedTreeNode.getSNode();
  }

  public List<SNode> getSelectedSNodes() {
    List<SNode> result = new ArrayList<SNode>();
    for (MPSTreeNodeEx node : getSelectedTreeNodes(MPSTreeNodeEx.class)) {
      SNode snode = node.getSNode();
      if (snode == null) continue;
      result.add(snode);
    }
    return result;
  }

  public List<SNode> getNormalizedSelectedSNodes() {
    List<SNode> selectedNodes = new ArrayList<SNode>(getSelectedSNodes());
    HashSet<SNode> unselectedNodes = new HashSet<SNode>();

    for (SNode node : selectedNodes) {
      if (node == null) continue;
      if (unselectedNodes.contains(node)) continue;
      unselectedNodes.addAll(node.getDescendants());
    }
    selectedNodes.removeAll(unselectedNodes);
    return selectedNodes;
  }

  public List<String> getSelectedPackages() {
    List<String> result = new ArrayList<String>();
    TreePath[] paths = getTree().getSelectionPaths();
    if (paths == null) return result;
    for (TreePath path : paths) {
      MPSTreeNode node = (MPSTreeNode) path.getLastPathComponent();
      while (node != null && !(node instanceof PackageNode)) {
        node = (MPSTreeNode) node.getParent();
      }
      if (node != null) {
        result.add(((PackageNode) node).getFullPackage());
      }
    }
    return result;
  }

  //----tree node selection queries---

  private VirtualFile[] getSelectedFiles() {
    List<VirtualFile> selectedFilesList = new LinkedList<VirtualFile>();

    // add selected model files
    List<SModelDescriptor> descriptors = getSelectedModels();
    if (descriptors != null) {
      for (SModelDescriptor descriptor : descriptors) {
        IFile ifile = descriptor.getModelFile();
        if (ifile != null) {
          VirtualFile vfile = VFileSystem.getFile(ifile);
          if (vfile != null) {
            selectedFilesList.add(vfile);
          }
        }
      }
    }

    // add selected modules files
    List<IModule> modules = getSelectedModules();
    if (modules != null) {
      for (IModule module : modules) {
        File home = module.getBundleHome();
        if (home != null) {
          VirtualFile vfile = VFileSystem.getFile(home);
          if (vfile != null) {
            selectedFilesList.add(vfile);
          }
        }
        IFile ifile = module.getDescriptorFile();
        if (ifile != null) {
          VirtualFile vfile = VFileSystem.getFile(ifile);
          if (vfile != null) {
            selectedFilesList.add(vfile);
          }
        }
      }
    }

    if (selectedFilesList.size() == 0) {
      return null;
    }

    return selectedFilesList.toArray(new VirtualFile[selectedFilesList.size()]);
  }

  private <T extends TreeNode> T getSelectedTreeNode(Class<T> nodeClass) {
    TreePath selectionPath = getTree().getSelectionPath();
    if (selectionPath == null) return null;
    Object selectedNode = selectionPath.getLastPathComponent();
    if (!(nodeClass.isInstance(selectedNode))) return null;
    return (T) selectedNode;
  }

  private <T extends TreeNode> List<T> getSelectedTreeNodes(Class<T> nodeClass) {
    TreePath[] selectionPaths = getTree().getSelectionPaths();
    List<T> selectedTreeNodes = new ArrayList<T>(selectionPaths.length);

    for (TreePath selectionPath : selectionPaths) {
      if (selectionPath == null) continue;
      Object selectedNode = selectionPath.getLastPathComponent();
      if (!(nodeClass.isInstance(selectedNode))) continue;
      selectedTreeNodes.add((T) selectedNode);
    }
    return selectedTreeNodes;
  }

  //----node finding----

  public MPSTreeNode findModuleTreeNode(final IModule module) {
    MPSTreeNode result = findModuleTreeNode(module, getTree().getRootNode());

    if (result != null) return result;

    if (!myModulesPool.isInitialized()) {
      myModulesPool.init();
      return findModuleTreeNode(module);
    }

    return null;
  }

  private MPSTreeNode findModuleTreeNode(final IModule module, MPSTreeNode rootTreeNode) {
    return findTreeNode(rootTreeNode,
      new Condition<MPSTreeNode>() {
        public boolean met(MPSTreeNode object) {
          //need to go into language to find generator modules
          if (object instanceof ProjectLanguageTreeNode) return true;
          //do not go into other modules
          if (object instanceof ProjectModuleTreeNode) return false;
          //not to load models
          if (object instanceof SModelTreeNode) return false;

          return true;
        }
      },
      new Condition<MPSTreeNode>() {
        public boolean met(MPSTreeNode treeNode) {
          if (!(treeNode instanceof ProjectModuleTreeNode)) return false;
          IOperationContext nodeContext = treeNode.getOperationContext();
          return nodeContext != null && nodeContext.getModule() == module;
        }
      });
  }

  protected SModelTreeNode findModelTreeNode(MPSTreeNode parent, SModelDescriptor modelDescriptor) {
    if (!(parent instanceof SModelTreeNode) && !parent.isInitialized() && !parent.hasInfiniteSubtree()) {
      parent.init();
    }

    if (parent instanceof SModelTreeNode) {
      SModelTreeNode parentSModelNode = (SModelTreeNode) parent;
      SModelDescriptor parentModelDescriptor = parentSModelNode.getSModelDescriptor();
      SModelReference parentModelRef = parentModelDescriptor.getSModelReference();
      SModelReference modelRef = modelDescriptor.getSModelReference();
      if (parentModelRef.equals(modelRef)) {
        return parentSModelNode;
      }
    }
    for (MPSTreeNode node : parent) {
      SModelTreeNode foundNode = findModelTreeNode(node, modelDescriptor);
      if (foundNode != null) {
        return foundNode;
      }
    }
    return null;
  }

  protected MPSTreeNodeEx findTreeNode(MPSTreeNode parent, SNode node) {
    if (!(parent.isInitialized() || parent.hasInfiniteSubtree())) parent.init();
    if (parent instanceof SNodeTreeNode) {
      SNodeTreeNode parentSNodeTreeNode = (SNodeTreeNode) parent;
      if (node == parentSNodeTreeNode.getSNode()) {
        return parentSNodeTreeNode;
      }
    }
    for (MPSTreeNode childNode : parent) {
      MPSTreeNodeEx foundNode = findTreeNode(childNode, node);
      if (foundNode != null) {
        return foundNode;
      }
    }
    return null;
  }

  private MPSTreeNode findTreeNode(MPSTreeNode root, Condition<MPSTreeNode> descendCondition, Condition<MPSTreeNode> resultCondition) {
    if (resultCondition.met(root)) {
      return root;
    }

    if (descendCondition.met(root)) {
      if (!root.isInitialized()) {
        root.init();
      }
      for (MPSTreeNode node : root) {
        MPSTreeNode result = findTreeNode(node, descendCondition, resultCondition);
        if (result != null) {
          return result;
        }
      }
    }
    return null;
  }

  public MPSTreeNode findNextTreeNode(SNode node) {
    DefaultTreeModel model = (DefaultTreeModel) getTree().getModel();
    MPSTreeNode rootNode = (MPSTreeNode) model.getRoot();
    SModelDescriptor sModel = node.getModel().getModelDescriptor();
    SModelTreeNode sModelNode = findModelTreeNode(rootNode, sModel);
    if (sModelNode == null) return null;
    MPSTreeNode foundNode = findTreeNode(sModelNode, node);
    if (foundNode == null) return null;
    DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) foundNode.getParent();
    TreeNode result = parentNode.getChildAfter(foundNode);
    if (result == null) result = parentNode.getChildBefore(foundNode);
    if (result == null) result = parentNode;
    return (MPSTreeNode) result;
  }

  public MPSTreeNode findNextTreeNode(SModelDescriptor modelDescriptor) {
    DefaultTreeModel model = (DefaultTreeModel) getTree().getModel();
    MPSTreeNode rootNode = (MPSTreeNode) model.getRoot();
    SModelTreeNode sModelNode = findModelTreeNode(rootNode, modelDescriptor);
    if (sModelNode == null) return null;
    DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) sModelNode.getParent();
    TreeNode result = parentNode.getChildAfter(sModelNode);
    if (result == null) result = parentNode.getChildBefore(sModelNode);
    if (result == null) result = parentNode;
    return (MPSTreeNode) result;
  }

  //----state----

  public MyState getState() {
    return new MyState((int) myScrollPane.getViewport().getViewPosition().getY(), getTree().saveState());
  }

  public void loadState(final MyState state) {
    ModelAccess.instance().runReadInEDT(new Runnable() {
      public void run() {
        rebuildTreeNow();
        getTree().loadState(state.getState());
        myScrollPane.getViewport().setViewPosition(new Point(0, state.getVerticalScrollPosition()));
      }
    });
  }

  public static class MyState {
    private TreeState myState;
    private int myVerticalScrollPosition = 0;

    public MyState() {
    }

    public MyState(int verticalScrollPosition, TreeState state) {
      myVerticalScrollPosition = verticalScrollPosition;
      myState = state;
    }

    public TreeState getState() {
      return myState;
    }

    public void setState(TreeState state) {
      myState = state;
    }

    public int getVerticalScrollPosition() {
      return myVerticalScrollPosition;
    }

    public void setVerticalScrollPosition(int verticalScrollPosition) {
      myVerticalScrollPosition = verticalScrollPosition;
    }
  }

  //----UI----

  private class MyScrollPane extends JScrollPane implements DataProvider {
    private MyScrollPane(Component view) {
      super(view);
    }

    @Nullable
    public Object getData(@NonNls String dataId) {
      return ProjectPane.this.getData(dataId);
    }
  }

  public class MyTree extends MPSTree {
    public MyTree() {
      super();

      getSelectionModel().setSelectionMode(TreeSelectionModel.DISCONTIGUOUS_TREE_SELECTION);
      scrollsOnExpand = false;
    }

    public void editNode(final SNode node, IOperationContext context, boolean focus) {
      boolean select = ModelAccess.instance().runReadAction(new Computable<Boolean>() {
        public Boolean compute() {
          return !node.isRoot();
        }
      });
      ProjectPane.this.editNode(node, context, focus, select);
    }

    @Override
    public boolean isAutoOpen() {
      return myProjectView.isAutoscrollToSource(ID);
    }

    protected MPSTreeNode rebuild() {
      if (getProject() == null || getProject().isDisposed()) {
        return new TextTreeNode("Empty");
      }
      ProjectTreeNode root = new ProjectTreeNode(getMPSProject());

      List<MPSTreeNode> moduleNodes = new ArrayList<MPSTreeNode>();

      List<Solution> solutions = getMPSProject().getProjectSolutions();
      for (Solution solution : solutions) {
        ProjectSolutionTreeNode solutionTreeNode = new ProjectSolutionTreeNode(solution, getMPSProject());
        moduleNodes.add(solutionTreeNode);
      }

      List<Language> languages = getMPSProject().getProjectLanguages();
      for (Language language : languages) {
        ProjectLanguageTreeNode node = new ProjectLanguageTreeNode(language, getMPSProject());
        moduleNodes.add(node);
      }

      List<DevKit> devkits = getMPSProject().getProjectDevKits();
      for (DevKit devKit : devkits) {
        ProjectDevKitTreeNode node = new ProjectDevKitTreeNode(devKit, getMPSProject());
        moduleNodes.add(node);
      }

      ModulesNamespaceTreeBuilder builder = new ModulesNamespaceTreeBuilder(getMPSProject());
      for (MPSTreeNode mtn : moduleNodes) {
        builder.addNode(mtn);
      }
      builder.fillNode(root);

      myModulesPool = new ProjectModulesPoolTreeNode(getMPSProject());
      root.add(myModulesPool);

      if (getMPSProject().getComponentSafe(TransientModelsModule.class).getOwnModelDescriptors().size() != 0) {
        TransientModelsTreeNode transientModelsNode = new TransientModelsTreeNode(getMPSProject());
        root.add(transientModelsNode);
      }
      return root;
    }
  }

  private class ModulesNamespaceTreeBuilder extends DefaultNamespaceTreeBuilder {
    private MPSProject myProject;

    protected ModulesNamespaceTreeBuilder(MPSProject project) {
      myProject = project;
    }

    protected boolean isSorted() {
      return false;
    }

    protected String getNamespace(MPSTreeNode node) {
      String folder = null;

      if (node instanceof ProjectModuleTreeNode) {
        ProjectModuleTreeNode pmtn = (ProjectModuleTreeNode) node;
        folder = myProject.getFolderFor(pmtn.getModule());
      }

      if (folder != null) {
        return folder;
      }

      return "";
    }
  }

  //----listeners----

  private class MyModuleRepositoryListener extends ModuleRepositoryAdapter {
    public void moduleAdded(IModule module) {
      myNeedRebuild = true;
    }

    public void moduleRemoved(IModule module) {
      myNeedRebuild = true;
    }
  }

  private class MyCommandListener extends CommandAdapter {
    public void commandStarted(CommandEvent event) {
      myNeedRebuild = false;
    }

    public void commandFinished(CommandEvent event) {
      if (myNeedRebuild) {
        getTree().rebuildLater();
        myNeedRebuild = false;
      }
    }
  }

  private class MyModelRepositoryAdapter extends SModelRepositoryAdapter {
    public void modelRepositoryChanged() {
      myNeedRebuild = true;
    }

    public void beforeModelDeleted(SModelDescriptor modelDescriptor) {
      onBeforeModelWillBeDeleted(modelDescriptor);
    }
  }

  //----copy-paste----

  private class MyCopyProvider implements CopyProvider {
    private CopyNode_Action myAction = new CopyNode_Action();

    public void performCopy(DataContext dataContext) {
      AnActionEvent event = createEvent(dataContext);
      ActionUtils.updateAndPerformAction(myAction, event);
    }

    public boolean isCopyEnabled(DataContext dataContext) {
      AnActionEvent event = createEvent(dataContext);
      myAction.update(event);
      return event.getPresentation().isEnabled();
    }
  }

  private class MyPasteProvider implements PasteProvider {
    private PasteNode_Action myAction = new PasteNode_Action();

    public void performPaste(DataContext dataContext) {
      AnActionEvent event = createEvent(dataContext);
      ActionUtils.updateAndPerformAction(myAction, event);
    }

    public boolean isPastePossible(DataContext dataContext) {
      return true;
    }

    public boolean isPasteEnabled(DataContext dataContext) {
      AnActionEvent event = createEvent(dataContext);
      myAction.update(event);
      return event.getPresentation().isEnabled();
    }
  }

  private class MyCutProvider implements CutProvider {
    private CutNode_Action myAction = new CutNode_Action();

    public void performCut(DataContext dataContext) {
      AnActionEvent event = createEvent(dataContext);
      ActionUtils.updateAndPerformAction(myAction, event);
    }

    public boolean isCutEnabled(DataContext dataContext) {
      AnActionEvent event = createEvent(dataContext);
      myAction.update(event);
      return event.getPresentation().isEnabled();
    }
  }

  private class RefreshListener implements VirtualFileManagerListener {
    public void beforeRefreshStart(boolean asynchonous) {

    }

    public void afterRefreshFinish(boolean asynchonous) {
      if (myNeedRebuild) {
        rebuildTree();
        myNeedRebuild = false;
      }
    }
  }
}
