package jetbrains.mps.vcs.changesmanager;

/*Generated by MPS */

import java.io.File;
import jetbrains.mps.util.FileUtil;
import jetbrains.mps.project.Project;
import com.intellij.openapi.vcs.changes.ChangeListManager;
import com.intellij.openapi.vcs.AbstractVcs;
import com.intellij.openapi.vfs.VirtualFile;
import jetbrains.mps.smodel.descriptor.EditableSModelDescriptor;
import jetbrains.mps.smodel.SModelAdapter;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.SModelRepository;
import jetbrains.mps.smodel.SModelFqName;
import jetbrains.mps.ide.project.ProjectHelper;
import com.intellij.openapi.vcs.impl.projectlevelman.AllVcses;
import jetbrains.mps.ide.vfs.VirtualFileUtils;
import jetbrains.mps.smodel.SReference;
import org.junit.Assert;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import com.intellij.openapi.vcs.changes.Change;
import java.util.Arrays;
import com.intellij.openapi.vcs.changes.VcsDirtyScopeManager;
import com.intellij.openapi.vcs.VcsException;
import jetbrains.mps.vcs.concrete.GitUtils;
import java.io.IOException;
import jetbrains.mps.smodel.persistence.def.ModelReadException;
import jetbrains.mps.smodel.persistence.def.ModelPersistence;
import java.util.List;
import java.util.ArrayList;
import com.intellij.openapi.vcs.rollback.RollbackProgressListener;
import jetbrains.mps.vcs.diff.ChangeSet;
import org.apache.commons.lang.StringUtils;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.vcs.diff.changes.ModelChange;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.util.Computable;
import jetbrains.mps.vcs.diff.ChangeSetBuilder;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import com.intellij.openapi.command.undo.UndoManager;
import org.junit.Test;
import jetbrains.mps.watching.ModelChangesWatcher;
import jetbrains.mps.TestMain;

public class CommonChangesManagerTest {
  private static final File DESTINATION_PROJECT_DIR = new File(FileUtil.getTempDir(), "testConflicts");
  private static final File PROJECT_ARCHIVE = new File("testbench/modules/fugue.zip");
  private static final String PROJECT_FILE = "fugue.mpr";

  private CurrentDifferenceRegistry myRegistry;
  private Project myProject;
  private boolean myWaitCompleted;
  private final Object myWaitLock = new Object();
  private ChangeListManager myChangeListManager;
  private CurrentDifference myHtmlDiff;
  private CurrentDifference myUiDiff;
  private CurrentDifference myUtilDiff;
  private AbstractVcs myGitVcs;
  private com.intellij.openapi.project.Project myIdeaProject;
  private VirtualFile myUtilVirtualFile;

  public CommonChangesManagerTest() {
  }

