package jetbrains.mps.vcs.diff.changes;

/*Generated by MPS */

import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.smodel.SNodeId;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.vcs.diff.ChangeSet;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.smodel.DynamicReference;
import jetbrains.mps.smodel.StaticReference;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;

public class SetReferenceChange extends NodeChange {
  private String myRole;
  private SModelReference myTargetModelReference;
  private SNodeId myTargetNodeId;
  private String myResolveInfo;

  public SetReferenceChange(@NotNull ChangeSet changeSet, @NotNull SNodeId sourceNodeId, @NotNull String role, @Nullable SModelReference targetModelReference, @Nullable SNodeId targetNodeId, @Nullable String resolveInfo) {
    super(changeSet, sourceNodeId);
    myRole = role;
    myTargetModelReference = targetModelReference;
    // if target node id is null and resolve info is not-null it's dynamic reference 
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
      SModelReference targetModelReference = (myTargetModelReference == null ?
        model.getSModelReference() :
        myTargetModelReference
      );
      SReference reference;
      if (myTargetNodeId == null) {
        reference = new DynamicReference(myRole, node, targetModelReference, myResolveInfo);
      } else {
        reference = new StaticReference(myRole, node, targetModelReference, myTargetNodeId, myResolveInfo);
      }
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

  public String getDescription() {
    // TODO consider dynamic references 
    SReference oldRef = getChangeSet().getOldModel().getNodeById(getAffectedNodeId()).getReference(myRole);
    SReference newRef = getChangeSet().getNewModel().getNodeById(getAffectedNodeId()).getReference(myRole);
    if (oldRef == null) {
      return String.format("Added %s reference", myRole);
    }
    if (newRef == null) {
      return String.format("Removed %s reference", myRole);
    }
    String what = "target";
    _FunctionTypes._return_P1_E0<? extends String, ? super SReference> formatRef = null;
    if (neq_mgdhcs_a0h0g(oldRef.getTargetSModelReference(), newRef.getTargetSModelReference())) {
      formatRef = new _FunctionTypes._return_P1_E0<String, SReference>() {
        public String invoke(SReference ref) {
          return String.format("[model=%s,\n  id=%s, resolveInfo=%s]", ref.getTargetSModelReference(), ref.getTargetNodeId(), ref.getResolveInfo());
        }
      };
    }
    if (neq_mgdhcs_a0i0g(oldRef.getTargetNodeId(), newRef.getTargetNodeId())) {
      formatRef = new _FunctionTypes._return_P1_E0<String, SReference>() {
        public String invoke(SReference ref) {
          return String.format("[id=%s, resolveInfo=%s]", ref.getTargetNodeId(), ref.getTargetNodeId());
        }
      };
    }
    if (neq_mgdhcs_a0j0g(oldRef.getResolveInfo(), newRef.getResolveInfo())) {
      what = "resolve info";
      formatRef = new _FunctionTypes._return_P1_E0<String, SReference>() {
        public String invoke(SReference ref) {
          return String.format("'%s'", ref.getResolveInfo());
        }
      };
    }
    if (formatRef == null) {
      return toString();
    } else {
      return String.format("Changed %s reference %s from\n  %s\n  to\n  %s", myRole, what, formatRef.invoke(oldRef), formatRef.invoke(newRef));
    }
  }

  @NotNull
  protected ModelChange createOppositeChange() {
    SNode node = getChangeSet().getOldModel().getNodeById(getAffectedNodeId());
    assert node != null;
    SReference ref = node.getReference(getRole());
    SModelReference targetModel = check_mgdhcs_a0d0h(ref);
    if (eq_mgdhcs_a0e0h(getChangeSet().getOldModel().getSModelReference(), targetModel)) {
      // This is internal reference 
      targetModel = null;
    }

    return new SetReferenceChange(getChangeSet().getOppositeChangeSet(), getAffectedNodeId(), getRole(), targetModel, check_mgdhcs_e0a6a7(ref), check_mgdhcs_f0a6a7(ref));
  }

  private static SModelReference check_mgdhcs_a0d0h(SReference checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getTargetSModelReference();
    }
    return null;
  }

  private static SNodeId check_mgdhcs_e0a6a7(SReference checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getTargetNodeId();
    }
    return null;
  }

  private static String check_mgdhcs_f0a6a7(SReference checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getResolveInfo();
    }
    return null;
  }

  private static boolean neq_mgdhcs_a0h0g(Object a, Object b) {
    return !((a != null ?
      a.equals(b) :
      a == b
    ));
  }

  private static boolean neq_mgdhcs_a0i0g(Object a, Object b) {
    return !((a != null ?
      a.equals(b) :
      a == b
    ));
  }

  private static boolean neq_mgdhcs_a0j0g(Object a, Object b) {
    return !((a != null ?
      a.equals(b) :
      a == b
    ));
  }

  private static boolean eq_mgdhcs_a0e0h(Object a, Object b) {
    return (a != null ?
      a.equals(b) :
      a == b
    );
  }
}
