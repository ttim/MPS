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

import jetbrains.mps.ide.ui.TextTreeNode;
import jetbrains.mps.project.DevKit;
import jetbrains.mps.project.IModule;
import jetbrains.mps.project.MPSProject;
import jetbrains.mps.project.Solution;
import jetbrains.mps.smodel.Generator;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.smodel.MPSModuleRepository;
import jetbrains.mps.util.CollectionUtil;
import jetbrains.mps.util.NameUtil;

import java.util.List;

class ProjectModulesPoolTreeNode extends TextTreeNode {
  private MPSProject myProject;
  private boolean myInitialized;

  public ProjectModulesPoolTreeNode(MPSProject project) {
    super("Modules Pool");
    myProject = project;

    setIcon(Icons.MODULE_GROUP_CLOSED, false);
    setIcon(Icons.MODULE_GROUP_OPENED, true);
  }

  @Override
  public boolean isLoadingEnabled() {
    return true;
  }

  public boolean isInitialized() {
    return myInitialized;
  }

  protected boolean propogateErrorUpwards() {
    return false;
  }

  protected void doInit() {
    populate();
    myInitialized = true;
  }

  private void populate() {
    List<IModule> modules = collectModules();
    {
      ModulePoolNamespaceBuilder builder = new ModulePoolNamespaceBuilder();
      TextTreeNode solutions = new TextTreeNode("Solutions");
      for (Solution s : CollectionUtil.filter(Solution.class, modules)) {
        builder.addNode(new ProjectSolutionTreeNode(s, myProject, true));
      }
      builder.fillNode(solutions);
      add(solutions);
    }

    {
      ModulePoolNamespaceBuilder builder = new ModulePoolNamespaceBuilder();
      TextTreeNode languages = new TextTreeNode("Languages");
      for (Language l : CollectionUtil.filter(Language.class, modules)) {
        builder.addNode(new ProjectLanguageTreeNode(l, myProject, true));
      }
      builder.fillNode(languages);
      add(languages);
    }

    {
      ModulePoolNamespaceBuilder builder = new ModulePoolNamespaceBuilder();
      TextTreeNode devkits = new TextTreeNode("DevKits");
      for (DevKit devKit : CollectionUtil.filter(DevKit.class, modules)) {
        builder.addNode(new ProjectDevKitTreeNode(devKit, myProject, true));
      }
      builder.fillNode(devkits);
      add(devkits);
    }
  }

  private List<IModule> collectModules() {
    return MPSModuleRepository.getInstance().getAllModules();
  }

  private class ModulePoolNamespaceBuilder extends DefaultNamespaceTreeBuilder<ProjectModuleTreeNode> {

    protected String getNamespace(ProjectModuleTreeNode node) {
      if (node.getModule() instanceof Generator) {
        Generator generator = (Generator) node.getModule();
        return NameUtil.namespaceFromLongName(generator.getSourceLanguage().getNamespace());
      }

      if (node.getModule() instanceof Solution) {
        return NameUtil.namespaceFromLongName(node.getModule().toString());
      }

      if (node.getModule() instanceof DevKit) {
        return NameUtil.namespaceFromLongName(node.getModule().toString());
      }

      if (node.getModule() instanceof Language) {
        return NameUtil.namespaceFromLongName(node.getModule().getModuleUID());
      }

      return "Others." + node.getModule().getModuleUID();
    }
  }
}
