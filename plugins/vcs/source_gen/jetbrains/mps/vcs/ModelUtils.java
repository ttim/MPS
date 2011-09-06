package jetbrains.mps.vcs;

/*Generated by MPS */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import org.jdom.Document;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.smodel.persistence.def.ModelPersistence;
import java.io.ByteArrayOutputStream;
import jetbrains.mps.util.JDOMUtil;
import java.io.IOException;
import com.intellij.openapi.vfs.VirtualFile;
import java.io.OutputStream;
import jetbrains.mps.smodel.descriptor.EditableSModelDescriptor;
import jetbrains.mps.smodel.SModelRepository;
import jetbrains.mps.ide.vfs.VirtualFileUtils;
import java.io.File;
import jetbrains.mps.util.FileUtil;
import jetbrains.mps.util.UnzipUtil;
import java.io.FilenameFilter;
import jetbrains.mps.project.MPSExtentions;
import java.io.FileInputStream;
import org.xml.sax.InputSource;
import java.io.ByteArrayInputStream;
import java.io.StringReader;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.smodel.persistence.def.DescriptorLoadResult;
import jetbrains.mps.smodel.ModelLoadingState;
import jetbrains.mps.vcs.integration.ModelDiffTool;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.ISelector;

public class ModelUtils {
  protected static Log log = LogFactory.getLog(ModelUtils.class);

  public ModelUtils() {
  }

  public static byte[] modelToBytes(final SModel result) {
    final Wrappers._T<Document> document = new Wrappers._T<Document>();
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        document.value = ModelPersistence.saveModel(result);
      }
    });
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    try {
      JDOMUtil.writeDocument(document.value, baos);
      return baos.toByteArray();
    } catch (IOException e) {
      if (log.isErrorEnabled()) {
        log.error("", e);
      }
    }
    return new byte[0];
  }

  public static void replaceWithNewModelFromBytes(final VirtualFile modelFile, final byte[] bytesToReplaceWith) {
    ModelAccess.instance().runWriteAction(new Runnable() {
      public void run() {
        OutputStream outputStream = null;
        try {
          outputStream = modelFile.getOutputStream(this);
          outputStream.write(bytesToReplaceWith);
        } catch (IOException e) {
          if (log.isErrorEnabled()) {
            log.error("", e);
          }
        } finally {
          if (outputStream != null) {
            try {
              outputStream.close();
            } catch (IOException e) {
            }
          }
        }
        ModelUtils.replaceModelWithBytes(modelFile, bytesToReplaceWith);
        modelFile.refresh(true, false);
      }
    });
  }

  private static void replaceModelWithBytes(VirtualFile modelFile, byte[] bytesToReplaceWith) {
    final EditableSModelDescriptor modelDescriptor = SModelRepository.getInstance().findModel(VirtualFileUtils.toIFile(modelFile));
    if (modelDescriptor == null) {
      return;
    }
    try {
      SModel model = ModelUtils.readModel(bytesToReplaceWith, modelFile.getPath());
      modelDescriptor.replaceModel(model);
    } catch (IOException e) {
      if (log.isErrorEnabled()) {
        log.error("", e);
      }
    }
  }

  public static SModel[] loadZippedModels(File zipfile, Version[] versions) throws IOException {
    File tmpdir = FileUtil.createTmpDir();
    UnzipUtil.unzip(zipfile, tmpdir);
    SModel[] models = new SModel[versions.length];
    int index = 0;
    for (final Version v : versions) {
      File file;
      File[] files = tmpdir.listFiles(new FilenameFilter() {
        public boolean accept(File dir, String name) {
          return name.endsWith(MPSExtentions.DOT_MODEL + "." + v.getSuffix());
        }
      });
      if (files == null || files.length != 1) {
        if (log.isErrorEnabled()) {
          log.error("Wrong zip contents");
        }
      }
      file = files[0];
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      FileInputStream fis = new FileInputStream(file);
      while (true) {
        int i = fis.read();
        if (i == -1) {
          break;
        }
        baos.write(i);
      }
      models[index] = ModelUtils.readModel(baos.toByteArray(), file.getAbsolutePath());
      index++;
    }
    FileUtil.delete(tmpdir);
    return models;
  }

  public static SModel readModel(final byte[] bytes, String path) throws IOException {
    return ModelUtils.readModel((bytes.length == 0 ?
      null :
      new ModelUtils.InputSourceFactory() {
        public InputSource create() throws IOException {
          return new InputSource(new ByteArrayInputStream(bytes));
        }
      }
    ), path);
  }

  public static SModel readModel(final String content, String path) throws IOException {
    return ModelUtils.readModel((content.isEmpty() ?
      null :
      new ModelUtils.InputSourceFactory() {
        public InputSource create() throws IOException {
          return new InputSource(new StringReader(content));
        }
      }
    ), path);
  }

  public static SModel readModel(final String path) throws IOException {
    final FileInputStream stream = new FileInputStream(path);
    try {
      return ModelUtils.readModel(new ModelUtils.InputSourceFactory() {
        public InputSource create() throws IOException {
          return new InputSource(stream);
        }
      }, path);
    } finally {
      stream.close();
    }
  }

  public static SModel readModel(final File file) throws IOException {
    final FileInputStream stream = new FileInputStream(file);
    try {
      return ModelUtils.readModel(new ModelUtils.InputSourceFactory() {
        public InputSource create() throws IOException {
          return new InputSource(stream);
        }
      }, file.getAbsolutePath());
    } finally {
      stream.close();
    }
  }

  private static SModel readModel(final ModelUtils.InputSourceFactory inputSourceFactory, String path) throws IOException {
    try {
      if (inputSourceFactory == null) {
        return new SModel(SModelReference.fromPath(path));
      }
      final IOException[] ex = new IOException[1];
      final SModel[] model = new SModel[1];
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          try {
            DescriptorLoadResult loadResult = ModelPersistence.loadDescriptor(inputSourceFactory.create());
            model[0] = ModelPersistence.readModel(loadResult.getHeader(), inputSourceFactory.create(), ModelLoadingState.FULLY_LOADED).getModel();
          } catch (IOException e) {
            ex[0] = e;
          }
        }
      });
      if (model[0] == null) {
        throw ex[0];
      } else {
        return model[0];
      }
    } catch (Exception t) {
      throw new ModelDiffTool.ReadException(t);
    }
  }

  public static Iterable<File> findZipFilesForModelFile(final String modelFileName) {
    File[] files = new File(VcsHelperUtil.getMergeBackupDirPath()).listFiles(new FilenameFilter() {
      public boolean accept(File dir, String name) {
        return name.contains(modelFileName) && modelFileName.endsWith(".zip");
      }
    });
    return Sequence.fromIterable(Sequence.fromArray(files)).sort(new ISelector<File, Comparable<?>>() {
      public Comparable<?> select(File f) {
        return f.getName();
      }
    }, false);
  }

  private static interface InputSourceFactory {
    public InputSource create() throws IOException;
  }
}
