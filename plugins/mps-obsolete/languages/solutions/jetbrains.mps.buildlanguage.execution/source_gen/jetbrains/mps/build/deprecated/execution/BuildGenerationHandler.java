package jetbrains.mps.build.deprecated.execution;

/*Generated by MPS */

import jetbrains.mps.generator.generationTypes.TextGenerationHandler;
import jetbrains.mps.textGen.TextGenerationResult;
import java.io.File;
import jetbrains.mps.util.FileUtil;

public class BuildGenerationHandler extends TextGenerationHandler {
  private final String myTargetDirectory;

  public BuildGenerationHandler(String targetDirectory) {
    myTargetDirectory = targetDirectory;
  }

  @Override
  protected void fileGenerated(String targetDir, String fileName, TextGenerationResult result) {
    File target = new File(myTargetDirectory + File.separator + fileName);
    new File(myTargetDirectory + File.separator).mkdirs();
    Object value = result.getResult();
    if (value instanceof String) {
      FileUtil.write(target, (String) value);
    } else {
      FileUtil.write(target, (byte[]) value);
    }
  }
}
