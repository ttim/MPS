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
package jetbrains.mps.ide.navigation;

import jetbrains.mps.logging.Logger;
import jetbrains.mps.openapi.navigation.NavigationSupport;
import jetbrains.mps.project.IModule;
import jetbrains.mps.project.ModuleContext;
import jetbrains.mps.project.Project;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SNodePointer;
import org.jetbrains.annotations.NotNull;

/**
 * evgeny, 11/6/11
 */
public class NodeNavigatable extends BaseNavigatable {
  private static final Logger LOG = Logger.getLogger(NodeNavigatable.class);

  @NotNull
  private SNodePointer nodePointer;

  public NodeNavigatable(@NotNull Project project, @NotNull SNodePointer nodePointer) {
    super(project);
    this.nodePointer = nodePointer;
  }

  @Override
  public void doNavigate(final boolean focus) {
    SNode node = nodePointer.getNode();
    if (node == null) {
      LOG.info("clicked node was deleted");
      return;
    }

    SModelDescriptor modelDescriptor = node.getModel().getModelDescriptor();
    if (modelDescriptor == null) return;

    IModule module = modelDescriptor.getModule();
    if (module == null) return;

    ModuleContext context = new ModuleContext(module, project);
    NavigationSupport.getInstance().openNode(context, node, focus, !node.isRoot());
  }

  public SNodePointer getNodePointer() {
    return nodePointer;
  }
}
