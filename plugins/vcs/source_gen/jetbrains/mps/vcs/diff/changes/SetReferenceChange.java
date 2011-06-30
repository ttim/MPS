package jetbrains.mps.vcs.diff.changes;

/*Generated by MPS */

import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.smodel.SNodeId;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.smodel.StaticReference;

public class SetReferenceChange extends NodeChange {
  private String myRole;
  private SModelReference myTargetModelReference;
  private SNodeId myTargetNodeId;
  private String myResolveInfo;

  public SetReferenceChange(@NotNull ChangeSet changeSet, @NotNull SNodeId sourceNodeId, @NotNull String role, @Nullable SModelReference targetModelReference, @Nullable SNodeId targetNodeId, @Nullable String resolveInfo) {
    super(changeSet, sourceNodeId);
    myRole = role;
    myTargetModelReference = targetModelReference;
    myTargetNodeId = targetNodeId;
    myResolveInfo = resolveInfo;
  }

  @NotNull
  public String getRole() {
    return myRole;
  }

  @Nullable
  public SModelReference getTargetModelReference() {
    return myTargetModelReference;
  }

  @Nullable
  public SNodeId getTargetNodeId() {
    return myTargetNodeId;
  }

  @Nullable
  public String getResolveInfo() {
    return myResolveInfo;
  }

  public void apply(@NotNull SModel model, @NotNull NodeCopier nodeCopier) {
    SNode node = model.getNodeById(getAffectedNodeId());
    assert node != null;
    if (myTargetNodeId == null && myResolveInfo == null) {
      node.setReferent(myRole, null);
    } else {
      SModelReference targetModel = (myTargetModelReference == null ?
        model.getSModelReference() :
        myTargetModelReference
      );
      SReference reference = new StaticReference(myRole, node, targetModel, myTargetNodeId, myResolveInfo);
      node.removeReferent(myRole);
      node.addReference(reference);
    }
  }

  @Override
  public String toString() {
    String targetString = (myTargetModelReference == null ?
      "" + myTargetNodeId :
      String.format("%s|%s", myTargetModelReference, myTargetNodeId)
    );
    return String.format("Set reference in role %s for node %s to %s [resolveInfo=%s]", myRole, getAffectedNodeId(), targetString, myResolveInfo);
  }

  @NotNull
  protected ModelChange createOppositeChange() {
    SNode node = getChangeSet().getOldModel().getNodeById(getAffectedNodeId());
    assert node != null;
    SReference ref = node.getReference(getRole());
    SModelReference targetModel = check_mgdhcs_a0d0g(ref);
    if (eq_mgdhcs_a0e0g(getChangeSet().getOldModel().getSModelReference(), targetModel)) {
      // This is internal reference 
      targetModel = null;
    }

    return new SetReferenceChange(getChangeSet().getOppositeChangeSet(), getAffectedNodeId(), getRole(), targetModel, check_mgdhcs_e0a6a6(ref), check_mgdhcs_f0a6a6(ref));
  }

  private static SModelReference check_mgdhcs_a0d0g(SReference checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getTargetSModelReference();
    }
    return null;
  }

  private static SNodeId check_mgdhcs_e0a6a6(SReference checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getTargetNodeId();
    }
    return null;
  }

  private static String check_mgdhcs_f0a6a6(SReference checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getResolveInfo();
    }
    return null;
  }

  private static boolean eq_mgdhcs_a0e0g(Object a, Object b) {
    return (a != null ?
      a.equals(b) :
      a == b
    );
  }
}
