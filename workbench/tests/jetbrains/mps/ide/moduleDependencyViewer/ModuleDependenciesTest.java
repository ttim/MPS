/*
 * Copyright 2003-2011 JetBrains s.r.o.
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
package jetbrains.mps.ide.moduleDependencyViewer;

import jetbrains.mps.TestMain;
import jetbrains.mps.cleanup.CleanupManager;
import jetbrains.mps.ide.IdeMain;
import jetbrains.mps.ide.IdeMain.TestMode;
import jetbrains.mps.ide.depanalyzer.DependencyPathTree;
import jetbrains.mps.ide.depanalyzer.DependencyTreeNode;
import jetbrains.mps.ide.ui.MPSTreeNode;
import jetbrains.mps.ide.vfs.IdeaFileSystemProvider;
import jetbrains.mps.internal.collections.runtime.backports.LinkedList;
import jetbrains.mps.library.ModulesMiner;
import jetbrains.mps.library.ModulesMiner.ModuleHandle;
import jetbrains.mps.project.DevKit;
import jetbrains.mps.project.IModule;
import jetbrains.mps.project.Solution;
import jetbrains.mps.project.WriteAction;
import jetbrains.mps.project.structure.modules.DevkitDescriptor;
import jetbrains.mps.project.structure.modules.LanguageDescriptor;
import jetbrains.mps.project.structure.modules.SolutionDescriptor;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.smodel.MPSModuleOwner;
import jetbrains.mps.smodel.MPSModuleRepository;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.util.IterableUtil;
import jetbrains.mps.util.misc.hash.HashSet;
import jetbrains.mps.vfs.IFile;
import jetbrains.mps.vfs.ex.IFileEx;
import jetbrains.mps.vfs.impl.IoFile;
import jetbrains.mps.workbench.dialogs.project.newproject.SolutionStep;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import java.util.Queue;
import java.util.UUID;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class ModuleDependenciesTest {
  private static final MPSModuleOwner OWNER = new MPSModuleOwner() {
  };
  @Rule
  public WriteAction wa = new WriteAction();

  @BeforeClass
  public static void setUp() throws Exception {
    IdeMain.setTestMode(TestMode.CORE_TEST);
    TestMain.configureMPS();
  }

  @After
  public void afterTest() {
    MPSModuleRepository.getInstance().unRegisterModules(OWNER);
    CleanupManager.getInstance().cleanup();
  }

  //------------module depends on solution------------

  private int findPaths(DependencyTreeNode root, IModule target) {
    int num = 0;
    Queue<DependencyTreeNode> queue = new LinkedList<DependencyTreeNode>();
    if (root == null) {
      return 0;
    }
    queue.add(root);
    while (!queue.isEmpty()) {
      DependencyTreeNode current = queue.remove();
      for (int i = 0; i < current.getChildCount(); i++) {
        queue.add((DependencyTreeNode)current.getChildAt(i));
      }
      if (current.getModule() == target) {
        num++;
      }
    }
    return num;
  }

  private void testDependency(DependencyPathTree testTree, IModule source, IModule target, int numPaths) {
    assertEquals(numPaths, findPaths((DependencyTreeNode)testTree.testBuildTree(source, target, null), target));
    if (testTree.isShowRuntime()) {
      assertEquals(numPaths != 0, source.getDependenciesManager().getAllRequiredModules().contains(target));
    } else {
      assertEquals(numPaths != 0, source.getDependenciesManager().getAllVisibleModules().contains(target));
    }
  }

  private void testUsedLanguage(DependencyPathTree testTree, IModule source, Language target, int numPaths) {
    assertEquals(numPaths, findPaths((DependencyTreeNode)testTree.testBuildTree(source, null, target), target));
    assertEquals(numPaths != 0, source.getDependenciesManager().getAllUsedLanguages().contains(target));
  }

  @Test
  public void testDependencies() {
    final Solution[] solutions = new Solution[5];
    for (int i = 0; i < 5; i++) {
      solutions[i] = createSolution();
    }
    final DependencyPathTree testTree = new DependencyPathTree(null);
    /*
    s[0]---->s[1]--reexport-->s[2]----->s[4]
             |                |
             |---reexport-----|----reexport-->s[3]

    */
    solutions[0].addDependency(solutions[1].getModuleReference(), false);
    solutions[1].addDependency(solutions[2].getModuleReference(), true);
    solutions[2].addDependency(solutions[3].getModuleReference(), true);
    solutions[1].addDependency(solutions[3].getModuleReference(), true);
    solutions[2].addDependency(solutions[4].getModuleReference(), false);

    testDependency(testTree, solutions[0], solutions[1], 1);    //simple
    testDependency(testTree, solutions[0], solutions[2], 1);    //transitive
    testDependency(testTree, solutions[0], solutions[3], 2);    //two paths
    testDependency(testTree, solutions[0], solutions[4], 0);    //not reexport
    testTree.setShowRuntime(true);
    testDependency(testTree, solutions[0], solutions[4], 1);    //runtime dependencies are on
  }

  @Test
  public void testRuntimeDependencies() {
    final Solution[] solutions = new Solution[4];
    final Language[] languages = new Language[4];
    for (int i = 0; i < 4; i++) {
      solutions[i] = createSolution();
      languages[i] = createLanguage();
    }
    final DependencyPathTree testTree = new DependencyPathTree(null);

    solutions[0].addUsedLanguage(languages[0].getModuleReference());
    languages[0].getModuleDescriptor().getRuntimeModules().add(solutions[1].getModuleReference());
    languages[0].addExtendedLanguage(languages[1].getModuleReference());
    languages[1].getModuleDescriptor().getRuntimeModules().add(solutions[2].getModuleReference());
    languages[0].addUsedLanguage(languages[2].getModuleReference());
    languages[2].getModuleDescriptor().getRuntimeModules().add(solutions[3].getModuleReference());
    /*
    s[0]---uses--->l[0]----runtime----->s[1]
                  |   |
                  | extends
                  |   |
                  |  l[1]----runtime----->s[2]
                 uses
                  |
                 l[s]---runtime-->s[37]
    */
    testDependency(testTree, solutions[0], solutions[1], 0);       //runtime dependencies are off
    testTree.setShowRuntime(true);
    testDependency(testTree, solutions[0], solutions[1], 1);       //runtime dependencies are on
    testDependency(testTree, solutions[0], solutions[2], 1);  //runtime dependencies can pass through extended language
    testDependency(testTree, solutions[0], solutions[3], 0);  //runtime dependencies can not pass through used language
  }

  @Test
  public void testUsedLanguages() {
    final Language[] languages = new Language[7];
    for (int i = 0; i < 7; i++) {
      languages[i] = createLanguage();
    }
    DevKit devKit = createDevKit();
    DevKit devKit2 = createDevKit();
    final DependencyPathTree testTree = new DependencyPathTree(null);
    /*
     l[0]--uses-->l[1]--extends-->l[2]---uses-->l[3]
                   |
                 devKit---extends-->devKit2-->l[5]-->l[6]
                   |
                  l[4]
     */
    languages[0].addUsedLanguage(languages[1].getModuleReference());
    languages[1].addExtendedLanguage(languages[2].getModuleReference());
    languages[2].addUsedLanguage(languages[3].getModuleReference());
    devKit.getModuleDescriptor().getExportedLanguages().add(languages[4].getModuleReference());
    devKit.getModuleDescriptor().getExtendedDevkits().add(devKit2.getModuleReference());
    devKit2.getModuleDescriptor().getExportedLanguages().add(languages[5].getModuleReference());
    languages[1].addUsedDevkit(devKit.getModuleReference());
    languages[5].addExtendedLanguage(languages[6].getModuleReference());

    testUsedLanguage(testTree, languages[0], languages[1], 1);    //simple
    testUsedLanguage(testTree, languages[0], languages[2], 1);
    testUsedLanguage(testTree, languages[0], languages[3], 0);
    testUsedLanguage(testTree, languages[1], languages[4], 1); //devKit
    testUsedLanguage(testTree, languages[0], languages[4], 0); //extended lang + devKit
    testUsedLanguage(testTree, languages[1], languages[5], 1); //extended DevKit
    testUsedLanguage(testTree, languages[1], languages[6], 1); //extended DevKit+extended language
  }

  //----------------------------------------------

  private Solution createSolution() {
    SolutionDescriptor d = new SolutionDescriptor();
    String uuid = UUID.randomUUID().toString();
    d.setNamespace(uuid);
    d.setUUID(uuid);
    return Solution.newInstance(d, OWNER);
  }

  private Language createLanguage() {
    LanguageDescriptor d = new LanguageDescriptor();
    String uuid = UUID.randomUUID().toString();
    d.setNamespace(uuid);
    d.setUUID(uuid);
    return Language.newInstance(d, OWNER);
  }

  private DevKit createDevKit() {
    DevkitDescriptor d = new DevkitDescriptor();
    String uuid = UUID.randomUUID().toString();
    d.setNamespace(uuid);
    d.setUUID(uuid);
    return DevKit.newInstance(new ModuleHandle(null, d),OWNER);
  }

}
