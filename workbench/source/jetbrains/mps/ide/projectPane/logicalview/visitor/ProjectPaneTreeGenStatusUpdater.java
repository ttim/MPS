/*
 * Copyright 2003-2010 JetBrains s.r.o.
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
package jetbrains.mps.ide.projectPane.logicalview.visitor;

import com.intellij.openapi.project.DumbService;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Computable;
import jetbrains.mps.generator.GeneratorManager;
import jetbrains.mps.generator.ModelGenerationStatusManager;
import jetbrains.mps.ide.projectPane.logicalview.nodes.AccessoriesModelTreeNode;
import jetbrains.mps.ide.projectPane.logicalview.nodes.ProjectModuleTreeNode;
import jetbrains.mps.ide.projectPane.logicalview.nodes.ProjectTreeNode;
import jetbrains.mps.ide.ui.MPSTreeNode;
import jetbrains.mps.ide.ui.smodel.SModelTreeNode;
import jetbrains.mps.ide.ui.smodel.SModelTreeNode.GenerationStatus;
import jetbrains.mps.ide.ui.smodel.SNodeTreeNode;
import jetbrains.mps.project.ProjectOperationContext;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.descriptor.EditableSModelDescriptor;

import javax.swing.SwingUtilities;

public class ProjectPaneTreeGenStatusUpdater extends TreeNodeVisitor {
  protected void visitModelNode(final SModelTreeNode node) {
    GenerationStatus generationStatus = ModelAccess.instance().runReadAction(new Computable<GenerationStatus>() {
      public GenerationStatus compute() {
        return getGenerationStatus(node);
      }
    });
    updateNodeLater(node, generationStatus.getMessage());
  }

  protected void visitModuleNode(final ProjectModuleTreeNode node) {
    String text = "packaged";
    if (!node.getModule().isPackaged()) {
      text = ModelAccess.instance().runReadAction(new Computable<String>() {
        public String compute() {
          return generationRequired(node).getMessage();
        }
      });
    }
    updateNodeLater(node, text);
  }

  protected void visitProjectNode(ProjectTreeNode node) {

  }

  private GenerationStatus generationRequired(MPSTreeNode node) {
    if (node instanceof SNodeTreeNode) return GenerationStatus.NOT_REQUIRED;
    if (node instanceof AccessoriesModelTreeNode) return GenerationStatus.NOT_REQUIRED;

    if (node instanceof SModelTreeNode) {
      SModelTreeNode smodelTreeNode = (SModelTreeNode) node;
      GenerationStatus modelGenStatus = getGenerationStatus(smodelTreeNode);
      if (isInheritableGenStatus(modelGenStatus)) return modelGenStatus;

      for (SModelTreeNode child : smodelTreeNode.getSubfolderSModelTreeNodes()) {
        GenerationStatus childGenStatus = generationRequired(child);
        if (isInheritableGenStatus(childGenStatus)) return childGenStatus;
      }

      return GenerationStatus.NOT_REQUIRED;
    }

    if (!node.isInitialized()) {
      node.init();
    }

    for (int i = 0; i < node.getChildCount(); i++) {
      MPSTreeNode child = (MPSTreeNode) node.getChildAt(i);

      GenerationStatus childGenStatus = generationRequired(child);
      if (isInheritableGenStatus(childGenStatus)) return childGenStatus;
    }

    return GenerationStatus.NOT_REQUIRED;
  }

  private boolean isInheritableGenStatus(GenerationStatus childGenStatus) {
    return childGenStatus == GenerationStatus.REQUIRED || childGenStatus == GenerationStatus.UPDATING;
  }

  private GenerationStatus getGenerationStatus(SModelTreeNode node) {
    if (node.getSModelDescriptor() == null) return GenerationStatus.NOT_REQUIRED;
    if (isPackaged(node)) return GenerationStatus.PACKAGED;
    if (isDoNotGenerate(node)) return GenerationStatus.DO_NOT_GENERATE;

    Project project = node.getOperationContext().getProject();
    if (DumbService.getInstance(project).isDumb()) return GenerationStatus.UPDATING;

    boolean required = ModelGenerationStatusManager.getInstance().generationRequired(node.getSModelDescriptor(), ProjectOperationContext.get(project), false, true);
    return required ? GenerationStatus.REQUIRED : GenerationStatus.NOT_REQUIRED;
  }

  private boolean isPackaged(SModelTreeNode node) {
    SModelDescriptor md = node.getSModelDescriptor();
    if (!(md instanceof EditableSModelDescriptor)) return false;
    return ((EditableSModelDescriptor) md).isPackaged();
  }

  private boolean isDoNotGenerate(SModelTreeNode node) {
    SModelDescriptor md = node.getSModelDescriptor();
    if (md == null) return false;
    return GeneratorManager.isDoNotGenerate(md);
  }

  private void updateNodeLater(final MPSTreeNode node, final String addText) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        node.setAdditionalText(addText);
        node.updateNodePresentationInTree();
      }
    });
  }
}
