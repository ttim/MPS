package jetbrains.mps.vcs.mergedriver;

/*Generated by MPS */

import java.io.File;
import com.intellij.util.PathUtil;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import org.apache.commons.lang.StringUtils;
import jetbrains.mps.util.FileUtil;
import com.intellij.ide.plugins.IdeaPluginDescriptor;
import com.intellij.ide.plugins.PluginManager;
import com.intellij.openapi.extensions.PluginId;

public class MergeDriverMain {
  private static final String CONFLICT_START = "<<<<<<<";
  private static final String CONFLICT_END = ">>>>>>>";
  private static final String CONFLICT_SEPARATOR = "=======";

  private MergeDriverMain() {
  }

  public static void main(String[] args) {
    byte[] conflictStart = CONFLICT_START.getBytes();
    byte[] conflictEnd = CONFLICT_END.getBytes();
    byte[] conflictSeparator = CONFLICT_SEPARATOR.getBytes();
    if (args.length < 4) {
      System.err.println("Usage: " + getCommandLine() + " --<vcs> <base> <current> <other> " + "[<base name> <current name> <other name>]");
      System.exit(2);
    }

    File baseFile = new File(args[1]);
    File currentFile = new File(args[2]);
    File otherFile = new File(args[3]);
    boolean overwrite = false;
    FileMerger merger;
    if ("--svn".equals(args[0])) {
      if (args.length >= 7) {
        conflictStart = (CONFLICT_START + " " + args[5]).getBytes();
        conflictEnd = (CONFLICT_END + " " + args[6]).getBytes();
      }
      if (baseFile.getName().endsWith(".mps.svn-base")) {
        merger = new SimpleMerger();
      } else {
        merger = new TextMerger();
      }
    } else if ("--git".equals(args[0])) {
      overwrite = true;
      merger = new SimpleMerger();
    } else {
      System.exit(2);
      return;
    }
    System.exit(merger.mergeFiles(baseFile, currentFile, otherFile, overwrite, conflictStart, conflictEnd, conflictSeparator));
  }

  public static String getCommandLine() {
    StringBuilder cmd = new StringBuilder();
    cmd.append('\"').append(System.getProperty("java.home")).append(File.separator).append("bin").append(File.separator).append("java\"");
    cmd.append(" -cp ");
    cmd.append(PathUtil.getJarPathForClass(MergeDriverMain.class)).append(File.pathSeparator);
    cmd.append(PathUtil.getJarPathForClass(ListSequence.class)).append(File.pathSeparator);
    cmd.append(PathUtil.getJarPathForClass(_FunctionTypes.class)).append(File.pathSeparator);
    cmd.append(PathUtil.getJarPathForClass(StringUtils.class)).append(File.pathSeparator);
    cmd.append(PathUtil.getJarPathForClass(FileUtil.class)).append(File.pathSeparator);
    IdeaPluginDescriptor svnPlugin = PluginManager.getPlugin(PluginId.getId("Subversion"));
    // TODO 
    if (svnPlugin == null) {
      assert false;
      return null;
    }
    cmd.append(svnPlugin.getPath() + File.separator + "lib" + File.separator + "svnkit.jar");
    cmd.append(" ").append(MergeDriverMain.class.getName());
    return cmd.toString();
  }
}
