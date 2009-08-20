package jetbrains.mps.buildlanguage.plugin;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.plugin.BaseRunner;
import java.io.File;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import org.apache.commons.lang.StringUtils;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.baseLanguage.plugin.BaseOutputReader;
import jetbrains.mps.smodel.ModelAccess;
import java.io.IOException;
import jetbrains.mps.internal.collections.runtime.backports.LinkedList;
import com.intellij.openapi.application.PathManager;
import com.intellij.openapi.application.PathMacros;
import java.util.Set;
import jetbrains.mps.internal.collections.runtime.SetSequence;

public class BuildScriptRunner extends BaseRunner {
  private BuildScriptRunnerComponent myComponent;

  public BuildScriptRunner(BuildScriptRunnerComponent component) {
    this.myComponent = component;
  }


  public void run(File file, String commandLine) {
    this.myComponent.setRunnerActions(null);
    List<String> parameters = ListSequence.fromList(new ArrayList<String>());
    BuildScriptRunner.addBasicParameters(parameters, file);
    BuildScriptRunner.addMacroValues(parameters);
    if (commandLine != null && StringUtils.isNotEmpty(commandLine)) {
      List<String> commandLineList = Sequence.fromIterable(Sequence.fromArray(commandLine.split("\\s+"))).toListSequence();
      ListSequence.fromList(parameters).addSequence(ListSequence.fromList(commandLineList));
    }
    ProcessBuilder builder = new ProcessBuilder(ListSequence.fromListWithValues(new ArrayList<String>(), parameters));
    builder.directory(file.getParentFile());
    try {
      final Process process = builder.start();
      this.myComponent.setRunnerActions(new BuildScriptRunnerComponent.RunnerActions() {
        public void kill() {
          process.destroy();
        }

        public void pause() {
        }

        public void play() {
        }
      });
      BaseOutputReader input = new BaseOutputReader(process.getInputStream()) {
        protected void addMessage(final String message) {
          ModelAccess.instance().runReadInEDT(new Runnable() {
            public void run() {
              BuildScriptRunner.this.myComponent.addMessage(message);
            }
          });
        }
      };
      input.start();
      BaseOutputReader error = new BaseOutputReader(process.getErrorStream()) {
        protected void addMessage(final String message) {
          ModelAccess.instance().runReadInEDT(new Runnable() {
            public void run() {
              BuildScriptRunner.this.myComponent.addError(message);
            }
          });
        }
      };
      error.start();
    } catch (IOException exception) {
    }
  }

  public static List<String> getJavaHomes() {
    String systemJavaHome = System.getProperty("java.home");
    List<String> homes = ListSequence.fromListAndArray(new LinkedList<String>(), systemJavaHome);
    String systemJdkHome = systemJavaHome.substring(0, systemJavaHome.length() - "/jre".length());
    if (systemJavaHome.endsWith("jre") && new File(systemJdkHome + File.separator + "bin").exists()) {
      ListSequence.fromList(homes).addElement(systemJdkHome);
    }
    if (StringUtils.isNotEmpty(System.getenv("JAVA_HOME"))) {
      ListSequence.fromList(homes).addElement(System.getenv("JAVA_HOME"));
    }
    return homes;
  }

  public static String getJdkHome() {
    for (String javaHome : ListSequence.fromList(BuildScriptRunner.getJavaHomes())) {
      String javaBinHome = javaHome + File.separator + "bin" + File.separator;
      String osName = System.getProperty("os.name");
      if (osName.startsWith("Mac OS")) {
        if (new File(javaBinHome + "java").exists()) {
          return javaHome;
        }
      } else
      if (osName.startsWith("Windows")) {
        if (new File(javaBinHome + "java.exe").exists()) {
          return javaHome;
        }
      } else {
        if (new File(javaBinHome + "java").exists()) {
          return javaHome;
        }
      }
    }
    return ListSequence.fromList(BuildScriptRunner.getJavaHomes()).first();
  }

  public static String getJava() {
    String javaBinHome = BuildScriptRunner.getJdkHome() + File.separator + "bin" + File.separator;
    String osName = System.getProperty("os.name");
    if (osName.startsWith("Mac OS")) {
      return javaBinHome + "java";
    } else
    if (osName.startsWith("Windows")) {
      return javaBinHome + "java.exe";
    } else {
      return javaBinHome + "java";
    }
  }

  public static void addBasicParameters(List<String> parameters, File file) {
    ListSequence.fromList(parameters).addElement(BuildScriptRunner.getJava());
    String jdkHome = BuildScriptRunner.getJdkHome();
    ListSequence.fromList(parameters).addElement("-Djava.home=" + jdkHome);
    String antHome = PathManager.getHomePath() + File.separator + "lib" + File.separator + "ant-1.7.0";
    ListSequence.fromList(parameters).addElement("-Dant.home=" + antHome);
    ListSequence.fromList(parameters).addElement("-cp");
    String antLib = antHome + File.separator + "lib" + File.separator;
    String pathSeparator = System.getProperty("path.separator");
    String classpath = antLib + "ant-launcher.jar" + pathSeparator + antLib + "ant.jar" + pathSeparator + antLib + "ant-nodeps.jar";
    classpath += pathSeparator + jdkHome + File.separator + "lib" + File.separator + "tools.jar";
    ListSequence.fromList(parameters).addElement(classpath);
    ListSequence.fromList(parameters).addElement("org.apache.tools.ant.launch.Launcher");
    ListSequence.fromList(parameters).addElement("-f");
    ListSequence.fromList(parameters).addElement(file.getAbsolutePath());
  }

  public static void addMacroValues(List<String> parameters) {
    PathMacros pathMacros = PathMacros.getInstance();
    ListSequence.fromList(parameters).addElement("-D" + "mps_home" + "=" + jetbrains.mps.util.PathManager.getHomePath());
    Set<String> macroNames = pathMacros.getUserMacroNames();
    for (String macro : SetSequence.fromSet(macroNames)) {
      ListSequence.fromList(parameters).addElement("-D" + macro + "=" + pathMacros.getValue(macro));
    }
  }
}
