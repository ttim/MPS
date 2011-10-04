package jetbrains.mps.vcs.diff.changes;

/*Generated by MPS */

import jetbrains.mps.smodel.SNodeId;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.smodel.SModel;

public class DeleteRootChange extends ModelChange {
  private SNodeId myNodeId;

  public DeleteRootChange(ChangeSet changeSet, SNodeId nodeId) {
    super(changeSet);
    myNodeId = nodeId;
  }

  @NotNull
  @Override
  public SNodeId getRootId() {
    return myNodeId;
  }

  public void apply(@NotNull SModel model, @NotNull NodeCopier nodeCopier) {
    assert model.getNodeById(myNodeId) != null;
    model.getNodeById(myNodeId).delete();
  }

  @NotNull
  protected ModelChange createOppositeChange() {
    return new AddRootChange(getChangeSet().getOppositeChangeSet(), myNodeId);
  }

  @NotNull
  public ChangeType getType() {
    return ChangeType.DELETE;
  }

  @Override
  public String toString() {
    return "Delete root " + myNodeId;
  }

  public String getDescription() {
    return "Deleted root #" + myNodeId;
  }
}
