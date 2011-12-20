package jetbrains.mps.vcs.changesmanager;

/*Generated by MPS */

import java.io.File;
import jetbrains.mps.util.FileUtil;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import org.junit.Test;
import jetbrains.mps.TestMain;
import jetbrains.mps.project.Project;
import jetbrains.mps.ide.project.ProjectHelper;
import jetbrains.mps.smodel.descriptor.EditableSModelDescriptor;
import jetbrains.mps.smodel.SModelRepository;
import jetbrains.mps.smodel.SModelFqName;
import org.junit.Assert;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.List;
import jetbrains.mps.vcs.diff.changes.ModelChange;
import jetbrains.mps.vcs.diff.ChangeSet;

public class CommonChangesManagerTest {
  private static final File DESTINATION_PROJECT_DIR = new File(FileUtil.getTempDir(), "testConflicts");
  private static final File PROJECT_ARCHIVE = new File("testbench/modules/fugue.zip");
  private static final String PROJECT_FILE = "fugue.mpr";

  private CurrentDifferenceRegistry myRegistry;

  public CommonChangesManagerTest() {
  }

  private void waitForChangesManager() {
    final Object lock = new Object();
    final Wrappers._boolean finished = new Wrappers._boolean(false);
    myRegistry.getCommandQueue().addTask(new Runnable() {
      public void run() {
        synchronized (lock) {
          finished.value = true;
          lock.notify();
        }
      }
    });
    while (!(finished.value)) {
      synchronized (lock) {
        try {
          lock.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }

  @Test
  public void doTest() {
    TestMain.testOnProjectCopy(PROJECT_ARCHIVE, DESTINATION_PROJECT_DIR, PROJECT_FILE, new TestMain.ProjectRunnable() {
      public boolean execute(Project project) {
        try {
          myRegistry = CurrentDifferenceRegistry.getInstance(ProjectHelper.toIdeaProject(project));
          EditableSModelDescriptor htmlmd = (EditableSModelDescriptor) SModelRepository.getInstance().getModelDescriptor(SModelFqName.fromString("ru.geevee.fugue.html"));
          waitForChangesManager();
          CurrentDifference cd = myRegistry.getCurrentDifference(htmlmd);
          Assert.assertNull(cd.getChangeSet());
          cd.setEnabled(true);
          waitForChangesManager();
          Assert.assertFalse(ListSequence.fromList(check_orwzer_a0a7a0a3a0a1(cd.getChangeSet())).isEmpty());
          return true;
        } catch (Throwable e) {
          e.printStackTrace();
          return false;
        }
      }
    }, "jetbrains.mps.vcs", "Git4Idea", "jetbrains.mps.ide.make");
  }

  private static List<ModelChange> check_orwzer_a0a7a0a3a0a1(ChangeSet checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getModelChanges();
    }
    return null;
  }
}
