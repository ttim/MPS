package jetbrains.mps.vcs.mergedriver;

/*Generated by MPS */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import jetbrains.mps.smodel.SModelFqName;
import java.io.File;
import jetbrains.mps.MPSCore;
import jetbrains.mps.smodel.persistence.RoleIdsComponent;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.persistence.def.ModelPersistence;
import jetbrains.mps.vfs.FileSystem;
import java.io.IOException;
import jetbrains.mps.vcs.diff.merge.MergeContext;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.vcs.diff.changes.ModelChange;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.smodel.ModelAccess;
import java.io.Writer;
import java.io.OutputStreamWriter;
import jetbrains.mps.util.FileUtil;
import jetbrains.mps.vcs.MergeBackupUtil;

/*package*/ class ModelMerger extends SimpleMerger {
  protected static Log log = LogFactory.getLog(ModelMerger.class);

  private SModelFqName myModelFqName;

  /*package*/ ModelMerger() {
  }

  @Override
  protected int mergeFiles(File baseFile, File localFile, File latestFile) {
    System.setProperty("mps.playRefactorings", "false");
    MPSCore.getInstance().setMergeDriverMode(true);
    try {
      MergerRoleIdsHandler roleIdsHandler = new MergerRoleIdsHandler();
      RoleIdsComponent.setHandler(roleIdsHandler);

      SModel baseModel;
      SModel localModel;
      SModel latestModel;
      try {
        if (log.isInfoEnabled()) {
          log.info("Reading models...");
        }
        baseModel = ModelPersistence.readModel(FileSystem.getInstance().getFileByPath(baseFile.getAbsolutePath()), false);
        if (baseModel == null) {
          throw new Exception("Could not read base model");
        }
        localModel = ModelPersistence.readModel(FileSystem.getInstance().getFileByPath(localFile.getAbsolutePath()), false);
        if (localModel == null) {
          throw new Exception("Could not read local model");
        }
        latestModel = ModelPersistence.readModel(FileSystem.getInstance().getFileByPath(latestFile.getAbsolutePath()), false);
        if (latestModel == null) {
          throw new Exception("Could not read latest model");
        }
      } catch (IOException e) {
        throw e;
      } catch (Throwable e) {
        if (log.isErrorEnabled()) {
          log.error("Exception while reading models", e);
        }
        return backupAndMergeSimply(baseFile, localFile, latestFile);
      }

      SModelFqName modelFqName = baseModel.getSModelFqName();
      int baseP = baseModel.getPersistenceVersion();
      int localP = localModel.getPersistenceVersion();
      int latestP = latestModel.getPersistenceVersion();
      if (baseP >= 7 && localP >= 7 && latestP >= 7 || baseP < 7 && localP < 7 && latestP < 7) {
        // ok, can merge 
      } else {
        if (log.isErrorEnabled()) {
          log.error(String.format("%s: Conflicting model persistence versions", modelFqName));
        }
        return backupAndMergeSimply(baseFile, localFile, latestFile);
      }
      if (!(roleIdsHandler.isConsistent())) {
        if (log.isErrorEnabled()) {
          log.error(String.format("%s: Inconsistent structure ids or import versions", modelFqName));
        }
        return backupAndMergeSimply(baseFile, localFile, latestFile);
      }

      try {
        if (log.isInfoEnabled()) {
          log.info("Merging " + baseModel.getSModelReference() + "...");
        }
        final MergeContext mergeContext = new MergeContext(baseModel, localModel, latestModel);
        int conflictingChangesCount = Sequence.fromIterable(mergeContext.getAllChanges()).where(new IWhereFilter<ModelChange>() {
          public boolean accept(ModelChange c) {
            return Sequence.fromIterable(mergeContext.getConflictedWith(c)).isNotEmpty();
          }
        }).count();
        if (conflictingChangesCount == 0) {
          if (log.isInfoEnabled()) {
            log.info(String.format("%s: %d changes detected: %d local and %d latest.", modelFqName, Sequence.fromIterable(mergeContext.getAllChanges()).count(), ListSequence.fromList(mergeContext.getMyChangeSet().getModelChanges()).count(), ListSequence.fromList(mergeContext.getRepositoryChangeSet().getModelChanges()).count()));
          }
          Runnable applyAction = new Runnable() {
            public void run() {
              mergeContext.applyChanges(mergeContext.getAllChanges());
            }
          };
          ModelAccess.instance().runReadAction(applyAction);
          if (mergeContext.hasIdsToRestore()) {
            if (log.isInfoEnabled()) {
              log.info(String.format("%s: node id duplication detected, should merge in UI.", modelFqName));
            }
          } else {
            String resultString = ModelPersistence.modelToString(mergeContext.getResultModel());
            if (log.isInfoEnabled()) {
              log.info(String.format("%s: merged successfully.", modelFqName));
            }
            Writer out = null;
            try {
              out = new OutputStreamWriter(getResultStream(localFile), FileUtil.DEFAULT_CHARSET);
              out.write(resultString);
              backup(baseFile, localFile, latestFile);
              return MERGED;
            } catch (IOException e) {
              e.printStackTrace();
              return FATAL_ERROR;
            } finally {
              FileUtil.closeFileSafe(out);
            }
          }
        } else {
          if (log.isInfoEnabled()) {
            log.info(String.format("%s: %d changes detected, %d of them are conflicting", modelFqName, Sequence.fromIterable(mergeContext.getAllChanges()).count(), conflictingChangesCount));
          }
        }
      } catch (Throwable e) {
        if (log.isErrorEnabled()) {
          log.error("Exception while merging", e);
        }
        return backupAndMergeSimply(baseFile, localFile, latestFile);
      }

      return backupAndMergeSimply(baseFile, localFile, latestFile);
    } catch (IOException e) {
      e.printStackTrace();
      return FATAL_ERROR;
    }
  }

  private int backupAndMergeSimply(File baseFile, File localFile, File latestFile) throws IOException {
    backup(baseFile, localFile, latestFile);
    return super.mergeFiles(baseFile, localFile, latestFile);
  }

  private void backup(File baseFile, File localFile, File latestFile) throws IOException {
    File zipModel = MergeBackupUtil.zipModel(new String[]{FileUtil.read(baseFile), FileUtil.read(localFile), FileUtil.read(latestFile)}, myModelFqName);
    if (zipModel != null) {
      if (log.isInfoEnabled()) {
        log.info("Saved merge backup to " + zipModel);
      }
    }
  }
}
