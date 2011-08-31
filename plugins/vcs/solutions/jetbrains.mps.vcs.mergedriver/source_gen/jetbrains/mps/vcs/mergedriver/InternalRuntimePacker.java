package jetbrains.mps.vcs.mergedriver;

/*Generated by MPS */

import com.intellij.openapi.application.PathManager;
import java.io.File;
import jetbrains.mps.util.FileUtil;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import jetbrains.mps.InternalFlag;

public class InternalRuntimePacker {
  private static final String MERGER_RT = "merger-rt.jar";
  private static boolean ourUpToDate = false;

  private InternalRuntimePacker() {
  }

  public static String getPath() {
    return PathManager.getConfigPath() + File.separator + MERGER_RT;
  }

  private static File getFile() {
    return new File(getPath());
  }

  private static void pack() {
    File tmpDir = FileUtil.createTmpDir();
    getFile().delete();
    for (String cpi : SetSequence.<String>fromSet(CommandLineGenerator.getClasspath(false))) {
      if (!(cpi.endsWith(".jar"))) {
        FileUtil.copyDir(new File(cpi), tmpDir);
      }
    }
    FileUtil.zip(tmpDir, getFile());
    tmpDir.delete();
  }

  public static AbstractInstaller.State packIfNeeded(boolean dryRun) {
    if (InternalFlag.isInternalMode() && !(ourUpToDate)) {
      if (dryRun) {
        if (getFile().exists()) {
          return AbstractInstaller.State.OUTDATED;
        } else {
          return AbstractInstaller.State.NOT_INSTALLED;
        }
      } else {
        pack();
        ourUpToDate = true;
        return AbstractInstaller.State.INSTALLED;
      }
    } else {
      return AbstractInstaller.State.INSTALLED;
    }
  }
}
