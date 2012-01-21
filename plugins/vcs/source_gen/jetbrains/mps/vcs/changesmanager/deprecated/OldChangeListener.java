package jetbrains.mps.vcs.changesmanager.deprecated;

/*Generated by MPS */

import java.util.EventListener;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.vcs.changesmanager.deprecated.changes.OldChange;
import jetbrains.mps.smodel.SModel;
import org.jetbrains.annotations.Nullable;
import com.intellij.openapi.vcs.FileStatus;

@Deprecated
public interface OldChangeListener extends EventListener {
  public void changeAdded(@NotNull OldChange change, @NotNull SModel model);
  public void changeRemoved(@NotNull OldChange change, @NotNull SModel model);
  public void fileStatusChanged(@Nullable FileStatus newFileStatus, @NotNull SModel model);
  public void changeUpdateStarted();
  public void changeUpdateFinished();
  public static class ChangeAdapter implements OldChangeListener {
    public ChangeAdapter() {
    }

    public void changeUpdateFinished() {
    }

    public void changeUpdateStarted() {
    }

    public void fileStatusChanged(@Nullable FileStatus newFileStatus, @NotNull SModel model) {
    }

    public void changeRemoved(@NotNull OldChange change, @NotNull SModel model) {
    }

    public void changeAdded(@NotNull OldChange change, @NotNull SModel model) {
    }
  }

}
