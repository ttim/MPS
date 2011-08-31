package jetbrains.mps.vcs.diff.merge.ui;

/*Generated by MPS */

import jetbrains.mps.ide.dialogs.BaseDialog;
import jetbrains.mps.vcs.diff.merge.MergeContext;
import jetbrains.mps.vcs.diff.changes.ModelChange;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import jetbrains.mps.smodel.ModelAccess;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.util.NameUtil;
import com.intellij.openapi.ui.Messages;

public class MergeConfirmation {
  public static final int RETURN = 0;
  public static final int SAVE_AS_IS = 1;
  public static final int RESOLVE_AUTOMATICALLY = 2;

  private MergeConfirmation() {
  }

  public static void showMergeConfirmationAndTakeAction(BaseDialog dialog, MergeContext mergeContext, Iterable<ModelChange> allRelevantChanges, final _FunctionTypes._void_P0_E0 resolveTask, final _FunctionTypes._void_P0_E0 saveAndCloseTask) {
    int result = MergeConfirmation.showMergeConfirmationIfNeeded(dialog, mergeContext, allRelevantChanges);
    if (result == RETURN) {
    } else if (result == SAVE_AS_IS) {
      saveAndCloseTask.invoke();
    } else if (result == RESOLVE_AUTOMATICALLY) {
      ModelAccess.instance().runWriteActionInCommand(new Runnable() {
        public void run() {
          resolveTask.invoke();
          saveAndCloseTask.invoke();
        }
      });
    }
  }

  private static int showMergeConfirmationIfNeeded(BaseDialog dialog, final MergeContext mergeContext, Iterable<ModelChange> allRelevantChanges) {
    List<ModelChange> changes = Sequence.<ModelChange>fromIterable(allRelevantChanges).where(new IWhereFilter<ModelChange>() {
      public boolean accept(ModelChange ch) {
        return !(mergeContext.isChangeResolved(ch));
      }
    }).toListSequence();
    Iterable<ModelChange> conflictedChanges = ListSequence.<ModelChange>fromList(changes).where(new IWhereFilter<ModelChange>() {
      public boolean accept(ModelChange ch) {
        return Sequence.<ModelChange>fromIterable(mergeContext.getConflictedWith(ch)).isNotEmpty();
      }
    });
    if (Sequence.<ModelChange>fromIterable(conflictedChanges).count() != 0) {
      return showUnresolvedConflictsConfirmation(dialog, Sequence.<ModelChange>fromIterable(conflictedChanges).count());
    } else if (ListSequence.<ModelChange>fromList(changes).count() != 0) {
      return showUnresolvedChangesConfirmation(dialog, ListSequence.<ModelChange>fromList(changes).count());
    }
    return SAVE_AS_IS;
  }

  private static int showUnresolvedConflictsConfirmation(BaseDialog dialog, int changes) {
    String msg = String.format("You have %s left. You need to resolve them manually.\n" + "Are you sure want to close merge dialog without resolving them?", NameUtil.formatNumericalString(changes, "unresolved conflicting change"));
    if (Messages.showYesNoDialog(dialog, msg, "Unresolved Conflicting Changes", Messages.getWarningIcon()) == 0) {
      return SAVE_AS_IS;
    } else {
      return RETURN;
    }
  }

  private static int showUnresolvedChangesConfirmation(BaseDialog dialog, int changes) {
    String message = String.format("You have %s left. Do you want to resolve %s automatically?", NameUtil.formatNumericalString(changes, "unresolved change"), (changes > 1 ?
      "them" :
      "it"
    ));
    String title = "Unresolved Change" + ((changes > 1 ?
      "s" :
      ""
    ));
    int answer = Messages.showYesNoCancelDialog(dialog, message, title, Messages.getQuestionIcon());
    if (answer == 0) {
      return RESOLVE_AUTOMATICALLY;
    } else if (answer == 1) {
      // Do nothing, leave unresolved changes as is 
      return SAVE_AS_IS;
    } else {
      return RETURN;
    }
  }
}
