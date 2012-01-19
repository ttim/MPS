/*
 * Copyright 2003-2012 JetBrains s.r.o.
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
package jetbrains.mps.ide.editor.warningPanel;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.ProjectComponent;
import com.intellij.openapi.extensions.Extensions;
import com.intellij.openapi.fileEditor.FileEditor;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.fileEditor.FileEditorManagerEvent;
import com.intellij.openapi.fileEditor.FileEditorManagerListener;
import com.intellij.openapi.project.DumbService;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vcs.FileStatusListener;
import com.intellij.openapi.vcs.FileStatusManager;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.util.containers.MultiMap;
import jetbrains.mps.ide.vfs.VirtualFileUtils;
import jetbrains.mps.openapi.editor.Editor;
import jetbrains.mps.ide.editor.MPSFileNodeEditor;
import jetbrains.mps.ide.IdeMain;
import jetbrains.mps.ide.IdeMain.TestMode;
import jetbrains.mps.ide.MPSCoreComponents;
import jetbrains.mps.ide.project.ProjectHelper;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.openapi.editor.EditorComponent;
import jetbrains.mps.project.IModule;
import jetbrains.mps.reloading.ClassLoaderManager;
import jetbrains.mps.reloading.ReloadAdapter;
import jetbrains.mps.reloading.ReloadListener;
import jetbrains.mps.smodel.*;
import jetbrains.mps.smodel.descriptor.EditableSModelDescriptor;
import jetbrains.mps.util.Computable;
import jetbrains.mps.vfs.IFile;
import jetbrains.mps.workbench.nodesFs.MPSNodeVirtualFile;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class MPSEditorWarningsManager implements ProjectComponent {
  public static final Logger LOG = Logger.getLogger(MPSEditorWarningsManager.class);

  private FileEditorManager myFileEditorManager;
  private ClassLoaderManager myClassLoaderManager;
  private ReloadListener myReloadListener = new MyReloadListener();
  private MyFileStatusListener myFileStatusListener = new MyFileStatusListener();
  private Project myProject;

  private MyFileEditorManagerListener myFileEditorManagerListener = new MyFileEditorManagerListener();
  private MultiMap<MPSFileNodeEditor, WarningPanel> myWarnings = new MultiMap<MPSFileNodeEditor, WarningPanel>();

  public MPSEditorWarningsManager(Project project, FileEditorManager fileEditorManager, MPSCoreComponents coreComponents) {
    myProject = project;
    myFileEditorManager = fileEditorManager;
    myClassLoaderManager = coreComponents.getClassLoaderManager();
  }

  public void projectOpened() {
    myFileEditorManager.addFileEditorManagerListener(myFileEditorManagerListener);
  }

  public void projectClosed() {
    myFileEditorManager.removeFileEditorManagerListener(myFileEditorManagerListener);
  }

  @NonNls
  @NotNull
  public String getComponentName() {
    return "MPS Editor Warnings Manager";
  }

  public void initComponent() {
    myClassLoaderManager.addReloadHandler(myReloadListener);
    FileStatusManager.getInstance(myProject).addFileStatusListener(myFileStatusListener);
  }

  public void disposeComponent() {
    FileStatusManager.getInstance(myProject).removeFileStatusListener(myFileStatusListener);
    myClassLoaderManager.removeReloadHandler(myReloadListener);
  }

  private void updateWarnings(@NotNull final MPSFileNodeEditor editor) {
    final Project project = ProjectHelper.toIdeaProject(editor.getNodeEditor().getOperationContext().getProject());

    DumbService.getInstance(project).smartInvokeLater(new Runnable() {
      public void run() {
        final Runnable task = new Runnable() {
          public void run() {
            doUpdateWarnings(editor, project);
          }
        };
        Boolean aBoolean = ModelAccess.instance().tryRead(new Computable<Boolean>() {
          @Override
          public Boolean compute() {
            task.run();
            return Boolean.TRUE;
          }
        });
        if (aBoolean == null) {
          ModelAccess.instance().runReadInEDT(task);
        }
      }
    });
  }

  private void doUpdateWarnings(final MPSFileNodeEditor editor, Project project) {
    List<WarningPanel> newWarnings = new ArrayList<WarningPanel>();
    
    Editor nodeEditor = editor.getNodeEditor();
    if (nodeEditor == null) return;

    EditorComponent editorComponent = nodeEditor.getCurrentEditorComponent();
    if (editorComponent != null && editorComponent.isDisposed()) return;

    SNode node = editor.getFile().getNode();
    if (node == null) return;

    EditorWarningsProvider[] providers = Extensions.getExtensions(EditorWarningsProvider.EP_NAME);

    for (EditorWarningsProvider provider : providers) {
      WarningPanel panel = provider.getWarningPanel(node, project);
      if (panel != null) {
        newWarnings.add(panel);
      }
    }

    replaceWarningPanels(editor, newWarnings);
  }

  private void updateAllWarnings(@Nullable VirtualFile vf) {
    if (IdeMain.getTestMode() == TestMode.CORE_TEST) return;

    for (FileEditor editor : myFileEditorManager.getAllEditors()) {
      if (editor instanceof MPSFileNodeEditor) {
        MPSFileNodeEditor mpsEditor = (MPSFileNodeEditor) editor;
        if (!mpsEditor.isDisposed()) {
          if (vf == null || vf.equals(mpsEditor.getFile())) {
            updateWarnings(mpsEditor);
          }
        }
      }
    }
  }

  private void updateAllWarnings() {
    updateAllWarnings(null);
  }

  private void replaceWarningPanels(MPSFileNodeEditor editor, List<WarningPanel> newPanels) {
    Collection<WarningPanel> oldPanels = myWarnings.get(editor);
    List<WarningPanel> toRemove = new ArrayList<WarningPanel>(oldPanels);
    toRemove.removeAll(newPanels);
    List<WarningPanel> toAdd = new ArrayList<WarningPanel>(newPanels);
    toAdd.removeAll(oldPanels);

    for (WarningPanel panel : toRemove) {
      myFileEditorManager.removeTopComponent(editor, panel);
      myWarnings.removeValue(editor, panel);
    }

    for (WarningPanel panel : toAdd) {
      myFileEditorManager.addTopComponent(editor, panel);
      myWarnings.putValue(editor, panel);
    }
  }

  private class MyFileEditorManagerListener implements FileEditorManagerListener {
    public void fileOpened(FileEditorManager source, VirtualFile file) {
      if (file instanceof MPSNodeVirtualFile) {
        for (FileEditor fe : myFileEditorManager.getEditors(file)) {
          if (fe instanceof MPSFileNodeEditor) {
            updateWarnings((MPSFileNodeEditor) fe);
          }
        }
      }
    }

    public void fileClosed(FileEditorManager source, VirtualFile file) {
      myWarnings.keySet().retainAll(Arrays.asList(source.getAllEditors()));
    }

    public void selectionChanged(FileEditorManagerEvent event) {
      updateAllWarnings();
    }
  }

  private class MyReloadListener extends ReloadAdapter {
    public void onAfterReload() {
      ApplicationManager.getApplication().invokeLater(new Runnable() {
        public void run() {
          if (myProject.isDisposed()) return;
          updateAllWarnings();
        }
      });
    }
  }

  private class MyFileStatusListener implements FileStatusListener {
    @Override
    public void fileStatusChanged(@NotNull final VirtualFile virtualFile) {
      updateAllWarnings(virtualFile);
    }

    @Override
    public void fileStatusesChanged() {
      updateAllWarnings();
    }
  }
}
