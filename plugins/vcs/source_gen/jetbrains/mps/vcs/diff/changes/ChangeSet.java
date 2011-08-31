package jetbrains.mps.vcs.diff.changes;

/*Generated by MPS */

import jetbrains.mps.smodel.SModel;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.internal.collections.runtime.Sequence;

public class ChangeSet {
  private final SModel myOldModel;
  private final SModel myNewModel;
  private final List<ModelChange> myModelChanges = ListSequence.<ModelChange>fromList(new ArrayList<ModelChange>());
  private ChangeSet myOppositeChangeSet = null;

  /*package*/ ChangeSet(@NotNull SModel oldModel, @NotNull SModel newModel) {
    myOldModel = oldModel;
    myNewModel = newModel;
  }

  @NotNull
  public List<ModelChange> getModelChanges() {
    return myModelChanges;
  }

  @NotNull
  public <C extends ModelChange> Iterable<C> getModelChanges(final Class<C> changeClass) {
    return ListSequence.<ModelChange>fromList(myModelChanges).where(new IWhereFilter<ModelChange>() {
      public boolean accept(ModelChange ch) {
        return changeClass.isInstance(ch);
      }
    }).<C>select(new ISelector<ModelChange, C>() {
      public C select(ModelChange ch) {
        return (C) ch;
      }
    });
  }

  @NotNull
  public SModel getOldModel() {
    return myOldModel;
  }

  @NotNull
  public SModel getNewModel() {
    return myNewModel;
  }

  @NotNull
  public ChangeSet getOppositeChangeSet() {
    if (myOppositeChangeSet == null) {
      throw new IllegalStateException("opposite chage set is not built");
    }

    return myOppositeChangeSet;
  }

  /*package*/ void clearOppositeChangeSet() {
    myOppositeChangeSet = null;
  }

  /*package*/ void buildOppositeChangeSet() {
    if (myOppositeChangeSet == null) {
      ModelAccess.assertLegalRead();

      myOppositeChangeSet = new ChangeSet(myNewModel, myOldModel);
      myOppositeChangeSet.myOppositeChangeSet = this;

      myOppositeChangeSet.addAll(ListSequence.<ModelChange>fromList(myModelChanges).<ModelChange>select(new ISelector<ModelChange, ModelChange>() {
        public ModelChange select(ModelChange c) {
          return c.getOppositeChange();
        }
      }));
    }
  }

  /*package*/ void add(@NotNull ModelChange change) {
    ListSequence.<ModelChange>fromList(myModelChanges).addElement(change);
  }

  /*package*/ void addAll(Iterable<? extends ModelChange> change) {
    ListSequence.<ModelChange>fromList(myModelChanges).addSequence(Sequence.fromIterable(change));
  }
}
