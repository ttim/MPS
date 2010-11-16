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

import java.util.Arrays;
import java.util.List;

public class MoveNodeChange extends Change {
  private SNodeId myNodeId;
  private SNodeId myNewParent;
  private SNodeId myPrevSibling;
  private String myNewRole;


  public MoveNodeChange(SNodeId node, SNodeId newParent, SNodeId prevSibling, String newRole) {
    myNodeId = node;
    myNewParent = newParent;
    myNewRole = newRole;
    myPrevSibling = prevSibling;
  }


  public SNodeId getNewParent() {
    return myNewParent;
  }

  public SNodeId getPrevSibling() {
    return myPrevSibling;
  }

  public String getNewRole() {
    return myNewRole;
  }

  public String toString() {
    return "move " + myNodeId + " to " + myNewParent + " before " + myPrevSibling;
  }

  public SNodeId getAffectedNodeId() {
    return myNodeId;
  }

  @Override
  public boolean isSameChange(Change c) {
    if (this == c) return true;
    if (c == null || getClass() != c.getClass()) return false;

    MoveNodeChange that = (MoveNodeChange) c;

    if (myNewParent != null ? !myNewParent.equals(that.myNewParent) : that.myNewParent != null) return false;
    if (myNewRole != null ? !myNewRole.equals(that.myNewRole) : that.myNewRole != null) return false;
    if (!myNodeId.equals(that.myNodeId)) return false;
    if (myPrevSibling != null ? !myPrevSibling.equals(that.myPrevSibling) : that.myPrevSibling != null) return false;

    return true;
  }

  @Override
  public List<SNodeId> getDependencies() {
    return Arrays.asList(myPrevSibling, myNewParent);
  }

  @Override
  public Object getChangeKey() {
    return myNodeId;
  }

  public boolean apply(SModel m) {
    SNode node = m.getNodeById(myNodeId);
    if (node == null) return false;
    SNode parent = m.getNodeById(myNewParent);
    if (parent == null) return false;
    node.getParent().removeChild(node);
    SNode prevSibling = m.getNodeById(myPrevSibling);
    parent.insertChild(prevSibling, myNewRole, node);
    return true;
  }

}
