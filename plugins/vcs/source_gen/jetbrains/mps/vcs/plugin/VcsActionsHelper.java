package jetbrains.mps.vcs.plugin;

/*Generated by MPS */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.awt.Frame;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SNode;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import jetbrains.mps.ide.vfs.VirtualFileUtils;
import jetbrains.mps.smodel.descriptor.EditableSModelDescriptor;
import com.intellij.openapi.vcs.AbstractVcs;
import com.intellij.openapi.vcs.ProjectLevelVcsManager;
import com.intellij.openapi.vcs.history.VcsRevisionNumber;
import com.intellij.openapi.vcs.changes.ContentRevision;
import jetbrains.mps.smodel.persistence.def.ModelPersistence;
import jetbrains.mps.vcs.integration.ModelDiffTool;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.vcs.diff.ui.ModelDifferenceDialog;
import jetbrains.mps.smodel.SNodeId;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.vcs.diff.ui.SimpleDiffRequest;
import jetbrains.mps.vcs.diff.ui.OldRootDifferenceDialog;
import com.intellij.openapi.vcs.VcsException;
import com.intellij.openapi.ui.Messages;
import jetbrains.mps.smodel.persistence.def.ModelReadException;
import com.intellij.openapi.vcs.impl.VcsFileStatusProvider;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import java.util.Iterator;
import jetbrains.mps.baseLanguage.closures.runtime.YieldingIterator;
import jetbrains.mps.internal.collections.runtime.Sequence;
import com.intellij.openapi.vcs.FileStatus;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.project.IModule;
import jetbrains.mps.vfs.IFile;
import java.util.Collections;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.internal.collections.runtime.ITranslator2;

public class VcsActionsHelper {
  protected static Log log = LogFactory.getLog(VcsActionsHelper.class);

  public VcsActionsHelper() {
  }

  public static void showRootDifference(Frame frame, final IOperationContext context, final SModel model, final SNode node, final Project project) {
    try {
      VirtualFile file = VirtualFileUtils.getVirtualFile(((EditableSModelDescriptor) model.getModelDescriptor()).getModelFile());
      AbstractVcs vcs = ProjectLevelVcsManager.getInstance(project).getVcsFor(file);
      final VcsRevisionNumber revisionNumber = vcs.getDiffProvider().getCurrentRevision(file);
      ContentRevision content = vcs.getDiffProvider().createFileContent(revisionNumber, file);
      final SModel oldModel = ModelPersistence.readModel(content.getContent(), false);
      if (ModelDiffTool.isNewDiffEnabled()) {
        final Wrappers._T<ModelDifferenceDialog> modelDialog = new Wrappers._T<ModelDifferenceDialog>();
        final Wrappers._T<SNodeId> id = new Wrappers._T<SNodeId>();
        ModelAccess.instance().runReadAction(new Runnable() {
          public void run() {
            modelDialog.value = new ModelDifferenceDialog(oldModel, model, new SimpleDiffRequest(project, revisionNumber.asString() + " (Read-Only)", "Your Version"));
            id.value = node.getSNodeId();
          }
        });
        modelDialog.value.invokeRootDifference(id.value);

      } else {
        final OldRootDifferenceDialog dialog = new OldRootDifferenceDialog(frame, model, oldModel, true, true);
        ModelAccess.instance().runReadAction(new Runnable() {
          public void run() {
            dialog.init(context, node, "Your Version", revisionNumber.asString() + " (Read-Only)");
          }
        });
        dialog.showDialog();
      }
    } catch (VcsException e) {
      if (log.isWarnEnabled()) {
        log.warn("", e);
      }
      Messages.showErrorDialog(project, "Can't show difference due to the following error: " + e.getMessage(), "Error");
    } catch (ModelReadException e) {
      Messages.showErrorDialog(project, "Can't load previous version: " + e.getMessage(), "Error");
    }
  }

  private static Iterable<VirtualFile> collectUnversionedFiles(final VcsFileStatusProvider fileStatusProvider, final VirtualFile dir) {
    return new _FunctionTypes._return_P0_E0<Iterable<VirtualFile>>() {
      public Iterable<VirtualFile> invoke() {
        return new Iterable<VirtualFile>() {
          public Iterator<VirtualFile> iterator() {
            return new YieldingIterator<VirtualFile>() {
              private int __CP__ = 0;
              private VirtualFile _5_child;
              private Iterator<VirtualFile> _5_child_it;
              private VirtualFile _8__yield_deu5rm_a0b0a0a0b;
              private Iterator<VirtualFile> _8__yield_deu5rm_a0b0a0a0b_it;

              protected boolean moveToNext() {
__loop__:
                do {
__switch__:
                  switch (this.__CP__) {
                    case -1:
                      assert false : "Internal error";
                      return false;
                    case 4:
                      this._5_child_it = Sequence.fromIterable(Sequence.fromArray(dir.getChildren())).iterator();
                    case 6:
                      if (!(this._5_child_it.hasNext())) {
                        this.__CP__ = 1;
                        break;
                      }
                      this._5_child = this._5_child_it.next();
                      this.__CP__ = 7;
                      break;
                    case 8:
                      this._8__yield_deu5rm_a0b0a0a0b_it = Sequence.fromIterable(collectUnversionedFiles(fileStatusProvider, _5_child)).iterator();
                    case 9:
                      if (!(this._8__yield_deu5rm_a0b0a0a0b_it.hasNext())) {
                        this.__CP__ = 6;
                        break;
                      }
                      this._8__yield_deu5rm_a0b0a0a0b = this._8__yield_deu5rm_a0b0a0a0b_it.next();
                      this.__CP__ = 10;
                      break;
                    case 2:
                      if (fileStatusProvider.getFileStatus(dir) == FileStatus.UNKNOWN) {
                        this.__CP__ = 3;
                        break;
                      }
                      this.__CP__ = 4;
                      break;
                    case 5:
                      this.__CP__ = 4;
                      this.yield(dir);
                      return true;
                    case 11:
                      this.__CP__ = 9;
                      this.yield(_8__yield_deu5rm_a0b0a0a0b);
                      return true;
                    case 0:
                      this.__CP__ = 2;
                      break;
                    case 3:
                      this.__CP__ = 5;
                      break;
                    case 7:
                      this.__CP__ = 8;
                      break;
                    case 10:
                      this.__CP__ = 11;
                      break;
                    default:
                      break __loop__;
                  }
                } while (true);
                return false;
              }
            };
          }
        };
      }
    }.invoke();
  }

  public static Iterable<VirtualFile> getUnversionedFilesForModule(@NotNull Project project, @NotNull IModule module) {
    IFile descriptorFile = module.getDescriptorFile();
    if (descriptorFile == null) {
      return Sequence.fromIterable(Collections.<VirtualFile>emptyList());
    }
    IFile moduleDir = descriptorFile.getParent();
    VcsFileStatusProvider statusProvider = project.getComponent(VcsFileStatusProvider.class);
    return collectUnversionedFiles(statusProvider, VirtualFileUtils.getVirtualFile(moduleDir));
  }

  public static List<VirtualFile> getUnversionedFilesForModules(@NotNull final Project project, List<IModule> module) {
    return ListSequence.fromList(module).translate(new ITranslator2<IModule, VirtualFile>() {
      public Iterable<VirtualFile> translate(IModule m) {
        return getUnversionedFilesForModule(project, m);
      }
    }).toListSequence();
  }
}
