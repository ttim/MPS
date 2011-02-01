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
package jetbrains.mps.nodeEditor.cellActions;

import jetbrains.mps.smodel.BaseAdapter;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.lang.structure.structure.LinkDeclaration;
import jetbrains.mps.lang.structure.structure.Cardinality;

public class CellAction_DeleteEasily extends CellAction_DeleteNode {

  public CellAction_DeleteEasily(SNode semanticNode) {
    super(semanticNode);
  }

  public boolean canExecute(EditorContext context) {
    return super.canExecute(context) && canBeDeletedEasily();
  }

  private boolean canBeDeletedEasily() {
    for (SNode child : getSourceNode().getChildren()) {
      if (child.isAttribute()) continue;
      LinkDeclaration link = (LinkDeclaration) BaseAdapter.fromNode(getSourceNode().getLinkDeclaration(child.getRole_()));
      if (link != null && link.getSourceCardinality() != Cardinality._1) return false;
    }

    return true;
  }
}
