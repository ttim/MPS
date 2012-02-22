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

import com.intellij.compiler.CompilerManagerImpl;
import com.intellij.openapi.compiler.CompilerManager;
import com.intellij.openapi.compiler.CompilerPaths;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.vfs.VirtualFile;
import jetbrains.mps.idea.core.facet.MPSFacetConfiguration;
import jetbrains.mps.idea.core.make.MPSCompiler2;
import jetbrains.mps.idea.core.make.MPSCompilerPaths;
import jetbrains.mps.vfs.IFile;

/**
 * Created by IntelliJ IDEA.
 * User: fyodor
 * Date: 2/22/12
 * Time: 4:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class ComplicatedMakeTests extends AbstractMakeTest {

  @Override
  protected void prepareTestData(MPSFacetConfiguration configuration) throws Exception {
    String moduleFileName = configuration.getFacet().getModule().getModuleFilePath();
    copyResource(moduleFileName, "makeTests.iml", "/tests/makeTests/makeTests.iml");
    final IFile codeModel = copyResource("models", "code.mps", "code.mps", "/tests/makeTests/models/code.mps");
    final IFile dataModel = copyResource("models", "data.mps", "data.mps", "/tests/makeTests/models/data.mps");
    configuration.getState().setModelRootPaths(codeModel.getParent().getPath());
    prepareTestData(configuration, codeModel.getParent());
  }

  public void testGeneratingMultiModels() {
    CompilerManagerImpl.testSetup();

    ModuleRootManager mrm = ModuleRootManager.getInstance(myFacet.getModule());
    VirtualFile[] srs = mrm.getSourceRoots();
    assertTrue(srs.length == 2);
    VirtualFile models = srs[0];
    assertEquals("models", models.getName());
    assertTrue(models.getChildren().length == 2);
    assertExists(models, "code.mps");
    assertExists(models, "data.mps");

    final VirtualFile moduleDir = models.getParent();
    assertTrue(moduleDir.findChild("src") == null);

    CompilerManager cm = CompilerManager.getInstance(myFacet.getModule().getProject());
    assertCompiles(cm);

    MPSCompiler2[] mpscs = cm.getCompilers(MPSCompiler2.class);
    assertSame(1, mpscs.length);

    VirtualFile outputDir = moduleDir.findChild("src");
    assertNotNull("Not found output dir", outputDir);
    assertExists(outputDir, "code");
    assertExists(outputDir, "code/Test.java");
    assertExists(outputDir, "code/trace.info");
    assertTrue(outputDir.findFileByRelativePath("code").getChildren().length == 2);

    assertExists(models, "Manifest.xml");
    assertExists(models, "trace.info");
    assertTrue(models.getChildren().length == 4);

    getVFS().refresh(false);
    assertNotExists(moduleDir, "source_gen");

    VirtualFile cachesOutputDir = getVFS().findFileByPath(MPSCompilerPaths.getCachesOutputPath(mpscs[0], myFacet.getModule(), false));
    assertExists(cachesOutputDir, "code");
    assertExists(cachesOutputDir, "code/dependencies");
    assertExists(cachesOutputDir, "code/generated");
    assertExists(cachesOutputDir, "data/dependencies");
    assertExists(cachesOutputDir, "data/generated");

  }

}
