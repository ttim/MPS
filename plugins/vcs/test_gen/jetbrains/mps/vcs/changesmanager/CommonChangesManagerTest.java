package jetbrains.mps.vcs.changesmanager;

/*Generated by MPS */

import java.io.File;
import jetbrains.mps.util.FileUtil;
import jetbrains.mps.project.Project;
import com.intellij.openapi.vcs.changes.ChangeListManagerImpl;
import com.intellij.openapi.vcs.AbstractVcs;
import com.intellij.openapi.vfs.VirtualFile;
import jetbrains.mps.smodel.descriptor.EditableSModelDescriptor;
import jetbrains.mps.smodel.SModelAdapter;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.SModelRepository;
import jetbrains.mps.smodel.SModelFqName;
import jetbrains.mps.ide.project.ProjectHelper;
import com.intellij.openapi.vcs.impl.projectlevelman.AllVcses;
import com.intellij.openapi.vcs.ProjectLevelVcsManager;
import com.intellij.openapi.vcs.VcsConfiguration;
import com.intellij.openapi.vcs.VcsShowConfirmationOption;
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
import jetbrains.mps.vcs.diff.changes.ModelChange;
import org.apache.commons.lang.StringUtils;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.util.Computable;
import jetbrains.mps.vcs.diff.ChangeSetBuilder;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import jetbrains.mps.smodel.SNodePointer;
import javax.swing.SwingUtilities;
import com.intellij.openapi.fileEditor.FileEditor;
import com.intellij.openapi.command.undo.UndoManager;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.internal.collections.runtime.IVisitor;
import java.util.Random;
import jetbrains.mps.vcs.diff.changes.NodeCopier;
import jetbrains.mps.vcs.diff.changes.AddRootChange;
import jetbrains.mps.vcs.diff.changes.ModuleDependencyChange;
import jetbrains.mps.project.IModule;
import com.intellij.openapi.vcs.FileStatusManager;
import jetbrains.mps.project.structure.modules.ModuleReference;
import jetbrains.mps.workbench.actions.model.DeleteModelHelper;
import org.junit.Test;
import jetbrains.mps.watching.ModelChangesWatcher;
import jetbrains.mps.TestMain;
import jetbrains.mps.nodeEditor.InspectorTool;
import com.intellij.openapi.command.undo.DocumentReferenceProvider;
import jetbrains.mps.workbench.nodesFs.MPSNodeVirtualFile;
import jetbrains.mps.workbench.nodesFs.MPSNodesVirtualFileSystem;
import org.jetbrains.annotations.NotNull;
import javax.swing.JComponent;
import org.jetbrains.annotations.Nullable;
import com.intellij.openapi.util.Key;
import java.util.Collection;
import com.intellij.openapi.command.undo.DocumentReference;
import com.intellij.openapi.command.undo.DocumentReferenceManager;
import org.jetbrains.annotations.NonNls;
import com.intellij.openapi.fileEditor.FileEditorState;
import com.intellij.openapi.fileEditor.FileEditorStateLevel;
import java.beans.PropertyChangeListener;
import com.intellij.codeHighlighting.BackgroundEditorHighlighter;
import com.intellij.openapi.fileEditor.FileEditorLocation;
import com.intellij.ide.structureView.StructureViewBuilder;

public class CommonChangesManagerTest {
  private static final File DESTINATION_PROJECT_DIR = new File(FileUtil.getTempDir(), "testConflicts");
  private static final File PROJECT_ARCHIVE = new File("testbench/modules/fugue.zip");
  private static final String PROJECT_FILE = "fugue.mpr";
  private static final String MODEL_PREFIX = "ru.geevee.fugue.";

  private CurrentDifferenceRegistry myRegistry;
  private Project myProject;
  private boolean myWaitCompleted;
  private final Object myWaitLock = new Object();
  private ChangeListManagerImpl myChangeListManager;
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
    return myRegistry.getCurrentDifference((EditableSModelDescriptor) SModelRepository.getInstance().getModelDescriptor(SModelFqName.fromString(MODEL_PREFIX + shortName)));
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

    myChangeListManager = ChangeListManagerImpl.getInstanceImpl(myIdeaProject);

