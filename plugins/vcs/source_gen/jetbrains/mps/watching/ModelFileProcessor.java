package jetbrains.mps.watching;

/*Generated by MPS */

import jetbrains.mps.logging.Logger;
import com.intellij.openapi.vfs.newvfs.events.VFileEvent;
import jetbrains.mps.ide.vfs.VirtualFileUtils;
import jetbrains.mps.smodel.descriptor.source.ReloadableSources;
import jetbrains.mps.vfs.FileSystem;
import com.intellij.openapi.vfs.newvfs.events.VFileMoveEvent;
import java.io.File;
import jetbrains.mps.vfs.IFile;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.SModelRepository;
import com.intellij.openapi.vfs.VirtualFile;
import jetbrains.mps.smodel.descriptor.EditableSModelDescriptor;
import jetbrains.mps.project.IModule;

/*package*/ class ModelFileProcessor extends EventProcessor {
  private static final Logger LOG = Logger.getLogger(ModelFileProcessor.class);
  private static final ModelFileProcessor INSTANCE = new ModelFileProcessor();

  /*package*/ ModelFileProcessor() {
  }

  @Override
  protected void processContentChanged(VFileEvent event, ReloadSession reloadSession) {
    if (!(VirtualFileUtils.isEventFromSave(event))) {
      ReloadableSources.getInstance().invalidate(FileSystem.getInstance().getFileByPath(event.getPath()));
    }
  }

  @Override
  protected void processCopy(VFileEvent event, ReloadSession reloadSession) {
    processCreate(event, reloadSession);
  }

  @Override
  protected void processMove(VFileEvent event, ReloadSession reloadSession) {
    processCreate(event, reloadSession);
    VFileMoveEvent moveEvent = (VFileMoveEvent) event;
    String oldPath = moveEvent.getOldParent().getPath() + File.separator + moveEvent.getFile().getName();
    fileDeleted(oldPath, reloadSession);
  }

  @Override
  protected void processCreate(VFileEvent event, ReloadSession reloadSession) {
    ReloadableSources.getInstance().invalidate(FileSystem.getInstance().getFileByPath(event.getPath()));
    IFile ifile = FileSystem.getInstance().getFileByPath(event.getPath());
    SModelDescriptor model = SModelRepository.getInstance().findModel(ifile);
    if (model == null) {
      VirtualFile vfile = refreshAndGetVFile(event);
      if (vfile == null) {
        return;
      }
      reloadSession.addNewModelFile(vfile);
    }
  }

  private void fileDeleted(String path, ReloadSession reloadSession) {
    ReloadableSources.getInstance().invalidate(FileSystem.getInstance().getFileByPath(path));
    IFile ifile = FileSystem.getInstance().getFileByPath(path);
    final EditableSModelDescriptor model = SModelRepository.getInstance().findModel(ifile);
    if (model == null) {
      return;
    }
    IModule module = model.getModule();
    if (module == null) {
      return;
    }
    reloadSession.addChangedModule(module);
  }

  public static ModelFileProcessor getInstance() {
    return INSTANCE;
  }
}
