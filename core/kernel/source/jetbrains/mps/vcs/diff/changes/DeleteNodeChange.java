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
package jetbrains.mps.vcs.diff.changes;

import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SNodeId;

import java.util.List;

public class DeleteNodeChange extends Change {
  private SNodeId myNodeId;
  private List<SNodeId> myChildren;

  public DeleteNodeChange(SNodeId nodeId, List<SNodeId> childrenIds) {
    myNodeId = nodeId;
    myChildren = childrenIds;
  }

  public String toString() {
    return "delete " + myNodeId;
  }

  public SNodeId getAffectedNodeId() {
    return myNodeId;
  }

  public boolean apply(SModel m) {
    SNode node = m.getNodeById(getAffectedNodeId());
    if (node != null) {
      node.delete();
    }
    return true;
  }

  @Override
  public ChangeType getChangeType() {
    return ChangeType.DELETE;
  }

  @Override
  public List<SNodeId> getDependencies() {
    return myChildren;
  }
}
