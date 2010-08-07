/*
 * Copyright 2003-2010 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jetbrains.mps.smodel;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.application.ModalityState;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.refactoring.PlayRefactoringsFlag;
import jetbrains.mps.refactoring.framework.ILoggableRefactoring;
import jetbrains.mps.refactoring.framework.IRefactoring;
import jetbrains.mps.refactoring.framework.RefactoringContext;
import jetbrains.mps.refactoring.framework.RefactoringHistory;
import jetbrains.mps.smodel.descriptor.RegularSModelDescriptor;
import jetbrains.mps.smodel.event.EventUtil;
import jetbrains.mps.smodel.event.SModelCommandListener;
import jetbrains.mps.smodel.event.SModelEvent;
import jetbrains.mps.smodel.persistence.IModelRootManager;
import jetbrains.mps.smodel.persistence.def.ModelPersistence;
import jetbrains.mps.vcs.VcsHelper;
import jetbrains.mps.vfs.IFile;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class DefaultSModelDescriptor extends BaseSModelDescriptor implements RegularSModelDescriptor {
  private static final String VERSION = "version";
  private static final String NAME_VERSION = "nameVersion";

  private static final Logger LOG = Logger.getLogger(DefaultSModelDescriptor.class);

  private SModel mySModel = null;

  private Map<String, String> myMetadata;
  private boolean myMetadataLoaded;

  private Object myRefactoringHistoryLock = new Object();
  private RefactoringHistory myRefactoringHistory;

  private final Object myLoadingLock = new Object();

  private long myLastChange;

  private long myDiskTimestamp = -1;
  private boolean myIsTestRefactoringMode = false;

  public DefaultSModelDescriptor(IModelRootManager manager, IFile modelFile, SModelReference modelReference) {
    this(manager, modelFile, modelReference, true);
  }

  protected DefaultSModelDescriptor(IModelRootManager manager, IFile modelFile, SModelReference modelReference, boolean checkDup) {
    super(manager, modelFile, modelReference, checkDup);
    updateLastChange();
  }

  {
    this.addModelCommandListener(new SModelCommandListener() {
      public void eventsHappenedInCommand(List<SModelEvent> events) {
        if (EventUtil.isChange(events)) {
          myLastChange = System.currentTimeMillis();
        }
      }
    });
  }

  protected SModel loadModel() {
    SModel result = myModelRootManager.loadModel(this);
    updateModelWithRefactorings(result);

    myRefactoringHistory = null;
    tryFixingVersion();
    updateDiskTimestamp();
    return result;
  }

  public void reloadFromDiskSafe() {
    if (SModelRepository.getInstance().isChanged(this)) {
      ApplicationManager.getApplication().invokeLater(new Runnable() {
        public void run() {
          final boolean needSave = VcsHelper.resolveDiskMemoryConflict(myModelFile, mySModel);
          if (needSave) {
            ModelAccess.instance().runWriteActionInCommand(new Runnable() {
              public void run() {
                updateDiskTimestamp();
                save();
              }
            });
          } else {
            ModelAccess.instance().runWriteAction(new Runnable() {
              public void run() {
                reloadFromDisk();
              }
            });
          }
        }
      }, ModalityState.NON_MODAL);
    } else {
      reloadFromDisk();
    }
  }

  /**
   * This method should be called either in EDT, inside WriteAction or in any other thread
   */
  public void reloadFromDisk() {
    ModelAccess.assertLegalWrite();
    if (!isInitialized()) {
      return;
    }
    SModel newModel = loadModel();
    replaceModel(newModel);
    updateLastChange();
  }

  public boolean isReadOnly() {
    return false;
  }

  public long fileTimestamp() {
    IFile file = getModelFile();
    if (file == null || !file.exists()) return -1;
    return file.lastModified();
  }

  public SModel getSModel() {
    // ModelAccess.assertLegalRead();

    SModel result;
    boolean fireInitialized = false;

    synchronized (myLoadingLock) {
      if (mySModel == null) {
        SModel model = loadModel();
        model.setModelDescritor(this);
        mySModel = model;
        fireInitialized = true;
      }
      result = mySModel;
    }
    if (fireInitialized) {
      fireModelInitialized();
    }
    return result;
  }

  public int getPersistenceVersion() {
    SModel model = mySModel; // do not use getSModel() to avoid lock
    if (model != null) {
      return model.getPersistenceVersion();
    }
    return ModelPersistence.getModelPersistenceVersion(getModelFile());
  }

  @Override
  @NotNull
  public RefactoringHistory getRefactoringHistory() {
    synchronized (myRefactoringHistoryLock) {
      if (myRefactoringHistory == null) {
        SModel model = mySModel;
        if (model != null && model.getPersistenceVersion() >= 0 && model.getPersistenceVersion() < 5) {
          //noinspection deprecation
          myRefactoringHistory = model.getRefactoringHistory();
        }
        if (myRefactoringHistory == null) {
          myRefactoringHistory = myModelRootManager.loadModelRefactorings(this);
        }
        if (myRefactoringHistory == null) {
          myRefactoringHistory = new RefactoringHistory();
        }
      }
    }
    return myRefactoringHistory;
  }

  @Override
  public void saveRefactoringHistory() {
    RefactoringHistory toSave = myRefactoringHistory;
    if (toSave != null) {
      myModelRootManager.saveModelRefactorings(this, toSave);
    }
  }

  private void updateModelWithRefactorings(SModel model) {
    assert model != null;
    if (!PlayRefactoringsFlag.refactoringsPlaybackEnabled()) {
      return;
    }
    if (!SModelStereotype.isUserModel(model)) {
      return;
    }
    boolean wasLoading = model.setLoading(true);
    try {
      boolean played;
      do {
        played = false;
        for (SModelDescriptor usedModelDescriptor : model.getDependenciesModels()) {
          if (!(usedModelDescriptor instanceof DefaultSModelDescriptor)) continue;
          if (playUsedModelDescriptorsRefactoring(model, (DefaultSModelDescriptor) usedModelDescriptor)) {
            played = true;
          }
        }
      } while (played);
    } finally {
      model.setLoading(wasLoading);
    }
  }

  public void setTestRefactoringMode(boolean isTestRefactoringMode) {
    myIsTestRefactoringMode = isTestRefactoringMode;
  }

  private void tryFixingVersion() {
    if (getVersion() != -1) return;

    int maxVersion = -1;
    for (RefactoringContext context : getRefactoringHistory().getRefactoringContexts()) {
      maxVersion = Math.max(maxVersion, context.getModelVersion());
    }

    if (maxVersion != -1) {
      setVersion(maxVersion);
      LOG.error("Metadata file for model " + getSModelFqName() + " wasn't present. Recreated a new one.");
    }
  }

  //true if any refactoring was played

  private boolean playUsedModelDescriptorsRefactoring(SModel model, DefaultSModelDescriptor usedModelDescriptor) {
    int currentVersion = usedModelDescriptor.getVersion();
    int usedVersion = model.getUsedVersion(usedModelDescriptor.getSModelReference());
    if (myIsTestRefactoringMode) {
      System.err.println(this + ": current version of used model " + usedModelDescriptor.getLongName() + " is " + currentVersion + ", used version is " + usedVersion);
    }

    if (currentVersion > usedVersion) {
      boolean result = false;
      if (myIsTestRefactoringMode) {
        System.err.println("updating a model " + this);
      }
      RefactoringHistory refactoringHistory = usedModelDescriptor.getRefactoringHistory();
      for (RefactoringContext refactoringContext : refactoringHistory.getRefactoringContexts()) {
        if (refactoringContext.getModelVersion() <= usedVersion) continue;
        result = true;


        IRefactoring refactoring = refactoringContext.getRefactoring();
        if (!(refactoring instanceof ILoggableRefactoring)) {
          LOG.error("Non-loggable refactoring was logged: " + refactoring.getClass().getName());
        } else {
          try {
            ((ILoggableRefactoring) refactoring).updateModel(model, refactoringContext);
          } catch (Throwable t) {
            LOG.error("An exception was thrown by refactoring " + refactoring.getUserFriendlyName() + " while updating model " + model.getLongName() + ". Models could have been corrupted.");
          }
        }
      }
      model.updateImportedModelUsedVersion(usedModelDescriptor.getSModelReference(), currentVersion);
      IFile modelFile = getModelFile();
      if (modelFile != null && !modelFile.isReadOnly()) {
        SModelRepository.getInstance().markChanged(this, true);
      }
      return result;
    }

    // broken model fixing code
    if (currentVersion < usedVersion) {

      //user might have forgotten to commit .metadata file
      if (currentVersion == -1) {
        if (usedModelDescriptor instanceof DefaultSModelDescriptor) {
          usedModelDescriptor.getSModel();
        }

        if (usedModelDescriptor.getVersion() == usedVersion) return false;
      }

      LOG.error("Model version mismatch for import " + usedModelDescriptor.getSModelFqName() + " in model " + getSModelFqName());
      LOG.error("Used version = " + usedVersion + ", current version = " + currentVersion);
      model.updateImportedModelUsedVersion(usedModelDescriptor.getSModelReference(), currentVersion);
      SModelRepository.getInstance().markChanged(this, true);
      LOG.error("Mismatch fixed");
    }

    return false;
  }

  public long lastChangeTime() {
    return myLastChange;
  }

  public void save() {
    ModelAccess.assertLegalWrite();

    if (mySModel == null) return;

    if (!ApplicationManager.getApplication().isDispatchThread()) {
      /*
      * This was added because of the line VFileSystem.refreshFileSynchronously(modelFile) few lines later.
      * Calling save not from EDT may cause this sequence of events:
      *
      * VirtualFile.refresh calls Semaphore.down and since we are not in EDT
      * call Semaphore.waitFor inside of invokeLater.
      *
      * At the same time somebody calls runReadAction in EDT and
      * since method save works only in writeAction, this somebody has to wait.
      * So we have EDT blocked and Semaphore.waitFor can not be called. Deadlock.
      * */
      IllegalStateException exception = new IllegalStateException("DefaultSModelDescriptor.Save should only be called from EDT.");
      exception.printStackTrace();
      throw exception;
    }

    //we must be in command since model save might change model by adding model/language imports
    if (!mySModel.isLoading()) LOG.assertInCommand();

    LOG.info("Saving model " + mySModel.getSModelFqName());

    if (needsReloading()) {
      LOG.warning("Model file " + mySModel.getSModelFqName() + " was modified externally!\n" +
        "You might want to turn \"Synchronize files on frame activation/deactivation\" option on to avoid conflicts.");
      ApplicationManager.getApplication().invokeLater(new Runnable() {
        public void run() {
          final boolean needSave = VcsHelper.resolveDiskMemoryConflict(myModelFile, mySModel);
          if (needSave) {
            ModelAccess.instance().runWriteActionInCommand(new Runnable() {
              public void run() {
                updateDiskTimestamp();
                save();
              }
            });
          } else {
            ModelAccess.instance().runWriteAction(new Runnable() {
              public void run() {
                reloadFromDisk();
              }
            });
          }
        }
      }, ModalityState.NON_MODAL);
      return;
    }

    // Paranoid check to avoid saving model during update (hack for MPS-6772)
    if (needsReloading()) return;
    
    SModelRepository.getInstance().markUnchanged(mySModel);
    SModel newData = myModelRootManager.saveModel(this, true);
    if (newData != null) {
      replaceModel(newData);
    }

    updateDiskTimestamp();

    IFile modelFile = getModelFile();
    if (modelFile != null && !modelFile.isReadOnly()) {
      MPSFileSynchronizer.getInstance().requestSync(modelFile);
    }

    fireModelSaved();
  }

  public boolean needsReloading() {
    if (myDiskTimestamp == -1) return false;
    return fileTimestamp() != myDiskTimestamp;
  }

  public boolean isInitialized() {
    return mySModel != null;
  }

  public void refresh() {
    ModelAccess.assertLegalWrite();

    if (!isInitialized()) return;
    replaceModel(myModelRootManager.refresh(this));
  }

  public void replaceModel(SModel newModel) {
    ModelAccess.assertLegalWrite();
    if (newModel == mySModel) return;
    final SModel oldSModel = mySModel;
    if (oldSModel != null) {
      oldSModel.setModelDescritor(null);
    }
    mySModel = newModel;
    myRefactoringHistory = null;
    if (mySModel != null) {
      mySModel.setModelDescritor(this);
    }
    SModelRepository.getInstance().markChanged(this, true);
    MPSModuleRepository.getInstance().invalidateCaches();
    Runnable modelReplacedNotifier = new Runnable() {
      @Override
      public void run() {
        fireModelReplaced();
        if (oldSModel != null) {
          oldSModel.dispose();
        }
      }
    };
    if (ModelAccess.instance().isInEDT()) {
      modelReplacedNotifier.run();
    } else {
      ModelAccess.instance().runReadInEDT(modelReplacedNotifier);
    }
  }

  public void dispose() {
    UnregisteredNodes.instance().clear(getSModelReference());

    if (mySModel != null) {
      fireBeforeModelDisposed(mySModel);
      mySModel.dispose();
    }
    super.dispose();
  }

  public String toString() {
    return getSModelReference().toString();
  }

  public boolean isTransient() {
    return false;
  }

  private synchronized Map<String, String> getMetaData_internal() {
    if (myMetadataLoaded) {
      return myMetadata;
    }
    myMetadata = myModelRootManager.loadMetadata(this);
    myMetadataLoaded = true;
    return myMetadata;
  }

  public String getAttribute(String key) {
    if (getMetaData_internal() == null) {
      return null;
    }
    return getMetaData_internal().get(key);
  }

  public void setAttribute(String key, String value) {
    ModelAccess.assertLegalWrite();

    if (getMetaData_internal() == null) {
      throw new UnsupportedOperationException();
    }

    if (value == null) {
      getMetaData_internal().remove(key);
    } else {
      getMetaData_internal().put(key, value);
    }

    myModelRootManager.saveMetadata(this);
  }

  public Map<String, String> getMetaData() {
    if (getMetaData_internal() == null) {
      return null;
    }
    return Collections.unmodifiableMap(getMetaData_internal());
  }

  public int getVersion() {
    String attributeValue = getAttribute(VERSION);
    if (attributeValue == null) {
      return -1;
    }
    try {
      return Integer.parseInt(attributeValue);
    } catch (NumberFormatException e) {
      return -1;
    }
  }

  public int getNameVersion() {
    try {
      return Integer.parseInt(getAttribute(NAME_VERSION));
    } catch (NumberFormatException e) {
      return -1;
    }
  }

  public void setVersion(int newVersion) {
    System.err.println("setting version for model " + this + ": " + newVersion);
    setAttribute(VERSION, "" + newVersion);
  }

  public void setNameVersion(int newNameVersion) {
    setAttribute(VERSION, "" + newNameVersion);
  }

  /*package*/

  void changeSModelUID(SModelReference newModelReference) {
    myModelReference = newModelReference;
    getSModel().changeModelReference(newModelReference);
  }

  /*package*/
  public void setModelFile(IFile file) {
    myModelFile = file;
  }

  @Override
  protected void updateDiskTimestamp() {
    myDiskTimestamp = fileTimestamp();
  }

  private void updateLastChange() {
    if (myModelFile != null) {
      myLastChange = myModelFile.lastModified();
    } else {
      myLastChange = System.currentTimeMillis();
    }
  }
}
