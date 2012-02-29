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

package jetbrains.mps.idea.core.tests;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.application.ex.ApplicationManagerEx;
import com.intellij.openapi.compiler.CompileContext;
import com.intellij.openapi.compiler.CompileStatusNotification;
import com.intellij.openapi.compiler.CompilerManager;
import com.intellij.openapi.components.impl.ComponentManagerImpl;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.projectRoots.impl.JavaSdkImpl;
import com.intellij.openapi.roots.CompilerModuleExtension;
import com.intellij.openapi.roots.ContentEntry;
import com.intellij.openapi.roots.ModifiableRootModel;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.util.Disposer;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.VirtualFileManager;
import com.intellij.openapi.vfs.VirtualFileSystem;
import jetbrains.mps.idea.core.facet.MPSFacetConfiguration;
import jetbrains.mps.idea.core.make.MPSCompilerComponent;
import jetbrains.mps.vfs.IFile;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: fyodor
 * Date: 2/15/12
 * Time: 10:26 AM
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractMakeTest extends DataMPSFixtureTestCase {

  protected void prepareTestData(MPSFacetConfiguration configuration, final IFile source) throws Exception {
    final ModuleRootManager mrm = ModuleRootManager.getInstance(configuration.getFacet().getModule());
    ApplicationManager.getApplication().runWriteAction(new Runnable() {
      @Override
      public void run() {
        ModifiableRootModel mm = mrm.getModifiableModel();
        mm.setSdk(JavaSdkImpl.getMockJdk17());

        VirtualFileSystem vfs = VirtualFileManager.getInstance().getFileSystem("file");
        VirtualFile project = vfs.findFileByPath(source.getParent().getPath());
        try {
          ContentEntry ce = mm.addContentEntry(project);
          VirtualFile contentRoot = project.findChild(source.getName());
          if (contentRoot == null) contentRoot = project.createChildDirectory(AbstractMakeTest.this, source.getName());
          ce.addSourceFolder(contentRoot, false);
        } catch (IOException e) {
        }
        mm.commit();

        CompilerModuleExtension cme = CompilerModuleExtension.getInstance(myModule);
        CompilerModuleExtension cmemm = (CompilerModuleExtension) cme.getModifiableModel(true);
        cmemm.setCompilerOutputPath(project.getUrl() + "/classes");
        cmemm.setCompilerOutputPathForTests(project.getUrl() + "/classes");
        cmemm.inheritCompilerOutputPath(false);
        cmemm.commit();
        Disposer.dispose(cmemm);

        vfs.refresh(false);
      }
    });
  }


  @Override
  protected void setUp() throws Exception {
    // TODO restore test logger factory
//        Logger.setFactory(LoggerFactory.getInstance());


    super.setUp();

    // this is to prevent exceptions in the project components that get "projectClosed" notifications
    ApplicationManagerEx.getApplicationEx().doNotSave();

    MPSCompilerComponent mpscc = myModule.getProject().getComponent(MPSCompilerComponent.class);
    mpscc.projectOpened();

    getVFS().refresh(false);

  }

  @Override
  protected void tearDown() throws Exception {
    super.tearDown();
    Project prj = myModule.getProject();
    if (prj instanceof ComponentManagerImpl) {
      ((ComponentManagerImpl) prj).setTemporarilyDisposed(true);
    }
  }


  protected void assertExists(VirtualFile dir, String relPath) {
    assertNotNull("Not found: " + dir, dir);
    assertNotNull("Not found: " + dir.getPath() + "/" + relPath, dir.findFileByRelativePath(relPath));
  }

  protected void assertNotExists(VirtualFile dir, String relPath) {
    assertNotNull("Not found: " + dir, dir);
    assertNull("Shouldn't be here: " + dir.getPath() + "/" + relPath, dir.findFileByRelativePath(relPath));
  }

  protected void assertChildrenCount(VirtualFile dir, String relPath, int count) {
    assertTrue(dir.findFileByRelativePath(relPath).getChildren().length == count);
  }

  protected void assertCompiles(CompilerManager cm) {
    class Result {
      boolean aborted;
      int errors;
      int warnings;
    }
    final Result res = new Result();
    cm.compile(myFacet.getModule(), new CompileStatusNotification() {
      @Override
      public void finished(boolean aborted, int errors, int warnings, CompileContext compileContext) {
        res.aborted = aborted;
        res.errors = errors;
        res.warnings = warnings;
      }
    });

    assertFalse(res.aborted);
    assertSame(0, res.errors);
    assertSame(0, res.warnings);
  }

  protected VirtualFileSystem getVFS() {
    return VirtualFileManager.getInstance().getFileSystem("file");
  }
}
