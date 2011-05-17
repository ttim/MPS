package jetbrains.mps.vcs.mergedriver;

/*Generated by MPS */

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import jetbrains.mps.util.ReadUtil;
import jetbrains.mps.util.FileUtil;
import java.io.FileOutputStream;
import java.io.IOException;

/*package*/ class SimpleMerger implements FileMerger {
  private static byte[] LINE_SEPARATOR = System.getProperty("line.separator").getBytes();

  public SimpleMerger() {
  }

  public int mergeFiles(File baseFile, File localFile, File latestFile, boolean overwrite, byte[] conflictStart, byte[] conflictEnd, byte[] separator) {
    FileInputStream baseIS = null;
    FileInputStream localIS = null;
    FileInputStream latestIS = null;
    OutputStream out = null;
    try {
      baseIS = new FileInputStream(baseFile);
      localIS = new FileInputStream(localFile);
      latestIS = new FileInputStream(latestFile);

      byte[] baseContent = ReadUtil.read(baseIS);
      FileUtil.closeFileSafe(baseIS);

      out = (overwrite ?
        new FileOutputStream(baseFile) :
        System.out
      );

      out.write(conflictStart);
      out.write(LINE_SEPARATOR);

      // current 
      out.write(ReadUtil.read(localIS));
      out.write(separator);
      out.write(LINE_SEPARATOR);

      // base 
      out.write(baseContent);
      out.write(separator);
      out.write(LINE_SEPARATOR);

      // other 
      out.write(ReadUtil.read(latestIS));
      out.write(conflictEnd);
      out.write(LINE_SEPARATOR);

      return CONFLICTS;
    } catch (IOException e) {
      return FATAL_ERROR;
    } finally {
      FileUtil.closeFileSafe(baseIS);
      FileUtil.closeFileSafe(localIS);
      FileUtil.closeFileSafe(latestIS);
      FileUtil.closeFileSafe(out);
    }
  }
}