  private void waitForSomething(Runnable waitScheduling) {
    myWaitCompleted = false;
    waitScheduling.run();
    while (!(myWaitCompleted)) {
      synchronized (myWaitLock) {
        try {
          myWaitLock.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }

  private void waitCompleted() {
    synchronized (myWaitLock) {
      myWaitCompleted = true;
      myWaitLock.notify();
    }
  }

  private void waitForChangesManager() {
    waitForSomething(new Runnable() {
      public void run() {
        myRegistry.getCommandQueue().addTask(new Runnable() {
          public void run() {
            waitCompleted();
          }
        });
      }
    });
  }

  private void waitForModelReplaced(final EditableSModelDescriptor modelDescriptor) {
    waitForSomething(new Runnable() {
      public void run() {
        modelDescriptor.addModelListener(new SModelAdapter() {
          @Override
          public void modelReplaced(SModelDescriptor descriptor) {
            descriptor.removeModelListener(this);
            waitCompleted();
          }
        });
      }
    });
  }

  private CurrentDifference getCurrentDifference(String shortName) {
    return myRegistry.getCurrentDifference((EditableSModelDescriptor) SModelRepository.getInstance().getModelDescriptor(SModelFqName.fromString("ru.geevee.fugue." + shortName)));
  }

  private void init() {
    myIdeaProject = ProjectHelper.toIdeaProject(myProject);
    myRegistry = CurrentDifferenceRegistry.getInstance(myIdeaProject);
    waitForChangesManager();

    myGitVcs = AllVcses.getInstance(myIdeaProject).getByName("Git");
    assert myGitVcs != null;

    myHtmlDiff = getCurrentDifference("html");
    myUiDiff = getCurrentDifference("ui");
    myUtilDiff = getCurrentDifference("util");

    myChangeListManager = ChangeListManager.getInstance(myIdeaProject);

    myUtilVirtualFile = VirtualFileUtils.getVirtualFile(myUtilDiff.getModelDescriptor().getModelFile());

    SReference.disableLogging();
  }

  private void checkAndEnable() {
    Assert.assertNull(myHtmlDiff.getChangeSet());
    Assert.assertNull(myUiDiff.getChangeSet());
    Assert.assertNull(myUtilDiff.getChangeSet());

    myHtmlDiff.setEnabled(true);
    myUiDiff.setEnabled(true);
    myUtilDiff.setEnabled(true);
    waitForChangesManager();

    Assert.assertTrue(ListSequence.fromList(check_orwzer_a0a9a6(myHtmlDiff.getChangeSet())).isNotEmpty());
    Assert.assertTrue(ListSequence.fromList(check_orwzer_a0a01a6(myUiDiff.getChangeSet())).isNotEmpty());
    Assert.assertNull(myUtilDiff.getChangeSet());
  }

  private void modifyModel() {
    runCommandAndWait(new Runnable() {
      public void run() {
        SModel model = myUtilDiff.getModelDescriptor().getSModel();
        SNode root = ListSequence.fromList(SModelOperations.getRoots(model, "jetbrains.mps.baseLanguage.structure.ClassConcept")).findFirst(new IWhereFilter<SNode>() {
          public boolean accept(SNode r) {
            return "ImageLoader".equals(SPropertyOperations.getString(r, "name"));
          }
        });
        SPropertyOperations.set(ListSequence.fromList(SLinkOperations.getTargets(root, "method", true)).findFirst(new IWhereFilter<SNode>() {
          public boolean accept(SNode m) {
            return "getImageAttempts".equals(SPropertyOperations.getString(m, "name"));
          }
        }), "name", "getImageAttempts2");
        ListSequence.fromList(SLinkOperations.getTargets(root, "field", true)).clear();
      }
    });

    waitForChangesManager();
    Assert.assertTrue(ListSequence.fromList(check_orwzer_a0a3a7(myUtilDiff.getChangeSet())).isNotEmpty());
  }

  private void saveAndCommit() {
    runCommandAndWait(new Runnable() {
      public void run() {
        myUtilDiff.getModelDescriptor().save();
      }
    });

    myChangeListManager.ensureUpToDate(false);
    Change change = myChangeListManager.getChange(myUtilVirtualFile);
    assert change != null;
    myGitVcs.getCheckinEnvironment().commit(Arrays.asList(change), "dumb commit");
    VcsDirtyScopeManager.getInstance(myIdeaProject).fileDirty(myUtilVirtualFile);
    myChangeListManager.ensureUpToDate(false);

    waitForChangesManager();
    Assert.assertNull(myUtilDiff.getChangeSet());
  }

  private void uncommit() throws VcsException {
    GitUtils.uncommmit(myIdeaProject, myIdeaProject.getBaseDir());
    VcsDirtyScopeManager.getInstance(myIdeaProject).fileDirty(myUtilVirtualFile);
    myChangeListManager.ensureUpToDate(false);

    waitForChangesManager();
    Assert.assertTrue(ListSequence.fromList(check_orwzer_a0a5a9(myUtilDiff.getChangeSet())).isNotEmpty());
  }

  private void modifyExternally() throws IOException, ModelReadException {
    int changesBefore = ListSequence.fromList(myUtilDiff.getChangeSet().getModelChanges()).count();
    SModel modelContent = ModelPersistence.readModel(myUtilDiff.getModelDescriptor().getModelFile(), false);
    SNode node = (SNode) new SNode(modelContent, "jetbrains.mps.baseLanguage.structure.ClassConcept");
    SPropertyOperations.set(node, "name", "NewRoot");
    SModelOperations.addRootNode(modelContent, node);
    myUtilVirtualFile.setBinaryContent(ModelPersistence.modelToString(modelContent).getBytes(FileUtil.DEFAULT_CHARSET));
    waitForModelReplaced(myUtilDiff.getModelDescriptor());
    waitForChangesManager();
    Assert.assertEquals(changesBefore + 1, ListSequence.fromList(myUtilDiff.getChangeSet().getModelChanges()).count());
  }

  private void rollback() throws VcsException {
    List<VcsException> exceptions = ListSequence.fromList(new ArrayList<VcsException>());
    myGitVcs.getRollbackEnvironment().rollbackChanges(Arrays.asList(myChangeListManager.getChange(myUtilVirtualFile)), exceptions, RollbackProgressListener.EMPTY);
    if (ListSequence.fromList(exceptions).isNotEmpty()) {
      throw ListSequence.fromList(exceptions).first();
    }
    myChangeListManager.ensureUpToDate(false);

    waitForChangesManager();
    Assert.assertNull(myUtilDiff.getChangeSet());
  }

  private String getChangeSetString(ChangeSet changeSet) {
    return StringUtils.join(ListSequence.fromList(changeSet.getModelChanges()).select(new ISelector<ModelChange, String>() {
      public String select(ModelChange c) {
        return c.toString();
      }
    }).sort(new ISelector<String, Comparable<?>>() {
      public Comparable<?> select(String s) {
        return s;
      }
    }, true).toListSequence(), "|");
  }

  private void assertChangeSetIsCorrect(final ChangeSet changeSet) {
    ChangeSet rebuiltChangeSet = ModelAccess.instance().runReadAction(new Computable<ChangeSet>() {
      public ChangeSet compute() {
        return ChangeSetBuilder.buildChangeSet(changeSet.getOldModel(), changeSet.getNewModel());
      }
    });
    Assert.assertEquals(getChangeSetString(rebuiltChangeSet), getChangeSetString(changeSet));
  }

  private void removeModifiedRoot() {
    runCommandAndWait(new Runnable() {
      public void run() {
        SModel model = myUiDiff.getModelDescriptor().getSModel();
        SNode root = ListSequence.fromList(SModelOperations.getRoots(model, "jetbrains.mps.baseLanguage.structure.ClassConcept")).findFirst(new IWhereFilter<SNode>() {
          public boolean accept(SNode r) {
            return "DocumentLayout".equals(SPropertyOperations.getString(r, "name"));
          }
        });
        SNodeOperations.deleteNode(root);
      }
    });
    waitForChangesManager();
    assertChangeSetIsCorrect(myUiDiff.getChangeSet());

    runCommandAndWait(new Runnable() {
      public void run() {
        UndoManager.getInstance(myIdeaProject).undo(null);
      }
    });
    // TODO should not wait 
    waitForChangesManager();
  }

  private void runCommandAndWait(Runnable r) {
    ModelAccess.instance().runCommandInEDT(r, myProject);
    ModelAccess.instance().flushEventQueue();
  }

  @Test
  public void doTest() {
    ModelChangesWatcher.setForceProcessingEnabled(true);
    boolean result = TestMain.testOnProjectCopy(PROJECT_ARCHIVE, DESTINATION_PROJECT_DIR, PROJECT_FILE, new TestMain.ProjectRunnable() {
      public boolean execute(Project project) {
        try {
          myProject = project;
          init();

          checkAndEnable();
          modifyModel();
          saveAndCommit();
          uncommit();
          modifyExternally();
          rollback();

          removeModifiedRoot();
        } catch (Throwable e) {
          e.printStackTrace();
          return false;
        }
        waitForChangesManager();
        return !(myRegistry.getCommandQueue().hadExceptions());
      }
    }, "jetbrains.mps.vcs", "Git4Idea", "jetbrains.mps.ide.make");
    Assert.assertTrue(result);
  }

  private static List<ModelChange> check_orwzer_a0a9a6(ChangeSet checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getModelChanges();
    }
    return null;
  }

  private static List<ModelChange> check_orwzer_a0a01a6(ChangeSet checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getModelChanges();
    }
    return null;
  }

  private static List<ModelChange> check_orwzer_a0a3a7(ChangeSet checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getModelChanges();
    }
    return null;
  }

  private static List<ModelChange> check_orwzer_a0a5a9(ChangeSet checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getModelChanges();
    }
    return null;
  }
}
