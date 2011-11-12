package jetbrains.mps.vcs.integration;

/*Generated by MPS */

import com.intellij.openapi.diff.DiffTool;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.intellij.openapi.diff.DiffRequest;
import com.intellij.openapi.diff.DiffContent;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.persistence.def.ModelReadException;
import com.intellij.openapi.diff.DiffManager;
import jetbrains.mps.vcs.diff.ui.ModelDifferenceDialog;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.fileTypes.FileType;
import jetbrains.mps.fileTypes.MPSFileTypeFactory;
import com.intellij.openapi.diff.DocumentContent;
import com.intellij.openapi.diff.FileContent;
import jetbrains.mps.smodel.SModelRepository;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.ide.vfs.VirtualFileUtils;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.util.Computable;
import jetbrains.mps.smodel.persistence.def.ModelPersistence;
import jetbrains.mps.util.FileUtil;
import java.io.IOException;

public class ModelDiffTool implements DiffTool {
  protected static Log log = LogFactory.getLog(ModelDiffTool.class);

  public ModelDiffTool() {
  }

  public void show(final DiffRequest request) {
    DiffContent[] contents = request.getContents();
    final SModel oldModel;
    final SModel newModel;
    try {
      oldModel = readModel(contents[0]);
      newModel = readModel(contents[1]);
    } catch (ModelReadException e) {
      if (log.isErrorEnabled()) {
        log.error("Can't read models", e);
      }
      DiffManager.getInstance().getIdeaDiffTool().show(request);
      return;
    }
    new ModelDifferenceDialog(oldModel, newModel, request).showDialog();
  }

  public boolean canShow(DiffRequest request) {
    DiffContent[] contents = request.getContents();
    return contents.length == 2 && isModelFile(contents[0]) && isModelFile(contents[1]);
  }

  private boolean isModelFile(@NotNull DiffContent contents) {
    FileType type = contents.getContentType();
    if (type == null) {
      return true;
    }
    return type.equals(MPSFileTypeFactory.MODEL_FILE_TYPE);
  }

  private static SModel readModel(DiffContent content) throws ModelReadException {
    if (content instanceof DocumentContent || content instanceof FileContent) {
      SModelRepository modelRepository = SModelRepository.getInstance();
      final SModelDescriptor modelDescriptor = modelRepository.findModel(VirtualFileUtils.toIFile(content.getFile()));
      if (modelDescriptor != null) {
        return ModelAccess.instance().runReadAction(new Computable<SModel>() {
          public SModel compute() {
            return modelDescriptor.getSModel();
          }
        });
      }
    }
    try {
      return ModelPersistence.readModel(new String(content.getBytes(), FileUtil.DEFAULT_CHARSET), false);
    } catch (IOException ioe) {
      throw new ModelReadException("Couldn't read content: " + ioe.getMessage(), ioe);
    }
  }
}
