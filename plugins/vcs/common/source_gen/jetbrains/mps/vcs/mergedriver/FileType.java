package jetbrains.mps.vcs.mergedriver;

/*Generated by MPS */

import java.io.File;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import jetbrains.mps.util.FileUtil;
import java.io.IOException;

public enum FileType {
  MODEL(".mps", "model"),
  LANGUAGE(".mpl", "language"),
  SOLUTION(".msd", "solution"),
  DEVKIT(".devkit", "dev-kit"),
  PROJECT(".mpr", "project"),
  TRACE_CACHE("trace.info", "debugInfo"),
  GENERATOR_DEPENDENCIES("generated", "dependencies"),
  JAVA_DEPENDENCIES("dependencies", "dependenciesRoot");

  private static final String SVN_BASE = ".svn-base";

  private String mySuffix;
  private String myRootElement;

  FileType(String suffix, String rootElement) {
    mySuffix = suffix;
    myRootElement = rootElement;
  }

  public String getSuffix() {
    return mySuffix;
  }

  public static FileType get(File file) {
    final Wrappers._T<String> fileName = new Wrappers._T<String>(file.getName());
    if (fileName.value.endsWith(SVN_BASE)) {
      fileName.value = fileName.value.substring(0, fileName.value.length() - FileType.SVN_BASE.length());
      FileType type = Sequence.fromIterable(Sequence.fromArray(FileType.values())).findFirst(new IWhereFilter<FileType>() {
        public boolean accept(FileType t) {
          return fileName.value.endsWith(t.mySuffix);
        }
      });
      if (type != null) {
        return type;
      }
    }

    char[] buf = new char[100];
    Reader reader = null;
    try {
      reader = new InputStreamReader(new FileInputStream(file), FileUtil.DEFAULT_CHARSET);
      int read = reader.read(buf);
      if (read == -1) {
        return null;
      }
      final String str = new String(buf, 0, read);
      return Sequence.fromIterable(Sequence.fromArray(FileType.values())).findFirst(new IWhereFilter<FileType>() {
        public boolean accept(FileType t) {
          String tagBegin = "<" + t.myRootElement;
          return str.contains(tagBegin + ">") || str.contains(tagBegin + " ");
        }
      });
    } catch (IOException ioe) {
      return null;
    } finally {
      FileUtil.closeFileSafe(reader);
    }
  }
}
