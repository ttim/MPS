package jetbrains.mps.vcs.diff.changes;

/*Generated by MPS */

import jetbrains.mps.smodel.SNodeId;

public class DeleteNodeGroupChange extends NodeGroupChange {
  private int myBegin;
  private int myEnd;

  public DeleteNodeGroupChange(ChangeSet changeSet, SNodeId parentNodeId, String role, int begin, int end) {
    super(changeSet, parentNodeId, role);
    myBegin = begin;
    myEnd = end;
  }

  public int getBegin() {
    return myBegin;
  }

  public int getEnd() {
    return myEnd;
  }

  @Override
  public String toString() {
    return String.format("Delete %s in role %s of node %s", nodeRange(myBegin, myEnd), getRole(), getParentNodeId());
  }
}