    ProjectLevelVcsManager vcsManager = ProjectLevelVcsManager.getInstance(myIdeaProject);
    vcsManager.getStandardConfirmation(VcsConfiguration.StandardConfirmation.ADD, myGitVcs).setValue(VcsShowConfirmationOption.Value.DO_NOTHING_SILENTLY);

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

  private SNode createNewRoot(SModel modelContent) {
    SNode root = (SNode) new SNode(modelContent, "jetbrains.mps.baseLanguage.structure.ClassConcept");
    SPropertyOperations.set(root, "name", "NewRoot");
    SModelOperations.addRootNode(modelContent, root);
    return root;
  }

  private void modifyExternally() throws IOException, ModelReadException {
    int changesBefore = ListSequence.fromList(myUtilDiff.getChangeSet().getModelChanges()).count();
    SModel modelContent = ModelPersistence.readModel(myUtilDiff.getModelDescriptor().getModelFile(), false);
    createNewRoot(modelContent);
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
    return getChangeSetString(changeSet.getModelChanges());
  }

  private String getChangeSetString(List<ModelChange> modelChanges) {
    return StringUtils.join(ListSequence.fromList(modelChanges).select(new ISelector<ModelChange, String>() {
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

  private void waitAndCheck(CurrentDifference currentDifference) {
    waitForChangesManager();
    assertChangeSetIsCorrect(currentDifference.getChangeSet());
  }

  private void runCommandAndWait(Runnable r) {
    ModelAccess.instance().runCommandInEDT(r, myProject);
    ModelAccess.instance().flushEventQueue();
  }

  private void doSomethingAndUndo(CurrentDifference diff, _FunctionTypes._return_P0_E0<? extends SNode>... tasks) {
    doSomethingAndUndo(diff, false, tasks);
  }

  private void doSomethingAndUndo(CurrentDifference diff, boolean checkAfterEachUndo, _FunctionTypes._return_P0_E0<? extends SNode>... tasks) {
    doSomethingAndUndo(diff, checkAfterEachUndo, Arrays.asList(tasks));
  }

  private void doSomethingAndUndo(CurrentDifference diff, boolean checkAfterEachUndo, List<_FunctionTypes._return_P0_E0<? extends SNode>> tasks) {
    String stringBefore = getChangeSetString(diff.getChangeSet());

    final List<SNodePointer> affectedNodePointers = ListSequence.fromList(new ArrayList<SNodePointer>());
    for (final _FunctionTypes._return_P0_E0<? extends SNode> t : ListSequence.fromList(tasks)) {
      runCommandAndWait(new Runnable() {
        public void run() {
          SNode node = t.invoke();
          assert node.isRoot();
          ListSequence.fromList(affectedNodePointers).addElement((node == null ?
            null :
            new SNodePointer(node)
          ));
        }
      });
      waitAndCheck(diff);
    }

    undoAndCheck(diff, affectedNodePointers, checkAfterEachUndo);
    Assert.assertEquals(stringBefore, getChangeSetString(diff.getChangeSet()));
  }

  private void undoAndCheck(CurrentDifference diff, List<SNodePointer> affectedNodePointers, boolean checkAfterEachUndo) {
    for (final SNodePointer np : ListSequence.fromList(affectedNodePointers).reversedList()) {
      try {
        SwingUtilities.invokeAndWait(new Runnable() {
          public void run() {
            FileEditor fe = null;
            if (np != null) {
              fe = new CommonChangesManagerTest.MyFileEditor(np);
            }
            UndoManager.getInstance(myIdeaProject).undo(fe);
            check_orwzer_a3a0a0a0a0a12(fe);
          }
        });
      } catch (Throwable t) {
        throw new AssertionError(t);
      }
      if (checkAfterEachUndo) {
        waitAndCheck(diff);
      }
    }
    if (!(checkAfterEachUndo)) {
      waitAndCheck(diff);
    }
  }

  private SNode getDocumentLayoutRoot() {
    SModel model = myUiDiff.getModelDescriptor().getSModel();
    return ListSequence.fromList(SModelOperations.getRoots(model, "jetbrains.mps.baseLanguage.structure.ClassConcept")).findFirst(new IWhereFilter<SNode>() {
      public boolean accept(SNode r) {
        return "DocumentLayout".equals(SPropertyOperations.getString(r, "name"));
      }
    });
  }

  private void removeModifiedRoot() {
    doSomethingAndUndo(myUiDiff, new _FunctionTypes._return_P0_E0<SNode>() {
      public SNode invoke() {
        SNode root = getDocumentLayoutRoot();
        SNodeOperations.deleteNode(root);
        return (SNode) null;
      }
    });
  }

  private void addRoot() {
    final Wrappers._T<SNode> root = new Wrappers._T<SNode>();
    doSomethingAndUndo(myUiDiff, new _FunctionTypes._return_P0_E0<SNode>() {
      public SNode invoke() {
        SModel model = myUiDiff.getModelDescriptor().getSModel();
        root.value = createNewRoot(model);
        return (SNode) null;
      }
    }, new _FunctionTypes._return_P0_E0<SNode>() {
      public SNode invoke() {
        SPropertyOperations.set(root.value, "name", "NewRootName");
        return root.value;
      }
    });
  }

  private void changeProperty() {
    final Wrappers._T<SNode> method = new Wrappers._T<SNode>();
    doSomethingAndUndo(myUiDiff, new _FunctionTypes._return_P0_E0<SNode>() {
      public SNode invoke() {
        method.value = ListSequence.fromList(SLinkOperations.getTargets(getDocumentLayoutRoot(), "method", true)).findFirst(new IWhereFilter<SNode>() {
          public boolean accept(SNode m) {
            return "selectAll".equals(SPropertyOperations.getString(m, "name"));
          }
        });
        Assert.assertNotNull(method.value);
        SPropertyOperations.set(method.value, "name", "selectEverything");
        return SNodeOperations.getContainingRoot(method.value);
      }
    }, new _FunctionTypes._return_P0_E0<SNode>() {
      public SNode invoke() {
        SPropertyOperations.set(method.value, "name", "selectEverySinglePiece");
        return SNodeOperations.getContainingRoot(method.value);
      }
    });
  }

  private void changeReference() {
    final Wrappers._T<SNode> root = new Wrappers._T<SNode>();
    final Wrappers._T<SNode> method = new Wrappers._T<SNode>();
    doSomethingAndUndo(myUiDiff, new _FunctionTypes._return_P0_E0<SNode>() {
      public SNode invoke() {
        root.value = getDocumentLayoutRoot();
        method.value = ListSequence.fromList(SLinkOperations.getTargets(root.value, "method", true)).findFirst(new IWhereFilter<SNode>() {
          public boolean accept(SNode m) {
            return "getSize".equals(SPropertyOperations.getString(m, "name"));
          }
        });
        Assert.assertNotNull(method.value);
        SLinkOperations.setTarget(SNodeOperations.cast(SLinkOperations.getTarget(method.value, "returnType", true), "jetbrains.mps.baseLanguage.structure.ClassifierType"), "classifier", root.value, false);
        return root.value;
      }
    }, new _FunctionTypes._return_P0_E0<SNode>() {
      public SNode invoke() {
        SLinkOperations.setTarget(SNodeOperations.cast(SLinkOperations.getTarget(method.value, "returnType", true), "jetbrains.mps.baseLanguage.structure.ClassifierType"), "classifier", ListSequence.fromList(SLinkOperations.getTargets(root.value, "staticInnerClassifiers", true)).first(), false);
        return SNodeOperations.getContainingRoot(method.value);
      }
    });
  }

  private void moveNode() {
    final Wrappers._T<SNode> root = new Wrappers._T<SNode>();
    final Wrappers._T<SNode> field = new Wrappers._T<SNode>();
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        root.value = getDocumentLayoutRoot();
        field.value = ListSequence.fromList(SLinkOperations.getTargets(root.value, "field", true)).findFirst(new IWhereFilter<SNode>() {
          public boolean accept(SNode f) {
            return "textPositions".equals(SPropertyOperations.getString(f, "name"));
          }
        });
      }
    });
    Assert.assertNotNull(field.value);

    _FunctionTypes._return_P0_E0<? extends SNode> moveUpTwice = new _FunctionTypes._return_P0_E0<SNode>() {
      public SNode invoke() {
        SNodeOperations.insertPrevSiblingChild(field.value, SNodeOperations.getPrevSibling(field.value));
        SNodeOperations.insertPrevSiblingChild(field.value, SNodeOperations.getPrevSibling(field.value));
        return SNodeOperations.getContainingRoot(field.value);
      }
    };
    _FunctionTypes._return_P0_E0<? extends SNode> moveDown = new _FunctionTypes._return_P0_E0<SNode>() {
      public SNode invoke() {
        SNodeOperations.insertNextSiblingChild(field.value, SNodeOperations.getNextSibling(field.value));
        return SNodeOperations.getContainingRoot(field.value);
      }
    };
    _FunctionTypes._return_P0_E0<? extends SNode> moveToOtherClass = new _FunctionTypes._return_P0_E0<SNode>() {
      public SNode invoke() {
        SNode inner = SNodeOperations.cast(ListSequence.fromList(SLinkOperations.getTargets(root.value, "staticInnerClassifiers", true)).first(), "jetbrains.mps.baseLanguage.structure.ClassConcept");
        ListSequence.fromList(SLinkOperations.getTargets(inner, "field", true)).addElement(field.value);
        return SNodeOperations.getContainingRoot(field.value);
      }
    };

    List<_FunctionTypes._return_P0_E0<? extends SNode>> tasks = ListSequence.fromList(new ArrayList<_FunctionTypes._return_P0_E0<? extends SNode>>());
    for (int i = 0; i < 3; i++) {
      ListSequence.fromList(tasks).addElement(moveUpTwice);
    }
    for (int i = 0; i < 19; i++) {
      ListSequence.fromList(tasks).addElement(moveDown);
    }
    ListSequence.fromList(tasks).addElement(moveToOtherClass);
    doSomethingAndUndo(myUiDiff, false, tasks);
  }

  private void inlineVariable() {
    final Wrappers._T<SNode> root = new Wrappers._T<SNode>();
    final Wrappers._T<SNode> method = new Wrappers._T<SNode>();
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        root.value = getDocumentLayoutRoot();
        method.value = ListSequence.fromList(SLinkOperations.getTargets(root.value, "method", true)).findFirst(new IWhereFilter<SNode>() {
          public boolean accept(SNode f) {
            return "getTextPosition".equals(SPropertyOperations.getString(f, "name"));
          }
        });
      }
    });
    doSomethingAndUndo(myUiDiff, true, new _FunctionTypes._return_P0_E0<SNode>() {
      public SNode invoke() {
        SNode ifBefore = (SNode) new SNode(SNodeOperations.getModel(root.value), "jetbrains.mps.baseLanguage.structure.IfStatement");
        SNodeOperations.insertPrevSiblingChild(ListSequence.fromList(SLinkOperations.getTargets(SLinkOperations.getTarget(method.value, "body", true), "statement", true)).first(), ifBefore);
        return root.value;
      }
    }, new _FunctionTypes._return_P0_E0<SNode>() {
      public SNode invoke() {
        SNode foreachBody = SLinkOperations.getTarget(SNodeOperations.cast(ListSequence.fromList(SLinkOperations.getTargets(SLinkOperations.getTarget(method.value, "body", true), "statement", true)).getElement(1), "jetbrains.mps.baseLanguage.structure.ForeachStatement"), "body", true);
        SNode declarationStatement = SNodeOperations.cast(ListSequence.fromList(SLinkOperations.getTargets(foreachBody, "statement", true)).getElement(0), "jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement");
        final SNode declaration = SLinkOperations.getTarget(declarationStatement, "localVariableDeclaration", true);
        final SNode initializer = SLinkOperations.getTarget(declaration, "initializer", true);
        ListSequence.fromList(SNodeOperations.getDescendants(foreachBody, "jetbrains.mps.baseLanguage.structure.LocalVariableReference", false, new String[]{})).where(new IWhereFilter<SNode>() {
          public boolean accept(SNode vr) {
            return SLinkOperations.getTarget(vr, "variableDeclaration", false) == declaration;
          }
        }).visitAll(new IVisitor<SNode>() {
          public void visit(SNode vr) {
            SNodeOperations.replaceWithAnother(vr, SNodeOperations.copyNode(initializer));
          }
        });
        SNodeOperations.deleteNode(declarationStatement);
        return root.value;
      }
    }, new _FunctionTypes._return_P0_E0<SNode>() {
      public SNode invoke() {
        SNodeOperations.deleteNode(ListSequence.fromList(SLinkOperations.getTargets(SLinkOperations.getTarget(method.value, "body", true), "statement", true)).getElement(2));
        SNodeOperations.deleteNode(ListSequence.fromList(SLinkOperations.getTargets(SLinkOperations.getTarget(method.value, "body", true), "statement", true)).getElement(1));
        return root.value;
      }
    });
  }

  private void rollbackAll() {
    Random random = new Random(239);
    String stringBeforeAll = getChangeSetString(myUiDiff.getChangeSet());
    final SModel model = myUiDiff.getModelDescriptor().getSModel();

    List<SNodePointer> affectedNodePointers = ListSequence.fromList(new ArrayList<SNodePointer>());

    while (true) {
      List<ModelChange> changesBefore = ListSequence.fromListWithValues(new ArrayList<ModelChange>(), myUiDiff.getChangeSet().getModelChanges());
      if (ListSequence.fromList(changesBefore).isEmpty()) {
        break;
      }
      final ModelChange changeToPick = ListSequence.fromList(changesBefore).getElement(random.nextInt(ListSequence.fromList(changesBefore).count()));
      runCommandAndWait(new Runnable() {
        public void run() {
          changeToPick.getOppositeChange().apply(model, new NodeCopier(model));
        }
      });
      waitAndCheck(myUiDiff);

      ListSequence.fromList(changesBefore).removeElement(changeToPick);
      Assert.assertEquals(getChangeSetString(changesBefore), getChangeSetString(myUiDiff.getChangeSet()));

      ListSequence.fromList(affectedNodePointers).addElement(new SNodePointer(myUiDiff.getModelDescriptor().getSModelReference(), changeToPick.getRootId()));
    }

    undoAndCheck(myUiDiff, affectedNodePointers, false);
    Assert.assertEquals(stringBeforeAll, getChangeSetString(myUiDiff.getChangeSet()));
  }

  private void checkOneAddedRoot(CurrentDifference newModelDiff) {
    waitForChangesManager();
    List<ModelChange> changes = newModelDiff.getChangeSet().getModelChanges();
    Assert.assertEquals(2, ListSequence.fromList(changes).count());
    Assert.assertTrue(ListSequence.fromList(changes).any(new IWhereFilter<ModelChange>() {
      public boolean accept(ModelChange it) {
        return it instanceof AddRootChange;
      }
    }));
    Assert.assertTrue(ListSequence.fromList(changes).any(new IWhereFilter<ModelChange>() {
      public boolean accept(ModelChange it) {
        return it instanceof ModuleDependencyChange;
      }
    }));
  }

  private void createNewModel() {
    final Wrappers._T<CurrentDifference> newModelDiff = new Wrappers._T<CurrentDifference>();
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        String modelName = "newmodel";
        IModule module = myUiDiff.getModelDescriptor().getModule();
        module.createModel(SModelFqName.fromString(MODEL_PREFIX + modelName), module.getSModelRoots().get(0), null);
        newModelDiff.value = getCurrentDifference(modelName);
      }
    });
    final EditableSModelDescriptor md = newModelDiff.value.getModelDescriptor();
    ModelAccess.instance().runWriteInEDT(new Runnable() {
      public void run() {
        md.getSModel();
        md.save();
      }
    });
    ModelAccess.instance().flushEventQueue();

    VirtualFile vf = VirtualFileUtils.getVirtualFile(md.getModelFile());
    VcsDirtyScopeManager.getInstance(myIdeaProject).fileDirty(vf);
    myChangeListManager.ensureUpToDate(false);
    FileStatusManager.getInstance(myIdeaProject).fileStatusChanged(vf);

    newModelDiff.value.setEnabled(true);
    waitForChangesManager();
    Assert.assertTrue((int) ListSequence.fromList(newModelDiff.value.getChangeSet().getModelChanges()).count() == 0);

    runCommandAndWait(new Runnable() {
      public void run() {
        SModel m = md.getSModel();
        m.addLanguage(ModuleReference.fromString("f3061a53-9226-4cc5-a443-f952ceaf5816(jetbrains.mps.baseLanguage)"));
        createNewRoot(m);
      }
    });
    checkOneAddedRoot(newModelDiff.value);

    myChangeListManager.addUnversionedFiles(myChangeListManager.getDefaultChangeList(), Arrays.asList(vf));
    myChangeListManager.ensureUpToDate(false);
    checkOneAddedRoot(newModelDiff.value);
  }

  private void deleteModelAndRollback() {
    final EditableSModelDescriptor md = myUiDiff.getModelDescriptor();
    String changeSetStringBefore = getChangeSetString(myUiDiff.getChangeSet());
    runCommandAndWait(new Runnable() {
      public void run() {
        DeleteModelHelper.deleteModel(myIdeaProject, md.getModule(), md, false, true);
      }
    });
    waitForChangesManager();

    try {
      SwingUtilities.invokeAndWait(new Runnable() {
        public void run() {
          UndoManager.getInstance(myIdeaProject).undo(null);
        }
      });
    } catch (Exception e) {
      e.printStackTrace();
      Assert.fail();
    }
    waitForChangesManager();
    myUiDiff = getCurrentDifference("ui");
    myUiDiff.setEnabled(true);
    waitForChangesManager();
    myChangeListManager.ensureUpToDate(false);
    waitForChangesManager();
    Assert.assertEquals(changeSetStringBefore, getChangeSetString(myUiDiff.getChangeSet()));
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
          addRoot();
          changeProperty();
          changeReference();
          moveNode();
          inlineVariable();
          rollbackAll();

          createNewModel();
          deleteModelAndRollback();

          SwingUtilities.invokeAndWait(new Runnable() {
            public void run() {
              myIdeaProject.getComponent(InspectorTool.class).getInspector().editNode(null, null);
            }
          });

          return true;
        } catch (Throwable e) {
          e.printStackTrace();
          return false;
        }
      }
    }, "jetbrains.mps.vcs", "Git4Idea", "jetbrains.mps.ide.make");
    Assert.assertTrue(result);

    Assert.assertFalse(myRegistry.getCommandQueue().hadExceptions());
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

  private static void check_orwzer_a3a0a0a0a0a12(FileEditor checkedDotOperand) {
    if (null != checkedDotOperand) {
      checkedDotOperand.dispose();
    }

  }

  private class MyFileEditor implements FileEditor, DocumentReferenceProvider {
    private MPSNodeVirtualFile myFile;

    private MyFileEditor(SNodePointer nodePointer) {
      myFile = MPSNodesVirtualFileSystem.getInstance().getFileFor(nodePointer);
    }

    @NotNull
    public JComponent getComponent() {
      throw new UnsupportedOperationException();
    }

    @Nullable
    public <T> T getUserData(@NotNull Key<T> key) {
      throw new UnsupportedOperationException();
    }

    public void dispose() {
    }

    public Collection<DocumentReference> getDocumentReferences() {
      return Arrays.<DocumentReference>asList(DocumentReferenceManager.getInstance().create(myFile));
    }

    @Nullable
    public JComponent getPreferredFocusedComponent() {
      throw new UnsupportedOperationException();
    }

    public <T> void putUserData(@NotNull Key<T> key, @Nullable T T) {
      throw new UnsupportedOperationException();
    }

    @NonNls
    @NotNull
    public String getName() {
      throw new UnsupportedOperationException();
    }

    @NotNull
    public FileEditorState getState(@NotNull FileEditorStateLevel level) {
      throw new UnsupportedOperationException();
    }

    public void setState(@NotNull FileEditorState state) {
      throw new UnsupportedOperationException();
    }

    public boolean isModified() {
      return false;
    }

    public boolean isValid() {
      return true;
    }

    public void selectNotify() {
      throw new UnsupportedOperationException();
    }

    public void deselectNotify() {
      throw new UnsupportedOperationException();
    }

    public void addPropertyChangeListener(@NotNull PropertyChangeListener listener) {
      throw new UnsupportedOperationException();
    }

    public void removePropertyChangeListener(@NotNull PropertyChangeListener listener) {
      throw new UnsupportedOperationException();
    }

    @Nullable
    public BackgroundEditorHighlighter getBackgroundHighlighter() {
      throw new UnsupportedOperationException();
    }

    @Nullable
    public FileEditorLocation getCurrentLocation() {
      throw new UnsupportedOperationException();
    }

    @Nullable
    public StructureViewBuilder getStructureViewBuilder() {
      throw new UnsupportedOperationException();
    }
  }
}
