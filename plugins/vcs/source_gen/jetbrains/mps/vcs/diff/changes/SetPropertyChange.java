package jetbrains.mps.vcs.diff.changes;

/*Generated by MPS */

import org.jetbrains.annotations.NotNull;
import jetbrains.mps.smodel.SNodeId;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SNode;

public class SetPropertyChange extends NodeChange {
  private String myPropertyName;
  private String myNewValue;

  public SetPropertyChange(@NotNull ChangeSet changeSet, @NotNull SNodeId nodeId, String propertyName, String newValue) {
    super(changeSet, nodeId);
    myPropertyName = propertyName;
    myNewValue = newValue;
  }

  @NotNull
  public String getPropertyName() {
    return myPropertyName;
  }

  public String getNewValue() {
    return myNewValue;
  }

  public void apply(@NotNull SModel model, @NotNull NodeCopier nodeCopier) {
    SNode node = model.getNodeById(getAffectedNodeId());
    assert node != null;
    node.setProperty(myPropertyName, myNewValue);
  }

  protected ModelChange createOppositeChange() {
    SNode node = getChangeSet().getOldModel().getNodeById(getAffectedNodeId());
    assert node != null;
    return new SetPropertyChange(getChangeSet().getOppositeChangeSet(), getAffectedNodeId(), myPropertyName, node.getProperty(myPropertyName));
  }

  @Override
  public String toString() {
    return String.format("Set property %s to %s in node %s", myPropertyName, myNewValue, getAffectedNodeId());
  }
}
